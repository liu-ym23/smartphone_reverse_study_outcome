package com.bytedance.android.shopping.mall.feed.ability;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "p1", "", "p2", "invoke"}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class LegouMallStickyAbility$addPageOpenSchemaListener$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public LegouMallStickyAbility$addPageOpenSchemaListener$1(c r8) {
        super(2, r8, c.class, "onMallOpenSchema", "onMallOpenSchema(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "p1");
        ((c) ((CallableReference) this).receiver).a(r2, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
