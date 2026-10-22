package com.bytedance.android.shopping.store.utils;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/store/utils/a0;", "", "", "frequence", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "isFollowed", "Ljava/lang/Boolean;", "g", "()Ljava/lang/Boolean;", "", "popupUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "timeRange", "f", "jumpUrl", "b", "storageKeyPrefix", "d", "storageType", "e", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a0 {

    @SerializedName("frequence")
    private final Integer frequence;

    @SerializedName("is_followed")
    private final Boolean isFollowed;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("popup_url")
    private final String popupUrl;

    @SerializedName("storage_key_prefix")
    private final String storageKeyPrefix;

    @SerializedName("storage_type")
    private final Integer storageType;

    @SerializedName("time_range")
    private final Integer timeRange;

    public a0() {
    }

    public final Integer a() {
        return this.frequence;
    }

    public final String b() {
        return this.jumpUrl;
    }

    public final String c() {
        return this.popupUrl;
    }

    public final String d() {
        return this.storageKeyPrefix;
    }

    public final Integer e() {
        return this.storageType;
    }

    public final Integer f() {
        return this.timeRange;
    }

    public final Boolean g() {
        return this.isFollowed;
    }
}
