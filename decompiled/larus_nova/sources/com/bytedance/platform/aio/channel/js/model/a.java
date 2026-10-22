package com.bytedance.platform.aio.channel.js.model;

import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/a;", "Lcom/bytedance/platform/aio/channel/js/model/g;", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "", "flags", "I", "c", "()I", "e", "(I)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a extends g {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("flags")
    private int flags;

    @Override // com.bytedance.platform.aio.channel.js.model.g
    public final Object a() {
        int r100 = com.bytedance.tools.kcp.modelx.runtime.protobuf.f.f271004a;
        com.bytedance.tools.kcp.modelx.runtime.protobuf.g r101 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.g();
        ArrayList r102 = new ArrayList();
        com.bytedance.tools.kcp.modelx.runtime.protobuf.b r103 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(true);
        Intrinsics.checkNotNullParameter(r103, "$this$encodeFields");
        r103.d(this.channelId, 1);
        r103.c(this.flags, 2);
        MessagePayload r104 = r103.a(3);
        if (r104.d() == false) goto L5;
        r102.add(r104);
    L5:
        new MessagePayload(-1, r102).a(r101);
        return r101.f271005a.readByteArray();
    }

    public a() {
        this.channelId = "";
    }

    public final String b() {
        return this.channelId;
    }

    public final int c() {
        return this.flags;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channelId = r100;
    }

    public final void e(int r100) {
        this.flags = r100;
    }
}
