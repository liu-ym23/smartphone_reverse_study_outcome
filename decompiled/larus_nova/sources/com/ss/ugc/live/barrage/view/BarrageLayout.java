package com.ss.ugc.live.barrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import plc.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/ss/ugc/live/barrage/view/BarrageLayout;", "Landroid/view/View;", "Lplc/a;", "", "enable", "", "setEnableTouch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barrage_release"}, k = 1, mv = {1, 4, 0})
public final class BarrageLayout extends View implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<AbsBarrageController> f458170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsBarrageController f458171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f458172c;

    public BarrageLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BarrageLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<AbsBarrageController> r100 = this.f458170a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().m();
        goto L4
    }

    @Override // plc.a
    public final void a(AbsBarrageController r100) {
        int r101 = this.f458170a.size();
        if (r100 == null) goto L6;
        ListProtector.add(this.f458170a, r101, r100);
        return;
    }

    @Override // plc.a
    public final void b(AbsBarrageController r100) {
        if (r100 == null) goto L5;
        this.f458170a.remove(r100);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        int r101 = this.f458170a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        AbsBarrageController r103 = (AbsBarrageController) ListProtector.get(this.f458170a, r102);
        r103.d(r100);
        r103.c(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f458172c == false) goto L35;
        int r101 = r100.getAction();
        if (r101 == 0) goto L25;
        if (r101 != 1) goto L8;
        AbsBarrageController r102 = this.f458171b;
        if (r102 != null) goto L36;
    L33:
        return super.onTouchEvent(r100);
    L36:
        boolean r103 = r102.k(r100);     // Catch: Throwable -> L22
        this.f458171b = null;
        return r103;
    L22:
        th = move-exception;
        this.f458171b = null;
        throw th;
    L8:
        if (r101 != 2) goto L10;
    L12:
        AbsBarrageController r104 = this.f458171b;
        if (r104 == null) goto L33;
        return r104.k(r100);
    L10:
        if (r101 == 3) goto L12;
    L25:
        Iterator<AbsBarrageController> r105 = this.f458170a.iterator();
    L27:
        if (r105.hasNext() == false) goto L33;
        AbsBarrageController r106 = r105.next();
        if (r106.k(r100) == false) goto L27;
        this.f458171b = r106;
        return true;
    L35:
        return super.onTouchEvent(r100);
    }

    @Override // plc.a
    public void setEnableTouch(boolean r100) {
        this.f458172c = r100;
    }

    public BarrageLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f458170a = new ArrayList();
        this.f458172c = true;
    }

    public /* synthetic */ BarrageLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
