package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends FrameLayout {
    public final TextView a;
    public final Set<Integer> b;
    public final View c;
    public boolean d;
    public final a e;
    public Runnable f;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = this.a;     // Catch: Throwable -> L4
            r0.c.animate().alpha(0.0f).setDuration(300).setListener(new i(r0)).start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a.requestLayout();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        super(r12);
        this.b = new LinkedHashSet();
        this.e = new a(this);
        LinearLayout r0 = new LinearLayout(r12);
        this.c = r0;
        r0.setPadding(0, com.bytedance.android.shopping.extensions.b.a(10), 0, com.bytedance.android.shopping.extensions.b.a(10));
        Drawable r2 = new BackgroundDrawable(r12, null, false, 4, null);
        r2.setBgColor(872415231);
        r2.setStrokeColor((int) 2298478591L);
        r2.setStrokeWidth(com.bytedance.android.shopping.extensions.b.a(Double.valueOf(0.2d)));
        r2.setCornerRadiusTL(q.a(12));
        r2.setCornerRadiusBL(q.a(12));
        r2.invalidate();
        Unit r3 = Unit.INSTANCE;
        r0.setBackground(r2);
        r0.setOrientation(1);
        r0.setGravity(1);
        ImageView r4 = new ImageView(r12);
        r4.setImageResource(2131231267);
        r0.addView(r4, com.bytedance.android.shopping.extensions.b.a(10), com.bytedance.android.shopping.extensions.b.a(10));
        TextView r1 = new TextView(r12);
        this.a = r1;
        r1.setGravity(1);
        int r5 = g1.a;
        r1.setTextColor(g1.a.a(r12, 2131101217));
        r1.setTextSize(1, 12.0f);
        r1.setEms(1);
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-2, -2);
        r13.topMargin = com.bytedance.android.shopping.extensions.b.a(8);
        r0.addView(r1, r13);
        addView(r0, new FrameLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.a(23), -2));
        r0.setVisibility(4);
    }

    private final void setVideoLabel(String r4) {
        TextView r0 = this.a;
        if (a2.d(r4) == null) goto L6;
        String r5 = "·" + r4;
        if (r5 == null) goto L6;
    L7:
        r0.setText("下一个视频".concat(r5));
        post(new b(this));
        return;
    L6:
        r5 = "";
        goto L7
    }

    public static final /* synthetic */ void a(h r0, String r1) {
        r0.setVideoLabel(r1);
    }
}
