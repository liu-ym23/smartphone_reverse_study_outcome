package com.larus.dora.impl.core.settingsconfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/core/settingsconfig/DoraXLinkTransportMode;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "BLUETOOTH", "WIFI", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraXLinkTransportMode extends Enum<DoraXLinkTransportMode> {
    public static final DoraXLinkTransportMode BLUETOOTH = null;
    public static final a Companion = null;
    public static final DoraXLinkTransportMode OFF = null;
    public static final DoraXLinkTransportMode WIFI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraXLinkTransportMode[] f332265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f332266b = null;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<DoraXLinkTransportMode> getEntries() {
        return f332266b;
    }

    static {
        DoraXLinkTransportMode r100 = new DoraXLinkTransportMode("OFF", 0);
        OFF = r100;
        DoraXLinkTransportMode r101 = new DoraXLinkTransportMode("BLUETOOTH", 1);
        BLUETOOTH = r101;
        DoraXLinkTransportMode r102 = new DoraXLinkTransportMode("WIFI", 2);
        WIFI = r102;
        DoraXLinkTransportMode[] r103 = {r100, r101, r102};
        f332265a = r103;
        f332266b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static DoraXLinkTransportMode[] values() {
        return (DoraXLinkTransportMode[]) f332265a.clone();
    }

    public static DoraXLinkTransportMode valueOf(String r100) {
        return (DoraXLinkTransportMode) r27.a.a(DoraXLinkTransportMode.class, r100);
    }

    public DoraXLinkTransportMode(String r100, int r101) {
        super(r100, r101);
    }
}
