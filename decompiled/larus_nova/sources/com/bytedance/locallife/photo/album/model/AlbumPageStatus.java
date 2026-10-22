package com.bytedance.locallife.photo.album.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/photo/album/model/AlbumPageStatus;", "", "", "status", "I", "getStatus", "()I", "LOOK", "ERROR_REPORT", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum AlbumPageStatus extends Enum<AlbumPageStatus> {
    public static final AlbumPageStatus ERROR_REPORT = null;
    public static final AlbumPageStatus LOOK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumPageStatus[] f261966a = null;
    private final int status;

    public static AlbumPageStatus valueOf(String r100) {
        return (AlbumPageStatus) r27.a.a(AlbumPageStatus.class, r100);
    }

    public static AlbumPageStatus[] values() {
        return (AlbumPageStatus[]) f261966a.clone();
    }

    static {
        AlbumPageStatus r100 = new AlbumPageStatus("LOOK", 0, 0);
        LOOK = r100;
        AlbumPageStatus r101 = new AlbumPageStatus("ERROR_REPORT", 1, 1);
        ERROR_REPORT = r101;
        f261966a = new AlbumPageStatus[]{r100, r101};
    }

    public final int getStatus() {
        return this.status;
    }

    public AlbumPageStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
