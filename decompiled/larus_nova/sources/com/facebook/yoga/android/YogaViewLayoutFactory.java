package com.facebook.yoga.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: loaded from: classes23.dex */
public class YogaViewLayoutFactory implements LayoutInflater.Factory {
    private static YogaViewLayoutFactory sYogaViewLayoutFactory;

    public YogaViewLayoutFactory() {
    }

    public static YogaViewLayoutFactory getInstance() {
        if (sYogaViewLayoutFactory != null) goto L6;
        sYogaViewLayoutFactory = new YogaViewLayoutFactory();
    L6:
        return sYogaViewLayoutFactory;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String r100, Context r101, AttributeSet r102) {
        if ("YogaLayout".equals(r100) == false) goto L7;
        return new YogaLayout(r101, r102);
    L7:
        if ("VirtualYogaLayout".equals(r100) == true) goto L9;
        return null;
    L9:
        return new VirtualYogaLayout(r101, r102);
    }
}
