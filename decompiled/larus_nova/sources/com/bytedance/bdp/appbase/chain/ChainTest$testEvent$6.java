package com.bytedance.bdp.appbase.chain;

import com.bytedance.bdp.appbase.base.bdptask.BdpPool;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Ljava/lang/Void;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$testEvent$6 extends Lambda implements Function2 {
    final /* synthetic */ Ref.IntRef $eventDelayTestId2;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200675a = null;

        static {
            f200675a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = ChainTest.f200670a;     // Catch: Throwable -> L4
            ChainTest.a.a(false, "event test failed");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ChainTest$testEvent$6(Ref.IntRef r100) {
        this.$eventDelayTestId2 = r100;
        super(2);
    }

    public final Void invoke(f r100, Object r101) {
        Ref.IntRef r102 = this.$eventDelayTestId2;
        r102.element = BdpPool.postLogic(500, a.f200675a);
        throw new ChainTest.TestEvent2();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101) {
        return invoke((f) r100, r101);
    }
}
