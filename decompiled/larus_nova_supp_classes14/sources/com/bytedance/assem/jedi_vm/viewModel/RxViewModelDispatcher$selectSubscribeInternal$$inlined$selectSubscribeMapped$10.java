package com.bytedance.assem.jedi_vm.viewModel;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.extensions.n;
import com.bytedance.assem.arch.viewModel.i;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"<anonymous>", "", "R", "S", "Lcom/bytedance/assem/arch/viewModel/VMState;", "it", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V", "com/bytedance/assem/jedi_vm/viewModel/RxViewModelDispatcher$selectSubscribeMapped$6$1", "com/bytedance/assem/jedi_vm/viewModel/RxViewModelDispatcher$selectSubscribeMapped$$inlined$let$lambda$8"}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
public final class RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$10 extends Lambda implements Function1<n<Object, Object, Object, Object, Object>, Unit> {
    final /* synthetic */ i $config$inlined;
    final /* synthetic */ Function1 $onError$inlined;
    final /* synthetic */ LifecycleOwner $owner$inlined;
    final /* synthetic */ Function5 $subscriber$inlined$1;
    final /* synthetic */ f this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0 a;

        public a(AnonymousClass1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$10(f r1, LifecycleOwner r2, i r3, Function1 r4, Function5 r5) {
        this.this$0 = r1;
        this.$owner$inlined = r2;
        this.$config$inlined = r3;
        this.$onError$inlined = r4;
        this.$subscriber$inlined$1 = r5;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.assem.jedi_vm.viewModel.RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$10$1, kotlin.jvm.functions.Function0] */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1190invoke(final n<Object, Object, Object, Object, Object> r3) {
        this.$config$inlined.getClass();
        ?? r0 = new AnonymousClass1(this, r3);
        if (com.bytedance.assem.jedi_vm.store.e.a() == false) goto L5;
        r0.invoke();
        return;
    L5:
        com.bytedance.assem.jedi_vm.store.e.a.post(new a(r0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        m1190invoke(r1);
        return Unit.INSTANCE;
    }
}
