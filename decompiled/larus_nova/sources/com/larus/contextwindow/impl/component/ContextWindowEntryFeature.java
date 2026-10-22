package com.larus.contextwindow.impl.component;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.contextwindow.api.ContextWindowContainer;
import com.larus.contextwindow.api.ContextWindowEnterFrom;
import com.larus.contextwindow.api.ContextWindowEntryRequest;
import com.larus.contextwindow.api.ContextWindowHiddenReason;
import com.larus.contextwindow.api.ContextWindowMessageSnapshot;
import com.larus.contextwindow.api.ContextWindowMode;
import com.larus.contextwindow.api.ContextWindowSnapshot;
import com.larus.contextwindow.api.IContextWindowUsageService;
import com.larus.contextwindow.impl.data.ContextWindowSnapshotStore;
import com.larus.contextwindow.impl.membership.MembershipQuotaRepository;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import va8.c0;
import wa8.t0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0003/25\b\u0000\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020;H\u0016J\b\u0010=\u001a\u00020\u001bH\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010?\u001a\u00020;H\u0002J\b\u0010@\u001a\u00020;H\u0002J\u0014\u0010A\u001a\u00020%*\u00020\u001b2\u0006\u0010B\u001a\u00020\u001bH\u0002J\u0010\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020EH\u0002J\u0018\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020%H\u0002J\u0013\u0010G\u001a\u00020%*\u0004\u0018\u00010HH\u0002¢\u0006\u0002\u0010IJ\"\u0010J\u001a\u0004\u0018\u00010E2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020E0\"2\b\u0010L\u001a\u0004\u0018\u00010(H\u0002J\f\u0010M\u001a\u00020%*\u00020EH\u0002J<\u0010N\u001a\u00020\u001b2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020%2\b\u0010J\u001a\u0004\u0018\u00010E2\u0006\u0010S\u001a\u00020%2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0016\u0010V\u001a\u00020%*\u00020E2\b\u0010W\u001a\u0004\u0018\u00010(H\u0002J\u0017\u0010X\u001a\u0004\u0018\u00010%2\u0006\u0010D\u001a\u00020EH\u0002¢\u0006\u0002\u0010YR\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020%0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020 08X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010\"08X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/larus/contextwindow/impl/component/ContextWindowEntryFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/contextwindow/api/IContextWindowEntryAbility;", "<init>", "()V", "chatListAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListAbility$delegate", "Lkotlin/Lazy;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "instructionInputAbility", "Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "getInstructionInputAbility", "()Lcom/larus/bmhome/instruction/IInstructionInputAbility;", "instructionInputAbility$delegate", "actionBarAbility", "Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "getActionBarAbility", "()Lcom/larus/bmhome/ability/ICustomActionBarCoreAbility;", "actionBarAbility$delegate", "decision", "Lcom/larus/contextwindow/api/ContextWindowEntryDecision;", "request", "Lcom/larus/contextwindow/api/ContextWindowEntryRequest;", "taskModeLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "actionBarConfigLiveData", "", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "listenersRegistered", "", "sentPromptOfficeModes", "", "", "mainHandler", "Landroid/os/Handler;", "refreshScheduled", "scheduledRefresh", "Ljava/lang/Runnable;", "chatChangedListener", "com/larus/contextwindow/impl/component/ContextWindowEntryFeature$chatChangedListener$1", "Lcom/larus/contextwindow/impl/component/ContextWindowEntryFeature$chatChangedListener$1;", "conversationChangedListener", "com/larus/contextwindow/impl/component/ContextWindowEntryFeature$conversationChangedListener$1", "Lcom/larus/contextwindow/impl/component/ContextWindowEntryFeature$conversationChangedListener$1;", "botChangedListener", "com/larus/contextwindow/impl/component/ContextWindowEntryFeature$botChangedListener$1", "Lcom/larus/contextwindow/impl/component/ContextWindowEntryFeature$botChangedListener$1;", "taskModeObserver", "Landroidx/lifecycle/Observer;", "actionBarConfigObserver", "onParentViewCreated", "", LiveCommonConstants.REASON_ON_DEDTROY, "currentDecision", "currentRequest", "scheduleRefresh", "refreshDecision", "isActionBarEquivalentTo", "other", "rememberSentPromptMode", "message", "Lcom/larus/im/bean/message/Message;", "isOfficeTask", "isSendFailure", "", "(Ljava/lang/Integer;)Z", "latestPrompt", "messages", "currentSectionId", "usesOfficeTaskMode", "retainHistoricalUsageDuringMatchingOfficeStream", "input", "Lcom/larus/contextwindow/api/ContextWindowEvaluationInput;", "evaluatedDecision", "isOfficeTaskMode", "latestPromptUsesOfficeMode", "usageService", "Lcom/larus/contextwindow/api/IContextWindowUsageService;", "matchesReplyId", "replyId", "sentPromptMode", "(Lcom/larus/im/bean/message/Message;)Ljava/lang/Boolean;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowEntryFeature extends ComponentFeature implements v29.c {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f330283z = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f330284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f330285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f330286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f330287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.contextwindow.api.a f330288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ContextWindowEntryRequest f330289m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LiveData<ReplyOption> f330290n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LiveData<List<z0>> f330291o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f330292p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, Boolean> f330293q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Handler f330294r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f330295s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.larus.contextwindow.impl.component.c f330296t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f330297u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f330298v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f330299w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.larus.contextwindow.impl.component.d f330300x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.larus.contextwindow.impl.component.e f330301y;

    public static final class a {
    }

    public static final class b implements y.a<BotModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContextWindowEntryFeature f330302a;

        public b(ContextWindowEntryFeature r100) {
            this.f330302a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(BotModel r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            ContextWindowEntryFeature r101 = this.f330302a;
            int r102 = ContextWindowEntryFeature.f330283z;
            r101.N2();
        }
    }

    public static final class c implements te8.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContextWindowEntryFeature f330303a;

        public c(ContextWindowEntryFeature r100) {
            this.f330303a = r100;
        }

        @Override // te8.c
        public final void A(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ContextWindowEntryFeature r101 = this.f330303a;
            int r102 = ContextWindowEntryFeature.f330283z;
            r101.N2();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // te8.c
        public final void F1(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ContextWindowEntryFeature r101 = this.f330303a;
            int r102 = ContextWindowEntryFeature.f330283z;
            com.larus.bmhome.instruction.g r103 = (com.larus.bmhome.instruction.g) r101.f330286j.getValue();
            String r104 = null;
            if (r103 == null) goto L6;
            ReplyOption r105 = r103.Ql();
            if (r105 == null) goto L6;
        L17:
            int r106 = com.larus.contextwindow.impl.data.d.f330321a;
            LiveData<List<z0>> r107 = r101.f330291o;
            if (r107 == null) goto L20;
            List<z0> r108 = r107.getValue();
        L21:
            if (r108 != null) goto L23;
            r108 = CollectionsKt.emptyList();
        L23:
            boolean r109 = com.larus.contextwindow.impl.data.d.a(r105, r108);
            String r110 = r100.getMessageId();
            if (r110 != null) goto L26;
        L31:
            String r111 = r100.getLocalMessageId();
            if (r111 != null) goto L34;
        L38:
            this.f330303a.N2();
            return;
        L34:
            if ((!StringsKt.isBlank(r111)) == false) goto L36;
            r104 = r111;
        L36:
            if (r104 == null) goto L38;
            r101.f330293q.put(r104, Boolean.valueOf(r109));
            goto L38
        L26:
            if ((!StringsKt.isBlank(r110)) == true) goto L29;
            r110 = null;
        L29:
            if (r110 == null) goto L31;
            r101.f330293q.put(r110, Boolean.valueOf(r109));
            goto L31
        L20:
            r108 = null;
        L6:
            LiveData<ReplyOption> r112 = r101.f330290n;
            if (r112 == null) goto L9;
            r105 = r112.getValue();
        L10:
            if (r105 != null) goto L17;
            com.larus.bmhome.instruction.g r113 = (com.larus.bmhome.instruction.g) r101.f330286j.getValue();
            if (r113 == null) goto L16;
            MutableLiveData r114 = r113.zU();
            if (r114 == null) goto L16;
            r105 = (ReplyOption) r114.getValue();
        L16:
            r105 = null;
            goto L17
        L9:
            r105 = null;
            goto L10
        }

        @Override // te8.c
        public final void N0(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
        }

        @Override // te8.c
        public final void Q(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "answer");
        }

        @Override // te8.c
        public final void p(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ContextWindowEntryFeature r101 = this.f330303a;
            int r102 = ContextWindowEntryFeature.f330283z;
            r101.N2();
        }

        @Override // te8.c
        public final void v(List<Message> r100) {
            Intrinsics.checkNotNullParameter(r100, "messages");
        }

        @Override // te8.c
        public final void v1(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "answer");
        }

        @Override // te8.c
        public final void y0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "id");
            ContextWindowEntryFeature r101 = this.f330303a;
            int r102 = ContextWindowEntryFeature.f330283z;
            r101.N2();
        }
    }

    public static final class d implements y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContextWindowEntryFeature f330304a;

        public d(ContextWindowEntryFeature r100) {
            this.f330304a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            ContextWindowEntryFeature r101 = this.f330304a;
            int r102 = ContextWindowEntryFeature.f330283z;
            r101.N2();
        }
    }

    public static final class e implements Function0<u7> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f330305a;

        public e(AttachReceiver r100) {
            this.f330305a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.list.u7, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final u7 invoke() {
            AttachReceiver r100 = this.f330305a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class f implements Function0<y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f330306a;

        public f(AttachReceiver r100) {
            this.f330306a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.cvs.y, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final y invoke() {
            AttachReceiver r100 = this.f330306a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(y.class));
        }
    }

    public static final class g implements Function0<com.larus.bmhome.instruction.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f330307a;

        public g(AttachReceiver r100) {
            this.f330307a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.instruction.g, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final com.larus.bmhome.instruction.g invoke() {
            AttachReceiver r100 = this.f330307a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.instruction.g.class));
        }
    }

    public static final class h implements Function0<c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f330308a;

        public h(AttachReceiver r100) {
            this.f330308a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.c0] */
        @Override // kotlin.jvm.functions.Function0
        public final c0 invoke() {
            AttachReceiver r100 = this.f330308a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(c0.class));
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        y29.b.f565722a.getClass();
        if (y29.b.a() == true) goto L5;
        return;
    L5:
        this.f330292p = true;
        u7 r100 = (u7) this.f330284h.getValue();
        if (r100 == null) goto L8;
        r100.PI(new ContextWindowEntryFeature$onParentViewCreated$1(this));
    L8:
        u7 r101 = (u7) this.f330284h.getValue();
        if (r101 == null) goto L11;
        r101.um(this.f330297u);
    L11:
        y r102 = F2();
        if (r102 == null) goto L14;
        r102.rh(new com.larus.contextwindow.impl.component.f(), this.f330298v);
    L14:
        y r103 = F2();
        if (r103 == null) goto L17;
        r103.ll(new com.larus.contextwindow.impl.component.g(), this.f330299w);
    L17:
        com.larus.bmhome.instruction.g r104 = (com.larus.bmhome.instruction.g) this.f330286j.getValue();
        MutableLiveData r105 = null;
        if (r104 == null) goto L24;
        MutableLiveData r106 = r104.zU();
        if (r106 == null) goto L24;
        LiveData<ReplyOption> r107 = Transformations.distinctUntilChanged(r106);
        if (r107 == null) goto L24;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r107.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), this.f330300x);
    L25:
        this.f330290n = r107;
        com.larus.bmhome.instruction.g r108 = (com.larus.bmhome.instruction.g) this.f330286j.getValue();
        if (r108 == null) goto L30;
        MutableLiveData r109 = r108.Zb();
        if (r109 == null) goto L30;
        Intrinsics.checkNotNullParameter(this, "<this>");
        r109.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), this.f330301y);
        r105 = r109;
    L30:
        this.f330291o = r105;
        return;
    L24:
        r107 = null;
        goto L25
    }

    public final y F2() {
        return (y) this.f330285i.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L2() {
        y r100 = F2();
        if (r100 == null) goto L5;
        wc9.e r101 = r100.h();
    L6:
        boolean r102 = true;
        if (r101 == null) goto L16;
        String r103 = r101.f559198a;
        if (r103 == null) goto L16;
        if ((!StringsKt.isBlank(r103)) == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
    L22:
        if (r101 == null) goto L24;
        ContextWindowContainer r104 = ContextWindowContainer.DEFAULT_CHAT;
    L25:
        ContextWindowContainer r105 = r104;
        u7 r106 = (u7) this.f330284h.getValue();
        if (r106 == null) goto L28;
        List<Message> r107 = r106.zj();
    L29:
        if (r107 != null) goto L31;
        r107 = CollectionsKt.emptyList();
    L31:
        List<Message> r110 = r107;
        LiveData<ReplyOption> r108 = this.f330290n;
        if (r108 == null) goto L35;
        ReplyOption r109 = r108.getValue();
        if (r109 == null) goto L35;
    L40:
        ReplyOption r111 = r109;
    L42:
        LiveData<List<z0>> r112 = this.f330291o;
        if (r112 == null) goto L45;
        List<z0> r113 = r112.getValue();
    L46:
        if (r113 != null) goto L48;
        r113 = CollectionsKt.emptyList();
    L48:
        List<z0> r114 = r113;
        int r115 = com.larus.contextwindow.impl.data.a.f330317a;
        y29.b.f565722a.getClass();
        v29.a r116 = com.larus.contextwindow.impl.data.a.a(y29.b.a(), r105, r103, null, r110, r111, r114);
        if (r101 == null) goto L51;
        String r117 = r101.B;
    L52:
        if (r117 != null) goto L54;
    L56:
        r117 = null;
    L57:
        Iterable r118 = CollectionsKt.withIndex(r110);
        ArrayList r119 = new ArrayList();
        Iterator r120 = r118.iterator();
    L58:
        boolean r121 = false;
        if (r120.hasNext() == false) goto L95;
        Object r122 = r120.next();
        Message r123 = (Message) ((IndexedValue) r122).component2();
        if (com.larus.bmhome.chat.bean.d.G0(r123) == false) goto L93;
        Integer r124 = Integer.valueOf(r123.getMessageStatusLocal());
        if (r124 != null) goto L66;
    L67:
        if (r124 != null) goto L70;
    L71:
        if (r124 != null) goto L74;
    L76:
        boolean r125 = false;
    L78:
        if (r125 == true) goto L93;
        if (r117 != null) goto L81;
    L92:
        r121 = true;
        goto L93
    L81:
        if (Intrinsics.areEqual(r123.getSectionId(), r117) == true) goto L92;
        String r126 = r123.getSectionId();
        if (r126 != null) goto L85;
    L88:
        boolean r127 = true;
    L89:
        if (r127 == false) goto L93;
        if (P2(r123) == null) goto L93;
    L85:
        if (StringsKt.isBlank(r126) == true) goto L88;
        r127 = false;
        goto L89
    L74:
        if (r124.intValue() != 14) goto L76;
    L77:
        r125 = true;
        goto L78
    L70:
        if (r124.intValue() == 13) goto L77;
    L66:
        if (r124.intValue() == 12) goto L77;
    L93:
        if (r121 == false) goto L58;
        r119.add(r122);
        goto L58
    L95:
        IndexedValue r128 = (IndexedValue) CollectionsKt.maxWithOrNull(r119, ComparisonsKt.compareBy(new Function1[]{new com.larus.contextwindow.impl.component.h(), new i()}));
        if (r128 == null) goto L98;
        Message r129 = (Message) r128.getValue();
    L99:
        if (r129 == null) goto L121;
        Map<String, String> r130 = r129.getExt();
        if (r130 != null) goto L103;
    L105:
        boolean r131 = false;
    L106:
        if (r131 == true) goto L115;
        Map<String, String> r132 = r129.getExt();
        if (r132 == null) goto L110;
        String r133 = r132.get("need_deep_think");
    L112:
        if (Intrinsics.areEqual(r133, t0.f558889e.getKey()) == true) goto L115;
        boolean r134 = false;
    L116:
        Boolean r135 = P2(r129);
        if (r135 == null) goto L119;
        r134 = r135.booleanValue();
    L119:
        if (r134 != true) goto L121;
        boolean r136 = true;
    L122:
        boolean r137 = com.larus.contextwindow.impl.data.d.a(r111, r114);
        IContextWindowUsageService.f330273a.getClass();
        IContextWindowUsageService r138 = IContextWindowUsageService.a.f330275b.getValue();
        if (r138 == null) goto L126;
        com.larus.contextwindow.api.a r139 = r138.e(r116);
        if (r139 == null) goto L126;
    L127:
        if (r137 == false) goto L212;
        if (r136 == false) goto L212;
        if (Intrinsics.areEqual(r139, new com.larus.contextwindow.api.a.C4197a(ContextWindowHiddenReason.USAGE_MISSING)) == false) goto L212;
        if (r129 == null) goto L212;
        if (r138 == null) goto L212;
        Iterable r140 = CollectionsKt.withIndex(r116.f552730g);
        ArrayList r141 = new ArrayList();
        Iterator r142 = r140.iterator();
    L136:
        if (r142.hasNext() == false) goto L160;
        Object r143 = r142.next();
        ContextWindowMessageSnapshot r144 = (ContextWindowMessageSnapshot) ((IndexedValue) r143).component2();
        if (Intrinsics.areEqual(r144.f330242a, r116.f552725b) == true) goto L140;
    L156:
        boolean r145 = false;
    L157:
        if (r145 == false) goto L136;
        r141.add(r143);
        goto L136
    L140:
        if ((!StringsKt.isBlank(r144.f330243b)) == false) goto L156;
        if (r144.f330245d == true) goto L156;
        if (r144.f330246e == false) goto L156;
        if (r144.f330247f == false) goto L156;
        String r146 = r144.f330249h;
        if (r146 != null) goto L150;
    L153:
        boolean r147 = true;
    L154:
        if (r147 == true) goto L156;
        r145 = true;
        goto L157
    L150:
        if (StringsKt.isBlank(r146) == true) goto L153;
        r147 = false;
        goto L154
    L160:
        IndexedValue r148 = (IndexedValue) CollectionsKt.maxWithOrNull(r141, ComparisonsKt.compareBy(new Function1[]{new j(), new k()}));
        if (r148 == null) goto L212;
        ContextWindowMessageSnapshot r149 = (ContextWindowMessageSnapshot) r148.getValue();
        if (r149.f330248g == false) goto L212;
        String r150 = r149.f330249h;
        if (r150 != null) goto L168;
    L190:
        boolean r151 = false;
    L191:
        if (r151 == false) goto L212;
        List<ContextWindowMessageSnapshot> r152 = r116.f552730g;
        ArrayList r153 = new ArrayList();
        Iterator<T> r154 = r152.iterator();
        int r155 = 0;
    L195:
        if (r154.hasNext() == false) goto L206;
        Object r156 = r154.next();
        int r157 = r155 + 1;
        if (r155 >= 0) goto L199;
        CollectionsKt.throwIndexOverflow();
    L199:
        ContextWindowMessageSnapshot r158 = (ContextWindowMessageSnapshot) r156;
        if (r155 == r148.getIndex()) goto L202;
        boolean r159 = true;
    L203:
        if (r159 == false) goto L205;
        r153.add(r156);
    L205:
        r155 = r157;
        goto L195
    L202:
        r159 = false;
        goto L203
    L206:
        boolean r160 = r116.f552724a;
        String r161 = r116.f552725b;
        String r162 = r116.f552726c;
        ContextWindowContainer r163 = r116.f552727d;
        ContextWindowMode r164 = r116.f552728e;
        Long r165 = r116.f552729f;
        Intrinsics.checkNotNullParameter(r161, "conversationId");
        Intrinsics.checkNotNullParameter(r163, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r164, "mode");
        Intrinsics.checkNotNullParameter(r153, "messages");
        com.larus.contextwindow.api.a r166 = r138.e(new v29.a(r160, r161, r162, r163, r164, r165, r153));
        if ((r166 instanceof com.larus.contextwindow.api.a.b) == false) goto L209;
        com.larus.contextwindow.api.a.b r167 = (com.larus.contextwindow.api.a.b) r166;
    L210:
        if (r167 == null) goto L212;
        r139 = r167;
        goto L212
    L209:
        r167 = null;
        goto L210
    L168:
        if ((!StringsKt.isBlank(r150)) == true) goto L171;
        r150 = null;
    L171:
        if (r150 == null) goto L190;
        String r168 = r129.getMessageId();
        if (r168 != null) goto L176;
    L178:
        r168 = null;
    L180:
        if (Intrinsics.areEqual(r168, r150) == true) goto L189;
        String r169 = r129.getLocalMessageId();
        if (r169 != null) goto L184;
    L186:
        r169 = null;
    L188:
        if (Intrinsics.areEqual(r169, r150) == false) goto L190;
    L184:
        if ((!StringsKt.isBlank(r169)) == false) goto L186;
    L189:
        r151 = true;
        goto L191
    L176:
        if ((!StringsKt.isBlank(r168)) == false) goto L178;
    L212:
        if (r137 == false) goto L215;
        if (r136 == true) goto L215;
        r139 = new com.larus.contextwindow.api.a.C4197a(ContextWindowHiddenReason.UNSUPPORTED_MODE);
    L215:
        com.larus.contextwindow.api.a r170 = r139;
        boolean r171 = r170 instanceof com.larus.contextwindow.api.a.b;
        if (r171 == false) goto L226;
        y r172 = F2();
        if (r172 == null) goto L224;
        String r173 = r172.getBotId();
        if (r173 == null) goto L224;
        if ((!StringsKt.isBlank(r173)) == false) goto L224;
        String r174 = r173;
    L225:
        ContextWindowEntryRequest r175 = new ContextWindowEntryRequest(r103, null, r174, ContextWindowEnterFrom.ACTION_BAR, ContextWindowContainer.DEFAULT_CHAT);
    L228:
        if (Intrinsics.areEqual(r170, this.f330288l) == true) goto L230;
    L232:
        com.larus.contextwindow.api.a r176 = this.f330288l;
        if (r171 == true) goto L235;
    L237:
        boolean r177 = Intrinsics.areEqual(r170, r176);
    L238:
        if (r177 == false) goto L244;
        if (Intrinsics.areEqual(r175, this.f330289m) == false) goto L244;
        r102 = false;
    L244:
        if ((this.f330288l instanceof com.larus.contextwindow.api.a.b) == true) goto L247;
        if (r171 == false) goto L247;
        com.larus.contextwindow.impl.membership.k.a();
        Lazy<MembershipQuotaRepository> r178 = MembershipQuotaRepository.f330347k;
        MembershipQuotaRepository.b.a().d();
    L247:
        this.f330288l = r170;
        this.f330289m = r175;
        if (r171 == false) goto L250;
        com.larus.contextwindow.api.a.b r179 = (com.larus.contextwindow.api.a.b) r170;
    L251:
        if (r179 == null) goto L255;
        ContextWindowSnapshot r180 = r179.f330277a;
        if (r180 == null) goto L255;
        StateFlowImpl r181 = ContextWindowSnapshotStore.f330312a;
        Intrinsics.checkNotNullParameter(r180, "snapshot");
        ContextWindowSnapshotStore.f330312a.setValue(r180);
    L255:
        if (r102 == false) goto L271;
        c0 r182 = (c0) this.f330287k.getValue();
        if (r182 == null) goto L272;
        r182.KY();
        return;
    L272:
        return;
    L271:
        return;
    L250:
        r179 = null;
        goto L251
    L235:
        if ((r176 instanceof com.larus.contextwindow.api.a.b) == false) goto L237;
        r177 = Intrinsics.areEqual(ContextWindowSnapshot.a(((com.larus.contextwindow.api.a.b) r170).f330277a), ContextWindowSnapshot.a(((com.larus.contextwindow.api.a.b) r176).f330277a));
        goto L238
    L230:
        if (Intrinsics.areEqual(r175, this.f330289m) == false) goto L232;
        return;
    L224:
        r174 = null;
        goto L225
    L226:
        r175 = null;
    L126:
        r139 = new com.larus.contextwindow.api.a.C4197a(ContextWindowHiddenReason.SERVICE_UNAVAILABLE);
        goto L127
    L110:
        r133 = null;
    L115:
        r134 = true;
        goto L116
    L103:
        if (r130.containsKey("general_task_param") != true) goto L105;
        r131 = true;
    L121:
        r136 = false;
        goto L122
    L98:
        r129 = null;
        goto L99
    L54:
        if ((!StringsKt.isBlank(r117)) == false) goto L56;
    L51:
        r117 = null;
        goto L52
    L45:
        r113 = null;
    L35:
        com.larus.bmhome.instruction.g r183 = (com.larus.bmhome.instruction.g) this.f330286j.getValue();
        if (r183 == null) goto L41;
        MutableLiveData r184 = r183.zU();
        if (r184 == null) goto L41;
        r109 = (ReplyOption) r184.getValue();
    L41:
        r111 = null;
        goto L42
    L28:
        r107 = null;
        goto L29
    L24:
        r104 = ContextWindowContainer.UNSUPPORTED;
    L16:
        y r185 = F2();
        if (r185 == null) goto L19;
        r103 = r185.Y1();
    L20:
        if (r103 != null) goto L22;
        r103 = "";
        goto L22
    L19:
        r103 = null;
        goto L20
    L5:
        r101 = null;
        goto L6
    }

    public final void N2() {
        if (this.f330292p == true) goto L5;
        return;
    L5:
        if (this.f330295s == true) goto L10;
        this.f330295s = true;
        this.f330294r.post(this.f330296t);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        if (this.f330292p == false) goto L20;
        u7 r100 = (u7) this.f330284h.getValue();
        if (r100 == null) goto L7;
        r100.mA(this.f330297u);
    L7:
        y r101 = F2();
        if (r101 == null) goto L10;
        r101.lQ(this.f330298v);
    L10:
        y r102 = F2();
        if (r102 == null) goto L13;
        r102.lQ(this.f330299w);
    L13:
        LiveData<ReplyOption> r103 = this.f330290n;
        if (r103 == null) goto L16;
        r103.removeObserver(this.f330300x);
    L16:
        LiveData<List<z0>> r104 = this.f330291o;
        if (r104 == null) goto L19;
        r104.removeObserver(this.f330301y);
    L19:
        this.f330292p = false;
    L20:
        this.f330294r.removeCallbacks(this.f330296t);
        this.f330295s = false;
        ((LinkedHashMap) this.f330293q).clear();
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.contextwindow.impl.component.c] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.larus.contextwindow.impl.component.d] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.contextwindow.impl.component.e] */
    public ContextWindowEntryFeature() {
        this.f330284h = LazyKt.lazy(new e(this));
        this.f330285i = LazyKt.lazy(new f(this));
        this.f330286j = LazyKt.lazy(new g(this));
        this.f330287k = LazyKt.lazy(new h(this));
        this.f330288l = new com.larus.contextwindow.api.a.C4197a(ContextWindowHiddenReason.SERVICE_UNAVAILABLE);
        this.f330293q = new LinkedHashMap();
        this.f330294r = new Handler(Looper.getMainLooper());
        this.f330296t = new com.larus.contextwindow.impl.component.c(this);
        this.f330297u = new c(this);
        this.f330298v = new d(this);
        this.f330299w = new b(this);
        this.f330300x = new com.larus.contextwindow.impl.component.d(this);
        this.f330301y = new com.larus.contextwindow.impl.component.e(this);
    }

    @Override // v29.c
    public final com.larus.contextwindow.api.a O90() {
        return this.f330288l;
    }

    @Override // v29.c
    public final ContextWindowEntryRequest dO() {
        return this.f330289m;
    }

    public final Boolean P2(Message r100) {
        String r101 = r100.getLocalMessageId();
        if (r101 != null) goto L5;
    L12:
        String r102 = r100.getMessageId();
        if (r102 != null) goto L15;
        return null;
    L15:
        if ((!StringsKt.isBlank(r102)) == true) goto L18;
        r102 = null;
    L18:
        if (r102 != null) goto L20;
        return null;
    L20:
        return (Boolean) ((LinkedHashMap) this.f330293q).get(r102);
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L12;
        Boolean r103 = (Boolean) ((LinkedHashMap) this.f330293q).get(r101);
        if (r103 == null) goto L12;
        return r103;
    }
}
