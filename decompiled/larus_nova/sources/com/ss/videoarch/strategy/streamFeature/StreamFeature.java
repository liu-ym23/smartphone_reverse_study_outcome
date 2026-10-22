package com.ss.videoarch.strategy.streamFeature;

import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class StreamFeature {
    static final String TAG = "StreamFeature";
    private StreamFeature mNext;

    private static native String nativeConvertAlgoSeiToJsonString(byte[] r100);

    public StreamFeature() {
        this.mNext = null;
    }

    public StreamFeature getNext() {
        return this.mNext;
    }

    public static JSONArray ConvertAlgoSeiToJSONArray(ByteBuffer r100) throws JSONException {
        int r101 = r100.position();
        int r102 = r100.limit();
        byte[] r103 = new byte[r100.remaining()];
        r100.get(r103);
        r100.position(r101);
        r100.limit(r102);
        if (VeLSUtils.isLoadSoSuccess() == true) goto L7;
        return null;
    L7:
        return new JSONArray(nativeConvertAlgoSeiToJsonString(r103));
    }
}
