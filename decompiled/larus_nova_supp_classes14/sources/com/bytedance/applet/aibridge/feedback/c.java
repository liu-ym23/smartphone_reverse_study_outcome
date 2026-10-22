package com.bytedance.applet.aibridge.feedback;

import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import f3.h;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import q99.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements IIMCallback<Message> {
    public final /* synthetic */ SetupFeedbackDataMethod a;
    public final /* synthetic */ e3.d b;
    public final /* synthetic */ AbsSetupFeedbackDataMethodIDL.a c;
    public final /* synthetic */ MsgFeedbackType d;
    public final /* synthetic */ h<AbsSetupFeedbackDataMethodIDL.b> e;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        Intrinsics.checkNotNullParameter(r4, "error");
        h.a.a(this.e, "0_[" + r4.getCode() + "]:" + r4.getTips(), null, null, 14);
    }

    public final void onSuccess(Object r27) {
        Message r1 = (Message) r27;
        Intrinsics.checkNotNullParameter(r1, "result");
        FLogger.a.v("js_fb_setup", "getMsg;[feedback]" + r1.getFeedback() + "[ext]" + r1.getExt());
        SetupFeedbackDataMethod r2 = this.a;
        AbsSetupFeedbackDataMethodIDL.a r3 = this.c;
        MsgFeedbackType r7 = this.d;
        h<AbsSetupFeedbackDataMethodIDL.b> r15 = this.e;
        int r4 = SetupFeedbackDataMethod.b;
        r2.getClass();
        FlowFeedbackServiceDelegate r5 = FlowFeedbackServiceDelegate.a;
        String r6 = r1.getConversationId();
        if (r6 != null) goto L5;
        String r8 = "";
    L6:
        String r9 = r1.getMessageId();
        if (r9 != null) goto L9;
        r9 = "";
    L9:
        Integer r10 = r3.getFeedbackDetailType();
        int r11 = 0;
        if (r10 == null) goto L12;
        int r12 = r10.intValue();
    L13:
        Integer r13 = r3.getFeedbackDetailType();
        if (r13 == null) goto L16;
        r11 = r13.intValue();
    L16:
        r5.g(new m(new yc9.m(r8, r9, r7, r12, CollectionsKt.listOf(Integer.valueOf(r11)), r3.getFeedbackDetailContent(), null, r3.getScene(), r3.getEntityId(), r3.getEntityType(), null, false, r3.getExtra(), 3136), 8, null, null, null, null, null, 124), new d(r15));
        return;
    L12:
        r12 = 0;
        goto L13
    L5:
        r8 = r6;
        goto L6
    }

    public c(SetupFeedbackDataMethod r1, e3.d r2, AbsSetupFeedbackDataMethodIDL.a r3, MsgFeedbackType r4, h<AbsSetupFeedbackDataMethodIDL.b> r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
