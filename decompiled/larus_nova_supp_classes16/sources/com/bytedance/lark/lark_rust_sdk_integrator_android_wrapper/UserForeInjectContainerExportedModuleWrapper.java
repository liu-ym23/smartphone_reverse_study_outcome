package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.lark_rust_sdk_integrator_android.BufferCallStatus;
import com.bytedance.lark.lark_rust_sdk_integrator_android.NativeLib;
import com.bytedance.lark.lark_rust_sdk_integrator_android.RustBuffer;
import com.bytedance.lark.lark_rust_sdk_integrator_android.UnhandledException;
import com.bytedance.lark.lark_rust_sdk_integrator_android.h;
import com.bytedance.lark.lark_rust_sdk_integrator_android.k;
import com.bytedance.lark.lark_rust_sdk_integrator_android.l;
import com.bytedance.lark.view_flow_wrapper.MoltenService;
import com.bytedance.lark.view_flow_wrapper.v;
import com.squareup.wire.ProtoAdapter;
import com.sun.jna.Pointer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import lark_rust_sdk_integrator.proto.FuncParamsX925422bfc7fd1ded;
import lark_rust_sdk_integrator.proto.FuncReturnXbb91683c8a1151f8;
import lark_rust_sdk_integrator.proto.UserForegroundScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UserForeInjectContainerExportedModuleWrapper extends MoltenService<k> {
    public final Lazy e;

    /* JADX INFO: renamed from: com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.UserForeInjectContainerExportedModuleWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/UserForeInjectContainerExportedModule;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.UserForeInjectContainerExportedModuleWrapper$1", f = "UserForeInjectContainerExportedModuleWrapper.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super k>, Object> {
        final /* synthetic */ l $param0;
        final /* synthetic */ v $strategy;
        int label;

        public AnonymousClass1(v r1, l r2, Continuation<? super AnonymousClass1> r3) {
            this.$strategy = r1;
            this.$param0 = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass1(this.$strategy, this.$param0, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super k> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r13);
        L11:
            l r14 = this.$param0;
            Intrinsics.checkNotNullParameter(r14, "arg0");
            com.bytedance.lark.lark_rust_sdk_integrator_android.d r2 = com.bytedance.lark.lark_rust_sdk_integrator_android.d.a;
            NativeLib.Companion r3 = NativeLib.Companion;
            String r5 = null;
            k r6 = null;
            com.bytedance.lark.lark_rust_sdk_integrator_android.e r4 = new com.bytedance.lark.lark_rust_sdk_integrator_android.e(null, "getUserForeInjectContainerExportedModule");
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "info");
            r14.getClass();
            FuncParamsX925422bfc7fd1ded r7 = new FuncParamsX925422bfc7fd1ded(new UserForegroundScope(0L), null);
            int r16 = FuncParamsX925422bfc7fd1ded.ADAPTER.encodedSize(r7);
            if (r16 <= 0) goto L14;
            RustBuffer.Companion.getClass();
            RustBuffer.ByValue r17 = RustBuffer.a.a(r16);
            Pointer r8 = r17.data;
            Intrinsics.checkNotNull(r8);
            h r9 = new h(r8);
            r7.encode(r9);
            r9.close();
        L15:
            BufferCallStatus.ByValue r18 = NativeLib.Companion.a().molten_ffi_lark_rust_sdk_integrator_call(NativeLib.Companion.b(), new Pointer(0), 4846092254770582297L, r17);
            int r10 = r18.code;
            if (r10 != 0) goto L24;
            RustBuffer.ByValue r19 = r18.data;
            ProtoAdapter r11 = FuncReturnXbb91683c8a1151f8.ADAPTER;
            RustBuffer.Companion.getClass();
            Long r110 = ((FuncReturnXbb91683c8a1151f8) r11.decode(RustBuffer.a.b(r19))).ret;
            if (r110 == null) goto L20;
            r6 = new k(new Pointer(r110.longValue()));
        L20:
            if (r6 == null) goto L23;
            return r6;
        L23:
            throw new IllegalArgumentException("exported module accessed before ready".toString());
        L24:
            if (r10 == 1) goto L46;
            if (r10 != 2) goto L43;
            RustBuffer.ByValue r12 = r18.data;
            int r20 = r12.len;
            if (r20 > 0) goto L47;
            UnhandledException r111 = new UnhandledException("Rust panic");
            Intrinsics.checkNotNullParameter(r111, "e");
            throw r111;
        L47:
            Pointer r21 = r12.data;     // Catch: Throwable -> L38
            if (r21 == null) goto L32;
            byte[] r22 = r21.getByteArray(0, r20);     // Catch: Throwable -> L38
        L33:
            if (r22 == null) goto L35;
            r5 = new String(r22, Charsets.UTF_8);     // Catch: Throwable -> L38
        L35:
            Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L38
            RustBuffer.a r23 = RustBuffer.Companion;
            RustBuffer.ByValue r112 = r18.data;
            r23.getClass();
            RustBuffer.a.c(r112);
            UnhandledException r113 = new UnhandledException(r5);
            Intrinsics.checkNotNullParameter(r113, "e");
            throw r113;
        L32:
            r22 = null;
        L38:
            th = move-exception;
            RustBuffer.a r24 = RustBuffer.Companion;
            RustBuffer.ByValue r114 = r18.data;
            r24.getClass();
            RustBuffer.a.c(r114);
            throw th;
        L43:
            UnhandledException r26 = new UnhandledException("Unknown rust call status: " + r18 + ".code");
            Intrinsics.checkNotNullParameter(r26, "e");
            throw r26;
        L46:
            throw r2.a(r18.data);
        L14:
            RustBuffer.Companion.getClass();
            r17 = RustBuffer.a.a(0);
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r13);
            v r115 = this.$strategy;
            this.label = 1;
            if (r115.a(this) != r0) goto L11;
            return r0;
        }
    }

    public UserForeInjectContainerExportedModuleWrapper(l r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "param0");
        Intrinsics.checkNotNullParameter(r4, "strategy");
        super(new AnonymousClass1(r4, r3, null));
        this.e = LazyKt.lazy(new UserForeInjectContainerExportedModuleWrapper$commandMoltenService$2(this));
    }
}
