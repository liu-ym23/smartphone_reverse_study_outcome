package com.bytedance.vcloud.networkpredictor;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class AwemeSpeedPredictor implements ISpeedPredictor, ISpeedPredictorAwemeListener {
    public static final int SPEEDPREDICTOR_ALOG_DEFAULT = 4;
    public static final int SPEEDPREDICTOR_ALOG_INTELLIGENT = 5;
    private static final String TAG = "AwemeSpeedPredictor";
    private ISpeedPredictorAwemePredictor mAwemeRealPredictor;
    private ISpeedPredictorListener mSpeedPredictorListener;
    private Timer timer;

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void close() {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getAverageDownloadSpeed(int r100, int r101, boolean r102) {
        return -1.0f;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public Map<String, String> getDownloadSpeed(int r100) {
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getLastPredictConfidence() {
        return -1.0f;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public String getMultidimensionalDownloadSpeeds() {
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public SpeedPredictorResultCollection getMultidimensionalDownloadSpeedsObj() {
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public String getMultidimensionalPredictSpeeds() {
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public SpeedPredictorResultCollection getMultidimensionalPredictSpeedsObj() {
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getPredictSpeed() {
        return getPredictSpeed(0);
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public String getVersion() {
        return "A1.8.0";
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void prepare() {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void release() {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void setConfigInfo(Map r100) {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void setSpeedQueueSize(int r100) {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void start() {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void update(ISpeedRecordOld r100, Map<String, Integer> r101) {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void update(String r100, Map<String, Integer> r101) {
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictorAwemeListener
    public String getCountry() {
        return this.mSpeedPredictorListener.getCountry();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictorAwemeListener
    public String getFilesCachePath() {
        return this.mSpeedPredictorListener.getFilesCachePath();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictorAwemeListener
    public Object getIOExecutor() {
        return this.mSpeedPredictorListener.getIOExecutor();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictorAwemeListener
    public String getNetworkType() {
        return this.mSpeedPredictorListener.getNetworkType();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictorAwemeListener
    public int getPhoneSignal() {
        return this.mSpeedPredictorListener.getPhoneSignal();
    }

    public void startCalculate() {
        PthreadTimer r100 = new PthreadTimer("awemeSpeedPredictor");
        this.timer = r100;
        r100.schedule(new AnonymousClass1(this), 500, 500);
    }

    public void stopCalculate() {
        this.timer.cancel();
    }

    public AwemeSpeedPredictor(ISpeedPredictorListener r100) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.mAwemeRealPredictor = null;
        this.mSpeedPredictorListener = r100;
        Class r101 = INVOKESTATIC_com_bytedance_vcloud_networkpredictor_AwemeSpeedPredictor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.vcloud.iesnetworkpredictnative.NetworkSpeedManager");     // Catch: ClassNotFoundException -> L5
    L6:
        this.mAwemeRealPredictor = (ISpeedPredictorAwemePredictor) r101.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        this.mSpeedPredictorListener = r100;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_vcloud_networkpredictor_AwemeSpeedPredictor_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ ISpeedPredictorAwemePredictor access$000(AwemeSpeedPredictor r100) {
        return r100.mAwemeRealPredictor;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getPredictSpeed(int r100) {
        return (float) this.mAwemeRealPredictor.getSpeed();
    }

    public void setupAlgorithmTypeAndConfig(int r100, ISpeedPredictorMLConfig r101) {
        if (r100 != 4) goto L9;
        Timer r102 = this.timer;
        if (r102 == null) goto L7;
        r102.cancel();
    L7:
        this.mAwemeRealPredictor.setSpeedAlgorithmType(4);
        return;
    L9:
        if (r100 != 5) goto L13;
        this.mAwemeRealPredictor.setPredictorListener(this);
        this.mAwemeRealPredictor.configMlModel(r101);
        this.mAwemeRealPredictor.setSpeedAlgorithmType(5);
        startCalculate();
        return;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictorAwemeListener
    public boolean getDownFileState(String r100, String r101, String r102) throws Exception {
        return this.mSpeedPredictorListener.getDownFileState(r100, r101, r102);
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void update(long r100, long r110, long r111) {
        if (r110 > 0) goto L5;
        return;
    L5:
        double r101 = r100;
        this.mAwemeRealPredictor.monitorVideoSpeed((8.0d * r101) / (r110 / 1000.0d), r101, r110);
    }
}
