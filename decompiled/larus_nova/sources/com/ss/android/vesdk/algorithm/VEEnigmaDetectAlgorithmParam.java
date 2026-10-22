package com.ss.android.vesdk.algorithm;

/* JADX INFO: loaded from: classes40.dex */
public class VEEnigmaDetectAlgorithmParam extends VEBaseAlgorithmParam {
    public static long REQUIREMENT_ENIGMA_DETECT = 65536;
    public int codeType;
    public boolean decodeMultiple;
    public float detectRectHeight;
    public float detectRectLeft;
    public float detectRectTop;
    public float detectRectWidth;
    public long detectRequirement;
    public boolean enableDetectRect;
    public boolean enhanceCamera;
    public int scanMode;

    public VEEnigmaDetectAlgorithmParam() {
        this.detectRectLeft = 0.0f;
        this.detectRectTop = 0.0f;
        this.detectRectWidth = 0.0f;
        this.detectRectHeight = 0.0f;
        this.enableDetectRect = false;
        this.scanMode = 0;
        this.detectRequirement = REQUIREMENT_ENIGMA_DETECT;
        this.codeType = 0;
        this.decodeMultiple = false;
        this.enhanceCamera = false;
        setAlgorithmType(7);
        setAlgorithmName("Enigma Detect");
    }
}
