package com.bytedance.ee.bear.drive.core.thumbnail;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/thumbnail/DriveThumbnailRemoteSource;", "", "<init>", "(Ljava/lang/String;I)V", "COVER", "PREVIEW", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DriveThumbnailRemoteSource extends Enum<DriveThumbnailRemoteSource> {
    public static final DriveThumbnailRemoteSource COVER = null;
    public static final DriveThumbnailRemoteSource PREVIEW = null;
    public static final /* synthetic */ DriveThumbnailRemoteSource[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DriveThumbnailRemoteSource> getEntries() {
        return b;
    }

    static {
        DriveThumbnailRemoteSource r0 = new DriveThumbnailRemoteSource("COVER", 0);
        COVER = r0;
        DriveThumbnailRemoteSource r1 = new DriveThumbnailRemoteSource("PREVIEW", 1);
        PREVIEW = r1;
        DriveThumbnailRemoteSource[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static DriveThumbnailRemoteSource[] values() {
        return (DriveThumbnailRemoteSource[]) a.clone();
    }

    public static DriveThumbnailRemoteSource valueOf(String r1) {
        return (DriveThumbnailRemoteSource) r27.a.a(DriveThumbnailRemoteSource.class, r1);
    }

    public DriveThumbnailRemoteSource(String r1, int r2) {
        super(r1, r2);
    }
}
