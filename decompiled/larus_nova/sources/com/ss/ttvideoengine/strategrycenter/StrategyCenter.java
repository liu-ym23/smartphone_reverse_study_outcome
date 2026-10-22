package com.ss.ttvideoengine.strategrycenter;

import com.bytedance.vcloud.networkpredictor.AwemeSpeedPredictor;
import com.bytedance.vcloud.networkpredictor.DefaultSpeedPredictor;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictor;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictorListener;
import com.bytedance.vcloud.networkpredictor.ISpeedPredictorMLConfig;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public class StrategyCenter {
    private static final String TAG = "TTVideoEngine";
    private static Map sConfigInfo;
    public static ISpeedPredictor sNetAbrSpeedPredictor;
    public static ISpeedPredictor sNetSpeedPredictor;
    private static ISpeedPredictorListener speedPredictorListener;
    private static ISpeedPredictorMLConfig speedPredictorMlConfig;

    /* JADX INFO: renamed from: com.ss.ttvideoengine.strategrycenter.StrategyCenter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class StrategyCenterHolder {
        private static final StrategyCenter instance = null;

        private StrategyCenterHolder() {
        }

        static {
            instance = new StrategyCenter(null);
        }

        public static /* synthetic */ StrategyCenter access$100() {
            return instance;
        }
    }

    private StrategyCenter() {
    }

    public static void closeNewStartAndSelectGearSpeedPredictor() {
        sNetSpeedPredictor.release();
    }

    public static StrategyCenter getInstance() {
        return StrategyCenterHolder.access$100();
    }

    public /* synthetic */ StrategyCenter(AnonymousClass1 r100) {
        this();
    }

    public static void createNewStartAndSelectGearSpeedPredictor(int r100) {
        if (sNetSpeedPredictor == null) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[IESSpeedPredictor] start new speed predictor, type:%d", new Object[]{Integer.valueOf(r100)}));
        DefaultSpeedPredictor r101 = new DefaultSpeedPredictor(r100);
        sNetSpeedPredictor = r101;
        r101.setConfigInfo(sConfigInfo);
    }

    public static void createSpeedPredictor(int r100) {
        if (sNetSpeedPredictor == null) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[IESSpeedPredictor] start speed predictor, type:%d", new Object[]{Integer.valueOf(r100)}));
        if (r100 == 1) goto L17;
        if (r100 == 0) goto L17;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L17;
        AwemeSpeedPredictor r101 = new AwemeSpeedPredictor(speedPredictorListener);     // Catch: Exception -> L15
        sNetSpeedPredictor = r101;     // Catch: Exception -> L15
        AwemeSpeedPredictor r102 = r101;     // Catch: Exception -> L15
        r101.setupAlgorithmTypeAndConfig(r100, speedPredictorMlConfig);     // Catch: Exception -> L15
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        sNetSpeedPredictor = new DefaultSpeedPredictor(r100);
    }

    public static void setConfigInfo(Map r100) {
        sConfigInfo = r100;
    }

    public static void setSpeedPredictorListener(ISpeedPredictorListener r100) {
        speedPredictorListener = r100;
    }

    public static void setSpeedPredictorMlConfig(ISpeedPredictorMLConfig r100) {
        speedPredictorMlConfig = r100;
    }

    public static void setSpeedQueueSize(int r100) {
        ISpeedPredictor r101 = sNetSpeedPredictor;
        if (r101 == null) goto L6;
        r101.setSpeedQueueSize(r100);
        return;
    }

    public static void createAbrSpeedPredictor(int r100, int r101) {
        if (sNetAbrSpeedPredictor == null) goto L5;
        return;
    L5:
        TTVideoEngineLog.d(TAG, String.format(Locale.US, "[ABR] start speed predictor, type:%d，intervalMs:%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}));
        sNetAbrSpeedPredictor = new DefaultSpeedPredictor(r100);
    }
}
