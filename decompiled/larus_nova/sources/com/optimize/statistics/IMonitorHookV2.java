package com.optimize.statistics;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface IMonitorHookV2 {
    Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest r100, Object r101, String r102, JSONObject r103, boolean r104, boolean r105);
}
