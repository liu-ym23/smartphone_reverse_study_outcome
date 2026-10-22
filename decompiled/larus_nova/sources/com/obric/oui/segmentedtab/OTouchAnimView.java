package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/segmentedtab/OTouchAnimView;", "Landroid/widget/RelativeLayout;", "", "cancelAnim", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OTouchAnimView extends RelativeLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f402744d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f402745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f402746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f402747c;

    public static final class a {
    }

    static {
    }

    public OTouchAnimView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OTouchAnimView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public abstract boolean a();

    public abstract void c(float r100, String r101);

    public final boolean b() {
        ValueAnimator r100 = this.f402746b;
        if (r100 != null) goto L6;
    L4:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L16;
        ValueAnimator r102 = this.f402747c;
        if (r102 != null) goto L13;
    L11:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L16;
        return false;
    L13:
        if (r102.isRunning() != true) goto L11;
        r103 = true;
    L16:
        return true;
    L6:
        if (r100.isRunning() != true) goto L4;
        r101 = true;
        goto L8
    }

    public final void cancelAnim() {
        ValueAnimator r100 = this.f402746b;
        if (r100 == null) goto L6;
        r100.cancel();
    L6:
        ValueAnimator r101 = this.f402747c;
        if (r101 == null) goto L11;
        r101.cancel();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L25;
        if (r101 == 1) goto L9;
        if (r101 == 3) goto L9;
    L41:
        return super.dispatchTouchEvent(r100);
    L9:
        if (a() == false) goto L41;
        ValueAnimator r102 = this.f402746b;
        if (r102 == null) goto L15;
        r102.removeAllUpdateListeners();
    L15:
        ValueAnimator r103 = this.f402746b;
        if (r103 == null) goto L19;
        r103.cancel();
    L19:
        ValueAnimator r104 = this.f402747c;
        if (r104 == null) goto L23;
        r104.cancel();
    L23:
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{this.f402745a, 0.0f});
        r105.setDuration(200);
        r105.setInterpolator(new DecelerateInterpolator());
        r105.addUpdateListener(new f(this));
        r105.start();
        this.f402747c = r105;
        goto L41
    L25:
        if (a() == false) goto L41;
        ValueAnimator r106 = this.f402747c;
        if (r106 == null) goto L31;
        r106.removeAllUpdateListeners();
    L31:
        ValueAnimator r107 = this.f402747c;
        if (r107 == null) goto L35;
        r107.cancel();
    L35:
        ValueAnimator r108 = this.f402746b;
        if (r108 == null) goto L39;
        r108.cancel();
    L39:
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{this.f402745a, 1.0f});
        r109.setDuration(50);
        r109.setInterpolator(new DecelerateInterpolator());
        r109.addUpdateListener(new g(this));
        r109.start();
        this.f402746b = r109;
        goto L41
    }

    public OTouchAnimView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ OTouchAnimView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
