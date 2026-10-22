package com.bytedance.timonbase.network;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/timonbase/network/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "message", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/google/gson/JsonObject;", "extra", "Lcom/google/gson/JsonObject;", "getExtra", "()Lcom/google/gson/JsonObject;", "", "statusCode", "I", "getStatusCode", "()I", "data", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class a<T> {

    @SerializedName("data")
    private final T data;

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("message")
    private final String message;

    @SerializedName("status_code")
    private final int statusCode;

    public final boolean c() {
        if (this.statusCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T a() {
        return this.data;
    }

    public final String b() {
        return this.message;
    }
}
