package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes23.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b1> f277461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277464d;

    public u(List<b1> r100, String r101, String r102, String r103) {
        this.f277461a = r100;
        this.f277462b = r101;
        this.f277463c = r102;
        this.f277464d = r103;
    }

    private void a(List<b1> r110, String r111, String r112) {
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = (r110.size() / 500) + 1;
        int r101 = 0;
    L6:
        if (r101 >= r100) goto L18;
        int r102 = r101 * 500;
        List<b1> r103 = r110.subList(r102, Math.min(r110.size(), r102 + 500));
        String r113 = UUID.randomUUID().toString().replace("-", "");
        long r104 = System.currentTimeMillis();
        long r105 = ((long) a1.b(r112, r111)) * 86400000;
        ArrayList r114 = new ArrayList();
        Iterator<b1> r106 = r103.iterator();
    L9:
        if (r106.hasNext() == false) goto L14;
        b1 r107 = r106.next();
        if (c0.a(r107.b(), r104, r105) == true) goto L9;
        r114.add(r107);
        goto L9
    L14:
        if (r114.size() <= 0) goto L16;
        new l0(r112, r111, this.f277464d, r114, r113).a();
    L17:
        r101 = r101 + 1;
        goto L6
    L16:
        v.e("hmsSdk", "No data to report handler");
        goto L17
    }

    public void a() {
        if ("_default_config_tag".equals(this.f277463c) == false) goto L23;
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<b1> r104 = this.f277461a.iterator();
    L6:
        if (r104.hasNext() == false) goto L22;
        b1 r105 = r104.next();
        String r110 = r105.c();
        if (TextUtils.isEmpty(r110) == true) goto L21;
        if ("oper".equals(r110) == true) goto L21;
        if ("maint".equals(r110) == true) goto L14;
        if ("preins".equals(r110) == true) goto L17;
        if ("diffprivacy".equals(r110) == false) goto L6;
        r102.add(r105);
        goto L6
    L17:
        r101.add(r105);
        goto L6
    L14:
        r100.add(r105);
    L21:
        r103.add(r105);
        goto L6
    L22:
        a(r103, "oper", "_default_config_tag");
        a(r100, "maint", "_default_config_tag");
        a(r101, "preins", "_default_config_tag");
        a(r102, "diffprivacy", "_default_config_tag");
        return;
    L23:
        a(this.f277461a, this.f277463c, this.f277462b);
    }
}
