package com.bytedance.ee.bear.office.export.space;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevel;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "DB", "NETWORK", "UI", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadLevel extends Enum<OfficeSpacePreloadLevel> implements Serializable {
    public static final OfficeSpacePreloadLevel DB = null;
    public static final OfficeSpacePreloadLevel INIT = null;
    public static final OfficeSpacePreloadLevel NETWORK = null;
    public static final OfficeSpacePreloadLevel UI = null;
    public static final /* synthetic */ OfficeSpacePreloadLevel[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<OfficeSpacePreloadLevel> getEntries() {
        return b;
    }

    static {
        OfficeSpacePreloadLevel r0 = new OfficeSpacePreloadLevel("INIT", 0);
        INIT = r0;
        OfficeSpacePreloadLevel r1 = new OfficeSpacePreloadLevel("DB", 1);
        DB = r1;
        OfficeSpacePreloadLevel r3 = new OfficeSpacePreloadLevel("NETWORK", 2);
        NETWORK = r3;
        OfficeSpacePreloadLevel r5 = new OfficeSpacePreloadLevel("UI", 3);
        UI = r5;
        OfficeSpacePreloadLevel[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static OfficeSpacePreloadLevel[] values() {
        return (OfficeSpacePreloadLevel[]) a.clone();
    }

    public static OfficeSpacePreloadLevel valueOf(String r1) {
        return (OfficeSpacePreloadLevel) r27.a.a(OfficeSpacePreloadLevel.class, r1);
    }

    public OfficeSpacePreloadLevel(String r1, int r2) {
        super(r1, r2);
    }
}
