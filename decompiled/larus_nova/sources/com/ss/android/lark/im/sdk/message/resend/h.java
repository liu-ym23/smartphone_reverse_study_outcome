package com.ss.android.lark.im.sdk.message.resend;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.im.sdk.service.ImSdkMessageServiceImplV2$resendMessage$reSendMessageCallback$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements jkb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f425962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IGetDataCallback<String> f425963b;

    public h(Message r100, ImSdkMessageServiceImplV2$resendMessage$reSendMessageCallback$1 r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f425962a = r100;
        this.f425963b = r101;
    }
}
