package com.bytedance.bdp.appbase.chain;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ChainTest$chainLockCaseOnce$1 extends Lambda implements Function2<f, Object, String> {
    final /* synthetic */ String $id;
    final /* synthetic */ String $lockA;
    final /* synthetic */ o $lockB;

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.chain.ChainTest$chainLockCaseOnce$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class AnonymousClass1 extends Lambda implements Function2<f, Object, Unit> {
        final /* synthetic */ ChainTest$chainLockCaseOnce$1 this$0;

        public AnonymousClass1(ChainTest$chainLockCaseOnce$1 r100) {
            this.this$0 = r100;
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(f r100, Object r101) {
            this.this$0.$lockB.getClass();
            new StringBuilder("lockB run id:").append(this.this$0.$id);
            throw null;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(f r100, Object r101) {
            invoke2(r100, r101);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdp.appbase.chain.ChainTest$chainLockCaseOnce$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/f;", "", "it", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/bdp/appbase/chain/f;Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class AnonymousClass2 extends Lambda implements Function2<f, Unit, Unit> {
        final /* synthetic */ f0 $suspend;
        final /* synthetic */ ChainTest$chainLockCaseOnce$1 this$0;

        public AnonymousClass2(ChainTest$chainLockCaseOnce$1 r100, f0 r101) {
            this.this$0 = r100;
            this.$suspend = r101;
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(f r100, Unit r101) {
            this.$suspend.b("result:" + this.this$0.$lockA);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(f r100, Unit r101) {
            invoke2(r100, r101);
            return Unit.INSTANCE;
        }
    }

    public ChainTest$chainLockCaseOnce$1(o r100, String r101, String r102) {
        this.$lockB = r100;
        this.$id = r101;
        this.$lockA = r102;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(f r100, Object r101) {
        this.$lockB.getClass();
        new StringBuilder("lock1 id:").append(this.$id);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(f r100, Object r101) {
        return invoke2(r100, r101);
    }
}
