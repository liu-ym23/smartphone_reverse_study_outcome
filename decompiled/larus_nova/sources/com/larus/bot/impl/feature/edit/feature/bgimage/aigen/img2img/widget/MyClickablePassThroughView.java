package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.byted.cast.common.CastMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0018\u001a\u00020\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017J0\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/widget/MyClickablePassThroughView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downX", "", "downY", "touchSlop", "isClicked", "", "handleParentTouchEvent", "", "event", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "ev", "clickEvent", "Lkotlin/Function0;", "bindClickEvent", "onInvoke", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyClickablePassThroughView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f318854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f318855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f318856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f318857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f318858e;

    public MyClickablePassThroughView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MyClickablePassThroughView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L6:
        if (r101 == null) goto L12;
        if (r101.intValue() != 0) goto L12;
        this.f318854a = r100.getX();
        this.f318855b = r100.getY();
        this.f318857d = true;
    L37:
        return super.dispatchTouchEvent(r100);
    L12:
        if (r101 != null) goto L15;
    L21:
        if (r101 != null) goto L24;
    L31:
        if (r101 == null) goto L37;
        if (r101.intValue() != 3) goto L37;
        this.f318857d = false;
        goto L37
    L24:
        if (r101.intValue() != 1) goto L31;
        if (this.f318857d == false) goto L30;
        Function0<Unit> r102 = this.f318858e;
        if (r102 == null) goto L30;
        r102.invoke();
    L30:
        this.f318857d = false;
        goto L37
    L15:
        if (r101.intValue() != 2) goto L21;
        if (Math.abs(r100.getX() - this.f318854a) <= this.f318856c) goto L19;
    L20:
        this.f318857d = false;
        goto L37
    L19:
        if (Math.abs(r100.getY() - this.f318855b) <= this.f318856c) goto L37;
    L4:
        r101 = null;
        goto L6
    }

    public MyClickablePassThroughView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f318856c = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f318857d = true;
    }

    public /* synthetic */ MyClickablePassThroughView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r110, int r111) {
        super.onLayout(r100, getLeft(), getTop(), getRight(), getBottom());
    }
}
