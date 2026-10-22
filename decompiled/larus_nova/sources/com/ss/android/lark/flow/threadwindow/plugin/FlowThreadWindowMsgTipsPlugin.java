package com.ss.android.lark.flow.threadwindow.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.larksuite.framework.callback.UICallbackExecutor;
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
import dwa.j;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowThreadWindowMsgTipsPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wgb.e f424251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public wgb.e f424252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Chat f424253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wgb.b<y6b.c<?>> f424254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f424255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f424256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larksuite.framework.callback.c f424257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IMessageListComponent f424258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IKeyboardComponent f424259o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IBannerComponent f424260p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ITitlebarComponent f424261q;

    public static final class a {
    }

    public static final class b implements IMessageListComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin f424262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c f424263b;

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
            FlowThreadWindowMsgTipsPlugin r100 = this.f424262a;
            IMessageListComponent r101 = r100.f424258n;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r102 = this.f424263b;
            wgb.b<y6b.c<?>> r103 = r100.f424254j;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.d() != true) goto L7;
        L9:
            if (r104 == false) goto L11;
            Log.e("FlowThreadWindowMsgTipsPlugin", "message tip is valid when init");
            return;
        L11:
            r7b.d r105 = new r7b.d(new com.ss.android.lark.flow.threadwindow.plugin.g(r100));
            if (r101 == null) goto L53;
            RelativeLayout r106 = r101.UI();
            Log.i("FlowThreadWindowMsgTipsPlugin", "init message tips view");
            wgb.e r107 = null;
            if (r106 == null) goto L35;
            Context r108 = r106.getContext();
            if (r108 == null) goto L19;
            j r109 = j.d(r108);
            String r110 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r109.getClass();
            dwa.b.c(r110);
        L19:
            r100.f424251g = new wgb.e(r106.getContext());
            RelativeLayout.LayoutParams r111 = new RelativeLayout.LayoutParams(-2, -2);
            r111.addRule(14);
            r111.addRule(10);
            wgb.e r112 = r100.f424251g;
            if (r112 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r112 = null;
        L22:
            r106.addView(r112, r111);
            wgb.e r113 = r100.f424251g;
            if (r113 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r113 = null;
        L25:
            r113.setVisibility(8);
            Context r114 = r106.getContext();
            if (r114 == null) goto L28;
            j r115 = j.d(r114);
            String r116 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r115.getClass();
            dwa.b.c(r116);
        L28:
            r100.f424252h = new wgb.e(r106.getContext());
            RelativeLayout.LayoutParams r117 = new RelativeLayout.LayoutParams(-2, -2);
            r117.addRule(14);
            r117.addRule(8, R.id.chat_ptr_layout);
            wgb.e r118 = r100.f424252h;
            if (r118 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r118 = null;
        L31:
            r106.addView(r118, r117);
            wgb.e r119 = r100.f424252h;
            if (r119 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r119 = null;
        L34:
            r119.setVisibility(8);
        L35:
            Context r120 = r102.getContext();
            wgb.e r121 = r100.f424251g;
            if (r121 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r121 = null;
        L38:
            wgb.e r122 = r100.f424252h;
            if (r122 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
        L42:
            wgb.b<y6b.c<?>> r123 = new wgb.b(r120, r105, r121, r107);
            r100.f424254j = r123;
            r123.k(new com.ss.android.lark.flow.threadwindow.plugin.a(r101, r100));
            r101.Vk(new com.ss.android.lark.flow.threadwindow.plugin.b(r100));
            r101.eM(new com.ss.android.lark.flow.threadwindow.plugin.c(r100, r101));
            r101.jX(new com.ss.android.lark.flow.threadwindow.plugin.e(r100));
            r101.df(new com.ss.android.lark.flow.threadwindow.plugin.f(r100));
            wgb.b<y6b.c<?>> r124 = r100.f424254j;
            if (r124 == null) goto L45;
            r124.j();
        L45:
            wgb.b<y6b.c<?>> r125 = r100.f424254j;
            if (r125 == null) goto L48;
            r125.g();
        L48:
            wgb.b<y6b.c<?>> r126 = r100.f424254j;
            if (r126 == null) goto L54;
            r126.h(CollectionsKt.emptyList());
            return;
        L54:
            return;
        L41:
            r107 = r122;
            goto L42
        L53:
            return;
        L7:
            r104 = false;
            goto L9
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void z9(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            Intrinsics.checkNotNullParameter(r100, "chat");
            FlowThreadWindowMsgTipsPlugin r101 = this.f424262a;
            r101.f424253i = r100;
            wgb.b<y6b.c<?>> r102 = r101.f424254j;
            if (r102 == null) goto L6;
            int r103 = wgb.b.f559612l;
            r102.m(false);
            return;
        }

        public b(FlowThreadWindowMsgTipsPlugin r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r101, i7b.a r102) {
            this.f424262a = r100;
            this.f424263b = r101;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin f424264a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowThreadWindowMsgTipsPlugin f424265a;

            public a(FlowThreadWindowMsgTipsPlugin r100) {
                this.f424265a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                wgb.b<y6b.c<?>> r100 = this.f424265a.f424254j;     // Catch: Throwable -> L6
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
            wgb.b<y6b.c<?>> r100 = this.f424264a.f424254j;
            if (r100 == null) goto L6;
            int r101 = wgb.b.f559612l;
            r100.f(false);
            return;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void f() {
            UICallbackExecutor.executeDelayed(new a(this.f424264a), 200);
        }

        public c(FlowThreadWindowMsgTipsPlugin r100) {
            this.f424264a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void g(com.ss.android.lark.keyboard.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        }
    }

    public static final class d implements IBannerComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowThreadWindowMsgTipsPlugin f424266a;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void c() {
            this.f424266a.getClass();
            wgb.b<y6b.c<?>> r100 = this.f424266a.f424254j;
            if (r100 == null) goto L6;
            r100.o();
            return;
        }

        public d(FlowThreadWindowMsgTipsPlugin r100) {
            this.f424266a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void a(int r100) {
            this.f424266a.getClass();
            wgb.b<y6b.c<?>> r101 = this.f424266a.f424254j;
            if (r101 == null) goto L6;
            r101.o();
            return;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void b(int r100) {
            this.f424266a.getClass();
            wgb.b<y6b.c<?>> r101 = this.f424266a.f424254j;
            if (r101 == null) goto L6;
            r101.o();
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

    public FlowThreadWindowMsgTipsPlugin() {
        this.f424256l = LazyKt.lazy(FlowThreadWindowMsgTipsPlugin$mBadgeProvider$2.INSTANCE);
        this.f424257m = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        this.f424257m.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f424253i = r101.f488506f;
        w4b.c.e r102 = ChatCoreModule.a().getMultiTaskDependency();
        B();
        r102.a();
        this.f424258n = (IMessageListComponent) r100.a(IMessageListComponent.class);
        this.f424259o = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        this.f424260p = (IBannerComponent) r100.a(IBannerComponent.class);
        this.f424261q = (ITitlebarComponent) r100.a(ITitlebarComponent.class);
        IMessageListComponent r103 = this.f424258n;
        if (r103 == null) goto L5;
        r103.m(new b(this, r100, r101));
    L5:
        IKeyboardComponent r104 = this.f424259o;
        if (r104 == null) goto L8;
        r104.m(new c(this));
    L8:
        IBannerComponent r105 = this.f424260p;
        if (r105 == null) goto L11;
        r105.jx(new d(this));
    L11:
        ITitlebarComponent r106 = this.f424261q;
        if (r106 == null) goto L14;
        r106.kq(new e());
    L14:
        ITitlebarComponent r107 = this.f424261q;
        if (r107 == null) goto L17;
        r107.sm(new f());
    L17:
        ITitlebarComponent r108 = this.f424261q;
        if (r108 == null) goto L20;
        r108.pR(new g());
    L20:
        ITitlebarComponent r109 = this.f424261q;
        if (r109 == null) goto L23;
        r109.OY(new h());
    L23:
        ITitlebarComponent r110 = this.f424261q;
        if (r110 == null) goto L27;
        r110.w3();
        return;
    }
}
