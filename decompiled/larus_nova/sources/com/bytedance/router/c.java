package com.bytedance.router;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f267527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Intent f267528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f267529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f267530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f267531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f267532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f267533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f267534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f267535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f267536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Uri f267537k;

    public final void a() {
        if (TextUtils.isEmpty(this.f267529c) == false) goto L5;
        return;
    L5:
        Uri r100 = UriProtector.parse(this.f267529c);
        this.f267530d = r100;
        this.f267528b.setData(r100);
        this.f267531e = this.f267530d.getScheme();
        this.f267532f = this.f267530d.getHost();
        String r101 = this.f267530d.getPath();
        this.f267533g = r101;
        if (this.f267531e != null) goto L9;
        this.f267531e = "";
    L9:
        if (this.f267532f != null) goto L11;
        this.f267532f = "";
    L11:
        if (r101 != null) goto L14;
        this.f267533g = "";
        return;
    }

    public final String toString() {
        return "RouteIntent{mOriginUrl='" + this.f267527a + "', mExtraIntent=" + this.f267528b + ", mUrl='" + this.f267529c + "', mUri=" + this.f267530d + ", mScheme='" + this.f267531e + "', mHost='" + this.f267532f + "', mPath='" + this.f267533g + "', enterAnim=" + this.f267534h + ", exitAnim=" + this.f267535i + ", mRequestCode=" + this.f267536j + ", mData=" + this.f267537k + '}';
    }

    public c() {
        this.f267527a = "";
        this.f267528b = null;
        this.f267529c = "";
        this.f267530d = null;
        this.f267531e = "";
        this.f267532f = "";
        this.f267533g = "";
        this.f267534h = -1;
        this.f267535i = -1;
        this.f267536j = Integer.MIN_VALUE;
    }

    public final void b(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (u97.b.c(r100) == false) goto L11;
        if (r100.equals(this.f267529c) == true) goto L12;
        this.f267529c = r100;
        a();
        c(this.f267528b, this.f267529c, true);
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("url is illegal!!!");
    }

    public static void c(Intent r100, String r101, boolean r102) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        Map r103 = Collections.EMPTY_MAP;
    L21:
        if (r103 != null) goto L23;
        return;
    L23:
        if (r103.size() == 0) goto L48;
        Iterator r104 = r103.entrySet().iterator();
    L27:
        if (r104.hasNext() == false) goto L49;
        Map.Entry r105 = (Map.Entry) r104.next();
        if (r102 == true) goto L30;
        if (r100.hasExtra((String) r105.getKey()) == true) goto L27;
        r100.putExtra((String) r105.getKey(), (String) r105.getValue());
        goto L27
    L30:
        r100.putExtra((String) r105.getKey(), (String) r105.getValue());
        goto L27
    L49:
        return;
    L48:
        return;
    L7:
        Uri r106 = UriProtector.parse(r101);
        if (r106.isHierarchical() == true) goto L10;
        r103 = Collections.EMPTY_MAP;
        goto L21
    L10:
        Iterator<String> r107 = UriProtector.getQueryParameterNames(r106).iterator();
        HashMap r108 = new HashMap();
    L12:
        if (r107.hasNext() == false) goto L20;
        String r109 = r107.next();
        if (TextUtils.isEmpty(r109) == true) goto L12;
        String r110 = UriProtector.getQueryParameter(r106, r109);
        if (r110 != null) goto L19;
        r110 = "";
    L19:
        r108.put(r109, r110);
        goto L12
    L20:
        r103 = r108;
        goto L21
    }
}
