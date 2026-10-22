package com.bytedance.vcloud.abrmodule;

import android.text.TextUtils;
import com.ss.ttm.player.ABRStrategy;
import com.ss.ttm.player.NativeABRStrategy;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class DefaultABRModule implements IABRModule {
    public static final int PREDICTBITRATE_ALGO_BABB = 0;
    public static final int PREDICTBITRATE_ALGO_BB = 1;
    public static final int PREDICTBITRATE_ALGO_BBA = 9;
    public static final int PREDICTBITRATE_ALGO_BOLA = 6;
    public static final int PREDICTBITRATE_ALGO_BW = 3;
    public static final int PREDICTBITRATE_ALGO_CS = 4;
    public static final int PREDICTBITRATE_ALGO_FESTIVE = 7;
    public static final int PREDICTBITRATE_ALGO_MPC = 2;
    public static final int PREDICTBITRATE_ALGO_MPC2 = 8;
    public static final int PREDICTBITRATE_ALGO_RL = 5;
    private int mAlgoType;
    private long mHandle;

    private native void _addBufferInfo(long r100, int r101, String r102, long r103, long r104, long r105);

    private native long _create();

    private native double _getDoubleValue(long r100, int r101, double r102);

    private native float _getFloatValue(long r100, int r101, float r102);

    private native long _getLongValue(long r100, int r101, long r102);

    private native ABRResult _getPredict(long r100);

    private native String _getPredictByJsonParams(long r100, String r101);

    private native String _getStringValue(long r100, int r101, String r102);

    private native String _getVersion();

    private native void _release(long r100);

    private native ABRResult _select(long r100, int r101, int r102);

    private native void _setDataSource(long r100, IPlayStateSupplier r101);

    private native void _setDeviceInfo(long r100, IDeviceInfo r101);

    private native void _setDoubleValue(long r100, int r101, double r102);

    private native void _setFloatValue(long r100, int r101, float r102);

    private native void _setInfoListener(long r100, IABRInfoListener r101);

    private native void _setIntValue(long r100, int r101, int r102);

    private native void _setLongValue(long r100, int r101, long r102);

    private native void _setMediaInfo(long r100, List<IVideoStream> r101, List<IAudioStream> r102);

    private native void _setSRBenchmark(long r100, Map<Integer, Integer> r101);

    private native void _setSRBenchmarkMap(long r100, Map<Integer, List<Integer>> r101);

    private native void _setStringValue(long r100, int r101, String r102);

    private native void _start(long r100, int r101, int r102);

    private native void _stop(long r100);

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public ABRResult getPredict() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return _getPredict(r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public String getVersion() {
        if (this.mHandle != 0) goto L7;
        return "j_2.142.1";
    L7:
        return _getVersion();
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void release() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        _release(r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void stop() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        _stop(r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public ABRStrategy toStratrgy() {
        long r100 = this.mHandle;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return new NativeABRStrategy(r100);
    }

    public DefaultABRModule() {
        this.mHandle = 0;
        this.mAlgoType = -1;
        ABRJniLoader.loadLibrary();
        if (ABRJniLoader.isLibraryLoaded == true) goto L5;
        return;
    L5:
        long r100 = _create();
        this.mHandle = r100;
        _setIntValue(r100, 0, ABRConfig.getLogLevel());
        _setIntValue(this.mHandle, 1, ABRConfig.getSwitchSensitivity());
        _setIntValue(this.mHandle, 3, ABRConfig.getSwitchModel());
        _setIntValue(this.mHandle, 4, ABRConfig.getFixedLevel());
        _setIntValue(this.mHandle, 5, ABRConfig.getStartupModel());
        _setIntValue(this.mHandle, 37, ABRConfig.getStartupUseCache());
        _setIntValue(this.mHandle, 45, ABRConfig.getNarrowScreenUseWidth());
        _setFloatValue(this.mHandle, 8, ABRConfig.getStartupBandwidthParameter());
        _setFloatValue(this.mHandle, 9, ABRConfig.getStallPenaltyParameter());
        _setFloatValue(this.mHandle, 10, ABRConfig.getSwitchPenaltyParameter());
        _setFloatValue(this.mHandle, 11, ABRConfig.getBandwidthParameter());
        _setDoubleValue(this.mHandle, 29, ABRConfig.getStartupModelFirstParam());
        _setDoubleValue(this.mHandle, 30, ABRConfig.getStartupModelSecondParam());
        _setDoubleValue(this.mHandle, 31, ABRConfig.getStartupModelThirdParam());
        _setDoubleValue(this.mHandle, 32, ABRConfig.getStartupModelFourthParam());
        String r101 = ABRConfig.getAbrStartupJson();
        if (TextUtils.isEmpty(r101) == true) goto L8;
        _setStringValue(this.mHandle, 51, r101);
    L8:
        String r102 = ABRConfig.getAbrFlowJson();
        if (TextUtils.isEmpty(r102) == true) goto L11;
        _setStringValue(this.mHandle, 52, r102);
    L11:
        String r103 = ABRConfig.getAbrPreloadJson();
        if (TextUtils.isEmpty(r103) == true) goto L15;
        _setStringValue(this.mHandle, 50, r103);
        return;
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public String getPredictByJsonParams(String r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L7;
        return null;
    L7:
        return _getPredictByJsonParams(r101, r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void init(IPlayStateSupplier r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L8;
        return;
    L8:
        _setDataSource(r101, r100);     // Catch: Throwable -> L7
        return;
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setDeviceInfo(IDeviceInfo r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setDeviceInfo(r101, r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setInfoListener(IABRInfoListener r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setInfoListener(r101, r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setSRBenchmark(Map<Integer, Integer> r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setSRBenchmark(r101, r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setSRBenchmarkMap(Map<Integer, List<Integer>> r100) {
        long r101 = this.mHandle;
        if (r101 != 0) goto L5;
        return;
    L5:
        _setSRBenchmarkMap(r101, r100);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public float getFloatOption(int r100, float r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L6;
        return r101;
    L6:
        return _getFloatValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public long getLongOption(int r100, long r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L6;
        return r101;
    L6:
        if (r100 != 19) goto L10;
        return this.mAlgoType;
    L10:
        return _getLongValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public String getStringOption(int r100, String r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L10;
        return r101;
    L10:
        return _getStringValue(r102, r100, r101);
    L7:
        th = move-exception;
        th.printStackTrace();
        return r101;
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public ABRResult onceSelect(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L7;
        return null;
    L7:
        return _select(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setDoubleOptionForKey(int r100, double r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setDoubleValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setFloatOptionForKey(int r100, float r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setFloatValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setIntOptionForKey(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setIntValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setLongOptionForKey(int r100, long r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setLongValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setMediaInfo(List<IVideoStream> r100, List<IAudioStream> r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setMediaInfo(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void setStringOptionForKey(int r100, String r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        _setStringValue(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void start(int r100, int r101) {
        long r102 = this.mHandle;
        if (r102 != 0) goto L5;
        return;
    L5:
        this.mAlgoType = r100;
        _start(r102, r100, r101);
    }

    @Override // com.bytedance.vcloud.abrmodule.IABRModule
    public void addBufferInfo(int r110, String r111, long r112, long r113, long r114) {
        long r100 = this.mHandle;
        if (r100 != 0) goto L5;
        return;
    L5:
        _addBufferInfo(r100, r110, r111, r112, r113, r114);
    }
}
