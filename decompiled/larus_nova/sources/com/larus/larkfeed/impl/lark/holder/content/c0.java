package com.larus.larkfeed.impl.lark.holder.content;

import android.content.Context;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.TranslateInfo;
import com.bytedance.lark.pb.office_sdk.basic.DoubaoContent;
import com.larus.bmhome.chat.messagetransfer.IFlowMergeForwardService;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseTextContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c0 implements gya.a<DouBaoContent> {
    public c0() {
    }

    @Override // gya.a
    public final boolean b() {
        return false;
    }

    @Override // gya.a
    public final boolean c() {
        return false;
    }

    @Override // gya.a
    public final MessageType a() {
        return MessageType.DOUBAO;
    }

    public static String j(Context r100, DouBaoContent r101) {
        IFlowMergeForwardService r102 = (IFlowMergeForwardService) ServiceManager.get().getService(IFlowMergeForwardService.class);
        if (r102 == null) goto L8;
        byte[] r103 = r101.getData();
        if (r103 != null) goto L7;
        r103 = new byte[0];
    L7:
        String r104 = r102.e(r100, r103);
    L9:
        if (r104 != null) goto L12;
        return "";
    L12:
        return r104;
    L8:
        r104 = null;
        goto L9
    }

    @Override // gya.a
    public final String d(Context r100, Content r101) {
        DouBaoContent r102 = (DouBaoContent) r101;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "content");
        return j(r100, r102);
    }

    @Override // gya.a
    public final String f(Context r100, Content r101) {
        DouBaoContent r102 = (DouBaoContent) r101;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "content");
        return j(r100, r102);
    }

    @Override // gya.a
    public final String h(Context r100, f5b.b r101) {
        gya.a.C6083a.a(r100, r101);
        return null;
    }

    @Override // gya.a
    public final Content g(Entity r100, Message r101, com.bytedance.lark.pb.basic.v1.Content r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "pbContent");
        DoubaoContent r103 = r102.doubao_content;
        if (r103 != null) goto L5;
        return null;
    L5:
        DouBaoContent r104 = new DouBaoContent();
        r104.setId(r103.doubao_msg_id);
        r104.setData(r103.doubao_data.toByteArray());
        r104.setLarkMessageId(r101.getId());
        return r104;
    }

    @Override // gya.a
    public final Content e(Entity r100, Message r101, com.bytedance.lark.pb.basic.v1.Content r102, TranslateInfo r103) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "pbContent");
        return null;
    }

    @Override // gya.a
    public final void i(com.bytedance.lark.pb.basic.v1.Content r100, BaseTextContent<?> r101, String r102, Entity r103) {
        gya.a.C6083a.b(r100, r101, r102);
    }
}
