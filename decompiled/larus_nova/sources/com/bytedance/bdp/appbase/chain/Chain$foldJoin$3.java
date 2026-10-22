package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00018\u00008\u00000\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"N", "C", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "input", "Lcom/bytedance/bdp/appbase/chain/b;", "acc", "Lcom/bytedance/bdp/appbase/chain/Chain;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;Lcom/bytedance/bdp/appbase/chain/b;)Lcom/bytedance/bdp/appbase/chain/Chain;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$foldJoin$3 extends Lambda implements Function3<f, Object, b<Object>, Chain<Object>> {
    final /* synthetic */ k $block;

    public Chain$foldJoin$3(k r100) {
        this.$block = r100;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Chain<Object> invoke(f r100, Object r101, b<Object> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Chain<Object> invoke2(f r100, Object r101, b<Object> r102) {
        return this.$block.call(r101, r102, r100);
    }
}
