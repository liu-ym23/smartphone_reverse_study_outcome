package com.bytedance.locallife.photo.album.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/AlbumReportMode;", "", "", "value", "I", "getValue", "()I", "OPEN", "CLOSE", "locallife-photo-api_release"}, k = 1, mv = {1, 4, 3})
public final enum AlbumReportMode extends Enum<AlbumReportMode> {
    public static final AlbumReportMode CLOSE = null;
    public static final AlbumReportMode OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumReportMode[] f261967a = null;
    private final int value;

    public static AlbumReportMode valueOf(String r100) {
        return (AlbumReportMode) r27.a.a(AlbumReportMode.class, r100);
    }

    public static AlbumReportMode[] values() {
        return (AlbumReportMode[]) f261967a.clone();
    }

    static {
        AlbumReportMode r100 = new AlbumReportMode("OPEN", 0, 1);
        OPEN = r100;
        AlbumReportMode r101 = new AlbumReportMode("CLOSE", 1, 2);
        CLOSE = r101;
        f261967a = new AlbumReportMode[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public AlbumReportMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
