package com.mammon.samicorenui;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreAudioTracker$Status extends Enum<SAMICoreAudioTracker$Status> {
    public static final SAMICoreAudioTracker$Status STATUS_NO_READY = null;
    public static final SAMICoreAudioTracker$Status STATUS_READY = null;
    public static final SAMICoreAudioTracker$Status STATUS_START = null;
    public static final SAMICoreAudioTracker$Status STATUS_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SAMICoreAudioTracker$Status[] f384365a = null;

    static {
        SAMICoreAudioTracker$Status r100 = new SAMICoreAudioTracker$Status("STATUS_NO_READY", 0);
        STATUS_NO_READY = r100;
        SAMICoreAudioTracker$Status r101 = new SAMICoreAudioTracker$Status("STATUS_READY", 1);
        STATUS_READY = r101;
        SAMICoreAudioTracker$Status r102 = new SAMICoreAudioTracker$Status("STATUS_START", 2);
        STATUS_START = r102;
        SAMICoreAudioTracker$Status r103 = new SAMICoreAudioTracker$Status("STATUS_STOP", 3);
        STATUS_STOP = r103;
        f384365a = new SAMICoreAudioTracker$Status[]{r100, r101, r102, r103};
    }

    public static SAMICoreAudioTracker$Status[] values() {
        return (SAMICoreAudioTracker$Status[]) f384365a.clone();
    }

    public static SAMICoreAudioTracker$Status valueOf(String r100) {
        return (SAMICoreAudioTracker$Status) a.a(SAMICoreAudioTracker$Status.class, r100);
    }

    public SAMICoreAudioTracker$Status(String r100, int r101) {
        super(r100, r101);
    }
}
