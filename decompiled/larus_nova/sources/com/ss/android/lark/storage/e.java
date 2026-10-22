package com.ss.android.lark.storage;

import java.io.File;
import java.net.URLEncoder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f440950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f440951d;

    public static abstract class a<U extends e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f440952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f440953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public f f440954c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f440955d;

        public a() {
            this.f440954c = f.f440958e;
        }
    }

    public final String a() {
        int r100 = o6c.c.f522230c;
        Intrinsics.checkNotNullParameter("://", "separator");
        o6c.c r101 = new o6c.c("://");
        r101.a(this.f440948a, false);
        r101.a(URLEncoder.encode(this.f440949b, "UTF-8"), true);
        Intrinsics.checkNotNullParameter("@", "separator");
        r101.f522231a = "@";
        r101.a(this.f440950c.getName(), false);
        String r102 = File.separator;
        Intrinsics.checkNotNullParameter(r102, "separator");
        r101.f522231a = r102;
        d r103 = this.f440951d;
        if (r103 == null) goto L5;
        String[] r104 = r103.a();
    L6:
        String[] r105 = r104;
        if (r105 == null) goto L12;
        int r106 = r105.length;
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L12;
        r101.a(r105[r107], false);
        r107 = r107 + 1;
    L12:
        return r101.toString();
    L5:
        r104 = null;
        goto L6
    }

    public final String toString() {
        return a();
    }

    public e(a<? extends e> r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        String r101 = r100.f440952a;
        Intrinsics.checkNotNull(r101);
        this.f440948a = r101;
        String r102 = r100.f440953b;
        Intrinsics.checkNotNull(r102);
        this.f440949b = r102;
        this.f440950c = r100.f440954c;
        this.f440951d = r100.f440955d;
    }
}
