package com.bytedance.ee.bear.bitable.homepage.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\r\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/widget/ScrollHomeViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Lcom/bytedance/ee/bear/list/list/IListAdapter$OnMenuScrollChangeListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "startX", "", "startY", "canScroll", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLast", "", "isFirst", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onMenuStateChanged", "", "document", "Lcom/bytedance/ee/bear/list/dto/Document;", "isOpen", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScrollHomeViewPager extends ViewPager implements d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f213119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f213120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f213121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f213122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f213123e;

    public ScrollHomeViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f213121c = new AtomicBoolean(true);
        addOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        if (r101 != 0) goto L5;
        this.f213119a = r100.getX();
        this.f213120b = r100.getY();
    L31:
        if (this.f213121c.get() == false) goto L33;
    L36:
        boolean r102 = true;
    L37:
        if (r102 == true) goto L39;
    L41:
        return false;
    L39:
        if (super.onInterceptTouchEvent(r100) == false) goto L41;
        return true;
    L33:
        if (getCurrentItem() == 0) goto L36;
        r102 = false;
        goto L37
    L5:
        if (r101 != 1) goto L7;
        this.f213119a = 0.0f;
        this.f213120b = 0.0f;
        goto L31
    L7:
        if (r101 != 2) goto L31;
        float r103 = r100.getX();
        float r104 = r100.getY();
        float r105 = r103 - this.f213119a;
        float r106 = r104 - this.f213120b;
        if (Math.abs(r105) <= Math.abs(r106)) goto L31;
        if (this.f213123e == false) goto L17;
        if (r105 <= 0.0f) goto L17;
        return false;
    L17:
        if (this.f213122d == false) goto L22;
        if (r105 >= 0.0f) goto L22;
        return false;
    L22:
        if (this.f213121c.get() == false) goto L24;
        return true;
    L24:
        if (getCurrentItem() == 0) goto L44;
        return false;
    L44:
        return true;
    }

    public ScrollHomeViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213121c = new AtomicBoolean(true);
        addOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // com.bytedance.ee.bear.list.list.d.c
    public final void h0(Document r100, boolean r101) {
        this.f213121c.set(!r101);
        a.h("ScrollHomeViewPager", "onMenuStateChanged, isOpen: " + r101);
    }
}
