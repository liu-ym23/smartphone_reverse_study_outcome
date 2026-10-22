package com.ss.android.lark.im.sdk.usercontainer;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.customized.externalcontact.repository.NewFriendBadgeRepository$getBadge$1;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactViewModel;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends c0c.b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f426199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f426200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<h> f426201d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> A2(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterIds");
        return this.f426199b.A2(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void E9(String r100, List<String> r101, IGetDataCallback<Map<String, ChatChatter>> r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "chatterIds");
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f426199b.E9(r100, r101, r102);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void F5(Chatter r100) {
        this.f426199b.F5(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter H5(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        return this.f426199b.H5(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter He(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        return this.f426199b.He(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map I3(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterIds");
        return this.f426199b.I3(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void L2(NewFriendBadgeRepository$getBadge$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f426199b.L2(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void N7(String r100, IGetDataCallback<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "contactUserId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426199b.N7(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void W8(OfficeExternalContactViewModel.AnonymousClass1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f426199b.W8(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> a0(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        return this.f426199b.a0(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void j1(String r100, IGetDataCallback<Chatter> r101) {
        Intrinsics.checkNotNullParameter(r100, "avatarKey");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426199b.j1(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, Chatter> l0(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        return this.f426199b.l0(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter l7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        return this.f426199b.l7(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Map<String, ChatChatter> ld(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "chatterIds");
        return this.f426199b.ld(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void pd(String r100, IGetDataCallback<Chatter> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426199b.pd(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Pair<ChatChatter, OpenApp> qb(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "botId");
        return this.f426199b.qb(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter ue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        return this.f426199b.ue(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final void v3(List<String> r100, IGetDataCallback<Map<String, Chatter>> r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f426199b.v3(r100, r101);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final ChatChatter x1(String r100) {
        return this.f426199b.x1(r100);
    }

    @Override // com.ss.android.lark.im.sdk.service.h
    public final Chatter zb() {
        return this.f426199b.zb();
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), h.class), h.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f426199b = r103.b();
        this.f426200c = r101;
        this.f426201d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("ImSdkChatterServiceProxy", "preparing");
        v r102 = this.f426200c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        h r104 = (h) k.b(r102.c(r103), h.class);
        this.f426201d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
