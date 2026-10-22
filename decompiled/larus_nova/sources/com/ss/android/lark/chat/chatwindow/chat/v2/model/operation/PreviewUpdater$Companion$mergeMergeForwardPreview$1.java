package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/chat/entity/message/Message;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/chat/entity/message/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class PreviewUpdater$Companion$mergeMergeForwardPreview$1 extends Lambda implements Function1<Message, Boolean> {
    final /* synthetic */ Map<String, Map<String, UrlCardPreviewEntity>> $previews;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewUpdater$Companion$mergeMergeForwardPreview$1(Map<String, ? extends Map<String, UrlCardPreviewEntity>> r100) {
        this.$previews = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(Message r100) {
        if (r100 == null) goto L8;
        if (this.$previews.containsKey(r100.getId()) == false) goto L8;
        int r101 = l.f414435c;
        l.a.a(r100, this.$previews.get(r100.getId()));
        return Boolean.TRUE;
    L8:
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Message r100) {
        return invoke2(r100);
    }
}
