package com.bytedance.android.shopping.store.tabkit.model;

import com.bytedance.android.shopping.store.tabkit.events.SecSettingSource;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/c0;", "", "", "", "apiUrlHost", "Ljava/util/List;", "b", "()Ljava/util/List;", "anchorUrlHost", "a", "ssrUrlHost", "c", "", "version", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "verifyMode", "d", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {
    public transient boolean a;

    @SerializedName("anchor_url_host")
    private final List<String> anchorUrlHost;

    @SerializedName("api_url_host")
    private final List<String> apiUrlHost;
    public transient SecSettingSource b;

    @SerializedName("ssr_url_host")
    private final List<String> ssrUrlHost;

    @SerializedName("verify_mode")
    private final Integer verifyMode;

    @SerializedName("version")
    private final Integer version;

    public c0() {
    }

    public final List<String> a() {
        return this.anchorUrlHost;
    }

    public final List<String> b() {
        return this.apiUrlHost;
    }

    public final List<String> c() {
        return this.ssrUrlHost;
    }

    public final Integer d() {
        return this.verifyMode;
    }

    public final Integer e() {
        return this.version;
    }
}
