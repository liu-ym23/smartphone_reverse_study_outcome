package com.ss.android.lark.coremd.impl.parse;

import android.view.View;
import com.ss.android.lark.coremd.base.parse.z;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MarkdownSpanSetterImpl$bindNodeClick$span$1 extends FunctionReferenceImpl implements Function1<View, z<View>> {
    public MarkdownSpanSetterImpl$bindNodeClick$span$1(Object r100) {
        super(1, r100, g.class, "findAdaptersForViewType", "findAdaptersForViewType(Landroid/view/View;)Lcom/ss/android/lark/coremd/base/parse/TextViewAdapter;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final z<View> invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        g r101 = (g) this.receiver;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        Class<?> r102 = r100.getClass();
        z<View> r103 = r101.f419893b.get(r102);
        if (r103 != null) goto L19;
        Iterator<T> r104 = r101.f419893b.keySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        if (((Class) r105).isAssignableFrom(r102) == false) goto L6;
    L11:
        Class r106 = (Class) r105;
        if (r106 == null) goto L15;
        return r101.f419893b.get(r106);
    L15:
        return null;
    L10:
        r105 = null;
        goto L11
    L19:
        return r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ z<View> invoke(View r100) {
        return invoke2(r100);
    }
}
