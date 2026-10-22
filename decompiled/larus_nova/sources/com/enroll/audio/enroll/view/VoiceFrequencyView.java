package com.enroll.audio.enroll.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0014R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0019\u0010\u0012R\u001b\u0010\u001b\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0012R\u001b\u0010\u001e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b\u001f\u0010\u0012R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lcom/enroll/audio/enroll/view/VoiceFrequencyView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "barGap", "getBarGap", "()I", "barGap$delegate", "Lkotlin/Lazy;", "barWidth", "getBarWidth", "barWidth$delegate", "maxHeight", "getMaxHeight", "maxHeight$delegate", "minHeight", "getMinHeight", "minHeight$delegate", "halfHeight", "getHalfHeight", "halfHeight$delegate", "painter", "Landroid/graphics/Paint;", "getPainter", "()Landroid/graphics/Paint;", "painter$delegate", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceFrequencyView extends LinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f273938h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Float> f273939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f273940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f273941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f273942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f273943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f273944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f273945g;

    public static final class a {
    }

    static {
    }

    private final int getBarGap() {
        return ((Number) this.f273940b.getValue()).intValue();
    }

    private final int getBarWidth() {
        return ((Number) this.f273941c.getValue()).intValue();
    }

    private final int getHalfHeight() {
        return ((Number) this.f273944f.getValue()).intValue();
    }

    private final int getMaxHeight() {
        return ((Number) this.f273942d.getValue()).intValue();
    }

    private final int getMinHeight() {
        return ((Number) this.f273943e.getValue()).intValue();
    }

    private final Paint getPainter() {
        return (Paint) this.f273945g.getValue();
    }

    public VoiceFrequencyView(Context r100) {
        this(r100, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f273939a.size() == 34) goto L5;
        return;
    L5:
        int r100 = 0;
    L6:
        if (r100 >= 34) goto L16;
        if (r110 == null) goto L9;
        r110.save();
    L9:
        if (r110 == null) goto L11;
        r110.translate((r100 * 2) * getBarGap(), getHalfHeight());
    L11:
        if (r110 == null) goto L13;
        float r101 = 2;
        r110.drawRoundRect(0.0f, ((-1) * ((Number) ListProtector.get(this.f273939a, r100)).floatValue()) / r101, getBarWidth(), (1 * ((Number) ListProtector.get(this.f273939a, r100)).floatValue()) / r101, getBarWidth() / 2.0f, getBarWidth() / 2.0f, getPainter());
    L13:
        if (r110 == null) goto L15;
        r110.restore();
    L15:
        r100 = r100 + 1;
        goto L6
    }

    public VoiceFrequencyView(final Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f273939a = new ArrayList(34);
        this.f273940b = LazyKt.lazy(new a0(r100));
        this.f273941c = LazyKt.lazy(new b0(r100));
        this.f273942d = LazyKt.lazy(new c0(r100));
        this.f273943e = LazyKt.lazy(new d0(r100));
        this.f273944f = LazyKt.lazy(new e0(r100));
        this.f273945g = LazyKt.lazy(new f0(r100));
    }

    public VoiceFrequencyView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101);
    }
}
