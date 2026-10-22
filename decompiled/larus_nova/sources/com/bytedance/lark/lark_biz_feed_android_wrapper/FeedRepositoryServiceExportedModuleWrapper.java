package com.bytedance.lark.lark_biz_feed_android_wrapper;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.lark.lark_biz_feed_android.MoltenFfiLibLarkBizFeed;
import com.bytedance.lark.lark_biz_feed_android.UnhandledException;
import com.bytedance.lark.lark_biz_feed_android.f1;
import com.bytedance.lark.lark_biz_feed_android.h;
import com.bytedance.lark.lark_biz_feed_android.k;
import com.bytedance.lark.lark_biz_feed_android.m;
import com.bytedance.lark.view_flow_wrapper.MoltenService;
import com.bytedance.lark.view_flow_wrapper.v;
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
import lark_biz_feed.proto.FuncParamsX7a8547e12a586378;
import lark_biz_feed.proto.FuncReturnXe6e6aa990169f5b3;
import lark_biz_feed.proto.UserForegroundScope;
import okio.ByteString;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedRepositoryServiceExportedModuleWrapper extends MoltenService<k> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f253216e;

    /* JADX INFO: renamed from: com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceExportedModuleWrapper$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/lark/lark_biz_feed_android/FeedRepositoryServiceExportedModule;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.lark.lark_biz_feed_android_wrapper.FeedRepositoryServiceExportedModuleWrapper$1", f = "FeedRepositoryServiceExportedModuleWrapper.kt", i = {}, l = {13}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super k>, Object> {
        final /* synthetic */ f1 $param0;
        final /* synthetic */ v $strategy;
        int label;

        public AnonymousClass1(v r100, f1 r101, Continuation<? super AnonymousClass1> r102) {
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
            f1 r111 = this.$param0;
            Intrinsics.checkNotNullParameter(r111, "arg0");
            Lazy<Long> r102 = MoltenFfiLibLarkBizFeed.f253143a;
            ByteString r103 = MoltenFfiLibLarkBizFeed.a.a(new m("getFeedRepositoryServiceExportedModule"));
            r111.getClass();
            byte[] r104 = new FuncParamsX7a8547e12a586378(new UserForegroundScope(Long.valueOf(r111.f253165a)), r103).encode();
            long r105 = MoltenFfiLibLarkBizFeed.a.b();     // Catch: RuntimeException -> L21
            Intrinsics.checkNotNull(r104);     // Catch: RuntimeException -> L21
            byte[] r112 = MoltenFfiLibLarkBizFeed.molten_ffi_lark_biz_feed_call(r105, 0, -5174295463393179311L, r104);     // Catch: RuntimeException -> L21
            Long r113 = FuncReturnXe6e6aa990169f5b3.ADAPTER.decode(r112).ret;
            if (r113 == null) goto L16;
            k r106 = new k(r113.longValue());
        L17:
            if (r106 == null) goto L20;
            return r106;
        L20:
            throw new IllegalArgumentException("exported module accessed before ready".toString());
        L16:
            r106 = null;
        L21:
            e = move-exception;
            if (e.getMessage() == null) goto L26;
            int r107 = h.f253168a;
            String r114 = e.getMessage();
            Intrinsics.checkNotNull(r114);
            UnhandledException r108 = new UnhandledException(r114);
            Intrinsics.checkNotNullParameter(r108, "e");
            throw r108;
        L26:
            int r115 = h.f253168a;
            UnhandledException r116 = new UnhandledException("Rust panic");
            Intrinsics.checkNotNullParameter(r116, "e");
            throw r116;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            v r117 = this.$strategy;
            this.label = 1;
            if (r117.a(this) != r100) goto L11;
            return r100;
        }
    }

    public FeedRepositoryServiceExportedModuleWrapper(f1 r100, v r101) {
        Intrinsics.checkNotNullParameter(r100, "param0");
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        super(new AnonymousClass1(r101, r100, null));
        this.f253216e = LazyKt.lazy(new FeedRepositoryServiceExportedModuleWrapper$feedBadgeService$2(this));
    }
}
