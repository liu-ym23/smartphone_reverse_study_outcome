package com.bytedance.kmp.image.options;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageLoadSource;", "", "MEMORY_CACHE", "MEMORY", "DISK", "NETWORK", "kmpimage_release"}, k = 1, mv = {1, 7, 0})
public final enum ImageLoadSource extends Enum<ImageLoadSource> {
    public static final ImageLoadSource DISK = null;
    public static final ImageLoadSource MEMORY = null;
    public static final ImageLoadSource MEMORY_CACHE = null;
    public static final ImageLoadSource NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageLoadSource[] f252137a = null;

    public static ImageLoadSource valueOf(String r100) {
        return (ImageLoadSource) r27.a.a(ImageLoadSource.class, r100);
    }

    public static ImageLoadSource[] values() {
        return (ImageLoadSource[]) f252137a.clone();
    }

    static {
        ImageLoadSource r100 = new ImageLoadSource("MEMORY_CACHE", 0);
        MEMORY_CACHE = r100;
        ImageLoadSource r101 = new ImageLoadSource("MEMORY", 1);
        MEMORY = r101;
        ImageLoadSource r102 = new ImageLoadSource("DISK", 2);
        DISK = r102;
        ImageLoadSource r103 = new ImageLoadSource("NETWORK", 3);
        NETWORK = r103;
        f252137a = new ImageLoadSource[]{r100, r101, r102, r103};
    }

    public ImageLoadSource(String r100, int r101) {
        super(r100, r101);
    }
}
