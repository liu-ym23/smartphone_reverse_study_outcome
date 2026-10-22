package r14;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b,\u0010-R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010&\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\b¨\u0006."}, d2 = {"Lr14/i;", "", "", "vote", "Z", "c", "()Z", "setVote", "(Z)V", "warn", "d", "setWarn", "riskSink", "getRiskSink", "setRiskSink", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "postContent", "getPostContent", "setPostContent", "warnLevel", "getWarnLevel", "setWarnLevel", "url", "getUrl", "setUrl", "iconUrl", "b", "setIconUrl", "notice", "getNotice", "setNotice", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class i {

    @SerializedName("content")
    private String content;

    @SerializedName("icon_url")
    private String iconUrl;

    @SerializedName("notice")
    private boolean notice;

    @SerializedName("post_content")
    private String postContent;

    @SerializedName("risk_sink")
    private boolean riskSink;

    @SerializedName("type")
    private int type;

    @SerializedName("url")
    private String url;

    @SerializedName("vote")
    private boolean vote;

    @SerializedName("warn")
    private boolean warn;

    @SerializedName("warn_level")
    private int warnLevel;

    public static final class a {
    }

    static {
    }

    public i() {
    }

    public final String a() {
        return this.content;
    }

    public final String b() {
        return this.iconUrl;
    }

    public final boolean c() {
        return this.vote;
    }

    public final boolean d() {
        return this.warn;
    }

    public final int getType() {
        return this.type;
    }
}
