package com.larus.dora.impl.guide.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/guide/common/DoraGuideMeta;", "", "guideType", "", "guideId", "<init>", "(Ljava/lang/String;III)V", "getGuideType", "()I", "getGuideId", "DoraBtPermissionGuide", "DoraBindGuide", "DoraKeepAliveGuide", "DoraConnectDeviceGuide", "DoraDNULostUserGuide", "DoraNotificationGuide", "DoraBatteryGuide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraGuideMeta extends Enum<DoraGuideMeta> {
    public static final a Companion = null;
    public static final DoraGuideMeta DoraBatteryGuide = null;
    public static final DoraGuideMeta DoraBindGuide = null;
    public static final DoraGuideMeta DoraBtPermissionGuide = null;
    public static final DoraGuideMeta DoraConnectDeviceGuide = null;
    public static final DoraGuideMeta DoraDNULostUserGuide = null;
    public static final DoraGuideMeta DoraKeepAliveGuide = null;
    public static final DoraGuideMeta DoraNotificationGuide = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraGuideMeta[] f335928a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335929b = null;
    private final int guideId;
    private final int guideType;

    public static EnumEntries<DoraGuideMeta> getEntries() {
        return f335929b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.guide.common.DoraGuideMeta$a] */
    static {
        DoraGuideMeta r100 = new DoraGuideMeta("DoraBtPermissionGuide", 0, GuideType.PERMISSION.getType(), 0);
        DoraBtPermissionGuide = r100;
        GuideType r101 = GuideType.BOTTOM_SHEET;
        DoraGuideMeta r102 = new DoraGuideMeta("DoraBindGuide", 1, r101.getType(), 1);
        DoraBindGuide = r102;
        GuideType r103 = GuideType.BALLOON;
        DoraGuideMeta r104 = new DoraGuideMeta("DoraKeepAliveGuide", 2, r103.getType(), 2);
        DoraKeepAliveGuide = r104;
        DoraGuideMeta r105 = new DoraGuideMeta("DoraConnectDeviceGuide", 3, r103.getType(), 3);
        DoraConnectDeviceGuide = r105;
        DoraGuideMeta r106 = new DoraGuideMeta("DoraDNULostUserGuide", 4, r103.getType(), 4);
        DoraDNULostUserGuide = r106;
        DoraGuideMeta r110 = new DoraGuideMeta("DoraNotificationGuide", 5, r101.getType(), 5);
        DoraNotificationGuide = r110;
        DoraGuideMeta r107 = new DoraGuideMeta("DoraBatteryGuide", 6, r103.getType(), 6);
        DoraBatteryGuide = r107;
        DoraGuideMeta[] r108 = {r100, r102, r104, r105, r106, r110, r107};
        f335928a = r108;
        f335929b = EnumEntriesKt.enumEntries(r108);
        Companion = new a();
    }

    public static DoraGuideMeta[] values() {
        return (DoraGuideMeta[]) f335928a.clone();
    }

    public final int getGuideId() {
        return this.guideId;
    }

    public final int getGuideType() {
        return this.guideType;
    }

    public static DoraGuideMeta valueOf(String r100) {
        return (DoraGuideMeta) r27.a.a(DoraGuideMeta.class, r100);
    }

    public DoraGuideMeta(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.guideType = r102;
        this.guideId = r103;
    }
}
