package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f249316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f249317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f249318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f249319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f249320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f249321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f249322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f249323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f249324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f249325j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<TimeLineEvent> f249326k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f249327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f249328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f249329c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f249330d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f249331e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f249332f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f249333g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f249334h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Boolean f249335i;

        public final c0 a() {
            return new c0(this);
        }

        public a() {
            this.f249335i = Boolean.FALSE;
        }
    }

    public static a a() {
        return new a();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("methodName: ");
        r100.append(this.f249319d);
        r100.append(", params: ");
        r100.append(this.f249320e);
        r100.append(", callbackId: ");
        r100.append(this.f249321f);
        r100.append(", type: ");
        r100.append(this.f249318c);
        r100.append(", iFrameUrl: ");
        String r101 = "null";
        if (TextUtils.isEmpty(this.f249323h) == false) goto L5;
        String r102 = "null";
    L6:
        r100.append(r102);
        r100.append(", safeV1AuthUrl: ");
        if (TextUtils.isEmpty(this.f249324i) == true) goto L10;
        r101 = this.f249324i;
    L10:
        r100.append(r101);
        r100.append(", version: ");
        r100.append(this.f249317b);
        r100.append(", ");
        return r100.toString();
    L5:
        r102 = this.f249323h;
        goto L6
    }

    public c0(a r110) {
        CopyOnWriteArrayList r100 = new CopyOnWriteArrayList();
        this.f249326k = r100;
        String r101 = r110.f249327a;
        this.f249317b = r101;
        String r102 = r110.f249328b;
        this.f249318c = r102;
        String r103 = r110.f249329c;
        this.f249319d = r103;
        String r104 = r110.f249330d;
        this.f249320e = r104;
        String r105 = r110.f249331e;
        this.f249321f = r105;
        String r106 = r110.f249332f;
        this.f249322g = r106;
        this.f249316a = 1;
        String r107 = r110.f249333g;
        this.f249323h = r107;
        String r108 = r110.f249334h;
        this.f249324i = r108;
        this.f249325j = r110.f249335i;
        TimeLineEvent.b r111 = new TimeLineEvent.b();
        r111.b("version", r101);
        r111.b("type", r102);
        r111.b("methodName", r103);
        r111.b("params", r104);
        r111.b("namespace", r106);
        r111.b("callbackId", r105);
        r111.b("namespace", r106);
        r111.b("iFrameUrl", r107);
        r111.b("safeV1AuthUrl", r108);
        r111.a("label_create_java_call", r100);
    }

    public static boolean b(c0 r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.f249316a == 1) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(r100.f249319d) == false) goto L9;
        return true;
    L9:
        if (TextUtils.isEmpty(r100.f249320e) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public c0(String r100) {
        CopyOnWriteArrayList r101 = new CopyOnWriteArrayList();
        this.f249326k = r101;
        this.f249317b = null;
        this.f249318c = null;
        this.f249319d = null;
        this.f249320e = null;
        this.f249321f = r100;
        this.f249322g = null;
        this.f249316a = -5;
        this.f249323h = null;
        this.f249324i = null;
        this.f249325j = Boolean.FALSE;
        TimeLineEvent.b r102 = new TimeLineEvent.b();
        r102.b("callbackId", r100);
        r102.b("code", -5);
        r102.a("label_create_java_call", r101);
    }
}
