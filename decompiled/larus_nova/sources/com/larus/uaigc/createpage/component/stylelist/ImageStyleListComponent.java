package com.larus.uaigc.createpage.component.stylelist;

import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.Keva;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.w;
import com.larus.im.internal.delegate.c0;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.i1;
import ny9.s;
import zd9.h;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 12\u00060\u0001j\u0002`\u00022\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0016\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0002J\f\u0010(\u001a\u00020\u000e*\u00020)H\u0002J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010+\u001a\u00020,H\u0002J\u0018\u0010-\u001a\u0004\u0018\u00010\u000b2\u0006\u0010.\u001a\u00020/H\u0082@¢\u0006\u0002\u00100R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001d¨\u00062"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleListComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/uaigc/createpage/component/stylelist/IImageStyleListAbility;", "<init>", "()V", "isImageListShowLoading", "", "isFetchingImageStyleList", "isShowingTxt2ImageStyleList", "cachedImageStyleData", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendResponse;", "prevTxt2ImageStyleList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "imageSelectorAbility", "Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "getImageSelectorAbility", "()Lcom/larus/uaigc/bean/createpage/component/mediacontainer/imageselector/IImageSelectorAbility;", "imageSelectorAbility$delegate", "Lkotlin/Lazy;", "creationEditorAbility", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "getCreationEditorAbility", "()Lcom/larus/bmhome/view/actionbar/edit/creationpage/component/editor/CreationEditorAbility;", "creationEditorAbility$delegate", "argumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "getArgumentData", "()Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "argumentData$delegate", "onAttach", "", WidgetCostModule.TYPE_ON_CREATE, "refreshImageStyleList", "fromRemote", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindObservers", "preloadImageStyleListImage", "preloadImageStyleList", "toActionBarInstructionOption", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyle;", "buildImageStylePlaceholderList", "count", "", "fetchImageStyleListFromRemote", UserInfo.LANGUAGECODE, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageStyleListComponent extends ComponentFeature implements com.larus.uaigc.createpage.component.stylelist.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f372462p = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f372463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f372464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f372465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageStyleRecommendApi.ImageStyleRecommendResponse f372466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<w> f372467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f372468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f372469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f372470o;

    public static final class a {
    }

    static {
    }

    public final ys8.a L2() {
        return (ys8.a) this.f372469n.getValue();
    }

    public ImageStyleListComponent() {
        this.f372465j = true;
        this.f372468m = LazyKt.lazy(new d(this));
        this.f372469n = LazyKt.lazy(new e(this));
        this.f372470o = LazyKt.lazy(new f(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageStyleListComponent$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ImageStyleListComponent$preloadImageStyleList$1(this, null), 3, null);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        s1a.d.a(this).c(this, com.larus.uaigc.createpage.component.stylelist.a.class);
    }

    public static w P2(ImageStyleRecommendApi.ImageStyle r100) {
        Long r101 = r100.getId();
        g1 r102 = r100.getIcon();
        return new w(r101, r100.getDisplayText(), r100.getMessageText(), r102, 2, null, null, 8388436);
    }

    public final Object F2(String r100, Continuation<? super ImageStyleRecommendApi.ImageStyleRecommendResponse> r101) {
        if ((r101 instanceof ImageStyleListComponent$fetchImageStyleListFromRemote$1) == false) goto L7;
        ImageStyleListComponent$fetchImageStyleListFromRemote$1 r102 = (ImageStyleListComponent$fetchImageStyleListFromRemote$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        dm9.a r108 = (dm9.a) r104;
        if ((r108 instanceof dm9.a.b) == false) goto L32;
        dm9.a.b r109 = (dm9.a.b) r108;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r110 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r109.f469231a.getData();
        if (r110 == null) goto L22;
        List<ImageStyleRecommendApi.ImageStyle> r111 = r110.getStyleList();
    L23:
        List<ImageStyleRecommendApi.ImageStyle> r112 = r111;
        if (r112 != null) goto L26;
    L29:
        if (r107 == false) goto L42;
        FLogger.f375446a.e("ImageStyleListComponent", "fetchImageStyleListFromRemote success but return empty list");
        return null;
    L42:
        return (ImageStyleRecommendApi.ImageStyleRecommendResponse) r109.f469231a.getData();
    L26:
        if (r112.isEmpty() == true) goto L29;
        r107 = false;
        goto L29
    L22:
        r111 = null;
        goto L23
    L32:
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("fetchImageStyleListFromRemote failed, msg: ");
        if ((r108 instanceof dm9.a.C5690a) == false) goto L35;
        dm9.a.C5690a r115 = (dm9.a.C5690a) r108;
    L36:
        if (r115 == null) goto L38;
        String r116 = r115.f469229b;
    L39:
        r114.append(r116);
        r114.append('}');
        r113.e("ImageStyleListComponent", r114.toString());
        return null;
    L38:
        r116 = null;
        goto L39
    L35:
        r115 = null;
        goto L36
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        ImageStyleRecommendApi.a r117 = ImageStyleRecommendApi.f372472a;
        ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1 r118 = new ImageStyleListComponent$fetchImageStyleListFromRemote$resp$1(r100, null);
        r102.label = 1;
        r117.getClass();
        r104 = BuildersKt.withContext(Dispatchers.getIO(), new ImageStyleRecommendApi$Companion$safeCall$2(r118, null), r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new ImageStyleListComponent$fetchImageStyleListFromRemote$1(this, r101);
        goto L8
    }

    public final Object N2(boolean r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof ImageStyleListComponent$refreshImageStyleList$1) == false) goto L7;
        ImageStyleListComponent$refreshImageStyleList$1 r100 = (ImageStyleListComponent$refreshImageStyleList$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Object r104 = null;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        r110 = r100.Z$0;
        ImageStyleListComponent r105 = (ImageStyleListComponent) r100.L$1;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L52:
        ImageStyleRecommendApi.ImageStyleRecommendResponse r113 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r112;
    L54:
        r105.f372466k = r113;
        this.f372464i = false;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r107 = this.f372466k;
        if (r107 == null) goto L61;
        List<ImageStyleRecommendApi.ImageStyle> r108 = r107.getStyleList();
        if (r108 == null) goto L61;
        List r109 = CollectionsKt.take(r108, 5);
        if (r109 == null) goto L61;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ImageStyleListComponent$preloadImageStyleListImage$1$1(r109, null), 2, null);
    L61:
        if (r110 == true) goto L63;
    L64:
        sy9.a r114 = (sy9.a) this.f372468m.getValue();
        if (r114 == null) goto L69;
        i1<sy9.b> r115 = r114.getUiState();
        if (r115 == null) goto L69;
        sy9.b r116 = r115.getValue();
    L71:
        if ((r116 instanceof sy9.b.e) == true) goto L81;
    L72:
        sy9.a r117 = (sy9.a) this.f372468m.getValue();
        if (r117 == null) goto L77;
        i1<sy9.b> r118 = r117.getUiState();
        if (r118 == null) goto L77;
        sy9.b r119 = r118.getValue();
    L79:
        if ((r119 instanceof sy9.b.c) == true) goto L81;
    L142:
        return Unit.INSTANCE;
    L77:
        r119 = null;
    L81:
        if (this.f372463h == false) goto L83;
    L84:
        this.f372463h = false;
        List<w> r120 = this.f372467l;
        if (r120 != null) goto L90;
        ys8.a r121 = L2();
        if (r121 == null) goto L89;
        r120 = r121.getCurImageList();
        goto L90
    L89:
        r120 = null;
    L90:
        this.f372467l = r120;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r122 = this.f372466k;
        if (r122 == null) goto L134;
        List<ImageStyleRecommendApi.ImageStyle> r123 = r122.getStyleList();
        if (r123 == null) goto L134;
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r123.iterator();
    L96:
        if (r125.hasNext() == false) goto L103;
        ImageStyleRecommendApi.ImageStyle r126 = (ImageStyleRecommendApi.ImageStyle) r125.next();
        if (r126 == null) goto L100;
        w r127 = P2(r126);
    L101:
        if (r127 == null) goto L96;
        r124.add(r127);
        goto L96
    L100:
        r127 = null;
        goto L101
    L103:
        if (r110 == true) goto L130;
        s r128 = (s) this.f372470o.getValue();
        if (r128 != null) goto L107;
    L109:
        boolean r129 = false;
    L110:
        if (r129 == false) goto L130;
        ys8.a r130 = L2();
        if (r130 == null) goto L130;
        Long r131 = r130.getDefaultSelectedImageStyleId();
        if (r131 == null) goto L130;
        long r132 = r131.longValue();
        Iterator r133 = r124.iterator();
    L117:
        if (r133.hasNext() == false) goto L127;
        Object r134 = r133.next();
        Long r135 = ((w) r134).f295510a;
        if (r135 != null) goto L122;
    L124:
        boolean r136 = false;
    L125:
        if (r136 == false) goto L117;
        r104 = r134;
        goto L127
    L122:
        if (r135.longValue() != r132) goto L124;
        r136 = true;
    L127:
        w r137 = (w) r104;
        if (r137 == null) goto L130;
        r137.f295528s = Boxing.boxInt(1);
        goto L130
    L107:
        if (r128.D() != true) goto L109;
        r129 = true;
    L130:
        ys8.a r138 = L2();
        if (r138 == null) goto L133;
        r138.refreshImageListSelectorWithMore(r124);
    L133:
        Keva r139 = c.f372477a;
        c.a(this.f372466k, r106);
    L140:
        this.f372465j = false;
    L134:
        ys8.a r140 = L2();
        if (r140 == null) goto L140;
        List<w> r141 = this.f372467l;
        if (r141 != null) goto L139;
        r141 = CollectionsKt.emptyList();
    L139:
        r140.refreshImageListSelectorWithMore(r141);
        goto L140
    L83:
        if (this.f372465j == false) goto L142;
    L69:
        r116 = null;
        goto L71
    L63:
        if (this.f372463h == false) goto L72;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = r100.Z$0;
        r105 = (ImageStyleListComponent) r100.L$1;
        r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        r113 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r112;
        goto L54
    L16:
        ResultKt.throwOnFailure(r112);
        this.f372464i = true;
        String r142 = IAIChatUgcAIGCService.f365905a.K0();
        if (r110 == false) goto L23;
        r100.L$0 = r142;
        r100.L$1 = this;
        r100.Z$0 = r110;
        r100.label = 1;
        Object r143 = F2(r142, r100);
        if (r143 != r102) goto L21;
        return r102;
    L21:
        r105 = this;
        r106 = r142;
        r112 = r143;
        goto L22
    L23:
        Keva r144 = c.f372477a;
        Intrinsics.checkNotNullParameter(r142, UserInfo.LANGUAGECODE);
        FLogger.f375446a.i("ImageStyleListCache", "getImageStyleList");
        String r145 = c.f372477a.getString("image_style_list_resp_" + r142, "");
        if (r145 != null) goto L143;
        ImageStyleRecommendApi.ImageStyleRecommendResponse r146 = null;
    L47:
        if (r146 != null) goto L53;
        r100.L$0 = r142;
        r100.L$1 = this;
        r100.Z$0 = r110;
        r100.label = 2;
        Object r147 = F2(r142, r100);
        if (r147 != r102) goto L51;
        return r102;
    L51:
        r105 = this;
        r106 = r142;
        r112 = r147;
        goto L52
    L53:
        r105 = this;
        r106 = r142;
        r113 = r146;
        goto L54
    L143:
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L40
        h r149 = h.f571481a;     // Catch: Throwable -> L40
        if (StringsKt.isBlank(r145) == false) goto L145;
    L37:
        Object r150 = null;
    L38:
        Object r151 = Result.m9449constructorimpl((ImageStyleRecommendApi.ImageStyleRecommendResponse) r150);     // Catch: Throwable -> L40
    L43:
        if (Result.m9455isFailureimpl(r151) == false) goto L45;
        r151 = null;
    L45:
        r146 = (ImageStyleRecommendApi.ImageStyleRecommendResponse) r151;
        goto L47
    L145:
        r149.getClass();     // Catch: Throwable -> L30
        r150 = Result.m9449constructorimpl(h.f571482b.fromJson(r145, new b().getType()));     // Catch: Throwable -> L30
    L32:
        Throwable r152 = Result.m9452exceptionOrNullimpl(r150);     // Catch: Throwable -> L40
        if (r152 == null) goto L36;
        c0 r153 = c0.f348199b;     // Catch: Throwable -> L40
        StringBuilder r154 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L40
        Intrinsics.checkNotNullParameter(r152, "<this>");     // Catch: Throwable -> L40
        r154.append(ExceptionsKt.stackTraceToString(r152));     // Catch: Throwable -> L40
        r153.e("GsonHolder", r154.toString());     // Catch: Throwable -> L40
    L36:
        if (Result.m9455isFailureimpl(r150) == false) goto L38;
    L30:
        th = move-exception;
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L40
        r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        Result.Companion r156 = Result.Companion;
        r151 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new ImageStyleListComponent$refreshImageStyleList$1(this, r111);
        goto L8
    }
}
