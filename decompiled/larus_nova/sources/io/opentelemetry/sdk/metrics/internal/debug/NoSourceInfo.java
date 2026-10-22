package io.opentelemetry.sdk.metrics.internal.debug;

/* JADX INFO: loaded from: classes41.dex */
final enum NoSourceInfo extends Enum<NoSourceInfo> {
    public static final NoSourceInfo INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NoSourceInfo[] f492725a = null;

    public String shortDebugString() {
        return "unknown source";
    }

    static {
        NoSourceInfo r100 = new NoSourceInfo();
        INSTANCE = r100;
        f492725a = new NoSourceInfo[]{r100};
    }

    public NoSourceInfo() {
        super("INSTANCE", 0);
    }

    public static NoSourceInfo[] values() {
        return (NoSourceInfo[]) f492725a.clone();
    }

    public String multiLineDebugString() {
        int r100 = a.f492726a;
        return "\tat unknown source\n\t\tTo enable better debugging, run your JVM with -Dotel.experimental.sdk.metrics.debug=true";
    }

    public static NoSourceInfo valueOf(String r100) {
        return (NoSourceInfo) r27.a.a(NoSourceInfo.class, r100);
    }
}
