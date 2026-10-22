package com.bytedance.common.jato.views;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes15.dex */
public class JatoOptDrawableCache {
    private static SparseArray<Drawable.ConstantState> mDrawableCache;

    static {
        mDrawableCache = new SparseArray(20);
    }

    public static void clearDrawableCache() {
        mDrawableCache.clear();
    }

    public static void addDrawableCache(int r100, Drawable r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getConstantState() == null) goto L9;
        mDrawableCache.put(r100, r101.getConstantState());
        return;
    }

    public static void preloadDrawableCache(Resources r100, int[] r101) {
        if (r101.length == 0) goto L13;
        if (r100 == null) goto L17;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L18;
        if (mDrawableCache.get(r101[r103]) != null) goto L12;
        Drawable.ConstantState r104 = r100.getDrawable(r101[r103]).getConstantState();
        mDrawableCache.put(r101[r103], r104);
    L12:
        r103 = r103 + 1;
        goto L7
    L18:
        return;
    L17:
        return;
    }
}
