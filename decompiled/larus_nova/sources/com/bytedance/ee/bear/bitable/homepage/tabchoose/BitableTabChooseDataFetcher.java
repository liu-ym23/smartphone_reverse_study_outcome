package com.bytedance.ee.bear.bitable.homepage.tabchoose;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException;
import com.lynx.tasm.LynxError;
import fo5.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableTabChooseDataFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f213088a;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<BitableTabChooseResponse> f213089a;

        public a(j r100) {
            this.f213089a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f213089a.resumeWith(Result.m9449constructorimpl((BitableTabChooseResponse) r100));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i<BitableTabChooseResponse> f213090a;

        public b(j r100) {
            this.f213090a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            BitableTabChooseResponse r102 = new BitableTabChooseResponse();
            if ((r101 instanceof CloudReqFun.OkHttpReqException) == false) goto L7;
            Exception r103 = ((CloudReqFun.OkHttpReqException) r101).exceptionObj;
            if ((r103 instanceof RustIOException) == false) goto L7;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.ee.eenet.httpclient.rust.exception.RustIOException");
            r102.code = ((RustIOException) r103).getRustSdkErrorCode();
            r102.msg = r101.getMessage();
        L8:
            this.f213090a.resumeWith(Result.m9449constructorimpl(r102));
            return;
        L7:
            r102.code = -1;
            r102.msg = "internal error";
            goto L8
        }
    }

    public BitableTabChooseDataFetcher() {
        this.f213088a = new CompositeDisposable();
    }

    public final Object a(Continuation<? super BitableTabChooseResponse> r100) {
        j r101 = new j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        NetService r102 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r103 = new NetService.f("/space/api/bitable/homepage/home/v1");
        r103.f216906c = 1;
        tt5.a.h("BitableRecommendDataFetcher", "innerFetch, params: " + r103.f216908e);
        final Disposable r104 = r102.Vc(new com.bytedance.ee.bear.bitable.homepage.tabchoose.a()).a(r103).subscribeOn(d.e()).observeOn(d.d()).subscribe(new a(r101), new b(r101));
        this.f213088a.add(r104);
        r101.i(new BitableTabChooseDataFetcher$fetch$2$1(r104));
        tt5.a.h("BitableRecommendDataFetcher", "fetch send, and wait");
        Object r105 = r101.B();
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r105;
    }
}
