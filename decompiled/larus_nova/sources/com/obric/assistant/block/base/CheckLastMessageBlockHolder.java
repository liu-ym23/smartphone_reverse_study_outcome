package com.obric.assistant.block.base;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.i;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.d;
import com.larus.im.observer.MessageListState;
import com.larus.utils.logger.FLogger;
import ic8.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import jc8.a;
import jc8.e;
import kc8.y;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import va8.m0;

/* JADX INFO: loaded from: classes32.dex */
public abstract class CheckLastMessageBlockHolder<T extends jc8.a> extends jc8.b<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f385904o = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f385905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f385906e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f385907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Message f385908g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final StateFlowImpl f385909h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f385910i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Lifecycle f385911j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public i<?> f385912k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m0 f385913l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CheckLastMessageBlockHolder$lifecycleObserver$1 f385914m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f385915n;

    public static final class a {
    }

    public static final class b implements nf9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CheckLastMessageBlockHolder<T> f385916a;

        @Override // nf9.b
        public final void a(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void d(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        @Override // nf9.b
        public final void f(String r100, Message r101) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
        }

        public b(CheckLastMessageBlockHolder<T> r100) {
            this.f385916a = r100;
        }

        public final void g(String r100) {
            FLogger r101 = FLogger.f375446a;
            StringBuilder r102 = new StringBuilder("\n                    checkLastMessageState: isLastestMessage = ");
            r102.append(this.f385916a.l());
            r102.append(", cid = ");
            r102.append(r100);
            r102.append(", curBlockMessage.conversationId = ");
            Message r103 = this.f385916a.f385908g;
            String r104 = null;
            if (r103 == null) goto L5;
            String r105 = r103.getConversationId();
        L6:
            r102.append(r105);
            r102.append("\n                ");
            r101.i("CheckLastMessageBlockHolder", StringsKt.trimIndent(r102.toString()));
            if (this.f385916a.l() == false) goto L15;
            Message r106 = this.f385916a.f385908g;
            if (r106 == null) goto L12;
            r104 = r106.getConversationId();
        L12:
            if (Intrinsics.areEqual(r100, r104) == false) goto L16;
            this.f385916a.k();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            r105 = null;
            goto L6
        }

        @Override // nf9.b
        public final void b(String r100, MessageListState r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r102, "msgList");
            FLogger.f375446a.i("CheckLastMessageBlockHolder", "onMessageListChanged");
            g(r100);
        }

        @Override // nf9.b
        public final void c(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.i("CheckLastMessageBlockHolder", "onUpdateMessage");
            g(r100);
        }

        @Override // nf9.b
        public final void e(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            FLogger.f375446a.i("CheckLastMessageBlockHolder", "onReceiveMessage");
            g(r100);
        }

        @Override // nf9.b
        public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "oldMsgList");
            Intrinsics.checkNotNullParameter(r102, "newMsgList");
            FLogger.f375446a.i("CheckLastMessageBlockHolder", "onMessageListReplaced");
            g(r100);
        }
    }

    static {
    }

    @Override // jc8.b
    public String c() {
        return "CheckLastMessageBlockHolder";
    }

    public abstract void m(boolean r100);

    @Override // jc8.b
    public void i() {
        FLogger r100 = FLogger.f375446a;
        r100.i("CheckLastMessageBlockHolder", "onViewRecycled");
        if (this.f385907f.compareAndSet(true, false) == false) goto L5;
        r100.i("CheckLastMessageBlockHolder", "unregisterOnGlobalMessageObserver");
        d.e().unregisterOnGlobalMessageObserver((b) this.f385915n.getValue());
    L5:
        Lifecycle r101 = this.f385911j;
        if (r101 == null) goto L8;
        r101.removeObserver(this.f385914m);
    L8:
        Job r102 = this.f385910i;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.f385910i = null;
        this.f385909h.setValue(Boolean.TRUE);
    }

    public final void k() {
        Message r100 = this.f385908g;
        if (r100 != null) goto L6;
        FLogger.f375446a.i("CheckLastMessageBlockHolder", "checkLastMessage: blockMessage is null");
        return;
    L6:
        Job r101 = this.f385906e;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        this.f385906e = BuildersKt.launch$default(this.f385905d, null, null, new CheckLastMessageBlockHolder$checkLastMessage$1(this, r100, null), 3, null);
    }

    public final boolean l() {
        return ((Boolean) this.f385909h.getValue()).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.assistant.block.base.CheckLastMessageBlockHolder$lifecycleObserver$1] */
    public CheckLastMessageBlockHolder() {
        this.f385905d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f385907f = new AtomicBoolean(false);
        this.f385909h = j1.a(Boolean.TRUE);
        this.f385914m = new CheckLastMessageBlockHolder$lifecycleObserver$1(this);
        this.f385915n = LazyKt.lazy(new com.obric.assistant.block.base.a(this));
    }

    @Override // jc8.b
    public jc8.d f(T r100) {
        Intrinsics.checkNotNullParameter(r100, "blockModel");
        return e.d(r100);
    }

    @Override // jc8.b
    public void g(T r110) {
        Intrinsics.checkNotNullParameter(r110, "blockModel");
        FLogger r100 = FLogger.f375446a;
        r100.i("CheckLastMessageBlockHolder", "onBindBlockView");
        kc8.b r101 = (kc8.b) jc8.c.a(this, kc8.b.class);
        if (r101 == null) goto L7;
        y r102 = r101.f502425a;
        if (r102 == null) goto L7;
        Fragment r103 = r102.f502620a;
    L8:
        if (r103 == null) goto L10;
        Lifecycle r104 = r103.getLifecycle();
    L11:
        this.f385911j = r104;
        if (r103 == null) goto L14;
        t1a.b r105 = s1a.a.g(r103);
    L15:
        if (r105 == null) goto L19;
        u7 r106 = (u7) r105.getAbility(u7.class);
        if (r106 == null) goto L19;
        MessageAdapter r107 = r106.MF();
    L20:
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type com.larus.bmhome.chat.adapter.IMessageListAdapter<*>");
        this.f385912k = r107;
        if (r105 == null) goto L23;
        m0 r108 = (m0) r105.getAbility(m0.class);
    L24:
        this.f385913l = r108;
        this.f385908g = r110.j();
        Job r111 = this.f385910i;
        if (r111 == null) goto L27;
        Job.DefaultImpls.cancel$default(r111, null, 1, null);
    L27:
        this.f385910i = BuildersKt.launch$default(this.f385905d, null, null, new CheckLastMessageBlockHolder$onBindBlockView$1(this, null), 3, null);
        if (this.f385907f.compareAndSet(false, true) == false) goto L30;
        r100.i("CheckLastMessageBlockHolder", "registerOnGlobalMessageObserver");
        d.e().registerOnGlobalMessageObserver((b) this.f385915n.getValue());
    L30:
        k();
        Lifecycle r112 = this.f385911j;
        if (r112 == null) goto L34;
        r112.addObserver(this.f385914m);
    L34:
        if (this.f385911j != null) goto L37;
        r100.w("CheckLastMessageBlockHolder", "onBindBlockView: lifecycleOwner is null");
        return;
    L37:
        return;
    L23:
        r108 = null;
    L19:
        r107 = null;
        goto L20
    L14:
        r105 = null;
        goto L15
    L10:
        r104 = null;
    L7:
        r103 = null;
        goto L8
    }

    public static final Object j(CheckLastMessageBlockHolder r110, String r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof CheckLastMessageBlockHolder$getLastMessage$1) == false) goto L7;
        CheckLastMessageBlockHolder$getLastMessage$1 r100 = (CheckLastMessageBlockHolder$getLastMessage$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r111 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);
    L87:
        Message r104 = (Message) r113;
        if (r104 == null) goto L90;
        FLogger.f375446a.i("CheckLastMessageBlockHolder", "getLastMessage from repo " + r104.getMessageId());
        return r104;
    L90:
        FLogger.f375446a.i("CheckLastMessageBlockHolder", "getLastMessage: cvsId = " + r111 + ", not found");
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        i<?> r114 = r110.f385912k;
        if (r114 == null) goto L81;
        Iterable r115 = r114.getMessageList();
        if (r115 == null) goto L81;
        Iterator r116 = r115.iterator();
    L20:
        if (r116.hasNext() == false) goto L77;
        Object r105 = r116.next();
        Message r106 = ((v) r105).a();
        boolean r107 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r106) == false) goto L27;
        if (com.larus.bmhome.chat.bean.d.w(r106) == true) goto L27;
    L46:
        boolean r108 = false;
    L47:
        if (r108 == false) goto L75;
        if (b0.f(r106) == true) goto L75;
        if (com.larus.bmhome.chat.bean.d.O0(r106) == false) goto L69;
        m0 r109 = r110.f385913l;
        if (r109 == null) goto L56;
        int r117 = r109.pD();
    L57:
        if (r117 == 0) goto L72;
        if (r117 != 1) goto L60;
        boolean r118 = com.larus.bmhome.chat.bean.d.k0(r106);
    L73:
        if (r118 == true) goto L75;
        r107 = true;
        goto L75
    L60:
        if (r117 != 2) goto L62;
        r118 = com.larus.bmhome.chat.bean.d.W0(r106);
        goto L73
    L62:
        if (r117 != 3) goto L69;
        if (com.larus.bmhome.chat.bean.d.k0(r106) == true) goto L72;
        if (com.larus.bmhome.chat.bean.d.W0(r106) == false) goto L69;
    L72:
        r118 = true;
        goto L73
    L56:
        r117 = -1;
    L69:
        r118 = false;
    L75:
        if (r107 == false) goto L20;
    L78:
        v r119 = (v) r105;
        if (r119 == null) goto L81;
        Message r120 = r119.a();
    L82:
        if (r120 == null) goto L84;
        FLogger.f375446a.i("CheckLastMessageBlockHolder", "getLastMessage from last message list " + r120.getMessageId());
        return r120;
    L84:
        IChatRepoService r121 = zh8.a.f572196a;
        r100.L$0 = r111;
        r100.label = 1;
        r113 = r121.D1(r111, r100);
        if (r113 != r102) goto L87;
        return r102;
    L27:
        if (com.larus.bmhome.chat.bean.d.T(r106) == true) goto L46;
        if (com.larus.bmhome.chat.bean.d.p0(r106) == true) goto L46;
        if (com.larus.bmhome.chat.bean.d.C0(r106) == true) goto L34;
    L36:
        MessageStatus r122 = r106.getMessageStatus();
        if (r122 != null) goto L39;
    L41:
        boolean r123 = false;
    L42:
        if (r123 == false) goto L44;
    L45:
        r108 = true;
        goto L47
    L44:
        if (b0.f(r106) == false) goto L46;
    L39:
        if (r122.isVisible() != true) goto L41;
        r123 = true;
        goto L42
    L34:
        if (r106.getRegenVisible() == true) goto L36;
    L77:
        r105 = null;
    L81:
        r120 = null;
    L7:
        r100 = new CheckLastMessageBlockHolder$getLastMessage$1(r110, r112);
        goto L8
    }
}
