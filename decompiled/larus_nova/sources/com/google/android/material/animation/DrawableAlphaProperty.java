package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class DrawableAlphaProperty extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> DRAWABLE_ALPHA_COMPAT = null;
    private final WeakHashMap<Drawable, Integer> alphaCache;

    static {
        DRAWABLE_ALPHA_COMPAT = new DrawableAlphaProperty();
    }

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        this.alphaCache = new WeakHashMap();
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Integer get2(Drawable r100) {
        return Integer.valueOf(r100.getAlpha());
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Integer get(Drawable r100) {
        return get2(r100);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(Drawable r100, Integer r101) {
        r100.setAlpha(r101.intValue());
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Drawable r100, Integer r101) {
        set2(r100, r101);
    }
}
