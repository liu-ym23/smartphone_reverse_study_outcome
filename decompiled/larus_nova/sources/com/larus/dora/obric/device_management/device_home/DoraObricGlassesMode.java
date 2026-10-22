package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/obric/device_management/device_home/DoraObricGlassesMode;", "", "<init>", "(Ljava/lang/String;I)V", "ASSISTANT", "HEADPHONE", "UNKNOWN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraObricGlassesMode extends Enum<DoraObricGlassesMode> {
    public static final DoraObricGlassesMode ASSISTANT = null;
    public static final DoraObricGlassesMode HEADPHONE = null;
    public static final DoraObricGlassesMode UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraObricGlassesMode[] f339157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f339158b = null;

    public static EnumEntries<DoraObricGlassesMode> getEntries() {
        return f339158b;
    }

    static {
        DoraObricGlassesMode r100 = new DoraObricGlassesMode("ASSISTANT", 0);
        ASSISTANT = r100;
        DoraObricGlassesMode r101 = new DoraObricGlassesMode("HEADPHONE", 1);
        HEADPHONE = r101;
        DoraObricGlassesMode r102 = new DoraObricGlassesMode("UNKNOWN", 2);
        UNKNOWN = r102;
        DoraObricGlassesMode[] r103 = {r100, r101, r102};
        f339157a = r103;
        f339158b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraObricGlassesMode[] values() {
        return (DoraObricGlassesMode[]) f339157a.clone();
    }

    public static DoraObricGlassesMode valueOf(String r100) {
        return (DoraObricGlassesMode) r27.a.a(DoraObricGlassesMode.class, r100);
    }

    public DoraObricGlassesMode(String r100, int r101) {
        super(r100, r101);
    }
}
