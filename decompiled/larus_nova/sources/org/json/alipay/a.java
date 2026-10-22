package org.json.alipay;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes42.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f525882a;

    public a() {
        this.f525882a = new ArrayList();
    }

    public a(Object r100) {
        this();
        if (r100.getClass().isArray() == false) goto L9;
        int r101 = Array.getLength(r100);
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        Object r103 = Array.get(r100, r102);
        this.f525882a.add(r103);
        r102 = r102 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public a(String r100) {
        this(new c(r100));
    }

    public a(Collection r100) {
        if (r100 != null) goto L5;
        ArrayList r101 = new ArrayList();
    L6:
        this.f525882a = r101;
        return;
    L5:
        r101 = new ArrayList(r100);
        goto L6
    }

    public a(c r100) {
        this();
        char r101 = r100.c();
        if (r101 != '[') goto L6;
        char r102 = ']';
    L9:
        if (r100.c() != ']') goto L11;
        return;
    L11:
        r100.a();
        char r103 = r100.c();
        r100.a();
        if (r103 != ',') goto L14;
        ArrayList r104 = this.f525882a;
        Object r105 = null;
    L15:
        r104.add(r105);
        char r106 = r100.c();
        if (r106 == ')') goto L27;
        if (r106 == ',') goto L25;
        if (r106 == ';') goto L25;
        if (r106 == ']') goto L27;
        throw r100.a("Expected a ',' or ']'");
    L25:
        if (r100.c() != ']') goto L11;
        return;
    L27:
        if (r102 != r106) goto L30;
        return;
    L30:
        throw r100.a("Expected a '" + new Character(r102) + "'");
    L14:
        r104 = this.f525882a;
        r105 = r100.d();
        goto L15
    L6:
        if (r101 != '(') goto L32;
        r102 = ')';
        goto L9
    L32:
        throw r100.a("A JSONArray text must start with '['");
    }

    private String a(String r100) {
        int r101 = this.f525882a.size();
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L8;
        if (r103 <= 0) goto L6;
        r102.append(r100);
    L6:
        r102.append(b.a(ListProtector.get(this.f525882a, r103)));
        r103 = r103 + 1;
        goto L3
    L8:
        return r102.toString();
    }

    public final int a() {
        return this.f525882a.size();
    }

    public final Object a(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        Object r101 = null;
    L8:
        if (r101 == null) goto L11;
        return r101;
    L11:
        throw new JSONException("JSONArray[" + r100 + "] not found.");
    L4:
        if (r100 >= this.f525882a.size()) goto L7;
        r101 = ListProtector.get(this.f525882a, r100);
        goto L8
    }

    public String toString() {
        return "[" + a(",") + ']';
    L4:
        return null;
    }
}
