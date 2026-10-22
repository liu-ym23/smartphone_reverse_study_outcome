package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.BotEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.BotDaoSource$tryUpdateNew$2", f = "BotDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BotDaoSource$tryUpdateNew$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BotEntity $local;
    final /* synthetic */ BotEntity $target;
    int label;

    public BotDaoSource$tryUpdateNew$2(BotEntity r100, BotEntity r101, Continuation<? super BotDaoSource$tryUpdateNew$2> r102) {
        this.$target = r100;
        this.$local = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new BotDaoSource$tryUpdateNew$2(this.$target, this.$local, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((BotDaoSource$tryUpdateNew$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r710) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L178;
        ResultKt.throwOnFailure(r710);
        String r100 = this.$target.getName();
        if (r100 != null) goto L7;
        r100 = this.$local.getName();
    L7:
        String r101 = r100;
        String r102 = this.$target.getIconImage();
        if (r102 != null) goto L10;
        r102 = this.$local.getIconImage();
    L10:
        String r103 = r102;
        Integer r104 = this.$target.getBotType();
        if (r104 != null) goto L13;
        r104 = this.$local.getBotType();
    L13:
        Integer r105 = r104;
        String r106 = this.$target.getShareInfo();
        if (r106 != null) goto L16;
        r106 = this.$local.getShareInfo();
    L16:
        String r110 = r106;
        String r107 = this.$target.getBotCreatorInfo();
        if (r107 != null) goto L19;
        r107 = this.$local.getBotCreatorInfo();
    L19:
        String r111 = r107;
        Integer r108 = this.$target.getPrivateStatus();
        if (r108 != null) goto L22;
        r108 = this.$local.getPrivateStatus();
    L22:
        Integer r112 = r108;
        String r109 = this.$target.getConversationPage();
        if (r109 != null) goto L25;
        r109 = this.$local.getConversationPage();
    L25:
        String r113 = r109;
        String r114 = this.$target.getDescriptionForModel();
        if (r114 != null) goto L28;
        r114 = this.$local.getDescriptionForModel();
    L28:
        String r115 = r114;
        String r116 = this.$target.getDescriptionForHuman();
        if (r116 != null) goto L31;
        r116 = this.$local.getDescriptionForHuman();
    L31:
        String r117 = r116;
        Integer r118 = this.$target.getBotStatus();
        if (r118 != null) goto L34;
        r118 = this.$local.getBotStatus();
    L34:
        Integer r119 = r118;
        String r120 = this.$target.getModel();
        if (r120 != null) goto L37;
        r120 = this.$local.getModel();
    L37:
        String r210 = r120;
        String r121 = this.$target.getVoiceType();
        if (r121 != null) goto L40;
        r121 = this.$local.getVoiceType();
    L40:
        String r211 = r121;
        String r122 = this.$target.getEditPos();
        if (r122 != null) goto L43;
        r122 = this.$local.getEditPos();
    L43:
        String r212 = r122;
        boolean r213 = this.$target.getMuted();
        Integer r123 = this.$target.getRecommendIndex();
        if (r123 != null) goto L46;
        r123 = this.$local.getRecommendIndex();
    L46:
        Integer r214 = r123;
        Boolean r124 = this.$target.getMessagePush();
        if (r124 != null) goto L49;
        r124 = this.$local.getMessagePush();
    L49:
        Boolean r215 = r124;
        Boolean r125 = this.$target.getShowMessagePush();
        if (r125 != null) goto L52;
        r125 = this.$local.getShowMessagePush();
    L52:
        Boolean r216 = r125;
        String r126 = this.$target.getBio();
        if (r126 != null) goto L55;
        r126 = this.$local.getBio();
    L55:
        String r217 = r126;
        String r127 = this.$target.getBotStatistic();
        if (r127 != null) goto L58;
        r127 = this.$local.getBotStatistic();
    L58:
        String r218 = r127;
        String r128 = this.$target.getAnswerActions();
        if (r128 != null) goto L61;
        r128 = this.$local.getAnswerActions();
    L61:
        String r310 = r128;
        String r129 = this.$target.getAnswerActionExposurePriority();
        if (r129 != null) goto L64;
        r129 = this.$local.getAnswerActionExposurePriority();
    L64:
        String r311 = r129;
        String r130 = this.$target.getStreamingAnswerActions();
        if (r130 != null) goto L67;
        r130 = this.$local.getStreamingAnswerActions();
    L67:
        String r312 = r130;
        String r131 = this.$target.getMenuActions();
        if (r131 != null) goto L70;
        r131 = this.$local.getMenuActions();
    L70:
        String r313 = r131;
        String r132 = this.$target.getBotConf();
        if (r132 != null) goto L73;
        r132 = this.$local.getBotConf();
    L73:
        String r314 = r132;
        int r315 = this.$target.getBotMode();
        String r133 = this.$target.getBgImgUrl();
        if (r133 != null) goto L76;
        r133 = this.$local.getBgImgUrl();
    L76:
        String r316 = r133;
        String r134 = this.$target.getBgImgColor();
        if (r134 != null) goto L79;
        r134 = this.$local.getBgImgColor();
    L79:
        String r317 = r134;
        String r135 = this.$target.getBgVideoModel();
        if (r135 != null) goto L82;
        r135 = this.$local.getBgVideoModel();
    L82:
        String r318 = r135;
        String r136 = this.$target.getIconPrompt();
        if (r136 != null) goto L85;
        r136 = this.$local.getIconPrompt();
    L85:
        String r410 = r136;
        String r137 = this.$target.getCallerName();
        if (r137 != null) goto L88;
        r137 = this.$local.getCallerName();
    L88:
        String r411 = r137;
        Boolean r138 = this.$target.getCallerNameSettings();
        if (r138 != null) goto L91;
        r138 = this.$local.getCallerNameSettings();
    L91:
        Boolean r412 = r138;
        String r139 = this.$target.getFirstMet();
        if (r139 != null) goto L94;
        r139 = this.$local.getFirstMet();
    L94:
        String r413 = r139;
        String r414 = this.$target.getCameraTabConfigMap();
        String r140 = this.$target.getBotMemoryConfig();
        if (r140 != null) goto L97;
        r140 = this.$local.getBotMemoryConfig();
    L97:
        String r510 = r140;
        String r141 = this.$target.getCallImgConfig();
        if (r141 != null) goto L100;
        r141 = this.$local.getCallImgConfig();
    L100:
        String r511 = r141;
        String r142 = this.$target.getBotFeatureLabel();
        if (r142 != null) goto L103;
        r142 = this.$local.getBotFeatureLabel();
    L103:
        String r415 = r142;
        String r143 = this.$target.getBgImgUri();
        if (r143 != null) goto L106;
        r143 = this.$local.getBgImgUri();
    L106:
        String r416 = r143;
        String r144 = this.$target.getBgImgInfo();
        if (r144 != null) goto L109;
        r144 = this.$local.getBgImgInfo();
    L109:
        String r512 = r144;
        String r145 = this.$target.getExtra();
        if (r145 != null) goto L112;
        r145 = this.$local.getExtra();
    L112:
        String r610 = r145;
        String r146 = this.$target.getBotIconMappedAppIcon();
        if (r146 != null) goto L115;
        r146 = this.$local.getBotIconMappedAppIcon();
    L115:
        String r513 = r146;
        String r147 = this.$target.getDynamicImgUri();
        if (r147 != null) goto L118;
        r147 = this.$local.getDynamicImgUri();
    L118:
        String r514 = r147;
        String r148 = this.$target.getDynamicImgUrl();
        if (r148 != null) goto L121;
        r148 = this.$local.getDynamicImgUrl();
    L121:
        String r515 = r148;
        String r149 = this.$target.getSceneModelList();
        if (r149 != null) goto L124;
        r149 = this.$local.getSceneModelList();
    L124:
        String r417 = r149;
        String r150 = this.$target.getBioEdit();
        if (r150 != null) goto L127;
        r150 = this.$local.getBioEdit();
    L127:
        String r219 = r150;
        String r151 = this.$target.getMessagePushSwitchConfirmTitle();
        if (r151 != null) goto L130;
        r151 = this.$local.getMessagePushSwitchConfirmTitle();
    L130:
        String r516 = r151;
        String r152 = this.$target.getTagList();
        if (r152 != null) goto L133;
        r152 = this.$local.getTagList();
    L133:
        String r153 = r152;
        String r154 = this.$target.getSelectTextActions();
        if (r154 != null) goto L136;
        r154 = this.$local.getSelectTextActions();
    L136:
        String r155 = r154;
        Integer r156 = this.$target.getStatus();
        if (r156 != null) goto L139;
        r156 = this.$local.getStatus();
    L139:
        Integer r157 = r156;
        String r158 = this.$target.getMsgRegenModeList();
        if (r158 != null) goto L142;
        r158 = this.$local.getMsgRegenModeList();
    L142:
        String r517 = r158;
        String r159 = this.$target.getUnavailableInstructionTypeList();
        if (r159 != null) goto L145;
        r159 = this.$local.getUnavailableInstructionTypeList();
    L145:
        String r518 = r159;
        String r160 = this.$target.getServiceBotConf();
        if (r160 != null) goto L148;
        r160 = this.$local.getServiceBotConf();
    L148:
        String r519 = r160;
        String r161 = this.$target.getLoadingConf();
        if (r161 != null) goto L151;
        r161 = this.$local.getLoadingConf();
    L151:
        String r611 = r161;
        String r162 = this.$target.getActionScenes();
        if (r162 != null) goto L154;
        r162 = this.$local.getActionScenes();
    L154:
        String r319 = r162;
        Integer r163 = this.$target.getLikeInfoShow();
        if (r163 != null) goto L157;
        r163 = this.$local.getLikeInfoShow();
    L157:
        Integer r612 = r163;
        Integer r164 = this.$target.getLikeInfoLiked();
        if (r164 != null) goto L160;
        r164 = this.$local.getLikeInfoLiked();
    L160:
        Integer r613 = r164;
        Long r165 = this.$target.getLikeInfoCount();
        if (r165 != null) goto L163;
        r165 = this.$local.getLikeInfoCount();
    L163:
        Long r614 = r165;
        Integer r166 = this.$target.getBotCommentInfoShow();
        if (r166 != null) goto L166;
        r166 = this.$local.getBotCommentInfoShow();
    L166:
        Integer r615 = r166;
        Long r167 = this.$target.getBotCommentInfoCount();
        if (r167 != null) goto L169;
        r167 = this.$local.getBotCommentInfoCount();
    L169:
        Long r616 = r167;
        Boolean r168 = this.$target.isDisable();
        if (r168 != null) goto L172;
        r168 = this.$local.isDisable();
    L172:
        Boolean r617 = r168;
        String r169 = this.$target.getSwitchConfInfo();
        if (r169 != null) goto L175;
        r169 = this.$local.getSwitchConfInfo();
    L175:
        BotEntity r170 = this.$local;
        BotEntity r171 = BotEntity.copy$default(r170, null, r101, r103, 0, null, r105, r110, r111, r153, r155, r112, r113, r115, r117, r119, r157, r210, r211, r212, r213, r214, r215, r216, r217, r219, r218, r310, r319, r311, r313, r312, r314, r315, r316, r317, r318, r410, r169, r411, r412, r417, r413, r414, r415, null, r416, r512, r510, r511, r513, r514, r515, r516, r517, r518, r519, r611, r612, r613, r614, r615, r616, r610, r617, 25, 4096, null);
        int r172 = BotDaoSource.f347922e;
        BotDaoSource.a.a().insertBot(r171);
        return Unit.INSTANCE;
    L178:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
