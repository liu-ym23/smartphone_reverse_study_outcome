package com.larus.bmhome.double_post.fragment;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager;
import com.larus.bmhome.video.Content;
import com.larus.bmhome.video.RecommendVideoData;
import com.larus.bmhome.video.SortRequestType;
import com.larus.bmhome.video.SortScene;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes26.dex */
public final class RecommendVideoApiRepo implements w {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f311574b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f311575a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.double_post.fragment.w
    public final void a() {
        this.f311575a = 1;
    }

    public RecommendVideoApiRepo() {
        this.f311575a = 1;
    }

    public static void d(int r100, List r101) {
        if (r100 <= 2) goto L5;
        return;
    L5:
        if (r100 != 1) goto L7;
        FLogger.f375446a.d("RecommendVideoApiRepo", "clear cache");
        ((ArrayList) AwemeDoublePostCacheManager.f311409d).clear();
    L7:
        FLogger r102 = FLogger.f375446a;
        r102.d("RecommendVideoApiRepo", "append cache page: " + r100);
        AwemeDoublePostCacheManager r103 = AwemeDoublePostCacheManager.f311406a;
        if (r101 == null) goto L11;
        ((ArrayList) AwemeDoublePostCacheManager.f311409d).addAll(r101);
    L11:
        if (r100 != 2) goto L15;
        r102.d("RecommendVideoApiRepo", "save cache");
        AwemeDoublePostCacheManager.c();
        return;
    }

    public final Object f(RecommendVideoData r100, SortRequestType r101, Continuation<? super RecommendVideoData> r102) {
        if ((r102 instanceof RecommendVideoApiRepo$tryUseLocalCache$1) == false) goto L7;
        RecommendVideoApiRepo$tryUseLocalCache$1 r103 = (RecommendVideoApiRepo$tryUseLocalCache$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L35:
        return new RecommendVideoData((List) r105, null, true, 2, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        boolean r108 = false;
        if (r101 != SortRequestType.PreLoad) goto L17;
    L18:
        if (r100 == null) goto L27;
        List<Content> r109 = r100.getItemLists();
        if (r109 != null) goto L22;
    L25:
        boolean r110 = true;
    L26:
        if (r110 == true) goto L27;
    L30:
        if (r108 == false) goto L36;
        AwemeDoublePostCacheManager r111 = AwemeDoublePostCacheManager.f311406a;
        r103.label = 1;
        r105 = r111.a(r103);
        if (r105 != r106) goto L35;
        return r106;
    L36:
        return r100;
    L22:
        if (r109.isEmpty() == true) goto L25;
        r110 = false;
    L27:
        Lazy r112 = com.larus.bmhome.video.b.f315193a;
        if (com.larus.bmhome.video.b.f() == true) goto L30;
        r108 = true;
        goto L30
    L17:
        if (r101 != SortRequestType.LandingEnterPage) goto L30;
    L7:
        r103 = new RecommendVideoApiRepo$tryUseLocalCache$1(this, r102);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00fc -> B:51:0x00ff). Please report as a decompilation issue!!! */
    public final Object e(int r110, long r210, Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r211, Continuation<? super RecommendVideoData> r212) {
        if ((r212 instanceof RecommendVideoApiRepo$requestWithRetry$1) == false) goto L7;
        RecommendVideoApiRepo$requestWithRetry$1 r100 = (RecommendVideoApiRepo$requestWithRetry$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r105 = r100.I$1;
        long r106 = r100.J$0;
        int r111 = r100.I$0;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r112 = (Function1) r100.L$0;
        ResultKt.throwOnFailure(r102);
        RecommendVideoApiRepo$requestWithRetry$1 r107 = r100;
        int r108 = r111;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r109 = r112;
        Object r113 = r103;
        int r114 = r105;
        long r115 = r106;
    L51:
        r114 = r114 + 1;
    L21:
        if (r114 < r108) goto L55;
        return null;
    L55:
        r107.L$0 = r109;     // Catch: Exception -> L46
        r107.I$0 = r108;     // Catch: Exception -> L46
        r107.J$0 = r115;     // Catch: Exception -> L46
        r107.I$1 = r114;     // Catch: Exception -> L46
        r107.I$2 = r114;     // Catch: Exception -> L46
        r107.label = 1;     // Catch: Exception -> L46
        r102 = r109.invoke(r107);     // Catch: Exception -> L46
        if (r102 != r113) goto L26;
        return r113;
    L26:
        RecommendVideoData r116 = (RecommendVideoData) r102;     // Catch: Exception -> L18
        if (r116 == null) goto L44;
        if (r116.getHasMore() == true) goto L32;
        return r116;
    L32:
        List<Content> r117 = r116.getItemLists();     // Catch: Exception -> L18
        if (r117 != null) goto L35;
    L38:
        boolean r118 = true;
    L39:
        if (r118 == true) goto L42;
        return r116;
    L42:
        throw new RequestRecommendVideoDataError("data is null or itemLists is null or empty");     // Catch: Exception -> L18
    L35:
        if (r117.isEmpty() == true) goto L38;
        r118 = false;
        goto L39
    L44:
        throw new RequestRecommendVideoDataError("data is null or itemLists is null or empty");     // Catch: Exception -> L18
    L46:
        Exception e100 = e;
        int r119 = r114;
    L48:
        FLogger.f375446a.i("RecommendVideoApiRepo", "requestWithRetry: request error attempt(" + (r119 + 1) + ") with exception(" + e100.getMessage() + ')');
        r107.L$0 = r109;
        r107.I$0 = r108;
        r107.J$0 = r115;
        r107.I$1 = r114;
        r107.label = 2;
        if (DelayKt.delay(r115, r107) != r113) goto L51;
        return r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r120 = r100.I$2;
        int r121 = r100.I$1;
        long r122 = r100.J$0;
        int r123 = r100.I$0;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r124 = (Function1) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Exception -> L18
    L18:
        e100 = e;
        r107 = r100;
        r113 = r103;
        r108 = r123;
        r114 = r121;
        r109 = r124;
        r119 = r120;
        r115 = r122;
        goto L48
    L20:
        ResultKt.throwOnFailure(r102);
        r109 = r211;
        r107 = r100;
        r113 = r103;
        r114 = 0;
        r108 = r110;
        r115 = r210;
    L7:
        r100 = new RecommendVideoApiRepo$requestWithRetry$1(this, r212);
        goto L8
    }

    @Override // com.larus.bmhome.double_post.fragment.w
    public final Object b(SortScene r210, SortRequestType r211, int r212, List<String> r213, List<String> r214, String r215, String r216, Continuation<? super RecommendVideoData> r217) {
        SortRequestType r110 = r211;
        if ((r217 instanceof RecommendVideoApiRepo$refreshData$1) == false) goto L7;
        RecommendVideoApiRepo$refreshData$1 r100 = (RecommendVideoApiRepo$refreshData$1) r217;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        RecommendVideoApiRepo$refreshData$1 r111 = r100;
        Object r102 = r111.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r111.label;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r102);
    L34:
        return r102;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        SortRequestType r104 = (SortRequestType) r111.L$0;
        ResultKt.throwOnFailure(r102);
        r110 = r104;
    L27:
        RecommendVideoData r105 = (RecommendVideoData) r102;
        int r106 = this.f311575a;
        if (r105 == null) goto L30;
        List<Content> r107 = r105.getItemLists();
    L31:
        d(r106, r107);
        r111.L$0 = null;
        r111.label = 3;
        r102 = f(r105, r110, r111);
        if (r102 != r112) goto L34;
        return r112;
    L30:
        r107 = null;
        goto L31
    L17:
        ResultKt.throwOnFailure(r102);
    L23:
        return r102;
    L18:
        ResultKt.throwOnFailure(r102);
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L24;
        FLogger.f375446a.i("RecommendVideoApiRepo", "refreshData: network is not available");
        r111.label = 1;
        r102 = f(null, r110, r111);
        if (r102 != r112) goto L23;
        return r112;
    L24:
        this.f311575a = 1;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r113 = new RecommendVideoApiRepo$refreshData$data$1(r210, r211, this, r213, r214, r215, r216, null);
        r111.L$0 = r110;
        r111.label = 2;
        r102 = e(r212, 5000, r113, r111);
        if (r102 != r112) goto L27;
        return r112;
    L7:
        r100 = new RecommendVideoApiRepo$refreshData$1(this, r217);
        goto L8
    }

    @Override // com.larus.bmhome.double_post.fragment.w
    public final Object c(SortScene r210, SortRequestType r211, int r212, List<String> r213, List<String> r214, String r215, String r216, Continuation<? super RecommendVideoData> r217) {
        if ((r217 instanceof RecommendVideoApiRepo$loadMoreData$1) == false) goto L7;
        RecommendVideoApiRepo$loadMoreData$1 r100 = (RecommendVideoApiRepo$loadMoreData$1) r217;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        RecommendVideoApiRepo$loadMoreData$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L35:
        return r103;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r106 = r102.I$0;
        SortRequestType r107 = (SortRequestType) r102.L$0;
        ResultKt.throwOnFailure(r103);
        Object r108 = r104;
        RecommendVideoApiRepo$loadMoreData$1 r110 = r102;
        List<Content> r109 = null;
    L28:
        RecommendVideoData r111 = (RecommendVideoData) r103;
        if (r111 == null) goto L31;
        List<Content> r112 = r111.getItemLists();
    L32:
        d(r106, r112);
        r110.L$0 = r109;
        r110.label = 3;
        r103 = f(r111, r107, r110);
        if (r103 != r108) goto L35;
        return r108;
    L31:
        r112 = r109;
        goto L32
    L17:
        ResultKt.throwOnFailure(r103);
    L23:
        return r103;
    L18:
        ResultKt.throwOnFailure(r103);
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L24;
        FLogger.f375446a.i("RecommendVideoApiRepo", "loadMoreData: network is not available");
        r102.label = 1;
        r103 = f(null, r211, r102);
        if (r103 != r104) goto L23;
        return r104;
    L24:
        int r113 = 1 + this.f311575a;
        this.f311575a = r113;
        Function1<? super Continuation<? super RecommendVideoData>, ? extends Object> r114 = new RecommendVideoApiRepo$loadMoreData$data$1(r210, r211, r113, r213, r214, r215, r216, null);
        r102.L$0 = r211;
        r102.I$0 = r113;
        r102.label = 2;
        r109 = null;
        r108 = r104;
        r110 = r102;
        r103 = e(r212, 5000, r114, r110);
        if (r103 != r108) goto L27;
        return r108;
    L27:
        r107 = r211;
        r106 = r113;
    L7:
        r100 = new RecommendVideoApiRepo$loadMoreData$1(this, r217);
        goto L8
    }
}
