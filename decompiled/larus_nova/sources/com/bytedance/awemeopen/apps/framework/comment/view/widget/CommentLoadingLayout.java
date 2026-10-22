package com.bytedance.awemeopen.apps.framework.comment.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DoubleColorBallAnimationView;
import com.larus.nova.R;
import ty3.a;
import ty3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class CommentLoadingLayout extends AbstractLoadingLayout {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f194311g = 0;

    public CommentLoadingLayout(Context r100) {
        super(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout
    public final View c(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.aos_comment_first_init_loading, this, false);
        ((DoubleColorBallAnimationView) r101.findViewById(R.id.comment_init_loading_double_ball)).c();
        return r101;
    }

    public CommentLoadingLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CommentLoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout
    public final View a(Context r100, AttributeSet r101, int r102) {
        AppCompatTextView r103 = new AppCompatTextView(r100, r101, r102);
        r103.setTextSize(15.0f);
        r103.setTextColor(ContextCompat.getColor(r100, R.color.aos_list_empty_text_color));
        r103.setGravity(17);
        r103.setText(R.string.aos_comment_list_empty);
        r103.setOnClickListener(new a(this));
        return r103;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout
    public final View b(Context r100, AttributeSet r101, int r102) {
        AppCompatTextView r103 = new AppCompatTextView(r100, r101, r102);
        r103.setTextSize(15.0f);
        r103.setTextColor(ContextCompat.getColor(r100, R.color.aos_list_empty_text_color));
        r103.setGravity(17);
        r103.setText(R.string.aos_load_status_error);
        r103.setOnClickListener(new b(this));
        return r103;
    }
}
