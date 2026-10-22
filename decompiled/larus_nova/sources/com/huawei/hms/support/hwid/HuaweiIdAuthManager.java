package com.huawei.hms.support.hwid;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.hwid.ap;
import com.huawei.hms.hwid.as;
import com.huawei.hms.hwid.x;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hwid.common.HuaweiIdAuthException;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthExtendedParams;
import com.huawei.hms.support.hwid.request.HuaweiIdAuthParams;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.huawei.hms.support.hwid.result.HuaweiIdAuthResult;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthService;
import com.huawei.hms.support.hwid.service.HuaweiIdAuthServiceImpl;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final class HuaweiIdAuthManager {
    public HuaweiIdAuthManager() {
    }

    public static AuthHuaweiId getAuthResult() {
        return x.b();
    }

    public static AuthHuaweiId getAuthResultWithScopes(List<Scope> r100) throws HuaweiIdAuthException {
        if (ap.a(r100).booleanValue() == true) goto L10;
        AuthHuaweiId r101 = x.b();
        if (r101 != null) goto L7;
        r101 = new AuthHuaweiId();
    L7:
        r101.requestExtraScopes(r100);
        return r101;
    L10:
        throw new HuaweiIdAuthException("ScopeList should not be empty");
    }

    public static AuthHuaweiId getExtendedAuthResult(HuaweiIdAuthExtendedParams r100) {
        if (r100 == null) goto L9;
        List<Scope> r101 = r100.getExtendedScopes();
        AuthHuaweiId r102 = x.b();
        if (r102 != null) goto L7;
        r102 = new AuthHuaweiId();
    L7:
        return r102.requestExtraScopes(r101);
    L9:
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
    }

    public static Task<AuthHuaweiId> parseAuthResultFromIntent(Intent r100) {
        TaskCompletionSource r101 = new TaskCompletionSource();
        HuaweiIdAuthResult r102 = x.a(r100);
        if (r102 != null) goto L6;
        r101.setException(new ApiException(new Status(8)));
    L13:
        return r101.getTask();
    L6:
        if (r102.isSuccess() == true) goto L8;
    L11:
        r101.setException(new ApiException(r102.getStatus()));
        goto L13
    L8:
        if (r102.getHuaweiId() == null) goto L11;
        r101.setResult(r102.getHuaweiId());
        goto L13
    }

    private static Intent a(Activity r100, List<Scope> r101) {
        return getService(r100, x.a(r101)).getSignInIntent();
    }

    public static boolean containScopes(AuthHuaweiId r100, List<Scope> r101) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (ap.a(r101).booleanValue() == false) goto L10;
        return true;
    L10:
        return r100.getAuthorizedScopes().containsAll(r101);
    }

    public static HuaweiIdAuthService getService(Activity r100, HuaweiIdAuthParams r101) {
        return new HuaweiIdAuthServiceImpl(r100, r101, 60900100);
    }

    public static boolean containScopes(AuthHuaweiId r100, HuaweiIdAuthExtendedParams r101) {
        if (r101 != null) goto L6;
        return false;
    L6:
        return containScopes(r100, r101.getExtendedScopes());
    }

    public static HuaweiIdAuthService getService(Context r100, HuaweiIdAuthParams r101) {
        return new HuaweiIdAuthServiceImpl(r100, r101, 60900100);
    }

    public static void addAuthScopes(Fragment r100, int r101, List<Scope> r102) {
        if (r100 == null) goto L13;
        if (r102 == null) goto L11;
        r100.startActivityForResult(a(r100.getActivity(), r102), r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        as.d("HuaweiIdAuthManager", "Exception：".concat(e.getClass().getSimpleName()), true);
        return;
    L11:
        throw new NullPointerException("ScopeList should not be null");
    L13:
        throw new NullPointerException("Fragment should not be null");
    }

    public static void addAuthScopes(Activity r100, int r101, List<Scope> r102) {
        if (r100 == null) goto L13;
        if (r102 == null) goto L11;
        r100.startActivityForResult(a(r100, r102), r101);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        as.d("HuaweiIdAuthManager", "Exception：".concat(e.getClass().getSimpleName()), true);
        return;
    L11:
        throw new NullPointerException("ScopeList should not be null");
    L13:
        throw new NullPointerException("Activity should not be null");
    }

    public static void addAuthScopes(Activity r100, int r101, HuaweiIdAuthExtendedParams r102) {
        if (r102 == null) goto L6;
        addAuthScopes(r100, r101, r102.getExtendedScopes());
        return;
    L6:
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
    }

    public static void addAuthScopes(Fragment r100, int r101, HuaweiIdAuthExtendedParams r102) {
        if (r102 == null) goto L6;
        addAuthScopes(r100, r101, r102.getExtendedScopes());
        return;
    L6:
        throw new NullPointerException("HuaweiIdAuthExtendedParams should not be null");
    }
}
