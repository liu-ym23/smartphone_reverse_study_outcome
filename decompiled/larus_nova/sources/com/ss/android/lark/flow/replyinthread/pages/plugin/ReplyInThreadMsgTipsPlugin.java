package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultCaller;
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
public final class ReplyInThreadMsgTipsPlugin extends com.ss.android.lark.chat.chatwindow.biz.plugin.core.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wgb.e f423986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public wgb.e f423987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Chat f423988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public wgb.b<y6b.c<?>> f423989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f423990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f423991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.larksuite.framework.callback.c f423992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public IMessageListComponent f423993n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public IKeyboardComponent f423994o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IBannerComponent f423995p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ITitlebarComponent f423996q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f423997r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f423998s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public zhb.a f423999t;

    public static final class a {
    }

    public static final class b implements IMessageListComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadMsgTipsPlugin f424000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.chat.chatwindow.chat.v2.component.c f424001b;

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
            final ReplyInThreadMsgTipsPlugin r100 = this.f424000a;
            IMessageListComponent r101 = r100.f423993n;
            com.ss.android.lark.chat.chatwindow.chat.v2.component.c r102 = this.f424001b;
            wgb.b<y6b.c<?>> r103 = r100.f423989j;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.d() != true) goto L7;
        L9:
            if (r104 == false) goto L11;
            Log.e("ReplyInThreadMsgTipsPlugin", "message tip is valid when init");
            return;
        L11:
            zhb.a r105 = r100.f423999t;
            Chat r106 = null;
            if (r105 == null) goto L14;
            ThreadTopic r107 = r105.N1();
        L15:
            if (r107 != null) goto L17;
            Log.e("ReplyInThreadMsgTipsPlugin", "threadTopic is valid when init");
            return;
        L17:
            com.ss.android.lark.flow.replyinthread.pages.plugin.h r108 = new com.ss.android.lark.flow.replyinthread.pages.plugin.h(new i(r107), new j(r100), new k(r100));
            if (r101 == null) goto L61;
            RelativeLayout r109 = r101.UI();
            Log.i("ReplyInThreadMsgTipsPlugin", "init message tips view");
            if (r109 == null) goto L41;
            Context r110 = r109.getContext();
            if (r110 == null) goto L25;
            dwa.j r111 = dwa.j.d(r110);
            String r112 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r111.getClass();
            dwa.b.c(r112);
        L25:
            r100.f423986g = new wgb.e(r109.getContext());
            RelativeLayout.LayoutParams r113 = new RelativeLayout.LayoutParams(-2, -2);
            r113.addRule(14);
            r113.addRule(10);
            wgb.e r114 = r100.f423986g;
            if (r114 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r114 = null;
        L28:
            r109.addView(r114, r113);
            wgb.e r115 = r100.f423986g;
            if (r115 != null) goto L31;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r115 = null;
        L31:
            r115.setVisibility(8);
            Context r116 = r109.getContext();
            if (r116 == null) goto L34;
            dwa.j r117 = dwa.j.d(r116);
            String r118 = Reflection.getOrCreateKotlinClass(wgb.e.class).getQualifiedName();
            r117.getClass();
            dwa.b.c(r118);
        L34:
            r100.f423987h = new wgb.e(r109.getContext());
            RelativeLayout.LayoutParams r119 = new RelativeLayout.LayoutParams(-2, -2);
            r119.addRule(14);
            r119.addRule(8, R.id.chat_ptr_layout);
            wgb.e r120 = r100.f423987h;
            if (r120 != null) goto L37;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r120 = null;
        L37:
            r109.addView(r120, r119);
            wgb.e r121 = r100.f423987h;
            if (r121 != null) goto L40;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r121 = null;
        L40:
            r121.setVisibility(8);
        L41:
            Context r122 = r102.getContext();
            wgb.e r123 = r100.f423986g;
            if (r123 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageTopTip");
            r123 = null;
        L44:
            wgb.e r124 = r100.f423987h;
            if (r124 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("mNewMessageBottomTip");
            r124 = null;
        L47:
            wgb.b<y6b.c<?>> r125 = new wgb.b(r122, r108, r123, r124);
            r100.f423989j = r125;
            r125.k(new com.ss.android.lark.flow.replyinthread.pages.plugin.b(r101, r100));
            r101.Vk(new com.ss.android.lark.flow.replyinthread.pages.plugin.c(r100));
            r101.eM(new com.ss.android.lark.flow.replyinthread.pages.plugin.d(r100, r101));
            r101.jX(new com.ss.android.lark.flow.replyinthread.pages.plugin.f(r100));
            r101.df(new com.ss.android.lark.flow.replyinthread.pages.plugin.g(r100));
            wgb.b<y6b.c<?>> r126 = r100.f423989j;
            if (r126 == null) goto L50;
            r126.j();
        L50:
            wgb.b<y6b.c<?>> r127 = r100.f423989j;
            if (r127 == null) goto L53;
            r127.g();
        L53:
            Chat r128 = r100.f423988i;
            if (r128 != null) goto L56;
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentChat");
        L57:
            CoreThreadPool.getDefault().getCachedThreadPool().execute(new l(r106.getId(), r100, new UIGetDataCallback(new ReplyInThreadMsgTipsPlugin$pullUnReadAtMessage$callback$1(r100))));
            return;
        L56:
            r106 = r128;
            goto L57
        L61:
            return;
        L14:
            r107 = null;
        L7:
            r104 = false;
            goto L9
        }

        @Override // com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent.a
        public final void z9(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            Intrinsics.checkNotNullParameter(r100, "chat");
            ReplyInThreadMsgTipsPlugin r101 = this.f424000a;
            r101.f423988i = r100;
            wgb.b<y6b.c<?>> r102 = r101.f423989j;
            if (r102 == null) goto L6;
            int r103 = wgb.b.f559612l;
            r102.m(false);
            return;
        }

        public b(ReplyInThreadMsgTipsPlugin r100, com.ss.android.lark.chat.chatwindow.chat.v2.component.c r101, i7b.a r102) {
            this.f424000a = r100;
            this.f424001b = r101;
        }
    }

    public static final class c implements ChatWindowKeyboard.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadMsgTipsPlugin f424002a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ReplyInThreadMsgTipsPlugin f424003a;

            public a(ReplyInThreadMsgTipsPlugin r100) {
                this.f424003a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                wgb.b<y6b.c<?>> r100 = this.f424003a.f423989j;     // Catch: Throwable -> L6
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
            wgb.b<y6b.c<?>> r100 = this.f424002a.f423989j;
            if (r100 == null) goto L6;
            int r101 = wgb.b.f559612l;
            r100.f(false);
            return;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void f() {
            UICallbackExecutor.executeDelayed(new a(this.f424002a), 200);
        }

        public c(ReplyInThreadMsgTipsPlugin r100) {
            this.f424002a = r100;
        }

        @Override // com.ss.android.lark.biz.im.api.extension.chat_window.ChatWindowKeyboard.a
        public final void g(com.ss.android.lark.keyboard.b r100) {
            Intrinsics.checkNotNullParameter(r100, ObricActionBarTrackType.KEY_BOARD);
        }
    }

    public static final class d implements IBannerComponent.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplyInThreadMsgTipsPlugin f424004a;

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void c() {
            ReplyInThreadMsgTipsPlugin r100 = this.f424004a;
            r100.f423998s = 0;
            wgb.b<y6b.c<?>> r101 = r100.f423989j;
            if (r101 == null) goto L6;
            r101.o();
            return;
        }

        public d(ReplyInThreadMsgTipsPlugin r100) {
            this.f424004a = r100;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void a(int r100) {
            ReplyInThreadMsgTipsPlugin r101 = this.f424004a;
            r101.f423998s = r100;
            wgb.b<y6b.c<?>> r102 = r101.f423989j;
            if (r102 == null) goto L6;
            r102.o();
            return;
        }

        @Override // com.ss.android.lark.chat.chatwindow.biz.component.banner.IBannerComponent.a
        public final void b(int r100) {
            ReplyInThreadMsgTipsPlugin r101 = this.f424004a;
            r101.f423998s = r100;
            wgb.b<y6b.c<?>> r102 = r101.f423989j;
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

    public ReplyInThreadMsgTipsPlugin() {
        this.f423990k = LazyKt.lazy(ReplyInThreadMsgTipsPlugin$mBadgeProvider$2.INSTANCE);
        this.f423992m = new com.larksuite.framework.callback.c(new Handler(Looper.getMainLooper()));
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void D() {
        super.D();
        this.f423992m.d();
    }

    @Override // com.ss.android.lark.chat.chatwindow.biz.plugin.core.BaseChatPlugin
    public final void C(com.ss.android.lark.chat.chatwindow.chat.v2.component.c r100, i7b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "chatApp");
        Intrinsics.checkNotNullParameter(r101, "initData");
        super.C(r100, r101);
        this.f423988i = r101.f488506f;
        w4b.c.e r102 = ChatCoreModule.a().getMultiTaskDependency();
        B();
        r102.a();
        ActivityResultCaller r103 = r100.getFragment();
        if ((r103 instanceof zhb.a) == false) goto L5;
        zhb.a r104 = (zhb.a) r103;
    L6:
        this.f423999t = r104;
        this.f423993n = (IMessageListComponent) r100.a(IMessageListComponent.class);
        this.f423994o = (IKeyboardComponent) r100.a(IKeyboardComponent.class);
        this.f423995p = (IBannerComponent) r100.a(IBannerComponent.class);
        this.f423996q = (ITitlebarComponent) r100.a(ITitlebarComponent.class);
        IMessageListComponent r105 = this.f423993n;
        if (r105 == null) goto L9;
        r105.m(new b(this, r100, r101));
    L9:
        IKeyboardComponent r106 = this.f423994o;
        if (r106 == null) goto L12;
        r106.m(new c(this));
    L12:
        IBannerComponent r107 = this.f423995p;
        if (r107 == null) goto L15;
        r107.jx(new d(this));
    L15:
        ITitlebarComponent r108 = this.f423996q;
        if (r108 == null) goto L18;
        r108.kq(new e());
    L18:
        ITitlebarComponent r109 = this.f423996q;
        if (r109 == null) goto L21;
        r109.sm(new f());
    L21:
        ITitlebarComponent r110 = this.f423996q;
        if (r110 == null) goto L24;
        r110.pR(new g());
    L24:
        ITitlebarComponent r111 = this.f423996q;
        if (r111 == null) goto L27;
        r111.OY(new h());
    L27:
        ITitlebarComponent r112 = this.f423996q;
        if (r112 == null) goto L30;
        int r113 = r112.w3();
    L31:
        this.f423997r = r113;
        return;
    L30:
        r113 = 0;
        goto L31
    L5:
        r104 = null;
        goto L6
    }
}
