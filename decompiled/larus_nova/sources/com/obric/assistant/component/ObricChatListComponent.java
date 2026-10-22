package com.obric.assistant.component;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0002KLB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0002J\u0012\u00101\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u000207H\u0002J\u0018\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010=\u001a\u00020(H\u0016J\u0010\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0?H\u0016J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0016J\b\u0010B\u001a\u00020-H\u0016J\u0016\u0010C\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0096@¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010FH\u0002J\u0010\u0010G\u001a\u00020/2\u0006\u0010A\u001a\u00020+H\u0002J\u0010\u0010H\u001a\u00020+2\u0006\u0010I\u001a\u00020/H\u0002J\u0018\u0010J\u001a\u0004\u0018\u00010&2\u0006\u0010A\u001a\u00020+H\u0082@¢\u0006\u0002\u0010DR\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/obric/assistant/component/ObricChatListComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/IObricChatListAbility;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "chatBottomFloatingAbility", "Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "getChatBottomFloatingAbility", "()Lcom/larus/bmhome/chat/component/bottom/floating/IChatBottomFloatingAbility;", "chatBottomFloatingAbility$delegate", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "messageList", "Landroidx/recyclerview/widget/RecyclerView;", "getMessageList", "()Landroidx/recyclerview/widget/RecyclerView;", "messageList$delegate", "latestVisibleMessageStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/im/bean/message/Message;", "onParentViewCreated", "", "scrollToMessageAlignBottom", "targetMsgId", "", "highlight", "", "marginBottom", "", "getWindowInputHeight", "getVisibleHeight", "view", "Landroid/view/View;", "getTargetHighlightViews", "Lcom/larus/bmhome/chat/layout/item/BaseMessageBox;", "targetView", "Landroid/view/ViewGroup;", "getBlockContainer", "box", "playHighlightAnimation", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "scrollToBottom", "getLatestVisibleMessageState", "Lkotlinx/coroutines/flow/StateFlow;", "isMsgInChatList", RemoteMessageConst.MSGID, "isNeedCutMessageNow", "canShowOnLockedScreen", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageListAdapter", "Lcom/larus/bmhome/chat/adapter/IMessageListAdapter;", "findMessagePositionInList", "getMessageIdAtPosition", "position", "findMessage", "Companion", "HighlightOverlayView", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatListComponent extends ComponentFeature implements laa.c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f387986o = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f387987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f387988i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f387989j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f387990k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f387991l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f387992m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final StateFlowImpl f387993n;

    public static final class a {
    }

    public static final class b extends View {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f387994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f387995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f387996c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f387997d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Rect f387998e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RectF f387999f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f388000g;

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f387994a = v19.c7.c(Float.valueOf(16.0f));
            this.f387995b = v19.c7.c(Float.valueOf(8.0f));
            this.f387996c = new Paint(1);
            Paint r101 = new Paint(1);
            r101.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            this.f387997d = r101;
            this.f387998e = new Rect();
            this.f387999f = new RectF();
            setLayerType(1, null);
        }

        @Override // android.view.View
        public final void onDraw(Canvas r110) {
            Intrinsics.checkNotNullParameter(r110, "canvas");
            int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
            float r101 = getWidth();
            float r102 = getHeight();
            float r103 = this.f387994a;
            r110.drawRoundRect(0.0f, 0.0f, r101, r102, r103, r103, this.f387996c);
            if (this.f388000g == false) goto L5;
            RectF r104 = this.f387999f;
            float r105 = this.f387995b;
            r110.drawRoundRect(r104, r105, r105, this.f387997d);
        L5:
            r110.restoreToCount(r100);
        }

        @Override // android.view.View
        public final void onSizeChanged(int r100, int r110, int r111, int r112) {
            super.onSizeChanged(r100, r110, r111, r112);
            if (r100 <= 0) goto L8;
            if (r110 <= 0) goto L9;
            this.f387996c.setShader(new LinearGradient(0.0f, r110, r100, 0.0f, new int[]{523724543, 531130111, 536834933, 536851045}, null, Shader.TileMode.CLAMP));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements com.larus.bmhome.social.page.datasource.diff.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricChatListComponent f388001a;

        public c(ObricChatListComponent r100) {
            this.f388001a = r100;
        }

        @Override // com.larus.bmhome.social.page.datasource.diff.c
        public final void onChanged(List<? extends ic8.v> r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            StateFlowImpl r101 = this.f388001a.f387993n;
            Iterator<T> r102 = r100.iterator();
        L3:
            Message r103 = null;
            if (r102.hasNext() == false) goto L32;
            T r104 = r102.next();
            Message r105 = ((ic8.v) r104).a();
            boolean r106 = false;
            if (com.larus.bmhome.chat.bean.d.i0(r105) == false) goto L11;
            if (com.larus.bmhome.chat.bean.d.w(r105) == true) goto L11;
        L30:
            if (r106 == false) goto L3;
        L33:
            ic8.v r107 = (ic8.v) r104;
            if (r107 == null) goto L36;
            r103 = r107.a();
        L36:
            r101.setValue(r103);
            return;
        L11:
            if (com.larus.bmhome.chat.bean.d.T(r105) == true) goto L30;
            if (com.larus.bmhome.chat.bean.d.p0(r105) == true) goto L30;
            if (com.larus.bmhome.chat.bean.d.C0(r105) == true) goto L18;
        L20:
            MessageStatus r108 = r105.getMessageStatus();
            if (r108 != null) goto L23;
        L25:
            boolean r109 = false;
        L26:
            if (r109 == false) goto L28;
        L29:
            r106 = true;
            goto L30
        L28:
            if (com.larus.bmhome.social.userchat.model.b0.f(r105) == false) goto L30;
        L23:
            if (r108.isVisible() != true) goto L25;
            r109 = true;
            goto L26
        L18:
            if (r105.getRegenVisible() == true) goto L20;
        L32:
            r104 = null;
            goto L33
        }
    }

    public static final class d implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388002a;

        public d(AttachReceiver r100) {
            this.f388002a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f388002a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class e implements Function0<u7> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388003a;

        public e(AttachReceiver r100) {
            this.f388003a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.list.u7, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final u7 invoke() {
            AttachReceiver r100 = this.f388003a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class f implements Function0<ld8.n> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388004a;

        public f(AttachReceiver r100) {
            this.f388004a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [ld8.n, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final ld8.n invoke() {
            AttachReceiver r100 = this.f388004a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(ld8.n.class));
        }
    }

    public static final class g implements Function0<va8.p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388005a;

        public g(AttachReceiver r100) {
            this.f388005a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.p] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.p invoke() {
            AttachReceiver r100 = this.f388005a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    static {
    }

    public final RecyclerView N2() {
        return (RecyclerView) this.f387992m.getValue();
    }

    public final com.larus.bmhome.chat.adapter.i<?> P2() {
        va8.p r100 = (va8.p) this.f387990k.getValue();
        if ((r100 instanceof u7) == false) goto L5;
        u7 r101 = (u7) r100;
    L6:
        if (r101 == null) goto L8;
        MessageAdapter r102 = r101.MF();
    L10:
        if ((r102 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L12;
        return null;
    L12:
        return r102;
    L8:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public ObricChatListComponent() {
        this.f387987h = LazyKt.lazy(new d(this));
        this.f387988i = LazyKt.lazy(new e(this));
        this.f387989j = LazyKt.lazy(new f(this));
        this.f387990k = LazyKt.lazy(new g(this));
        this.f387991l = LazyKt.lazy(new com.obric.assistant.component.g(this));
        this.f387992m = LazyKt.lazy(new h(this));
        this.f387993n = kotlinx.coroutines.flow.j1.a(null);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        com.larus.bmhome.chat.adapter.i<?> r100 = P2();
        if (r100 == null) goto L6;
        r100.p1(new c(this));
        return;
    }

    @Override // laa.c
    public final void kc() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricChatListComponent$scrollToBottom$1(this, null), 3, null);
    }

    @Override // laa.c
    public final StateFlowImpl q90() {
        return this.f387993n;
    }

    @Override // laa.c
    public final boolean BL(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        com.larus.bmhome.chat.adapter.i<?> r101 = P2();
        Object r102 = null;
        if (r101 == null) goto L13;
        Iterable r103 = r101.getMessageList();
        if (r103 == null) goto L13;
        Iterator r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((ic8.v) r105).a().getMessageId(), r100) == false) goto L8;
        r102 = r105;
    L12:
        r102 = (ic8.v) r102;
    L13:
        if (r102 == null) goto L15;
        return true;
    L15:
        return false;
    }

    public final int L2(String r100) {
        com.larus.bmhome.chat.adapter.i<?> r101 = P2();
        if (r101 == null) goto L13;
        List<DATA> r102 = r101.getMessageList();
        if (r102 == 0) goto L16;
        Iterator r103 = r102.iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((ic8.v) r103.next()).a().getMessageId(), r100) == true) goto L17;
        r104 = r104 + 1;
        goto L8
    L17:
        return r104;
    L18:
        return -1;
    L16:
        return -1;
    L13:
        return -1;
    }

    @Override // laa.c
    public final void vC(String r110) {
        Intrinsics.checkNotNullParameter(r110, "targetMsgId");
        FLogger.f375446a.i("ObricChatListComponent", "scrollToMessageAlignBottom: targetMsgId[" + r110 + "], highlight[true], marginBottom[0]");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricChatListComponent$scrollToMessageAlignBottom$1(this, r110, 0, true, null), 3, null);
    }

    @Override // laa.c
    public final Object Dp(String r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof ObricChatListComponent$canShowOnLockedScreen$1) == false) goto L7;
        ObricChatListComponent$canShowOnLockedScreen$1 r100 = (ObricChatListComponent$canShowOnLockedScreen$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        Message r113 = (Message) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L41:
        Message r114 = (Message) r112;
        if (r114 != null) goto L45;
        FLogger.f375446a.w("ObricChatListComponent", "canShowOnLockedScreen: replyId[" + r113.getReplyId() + "] not found");
        return Boxing.boxBoolean(false);
    L45:
        long r106 = IKeyguardStateKt.getKeyguardState().getKeyguardLockTime();
        if (r114.getCreateTime() < r106) goto L57;
        if (com.larus.bmhome.chat.bean.d.G0(r114) == false) goto L55;
        Map<String, String> r115 = r114.getExt();
        if (r115 == null) goto L52;
        String r116 = r115.get("keyguard_lock_time");
    L53:
        r104 = Intrinsics.areEqual(r116, String.valueOf(r106));
        goto L55
    L52:
        r116 = null;
    L55:
        return Boxing.boxBoolean(r104);
    L57:
        return Boxing.boxBoolean(false);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L28:
        r114 = (Message) r112;
        if (r114 != null) goto L31;
        FLogger.f375446a.i("ObricChatListComponent", "canShowOnLockedScreen: msgId[" + r110 + "] not found");
        return Boxing.boxBoolean(false);
    L31:
        if (com.larus.utils.o0.d(r114.getReplyId()) == false) goto L45;
        if (Intrinsics.areEqual(r114.getReplyId(), "0") == true) goto L45;
        String r107 = r114.getReplyId();
        if (r107 != null) goto L37;
        r107 = "";
    L37:
        r100.L$0 = r110;
        r100.L$1 = r114;
        r100.label = 2;
        Object r117 = F2(r107, r100);
        if (r117 != r102) goto L40;
        return r102;
    L40:
        r112 = r117;
        r113 = r114;
        goto L41
    L16:
        ResultKt.throwOnFailure(r112);
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L19;
    L21:
        boolean r118 = false;
    L22:
        if (r118 == true) goto L25;
        FLogger.f375446a.i("ObricChatListComponent", "canShowOnLockedScreen: not need cut message");
        return Boxing.boxBoolean(true);
    L25:
        r100.L$0 = r110;
        r100.label = 1;
        r112 = F2(r110, r100);
        if (r112 != r102) goto L28;
        return r102;
    L19:
        if (SessionAuthenticationServiceDelegate.f385201b.o().getValue().booleanValue() == true) goto L21;
        r118 = true;
    L7:
        r100 = new ObricChatListComponent$canShowOnLockedScreen$1(this, r111);
        goto L8
    }

    public final Object F2(String r100, Continuation<? super Message> r101) {
        com.larus.bmhome.chat.adapter.i<?> r102 = P2();
        if (r102 == null) goto L16;
        List<xc8.b> r103 = ((MessageAdapter) r102).z2();
        if (r103 == null) goto L16;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L12;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((ic8.v) r105).a().getMessageId(), r100) == false) goto L8;
    L13:
        ic8.v r106 = (ic8.v) r105;
        if (r106 == null) goto L16;
        Message r107 = r106.a();
    L17:
        if (r107 == null) goto L19;
        return r107;
    L19:
        IChatRepoService r108 = (IChatRepoService) ServiceManager.get().getService(IChatRepoService.class);
        if (r108 != null) goto L22;
        return null;
    L22:
        return r108.E1(r100, r101);
    L12:
        r105 = null;
    L16:
        r107 = null;
        goto L17
    }
}
