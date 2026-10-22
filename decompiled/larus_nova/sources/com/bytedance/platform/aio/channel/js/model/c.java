package com.bytedance.platform.aio.channel.js.model;

import com.amap.api.col.s.ce;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/c;", "Lcom/bytedance/platform/aio/channel/js/model/h;", "", "category", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "message", "d", ce.f26391f, "", "extra", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "f", "(Ljava/util/Map;)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class c extends h {

    @SerializedName("category")
    private String category;

    @SerializedName("extra")
    private Map<String, String> extra;

    @SerializedName("message")
    private String message;

    public c() {
        this.category = "";
        this.message = "";
        this.extra = MapsKt.emptyMap();
    }

    public final String b() {
        return this.category;
    }

    public final Map<String, String> c() {
        return this.extra;
    }

    public final String d() {
        return this.message;
    }

    public final void a(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$encodeFields");
        r100.d(this.category, 1);
        r100.d(this.message, 2);
        Iterator<Map.Entry<String, String>> r101 = this.extra.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Map.Entry<String, String> r102 = r101.next();
        String r103 = r102.getKey();
        String r104 = r102.getValue();
        ArrayList r105 = new ArrayList();
        String r106 = r103;
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.add(new com.bytedance.tools.kcp.modelx.runtime.protobuf.h(1, r106));
        String r107 = r104;
        Intrinsics.checkNotNullParameter(r107, "value");
        r105.add(new com.bytedance.tools.kcp.modelx.runtime.protobuf.h(2, r107));
        MessagePayload r108 = new MessagePayload(3, r105);
        if (r100.f271000b == false) goto L9;
        if (r108.d() == false) goto L4;
    L9:
        ((ArrayList) r100.f270999a).add(r108);
        goto L4
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.category = r100;
    }

    public final void f(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extra = r100;
    }

    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.message = r100;
    }
}
