package wgb;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.utils.AndroidThrottle;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.m;
import com.ss.android.lark.chatwindow.view.tip.NewMessageTipUtils;
import com.ss.android.lark.flow.chat.databinding.LayoutFlowMessageTipBinding;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b<T> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f559612l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r7b.c f559613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f559614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f559615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f<T> f559616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wgb.a<T> f559617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f559618f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AndroidThrottle<Runnable> f559619g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f559620h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f559621i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f559622j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f559623k;

    public static final class a {
    }

    /* JADX INFO: renamed from: wgb.b$b, reason: collision with other inner class name */
    public static final class RunnableC8112b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T> f559624a;

        public RunnableC8112b(b<T> r100) {
            this.f559624a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f559624a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T> f559625a;

        public c(b<T> r100) {
            this.f559625a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f559625a.c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void c() {
        f<T> r100 = this.f559616d;
        wgb.a<T> r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r100 = null;
    L5:
        boolean r102 = true;
        boolean r103 = b(r100, this.f559614b, true);
        wgb.a<T> r104 = this.f559617e;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L9:
        e r105 = this.f559615c;
        if (this.f559618f == false) goto L13;
        if (r103 == true) goto L13;
    L14:
        b(r101, r105, r102);
        return;
    L13:
        r102 = false;
        goto L14
    L8:
        r101 = r104;
        goto L9
    }

    public final boolean d() {
        if (this.f559620h == true) goto L6;
        Log.e("FlowMessageTipController", "Un-init");
    L6:
        return this.f559620h;
    }

    public final void e() {
        if (d() == true) goto L5;
        return;
    L5:
        this.f559614b.setLoadingState(false);
        this.f559615c.setLoadingState(false);
    }

    public final void g() {
        if (d() == true) goto L5;
        return;
    L5:
        f<T> r100 = this.f559616d;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r100 = null;
    L8:
        r100.f417114h = r100.f417103b.e() + 1;
        r100.f417112f = r100.f417103b.l() + 1;
        r100.f417113g = r100.f417103b.i() + 1;
    }

    public final void j() {
        if (d() == true) goto L5;
        return;
    L5:
        wgb.a<T> r100 = this.f559617e;
        wgb.a<T> r101 = null;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r100 = null;
    L8:
        r100.f417108f = 0;
        e r102 = this.f559615c;
        wgb.a<T> r103 = this.f559617e;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L12:
        ViewGroup.LayoutParams r104 = this.f559615c.getLayoutParams();
        r101.k(r104);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "layoutParams");
        r102.setLayoutParams(r104);
        return;
    L11:
        r101 = r103;
        goto L12
    }

    public final void l() {
        if (d() == true) goto L5;
        return;
    L5:
        this.f559614b.setLoadingState(true);
        this.f559615c.setLoadingState(true);
    }

    public final void o() {
        if (d() == true) goto L5;
        return;
    L5:
        e r100 = this.f559614b;
        f<T> r101 = this.f559616d;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r101 = null;
    L8:
        ViewGroup.LayoutParams r102 = this.f559614b.getLayoutParams();
        r101.k(r102);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "layoutParams");
        r100.setLayoutParams(r102);
    }

    public final void f(boolean r100) {
        if (d() == true) goto L5;
        return;
    L5:
        wgb.a<T> r101 = this.f559617e;
        f<T> r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r101 = null;
    L8:
        r101.f417105d = true;
        f<T> r103 = this.f559616d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
    L12:
        r102.f417105d = true;
        m(r100);
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public final void h(List<? extends MessageInfo> r100) {
        if (d() == true) goto L6;
        return;
    L6:
        if (this.f559613a.f() != Chat.MessagePosition.NEWEST_UNREAD) goto L9;
        ArrayList r101 = new ArrayList();
    L13:
        StringBuilder r102 = new StringBuilder("new message tip strategy: ");
        Chat.MessagePosition r103 = this.f559613a.f();
        wgb.a<T> r104 = null;
        if (r103 == null) goto L16;
        String r105 = r103.desc();
    L17:
        r102.append(r105);
        Log.i("FlowMessageTipController", r102.toString());
        f<T> r106 = this.f559616d;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r106 = null;
    L21:
        if (r100 != null) goto L24;
        r100 = CollectionsKt.emptyList();
    L24:
        ArrayList r107 = new ArrayList(r100);
        r106.getClass();
        Iterator r108 = r107.iterator();
    L26:
        if (r108.hasNext() == false) goto L30;
        if (r106.f417103b.d((MessageInfo) r108.next()) < r106.f417113g) goto L26;
        r108.remove();
        goto L26
    L30:
        CollectionUtils.resetToList(r106.f417102a, r107);
        Collections.sort(r106.f417102a);
        Collections.reverse(r106.f417102a);
        wgb.a<T> r109 = this.f559617e;
        if (r109 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L34:
        r104.getClass();
        Iterator r110 = r101.iterator();
    L36:
        if (r110.hasNext() == false) goto L40;
        if (r104.f417103b.d((MessageInfo) r110.next()) > r104.f417110h) goto L36;
        r110.remove();
        goto L36
    L40:
        CollectionUtils.resetToList(r104.f417102a, r101);
        this.f559622j = true;
        m(true);
        return;
    L33:
        r104 = r109;
        goto L34
    L16:
        r105 = null;
        goto L17
    L9:
        if (r100 == null) goto L11;
        List<? extends MessageInfo> r111 = r100;
    L12:
        r101 = new ArrayList(r111);
        goto L13
    L11:
        r111 = CollectionsKt.emptyList();
        goto L12
    }

    public final void k(com.ss.android.lark.chatwindow.view.tip.a.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (d() == true) goto L5;
        return;
    L5:
        wgb.a<T> r101 = this.f559617e;
        f<T> r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r101 = null;
    L8:
        r101.f417106e = r100;
        f<T> r103 = this.f559616d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
    L12:
        r102.f417106e = r100;
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public final void m(boolean r100) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f559621i == true) goto L7;
        return;
    L7:
        if (this.f559622j == false) goto L26;
        if (r100 == false) goto L13;
        c();
        return;
    L13:
        if (this.f559623k == false) goto L18;
        AndroidThrottle<Runnable> r101 = this.f559619g;
        if (r101 == null) goto L17;
        RunnableC8112b r102 = new RunnableC8112b(this);
        r101.f285868a.post(new com.larksuite.framework.utils.a(r101, r102));
    L17:
        this.f559623k = false;
        return;
    L18:
        AndroidThrottle<Runnable> r103 = this.f559619g;
        if (r103 == null) goto L25;
        r103.d(new c(this));
        return;
    L25:
        return;
    }

    public final void n(boolean r100) {
        if (d() == true) goto L5;
        return;
    L5:
        wgb.a<T> r101 = this.f559617e;
        f<T> r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r101 = null;
    L8:
        r101.f417105d = false;
        f<T> r103 = this.f559616d;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
    L12:
        r102.f417105d = false;
        m(r100);
        return;
    L11:
        r102 = r103;
        goto L12
    }

    public final void a(List<? extends MessageInfo> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "messageInfos");
        if (d() == true) goto L5;
        return;
    L5:
        this.f559618f = r101;
        Log.i("FlowMessageTipController", "add new messages count: " + r100.size());
        wgb.a<T> r102 = this.f559617e;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
        r102 = null;
    L8:
        r102.getClass();
        Iterator<? extends MessageInfo> r103 = r100.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        MessageInfo r104 = r103.next();
        if (r102.f417103b.g(r104) == false) goto L10;
        ((ArrayList) r102.f417102a).add(r104);
        goto L10
    L14:
        Iterator r105 = ((ArrayList) r102.f417102a).iterator();
    L16:
        if (r105.hasNext() == false) goto L20;
        if (r102.f417103b.k((MessageInfo) r105.next()) == false) goto L16;
        r105.remove();
        goto L16
    L20:
        StringBuilder r106 = new StringBuilder("strategy: ");
        r106.append(r102.f417103b.f().desc());
        r106.append(" add unread at messages: ");
        int r107 = NewMessageTipUtils.f417087a;
        r106.append(NewMessageTipUtils.a(r102.f417102a));
        Log.i("NewMessageTipController", r106.toString());
        r102.f417109g = true;
        m(false);
    }

    public final void i(List<? extends T> r100, com.ss.android.lark.chatwindow.view.tip.a.b<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "passedDataList");
        Intrinsics.checkNotNullParameter(r101, "fetcher");
        if (d() == true) goto L5;
        return;
    L5:
        f<T> r102 = this.f559616d;
        wgb.a<T> r103 = null;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("topNewMessageTip");
        r102 = null;
    L8:
        r102.j(r100, r101);
        wgb.a<T> r104 = this.f559617e;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("bottomNewMessageTip");
    L12:
        r103.j(r100, r101);
        m(false);
        return;
    L11:
        r103 = r104;
        goto L12
    }

    public final boolean b(com.ss.android.lark.chatwindow.view.tip.a<?> r100, e r110, boolean r111) {
        if (r100 == null) goto L76;
        if (r110 != null) goto L7;
        return false;
    L7:
        if (d() == true) goto L10;
        return false;
    L10:
        if (r100.i() == true) goto L14;
        r110.setVisibility(8);
        return false;
    L14:
        if (r100.f417105d == false) goto L16;
    L18:
        boolean r101 = false;
    L19:
        LayoutFlowMessageTipBinding r102 = null;
        if (r101 == false) goto L52;
        if (r111 == false) goto L52;
        if (((ArrayList) r100.f417102a).isEmpty() == true) goto L25;
        MessageInfo r112 = (MessageInfo) ListProtector.get(r100.f417102a, 0);
    L26:
        if (r112 != null) goto L28;
    L39:
        ((ArrayList) r100.f417102a).remove(r112);
    L40:
        com.ss.android.lark.chatwindow.view.tip.a.C4883a r113 = null;
    L41:
        if (r113 == null) goto L50;
        String r103 = r113.f417107a;
        Intrinsics.checkNotNullParameter(r103, "atTip");
        r110.a();
        LayoutFlowMessageTipBinding r114 = r110.f559629a;
        if (r114 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L45:
        r114.f422179g.setVisibility(0);
        LayoutFlowMessageTipBinding r115 = r110.f559629a;
        if (r115 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L49:
        r102.f422179g.setText(r103);
        d();
    L73:
        return true;
    L48:
        r102 = r115;
        goto L49
    L50:
        Log.e("FlowMessageTipController", "cannot get at content when show top tips");
        return false;
    L28:
        if (r112.getMessageSender() == null) goto L39;
        if (r112.getMessage().isFromMe() == true) goto L39;
        ChatChatter r104 = r112.getMessageSender();
        String r105 = m.b(r104, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, false);
        Message r106 = r112.getMessage();
        String r107 = r100.a(r106, r105);
        if (r107 != null) goto L35;
        Log.e("chatwindow", "show at tip, but message is not at me or at all. message: " + r106);
        ((ArrayList) r100.f417102a).remove(r112);
        goto L40
    L35:
        r113 = new com.ss.android.lark.chatwindow.view.tip.a.C4883a();
        r100.f417103b.c(r106);
        r113.f417107a = r107;
        if (TextUtils.isEmpty(r107) == true) goto L38;
        r107.replace(r105, "");
    L38:
        r104.getAvatarKey();
        r104.getId();
        goto L41
    L25:
        r112 = null;
    L52:
        if (r100.h() == false) goto L63;
        if (r111 == false) goto L63;
        String r108 = r100.d();
        Intrinsics.checkNotNullParameter(r108, "newMessageTip");
        r110.a();
        LayoutFlowMessageTipBinding r116 = r110.f559629a;
        if (r116 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r116 = null;
    L57:
        r116.f422179g.setVisibility(0);
        LayoutFlowMessageTipBinding r117 = r110.f559629a;
        if (r117 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L61:
        r102.f422179g.setText(r108);
        goto L73
    L60:
        r102 = r117;
    L63:
        if (r100.g() == false) goto L74;
        if (r111 == false) goto L74;
        r110.setVisibility(0);
        LayoutFlowMessageTipBinding r109 = r110.f559629a;
        if (r109 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L68:
        r109.f422175c.setVisibility(0);
        LayoutFlowMessageTipBinding r118 = r110.f559629a;
        if (r118 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L72:
        r102.f422178f.setVisibility(8);
        goto L73
    L71:
        r102 = r118;
    L74:
        r110.setVisibility(8);
        return false;
    L16:
        if (((ArrayList) r100.f417102a).isEmpty() == true) goto L18;
        r101 = true;
        goto L19
    L76:
        return false;
    }

    public b(Context r100, r7b.c r101, e r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataStrategy");
        Intrinsics.checkNotNullParameter(r102, "topTipView");
        Intrinsics.checkNotNullParameter(r103, "bottomTipView");
        this.f559613a = r101;
        this.f559614b = r102;
        this.f559615c = r103;
        this.f559618f = true;
        new HashSet();
        this.f559623k = true;
        f<T> r104 = new f(r100, r101);
        this.f559616d = r104;
        wgb.a<T> r105 = new wgb.a(r100, r101);
        this.f559617e = r105;
        r101.h();
        r102.setOnClickListener(new d(this));
        ViewGroup.LayoutParams r106 = r102.getLayoutParams();
        r104.k(r106);
        Intrinsics.checkNotNullParameter(r106, "layoutParams");
        r102.setLayoutParams(r106);
        r102.setArrowDirection(true);
        ViewGroup.LayoutParams r107 = r103.getLayoutParams();
        r105.k(r107);
        Intrinsics.checkNotNullParameter(r107, "layoutParams");
        r103.setLayoutParams(r107);
        r103.setOnClickListener(new wgb.c(this));
        r103.setArrowDirection(false);
        new CallbackManager();
        AndroidThrottle.a r108 = new AndroidThrottle.a();
        r108.f285878b = 500;
        r108.f285881e = new AndroidThrottle.b();
        this.f559619g = new AndroidThrottle(r108);
        this.f559620h = true;
    }
}
