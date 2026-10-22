package com.larus.camera.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.common_ui.utils.ViewExtKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010\u001f\u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0014\u0010 \u001a\u00020\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/larus/camera/impl/widget/CameraInputContainer;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "navigationPadding", "isImeShowing", "", "imeShowingOnStart", "imeShowingStatusConsumed", "onShowImeCallback", "Lkotlin/Function0;", "", "onHideImeCallback", "onTouchDownCallback", "minBottomPadding", "getMinBottomPadding", "()I", "addView", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Landroid/view/View;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onShowImeStart", "block", "onHideImeStart", "onTouchDown", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraInputContainer extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f322827h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f322828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f322829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f322830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f322831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f322832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f322833f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f322834g;

    public CameraInputContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CameraInputContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final int getMinBottomPadding() {
        return this.f322828a + c7.b(12);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, -2);
        r101.gravity = 80;
        addView(r100, r101);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L6;
        this.f322834g.invoke();
    L6:
        return super.onInterceptTouchEvent(r100);
    }

    public CameraInputContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f322832e = new a();
        this.f322833f = new b();
        this.f322834g = new c();
        setPaddingRelative(0, 0, 0, getMinBottomPadding());
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
        ViewExtKt.l(this, new e(this), null, new f(this), null, 10);
    }

    public /* synthetic */ CameraInputContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
