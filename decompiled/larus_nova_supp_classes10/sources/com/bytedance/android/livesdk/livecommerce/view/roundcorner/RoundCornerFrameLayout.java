package com.bytedance.android.livesdk.livecommerce.view.roundcorner;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rl2.a;
import rl2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/view/roundcorner/RoundCornerFrameLayout;", "Landroid/widget/FrameLayout;", "Lrl2/a;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundCornerFrameLayout extends FrameLayout implements a {
    public final b a;

    public RoundCornerFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public RoundCornerFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // rl2.a
    public final void h() {
        invalidate();
    }

    @Override // android.view.View
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        b r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "canvas");
        r1.a.a(r3);
    }

    @Override // rl2.a
    public final void g(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.draw(r2);
    }

    public RoundCornerFrameLayout(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        b r1 = new b(this);
        this.a = r1;
        Intrinsics.checkNotNullParameter(r3, "context");
        r1.a.b(r3, r4, r5);
    }

    public /* synthetic */ RoundCornerFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        b r5 = this.a;
        int r6 = getWidth();
        int r7 = getHeight();
        r5.a.c(r6, r7);
    }
}
