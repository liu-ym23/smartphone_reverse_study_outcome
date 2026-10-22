package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lw20/ie;", "", "", "toUserID", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setToUserID", "(Ljava/lang/String;)V", "emojiID", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEmojiID", "requestPage", "b", "setRequestPage", "<init>", "()V", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ie {

    @SerializedName("emojiID")
    private String emojiID;

    @SerializedName("requestPage")
    private String requestPage;

    @SerializedName("toUserID")
    private String toUserID;

    public ie() {
    }

    public final String a() {
        return this.emojiID;
    }

    public final String b() {
        return this.requestPage;
    }

    public final String c() {
        return this.toUserID;
    }
}
