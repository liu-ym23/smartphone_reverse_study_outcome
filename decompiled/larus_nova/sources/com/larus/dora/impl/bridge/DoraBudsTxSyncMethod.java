package com.larus.dora.impl.bridge;

import android.os.SystemClock;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.buds.txSync")
public final class DoraBudsTxSyncMethod extends XCoreIDLBridgeMethod<c, d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IntRange f332052b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.buds.txSync")
    public final String f332053a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f332054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f332055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f332056c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f332054a == r101.f332054a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f332055b, r101.f332055b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f332056c, r101.f332056c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f332054a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = ((r100 * 31) + this.f332055b.hashCode()) * 31;
            String r102 = this.f332056c;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "BridgeResult(isFailure=" + this.f332054a + ", resultModel=" + this.f332055b + ", message=" + this.f332056c + ')';
        }

        public a(boolean r100, d r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "resultModel");
            this.f332054a = r100;
            this.f332055b = r101;
            this.f332056c = r102;
        }
    }

    public static final class b {
    }

    @XBridgeParamModel
    public interface c extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "cid", required = true)
        Number getCid();

        @XBridgeParamField(isGetter = true, keyPath = "event", required = true)
        Number getEvent();

        @XBridgeParamField(isGetter = true, keyPath = WsConstants.KEY_SESSION_ID, required = true)
        Number getSid();

        @XBridgeParamField(isGetter = true, keyPath = "tolerableTimeout", required = false)
        Number getTolerableTimeout();

        @XBridgeParamField(isGetter = true, keyPath = "value", required = false)
        List<Number> getValue();
    }

    @XBridgeResultModel
    public interface d extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = "retCode", required = false)
        Number getRetCode();

        @XBridgeParamField(isGetter = true, keyPath = "retData", required = false)
        Object getRetData();

        @XBridgeParamField(isGetter = false, keyPath = "retCode", required = false)
        void setRetCode(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "retData", required = false)
        void setRetData(Object r100);
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1", f = "DoraBudsTxSyncMethod.kt", i = {0}, l = {75, 90}, m = "invokeSuspend", n = {"startMs"}, s = {"J$0"})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CompletionBlock<d> $callback;
        final /* synthetic */ Integer $cid;
        final /* synthetic */ Integer $event;
        final /* synthetic */ Integer $sid;
        final /* synthetic */ List<Integer> $values;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DoraBudsTxSyncMethod this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.bridge.DoraBudsTxSyncMethod$handle$1$1", f = "DoraBudsTxSyncMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C42101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ a $bridgeResult;
            final /* synthetic */ CompletionBlock<d> $callback;
            int label;

            public C42101(a r100, CompletionBlock<d> r101, Continuation<? super C42101> r102) {
                this.$bridgeResult = r100;
                this.$callback = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C42101(this.$bridgeResult, this.$callback, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C42101) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L14;
                ResultKt.throwOnFailure(r100);
                a r101 = this.$bridgeResult;
                if (r101.f332054a == false) goto L10;
                CompletionBlock<d> r102 = this.$callback;
                String r103 = r101.f332056c;
                if (r103 != null) goto L9;
                r103 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
            L9:
                r102.onFailure(0, r103, r101.f332055b);
            L12:
                return Unit.INSTANCE;
            L10:
                CompletionBlock.DefaultImpls.onSuccess$default(this.$callback, r101.f332055b, null, 2, null);
                goto L12
            L14:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(DoraBudsTxSyncMethod r100, Integer r101, Integer r102, Integer r103, List<Integer> r104, CompletionBlock<d> r105, Continuation<? super AnonymousClass1> r106) {
            this.this$0 = r100;
            this.$sid = r101;
            this.$cid = r102;
            this.$event = r103;
            this.$values = r104;
            this.$callback = r105;
            super(2, r106);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            AnonymousClass1 r100 = new AnonymousClass1(this.this$0, this.$sid, this.$cid, this.$event, this.$values, this.$callback, r111);
            r100.L$0 = r110;
            return r100;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L31:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            long r102 = this.J$0;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L18
        L16:
            Object r111 = Result.m9449constructorimpl((a) r110);     // Catch: Throwable -> L18
        L20:
            DoraBudsTxSyncMethod r103 = this.this$0;
            Throwable r104 = Result.m9452exceptionOrNullimpl(r111);
            if (r104 == null) goto L27;
            FLogger.f375446a.e("DoraBudsTxSyncMethod", "dora.buds.txSync execute failed", r104);
            String r112 = r104.getMessage();
            if (r112 != null) goto L26;
            r112 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
        L26:
            IntRange r105 = DoraBudsTxSyncMethod.f332052b;
            r103.getClass();
            d r106 = (d) ne7.e.b(d.class);
            r106.setRetCode(-1);
            r106.setRetData(null);
            r111 = new a(true, r106, r112);
        L27:
            a r113 = (a) r111;
            long r107 = SystemClock.elapsedRealtime() - r102;
            FLogger r108 = FLogger.f375446a;
            StringBuilder r109 = new StringBuilder("dora.buds.txSync end sid=0x");
            DoraBudsTxSyncMethod r114 = this.this$0;
            int r115 = this.$sid.intValue();
            IntRange r116 = DoraBudsTxSyncMethod.f332052b;
            r114.getClass();
            r109.append(Integer.toHexString(r115));
            r109.append(" cid=0x");
            DoraBudsTxSyncMethod r117 = this.this$0;
            int r118 = this.$cid.intValue();
            r117.getClass();
            r109.append(Integer.toHexString(r118));
            r109.append(" event=0x");
            DoraBudsTxSyncMethod r119 = this.this$0;
            int r120 = this.$event.intValue();
            r119.getClass();
            r109.append(Integer.toHexString(r120));
            r109.append(" retCode=");
            r109.append(r113.f332055b.getRetCode());
            r109.append(" costMs=");
            r109.append(r107);
            r108.i("DoraBudsTxSyncMethod", r109.toString());
            MainCoroutineDispatcher r121 = Dispatchers.getMain();
            C42101 r122 = new C42101(r113, this.$callback, null);
            this.label = 2;
            if (BuildersKt.withContext(r121, r122, this) != r100) goto L31;
            return r100;
        L12:
            ResultKt.throwOnFailure(r110);
            CoroutineScope r123 = (CoroutineScope) this.L$0;
            r102 = SystemClock.elapsedRealtime();
            DoraBudsTxSyncMethod r124 = this.this$0;
            Integer r125 = this.$sid;
            Integer r126 = this.$cid;
            Integer r127 = this.$event;
            List<Integer> r128 = this.$values;
            Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L18
            int r130 = r125.intValue();     // Catch: Throwable -> L18
            int r131 = r126.intValue();     // Catch: Throwable -> L18
            int r132 = r127.intValue();     // Catch: Throwable -> L18
            this.J$0 = r102;     // Catch: Throwable -> L18
            this.label = 1;     // Catch: Throwable -> L18
            r110 = DoraBudsTxSyncMethod.a(r124, r130, r131, r132, r128, this);     // Catch: Throwable -> L18
            if (r110 != r100) goto L16;
            return r100;
        L18:
            th = move-exception;
            Result.Companion r133 = Result.Companion;
            r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L20
        }
    }

    static {
        f332052b = new IntRange(0, 1);
    }

    public DoraBudsTxSyncMethod() {
        this.f332053a = "dora.buds.txSync";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332053a;
    }

    public static String e(DoraBudsTxSyncMethod r100, List r101) {
        r100.getClass();
        if (r101.isEmpty() == false) goto L5;
        return "[]";
    L5:
        int r102 = Math.min(r101.size(), 16);
        StringBuilder r103 = new StringBuilder("[");
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L14;
        if (r104 <= 0) goto L9;
        r103.append(' ');
    L9:
        r103.append("0x");
        String r105 = Integer.toHexString(((Number) ListProtector.get(r101, r104)).intValue() & 255);
        if (r105.length() != 1) goto L12;
        r103.append('0');
    L12:
        r103.append(r105);
        r104 = r104 + 1;
        goto L6
    L14:
        if (r101.size() <= 16) goto L16;
        r103.append(" ... +");
        r103.append(r101.size() - 16);
    L16:
        r103.append(']');
        return r103.toString();
    }

    public final Object c(List<Integer> r110, Continuation<? super Pair<Integer, ? extends Object>> r111) {
        if ((r111 instanceof DoraBudsTxSyncMethod$executeVolumeAdaptation$1) == false) goto L7;
        DoraBudsTxSyncMethod$executeVolumeAdaptation$1 r100 = (DoraBudsTxSyncMethod$executeVolumeAdaptation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        boolean r105 = true;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        final int r113 = r100.I$0;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L44:
        int r114 = ((Number) r112).intValue();
        if (r114 != 0) goto L52;
        IntRange r107 = f332052b;
        int r108 = r107.getFirst();
        if (r113 > r107.getLast()) goto L50;
        if (r108 > r113) goto L50;
        r104 = true;
    L50:
        if (r104 == false) goto L52;
        DoraDeviceSettingsCache.f332061a.update(r106, new com.larus.dora.impl.bridge.b(r113));
    L52:
        FLogger.f375446a.i("DoraBudsTxSyncMethod", "dora.buds.txSync volumeAdaptation set deviceKey=" + r106 + " nextState=" + r113 + " retCode=" + r114);
        return TuplesKt.to(Boxing.boxInt(r114), null);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r115 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L32:
        final int r116 = ((Number) r112).intValue();
        IntRange r109 = f332052b;
        int r117 = r109.getFirst();
        if (r116 > r109.getLast()) goto L36;
        if (r117 > r116) goto L36;
    L37:
        if (r105 == false) goto L39;
        DoraDeviceSettingsCache.f332061a.update(r115, new com.larus.dora.impl.bridge.a(r116));
        FLogger.f375446a.i("DoraBudsTxSyncMethod", "dora.buds.txSync volumeAdaptation get ok deviceKey=" + r115 + " state=" + r116);
        return TuplesKt.to(Boxing.boxInt(0), Boxing.boxInt(r116));
    L39:
        FLogger.f375446a.w("DoraBudsTxSyncMethod", "dora.buds.txSync volumeAdaptation get unexpected state=" + r116 + " deviceKey=" + r115);
        return TuplesKt.to(Boxing.boxInt(r116), null);
    L36:
        r105 = false;
        goto L37
    L16:
        ResultKt.throwOnFailure(r112);
        kj4.a r118 = kj4.a.g();
        Intrinsics.checkNotNull(r118);
        DoraDevice r119 = DoraAdapterExtKt.h(r118);
        if (r119 == null) goto L19;
        String r120 = r119.getSerialNumber();
    L20:
        if (r119 == null) goto L22;
        String r121 = r119.f204389mac;
    L23:
        if (r119 == null) goto L25;
        Integer r122 = Boxing.boxInt(r119.productId);
    L26:
        String r123 = b(r120, r121, r122);
        if (r110.isEmpty() == false) goto L40;
        r100.L$0 = r123;
        r100.label = 1;
        r112 = DoraAdapterExtKt.l(r118);
        if (r112 != r102) goto L31;
        return r102;
    L31:
        r115 = r123;
        goto L32
    L40:
        r113 = ((Number) CollectionsKt.first(r110)).intValue();
        r100.L$0 = r123;
        r100.I$0 = r113;
        r100.label = 2;
        r112 = DoraAdapterExtKt.H(r118, r113);
        if (r112 != r102) goto L43;
        return r102;
    L43:
        r106 = r123;
        goto L44
    L25:
        r122 = null;
        goto L26
    L22:
        r121 = null;
        goto L23
    L19:
        r120 = null;
    L7:
        r100 = new DoraBudsTxSyncMethod$executeVolumeAdaptation$1(this, r111);
        goto L8
    }

    public final String b(String r100, String r101, Number r102) {
        if (r100 != null) goto L5;
    L11:
        if (r101 != null) goto L13;
    L15:
        r101 = null;
    L16:
        if (r101 != null) goto L20;
        if (r102 != null) goto L23;
        return null;
    L23:
        return r102.toString();
    L20:
        return r101;
    L13:
        if ((!StringsKt.isBlank(r101)) == false) goto L15;
    L5:
        if ((!StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        return r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r210, CompletionBlock r211) {
        c r100 = (c) r210;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, "callback");
        if (DoraAdapterExtKt.h(kj4.a.g()) != null) goto L5;
        FLogger.f375446a.w("DoraBudsTxSyncMethod", "dora.buds.txSync current dora device not found");
        CompletionBlock.DefaultImpls.onFailure$default(r211, 0, "current dora device not found", null, 4, null);
    L36:
        return;
    L5:
        Number r101 = r100.getSid();
        if (r101 == null) goto L8;
        Integer r102 = Integer.valueOf(r101.intValue());
    L9:
        Number r103 = r100.getCid();
        if (r103 == null) goto L12;
        Integer r104 = Integer.valueOf(r103.intValue());
    L13:
        Number r105 = r100.getEvent();
        if (r105 == null) goto L16;
        Integer r106 = Integer.valueOf(r105.intValue());
    L17:
        if (r102 == null) goto L33;
        if (r104 == null) goto L33;
        if (r106 == null) goto L33;
        List<Number> r107 = r100.getValue();
        if (r107 != null) goto L24;
        r107 = CollectionsKt.emptyList();
    L24:
        List<Number> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r111 = r108.iterator();
    L26:
        if (r111.hasNext() == false) goto L29;
        r109.add(Integer.valueOf(((Number) r111.next()).intValue() & 255));
        goto L26
    L29:
        if (r109.size() <= 255) goto L32;
        FLogger.f375446a.w("DoraBudsTxSyncMethod", "dora.buds.txSync value too long sid=0x" + Integer.toHexString(r102.intValue()) + " cid=0x" + Integer.toHexString(r104.intValue()) + " event=0x" + Integer.toHexString(r106.intValue()) + " len=" + r109.size());
        StringBuilder r112 = new StringBuilder("value is too long: ");
        r112.append(r109.size());
        CompletionBlock.DefaultImpls.onFailure$default(r211, -3, r112.toString(), null, 4, null);
        goto L36
    L32:
        FLogger.f375446a.i("DoraBudsTxSyncMethod", "dora.buds.txSync start sid=0x" + Integer.toHexString(r102.intValue()) + " cid=0x" + Integer.toHexString(r104.intValue()) + " event=0x" + Integer.toHexString(r106.intValue()) + " len=" + r109.size() + " values=" + e(this, r109) + " tolerableTimeout=" + r100.getTolerableTimeout());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new AnonymousClass1(this, r102, r104, r106, r109, r211, null), 3, null);
        return;
    L33:
        FLogger.f375446a.w("DoraBudsTxSyncMethod", "dora.buds.txSync invalid params sid=" + r102 + " cid=" + r104 + " event=" + r106);
        CompletionBlock.DefaultImpls.onFailure$default(r211, -3, "sid/cid/event is required", null, 4, null);
        return;
    L16:
        r106 = null;
        goto L17
    L12:
        r104 = null;
        goto L13
    L8:
        r102 = null;
        goto L9
    }

    public static final Object a(DoraBudsTxSyncMethod r110, int r111, int r112, int r113, List r210, Continuation r211) {
        r110.getClass();
        if ((r211 instanceof DoraBudsTxSyncMethod$executeTxSync$1) == false) goto L7;
        DoraBudsTxSyncMethod$executeTxSync$1 r100 = (DoraBudsTxSyncMethod$executeTxSync$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L22:
        Pair r105 = (Pair) r102;
    L67:
        int r106 = ((Number) r105.component1()).intValue();
        Object r107 = r105.component2();
        d r108 = (d) ne7.e.b(d.class);
        r108.setRetCode(Integer.valueOf(r106));
        r108.setRetData(r107);
        return new a(false, r108, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r111 == 1) goto L17;
    L23:
        if (r111 == 1) goto L25;
    L46:
        int r109 = r210.size() + 2;
        byte[] r114 = new byte[r109];
        r114[0] = (byte) r113;
        r114[1] = (byte) r109;
        int r115 = 0;
        int r116 = 0;
    L47:
        if (r115 >= r109) goto L49;
        int r117 = r116 + 1;
        r114[r116 + 2] = r114[r115];
        r115 = r115 + 1;
        r116 = r117;
        goto L47
    L49:
        FLogger r118 = FLogger.f375446a;
        StringBuilder r119 = new StringBuilder("dora.buds.txSync branch=rawTxSync sid=0x");
        r119.append(Integer.toHexString(r111));
        r119.append(" cid=0x");
        r119.append(Integer.toHexString(r112));
        r119.append(" payload=");
        if (r109 != 0) goto L52;
        boolean r120 = true;
    L53:
        if (r120 == false) goto L55;
        String r121 = "[]";
    L66:
        r119.append(r121);
        r118.i("DoraBudsTxSyncMethod", r119.toString());
        r105 = TuplesKt.to(Boxing.boxInt(ak4.a.d().i(r111, r112, r114)), null);
        goto L67
    L55:
        int r122 = Math.min(r109, 24);
        StringBuilder r123 = new StringBuilder("[");
        int r124 = 0;
    L56:
        if (r124 >= r122) goto L63;
        if (r124 <= 0) goto L59;
        r123.append(' ');
    L59:
        r123.append("0x");
        String r125 = Integer.toHexString(r114[r124] & UByte.MAX_VALUE);
        if (r125.length() != 1) goto L62;
        r123.append('0');
    L62:
        r123.append(r125);
        r124 = r124 + 1;
        goto L56
    L63:
        if (r109 <= 24) goto L65;
        r123.append(" ... +");
        r123.append(r109 - 24);
    L65:
        r123.append(']');
        r121 = r123.toString();
        goto L66
    L52:
        r120 = false;
        goto L53
    L25:
        if (r112 != 4) goto L46;
        if (r113 != 11) goto L46;
        FLogger r126 = FLogger.f375446a;
        r126.i("DoraBudsTxSyncMethod", "dora.buds.txSync branch=cueToneVolume sid=0x" + Integer.toHexString(r111) + " cid=0x" + Integer.toHexString(r112) + " event=0x" + Integer.toHexString(r113) + " values=" + e(r110, r210));
        kj4.a r127 = kj4.a.g();
        Intrinsics.checkNotNull(r127);
        DoraDevice r128 = DoraAdapterExtKt.h(r127);
        if (r128 == null) goto L31;
        String r129 = r128.getSerialNumber();
    L32:
        if (r128 == null) goto L34;
        String r130 = r128.f204389mac;
    L35:
        if (r128 == null) goto L37;
        Number r131 = Integer.valueOf(r128.productId);
    L38:
        String r132 = r110.b(r129, r130, r131);
        if (r210.isEmpty() == false) goto L42;
        final int r133 = r127.z() & UByte.MAX_VALUE;
        DoraDeviceSettingsCache.f332061a.update(r132, new com.larus.dora.impl.bridge.c(r133));
        r126.i("DoraBudsTxSyncMethod", "dora.buds.txSync cueToneVolume get ok deviceKey=" + r132 + " volumeRaw=" + r133);
        Pair r134 = TuplesKt.to(0, Integer.valueOf(r133));
    L41:
        r105 = r134;
        goto L67
    L42:
        int r135 = ((Number) CollectionsKt.first(r210)).intValue();
        int r136 = r127.o(r135);
        if (r136 != 0) goto L45;
        final int r137 = r135 & 255;
        DoraDeviceSettingsCache.f332061a.update(r132, new com.larus.dora.impl.bridge.d(r137));
    L45:
        r126.i("DoraBudsTxSyncMethod", "dora.buds.txSync cueToneVolume set deviceKey=" + r132 + " nextValue=" + r135 + " retCode=" + r136);
        r134 = TuplesKt.to(Integer.valueOf(r136), null);
        goto L41
    L37:
        r131 = null;
        goto L38
    L34:
        r130 = null;
        goto L35
    L31:
        r129 = null;
        goto L32
    L17:
        if (r112 != 5) goto L23;
        if (r113 != 1) goto L23;
        FLogger.f375446a.i("DoraBudsTxSyncMethod", "dora.buds.txSync branch=volumeAdaptation sid=0x" + Integer.toHexString(r111) + " cid=0x" + Integer.toHexString(r112) + " event=0x" + Integer.toHexString(r113) + " values=" + e(r110, r210));
        r100.label = 1;
        r102 = r110.c(r210, r100);
        if (r102 != r103) goto L22;
        return r103;
    L7:
        r100 = new DoraBudsTxSyncMethod$executeTxSync$1(r110, r211);
        goto L8
    }
}
