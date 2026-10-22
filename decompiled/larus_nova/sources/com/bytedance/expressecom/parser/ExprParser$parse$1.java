package com.bytedance.expressecom.parser;

import com.bytedance.expressecom.util.a;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/expressecom/util/a;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/expressecom/util/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ExprParser$parse$1 extends Lambda implements Function1<a, Unit> {
    final /* synthetic */ String $expr;
    final /* synthetic */ List $words;

    public ExprParser$parse$1(String r100, List r101) {
        this.$expr = r100;
        this.$words = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(a r110) {
        r110.getClass();
        this.$expr.hashCode();
        CollectionsKt.joinToString$default(this.$words, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
