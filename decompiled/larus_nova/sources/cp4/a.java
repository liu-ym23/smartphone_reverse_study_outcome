package cp4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.FieldGroupNode;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.bear.bitable.itemview.record.menu.e;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Cloneable, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f464634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f464636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f464637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f464638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f464639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f464640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f464641h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f464642i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f464643j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f464644k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f464645l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<dp4.a> f464646m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, FieldGroupNode> f464647n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f464648o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Integer f464649p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<String> f464650q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f464651r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f464652s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f464653t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f464654u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f464655v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TableDataModel.ReportEvent f464656w;

    public a() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.e
    public final String getBaseId() {
        return this.f464634a.f464658b;
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.e
    public final String getTableId() {
        return this.f464634a.f464660d;
    }

    public final int hashCode() {
        String r100 = this.f464635b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f464645l;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final a b() throws CloneNotSupportedException {
        a r100 = (a) super.clone();
        r100.f464646m = new ArrayList(this.f464646m);
        r100.f464647n = this.f464647n;
        return r100;
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    @Override // com.bytedance.ee.bear.bitable.itemview.record.menu.e
    public final String a() {
        return this.f464635b;
    }

    public final String toString() {
        return this.f464635b;
    }

    public final boolean c(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L15:
        return false;
    L5:
        if (CollectionUtils.isEmpty(this.f464647n) == true) goto L15;
        Iterator<FieldGroupNode> r101 = this.f464647n.values().iterator();
    L9:
        if (r101.hasNext() == false) goto L15;
        FieldGroupNode r102 = r101.next();
        if (r102 == null) goto L9;
        if (TextUtils.equals(r100, r102.getId()) == false) goto L9;
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        String r102 = this.f464635b;
        if (r102 == null) goto L14;
        if (r102.equals(r101.f464635b) == true) goto L17;
    L15:
        return false;
    L17:
        if (TextUtils.isEmpty(this.f464645l) == false) goto L20;
        return TextUtils.isEmpty(r101.f464645l);
    L20:
        return TextUtils.equals(this.f464645l, r101.f464645l);
    L14:
        if (r101.f464635b == null) goto L17;
        goto L15
    }

    public a(b r100, String r101, String r102, String r103, String r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, int r113, String r114, Integer r115, boolean r116, boolean r117, String r118, String r119, boolean r210, ArrayList r211) {
        this.f464634a = r100;
        this.f464635b = r101;
        this.f464636c = r102;
        this.f464637d = r103;
        this.f464638e = r104;
        this.f464639f = r105;
        this.f464640g = r106;
        this.f464643j = r110;
        this.f464641h = r111;
        this.f464642i = r112;
        this.f464644k = r113;
        this.f464645l = r114;
        this.f464649p = r115;
        this.f464650q = r211;
        this.f464651r = r116;
        this.f464652s = r117;
        this.f464654u = r118;
        this.f464655v = r119;
        this.f464653t = r210;
    }
}
