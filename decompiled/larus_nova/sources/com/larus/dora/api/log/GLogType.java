package com.larus.dora.api.log;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/dora/api/log/GLogType;", "", "id", "", "type", "", "<init>", "(Ljava/lang/String;IBLjava/lang/String;)V", "getId", "()B", "getType", "()Ljava/lang/String;", "SYSLOG", "POINT", "CORE_DUMP", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GLogType extends Enum<GLogType> {
    public static final GLogType CORE_DUMP = null;
    public static final a Companion = null;
    public static final GLogType POINT = null;
    public static final GLogType SYSLOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GLogType[] f331743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331744b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final byte f331745id;
    private final String type;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<GLogType> getEntries() {
        return f331744b;
    }

    static {
        GLogType r100 = new GLogType("SYSLOG", 0, (byte) 0, "Syslog");
        SYSLOG = r100;
        GLogType r101 = new GLogType("POINT", 1, (byte) 1, "Point");
        POINT = r101;
        GLogType r102 = new GLogType("CORE_DUMP", 2, (byte) 2, "CoreDump");
        CORE_DUMP = r102;
        GLogType[] r103 = {r100, r101, r102};
        f331743a = r103;
        f331744b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static GLogType[] values() {
        return (GLogType[]) f331743a.clone();
    }

    public final byte getId() {
        return this.f331745id;
    }

    public final String getType() {
        return this.type;
    }

    public static GLogType valueOf(String r100) {
        return (GLogType) r27.a.a(GLogType.class, r100);
    }

    public GLogType(String r100, int r101, byte r102, String r103) {
        super(r100, r101);
        this.f331745id = r102;
        this.type = r103;
    }
}
