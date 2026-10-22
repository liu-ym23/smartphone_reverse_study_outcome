package com.bytedance.dux.window.controller;

import android.view.View;
import android.view.Window;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import hm4.d;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "splitWidth", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 7, 1}, xi = 48)
final class DuxBreakPointController$registerGridChangeListenerDowngrade$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ jm4.b $listener;
    final /* synthetic */ DuxBreakPointController this$0;

    public DuxBreakPointController$registerGridChangeListenerDowngrade$1(DuxBreakPointController r100, jm4.b r101) {
        this.this$0 = r100;
        this.$listener = r101;
        super(1);
    }

    public static View INVOKEVIRTUAL_com_bytedance_dux_window_controller_DuxBreakPointController$registerGridChangeListenerDowngrade$1_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public final void invoke(int r100) {
        ConcurrentHashMap<Integer, d> r101 = b.f205936a;
        DuxBreakPointController r102 = this.this$0;
        int r103 = DuxBreakPointController.f205930a;
        r102.getClass();
        d r104 = b.b();
        List<hm4.b> r105 = hm4.c.f485930c;
        ListIterator<hm4.b> r106 = r105.listIterator(r105.size());
    L4:
        if (r106.hasPrevious() == false) goto L11;
        hm4.b r107 = r106.previous();
        if (r100 < r107.f485928a) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == false) goto L4;
    L12:
        hm4.b r109 = r107;
        if (r109 != null) goto L15;
        r109 = hm4.b.f485918c;
    L15:
        this.$listener.a(new d(r109, r104.f485935c, new hm4.a(r100, r104.f485936d.f485915b)));
        return;
    L8:
        r108 = false;
        goto L9
    L11:
        r107 = null;
        goto L12
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
