package com.bytedance.android.livesdk.livecommerce.network.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetail;", "", "", "duration", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "", "uniqueID", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "", "isShow", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "schema", "getSchema", "resource", "getResource", "pendantImage", "getPendantImage", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetailExtraParams;", "extraParams", "Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetailExtraParams;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/network/response/ECFloatWindowDetailExtraParams;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowDetail {

    @SerializedName("duration")
    private final Integer duration;

    @SerializedName("extraParams")
    private final ECFloatWindowDetailExtraParams extraParams;

    @SerializedName("isShow")
    private final Boolean isShow;

    @SerializedName("pendantImage")
    private final String pendantImage;

    @SerializedName("resource")
    private final String resource;

    @SerializedName("schema")
    private final String schema;

    @SerializedName("uniqueID")
    private final String uniqueID;

    public ECFloatWindowDetail() {
    }

    public final Integer a() {
        return this.duration;
    }

    public final ECFloatWindowDetailExtraParams b() {
        return this.extraParams;
    }

    public final String c() {
        return this.uniqueID;
    }
}
