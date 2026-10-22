package com.bytedance.vcloud.networkpredictor;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public class DefaultSpeedPredictor implements ISpeedPredictor, Handler.Callback {
    public static final int KeyIsUpdateSpeedRecord = 0;
    public static final int SPEEDPREDICTOR_ALOG_ANET = 2;
    public static final int SPEEDPREDICTOR_ALOG_ANETIES = 6;
    public static final int SPEEDPREDICTOR_ALOG_HANET = 1;
    public static final int SPEEDPREDICTOR_ALOG_HECNET = 0;
    public static final int SPEEDPREDICTOR_ALOG_KFNET = 4;
    public static final int SPEEDPREDICTOR_ALOG_LSTMNET = 3;
    private static final int SPEEDPREDICTOR_LOG_LEVEL_KEY = 0;
    private static final String TAG = "SpeedPredictor";
    ReentrantReadWriteLock lock;
    private long mHandle;
    private Handler mSpeedUpdateHander;
    final ReentrantReadWriteLock.ReadLock readLock;
    private Thread subThread;
    final ReentrantReadWriteLock.WriteLock writeLock;

    private native void _close(long r100);

    private native long _create(int r100);

    private native float _getAverageDownloadSpeed(long r100, int r101, int r102, boolean r103);

    private native double _getDoubleValue(long r100, int r101, double r102);

    private native Map<String, String> _getDownloadSpeed(long r100, int r101);

    private native int _getIntValue(long r100, int r101, int r102);

    private native float _getLastPredictConfidence(long r100);

    private native long _getLongValue(long r100, int r101, long r102);

    private native SpeedPredictorResultCollection _getMultidimensionalDownloadSpeeds(long r100);

    private native SpeedPredictorResultCollection _getMultidimensionalPredictSpeeds(long r100);

    private native float _getPredictSpeed(long r100, int r101);

    private native String _getVersion();

    private native void _prepare(long r100);

    private native void _release(long r100);

    private native void _setConfigSpeedInfo(long r100, Map<String, String> r101);

    private native void _setDoubleValue(long r100, int r101, double r102);

    private native void _setIntValue(long r100, int r101, int r102);

    private native void _setLongValue(long r100, int r101, long r102);

    private native void _setSpeedQueueSize(long r100, int r101);

    private native void _setStringValue(long r100, int r101, String r102);

    private native void _start(long r100);

    private native void _update(long r100, ArrayList<SpeedPredictorRecord> r101, Map<String, Integer> r102);

    private native void _updateOldWithStreamId(long r100, ISpeedRecordOld r101, Map<String, Integer> r102);

    private native void _updateWithSizeTime(long r100, long r101, long r102, long r103);

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getPredictSpeed() {
        return getPredictSpeed(0);
    }

    private void resetSpeedPredictor() {
        Handler r100 = this.mSpeedUpdateHander;
        if (r100 == null) goto L6;
        r100.removeCallbacksAndMessages(null);
        ThreadMethodProxy.quit(this.mSpeedUpdateHander.getLooper());
        this.mSpeedUpdateHander = null;
        this.subThread = null;
        return;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void close() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return;
    L6:
        _close(r100);
        this.readLock.unlock();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getLastPredictConfidence() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return -1.0f;
    L6:
        float r101 = _getLastPredictConfidence(r100);
        this.readLock.unlock();
        return r101;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public String getMultidimensionalDownloadSpeeds() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return null;
    L6:
        String r101 = speedPredictorResultArrayToString(_getMultidimensionalDownloadSpeeds(r100).getResultCollection());
        this.readLock.unlock();
        return r101;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public SpeedPredictorResultCollection getMultidimensionalDownloadSpeedsObj() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return null;
    L6:
        SpeedPredictorResultCollection r101 = _getMultidimensionalDownloadSpeeds(r100);
        this.readLock.unlock();
        return r101;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public String getMultidimensionalPredictSpeeds() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return null;
    L6:
        SpeedPredictorResultCollection r101 = _getMultidimensionalPredictSpeeds(r100);
        if (r101 == null) goto L10;
        this.readLock.unlock();
        return speedPredictorResultArrayToString(r101.getResultCollection());
    L10:
        this.readLock.unlock();
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public SpeedPredictorResultCollection getMultidimensionalPredictSpeedsObj() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return null;
    L6:
        SpeedPredictorResultCollection r101 = _getMultidimensionalPredictSpeeds(r100);
        this.readLock.unlock();
        return r101;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public String getVersion() {
        if (this.mHandle != 0) goto L7;
        return "j_1.8.0";
    L7:
        return _getVersion();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void prepare() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return;
    L6:
        _prepare(r100);
        this.readLock.unlock();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void release() {
        this.writeLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.writeLock.unlock();
        return;
    L6:
        _close(r100);
        _release(this.mHandle);
        this.mHandle = 0;
        resetSpeedPredictor();
        this.writeLock.unlock();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void start() {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return;
    L6:
        _start(r100);
        this.readLock.unlock();
    }

    public DefaultSpeedPredictor(int r100) {
        this.mHandle = 0;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock(false);
        this.lock = r101;
        this.readLock = r101.readLock();
        this.writeLock = this.lock.writeLock();
        SpeedPredictorJniLoader.loadLibrary();
        if (SpeedPredictorJniLoader.isLibraryLoaded == true) goto L6;
        SpeedPredictorLog.e(TAG, "[SpeedPredictor] no predictor native loaded");
        return;
    L6:
        this.mHandle = _create(r100);
        SpeedPredictorConfig.setLoglevel(0);
        _setIntValue(this.mHandle, 0, SpeedPredictorConfig.getLogLevel());
    }

    private String speedPredictorResultArrayToString(ArrayList<SpeedPredictorResult> r100) {
        if (r100 == null) goto L23;
    L7:
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L20
        Iterator<SpeedPredictorResult> r102 = r100.iterator();     // Catch: Exception -> L20
    L9:
        if (r102.hasNext() == false) goto L17;
        SpeedPredictorResult r103 = r102.next();     // Catch: Exception -> L20
        if (r103 == null) goto L9;
        JSONObject r104 = r103.toJsonObject();     // Catch: Exception -> L20
        if (r104 == null) goto L9;
        r101.put(r104);     // Catch: Exception -> L20
        goto L9
    L17:
        if (r101.length() <= 0) goto L22;
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L20
        r105.put("data", r101);     // Catch: Exception -> L20
        return r105.toString();
    L20:
        e = move-exception;
        e.printStackTrace();
    L22:
        return null;
    L23:
        if (r100.size() > 0) goto L7;
        return null;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public Map<String, String> getDownloadSpeed(int r100) {
        this.readLock.lock();
        long r101 = this.mHandle;
        if (r101 != 0) goto L6;
        this.readLock.unlock();
        return null;
    L6:
        Map<String, String> r102 = _getDownloadSpeed(r101, r100);
        this.readLock.unlock();
        return r102;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getPredictSpeed(int r100) {
        this.readLock.lock();
        long r101 = this.mHandle;
        if (r101 != 0) goto L6;
        this.readLock.unlock();
        return -1.0f;
    L6:
        float r102 = _getPredictSpeed(r101, r100);
        this.readLock.unlock();
        return r102;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r100) {
        if (r100.what != 0) goto L7;
        SpeedPredictorNotifyInfo r101 = (SpeedPredictorNotifyInfo) r100.obj;
        _updateOldWithStreamId(this.mHandle, r101.mSpeedRecord, r101.mStreamIdMediaTypeMap);
        return true;
    L7:
        return true;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void setConfigInfo(Map r100) {
        this.readLock.lock();
        long r101 = this.mHandle;
        if (r101 != 0) goto L6;
        this.readLock.unlock();
        return;
    L6:
        _setConfigSpeedInfo(r101, r100);
        this.readLock.unlock();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void setSpeedQueueSize(int r100) {
        this.readLock.lock();
        long r101 = this.mHandle;
        if (r101 != 0) goto L6;
        this.readLock.unlock();
        return;
    L6:
        _setSpeedQueueSize(r101, r100);
        this.readLock.unlock();
    }

    public static /* synthetic */ Handler access$002(DefaultSpeedPredictor r100, Handler r101) {
        r100.mSpeedUpdateHander = r101;
        return r101;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void update(String r100, Map<String, Integer> r101) {
        this.readLock.lock();
        if (this.mHandle == 0) goto L19;
        if (r100 == null) goto L19;
        if (r100.length() < 0) goto L19;
        if (r101 == null) goto L19;
        if (r101.size() < 0) goto L19;
        this.readLock.unlock();
        JSONArray r102 = new JSONObject(r100).optJSONArray("data");     // Catch: Exception -> L22
        ArrayList<SpeedPredictorRecord> r103 = new ArrayList();     // Catch: Exception -> L22
        int r104 = 0;
    L14:
        if (r104 >= r102.length()) goto L17;
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r102, r104);     // Catch: Throwable -> L21
        SpeedPredictorRecord r106 = new SpeedPredictorRecord();     // Catch: Throwable -> L21
        r106.extractFields(r105);     // Catch: Throwable -> L21
        r103.add(r106);     // Catch: Throwable -> L21
    L16:
        r104 = r104 + 1;
        goto L14
    L17:
        this.readLock.lock();     // Catch: Exception -> L22
        _update(this.mHandle, r103, r101);     // Catch: Exception -> L22
        this.readLock.unlock();     // Catch: Exception -> L22
        return;
    L29:
        return;
    L19:
        this.readLock.unlock();
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void update(ISpeedRecordOld r100, Map<String, Integer> r101) {
        this.readLock.lock();
        if (this.mHandle != 0) goto L7;
        this.readLock.unlock();
        return;
    L7:
        if (Looper.getMainLooper() == Looper.myLooper()) goto L9;
        _updateOldWithStreamId(this.mHandle, r100, r101);
    L15:
        this.readLock.unlock();
        return;
    L9:
        if (this.subThread != null) goto L12;
        PthreadThreadV2 r102 = new AnonymousClass1(this, this);
        this.subThread = r102;
        ThreadMethodProxy.setName(r102, "speed_predict_update_thread");
        ThreadMethodProxy.start(this.subThread);
    L12:
        if (this.mSpeedUpdateHander == null) goto L15;
        SpeedPredictorNotifyInfo r103 = new SpeedPredictorNotifyInfo();
        r103.what = 0;
        r103.mSpeedRecord = r100;
        r103.mStreamIdMediaTypeMap = r101;
        Message r104 = this.mSpeedUpdateHander.obtainMessage();
        r104.what = 0;
        r104.obj = r103;
        r104.sendToTarget();
        goto L15
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public float getAverageDownloadSpeed(int r100, int r101, boolean r110) {
        this.readLock.lock();
        long r102 = this.mHandle;
        if (r102 != 0) goto L6;
        this.readLock.unlock();
        return -1.0f;
    L6:
        float r103 = _getAverageDownloadSpeed(r102, r100, r101, r110);
        this.readLock.unlock();
        return r103;
    }

    @Override // com.bytedance.vcloud.networkpredictor.ISpeedPredictor
    public void update(long r110, long r111, long r112) {
        this.readLock.lock();
        long r100 = this.mHandle;
        if (r100 != 0) goto L6;
        this.readLock.unlock();
        return;
    L6:
        _updateWithSizeTime(r100, r110, r111, r112);
        this.readLock.unlock();
    }
}
