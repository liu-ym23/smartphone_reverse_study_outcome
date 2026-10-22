package com.bytedance.ee.bear.bitable.card.view.membrane;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/membrane/MembraneAlignment;", "", "<init>", "(Ljava/lang/String;I)V", "ALIGN_BASELINE", "ALIGN_CENTER", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MembraneAlignment extends Enum<MembraneAlignment> {
    public static final MembraneAlignment ALIGN_BASELINE = null;
    public static final MembraneAlignment ALIGN_CENTER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MembraneAlignment[] f208457a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f208458b = null;

    public static EnumEntries<MembraneAlignment> getEntries() {
        return f208458b;
    }

    static {
        MembraneAlignment r100 = new MembraneAlignment("ALIGN_BASELINE", 0);
        ALIGN_BASELINE = r100;
        MembraneAlignment r101 = new MembraneAlignment("ALIGN_CENTER", 1);
        ALIGN_CENTER = r101;
        MembraneAlignment[] r102 = {r100, r101};
        f208457a = r102;
        f208458b = EnumEntriesKt.enumEntries(r102);
    }

    public static MembraneAlignment[] values() {
        return (MembraneAlignment[]) f208457a.clone();
    }

    public static MembraneAlignment valueOf(String r100) {
        return (MembraneAlignment) a.a(MembraneAlignment.class, r100);
    }

    public MembraneAlignment(String r100, int r101) {
        super(r100, r101);
    }
}
