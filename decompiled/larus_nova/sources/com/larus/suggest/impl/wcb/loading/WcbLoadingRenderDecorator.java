package com.larus.suggest.impl.wcb.loading;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.suggest.impl.wcb.render.i;
import com.larus.suggest.impl.wcb.render.k;
import com.larus.suggest.impl.wcb.render.n;
import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.suggest.impl.wcb.render.r;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.suggest.impl.wcb.request.f;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import hx9.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: classes31.dex */
public final class WcbLoadingRenderDecorator implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f369926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f369927b;

    public final class LoadingTransaction implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f369928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f369929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f369930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ WcbLoadingRenderDecorator f369931d;

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void c() {
            b r100 = this.f369929b;
            boolean r101 = false;
            if (r100.f369946n == false) goto L6;
            r100.f369946n = false;
            r101 = true;
        L6:
            if (r101 == false) goto L9;
            this.f369931d.f369927b.x4();
            return;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final boolean isActive() {
            if (this.f369928a.isActive() == false) goto L7;
            ConcurrentHashMap<Long, b> r100 = c.f369948a;
            if (Intrinsics.areEqual(c.a(this.f369929b.f369933a), this.f369929b) == false) goto L7;
            return true;
        L7:
            return false;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void cancel() {
            d(this);
            this.f369928a.cancel();
        }

        public static void d(LoadingTransaction r100) {
            r100.getClass();
            ConcurrentHashMap<Long, b> r101 = c.f369948a;
            b r102 = r100.f369929b;
            if (c.b(r102.f369933a, r102.f369934b) == false) goto L6;
            r100.f369931d.f369927b.x4();
            return;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object b(Continuation<? super Unit> r100) {
            if ((r100 instanceof WcbLoadingRenderDecorator$LoadingTransaction$finish$1) == false) goto L7;
            WcbLoadingRenderDecorator$LoadingTransaction$finish$1 r101 = (WcbLoadingRenderDecorator$LoadingTransaction$finish$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(r101.label) {
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            Throwable r105 = (Throwable) r101.L$0;
            ResultKt.throwOnFailure(r103);
            throw r105;
        L13:
            ResultKt.throwOnFailure(r103);
        L56:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L19
        L51:
            d(this);     // Catch: Throwable -> L19
        L52:
            q r106 = this.f369928a;
            r101.label = 5;
            if (r106.b(r101) != r104) goto L56;
            return r104;
        L16:
            Unit r107 = (Unit) r101.L$0;
            ResultKt.throwOnFailure(r103);
            return r107;
        L17:
            ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L19
        L40:
            if (isActive() == true) goto L47;
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L19
            q r109 = this.f369928a;
            r101.L$0 = r108;
            r101.label = 3;
            if (r109.b(r101) != r104) goto L46;
            return r104;
        L46:
            return r108;
        L47:
            d(this);     // Catch: Throwable -> L19
            goto L52
        L21:
            Unit r110 = (Unit) r101.L$0;
            ResultKt.throwOnFailure(r103);
            return r110;
        L22:
            ResultKt.throwOnFailure(r103);
            if (isActive() == true) goto L32;
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L19
            q r112 = this.f369928a;
            r101.L$0 = r111;
            r101.label = 1;
            if (r112.b(r101) != r104) goto L30;
            return r104;
        L30:
            return r111;
        L32:
            if (this.f369930c == false) goto L48;
            b r113 = this.f369929b;     // Catch: Throwable -> L19
            r101.label = 2;     // Catch: Throwable -> L19
            Object r114 = r113.f369947o.await(r101);     // Catch: Throwable -> L19
            if (r114 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
            r114 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L37:
            if (r114 != r104) goto L40;
            return r104;
        L48:
            r101.label = 4;     // Catch: Throwable -> L19
            if (e(r101) != r104) goto L51;
            return r104;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            th = move-exception;
            q r115 = this.f369928a;
            r101.L$0 = th;
            r101.label = 6;
            if (r115.b(r101) != r104) goto L61;
            return r104;
        L61:
            throw th;
        L7:
            r101 = new WcbLoadingRenderDecorator$LoadingTransaction$finish$1(this, r100);
            goto L8
        }

        public final Object e(Continuation<? super Boolean> r100) {
            if ((r100 instanceof WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1) == false) goto L7;
            WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1 r101 = (WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L25:
            n r106 = (n) r103;
            if (isActive() == true) goto L30;
            return Boxing.boxBoolean(false);
        L30:
            if ((r106 instanceof n.a) == false) goto L33;
            FLogger.f375446a.w("WcbLog", ((n.a) r106).f370062a);
        L33:
            return Boxing.boxBoolean(true);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            if (isActive() == false) goto L17;
            String r107 = this.f369929b.f369938f;
            if (r107 == null) goto L21;
            q r108 = this.f369928a;
            com.larus.suggest.impl.wcb.render.l.b r109 = new com.larus.suggest.impl.wcb.render.l.b(new p(r107));
            r101.label = 1;
            r103 = r108.a(r109, r101);
            if (r103 != r104) goto L25;
            return r104;
        L21:
            return Boxing.boxBoolean(true);
        L17:
            return Boxing.boxBoolean(false);
        L7:
            r101 = new WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1(this, r100);
            goto L8
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object a(com.larus.suggest.impl.wcb.render.l r100, Continuation<? super n> r101) {
            if ((r101 instanceof WcbLoadingRenderDecorator$LoadingTransaction$render$1) == false) goto L7;
            WcbLoadingRenderDecorator$LoadingTransaction$render$1 r102 = (WcbLoadingRenderDecorator$LoadingTransaction$render$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            n r107 = (n) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L38:
            if (((Boolean) r104).booleanValue() == true) goto L40;
            return r107;
        L40:
            n r108 = r107;
        L41:
            this.f369930c = true;
            b r109 = this.f369929b;
            n.b r110 = (n.b) r108;
            r109.getClass();
            Intrinsics.checkNotNullParameter(r110, "submission");
            r109.f369945m = r110;
            this.f369931d.f369927b.x4();
        L42:
            return r108;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r100 = (com.larus.suggest.impl.wcb.render.l) r102.L$0;
            ResultKt.throwOnFailure(r104);
        L26:
            r108 = (n) r104;
            if ((r108 instanceof n.b) == false) goto L42;
            if (isActive() == false) goto L42;
            if ((r100 instanceof com.larus.suggest.impl.wcb.render.l.a) == false) goto L41;
            r102.L$0 = r108;
            r102.label = 2;
            Object r111 = e(r102);
            if (r111 != r105) goto L36;
            return r105;
        L36:
            r104 = r111;
            r107 = r108;
            goto L38
        L16:
            ResultKt.throwOnFailure(r104);
            if (isActive() == true) goto L21;
            return new n.a("wcb render transaction inactive");
        L21:
            if ((r100 instanceof com.larus.suggest.impl.wcb.render.l.a) == false) goto L23;
            String r112 = this.f369929b.f369939g;
            i r113 = ((com.larus.suggest.impl.wcb.render.l.a) r100).f370056a;
            Intrinsics.checkNotNullParameter(r113, "presentation");
            r100 = new com.larus.suggest.impl.wcb.render.l.a(r113, r112);
        L23:
            q r114 = this.f369928a;
            r102.L$0 = r100;
            r102.label = 1;
            r104 = r114.a(r100, r102);
            if (r104 != r105) goto L26;
            return r105;
        L7:
            r102 = new WcbLoadingRenderDecorator$LoadingTransaction$render$1(this, r101);
            goto L8
        }

        public LoadingTransaction(WcbLoadingRenderDecorator r100, q r101, b r102) {
            Intrinsics.checkNotNullParameter(r101, "delegate");
            Intrinsics.checkNotNullParameter(r102, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
            this.f369931d = r100;
            this.f369928a = r101;
            this.f369929b = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    public static boolean b(f r100) {
        if (r100.f370118f.f370099a.getKey().f511241a != WcbSurface.NEW_CONVERSATION) goto L9;
        com.larus.suggest.impl.wcb.request.c r101 = r100.f370118f;
        if (r101.f370100b != WcbRequestTrigger.INITIAL) goto L9;
        if (r101.f370099a.getKey().f511242b != WcbMode.QUICK_EXPERT) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.suggest.impl.wcb.render.r
    public final q a(k r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        q r100 = this.f369926a.a(r210);
        com.larus.suggest.impl.wcb.request.c r101 = r210.f370053a.f370118f;
        if (Intrinsics.areEqual(r210.f370055c, a0.c.f369959a) == true) goto L6;
    L45:
        boolean r102 = false;
    L46:
        if (r102 == true) goto L48;
        return r100;
    L48:
        f r103 = r210.f370053a;
        p r104 = r103.f370118f.f370103e;
        if (r104 == null) goto L53;
        String r105 = r104.f370069a;
        if (r105 == null) goto L53;
        String r106 = StringsKt.removeSuffix(r105, ":fake_message:1");
    L54:
        boolean r107 = r103.f370118f.f370099a.e().a(this.f369927b).f370047a;
        if (r106 == null) goto L58;
        if (r107 == false) goto L58;
        String r108 = r106;
    L59:
        if (r106 == null) goto L71;
        Iterator r110 = SequencesKt.flattenSequenceOfIterable(SequencesKt.sequenceOf(new List[]{this.f369927b.c(), this.f369927b.g()})).iterator();
    L62:
        if (r110.hasNext() == false) goto L69;
        Object r111 = r110.next();
        String r112 = ((Message) r111).getLocalMessageId();
        if (r112 != null) goto L67;
        r112 = "";
    L67:
        if (Intrinsics.areEqual(StringsKt.removeSuffix(r112, ":fake_message:1"), r106) == false) goto L62;
    L70:
        Message r113 = (Message) r111;
    L72:
        long r109 = r103.f370116d;
        long r114 = r103.f370117e;
        String r115 = r103.f370114b;
        String r116 = r103.f370115c;
        int r117 = r103.f370118f.f370104f;
        if (Intrinsics.areEqual(r108, r106) == false) goto L84;
        if (r113 == null) goto L78;
        long r211 = r114;
        if (r113.getContentType() != 2) goto L79;
        boolean r118 = true;
    L80:
        if (r118 == false) goto L85;
        String r119 = r113.getLocalMessageId();
        if (r119 != null) goto L86;
        r119 = "";
    L86:
        Iterator r120 = this.f369927b.c().iterator();
    L88:
        if (r120.hasNext() == false) goto L125;
        Object r121 = r120.next();
        Message r122 = (Message) r121;
        if (com.larus.bmhome.chat.bean.d.i0(r122) == false) goto L95;
        if (com.larus.bmhome.chat.bean.d.w(r122) == true) goto L95;
    L115:
        Iterator r212 = r120;
        Object r123 = r121;
    L116:
        boolean r124 = false;
    L117:
        if (r124 == true) goto L119;
    L121:
        boolean r125 = false;
    L122:
        if (r125 == true) goto L126;
        r120 = r212;
    L126:
        Message r126 = (Message) r123;
        if (r126 == null) goto L129;
        String r213 = r126.getLocalMessageId();
    L130:
        e r127 = this.f369927b.O8();
        if (r127 == null) goto L133;
        String r214 = r127.B;
    L134:
        if (r113 == null) goto L136;
        String r128 = com.larus.bmhome.chat.bean.d.x(r113).getWcbTitle();
    L137:
        if (r128 != null) goto L139;
        String r215 = "";
    L141:
        if (b(r103) == false) goto L143;
        int r216 = 1;
    L150:
        b r129 = new b(r109, r211, r115, r116, r117, r106, r108, r119, r213, r214, r215, r216);
        LoadingTransaction r130 = new LoadingTransaction(this, r100, r129);
        ConcurrentHashMap<Long, b> r131 = c.f369948a;
        Intrinsics.checkNotNullParameter(r129, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        b r132 = c.f369948a.put(Long.valueOf(r129.f369933a), r129);
        if (r132 == null) goto L153;
        r132.f369947o.complete(Unit.INSTANCE);
    L153:
        this.f369927b.x4();
        return r130;
    L143:
        if (r113 == null) goto L149;
        String r133 = (String) com.larus.bmhome.chat.bean.d.x(r113).get("wcb_title_style");
        if (r133 == null) goto L149;
        Integer r134 = StringsKt.toIntOrNull(r133);
        if (r134 == null) goto L149;
        r216 = r134.intValue();
    L149:
        r216 = 0;
        goto L150
    L139:
        r215 = r128;
        goto L141
    L136:
        r128 = null;
        goto L137
    L133:
        r214 = null;
        goto L134
    L129:
        r213 = null;
        goto L130
    L119:
        if (b0.f(r122) == true) goto L121;
        r125 = true;
    L95:
        if (com.larus.bmhome.chat.bean.d.T(r122) == true) goto L115;
        if (com.larus.bmhome.chat.bean.d.p0(r122) == true) goto L115;
        if (com.larus.bmhome.chat.bean.d.C0(r122) == true) goto L102;
    L104:
        MessageStatus r135 = r122.getMessageStatus();
        r212 = r120;
        if (r135 == null) goto L109;
        boolean r136 = r135.isVisible();
        r123 = r121;
        if (r136 != true) goto L110;
        boolean r137 = true;
    L111:
        if (r137 == false) goto L113;
    L114:
        r124 = true;
        goto L117
    L113:
        if (b0.f(r122) == false) goto L116;
    L110:
        r137 = false;
        goto L111
    L109:
        r123 = r121;
        goto L110
    L102:
        if (r122.getRegenVisible() == true) goto L104;
    L125:
        r123 = null;
    L85:
        r119 = r108 + ":fake_message:1";
    L79:
        r118 = false;
        goto L80
    L78:
        r211 = r114;
        goto L79
    L84:
        r211 = r114;
        goto L85
    L69:
        r111 = null;
        goto L70
    L71:
        r113 = null;
    L58:
        int r138 = wf9.b.f559489a;
        r108 = com.flow.kmp.common.util.i.a();
    L53:
        r106 = null;
        goto L54
    L6:
        if (b(r210.f370053a) == false) goto L9;
    L44:
        r102 = true;
        goto L46
    L9:
        if (r101.f370100b != WcbRequestTrigger.MODE_SWITCH) goto L45;
        p r139 = r101.f370103e;
        if (r139 == null) goto L45;
        String r140 = r139.f370069a;
        if (r140 == null) goto L45;
        String r141 = StringsKt.removeSuffix(r140, ":fake_message:1");
        if (r141 == null) goto L45;
        Iterator<T> r142 = this.f369927b.g().iterator();
    L20:
        if (r142.hasNext() == false) goto L36;
        Object r143 = r142.next();
        Message r144 = (Message) r143;
        if (Intrinsics.areEqual(r144.getConversationId(), r210.f370053a.f370114b) == false) goto L33;
        String r145 = r144.getLocalMessageId();
        if (r145 != null) goto L27;
        r145 = "";
    L27:
        if (Intrinsics.areEqual(StringsKt.removeSuffix(r145, ":fake_message:1"), r141) == false) goto L33;
        if (r144.getContentType() != 2) goto L33;
        if (gx9.p.a(r144) == false) goto L33;
        boolean r146 = true;
    L34:
        if (r146 == false) goto L20;
    L37:
        Message r147 = (Message) r143;
        if (r147 == null) goto L45;
        PromptContent r148 = com.larus.bmhome.chat.bean.d.i1(r147, null, 3);
        if (r148.isEmpty() == true) goto L45;
        if (Intrinsics.areEqual(r148.getWcbRenderStatus(), WcbRenderStatus.DEPRECATED) == true) goto L45;
    L33:
        r146 = false;
        goto L34
    L36:
        r143 = null;
        goto L37
    }

    public WcbLoadingRenderDecorator(r r100, hx9.a r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f369926a = r100;
        this.f369927b = r101;
    }
}
