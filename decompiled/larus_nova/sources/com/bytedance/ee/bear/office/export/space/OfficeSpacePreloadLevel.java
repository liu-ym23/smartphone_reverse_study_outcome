package com.bytedance.ee.bear.office.export.space;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/office/export/space/OfficeSpacePreloadLevel;", "Ljava/io/Serializable;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "DB", "NETWORK", "UI", "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeSpacePreloadLevel extends Enum<OfficeSpacePreloadLevel> implements Serializable {
    public static final OfficeSpacePreloadLevel DB = null;
    public static final OfficeSpacePreloadLevel INIT = null;
    public static final OfficeSpacePreloadLevel NETWORK = null;
    public static final OfficeSpacePreloadLevel UI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeSpacePreloadLevel[] f235465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235466b = null;

    public static EnumEntries<OfficeSpacePreloadLevel> getEntries() {
        return f235466b;
    }

    static {
        OfficeSpacePreloadLevel r100 = new OfficeSpacePreloadLevel(ErrorCode.INIT, 0);
        INIT = r100;
        OfficeSpacePreloadLevel r101 = new OfficeSpacePreloadLevel("DB", 1);
        DB = r101;
        OfficeSpacePreloadLevel r102 = new OfficeSpacePreloadLevel("NETWORK", 2);
        NETWORK = r102;
        OfficeSpacePreloadLevel r103 = new OfficeSpacePreloadLevel("UI", 3);
        UI = r103;
        OfficeSpacePreloadLevel[] r104 = {r100, r101, r102, r103};
        f235465a = r104;
        f235466b = EnumEntriesKt.enumEntries(r104);
    }

    public static OfficeSpacePreloadLevel[] values() {
        return (OfficeSpacePreloadLevel[]) f235465a.clone();
    }

    public static OfficeSpacePreloadLevel valueOf(String r100) {
        return (OfficeSpacePreloadLevel) r27.a.a(OfficeSpacePreloadLevel.class, r100);
    }

    public OfficeSpacePreloadLevel(String r100, int r101) {
        super(r100, r101);
    }
}
