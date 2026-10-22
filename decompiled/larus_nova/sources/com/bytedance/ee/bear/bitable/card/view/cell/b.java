package com.bytedance.ee.bear.bitable.card.view.cell;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes15.dex */
public interface b<V, E> {

    public interface a {
        void a(Object r100, String r101);

        void b(Object r100);
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.b$b, reason: collision with other inner class name */
    public interface InterfaceC2994b {
    }

    void K2(boolean r100);

    void M2(boolean r100);

    boolean O2(MotionEvent r100);

    void Z(a r100);

    void b0();

    void l2(dp4.a<V> r100);

    void m2();

    void onViewAttachedToWindow();

    void onViewDetachedFromWindow();

    void onViewRecycled();

    void q1(InterfaceC2994b r100);

    void u();

    boolean v2();
}
