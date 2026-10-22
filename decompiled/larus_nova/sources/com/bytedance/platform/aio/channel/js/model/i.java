package com.bytedance.platform.aio.channel.js.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/platform/aio/channel/js/model/i;", "Lcom/bytedance/platform/aio/channel/js/model/g;", "", "interfaceId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setInterfaceId", "(Ljava/lang/String;)V", "<init>", "()V", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i extends g {

    @SerializedName("interface_id")
    private String interfaceId;

    @Override // com.bytedance.platform.aio.channel.js.model.g
    public final Object a() {
        throw new IllegalStateException("deprecated register Service".toString());
    }

    public i() {
        this.interfaceId = "";
    }

    public final String b() {
        return this.interfaceId;
    }
}
