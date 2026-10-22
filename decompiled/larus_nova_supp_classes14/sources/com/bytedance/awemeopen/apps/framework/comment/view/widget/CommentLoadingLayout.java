package com.bytedance.awemeopen.apps.framework.comment.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import ty3.a;
import ty3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CommentLoadingLayout extends AbstractLoadingLayout {
    public static final /* synthetic */ int g = 0;

    public CommentLoadingLayout(Context r1) {
        super(r1);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout
    public final View c(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(2131558594, this, false);
        ((DoubleColorBallAnimationView) r4.findViewById(2131367366)).c();
        return r4;
    }

    public CommentLoadingLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommentLoadingLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout
    public final View a(Context r2, AttributeSet r3, int r4) {
        AppCompatTextView r0 = new AppCompatTextView(r2, r3, r4);
        r0.setTextSize(15.0f);
        r0.setTextColor(ContextCompat.getColor(r2, 2131100290));
        r0.setGravity(17);
        r0.setText(2131894162);
        r0.setOnClickListener(new a(this));
        return r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout
    public final View b(Context r2, AttributeSet r3, int r4) {
        AppCompatTextView r0 = new AppCompatTextView(r2, r3, r4);
        r0.setTextSize(15.0f);
        r0.setTextColor(ContextCompat.getColor(r2, 2131100290));
        r0.setGravity(17);
        r0.setText(2131894223);
        r0.setOnClickListener(new b(this));
        return r0;
    }
}
