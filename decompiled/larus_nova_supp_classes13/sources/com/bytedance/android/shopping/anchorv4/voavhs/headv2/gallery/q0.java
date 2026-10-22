package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q0 extends FrameLayout {
    public final Paint a;
    public final RectF b;
    public final TextView c;
    public final b d;
    public LinearGradient e;
    public LinearGradient f;
    public int g;

    public static final class a {
    }

    public static final class b extends ECDraweeView {
        public final /* synthetic */ q0 a;

        /* JADX WARN: Multi-variable type inference failed */
        public final void dispatchDraw(Canvas r13) {
            Intrinsics.checkNotNullParameter(r13, "canvas");
            super/*android.widget.ImageView*/.dispatchDraw(r13);
            if (this.a.c.getVisibility() != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L12;
            this.a.b.set(0.0f, 0.0f, getWidth(), com.bytedance.android.ec.core.utils.q.a(18));
            q0 r1 = this.a;
            Paint r2 = r1.a;
            LinearGradient r3 = r1.e;
            if (r3 != null) goto L10;
            r3 = new LinearGradient(0.0f, 0.2f * com.bytedance.android.ec.core.utils.q.a(18), 0.0f, com.bytedance.android.ec.core.utils.q.a(18), (int) 2367035427L, 437655587, Shader.TileMode.CLAMP);
            r1.e = r3;
        L10:
            r2.setShader(r3);
            this.a.a.setStyle(Paint.Style.FILL);
            q0 r4 = this.a;
            r13.drawRect(r4.b, r4.a);
            this.a.a.setShader(null);
            return;
        L12:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public b(q0 r7, Context r8) {
            this.a = r7;
            super(r8, null, 0, 6, null);
            GenericDraweeHierarchy r9 = getHierarchy();
            if (r9 == null) goto L6;
            r9.setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            return;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.view.View, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.q0$b] */
    public q0(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = new Paint(1);
        this.b = new RectF();
        TextView r0 = new TextView(r6);
        r0.setTextSize(1, 10.0f);
        r0.setTextColor(-1);
        r0.setGravity(17);
        Unit r3 = Unit.INSTANCE;
        this.c = r0;
        ?? r4 = new b(this, r6);
        this.d = r4;
        int r7 = com.bytedance.android.shopping.extensions.b.a(56);
        addView(r4, new FrameLayout.LayoutParams(r7, r7));
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.a(18));
        r8.gravity = 1;
        addView(r0, r8);
        ViewExtensionsKt.g(this, 12.0f, 12.0f, 12.0f, 12.0f);
        setBackgroundColor(-1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r14) {
        Intrinsics.checkNotNullParameter(r14, "canvas");
        super.dispatchDraw(r14);
        float r0 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(12.0f));
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        Paint r1 = this.a;
        int r2 = getHeight();
        LinearGradient r3 = this.f;
        if (r3 != null) goto L5;
    L12:
        r3 = new LinearGradient(0.0f, 0.0f, 0.0f, r2, 218103808, 855638016, Shader.TileMode.CLAMP);
        this.f = r3;
        this.g = r2;
    L13:
        r1.setShader(r3);
        this.a.setStyle(Paint.Style.FILL);
        r14.drawRoundRect(this.b, r0, r0, this.a);
        this.a.setShader(null);
        if (isSelected() == false) goto L17;
        float r4 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(2.0f));
        float r5 = r4 / 2.0f;
        this.b.inset(r5, r5);
        this.a.setColor(-1);
        this.a.setStrokeWidth(r4);
        this.a.setStyle(Paint.Style.STROKE);
        r14.drawRoundRect(this.b, r0, r0, this.a);
        return;
    L17:
        return;
    L5:
        if (this.g != r2) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r3 = null;
    L11:
        if (r3 != null) goto L13;
    L7:
        r6 = false;
        goto L8
    }
}
