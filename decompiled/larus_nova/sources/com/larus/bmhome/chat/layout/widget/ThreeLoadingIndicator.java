package com.larus.bmhome.chat.layout.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\"\u001a\u00020#2\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#J\b\u0010'\u001a\u00020#H\u0016J\b\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020#H\u0002J\u0018\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u0011H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011@CX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006-"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ThreeLoadingIndicator;", "Lcom/larus/bmhome/chat/layout/widget/LoadingAnimationLifecycleAware;", "anchorView", "Landroid/view/View;", "resId", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "tint", "<init>", "(Landroid/view/View;ILandroid/content/Context;Ljava/lang/Integer;)V", "indicators", "", "Lcom/larus/bmhome/chat/layout/widget/LoadingIndicatorImageSpan;", "getIndicators", "()Ljava/util/List;", "minAlpha", "", "maxAlpha", "value", "curDuration", "setCurDuration", "(F)V", "animator", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "registered", "", "isAppForeground", "needAnim", "getNeedAnim", "()Z", "setNeedAnim", "(Z)V", "setTintColor", "", "(Ljava/lang/Integer;)V", "startLoading", "cancelLoading", "onAppForeground", "onAppBackground", "setupUIToDuration", "setupChildUIToDuration", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "duration", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThreeLoadingIndicator implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f304929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<v0> f304930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f304931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f304932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObjectAnimator f304933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f304934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f304935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f304936h;

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppBackground() {
        this.f304935g = false;
        a();
    }

    @Override // com.larus.bmhome.chat.layout.widget.q0
    public final void onAppForeground() {
        this.f304935g = true;
        d();
    }

    public final void a() {
        if (this.f304933e.isStarted() == true) goto L5;
        return;
    L5:
        this.f304933e.cancel();
    }

    public final void d() {
        if (this.f304933e.isStarted() == false) goto L5;
        return;
    L5:
        if (this.f304936h == true) goto L8;
        return;
    L8:
        if (this.f304934f == true) goto L11;
        CopyOnWriteArrayList<WeakReference<q0>> r100 = s0.f305249a;
        s0.a(this);
        this.f304935g = !AppHost.f326268a.a().isAppBackground();
        this.f304934f = true;
    L11:
        if (this.f304935g == false) goto L15;
        this.f304933e.start();
        return;
    }

    private final void setCurDuration(float r100) {
        Iterator r101 = CollectionsKt.reversed(this.f304930b).iterator();
    L4:
        if (r101.hasNext() == false) goto L23;
        c((v0) r101.next(), r100);
        View r102 = this.f304929a;
        Unit r103 = null;
        if ((r102 instanceof ViewGroup) == false) goto L8;
        ViewGroup r104 = (ViewGroup) r102;
    L9:
        if (r104 == null) goto L19;
        View r105 = r104.getChildAt(r104.getChildCount() - 1);
        if ((r105 instanceof FrameLayout) == false) goto L13;
        FrameLayout r106 = (FrameLayout) r105;
    L14:
        if (r106 == null) goto L18;
        View r107 = r106.getChildAt(0);
        if (r107 == null) goto L18;
        r107.invalidate();
        r103 = Unit.INSTANCE;
    L18:
        if (r103 == null) goto L19;
    L22:
        r100 = r100 + 0.16666667f;
        goto L4
    L13:
        r106 = null;
    L19:
        View r108 = this.f304929a;
        if (r108 == null) goto L22;
        r108.invalidate();
        Unit r109 = Unit.INSTANCE;
        goto L22
    L8:
        r104 = null;
        goto L9
    L23:
        View r110 = this.f304929a;
        if (r110 == null) goto L31;
        r110.invalidate();
        return;
    }

    public final void b(boolean r100) {
        this.f304936h = r100;
        if (r100 == true) goto L6;
        a();
        return;
    }

    public final void c(v0 r100, float r101) {
        boolean r102 = true;
        if (0.0f <= r101) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        float r104 = this.f304932d;
        r100.f305288j = (int) ((r104 - (((r104 - this.f304931c) * r101) / 0.5f)) * 255);
        return;
    L12:
        if (0.5f <= r101) goto L14;
    L16:
        r102 = false;
    L17:
        if (r102 == false) goto L19;
        float r105 = this.f304931c;
        r100.f305288j = (int) ((r105 + (((this.f304932d - r105) * (r101 - 0.5f)) / 0.5f)) * 255);
        return;
    L19:
        c(r100, r101 - ((int) r101));
        return;
    L14:
        if (r101 > 1.0f) goto L16;
    L5:
        if (r101 > 0.5f) goto L7;
        r103 = true;
        goto L9
    }

    public ThreeLoadingIndicator(View r110, int r111, Context r112, Integer r113) {
        this.f304929a = r110;
        v0[] r100 = new v0[3];
        int r101 = 0;
    L3:
        if (r101 >= 3) goto L5;
        r100[r101] = new v0(null, r111, r112, true, r113);
        r101 = r101 + 1;
        goto L3
    L5:
        this.f304930b = ArraysKt.toList(r100);
        this.f304931c = 0.1f;
        this.f304932d = 1.0f;
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this, "curDuration", new float[]{0.0f, 1.0f});
        r114.setRepeatCount(-1);
        r114.setDuration(800);
        this.f304933e = r114;
        this.f304935g = true;
    }
}
