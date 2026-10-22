package com.ss.android.lark.chat.message.menu.provider;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.biz.im.extension.PageType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/biz/im/extension/PageType;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatCopyResourceActionProvider$supportedPageTypes$2 extends Lambda implements Function0<List<? extends PageType>> {
    public static final ChatCopyResourceActionProvider$supportedPageTypes$2 INSTANCE = null;

    static {
        INSTANCE = new ChatCopyResourceActionProvider$supportedPageTypes$2();
    }

    public ChatCopyResourceActionProvider$supportedPageTypes$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends PageType> invoke2() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.CHAT_THREAD, PageType.REPLY_IN_THREAD, PageType.MERGE_FORWARD, PageType.THREAD_FORWARD});
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends PageType> invoke() {
        return invoke2();
    }
}
