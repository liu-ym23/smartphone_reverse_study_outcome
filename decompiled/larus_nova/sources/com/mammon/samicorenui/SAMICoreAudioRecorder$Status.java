package com.mammon.samicorenui;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum SAMICoreAudioRecorder$Status extends Enum<SAMICoreAudioRecorder$Status> {
    public static final SAMICoreAudioRecorder$Status STATUS_NO_READY = null;
    public static final SAMICoreAudioRecorder$Status STATUS_PAUSE = null;
    public static final SAMICoreAudioRecorder$Status STATUS_READY = null;
    public static final SAMICoreAudioRecorder$Status STATUS_START = null;
    public static final SAMICoreAudioRecorder$Status STATUS_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SAMICoreAudioRecorder$Status[] f384364a = null;

    static {
        SAMICoreAudioRecorder$Status r100 = new SAMICoreAudioRecorder$Status("STATUS_NO_READY", 0);
        STATUS_NO_READY = r100;
        SAMICoreAudioRecorder$Status r101 = new SAMICoreAudioRecorder$Status("STATUS_READY", 1);
        STATUS_READY = r101;
        SAMICoreAudioRecorder$Status r102 = new SAMICoreAudioRecorder$Status("STATUS_START", 2);
        STATUS_START = r102;
        SAMICoreAudioRecorder$Status r103 = new SAMICoreAudioRecorder$Status("STATUS_PAUSE", 3);
        STATUS_PAUSE = r103;
        SAMICoreAudioRecorder$Status r104 = new SAMICoreAudioRecorder$Status("STATUS_STOP", 4);
        STATUS_STOP = r104;
        f384364a = new SAMICoreAudioRecorder$Status[]{r100, r101, r102, r103, r104};
    }

    public static SAMICoreAudioRecorder$Status[] values() {
        return (SAMICoreAudioRecorder$Status[]) f384364a.clone();
    }

    public static SAMICoreAudioRecorder$Status valueOf(String r100) {
        return (SAMICoreAudioRecorder$Status) a.a(SAMICoreAudioRecorder$Status.class, r100);
    }

    public SAMICoreAudioRecorder$Status(String r100, int r101) {
        super(r100, r101);
    }
}
