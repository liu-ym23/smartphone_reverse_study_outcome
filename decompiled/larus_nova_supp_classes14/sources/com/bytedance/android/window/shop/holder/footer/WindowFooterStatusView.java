package com.bytedance.android.window.shop.holder.footer;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowFooterStatusView extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public CharSequence a;
    public final Lazy b;
    public final Lazy c;

    private final LoadMoreStatusView getStatusView() {
        return (LoadMoreStatusView) this.b.getValue();
    }

    private final Unit getSubViewInitializer() {
        return (Unit) this.c.getValue();
    }

    public final CharSequence getNoMoreContent() {
        return this.a;
    }

    public WindowFooterStatusView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        setMinimumHeight(r4.getResources().getDimensionPixelSize(2131166424) + (r4.getResources().getDimensionPixelSize(2131166425) * 2));
        this.a = r4.getText(2131896755);
        this.b = LazyKt.lazy(new WindowFooterStatusView$statusView$2(this));
        this.c = LazyKt.lazy(new WindowFooterStatusView$subViewInitializer$2(this));
    }

    public static final void a(WindowFooterStatusView r4) {
        r4.getClass();
        int r0 = com.bytedance.android.shopping.extensions.b.b(12);
        r4.setPadding(0, r0, 0, r0);
        r4.addView(r4.getStatusView(), new FrameLayout.LayoutParams(-1, -2));
    }

    public final void b(np3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "vo");
        getSubViewInitializer();
        FooterStatus r3 = r2.a;
        int r4 = c.a[r3.ordinal()];
        if (r4 != 1) goto L5;
        getStatusView().a();
        return;
    L5:
        if (r4 != 2) goto L7;
        getStatusView().b();
        return;
    L7:
        if (r4 != 3) goto L15;
        getStatusView().d();
        return;
    }

    public final void setNoMoreContent(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }
}
