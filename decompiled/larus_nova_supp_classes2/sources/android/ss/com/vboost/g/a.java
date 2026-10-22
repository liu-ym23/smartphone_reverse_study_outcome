package android.ss.com.vboost.g;

import android.ss.com.vboost.CapabilityType;
import android.ss.com.vboost.utils.LogUtil;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f54b = "android.ss.com.vboost.g.a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, String> f55a;

    private a() {
        this.f55a = new LinkedHashMap(64);
    }

    public static a b() {
        return new a();
    }

    private Set<CapabilityType> b(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        TextUtils.SimpleStringSplitter r1 = new TextUtils.SimpleStringSplitter(',');
        r1.setString(r4);
        HashSet r5 = new HashSet();
        Iterator<String> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L10;
        r5.add(CapabilityType.valueOf(CastIntegerProtector.parseInt(r2.next())));
        goto L7
    L10:
        if (r5.size() != 0) goto L12;
        return null;
    L12:
        return r5;
    }

    private void b(String r2, String r3) {
        this.f55a.remove(r2);
        this.f55a.put(r2, r3);
    }

    public String a(String r2) {
        return this.f55a.get(r2);
    }

    public Set<CapabilityType> a() {
        return b(a("support_capability_set"));
    }

    public void a(CapabilityType r9, List<c> r10) {
        String r11 = r9.getName() + "_limit_rule";
        if (r10 != null) goto L6;
        String r12 = "(0:0:0,0:0,0:0)";
    L5:
        a(r11, r12);
        return;
    L6:
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L8:
        if (r1 >= r10.size()) goto L25;
        c r2 = (c) ListProtector.get(r10, r1);
        r0.append("(");
        String r4 = "1";
        if (r2.f59a == false) goto L12;
        String r3 = "1";
    L13:
        r0.append(r3);
        r0.append(":");
        r0.append(r2.f60b);
        r0.append(":");
        r0.append(r2.f61c);
        r0.append(",");
        if (r2.d == false) goto L16;
        String r7 = "1";
    L17:
        r0.append(r7);
        r0.append(":");
        r0.append(r2.e);
        r0.append(",");
        if (r2.f62f == true) goto L21;
        r4 = "0";
    L21:
        r0.append(r4);
        r0.append(":");
        r0.append(r2.f63g);
        r0.append(")");
        if (r1 == (r10.size() - 1)) goto L24;
        r0.append(',');
    L24:
        r1 = r1 + 1;
        goto L8
    L16:
        r7 = "0";
        goto L17
    L12:
        r3 = "0";
        goto L13
    L25:
        r12 = r0.toString();
        goto L5
    }

    public void a(b r2) {
        a("cpu_core_limit_by", r2.ordinal());
    }

    public void a(d r5) {
        if (r5 != null) goto L5;
        String r6 = "0,0,0";
    L6:
        a("task_priority_limit_rule", r6);
        return;
    L5:
        r6 = r5.f64a + "," + r5.f65b + "," + r5.f66c;
        goto L6
    }

    public void a(String r1, int r2) {
        b(r1, Integer.toString(r2));
    }

    public void a(String r7, String r8) {
        if (r7.indexOf(61) == (-1)) goto L5;
    L20:
        LogUtil.error(f54b, "Key \"" + r7 + "\" contains invalid character (= or ; or \\0)");
        return;
    L5:
        if (r7.indexOf(59) != (-1)) goto L20;
        if (r7.indexOf(0) != (-1)) goto L20;
        if (r8.indexOf(61) == (-1)) goto L12;
    L18:
        LogUtil.error(f54b, "Value \"" + r8 + "\" contains invalid character (= or ; or \\0)");
        return;
    L12:
        if (r8.indexOf(59) != (-1)) goto L18;
        if (r8.indexOf(0) != (-1)) goto L18;
        b(r7, r8);
    }

    public void a(Set<CapabilityType> r3) {
        StringBuilder r0 = new StringBuilder();
        Iterator<CapabilityType> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        r0.append(r4.next().getIndex());
        if (r4.hasNext() == false) goto L4;
        r0.append(",");
        goto L4
    L8:
        a("support_capability_set", r0.toString());
    }
}
