package e7;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Le7/e0;", "", "", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "Lcom/google/gson/JsonObject;", "header", "Lcom/google/gson/JsonObject;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/google/gson/JsonObject;", "setHeader", "(Lcom/google/gson/JsonObject;)V", "", "protocols", "Ljava/util/List;", "b", "()Ljava/util/List;", "setProtocols", "(Ljava/util/List;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName("header")
    private JsonObject header;

    @SerializedName("protocols")
    private List<String> protocols;

    @SerializedName("url")
    private String url;

    public e0() {
    }

    public final JsonObject a() {
        return this.header;
    }

    public final List<String> b() {
        return this.protocols;
    }

    public final String c() {
        return this.url;
    }
}
