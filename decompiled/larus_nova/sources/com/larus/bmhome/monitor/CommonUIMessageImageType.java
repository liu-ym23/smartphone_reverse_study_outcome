package com.larus.bmhome.monitor;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/monitor/CommonUIMessageImageType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonUIMessageImageType extends Enum<CommonUIMessageImageType> {
    public static final CommonUIMessageImageType IMAGE = null;
    public static final CommonUIMessageImageType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonUIMessageImageType[] f312709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312710b = null;

    public static EnumEntries<CommonUIMessageImageType> getEntries() {
        return f312710b;
    }

    static {
        CommonUIMessageImageType r100 = new CommonUIMessageImageType("IMAGE", 0);
        IMAGE = r100;
        CommonUIMessageImageType r101 = new CommonUIMessageImageType("VIDEO", 1);
        VIDEO = r101;
        CommonUIMessageImageType[] r102 = {r100, r101};
        f312709a = r102;
        f312710b = EnumEntriesKt.enumEntries(r102);
    }

    public static CommonUIMessageImageType[] values() {
        return (CommonUIMessageImageType[]) f312709a.clone();
    }

    public static CommonUIMessageImageType valueOf(String r100) {
        return (CommonUIMessageImageType) a.a(CommonUIMessageImageType.class, r100);
    }

    public CommonUIMessageImageType(String r100, int r101) {
        super(r100, r101);
    }
}
