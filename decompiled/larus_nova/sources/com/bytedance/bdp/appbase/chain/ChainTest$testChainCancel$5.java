package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "input", "", "tr", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/String;Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testChainCancel$5 extends Lambda implements Function3<f, String, Throwable, Unit> {
    public static final ChainTest$testChainCancel$5 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testChainCancel$5();
    }

    public ChainTest$testChainCancel$5() {
        super(3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(f r100, String r101, Throwable r102) {
        int r103 = ChainTest.f200670a;
        String r104 = null;
        if (r102 == null) goto L5;
        String r105 = r102.getMessage();
    L6:
        ChainTest.a.a(Intrinsics.areEqual("11", r105), "testChainCancel success");
        Object[] r106 = new Object[1];
        StringBuilder r107 = new StringBuilder("testChainCancel ");
        if (r102 == null) goto L9;
        r104 = r102.getMessage();
    L9:
        r107.append(r104);
        r107.append(" success");
        r106[0] = r107.toString();
        g94.b.a("CnTest", r106);
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(f r100, String r101, Throwable r102) {
        invoke2(r100, r101, r102);
        return Unit.INSTANCE;
    }
}
