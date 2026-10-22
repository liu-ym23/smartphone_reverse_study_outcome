package w20;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lw20/da;", "", "", "emojiId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setEmojiId", "(Ljava/lang/String;)V", "fusionEmoji", "b", "setFusionEmoji", "messageSource", "c", "setMessageSource", "Lcom/google/gson/JsonObject;", "extraParams", "Lcom/google/gson/JsonObject;", "getExtraParams", "()Lcom/google/gson/JsonObject;", "setExtraParams", "(Lcom/google/gson/JsonObject;)V", "request_source", "d", "setRequest_source", "<init>", "()V", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class da {

    @SerializedName("emojiId")
    private String emojiId;

    @SerializedName("extraParams")
    private JsonObject extraParams;

    @SerializedName("fusionEmoji")
    private String fusionEmoji;

    @SerializedName("messageSource")
    private String messageSource;

    @SerializedName("request_source")
    private String request_source;

    public da() {
    }

    public final String a() {
        return this.emojiId;
    }

    public final String b() {
        return this.fusionEmoji;
    }

    public final String c() {
        return this.messageSource;
    }

    public final String d() {
        return this.request_source;
    }
}
