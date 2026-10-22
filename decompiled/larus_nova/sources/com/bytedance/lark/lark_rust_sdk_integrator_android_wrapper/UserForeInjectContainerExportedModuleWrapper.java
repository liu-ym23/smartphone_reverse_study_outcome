package com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
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

/* JADX INFO: loaded from: classes16.dex */
public final class UserForeInjectContainerExportedModuleWrapper extends MoltenService<k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f253258e;

    /* JADX INFO: renamed from: com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.UserForeInjectContainerExportedModuleWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_rust_sdk_integrator_android/UserForeInjectContainerExportedModule;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.lark_rust_sdk_integrator_android_wrapper.UserForeInjectContainerExportedModuleWrapper$1", f = "UserForeInjectContainerExportedModuleWrapper.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super k>, Object> {
        final /* synthetic */ l $param0;
        final /* synthetic */ v $strategy;
        int label;

        public AnonymousClass1(v r100, l r101, Continuation<? super AnonymousClass1> r102) {
            this.$strategy = r100;
            this.$param0 = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(this.$strategy, this.$param0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super k> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super k> r100) {
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
            l r111 = this.$param0;
            Intrinsics.checkNotNullParameter(r111, "arg0");
            com.bytedance.lark.lark_rust_sdk_integrator_android.d r102 = com.bytedance.lark.lark_rust_sdk_integrator_android.d.f253246a;
            NativeLib.Companion r103 = NativeLib.Companion;
            String r104 = null;
            k r105 = null;
            com.bytedance.lark.lark_rust_sdk_integrator_android.e r106 = new com.bytedance.lark.lark_rust_sdk_integrator_android.e(null, "getUserForeInjectContainerExportedModule");
            r103.getClass();
            Intrinsics.checkNotNullParameter(r106, "info");
            r111.getClass();
            FuncParamsX925422bfc7fd1ded r107 = new FuncParamsX925422bfc7fd1ded(new UserForegroundScope(0L), null);
            int r112 = FuncParamsX925422bfc7fd1ded.ADAPTER.encodedSize(r107);
            if (r112 <= 0) goto L14;
            RustBuffer.Companion.getClass();
            RustBuffer.ByValue r113 = RustBuffer.a.a(r112);
            Pointer r108 = r113.data;
            Intrinsics.checkNotNull(r108);
            h r109 = new h(r108);
            r107.encode(r109);
            r109.close();
        L15:
            BufferCallStatus.ByValue r114 = NativeLib.Companion.a().molten_ffi_lark_rust_sdk_integrator_call(NativeLib.Companion.b(), new Pointer(0), 4846092254770582297L, r113);
            int r115 = r114.code;
            if (r115 != 0) goto L24;
            RustBuffer.ByValue r116 = r114.data;
            ProtoAdapter<FuncReturnXbb91683c8a1151f8> r117 = FuncReturnXbb91683c8a1151f8.ADAPTER;
            RustBuffer.Companion.getClass();
            Long r118 = r117.decode(RustBuffer.a.b(r116)).ret;
            if (r118 == null) goto L20;
            r105 = new k(new Pointer(r118.longValue()));
        L20:
            if (r105 == null) goto L23;
            return r105;
        L23:
            throw new IllegalArgumentException("exported module accessed before ready".toString());
        L24:
            if (r115 == 1) goto L46;
            if (r115 != 2) goto L43;
            RustBuffer.ByValue r119 = r114.data;
            int r120 = r119.len;
            if (r120 > 0) goto L47;
            UnhandledException r121 = new UnhandledException("Rust panic");
            Intrinsics.checkNotNullParameter(r121, "e");
            throw r121;
        L47:
            Pointer r122 = r119.data;     // Catch: Throwable -> L38
            if (r122 == null) goto L32;
            byte[] r123 = r122.getByteArray(0, r120);     // Catch: Throwable -> L38
        L33:
            if (r123 == null) goto L35;
            r104 = new String(r123, Charsets.UTF_8);     // Catch: Throwable -> L38
        L35:
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L38
            RustBuffer.a r124 = RustBuffer.Companion;
            RustBuffer.ByValue r125 = r114.data;
            r124.getClass();
            RustBuffer.a.c(r125);
            UnhandledException r126 = new UnhandledException(r104);
            Intrinsics.checkNotNullParameter(r126, "e");
            throw r126;
        L32:
            r123 = null;
        L38:
            th = move-exception;
            RustBuffer.a r127 = RustBuffer.Companion;
            RustBuffer.ByValue r128 = r114.data;
            r127.getClass();
            RustBuffer.a.c(r128);
            throw th;
        L43:
            UnhandledException r129 = new UnhandledException("Unknown rust call status: " + r114 + ".code");
            Intrinsics.checkNotNullParameter(r129, "e");
            throw r129;
        L46:
            throw r102.a(r114.data);
        L14:
            RustBuffer.Companion.getClass();
            r113 = RustBuffer.a.a(0);
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            v r130 = this.$strategy;
            this.label = 1;
            if (r130.a(this) != r100) goto L11;
            return r100;
        }
    }

    public UserForeInjectContainerExportedModuleWrapper(l r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "param0");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        super(new AnonymousClass1(r101, r100, null));
        this.f253258e = LazyKt.lazy(new UserForeInjectContainerExportedModuleWrapper$commandMoltenService$2(this));
    }
}
