package com.ss.android.lark.coremd.facade.plugins;

import com.ss.android.lark.coremd.base.theme.BlockQuoteThemeData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class o<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f419792a;

    public o(p r100) {
        this.f419792a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(com.ss.android.lark.coremd.impl.parse.k r110) {
        Intrinsics.checkNotNullParameter(r110, "it");
        BlockQuoteThemeData r100 = com.ss.android.lark.coremd.base.parse.k.f419543b.b(r110.getTheme());
        if (((Boolean) r100.f419548d.getValue(r100, BlockQuoteThemeData.f419547j[0])).booleanValue() == false) goto L27;
        r110.f419905g.a();
        int r101 = r110.f419905g.length();
        this.f419792a.getClass();
        ArrayList r102 = new ArrayList();
        v7b.s r103 = ((v7b.b) r110.f419902d).f553569e;
    L6:
        if (r103 == null) goto L17;
        v7b.s r104 = r103.f553572h;
        if ((r103 instanceof v7b.v) == false) goto L15;
        int r105 = r110.f419905g.length();
        r110.f419904f.a(r103);
        int r106 = r110.f419905g.length();
        if (r105 >= r106) goto L14;
        int r107 = r105 + 1;
        if (Intrinsics.areEqual(r110.f419905g.c(r105, r107), "\n") == false) goto L14;
        r105 = r107;
    L14:
        r102.add(new Triple(r103, Integer.valueOf(r105), Integer.valueOf(r106)));
    L16:
        r103 = r104;
        goto L6
    L15:
        r110.f419904f.a(r103);
        goto L16
    L17:
        Iterator r108 = r102.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        Triple r109 = (Triple) r108.next();
        v7b.v r111 = (v7b.v) r109.component1();
        int r112 = ((Number) r109.component2()).intValue();
        int r113 = ((Number) r109.component3()).intValue();
        com.ss.android.lark.coremd.base.parse.s r114 = r110.f419905g;
        r114.setSpan(new com.ss.android.lark.coremd.impl.buildnode.a(r111, r114.c(r112, r113), false), r112, r113, 34);
        goto L19
    L21:
        com.ss.android.lark.coremd.base.parse.s r115 = r110.f419905g;
        r115.f(r101, r115.length(), 65569);
        return;
    }
}
