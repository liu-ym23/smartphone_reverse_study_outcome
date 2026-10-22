package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.chat.ChatTab;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "chatTab", "Lcom/ss/android/lark/chat/entity/chat/ChatTab;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/chat/entity/chat/ChatTab;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TabTitleView$showGuideIfNeed$1$1$3 extends Lambda implements Function1<ChatTab, Boolean> {
    public static final TabTitleView$showGuideIfNeed$1$1$3 INSTANCE = null;

    static {
        INSTANCE = new TabTitleView$showGuideIfNeed$1$1$3();
    }

    public TabTitleView$showGuideIfNeed$1$1$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(ChatTab r100) {
        Intrinsics.checkNotNullParameter(r100, "chatTab");
        if (r100.getType() != ChatTab.ChatTabType.DOC_FILE_URL_MERGE) goto L5;
        boolean r101 = true;
    L7:
        return Boolean.valueOf(r101);
    L5:
        r101 = false;
        goto L7
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ChatTab r100) {
        return invoke2(r100);
    }
}
