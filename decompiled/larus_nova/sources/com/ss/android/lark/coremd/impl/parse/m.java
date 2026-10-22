package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.v;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class m implements v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f419912b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<v, Integer, Unit> f419913a;

    public static final class a {
        public static m a(final com.ss.android.lark.coremd.base.parse.i r100, final s r101) {
            Intrinsics.checkNotNullParameter(r100, "parseContext");
            Intrinsics.checkNotNullParameter(r101, "node");
            final com.ss.android.lark.coremd.base.parse.n.b r102 = r100.g().b(r101.getClass());
            if (r102 != null) goto L7;
            return null;
        L7:
            return new m(new ProxyClickSpanInner$Companion$proxyNodeClickInner$1$proxySpan$1(r100, r101, r100, r102));
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function2<? super v, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickRaiser");
        this.f419913a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.v
    public final void a(int r100) {
        this.f419913a.invoke(this, Integer.valueOf(r100));
    }
}
