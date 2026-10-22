package com.ss.android.lark.opmonitor.model;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum OPMonitorLevel extends Enum<OPMonitorLevel> {
    private static final /* synthetic */ OPMonitorLevel[] $VALUES = null;
    public static final OPMonitorLevel ERROR = null;
    public static final OPMonitorLevel FATAL = null;
    public static final OPMonitorLevel NORMAL = null;
    public static final OPMonitorLevel TRACE = null;
    public static final OPMonitorLevel UNKNOWN = null;
    public static final OPMonitorLevel WARN = null;
    private final int value;

    static {
        OPMonitorLevel r100 = new OPMonitorLevel("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        OPMonitorLevel r101 = new OPMonitorLevel("TRACE", 1, 1);
        TRACE = r101;
        OPMonitorLevel r102 = new OPMonitorLevel(EffectConstants.NORMAL, 2, 2);
        NORMAL = r102;
        OPMonitorLevel r103 = new OPMonitorLevel("WARN", 3, 3);
        WARN = r103;
        OPMonitorLevel r104 = new OPMonitorLevel("ERROR", 4, 4);
        ERROR = r104;
        OPMonitorLevel r105 = new OPMonitorLevel(SpeechEngineDefines.LOG_LEVEL_FATAL, 5, 5);
        FATAL = r105;
        $VALUES = new OPMonitorLevel[]{r100, r101, r102, r103, r104, r105};
    }

    public static OPMonitorLevel[] values() {
        return (OPMonitorLevel[]) $VALUES.clone();
    }

    public final int getNumber() {
        return this.value;
    }

    public static OPMonitorLevel forNumber(int r100) {
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
        return NORMAL;
    L23:
        return TRACE;
    }

    public static OPMonitorLevel valueOf(String r100) {
        return (OPMonitorLevel) a.a(OPMonitorLevel.class, r100);
    }

    private OPMonitorLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
