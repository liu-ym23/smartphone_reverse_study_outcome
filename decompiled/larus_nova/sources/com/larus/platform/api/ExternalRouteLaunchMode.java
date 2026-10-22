package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/api/ExternalRouteLaunchMode;", "", "<init>", "(Ljava/lang/String;I)V", "COLD", "HOT", "WARM", "UNKNOWN", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalRouteLaunchMode extends Enum<ExternalRouteLaunchMode> {
    public static final ExternalRouteLaunchMode COLD = null;
    public static final ExternalRouteLaunchMode HOT = null;
    public static final ExternalRouteLaunchMode UNKNOWN = null;
    public static final ExternalRouteLaunchMode WARM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalRouteLaunchMode[] f364770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364771b = null;

    public static EnumEntries<ExternalRouteLaunchMode> getEntries() {
        return f364771b;
    }

    static {
        ExternalRouteLaunchMode r100 = new ExternalRouteLaunchMode("COLD", 0);
        COLD = r100;
        ExternalRouteLaunchMode r101 = new ExternalRouteLaunchMode("HOT", 1);
        HOT = r101;
        ExternalRouteLaunchMode r102 = new ExternalRouteLaunchMode("WARM", 2);
        WARM = r102;
        ExternalRouteLaunchMode r103 = new ExternalRouteLaunchMode("UNKNOWN", 3);
        UNKNOWN = r103;
        ExternalRouteLaunchMode[] r104 = {r100, r101, r102, r103};
        f364770a = r104;
        f364771b = EnumEntriesKt.enumEntries(r104);
    }

    public static ExternalRouteLaunchMode[] values() {
        return (ExternalRouteLaunchMode[]) f364770a.clone();
    }

    public static ExternalRouteLaunchMode valueOf(String r100) {
        return (ExternalRouteLaunchMode) r27.a.a(ExternalRouteLaunchMode.class, r100);
    }

    public ExternalRouteLaunchMode(String r100, int r101) {
        super(r100, r101);
    }
}
