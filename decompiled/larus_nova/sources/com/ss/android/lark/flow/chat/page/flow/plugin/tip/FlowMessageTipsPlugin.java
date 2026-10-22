package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard;
import com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.base.IKeyboardComponent;
import com.ss.android.lark.chat.chatwindow.biz.component.titlebar.ITitlebarComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowMessageTipsPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wgb.e f422861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public wgb.e f422862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Chat f422863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wgb.b<y6b.c<?>> f422864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f422865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f422866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larksuite.framework.callback.c f422867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IMessageListComponent f422868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IKeyboardComponent f422869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IBannerComponent f422870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ITitlebarComponent f422871q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f422872r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f422873s;

    public static final class a {
    }

    public static final class b implements IMessageListComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMessageTipsPlugin f422874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c f422875b;

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final /* synthetic */ void A9() {
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void B9(ChatChatter r100) {
            Intrinsics.checkNotNullParameter(r100, "chatChatter");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void e(BasePageStore r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void w9(ThreadTopic r100) {
            Intrinsics.checkNotNullParameter(r100, "threadTopic");
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final /* synthetic */ void x9() {
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void y9() {
            final FlowMessageTipsPlugin r100 = this.f422874a;
            IMessageListComponent r101 = r100.f422868n;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r102 = this.f422875b;
            wgb.b<y6b.c<?>> r103 = r100.f422864j;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.d() != true) goto L7;
        L9:
            if (r104 == false) goto L11;
            Log.e("FlowMessageTipsPlugin", "message tip is valid when init");
            return;
        L11:
            i r105 = new i(new j(r100), new k(r100), new l(r100));
            if (r101 == null) goto L54;
            RelativeLayout r106 = r101.UI();
            Log.i("FlowMessageTipsPlugin", "init message tips view");
            Chat r107 = null;
            if (r106 == null) goto L35;
            Context r108 = r106.getContext();
            if (r108 == null) goto L19;
            dwa.j r109 = dwa.j.d(r108);
            String r110 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r109.getClass();
            dwa.b.c(r110);
        L19:
            r100.f422861g = new wgb.e(r106.getContext());
            RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(-2, -2);
            r111.addRule(14);
            r111.addRule(10);
            wgb.e r112 = r100.f422861g;
            if (r112 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r112 = null;
        L22:
            r106.addView(r112, r111);
            wgb.e r113 = r100.f422861g;
            if (r113 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r113 = null;
        L25:
            r113.setVisibility(8);
            Context r114 = r106.getContext();
            if (r114 == null) goto L28;
            dwa.j r115 = dwa.j.d(r114);
            String r116 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r115.getClass();
            dwa.b.c(r116);
        L28:
            r100.f422862h = new wgb.e(r106.getContext());
            RelativeLayout.LayoutParams r117 = new RelativeLayout.LayoutParams(-2, -2);
            r117.addRule(14);
            r117.addRule(8, R.id.chat_ptr_layout);
            wgb.e r118 = r100.f422862h;
            if (r118 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r118 = null;
        L31:
            r106.addView(r118, r117);
            wgb.e r119 = r100.f422862h;
            if (r119 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r119 = null;
        L34:
            r119.setVisibility(8);
        L35:
            Context r120 = r102.getContext();
            wgb.e r121 = r100.f422861g;
            if (r121 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r121 = null;
        L38:
            wgb.e r122 = r100.f422862h;
            if (r122 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r122 = null;
        L41:
            wgb.b<y6b.c<?>> r123 = new wgb.b(r120, r105, r121, r122);
            r100.f422864j = r123;
            r123.k(new com.ss.android.lark.flow.chat.page.flow.plugin.tip.c(r101, r100));
            r101.Vk(new com.ss.android.lark.flow.chat.page.flow.plugin.tip.d(r100));
            r101.eM(new com.ss.android.lark.flow.chat.page.flow.plugin.tip.e(r100, r101));
            r101.jX(new com.ss.android.lark.flow.chat.page.flow.plugin.tip.g(r100));
            r101.df(new com.ss.android.lark.flow.chat.page.flow.plugin.tip.h(r100));
            wgb.b<y6b.c<?>> r124 = r100.f422864j;
            if (r124 == null) goto L44;
            r124.j();
        L44:
            wgb.b<y6b.c<?>> r125 = r100.f422864j;
            if (r125 == null) goto L47;
            r125.g();
        L47:
            Chat r126 = r100.f422863i;
            if (r126 != null) goto L50;
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentChat");
        L51:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new m(r107.getId(), r100, new UIGetDataCallback(new FlowMessageTipsPlugin$pullUnReadAtMessage$callback$1(r100))));
            return;
        L50:
            r107 = r126;
            goto L51
        L54:
            return;
        L7:
            r104 = false;
            goto L9
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void z9(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            Intrinsics.checkNotNullParameter(r100, "chat");
            FlowMessageTipsPlugin r101 = this.f422874a;
            r101.f422863i = r100;
            wgb.b<y6b.c<?>> r102 = r101.f422864j;
            if (r102 == null) goto L6;
            int r103 = wgb.b.f559612l;
            r102.m(false);
            return;
        }

        public b(FlowMessageTipsPlugin r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r101, i7b.a r102) {
            this.f422874a = r100;
            this.f422875b = r101;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMessageTipsPlugin f422876a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowMessageTipsPlugin f422877a;

            public a(FlowMessageTipsPlugin r100) {
                this.f422877a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                wgb.b<y6b.c<?>> r100 = this.f422877a.f422864j;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                int r101 = wgb.b.f559612l;     // Catch: Throwable -> L6
                r100.n(false);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void a() {
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void d() {
            wgb.b<y6b.c<?>> r100 = this.f422876a.f422864j;
            if (r100 == null) goto L6;
            int r101 = wgb.b.f559612l;
            r100.f(false);
            return;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void f() {
            UICallbackExecutor.executeDelayed(new a(this.f422876a), 200);
        }

        public c(FlowMessageTipsPlugin r100) {
            this.f422876a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void g(com.ss.android.lark.keyboard.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        }
    }

    public static final class d implements IBannerComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowMessageTipsPlugin f422878a;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void c() {
            FlowMessageTipsPlugin r100 = this.f422878a;
            r100.f422873s = 0;
            wgb.b<y6b.c<?>> r101 = r100.f422864j;
            if (r101 == null) goto L6;
            r101.o();
            return;
        }

        public d(FlowMessageTipsPlugin r100) {
            this.f422878a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void a(int r100) {
            FlowMessageTipsPlugin r101 = this.f422878a;
            r101.f422873s = r100;
            wgb.b<y6b.c<?>> r102 = r101.f422864j;
            if (r102 == null) goto L6;
            r102.o();
            return;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void b(int r100) {
            FlowMessageTipsPlugin r101 = this.f422878a;
            r101.f422873s = r100;
            wgb.b<y6b.c<?>> r102 = r101.f422864j;
            if (r102 == null) goto L6;
            r102.o();
            return;
        }
    }

    public static final class e implements ITitlebarComponent.b {
        public e() {
        }
    }

    public static final class f implements ITitlebarComponent.f {
        public f() {
        }
    }

    public static final class g implements ITitlebarComponent.e {
        public g() {
        }
    }

    public static final class h implements ITitlebarComponent.a {
        public h() {
        }
    }

    static {
    }

    public FlowMessageTipsPlugin() {
        this.f422865k = LazyKt.lazy(FlowMessageTipsPlugin$mBadgeProvider$2.INSTANCE);
        this.f422867m = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        this.f422867m.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f422863i = r101.f488506f;
        w4b.c.e r102 = ChatCoreModule.a().getMultiTaskDependency();
        B();
        r102.a();
        this.f422868n = (IMessageListComponent) r100.a(IMessageListComponent.class);
        this.f422869o = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        this.f422870p = (IBannerComponent) r100.a(IBannerComponent.class);
        this.f422871q = (ITitlebarComponent) r100.a(ITitlebarComponent.class);
        IMessageListComponent r103 = this.f422868n;
        if (r103 == null) goto L5;
        r103.m(new b(this, r100, r101));
    L5:
        IKeyboardComponent r104 = this.f422869o;
        if (r104 == null) goto L8;
        r104.m(new c(this));
    L8:
        IBannerComponent r105 = this.f422870p;
        if (r105 == null) goto L11;
        r105.jx(new d(this));
    L11:
        ITitlebarComponent r106 = this.f422871q;
        if (r106 == null) goto L14;
        r106.kq(new e());
    L14:
        ITitlebarComponent r107 = this.f422871q;
        if (r107 == null) goto L17;
        r107.sm(new f());
    L17:
        ITitlebarComponent r108 = this.f422871q;
        if (r108 == null) goto L20;
        r108.pR(new g());
    L20:
        ITitlebarComponent r109 = this.f422871q;
        if (r109 == null) goto L23;
        r109.OY(new h());
    L23:
        ITitlebarComponent r110 = this.f422871q;
        if (r110 == null) goto L26;
        int r111 = r110.w3();
    L27:
        this.f422872r = r111;
        return;
    L26:
        r111 = 0;
        goto L27
    }
}
