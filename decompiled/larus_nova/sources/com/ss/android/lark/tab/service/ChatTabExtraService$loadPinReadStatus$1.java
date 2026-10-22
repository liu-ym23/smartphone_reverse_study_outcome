package com.ss.android.lark.tab.service;

import com.bytedance.lark.pb.im.v1.GetPinReadStatusResponse;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/pb/im/v1/GetPinReadStatusResponse;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/lark/pb/im/v1/GetPinReadStatusResponse;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ChatTabExtraService$loadPinReadStatus$1 extends Lambda implements Function1<GetPinReadStatusResponse, Boolean> {
    public static final ChatTabExtraService$loadPinReadStatus$1 INSTANCE = null;

    static {
        INSTANCE = new ChatTabExtraService$loadPinReadStatus$1();
    }

    public ChatTabExtraService$loadPinReadStatus$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(GetPinReadStatusResponse r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return r100.has_unread_pin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(GetPinReadStatusResponse r100) {
        return invoke2(r100);
    }
}
