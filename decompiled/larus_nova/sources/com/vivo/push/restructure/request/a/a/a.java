package com.vivo.push.restructure.request.a.a;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f462491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f462492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONArray f462493c;

    public final int a() throws JSONException {
        int r100 = this.f462491a;
        if (r100 >= this.f462492b) goto L6;
        JSONArray r101 = this.f462493c;
        this.f462491a = r100 + 1;
        return JSONArrayProtectorUtils.getInt(r101, r100);
    L6:
        return 0;
    }

    public final long b() throws JSONException {
        int r100 = this.f462491a;
        if (r100 >= this.f462492b) goto L6;
        JSONArray r101 = this.f462493c;
        this.f462491a = r100 + 1;
        return JSONArrayProtectorUtils.getLong(r101, r100);
    L6:
        return 0;
    }

    public final String c() throws JSONException {
        int r100 = this.f462491a;
        if (r100 >= this.f462492b) goto L6;
        JSONArray r101 = this.f462493c;
        this.f462491a = r100 + 1;
        return JSONArrayProtectorUtils.getString(r101, r100);
    L6:
        return null;
    }

    public final boolean d() throws JSONException {
        int r100 = this.f462491a;
        if (r100 >= this.f462492b) goto L6;
        JSONArray r101 = this.f462493c;
        this.f462491a = r100 + 1;
        return JSONArrayProtectorUtils.getBoolean(r101, r100);
    L6:
        return false;
    }

    public final String e() {
        JSONArray r100 = this.f462493c;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.toString();
    }

    public a() {
        this.f462491a = 0;
        this.f462493c = new JSONArray();
    }

    public a(String r100) throws JSONException {
        this.f462491a = 0;
        JSONArray r101 = new JSONArray(r100);
        this.f462493c = r101;
        this.f462491a = 0;
        this.f462492b = r101.length();
    }

    public final <T extends c> void a(List<T> r100) {
        if (r100 == null) goto L8;
        this.f462493c.put(r100.size());
        Iterator<T> r101 = r100.iterator();
    L5:
        if (r101.hasNext() == false) goto L7;
        T r102 = r101.next();
        this.f462493c.put(r102.a());
        goto L5
    L7:
        return;
    L8:
        this.f462493c.put(null);
    }

    public final void a(int r100) {
        this.f462493c.put(r100);
    }

    public final void a(long r100) {
        this.f462493c.put(r100);
    }

    public final void a(String r100) {
        this.f462493c.put(r100);
    }

    public final void a(boolean r100) {
        this.f462493c.put(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends c> void a(c.a<T> r100, List<T> r101) throws JSONException {
        int r102 = this.f462491a;
        if (r102 >= this.f462492b) goto L5;
        boolean r103 = this.f462493c.isNull(r102);
    L6:
        if (r103 == false) goto L9;
        this.f462491a++;
        return;
    L9:
        JSONArray r104 = this.f462493c;
        int r105 = this.f462491a;
        this.f462491a = r105 + 1;
        int r106 = JSONArrayProtectorUtils.getInt(r104, r105);
        int r107 = 0;
    L10:
        if (r107 >= r106) goto L16;
        int r108 = this.f462491a;
        if (r108 >= this.f462492b) goto L14;
        JSONArray r109 = this.f462493c;
        this.f462491a = r108 + 1;
        c r110 = r100.a(JSONArrayProtectorUtils.getString(r109, r108));
    L15:
        r101.add(r110);
        r107 = r107 + 1;
        goto L10
    L14:
        r110 = null;
        goto L15
    L16:
        return;
    L5:
        r103 = true;
        goto L6
    }
}
