package e7;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Le7/l0;", "", "", "keepOpen", "Ljava/lang/Boolean;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Boolean;", "setKeepOpen", "(Ljava/lang/Boolean;)V", "Lcom/google/gson/JsonObject;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonObject;", "getContext", "()Lcom/google/gson/JsonObject;", "setContext", "(Lcom/google/gson/JsonObject;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName(PerfLog.PARAM_KEY_CONTEXT_ID)
    private JsonObject context;

    @SerializedName("keepOpen")
    private Boolean keepOpen;

    public l0() {
    }

    public final Boolean a() {
        return this.keepOpen;
    }

    public final JsonObject getContext() {
        return this.context;
    }
}
