package com.bytedance.ee.bear.drive.core.thumbnail;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailRemoteSource;", "", "<init>", "(Ljava/lang/String;I)V", "COVER", "PREVIEW", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveThumbnailRemoteSource extends Enum<DriveThumbnailRemoteSource> {
    public static final DriveThumbnailRemoteSource COVER = null;
    public static final DriveThumbnailRemoteSource PREVIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DriveThumbnailRemoteSource[] f224319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f224320b = null;

    public static EnumEntries<DriveThumbnailRemoteSource> getEntries() {
        return f224320b;
    }

    static {
        DriveThumbnailRemoteSource r100 = new DriveThumbnailRemoteSource("COVER", 0);
        COVER = r100;
        DriveThumbnailRemoteSource r101 = new DriveThumbnailRemoteSource("PREVIEW", 1);
        PREVIEW = r101;
        DriveThumbnailRemoteSource[] r102 = {r100, r101};
        f224319a = r102;
        f224320b = EnumEntriesKt.enumEntries(r102);
    }

    public static DriveThumbnailRemoteSource[] values() {
        return (DriveThumbnailRemoteSource[]) f224319a.clone();
    }

    public static DriveThumbnailRemoteSource valueOf(String r100) {
        return (DriveThumbnailRemoteSource) r27.a.a(DriveThumbnailRemoteSource.class, r100);
    }

    public DriveThumbnailRemoteSource(String r100, int r101) {
        super(r100, r101);
    }
}
