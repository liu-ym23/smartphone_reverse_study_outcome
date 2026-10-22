package com.bytedance.platform.aio;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/platform/aio/Severity;", "", "DEBUG", "INFO", "ERROR", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum Severity extends Enum<Severity> {
    public static final Severity DEBUG = null;
    public static final Severity ERROR = null;
    public static final Severity INFO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Severity[] f266551a = null;

    static {
        Severity r100 = new Severity("DEBUG", 0);
        DEBUG = r100;
        Severity r101 = new Severity("INFO", 1);
        INFO = r101;
        Severity r102 = new Severity("ERROR", 2);
        ERROR = r102;
        f266551a = new Severity[]{r100, r101, r102};
    }

    public static Severity valueOf(String r100) {
        return (Severity) r27.a.a(Severity.class, r100);
    }

    public static Severity[] values() {
        return (Severity[]) f266551a.clone();
    }

    public Severity(String r100, int r101) {
        super(r100, r101);
    }
}
