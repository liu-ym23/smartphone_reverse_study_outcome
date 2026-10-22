package com.bytedance.bdp.service.plug.map.model;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpCustomInfoWindowOptions;", "", "params", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "anchorX", "", "anchorY", "display", "Lcom/bytedance/bdp/service/plug/map/model/BdpInfoWindowOptions$Display;", "isDisplaying", "", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public final class BdpCustomInfoWindowOptions {
    public final double anchorX;
    public final double anchorY;
    public final BdpInfoWindowOptions.Display display;
    public boolean isDisplaying;

    public BdpCustomInfoWindowOptions(JSONObject r100) {
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r100 == null) goto L5;
        double r102 = r100.optDouble("anchorX", AudioStats.AUDIO_AMPLITUDE_NONE);
    L6:
        this.anchorX = r102;
        if (r100 == null) goto L9;
        r101 = r100.optDouble("anchorY", AudioStats.AUDIO_AMPLITUDE_NONE);
    L9:
        this.anchorY = r101;
        if (r100 == null) goto L12;
        String r103 = r100.optString("display");
    L14:
        if (Intrinsics.areEqual(r103, "ALWAYS") == false) goto L16;
        BdpInfoWindowOptions.Display r104 = BdpInfoWindowOptions.Display.ALWAYS;
    L17:
        this.display = r104;
        return;
    L16:
        r104 = BdpInfoWindowOptions.Display.BYCLICK;
        goto L17
    L12:
        r103 = null;
        goto L14
    L5:
        r102 = 0.0d;
        goto L6
    }
}
