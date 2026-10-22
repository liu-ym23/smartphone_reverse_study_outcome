package com.larus.bmhome.taskskill.service;

import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0010H\u0016J\u001f\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010#JM\u0010$\u001a\u00020%2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\u0006\u0010&\u001a\u00020\u00102\b\u0010'\u001a\u0004\u0018\u00010\u00102\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010.J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\f04H\u0016J\u0010\u00106\u001a\u00020%2\u0006\u00101\u001a\u000207H\u0016J \u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0016J\u0018\u0010<\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010H\u0016J\b\u0010=\u001a\u00020%H\u0016J\u001a\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020%H\u0016J:\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u00102\b\u0010I\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\bJ\u0010KJ:\u0010L\u001a\b\u0012\u0004\u0012\u00020\f0D2\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u00102\b\u0010I\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0004\bM\u0010KR\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006N"}, d2 = {"Lcom/larus/bmhome/taskskill/service/SkillServiceDelegate;", "Lcom/larus/bmhome/taskskill/service/ISkillService;", "<init>", "()V", "delegate", "getDelegate", "()Lcom/larus/bmhome/taskskill/service/ISkillService;", "getDeviceOrRuntimeChangedCellInfo", "Lkotlin/Pair;", "Ljava/lang/Class;", "", "initializeAccountCacheInvalidation", "", "initializeConnectorListRefresh", "refreshConnectorList", "scene", "", "tryTriggerOfficeTaskAskHumanInnerNotification", "data", "Lcom/larus/im/bean/InAppBannerNotify;", "resolvePcDeviceId", "agentTaskParam", "Lcom/larus/bmhome/taskskill/model/ConversationAgentTaskParam;", "findTargetAppId", "", "targetDeviceId", "(Ljava/lang/String;)Ljava/lang/Integer;", "prepareTaskSkillFullScreenTransfer", "conversationId", "prepareOTransferVisibleSkills", "createSkillComponent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "sceneDelegate", "Lcom/larus/bmhome/taskskill/SkillComponentSceneDelegate;", "initialContentViewId", "(Lcom/larus/bmhome/taskskill/SkillComponentSceneDelegate;Ljava/lang/Integer;)Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "interceptQuickReplyClick", "", "messageId", WikiFolderPushPlugin.BLOCK_ID, MapController.ITEM_LAYER_TAG, "Lcom/larus/im/bean/message/block/QuickReplyItem;", "itemIndex", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "interactionType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/block/QuickReplyItem;ILandroidx/fragment/app/FragmentActivity;Ljava/lang/Integer;)Z", "executeQuickReplyAction", "Lcom/larus/bmhome/taskskill/service/QuickReplyActionHandle;", "request", "Lcom/larus/bmhome/taskskill/service/QuickReplyActionRequest;", "onEvent", "Lkotlin/Function1;", "Lcom/larus/bmhome/taskskill/service/QuickReplyActionEvent;", "showLocalPcDispatchFallbackDialogIfNeeded", "Lcom/larus/bmhome/taskskill/service/LocalPcDispatchFallbackDialogRequest;", "retainTaskSkillActionBarFilter", "ownerId", "source", "actionBarScopeId", "releaseTaskSkillActionBarFilter", "isRemoteControlEnabled", "snapshotTaskSkillMessage", "Lcom/larus/bmhome/taskskill/model/TaskSkillMessageSnapshot;", "conversation", "Lcom/larus/im/bean/conversation/Conversation;", "isInTaskMode", "addRecentlyUsedSkill", "Lkotlin/Result;", "", "skillName", "skillType", "path", "externalSkillId", "addRecentlyUsedSkill-yxL6bBk", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeRecentlyUsedSkill", "removeRecentlyUsedSkill-yxL6bBk", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SkillServiceDelegate implements ISkillService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SkillServiceDelegate f314414a = null;

    static {
        f314414a = new SkillServiceDelegate();
    }

    private SkillServiceDelegate() {
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void o() {
        Intrinsics.checkNotNullParameter("flow.refreshConnector", "scene");
        s().o();
    }

    public static ISkillService s() {
        ISkillService r100 = (ISkillService) ServiceManager.get().getService(ISkillService.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new SkillServiceNoop();
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void a() {
        s().a();
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final Pair<Class<?>, Object> g() {
        return s().g();
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final boolean k() {
        return s().k();
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final boolean d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return s().d(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final Integer f(String r100) {
        return s().f(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final String j(bs8.a r100) {
        return s().j(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        s().m(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void n(tc9.e r100) {
        s().n(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void p(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        s().p(r100);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final ComponentFeature b(bz8.j r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneDelegate");
        return s().b(r100, r101);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final l c(m r100, com.larus.bmhome.chat.standarduikit.interaction.viewmodel.h r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "onEvent");
        return s().c(r100, r101);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final bs8.n h(wc9.e r100, boolean r101) {
        return s().h(r100, r101);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "source");
        s().i(r100, r101);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final void r(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "ownerId");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "actionBarScopeId");
        s().r(r100, r101, r102);
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final Object e(String r100, int r101, String r110, String r111, Continuation<? super Result<Long>> r112) {
        if ((r112 instanceof SkillServiceDelegate$addRecentlyUsedSkill$1) == false) goto L7;
        SkillServiceDelegate$addRecentlyUsedSkill$1 r102 = (SkillServiceDelegate$addRecentlyUsedSkill$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        SkillServiceDelegate$addRecentlyUsedSkill$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
        return ((Result) r113).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        ISkillService r107 = s();
        r104.label = 1;
        Object r108 = r107.e(r100, r101, r110, r111, r104);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new SkillServiceDelegate$addRecentlyUsedSkill$1(this, r112);
        goto L8
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final Object q(String r100, int r101, String r110, String r111, Continuation<? super Result<Unit>> r112) {
        if ((r112 instanceof SkillServiceDelegate$removeRecentlyUsedSkill$1) == false) goto L7;
        SkillServiceDelegate$removeRecentlyUsedSkill$1 r102 = (SkillServiceDelegate$removeRecentlyUsedSkill$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        SkillServiceDelegate$removeRecentlyUsedSkill$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
        return ((Result) r113).m9458unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        ISkillService r107 = s();
        r104.label = 1;
        Object r108 = r107.q(r100, r101, r110, r111, r104);
        if (r108 != r105) goto L18;
        return r105;
    L18:
        return r108;
    L7:
        r102 = new SkillServiceDelegate$removeRecentlyUsedSkill$1(this, r112);
        goto L8
    }

    @Override // com.larus.bmhome.taskskill.service.ISkillService
    public final boolean l(String r110, String r111, String r112, QuickReplyItem r113, int r114, FragmentActivity r115, Integer r116) {
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        return s().l(r110, r111, r112, r113, r114, r115, r116);
    }
}
