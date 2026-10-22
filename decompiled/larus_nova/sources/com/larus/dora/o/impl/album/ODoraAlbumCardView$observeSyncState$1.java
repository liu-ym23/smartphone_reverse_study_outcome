package com.larus.dora.o.impl.album;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import w88.i;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.album.ODoraAlbumCardView$observeSyncState$1", f = "ODoraAlbumCardView.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class ODoraAlbumCardView$observeSyncState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ODoraAlbumCardView this$0;

    /* JADX INFO: renamed from: com.larus.dora.o.impl.album.ODoraAlbumCardView$observeSyncState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODoraAlbumCardView f338333a;

        public AnonymousClass1(ODoraAlbumCardView r100) {
            this.f338333a = r100;
        }

        public final Object a(i r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof ODoraAlbumCardView$observeSyncState$1$1$emit$1) == false) goto L7;
            ODoraAlbumCardView$observeSyncState$1$1$emit$1 r102 = (ODoraAlbumCardView$observeSyncState$1$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            ResultKt.throwOnFailure(r104);
        L19:
            ODoraAlbumCardView r107 = this.f338333a;
            if ((r107.f338319g instanceof i.a) == false) goto L23;
            r107.f338319g = i.c.f558679a;
            FLogger.f375446a.i("ODoraAlbumCardView", "observeSyncState reset Completed to Idle and refresh");
            this.f338333a.e();
        L23:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            ODoraAlbumCardView r108 = this.f338333a;
            r108.f338319g = r100;
            i r109 = r108.b(r100);
            FLogger r110 = FLogger.f375446a;
            StringBuilder r111 = new StringBuilder("observeSyncState state=");
            this.f338333a.getClass();
            r111.append(ODoraAlbumCardView.c(r100));
            r111.append(", display=");
            this.f338333a.getClass();
            r111.append(ODoraAlbumCardView.c(r109));
            r111.append(", unsynced=");
            r111.append(this.f338333a.f338318f);
            r111.append(", hasInProgressPreview=");
            r111.append(this.f338333a.f338320h);
            r110.i("ODoraAlbumCardView", r111.toString());
            this.f338333a.f(r109);
            if ((r100 instanceof i.a) == false) goto L23;
            r102.label = 1;
            if (DelayKt.delay(2000, r102) != r105) goto L19;
            return r105;
        L7:
            r102 = new ODoraAlbumCardView$observeSyncState$1$1$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((i) r100, r101);
        }
    }

    public ODoraAlbumCardView$observeSyncState$1(ODoraAlbumCardView r100, Continuation<? super ODoraAlbumCardView$observeSyncState$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ODoraAlbumCardView$observeSyncState$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ODoraAlbumCardView$observeSyncState$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IDoraAVLinkService r103 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r103 == null) goto L16;
        Flow<i> r104 = r103.H0();
        if (r104 == null) goto L16;
        AnonymousClass1 r105 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L16;
        return r101;
    }
}
