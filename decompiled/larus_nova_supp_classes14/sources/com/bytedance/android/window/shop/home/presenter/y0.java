package com.bytedance.android.window.shop.home.presenter;

import com.bytedance.android.window.shop.WindowLaunchTask;
import com.bytedance.android.window.shop.repository.vo.ShopComponentResponseVO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class y0<T> implements Observer {
    public final /* synthetic */ ECWindowFloatLayerPresenter a;
    public final /* synthetic */ Ref.BooleanRef b;

    public y0(ECWindowFloatLayerPresenter r1, Ref.BooleanRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onChanged(Object r7) {
        ShopComponentResponseVO r8 = (ShopComponentResponseVO) r7;
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r0 = this.a.O().getPipeline();
        if (r0 == null) goto L5;
        r0.c(WindowLaunchTask.i);
    L5:
        List<com.bytedance.android.ec.window.base.repository.vo.d> r1 = r8.getComponents();
        ArrayList r2 = new ArrayList();
        Iterator<T> r3 = r1.iterator();
    L6:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L13;
        T r5 = r3.next();
        if (((com.bytedance.android.ec.window.base.repository.vo.d) r5).b() != 1) goto L11;
        r4 = true;
    L11:
        if (r4 == false) goto L6;
        r2.add(r5);
        goto L6
    L13:
        Iterator r6 = r2.iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        com.bytedance.android.ec.window.base.repository.vo.d r9 = (com.bytedance.android.ec.window.base.repository.vo.d) r6.next();
        this.b.element = true;
        ECWindowFloatLayerPresenter r10 = this.a;
        ECWindowFloatLayerPresenter.Z(r10, r9, r10.O().getMetaInfo());
        goto L15
    L17:
        com.bytedance.android.ec.window.base.common.taskgraph.b<?> r11 = this.a.O().getPipeline();
        if (r11 == null) goto L20;
        r11.b(WindowLaunchTask.i, Unit.INSTANCE);
    L20:
        boolean r12 = com.bytedance.android.ec.window.base.shop.j.a;
        com.bytedance.android.ec.window.base.shop.j.a(this.a.u().c(), !this.b.element, this.a.I());
        List<com.bytedance.android.ec.window.base.repository.vo.d> r13 = r8.getComponents();
        if ((r13 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r14 = r13.iterator();
    L27:
        if (r14.hasNext() == false) goto L34;
        if (((com.bytedance.android.ec.window.base.repository.vo.d) r14.next()).b() != 1) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L27;
    L35:
        if (r4 == false) goto L49;
        this.a.O().getShowPopupWindowLiveData().setValue(Boolean.TRUE);
        return;
    L49:
        return;
    L31:
        r15 = false;
    L34:
        r4 = true;
        goto L35
    L23:
        if (r13.isEmpty() == false) goto L25;
        goto L25
    }
}
