package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class FadeImageView extends ImageView {
    public boolean a;

    public interface a {
    }

    public void setListener(a r1) {
    }

    @Override // android.view.View
    public final boolean isSelected() {
        return this.a;
    }

    public FadeImageView(Context r2) {
        this(r2, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean r1) {
        this.a = r1;
    }

    public FadeImageView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public FadeImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
