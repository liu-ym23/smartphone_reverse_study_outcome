package com.bytedance.ee.bear.office.space;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/office/space/OfficeSpaceTabAlignment;", "", "<init>", "(Ljava/lang/String;I)V", "CENTER", GXAnimation.STATE_START, "office-space_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpaceTabAlignment extends Enum<OfficeSpaceTabAlignment> {
    public static final OfficeSpaceTabAlignment CENTER = null;
    public static final OfficeSpaceTabAlignment START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpaceTabAlignment[] f236075a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f236076b = null;

    public static EnumEntries<OfficeSpaceTabAlignment> getEntries() {
        return f236076b;
    }

    static {
        OfficeSpaceTabAlignment r100 = new OfficeSpaceTabAlignment("CENTER", 0);
        CENTER = r100;
        OfficeSpaceTabAlignment r101 = new OfficeSpaceTabAlignment(GXAnimation.STATE_START, 1);
        START = r101;
        OfficeSpaceTabAlignment[] r102 = {r100, r101};
        f236075a = r102;
        f236076b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeSpaceTabAlignment[] values() {
        return (OfficeSpaceTabAlignment[]) f236075a.clone();
    }

    public static OfficeSpaceTabAlignment valueOf(String r100) {
        return (OfficeSpaceTabAlignment) r27.a.a(OfficeSpaceTabAlignment.class, r100);
    }

    public OfficeSpaceTabAlignment(String r100, int r101) {
        super(r100, r101);
    }
}
