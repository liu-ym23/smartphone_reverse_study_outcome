package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabDTO;", "Ljava/io/Serializable;", "", "bundleUrl", "Ljava/lang/String;", "getBundleUrl", "()Ljava/lang/String;", "setBundleUrl", "(Ljava/lang/String;)V", "tmpId", "getTmpId", "setTmpId", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "data", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "getData", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;", "setData", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabData;)V", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabConfig;", "config", "Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabConfig;", "getConfig", "()Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabConfig;", "setConfig", "(Lcom/bytedance/android/shopping/store/home/entity/ECStoreDynamicTabConfig;)V", "", "logExtra", "Ljava/util/Map;", "getLogExtra", "()Ljava/util/Map;", "setLogExtra", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreDynamicTabDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("bundle_url")
    private String bundleUrl;

    @SerializedName("config")
    private ECStoreDynamicTabConfig config;

    @SerializedName("tab_data")
    private ECStoreDynamicTabData data;

    @SerializedName("log_extra")
    private Map<String, String> logExtra;

    @SerializedName("tmp_id")
    private String tmpId;

    public static final class a {
        public a() {
        }

        public static ECStoreDynamicTabDTO a(uj3.j r2) {
            Intrinsics.checkNotNullParameter(r2, "tabVO");
            ECStoreDynamicTabDTO r0 = new ECStoreDynamicTabDTO();
            r0.setBundleUrl(r2.u);
            r0.setTmpId(r2.v);
            r0.setData(r2.w);
            r0.setConfig(r2.x);
            r0.setLogExtra(r2.n);
            return r0;
        }
    }

    static {
        Companion = new a();
    }

    public ECStoreDynamicTabDTO() {
    }

    public final String getBundleUrl() {
        return this.bundleUrl;
    }

    public final ECStoreDynamicTabConfig getConfig() {
        return this.config;
    }

    public final ECStoreDynamicTabData getData() {
        return this.data;
    }

    public final Map<String, String> getLogExtra() {
        return this.logExtra;
    }

    public final String getTmpId() {
        return this.tmpId;
    }

    public final void setBundleUrl(String r1) {
        this.bundleUrl = r1;
    }

    public final void setConfig(ECStoreDynamicTabConfig r1) {
        this.config = r1;
    }

    public final void setData(ECStoreDynamicTabData r1) {
        this.data = r1;
    }

    public final void setLogExtra(Map<String, String> r1) {
        this.logExtra = r1;
    }

    public final void setTmpId(String r1) {
        this.tmpId = r1;
    }
}
