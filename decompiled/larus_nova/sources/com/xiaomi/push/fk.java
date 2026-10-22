package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public class fk implements fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f463547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<fk> f574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[] f575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f463548b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String[] f576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f463549c;

    public Bundle a() {
        Bundle r100 = new Bundle();
        r100.putString("ext_ele_name", this.f463547a);
        r100.putString("ext_ns", this.f463548b);
        r100.putString("ext_text", this.f463549c);
        Bundle r101 = new Bundle();
        String[] r102 = this.f575a;
        if (r102 != null) goto L5;
    L10:
        r100.putBundle("attributes", r101);
        List<fk> r103 = this.f574a;
        if (r103 != null) goto L13;
    L15:
        return r100;
    L13:
        if (r103.size() <= 0) goto L15;
        r100.putParcelableArray("children", a(this.f574a));
        goto L15
    L5:
        if (r102.length <= 0) goto L10;
        int r104 = 0;
    L7:
        String[] r105 = this.f575a;
        if (r104 >= r105.length) goto L10;
        r101.putString(r105[r104], this.f576b[r104]);
        r104 = r104 + 1;
        goto L7
    }

    public String c() {
        if (TextUtils.isEmpty(this.f463549c) == true) goto L7;
        return fw.b(this.f463549c);
    L7:
        return this.f463549c;
    }

    @Override // com.xiaomi.push.fo
    public String d() {
        StringBuilder r100 = new StringBuilder("<");
        r100.append(this.f463547a);
        if (TextUtils.isEmpty(this.f463548b) == true) goto L5;
        r100.append(" xmlns=\"");
        r100.append(this.f463548b);
        r100.append("\"");
    L5:
        String[] r101 = this.f575a;
        if (r101 == null) goto L17;
        if (r101.length <= 0) goto L17;
        int r102 = 0;
    L11:
        if (r102 >= this.f575a.length) goto L17;
        if (TextUtils.isEmpty(this.f576b[r102]) == true) goto L15;
        r100.append(" ");
        r100.append(this.f575a[r102]);
        r100.append("=\"");
        r100.append(fw.a(this.f576b[r102]));
        r100.append("\"");
    L15:
        r102 = r102 + 1;
    L17:
        if (TextUtils.isEmpty(this.f463549c) == true) goto L19;
        r100.append(">");
        r100.append(this.f463549c);
        r100.append("</");
        r100.append(this.f463547a);
        r100.append(">");
    L30:
        return r100.toString();
    L19:
        List<fk> r103 = this.f574a;
        if (r103 != null) goto L22;
    L28:
        r100.append("/>");
        goto L30
    L22:
        if (r103.size() <= 0) goto L28;
        r100.append(">");
        Iterator<fk> r104 = this.f574a.iterator();
    L25:
        if (r104.hasNext() == false) goto L27;
        r100.append(r104.next().d());
        goto L25
    L27:
        r100.append("</");
        r100.append(this.f463547a);
        r100.append(">");
        goto L30
    }

    public String toString() {
        return d();
    }

    public String b() {
        return this.f463548b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Parcelable m9095a() {
        return a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m9096a() {
        return this.f463547a;
    }

    public static fk a(Bundle r110) {
        String r100 = r110.getString("ext_ele_name");
        String r101 = r110.getString("ext_ns");
        String r102 = r110.getString("ext_text");
        Bundle r103 = r110.getBundle("attributes");
        Set<String> r104 = r103.keySet();
        String[] r105 = new String[r104.size()];
        String[] r106 = new String[r104.size()];
        Iterator<String> r107 = r104.iterator();
        int r108 = 0;
        int r109 = 0;
    L4:
        if (r107.hasNext() == false) goto L7;
        String r111 = r107.next();
        r105[r109] = r111;
        r106[r109] = r103.getString(r111);
        r109 = r109 + 1;
        goto L4
    L7:
        if (r110.containsKey("children") == false) goto L12;
        Parcelable[] r112 = r110.getParcelableArray("children");
        ArrayList r113 = new ArrayList(r112.length);
        int r114 = r112.length;
    L9:
        if (r108 >= r114) goto L11;
        r113.add(a((Bundle) r112[r108]));
        r108 = r108 + 1;
        goto L9
    L11:
        ArrayList r115 = r113;
    L14:
        return new fk(r100, r101, r105, r106, r102, r115);
    L12:
        r115 = null;
        goto L14
    }

    public String a(String r100) {
        if (r100 == null) goto L16;
        if (this.f575a == null) goto L13;
        int r101 = 0;
    L6:
        String[] r102 = this.f575a;
        if (r101 >= r102.length) goto L19;
        if (r100.equals(r102[r101]) == true) goto L11;
        r101 = r101 + 1;
        goto L6
    L11:
        return this.f576b[r101];
    L19:
        return null;
    L13:
        return null;
    L16:
        throw new IllegalArgumentException();
    }

    public void a(fk r100) {
        if (this.f574a != null) goto L6;
        this.f574a = new ArrayList();
    L6:
        if (this.f574a.contains(r100) == true) goto L9;
        this.f574a.add(r100);
        return;
    }

    public static Parcelable[] a(fk[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Parcelable[] r101 = new Parcelable[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = r100[r102].m9095a();
        r102 = r102 + 1;
        goto L7
    L9:
        return r101;
    }

    public static Parcelable[] a(List<fk> r100) {
        return a((fk[]) r100.toArray(new fk[r100.size()]));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m9097a(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.f463549c = fw.a(r100);
        return;
    L5:
        this.f463549c = r100;
    }

    public fk(String r100, String r101, String[] r102, String[] r103) {
        this.f574a = null;
        this.f463547a = r100;
        this.f463548b = r101;
        this.f575a = r102;
        this.f576b = r103;
    }

    public fk(String r100, String r101, String[] r102, String[] r103, String r104, List<fk> r105) {
        this.f463547a = r100;
        this.f463548b = r101;
        this.f575a = r102;
        this.f576b = r103;
        this.f463549c = r104;
        this.f574a = r105;
    }
}
