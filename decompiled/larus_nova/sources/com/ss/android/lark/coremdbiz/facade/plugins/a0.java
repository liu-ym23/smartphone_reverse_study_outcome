package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkTableThemeData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class a0<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f420100a;

    public a0(b0 r100) {
        this.f420100a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.t
    public final void a(final com.ss.android.lark.coremd.impl.parse.k r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.f419905g.a();
        int r101 = r100.f419905g.length();
        LarkTableThemeData r102 = (LarkTableThemeData) LarkThemeExtend.f419998m.b(new TablePlugin$configureVisitor$1$themeData$1(r100));
        if (((Boolean) r102.f420075d.getValue(r102, LarkTableThemeData.f420074e[0])).booleanValue() == true) goto L11;
        this.f420100a.getClass();
        Iterator<T> r103 = ((eab.h) r100.f419902d).f471754l.iterator();
    L6:
        if (r103.hasNext() == false) goto L15;
        Iterator<T> r104 = ((eab.h.b) r103.next()).f471764d.iterator();
    L9:
        if (r104.hasNext() == false) goto L6;
        eab.h.a r105 = (eab.h.a) r104.next();
        r100.f419904f.a(r105.f471760f);
        goto L9
    L15:
        return;
    L11:
        r100.f419905g.d(uec.a.a());
        com.ss.android.lark.coremd.base.parse.s.a.c(r100.f419905g, r101, 0, 6);
        com.ss.android.lark.coremd.base.parse.s.a.a(r100.f419905g, r101);
        r100.f419905g.a();
    }
}
