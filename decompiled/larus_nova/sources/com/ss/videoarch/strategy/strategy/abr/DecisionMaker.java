package com.ss.videoarch.strategy.strategy.abr;

import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class DecisionMaker {
    private static final String TAG = "DecisionMaker";

    public static class DecisionMakerInstance {
        private static final DecisionMaker mInstance = null;

        private DecisionMakerInstance() {
        }

        static {
            mInstance = new DecisionMaker();
        }

        public static /* synthetic */ DecisionMaker access$000() {
            return mInstance;
        }
    }

    public DecisionMaker() {
    }

    private native String nativeMakeDecision(String r100);

    public static DecisionMaker getInstance() {
        return DecisionMakerInstance.access$000();
    }

    public JSONObject makeDecision(JSONObject r100) {
        if (VeLSUtils.isLoadSoSuccess() == true) goto L5;
        return null;
    L5:
        String r101 = nativeMakeDecision(r100.toString());
        if (r101 != null) goto L8;
    L13:
        return null;
    L8:
        if (r101.isEmpty() == true) goto L13;
        return new JSONObject(r101);
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }
}
