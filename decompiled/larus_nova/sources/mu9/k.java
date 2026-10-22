package mu9;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/doc/DocFusionConfigV2;", "", BaseHttpRequestInfo.KEY_HIT, "", "initOfficeSdkStrategy", "initOfficeSdkDelay", "", "preloadWebViewStrategy", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getHit", "()Ljava/lang/String;", "getInitOfficeSdkStrategy", "getInitOfficeSdkDelay", "()I", "getPreloadWebViewStrategy", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName(BaseHttpRequestInfo.KEY_HIT)
    private final String hit;

    @SerializedName("init_officesdk_delay")
    private final int initOfficeSdkDelay;

    @SerializedName("init_officesdk_strategy")
    private final String initOfficeSdkStrategy;

    @SerializedName("preload_doc_strategy")
    private final String preloadWebViewStrategy;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.hit, r101.hit) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.initOfficeSdkStrategy, r101.initOfficeSdkStrategy) == true) goto L15;
        return false;
    L15:
        if (this.initOfficeSdkDelay == r101.initOfficeSdkDelay) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preloadWebViewStrategy, r101.preloadWebViewStrategy) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.hit;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.initOfficeSdkStrategy;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.initOfficeSdkDelay) * 31;
        String r107 = this.preloadWebViewStrategy;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DocFusionConfigV2(hit=" + this.hit + ", initOfficeSdkStrategy=" + this.initOfficeSdkStrategy + ", initOfficeSdkDelay=" + this.initOfficeSdkDelay + ", preloadWebViewStrategy=" + this.preloadWebViewStrategy + ')';
    }

    public final String a() {
        return this.hit;
    }

    public final int b() {
        return this.initOfficeSdkDelay;
    }

    public final String c() {
        return this.initOfficeSdkStrategy;
    }

    public final String d() {
        return this.preloadWebViewStrategy;
    }

    public k(int r100) {
        this.hit = "true";
        this.initOfficeSdkStrategy = "init_after_cold_start";
        this.initOfficeSdkDelay = 0;
        this.preloadWebViewStrategy = "preload_if_opened_before";
    }
}
