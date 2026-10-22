package com.larus.bmhome.chat.component.regen;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.adapter.p0;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.list.cell.text.TextCellCutType;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import va8.q;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\f\u0010\u0014\u001a\u00020\u0011*\u00020\u0013H\u0002J\u0016\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010\u0019\u001a\u00020\u0016*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010\u001a\u001a\u00020\u0016*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010-\u001a\u00020\u0016H\u0016J\u0012\u0010.\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u00100\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u0011H\u0016J\u0016\u00105\u001a\u00020\u00162\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001307H\u0016J\u001c\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u00172\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0013H\u0002J8\u0010:\u001a\u0004\u0018\u00010\u00162\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000f072\b\b\u0002\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010>J \u0010?\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0006R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+¨\u0006B"}, d2 = {"Lcom/larus/bmhome/chat/component/regen/RegenAnswerComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "Lcom/larus/bmhome/chat/component/regen/IRegenAnswerAbility;", "Lcom/larus/bmhome/ability/IChatRegenCoreAbility;", "<init>", "()V", "resetJob", "Lkotlinx/coroutines/Job;", "regenAnswersLive", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/bmhome/chat/component/regen/RegenAnswersData;", "kotlin.jvm.PlatformType", "getRegenAnswersLive$annotations", "hasActionId", "", "hasAction", "", "message", "Lcom/larus/im/bean/message/Message;", "shouldSkipForLastAction", "notifyActionItemChanged", "", "Lcom/larus/bmhome/chat/adapter/MessageAdapter;", "actionId", "notifyActionItemChangedWhenUseWholeCell", "notifyActionItemChangedWhenCutThreeCell", "noRegenAction", "getNoRegenAction", "()Z", "nextIndex", "", "getNextIndex", "()I", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "Lkotlin/Lazy;", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "onAttach", "canShowRegenerateBtn", "reply", "isRegenerateValid", "isRegenerate", "isEmptyTxt", "updateHasAction", "force", "updateHasActionWithPrefetchMessageList", "msgList", "", "resetByReply", "adapter", "updateRegenAnswersData", com.bytedance.android.ec.core.event.a.VALUE_QUESTION, "selected", "answers", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canShowRegenerate", "isConversationEnable", "isLongAction", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RegenAnswerComponent extends ComponentFeature implements a, q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f301430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<h> f301431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f301432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f301433k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f301434l;

    @Override // com.larus.bmhome.chat.component.regen.a
    public final boolean DO() {
        h r100 = this.f301431i.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f301447d;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, a.class);
    }

    public RegenAnswerComponent() {
        this.f301431i = new MutableLiveData(new h("", "", CollectionsKt.emptyList(), false));
        this.f301433k = LazyKt.lazy(new c(this));
        this.f301434l = LazyKt.lazy(new d(this));
    }

    public static boolean P2(Message r100) {
        Integer r101 = b0.c(r100);
        if (r101 != null) goto L6;
    L7:
        if (r101 != null) goto L10;
    L11:
        if (r101 != null) goto L14;
    L16:
        return false;
    L14:
        if (r101.intValue() != 15) goto L16;
    L17:
        return true;
    L10:
        if (r101.intValue() == 14) goto L17;
    L6:
        if (r101.intValue() == 13) goto L17;
        goto L7
    }

    @Override // com.larus.bmhome.chat.component.regen.a
    public final boolean DL(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        h r101 = this.f301431i.getValue();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.a(r100) != true) goto L7;
        return true;
    }

    public final boolean F2(Message r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        int r102 = r100.getContentType();     // Catch: Throwable -> L14
        if (r102 != 1) goto L6;
    L8:
        String r103 = com.larus.bmhome.chat.bean.d.r(r100);     // Catch: Throwable -> L14
        if (r103 == null) goto L12;
        if (r103.length() == 0) goto L12;
        return false;
    L12:
        return true;
    L6:
        if (r102 == 9999) goto L8;
        return false;
    L14:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Throwable r105 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r105 == null) goto L18;
        FLogger.f375446a.i("RegenAnswerComponent", r105.toString());
    L18:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.regen.a
    public final boolean gB(Message r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getConversationId();
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("canShowRegenerateBtn msgId=");
        r103.append(r100.getMessageId());
        r103.append(" localMsgId=");
        r103.append(r100.getLocalMessageId());
        r103.append(" replyId=");
        r103.append(r100.getReplyId());
        r103.append(" localIndex=");
        r103.append(r100.getLocalIndex());
        r103.append(" lastActionIndex=");
        p0 r104 = p0.f297111a;
        r103.append(p0.b(r101));
        r103.append(" lastReplyId=");
        r103.append(p0.c(r101));
        r103.append(" isClearContext=");
        r103.append(com.larus.bmhome.chat.bean.d.Z(r100));
        r102.i("RegenAnswerComponent", r103.toString());
        if (r100.getLocalIndex() >= p0.b(r101)) goto L13;
        if (Intrinsics.areEqual(r100.getReplyId(), p0.c(r101)) == true) goto L13;
        return false;
    L13:
        if (com.larus.bmhome.chat.bean.d.Z(r100) == true) goto L17;
        return true;
    L17:
        return false;
    }

    @Override // com.larus.bmhome.chat.component.regen.a
    public final boolean nS(Message r100) {
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L5;
    L7:
        h r101 = this.f301431i.getValue();
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.b(r100) != true) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (z2.f365865a.s0() == true) goto L7;
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [com.larus.bmhome.chat.component.regen.b] */
    @Override // com.larus.bmhome.chat.component.regen.a
    public final void qb(boolean r210) {
        u7 r100 = (u7) this.f301434l.getValue();
        if (r100 == null) goto L227;
        final MessageAdapter r101 = r100.MF();
        if (r101 == null) goto L232;
        String r102 = this.f301432j;
        Iterator<T> r103 = r101.getCurrentList().iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if ((!P2((Message) r104)) == false) goto L9;
    L14:
        Message r105 = (Message) r104;
        String r106 = "";
        if (r105 == null) goto L18;
        String r107 = r105.getConversationId();
        if (r107 == null) goto L18;
    L19:
        Iterator<T> r108 = r101.getCurrentList().iterator();
    L21:
        if (r108.hasNext() == false) goto L32;
        Object r110 = r108.next();
        Message r211 = (Message) r110;
        if (P2(r211) == false) goto L25;
    L29:
        boolean r111 = false;
    L30:
        if (r111 == false) goto L21;
    L33:
        Message r112 = (Message) r110;
        Integer[] r109 = {1, 66, 6, 72, 9999, 2022};
        if (r112 != null) goto L36;
    L57:
        Message r113 = null;
    L59:
        if (AppHost.f326268a.isDebug() == false) goto L109;
        FLogger r114 = FLogger.f375446a;
        StringBuilder r115 = new StringBuilder("realLastMsg ");
        if (r105 == null) goto L63;
        String r116 = r105.getMessageId();
    L64:
        r115.append(r116);
        r115.append(' ');
        if (r105 == null) goto L67;
        Integer r117 = Integer.valueOf(r105.getMessageStatusLocal());
    L68:
        r115.append(r117);
        r115.append(' ');
        if (r105 == null) goto L71;
        Integer r118 = Integer.valueOf(r105.getContentType());
    L72:
        r115.append(r118);
        r115.append(' ');
        if (r105 == null) goto L75;
        String r119 = r105.getContent();
    L76:
        r115.append(g2a.d.c(r119));
        r114.d("RegenAnswerComponent", r115.toString());
        StringBuilder r120 = new StringBuilder("lastActionMsg ");
        if (r112 == null) goto L79;
        String r121 = r112.getMessageId();
    L80:
        r120.append(r121);
        r120.append(' ');
        if (r112 == null) goto L83;
        Integer r122 = Integer.valueOf(r112.getMessageStatusLocal());
    L84:
        r120.append(r122);
        r120.append(' ');
        if (r112 == null) goto L87;
        Integer r123 = Integer.valueOf(r112.getContentType());
    L88:
        r120.append(r123);
        r120.append(' ');
        if (r112 == null) goto L91;
        String r124 = r112.getContent();
    L92:
        r120.append(g2a.d.c(r124));
        r114.d("RegenAnswerComponent", r120.toString());
        StringBuilder r125 = new StringBuilder("newLastActionMsg ");
        if (r113 == null) goto L95;
        String r126 = r113.getMessageId();
    L96:
        r125.append(r126);
        r125.append(' ');
        if (r113 == null) goto L99;
        Integer r127 = Integer.valueOf(r113.getMessageStatusLocal());
    L100:
        r125.append(r127);
        r125.append(' ');
        if (r113 == null) goto L103;
        Integer r128 = Integer.valueOf(r113.getContentType());
    L104:
        r125.append(r128);
        r125.append(' ');
        if (r113 == null) goto L107;
        String r129 = r113.getContent();
    L108:
        r125.append(g2a.d.c(r129));
        r114.d("RegenAnswerComponent", r125.toString());
        goto L109
    L107:
        r129 = null;
        goto L108
    L103:
        r128 = null;
        goto L104
    L99:
        r127 = null;
        goto L100
    L95:
        r126 = null;
        goto L96
    L91:
        r124 = null;
        goto L92
    L87:
        r123 = null;
        goto L88
    L83:
        r122 = null;
        goto L84
    L79:
        r121 = null;
        goto L80
    L75:
        r119 = null;
        goto L76
    L71:
        r118 = null;
        goto L72
    L67:
        r117 = null;
        goto L68
    L63:
        r116 = null;
    L109:
        if (r113 == null) goto L112;
        String r130 = r113.getLocalMessageId();
        if (r130 == null) goto L112;
    L113:
        if (r112 != null) goto L115;
    L117:
        boolean r131 = false;
    L118:
        if (r131 == true) goto L127;
        if (r112 != null) goto L121;
    L123:
        boolean r132 = false;
    L124:
        if (r132 == true) goto L127;
    L164:
        r106 = r130;
    L165:
        this.f301432j = r106;
        if (r105 != null) goto L168;
    L170:
        boolean r133 = false;
    L171:
        if (r133 == true) goto L186;
        if (r105 == null) goto L174;
        long r134 = r105.getLocalIndex();
    L175:
        p0 r135 = p0.f297111a;
        long r136 = Math.max(r134, p0.b(r107));
        Intrinsics.checkNotNullParameter(r107, "cvsId");
        Lazy r137 = p0.f297112b;
        ((Keva) r137.getValue()).storeLong("last_action_id_".concat(r107), r136);
        if (r105 == null) goto L186;
        String r138 = r105.getReplyId();
        if (r138 == null) goto L186;
        if (r138.length() <= 0) goto L182;
        boolean r139 = true;
    L183:
        if (r139 == false) goto L186;
        Intrinsics.checkNotNullParameter(r138, "newOne");
        Intrinsics.checkNotNullParameter(r107, "cvsId");
        ((Keva) r137.getValue()).storeString("last_reply_id_".concat(r107), r138);
        goto L186
    L182:
        r139 = false;
        goto L183
    L174:
        r134 = 0;
    L186:
        if (Intrinsics.areEqual(r102, this.f301432j) == false) goto L188;
        if (r210 == true) goto L188;
    L193:
        if (r105 == null) goto L195;
        String r140 = r105.getLocalMessageId();
    L197:
        if (Intrinsics.areEqual(r102, r140) == false) goto L200;
        if (r210 == true) goto L200;
        return;
    L200:
        if (r106.length() <= 0) goto L202;
        boolean r141 = true;
    L203:
        if (r141 == false) goto L205;
        N2(r101, r112);
    L206:
        ChatMessageList r142 = r101.f297036u;
        if (r142 == null) goto L229;
        LifecycleOwner r143 = ViewTreeLifecycleOwner.get(r142);
        if (r143 == null) goto L230;
        this.f301431i.removeObservers(r143);
        if (o0.d(this.f301432j) == false) goto L231;
        this.f301431i.observe(r143, new g(new b(this, r101)));
        return;
    L231:
        return;
    L230:
        return;
    L229:
        return;
    L205:
        N2(r101, null);
        goto L206
    L202:
        r141 = false;
        goto L203
    L195:
        r140 = null;
    L188:
        FLogger r144 = FLogger.f375446a;
        r144.i("RegenAnswerComponent", "updateHasAction " + r102 + ' ' + this.f301432j + ' ' + r210);
        StringBuilder r145 = new StringBuilder("lastMsg ");
        if (r112 == null) goto L191;
        String r146 = r112.getMessageId();
    L192:
        r145.append(r146);
        r144.i("RegenAnswerComponent", r145.toString());
        L2(r101, r102);
        L2(r101, this.f301432j);
        goto L193
    L191:
        r146 = null;
        goto L192
    L168:
        if (r105.getLocalIndex() != Long.MAX_VALUE) goto L170;
        r133 = true;
        goto L171
    L121:
        if (r112.getContentType() != 72) goto L123;
        r132 = true;
    L127:
        Iterator<T> r147 = r101.getCurrentList().iterator();
    L129:
        if (r147.hasNext() == false) goto L151;
        Object r148 = r147.next();
        Message r149 = (Message) r148;
        if (r149.getContentType() != 0) goto L142;
        Map<String, String> r150 = r149.getBusinessExt();
        if (r150 == null) goto L138;
        if (r150.containsKey("is_mock_receiving") != true) goto L138;
        boolean r151 = true;
    L139:
        if (r151 == false) goto L142;
    L147:
        boolean r152 = true;
    L149:
        if (r152 == false) goto L129;
    L152:
        Message r153 = (Message) r148;
        if (r153 == null) goto L155;
        String r154 = r153.getReplyId();
    L157:
        if (Intrinsics.areEqual(r154, r112.getReplyId()) == true) goto L165;
        Integer r155 = b0.c(r153);
        if (r155 == null) goto L164;
        if (r155.intValue() != 0) goto L164;
    L155:
        r154 = null;
    L138:
        r151 = false;
    L142:
        Integer r156 = b0.c(r149);
        if (r156 != null) goto L146;
    L148:
        r152 = false;
        goto L149
    L146:
        if (r156.intValue() != 0) goto L148;
    L151:
        r148 = null;
        goto L152
    L115:
        if (r112.getContentType() != 6) goto L117;
        r131 = true;
    L112:
        r130 = "";
        goto L113
    L36:
        if (ArraysKt.contains(r109, Integer.valueOf(r112.getContentType())) == true) goto L38;
    L54:
        boolean r157 = false;
    L55:
        if (r157 == false) goto L57;
        r113 = r112;
        goto L59
    L38:
        if (r112.getMessageStatusLocal() == 21) goto L44;
        if (r112.getMessageStatusLocal() == 23) goto L44;
        if (com.larus.bmhome.chat.bean.d.d(r112) == false) goto L54;
    L44:
        if (com.larus.bmhome.chat.bean.d.G0(r112) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.z0(r112) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.v(r112) == true) goto L54;
        if (com.larus.bmhome.chat.bean.d.R0(r112) == true) goto L54;
        if (F2(r112) == true) goto L54;
        r157 = true;
        goto L55
    L25:
        if (ArraysKt.contains(new Integer[]{1, 66, 6, 5, 72, 1001, 9999, 2022}, Integer.valueOf(r211.getContentType())) == false) goto L27;
    L28:
        r111 = true;
        goto L30
    L27:
        if (m99.a.f(r211) == false) goto L29;
    L32:
        r110 = null;
    L18:
        r107 = "";
        goto L19
    L13:
        r104 = null;
        goto L14
    L232:
        return;
    }

    @Override // com.larus.bmhome.chat.component.regen.a
    public final boolean tL(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (o0.d(r100.getLocalMessageId()) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getLocalMessageId(), this.f301432j) == true) goto L7;
        return false;
    L7:
        if (com.larus.bmhome.chat.bean.d.J0(r100) == true) goto L26;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.getBusinessExt();
        if (r101 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L20;
        Map<String, String> r103 = r100.getBusinessExt();
        if (r103 == null) goto L18;
        String r104 = r103.get("message_collect_mode");
    L19:
        boolean r105 = Intrinsics.areEqual(r104, "1");
    L21:
        if (r105 == true) goto L27;
        return true;
    L27:
        return false;
    L18:
        r104 = null;
        goto L19
    L20:
        r105 = false;
        goto L21
    L11:
        if (r101.containsKey("message_collect_mode") != true) goto L13;
        r102 = true;
        goto L14
    L26:
        return false;
    }

    public static void L2(final MessageAdapter r100, String r101) {
        TextCellCutType.Companion.getClass();
        final int r102 = 0;
        if (TextCellCutType.NewTextCell != TextCellCutType.NewCutThreeTextCell) goto L24;
        if (r101 == null) goto L53;
        ArrayList r103 = new ArrayList();
        Iterator r104 = ((ArrayList) r100.getCurrentList()).iterator();
    L8:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        int r106 = r102 + 1;
        if (r102 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        if (Intrinsics.areEqual(((Message) r105).getLocalMessageId(), r101) == false) goto L15;
        r103.add(Integer.valueOf(r102));
    L15:
        r102 = r106;
        goto L8
    L16:
        Iterator r107 = r103.iterator();
    L18:
        if (r107.hasNext() == false) goto L55;
        final int r108 = ((Number) r107.next()).intValue();
        if (r108 < 0) goto L18;
        ChatMessageList r109 = r100.f297036u;
        if (r109 == null) goto L18;
        r109.post(new f(r100, r108));
        goto L18
    L55:
        return;
    L53:
        return;
    L24:
        if (r101 == null) goto L54;
        Iterator r110 = ((ArrayList) r100.getCurrentList()).iterator();
    L28:
        if (r110.hasNext() == false) goto L33;
        if (Intrinsics.areEqual(((Message) r110.next()).getLocalMessageId(), r101) == true) goto L34;
        r102 = r102 + 1;
    L34:
        if (r102 < 0) goto L51;
        ChatMessageList r111 = r100.f297036u;
        if (r111 == null) goto L52;
        r111.post(new e(r100, r102));
        return;
    L52:
        return;
    L51:
        return;
    L33:
        r102 = -1;
        goto L34
    }

    public final void N2(MessageAdapter r100, Message r110) {
        Job r101 = this.f301430h;
        if (r101 == null) goto L5;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L5:
        this.f301430h = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new RegenAnswerComponent$resetByReply$1(r110, this, r100, null), 3, null);
    }

    @Override // com.larus.bmhome.chat.component.regen.a, va8.q
    public final boolean Z2(Message r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (tL(r100) == true) goto L5;
    L11:
        boolean r102 = false;
    L13:
        if (nS(r100) == true) goto L15;
    L18:
        boolean r103 = false;
    L19:
        if (r102 == false) goto L24;
        if (r103 == false) goto L24;
        if (DO() == true) goto L24;
        return true;
    L24:
        return false;
    L15:
        if (gB(r100) == false) goto L18;
        if (r101 == false) goto L18;
        r103 = true;
        goto L19
    L5:
        if (com.larus.bmhome.chat.bean.d.Q0(r100) == true) goto L11;
        if (com.larus.bmhome.chat.bean.d.P0(r100) == true) goto L11;
        if (com.larus.bmhome.chat.bean.d.r0(r100) == true) goto L11;
        r102 = true;
        goto L13
    }
}
