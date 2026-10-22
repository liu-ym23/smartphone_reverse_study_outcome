package com.larus.larkfeed.impl.lark.holder.content;

import android.app.Application;
import com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService;
import com.larus.common.apphost.AppHost;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b0 implements v5b.b<a0> {
    public b0() {
    }

    @Override // v5b.b
    public final MessageType a() {
        return MessageType.DOUBAO;
    }

    @Override // v5b.b
    public final CharSequence b(p5b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        DouBaoContent r101 = (DouBaoContent) r100.getMessage().getContent();
        IFlowMergeForwardService r102 = (IFlowMergeForwardService) ServiceManager.get().getService(IFlowMergeForwardService.class);
        if (r102 == null) goto L8;
        Application r103 = AppHost.f326268a.getApplication();
        byte[] r104 = r101.getData();
        if (r104 != null) goto L7;
        r104 = new byte[0];
    L7:
        String r105 = r102.e(r103, r104);
    L9:
        if (r105 != null) goto L12;
        return "";
    L12:
        return r105;
    L8:
        r105 = null;
        goto L9
    }

    @Override // v5b.b
    public final v5b.a c(p5b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        return new a0((DouBaoContent) r100.getMessage().getContent());
    }
}
