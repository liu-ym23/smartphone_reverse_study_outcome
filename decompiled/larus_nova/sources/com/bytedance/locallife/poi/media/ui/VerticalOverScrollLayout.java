package com.bytedance.locallife.poi.media.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001a\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016B!\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0012\u0010\u0019J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/VerticalOverScrollLayout;", "Landroid/widget/RelativeLayout;", "Landroidx/core/view/NestedScrollingParent2;", "", "enable", "", "setTopOverScroll", "setBottomOverScroll", "Lcom/bytedance/locallife/poi/media/ui/a;", "h", "Lcom/bytedance/locallife/poi/media/ui/a;", "getListener", "()Lcom/bytedance/locallife/poi/media/ui/a;", "setListener", "(Lcom/bytedance/locallife/poi/media/ui/a;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class VerticalOverScrollLayout extends RelativeLayout implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f262835i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NestedScrollingParentHelper f262836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f262837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f262838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f262839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f262840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f262841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f262842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.locallife.poi.media.ui.a f262843h;

    public static final class a {
    }

    public final class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            return 1 - ((float) Math.pow(0.8f, r100 * 2));
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public final boolean onNestedFling(View r100, float r101, float r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        return false;
    }

    public final com.bytedance.locallife.poi.media.ui.a getListener() {
        return this.f262843h;
    }

    public VerticalOverScrollLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f262836a = new NestedScrollingParentHelper(this);
        this.f262837b = new b();
    }

    public final void a(int r100) {
        float r101 = 500;
        float r102 = (getScrollY() + r100) / r101;
        b r103 = this.f262837b;
        float r104 = Math.abs(r102);
        r103.getClass();
        int r105 = (int) (((((float) Math.log(1 - r104)) / ((float) Math.log(0.8f))) / 2) * r101);
        this.f262839d = r105;
        if (r102 >= 0) goto L5;
        r105 = -r105;
    L5:
        this.f262839d = r105;
        scrollBy(0, r100);
    }

    public final void b(int r100) {
        if (r100 > 0) goto L4;
    L5:
        if (r100 < 0) goto L7;
    L9:
        this.f262839d = r100;
        float r101 = 500;
        int r102 = (int) (r101 * this.f262837b.getInterpolation(Math.abs(r100 / r101)));
        if (this.f262839d >= 0) goto L12;
        scrollTo(0, -r102);
        return;
    L12:
        scrollTo(0, r102);
        return;
    L7:
        if (this.f262841f == true) goto L9;
        return;
    L4:
        if (this.f262842g == true) goto L5;
    }

    public final void setBottomOverScroll(boolean r100) {
        this.f262842g = r100;
    }

    public final void setListener(com.bytedance.locallife.poi.media.ui.a r100) {
        this.f262843h = r100;
    }

    public final void setTopOverScroll(boolean r100) {
        this.f262841f = r100;
    }

    public VerticalOverScrollLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f262836a = new NestedScrollingParentHelper(this);
        this.f262837b = new b();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f262836a.onStopNestedScroll(r100);
        if (this.f262839d == 0) goto L22;
        ValueAnimator r102 = this.f262840e;
        if (r102 == null) goto L7;
        r102.cancel();
    L7:
        ValueAnimator r103 = ValueAnimator.ofInt(new int[]{this.f262839d, 0});
        this.f262840e = r103;
        if (r103 == null) goto L11;
        r103.setInterpolator(new DecelerateInterpolator());
    L11:
        ValueAnimator r104 = this.f262840e;
        if (r104 == null) goto L15;
        r104.setDuration(200);
    L15:
        ValueAnimator r105 = this.f262840e;
        if (r105 == null) goto L18;
        r105.addUpdateListener(new f(this));
    L18:
        ValueAnimator r106 = this.f262840e;
        if (r106 == null) goto L23;
        r106.start();
        return;
    L23:
        return;
    }

    @Override // android.view.View
    public final void scrollTo(int r100, int r101) {
        com.bytedance.locallife.poi.media.ui.a r102 = this.f262843h;
        if (r102 == null) goto L5;
        r102.b(r101);
    L5:
        super.scrollTo(r100, r101);
    }

    public VerticalOverScrollLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f262836a = new NestedScrollingParentHelper(this);
        this.f262837b = new b();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f262836a.onNestedScrollAccepted(r100, r101, r102);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        this.f262838c = r102;
        ValueAnimator r104 = this.f262840e;
        if (r104 == null) goto L6;
        r104.cancel();
    L6:
        return isEnabled();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        int r105 = getScrollY();
        if (r105 <= 0) goto L9;
        if (r102 >= 0) goto L9;
        if ((r105 + r102) < 0) goto L8;
        r103[1] = r102;
        a(r102);
        return;
    L8:
        int r106 = -r105;
        a(r106);
        r103[1] = r106;
        return;
    L9:
        if (r105 >= 0) goto L18;
        if (r102 > 0) goto L12;
        return;
    L12:
        if ((r105 + r102) > 0) goto L14;
        r103[1] = r102;
        a(r102);
        return;
    L14:
        int r107 = -r105;
        a(r107);
        r103[1] = r107;
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f262838c != 2) goto L8;
        if (r104 == 0) goto L9;
        if (r105 != 0) goto L10;
        b(this.f262839d + r104);
        return;
    L10:
        return;
    L9:
        return;
    }
}
