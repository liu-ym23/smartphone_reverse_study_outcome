package cp4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.enums.ECardType;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.CardOperationModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableMetaModel;
import com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.AsyncFetchResult;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fp4.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public String A;
    public String B;
    public boolean C;
    public boolean D;
    public CardOperationModel.FormRecordParams E;
    public String F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f464657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f464658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f464659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f464660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f464661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String[] f464662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ECardType f464663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f464664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, g> f464665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f464666j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f464667k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<a> f464668l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f464669m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f464670n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f464671o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f464672p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f464673q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f464674r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ETableType f464675s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f464676t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f464677u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public AsyncFetchResult.EResultState f464678v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f464679w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f464680x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f464681y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<TableMetaModel.ColorsMap> f464682z;

    public final int b() {
        if (this.f464668l == null) goto L11;
        int r100 = 0;
    L6:
        if (r100 >= this.f464668l.size()) goto L11;
        if (TextUtils.equals(this.f464669m, ((a) ListProtector.get(this.f464668l, r100)).f464635b) == true) goto L9;
        r100 = r100 + 1;
        goto L6
    L9:
        return r100;
    L11:
        return 0;
    }

    public final boolean g() {
        if (this.f464675s != ETableType.PRO) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f464658b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f464660d;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "STTable(tableId: " + this.f464660d + ", activeRecordId: " + this.f464669m + ", tableType: " + this.f464675s + ")";
    }

    public final a c() {
        int r100 = b();
        List<a> r101 = this.f464668l;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.size() == 0) goto L13;
        if (r100 >= 0) goto L8;
        return null;
    L8:
        if (r100 < this.f464668l.size()) goto L10;
        return null;
    L10:
        return (a) ListProtector.get(this.f464668l, r100);
    L13:
        return null;
    }

    public final void a(b r100) {
        this.f464658b = r100.f464658b;
        this.f464660d = r100.f464660d;
        this.f464661e = r100.f464661e;
        this.f464663g = r100.f464663g;
        this.f464664h = r100.f464664h;
        this.f464665i = r100.f464665i;
        this.f464666j = r100.f464666j;
        this.f464667k = r100.f464667k;
        this.f464668l = r100.f464668l;
        this.f464669m = r100.f464669m;
        this.f464671o = r100.f464671o;
        this.f464672p = r100.f464672p;
        this.f464675s = r100.f464675s;
        this.f464673q = r100.f464673q;
        this.f464674r = r100.f464674r;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        this.f464681y = r100.f464681y;
    }

    public final g d(String r100) {
        Map<String, g> r101 = this.f464665i;
        if (r101 == null) goto L7;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r101.get(r100);
    L7:
        return null;
    }

    public final a e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        List<a> r101 = this.f464668l;
        if (r101 == null) goto L17;
        Iterator<a> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L18;
        a r103 = r102.next();
        if (TextUtils.equals(r103.f464635b, r100) == false) goto L8;
        return r103;
    L18:
        return null;
    L17:
        return null;
    L12:
        return null;
    }

    public final boolean f(int r100) {
        List<a> r101 = this.f464668l;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L27:
        return true;
    L5:
        if (r101.isEmpty() == true) goto L27;
        if (r100 != 0) goto L18;
        a r103 = (a) ListProtector.get(this.f464668l, 0);
        if (r103.f464653t == true) goto L13;
        return r103.f464651r;
    L13:
        if (r103.f464644k > 0) goto L17;
        r102 = false;
    L17:
        return r102;
    L18:
        List<a> r104 = this.f464668l;
        a r105 = (a) ListProtector.get(r104, r104.size() - 1);
        int r106 = this.f464679w;
        if (r105.f464653t == true) goto L22;
        return r105.f464652s;
    L22:
        if ((r105.f464644k + 1) < r106) goto L26;
        r102 = false;
    L26:
        return r102;
    }

    public b(String r100, String r101) {
        this.f464675s = ETableType.CARD;
        this.f464678v = AsyncFetchResult.EResultState.LOADED;
        this.f464658b = r100;
        this.f464660d = r101;
    }

    public b(String r100, String r101, ETableType r102) {
        this.f464675s = ETableType.CARD;
        this.f464678v = AsyncFetchResult.EResultState.LOADED;
        this.f464658b = r100;
        this.f464660d = r101;
        this.f464675s = r102;
    }
}
