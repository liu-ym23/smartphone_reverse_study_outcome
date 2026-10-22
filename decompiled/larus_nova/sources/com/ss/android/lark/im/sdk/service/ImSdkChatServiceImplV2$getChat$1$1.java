package com.ss.android.lark.im.sdk.service;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.chat.entity.chat.Chat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "it", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImSdkChatServiceImplV2$getChat$1$1 extends Lambda implements Function1<Map<String, ? extends Chat>, Chat> {
    final /* synthetic */ String $chatId;

    public ImSdkChatServiceImplV2$getChat$1$1(String r100) {
        this.$chatId = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Chat invoke2(Map<String, ? extends Chat> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.get(this.$chatId);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Chat invoke(Map<String, ? extends Chat> r100) {
        return invoke2(r100);
    }
}
