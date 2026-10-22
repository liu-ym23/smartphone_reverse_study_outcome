package com.larus.bmhome.chat.component.bottom.talk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;
import t19.s;
import tx9.a1;
import tx9.k0;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\"H\u0002J \u00102\u001a\u00020,2\u0006\u00101\u001a\u00020\"2\b\b\u0002\u00103\u001a\u000204H\u0082@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020,H\u0016J\b\u00107\u001a\u00020,H\u0002J\b\u00108\u001a\u000204H\u0002J\b\u00102\u001a\u00020,H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b(\u0010)¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/talk/ChatContinueTalkComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/ui/arch/component/external/ContentComponent;", "Lcom/larus/bmhome/chat/component/bottom/IChatContinueTalkAbility;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "listComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "listComponentAbility$delegate", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "playbackAbility", "Lcom/larus/bmhome/chat/component/showcase/IChatPlaybackAbility;", "getPlaybackAbility", "()Lcom/larus/bmhome/chat/component/showcase/IChatPlaybackAbility;", "playbackAbility$delegate", "chatBottomAbility", "Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "getChatBottomAbility", "()Lcom/larus/bmhome/chat/component/bottom/IChatBottomAbility;", "chatBottomAbility$delegate", "onConversationOrTypeChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "onlyReadCvsId", "", "onlyReadCvs", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "onViewCreated", "", "view", "Landroid/view/View;", "observeConversationChanged", "setOnClick", "cvs", "continueTalk", "needShowIme", "", "(Lcom/larus/im/bean/conversation/Conversation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", LiveCommonConstants.REASON_ON_DEDTROY, "removeUnContinueTalkCvs", "shouldAutoLaunchKeyboardOnCreateSub", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinueTalkComponent extends BaseContentWidget implements t1a.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f300354v = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f300355m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f300356n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f300357o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f300358p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f300359q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public j f300360r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f300361s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public wc9.e f300362t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f300363u;

    public ChatContinueTalkComponent() {
        this.f300355m = LazyKt.lazy(new c(this));
        this.f300356n = LazyKt.lazy(new d(this));
        this.f300357o = LazyKt.lazy(new e(this));
        this.f300358p = LazyKt.lazy(new f(this));
        this.f300359q = LazyKt.lazy(new g(this));
        this.f300363u = LazyKt.lazy(new h());
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        Bundle r100 = ((de8.c) s1a.d.a(this).f(de8.c.class)).f468086b;
        if (r100 == null) goto L5;
        String r101 = r100.getString("as_container");
    L7:
        if (o0.d(this.f300361s) == true) goto L9;
    L11:
        ((Handler) this.f300363u.getValue()).removeCallbacksAndMessages(null);
        return;
    L9:
        if (Intrinsics.areEqual(r101, "FLOAT_CHAT") == true) goto L11;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ChatContinueTalkComponent$removeUnContinueTalkCvs$1(this, null), 3, null);
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f300360r = new j(this);
        y r101 = (y) this.f300355m.getValue();
        if (r101 == null) goto L6;
        r101.rh(new b(), this.f300360r);
        return;
    }

    public static final Object Y2(final ChatContinueTalkComponent r910, wc9.e r911, boolean r912, Continuation r913) {
        wc9.e r100 = r911;
        r910.getClass();
        if ((r913 instanceof ChatContinueTalkComponent$continueTalk$1) == false) goto L7;
        ChatContinueTalkComponent$continueTalk$1 r101 = (ChatContinueTalkComponent$continueTalk$1) r913;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        ChatContinueTalkComponent$continueTalk$1 r110 = r101;
        Object r103 = r110.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r106 = r110.Z$0;
        wc9.e r107 = (wc9.e) r110.L$0;
        ResultKt.throwOnFailure(r103);
        Object r108 = r103;
        boolean r109 = r106;
        r100 = r107;
    L17:
        com.larus.network.http.a r111 = (com.larus.network.http.a) r108;
        boolean r112 = false;
        if ((r111 instanceof com.larus.network.http.f) == false) goto L28;
        String r113 = ((com.larus.network.http.f) r111).f360157d.getMessage();
        if (r113 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == true) goto L32;
        s r115 = s.f544207a;
        Context r116 = AppHost.f326268a.getApplication().getApplicationContext();
        r115.getClass();
        s.c(r116, r113);
    L32:
        ((Handler) r910.f300363u.getValue()).removeCallbacksAndMessages(null);
        u7 r117 = (u7) r910.f300356n.getValue();
        if (r117 == null) goto L35;
        r117.dismissLoading();
    L35:
        z2 r118 = z2.f365865a;
        if (r118.subConvKeyboardConfig().a() == false) goto L38;
    L41:
        boolean r119 = true;
    L42:
        ICoreInputAbility r120 = (ICoreInputAbility) r910.f300357o.getValue();
        if (r120 != null) goto L45;
    L47:
        boolean r121 = false;
    L48:
        boolean r122 = !r121;
        if (r119 == false) goto L52;
        if (r122 == false) goto L52;
        r112 = true;
    L52:
        if (r112 == false) goto L56;
        if (r109 == false) goto L56;
        ((Handler) r910.f300363u.getValue()).postDelayed(new a(r910), 200);
    L56:
        return Unit.INSTANCE;
    L45:
        if (r120.Rp() != 2) goto L47;
        r121 = true;
        goto L48
    L38:
        if (r118.subConvKeyboardConfig().b() == true) goto L41;
        r119 = false;
        goto L42
    L22:
        if (r113.length() == 0) goto L25;
        r114 = false;
        goto L26
    L28:
        r910.f300361s = null;
        String r123 = r100.f559215r;
        if (r123 != null) goto L31;
        r123 = "";
    L31:
        JSONObject r124 = new JSONObject(r123);
        r124.remove("forbid_send_msg");
        RepoDispatcherDelegate.f307737b.f().e(r100, r124.toString());
        String r125 = r100.f559198a;
        JSONObject r126 = new JSONObject();
        r126.put("current_page_status", "temporary");
        k0.a(null, "click_continue_talk", r125, "chat", "landing", null, null, null, null, null, null, null, null, null, r126, null, null, null, 1015747);
        String r127 = r100.f559198a;
        JSONObject r128 = new JSONObject();
        r128.put("current_page_status", "normal");
        r128.put("previous_page_status", "temporary");
        a1.c(null, null, null, null, r127, "chat", null, null, null, null, null, null, null, null, null, null, "chat", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r128, null, null, null, null, null, null, null, null, -1048769, -8388609, 7);
        goto L32
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        JSONObject r129 = new JSONObject();
        r129.put("conversation_id", r100.f559198a);
        Unit r130 = Unit.INSTANCE;
        r110.L$0 = r100;
        r109 = r912;
        r110.Z$0 = r109;
        r110.label = 1;
        r108 = HttpExtKt.k(ServiceType.IM, String.class, "/social/conversation/continue_chat", r129, null, null, false, null, null, null, r110, 1008);
        if (r108 != r104) goto L17;
        return r104;
    L7:
        r101 = new ChatContinueTalkComponent$continueTalk$1(r910, r913);
        goto L8
    }
}
