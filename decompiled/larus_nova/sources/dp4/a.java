package dp4;

import com.bytedance.ee.bear.bitable.card.model.enums.EFieldUneditableReason;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.permission.FieldPermission;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import cp4.b;
import fp4.g;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class a<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f469587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cp4.a f469588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f469589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f469590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EFieldUneditableReason f469591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f469592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f469593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f469594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FieldPermission f469595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f469596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f469597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public V f469598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Object f469599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TableDataModel.ReportEvent f469600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TableDataModel.ReportEvent f469601o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f469602p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f469603q;

    public final boolean b() {
        if (this.f469590d == false) goto L15;
        cp4.a r100 = this.f469588b;
        if (r100 == null) goto L11;
        b r101 = r100.f464634a;
        if (r101 == null) goto L11;
        if (r101.f464677u == false) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L16;
        return true;
    L16:
        return false;
    L11:
        r102 = false;
        goto L12
    L15:
        return false;
    }

    public final int hashCode() {
        g r100 = this.f469587a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        cp4.a r104 = this.f469588b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final <E> E a(Class<E> r100) {
        V r101 = this.f469598l;
        if ((r101 instanceof List) == true) goto L5;
    L42:
        return null;
    L5:
        if (((List) r101).isEmpty() == true) goto L42;
        E r102 = (E) ListProtector.get((List) this.f469598l, 0);
        if (r102 == null) goto L42;
        Class<?> r103 = r102.getClass();
        if (r100 != null) goto L12;
        r100 = null;
    L40:
        if (r103 != r100) goto L42;
        return r102;
    L12:
        if (r100.isPrimitive() == false) goto L40;
        if (Boolean.TYPE != r100) goto L17;
        r100 = (Class<E>) Boolean.class;
        goto L40
    L17:
        if (Integer.TYPE != r100) goto L20;
        r100 = (Class<E>) Integer.class;
        goto L40
    L20:
        if (Long.TYPE != r100) goto L23;
        r100 = (Class<E>) Long.class;
        goto L40
    L23:
        if (Short.TYPE != r100) goto L26;
        r100 = (Class<E>) Short.class;
        goto L40
    L26:
        if (Byte.TYPE != r100) goto L29;
        r100 = (Class<E>) Byte.class;
        goto L40
    L29:
        if (Double.TYPE != r100) goto L32;
        r100 = (Class<E>) Double.class;
        goto L40
    L32:
        if (Float.TYPE != r100) goto L35;
        r100 = (Class<E>) Float.class;
        goto L40
    L35:
        if (Character.TYPE != r100) goto L38;
        r100 = (Class<E>) Character.class;
        goto L40
    L38:
        if (Void.TYPE != r100) goto L40;
        r100 = (Class<E>) Void.class;
        goto L40
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        g r102 = this.f469587a;
        if (r102 == null) goto L14;
        if (r102.equals(r101.f469587a) == false) goto L15;
    L16:
        cp4.a r103 = this.f469588b;
        if (r103 == null) goto L20;
        return r103.equals(r101.f469588b);
    L20:
        if (r101.f469588b == null) goto L25;
        return false;
    L25:
        return true;
    L15:
        return false;
    L14:
        if (r101.f469587a == null) goto L16;
        goto L15
    }

    public a(cp4.a r100, V r101, boolean r102, EFieldUneditableReason r103, boolean r104, String r105, FieldPermission r106) {
        this.f469593g = -1;
        this.f469588b = r100;
        this.f469598l = r101;
        if (r102 == true) goto L5;
    L7:
        boolean r107 = false;
    L8:
        this.f469590d = r107;
        this.f469591e = r103;
        this.f469592f = r104;
        this.f469594h = r105;
        this.f469595i = r106;
        return;
    L5:
        if (r100.f464641h == false) goto L7;
        r107 = true;
        goto L8
    }
}
