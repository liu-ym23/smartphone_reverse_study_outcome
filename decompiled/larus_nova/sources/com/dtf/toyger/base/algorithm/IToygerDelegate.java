package com.dtf.toyger.base.algorithm;

import android.graphics.PointF;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.ToygerBiometricInfo;
import com.dtf.toyger.base.face.ToygerPairFaceInfo;
import faceverify.s;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface IToygerDelegate<State extends s, Attr extends ToygerAttr, Info extends ToygerBiometricInfo> {
    public static final int EVENT_CODE_DARK_SCREEN = -1;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_DEVICE = 2;
    public static final int LOG_MONITOR = 3;

    PointF handleAlignDepthPoint(PointF r100);

    void handleCaptureCompleted(int r100, List<Info> r101, Map<String, Object> r102);

    void handleEventTriggered(int r100, String r101);

    void handleInfoReady(TGFrame r100, Attr r101);

    void handleLog(int r100, HashMap<String, Object> r101);

    boolean handleModelLoad(int r100);

    void handleNativeDataUpdate(int r100, List<ToygerPairFaceInfo> r101, Map<String, String> r102);

    void handleScanCompleted(int r100, List<Info> r101, Map<String, Object> r102);

    void handleStateUpdated(State r100, Attr r101);
}
