package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"N", "R", "Lcom/bytedance/bdp/appbase/chain/f;", "data", "", "tr", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class Chain$joinIfAbsent$1$cn$1 extends Lambda implements Function3<f, Object, Throwable, Object> {
    final /* synthetic */ Chain$joinIfAbsent$1 this$0;

    public Chain$joinIfAbsent$1$cn$1(Chain$joinIfAbsent$1 r100) {
        this.this$0 = r100;
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(f r100, Object r101, Throwable r102) {
        if (r102 == null) goto L6;
        this.this$0.getClass();
        throw null;
    L6:
        this.this$0.getClass();
        throw null;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(f r100, Object r101, Throwable r102) {
        return invoke2(r100, r101, r102);
    }
}
