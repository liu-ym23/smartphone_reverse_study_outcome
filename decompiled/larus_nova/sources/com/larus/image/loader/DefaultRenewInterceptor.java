package com.larus.image.loader;

import android.net.Uri;
import android.os.Looper;
import android.util.Pair;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.net.FrescoTTNetFetcher;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.InputStream;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class DefaultRenewInterceptor implements FrescoTTNetFetcher.FetcherInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DefaultRenewInterceptor f350947a = null;

    /* JADX INFO: renamed from: com.larus.image.loader.DefaultRenewInterceptor$intercepterUrl$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.image.loader.DefaultRenewInterceptor$intercepterUrl$2", f = "DefaultRenew.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ String $url;
        int label;

        public AnonymousClass2(String r100, Continuation<? super AnonymousClass2> r101) {
            this.$url = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$url, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return y0.k((Uri) r100);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            String r103 = this.$url;
            this.label = 1;
            r100 = ImageLoaderKt.r(r103, "renew_default", this);
            if (r100 != r101) goto L12;
            return r101;
        }
    }

    static {
        f350947a = new DefaultRenewInterceptor();
    }

    public DefaultRenewInterceptor() {
    }

    @Override // com.facebook.net.FrescoTTNetFetcher.FetcherInterceptor
    public final String intercepterUrl(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L11:
        Uri r103 = UriProtector.parse(r100);
        String r104 = y0.f(r103, "flow_renew");
        if (Intrinsics.areEqual(r104, "0") == false) goto L15;
        return r100;
    L15:
        if (b0.c(r103) == false) goto L17;
    L26:
        String r105 = y0.f(r103, "biz_tag");
        com.larus.platform.service.g r106 = com.larus.platform.service.g.f365738a;
        JSONObject r107 = new JSONObject();
        r107.put("biz_tag", o0.a(r105));
        r107.put("interceptor_url", o0.a(r100));
        r107.put("thread_name", o0.a(ThreadMethodProxy.currentThread().getName()));
        Unit r108 = Unit.INSTANCE;
        r106.monitorEventForSlardar("default_renew_monitor", r107, null, null);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L30;
        return r100;
    L30:
        return (String) BuildersKt.runBlocking$default(null, new AnonymousClass2(r100, null), 1, null);
    L17:
        if (Intrinsics.areEqual(r104, "1") == false) goto L19;
    L25:
        return r100;
    L19:
        if (Intrinsics.areEqual(r104, "2") == true) goto L25;
        if ((o.a() & 1) == 0) goto L24;
        r101 = true;
    L24:
        if (r101 == true) goto L26;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.facebook.net.FrescoTTNetFetcher.FetcherInterceptor
    public final Pair<InputStream, Long> intercepterStream(InputStream r100, String r101, long r102) {
        return new Pair(r100, Long.valueOf(r102));
    }
}
