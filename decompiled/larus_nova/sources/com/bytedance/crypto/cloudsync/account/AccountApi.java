package com.bytedance.crypto.cloudsync.account;

import com.bytedance.crypto.bridge.IAccountBridge;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class AccountApi {
    public static final AccountApi INSTANCE = null;
    private static final String TAG = "AccountApi";
    private static IAccountBridge mAccountBridge;

    static {
        INSTANCE = new AccountApi();
    }

    private AccountApi() {
    }

    @JvmStatic
    public static final void init(IAccountBridge r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        mAccountBridge = r100;
    }

    public final String getUserId() {
        IAccountBridge r100 = mAccountBridge;
        if (r100 == null) goto L7;
        String r101 = r100.onGetUserId();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return "";
    }

    public final Map<String, String> getXttTokenMap() {
        Map<String, String> r100 = MapsKt.emptyMap();
        IAccountBridge r101 = mAccountBridge;
        if (r101 == null) goto L10;
        Map<String, String> r102 = r101.onGetXttTokenMap();
        if (r102 != null) goto L9;
        return r100;
    L9:
        return r102;
    L10:
        return r100;
    }

    public final boolean isLogin() {
        IAccountBridge r100 = mAccountBridge;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.onIsAccountLogin();
    }
}
