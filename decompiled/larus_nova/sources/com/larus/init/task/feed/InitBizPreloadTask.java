package com.larus.init.task.feed;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.e1;
import com.larus.utils.logger.FLogger;
import hq9.z1;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/larus/init/task/feed/InitBizPreloadTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "preloadActionBarCacheAndImages", "preloadActionBarImages", "actionBarService", "Lcom/larus/bmhome/chat/actionbar/IActionBarService;", "(Lcom/larus/bmhome/chat/actionbar/IActionBarService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitBizPreloadTask extends bf6.a implements bg9.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f351227b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351228a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        if (com.larus.platform.exp.a.f365360a == true) goto L5;
    L8:
        final List<String> r100 = ((z1) e1.f365733a.getValue()).c();
        List<String> r101 = r100;
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == true) goto L17;
        ag9.a.f3362a.execute(new d(r100));
    L17:
        ag9.a.f3362a.execute(new e());
        return;
    L11:
        if (r101.isEmpty() == true) goto L14;
        r102 = false;
        goto L15
    L5:
        if (com.larus.platform.exp.a.f365363d == false) goto L8;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(ag9.a.f3362a)), null, null, new InitBizPreloadTask$preloadActionBarCacheAndImages$1(this, null), 3, null);
        goto L8
    }

    public InitBizPreloadTask() {
        this.f351228a = ServiceType.BASIC_TEC;
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351228a;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c0 -> B:29:0x00ce). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x010d -> B:29:0x00ce). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0152 -> B:42:0x0159). Please report as a decompilation issue!!! */
    public static final Object a(InitBizPreloadTask r210, IActionBarService r211, Continuation r212) {
        r210.getClass();
        if ((r212 instanceof InitBizPreloadTask$preloadActionBarImages$1) == false) goto L7;
        InitBizPreloadTask$preloadActionBarImages$1 r100 = (InitBizPreloadTask$preloadActionBarImages$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        long r105 = r100.J$0;
        String r106 = (String) r100.L$4;
        Iterator r107 = (Iterator) r100.L$3;
        Iterator r108 = (Iterator) r100.L$2;
        com.larus.image.loader.g r110 = (com.larus.image.loader.g) r100.L$1;
        ImagePipeline r111 = (ImagePipeline) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Iterator r112 = r107;
        Iterator r109 = r108;
        long r113 = r105;
        com.larus.image.loader.g r114 = r110;
    L42:
        ((DataSource) r102).subscribe(new f(r106, r113), CallerThreadExecutor.getInstance());
        Iterator r115 = r109;
        Iterator r116 = r112;
        ImagePipeline r117 = r111;
    L30:
        if (r116.hasNext() == false) goto L27;
        String r118 = (String) r116.next();
        Function1 r119 = new b();
        r100.L$0 = r117;
        r100.L$1 = r114;
        r100.L$2 = r115;
        r100.L$3 = r116;
        r100.L$4 = r118;
        r100.label = 1;
        Lazy r120 = ImageLoaderKt.f350948a;
        Object r121 = ImageLoaderKt.a(r118, "custom_actionbar_icon_prefetch", new com.larus.image.loader.m(r118, "custom_actionbar_icon_prefetch"), r119, r100);
        if (r121 == r103) goto L45;
        com.larus.image.loader.g r122 = r114;
        Iterator r123 = r116;
        String r124 = r118;
        r109 = r115;
        r102 = r121;
    L36:
        if (r117.isInDiskCacheSync(ImageLoaderKt.g((ImageRequest) r102, r122)) == true) goto L38;
        FLogger.f375446a.i("InitBizPreloadTask", "actionbar_image_prefetch skip: disk miss, url=" + r124);
        r115 = r109;
        r116 = r123;
        r114 = r122;
        goto L30
    L38:
        long r125 = System.currentTimeMillis();
        Function1 r126 = new c();
        r100.L$0 = r117;
        r100.L$1 = r122;
        r100.L$2 = r109;
        r100.L$3 = r123;
        r100.L$4 = r124;
        r100.J$0 = r125;
        r100.label = 2;
        Iterator r127 = r123;
        Object r128 = ImageLoaderKt.A(r124, "custom_actionbar_icon_prefetch", null, r122, r126, r100, 12);
        if (r128 == r103) goto L46;
        r112 = r127;
        r111 = r117;
        r106 = r124;
        r102 = r128;
        r114 = r122;
        r113 = r125;
        goto L42
    L46:
        return r103;
    L45:
        return r103;
    L27:
        if (r115.hasNext() == false) goto L44;
        r116 = ((cc8.a) r115.next()).f23320b.iterator();
        goto L30
    L44:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r129 = (String) r100.L$4;
        Iterator r130 = (Iterator) r100.L$3;
        r109 = (Iterator) r100.L$2;
        com.larus.image.loader.g r131 = (com.larus.image.loader.g) r100.L$1;
        ImagePipeline r132 = (ImagePipeline) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r123 = r130;
        r122 = r131;
        r124 = r129;
        r117 = r132;
        goto L36
    L16:
        ResultKt.throwOnFailure(r102);
        e0 r133 = AuthModelDelegate.f297134b.e().getValue();
        if (r133 == null) goto L21;
        LaunchInfo r134 = r133.f297186a;
        if (r134 == null) goto L21;
        String r135 = r134.W();
    L22:
        List<cc8.a> r136 = r211.k(r135);
        if (r136 != null) goto L25;
        r136 = CollectionsKt.emptyList();
    L25:
        List r137 = CollectionsKt.take(r136, com.larus.platform.exp.a.f365369j);
        r117 = Fresco.getImagePipeline();
        r114 = b0.d("custom_actionbar_icon", com.larus.platform.exp.a.f365368i);
        r115 = r137.iterator();
    L21:
        r135 = null;
    L7:
        r100 = new InitBizPreloadTask$preloadActionBarImages$1(r210, r212);
        goto L8
    }
}
