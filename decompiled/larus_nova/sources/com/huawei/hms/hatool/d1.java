package com.huawei.hms.hatool;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class d1 implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f277316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<b1> f277319d;

    public d1(List<b1> r100, String r101, String r102, String r103) {
        this.f277316a = r101;
        this.f277317b = r102;
        this.f277318c = r103;
        this.f277319d = r100;
    }

    private void a() {
        String r100 = n1.a(this.f277316a, this.f277318c, this.f277317b);
        d.a(q0.i(), "backup_event", new String[]{r100});
    }

    @Override // java.lang.Runnable
    public void run() {
        List<b1> r100 = this.f277319d;
        if (r100 != null) goto L5;
    L29:
        v.d("hmsSdk", "failed events is empty");
        return;
    L5:
        if (r100.size() == 0) goto L29;
        if (c0.a(q0.i(), "cached_v2_1", q0.k() * 1048576) == false) goto L11;
        v.e("hmsSdk", "The cacheFile is full,Can not writing data, delete it! reqID:" + this.f277317b);
        d.a(q0.i(), "cached_v2_1", new String[0]);
        return;
    L11:
        String r101 = n1.a(this.f277316a, this.f277318c);
        List<b1> r102 = c1.b(q0.i(), "cached_v2_1", r101).get(r101);
        if (r102 != null) goto L14;
    L16:
        JSONArray r103 = new JSONArray();
        Iterator<b1> r104 = this.f277319d.iterator();
    L18:
        if (r104.hasNext() == false) goto L23;
        r103.put(r104.next().d());     // Catch: JSONException -> L22
    L22:
        v.e("hmsSdk", "event to json error");
        goto L18
    L23:
        String r105 = r103.toString();
        if (r105.length() <= (q0.h() * 1048576)) goto L27;
        v.e("hmsSdk", "this failed data is too long,can not writing it");
        this.f277319d = null;
        return;
    L27:
        v.d("hmsSdk", "data send failed, write to cache file...reqID:" + this.f277317b);
        d.b(q0.i(), "cached_v2_1", r101, r105);
        a();
        return;
    L14:
        if (r102.size() == 0) goto L16;
        this.f277319d.addAll(r102);
        goto L16
    }
}
