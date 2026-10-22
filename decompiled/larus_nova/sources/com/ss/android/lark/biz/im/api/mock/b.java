package com.ss.android.lark.biz.im.api.mock;

import android.app.Activity;
import com.bytedance.lark.pb.basic.v1.CardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.compose.chatsetting.bridge.SelectChatMessagesBridge$SelectChatMessagesBridgeHandler$handle$messageSelectCallback$1;
import com.ss.android.lark.forwardv3.configuration.BasicDialogContentConfig;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements com.ss.android.lark.biz.im.api.d {
    public b() {
    }

    @Override // com.ss.android.lark.biz.im.api.d
    public final gya.a<Content> a(MessageType r100) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        return null;
    }

    @Override // com.ss.android.lark.biz.im.api.d
    public final void e() {
    }

    @Override // com.ss.android.lark.biz.im.api.d
    public final BasicDialogContentConfig b() {
        return new BasicDialogContentConfig();
    }

    @Override // com.ss.android.lark.biz.im.api.d
    public final List<gya.a<Content>> d() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.biz.im.api.d
    public final CardContent c(com.ss.android.lark.chat.entity.message.content.CardContent r100) {
        Intrinsics.checkNotNullParameter(r100, "cardContent");
        return new CardContent.Builder().build();
    }

    @Override // com.ss.android.lark.biz.im.api.d
    public final void f(Activity r100, String r101, Map r102, SelectChatMessagesBridge$SelectChatMessagesBridgeHandler$handle$messageSelectCallback$1 r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        Intrinsics.checkNotNullParameter(r103, "callback");
    }
}
