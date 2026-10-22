package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u00011BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u000200H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001a¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "site", "Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "coverImage", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "coverImageUrl", "", "duration", "", "srcUrl", "vid", "iframeUrl", "<init>", "(Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSite", "()Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "setSite", "(Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;)V", "getCoverImage", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setCoverImage", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getCoverImageUrl", "()Ljava/lang/String;", "setCoverImageUrl", "(Ljava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getSrcUrl", "setSrcUrl", "getVid", "setVid", "getIframeUrl", "setIframeUrl", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "", "other", "", "hashCode", "", "clone", "Lcom/ss/android/lark/tangram/base/props/Props;", "Site", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoProperty extends BaseProperty {
    private ImageSet coverImage;
    private String coverImageUrl;
    private long duration;
    private String iframeUrl;
    private Site site;
    private String srcUrl;
    private String vid;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/VideoProperty$Site;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "XIGUA", "DOUYIN", "HUOSHAN", "YOUTUBE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Site extends Enum<Site> {
        public static final a Companion = null;
        public static final Site DOUYIN = null;
        public static final Site HUOSHAN = null;
        public static final Site UNKNOWN = null;
        public static final Site XIGUA = null;
        public static final Site YOUTUBE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Site[] f416271a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f416272b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static Site a(int r100) {
                if (r100 == 1) goto L15;
                if (r100 == 2) goto L19;
                if (r100 == 3) goto L18;
                if (r100 == 4) goto L17;
                return Site.UNKNOWN;
            L17:
                return Site.YOUTUBE;
            L18:
                return Site.HUOSHAN;
            L19:
                return Site.DOUYIN;
            L15:
                return Site.XIGUA;
            }
        }

        public static EnumEntries<Site> getEntries() {
            return f416272b;
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
            Site[] r105 = {r100, r101, r102, r103, r104};
            f416271a = r105;
            f416272b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static Site[] values() {
            return (Site[]) f416271a.clone();
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

    public VideoProperty() {
        this(null, null, null, 0, null, null, null, 127, null);
    }

    @Override // com.ss.android.lark.tangram.base.props.Props
    public Props clone() {
        Site r100 = this.site;
        ImageSet r101 = this.coverImage;
        if (r101 == null) goto L5;
        ImageSet r102 = r101.clone();
    L6:
        VideoProperty r103 = new VideoProperty(r100, r102, this.coverImageUrl, this.duration, this.srcUrl, this.vid, this.iframeUrl);
        r103.setMarginLeft(getMarginLeft());
        r103.setMarginRight(getMarginRight());
        r103.setMarginTop(getMarginTop());
        r103.setMarginBottom(getMarginBottom());
        return r103;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = ((super.hashCode() * 31) + this.site.hashCode()) * 31;
        ImageSet r101 = this.coverImage;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        long r104 = this.duration;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.srcUrl;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.vid;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.iframeUrl;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        String r115 = this.coverImageUrl;
        if (r115 == null) goto L22;
        r102 = r115.hashCode();
    L22:
        return r114 + r102;
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final ImageSet getCoverImage() {
        return this.coverImage;
    }

    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getIframeUrl() {
        return this.iframeUrl;
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getSrcUrl() {
        return this.srcUrl;
    }

    public final String getVid() {
        return this.vid;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VideoProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L11;
        return false;
    L11:
        VideoProperty r101 = (VideoProperty) r100;
        if (this.site == r101.site) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.coverImage, r101.coverImage) == true) goto L18;
        return false;
    L18:
        if (this.duration == r101.duration) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.srcUrl, r101.srcUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.vid, r101.vid) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.iframeUrl, r101.iframeUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.coverImageUrl, r101.coverImageUrl) == true) goto L32;
        return false;
    L32:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L55;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        if (r103 == ComponentAttribute.site.getValue()) goto L9;
        ImageSet r104 = null;
        String r105 = null;
        String r106 = null;
        String r107 = null;
        String r108 = null;
        if (r103 == ComponentAttribute.cover_image.getValue()) goto L18;
        if (r103 == ComponentAttribute.src_url.getValue()) goto L24;
        if (r103 == ComponentAttribute.vid.getValue()) goto L30;
        if (r103 == ComponentAttribute.iframe_url.getValue()) goto L36;
        if (r103 == ComponentAttribute.cover_image_url.getValue()) goto L42;
        if (r103 != ComponentAttribute.duration.getValue()) goto L6;
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L53;
        Long r110 = r109.getLong();
        if (r110 == null) goto L53;
        long r111 = r110.longValue();
    L54:
        this.duration = r111;
    L53:
        r111 = 0;
        goto L54
    L42:
        PreviewData r112 = r102.getValue();
        if (r112 == null) goto L45;
        r105 = r112.getString();
    L45:
        this.coverImageUrl = r105;
        goto L6
    L36:
        PreviewData r113 = r102.getValue();
        if (r113 == null) goto L39;
        r106 = r113.getString();
    L39:
        this.iframeUrl = r106;
        goto L6
    L30:
        PreviewData r114 = r102.getValue();
        if (r114 == null) goto L33;
        r107 = r114.getString();
    L33:
        this.vid = r107;
        goto L6
    L24:
        PreviewData r115 = r102.getValue();
        if (r115 == null) goto L27;
        r108 = r115.getString();
    L27:
        this.srcUrl = r108;
        goto L6
    L18:
        PreviewData r116 = r102.getValue();
        if (r116 == null) goto L21;
        r104 = r116.getImageSet();
    L21:
        this.coverImage = r104;
        goto L6
    L9:
        Site.a r117 = Site.Companion;
        PreviewData r118 = r102.getValue();
        if (r118 == null) goto L14;
        Integer r119 = r118.getInt();
        if (r119 == null) goto L14;
        int r120 = r119.intValue();
    L15:
        r117.getClass();
        this.site = Site.a.a(r120);
    L14:
        r120 = 0;
        goto L15
    }

    public final void setCoverImage(ImageSet r100) {
        this.coverImage = r100;
    }

    public final void setCoverImageUrl(String r100) {
        this.coverImageUrl = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setIframeUrl(String r100) {
        this.iframeUrl = r100;
    }

    public final void setSite(Site r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.site = r100;
    }

    public final void setSrcUrl(String r100) {
        this.srcUrl = r100;
    }

    public final void setVid(String r100) {
        this.vid = r100;
    }

    public VideoProperty(Site r100, ImageSet r101, String r102, long r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "site");
        super(Type.VIDEO);
        this.site = r100;
        this.coverImage = r101;
        this.coverImageUrl = r102;
        this.duration = r103;
        this.srcUrl = r104;
        this.vid = r105;
        this.iframeUrl = r106;
    }

    public /* synthetic */ VideoProperty(Site r110, ImageSet r111, String r112, long r113, String r114, String r115, String r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        Site r100 = Site.UNKNOWN;
    L7:
        if ((r117 & 2) == 0) goto L9;
        ImageSet r101 = null;
    L10:
        String r102 = "";
        if ((r117 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r117 & 8) == 0) goto L17;
        long r104 = 0;
    L19:
        if ((r117 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r117 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r117 & 64) != 0) goto L30;
        r102 = r116;
    L30:
        this(r100, r101, r103, r104, r105, r106, r102);
        return;
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
