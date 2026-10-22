package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/IllegalArgumentException;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testCatch$8 extends Lambda implements Function2<f, IllegalArgumentException, Unit> {
    public static final ChainTest$testCatch$8 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testCatch$8();
    }

    public ChainTest$testCatch$8() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(f r100, IllegalArgumentException r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, IllegalArgumentException r101) {
        int r102 = ChainTest.f200670a;
        ChainTest.a.a(false, "NullPointerException can not be run here");
    }
}
