package com.bytedance.live.richcontent.utils;

import com.bytedance.live.richcontent.model.style.ImageStyle;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255803a = null;

    static {
        int[] r100 = new int[ImageStyle.AdjustType.values().length];
        f255803a = r100;
        r100[ImageStyle.AdjustType.ORIGIN.ordinal()] = 1;
        r100[ImageStyle.AdjustType.EXACTLY.ordinal()] = 2;
        r100[ImageStyle.AdjustType.SCALE.ordinal()] = 3;
        r100[ImageStyle.AdjustType.ADJUST_HEIGHT.ordinal()] = 4;
        r100[ImageStyle.AdjustType.ADJUST_WIDTH.ordinal()] = 5;
    }
}
