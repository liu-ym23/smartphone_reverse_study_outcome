package com.larus.avlink.simulInterpret.page.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/AREA;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AREA extends Enum<AREA> {
    public static final AREA BOTTOM = null;
    public static final AREA TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AREA[] f294482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294483b = null;

    public static EnumEntries<AREA> getEntries() {
        return f294483b;
    }

    static {
        AREA r100 = new AREA("TOP", 0);
        TOP = r100;
        AREA r101 = new AREA("BOTTOM", 1);
        BOTTOM = r101;
        AREA[] r102 = {r100, r101};
        f294482a = r102;
        f294483b = EnumEntriesKt.enumEntries(r102);
    }

    public static AREA[] values() {
        return (AREA[]) f294482a.clone();
    }

    public static AREA valueOf(String r100) {
        return (AREA) r27.a.a(AREA.class, r100);
    }

    public AREA(String r100, int r101) {
        super(r100, r101);
    }
}
