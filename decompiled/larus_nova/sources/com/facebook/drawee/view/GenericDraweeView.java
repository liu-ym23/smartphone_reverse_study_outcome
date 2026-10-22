package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyInflater;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class GenericDraweeView extends DraweeView<GenericDraweeHierarchy> {
    public GenericDraweeView(Context r100) {
        super(r100);
        inflateHierarchy(r100, null);
    }

    public GenericDraweeView(Context r100, AttributeSet r101) {
        super(r100, r101);
        inflateHierarchy(r100, r101);
    }

    public void inflateHierarchy(Context r100, @Nullable AttributeSet r101) {
        if (FrescoSystrace.isTracing() == false) goto L5;
        FrescoSystrace.beginSection("GenericDraweeView#inflateHierarchy");
    L5:
        GenericDraweeHierarchyBuilder r102 = GenericDraweeHierarchyInflater.inflateBuilder(r100, r101);
        setAspectRatio(r102.getDesiredAspectRatio());
        setHierarchy(r102.build());
        if (FrescoSystrace.isTracing() == false) goto L9;
        FrescoSystrace.endSection();
        return;
    }

    public GenericDraweeView(Context r100, GenericDraweeHierarchy r101) {
        super(r100);
        setHierarchy(r101);
    }

    public GenericDraweeView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        inflateHierarchy(r100, r101);
    }

    public GenericDraweeView(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        inflateHierarchy(r100, r101);
    }
}
