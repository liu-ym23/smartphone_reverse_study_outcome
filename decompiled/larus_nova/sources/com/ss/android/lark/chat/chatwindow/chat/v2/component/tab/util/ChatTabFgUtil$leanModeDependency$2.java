package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import w4b.c;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/core/dependency/ChatCoreDependency$LeanModeDependency;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatTabFgUtil$leanModeDependency$2 extends Lambda implements Function0<c.m> {
    public static final ChatTabFgUtil$leanModeDependency$2 INSTANCE = null;

    static {
        INSTANCE = new ChatTabFgUtil$leanModeDependency$2();
    }

    public ChatTabFgUtil$leanModeDependency$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final c.m invoke2() {
        ChatCoreModule.a().getLeanModeDependency();
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c.m invoke() {
        invoke2();
        return null;
    }
}
