package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import bc3.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/CommentIndicatorView;", "Landroid/widget/FrameLayout;", "", "selected", "", "setIndicatorSelected", "", "getCurrentProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentIndicatorView extends FrameLayout {
    public final ProgressBar a;
    public int b;
    public d c;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ CommentIndicatorView g;

        public a(CommentIndicatorView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            CommentIndicatorView r3 = this.g;
            d r0 = r3.c;
            if (r0 == null) goto L6;
            r0.onItemSelected(r3.b);
            return;
        }
    }

    public CommentIndicatorView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommentIndicatorView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getCurrentProgress() {
        return this.a.getProgress();
    }

    public final void setIndicatorSelected(boolean r2) {
        if (r2 == false) goto L4;
        this.a.setProgress(100);
        return;
    L4:
        this.a.setProgress(0);
    }

    public CommentIndicatorView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131560584, this, true);
        this.a = (ProgressBar) findViewById(2131370644);
        setOnClickListener(new a(this));
    }

    public /* synthetic */ CommentIndicatorView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
