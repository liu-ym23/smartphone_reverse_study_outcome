package com.larus.home.impl.main.side_bar.data;

import com.larus.im.IInstantMessenger;
import com.larus.im.bean.IMCmd;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.data.SideBarConfigModel$startObservingSideBarRefresh$1", f = "SideBarConfigModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD}, m = "invokeSuspend", n = {}, s = {})
final class SideBarConfigModel$startObservingSideBarRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IInstantMessenger $messenger;
    int label;
    final /* synthetic */ SideBarConfigModel this$0;

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.data.SideBarConfigModel$startObservingSideBarRefresh$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SideBarConfigModel f344460a;

        public AnonymousClass1(SideBarConfigModel r100) {
            this.f344460a = r100;
        }

        public final Object a(IMCmd r110, Continuation<? super Unit> r111) {
            if ((r111 instanceof SideBarConfigModel$startObservingSideBarRefresh$1$1$emit$1) == false) goto L7;
            SideBarConfigModel$startObservingSideBarRefresh$1$1$emit$1 r100 = (SideBarConfigModel$startObservingSideBarRefresh$1$1$emit$1) r111;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            Object r112 = r100.result;
            Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r103 = r100.label;
            if (r103 == 0) goto L18;
            if (r103 == 1) goto L17;
            if (r103 == 2) goto L16;
            if (r103 != 3) goto L15;
            ResultKt.throwOnFailure(r112);
        L66:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r112);
        L61:
            return Unit.INSTANCE;
        L17:
            SideBarConfigModel r113 = (SideBarConfigModel) r100.L$0;
            ResultKt.throwOnFailure(r112);
        L57:
            r100.L$0 = null;
            r100.label = 2;
            if (SideBarConfigModel.a(r113, (k0) r112, r100) != r102) goto L61;
            return r102;
        L18:
            ResultKt.throwOnFailure(r112);
            Integer r114 = r110.getCmdType();
            if (r114 == null) goto L24;
            if (r114.intValue() != 92001) goto L24;
            SideBarRepo r115 = SideBarRepo.f344467a;
            Map<String, String> r116 = r110.getExt();
            if (r116 == null) goto L28;
            String r117 = r116.get("app_framework_sidebar_refresh_push");
        L29:
            r115.getClass();
            if (r117 != null) goto L32;
        L35:
            boolean r118 = true;
        L36:
            if (r118 == false) goto L67;
            z0 r119 = null;
        L49:
            if (r119 != null) goto L53;
            return Unit.INSTANCE;
        L53:
            if (r119.a() == false) goto L62;
            FLogger.f375446a.i("SideBarConfigModel", "received sidebar refresh trigger, pull latest layout");
            r113 = this.f344460a;
            SideBarRepo r120 = SideBarRepo.f344467a;
            long r104 = r113.f344438i;
            Integer r105 = Boxing.boxInt(1);
            r100.L$0 = r113;
            r100.label = 1;
            r112 = r120.j(r104, r105, r100);
            if (r112 != r102) goto L57;
            return r102;
        L62:
            SideBarConfigModel r121 = this.f344460a;
            SideBarRepo r106 = SideBarRepo.f344467a;
            k0 r122 = r119.b();
            r106.getClass();
            k0 r123 = SideBarRepo.a(r122, AccountService.f365697a.getUserId());
            r100.label = 3;
            if (SideBarConfigModel.a(r121, r123, r100) != r102) goto L66;
            return r102;
        L67:
            Result.Companion r124 = Result.Companion;     // Catch: Throwable -> L40
            Object r125 = Result.m9449constructorimpl((z0) SideBarRepo.d().fromJson(r117, z0.class));     // Catch: Throwable -> L40
        L42:
            Throwable r126 = Result.m9452exceptionOrNullimpl(r125);
            if (r126 == null) goto L46;
            FLogger.f375446a.e("SideBarRepo", "parse sidebar refresh push failed", r126);
        L46:
            if (Result.m9455isFailureimpl(r125) == false) goto L48;
            r125 = null;
        L48:
            r119 = (z0) r125;
        L40:
            th = move-exception;
            Result.Companion r127 = Result.Companion;
            r125 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L42
        L32:
            if (StringsKt.isBlank(r117) == true) goto L35;
            r118 = false;
            goto L36
        L28:
            r117 = null;
        L24:
            return Unit.INSTANCE;
        L7:
            r100 = new SideBarConfigModel$startObservingSideBarRefresh$1$1$emit$1(this, r111);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((IMCmd) r100, r101);
        }
    }

    public SideBarConfigModel$startObservingSideBarRefresh$1(IInstantMessenger r100, SideBarConfigModel r101, Continuation<? super SideBarConfigModel$startObservingSideBarRefresh$1> r102) {
        this.$messenger = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SideBarConfigModel$startObservingSideBarRefresh$1(this.$messenger, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SideBarConfigModel$startObservingSideBarRefresh$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MutableSharedFlow r103 = this.$messenger.e();
        AnonymousClass1 r104 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
