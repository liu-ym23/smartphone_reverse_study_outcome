package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final Property<ViewGroup, Float> CHILDREN_ALPHA = null;

    static {
        CHILDREN_ALPHA = new ChildrenAlphaProperty("childrenAlpha");
    }

    private ChildrenAlphaProperty(String r100) {
        super(Float.class, r100);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public Float get2(ViewGroup r100) {
        Float r101 = (Float) r100.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ Float get(ViewGroup r100) {
        return get2(r100);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ViewGroup r100, Float r101) {
        float r102 = r101.floatValue();
        r100.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(r102));
        int r103 = r100.getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r100.getChildAt(r104).setAlpha(r102);
        r104 = r104 + 1;
        goto L3
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ViewGroup r100, Float r101) {
        set2(r100, r101);
    }
}
