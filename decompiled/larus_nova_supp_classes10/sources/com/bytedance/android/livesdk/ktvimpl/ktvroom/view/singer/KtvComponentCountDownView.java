package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentCountDownView;", "Landroid/view/View;", "", "startTime", "", "setStartTime", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentCountDownView extends View {
    public long a;
    public final RectF b;
    public final Paint c;
    public final Paint d;
    public RectF[] e;
    public final float f;
    public int g;

    public KtvComponentCountDownView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvComponentCountDownView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void a(long r6) {
        long r0 = this.a;
        if (r6 <= r0) goto L7;
        this.b.setEmpty();
        UtilityKotlinExtentionsKt.t(this);
        return;
    L7:
        if (r6 >= (r0 - ((long) 3000))) goto L9;
        return;
    L9:
        long r2 = r0 - KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION;
        float r7 = ((r6 - r2) * 1.0f) / (r0 - r2);
        RectF r8 = this.b;
        int r1 = this.g;
        r8.set(0.0f, 0.0f, r1 * r7, r1);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        super.onDraw(r6);
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 > 2) goto L6;
        RectF r2 = this.e[r1];
        float r3 = this.f;
        r6.drawRoundRect(r2, r3, r3, this.d);
        r1 = r1 + 1;
        goto L4
    L6:
        r6.save();
        r6.clipRect(this.b);
        this.d.setStrokeWidth(UtilityKotlinExtentionsKt.h(1.0f));
    L7:
        if (r0 > 2) goto L9;
        RectF r4 = this.e[r0];
        float r5 = this.f;
        r6.drawRoundRect(r4, r5, r5, this.d);
        RectF r7 = this.e[r0];
        float r8 = this.f;
        r6.drawRoundRect(r7, r8, r8, this.c);
        r0 = r0 + 1;
        goto L7
    L9:
        this.d.setStrokeWidth(0.0f);
        r6.restore();
    }

    public final void setStartTime(long r1) {
        this.a = r1;
        this.b.setEmpty();
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.g, 1073741824));
    }

    public KtvComponentCountDownView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        this.b = new RectF();
        Paint r11 = new Paint();
        this.c = r11;
        Paint r12 = new Paint();
        this.d = r12;
        this.e = new RectF[]{new RectF(UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(16.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(7.0f), UtilityKotlinExtentionsKt.h(7.0f), UtilityKotlinExtentionsKt.h(10.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(1.0f), UtilityKotlinExtentionsKt.h(1.0f), UtilityKotlinExtentionsKt.h(4.0f), UtilityKotlinExtentionsKt.h(19.0f))};
        this.f = s1.e(1.0f);
        this.g = s1.f(21.0f);
        r11.setColor(s1.h(2131107068));
        r11.setFakeBoldText(true);
        r12.setColor(s1.h(2131107706));
        r12.setStyle(Paint.Style.FILL_AND_STROKE);
        r12.setFakeBoldText(true);
        r12.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(2131107705));
    }

    public /* synthetic */ KtvComponentCountDownView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
