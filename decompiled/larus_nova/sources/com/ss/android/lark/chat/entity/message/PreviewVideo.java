package com.ss.android.lark.chat.entity.message;

import com.tencent.connect.common.Constants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/PreviewVideo;", "Ljava/io/Serializable;", "site", "Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;", "vid", "", "iFrameUrl", "<init>", "(Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;Ljava/lang/String;Ljava/lang/String;)V", "getSite", "()Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;", "getVid", "()Ljava/lang/String;", "getIFrameUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Site", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreviewVideo implements Serializable {
    private final String iFrameUrl;
    private final Site site;
    private final String vid;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/PreviewVideo$Site;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "XIGUA", "DOUYIN", "HUOSHAN", "YOUTUBE", "IQIYI", "YOUKU", Constants.SOURCE_QQ, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Site extends Enum<Site> {
        public static final Site DOUYIN = null;
        public static final Site HUOSHAN = null;
        public static final Site IQIYI = null;
        public static final Site QQ = null;
        public static final Site UNKNOWN = null;
        public static final Site XIGUA = null;
        public static final Site YOUKU = null;
        public static final Site YOUTUBE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Site[] f415304a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f415305b = null;
        private final int value;

        public static EnumEntries<Site> getEntries() {
            return f415305b;
        }

        static {
            Site r100 = new Site("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Site r101 = new Site("XIGUA", 1, 1);
            XIGUA = r101;
            Site r102 = new Site("DOUYIN", 2, 2);
            DOUYIN = r102;
            Site r103 = new Site("HUOSHAN", 3, 3);
            HUOSHAN = r103;
            Site r104 = new Site("YOUTUBE", 4, 4);
            YOUTUBE = r104;
            Site r105 = new Site("IQIYI", 5, 5);
            IQIYI = r105;
            Site r110 = new Site("YOUKU", 6, 6);
            YOUKU = r110;
            Site r111 = new Site(Constants.SOURCE_QQ, 7, 7);
            QQ = r111;
            Site[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f415304a = r112;
            f415305b = EnumEntriesKt.enumEntries(r112);
        }

        public static Site[] values() {
            return (Site[]) f415304a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Site valueOf(String r100) {
            return (Site) r27.a.a(Site.class, r100);
        }

        public Site(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ PreviewVideo copy$default(PreviewVideo r100, Site r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.site;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.vid;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.iFrameUrl;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Site component1() {
        return this.site;
    }

    public final String component2() {
        return this.vid;
    }

    public final String component3() {
        return this.iFrameUrl;
    }

    public final PreviewVideo copy(Site r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "site");
        return new PreviewVideo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreviewVideo) == true) goto L8;
        return false;
    L8:
        PreviewVideo r101 = (PreviewVideo) r100;
        if (this.site == r101.site) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iFrameUrl, r101.iFrameUrl) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.site.hashCode() * 31;
        String r101 = this.vid;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.iFrameUrl;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "PreviewVideo(site=" + this.site + ", vid=" + this.vid + ", iFrameUrl=" + this.iFrameUrl + ')';
    }

    public final String getIFrameUrl() {
        return this.iFrameUrl;
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getVid() {
        return this.vid;
    }

    public PreviewVideo(Site r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "site");
        this.site = r100;
        this.vid = r101;
        this.iFrameUrl = r102;
    }
}
