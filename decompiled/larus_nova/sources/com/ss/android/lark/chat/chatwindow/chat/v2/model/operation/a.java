package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f414420a;

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 == null) goto L14;
        List<ReactionInfo> r102 = r101.getReactionInfoList();
        if (CollectionUtils.isNotEmpty(r102) == false) goto L14;
        Iterator<ReactionInfo> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map<String, ChatChatter> r104 = r103.next().getReactionChatters();
        if (CollectionUtils.isNotEmpty(r104) == false) goto L8;
        ChatChatter r105 = r104.get(this.f414420a);
        if (r105 == null) goto L8;
        r105.setAlias(this.f414420a);
    L14:
        return r101;
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "chatterId");
        Intrinsics.checkNotNullParameter(r101, InstantPlayContext.NICKNAME);
        this.f414420a = r100;
    }
}
