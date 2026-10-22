package com.lynx.animax.loader;

import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final enum AnimaXLoaderScheme extends Enum<AnimaXLoaderScheme> {
    public static final AnimaXLoaderScheme ASSET = null;
    public static final AnimaXLoaderScheme CONTENT_URI = null;
    public static final AnimaXLoaderScheme DATA_URL = null;
    public static final AnimaXLoaderScheme FILE = null;
    public static final AnimaXLoaderScheme HTTP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimaXLoaderScheme[] f380311a = null;

    static {
        AnimaXLoaderScheme r100 = new AnimaXLoaderScheme("ASSET", 0);
        ASSET = r100;
        AnimaXLoaderScheme r101 = new AnimaXLoaderScheme("FILE", 1);
        FILE = r101;
        AnimaXLoaderScheme r102 = new AnimaXLoaderScheme("HTTP", 2);
        HTTP = r102;
        AnimaXLoaderScheme r103 = new AnimaXLoaderScheme("DATA_URL", 3);
        DATA_URL = r103;
        AnimaXLoaderScheme r104 = new AnimaXLoaderScheme("CONTENT_URI", 4);
        CONTENT_URI = r104;
        f380311a = new AnimaXLoaderScheme[]{r100, r101, r102, r103, r104};
    }

    public static AnimaXLoaderScheme[] values() {
        return (AnimaXLoaderScheme[]) f380311a.clone();
    }

    public static AnimaXLoaderScheme valueOf(String r100) {
        return (AnimaXLoaderScheme) a.a(AnimaXLoaderScheme.class, r100);
    }

    public AnimaXLoaderScheme(String r100, int r101) {
        super(r100, r101);
    }
}
