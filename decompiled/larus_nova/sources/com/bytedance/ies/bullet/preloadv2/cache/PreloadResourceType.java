package com.bytedance.ies.bullet.preloadv2.cache;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/cache/PreloadResourceType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Template", "Image", "Video", "Lottie", "Font", "ExternalJs", "DynamicComponent", "Redirect", "Any", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum PreloadResourceType extends Enum<PreloadResourceType> {
    public static final PreloadResourceType Any = null;
    public static final PreloadResourceType DynamicComponent = null;
    public static final PreloadResourceType ExternalJs = null;
    public static final PreloadResourceType Font = null;
    public static final PreloadResourceType Image = null;
    public static final PreloadResourceType Lottie = null;
    public static final PreloadResourceType Redirect = null;
    public static final PreloadResourceType Template = null;
    public static final PreloadResourceType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreloadResourceType[] f247696a = null;
    private final String tag;

    public static PreloadResourceType valueOf(String r100) {
        return (PreloadResourceType) r27.a.a(PreloadResourceType.class, r100);
    }

    public static PreloadResourceType[] values() {
        return (PreloadResourceType[]) f247696a.clone();
    }

    static {
        PreloadResourceType r100 = new PreloadResourceType("Template", 0, ThumbGlideUrl.SOURCE_TEMPLATE);
        Template = r100;
        PreloadResourceType r101 = new PreloadResourceType("Image", 1, "image");
        Image = r101;
        PreloadResourceType r102 = new PreloadResourceType("Video", 2, "video");
        Video = r102;
        PreloadResourceType r103 = new PreloadResourceType("Lottie", 3, "lottie");
        Lottie = r103;
        PreloadResourceType r104 = new PreloadResourceType("Font", 4, LynxResourceModule.FONT_TYPE);
        Font = r104;
        PreloadResourceType r105 = new PreloadResourceType("ExternalJs", 5, "externalJs");
        ExternalJs = r105;
        PreloadResourceType r110 = new PreloadResourceType("DynamicComponent", 6, "dynamicComponent");
        DynamicComponent = r110;
        PreloadResourceType r111 = new PreloadResourceType("Redirect", 7, "redirect");
        Redirect = r111;
        PreloadResourceType r112 = new PreloadResourceType("Any", 8, "any");
        Any = r112;
        f247696a = new PreloadResourceType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
    }

    public final String getTag() {
        return this.tag;
    }

    public PreloadResourceType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
