package d63;

import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ld63/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/VOIdentifier;", "", "mainTitle", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setMainTitle", "(Ljava/lang/String;)V", "", "Ld63/u;", "mainContent", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setMainContent", "(Ljava/util/List;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d extends VOIdentifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f467114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f467115c;

    @SerializedName("main_content")
    private List<u> mainContent;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    private String mainTitle;

    public d() {
        this(null, null, 0, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.mainTitle, r101.mainTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mainContent, r101.mainContent) == true) goto L10;
        return false;
    L10:
        if (this.f467114b == r101.f467114b) goto L12;
        return false;
    L12:
        if (this.f467115c == r101.f467115c) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.mainTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<u> r104 = this.mainContent;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((r103 + r101) * 31) + this.f467114b) * 31;
        boolean r106 = this.f467115c;
        ?? r107 = r106;
        if (r106 == false) goto L13;
        r107 = 1;
    L13:
        return r105 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorV3UnifiedTipsVO(mainTitle=" + this.mainTitle + ", mainContent=" + this.mainContent + ", index=" + this.f467114b + ", lastTip=" + this.f467115c + ")";
    }

    public final List<u> a() {
        return this.mainContent;
    }

    public final String b() {
        return this.mainTitle;
    }

    public d(String r100, List<u> r101, int r102, boolean r103) {
        this.mainTitle = r100;
        this.mainContent = r101;
        this.f467114b = r102;
        this.f467115c = r103;
    }
}
