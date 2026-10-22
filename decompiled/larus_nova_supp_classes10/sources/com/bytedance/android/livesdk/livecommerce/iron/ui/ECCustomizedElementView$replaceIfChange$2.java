package com.bytedance.android.livesdk.livecommerce.iron.ui;

import android.animation.Animator;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00032'\u0010\n\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0\u0003H\n¢\u0006\u0002\b\f"}, d2 = {"<anonymous>", "", "ra", "Lkotlin/Function1;", "", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "removeList", "Landroid/animation/Animator;", "aa", "addList", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECCustomizedElementView$replaceIfChange$2 extends Lambda implements Function2<Function1<? super List<? extends View>, ? extends Animator>, Function1<? super List<? extends View>, ? extends Animator>, Unit> {
    final /* synthetic */ ArrayList $list;
    final /* synthetic */ Runnable $removeAndAddView;
    final /* synthetic */ ECCustomizedElementView this$0;

    public ECCustomizedElementView$replaceIfChange$2(ECCustomizedElementView r1, ArrayList r2, Runnable r3) {
        this.this$0 = r1;
        this.$list = r2;
        this.$removeAndAddView = r3;
        super(2);
    }

    public final void invoke(Function1<? super List<? extends View>, ? extends Animator> r5, final Function1<? super List<? extends View>, ? extends Animator> r6) {
        Intrinsics.checkNotNullParameter(r5, "ra");
        Intrinsics.checkNotNullParameter(r6, "aa");
        ECCustomizedElementView r0 = this.this$0;
        r0.i = ECCustomizedElementView.a.b.a;
        ArrayList r1 = this.$list;
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Triple r4 = (Triple) r3.next();
        if (((Boolean) r4.getSecond()).booleanValue() == false) goto L8;
        View r7 = this.this$0.getChildAt(((Number) r4.getFirst()).intValue());
    L9:
        if (r7 == null) goto L4;
        r2.add(r7);
        goto L4
    L8:
        r7 = null;
        goto L9
    L11:
        Animator r8 = (Animator) r5.invoke(r2);
        this.this$0.f = r8;
        com.bytedance.android.livesdk.livecommerce.utils.c.a(r8, new AnonymousClass3(this, r6));
        r8.start();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((Function1) r1, (Function1) r2);
        return Unit.INSTANCE;
    }
}
