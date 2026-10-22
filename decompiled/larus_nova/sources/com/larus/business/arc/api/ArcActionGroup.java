package com.larus.business.arc.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/business/arc/api/ArcActionGroup;", "", "id", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "BASE", "SETTINGS", "KEVA", "ACCOUNT", "TELEMETRY", "NETWORK", "CHAT", "AUDIO", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ArcActionGroup extends Enum<ArcActionGroup> {
    public static final ArcActionGroup ACCOUNT = null;
    public static final ArcActionGroup AUDIO = null;
    public static final ArcActionGroup BASE = null;
    public static final ArcActionGroup CHAT = null;
    public static final ArcActionGroup KEVA = null;
    public static final ArcActionGroup NETWORK = null;
    public static final ArcActionGroup SETTINGS = null;
    public static final ArcActionGroup TELEMETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArcActionGroup[] f319832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f319833b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f319834id;

    public static EnumEntries<ArcActionGroup> getEntries() {
        return f319833b;
    }

    static {
        ArcActionGroup r100 = new ArcActionGroup("BASE", 0, "base");
        BASE = r100;
        ArcActionGroup r101 = new ArcActionGroup("SETTINGS", 1, "settings");
        SETTINGS = r101;
        ArcActionGroup r102 = new ArcActionGroup("KEVA", 2, "keva");
        KEVA = r102;
        ArcActionGroup r103 = new ArcActionGroup("ACCOUNT", 3, "account");
        ACCOUNT = r103;
        ArcActionGroup r104 = new ArcActionGroup("TELEMETRY", 4, "telemetry");
        TELEMETRY = r104;
        ArcActionGroup r105 = new ArcActionGroup("NETWORK", 5, "network");
        NETWORK = r105;
        ArcActionGroup r110 = new ArcActionGroup("CHAT", 6, "chat");
        CHAT = r110;
        ArcActionGroup r111 = new ArcActionGroup("AUDIO", 7, "audio");
        AUDIO = r111;
        ArcActionGroup[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f319832a = r112;
        f319833b = EnumEntriesKt.enumEntries(r112);
    }

    public static ArcActionGroup[] values() {
        return (ArcActionGroup[]) f319832a.clone();
    }

    public final String getId() {
        return this.f319834id;
    }

    public static ArcActionGroup valueOf(String r100) {
        return (ArcActionGroup) r27.a.a(ArcActionGroup.class, r100);
    }

    public ArcActionGroup(String r100, int r101, String r102) {
        super(r100, r101);
        this.f319834id = r102;
    }
}
