package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.amap.api.col.s.ce;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010B!\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\f\u0010\u0013R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/NestedScrollFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/locallife/poi/newdetail/widget/trip/a;", ce.f26391f, "Lcom/bytedance/locallife/poi/newdetail/widget/trip/a;", "getListener", "()Lcom/bytedance/locallife/poi/newdetail/widget/trip/a;", "setListener", "(Lcom/bytedance/locallife/poi/newdetail/widget/trip/a;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public class NestedScrollFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f263516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f263517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f263518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f263519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f263520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f263521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f263522g;

    public final a getListener() {
        return this.f263522g;
    }

    public NestedScrollFrameLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f263516a = 20;
        this.f263518c = -1;
    }

    public final void a(MotionEvent r100) {
        int r101 = (r100.getAction() & 65280) >> 8;
        if (r100.getPointerId(r101) != this.f263518c) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.f263519d = (int) r100.getY(r102);
        this.f263518c = r100.getPointerId(r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.getAction();
        if (r101 != 2) goto L11;
        if (this.f263517b == false) goto L11;
        return true;
    L11:
        if (super.onInterceptTouchEvent(r100) == false) goto L13;
        return true;
    L13:
        int r102 = r101 & 255;
        if (r102 != 0) goto L16;
        this.f263520e = (int) r100.getX();
        this.f263519d = (int) r100.getY();
        this.f263518c = r100.getPointerId(0);
    L39:
        return this.f263517b;
    L16:
        if (r102 == 1) goto L36;
        if (r102 != 2) goto L19;
        int r103 = this.f263518c;
        if (r103 != (-1)) goto L27;
        return false;
    L27:
        int r104 = r100.findPointerIndex(r103);
        if (r104 != (-1)) goto L30;
        return false;
    L30:
        int r105 = (int) r100.getX(r104);
        int r106 = (int) r100.getY(r104);
        int r107 = Math.abs(r105 - this.f263520e);
        int r108 = Math.abs(r106 - this.f263519d);
        if (r108 <= this.f263516a) goto L39;
        if (r108 <= r107) goto L39;
        this.f263517b = true;
        this.f263519d = r106;
        ViewParent r109 = getParent();
        if (r109 == null) goto L39;
        r109.requestDisallowInterceptTouchEvent(true);
        goto L39
    L19:
        if (r102 == 3) goto L36;
        if (r102 != 6) goto L39;
        a(r100);
    L36:
        this.f263517b = false;
        this.f263518c = -1;
        goto L39
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        int r101 = r100.getActionMasked();
        if (r101 == 0) goto L57;
        if (r101 == 1) goto L52;
        if (r101 != 2) goto L12;
        int r102 = r100.findPointerIndex(this.f263518c);
        if (r102 != (-1)) goto L30;
        return false;
    L30:
        float r103 = r100.getY(r102);
        float r104 = this.f263519d - r103;
        if (this.f263517b == true) goto L42;
        if (Math.abs(r104) <= this.f263516a) goto L42;
        ViewParent r105 = getParent();
        if (r105 == null) goto L37;
        r105.requestDisallowInterceptTouchEvent(true);
    L37:
        this.f263517b = true;
        if (r104 <= 0) goto L40;
        r104 = r104 - this.f263516a;
        goto L42
    L40:
        r104 = r104 + this.f263516a;
    L42:
        if (this.f263517b == false) goto L63;
        this.f263519d = (int) r103;
        if (this.f263521f == true) goto L48;
        this.f263521f = true;
        a r106 = this.f263522g;
        if (r106 == null) goto L48;
        r106.b();
    L48:
        a r107 = this.f263522g;
        if (r107 == null) goto L63;
        r107.onScroll((int) r104);
    L63:
        return true;
    L12:
        if (r101 == 3) goto L21;
        if (r101 != 5) goto L16;
        int r108 = r100.getActionIndex();
        this.f263519d = (int) r100.getY(r108);
        this.f263518c = r100.getPointerId(r108);
        goto L63
    L16:
        if (r101 != 6) goto L63;
        a(r100);
        this.f263519d = (int) r100.getY(r100.findPointerIndex(this.f263518c));
        goto L63
    L21:
        if (this.f263517b == false) goto L63;
        if (getChildCount() <= 0) goto L63;
        this.f263518c = -1;
        this.f263517b = false;
        this.f263521f = false;
        a r109 = this.f263522g;
        if (r109 == null) goto L63;
        r109.a();
        goto L63
    L52:
        if (this.f263517b == false) goto L63;
        this.f263518c = -1;
        this.f263517b = false;
        this.f263521f = false;
        a r110 = this.f263522g;
        if (r110 == null) goto L63;
        r110.a();
        goto L63
    L57:
        if (getChildCount() != 0) goto L59;
        return false;
    L59:
        a r111 = this.f263522g;
        if (r111 == null) goto L62;
        r111.b();
    L62:
        this.f263519d = (int) r100.getY();
        this.f263518c = r100.getPointerId(0);
        goto L63
    L4:
        return super.onTouchEvent(r100);
    }

    public final void setListener(a r100) {
        this.f263522g = r100;
    }

    public NestedScrollFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f263516a = 20;
        this.f263518c = -1;
    }

    public NestedScrollFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        this.f263516a = 20;
        this.f263518c = -1;
    }
}
