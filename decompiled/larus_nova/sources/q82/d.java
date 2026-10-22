package q82;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lq82/d;", "", "", "entry", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEntry", "(Ljava/lang/String;)V", "", "scene", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setScene", "(Ljava/lang/Integer;)V", "btm_token", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBtm_token", "<init>", "()V", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("btm_token")
    private String btm_token;

    @SerializedName("entry")
    private String entry;

    @SerializedName("scene")
    private Integer scene;

    public d() {
    }

    public final String a() {
        return this.btm_token;
    }

    public final String b() {
        return this.entry;
    }

    public final Integer c() {
        return this.scene;
    }
}
