package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.api.service.ITranslateService;
import com.ss.android.lark.chat.service.impl.EditMessageService;
import com.ss.android.lark.chat.service.impl.MessageTenantConfService;
import com.ss.android.lark.chat.utils.x0;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.tab.service.IChatTabService;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class ChatAppContainerV2 implements v, m2b.b {
    public final com.ss.android.lark.translate.service.impl.a A;
    public final m6b.q B;
    public final a2b.c C;
    public final com.ss.android.lark.audio.voiceinput.service.o D;
    public final m6b.a E;
    public final com.ss.android.lark.audio.voiceinput.service.l F;
    public final com.ss.android.lark.tab.service.m G;
    public final com.ss.android.lark.tab.service.i H;
    public final a2b.n I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d f414514J;
    public final a2b.i K;
    public final a2b.l L;
    public final z M;
    public final com.ss.android.lark.chat.core.api.d N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b38.b f414516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final KVRepo f414517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w4b.c.o f414518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IChatService f414519e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IAudioService f414520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.o0 f414521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m6b.m f414522h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m6b.g f414523i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final jdb.g f414524j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.ss.android.lark.chat.cot.a f414525k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a2b.f f414526l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ITranslateService f414527m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b f414528n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a2b.h f414529o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a2b.k f414530p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MessageTenantConfService f414531q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final m6b.n f414532r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final EditMessageService f414533s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m6b.d f414534t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final x0 f414535u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final IChatTabService f414536v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.ss.android.lark.tab.service.l f414537w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final a2b.o f414538x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a2b.j f414539y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final m6b.t f414540z;

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final x H() {
        return new ChatAppContainerV2$dataPreloadContainer$1(this);
    }

    @Override // m2b.b
    public final <T extends x1b.b> T get() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV2.get");
        return this;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final ImSdkChatService B() {
        return ImSdkService.b();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.u L() {
        return ImSdkService.e();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.im.sdk.service.h T() {
        return ImSdkService.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.im.sdk.service.p w() {
        return ImSdkService.f();
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.translate.service.impl.a A() {
        return this.A;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final jdb.g C() {
        return this.f414524j;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.g D() {
        return this.f414523i;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.o E() {
        return this.f414538x;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.n F() {
        return this.I;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.j G() {
        return this.f414539y;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.l J() {
        return this.L;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.biz.im.api.o0 K() {
        return this.f414521g;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final w4b.c.o M() {
        return this.f414518d;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.q N() {
        return this.B;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b O() {
        return this.f414528n;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.f P() {
        return this.f414526l;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final x0 Q() {
        return this.f414535u;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final EditMessageService S() {
        return this.f414533s;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.d V() {
        return this.f414534t;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.m W() {
        return this.f414522h;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final z Z() {
        return this.M;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.t c0() {
        return this.f414540z;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final m6b.j f0() {
        return this.f414531q;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final String getUserId() {
        return this.f414515a;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final IChatService j0() {
        return this.f414519e;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.cot.a o0() {
        return this.f414525k;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final com.ss.android.lark.chat.core.api.d p0() {
        return this.N;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final IAudioService v() {
        return this.f414520f;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final ITranslateService x() {
        return this.f414527m;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final b38.b y() {
        return this.f414516b;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.v
    public final a2b.c z() {
        return this.C;
    }

    @Inject
    public ChatAppContainerV2(String r110, b38.b r111, KVRepo r112, w4b.c.o r210, IChatService r211, IAudioService r212, com.ss.android.lark.biz.im.api.o0 r213, m6b.m r214, m6b.g r215, jdb.g r216, com.ss.android.lark.chat.cot.a r217, a2b.f r218, ITranslateService r219, com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.fields.b r310, a2b.h r311, a2b.k r312, MessageTenantConfService r313, m6b.n r314, EditMessageService r315, m6b.d r316, x0 r317, IChatTabService r318, com.ss.android.lark.tab.service.l r319, a2b.o r410, a2b.j r411, m6b.t r412, com.ss.android.lark.translate.service.impl.a r413, m6b.q r414, a2b.c r415, com.ss.android.lark.audio.voiceinput.service.o r416, m6b.a r417, com.ss.android.lark.audio.voiceinput.service.l r418, com.ss.android.lark.tab.service.m r419, com.ss.android.lark.tab.service.i r510, a2b.n r511, com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r512, a2b.i r513, a2b.l r514, z r515, com.ss.android.lark.chat.core.api.d r516) {
        Intrinsics.checkNotNullParameter(r111, "rucket");
        Intrinsics.checkNotNullParameter(r112, "imUserKVRepo");
        Intrinsics.checkNotNullParameter(r210, "passportDependency");
        Intrinsics.checkNotNullParameter(r211, "legacyChatService");
        Intrinsics.checkNotNullParameter(r212, "audioService");
        Intrinsics.checkNotNullParameter(r213, "threadService");
        Intrinsics.checkNotNullParameter(r214, "quoteService");
        Intrinsics.checkNotNullParameter(r215, "draftService");
        Intrinsics.checkNotNullParameter(r216, "fgService");
        Intrinsics.checkNotNullParameter(r217, "cotFeatureGate");
        Intrinsics.checkNotNullParameter(r218, "previewService");
        Intrinsics.checkNotNullParameter(r219, "translateService");
        Intrinsics.checkNotNullParameter(r310, "userFieldsService");
        Intrinsics.checkNotNullParameter(r311, "privateDescriptionService");
        Intrinsics.checkNotNullParameter(r312, "storePrivateDescriptionHandlerFactory");
        Intrinsics.checkNotNullParameter(r313, "messageTenantConfService");
        Intrinsics.checkNotNullParameter(r314, "previewVideoService");
        Intrinsics.checkNotNullParameter(r315, "editMessageService");
        Intrinsics.checkNotNullParameter(r316, "chatSubscribeService");
        Intrinsics.checkNotNullParameter(r317, "pushChatRelationListenerManager");
        Intrinsics.checkNotNullParameter(r318, "chatTabService");
        Intrinsics.checkNotNullParameter(r319, "chatTabExtraService");
        Intrinsics.checkNotNullParameter(r410, "userGroupService");
        Intrinsics.checkNotNullParameter(r411, "aiSmartApplyAnswerService");
        Intrinsics.checkNotNullParameter(r412, "chatterPush");
        Intrinsics.checkNotNullParameter(r413, "translatePush");
        Intrinsics.checkNotNullParameter(r414, "threadPush");
        Intrinsics.checkNotNullParameter(r415, "previewPush");
        Intrinsics.checkNotNullParameter(r416, "speechPush");
        Intrinsics.checkNotNullParameter(r417, "audioTextPush");
        Intrinsics.checkNotNullParameter(r418, "newAudioTextPush");
        Intrinsics.checkNotNullParameter(r419, "chatTabPush");
        Intrinsics.checkNotNullParameter(r510, "chatTabExtraPush");
        Intrinsics.checkNotNullParameter(r511, "userGroupPush");
        Intrinsics.checkNotNullParameter(r512, "dataPreloaderManager");
        Intrinsics.checkNotNullParameter(r513, "secretChatDataCorruptPush");
        Intrinsics.checkNotNullParameter(r514, "strangerActionUploader");
        Intrinsics.checkNotNullParameter(r515, "unreadAIDataCache");
        Intrinsics.checkNotNullParameter(r516, "mentionBotsNotInChatCoordinator");
        this.f414515a = r110;
        this.f414516b = r111;
        this.f414517c = r112;
        this.f414518d = r210;
        this.f414519e = r211;
        this.f414520f = r212;
        this.f414521g = r213;
        this.f414522h = r214;
        this.f414523i = r215;
        this.f414524j = r216;
        this.f414525k = r217;
        this.f414526l = r218;
        this.f414527m = r219;
        this.f414528n = r310;
        this.f414529o = r311;
        this.f414530p = r312;
        this.f414531q = r313;
        this.f414532r = r314;
        this.f414533s = r315;
        this.f414534t = r316;
        this.f414535u = r317;
        this.f414536v = r318;
        this.f414537w = r319;
        this.f414538x = r410;
        this.f414539y = r411;
        this.f414540z = r412;
        this.A = r413;
        this.B = r414;
        this.C = r415;
        this.D = r416;
        this.E = r417;
        this.F = r418;
        this.G = r419;
        this.H = r510;
        this.I = r511;
        this.f414514J = r512;
        this.K = r513;
        this.L = r514;
        this.M = r515;
        this.N = r516;
    }
}
