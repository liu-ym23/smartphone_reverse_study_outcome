package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

/* JADX INFO: loaded from: classes40.dex */
public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int r100) {
        Log.v(TAG, "getDiffDevOAuth, version = " + r100);
        if (r100 <= 1) goto L6;
        Log.e(TAG, "getDiffDevOAuth fail, unsupported version = " + r100);
        return null;
    L6:
        if (r100 == 1) goto L9;
        return null;
    L9:
        if (v1Instance != null) goto L12;
        v1Instance = new a();
    L12:
        return v1Instance;
    }
}
