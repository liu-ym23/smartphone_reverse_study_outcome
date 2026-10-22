package com.larus.music.qq.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/larus/music/qq/data/QQMusicAlbum;", "", "coverUri", "", "id", "mid", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCoverUri", "()Ljava/lang/String;", "getId", "getMid", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QQMusicAlbum {
    private final String coverUri;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f359524id;
    private final String mid;
    private final String title;

    public static /* synthetic */ QQMusicAlbum copy$default(QQMusicAlbum r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.coverUri;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f359524id;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.mid;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.title;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.coverUri;
    }

    public final String component2() {
        return this.f359524id;
    }

    public final String component3() {
        return this.mid;
    }

    public final String component4() {
        return this.title;
    }

    public final QQMusicAlbum copy(String r100, String r101, String r102, String r103) {
        return new QQMusicAlbum(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QQMusicAlbum) == true) goto L8;
        return false;
    L8:
        QQMusicAlbum r101 = (QQMusicAlbum) r100;
        if (Intrinsics.areEqual(this.coverUri, r101.coverUri) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359524id, r101.f359524id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mid, r101.mid) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.coverUri;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f359524id;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mid;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.title;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "QQMusicAlbum(coverUri=" + this.coverUri + ", id=" + this.f359524id + ", mid=" + this.mid + ", title=" + this.title + ')';
    }

    public final String getCoverUri() {
        return this.coverUri;
    }

    public final String getId() {
        return this.f359524id;
    }

    public final String getMid() {
        return this.mid;
    }

    public final String getTitle() {
        return this.title;
    }

    public QQMusicAlbum(String r100, String r101, String r102, String r103) {
        this.coverUri = r100;
        this.f359524id = r101;
        this.mid = r102;
        this.title = r103;
    }
}
