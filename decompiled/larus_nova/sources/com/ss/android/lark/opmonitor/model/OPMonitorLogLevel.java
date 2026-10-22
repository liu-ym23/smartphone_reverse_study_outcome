package com.ss.android.lark.opmonitor.model;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum OPMonitorLogLevel extends Enum<OPMonitorLogLevel> {
    public static final OPMonitorLogLevel DEBUG = null;
    public static final OPMonitorLogLevel ERROR = null;
    public static final OPMonitorLogLevel FATAL = null;
    public static final OPMonitorLogLevel INFO = null;
    public static final OPMonitorLogLevel UNKNOWN = null;
    public static final OPMonitorLogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OPMonitorLogLevel[] f437601a = null;
    private final int value;

    static {
        OPMonitorLogLevel r100 = new OPMonitorLogLevel("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        OPMonitorLogLevel r101 = new OPMonitorLogLevel("DEBUG", 1, 1);
        DEBUG = r101;
        OPMonitorLogLevel r102 = new OPMonitorLogLevel("INFO", 2, 2);
        INFO = r102;
        OPMonitorLogLevel r103 = new OPMonitorLogLevel("WARN", 3, 3);
        WARN = r103;
        OPMonitorLogLevel r104 = new OPMonitorLogLevel("ERROR", 4, 4);
        ERROR = r104;
        OPMonitorLogLevel r105 = new OPMonitorLogLevel(SpeechEngineDefines.LOG_LEVEL_FATAL, 5, 5);
        FATAL = r105;
        f437601a = new OPMonitorLogLevel[]{r100, r101, r102, r103, r104, r105};
    }

    public static OPMonitorLogLevel[] values() {
        return (OPMonitorLogLevel[]) f437601a.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public static OPMonitorLogLevel forNumber(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 5) goto L15;
        return UNKNOWN;
    L15:
        return FATAL;
    L17:
        return ERROR;
    L19:
        return WARN;
    L21:
        return INFO;
    L23:
        return DEBUG;
    }

    public static OPMonitorLogLevel valueOf(String r100) {
        return (OPMonitorLogLevel) a.a(OPMonitorLogLevel.class, r100);
    }

    public OPMonitorLogLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
