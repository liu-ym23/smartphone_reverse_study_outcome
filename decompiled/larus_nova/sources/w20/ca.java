package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lw20/ca;", "", "", "emojiId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setEmojiId", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "extraParams", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setExtraParams", "(Lcom/google/gson/JsonObject;)V", "messageSource", "c", "setMessageSource", "request_source", "d", "setRequest_source", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ca {

    @SerializedName("emojiId")
    private String emojiId;

    @SerializedName("extraParams")
    private JsonObject extraParams;

    @SerializedName("messageSource")
    private String messageSource;

    @SerializedName("request_source")
    private String request_source;

    public ca() {
    }

    public final String a() {
        return this.emojiId;
    }

    public final JsonObject b() {
        return this.extraParams;
    }

    public final String c() {
        return this.messageSource;
    }

    public final String d() {
        return this.request_source;
    }
}
