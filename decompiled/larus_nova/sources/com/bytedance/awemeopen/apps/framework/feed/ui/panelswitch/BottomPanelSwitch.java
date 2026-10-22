package com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.infra.util.e;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import k14.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\n\u0010B\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/panelswitch/BottomPanelSwitch;", "Landroid/widget/FrameLayout;", "", "state", "", "setBottomPanelSwitchState", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/panelswitch/BottomPanelSwitch$b;", "listener", "setSwitchListener", "Lk14/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getBottomPanelSwitchTrackView", "()Lk14/c;", "bottomPanelSwitchTrackView", "Lk14/b;", "b", "getBottomPanelSwitchThumbView", "()Lk14/b;", "bottomPanelSwitchThumbView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class BottomPanelSwitch extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f196573e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f196574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f196575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f196576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f196577d;

    public static final class a {
        public a() {
        }
    }

    public interface b {
        void a();

        void b();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        return true;
    }

    static {
        new a();
        f196573e = e.a(y54.a.a(), 2.0f);
    }

    private final k14.b getBottomPanelSwitchThumbView() {
        return (k14.b) this.f196575b.getValue();
    }

    private final c getBottomPanelSwitchTrackView() {
        return (c) this.f196574a.getValue();
    }

    public static void a(BottomPanelSwitch r100) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        ValueAnimator r101 = null;
        if (r100.f196577d == false) goto L20;
        c r102 = r100.getBottomPanelSwitchTrackView();
        r102.f501377d = Integer.valueOf(r102.f501375b);
        r102.invalidate();
        k14.b r103 = r100.getBottomPanelSwitchThumbView();
        ValueAnimator r104 = r103.f501373g;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("turnOnAnimator");
        r104 = null;
    L8:
        if (r104.isRunning() == false) goto L13;
        ValueAnimator r105 = r103.f501373g;
        if (r105 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("turnOnAnimator");
        r105 = null;
    L12:
        r105.cancel();
    L13:
        ValueAnimator r106 = r103.f501372f;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("turnOffAnimator");
    L17:
        r101.start();
        b r107 = r100.f196576c;
        if (r107 == null) goto L36;
        r107.b();
    L36:
        r100.f196577d = !r100.f196577d;
        return;
    L16:
        r101 = r106;
        goto L17
    L20:
        c r108 = r100.getBottomPanelSwitchTrackView();
        r108.f501377d = Integer.valueOf(r108.f501374a);
        r108.invalidate();
        k14.b r109 = r100.getBottomPanelSwitchThumbView();
        ValueAnimator r110 = r109.f501372f;
        if (r110 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("turnOffAnimator");
        r110 = null;
    L24:
        if (r110.isRunning() == false) goto L29;
        ValueAnimator r111 = r109.f501372f;
        if (r111 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("turnOffAnimator");
        r111 = null;
    L28:
        r111.cancel();
    L29:
        ValueAnimator r112 = r109.f501373g;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("turnOnAnimator");
    L33:
        r101.start();
        b r113 = r100.f196576c;
        if (r113 == null) goto L36;
        r113.a();
        goto L36
    L32:
        r101 = r112;
        goto L33
    }

    public final void setBottomPanelSwitchState(boolean r100) {
        this.f196577d = r100;
        getBottomPanelSwitchTrackView().setTrackState(r100);
        getBottomPanelSwitchThumbView().setThumbState(r100);
    }

    public final void setSwitchListener(b r100) {
        this.f196576c = r100;
    }

    public BottomPanelSwitch(final Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "attributeSet");
        new LinkedHashMap();
        super(r110, r111);
        this.f196574a = LazyKt.lazy(new BottomPanelSwitch$bottomPanelSwitchTrackView$2(r110));
        this.f196575b = LazyKt.lazy(new BottomPanelSwitch$bottomPanelSwitchThumbView$2(r110));
        this.f196577d = true;
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.thumb_color, R.attr.thumb_radius, R.attr.track_corner, R.attr.track_height, R.attr.track_turn_off_color, R.attr.track_turn_on_color, R.attr.track_width});
        float r113 = r112.getDimension(6, e.a(y54.a.a(), 43.0f));
        float r100 = r112.getDimension(3, e.a(y54.a.a(), 25.0f));
        int r101 = r112.getColor(5, -65536);
        int r102 = r112.getColor(4, FakePickerAvatarCreator.GRAY);
        float r103 = r112.getDimension(2, e.a(y54.a.a(), 44.0f));
        float r104 = r112.getDimension(1, e.a(y54.a.a(), 10.5f));
        int r105 = r112.getColor(0, -1);
        r112.recycle();
        c r114 = getBottomPanelSwitchTrackView();
        r114.f501376c = r103;
        r114.f501374a = r101;
        r114.f501375b = r102;
        addView(getBottomPanelSwitchTrackView(), new FrameLayout.LayoutParams((int) r113, (int) r100));
        int r115 = f196573e;
        float r106 = 2 * r104;
        int r116 = (int) ((r113 - r115) - r106);
        final k14.b r107 = getBottomPanelSwitchThumbView();
        r107.f501367a = r105;
        r107.f501368b = r104;
        r107.f501370d = r116;
        r107.f501371e = r115;
        ValueAnimator r108 = ValueAnimator.ofInt(new int[]{r116, r115});
        r108.setDuration(300);
        r108.addUpdateListener(new k14.a(r107));
        r107.f501372f = r108;
        ValueAnimator r109 = ValueAnimator.ofInt(new int[]{r115, r116});
        r109.setDuration(300);
        r109.addUpdateListener(new k14.a(r107));
        r107.f501373g = r109;
        int r117 = (int) r106;
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(r117, r117);
        r118.setMarginStart(r116);
        r118.topMargin = r115;
        addView(getBottomPanelSwitchThumbView(), r118);
        setOnClickListener(new com.bytedance.awemeopen.apps.framework.feed.ui.panelswitch.a(this));
    }
}
