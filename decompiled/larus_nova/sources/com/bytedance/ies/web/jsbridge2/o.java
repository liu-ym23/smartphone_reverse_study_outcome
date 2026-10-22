package com.bytedance.ies.web.jsbridge2;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.facebook.imagepipeline.memory.BitmapPoolType;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WebView f249396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f249397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f249398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f249399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l f249400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f249401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f249402g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f249403h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f249404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<u> f249405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f249406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Set<String> f249407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f249408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f249409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f249410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final List<TimeLineEvent> f249411p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f249412q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p f249413r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f249414s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f249415t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public x f249416u;

    public final d0 a() {
        if (this.f249396a != null) goto L9;
        if (this.f249409n == true) goto L9;
        if (this.f249398c != null) goto L9;
    L30:
        throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
    L9:
        if (TextUtils.isEmpty(this.f249399d) == false) goto L13;
        if (this.f249396a != null) goto L30;
    L13:
        if (this.f249400e == null) goto L30;
        boolean r100 = this.f249402g;
        boolean r101 = this.f249412q;
        WebView r102 = this.f249396a;
        if (r100 == false) goto L21;
        if (r101 == false) goto L21;
        if (r102 == null) goto L21;
        if ((r102 instanceof x) == true) goto L21;
        r102.post(new n(r102));
    L21:
        TimeLineEvent.b r103 = new TimeLineEvent.b();
        r103.b("jsObjectName", this.f249399d);
        r103.b("debug", Boolean.valueOf(this.f249402g));
        r103.b("shouldFlattenData", Boolean.valueOf(this.f249403h));
        r103.b("enablePermissionCheck", Boolean.valueOf(this.f249404i));
        r103.b("namespace", this.f249406k);
        r103.b("safeHostSet", this.f249407l);
        r103.b("publicMethodSet", this.f249408m);
        r103.b(BitmapPoolType.DUMMY, Boolean.valueOf(this.f249409n));
        r103.b("jsbPermissionValidator", false);
        r103.b("disableAllPermissionCheck", Boolean.valueOf(this.f249410o));
        r103.b("isShowDebugToast", Boolean.valueOf(this.f249412q));
        WebView r104 = this.f249396a;
        if (r104 == null) goto L24;
        r103.b("webView", r104.getClass().getSimpleName());
    L24:
        x r105 = this.f249416u;
        if (r105 == null) goto L27;
        r103.b("safeWebViewHandler", r105.getClass().getSimpleName());
    L27:
        r103.a("label_create_jsb_environment", this.f249411p);
        return new d0(this);
    }

    public final String b() {
        String r100 = this.f249414s;
        if (r100 != null) goto L5;
        return "host";
    L5:
        if (r100.isEmpty() == false) goto L8;
        return "host";
    L8:
        return this.f249414s;
    }

    public o() {
        this.f249399d = "IESJSBridge";
        this.f249405j = new LinkedHashSet();
        this.f249406k = "host";
        this.f249407l = new LinkedHashSet();
        this.f249408m = new LinkedHashSet();
        this.f249411p = new CopyOnWriteArrayList();
        this.f249412q = true;
        this.f249415t = true;
    }

    public Context getContext() {
        return this.f249401f;
    }

    public o(WebView r100) {
        this.f249399d = "IESJSBridge";
        this.f249405j = new LinkedHashSet();
        this.f249406k = "host";
        this.f249407l = new LinkedHashSet();
        this.f249408m = new LinkedHashSet();
        this.f249411p = new CopyOnWriteArrayList();
        this.f249412q = true;
        this.f249415t = true;
        this.f249396a = r100;
        this.f249397b = new a.C3554a(r100);
    }

    public final void c(q r100) {
        l r101 = new l(r100);
        this.f249400e = r101;
        r101.f249387b = false;
    }

    public o(a r100) {
        this.f249399d = "IESJSBridge";
        this.f249405j = new LinkedHashSet();
        this.f249406k = "host";
        this.f249407l = new LinkedHashSet();
        this.f249408m = new LinkedHashSet();
        this.f249411p = new CopyOnWriteArrayList();
        this.f249412q = true;
        this.f249415t = true;
        this.f249397b = r100;
    }
}
