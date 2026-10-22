package com.bytedance.platform.aio.channel.js.model;

import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.react.bridge.JavaOnlyMap;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/j;", "Lcom/bytedance/platform/aio/channel/js/model/g;", "", RemoteMessageConst.Notification.CHANNEL_ID, "Ljava/lang/String;", "c", "()Ljava/lang/String;", ce.f26391f, "(Ljava/lang/String;)V", "", "data", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/Object;)V", "Lcom/bytedance/platform/aio/channel/js/model/c;", "error", "Lcom/bytedance/platform/aio/channel/js/model/c;", "f", "()Lcom/bytedance/platform/aio/channel/js/model/c;", ce.f26395j, "(Lcom/bytedance/platform/aio/channel/js/model/c;)V", "", "contentType", "I", "d", "()I", "h", "(I)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class j extends g {

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("content_type")
    private int contentType;

    @SerializedName("data")
    private Object data;

    @SerializedName("error")
    private c error;

    @Override // com.bytedance.platform.aio.channel.js.model.g
    public final Object a() {
        Object r100 = this.data;
        if (r100 != null) goto L5;
        int r101 = com.bytedance.tools.kcp.modelx.runtime.protobuf.f.f271004a;
        com.bytedance.tools.kcp.modelx.runtime.protobuf.g r102 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.g();
        ArrayList r103 = new ArrayList();
        com.bytedance.tools.kcp.modelx.runtime.protobuf.b r104 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(true);
        b(r104);
        MessagePayload r105 = r104.a(2);
        if (r105.d() == false) goto L14;
        r103.add(r105);
    L14:
        new MessagePayload(-1, r103).a(r102);
        return r102.f271005a.readByteArray();
    L5:
        if ((r100 instanceof byte[]) == false) goto L10;
        int r106 = com.bytedance.tools.kcp.modelx.runtime.protobuf.f.f271004a;
        com.bytedance.tools.kcp.modelx.runtime.protobuf.g r107 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.g();
        ArrayList r108 = new ArrayList();
        com.bytedance.tools.kcp.modelx.runtime.protobuf.b r109 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(true);
        b(r109);
        MessagePayload r110 = r109.a(2);
        if (r110.d() == false) goto L9;
        r108.add(r110);
    L9:
        new MessagePayload(-1, r108).a(r107);
        return r107.f271005a.readByteArray();
    L10:
        JavaOnlyMap r111 = new JavaOnlyMap();
        r111.put("write_channel", d.a(GsonProtectorUtils.toJsonTree(l97.a.f508113a, this)));
        return r111;
    }

    public j() {
        this.channelId = "";
        this.contentType = BytesContentType.JSON.getType();
    }

    public final String c() {
        return this.channelId;
    }

    public final int d() {
        return this.contentType;
    }

    public final Object e() {
        return this.data;
    }

    public final c f() {
        return this.error;
    }

    public final void b(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$encodeFields");
        r100.d(this.channelId, 1);
        Object r101 = this.data;
        if (r101 != null) goto L12;
        c r102 = this.error;
        if (r102 == null) goto L15;
        com.bytedance.tools.kcp.modelx.runtime.protobuf.b r103 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(r100.f271000b);
        r102.a(r103);
        MessagePayload r104 = r103.a(3);
        if (r100.f271000b == true) goto L9;
    L10:
        ((ArrayList) r100.f270999a).add(r104);
        goto L15
    L9:
        if (r104.d() == true) goto L10;
    L15:
        r100.c(this.contentType, 4);
        return;
    L12:
        if ((r101 instanceof byte[]) == false) goto L14;
        r100.b((byte[]) r101, 2);
        goto L15
    L14:
        r100.d(GsonProtectorUtils.toJson(l97.a.f508113a, r101), 2);
        goto L15
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.channelId = r100;
    }

    public final void h(int r100) {
        this.contentType = r100;
    }

    public final void i(Object r100) {
        this.data = r100;
    }

    public final void j(c r100) {
        this.error = r100;
    }
}
