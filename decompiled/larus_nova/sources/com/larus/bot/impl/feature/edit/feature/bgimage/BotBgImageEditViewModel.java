package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import com.larus.image.loader.b0;
import com.larus.network.http.y;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes26.dex */
public final class BotBgImageEditViewModel implements t, u, s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f318606j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f318607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f318608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f318609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1 f318610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<b> f318611e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a1 f318612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f318613g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f318614h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f318615i;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final BotEditParam a() {
        return this.f318607a.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void b(boolean r100) {
        this.f318607a.b(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void c(boolean r100) {
        this.f318607a.c(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f318607a.e(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void f(String r100) {
        this.f318607a.f(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final Map<String, List<String>> g() {
        return this.f318607a.g();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final int getScene() {
        return this.f318607a.getScene();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void h(String r100) {
        this.f318607a.h(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void j(String r100) {
        this.f318607a.j(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "uri");
        this.f318607a.k(r100, r101);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "gender");
        this.f318607a.l(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void m(String r100) {
        this.f318607a.m(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void n(BgImage r100) {
        Intrinsics.checkNotNullParameter(r100, "bgImage");
        this.f318607a.n(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.s
    public final void p(String r100) {
        this.f318607a.p(r100);
    }

    public final Pair<String, String> s() {
        Map<String, List<String>> r100 = g();
        List<String> r101 = r100.get(ContentType.NAME.getValue());
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = (String) CollectionsKt.firstOrNull(r101);
    L7:
        if (Intrinsics.areEqual(r103, a().getName()) == false) goto L9;
        String r104 = null;
    L10:
        List<String> r105 = r100.get(ContentType.DESC.getValue());
        if (r105 == null) goto L13;
        String r106 = (String) CollectionsKt.firstOrNull(r105);
    L15:
        if (Intrinsics.areEqual(r106, a().getDescription()) == true) goto L19;
        r102 = a().getDescription();
    L19:
        return TuplesKt.to(r104, r102);
    L13:
        r106 = null;
        goto L15
    L9:
        r104 = a().getName();
        goto L10
    L5:
        r103 = null;
        goto L7
    }

    @Override // uu8.b
    public final d1<b> getUiEvent() {
        return this.f318612f;
    }

    @Override // uu8.b
    public final i1<c> getUiState() {
        return this.f318610d;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void d(boolean r110) {
        FLogger.f375446a.i("BotBgImageEditViewModel", "refreshIsGenerating, isGenerating: " + r110);
        u(this, null, false, false, r110, 7);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.bgimage.a r310) {
        com.larus.bot.impl.feature.edit.feature.bgimage.a r100 = r310;
        Intrinsics.checkNotNullParameter(r100, "uiAction");
        boolean r101 = true;
        boolean r102 = false;
        String r103 = null;
        if ((r100 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.e) == false) goto L24;
        String r110 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.e) r100).f318620a;
        Pair<String, String> r104 = s();
        if (((c) this.f318610d.getValue()).f318969f == true) goto L22;
        Uri r105 = ((c) this.f318610d.getValue()).f318964a;
        if (r105 == null) goto L9;
        String r106 = r105.toString();
    L10:
        if (r106 != null) goto L12;
    L15:
        if (r101 == true) goto L22;
        if (o0.d(a().getIconUri()) == true) goto L20;
        return;
    L20:
        if (o0.d(a().getIconUrl()) == false) goto L138;
        v(new b.d(new BotAvatarIconData(a().getIconUri(), a().getIconUrl(), a().getAvatarPromptForEnrich(), null, null, 24, null), a().getBgImage(), r104.getFirst(), r104.getSecond(), a().getUserBotGenderStarlingKey(), a().getUserBotTypeStarlingKey(), r110, a().getOriginalUserImgUri(), Boolean.TRUE, a().getOriginalAvatarImgUri(), true, a().getOriginalBackgroundImgUri()));
        return;
    L138:
        return;
    L12:
        if (StringsKt.isBlank(r106) == true) goto L15;
        r101 = false;
        goto L15
    L9:
        r106 = null;
    L22:
        BuildersKt.launch$default(this.f318608b, null, null, new BotBgImageEditViewModel$onClickImageArea$1(this, r104, r110, null), 3, null);
        return;
    L24:
        if (Intrinsics.areEqual(r100, com.larus.bot.impl.feature.edit.feature.bgimage.a.d.f318619a) == false) goto L27;
        qu8.b.e("bot_create/bg_setting", "bot_create", false);
        qu8.b.e("bot_create/bg_setting/ai", "bot_create/bg_setting", false);
        BuildersKt.launch$default(this.f318608b, null, null, new BotBgImageEditViewModel$onClickBottomBtn$1(this, null), 3, null);
        return;
    L27:
        if ((r100 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.g) == true) goto L29;
        String r107 = "";
        if ((r100 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.c) == false) goto L54;
        BotAvatarIconData r108 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.c) r100).f318618a;
        if (r108 != null) goto L42;
        return;
    L42:
        if (o0.d(r108.getIconUrl()) == false) goto L44;
        Uri r109 = b0.a(r108.getIconUrl(), "bot_create.avatar_ai", false, false, 6);
    L45:
        u(this, r109, true, false, false, 12);
        String r111 = r108.getIconUrl();
        if (r111 != null) goto L48;
        r111 = "";
    L48:
        String r112 = r108.getIconUri();
        if (r112 == null) goto L52;
        r107 = r112;
    L52:
        k(r111, r107);
        h(r108.getPrompt());
        c(false);
        return;
    L44:
        r109 = null;
        goto L45
    L54:
        if ((r100 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.f) == false) goto L83;
        com.larus.bot.impl.feature.edit.feature.bgimage.a.f r113 = (com.larus.bot.impl.feature.edit.feature.bgimage.a.f) r100;
        boolean r114 = r113.f318621a;
        Intent r115 = r113.f318622b;
        if (r114 == false) goto L68;
        if (r115 == null) goto L68;
        Uri r116 = (Uri) r115.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        if (r116 == null) goto L68;
        Pair<String, String> r117 = s();
        BotAvatarIconData r118 = new BotAvatarIconData("", r116.toString(), null, null, null, 24, null);
        BgImage r119 = new BgImage(null, r116.toString(), null, new BgImageInfo(null, null, null, null, Boolean.valueOf(av8.b.b(Boolean.FALSE, null)), null, null, null, null, null, null, 2031, null), 4, null);
        String r120 = r117.getFirst();
        String r121 = r117.getSecond();
        String r122 = a().getUserBotGenderStarlingKey();
        String r123 = a().getUserBotTypeStarlingKey();
        String r124 = r116.toString();
        Uri r125 = (Uri) r115.getParcelableExtra("com.yalantis.ucrop.InputUri");
        if (r125 == null) goto L63;
        String r126 = r125.toString();
    L64:
        boolean r127 = o0.d(a().getIconUrl());
        Uri r128 = (Uri) r115.getParcelableExtra("com.yalantis.ucrop.InputUri");
        if (r128 == null) goto L67;
        r103 = r128.toString();
    L67:
        v(new b.d(r118, r119, r120, r121, r122, r123, "click_create_preview", r124, null, r126, r127, r103));
        return;
    L63:
        r126 = null;
    L68:
        FLogger r129 = FLogger.f375446a;
        r129.e("BotBgImageEditViewModel", "crop fail");
        if (r115 == null) goto L81;
        Throwable r130 = (Throwable) r115.getSerializableExtra("com.yalantis.ucrop.Error");
        if (r130 == null) goto L77;
        String r131 = r130.getMessage();
        if (r131 == null) goto L77;
        if (StringsKt.contains$default(r131, "Failed to recognize format", false, 2, null) != true) goto L77;
    L78:
        if (r101 == false) goto L80;
        r129.e("BotBgImageEditViewModel", "Failed to recognize format");
        qu8.b.d("bot_create/bg_setting/manual", 10023);
        qu8.b.d("bot_create/avatar_setting", 1002);
        v(new b.h(new TextRes.StringResId(R.string.larus_unsupported_format)));
        return;
    L80:
        qu8.b.d("bot_create/bg_setting/manual", -2);
        qu8.b.d("bot_create/avatar_setting", 1002);
        v(new b.h(new TextRes.StringResId(R.string.larus_bot_upload_profile_pic_failed)));
        return;
    L77:
        r101 = false;
        goto L78
    L81:
        qu8.b.d("bot_create/bg_setting/manual", -2);
        qu8.b.d("bot_create/avatar_setting", 1002);
        v(new b.h(new TextRes.StringResId(R.string.larus_bot_upload_profile_pic_failed)));
        return;
    L83:
        if ((r100 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.b) == false) goto L120;
        Bundle r132 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.b) r100).f318617a;
        this.f318613g = r132;
        if (getScene() != 1) goto L104;
        BgImage r133 = a().getBgImage();
        if (r133 == null) goto L89;
        String r134 = r133.bgImgUrl;
    L91:
        if (o0.d(r134) == false) goto L102;
        if (r(a().getBgImage()) == false) goto L102;
        BgImage r135 = a().getBgImage();
        if (r135 == null) goto L97;
        r103 = r135.bgImgUrl;
    L97:
        if (r103 == null) goto L100;
        r107 = r103;
    L100:
        u(this, UriProtector.parse(r107), true, false, false, 8);
        return;
    L102:
        if ((!StringsKt.isBlank(a().getIconUrl())) == false) goto L149;
        u(this, UriProtector.parse(a().getIconUrl()), true, true, false, 8);
        return;
    L149:
        return;
    L89:
        r134 = null;
        goto L91
    L104:
        if (r132 == null) goto L106;
        String r136 = r132.getString("user_bot_gender");
    L107:
        if (r132 == null) goto L110;
        r103 = r132.getString("user_bot_type");
    L110:
        if (o0.d(r136) == false) goto L115;
        if (r136 == null) goto L114;
        r107 = r136;
    L114:
        l(r107);
        return;
    L115:
        if (r103 == null) goto L118;
        r107 = r103;
    L118:
        e(r107);
        return;
    L106:
        r136 = null;
        goto L107
    L120:
        if ((r100 instanceof com.larus.bot.impl.feature.edit.feature.bgimage.a.C4126a) == false) goto L136;
        String r137 = ((com.larus.bot.impl.feature.edit.feature.bgimage.a.C4126a) r100).f318616a.getString("bg_image_new_user_guide_click_btn");
        if (Intrinsics.areEqual(r137, "ai_gen") == false) goto L132;
        String r138 = a().getUserBotGenderStarlingKey();
        if (r138 != null) goto L126;
        r138 = "";
    L126:
        String r139 = a().getUserBotTypeStarlingKey();
        if (r139 == null) goto L130;
        r107 = r139;
    L130:
        v(new b.c(r138, r107));
        return;
    L132:
        if (Intrinsics.areEqual(r137, "select_album") == false) goto L154;
        v(new b.e());
        return;
    L154:
        return;
    L136:
        throw new NoWhenBranchMatchedException();
    L29:
        if (((com.larus.bot.impl.feature.edit.feature.bgimage.a.g) r100).f318623a == false) goto L31;
    L35:
        c(true);
        return;
    L31:
        if (String.valueOf(((c) this.f318610d.getValue()).f318964a).length() <= 0) goto L33;
        r102 = true;
    L33:
        if (r102 == false) goto L35;
        v(b.g.f318962a);
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bot.impl.feature.edit.feature.bgimage.t
    public final Object i(Continuation<? super Boolean> r110) {
        if ((r110 instanceof BotBgImageEditViewModel$interceptCreateProcess$1) == false) goto L7;
        BotBgImageEditViewModel$interceptCreateProcess$1 r100 = (BotBgImageEditViewModel$interceptCreateProcess$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BotBgImageEditViewModel$interceptCreateProcess$1 r102 = r100;
        Object r111 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L29:
        com.larus.network.http.a r112 = (com.larus.network.http.a) r111;
        if ((r112 instanceof y) == false) goto L37;
        ImageUploadResult r113 = (ImageUploadResult) ((y) r112).f360135b;
        if (r113 == null) goto L34;
        String r114 = r113.getUploadUri();
    L35:
        j(r114);
        goto L37
    L34:
        r114 = null;
    L37:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (o0.d(a().getOriginalUserImgUri()) == false) goto L37;
        String r115 = a().getOriginalUserImgUri();
        if (r115 == null) goto L21;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        Uri r116 = UriProtector.parse(r115);
        Intrinsics.checkNotNullParameter(r116, "<this>");
        if (Intrinsics.areEqual(r116.getScheme(), "file") != true) goto L21;
        boolean r117 = true;
    L22:
        if (r117 == false) goto L37;
        BotImageUploadViewModel r105 = (BotImageUploadViewModel) this.f318615i.getValue();
        String r118 = a().getOriginalUserImgUri();
        if (r118 != null) goto L26;
        r118 = "";
    L26:
        Uri r119 = UriProtector.parse(r118);
        r102.label = 1;
        r111 = BotImageUploadViewModel.syncUpload$default(r105, r119, 0, null, false, r102, 14, null);
        if (r111 != r103) goto L29;
        return r103;
    L21:
        r117 = false;
    L7:
        r100 = new BotBgImageEditViewModel$interceptCreateProcess$1(this, r110);
        goto L8
    }

    public final boolean r(BgImage r100) {
        if (getScene() != 0) goto L6;
        if (r100 != null) goto L13;
        return false;
    L13:
        return Intrinsics.areEqual(r100.getBgImgOpen(), Boolean.TRUE);
    L6:
        if (r100 == null) goto L8;
        boolean r101 = Intrinsics.areEqual(r100.getBgImgOpen(), Boolean.FALSE);
    L9:
        if (r101 == true) goto L14;
        return true;
    L14:
        return false;
    L8:
        r101 = false;
        goto L9
    }

    public final void v(b r100) {
        BuildersKt.launch$default(this.f318608b, null, null, new BotBgImageEditViewModel$sendUIEvent$1(this, r100, null), 3, null);
    }

    public BotBgImageEditViewModel(CoroutineScope r100, s r110) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r110, "dependency");
        this.f318607a = r110;
        this.f318608b = r100;
        StateFlowImpl r111 = j1.a(new c(null, false, true, new TextRes.StringResId(R.string.larus_AI_generate_avatar), true, false));
        this.f318609c = r111;
        this.f318610d = kotlinx.coroutines.flow.e.b(r111);
        MutableSharedFlow<b> r112 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f318611e = r112;
        this.f318612f = kotlinx.coroutines.flow.e.a(r112);
        this.f318614h = LazyKt.lazy(new q());
        this.f318615i = LazyKt.lazy(new r());
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.e.f318676b, new BotBgImageEditViewModel$bindObservers$1(this, null)), r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void o(String r110, BgImage r111) {
        String r100 = null;
        if (r111 == null) goto L5;
        String r101 = r111.bgImgUrl;
    L7:
        if (o0.d(r101) == true) goto L9;
    L15:
        if (r110 == null) goto L17;
        u(this, UriProtector.parse(r110), true, true, false, 8);
        return;
    L17:
        u(this, null, false, true, false, 8);
        return;
    L9:
        if (r(r111) == false) goto L15;
        if (r111 == null) goto L12;
        r100 = r111.bgImgUrl;
    L12:
        if (r100 != null) goto L14;
        r100 = "";
    L14:
        u(this, UriProtector.parse(r100), true, false, false, 8);
        return;
    L5:
        r101 = null;
        goto L7
    }

    public static final Object q(BotBgImageEditViewModel r110, String r111, String r210, Continuation r211) {
        r110.getClass();
        if ((r211 instanceof BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1) == false) goto L7;
        BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1 r100 = (BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = false;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        Job r107 = (Job) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L24:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r103;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
        r110.b(false);
        if ((r108 instanceof com.larus.network.http.f) == false) goto L37;
        FLogger.f375446a.e("BotBgImageEditViewModel", "interceptShowGenActionSheetToBotInfoReview");
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L29;
        qu8.b.c(20016, new String[]{"bot_create/bg_setting/ai", "bot_create/bg_setting"});
        r110.v(new b.h(new TextRes.StringResId(R.string.larus_network_error)));
    L35:
        r106 = true;
        goto L37
    L29:
        com.larus.network.http.f r109 = (com.larus.network.http.f) r108;
        qu8.b.c(r109.f360157d.getCode(), new String[]{"bot_create/bg_setting/ai", "bot_create/bg_setting"});
        int r112 = lm9.e.f509902a;
        String r113 = lm9.e.a(r109.f360157d, "");
        if (r113.length() != 0) goto L32;
        r106 = true;
    L32:
        if (r106 == false) goto L34;
        r110.v(new b.h(new TextRes.StringResId(R.string.larus_describe_image_error_msg)));
        goto L35
    L34:
        r110.v(new b.h(new TextRes.PlainText(r113)));
    L37:
        return Boxing.boxBoolean(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        if (o0.d(r111) == false) goto L17;
    L20:
        Job r114 = BuildersKt.launch$default(r110.f318608b, null, null, new BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$delayShowLoadingJob$1(r110, null), 3, null);
        AIGenBgImageRepository r115 = (AIGenBgImageRepository) r110.f318614h.getValue();
        r102.L$0 = r114;
        r102.label = 1;
        Object r116 = AIGenBgImageRepository.d(r115, r111, r210, null, r102, 4);
        if (r116 == r104) goto L39;
        r107 = r114;
        r103 = r116;
        goto L24
    L39:
        return r104;
    L17:
        if (o0.d(r210) == true) goto L20;
        return Boxing.boxBoolean(false);
    L7:
        r100 = new BotBgImageEditViewModel$interceptShowGenActionSheetForBotInfoReview$1(r110, r211);
        goto L8
    }

    public final void t(Uri r110, boolean r111, boolean r112, boolean r113) {
        if (r110 != null) goto L4;
        TextRes.StringResId r100 = new TextRes.StringResId(R.string.larus_AI_generate_avatar);
        boolean r101 = true;
    L5:
        StateFlowImpl r102 = this.f318609c;
        ((c) this.f318610d.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r100, "btnStr");
        r102.setValue(new c(r110, r111, r112, r100, r101, r113));
        return;
    L4:
        r100 = new TextRes.StringResId(R.string.larus_edit_image_btn);
        r101 = false;
        goto L5
    }

    public static void u(BotBgImageEditViewModel r100, Uri r101, boolean r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = ((c) r100.f318610d.getValue()).f318964a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = ((c) r100.f318610d.getValue()).f318965b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = ((c) r100.f318610d.getValue()).f318966c;
    L12:
        if ((r105 & 8) == 0) goto L14;
        r104 = ((c) r100.f318610d.getValue()).f318969f;
    L14:
        r100.t(r101, r102, r103, r104);
    }
}
