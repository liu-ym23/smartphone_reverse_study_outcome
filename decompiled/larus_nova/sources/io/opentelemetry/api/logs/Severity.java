package io.opentelemetry.api.logs;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum Severity extends Enum<Severity> {
    public static final Severity DEBUG = null;
    public static final Severity DEBUG2 = null;
    public static final Severity DEBUG3 = null;
    public static final Severity DEBUG4 = null;
    public static final Severity ERROR = null;
    public static final Severity ERROR2 = null;
    public static final Severity ERROR3 = null;
    public static final Severity ERROR4 = null;
    public static final Severity FATAL = null;
    public static final Severity FATAL2 = null;
    public static final Severity FATAL3 = null;
    public static final Severity FATAL4 = null;
    public static final Severity INFO = null;
    public static final Severity INFO2 = null;
    public static final Severity INFO3 = null;
    public static final Severity INFO4 = null;
    public static final Severity TRACE = null;
    public static final Severity TRACE2 = null;
    public static final Severity TRACE3 = null;
    public static final Severity TRACE4 = null;
    public static final Severity UNDEFINED_SEVERITY_NUMBER = null;
    public static final Severity WARN = null;
    public static final Severity WARN2 = null;
    public static final Severity WARN3 = null;
    public static final Severity WARN4 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Severity[] f492681a = null;
    private final int severityNumber;

    static {
        Severity r100 = new Severity("UNDEFINED_SEVERITY_NUMBER", 0, 0);
        UNDEFINED_SEVERITY_NUMBER = r100;
        Severity r101 = new Severity("TRACE", 1, 1);
        TRACE = r101;
        Severity r102 = new Severity("TRACE2", 2, 2);
        TRACE2 = r102;
        Severity r103 = new Severity("TRACE3", 3, 3);
        TRACE3 = r103;
        Severity r104 = new Severity("TRACE4", 4, 4);
        TRACE4 = r104;
        Severity r105 = new Severity("DEBUG", 5, 5);
        DEBUG = r105;
        Severity r110 = new Severity("DEBUG2", 6, 6);
        DEBUG2 = r110;
        Severity r111 = new Severity("DEBUG3", 7, 7);
        DEBUG3 = r111;
        Severity r112 = new Severity("DEBUG4", 8, 8);
        DEBUG4 = r112;
        Severity r113 = new Severity("INFO", 9, 9);
        INFO = r113;
        Severity r114 = new Severity("INFO2", 10, 10);
        INFO2 = r114;
        Severity r115 = new Severity("INFO3", 11, 11);
        INFO3 = r115;
        Severity r106 = new Severity("INFO4", 12, 12);
        INFO4 = r106;
        Severity r107 = new Severity("WARN", 13, 13);
        WARN = r107;
        Severity r108 = new Severity("WARN2", 14, 14);
        WARN2 = r108;
        Severity r109 = new Severity("WARN3", 15, 15);
        WARN3 = r109;
        Severity r116 = new Severity("WARN4", 16, 16);
        WARN4 = r116;
        Severity r117 = new Severity("ERROR", 17, 17);
        ERROR = r117;
        Severity r118 = new Severity("ERROR2", 18, 18);
        ERROR2 = r118;
        Severity r119 = new Severity("ERROR3", 19, 19);
        ERROR3 = r119;
        Severity r120 = new Severity("ERROR4", 20, 20);
        ERROR4 = r120;
        Severity r121 = new Severity(SpeechEngineDefines.LOG_LEVEL_FATAL, 21, 21);
        FATAL = r121;
        Severity r122 = new Severity("FATAL2", 22, 22);
        FATAL2 = r122;
        Severity r123 = new Severity("FATAL3", 23, 23);
        FATAL3 = r123;
        Severity r124 = new Severity("FATAL4", 24, 24);
        FATAL4 = r124;
        f492681a = new Severity[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124};
    }

    public static Severity[] values() {
        return (Severity[]) f492681a.clone();
    }

    public int getSeverityNumber() {
        return this.severityNumber;
    }

    public static Severity valueOf(String r100) {
        return (Severity) a.a(Severity.class, r100);
    }

    public Severity(String r100, int r101, int r102) {
        super(r100, r101);
        this.severityNumber = r102;
    }
}
