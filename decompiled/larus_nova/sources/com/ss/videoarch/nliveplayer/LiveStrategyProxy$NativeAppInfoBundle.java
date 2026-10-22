package com.ss.videoarch.nliveplayer;

import com.ss.videoarch.strategy.IAppInfoBundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
class LiveStrategyProxy$NativeAppInfoBundle implements IAppInfoBundle {
    private static native int cpp_getIntegerAppInfoForKey(int r100, String r101, int r102);

    private static native String cpp_getJSONObjectAppInfoForKey(int r100, String r101, JSONObject r102);

    private static native void cpp_getNullAppInfoForKey(int r100, String r101);

    private static native String cpp_getStringAppInfoForKey(int r100, String r101, String r102);

    @Override // com.ss.videoarch.strategy.IAppInfoBundle
    public final /* synthetic */ void onStrategyResult(String r100, JSONObject r101) {
        IAppInfoBundle.CC.$default$onStrategyResult(this, r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, org.json.JSONObject] */
    @Override // com.ss.videoarch.strategy.IAppInfoBundle
    public final <T> T getAppInfoForKey(String r100, T r101) {
        if (r101 != 0) goto L7;
        cpp_getNullAppInfoForKey(0, r100);
        return r101;
    L7:
        if ((r101 instanceof JSONObject) == false) goto L15;
        ?? r102 = (T) ((JSONObject) r101);
        String r103 = cpp_getJSONObjectAppInfoForKey(0, r100, r102);
        if (r103 == null) goto L26;
        return (T) new JSONObject(r103);
    L27:
        return r102;
    L26:
        return r102;
    L15:
        if ((r101 instanceof Integer) == false) goto L19;
        return (T) Integer.valueOf(cpp_getIntegerAppInfoForKey(0, r100, ((Integer) r101).intValue()));
    L19:
        if ((r101 instanceof String) == true) goto L21;
        return r101;
    L21:
        return (T) cpp_getStringAppInfoForKey(0, r100, (String) r101);
    }
}
