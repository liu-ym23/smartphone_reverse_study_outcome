package com.larus.bot.impl.feature.edit.feature.avatar;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.FlowLiveDataConversions;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.bean.BotEditParam;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BgImage;
import com.larus.image.loader.b0;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class BotAvatarEditViewModel implements v, t, s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f318463h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f318464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f318465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f318466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b1 f318467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableSharedFlow<b> f318468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a1 f318469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BotImageUploadViewModel f318470g;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final BotEditParam a() {
        return this.f318464a.a();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void b(boolean r100) {
        this.f318464a.b(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void c(boolean r100) {
        this.f318464a.c(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final int getScene() {
        return this.f318464a.getScene();
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void h(String r100) {
        this.f318464a.h(r100);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "uri");
        this.f318464a.k(r100, r101);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.s
    public final void m(String r100) {
        this.f318464a.m(r100);
    }

    @Override // uu8.b
    public final d1<b> getUiEvent() {
        return this.f318469f;
    }

    @Override // uu8.b
    public final i1<c> getUiState() {
        return this.f318467d;
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void d(boolean r100) {
        FLogger.f375446a.i("BotAvatarViewModel", "refreshAvatarLoading, isGenerating: " + r100);
        q(this, null, false, r100, 3);
    }

    @Override // uu8.b
    public final void dispatchUIAction(com.larus.bot.impl.feature.edit.feature.avatar.a r110) {
        com.larus.bot.impl.feature.edit.feature.avatar.a r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "uiAction");
        boolean r100 = true;
        String r101 = null;
        Uri r102 = null;
        if ((r111 instanceof com.larus.bot.impl.feature.edit.feature.avatar.a.b) == false) goto L28;
        ActivityResult r112 = ((com.larus.bot.impl.feature.edit.feature.avatar.a.b) r111).f318472a;
        if (r112.getResultCode() != (-1)) goto L13;
        Intent r113 = r112.getData();
        if (r113 == null) goto L81;
        Uri r114 = (Uri) r113.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        if (r114 == null) goto L11;
        b(true);
        qu8.b.e("file_handle_upload_avatar", "bot_create/avatar/manual", false);
        this.f318470g.upload(r114, 6, Intrinsics.areEqual(r114.getScheme(), "file"));
        return;
    L11:
        r(new b.d(new TextRes.StringResId(R.string.larus_bot_upload_profile_pic_failed)));
        qu8.b.d("bot_create/avatar/manual", -2);
        qu8.b.d("bot_create/avatar_setting", 1002);
        return;
    L81:
        return;
    L13:
        if (r112.getResultCode() != 96) goto L84;
        Intent r115 = r112.getData();
        if (r115 == null) goto L85;
        Throwable r116 = (Throwable) r115.getSerializableExtra("com.yalantis.ucrop.Error");
        FLogger.f375446a.e("BotAvatarViewModel", "onActivityResult: called, cropError = " + r116);
        if (r116 == null) goto L23;
        String r117 = r116.getMessage();
        if (r117 == null) goto L23;
        if (StringsKt.contains$default(r117, "Failed to recognize format", false, 2, null) != true) goto L23;
    L24:
        if (r100 == false) goto L26;
        r(new b.d(new TextRes.StringResId(R.string.larus_unsupported_format)));
        qu8.b.d("bot_create/avatar_setting", 1002);
        qu8.b.d("bot_create/avatar/manual", 10023);
        return;
    L26:
        r(new b.d(new TextRes.StringResId(R.string.larus_bot_upload_profile_pic_failed)));
        qu8.b.d("bot_create/avatar_setting", 1002);
        qu8.b.d("bot_create/avatar/manual", -2);
        return;
    L23:
        r100 = false;
        goto L24
    L85:
        return;
    L84:
        return;
    L28:
        if ((r111 instanceof com.larus.bot.impl.feature.edit.feature.avatar.a.f) == false) goto L31;
        com.larus.bot.impl.feature.edit.feature.avatar.a.f r118 = (com.larus.bot.impl.feature.edit.feature.avatar.a.f) r111;
        c(true);
        return;
    L31:
        if ((r111 instanceof com.larus.bot.impl.feature.edit.feature.avatar.a.c) == false) goto L47;
        BotAvatarIconData r119 = ((com.larus.bot.impl.feature.edit.feature.avatar.a.c) r111).f318473a;
        if (r119 != null) goto L36;
        return;
    L36:
        if (o0.d(r119.getIconUrl()) == false) goto L38;
        r102 = b0.a(r119.getIconUrl(), "bot_create.avatar_upload", false, false, 6);
    L38:
        q(this, r102, true, false, 4);
        String r103 = r119.getIconUrl();
        String r104 = "";
        if (r103 != null) goto L41;
        r103 = "";
    L41:
        String r105 = r119.getIconUri();
        if (r105 == null) goto L45;
        r104 = r105;
    L45:
        k(r103, r104);
        h(r119.getPrompt());
        c(false);
        qu8.b.c(0, new String[]{"bot_create/avatar/ai", "bot_create/avatar_setting"});
        return;
    L47:
        if (Intrinsics.areEqual(r111, com.larus.bot.impl.feature.edit.feature.avatar.a.d.f318474a) == false) goto L53;
        if (z2.f365865a.createBotAutoFillEnable() == false) goto L51;
        r(new b.c(a().getAvatarPrompt(), DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON));
        return;
    L51:
        r(new b.C4125b(DoraObricDeviceHomeViewModel.ENTER_METHOD_CLICK_BUTTON));
        return;
    L53:
        if (Intrinsics.areEqual(r111, com.larus.bot.impl.feature.edit.feature.avatar.a.e.f318475a) == false) goto L72;
        if (((c) this.f318467d.getValue()).f318520c == true) goto L68;
        Uri r120 = ((c) this.f318467d.getValue()).f318518a;
        if (r120 == null) goto L59;
        r101 = r120.toString();
    L59:
        if (r101 != null) goto L61;
    L64:
        if (r100 == true) goto L68;
        r(new b.a(String.valueOf(((c) this.f318467d.getValue()).f318518a), a().getAvatarPrompt()));
        return;
    L61:
        if (StringsKt.isBlank(r101) == true) goto L64;
        r100 = false;
    L68:
        if (z2.f365865a.createBotAutoFillEnable() == false) goto L70;
        r(new b.c(a().getAvatarPrompt(), "click_empty_head"));
        return;
    L70:
        r(new b.C4125b("click_empty_head"));
        return;
    L72:
        if (Intrinsics.areEqual(r111, com.larus.bot.impl.feature.edit.feature.avatar.a.C4124a.f318471a) == false) goto L80;
        if (getScene() == 1) goto L76;
        return;
    L76:
        if ((!StringsKt.isBlank(a().getIconUrl())) == false) goto L96;
        Uri r121 = UriProtector.parse(a().getIconUrl());
        StateFlowImpl r106 = this.f318466c;
        ((c) this.f318467d.getValue()).getClass();
        r106.setValue(new c(r121, true, false));
        return;
    L96:
        return;
    L80:
        throw new NoWhenBranchMatchedException();
    }

    public final void r(b r100) {
        BuildersKt.launch$default(this.f318465b, null, null, new BotAvatarEditViewModel$sendUIEvent$1(this, r100, null), 3, null);
    }

    @Override // com.larus.bot.impl.feature.edit.feature.avatar.t
    public final void o(String r100, BgImage r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (o0.d(r100) == false) goto L6;
        Uri r102 = b0.a(r100, "bot_create.avatar_upload", false, false, 6);
    L7:
        q(this, r102, false, false, 6);
        return;
    L6:
        r102 = null;
        goto L7
    }

    public BotAvatarEditViewModel(Application r100, CoroutineScope r101, s r102) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "dependency");
        this.f318464a = r102;
        this.f318465b = r101;
        boolean r103 = true;
        if (getScene() == 1) goto L5;
    L7:
        Uri r104 = null;
    L9:
        if (getScene() == 1) goto L12;
        r103 = false;
    L12:
        StateFlowImpl r105 = j1.a(new c(r104, r103, false));
        this.f318466c = r105;
        this.f318467d = kotlinx.coroutines.flow.e.b(r105);
        MutableSharedFlow<b> r106 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f318468e = r106;
        this.f318469f = kotlinx.coroutines.flow.e.a(r106);
        BotImageUploadViewModel r107 = new BotImageUploadViewModel(r100);
        this.f318470g = r107;
        kotlinx.coroutines.flow.e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(FlowLiveDataConversions.asFlow(r107.getUpload().f360128c), new BotAvatarEditViewModel$bindObservers$1(this, null)), r101);
        return;
    L5:
        if (o0.d(a().getIconUrl()) == false) goto L7;
        r104 = b0.a(a().getIconUrl(), "bot_update.avatar_default", false, false, 6);
        goto L9
    }

    public static void q(BotAvatarEditViewModel r100, Uri r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = ((c) r100.f318467d.getValue()).f318518a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = ((c) r100.f318467d.getValue()).f318519b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = ((c) r100.f318467d.getValue()).f318520c;
    L11:
        StateFlowImpl r105 = r100.f318466c;
        ((c) r100.f318467d.getValue()).getClass();
        r105.setValue(new c(r101, r102, r103));
    }
}
