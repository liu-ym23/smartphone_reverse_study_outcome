package com.larus.suggest.impl.wcb.policy;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class MainConversationDisplayFrequencyPolicy implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MainConversationDisplayFrequencyPolicy f369952a = null;

    public static final class a implements IIMCallback<List<? extends Message>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<s> f369953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hx9.l f369954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f369955c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            FLogger.f375446a.e("WcbLog", "checkMsgInterval getMessageListFromLocal failed, error: " + r100);
            if (this.f369953a.isActive() == false) goto L6;
            kotlinx.coroutines.i<s> r101 = this.f369953a;
            Result.Companion r102 = Result.Companion;
            MainConversationDisplayFrequencyPolicy r103 = MainConversationDisplayFrequencyPolicy.f369952a;
            r101.resumeWith(Result.m9449constructorimpl(MainConversationDisplayFrequencyPolicy.b(this.f369954b.c(), this.f369955c)));
            return;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(List<? extends Message> r100) {
            List<? extends Message> r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            FLogger.f375446a.w("WcbLog", "checkMsgInterval getMessageListFromLocal success, size = " + r101.size());
            if (this.f369953a.isActive() == false) goto L6;
            kotlinx.coroutines.i<s> r102 = this.f369953a;
            Result.Companion r103 = Result.Companion;
            MainConversationDisplayFrequencyPolicy r104 = MainConversationDisplayFrequencyPolicy.f369952a;
            r102.resumeWith(Result.m9449constructorimpl(MainConversationDisplayFrequencyPolicy.b(r101, this.f369955c)));
            return;
        }

        public a(kotlinx.coroutines.j r100, hx9.l r101, long r102) {
            this.f369953a = r100;
            this.f369954b = r101;
            this.f369955c = r102;
        }
    }

    static {
        f369952a = new MainConversationDisplayFrequencyPolicy();
    }

    public MainConversationDisplayFrequencyPolicy() {
    }

    public static final s b(List r110, long r111) {
        List r100 = r110;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L139;
        List r112 = r110;
        ArrayList r103 = new ArrayList();
        Iterator r104 = r112.iterator();
    L13:
        if (r104.hasNext() == false) goto L49;
        Object r105 = r104.next();
        Message r106 = (Message) r105;
        if (com.larus.bmhome.social.userchat.model.b0.f(r106) == false) goto L17;
    L46:
        boolean r107 = false;
    L47:
        if (r107 == false) goto L13;
        r103.add(r105);
        goto L13
    L17:
        if (com.larus.bmhome.chat.bean.d.W0(r106) == true) goto L46;
        if (com.larus.bmhome.chat.bean.d.i0(r106) == false) goto L24;
        if (com.larus.bmhome.chat.bean.d.w(r106) == true) goto L24;
    L43:
        boolean r108 = false;
    L44:
        if (r108 == false) goto L46;
        r107 = true;
    L24:
        if (com.larus.bmhome.chat.bean.d.T(r106) == true) goto L43;
        if (com.larus.bmhome.chat.bean.d.p0(r106) == true) goto L43;
        if (com.larus.bmhome.chat.bean.d.C0(r106) == true) goto L31;
    L33:
        MessageStatus r109 = r106.getMessageStatus();
        if (r109 != null) goto L36;
    L38:
        boolean r113 = false;
    L39:
        if (r113 == false) goto L41;
    L42:
        r108 = true;
        goto L44
    L41:
        if (com.larus.bmhome.social.userchat.model.b0.f(r106) == false) goto L43;
    L36:
        if (r109.isVisible() != true) goto L38;
        r113 = true;
        goto L39
    L31:
        if (r106.getRegenVisible() == true) goto L33;
    L49:
        String r114 = null;
        if ((!r103.isEmpty()) == false) goto L52;
        ArrayList r115 = r103;
    L54:
        if (r115 == null) goto L65;
        Iterator r116 = r115.iterator();
        if (r116.hasNext() == false) goto L64;
        long r117 = ((Message) r116.next()).getCreateTime();
    L59:
        if (r116.hasNext() == false) goto L66;
        long r118 = ((Message) r116.next()).getCreateTime();
        if (r117 >= r118) goto L59;
        r117 = r118;
    L66:
        Iterator r119 = r112.iterator();
    L68:
        if (r119.hasNext() == false) goto L102;
        Object r120 = r119.next();
        Message r121 = (Message) r120;
        if (com.larus.bmhome.chat.bean.d.i0(r121) == false) goto L75;
        if (com.larus.bmhome.chat.bean.d.w(r121) == true) goto L75;
    L94:
        boolean r122 = false;
    L95:
        if (r122 == true) goto L97;
    L99:
        boolean r123 = false;
    L100:
        if (r123 == false) goto L68;
    L103:
        Message r124 = (Message) r120;
        FLogger r125 = FLogger.f375446a;
        StringBuilder r126 = new StringBuilder("check message interval, latestMsgTime=");
        r126.append(r117);
        r126.append(" validMsgSize=");
        r126.append(r103.size());
        r126.append(" lastVisibleMsg=");
        if (r124 == null) goto L106;
        r114 = gx9.p.b(r124);
    L106:
        r126.append(r114);
        r125.i("WcbLog", r126.toString());
        if (r124 != null) goto L109;
    L111:
        if (r101 == false) goto L114;
        return new s.b("checkMsgInterval last msg firstMet");
    L114:
        if (r117 <= 0) goto L119;
        long r127 = (AppHost.f326268a.getAppClock().currentTimeMillis() / 1000) - r117;
        r125.w("WcbLog", "check message interval, msgInterval=" + r127 + ", controlInterval=" + r111);
        if (r127 <= r111) goto L142;
        return s.a.f370004a;
    L142:
        return new s.b("checkMsgInterval within controlInterval");
    L119:
        r125.e("WcbLog", "checkMsgInterval invalid latestMsgTime, validMessages=" + r103.size());
        if (r103.isEmpty() == false) goto L123;
        return s.a.f370004a;
    L123:
        return new s.b("checkMsgInterval invalid latestMsgTime");
    L109:
        if (com.larus.bmhome.chat.bean.d.k0(r124) != true) goto L111;
        r101 = true;
        goto L111
    L97:
        if (com.larus.bmhome.social.userchat.model.b0.f(r121) == true) goto L99;
        r123 = true;
    L75:
        if (com.larus.bmhome.chat.bean.d.T(r121) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.p0(r121) == true) goto L94;
        if (com.larus.bmhome.chat.bean.d.C0(r121) == true) goto L82;
    L84:
        MessageStatus r128 = r121.getMessageStatus();
        if (r128 != null) goto L87;
    L89:
        boolean r129 = false;
    L90:
        if (r129 == false) goto L92;
    L93:
        r122 = true;
        goto L95
    L92:
        if (com.larus.bmhome.social.userchat.model.b0.f(r121) == false) goto L94;
    L87:
        if (r128.isVisible() != true) goto L89;
        r129 = true;
        goto L90
    L82:
        if (r121.getRegenVisible() == true) goto L84;
    L102:
        r120 = null;
        goto L103
    L64:
        throw new NoSuchElementException();
    L65:
        r117 = 0;
        goto L66
    L52:
        r115 = null;
        goto L54
    L139:
        return new s.b("checkMsgInterval messageList empty");
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.larus.suggest.impl.wcb.policy.t
    public final Object a(com.larus.suggest.impl.wcb.request.f r210, hx9.l r211, Continuation<? super s> r212) {
        hx9.l r100 = r211;
        if ((r212 instanceof MainConversationDisplayFrequencyPolicy$evaluate$1) == false) goto L7;
        MainConversationDisplayFrequencyPolicy$evaluate$1 r101 = (MainConversationDisplayFrequencyPolicy$evaluate$1) r212;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        MessageListRequest r106 = (MessageListRequest) r101.L$1;
        hx9.l r107 = (hx9.l) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L28:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (hx9.l) r101.L$1;
        com.larus.suggest.impl.wcb.request.f r108 = (com.larus.suggest.impl.wcb.request.f) r101.L$0;
        ResultKt.throwOnFailure(r103);
        com.larus.suggest.impl.wcb.request.f r109 = r108;
    L19:
        long r110 = r109.f370118f.f370099a.h().g(r109);
        if (r110 > 0) goto L23;
        FLogger.f375446a.i("WcbLog", "[DisplayFrequencyPolicy] invalid control interval, direct consume nex pulse");
        return s.a.f370004a;
    L23:
        MessageListRequest r111 = new MessageListRequest(r109.f370114b, 0, 0, 10, 0, null, false, 118, null);
        r101.L$0 = r100;
        r101.L$1 = r111;
        r101.J$0 = r110;
        r101.label = 2;
        kotlinx.coroutines.j r112 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r112.C();
        com.larus.im.d.e().getMessageListFromLocal(r111, new a(r112, r100, r110));
        r103 = r112.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L26:
        if (r103 != r104) goto L28;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
        r109 = r210;
        r101.L$0 = r109;
        r101.L$1 = r100;
        r101.label = 1;
        if (r100.i(r101) != r104) goto L19;
        return r104;
    L7:
        r101 = new MainConversationDisplayFrequencyPolicy$evaluate$1(this, r212);
        goto L8
    }
}
