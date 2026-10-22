package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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

/* JADX INFO: loaded from: classes16.dex */
public final class LarkInjectContainerExportedModuleWrapper extends MoltenService<com.bytedance.lark.lark_rust_sdk_integrator_android.f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f253257e;

    /* JADX INFO: renamed from: com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.LarkInjectContainerExportedModuleWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/LarkInjectContainerExportedModule;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.LarkInjectContainerExportedModuleWrapper$1", f = "LarkInjectContainerExportedModuleWrapper.kt", i = {}, l = {11}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super com.bytedance.lark.lark_rust_sdk_integrator_android.f>, Object> {
        final /* synthetic */ v $strategy;
        int label;

        public AnonymousClass1(v r100, Continuation<? super AnonymousClass1> r101) {
            this.$strategy = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(this.$strategy, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super com.bytedance.lark.lark_rust_sdk_integrator_android.f> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super com.bytedance.lark.lark_rust_sdk_integrator_android.f> r100) {
            return ((AnonymousClass1) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L11:
            com.bytedance.lark.lark_rust_sdk_integrator_android.d r111 = com.bytedance.lark.lark_rust_sdk_integrator_android.d.f253246a;
            NativeLib.Companion r102 = NativeLib.Companion;
            String r103 = null;
            com.bytedance.lark.lark_rust_sdk_integrator_android.f r104 = null;
            com.bytedance.lark.lark_rust_sdk_integrator_android.e r105 = new com.bytedance.lark.lark_rust_sdk_integrator_android.e(null, "getLarkInjectContainerExportedModule");
            r102.getClass();
            Intrinsics.checkNotNullParameter(r105, "info");
            MoltenContextExtra r106 = new MoltenContextExtra(null);
            int r107 = MoltenContextExtra.ADAPTER.encodedSize(r106);
            if (r107 <= 0) goto L14;
            RustBuffer.Companion.getClass();
            RustBuffer.ByValue r108 = RustBuffer.a.a(r107);
            Pointer r109 = r108.data;
            Intrinsics.checkNotNull(r109);
            h r112 = new h(r109);
            r106.encode(r112);
            r112.close();
        L15:
            BufferCallStatus.ByValue r113 = NativeLib.Companion.a().molten_ffi_lark_rust_sdk_integrator_call(NativeLib.Companion.b(), new Pointer(0), -6847200311107213543L, r108);
            int r114 = r113.code;
            if (r114 != 0) goto L24;
            RustBuffer.ByValue r115 = r113.data;
            ProtoAdapter<FuncReturnXc0aaa36386691e99> r116 = FuncReturnXc0aaa36386691e99.ADAPTER;
            RustBuffer.Companion.getClass();
            Long r117 = r116.decode(RustBuffer.a.b(r115)).ret;
            if (r117 == null) goto L20;
            r104 = new com.bytedance.lark.lark_rust_sdk_integrator_android.f(new Pointer(r117.longValue()));
        L20:
            if (r104 == null) goto L23;
            return r104;
        L23:
            throw new IllegalArgumentException("exported module accessed before ready".toString());
        L24:
            if (r114 == 1) goto L46;
            if (r114 != 2) goto L43;
            RustBuffer.ByValue r118 = r113.data;
            int r119 = r118.len;
            if (r119 > 0) goto L47;
            UnhandledException r120 = new UnhandledException("Rust panic");
            Intrinsics.checkNotNullParameter(r120, "e");
            throw r120;
        L47:
            Pointer r121 = r118.data;     // Catch: Throwable -> L38
            if (r121 == null) goto L32;
            byte[] r122 = r121.getByteArray(0, r119);     // Catch: Throwable -> L38
        L33:
            if (r122 == null) goto L35;
            r103 = new String(r122, Charsets.UTF_8);     // Catch: Throwable -> L38
        L35:
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L38
            RustBuffer.a r123 = RustBuffer.Companion;
            RustBuffer.ByValue r124 = r113.data;
            r123.getClass();
            RustBuffer.a.c(r124);
            UnhandledException r125 = new UnhandledException(r103);
            Intrinsics.checkNotNullParameter(r125, "e");
            throw r125;
        L32:
            r122 = null;
        L38:
            th = move-exception;
            RustBuffer.a r126 = RustBuffer.Companion;
            RustBuffer.ByValue r127 = r113.data;
            r126.getClass();
            RustBuffer.a.c(r127);
            throw th;
        L43:
            UnhandledException r128 = new UnhandledException("Unknown rust call status: " + r113 + ".code");
            Intrinsics.checkNotNullParameter(r128, "e");
            throw r128;
        L46:
            throw r111.a(r113.data);
        L14:
            RustBuffer.Companion.getClass();
            r108 = RustBuffer.a.a(0);
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            v r129 = this.$strategy;
            this.label = 1;
            if (r129.a(this) != r100) goto L11;
            return r100;
        }
    }

    public LarkInjectContainerExportedModuleWrapper() {
        v.f254467a.getClass();
        this(v.b.f254469b);
    }

    public LarkInjectContainerExportedModuleWrapper(v r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        super(new AnonymousClass1(r100, null));
        this.f253257e = LazyKt.lazy(new LarkInjectContainerExportedModuleWrapper$commandMoltenServiceGlobal$2(this));
    }
}
