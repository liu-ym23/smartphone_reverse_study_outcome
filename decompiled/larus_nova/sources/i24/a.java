package i24;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Li24/a;", "Ln14/a;", "", "command", "Ljava/lang/String;", "getCommand", "()Ljava/lang/String;", "setCommand", "(Ljava/lang/String;)V", "tokenTemplate", "e", "setTokenTemplate", "logId", "getLogId", "setLogId", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class a extends n14.a {

    @SerializedName("command")
    private String command;

    @SerializedName("log_id")
    private String logId;

    @SerializedName("token_template")
    private String tokenTemplate;

    public a() {
        this.command = "";
        this.tokenTemplate = "";
        this.logId = "";
    }

    public final String e() {
        return this.tokenTemplate;
    }
}
