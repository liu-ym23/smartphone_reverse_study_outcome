package android.ss.com.vboost;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class VboostListener {

    public interface SystemListener {
        void onSystemEvent(int r1, int r2, Bundle r3);
    }

    public interface VboostApplogListener {
        void onInternalEventV3(String r1, JSONObject r2, String r3, String r4, String r5);
    }

    public VboostListener() {
    }
}
