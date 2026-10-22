package com.bytedance.platform.aio.channel.js.model;

import com.amap.api.col.s.ce;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/b;", "Lcom/bytedance/platform/aio/channel/js/model/g;", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "interfaceId", "c", ce.f26391f, "methodId", "d", "h", "contentType", "getContentType", "setContentType", "", "preferredContentType", "I", "e", "()I", RXScreenCaptureService.KEY_INDEX, "(I)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b extends g {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("content_type")
    private String contentType;

    @SerializedName("interface_id")
    private String interfaceId;

    @SerializedName("method_id")
    private String methodId;

    @SerializedName("preferred_content_type")
    private int preferredContentType;

    @Override // com.bytedance.platform.aio.channel.js.model.g
    public final Object a() {
        int r100 = com.bytedance.tools.kcp.modelx.runtime.protobuf.f.f271004a;
        com.bytedance.tools.kcp.modelx.runtime.protobuf.g r101 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.g();
        ArrayList r102 = new ArrayList();
        com.bytedance.tools.kcp.modelx.runtime.protobuf.b r103 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(true);
        Intrinsics.checkNotNullParameter(r103, "$this$encodeFields");
        r103.d(this.channelId, 1);
        r103.d(this.interfaceId, 2);
        r103.d(this.methodId, 3);
        r103.d(this.contentType, 4);
        r103.c(this.preferredContentType, 5);
        MessagePayload r104 = r103.a(1);
        if (r104.d() == false) goto L5;
        r102.add(r104);
    L5:
        new MessagePayload(-1, r102).a(r101);
        return r101.f271005a.readByteArray();
    }

    public b() {
        this.channelId = "";
        this.interfaceId = "";
        this.methodId = "";
        this.contentType = "";
        this.preferredContentType = BytesContentType.JSON.getType();
    }

    public final String b() {
        return this.channelId;
    }

    public final String c() {
        return this.interfaceId;
    }

    public final String d() {
        return this.methodId;
    }

    public final int e() {
        return this.preferredContentType;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channelId = r100;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interfaceId = r100;
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.methodId = r100;
    }

    public final void i(int r100) {
        this.preferredContentType = r100;
    }
}
