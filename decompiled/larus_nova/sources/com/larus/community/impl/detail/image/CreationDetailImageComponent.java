package com.larus.community.impl.detail.image;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Pair;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.common.apphost.AppHost;
import com.larus.community.impl.detail.c0;
import com.larus.community.impl.detail.f0;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.image.loader.b0;
import com.larus.nova.R;
import com.larus.platform.api.Image;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.IBachService;
import com.larus.platform.api.creation.PreLoadScene;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 42\u00060\u0001j\u0002`\u00022\u00020\u0003:\u00014B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020'H\u0016J\b\u0010*\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u0007H\u0002J \u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0082@¢\u0006\u0002\u00103R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/larus/community/impl/detail/image/CreationDetailImageComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/community/impl/detail/image/CreationDetailImageAbility;", "<init>", "()V", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "getUserCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "creationDetailTopToolsAbility", "Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "getCreationDetailTopToolsAbility", "()Lcom/larus/community/impl/detail/toptools/CreationDetailTopToolsAbility;", "creationDetailTopToolsAbility$delegate", "Lkotlin/Lazy;", "creationDetailBottomToolsAbility", "Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "getCreationDetailBottomToolsAbility", "()Lcom/larus/community/impl/detail/bottomtools/CreationDetailBottomToolsAbility;", "creationDetailBottomToolsAbility$delegate", "creationDetailLoadingAbility", "Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "getCreationDetailLoadingAbility", "()Lcom/larus/community/impl/detail/loading/CreationDetailLoadingAbility;", "creationDetailLoadingAbility$delegate", "creationDetailFragmentAbility", "Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "getCreationDetailFragmentAbility", "()Lcom/larus/community/impl/detail/CreationDetailFragmentAbility;", "creationDetailFragmentAbility$delegate", "digitalAvatarBachAbility", "Lcom/larus/platform/api/creation/IBachAvatarDetectAbility;", "onAttach", "", LiveCommonConstants.REASON_ON_DEDTROY, "getImageView", "Lcom/larus/community/impl/detail/image/CreationZoomableDraweeView;", "containerView", "Lcom/larus/community/impl/detail/image/CreationDetailImageView;", "bindView", "creationDetailImageView", "initObserver", "creation", "detectCreationImage", "getBitmapFromRemoteUrl", "Landroid/graphics/Bitmap;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDetailImageComponent extends ComponentFeature implements d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f329279n = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f329280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f329281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f329282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f329283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public zp9.i f329284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CreationDetailImageView f329285m;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.community.impl.detail.image.d
    public final CreationZoomableDraweeView Jp() {
        CreationDetailImageView r100 = this.f329285m;
        if ((r100 instanceof CreationDetailImageView) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.getImageView();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        zp9.i r100 = this.f329284l;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, d.class);
        if (z2.f365865a.enableClientAvatarDetectAlgorithm() == false) goto L19;
        IBachService r100 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r100 == null) goto L7;
        zp9.i r101 = r100.a();
    L8:
        this.f329284l = r101;
        IBachService r102 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r102 == null) goto L13;
        MutableLiveData<Boolean> r103 = r102.b();
        if (r103 == null) goto L13;
        boolean r104 = Intrinsics.areEqual(r103.getValue(), Boolean.TRUE);
    L14:
        if (r104 == true) goto L20;
        IBachService r105 = (IBachService) ServiceManager.get().getService(IBachService.class);
        if (r105 == null) goto L21;
        r105.c(PreLoadScene.DIGITAL_AVTAR);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r104 = false;
        goto L14
    L7:
        r101 = null;
        goto L8
    }

    public CreationDetailImageComponent() {
        this.f329280h = LazyKt.lazy(new e(this));
        this.f329281i = LazyKt.lazy(new f(this));
        this.f329282j = LazyKt.lazy(new g(this));
        this.f329283k = LazyKt.lazy(new h(this));
    }

    public final void L2(UserCreation r110) {
        String r100 = r110.f364987a;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
    L80:
        CreationDetailImageView r111 = this.f329285m;
        if (r111 == null) goto L90;
        e1.o(r111);
        return;
    L90:
        return;
    L10:
        if (CollectionsKt.listOf(new Integer[]{2, 5, 3, 4}).contains(Integer.valueOf(r110.f364988b)) == false) goto L80;
        final CreationDetailImageView r103 = this.f329285m;
        if (r103 == null) goto L86;
        e1.x(r103);
        c0 r104 = (c0) this.f329283k.getValue();
        if (r104 != null) goto L16;
    L18:
        r101 = false;
    L19:
        Intrinsics.checkNotNullParameter(r110, "userCreation");
        String r105 = null;
        if (r101 == false) goto L38;
        Image r106 = r110.i();
        if (r106 == null) goto L24;
        Long r107 = Long.valueOf(r106.f364793c);
    L25:
        Image r108 = r110.i();
        if (r108 == null) goto L28;
        Long r109 = Long.valueOf(r108.f364794d);
    L29:
        Pair r112 = new Pair(r107, r109);
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L32
        Object r114 = Result.m9449constructorimpl(Float.valueOf(((Number) r112.first).floatValue() / ((Number) r112.second).longValue()));     // Catch: Throwable -> L32
    L34:
        Float r115 = Float.valueOf(0.0f);
        if (Result.m9455isFailureimpl(r114) == false) goto L37;
        r114 = r115;
    L37:
        float r116 = ((Number) r114).floatValue();
        int r117 = f0.f329265a;
        r103.f329288a.f329044b.getLayoutParams().height = f0.a(r103.getContext(), r116);
        r103.f329288a.f329044b.requestLayout();
    L39:
        Intrinsics.checkNotNullParameter(r110, "userCreation");
        Image r118 = r110.i();
        if (r118 == null) goto L42;
        String r119 = r118.f364791a;
    L43:
        Uri r120 = b0.a(r119, "community_creation_detail_preview", false, false, 6);
        z2 r121 = z2.f365865a;
        if (r121.creationFeedThumbRatioLimit43() == true) goto L46;
    L48:
        Uri r122 = b0.a(r110.r(), "community_creation_detail_thumb", false, false, 6);
    L49:
        if (r120 == null) goto L54;
        if (r122 == null) goto L52;
        final ImageRequest r123 = ImageRequestBuilder.newBuilderWithSource(r122).setImageDecodeOptions(ImageDecodeOptions.newBuilder().setBitmapConfig(Bitmap.Config.RGB_565).build()).build();
    L53:
        r103.f329288a.f329045c.setTag(R.id.larus_community_fresco_drawee_image_uri, r120);
        ImageLoaderKt.x(r103.f329288a.f329045c, r120, null, null, new l(r123, r103), 6);
        r103.f329288a.f329045c.setOnLongClickListener(new m(r103));
        r103.f329288a.f329045c.setOnDoubleTapListener(new o(r103));
        goto L54
    L52:
        r123 = null;
    L54:
        Function0<Unit> r124 = new i(this);
        Function0<Unit> r125 = new j(this);
        r103.f329289b = r124;
        r103.f329290c = null;
        r103.f329291d = r125;
        if (r121.enableClientAvatarDetectAlgorithm() == true) goto L57;
        return;
    L57:
        if (r110.f364988b == 3) goto L74;
        CreationDynamicInfo r126 = r110.f364994h;
        if (r126 == null) goto L63;
        TplInfo r127 = r126.f364915e;
        if (r127 == null) goto L63;
        String r128 = r127.f364972a;
    L65:
        if (Intrinsics.areEqual(r128, TplType.AI_REPLICA) == true) goto L74;
        CreationDynamicInfo r129 = r110.f364994h;
        if (r129 == null) goto L71;
        TplInfo r130 = r129.f364915e;
        if (r130 == null) goto L71;
        String r131 = r130.f364972a;
    L73:
        if (Intrinsics.areEqual(r131, TplType.MENU) == true) goto L74;
        return;
    L71:
        r131 = null;
    L63:
        r128 = null;
    L74:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new CreationDetailImageComponent$detectCreationImage$1(r110, this, null), 2, null);
        FLogger r132 = FLogger.f375446a;
        StringBuilder r133 = new StringBuilder("detectCreationImage, userCreationType:");
        r133.append(r110.f364988b);
        r133.append(", tplType:");
        CreationDynamicInfo r134 = r110.f364994h;
        if (r134 == null) goto L79;
        TplInfo r135 = r134.f364915e;
        if (r135 == null) goto L79;
        r105 = r135.f364972a;
    L79:
        r133.append(r105);
        r132.i("CreationDetailImageComponent", r133.toString());
        return;
    L46:
        if (AppHost.f326268a.isOversea() == true) goto L48;
        r122 = b0.a(r110.s(), "community_creation_detail_thumb", false, false, 6);
        goto L49
    L42:
        r119 = null;
    L32:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L28:
        r109 = null;
        goto L29
    L24:
        r107 = null;
        goto L25
    L38:
        r103.f329288a.f329044b.getLayoutParams().height = (int) RangesKt.coerceAtMost(c7.b(600), RangesKt.coerceAtMost(r103.f329293f * 0.7f, (r103.f329292e * 4.0f) / 3));
        r103.f329288a.f329044b.requestLayout();
        goto L39
    L16:
        if (r104.ak() != true) goto L18;
    L86:
        return;
    L5:
        if (o0.d(r100) != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.larus.community.impl.detail.image.d
    public final void P9(CreationDetailImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "creationDetailImageView");
        this.f329285m = r100;
        if (r100 == null) goto L5;
        e1.o(r100);
    L5:
        j29.c r101 = (j29.c) s1a.d.a(this).a(j29.c.class);
        if (r101 == null) goto L8;
        UserCreation r102 = r101.f497042a;
    L9:
        if (r102 == null) goto L15;
        CreationDetailImageView r103 = this.f329285m;
        if (r103 == null) goto L13;
        L2(r102);
    L14:
        if (r103 == null) goto L15;
        return;
    L13:
        r103 = null;
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationDetailImageComponent$initObserver$1(this, null), 3, null);
        Unit r104 = Unit.INSTANCE;
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static final Object F2(CreationDetailImageComponent r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof CreationDetailImageComponent$getBitmapFromRemoteUrl$1) == false) goto L7;
        CreationDetailImageComponent$getBitmapFromRemoteUrl$1 r103 = (CreationDetailImageComponent$getBitmapFromRemoteUrl$1) r102;
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
    L17:
        Bitmap r108 = (Bitmap) r105;
        if (r108 == null) goto L20;
        return r108;
    L20:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        CoroutineDispatcher r109 = Dispatchers.getIO();
        CreationDetailImageComponent$getBitmapFromRemoteUrl$bitmap$1 r110 = new CreationDetailImageComponent$getBitmapFromRemoteUrl$bitmap$1(r101, null);
        r103.label = 1;
        r105 = BuildersKt.withContext(r109, r110, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new CreationDetailImageComponent$getBitmapFromRemoteUrl$1(r100, r102);
        goto L8
    }
}
