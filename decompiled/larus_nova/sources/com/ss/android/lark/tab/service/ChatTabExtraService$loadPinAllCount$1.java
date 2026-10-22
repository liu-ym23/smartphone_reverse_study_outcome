package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.GetChatPinCountResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/pb/im/v1/GetChatPinCountResponse;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/lark/pb/im/v1/GetChatPinCountResponse;)Ljava/lang/Integer;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatTabExtraService$loadPinAllCount$1 extends Lambda implements Function1<GetChatPinCountResponse, Integer> {
    public static final ChatTabExtraService$loadPinAllCount$1 INSTANCE = null;

    static {
        INSTANCE = new ChatTabExtraService$loadPinAllCount$1();
    }

    public ChatTabExtraService$loadPinAllCount$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Integer invoke2(GetChatPinCountResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Integer.valueOf((int) r100.count.longValue());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(GetChatPinCountResponse r100) {
        return invoke2(r100);
    }
}
