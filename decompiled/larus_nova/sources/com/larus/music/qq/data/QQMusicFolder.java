package com.larus.music.qq.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JG\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/music/qq/data/QQMusicFolder;", "", "type", "", "id", "", "mainTitle", "subTitle", "picUrl", "isSongFolder", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getType", "()I", "getId", "()Ljava/lang/String;", "getMainTitle", "getSubTitle", "getPicUrl", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QQMusicFolder {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f359525id;
    private final boolean isSongFolder;
    private final String mainTitle;
    private final String picUrl;
    private final String subTitle;
    private final int type;

    public QQMusicFolder() {
        this(0, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ QQMusicFolder copy$default(QQMusicFolder r100, int r101, String r102, String r103, String r104, String r105, boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f359525id;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.mainTitle;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.subTitle;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.picUrl;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.isSongFolder;
    L20:
        int r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.f359525id;
    }

    public final String component3() {
        return this.mainTitle;
    }

    public final String component4() {
        return this.subTitle;
    }

    public final String component5() {
        return this.picUrl;
    }

    public final boolean component6() {
        return this.isSongFolder;
    }

    public final QQMusicFolder copy(int r100, String r110, String r111, String r112, String r113, boolean r114) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "mainTitle");
        Intrinsics.checkNotNullParameter(r113, "picUrl");
        return new QQMusicFolder(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QQMusicFolder) == true) goto L8;
        return false;
    L8:
        QQMusicFolder r101 = (QQMusicFolder) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f359525id, r101.f359525id) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.picUrl, r101.picUrl) == true) goto L24;
        return false;
    L24:
        if (this.isSongFolder == r101.isSongFolder) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.type * 31) + this.f359525id.hashCode()) * 31) + this.mainTitle.hashCode()) * 31;
        String r101 = this.subTitle;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.picUrl.hashCode()) * 31;
        if (this.isSongFolder == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "QQMusicFolder(type=" + this.type + ", id=" + this.f359525id + ", mainTitle=" + this.mainTitle + ", subTitle=" + this.subTitle + ", picUrl=" + this.picUrl + ", isSongFolder=" + this.isSongFolder + ')';
    }

    public final String getId() {
        return this.f359525id;
    }

    public final String getMainTitle() {
        return this.mainTitle;
    }

    public final String getPicUrl() {
        return this.picUrl;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isSongFolder() {
        return this.isSongFolder;
    }

    public QQMusicFolder(int r100, String r101, String r102, String r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "mainTitle");
        Intrinsics.checkNotNullParameter(r104, "picUrl");
        this.type = r100;
        this.f359525id = r101;
        this.mainTitle = r102;
        this.subTitle = r103;
        this.picUrl = r104;
        this.isSongFolder = r105;
    }

    public /* synthetic */ QQMusicFolder(int r100, String r101, String r102, String r103, String r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        int r114 = 0;
    L6:
        String r104 = "";
        if ((r112 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r112 & 16) != 0) goto L23;
        r104 = r110;
    L23:
        if ((r112 & 32) == 0) goto L25;
        boolean r115 = false;
    L26:
        this(r114, r105, r106, r107, r104, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L6
    }
}
