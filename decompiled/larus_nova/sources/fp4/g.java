package fp4;

import com.bytedance.ee.bear.bitable.card.model.jsmodel.defaultvaluerule.DefaultValueRule;
import com.bytedance.ee.bear.bitable.common.model.field.AllowedEditModes;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes15.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cp4.b f478254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f478255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f478256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FieldCompositeType f478257d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AllowedEditModes f478258e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ep4.a f478259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f478260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f478261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f478262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f478263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap<Integer, ArrayList<String>> f478264k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f478265l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DefaultValueRule f478266m;

    public final int hashCode() {
        cp4.b r100 = this.f478254a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f478255b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "STField{table=" + this.f478254a + ", fieldId='" + this.f478255b + "'}";
    }

    public g(g r110) {
        this(r110.f478254a, r110.f478255b, r110.f478256c, r110.f478257d, r110.f478258e, r110.f478259f, r110.f478260g, r110.f478261h, r110.f478262i, r110.f478265l, r110.f478266m);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        cp4.b r102 = this.f478254a;
        if (r102 == null) goto L14;
        if (r102.equals(r101.f478254a) == false) goto L15;
    L16:
        String r103 = this.f478255b;
        if (r103 == null) goto L20;
        return r103.equals(r101.f478255b);
    L20:
        if (r101.f478255b == null) goto L25;
        return false;
    L25:
        return true;
    L15:
        return false;
    L14:
        if (r101.f478254a == null) goto L16;
        goto L15
    }

    public g(cp4.b r100, String r101, String r102, FieldCompositeType r103, AllowedEditModes r104, ep4.a r105, boolean r106, boolean r107, String r108, boolean r110, DefaultValueRule r111) {
        this.f478254a = r100;
        this.f478255b = r101;
        this.f478256c = r102;
        this.f478257d = r103;
        this.f478258e = r104;
        this.f478259f = r105;
        this.f478260g = r106;
        this.f478261h = r107;
        this.f478262i = r108;
        this.f478265l = r110;
        this.f478266m = r111;
    }
}
