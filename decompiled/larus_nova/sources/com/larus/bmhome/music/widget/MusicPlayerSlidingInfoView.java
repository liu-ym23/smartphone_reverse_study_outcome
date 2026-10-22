package com.larus.bmhome.music.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.music.databinding.LarusViewMusicPlayerSlidingInfoBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0016J\u0006\u0010(\u001a\u00020\u001aR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lcom/larus/bmhome/music/widget/MusicPlayerSlidingInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "touchSlop", "dismissOffset", "", "startX", "startY", "dispatchToViewPager", "", "banInnerDismiss", "binding", "Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerSlidingInfoBinding;", "getBinding", "()Lcom/larus/bmhome/music/databinding/LarusViewMusicPlayerSlidingInfoBinding;", "binding$delegate", "Lkotlin/Lazy;", "dismissCallback", "Lkotlin/Function0;", "", "getDismissCallback", "()Lkotlin/jvm/functions/Function0;", "setDismissCallback", "(Lkotlin/jvm/functions/Function0;)V", "parentSlideDirection", "getParentSlideDirection", "()I", "setParentSlideDirection", "(I)V", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "disallowInnerDismiss", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicPlayerSlidingInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f313278i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f313279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f313280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f313281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f313282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f313283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f313284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f313285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f313286h;

    public MusicPlayerSlidingInfoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MusicPlayerSlidingInfoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final LarusViewMusicPlayerSlidingInfoBinding getBinding() {
        return (LarusViewMusicPlayerSlidingInfoBinding) this.f313284f.getValue();
    }

    public final Function0<Unit> getDismissCallback() {
        return this.f313285g;
    }

    public final int getParentSlideDirection() {
        return this.f313286h;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f313283e == true) goto L5;
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L9;
        this.f313281c = r100.getX();
        this.f313282d = r100.getY();
        getParent().requestDisallowInterceptTouchEvent(true);
    L40:
        return super.onInterceptTouchEvent(r100);
    L9:
        if (r101 != 1) goto L11;
    L37:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L40
    L11:
        if (r101 != 2) goto L13;
        float r102 = r100.getX() - this.f313281c;
        float r103 = r100.getY() - this.f313282d;
        if (Math.abs(r103) > this.f313279a) goto L18;
    L22:
        boolean r104 = false;
    L24:
        if (Math.abs(r102) > this.f313279a) goto L26;
    L30:
        boolean r105 = false;
    L31:
        if (r104 == true) goto L35;
        if (r105 == true) goto L35;
        getParent().requestDisallowInterceptTouchEvent(false);
    L35:
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    L26:
        if (Math.abs(r102) <= Math.abs(r103)) goto L30;
        if (this.f313286h != 1) goto L30;
        r105 = true;
        goto L31
    L18:
        if (Math.abs(r103) <= Math.abs(r102)) goto L22;
        if (this.f313286h != 0) goto L22;
        r104 = true;
        goto L24
    L13:
        if (r101 == 3) goto L37;
    L5:
        return super.onInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f313283e == false) goto L7;
        return super.onTouchEvent(r100);
    L7:
        if (r100.getActionMasked() != 2) goto L46;
        float r101 = r100.getX() - this.f313281c;
        float r102 = r100.getY() - this.f313282d;
        boolean r103 = false;
        if (Math.abs(r102) > this.f313279a) goto L11;
    L15:
        boolean r104 = false;
    L17:
        if (Math.abs(r101) > this.f313279a) goto L19;
    L23:
        boolean r105 = false;
    L24:
        if (r104 == true) goto L28;
        if (r105 == true) goto L28;
        getParent().requestDisallowInterceptTouchEvent(false);
    L28:
        getParent().requestDisallowInterceptTouchEvent(true);
        float r106 = this.f313280b;
        if (r102 > r106) goto L31;
    L33:
        boolean r107 = false;
    L35:
        if (r101 > r106) goto L37;
    L39:
        if (r107 == true) goto L41;
        if (r103 == true) goto L41;
    L44:
        return true;
    L41:
        Function0<Unit> r108 = this.f313285g;
        if (r108 == null) goto L44;
        r108.invoke();
        goto L44
    L37:
        if (this.f313286h != 1) goto L39;
        r103 = true;
        goto L39
    L31:
        if (this.f313286h != 0) goto L33;
        r107 = true;
        goto L35
    L19:
        if (Math.abs(r101) <= Math.abs(r102)) goto L23;
        if (this.f313286h != 1) goto L23;
        r105 = true;
        goto L24
    L11:
        if (Math.abs(r102) <= Math.abs(r101)) goto L15;
        if (this.f313286h != 0) goto L15;
        r104 = true;
    L46:
        return super.onTouchEvent(r100);
    }

    public final void setDismissCallback(Function0<Unit> r100) {
        this.f313285g = r100;
    }

    public final void setParentSlideDirection(int r100) {
        this.f313286h = r100;
    }

    public MusicPlayerSlidingInfoView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f313279a = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f313280b = 150.0f;
        this.f313284f = LazyKt.lazy(new l2(r100, this));
        this.f313286h = 1;
    }

    public /* synthetic */ MusicPlayerSlidingInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
