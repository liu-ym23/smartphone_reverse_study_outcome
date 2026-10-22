package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Pin;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f414430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f414431c;

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 == null) goto L27;
        List<ReactionInfo> r102 = r101.getReactionInfoList();
        if (CollectionUtils.isNotEmpty(r102) == false) goto L14;
        Iterator<ReactionInfo> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map<String, ChatChatter> r104 = r103.next().getReactionChatters();
        if (CollectionUtils.isNotEmpty(r104) == false) goto L8;
        ChatChatter r105 = r104.get(this.f414430b);
        if (r105 == null) goto L8;
        r105.setNickName(this.f414431c);
    L14:
        ChatChatter r106 = r101.getMessageSender();
        if (r106 != null) goto L17;
    L19:
        Pin r107 = r101.getPin();
        if (r107 == null) goto L27;
        if (Intrinsics.areEqual(r107.getOperatorId(), this.f414430b) == false) goto L27;
        ChatChatter r108 = ImSdkService.d().He(this.f414429a, this.f414430b);
        if (r108 == null) goto L26;
        r108.setNickName(this.f414431c);
    L26:
        r107.setOperatorDisplayName(com.ss.android.lark.chat.utils.m.b(r108, ChatterNameDisplayRule.ALIAS_NICKNAME_NAME, true));
        goto L27
    L17:
        if (Intrinsics.areEqual(r106.getId(), this.f414430b) == false) goto L19;
        r106.setNickName(this.f414431c);
    L27:
        return r101;
    }

    public j(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r101, "chatterId");
        Intrinsics.checkNotNullParameter(r102, InstantPlayContext.NICKNAME);
        this.f414429a = r100;
        this.f414430b = r101;
        this.f414431c = r102;
    }
}
