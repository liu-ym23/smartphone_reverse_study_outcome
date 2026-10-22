package x97;

import com.alipay.sdk.m.x.d;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0016"}, d2 = {"Lx97/b;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "Lcom/google/gson/JsonElement;", "conf", "Lcom/google/gson/JsonElement;", "getConf", "()Lcom/google/gson/JsonElement;", "setConf", "(Lcom/google/gson/JsonElement;)V", "cel", "getCel", "setCel", "key", "getKey", "setKey", "ruler-base-ecom_release"}, k = 1, mv = {1, 4, 0})
public class b {

    @SerializedName("cel")
    private String cel;

    @SerializedName("conf")
    private JsonElement conf;

    @SerializedName("key")
    private String key;

    @SerializedName("title")
    private String title;

    public b() {
        this.title = null;
        this.conf = null;
        this.cel = null;
        this.key = null;
    }
}
