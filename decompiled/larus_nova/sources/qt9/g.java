package qt9;

import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\""}, d2 = {"Lcom/larus/settings/provider/AppletLiteUsageConfig;", "", "replaceRuyi", "", "replaceOtherLynxView", "replaceLynxPage", "lynxPageHostWhitelist", "", "", "lynxViewHostWhitelist", "<init>", "(ZZZLjava/util/List;Ljava/util/List;)V", "getReplaceRuyi", "()Z", "getReplaceOtherLynxView", "getReplaceLynxPage", "getLynxPageHostWhitelist", "()Ljava/util/List;", "getLynxViewHostWhitelist", "getStandardLynxPageHostWhitelist", "getStandardLynxViewHostWhitelist", "handleWhitelist", "originalList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g {

    @SerializedName("lynx_page_host_whitelist")
    private final List<String> lynxPageHostWhitelist;

    @SerializedName("lynx_view_host_whitelist")
    private final List<String> lynxViewHostWhitelist;

    @SerializedName("replace_lynx_page")
    private final boolean replaceLynxPage;

    @SerializedName("replace_other_lynx_view")
    private final boolean replaceOtherLynxView;

    @SerializedName("replace_ruyi")
    private final boolean replaceRuyi;

    public g() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.replaceRuyi == r101.replaceRuyi) goto L12;
        return false;
    L12:
        if (this.replaceOtherLynxView == r101.replaceOtherLynxView) goto L15;
        return false;
    L15:
        if (this.replaceLynxPage == r101.replaceLynxPage) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxPageHostWhitelist, r101.lynxPageHostWhitelist) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.lynxViewHostWhitelist, r101.lynxViewHostWhitelist) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.replaceRuyi == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.replaceOtherLynxView == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.replaceLynxPage == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        List<String> r106 = this.lynxPageHostWhitelist;
        int r107 = 0;
        if (r106 != null) goto L17;
        int r108 = 0;
    L18:
        int r109 = (r105 + r108) * 31;
        List<String> r110 = this.lynxViewHostWhitelist;
        if (r110 == null) goto L23;
        r107 = r110.hashCode();
    L23:
        return r109 + r107;
    L17:
        r108 = r106.hashCode();
        goto L18
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AppletLiteUsageConfig(replaceRuyi=" + this.replaceRuyi + ", replaceOtherLynxView=" + this.replaceOtherLynxView + ", replaceLynxPage=" + this.replaceLynxPage + ", lynxPageHostWhitelist=" + this.lynxPageHostWhitelist + ", lynxViewHostWhitelist=" + this.lynxViewHostWhitelist + ')';
    }

    public final List<String> b() {
        List<String> r100 = this.lynxPageHostWhitelist;
        if (r100 == null) goto L10;
        List r101 = CollectionsKt.filterNotNull(r100);
        if (r101 == null) goto L10;
        return d(r101);
    L10:
        return CollectionsKt.emptyList();
    }

    public final List<String> c() {
        List<String> r100 = this.lynxViewHostWhitelist;
        if (r100 == null) goto L10;
        List r101 = CollectionsKt.filterNotNull(r100);
        if (r101 == null) goto L10;
        return d(r101);
    L10:
        return CollectionsKt.emptyList();
    }

    public final boolean a() {
        return this.replaceLynxPage;
    }

    public g(Object r100) {
        AppHost.Companion r101 = AppHost.f326268a;
        boolean r102 = !r101.isOversea();
        boolean r103 = !r101.isOversea();
        boolean r104 = !r101.isOversea();
        if (r101.isOversea() == true) goto L5;
        List<String> r105 = CollectionsKt.listOf(".bytegecko.com");
    L7:
        if (r101.isOversea() == true) goto L9;
        List<String> r106 = CollectionsKt.listOf(".bytegecko.com");
    L10:
        this.replaceRuyi = r102;
        this.replaceOtherLynxView = r103;
        this.replaceLynxPage = r104;
        this.lynxPageHostWhitelist = r105;
        this.lynxViewHostWhitelist = r106;
        return;
    L9:
        r106 = CollectionsKt.emptyList();
        goto L10
    L5:
        r105 = CollectionsKt.emptyList();
        goto L7
    }

    public static List d(List r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = (String) r102.next();
        if (StringsKt.startsWith$default(r103, ".", false, 2, null) == true) goto L9;
        r103 = "." + r103;
    L9:
        r101.add(r103);
        goto L4
    L10:
        return r101;
    }
}
