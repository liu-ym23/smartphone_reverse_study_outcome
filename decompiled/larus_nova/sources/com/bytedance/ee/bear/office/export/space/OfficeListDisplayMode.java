package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeListDisplayMode;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "LIST", "GRID", "FLOW", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeListDisplayMode extends Enum<OfficeListDisplayMode> implements Serializable {
    public static final OfficeListDisplayMode FLOW = null;
    public static final OfficeListDisplayMode GRID = null;
    public static final OfficeListDisplayMode LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeListDisplayMode[] f235451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235452b = null;

    public static EnumEntries<OfficeListDisplayMode> getEntries() {
        return f235452b;
    }

    static {
        OfficeListDisplayMode r100 = new OfficeListDisplayMode("LIST", 0);
        LIST = r100;
        OfficeListDisplayMode r101 = new OfficeListDisplayMode("GRID", 1);
        GRID = r101;
        OfficeListDisplayMode r102 = new OfficeListDisplayMode("FLOW", 2);
        FLOW = r102;
        OfficeListDisplayMode[] r103 = {r100, r101, r102};
        f235451a = r103;
        f235452b = EnumEntriesKt.enumEntries(r103);
    }

    public static OfficeListDisplayMode[] values() {
        return (OfficeListDisplayMode[]) f235451a.clone();
    }

    public static OfficeListDisplayMode valueOf(String r100) {
        return (OfficeListDisplayMode) r27.a.a(OfficeListDisplayMode.class, r100);
    }

    public OfficeListDisplayMode(String r100, int r101) {
        super(r100, r101);
    }
}
