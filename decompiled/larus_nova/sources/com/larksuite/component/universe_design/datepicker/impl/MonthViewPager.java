package com.larksuite.component.universe_design.datepicker.impl;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import com.larksuite.component.universe_design.datepicker.impl.infinite.InfiniteViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o08.b;
import p08.c;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/MonthViewPager;", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "viewPageListener", "Lcom/larksuite/component/universe_design/datepicker/impl/listener/IMonthViewListener;", "setViewPageListener", "", "initView", "scrollToPage", "offset", "", "getCenterViewHeight", "getCenterView", "Lcom/larksuite/component/universe_design/datepicker/impl/monthview/MonthView;", "getRightView", "getLeftView", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MonthViewPager extends InfiniteViewPager {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f284793h;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MonthViewPager f284794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f284795b;

        @Override // o08.b
        public final void a() {
            MonthCalendarViewAdapter r100 = (MonthCalendarViewAdapter) this.f284794a.getAdapter();
            if (r100 == null) goto L5;
            r100.i();
        L5:
            int r101 = this.f284795b;
            if (r101 >= 0) goto L10;
            c r102 = this.f284794a.f284793h;
            if (r102 == null) goto L15;
            r102.b();
            return;
        L15:
            return;
        L10:
            if (r101 <= 0) goto L17;
            c r103 = this.f284794a.f284793h;
            if (r103 == null) goto L18;
            r103.a();
            return;
        L18:
            return;
        }

        public a(MonthViewPager r100, int r101) {
            this.f284794a = r100;
            this.f284795b = r101;
        }
    }

    public final q08.c getCenterView() {
        PagerAdapter r100 = getAdapter();
        if ((r100 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r101 = (MonthCalendarViewAdapter) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return (q08.c) r101.g(1);
    L5:
        r101 = null;
        goto L6
    }

    public final int getCenterViewHeight() {
        q08.c r100 = getCenterView();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getCurrentHeight();
    }

    public final q08.c getLeftView() {
        PagerAdapter r100 = getAdapter();
        if ((r100 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r101 = (MonthCalendarViewAdapter) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return (q08.c) r101.g(0);
    L5:
        r101 = null;
        goto L6
    }

    public final q08.c getRightView() {
        PagerAdapter r100 = getAdapter();
        if ((r100 instanceof MonthCalendarViewAdapter) == false) goto L5;
        MonthCalendarViewAdapter r101 = (MonthCalendarViewAdapter) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return (q08.c) r101.g(2);
    L5:
        r101 = null;
        goto L6
    }

    public MonthViewPager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void h(int r100) {
        if (r100 <= 0) goto L5;
        int r101 = 2;
    L6:
        this.f284818e = true;
        this.f284815b = false;
        setCurrentItem(r101, true);
        setOnSmoothScrollFinishListener(new a(this, r100));
        return;
    L5:
        r101 = 0;
        goto L6
    }

    public final void setViewPageListener(c r100) {
        this.f284793h = r100;
    }

    public MonthViewPager(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setWillNotDraw(false);
        setOffscreenPageLimit(3);
        m08.b r102 = new m08.b(this);
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (this.f284816c != null) goto L5;
        this.f284816c = new ArrayList();
    L5:
        List<o08.c> r103 = this.f284816c;
        if (r103 == null) goto L9;
        ((ArrayList) r103).add(r102);
        return;
    }
}
