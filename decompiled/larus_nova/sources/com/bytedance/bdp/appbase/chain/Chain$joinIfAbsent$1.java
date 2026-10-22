package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"N", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "input", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$joinIfAbsent$1 extends Lambda implements Function2<f, Object, Object> {
    final /* synthetic */ a $absentValue;
    final /* synthetic */ Function2 $block;

    public Chain$joinIfAbsent$1(a r100, Function2 r101) {
        this.$block = r101;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(final f r100, Object r101) {
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = null;
        new Chain$joinIfAbsent$1$hasResult$1(r100, r102);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
