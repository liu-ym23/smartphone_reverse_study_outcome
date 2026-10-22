package com.larksuite.framework.http.v2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: classes24.dex */
public interface c {

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OkHttpClient.Builder f285579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f285580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f285581c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f285582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f285583e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f285579a, r101.f285579a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f285580b, r101.f285580b) == true) goto L15;
            return false;
        L15:
            if (this.f285581c == r101.f285581c) goto L18;
            return false;
        L18:
            if (this.f285582d == r101.f285582d) goto L21;
            return false;
        L21:
            if (this.f285583e == r101.f285583e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f285579a.hashCode() * 31) + this.f285580b.hashCode()) * 31;
            int r101 = 1231;
            if (this.f285581c == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f285582d == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f285583e == true) goto L15;
            r101 = 1237;
        L15:
            return r105 + r101;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ClientSpec(builder=" + this.f285579a + ", userCookieStrategy=" + this.f285580b + ", enableUserAgent=" + this.f285581c + ", noneSuccess2Exception=" + this.f285582d + ", enableLog=" + this.f285583e + ')';
        }

        public b(OkHttpClient.Builder r100) {
            d.b r101 = d.b.f285585a;
            Intrinsics.checkNotNullParameter(r100, "builder");
            Intrinsics.checkNotNullParameter(r101, "userCookieStrategy");
            this.f285579a = r100;
            this.f285580b = r101;
            this.f285581c = false;
            this.f285582d = false;
            this.f285583e = false;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.framework.http.v2.c$c, reason: collision with other inner class name */
    public static final class C3923c {
        public static /* synthetic */ Call a(c r100, Request r101) {
            return r100.a(r101, LarkHttpClient$newCall$1.INSTANCE);
        }
    }

    com.larksuite.framework.http.v2.internal.main.a a(Request r100, Function1 r101);

    OkHttpClient getOriginal();
}
