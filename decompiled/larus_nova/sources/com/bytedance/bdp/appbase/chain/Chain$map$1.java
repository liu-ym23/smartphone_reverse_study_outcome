package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00018\u00008\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"N", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "it", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class Chain$map$1 extends Lambda implements Function2<f, Object, Object> {
    final /* synthetic */ j $block;

    public Chain$map$1(j r100) {
        this.$block = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(f r100, Object r101) {
        return this.$block.call(r101, r100);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
