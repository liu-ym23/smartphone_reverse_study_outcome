package com.bytedance.android.livesdk.ktvimpl.base.lyricv2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.ktvapi.config.ScrollLyricConfigV2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends View {
    public final a a;
    public boolean b;
    public final float c;
    public int d;
    public final RectF e;
    public String f;
    public float g;
    public float h;
    public final Rect i;
    public final float j;
    public boolean k;
    public final ScrollLyricConfigV2 l;

    public static final class a<T> implements Observer {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            Float r6 = (Float) r5;
            if (this.a.getPos() != this.a.getConfig().i) goto L12;
            b r0 = this.a;
            if (r6 == null) goto L7;
            float r7 = r6.floatValue();
        L9:
            if (r0.b == true) goto L11;
            r0.setInSweeping(true);
        L11:
            float r2 = ((com.bytedance.android.livesdk.ktvapi.config.a) r0.l).b.measureText(r0.f);
            float r3 = ((r0.getMeasuredWidth() - r2) / 2) + (r7 * r2);
            r0.getMeasuredWidth();
            r0.e.set(0.0f, 0.0f, r3, r0.getMeasuredHeight());
            r0.postInvalidate();
            return;
        L7:
            r7 = 0.0f;
            goto L9
        L12:
            String r8 = "SingleLineLyricView pos：" + this.a.getPos() + ",sweepLine:" + this.a.getConfig().i;
            ALogger.e(bb0.b.b(), r8 + ", invoke class :" + b.class.getSimpleName());
        }
    }

    public final ScrollLyricConfigV2 getConfig() {
        return this.l;
    }

    public final float getDBaseLine() {
        return this.c;
    }

    public final boolean getInSweeping() {
        return this.b;
    }

    public final float getMHeight() {
        return this.h;
    }

    public final float getMWidth() {
        return this.g;
    }

    public final boolean getNeedHighLight() {
        return this.k;
    }

    public final int getPos() {
        return this.d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        super.onDraw(r18);
        this.g = getMeasuredWidth();
        float r2 = getMeasuredHeight();
        this.h = r2;
        String r3 = this.f;
        if (this.b == false) goto L6;
        float r5 = 2;
        r18.drawText(r3, this.g / r5, (r2 / r5) + this.c, ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).c);
        r18.save();
        r18.clipRect(this.e);
        r18.drawText(r3, this.g / r5, (this.h / r5) + this.c, ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).b);
        r18.restore();
        return;
    L6:
        if (this.k == false) goto L20;
        boolean r7 = false;
        ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).c.getTextBounds(r3, 0, r3.length(), this.i);
        int r4 = this.i.width();
        Shader r6 = ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).c.getShader();
        if (r4 <= ((getWidth() / 5) * 3)) goto L19;
        float r13 = getHeight() / 2.0f;
        float r10 = this.j;
        Float r8 = Float.valueOf(getWidth() - this.j);
        if (r8.floatValue() <= 0) goto L12;
        r7 = true;
    L12:
        if (r7 == true) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L17;
        float r9 = r8.floatValue();
    L18:
        ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).c.setShader(new LinearGradient(r10, r13, r9, r13, new int[]{0, -1, 0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        goto L19
    L17:
        r9 = getWidth();
    L19:
        float r11 = 2;
        r18.drawText(r3, this.g / r11, (this.h / r11) + this.c, ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).c);
        ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).c.setShader(r6);
        return;
    L20:
        float r12 = 2;
        r18.drawText(r3, this.g / r12, (r2 / r12) + this.c, ((com.bytedance.android.livesdk.ktvapi.config.a) this.l).d);
    }

    public final void setInSweeping(boolean r3) {
        this.b = r3;
        if (r3 == false) goto L5;
        this.l.j.observeForever(this.a, true);
    L6:
        invalidate();
        return;
    L5:
        this.l.j.removeObserver(this.a);
        goto L6
    }

    public final void setLyricLine(com.bytedance.component.lyric.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "lyricLine");
        String r3 = r2.d;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        this.f = r3;
        invalidate();
    }

    public final void setMHeight(float r1) {
        this.h = r1;
    }

    public final void setMWidth(float r1) {
        this.g = r1;
    }

    public final void setNeedHighLight(boolean r1) {
        this.k = r1;
    }

    public final void setPos(int r1) {
        this.d = r1;
    }

    public b(Context r2, ScrollLyricConfigV2 r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        super(r2, null);
        this.l = r3;
        this.a = new a(this);
        Paint.FontMetrics r4 = ((com.bytedance.android.livesdk.ktvapi.config.a) r3).c.getFontMetrics();
        Intrinsics.checkNotNullParameter(r4, "fontMetrics");
        float r5 = r4.descent;
        this.c = ((r5 - r4.ascent) / 2) - r5;
        this.d = -1;
        this.e = new RectF();
        this.f = "";
        this.i = new Rect();
        this.j = UtilityKotlinExtentionsKt.h(38);
    }
}
