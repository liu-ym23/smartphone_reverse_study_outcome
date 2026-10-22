package com.larus.contextwindow.impl.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larus/contextwindow/impl/ui/MembershipQuotaProgressView;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", SVGRenderEngine.CLIP_PATH, "Landroid/graphics/Path;", "bounds", "Landroid/graphics/RectF;", "trackColor", "tierColors", "", "Lcom/larus/contextwindow/impl/membership/model/MembershipQuotaBarTier;", "percent", "", "tier", "setQuota", "", "", "unlimited", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "resolveColor", SlcElement.KEY_ATTR, "fallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MembershipQuotaProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f330454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f330455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f330456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f330457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<MembershipQuotaBarTier, Integer> f330458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f330459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MembershipQuotaBarTier f330460g;

    public MembershipQuotaProgressView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MembershipQuotaProgressView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (getWidth() > 0) goto L5;
        return;
    L5:
        if (getHeight() <= 0) goto L13;
        this.f330456c.set(0.0f, 0.0f, getWidth(), getHeight());
        float r100 = getHeight() / 2.0f;
        this.f330455b.reset();
        this.f330455b.addRoundRect(this.f330456c, r100, r100, Path.Direction.CW);
        int r101 = r110.save();
        r110.clipPath(this.f330455b);
        this.f330454a.setColor(this.f330457d);
        r110.drawRect(this.f330456c, this.f330454a);
        if (this.f330459f <= 0.0f) goto L10;
        this.f330454a.setColor(((Number) MapsKt.getValue(this.f330458e, this.f330460g)).intValue());
        r110.drawRect(0.0f, 0.0f, (getWidth() * this.f330459f) / 100.0f, getHeight(), this.f330454a);
    L10:
        r110.restoreToCount(r101);
        return;
    }

    public MembershipQuotaProgressView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f330454a = new Paint(1);
        this.f330455b = new Path();
        this.f330456c = new RectF();
        int r103 = v19.c.a(R.attr.larus_neutral_transparent_1, getContext(), R.color.larus_neutral_transparent_1);
        this.f330457d = r103;
        MembershipQuotaBarTier r104 = MembershipQuotaBarTier.EMPTY;
        this.f330458e = MapsKt.mapOf(new Pair[]{TuplesKt.to(r104, Integer.valueOf(r103)), TuplesKt.to(MembershipQuotaBarTier.PRIMARY, Integer.valueOf(v19.c.a(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50))), TuplesKt.to(MembershipQuotaBarTier.WARNING, Integer.valueOf(v19.c.a(R.attr.larus_warning_50, getContext(), R.color.larus_warning_50))), TuplesKt.to(MembershipQuotaBarTier.DANGER, Integer.valueOf(v19.c.a(R.attr.larus_danger_50, getContext(), R.color.larus_danger_50))), TuplesKt.to(MembershipQuotaBarTier.NEUTRAL, Integer.valueOf(v19.c.a(R.attr.larus_neutral_50, getContext(), R.color.larus_neutral_50)))});
        this.f330460g = r104;
    }

    public /* synthetic */ MembershipQuotaProgressView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
