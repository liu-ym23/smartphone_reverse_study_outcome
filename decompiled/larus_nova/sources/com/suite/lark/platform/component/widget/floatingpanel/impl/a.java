package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.app.Application;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.platform.component.widget.floatingpanel.impl.container.FloatingPanelTopPageViewContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yoc.h;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f460669a;

    @Override // yoc.h
    public final void G6() {
        c r100 = this.f460669a;
        r100.getClass();
        Log.i("FloatingPanelPresenter", "collapseCardList");
        r100.c().c();
    }

    @Override // yoc.h
    public final int c8() {
        c r100 = this.f460669a;
        r100.getClass();
        Log.i("FloatingPanelPresenter", "getCardCount");
        List r101 = CollectionsKt.toList(r100.f460677f);
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator r102 = r101.iterator();
        int r103 = 0;
    L9:
        if (r102.hasNext() == false) goto L19;
        if (((FloatingCardItem) r102.next()).f460662f != R.id.todo_reminder_handler_type_overall) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L9;
        r103 = r103 + 1;
        if (r103 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
        goto L9
    L13:
        r104 = false;
        goto L14
    L19:
        return r103;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return 0;
    }

    public a() {
        FloatingPanelTopPageViewContainer r100 = new FloatingPanelTopPageViewContainer(LarkContext.getApplication());
        Application r101 = LarkContext.getApplication();
        int r102 = com.larksuite.framework.utils.autoscale.a.f285947a;
        this.f460669a = new c(r101, r100, new e());
    }

    @Override // yoc.h
    public final void ra(yoc.c r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        final c r101 = this.f460669a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Log.i("FloatingPanelPresenter", "showCard, id: " + r100.getId());
        int r102 = FloatingCardItem.f460656h;
        String r103 = FloatingCardItem.a.a(r100);
        Iterator r104 = ((ArrayList) r101.f460677f).iterator();
        final int r105 = 0;
        int r106 = 0;
    L4:
        if (r104.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((FloatingCardItem) r104.next()).f460661e, r103) == true) goto L10;
        r106 = r106 + 1;
    L10:
        if (r106 >= 0) goto L13;
        final FloatingCardItem<?> r107 = new FloatingCardItem(r100, r101.f460672a);
        r101.d(r107);
        ListProtector.add(r101.f460677f, 0, r107);
        r101.k(new FloatingPanelPresenter$showCardInner$2(r101, r107, r105));
    L13:
        Long r108 = FloatPanelHitPoint.f460654a;
        FloatPanelHitPoint.b(1, ((ArrayList) r101.f460677f).size());
        return;
    L9:
        r106 = -1;
        goto L10
    }

    @Override // yoc.h
    public final void y2(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "id");
        this.f460669a.h(r100, r101);
    }
}
