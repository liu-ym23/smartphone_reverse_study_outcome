package com.bytedance.android.shopping.store.tabkit.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/model/s;", "", "", "containerType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "g", "(Ljava/lang/Integer;)V", "", "bundleUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "jumpUrl", "e", "setJumpUrl", "Lcom/bytedance/android/shopping/store/tabkit/model/a;", "apiConfig", "Lcom/bytedance/android/shopping/store/tabkit/model/a;", "a", "()Lcom/bytedance/android/shopping/store/tabkit/model/a;", "setApiConfig", "(Lcom/bytedance/android/shopping/store/tabkit/model/a;)V", "hybridContainerType", "d", "h", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("api_config")
    private a apiConfig;

    @SerializedName("bundle_url")
    private String bundleUrl;

    @SerializedName("container_type")
    private Integer containerType;

    @SerializedName("extra")
    private String extra;

    @SerializedName("hybrid_container_type")
    private Integer hybridContainerType;

    @SerializedName("jump_url")
    private String jumpUrl;

    public s() {
    }

    public final a a() {
        return this.apiConfig;
    }

    public final String b() {
        return this.bundleUrl;
    }

    public final Integer c() {
        return this.containerType;
    }

    public final Integer d() {
        return this.hybridContainerType;
    }

    public final String e() {
        return this.jumpUrl;
    }

    public final void f(String r1) {
        this.bundleUrl = r1;
    }

    public final void g(Integer r1) {
        this.containerType = r1;
    }

    public final void h(Integer r1) {
        this.hybridContainerType = r1;
    }
}
