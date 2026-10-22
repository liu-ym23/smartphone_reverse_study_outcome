package com.larus.home.impl.main.side_bar.view.group.render;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Object> f345696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f345697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f345698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, n<com.larus.home.impl.main.side_bar.data.j0>> f345699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, k> f345700e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Object r100 = this.f345696a.invoke();
        if (this.f345698c == true) goto L5;
    L7:
        int r101 = this.f345699d.size() + this.f345700e.size();
        if (r101 <= 0) goto L10;
        int r102 = com.larus.home.impl.main.side_bar.feed.arch.t.f344637a;
        com.larus.home.impl.main.side_bar.feed.arch.t.c("list_browse_state_drop", "from=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(this.f345697b) + " to=" + com.larus.home.impl.main.side_bar.feed.arch.t.e(r100) + " dropped=" + r101);
    L10:
        ((LinkedHashMap) this.f345699d).clear();
        ((LinkedHashMap) this.f345700e).clear();
        this.f345697b = r100;
        this.f345698c = true;
        return;
    L5:
        if (Intrinsics.areEqual(this.f345697b, r100) == false) goto L7;
    }

    public o0(n0 r100) {
        Intrinsics.checkNotNullParameter(r100, "currentScopeKey");
        this.f345696a = r100;
        this.f345699d = new LinkedHashMap();
        this.f345700e = new LinkedHashMap();
    }
}
