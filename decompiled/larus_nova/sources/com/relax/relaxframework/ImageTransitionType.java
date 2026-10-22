package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/relax/relaxframework/ImageTransitionType;", "", "", "value", "I", "getValue", "()I", "ImageTransitionFadeIn", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageTransitionType extends Enum<ImageTransitionType> {
    public static final ImageTransitionType ImageTransitionFadeIn = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageTransitionType[] f404740a = null;
    private final int value;

    public static ImageTransitionType valueOf(String r100) {
        return (ImageTransitionType) r27.a.a(ImageTransitionType.class, r100);
    }

    public static ImageTransitionType[] values() {
        return (ImageTransitionType[]) f404740a.clone();
    }

    static {
        ImageTransitionType r100 = new ImageTransitionType();
        ImageTransitionFadeIn = r100;
        f404740a = new ImageTransitionType[]{r100};
    }

    public ImageTransitionType() {
        super("ImageTransitionFadeIn", 0);
        this.value = 40012;
    }

    public final int getValue() {
        return this.value;
    }
}
