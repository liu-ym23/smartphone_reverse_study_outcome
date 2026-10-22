package com.bytedance.ee.bear.tts.impl.model;

import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.permission.model.DocUserPermissions;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import wh5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/permission/TtsPermissionBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.model.TtsPermissionModel$reload$2", f = "TtsPermissionModel.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"disposable"}, s = {"L$0"})
public final class TtsPermissionModel$reload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ro5.a>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TtsPermissionModel this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ i<IDocUserPermission> a;

        public a(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            IDocUserPermission r4 = (IDocUserPermission) r3;
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("TtsPermissionModel", "reloadM3U8Bean-RX_next, get respond success");
            this.a.resumeWith(Result.constructor-impl(r4));
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ i<IDocUserPermission> a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            if (this.a.isActive() == false) goto L6;
            tt5.a.i("TtsPermissionModel", "reloadM3U8Bean-RX_error:", r4);
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public static final class c implements Action {
        public final /* synthetic */ i<IDocUserPermission> a;

        public c(j r1) {
            this.a = r1;
        }

        public final void run() {
            if (this.a.isActive() == false) goto L6;
            tt5.a.h("TtsPermissionModel", "reloadM3U8Bean-RX_complete");
            this.a.resumeWith(Result.constructor-impl(null));
            return;
        }
    }

    public TtsPermissionModel$reload$2(TtsPermissionModel r1, Continuation<? super TtsPermissionModel$reload$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new TtsPermissionModel$reload$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ro5.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        TtsPermissionModel r2 = (TtsPermissionModel) this.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r8);
    L14:
        IDocUserPermission r9 = (IDocUserPermission) r8;
        Disposable r4 = (Disposable) r3.element;
        if (r4 == null) goto L17;
        r4.dispose();
    L17:
        TtsPermissionModel r5 = this.this$0;
        r5.d = true;
        ro5.a r6 = new ro5.a();
        this.this$0.getClass();
        if (r9 != null) goto L20;
        DocUserPermissions r10 = null;
    L33:
        r6.a = r10;
        r5.c = r6;
        return this.this$0.c;
    L20:
        DocUserPermissions r7 = new DocUserPermissions();
        if (r9.canRead() == false) goto L23;
        DocUserPermissions.EState r11 = DocUserPermissions.EState.ALLOW;
    L24:
        r7.a = r11;
        if (r9.canPreview() == false) goto L27;
        DocUserPermissions.EState r12 = DocUserPermissions.EState.ALLOW;
    L28:
        r7.b = r12;
        if (r9.canPerceive() == false) goto L31;
        DocUserPermissions.EState r13 = DocUserPermissions.EState.ALLOW;
    L32:
        r7.c = r13;
        r10 = r7;
        goto L33
    L31:
        r13 = DocUserPermissions.EState.DENY;
        goto L32
    L27:
        r12 = DocUserPermissions.EState.DENY;
        goto L28
    L23:
        r11 = DocUserPermissions.EState.DENY;
        goto L24
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        TtsPermissionModel r15 = this.this$0;
        this.L$0 = r14;
        this.L$1 = r15;
        this.label = 1;
        j r16 = new j(IntrinsicsKt.intercepted(this), 1);
        r16.C();
        r14.element = new d().c(r15.a, r15.b).subscribe(new a(r16), new b(r16), new c(r16));
        r16.i(new TtsPermissionModel$reload$2$userPermission$1$4(r14));
        Object r17 = r16.B();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r17 != r0) goto L13;
        return r0;
    L13:
        r3 = r14;
        r8 = r17;
        goto L14
    }
}
