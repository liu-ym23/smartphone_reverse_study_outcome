package com.ss.videoarch.liveplayer.config;

import tmc.a;

/* JADX INFO: loaded from: classes38.dex */
public class PlayerConfig {
    public PlayerConfigParams.NNSRParams SRConfig;
    public a<Integer> VeLivePlayerKeySetABRAlgorithm;
    public a<Integer> VeLivePlayerKeySetBufferingEndIgnoreVideo;
    public a<Integer> VeLivePlayerKeySetDefaultBufferingEndMs;
    public a<Integer> VeLivePlayerKeySetHWAsyncMode;
    public a<Integer> VeLivePlayerKeySetHardwareDecode;
    public a<Integer> VeLivePlayerKeySetHurryEnable;
    public a<Float> VeLivePlayerKeySetHurrySpeed;
    public a<Integer> VeLivePlayerKeySetHurryTime;
    public a<Integer> VeLivePlayerKeySetKernelOpenFailRetry;
    public a<Integer> VeLivePlayerKeySetMaxCacheSeconds;
    public a<Integer> VeLivePlayerKeySetNTPEnable;
    public a<Integer> VeLivePlayerKeySetOpenTextureRender;
    public a<Integer> VeLivePlayerKeySetOptimizeLivePtsRollback;
    public a<Integer> VeLivePlayerKeySetReportApplogEnable;
    public a<Integer> VeLivePlayerKeySetReportKernelLogEnable;
    public a<Float> VeLivePlayerKeySetSlowSpeed;
    public a<Integer> VeLivePlayerKeySetSlowTime;
    public a<Integer> VeLivePlayerKeySetSoftwareDecodeForidden;
    public a<Integer> VeLivePlayerKeySetStartPlayAudioBufferThresholdMs;
    public a<Integer> mergeStrategyConfigLevel;

    public PlayerConfig() {
        this.VeLivePlayerKeySetHWAsyncMode = new a(0);
        this.VeLivePlayerKeySetMaxCacheSeconds = new a(10);
        this.VeLivePlayerKeySetDefaultBufferingEndMs = new a(-1);
        this.VeLivePlayerKeySetBufferingEndIgnoreVideo = new a(0);
        this.VeLivePlayerKeySetStartPlayAudioBufferThresholdMs = new a(0);
        this.VeLivePlayerKeySetKernelOpenFailRetry = new a(-1);
        this.VeLivePlayerKeySetABRAlgorithm = new a(0);
        this.VeLivePlayerKeySetOpenTextureRender = new a(-1);
        this.VeLivePlayerKeySetNTPEnable = new a(1);
        this.VeLivePlayerKeySetHardwareDecode = new a(0);
        this.VeLivePlayerKeySetSoftwareDecodeForidden = new a(1);
        this.VeLivePlayerKeySetHurryEnable = new a(0);
        this.VeLivePlayerKeySetHurryTime = new a(2000);
        this.VeLivePlayerKeySetHurrySpeed = new a(Float.valueOf(1.2f));
        this.VeLivePlayerKeySetSlowTime = new a(200);
        this.VeLivePlayerKeySetSlowSpeed = new a(Float.valueOf(0.9f));
        this.VeLivePlayerKeySetReportApplogEnable = new a(1);
        this.VeLivePlayerKeySetReportKernelLogEnable = new a(0);
        this.SRConfig = new PlayerConfigParams.NNSRParams();
        this.VeLivePlayerKeySetOptimizeLivePtsRollback = new a(0);
        this.mergeStrategyConfigLevel = new a(0);
    }
}
