package com.larus.music.qq.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00104\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00106\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010&J°\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u00112\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u001aR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010'\u001a\u0004\b\u0010\u0010&R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010'\u001a\u0004\b\u0012\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b(\u0010\u001aR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010'\u001a\u0004\b)\u0010&¨\u0006="}, d2 = {"Lcom/larus/music/qq/data/QQMusicSong;", "", "album", "Lcom/larus/music/qq/data/QQMusicAlbum;", "duration", "", "genre", "", "id", "labelIdList", "", "mid", "singer", "Lcom/larus/music/qq/data/QQMusicSinger;", "title", "type", "isAudition", "", "isOrigin", "vipState", "hasCopyRight", "<init>", "(Lcom/larus/music/qq/data/QQMusicAlbum;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/music/qq/data/QQMusicSinger;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAlbum", "()Lcom/larus/music/qq/data/QQMusicAlbum;", "getDuration", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGenre", "()Ljava/lang/String;", "getId", "getLabelIdList", "()Ljava/util/List;", "getMid", "getSinger", "()Lcom/larus/music/qq/data/QQMusicSinger;", "getTitle", "getType", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getVipState", "getHasCopyRight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Lcom/larus/music/qq/data/QQMusicAlbum;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/larus/music/qq/data/QQMusicSinger;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)Lcom/larus/music/qq/data/QQMusicSong;", "equals", "other", "hashCode", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QQMusicSong {
    private final QQMusicAlbum album;
    private final Integer duration;
    private final String genre;
    private final Boolean hasCopyRight;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f359530id;
    private final Boolean isAudition;
    private final Boolean isOrigin;
    private final List<Integer> labelIdList;
    private final String mid;
    private final QQMusicSinger singer;
    private final String title;
    private final Integer type;
    private final Integer vipState;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QQMusicSong copy$default(QQMusicSong r110, QQMusicAlbum r111, Integer r112, String r113, String r114, List r115, String r210, QQMusicSinger r211, String r212, Integer r213, Boolean r214, Boolean r215, Integer r216, Boolean r217, int r218, Object r219) {
        if ((r218 & 1) == 0) goto L5;
        QQMusicAlbum r100 = r110.album;
    L7:
        if ((r218 & 2) == 0) goto L9;
        Integer r101 = r110.duration;
    L11:
        if ((r218 & 4) == 0) goto L13;
        String r102 = r110.genre;
    L15:
        if ((r218 & 8) == 0) goto L17;
        String r103 = r110.f359530id;
    L19:
        if ((r218 & 16) == 0) goto L21;
        List r104 = r110.labelIdList;
    L23:
        if ((r218 & 32) == 0) goto L25;
        String r105 = r110.mid;
    L27:
        if ((r218 & 64) == 0) goto L29;
        QQMusicSinger r106 = r110.singer;
    L31:
        if ((r218 & 128) == 0) goto L33;
        String r107 = r110.title;
    L35:
        if ((r218 & 256) == 0) goto L37;
        Integer r116 = r110.type;
    L39:
        if ((r218 & 512) == 0) goto L41;
        Boolean r117 = r110.isAudition;
    L43:
        if ((r218 & 1024) == 0) goto L45;
        Boolean r118 = r110.isOrigin;
    L47:
        if ((r218 & 2048) == 0) goto L49;
        Integer r119 = r110.vipState;
    L51:
        if ((r218 & 4096) == 0) goto L53;
        Boolean r108 = r110.hasCopyRight;
    L55:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118, r119, r108);
    L53:
        r108 = r217;
        goto L55
    L49:
        r119 = r216;
        goto L51
    L45:
        r118 = r215;
        goto L47
    L41:
        r117 = r214;
        goto L43
    L37:
        r116 = r213;
        goto L39
    L33:
        r107 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final QQMusicAlbum component1() {
        return this.album;
    }

    public final Boolean component10() {
        return this.isAudition;
    }

    public final Boolean component11() {
        return this.isOrigin;
    }

    public final Integer component12() {
        return this.vipState;
    }

    public final Boolean component13() {
        return this.hasCopyRight;
    }

    public final Integer component2() {
        return this.duration;
    }

    public final String component3() {
        return this.genre;
    }

    public final String component4() {
        return this.f359530id;
    }

    public final List<Integer> component5() {
        return this.labelIdList;
    }

    public final String component6() {
        return this.mid;
    }

    public final QQMusicSinger component7() {
        return this.singer;
    }

    public final String component8() {
        return this.title;
    }

    public final Integer component9() {
        return this.type;
    }

    public final QQMusicSong copy(QQMusicAlbum r110, Integer r111, String r112, String r113, List<Integer> r210, String r211, QQMusicSinger r212, String r213, Integer r214, Boolean r215, Boolean r216, Integer r217, Boolean r218) {
        return new QQMusicSong(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QQMusicSong) == true) goto L8;
        return false;
    L8:
        QQMusicSong r101 = (QQMusicSong) r100;
        if (Intrinsics.areEqual(this.album, r101.album) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.genre, r101.genre) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f359530id, r101.f359530id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.labelIdList, r101.labelIdList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mid, r101.mid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.singer, r101.singer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.isAudition, r101.isAudition) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.isOrigin, r101.isOrigin) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.vipState, r101.vipState) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.hasCopyRight, r101.hasCopyRight) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        QQMusicAlbum r100 = this.album;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.duration;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.genre;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f359530id;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = this.labelIdList;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.mid;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        QQMusicSinger r119 = this.singer;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.title;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.type;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Boolean r128 = this.isAudition;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Boolean r131 = this.isOrigin;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.vipState;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.hasCopyRight;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "QQMusicSong(album=" + this.album + ", duration=" + this.duration + ", genre=" + this.genre + ", id=" + this.f359530id + ", labelIdList=" + this.labelIdList + ", mid=" + this.mid + ", singer=" + this.singer + ", title=" + this.title + ", type=" + this.type + ", isAudition=" + this.isAudition + ", isOrigin=" + this.isOrigin + ", vipState=" + this.vipState + ", hasCopyRight=" + this.hasCopyRight + ')';
    }

    public final QQMusicAlbum getAlbum() {
        return this.album;
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final String getGenre() {
        return this.genre;
    }

    public final Boolean getHasCopyRight() {
        return this.hasCopyRight;
    }

    public final String getId() {
        return this.f359530id;
    }

    public final List<Integer> getLabelIdList() {
        return this.labelIdList;
    }

    public final String getMid() {
        return this.mid;
    }

    public final QQMusicSinger getSinger() {
        return this.singer;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Integer getVipState() {
        return this.vipState;
    }

    public final Boolean isAudition() {
        return this.isAudition;
    }

    public final Boolean isOrigin() {
        return this.isOrigin;
    }

    public QQMusicSong(QQMusicAlbum r100, Integer r101, String r102, String r103, List<Integer> r104, String r105, QQMusicSinger r106, String r107, Integer r108, Boolean r110, Boolean r111, Integer r112, Boolean r113) {
        this.album = r100;
        this.duration = r101;
        this.genre = r102;
        this.f359530id = r103;
        this.labelIdList = r104;
        this.mid = r105;
        this.singer = r106;
        this.title = r107;
        this.type = r108;
        this.isAudition = r110;
        this.isOrigin = r111;
        this.vipState = r112;
        this.hasCopyRight = r113;
    }
}
