package com.ss.ttvideoengine;

/* JADX INFO: loaded from: classes34.dex */
public class EngineGlobalConfig {
    private static final String TAG = "EngineGlobalConfig";
    public int dataLoaderHelperLockType;
    private int dnsCustomType;
    public int enableMdlLockOptimizeV2;
    private long mALogWriteAddr;
    private int mEnableBmf;
    private int mEnableCPPBYTEVC1CodecOpt;
    private int mEnablePcdnAuto;
    private int mEnableSelectStringMapMethod;
    private int mEnableSelectUseObject;
    private int mEnableUseRealBitrate;
    private long mEngineOptimizeFlag;
    private int mLazyLoadVideodec;
    private boolean onlyUseMediaLoader;
    private int outputLogLevel;
    private int outputLogLevelPercise;
    private int renderType;
    private boolean useVideoInfoFetcherHandlerThread;

    public static final class InstanceHolder {
        private static final EngineGlobalConfig sInstance = null;

        private InstanceHolder() {
        }

        static {
            sInstance = new EngineGlobalConfig();
        }

        public static /* synthetic */ EngineGlobalConfig access$000() {
            return sInstance;
        }
    }

    public EngineGlobalConfig() {
        this.onlyUseMediaLoader = false;
        this.useVideoInfoFetcherHandlerThread = false;
        this.renderType = -1;
        this.outputLogLevel = 0;
        this.outputLogLevelPercise = -1;
        this.mALogWriteAddr = 0;
        this.mEnableCPPBYTEVC1CodecOpt = -1;
        this.mEnableBmf = 0;
        this.mEnableUseRealBitrate = 0;
        this.mLazyLoadVideodec = 0;
        this.mEnablePcdnAuto = 0;
        this.mEngineOptimizeFlag = 3;
        this.mEnableSelectStringMapMethod = 0;
        this.mEnableSelectUseObject = 0;
        this.dataLoaderHelperLockType = 0;
        this.enableMdlLockOptimizeV2 = 0;
    }

    public static EngineGlobalConfig getInstance() {
        return InstanceHolder.access$000();
    }

    public long getALogWriteAddr() {
        return this.mALogWriteAddr;
    }

    public int getDnsCustomType() {
        return this.dnsCustomType;
    }

    public int getEnableBmf() {
        return this.mEnableBmf;
    }

    public int getEnableCPPBYTEVC1CodecOpt() {
        return this.mEnableCPPBYTEVC1CodecOpt;
    }

    public int getEnableSelectStringMapMethod() {
        return this.mEnableSelectStringMapMethod;
    }

    public int getEnableSelectUseObject() {
        return this.mEnableSelectUseObject;
    }

    public int getEnableUseRealBitrate() {
        return this.mEnableUseRealBitrate;
    }

    public long getEngineOptimizeFlag() {
        return this.mEngineOptimizeFlag;
    }

    public int getLazyLoadVideodec() {
        return this.mLazyLoadVideodec;
    }

    public int getOutputLogLevel() {
        return this.outputLogLevel;
    }

    public int getOutputLogLevelPercise() {
        return this.outputLogLevelPercise;
    }

    public int getPcdnAuto() {
        return this.mEnablePcdnAuto;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public boolean isOnlyUseMediaLoader() {
        return this.onlyUseMediaLoader;
    }

    public boolean isUseVideoInfoFetcherHandlerThread() {
        return this.useVideoInfoFetcherHandlerThread;
    }

    public void onlyUseMediaLoader(boolean r100) {
        this.onlyUseMediaLoader = r100;
    }

    public void setALogWriteAddr(long r100) {
        this.mALogWriteAddr = r100;
    }

    public void setDnsCustomType(int r100) {
        this.dnsCustomType = r100;
    }

    public void setEnableBmf(int r100) {
        this.mEnableBmf = r100;
    }

    public void setEnableCPPBYTEVC1CodecOpt(int r100) {
        this.mEnableCPPBYTEVC1CodecOpt = r100;
    }

    public void setEnablePcdnAuto(int r100) {
        this.mEnablePcdnAuto = r100;
    }

    public void setEnableSelectStringMapMethod(int r100) {
        this.mEnableSelectStringMapMethod = r100;
    }

    public void setEnableSelectUseObject(int r100) {
        this.mEnableSelectUseObject = r100;
    }

    public void setEnableUseRealBitrate(int r100) {
        this.mEnableUseRealBitrate = r100;
    }

    public void setEngineOptimizeFlag(long r100) {
        this.mEngineOptimizeFlag = r100;
    }

    public void setLazyLoadVideodec(int r100) {
        this.mLazyLoadVideodec = r100;
    }

    public void setOutputLogLevel(int r100) {
        this.outputLogLevel = r100;
    }

    public void setOutputLogLevelPercise(int r100) {
        this.outputLogLevelPercise = r100;
    }

    public void setRenderType(int r100) {
        this.renderType = r100;
    }

    public void setUseVideoInfoFetcherHandlerThread(boolean r100) {
        this.useVideoInfoFetcherHandlerThread = r100;
    }
}
