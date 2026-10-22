package com.bytedance.privacy.pseudoid.account;

import com.bytedance.privacy.bridge.IAccountBridge;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0007J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/privacy/pseudoid/account/AccountApi;", "", "()V", "TAG", "", "mAccountBridge", "Lcom/bytedance/privacy/bridge/IAccountBridge;", "getDeviceId", "getUDID", "getUserId", "getXttTokenMap", "", "init", "", "callback", Keys.API_RETURN_KEY_IS_LOGIN, "", "privacysdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AccountApi {
    public static final AccountApi INSTANCE = null;
    private static final String TAG = "AccountApi";
    private static IAccountBridge mAccountBridge;

    static {
        INSTANCE = new AccountApi();
    }

    private AccountApi() {
    }

    public final String getDeviceId() {
        IAccountBridge r100 = mAccountBridge;
        if (r100 == null) goto L5;
        String r101 = r100.onGetDeviceId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getUDID() {
        IAccountBridge r100 = mAccountBridge;
        if (r100 == null) goto L5;
        String r101 = r100.onGetUDID();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final String getUserId() {
        IAccountBridge r100 = mAccountBridge;
        if (r100 == null) goto L5;
        String r101 = r100.onGetUserId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public final boolean isLogin() {
        IAccountBridge r100 = mAccountBridge;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.onIsAccountLogin();
    }

    public final Map<String, String> getXttTokenMap() {
        Map<String, String> r100 = MapsKt.emptyMap();
        IAccountBridge r101 = mAccountBridge;
        if (r101 == null) goto L5;
        Map<String, String> r102 = r101.onGetXttTokenMap();
    L6:
        if (r102 != null) goto L9;
        return r100;
    L9:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void init(IAccountBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        mAccountBridge = r100;
    }
}
