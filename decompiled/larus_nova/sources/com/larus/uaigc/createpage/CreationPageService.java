package com.larus.uaigc.createpage;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.bmhome.auth.ILaunchCacheService;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Image;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.creation.CustomInputInitData;
import com.larus.platform.model.creation.ResourceExt;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u009d\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00072\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010)\u001a\u0004\u0018\u00010\u001c2\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0002\u00102JW\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\b\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u00112\b\u0010;\u001a\u0004\u0018\u00010\u00112\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u0004\u0018\u00010\u0011H\u0096@¢\u0006\u0002\u0010BJ\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001c0DH\u0016J\n\u0010E\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010F\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010G\u001a\u0004\u0018\u000101H\u0002J \u0010H\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0002\u0010IJ4\u0010J\u001a\u00020\u00052$\u0010K\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010M\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050N\u0012\u0006\u0012\u0004\u0018\u00010O0LH\u0082@¢\u0006\u0002\u0010P¨\u0006Q"}, d2 = {"Lcom/larus/uaigc/createpage/CreationPageService;", "Lcom/larus/bmhome/community/ICreationPageService;", "<init>", "()V", "startCreationActivity", "", "isHalfScreenPage", "", "activity", "Landroid/app/Activity;", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "chatParam", "Lcom/larus/bmhome/chat/ChatParam;", "openNewChatPageOnSend", "openNewChatPageOnSendWithClearTop", ThumbGlideUrl.SOURCE_TEMPLATE, "", "userPrompt", "refImageUrl", "refImage", "Lcom/larus/im/bean/message/Image;", "refCreateRefInfoList", "", "Lcom/larus/platform/model/creation/ResourceExt;", "refImageAlbumPath", "whiteIndexList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isReedit", "hitPointData", "Lcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "extraBundle", "Landroid/os/Bundle;", "cleaInput", "msgExtMap", "", "selectStartPosition", "selectEndPosition", "isEnterTemplate", "customInputInitData", "Lcom/larus/platform/api/creation/CustomInputInitData;", "ignoreSideBar", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "compactForsetiFragment", "Landroidx/fragment/app/Fragment;", "(ZLandroid/app/Activity;Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Lcom/larus/bmhome/chat/ChatParam;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/Image;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;ZLcom/larus/bmhome/view/actionbar/edit/creationpage/data/IInstructionHitPoint;Lcom/ixigua/lib/track/ITrackNode;Landroid/os/Bundle;ZLjava/util/Map;Ljava/lang/Integer;Ljava/lang/Integer;ZLcom/larus/platform/api/creation/CustomInputInitData;ZLcom/larus/bmhome/chat/bean/ChatPageContext;Landroidx/fragment/app/Fragment;)V", "openCreationPage", "position", "itemId", "", "instructionType", "lifecycleCoroutineScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "previousPage", "currentPage", "enterMethod", "(Ljava/lang/Integer;Landroid/app/Activity;Ljava/lang/Long;ILandroidx/lifecycle/LifecycleCoroutineScope;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "updateActionBar", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchWhiteAvatarTUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAvatarCreatedStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getIpaMainUrl", "getWhiteTUrl", "getCurBottomTabMainBotFrag", "handleOpenSchema", "(Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainBotConversationInfo", "callback", "Lkotlin/Function2;", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPageService implements ICreationPageService {
    public CreationPageService() {
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final String d() {
        DigitalAvatarInfoManager.f371542a.getClass();
        return (String) DigitalAvatarInfoManager.f371543b.getValue();
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final StateFlowImpl e() {
        DigitalAvatarInfoManager.f371542a.getClass();
        return DigitalAvatarInfoManager.f371544c;
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final String g() {
        DigitalAvatarInfoManager.f371542a.getClass();
        return DigitalAvatarInfoManager.e();
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final void b(GlobalScope r100) {
        Intrinsics.checkNotNullParameter(r100, "coroutineScope");
        IActionBarService r101 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r101 == null) goto L12;
        com.larus.bmhome.chat.api.e0 r102 = AuthModelDelegate.f297134b.e().getValue();
        if (r102 == null) goto L9;
        LaunchInfo r103 = r102.f297186a;
        if (r103 == null) goto L9;
        String r104 = r103.W();
    L10:
        r101.d(r100, r104, new t0());
        return;
    L9:
        r104 = null;
        goto L10
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final Object c(Continuation<? super String> r100) {
        return DigitalAvatarInfoManager.d(DigitalAvatarInfoManager.f371542a, r100);
    }

    public final Object i(Function2<? super wc9.e, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof CreationPageService$getMainBotConversationInfo$1) == false) goto L7;
        CreationPageService$getMainBotConversationInfo$1 r102 = (CreationPageService$getMainBotConversationInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 != 3) goto L15;
        ResultKt.throwOnFailure(r104);
    L36:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r100 = (Function2) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L31:
        wc9.e r107 = (wc9.e) r104;
    L32:
        r102.L$0 = null;
        r102.label = 3;
        if (r100.invoke(r107, r102) != r105) goto L36;
        return r105;
    L17:
        r100 = (Function2) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L23:
        r107 = (wc9.e) r104;
        goto L32
    L18:
        ResultKt.throwOnFailure(r104);
        if (com.larus.platform.exp.o.a() == false) goto L24;
        LocalSubConvHelper r108 = LocalSubConvHelper.f314106a;
        String r109 = AccountService.f365697a.getSecUserId();
        r102.L$0 = r100;
        r102.label = 1;
        r104 = r108.c(r109, null, r102);
        if (r104 != r105) goto L23;
        return r105;
    L24:
        ILaunchCacheService r110 = (ILaunchCacheService) ServiceManager.get().getService(ILaunchCacheService.class);
        if (r110 == null) goto L28;
        r107 = r110.b();
        if (r107 != null) goto L32;
    L28:
        Flow r111 = FlowLiveDataConversions.asFlow(AuthModelDelegate.f297134b.y());
        CreationPageService$getMainBotConversationInfo$cvs$1 r112 = new CreationPageService$getMainBotConversationInfo$cvs$1(null);
        r102.L$0 = r100;
        r102.label = 2;
        r104 = kotlinx.coroutines.flow.e.t(r111, r112, r102);
        if (r104 != r105) goto L31;
        return r105;
    L7:
        r102 = new CreationPageService$getMainBotConversationInfo$1(this, r101);
        goto L8
    }

    public static final Object h(CreationPageService r100, com.larus.bmhome.actionbar.model.z0 r110, String r111, Continuation r112) {
        r100.getClass();
        if ((r112 instanceof CreationPageService$handleOpenSchema$1) == false) goto L7;
        CreationPageService$handleOpenSchema$1 r101 = (CreationPageService$handleOpenSchema$1) r112;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r113 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L37:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r105 = (Ref.ObjectRef) r101.L$3;
        String r114 = (String) r101.L$2;
        r111 = (String) r101.L$1;
        com.larus.bmhome.actionbar.model.z0 r106 = (com.larus.bmhome.actionbar.model.z0) r101.L$0;
        ResultKt.throwOnFailure(r113);
        String r115 = r114;
        r110 = r106;
    L26:
        com.larus.bmhome.actionbar.model.e0 r107 = r110.f295617m;
        if (r107 == null) goto L36;
        String r108 = r107.f295086a;
        if (r108 == null) goto L36;
        FLogger.f375446a.i("CreationPageService", "[handleOpenSchema] schemaUrl=".concat(r108));
        Bundle r109 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("enter_from", "chat"), TuplesKt.to("enter_method", r111), TuplesKt.to("conversation_id", r105.element), TuplesKt.to("argConversationId", r105.element), TuplesKt.to("bot_id", r115), TuplesKt.to("need_router_to_chat", Boxing.boxBoolean(true))});
        MainCoroutineDispatcher r116 = Dispatchers.getMain();
        CreationPageService$handleOpenSchema$3 r117 = new CreationPageService$handleOpenSchema$3(r108, r110, r109, null);
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.label = 2;
        if (BuildersKt.withContext(r116, r117, r101) != r103) goto L37;
        return r103;
    L36:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r113);
        com.larus.bmhome.chat.api.e0 r118 = AuthModelDelegate.f297134b.e().getValue();
        if (r118 == null) goto L21;
        LaunchInfo r119 = r118.f297186a;
        if (r119 == null) goto L21;
        r115 = r119.W();
    L22:
        Ref.ObjectRef r120 = new Ref.ObjectRef();
        r120.element = "";
        Function2<? super wc9.e, ? super Continuation<? super Unit>, ? extends Object> r121 = new CreationPageService$handleOpenSchema$2(r120, null);
        r101.L$0 = r110;
        r101.L$1 = r111;
        r101.L$2 = r115;
        r101.L$3 = r120;
        r101.label = 1;
        if (r100.i(r121, r101) == r103) goto L38;
        r105 = r120;
        goto L26
    L38:
        return r103;
    L21:
        r115 = null;
    L7:
        r101 = new CreationPageService$handleOpenSchema$1(r100, r112);
        goto L8
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final void f(Integer r110, FragmentActivity r111, Long r112, int r113, LifecycleCoroutineScope r210, String r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r111, "activity");
        Intrinsics.checkNotNullParameter(r210, "lifecycleCoroutineScope");
        com.larus.bmhome.chat.api.e0 r100 = AuthModelDelegate.f297134b.e().getValue();
        if (r100 == null) goto L7;
        LaunchInfo r101 = r100.f297186a;
        if (r101 == null) goto L7;
        String r102 = r101.W();
    L8:
        List<com.larus.bmhome.actionbar.model.z0> r103 = ((IActionBarService) ServiceManager.get().getService(IActionBarService.class)).f(r102);
        boolean r104 = false;
        if (r103 == null) goto L21;
        Iterator<T> r105 = r103.iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r106).f295605a, r112) == false) goto L12;
    L17:
        com.larus.bmhome.actionbar.model.z0 r107 = (com.larus.bmhome.actionbar.model.z0) r106;
        if (r107 == null) goto L21;
        com.larus.bmhome.actionbar.model.z0 r108 = r107;
    L40:
        if (r110 == null) goto L42;
        String r109 = r110.toString();
    L43:
        if (r108 == null) goto L47;
        com.larus.bmhome.actionbar.model.r r114 = r108.f295621q;
        if (r114 == null) goto L47;
        Integer r115 = r114.f295408a;
    L49:
        if (r115 != null) goto L52;
    L55:
        if (r115 != null) goto L58;
    L60:
        if (r115 != null) goto L63;
    L65:
        if (r115 != null) goto L68;
    L70:
        String r116 = "";
    L54:
        String r117 = r116;
        if (r108 == null) goto L73;
        boolean r118 = true;
    L74:
        tx9.c0.o(r109, r117, r212, Boolean.valueOf(r118), "create_function_area", 96);
        if (r108 != null) goto L79;
        t19.s r119 = t19.s.f544207a;
        String r120 = AppHost.f326268a.getApplication().getString(R.string.larus_CreateAI_toast_unavailable);
        r119.getClass();
        t19.s.c(r111, r120);
        return;
    L79:
        if (z2.f365865a.enableChatWithTab() == false) goto L101;
        IFlowSdkDepend r121 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r121 == null) goto L84;
        r121.f0();
        Fragment r122 = com.larus.home.impl.sdk.i.f346186a.a();
    L85:
        if (r122 == null) goto L91;
        t1a.b r123 = s1a.a.g(r122);
        if (r123 == null) goto L91;
        com.larus.bmhome.chat.component.cvs.y r124 = (com.larus.bmhome.chat.component.cvs.y) r123.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
        if (r124 == null) goto L91;
        String r125 = r124.getBotId();
    L92:
        com.larus.bmhome.chat.api.e0 r126 = AuthModelDelegate.f297134b.e().getValue();
        if (r126 == null) goto L97;
        LaunchInfo r127 = r126.f297186a;
        if (r127 == null) goto L97;
        String r128 = r127.W();
    L99:
        if (Intrinsics.areEqual(r125, r128) == false) goto L101;
    L102:
        if (r122 == null) goto L107;
        com.larus.bmhome.instruction.g r129 = (com.larus.bmhome.instruction.g) s1a.a.g(r122).getAbility(com.larus.bmhome.instruction.g.class);
        if (r129 == null) goto L154;
        r129.j90(r108);
        return;
    L154:
        return;
    L107:
        Integer r130 = r108.f295611g;
        int r131 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
        if (r130 != null) goto L111;
    L113:
        com.larus.bmhome.actionbar.model.r r132 = r108.f295621q;
        if (r132 == null) goto L121;
        Integer r133 = r132.f295408a;
        if (r133 == null) goto L121;
        if (r133.intValue() != 4) goto L121;
        boolean r134 = true;
    L122:
        if (r134 == true) goto L144;
        com.larus.bmhome.actionbar.model.r r135 = r108.f295621q;
        if (r135 == null) goto L131;
        Integer r136 = r135.f295408a;
        if (r136 == null) goto L131;
        if (r136.intValue() != 18) goto L131;
        boolean r137 = true;
    L132:
        if (r137 == true) goto L144;
        com.larus.bmhome.actionbar.model.r r138 = r108.f295621q;
        if (r138 == null) goto L141;
        Integer r139 = r138.f295408a;
        if (r139 == null) goto L141;
        if (r139.intValue() != 28) goto L141;
        r104 = true;
    L141:
        if (r104 == true) goto L144;
        BuildersKt.launch$default(r210, null, null, new CreationPageService$openCreationPage$3(this, r111, r108, r211, r212, r213, null), 3, null);
        return;
    L131:
        r137 = false;
    L144:
        BuildersKt.launch$default(r210, null, null, new CreationPageService$openCreationPage$2(this, r108, r111, r211, r212, r213, null), 3, null);
        return;
    L121:
        r134 = false;
        goto L122
    L111:
        if (r130.intValue() != r131) goto L113;
        BuildersKt.launch$default(r210, null, null, new CreationPageService$openCreationPage$1(this, r108, r213, null), 3, null);
        return;
    L97:
        r128 = null;
    L91:
        r125 = null;
        goto L92
    L84:
        r122 = null;
    L101:
        r122 = null;
        goto L102
    L73:
        r118 = false;
        goto L74
    L68:
        if (r115.intValue() != 11) goto L70;
        r116 = "avatar";
        goto L54
    L63:
        if (r115.intValue() != 1) goto L65;
        r116 = "music";
        goto L54
    L58:
        if (r115.intValue() != 18) goto L60;
        r116 = "video";
        goto L54
    L52:
        if (r115.intValue() != 4) goto L55;
        r116 = "image";
    L47:
        r115 = null;
        goto L49
    L42:
        r109 = null;
        goto L43
    L16:
        r106 = null;
    L21:
        if (r103 == null) goto L39;
        Iterator<T> r140 = r103.iterator();
    L24:
        if (r140.hasNext() == false) goto L37;
        Object r141 = r140.next();
        com.larus.bmhome.actionbar.model.r r142 = ((com.larus.bmhome.actionbar.model.z0) r141).f295621q;
        if (r142 == null) goto L34;
        Integer r143 = r142.f295408a;
        if (r143 == null) goto L34;
        if (r143.intValue() != r113) goto L34;
        boolean r144 = true;
    L35:
        if (r144 == false) goto L24;
    L38:
        r108 = (com.larus.bmhome.actionbar.model.z0) r141;
    L34:
        r144 = false;
        goto L35
    L37:
        r141 = null;
        goto L38
    L39:
        r108 = null;
    L7:
        r102 = null;
        goto L8
    }

    @Override // com.larus.bmhome.community.ICreationPageService
    public final void a(boolean r510, Activity r511, com.larus.bmhome.actionbar.model.z0 r512, ChatParam r513, boolean r514, boolean r610, String r611, String r612, String r613, Image r614, List<ResourceExt> r615, String r616, ArrayList<Integer> r617, boolean r618, zs8.a r619, by7.e r710, Bundle r711, boolean r712, Map<String, String> r713, Integer r714, Integer r715, boolean r716, CustomInputInitData r717, boolean r718, ChatPageContext r719, Fragment r810) {
        Intrinsics.checkNotNullParameter(r511, "activity");
        Intrinsics.checkNotNullParameter(r512, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r615, "refCreateRefInfoList");
        Intrinsics.checkNotNullParameter(r617, "whiteIndexList");
        ny9.b r110 = new ny9.b(r510, r511, r512, r513, r514, r610, r611, r612, r613, null, r615, null, r617, null, r614, null, null, r616, null, false, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r718, null, null, null, null, null, null, null, null, null, null, null, null, null, r719, null, r810, null, null, false, -2146588160, 241663);
        if (IAICreationAppletHostService.f370273a.f(r110, true) == false) goto L5;
        return;
    L5:
        s0.f372603a.getClass();
        s0.d(r110);
    }
}
