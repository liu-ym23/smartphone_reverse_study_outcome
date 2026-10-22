package com.larus.home.impl.main.side_bar.view.group.render;

import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b0 implements fb9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb9.i f345608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.home.impl.main.side_bar.view.group.datasource.lark.h f345609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public eb9.n f345610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f345611d;

    @Override // fb9.i
    public final List<eb9.o<?>> b(List<? extends eb9.o<?>> r100) {
        Intrinsics.checkNotNullParameter(r100, "cards");
        return this.f345608a.b(r100);
    }

    @Override // fb9.i
    public final void f(eb9.o<?> r100) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        this.f345608a.f(r100);
    }

    @Override // fb9.i
    public final int i(eb9.n r100) {
        Intrinsics.checkNotNullParameter(r100, "selectionKey");
        return this.f345608a.i(r100);
    }

    @Override // fb9.i
    public final eb9.n n() {
        return this.f345608a.n();
    }

    @Override // fb9.i
    public final boolean o() {
        return this.f345608a.o();
    }

    @Override // fb9.i
    public final void h(eb9.n r100) {
        this.f345608a.h(r100);
        s(r100);
    }

    @Override // fb9.i
    public final void l(eb9.n r100) {
        this.f345608a.l(r100);
        s(r100);
    }

    public final void s(eb9.n r100) {
        boolean r101 = false;
        if (this.f345611d == false) goto L17;
        eb9.n r102 = this.f345610c;
        if (r102 != null) goto L7;
        if (r100 != null) goto L7;
    L13:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L17;
        return;
    L7:
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L13;
        r103 = false;
        goto L15
    L9:
        if (r102.a(r100) != true) goto L11;
        r104 = true;
    L17:
        this.f345611d = true;
        this.f345610c = r100;
        com.larus.home.impl.main.side_bar.view.group.datasource.lark.h r105 = this.f345609b;
        Intrinsics.checkNotNullParameter(r105, "<this>");
        String r106 = null;
        if (r100 == null) goto L31;
        int r107 = qb9.a.f532418a;
        Intrinsics.checkNotNullParameter(r100, "selectionKey");
        if (Intrinsics.areEqual(r100.f471903a, "side_bar_human_feed") == false) goto L22;
        eb9.n r108 = r100;
    L23:
        if (r108 == null) goto L31;
        String r109 = r108.f471904b;
        if (r109 == null) goto L31;
        if (r109.length() <= 0) goto L29;
        r101 = true;
    L29:
        if (r101 == false) goto L31;
        r106 = r109;
        goto L31
    L22:
        r108 = null;
    L31:
        int r110 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        StringBuilder r111 = new StringBuilder("renderer=");
        r111.append(com.larus.home.impl.main.side_bar.feed.arch.t.e(r105));
        r111.append(" action=");
        if (r106 != null) goto L34;
        String r112 = "clear";
    L35:
        r111.append(r112);
        r111.append(" id=");
        if (r106 != null) goto L38;
        String r113 = "";
    L39:
        r111.append(r113);
        r111.append(" key=");
        r111.append(r100);
        com.larus.home.impl.main.side_bar.feed.arch.t.c("human_click_hint", r111.toString());
        if (r106 != null) goto L42;
        r105.c();
        return;
    L42:
        r105.f(r106);
        return;
    L38:
        r113 = r106;
        goto L39
    L34:
        r112 = "set";
        goto L35
    }

    public b0(fb9.i r100, com.larus.home.impl.main.side_bar.view.group.datasource.lark.h r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "renderer");
        this.f345608a = r100;
        this.f345609b = r101;
    }
}
