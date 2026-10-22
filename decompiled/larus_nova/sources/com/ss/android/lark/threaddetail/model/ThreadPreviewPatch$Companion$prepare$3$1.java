package com.ss.android.lark.threaddetail.model;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.message.Message;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ThreadPreviewPatch$Companion$prepare$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LinkedHashMap<String, MessageLink> $preparedLinks;
    final /* synthetic */ Message $target;

    public ThreadPreviewPatch$Companion$prepare$3$1(Message r100, LinkedHashMap<String, MessageLink> r101) {
        this.$target = r100;
        this.$preparedLinks = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LinkedHashMap<String, MessageLink> r100 = this.$target.getMessageLinkMap();
        if (r100 != null) goto L5;
        this.$target.setMessageLinkMap(this.$preparedLinks);
        return;
    L5:
        r100.putAll(this.$preparedLinks);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
