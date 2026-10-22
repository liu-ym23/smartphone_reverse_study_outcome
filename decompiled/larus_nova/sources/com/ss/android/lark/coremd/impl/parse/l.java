package com.ss.android.lark.coremd.impl.parse;

import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.base.parse.t;
import com.ss.android.lark.coremd.base.parse.u;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements u, f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, t<s>> f419906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f419907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MarkdownSpanSetterImpl f419908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f419909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SpannableStringBuilder f419910e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, t<s>> f419911a;

        public a() {
            this.f419911a = new LinkedHashMap();
        }

        public final a a(Class r100, t r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, "nodeHandler");
            this.f419911a.put(r100, r101);
            return this;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.ss.android.lark.coremd.base.parse.u
    public final void b() {
        this.f419909d = true;
    }

    @Override // com.ss.android.lark.coremd.base.parse.u, v7b.f0
    public final void a(s r110) {
        Intrinsics.checkNotNullParameter(r110, "node");
        if (this.f419909d == false) goto L5;
        return;
    L5:
        List<com.ss.android.lark.coremd.base.parse.f> r100 = this.f419907b.f419881h;
        t<s> r101 = this.f419906a.get(r110.getClass());
        n r102 = new n(r110, this.f419910e, this.f419908c, this.f419907b);
        k r103 = new k(this.f419907b, r110, this.f419908c, this, r102);
        List<com.ss.android.lark.coremd.base.parse.f> r104 = r100;
        Iterator<T> r105 = r104.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        ((com.ss.android.lark.coremd.base.parse.f) r105.next()).f(r103);
        goto L7
    L9:
        if (r101 == null) goto L11;
        r101.a(r103);
    L12:
        Iterator<T> r111 = r104.iterator();
    L14:
        if (r111.hasNext() == false) goto L16;
        ((com.ss.android.lark.coremd.base.parse.f) r111.next()).d(r103);
        goto L14
    L16:
        return;
    L11:
        c(r110);
        goto L12
    }

    @Override // com.ss.android.lark.coremd.base.parse.u
    public final void c(s r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        s r101 = r100.f553569e;
    L3:
        if (r101 == null) goto L8;
        s r102 = r101.f553572h;
        r101.c(this);
        if (this.f419909d == true) goto L6;
        r101 = r102;
        goto L3
    L6:
        return;
    }

    public l(Map<Class<?>, t<s>> r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "visitHandlers");
        Intrinsics.checkNotNullParameter(r101, "parseContext");
        this.f419906a = r100;
        this.f419907b = r101;
        this.f419908c = new MarkdownSpanSetterImpl(r101);
        SpannableStringBuilder r102 = new SpannableStringBuilder();
        r102.setSpan(r101.f419882i, 0, 0, 18);
        this.f419910e = r102;
    }
}
