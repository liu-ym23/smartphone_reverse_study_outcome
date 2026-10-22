package com.larus.avlink.plugins;

import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.platform.AndroidPlatformKt;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class DoraIMPlugin extends com.larus.audio.call.arch.a<n4> implements e1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f293640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f293641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f293642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f293643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final q68.a<String, String> f293644j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set<String> f293645k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f293646l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q68.a<String, Long> f293647m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f293648n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f293649o;

    public static final class a extends com.larus.im.service.audio.z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f293650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DoraIMPlugin f293651b;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f293650a;
        }

        public a(DoraIMPlugin r100) {
            this.f293651b = r100;
            this.f293650a = r100.f293640f;
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(com.larus.im.service.audio.z0.a r110) {
            Intrinsics.checkNotNullParameter(r110, "event");
            if ((r110 instanceof pf9.z) == false) goto L9;
            DoraIMPlugin r100 = this.f293651b;
            String r111 = ((pf9.z) r110).f528980a;
            if (r111 != null) goto L7;
            r111 = "";
        L7:
            r100.f293648n = r111;
            return;
        L9:
            if ((r110 instanceof pf9.a0) == false) goto L25;
            String r112 = this.f293651b.f293648n;
            if (r112.length() <= 0) goto L13;
            boolean r101 = true;
        L14:
            if (r101 == false) goto L26;
            ((CopyOnWriteArraySet) this.f293651b.f293645k).add(r112);
            q68.a<String, Long> r102 = this.f293651b.f293647m;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r112, "key");
            if (r102.f531866a.get(r112) == null) goto L22;
            IRealtimeCallTracer r103 = this.f293651b.getContext().k();
            q68.a<String, Long> r104 = this.f293651b.f293647m;
            r104.getClass();
            Intrinsics.checkNotNullParameter(r112, "key");
            Long r105 = r104.f531866a.get(r112);
            if (r105 == null) goto L20;
            long r106 = r105.longValue();
        L21:
            r103.h0(r106, System.currentTimeMillis(), this.f293651b.getContext().params().f288755o.f288899a, this.f293651b.getContext().params().f288751k.f288831t);
            q68.a<String, Long> r107 = this.f293651b.f293647m;
            r107.getClass();
            Intrinsics.checkNotNullParameter(r112, "key");
            r107.f531866a.remove(r112);
            return;
        L20:
            r106 = 0;
            goto L21
        L22:
            q68.a<String, Long> r108 = this.f293651b.f293647m;
            Long r109 = Long.valueOf(System.currentTimeMillis());
            r108.getClass();
            Intrinsics.checkNotNullParameter(r112, "key");
            r108.f531866a.put(r112, r109);
            return;
        L26:
            return;
        L13:
            r101 = false;
            goto L14
        }
    }

    public static final class b extends y4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraIMPlugin f293652a;

        public b(DoraIMPlugin r100) {
            this.f293652a = r100;
        }

        @Override // nf9.b
        public final void c(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            DoraIMPlugin.j3(this.f293652a, r100, r101);
        }

        @Override // nf9.b
        public final void e(String r100, Message r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "cid");
            Intrinsics.checkNotNullParameter(r101, "msg");
            DoraIMPlugin.j3(this.f293652a, r100, r101);
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        com.larus.im.d.e().unregisterOnMessageChangedObserver(this.f293641g, this.f293649o);
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        String r100 = getContext().params().f288752l.f288787c;
        this.f293641g = r100;
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        com.larus.im.d.e().registerOnMessageChangedObserver(this.f293641g, this.f293649o);
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        CoroutineScope r100 = getContext().r();
        if (r100 == null) goto L6;
        BuildersKt.launch$default(r100, Dispatchers.getIO(), null, new DoraIMPlugin$onStop$1(this, null), 2, null);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f293640f;
    }

    public DoraIMPlugin(n4 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f293640f = "DoraIMPlugin";
        this.f293641g = "";
        this.f293642h = new CopyOnWriteArraySet();
        this.f293643i = new CopyOnWriteArraySet();
        this.f293644j = new q68.a();
        this.f293645k = new CopyOnWriteArraySet();
        this.f293646l = new CopyOnWriteArraySet();
        this.f293647m = new q68.a();
        this.f293648n = "";
        this.f293649o = new b(this);
    }

    @Override // com.larus.avlink.plugins.e1
    public final void v1(String r100) {
        if (com.flow.kmp.common.util.f.a(r100) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.f293641g, r100) == false) goto L7;
        return;
    L7:
        if (this.f293641g.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        com.larus.im.d.e().unregisterOnMessageChangedObserver(this.f293641g, this.f293649o);
    L12:
        if (r100 != null) goto L14;
        r100 = "";
    L14:
        this.f293641g = r100;
        com.larus.im.d.e().registerOnMessageChangedObserver(this.f293641g, this.f293649o);
        return;
    L9:
        r101 = false;
        goto L10
    }

    public static final Object k3(DoraIMPlugin r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof DoraIMPlugin$updateConversationInfo$1) == false) goto L7;
        DoraIMPlugin$updateConversationInfo$1 r102 = (DoraIMPlugin$updateConversationInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L17:
        wc9.e r107 = (wc9.e) r104;
        if (r107 == null) goto L21;
        com.larus.im.d.e().j(new uf9.a.C7879a(r107.f559198a, 50), new d1(r100, r107));
    L21:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        String r108 = r100.f293641g;
        r102.label = 1;
        r104 = AndroidPlatformKt.b(r108, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new DoraIMPlugin$updateConversationInfo$1(r100, r101);
        goto L8
    }

    public static final void j3(DoraIMPlugin r110, String r111, Message r112) {
        if (Intrinsics.areEqual(r111, r110.f293641g) == false) goto L62;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r112, "msg");     // Catch: Throwable -> L54
        RealtimeCallUtil.f379424a.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r112, "msg");     // Catch: Throwable -> L54
        String r100 = "";
        Object r101 = null;
        if (com.larus.bmhome.chat.bean.d.G0(r112) == false) goto L27;
        Map<String, String> r114 = r112.getExt();     // Catch: Throwable -> L54
        if (r114 == null) goto L11;
        String r115 = r114.get("local_call_id");     // Catch: Throwable -> L54
    L13:
        if (Intrinsics.areEqual(r115, r110.getContext().params().f288745e) == false) goto L27;
        String r116 = r112.getMessageId();     // Catch: Throwable -> L54
        if (r116 == null) goto L18;
        r100 = r116;
    L18:
        com.larus.avlink.n1.d(r110.f293640f, "Query msgId=" + r112.getMessageId());     // Catch: Throwable -> L54
        ((CopyOnWriteArraySet) r110.f293642h).add(r100);     // Catch: Throwable -> L54
        q68.a<String, Long> r117 = r110.f293647m;     // Catch: Throwable -> L54
        r117.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L54
        if (r117.f531866a.get(r100) == null) goto L25;
        IRealtimeCallTracer r102 = r110.getContext().k();     // Catch: Throwable -> L54
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L54
        q68.a<String, Long> r118 = r110.f293647m;     // Catch: Throwable -> L54
        r118.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L54
        Long r119 = r118.f531866a.get(r100);     // Catch: Throwable -> L54
        if (r119 == null) goto L23;
        long r120 = r119.longValue();     // Catch: Throwable -> L54
    L24:
        r102.h0(r103, r120, r110.getContext().params().f288755o.f288899a, r110.getContext().params().f288751k.f288831t);     // Catch: Throwable -> L54
        q68.a<String, Long> r121 = r110.f293647m;     // Catch: Throwable -> L54
        r121.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L54
        r101 = r121.f531866a.remove(r100);     // Catch: Throwable -> L54
    L51:
        Object r122 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L54
    L56:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L61;
        com.larus.avlink.n1.b(r110.f293640f, "onReceiveMessage error: " + r123.getMessage());
        return;
    L61:
        return;
    L23:
        r120 = 0;
        goto L24
    L25:
        q68.a<String, Long> r124 = r110.f293647m;     // Catch: Throwable -> L54
        Long r125 = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L54
        r124.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r100, "key");     // Catch: Throwable -> L54
        r124.f531866a.put(r100, r125);     // Catch: Throwable -> L54
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L54
        goto L51
    L11:
        r115 = null;
    L27:
        if (com.larus.im.bean.message.a.r0(r112) == false) goto L29;
    L52:
        com.larus.avlink.n1.d(r110.f293640f, "msgStatusLocal=" + r112.getMessageStatusLocal() + ", isServerLoading=" + com.larus.im.bean.message.a.r0(r112) + ", msgStatus=" + r112.getMessageStatus());     // Catch: Throwable -> L54
        return;
    L29:
        if (r112.getMessageStatusLocal() == (-1)) goto L52;
        MessageStatus r126 = r112.getMessageStatus();     // Catch: Throwable -> L54
        if (r126 == null) goto L35;
        boolean r104 = true;
        if (r126.isVisible() != true) goto L35;
    L36:
        if (r104 == false) goto L52;
        if (CollectionsKt.contains(r110.f293642h, r112.getReplyId()) == false) goto L50;
        com.larus.avlink.n1.d(r110.f293640f, "msgId=" + r112.getMessageId() + ", replyId=" + r112.getReplyId() + ", state=" + r112.getMessageStatus());     // Catch: Throwable -> L54
        String r127 = r112.getMessageId();     // Catch: Throwable -> L54
        if (r127 == null) goto L43;
        ((CopyOnWriteArraySet) r110.f293643i).add(r127);     // Catch: Throwable -> L54
    L43:
        String r128 = r112.getReplyId();     // Catch: Throwable -> L54
        if (r128 == null) goto L51;
        q68.a<String, String> r105 = r110.f293644j;     // Catch: Throwable -> L54
        String r129 = r112.getMessageId();     // Catch: Throwable -> L54
        if (r129 == null) goto L49;
        r100 = r129;
    L49:
        r105.getClass();     // Catch: Throwable -> L54
        Intrinsics.checkNotNullParameter(r128, "key");     // Catch: Throwable -> L54
        r105.f531866a.put(r128, r100);     // Catch: Throwable -> L54
    L50:
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L35:
        r104 = false;
    L54:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    }
}
