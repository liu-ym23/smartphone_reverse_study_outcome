package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/relax/relaxframework/ImageFillMode;", "", "", "value", "I", "getValue", "()I", "ModeScaleToFill", "ModeAspectFit", "ModeAspectFill", "ModeCenter", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageFillMode extends Enum<ImageFillMode> {
    public static final ImageFillMode ModeAspectFill = null;
    public static final ImageFillMode ModeAspectFit = null;
    public static final ImageFillMode ModeCenter = null;
    public static final ImageFillMode ModeScaleToFill = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageFillMode[] f404736a = null;
    private final int value;

    public static ImageFillMode valueOf(String r100) {
        return (ImageFillMode) r27.a.a(ImageFillMode.class, r100);
    }

    public static ImageFillMode[] values() {
        return (ImageFillMode[]) f404736a.clone();
    }

    static {
        ImageFillMode r100 = new ImageFillMode("ModeScaleToFill", 0, 40003);
        ModeScaleToFill = r100;
        ImageFillMode r101 = new ImageFillMode("ModeAspectFit", 1, 40004);
        ModeAspectFit = r101;
        ImageFillMode r102 = new ImageFillMode("ModeAspectFill", 2, 40005);
        ModeAspectFill = r102;
        ImageFillMode r103 = new ImageFillMode("ModeCenter", 3, 40006);
        ModeCenter = r103;
        f404736a = new ImageFillMode[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public ImageFillMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
