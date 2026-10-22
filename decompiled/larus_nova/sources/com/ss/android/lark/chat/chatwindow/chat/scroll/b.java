package com.ss.android.lark.chat.chatwindow.chat.scroll;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements com.ss.android.lark.chat.chatwindow.chat.a.InterfaceC4798a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollBottomController f413539a;

    public static final class a implements ScrollBottomController.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y6b.c<?> f413540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ScrollBottomController.e f413541b;

        public a(y6b.c<?> r100, ScrollBottomController.e r101) {
            this.f413540a = r100;
            this.f413541b = r101;
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.scroll.ScrollBottomController.c
        public final void a(ScrollBottomController.d r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            y6b.c<?> r101 = this.f413540a;
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f413533f = r101;
            this.f413541b.c(r100);
        }
    }

    public b(ScrollBottomController r100) {
        this.f413539a = r100;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.a.InterfaceC4798a
    public final Object a(y6b.c<?> r100, y6b.c<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        List r102 = p.a(this.f413539a.f413522b.keySet());
        ScrollBottomController r103 = this.f413539a;
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L15;
        ScrollBottomController.e r105 = (ScrollBottomController.e) r104.next();
        Intrinsics.checkNotNull(r105);
        Function2<y6b.c<?>, y6b.c<?>, Boolean> r106 = r103.f413522b.get(r105);
        if (r106 == null) goto L8;
        Boolean r107 = r106.invoke(r100, r101);
    L10:
        if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L4;
        return new a(r101, r105);
    L8:
        r107 = null;
        goto L10
    L15:
        return Unit.INSTANCE;
    }
}
