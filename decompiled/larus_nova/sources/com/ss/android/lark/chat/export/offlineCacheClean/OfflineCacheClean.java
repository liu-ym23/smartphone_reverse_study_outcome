package com.ss.android.lark.chat.export.offlineCacheClean;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.im.v1.OfflineDataCleanPush;
import com.ss.android.eventbus.EventBus;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.r;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class OfflineCacheClean implements a, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f415410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f415411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b38.b f415412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f415413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f415414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f415415f;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1", f = "OfflineCacheClean.kt", i = {}, l = {90, 96}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ OfflineCacheClean this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chat.export.offlineCacheClean.OfflineCacheClean$onUserOnline$1$1", f = "OfflineCacheClean.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C48591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ OfflineCacheClean this$0;

            public C48591(OfflineCacheClean r100, Continuation<? super C48591> r101) {
                this.this$0 = r100;
                super(2, r101);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C48591(this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C48591) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r100) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L13;
                ResultKt.throwOnFailure(r100);
                boolean r101 = !this.this$0.f415415f.isEmpty();
                Iterator<T> r102 = this.this$0.f415415f.iterator();
            L6:
                if (r102.hasNext() == false) goto L8;
                ((b) r102.next()).a();
                goto L6
            L8:
                if (r101 == false) goto L11;
                EventBus.getDefault().trigger(new zdb.b());
            L11:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(OfflineCacheClean r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0086 -> B:12:0x003f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<OfflineDataCleanPush>> r102 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r110);
        L11:
            AnonymousClass1 r111 = this;
        L12:
            r111.L$0 = r102;
            r111.label = 1;
            Object r103 = r102.hasNext(r111);
            if (r103 != r100) goto L15;
            return r100;
        L15:
            Object r104 = r100;
            AnonymousClass1 r105 = r111;
            r110 = r103;
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<OfflineDataCleanPush>> r106 = r102;
            Object r107 = r104;
        L17:
            if (((Boolean) r110).booleanValue() == false) goto L28;
            com.larksuite.rucket.job.base.b r112 = r106.a();
            r112.getClass();
            if ((r112 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L22;
        L26:
            r111 = r105;
            r100 = r107;
            r102 = r106;
            goto L12
        L22:
            if (((OfflineDataCleanPush) r112.b()).status != OfflineDataCleanPush.Status.START_CLEAN) goto L26;
            MainCoroutineDispatcher r113 = Dispatchers.getMain();
            C48591 r108 = new C48591(r105.this$0, null);
            r105.L$0 = r106;
            r105.label = 2;
            if (BuildersKt.withContext(r113, r108, r105) != r107) goto L26;
            return r107;
        L28:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<OfflineDataCleanPush>> r109 = (com.larksuite.rucket.job.extension.a) this.L$0;
            ResultKt.throwOnFailure(r110);
            r106 = r109;
            r107 = r100;
            r105 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r110);
            r102 = ((c) this.this$0.f415414e.getValue()).pushOfflineDataClean().iterator();
            goto L11
        }
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void afterUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.r
    public final m getPassport() {
        return this.f415410a;
    }

    @Override // com.ss.android.lark.chat.export.offlineCacheClean.a
    public final void Ib(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f415415f.remove(r100);
    }

    @Override // com.ss.android.lark.chat.export.offlineCacheClean.a
    public final void Wa(b r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if (this.f415415f.contains(r100) == true) goto L6;
        this.f415415f.add(r100);
        return;
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOffline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f415415f.clear();
        CoroutineScopeKt.cancel$default(this.f415413d, null, 1, null);
    }

    @Override // com.ss.android.lark.passportc.api.o
    public final void onUserOnline(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f415411b.isEnable("lark.security.offline_caching_policy") == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f415413d, Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    @Inject
    public OfflineCacheClean(m r100, g r101, b38.b r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "fgService");
        Intrinsics.checkNotNullParameter(r102, "rucket");
        this.f415410a = r100;
        this.f415411b = r101;
        this.f415412c = r102;
        this.f415413d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f415414e = LazyKt.lazy(new OfflineCacheClean$service$2(this));
        this.f415415f = new CopyOnWriteArrayList();
        r100.d(this);
    }
}
