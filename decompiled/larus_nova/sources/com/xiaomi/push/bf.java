package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class bf extends JSONObject implements bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f463187a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f463188b = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f261a;

    @Override // com.xiaomi.push.bd
    public int a() {
        int r100 = f463187a;
        Iterator<Integer> r101 = this.f261a.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100 = r100 + r101.next().intValue();
        goto L4
    L7:
        return r100 + (length() - 1);
    }

    public bf() {
        this.f261a = new LinkedHashMap();
    }

    @Override // org.json.JSONObject
    public Object remove(String r100) {
        this.f261a.remove(r100);
        return super.remove(r100);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String r100, Object r101) {
        JSONObject r102 = super.put(r100, r101);
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r101 == null) goto L9;
        if ((r101 instanceof bd) == false) goto L8;
        this.f261a.put(r100, Integer.valueOf((r100.length() + ((bd) r101).a()) + f463188b));
        goto L9
    L8:
        this.f261a.put(r100, Integer.valueOf(((r100.length() + String.valueOf(r101).getBytes(StandardCharsets.UTF_8).length) + f463188b) + f463187a));
    L9:
        return r102;
    }

    @Override // org.json.JSONObject
    public JSONObject put(String r100, double r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f261a.put(r100, Integer.valueOf((r100.length() + String.valueOf(r101).length()) + f463188b));
    L6:
        return super.put(r100, r101);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f261a.put(r100, Integer.valueOf((r100.length() + String.valueOf(r101).length()) + f463188b));
    L6:
        return super.put(r100, r101);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String r100, long r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f261a.put(r100, Integer.valueOf((r100.length() + String.valueOf(r101).length()) + f463188b));
    L6:
        return super.put(r100, r101);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String r100, boolean r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.f261a.put(r100, Integer.valueOf((r100.length() + String.valueOf(r101).length()) + f463188b));
    L6:
        return super.put(r100, r101);
    }
}
