package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes14.dex */
public class FadeImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f194327a;

    public interface a {
    }

    public void setListener(a r100) {
    }

    @Override // android.view.View
    public final boolean isSelected() {
        return this.f194327a;
    }

    public FadeImageView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r100) {
        this.f194327a = r100;
    }

    public FadeImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FadeImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
