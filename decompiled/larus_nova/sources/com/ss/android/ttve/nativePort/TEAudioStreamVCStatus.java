package com.ss.android.ttve.nativePort;

/* JADX INFO: loaded from: classes38.dex */
public final enum TEAudioStreamVCStatus extends Enum<TEAudioStreamVCStatus> {
    private static final /* synthetic */ TEAudioStreamVCStatus[] $VALUES = null;
    public static final TEAudioStreamVCStatus TEAudioStreamVC_onConnectClosed = null;
    public static final TEAudioStreamVCStatus TEAudioStreamVC_onConnectFailed = null;
    public static final TEAudioStreamVCStatus TEAudioStreamVC_onFailed = null;
    public static final TEAudioStreamVCStatus TEAudioStreamVC_onFinished = null;
    public static final TEAudioStreamVCStatus TEAudioStreamVC_onProcessing = null;
    public static final TEAudioStreamVCStatus TEAudioStreamVC_onStart = null;
    private final int value;

    private static /* synthetic */ TEAudioStreamVCStatus[] $values() {
        return new TEAudioStreamVCStatus[]{TEAudioStreamVC_onStart, TEAudioStreamVC_onProcessing, TEAudioStreamVC_onFinished, TEAudioStreamVC_onFailed, TEAudioStreamVC_onConnectClosed, TEAudioStreamVC_onConnectFailed};
    }

    static {
        TEAudioStreamVC_onStart = new TEAudioStreamVCStatus("TEAudioStreamVC_onStart", 0, 0);
        TEAudioStreamVC_onProcessing = new TEAudioStreamVCStatus("TEAudioStreamVC_onProcessing", 1, 1);
        TEAudioStreamVC_onFinished = new TEAudioStreamVCStatus("TEAudioStreamVC_onFinished", 2, 2);
        TEAudioStreamVC_onFailed = new TEAudioStreamVCStatus("TEAudioStreamVC_onFailed", 3, 3);
        TEAudioStreamVC_onConnectClosed = new TEAudioStreamVCStatus("TEAudioStreamVC_onConnectClosed", 4, 4);
        TEAudioStreamVC_onConnectFailed = new TEAudioStreamVCStatus("TEAudioStreamVC_onConnectFailed", 5, 5);
        $VALUES = $values();
    }

    public static TEAudioStreamVCStatus[] values() {
        return (TEAudioStreamVCStatus[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static TEAudioStreamVCStatus valueOf(String r100) {
        return (TEAudioStreamVCStatus) r27.a.a(TEAudioStreamVCStatus.class, r100);
    }

    private TEAudioStreamVCStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
