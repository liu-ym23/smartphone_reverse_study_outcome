package nj0;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lnj0/h;", "", "", "userId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "text", "c", "setText", "", "sequence", "I", "b", "()I", "setSequence", "(I)V", "", "definite", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setDefinite", "(Z)V", "<init>", "()V", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h {

    @SerializedName("definite")
    private boolean definite;

    @SerializedName("sequence")
    private int sequence;

    @SerializedName("text")
    private String text;

    @SerializedName("user_id")
    private String userId;

    public h() {
        this.userId = "";
        this.text = "";
    }

    public final boolean a() {
        return this.definite;
    }

    public final int b() {
        return this.sequence;
    }

    public final String c() {
        return this.text;
    }

    public final String d() {
        return this.userId;
    }
}
