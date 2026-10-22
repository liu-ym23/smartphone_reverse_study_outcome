package di;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019¨\u0006\u001f"}, d2 = {"Ldi/e;", "", "", "priorityLevel", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "setPriorityLevel", "(Ljava/lang/Integer;)V", "", "requestCompressType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setRequestCompressType", "(Ljava/lang/String;)V", "responseCompressType", "c", "setResponseCompressType", "", "toResponseStartTime", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "setToResponseStartTime", "(Ljava/lang/Long;)V", "toResponseEndTime", "d", "setToResponseEndTime", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("priorityLevel")
    private Integer priorityLevel;

    @SerializedName("requestCompressType")
    private String requestCompressType;

    @SerializedName("responseCompressType")
    private String responseCompressType;

    @SerializedName("toResponseEndTime")
    private Long toResponseEndTime;

    @SerializedName("toResponseStartTime")
    private Long toResponseStartTime;

    public e() {
    }

    public final Integer a() {
        return this.priorityLevel;
    }

    public final String b() {
        return this.requestCompressType;
    }

    public final String c() {
        return this.responseCompressType;
    }

    public final Long d() {
        return this.toResponseEndTime;
    }

    public final Long e() {
        return this.toResponseStartTime;
    }
}
