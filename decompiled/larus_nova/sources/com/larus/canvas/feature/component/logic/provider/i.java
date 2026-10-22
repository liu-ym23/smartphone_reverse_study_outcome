package com.larus.canvas.feature.component.logic.provider;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larus.bmhome.bigimg.aibeautify.CommonAiBeautifyLayout;
import com.larus.bmhome.bigimg.download.CommonDownLoadLayout;
import com.larus.bmhome.bigimg.u1;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.view.CreationOperateContainerView;
import com.larus.canvas.impl.databinding.LarusLayoutCanvasGenerateBottomProviderBinding;
import com.larus.nova.R;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.e0;
import com.larus.platform.service.z2;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.e1;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.e2;
import tx9.m0;
import tx9.o0;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class i extends com.larus.gallery.api.t<ky8.a> implements zp9.r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f323437f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusLayoutCanvasGenerateBottomProviderBinding f323438g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f323439h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f323440i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f323441j;

    @Override // com.larus.gallery.api.t
    public final boolean m() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        LarusLayoutCanvasGenerateBottomProviderBinding r100 = this.f323438g;
        if (r100 == null) goto L7;
        CreationOperateContainerView r101 = r100.f323783c;
        if (r101 == null) goto L7;
        r101.setByPublisher(z2.f365865a.getCreationPublishConfig().b());
    L7:
        LarusLayoutCanvasGenerateBottomProviderBinding r102 = this.f323438g;
        String r103 = null;
        if (r102 == null) goto L12;
        CreationOperateContainerView r104 = r102.f323783c;
        if (r104 == null) goto L12;
        final View r105 = r104.findViewById(R.id.privacy_button_container);
    L13:
        LarusLayoutCanvasGenerateBottomProviderBinding r106 = this.f323438g;
        if (r106 == null) goto L18;
        CreationOperateContainerView r107 = r106.f323783c;
        if (r107 == null) goto L18;
        View r108 = r107.findViewById(R.id.publish_container);
    L19:
        if (r105 == null) goto L21;
        e1.d(r105, new c(this, r105));
    L21:
        if (r108 == null) goto L23;
        e1.d(r108, new d(this));
    L23:
        Map<String, Integer> r109 = this.f323437f.f323446e;
        ky8.a r110 = (ky8.a) this.f343898d;
        if (r110 == null) goto L26;
        r103 = r110.f506662a;
    L26:
        Integer r111 = r109.get(r103);
        if (r111 == null) goto L29;
        C(Integer.valueOf(r111.intValue()), "bindPublishButton-state");
        return;
    L29:
        C(1, "bindPublishButton-default");
        return;
    L18:
        r108 = null;
    L12:
        r105 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final PublisherCreation B() {
        Map<String, String> r100 = this.f323437f.f323447f;
        ky8.a r101 = (ky8.a) this.f343898d;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f506662a;
    L6:
        String r104 = r100.get(r103);
        ky8.a r105 = (ky8.a) this.f343898d;
        if (r105 == null) goto L11;
        UserCreationFromIM r106 = r105.f506676o;
        if (r106 == null) goto L11;
        Integer r107 = r106.getCreationType();
    L12:
        ky8.a r108 = (ky8.a) this.f343898d;
        if (r108 == null) goto L17;
        UserCreationFromIM r109 = r108.f506676o;
        if (r109 == null) goto L17;
        String r110 = r109.getRefContent();
    L18:
        ky8.a r111 = (ky8.a) this.f343898d;
        if (r111 == null) goto L23;
        UserCreationFromIM r112 = r111.f506676o;
        if (r112 == null) goto L23;
        String r113 = r112.getPrompt();
    L24:
        T r114 = this.f343898d;
        ky8.a r115 = (ky8.a) r114;
        if (r115 == null) goto L27;
        String r116 = r115.f506668g;
    L28:
        ky8.a r117 = (ky8.a) r114;
        if (r117 == null) goto L31;
        Long r118 = r117.f506663b;
    L32:
        ky8.a r119 = (ky8.a) r114;
        if (r119 == null) goto L35;
        Long r120 = r119.f506665d;
    L36:
        ky8.a r121 = (ky8.a) r114;
        if (r121 == null) goto L39;
        String r122 = r121.f506664c;
    L40:
        ky8.a r123 = (ky8.a) r114;
        if (r123 == null) goto L44;
        r102 = r123.f506677p;
    L44:
        return new PublisherCreation(r104, r107, null, r102, r113, r116, r110, null, r122, false, null, r118, r120, Boolean.TRUE, 1668, null);
    L39:
        r122 = null;
        goto L40
    L35:
        r120 = null;
        goto L36
    L31:
        r118 = null;
        goto L32
    L27:
        r116 = null;
    L23:
        r113 = null;
    L17:
        r110 = null;
    L11:
        r107 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.larus.gallery.api.t
    public final void u() {
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L6;
        e0.f365731a.c1(this);
        return;
    }

    @Override // com.larus.gallery.api.t
    public final void v() {
        LarusLayoutCanvasGenerateBottomProviderBinding r100 = this.f323438g;
        if (r100 == null) goto L7;
        CommonDownLoadLayout r101 = r100.f323784d;
        if (r101 == null) goto L7;
        r101.onDestroy();
    L7:
        ValueAnimator r102 = this.f323440i;
        if (r102 == null) goto L10;
        r102.cancel();
    L10:
        this.f323440i = null;
    }

    public i(j r100) {
        Intrinsics.checkNotNullParameter(r100, "galleryContext");
        this.f323437f = r100;
        this.f323439h = CoroutineScopeKt.MainScope();
        this.f323441j = true;
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L6;
        e0.f365731a.e1(this);
        return;
    }

    @Override // zp9.r
    public final void X0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "creationId");
    }

    @Override // zp9.r
    public final void bZ(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
    }

    @Override // com.larus.gallery.api.t
    public final View p(ViewGroup r100) {
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.larus_layout_canvas_generate_bottom_provider, r100, false);
        int r102 = R.id.ai_beautify_layout;
        if (((CommonAiBeautifyLayout) ViewBindings.findChildViewById(r101, R.id.ai_beautify_layout)) == null) goto L42;
        ConstraintLayout r103 = (ConstraintLayout) r101;
        CreationOperateContainerView r104 = (CreationOperateContainerView) ViewBindings.findChildViewById(r101, R.id.creation_view);
        if (r104 == null) goto L40;
        CommonDownLoadLayout r105 = (CommonDownLoadLayout) ViewBindings.findChildViewById(r101, R.id.download_layout);
        if (r105 == null) goto L39;
        this.f323438g = new LarusLayoutCanvasGenerateBottomProviderBinding(r103, r103, r104, r105);
        if (r103 == null) goto L11;
        i0.f375410a.getClass();
        int r106 = i0.e() + i5.h();
        int r107 = r103.getPaddingStart();
        int r108 = r103.getPaddingTop();
        int r109 = r103.getPaddingEnd();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r103.getClass().getSimpleName() + ",source:,start:" + r107 + ",top:" + r108 + ",end:" + r109 + ",bottom:" + r106);
        r103.setPaddingRelative(r107, r108, r109, r106);
    L11:
        LarusLayoutCanvasGenerateBottomProviderBinding r110 = this.f323438g;
        if (r110 == null) goto L14;
        CommonDownLoadLayout r111 = r110.f323784d;
    L15:
        e1.d(r111, new e(this));
        if (this.f323437f.f323448g == false) goto L35;
        LarusLayoutCanvasGenerateBottomProviderBinding r112 = this.f323438g;
        if (r112 == null) goto L26;
        CommonDownLoadLayout r113 = r112.f323784d;
        if (r113 == null) goto L26;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if (r114 == null) goto L25;
        r114.height = i5.g0();
        r113.setLayoutParams(r114);
        goto L26
    L25:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L26:
        LarusLayoutCanvasGenerateBottomProviderBinding r115 = this.f323438g;
        if (r115 == null) goto L35;
        CreationOperateContainerView r116 = r115.f323783c;
        if (r116 == null) goto L35;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L34;
        r117.height = i5.g0();
        r116.setLayoutParams(r117);
        goto L35
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L35:
        LarusLayoutCanvasGenerateBottomProviderBinding r118 = this.f323438g;
        if (r118 != null) goto L38;
        return null;
    L38:
        return r118.f323781a;
    L14:
        r111 = null;
        goto L15
    L39:
        r102 = R.id.download_layout;
        goto L42
    L40:
        r102 = R.id.creation_view;
    L42:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // zp9.r
    public final void yE(UserCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object y(i r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof CanvasBottomProvider$addCreation$1) == false) goto L7;
        CanvasBottomProvider$addCreation$1 r100 = (CanvasBottomProvider$addCreation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        Long r113 = null;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L62:
        return r112;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L38:
        zp9.a r114 = (zp9.a) r112;
        if (r114 != null) goto L41;
    L43:
        r104 = false;
    L44:
        if (r104 == true) goto L49;
        MainCoroutineDispatcher r105 = Dispatchers.getMain();
        CanvasBottomProvider$addCreation$3 r106 = new CanvasBottomProvider$addCreation$3(r110, r114, null);
        r100.label = 3;
        r112 = BuildersKt.withContext(r105, r106, r100);
        if (r112 != r102) goto L62;
        return r102;
    L49:
        t19.s r115 = t19.s.f544207a;
        Context r107 = r110.getContext();
        Context r108 = r110.getContext();
        if (r108 == null) goto L55;
        Resources r109 = r108.getResources();
        if (r109 == null) goto L55;
        String r116 = r109.getString(R.string.larus_ccMob_PreviewPage_toast_madePublic);
        if (r116 == null) goto L55;
    L56:
        r115.getClass();
        t19.s.p(r107, r116);
        ky8.a r117 = (ky8.a) r110.f343898d;
        if (r117 == null) goto L59;
        r113 = r117.f506665d;
    L59:
        m0.a(String.valueOf(r113), null, null, null, null, false, null, null, null, 2046);
        return Unit.INSTANCE;
    L55:
        r116 = "";
        goto L56
    L41:
        if (r114.f573205a != true) goto L43;
    L17:
        int r118 = r100.I$0;
        ResultKt.throwOnFailure(r112);
    L25:
        e0 r119 = e0.f365731a;
        ky8.a r120 = (ky8.a) r110.f343898d;
        if (r120 == null) goto L28;
        Long r121 = r120.f506663b;
    L29:
        if (r120 == null) goto L31;
        Long r122 = r120.f506665d;
    L32:
        if (r120 == null) goto L34;
        String r123 = r120.f506664c;
    L35:
        Integer r124 = Boxing.boxInt(r118);
        r100.label = 2;
        r112 = r119.c(r121, r122, r123, r124, r100);
        if (r112 != r102) goto L38;
        return r102;
    L34:
        r123 = null;
        goto L35
    L31:
        r122 = null;
        goto L32
    L28:
        r121 = null;
        goto L29
    L18:
        ResultKt.throwOnFailure(r112);
        PublisherCreation r125 = r110.B();
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L21;
        new u1();
        u1.a(r125, new PublisherTrackParams("canvas_preview", String.valueOf(r110.f323437f.f323450i.get("recommend_from")), String.valueOf(r110.f323437f.f323450i.get("template_rec_req_id"))));
        return Unit.INSTANCE;
    L21:
        MainCoroutineDispatcher r126 = Dispatchers.getMain();
        CanvasBottomProvider$addCreation$2 r127 = new CanvasBottomProvider$addCreation$2(r110, 3, null);
        r100.I$0 = 1;
        r100.label = 1;
        if (BuildersKt.withContext(r126, r127, r100) == r102) goto L63;
        r118 = 1;
        goto L25
    L63:
        return r102;
    L7:
        r100 = new CanvasBottomProvider$addCreation$1(r110, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(Integer r100, String r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i(this.f343895a, "refreshButtonStatus " + r100 + " from:" + r101);
        if (r100 == null) goto L27;
        r100.intValue();
        int r103 = 0;
        if (com.larus.bmhome.utils.u.h() == true) goto L7;
    L9:
        boolean r104 = false;
    L10:
        r102.i(this.f343895a, "refreshButtonStatus enable " + r104);
        LarusLayoutCanvasGenerateBottomProviderBinding r105 = this.f323438g;
        if (r105 == null) goto L18;
        CreationOperateContainerView r106 = r105.f323783c;
        if (r106 == null) goto L18;
        if (r104 == false) goto L16;
        int r107 = r100.intValue();
    L17:
        r106.r1(r107);
        goto L18
    L16:
        r107 = 0;
    L18:
        ky8.a r108 = (ky8.a) this.f343898d;
        if (r108 == null) goto L28;
        String r109 = r108.f506662a;
        if (r109 == null) goto L29;
        Map<String, Integer> r110 = this.f323437f.f323446e;
        if (r104 == false) goto L25;
        r103 = r100.intValue();
    L25:
        r110.put(r109, Integer.valueOf(r103));
        return;
    L29:
        return;
    L28:
        return;
    L7:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L9;
        r104 = true;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object, ky8.a] */
    @Override // com.larus.gallery.api.t
    public final void w(ky8.a r100, int r101) {
        ky8.a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "data");
        this.f343898d = r102;
        boolean r103 = true;
        if (r101 != this.f323437f.f323442a) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L33;
        if (this.f323441j == false) goto L33;
        this.f323441j = false;
        if (Intrinsics.areEqual(r102.f506662a, PlayerResolution.SDKKEY.ORIGIN) == false) goto L17;
        LarusLayoutCanvasGenerateBottomProviderBinding r105 = this.f323438g;
        if (r105 == null) goto L62;
        ConstraintLayout r106 = r105.f323782b;
        if (r106 == null) goto L63;
        e1.q(r106);
        return;
    L63:
        return;
    L62:
        return;
    L17:
        LarusLayoutCanvasGenerateBottomProviderBinding r107 = this.f323438g;
        if (r107 == null) goto L22;
        ConstraintLayout r108 = r107.f323782b;
        if (r108 == null) goto L22;
        e1.x(r108);
    L22:
        LarusLayoutCanvasGenerateBottomProviderBinding r109 = this.f323438g;
        if (r109 == null) goto L31;
        CommonDownLoadLayout r110 = r109.f323784d;
        if (r110 == null) goto L31;
        CoroutineScope r111 = this.f323439h;
        ky8.a r112 = (ky8.a) this.f343898d;
        if (r112 == null) goto L29;
        String r113 = r112.f506667f;
    L30:
        r110.S5(r111, new com.larus.bmhome.bigimg.download.d.a(String.valueOf(r113)));
        goto L31
    L29:
        r113 = null;
    L31:
        A();
        return;
    L33:
        if (Intrinsics.areEqual(r102.f506662a, PlayerResolution.SDKKEY.ORIGIN) == false) goto L47;
        LarusLayoutCanvasGenerateBottomProviderBinding r114 = this.f323438g;
        if (r114 == null) goto L44;
        ConstraintLayout r115 = r114.f323782b;
        if (r115 == null) goto L44;
        if (r115.getVisibility() != 0) goto L41;
        boolean r116 = true;
    L42:
        if (r116 != true) goto L44;
    L45:
        if (r103 == false) goto L66;
        ValueAnimator r117 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r117.setDuration(this.f323437f.f323444c);
        r117.addUpdateListener(new a(this));
        r117.addListener(new g(this));
        this.f323440i = r117;
        r117.start();
        return;
    L66:
        return;
    L41:
        r116 = false;
    L44:
        r103 = false;
        goto L45
    L47:
        LarusLayoutCanvasGenerateBottomProviderBinding r118 = this.f323438g;
        if (r118 == null) goto L57;
        ConstraintLayout r119 = r118.f323782b;
        if (r119 == null) goto L57;
        if (r119.getVisibility() != 0) goto L54;
        boolean r120 = true;
    L55:
        if (r120 == true) goto L57;
    L58:
        if (r103 == false) goto L60;
        ValueAnimator r121 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r121.setDuration(this.f323437f.f323444c);
        r121.addUpdateListener(new b(this));
        r121.addListener(new h(this));
        this.f323440i = r121;
        r121.start();
        return;
    L60:
        A();
        return;
    L54:
        r120 = false;
    L57:
        r103 = false;
        goto L58
    L5:
        r104 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object z(i r310, boolean r311, Continuation r312) {
        r310.getClass();
        if ((r312 instanceof CanvasBottomProvider$setCreationPrivacy$1) == false) goto L7;
        CanvasBottomProvider$setCreationPrivacy$1 r100 = (CanvasBottomProvider$setCreationPrivacy$1) r312;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "";
        String r110 = null;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        ResultKt.throwOnFailure(r102);
    L145:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r106 = r100.I$1;
        int r107 = r100.I$0;
        String r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L117:
        Pair r108 = (Pair) r102;
        if (r108 == null) goto L120;
        Boolean r109 = (Boolean) r108.getFirst();
    L122:
        if (Intrinsics.areEqual(r109, Boxing.boxBoolean(true)) == true) goto L126;
        MainCoroutineDispatcher r112 = Dispatchers.getMain();
        CanvasBottomProvider$setCreationPrivacy$3 r113 = new CanvasBottomProvider$setCreationPrivacy$3(r310, r107, null);
        r100.L$0 = null;
        r100.label = 3;
        if (BuildersKt.withContext(r112, r113, r100) != r103) goto L145;
        return r103;
    L126:
        if (r106 != 2) goto L132;
        Context r114 = r310.getContext();
        if (r114 == null) goto L137;
        Resources r115 = r114.getResources();
        if (r115 == null) goto L137;
        r110 = r115.getString(R.string.larus_ccMob_PreviewPage_toast_madePrivate);
    L137:
        t19.s r116 = t19.s.f544207a;
        Context r117 = r310.getContext();
        if (r110 == null) goto L141;
        r105 = r110;
    L141:
        r116.getClass();
        t19.s.p(r117, r105);
        if (r106 != 2) goto L145;
        e0.f365731a.X0(r111);
        goto L145
    L132:
        Context r118 = r310.getContext();
        if (r118 == null) goto L137;
        Resources r119 = r118.getResources();
        if (r119 == null) goto L137;
        r110 = r119.getString(R.string.larus_ccMob_PreviewPage_toast_madePublic);
        goto L137
    L120:
        r109 = null;
        goto L122
    L17:
        r106 = r100.I$1;
        r107 = r100.I$0;
        boolean r120 = r100.Z$0;
        ResultKt.throwOnFailure(r102);
    L36:
        Map<String, String> r121 = r310.f323437f.f323447f;
        ky8.a r122 = (ky8.a) r310.f343898d;
        if (r122 == null) goto L39;
        String r123 = r122.f506662a;
    L40:
        String r124 = r121.get(r123);
        if (r124 == null) goto L150;
        ky8.a r125 = (ky8.a) r310.f343898d;
        if (r125 == null) goto L48;
        UserCreationFromIM r126 = r125.f506676o;
        if (r126 == null) goto L48;
        String r127 = r126.getCreationId();
    L49:
        ky8.a r128 = (ky8.a) r310.f343898d;
        if (r128 == null) goto L52;
        String r129 = r128.f506664c;
    L53:
        String r130 = String.valueOf(r129);
        String r131 = String.valueOf(r310.f323437f.f323450i.get("current_page"));
        if (r120 == false) goto L56;
        String r210 = "1";
    L57:
        ky8.a r132 = (ky8.a) r310.f343898d;
        if (r132 == null) goto L60;
        String r211 = r132.f506666e;
    L61:
        if (r120 == false) goto L63;
        String r212 = "0";
    L64:
        if (r132 == null) goto L84;
        UserCreationFromIM r133 = r132.f506676o;
        if (r133 == null) goto L146;
        Integer r134 = r133.getCreationType();
        if (r134 != null) goto L70;
        String r213 = "";
    L85:
        ky8.a r135 = (ky8.a) r310.f343898d;
        if (r135 == null) goto L90;
        UserCreationFromIM r136 = r135.f506676o;
        if (r136 == null) goto L90;
        Integer r137 = r136.getCreationType();
    L91:
        if (r137 != null) goto L94;
    L95:
        if (r137 != null) goto L98;
    L100:
        if (r137 != null) goto L103;
    L105:
        String r138 = "replica";
    L107:
        String r214 = r138;
        ky8.a r139 = (ky8.a) r310.f343898d;
        if (r139 == null) goto L112;
        UserCreationFromIM r140 = r139.f506676o;
        if (r140 == null) goto L112;
        String r215 = r140.getCreationId();
    L113:
        e2.a.b(new o0(r131, null, r127, r130, r211, r214, r210, r212, String.valueOf(r310.f323437f.f323450i.get("recommend_from")), r215, String.valueOf(r310.f323437f.f323450i.get("template_rec_req_id")), null, null, r213, null, Boxing.boxInt(0), null, null, 438277), null, 3);
        e0 r141 = e0.f365731a;
        r100.L$0 = r124;
        r100.I$0 = r107;
        r100.I$1 = r106;
        r100.label = 2;
        Object r142 = r141.h(r124, r106, r100);
        if (r142 == r103) goto L152;
        r111 = r124;
        r102 = r142;
        goto L117
    L152:
        return r103;
    L112:
        r215 = null;
        goto L113
    L103:
        if (r137.intValue() != 4) goto L105;
        r138 = "image_edit";
        goto L107
    L98:
        if (r137.intValue() != 5) goto L100;
    L106:
        r138 = "pic";
        goto L107
    L94:
        if (r137.intValue() == 2) goto L106;
    L90:
        r137 = null;
        goto L91
    L70:
        switch(r134.intValue()) {
            case 1: goto L82;
            case 2: goto L81;
            case 3: goto L80;
            case 4: goto L79;
            case 5: goto L79;
            case 6: goto L78;
            case 7: goto L77;
            case 8: goto L76;
            case 9: goto L75;
            case 10: goto L74;
            case 11: goto L73;
            case 12: goto L72;
            default: goto L148;
        };
    L72:
        String r143 = "refaudio2video";
    L83:
        r213 = r143;
        goto L85
    L73:
        r143 = "videoimagedmixed2video";
        goto L83
    L74:
        r143 = "avatar2video";
        goto L83
    L75:
        r143 = "image2video_extend";
        goto L83
    L76:
        r143 = "text2video_extend";
        goto L83
    L77:
        r143 = "image2video";
        goto L83
    L78:
        r143 = "text2video";
        goto L83
    L79:
        r143 = CreativeScene.IMAGE_TO_IMAGE;
        goto L83
    L80:
        r143 = "avatar2image";
        goto L83
    L81:
        r143 = "text2image";
        goto L83
    L82:
        r143 = "text2music";
        goto L83
    L148:
        r213 = "";
        goto L85
    L146:
        r213 = "";
        goto L85
    L84:
        r213 = "";
        goto L85
    L63:
        r212 = "1";
        goto L64
    L60:
        r211 = null;
        goto L61
    L56:
        r210 = "0";
        goto L57
    L52:
        r129 = null;
    L48:
        r127 = null;
        goto L49
    L150:
        return Unit.INSTANCE;
    L39:
        r123 = null;
        goto L40
    L18:
        ResultKt.throwOnFailure(r102);
        if (r311 == false) goto L21;
    L23:
        if (r311 == false) goto L25;
        int r144 = 3;
    L26:
        if (r311 == false) goto L28;
        int r145 = 2;
    L29:
        if (r311 == false) goto L31;
        int r146 = 2;
    L32:
        MainCoroutineDispatcher r147 = Dispatchers.getMain();
        CanvasBottomProvider$setCreationPrivacy$2 r148 = new CanvasBottomProvider$setCreationPrivacy$2(r310, r146, null);
        r100.Z$0 = r311;
        r100.I$0 = r144;
        r100.I$1 = r145;
        r100.label = 1;
        if (BuildersKt.withContext(r147, r148, r100) == r103) goto L151;
        r120 = r311;
        r106 = r145;
        r107 = r144;
        goto L36
    L151:
        return r103;
    L31:
        r146 = 3;
        goto L32
    L28:
        r145 = 1;
        goto L29
    L25:
        r144 = 2;
        goto L26
    L21:
        if (z2.f365865a.getCreationPublishConfig().b() == false) goto L23;
        new u1();
        u1.a(r310.B(), new PublisherTrackParams("picture_detail", String.valueOf(r310.f323437f.f323450i.get("recommend_from")), String.valueOf(r310.f323437f.f323450i.get("template_rec_req_id"))));
        return Unit.INSTANCE;
    L7:
        r100 = new CanvasBottomProvider$setCreationPrivacy$1(r310, r312);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zp9.r
    public final void i20(UserCreation r100, long r101, long r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "userCreation");
        Intrinsics.checkNotNullParameter(r111, DBDefinition.TASK_ID);
        zp9.r.a.a(r100, r111);
        ky8.a r102 = (ky8.a) this.f343898d;
        String r103 = null;
        if (r102 == null) goto L5;
        Long r104 = r102.f506663b;
    L6:
        if (r102 == null) goto L8;
        Long r105 = r102.f506665d;
    L9:
        if (r102 == null) goto L11;
        r103 = r102.f506664c;
    L11:
        if (r104 != null) goto L14;
        return;
    L14:
        if (r104.longValue() != r101) goto L37;
        if (r105 != null) goto L18;
        return;
    L18:
        if (r105.longValue() == r110) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r103, r111) == false) goto L39;
        ky8.a r106 = (ky8.a) this.f343898d;
        if (r106 == null) goto L33;
        String r107 = r106.f506662a;
        if (r107 == null) goto L33;
        this.f323437f.f323446e.put(r107, 3);
        C(3, "onPublishSuccess");
        Fragment r108 = this.f323437f.f323449h;
        if (r108 == null) goto L30;
        FragmentActivity r109 = r108.getActivity();
        if (r109 == null) goto L30;
        IUgcAIGCService.Companion r112 = IUgcAIGCService.f373945a;
        r112.y();
        r112.J(r100, r109, new View(getContext()), r109, true);
    L30:
        String r113 = r100.f364987a;
        if (r113 == null) goto L33;
        this.f323437f.f323447f.put(r107, r113);
    L33:
        com.larus.gallery.api.w r114 = this.f343899e;
        if (r114 == null) goto L40;
        r114.Rf(com.larus.gallery.api.p.c.f343878a);
        return;
    L40:
        return;
    L39:
        return;
    L37:
        return;
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = null;
        goto L6
    }
}
