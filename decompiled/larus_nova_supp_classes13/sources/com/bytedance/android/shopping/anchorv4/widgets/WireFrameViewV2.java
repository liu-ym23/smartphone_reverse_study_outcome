package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/widgets/WireFrameViewV2;", "Landroid/view/View;", "Landroid/graphics/Paint;", "a", "Lkotlin/Lazy;", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WireFrameViewV2 extends View {
    public final Lazy a;
    public final RectF b;
    public final float c;
    public LinearGradient d;

    private final Paint getPaint() {
        return (Paint) this.a.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r36) {
        Intrinsics.checkNotNullParameter(r36, "canvas");
        float r12 = com.bytedance.android.shopping.extensions.b.a(266);
        Paint r1 = getPaint();
        LinearGradient r2 = this.d;
        if (r2 != null) goto L6;
        r2 = new LinearGradient(0.0f, 0.0f, 0.0f, r12, -1, (int) 4294309625L, Shader.TileMode.CLAMP);
        this.d = r2;
        Unit r3 = Unit.INSTANCE;
    L6:
        r1.setShader(r2);
        r36.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getPaint());
        getPaint().setShader(null);
        int r8 = (int) 4294375419L;
        getPaint().setColor(r8);
        float r13 = 2;
        float r5 = com.bytedance.android.shopping.extensions.b.a(1) / r13;
        r36.drawLine(0.0f, r5, getWidth(), r5, getPaint());
        float r4 = com.bytedance.android.shopping.extensions.b.a(16);
        float r6 = getWidth() - (r4 * r13);
        getPaint().setColor((int) 4294178039L);
        float r7 = com.bytedance.android.shopping.extensions.b.a(12);
        int r15 = 3;
        List r9 = CollectionsKt.listOf(new Float[]{Float.valueOf(com.bytedance.android.shopping.extensions.b.a(24)), Float.valueOf(com.bytedance.android.shopping.extensions.b.a(16)), Float.valueOf(com.bytedance.android.shopping.extensions.b.a(16))});
        Float[] r10 = {Float.valueOf(0.54f), Float.valueOf(1.0f), Float.valueOf(0.45f)};
        float r11 = r4;
        int r14 = 0;
        int r16 = 0;
    L7:
        if (r14 >= r15) goto L9;
        this.b.set(r4, r11, (r10[r14].floatValue() * r6) + r4, ((Number) ListProtector.get(r9, r16)).floatValue() + r11);
        RectF r17 = this.b;
        float r18 = this.c;
        r36.drawRoundRect(r17, r18, r18, getPaint());
        r11 = this.b.bottom + r7;
        r14 = r14 + 1;
        r16 = r16 + 1;
        r15 = 3;
        goto L7
    L9:
        float r19 = this.b.bottom + r4;
        float r20 = com.bytedance.android.shopping.extensions.b.a(8);
        float r21 = r20 * r13;
        float r22 = getWidth() - r21;
        getPaint().setColor(-1);
        float r110 = com.bytedance.android.shopping.extensions.b.a(12);
        float r111 = com.bytedance.android.shopping.extensions.b.a(156) + r19;
        this.b.set(r20, r19, r20 + r22, r111);
        r36.drawRoundRect(this.b, r110, r110, getPaint());
        float r112 = com.bytedance.android.shopping.extensions.b.a(20);
        float r113 = com.bytedance.android.shopping.extensions.b.a(32);
        float r23 = com.bytedance.android.shopping.extensions.b.a(8);
        float r24 = com.bytedance.android.shopping.extensions.b.a(12);
        float r25 = (r22 - (r13 * r24)) - r23;
        float r26 = r19 + com.bytedance.android.shopping.extensions.b.a(16);
        Float[] r114 = {Float.valueOf(0.72f), Float.valueOf(0.6f), Float.valueOf(1.0f)};
        int r27 = 0;
        int r115 = 0;
    L10:
        int r29 = r8;
        if (r115 >= 3) goto L24;
        int r30 = r27 + 1;
        float r28 = r114[r115].floatValue();
        Float[] r31 = r114;
        Paint r116 = getPaint();
        float r32 = r13;
        if (r27 != 0) goto L15;
        int r33 = r115;
        long r117 = 4294309625L;
    L19:
        r116.setColor((int) r117);
        float r118 = r20 + r24;
        float r34 = r24;
        this.b.set(r118, r26, r118 + r112, r26 + r112);
        RectF r35 = this.b;
        float r37 = this.c;
        r36.drawRoundRect(r35, r37, r37, getPaint());
        RectF r38 = this.b;
        float r39 = r38.right;
        float r119 = r39 - r38.left;
        float r40 = r39 + r23;
        r38.left = r40;
        if (r27 != 2) goto L22;
        float r41 = r28 * ((r25 - r119) - r23);
    L23:
        r38.right = r40 + r41;
        float r42 = this.c;
        r36.drawRoundRect(r38, r42, r42, getPaint());
        r26 = this.b.bottom + r113;
        r115 = r33 + 1;
        r8 = r29;
        r27 = r30;
        r114 = r31;
        r13 = r32;
        r24 = r34;
        goto L10
    L22:
        r41 = r28 * r25;
        goto L23
    L15:
        r33 = r115;
        if (r27 != 1) goto L18;
        r117 = 3438671609L;
        goto L19
    L18:
        r117 = 2599810809L;
        goto L19
    L24:
        float r310 = r13;
        float r120 = r111 + com.bytedance.android.shopping.extensions.b.a(12);
        int r43 = 1;
    L26:
        if (r120 >= getHeight()) goto L40;
        float r44 = getWidth() - r21;
        int r45 = r43 + 1;
        getPaint().setColor(-1);
        float r46 = com.bytedance.android.shopping.extensions.b.a(12);
        float r121 = com.bytedance.android.shopping.extensions.b.a(156) + r120;
        this.b.set(r20, r120, r20 + r44, r121);
        r36.drawRoundRect(this.b, r46, r46, getPaint());
        List r122 = CollectionsKt.listOf(new Float[]{Float.valueOf(com.bytedance.android.shopping.extensions.b.a(20)), Float.valueOf(com.bytedance.android.shopping.extensions.b.a(204))});
        float r123 = com.bytedance.android.shopping.extensions.b.a(16);
        com.bytedance.android.shopping.extensions.b.a(8);
        float r47 = com.bytedance.android.shopping.extensions.b.a(12);
        float r48 = r44 - (r310 * r47);
        float r124 = r120 + com.bytedance.android.shopping.extensions.b.a(16);
        int r125 = 2;
        Float[] r49 = {Float.valueOf(0.54f), Float.valueOf(1.0f)};
        int r50 = 0;
        int r126 = 0;
    L28:
        if (r50 >= r125) goto L39;
        int r311 = r126 + 1;
        float r127 = r49[r50].floatValue();
        int r312 = r45;
        Paint r51 = getPaint();
        if (r126 != 0) goto L33;
        if (r43 != 0) goto L33;
        Float[] r313 = r49;
        long r52 = 4294309625L;
    L38:
        r51.setColor((int) r52);
        float r53 = r20 + r47;
        this.b.set(r53, r124, (r127 * r48) + r53, ((Number) ListProtector.get(r122, r126)).floatValue() + r124);
        RectF r54 = this.b;
        float r55 = this.c;
        r36.drawRoundRect(r54, r55, r55, getPaint());
        r124 = this.b.bottom + r123;
        r50 = r50 + 1;
        r21 = r21;
        r126 = r311;
        r45 = r312;
        r49 = r313;
        r125 = 2;
    L33:
        r313 = r49;
        if (r126 != 1) goto L37;
        if (r43 != 0) goto L37;
        r52 = 3438671609L;
    L37:
        r52 = 2599810809L;
        goto L38
    L39:
        r120 = r121 + com.bytedance.android.shopping.extensions.b.a(12);
        r21 = r21;
        r43 = r45;
        goto L26
    L40:
        float r56 = com.bytedance.android.shopping.extensions.b.a(60);
        float r57 = getWidth();
        float r128 = getHeight() - r56;
        getPaint().setColor(-1);
        float r129 = 0.0f + r57;
        this.b.set(0.0f, r128, r129, r128 + r56);
        r36.drawRect(this.b, getPaint());
        getPaint().setColor(r29);
        r36.drawLine(0.0f, r128, r129, r128, getPaint());
        getPaint().setColor((int) 4294309625L);
        float r58 = com.bytedance.android.shopping.extensions.b.a(16);
        float r59 = com.bytedance.android.shopping.extensions.b.a(36);
        float r60 = (r57 - (r58 * r310)) - (3 * r59);
        float r130 = r128 + (r56 / r310);
        float r61 = r59 / r310;
        float r131 = (0.0f + r58) + r61;
        int r62 = 0;
    L41:
        if (r62 >= 3) goto L46;
        r36.drawCircle(r131, r130, r61, getPaint());
        if (r62 >= 2) goto L45;
        r131 = r131 + ((0.06f * r60) + r59);
    L45:
        r62 = r62 + 1;
        goto L41
    L46:
        this.b.set((r131 + r61) + (r60 * 0.09f), r130 - com.bytedance.android.shopping.extensions.b.a(22), r129 - r58, r130 + com.bytedance.android.shopping.extensions.b.a(22));
        float r63 = com.bytedance.android.shopping.extensions.b.a(22);
        r36.drawRoundRect(this.b, r63, r63, getPaint());
    }

    public WireFrameViewV2(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(WireFrameViewV2$paint$2.INSTANCE);
        this.b = new RectF();
        this.c = com.bytedance.android.shopping.extensions.b.a(6);
    }
}
