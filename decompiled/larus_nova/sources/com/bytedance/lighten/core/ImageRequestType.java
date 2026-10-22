package com.bytedance.lighten.core;

import com.ss.android.download.api.config.HttpMethod;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ImageRequestType extends Enum<ImageRequestType> {
    public static final ImageRequestType DISPLAY = null;
    public static final ImageRequestType DOWNLOAD = null;
    public static final ImageRequestType LOAD_BITMAP = null;
    public static final ImageRequestType PREFETCH_CACHE = null;
    public static final ImageRequestType PREFETCH_DISK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageRequestType[] f254613a = null;

    static {
        ImageRequestType r100 = new ImageRequestType("DISPLAY", 0);
        DISPLAY = r100;
        ImageRequestType r101 = new ImageRequestType(HttpMethod.DOWNLOAD, 1);
        DOWNLOAD = r101;
        ImageRequestType r102 = new ImageRequestType("LOAD_BITMAP", 2);
        LOAD_BITMAP = r102;
        ImageRequestType r103 = new ImageRequestType("PREFETCH_DISK", 3);
        PREFETCH_DISK = r103;
        ImageRequestType r104 = new ImageRequestType("PREFETCH_CACHE", 4);
        PREFETCH_CACHE = r104;
        f254613a = new ImageRequestType[]{r100, r101, r102, r103, r104};
    }

    public static ImageRequestType[] values() {
        return (ImageRequestType[]) f254613a.clone();
    }

    public static ImageRequestType valueOf(String r100) {
        return (ImageRequestType) a.a(ImageRequestType.class, r100);
    }

    public ImageRequestType(String r100, int r101) {
        super(r100, r101);
    }
}
