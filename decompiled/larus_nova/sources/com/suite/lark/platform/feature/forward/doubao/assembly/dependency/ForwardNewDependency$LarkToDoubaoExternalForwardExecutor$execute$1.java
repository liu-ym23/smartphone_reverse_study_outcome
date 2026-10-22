package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.log.Log;
import com.suite.lark.platform.feature.forward.doubao.assembly.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mpc.b;
import mpc.c;
import mpc.e;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1", f = "ForwardNewDependency.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IExternalForwardExecutor.a $callback;
    final /* synthetic */ e $doubaoProtocol;
    final /* synthetic */ List<String> $larkMsgIds;
    final /* synthetic */ String $note;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ForwardNewDependency.LarkToDoubaoExternalForwardExecutor this$0;

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IExternalForwardExecutor.a f461306a;

        @Override // mpc.b
        public final void onSuccess() {
            this.f461306a.onSuccess(MapsKt.emptyMap());
        }

        public a(IExternalForwardExecutor.a r100) {
            this.f461306a = r100;
        }

        @Override // mpc.b
        public final void onFailure(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            this.f461306a.onFailure(r101);
        }
    }

    public ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1(e r100, List<String> r101, String r102, ForwardNewDependency.LarkToDoubaoExternalForwardExecutor r103, IExternalForwardExecutor.a r104, Continuation<? super ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1> r105) {
        this.$doubaoProtocol = r100;
        this.$larkMsgIds = r101;
        this.$note = r102;
        this.this$0 = r103;
        this.$callback = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1(this.$doubaoProtocol, this.$larkMsgIds, this.$note, this.this$0, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L11;
        if (r101 != 1) goto L10;
        String r102 = (String) this.L$3;
        String r103 = (String) this.L$2;
        List<String> r104 = (List) this.L$1;
        e r105 = (e) this.L$0;
        ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L31
        String r106 = r102;
        String r107 = r103;
        e r108 = r105;
    L8:
        List<String> r109 = r104;
        boolean r111 = ((Boolean) r110).booleanValue();     // Catch: Throwable -> L31
        ForwardNewDependency.LarkToDoubaoExternalForwardExecutor r112 = this.this$0;     // Catch: Throwable -> L31
        String r113 = r112.f461303d;     // Catch: Throwable -> L31
        boolean r114 = r112.f461304e;     // Catch: Throwable -> L31
        String r115 = r112.f461305f;     // Catch: Throwable -> L31
        if (r114 == false) goto L28;
        boolean r116 = true;
    L29:
        r108.c0(new c(r109, r107, r106, r111, r113, r116, r115), new a(this.$callback));     // Catch: Throwable -> L31
    L38:
        return Unit.INSTANCE;
    L28:
        r116 = false;
        goto L29
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r110);
        e r117 = this.$doubaoProtocol;     // Catch: Throwable -> L31
        r104 = this.$larkMsgIds;     // Catch: Throwable -> L31
        String r118 = this.$note;     // Catch: Throwable -> L31
        String r119 = this.this$0.f461301b;     // Catch: Throwable -> L31
        if ((!StringsKt.isBlank(r119)) == true) goto L16;
        r119 = null;
    L16:
        if (r119 != null) goto L18;
        r119 = d.a();     // Catch: Throwable -> L31
    L18:
        String r120 = this.this$0.f461303d;     // Catch: Throwable -> L31
        this.L$0 = r117;     // Catch: Throwable -> L31
        this.L$1 = r104;     // Catch: Throwable -> L31
        this.L$2 = r118;     // Catch: Throwable -> L31
        this.L$3 = r119;     // Catch: Throwable -> L31
        this.label = 1;     // Catch: Throwable -> L31
        if (StringsKt.isBlank(r120) == false) goto L21;
        Object r121 = Boxing.boxBoolean(false);     // Catch: Throwable -> L31
    L22:
        if (r121 != r100) goto L24;
        return r100;
    L24:
        r106 = r119;
        r108 = r117;
        r110 = r121;
        r107 = r118;
        goto L8
    L21:
        r121 = BuildersKt.withContext(Dispatchers.getIO(), new ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$isSourceGroupChat$2(r120, null), this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        String r122 = "forward to doubao execute failed";
        Log.e("ForwardNewDependency", "forward to doubao execute failed", th);
        IExternalForwardExecutor.a r123 = this.$callback;
        String r124 = th.getMessage();
        if (r124 == null) goto L36;
        r122 = r124;
    L36:
        r123.onFailure(r122);
        goto L38
    }
}
