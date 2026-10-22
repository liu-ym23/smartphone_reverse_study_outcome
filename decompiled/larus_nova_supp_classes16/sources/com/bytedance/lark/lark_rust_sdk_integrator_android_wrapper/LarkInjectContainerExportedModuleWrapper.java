package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.lark.lark_rust_sdk_integrator_android.BufferCallStatus;
import com.bytedance.lark.lark_rust_sdk_integrator_android.NativeLib;
import com.bytedance.lark.lark_rust_sdk_integrator_android.RustBuffer;
import com.bytedance.lark.lark_rust_sdk_integrator_android.UnhandledException;
import com.bytedance.lark.lark_rust_sdk_integrator_android.h;
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
import lark_rust_sdk_integrator.proto.FuncReturnXc0aaa36386691e99;
import lark_rust_sdk_integrator.proto.MoltenContextExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class LarkInjectContainerExportedModuleWrapper extends MoltenService<com.bytedance.lark.lark_rust_sdk_integrator_android.f> {
    public final Lazy e;

    /* JADX INFO: renamed from: com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.LarkInjectContainerExportedModuleWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/LarkInjectContainerExportedModule;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.LarkInjectContainerExportedModuleWrapper$1", f = "LarkInjectContainerExportedModuleWrapper.kt", i = {}, l = {11}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super com.bytedance.lark.lark_rust_sdk_integrator_android.f>, Object> {
        final /* synthetic */ v $strategy;
        int label;

        public AnonymousClass1(v r1, Continuation<? super AnonymousClass1> r2) {
            this.$strategy = r1;
            super(1, r2);
        }

        public final Continuation<Unit> create(Continuation<?> r3) {
            return new AnonymousClass1(this.$strategy, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super com.bytedance.lark.lark_rust_sdk_integrator_android.f> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r12);
        L11:
            com.bytedance.lark.lark_rust_sdk_integrator_android.d r13 = com.bytedance.lark.lark_rust_sdk_integrator_android.d.a;
            NativeLib.Companion r2 = NativeLib.Companion;
            String r4 = null;
            com.bytedance.lark.lark_rust_sdk_integrator_android.f r5 = null;
            com.bytedance.lark.lark_rust_sdk_integrator_android.e r3 = new com.bytedance.lark.lark_rust_sdk_integrator_android.e(null, "getLarkInjectContainerExportedModule");
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "info");
            MoltenContextExtra r6 = new MoltenContextExtra(null);
            int r7 = MoltenContextExtra.ADAPTER.encodedSize(r6);
            if (r7 <= 0) goto L14;
            RustBuffer.Companion.getClass();
            RustBuffer.ByValue r8 = RustBuffer.a.a(r7);
            Pointer r9 = r8.data;
            Intrinsics.checkNotNull(r9);
            h r10 = new h(r9);
            r6.encode(r10);
            r10.close();
        L15:
            BufferCallStatus.ByValue r11 = NativeLib.Companion.a().molten_ffi_lark_rust_sdk_integrator_call(NativeLib.Companion.b(), new Pointer(0), -6847200311107213543L, r8);
            int r14 = r11.code;
            if (r14 != 0) goto L24;
            RustBuffer.ByValue r16 = r11.data;
            ProtoAdapter r17 = FuncReturnXc0aaa36386691e99.ADAPTER;
            RustBuffer.Companion.getClass();
            Long r18 = ((FuncReturnXc0aaa36386691e99) r17.decode(RustBuffer.a.b(r16))).ret;
            if (r18 == null) goto L20;
            r5 = new com.bytedance.lark.lark_rust_sdk_integrator_android.f(new Pointer(r18.longValue()));
        L20:
            if (r5 == null) goto L23;
            return r5;
        L23:
            throw new IllegalArgumentException("exported module accessed before ready".toString());
        L24:
            if (r14 == 1) goto L46;
            if (r14 != 2) goto L43;
            RustBuffer.ByValue r19 = r11.data;
            int r20 = r19.len;
            if (r20 > 0) goto L47;
            UnhandledException r110 = new UnhandledException("Rust panic");
            Intrinsics.checkNotNullParameter(r110, "e");
            throw r110;
        L47:
            Pointer r111 = r19.data;     // Catch: Throwable -> L38
            if (r111 == null) goto L32;
            byte[] r112 = r111.getByteArray(0, r20);     // Catch: Throwable -> L38
        L33:
            if (r112 == null) goto L35;
            r4 = new String(r112, Charsets.UTF_8);     // Catch: Throwable -> L38
        L35:
            Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L38
            RustBuffer.a r113 = RustBuffer.Companion;
            RustBuffer.ByValue r21 = r11.data;
            r113.getClass();
            RustBuffer.a.c(r21);
            UnhandledException r114 = new UnhandledException(r4);
            Intrinsics.checkNotNullParameter(r114, "e");
            throw r114;
        L32:
            r112 = null;
        L38:
            th = move-exception;
            RustBuffer.a r22 = RustBuffer.Companion;
            RustBuffer.ByValue r23 = r11.data;
            r22.getClass();
            RustBuffer.a.c(r23);
            throw th;
        L43:
            UnhandledException r115 = new UnhandledException("Unknown rust call status: " + r11 + ".code");
            Intrinsics.checkNotNullParameter(r115, "e");
            throw r115;
        L46:
            throw r13.a(r11.data);
        L14:
            RustBuffer.Companion.getClass();
            r8 = RustBuffer.a.a(0);
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r12);
            v r116 = this.$strategy;
            this.label = 1;
            if (r116.a(this) != r0) goto L11;
            return r0;
        }
    }

    public LarkInjectContainerExportedModuleWrapper() {
        v.a.getClass();
        this(v.b.b);
    }

    public LarkInjectContainerExportedModuleWrapper(v r3) {
        Intrinsics.checkNotNullParameter(r3, "strategy");
        super(new AnonymousClass1(r3, null));
        this.e = LazyKt.lazy(new LarkInjectContainerExportedModuleWrapper$commandMoltenServiceGlobal$2(this));
    }
}
