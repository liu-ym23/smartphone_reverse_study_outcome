package pc;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006\u001f"}, d2 = {"Lpc/b;", "", "", "event", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setEvent", "(Ljava/lang/String;)V", "", "defaultSend", "I", "d", "()I", "setDefaultSend", "(I)V", "", "allowlist", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setAllowlist", "(Ljava/util/List;)V", "blocklist", "b", "setBlocklist", "chainLength", "c", "setChainLength", "<init>", "()V", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class b {

    @SerializedName("btm_allowlist")
    private List<String> allowlist;

    @SerializedName("btm_blocklist")
    private List<String> blocklist;

    @SerializedName("chain_length")
    private int chainLength;

    @SerializedName("default_send")
    private int defaultSend;

    @SerializedName("event")
    private String event;

    public final int hashCode() {
        return (((((((this.defaultSend * 31) + this.chainLength) * 31) + this.event.hashCode()) * 31) + this.allowlist.hashCode()) * 31) + this.blocklist.hashCode();
    }

    public b() {
        this.event = "";
        this.allowlist = CollectionsKt.emptyList();
        this.blocklist = CollectionsKt.emptyList();
        this.chainLength = 20;
    }

    public final List<String> a() {
        return this.allowlist;
    }

    public final List<String> b() {
        return this.blocklist;
    }

    public final int c() {
        return this.chainLength;
    }

    public final int d() {
        return this.defaultSend;
    }

    public final String e() {
        return this.event;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == false) goto L15;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.event, r101.event) == false) goto L15;
        if (this.defaultSend != r101.defaultSend) goto L15;
        if (c.a(this.allowlist, r101.allowlist) == false) goto L15;
        if (c.a(this.blocklist, r101.blocklist) == false) goto L15;
        if (this.chainLength != r101.chainLength) goto L15;
        return true;
    L15:
        return false;
    }
}
