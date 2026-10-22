package com.lynx.debugrouter;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class MessageAssembler {
    public MessageAssembler() {
    }

    public static native String nativeAssembleDispatchDocumentUpdated();

    public static native String nativeAssembleDispatchFrameNavigated(String r100);

    public static native String nativeAssembleDispatchScreencastVisibilityChanged(boolean r100);

    public static native String nativeAssembleScreenCastFrame(int r100, String r101, String r102);

    public static String assembleDispatchDocumentUpdated() {
        return nativeAssembleDispatchDocumentUpdated();
    }

    public static String assembleDispatchFrameNavigated(String r100) {
        return nativeAssembleDispatchFrameNavigated(r100);
    }

    public static String assembleDispatchScreencastVisibilityChanged(boolean r100) {
        return nativeAssembleDispatchScreencastVisibilityChanged(r100);
    }

    public static String assembleScreenCastFrame(int r100, String r101, Map<String, Float> r102) {
        return nativeAssembleScreenCastFrame(r100, r101, new JSONObject(r102).toString());
    }
}
