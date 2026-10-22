package com.larus.larkfeed.impl.gallery;

import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f355308a = null;

    static {
        int[] r100 = new int[GalleryType.values().length];
        r100[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
    L9:
        r100[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
    L5:
        f355308a = r100;
    }
}
