package com.larus.profile.impl.creation;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.router.SmartRouter;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.service.ICreationWorkflowService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationImageEditAbility {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f366144d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f366145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleCoroutineScope f366146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fs9.g f366147c;

    public static final class a {
    }

    public static final class b extends BaseDataSubscriber<CloseableReference<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Bitmap, Unit> f366148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f366149b;

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            Intrinsics.checkNotNullParameter(r100, "dataSource");
            Function1<String, Unit> r101 = this.f366149b;
            if (r101 == null) goto L6;
            r101.invoke("Bitmap download fails.");
            return;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> r100) {
            Intrinsics.checkNotNullParameter(r100, "dataSource");
            if (r100.isFinished() == false) goto L21;
            CloseableReference<CloseableImage> r101 = r100.getResult();
            if (r101 == null) goto L26;
            CloseableImage r102 = r101.get();     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.facebook.imagepipeline.image.CloseableBitmap");     // Catch: Throwable -> L12 Exception -> L14
            Bitmap r103 = ((CloseableBitmap) r102).getUnderlyingBitmap();     // Catch: Throwable -> L12 Exception -> L14
            if (r103 != null) goto L9;
        L18:
            r101.close();
            return;
        L9:
            if (r103.isRecycled() == true) goto L18;
            Bitmap r104 = r103.copy(com.larus.utils.z0.b(r103.getConfig()), r103.isMutable());     // Catch: Throwable -> L12 Exception -> L14
            Function1<Bitmap, Unit> r105 = this.f366148a;     // Catch: Throwable -> L12 Exception -> L14
            Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L12 Exception -> L14
            r105.invoke(r104);     // Catch: Throwable -> L12 Exception -> L14
        L14:
            e = move-exception;
            Function1<String, Unit> r106 = this.f366149b;     // Catch: Throwable -> L12
            if (r106 == null) goto L18;
            r106.invoke(e.toString());     // Catch: Throwable -> L12
            goto L18
        L26:
            return;
        L12:
            th = move-exception;
            r101.close();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Bitmap, Unit> r100, Function1<? super String, Unit> r101) {
            this.f366148a = r100;
            this.f366149b = r101;
        }
    }

    static {
    }

    public final void c() {
        LifecycleCoroutineScope r100 = this.f366146b;
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, null, null, new CreationImageEditAbility$doImageEditAction$1(this, null), 3, null);
        return;
    }

    public static final void b(CreationImageEditAbility r100, Bundle r101) {
        r100.getClass();
        if (ICreationWorkflowService.f373940a.U(r100.f366145a, false, r101, true) == true) goto L7;
        com.bytedance.router.i r102 = SmartRouter.buildRoute(r100.f366145a, "//flow/chat_page");
        r102.f267554c.putExtras(r101);
        r102.f267555d = R.anim.larus_router_slide_in_right;
        r102.f267556e = R.anim.larus_router_no_anim;
        r102.d();
        return;
    }

    public CreationImageEditAbility(Context r100, LifecycleCoroutineScope r101, fs9.g r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "doImageEditInitParams");
        this.f366145a = r100;
        this.f366146b = r101;
        this.f366147c = r102;
    }

    public final Object d(String r100, Function1<? super Bitmap, Unit> r101, Function1<? super String, Unit> r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof CreationImageEditAbility$downloadByUrl$3) == false) goto L7;
        CreationImageEditAbility$downloadByUrl$3 r104 = (CreationImageEditAbility$downloadByUrl$3) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        b r109 = (b) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L18:
        ImageRequest r110 = ImageRequestBuilder.newBuilderWithSource((Uri) r106).build();
        Fresco.getImagePipeline().fetchDecodedImage(r110, AppHost.f326268a.getApplication()).subscribe(r109, UiThreadImmediateExecutorService.getInstance());
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        b r111 = new b(r101, r102);
        r104.L$0 = r111;
        r104.label = 1;
        Object r112 = ImageLoaderKt.r(r100, "bitmap_downloader", r104);
        if (r112 != r107) goto L17;
        return r107;
    L17:
        r106 = r112;
        r109 = r111;
    L7:
        r104 = new CreationImageEditAbility$downloadByUrl$3(this, r103);
        goto L8
    }

    public static final Object a(CreationImageEditAbility r110, String r111, String r112, Map r113, int r210, CreationImageEditAbility$doImageEditAction$1.a r211, Continuation r212) {
        r110.getClass();
        if ((r212 instanceof CreationImageEditAbility$buildImageRemoveSendMessageConfig$1) == false) goto L7;
        CreationImageEditAbility$buildImageRemoveSendMessageConfig$1 r100 = (CreationImageEditAbility$buildImageRemoveSendMessageConfig$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        boolean r105 = true;
        String r114 = "";
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        int r106 = r100.I$0;
        String r107 = (String) r100.L$4;
        zs8.a r108 = (zs8.a) r100.L$3;
        Map r109 = (Map) r100.L$2;
        String r115 = (String) r100.L$1;
        String r116 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L34:
        wc9.e r117 = (wc9.e) r102;
        if (r117 != null) goto L37;
        r117 = AuthModelDelegate.f297134b.u().getValue();
    L37:
        String r118 = r116;
        Map r119 = r109;
        String r120 = r115;
    L38:
        if (r117 == null) goto L40;
        String r121 = r117.f559198a;
    L41:
        if (r121 == null) goto L45;
        r114 = r121;
    L45:
        if (r114.length() != 0) goto L47;
        boolean r122 = true;
    L48:
        if (r122 == true) goto L52;
        r107 = r114;
    L52:
        if (r107.length() == 0) goto L55;
        r105 = false;
    L55:
        if (r105 == false) goto L57;
        FLogger.f375446a.e("creationImageEditAbility", "buildImageRemoveSendMessageConfig cvsId is empty");
        return null;
    L57:
        CreationSendMessageConfig.Companion.getClass();
        CreationSendMessageConfig.a r123 = new CreationSendMessageConfig.a();
        r123.l(r107);
        r123.f(r118);
        r123.i(r120);
        r123.s("edit");
        r123.u("edit");
        r123.m(r108.getEnterMethod());
        r123.r(r108.b());
        r123.d(Boxing.boxInt(r106));
        r123.c(r119);
        r123.b("image_edit");
        return r123.f370355a;
    L47:
        r122 = false;
        goto L48
    L40:
        r121 = null;
        goto L41
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r106 = r100.I$0;
        r107 = (String) r100.L$4;
        r108 = (zs8.a) r100.L$3;
        Map r124 = (Map) r100.L$2;
        String r125 = (String) r100.L$1;
        String r126 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r119 = r124;
        r120 = r125;
        r118 = r126;
    L28:
        r117 = (wc9.e) r102;
        if (r117 != null) goto L38;
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r127 = RepoDispatcher.f307734f;
        r100.L$0 = r118;
        r100.L$1 = r120;
        r100.L$2 = r119;
        r100.L$3 = r108;
        r100.L$4 = r107;
        r100.I$0 = r106;
        r100.label = 2;
        r102 = r127.f(r100);
        if (r102 == r103) goto L61;
        r116 = r118;
        r115 = r120;
        r109 = r119;
        goto L34
    L61:
        return r103;
    L16:
        ResultKt.throwOnFailure(r102);
        com.larus.bmhome.chat.api.e0 r128 = AuthModelDelegate.f297134b.e().getValue();
        if (r128 == null) goto L21;
        LaunchInfo r129 = r128.f297186a;
        if (r129 == null) goto L21;
        String r130 = r129.Y();
    L22:
        if (r130 != null) goto L24;
        r130 = "";
    L24:
        RepoDispatcher.f307729a.getClass();
        ConversationRepo r131 = RepoDispatcher.f307734f;
        r118 = r111;
        r100.L$0 = r118;
        r120 = r112;
        r100.L$1 = r120;
        r119 = r113;
        r100.L$2 = r119;
        r100.L$3 = r211;
        r100.L$4 = r130;
        r100.I$0 = r210;
        r100.label = 1;
        Object r132 = IConversationRepoService.a.c(r131, r130, false, null, r100, 6);
        if (r132 == r103) goto L60;
        r108 = r211;
        r107 = r130;
        r102 = r132;
        r106 = r210;
        goto L28
    L60:
        return r103;
    L21:
        r130 = null;
    L7:
        r100 = new CreationImageEditAbility$buildImageRemoveSendMessageConfig$1(r110, r212);
        goto L8
    }
}
