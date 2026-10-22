package com.larus.bmhome.instruction.handler;

import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.bean.SuggestActionType;
import com.larus.bmhome.instruction.helper.AiBeautifyPickPhotoHelper;
import com.larus.im.bean.bot.BotModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class w extends i {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.bmhome.instruction.p f312132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AiBeautifyPickPhotoHelper f312133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final z0 f312134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.bmhome.instruction.n f312135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f312136n;

    public final String f() {
        com.larus.bmhome.instruction.n r100 = this.f312135m;
        if (r100 == null) goto L8;
        aq8.e r101 = r100.f312184b;
        if (r101 == null) goto L8;
        String r102 = r101.f15940a;
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "";
    }

    @Override // com.larus.bmhome.instruction.handler.m
    public final void a(com.larus.bmhome.instruction.n r310) {
        Intrinsics.checkNotNullParameter(r310, "inputData");
        this.f312135m = r310;
        String r100 = "";
        if (this.f312134l == null) goto L30;
        AiBeautifyPickPhotoHelper r101 = this.f312133k;
        if (r101 == null) goto L7;
        com.larus.bmhome.instruction.helper.f.a.a(r101, d().requireActivity(), 6);
    L7:
        ChatParam r102 = (ChatParam) e().a(ChatParam.class);
        String r103 = null;
        if (r102 != null) goto L19;
        com.larus.bmhome.chat.component.cvs.y r104 = b();
        if (r104 == null) goto L14;
        BotModel r105 = r104.j0();
        if (r105 == null) goto L14;
        String r106 = r105.getBotId();
    L15:
        if (r106 != null) goto L17;
        String r107 = "";
    L18:
        r102 = new ChatParam(null, r107, null, null, null, 253);
        goto L19
    L17:
        r107 = r106;
    L14:
        r106 = null;
    L19:
        String r108 = r102.f296890b;
        String r109 = r102.f296893e;
        aq8.e r110 = r310.f312184b;
        if (r110 == null) goto L22;
        String r111 = r110.f15946g;
    L23:
        if (r110 == null) goto L25;
        String r112 = r110.f15946g;
    L26:
        String r113 = String.valueOf(this.f312136n);
        com.larus.bmhome.actionbar.model.r r114 = this.f312134l.f295621q;
        if (r114 == null) goto L29;
        r103 = r114.f295414g;
    L29:
        tx9.c0.H(r108, r111, r112, null, r109, "chat", null, r113, r103, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 33553992);
        return;
    L25:
        r112 = null;
        goto L26
    L22:
        r111 = null;
        goto L23
    L30:
        eq8.a r115 = new eq8.a();
        aq8.e r116 = r310.f312184b;
        if (r116 == null) goto L37;
        String r117 = r116.f15946g;
        if (r117 == null) goto L37;
        r100 = r117;
    L37:
        if (r310.f312185c == false) goto L39;
        String r118 = "IMAGE_TO_IMAGE";
    L40:
        r115.d(r100, r118, f());
        eq8.a.b(r115, "get actionBarItem null", "instructionType:" + this.f312136n);
        return;
    L39:
        r118 = SuggestActionType.ALBUM_IMAGE;
        goto L40
    }

    public w(com.larus.bmhome.instruction.p r100, AiBeautifyPickPhotoHelper r101) {
        Intrinsics.checkNotNullParameter(r100, "instructionCoreAbility");
        super(r100);
        this.f312132j = r100;
        this.f312133k = r101;
        this.f312136n = 4;
        if (r101 == null) goto L5;
        r101.f312144b = new t(this);
    L5:
        this.f312134l = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).e(4);
    }
}
