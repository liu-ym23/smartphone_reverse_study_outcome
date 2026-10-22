package t06;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0000\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0005\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001a"}, d2 = {"Lt06/a0;", "Lt06/a;", "", "", "whiteParentDomainList", "Ljava/util/List;", "getWhiteParentDomainList", "()Ljava/util/List;", "whiteWholeDomainList", "getWhiteWholeDomainList", "whiteUrlRegList", "getWhiteUrlRegList", "excludeWhiteUrlRegList", "getExcludeWhiteUrlRegList", "redirectBlackProtocol", "c", "redirectBlackUrlReg", "d", "blackUrlReg", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "riskInfoPage", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "skipVerifyProtocol", "f", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class a0 extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.ies.argus.util.g.a f544125a;

    @SerializedName("black_url_reg")
    private final List<String> blackUrlReg;

    @SerializedName("exclude_white_url_reg")
    private final List<String> excludeWhiteUrlRegList;

    @SerializedName("redirect_black_protocol")
    private final List<String> redirectBlackProtocol;

    @SerializedName("redirect_black_url_reg")
    private final List<String> redirectBlackUrlReg;

    @SerializedName("risk_info_page")
    private final String riskInfoPage;

    @SerializedName("skip_verify_protocol")
    private final List<String> skipVerifyProtocol;

    @SerializedName("white_parent_domain")
    private final List<String> whiteParentDomainList;

    @SerializedName("white_url_reg")
    private final List<String> whiteUrlRegList;

    @SerializedName("white_whole_domain")
    private final List<String> whiteWholeDomainList;

    public final com.bytedance.ies.argus.util.g.a b() {
        if (this.f544125a != null) goto L26;
        com.bytedance.ies.argus.util.g.a r100 = new com.bytedance.ies.argus.util.g.a();
        List<String> r101 = this.whiteWholeDomainList;
        if (r101 == null) goto L11;
        List<String> r102 = r101;
        LinkedHashMap r103 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r102, 10)), 16));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Object r105 = r104.next();
        String r106 = (String) r105;
        r103.put(r105, 1);
        goto L8
    L10:
        r100.f246259a = r103;
    L11:
        List<String> r107 = this.whiteParentDomainList;
        if (r107 == null) goto L18;
        List<String> r108 = r107;
        LinkedHashMap r109 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r108, 10)), 16));
        Iterator<T> r110 = r108.iterator();
    L15:
        if (r110.hasNext() == false) goto L17;
        Object r111 = r110.next();
        String r112 = (String) r111;
        r109.put(r111, 1);
        goto L15
    L17:
        r100.f246260b = r109;
    L18:
        List<String> r113 = this.whiteUrlRegList;
        if (r113 == null) goto L21;
        r100.f246261c = r113;
    L21:
        List<String> r114 = this.excludeWhiteUrlRegList;
        if (r114 == null) goto L24;
        r100.f246262d = r114;
    L24:
        this.f544125a = r100;
    L26:
        return this.f544125a;
    }

    public a0() {
        this.whiteParentDomainList = null;
        this.whiteWholeDomainList = null;
        this.whiteUrlRegList = null;
        this.excludeWhiteUrlRegList = null;
        this.redirectBlackProtocol = null;
        this.redirectBlackUrlReg = null;
        this.blackUrlReg = null;
        this.riskInfoPage = null;
        this.skipVerifyProtocol = null;
    }

    public final List<String> a() {
        return this.blackUrlReg;
    }

    public final List<String> c() {
        return this.redirectBlackProtocol;
    }

    public final List<String> d() {
        return this.redirectBlackUrlReg;
    }

    public final String e() {
        return this.riskInfoPage;
    }

    public final List<String> f() {
        return this.skipVerifyProtocol;
    }
}
