package com.relax.relaxframework;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/relax/relaxframework/ImageFilterType;", "", "", "value", "I", "getValue", "()I", "None", "Grayscale", "Blur", "Brightness", ExifInterface.TAG_CONTRAST, "Saturate", "HueRotate", "Matrix", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum ImageFilterType extends Enum<ImageFilterType> {
    public static final ImageFilterType Blur = null;
    public static final ImageFilterType Brightness = null;
    public static final ImageFilterType Contrast = null;
    public static final ImageFilterType Grayscale = null;
    public static final ImageFilterType HueRotate = null;
    public static final ImageFilterType Matrix = null;
    public static final ImageFilterType None = null;
    public static final ImageFilterType Saturate = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageFilterType[] f404737a = null;
    private final int value;

    public static ImageFilterType valueOf(String r100) {
        return (ImageFilterType) r27.a.a(ImageFilterType.class, r100);
    }

    public static ImageFilterType[] values() {
        return (ImageFilterType[]) f404737a.clone();
    }

    static {
        ImageFilterType r100 = new ImageFilterType("None", 0, 0);
        None = r100;
        ImageFilterType r101 = new ImageFilterType("Grayscale", 1, 1);
        Grayscale = r101;
        ImageFilterType r102 = new ImageFilterType("Blur", 2, 2);
        Blur = r102;
        ImageFilterType r103 = new ImageFilterType("Brightness", 3, 3);
        Brightness = r103;
        ImageFilterType r104 = new ImageFilterType(ExifInterface.TAG_CONTRAST, 4, 4);
        Contrast = r104;
        ImageFilterType r105 = new ImageFilterType("Saturate", 5, 5);
        Saturate = r105;
        ImageFilterType r110 = new ImageFilterType("HueRotate", 6, 6);
        HueRotate = r110;
        ImageFilterType r111 = new ImageFilterType("Matrix", 7, 7);
        Matrix = r111;
        f404737a = new ImageFilterType[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public final int getValue() {
        return this.value;
    }

    public ImageFilterType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
