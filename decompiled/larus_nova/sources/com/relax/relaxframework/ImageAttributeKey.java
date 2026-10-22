package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/relax/relaxframework/ImageAttributeKey;", "", "", "value", "I", "getValue", "()I", "Mode", "Src", "Repeat", "Placeholder", "SkipRedirection", "ImageTransitionStyle", "PreventLoadingOnListScroll", "BlurRadius", "LowQuality", "CapInsets", "CapInsetsScale", "DeferSrcInvalidation", "LoopCount", "AutoSize", "Autoplay", "EnableResourceHint", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageAttributeKey extends Enum<ImageAttributeKey> {
    public static final ImageAttributeKey AutoSize = null;
    public static final ImageAttributeKey Autoplay = null;
    public static final ImageAttributeKey BlurRadius = null;
    public static final ImageAttributeKey CapInsets = null;
    public static final ImageAttributeKey CapInsetsScale = null;
    public static final ImageAttributeKey DeferSrcInvalidation = null;
    public static final ImageAttributeKey EnableResourceHint = null;
    public static final ImageAttributeKey ImageTransitionStyle = null;
    public static final ImageAttributeKey LoopCount = null;
    public static final ImageAttributeKey LowQuality = null;
    public static final ImageAttributeKey Mode = null;
    public static final ImageAttributeKey Placeholder = null;
    public static final ImageAttributeKey PreventLoadingOnListScroll = null;
    public static final ImageAttributeKey Repeat = null;
    public static final ImageAttributeKey SkipRedirection = null;
    public static final ImageAttributeKey Src = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageAttributeKey[] f404734a = null;
    private final int value;

    public static ImageAttributeKey valueOf(String r100) {
        return (ImageAttributeKey) r27.a.a(ImageAttributeKey.class, r100);
    }

    public static ImageAttributeKey[] values() {
        return (ImageAttributeKey[]) f404734a.clone();
    }

    static {
        ImageAttributeKey r100 = new ImageAttributeKey("Mode", 0, 20004);
        Mode = r100;
        ImageAttributeKey r101 = new ImageAttributeKey("Src", 1, 20002);
        Src = r101;
        ImageAttributeKey r102 = new ImageAttributeKey("Repeat", 2, 20005);
        Repeat = r102;
        ImageAttributeKey r103 = new ImageAttributeKey("Placeholder", 3, 20006);
        Placeholder = r103;
        ImageAttributeKey r104 = new ImageAttributeKey("SkipRedirection", 4, 20108);
        SkipRedirection = r104;
        ImageAttributeKey r105 = new ImageAttributeKey("ImageTransitionStyle", 5, 20117);
        ImageTransitionStyle = r105;
        ImageAttributeKey r110 = new ImageAttributeKey("PreventLoadingOnListScroll", 6, 20003);
        PreventLoadingOnListScroll = r110;
        ImageAttributeKey r111 = new ImageAttributeKey("BlurRadius", 7, 20008);
        BlurRadius = r111;
        ImageAttributeKey r112 = new ImageAttributeKey("LowQuality", 8, 20181);
        LowQuality = r112;
        ImageAttributeKey r113 = new ImageAttributeKey("CapInsets", 9, 20118);
        CapInsets = r113;
        ImageAttributeKey r114 = new ImageAttributeKey("CapInsetsScale", 10, 20119);
        CapInsetsScale = r114;
        ImageAttributeKey r106 = new ImageAttributeKey("DeferSrcInvalidation", 11, 20120);
        DeferSrcInvalidation = r106;
        ImageAttributeKey r107 = new ImageAttributeKey("LoopCount", 12, 20158);
        LoopCount = r107;
        ImageAttributeKey r108 = new ImageAttributeKey("AutoSize", 13, 20153);
        AutoSize = r108;
        ImageAttributeKey r109 = new ImageAttributeKey("Autoplay", 14, 20043);
        Autoplay = r109;
        ImageAttributeKey r115 = new ImageAttributeKey("EnableResourceHint", 15, 20304);
        EnableResourceHint = r115;
        f404734a = new ImageAttributeKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115};
    }

    public final int getValue() {
        return this.value;
    }

    public ImageAttributeKey(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
