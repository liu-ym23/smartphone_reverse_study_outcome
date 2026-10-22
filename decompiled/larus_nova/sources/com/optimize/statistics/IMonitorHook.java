package com.optimize.statistics;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface IMonitorHook {
    Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest r100, Object r101, String r102, JSONObject r103, boolean r104);
}
