package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "input", "", "tr", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testChainCancel$3 extends Lambda implements Function3 {
    public static final ChainTest$testChainCancel$3 INSTANCE = null;

    static {
        INSTANCE = new ChainTest$testChainCancel$3();
    }

    public ChainTest$testChainCancel$3() {
        super(3);
    }

    public final Void invoke(f r100, String r101, Throwable r102) {
        int r103 = ChainTest.f200670a;
        if (r102 == null) goto L5;
        String r104 = r102.getMessage();
    L6:
        ChainTest.a.a(Intrinsics.areEqual("1", r104), "testChainCancel success");
        throw new CancelEvent("11");
    L5:
        r104 = null;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102) {
        return invoke((f) r100, (String) r101, (Throwable) r102);
    }
}
