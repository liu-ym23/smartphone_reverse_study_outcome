package com.larus.dora.impl.core;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.annotation.DoraScene;
import com.larus.dora.impl.ota.DoraOTAManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraSceneManager$init$2", f = "DoraSceneManager.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class DoraSceneManager$init$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.core.DoraSceneManager$init$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1<T> f332164a = null;

        static {
            f332164a = new AnonymousClass1();
        }

        public AnonymousClass1() {
        }

        public final Object a(Map<String, ? extends d49.a> r100, Continuation<? super Unit> r110) {
            if ((r110 instanceof DoraSceneManager$init$2$1$emit$1) == false) goto L7;
            DoraSceneManager$init$2$1$emit$1 r101 = (DoraSceneManager$init$2$1$emit$1) r110;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r111 = r101.result;
            Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r104 = r101.label;
            boolean r105 = false;
            if (r104 == 0) goto L20;
            if (r104 == 1) goto L19;
            if (r104 == 2) goto L18;
            if (r104 == 3) goto L17;
            if (r104 != 4) goto L16;
            ResultKt.throwOnFailure(r111);
        L66:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L17:
            ResultKt.throwOnFailure(r111);
        L61:
            return Unit.INSTANCE;
        L18:
            r100 = (Map) r101.L$0;
            ResultKt.throwOnFailure(r111);
        L41:
            IDoraAVLinkService r112 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
            if (r112 == null) goto L44;
            r112.B0(4, 2);
        L44:
            Collection<? extends d49.a> r106 = r100.values();
            if ((r106 instanceof Collection) == true) goto L47;
        L49:
            Iterator<T> r107 = r106.iterator();
        L51:
            if (r107.hasNext() == false) goto L56;
            if ((((d49.a) r107.next()) instanceof d49.a.o) == false) goto L51;
            r105 = true;
        L56:
            if (r105 == false) goto L62;
            DoraSceneManager r113 = DoraSceneManager.f332159a;
            DoraScene r108 = DoraScene.OTA_PERIPHERAL_INSTALL;
            r101.L$0 = null;
            r101.label = 3;
            if (r113.b(r108, r101) != r103) goto L61;
            return r103;
        L62:
            DoraSceneManager r114 = DoraSceneManager.f332159a;
            DoraScene r109 = DoraScene.OTA_PERIPHERAL_INSTALL;
            r101.L$0 = null;
            r101.label = 4;
            if (r114.e(r109, r101) != r103) goto L66;
            return r103;
        L47:
            if (r106.isEmpty() == false) goto L49;
        L19:
            r100 = (Map) r101.L$0;
            ResultKt.throwOnFailure(r111);
        L35:
            IDoraAVLinkService r115 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
            if (r115 == null) goto L44;
            r115.B0(4, 1);
            goto L44
        L20:
            ResultKt.throwOnFailure(r111);
            Collection<? extends d49.a> r116 = r100.values();
            if ((r116 instanceof Collection) == true) goto L23;
        L25:
            Iterator<T> r117 = r116.iterator();
        L27:
            if (r117.hasNext() == false) goto L24;
            if ((((d49.a) r117.next()) instanceof d49.a.h) == false) goto L27;
            boolean r118 = true;
        L31:
            if (r118 == false) goto L38;
            DoraSceneManager r119 = DoraSceneManager.f332159a;
            DoraScene r120 = DoraScene.OTA_TRANSFER_DATA;
            r101.L$0 = r100;
            r101.label = 1;
            if (r119.b(r120, r101) != r103) goto L35;
            return r103;
        L38:
            DoraSceneManager r121 = DoraSceneManager.f332159a;
            DoraScene r122 = DoraScene.OTA_TRANSFER_DATA;
            r101.L$0 = r100;
            r101.label = 2;
            if (r121.e(r122, r101) != r103) goto L41;
            return r103;
        L24:
            r118 = false;
            goto L31
        L23:
            if (r116.isEmpty() == false) goto L25;
        L7:
            r101 = new DoraSceneManager$init$2$1$emit$1(this, r110);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((Map) r100, r101);
        }
    }

    public DoraSceneManager$init$2(Continuation<? super DoraSceneManager$init$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraSceneManager$init$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraSceneManager$init$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DoraOTAManager.f337359a.getClass();
        StateFlowImpl r103 = DoraOTAManager.f337362d;
        FlowCollector r104 = AnonymousClass1.f332164a;
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
