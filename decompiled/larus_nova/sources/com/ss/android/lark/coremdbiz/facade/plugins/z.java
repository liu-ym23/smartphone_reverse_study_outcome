package com.ss.android.lark.coremdbiz.facade.plugins;

import android.content.Context;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.widget.table.entity.TableInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class z<T extends v7b.s> implements com.ss.android.lark.coremd.base.parse.q {
    public z() {
    }

    @Override // com.ss.android.lark.coremd.base.parse.q
    public final Object a(final com.ss.android.lark.coremd.impl.parse.i r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        LarkContextExtend.a r101 = LarkContextExtend.f419979s;
        com.ss.android.lark.coremdbiz.facade.table.a r102 = (com.ss.android.lark.coremdbiz.facade.table.a) r101.b(new TablePlugin$configureSpanFactory$1$tableParseFactory$1(r100));
        if (r102 != null) goto L5;
        return null;
    L5:
        eab.h r103 = (eab.h) r100.f419898d;
        Context r104 = r100.getContext();
        final com.ss.android.lark.coremd.impl.parse.m r105 = r100.c();
        final Function1 r106 = (Function1) r101.b(new TablePlugin$configureSpanFactory$1$longPressHandler$1(r100));
        final TableInfo r107 = com.ss.android.lark.coremdbiz.facade.table.d.a(r104, r102, r103);
        return com.ss.android.lark.coremd.ext.b.a(new TablePlugin$configureSpanFactory$1$span$1(r107, r106, r100, r105), new Object[]{r105});
    }
}
