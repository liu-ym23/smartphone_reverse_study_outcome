package com.bytedance.assem.jedi_vm.viewModel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.extensions.l;
import com.bytedance.assem.arch.viewModel.i;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"<anonymous>", "", "R", ExifInterface.LATITUDE_SOUTH, "Lcom/bytedance/assem/arch/viewModel/VMState;", "it", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;)V", "com/bytedance/assem/jedi_vm/viewModel/RxViewModelDispatcher$selectSubscribeMapped$6$1", "com/bytedance/assem/jedi_vm/viewModel/RxViewModelDispatcher$selectSubscribeMapped$$inlined$let$lambda$6"}, k = 3, mv = {1, 1, 16})
public final class RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$6 extends Lambda implements Function1<l<Object, Object, Object>, Unit> {
    final /* synthetic */ i $config$inlined;
    final /* synthetic */ Function1 $onError$inlined;
    final /* synthetic */ LifecycleOwner $owner$inlined;
    final /* synthetic */ Function3 $subscriber$inlined$1;
    final /* synthetic */ f this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f193116a;

        public a(AnonymousClass1 r100) {
            this.f193116a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f193116a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$6(f r100, LifecycleOwner r101, i r102, Function1 r103, Function3 r104) {
        this.this$0 = r100;
        this.$owner$inlined = r101;
        this.$config$inlined = r102;
        this.$onError$inlined = r103;
        this.$subscriber$inlined$1 = r104;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.assem.jedi_vm.viewModel.RxViewModelDispatcher$selectSubscribeInternal$$inlined$selectSubscribeMapped$6$1, kotlin.jvm.functions.Function0] */
    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m8300invoke(final l<Object, Object, Object> r100) {
        this.$config$inlined.getClass();
        ?? r101 = new AnonymousClass1(this, r100);
        if (com.bytedance.assem.jedi_vm.store.e.a() == false) goto L5;
        r101.invoke();
        return;
    L5:
        com.bytedance.assem.jedi_vm.store.e.f193107a.post(new a(r101));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(l<Object, Object, Object> r100) {
        m8300invoke(r100);
        return Unit.INSTANCE;
    }
}
