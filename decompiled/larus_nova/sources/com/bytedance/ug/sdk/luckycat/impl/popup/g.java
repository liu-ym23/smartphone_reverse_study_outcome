package com.bytedance.ug.sdk.luckycat.impl.popup;

import com.bytedance.forest.model.p;
import com.bytedance.forest.pollyfill.NetWorker;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ug/sdk/luckycat/impl/popup/g;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "", "enableMemoryCache", "Z", "getEnableMemoryCache", "()Z", "setEnableMemoryCache", "(Z)V", "", "size", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "disableCND", "getDisableCND", "setDisableCND", "<init>", "()V", "luckycat_container_release"}, k = 1, mv = {1, 4, 0})
public final class g {

    @SerializedName("disableCDN")
    private boolean disableCND;

    @SerializedName("enableMemoryCache")
    private boolean enableMemoryCache;

    @SerializedName("size")
    private Long size;

    @SerializedName("url")
    private String url;

    public final p a() {
        String r100 = this.url;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        return new p(r100, this.enableMemoryCache, this.size, this.disableCND, NetWorker.Downloader);
    }

    public g() {
        this.url = "";
        this.size = 0L;
    }

    public final String b() {
        return this.url;
    }
}
