package com.ss.android.lark.officesdk.minutes.service.recording.common.widget.web;

import android.webkit.WebView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f435508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f435509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f435510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f435511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f435512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f435513f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f435515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f435516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function1<WebView, Boolean> f435517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Function0<Unit> f435518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function0<Unit> f435519f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function0<Unit> f435520g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Function2<String, JSONObject, Unit> f435521h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f435514a, r101.f435514a) == true) goto L12;
            return false;
        L12:
            if (this.f435515b == r101.f435515b) goto L15;
            return false;
        L15:
            if (this.f435516c == r101.f435516c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f435517d, r101.f435517d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f435518e, r101.f435518e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f435519f, r101.f435519f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f435520g, r101.f435520g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f435521h, r101.f435521h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f435514a.hashCode() * 31) + this.f435515b) * 31;
            long r101 = this.f435516c;
            return ((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f435517d.hashCode()) * 31) + this.f435518e.hashCode()) * 31) + this.f435519f.hashCode()) * 31) + this.f435520g.hashCode()) * 31) + this.f435521h.hashCode();
        }

        public final String toString() {
            return "Config(webViewType=" + this.f435514a + ", maxRecreateCount=" + this.f435515b + ", cooldownMs=" + this.f435516c + ", isCurrentWebView=" + this.f435517d + ", onRenderGone=" + this.f435518e + ", onRecreate=" + this.f435519f + ", onMaxRetryReached=" + this.f435520g + ", onTrackEvent=" + this.f435521h + ')';
        }

        public b(String r100, int r101, Function1 r102, Function0 r103, Function0 r104, Function0 r105, Function2 r106) {
            Intrinsics.checkNotNullParameter(r100, "webViewType");
            Intrinsics.checkNotNullParameter(r102, "isCurrentWebView");
            Intrinsics.checkNotNullParameter(r103, "onRenderGone");
            Intrinsics.checkNotNullParameter(r104, "onRecreate");
            Intrinsics.checkNotNullParameter(r105, "onMaxRetryReached");
            Intrinsics.checkNotNullParameter(r106, "onTrackEvent");
            this.f435514a = r100;
            this.f435515b = r101;
            this.f435516c = 30000;
            this.f435517d = r102;
            this.f435518e = r103;
            this.f435519f = r104;
            this.f435520g = r105;
            this.f435521h = r106;
        }
    }

    static {
    }

    public final void a() {
        lvb.a.e(this.f435509b, "[onResume] isInBackground=" + this.f435512e + ", needRecreateOnResume=" + this.f435513f + ", currentCount=" + this.f435510c);
        this.f435512e = false;
        if (this.f435510c <= 0) goto L6;
        lvb.a.e(this.f435509b, "[onResume] reset recreate count from " + this.f435510c + " to 0");
        this.f435510c = 0;
    L6:
        if (this.f435513f == false) goto L9;
        this.f435513f = false;
        b();
        return;
    }

    public final void b() {
        this.f435511d = System.currentTimeMillis();
        this.f435510c++;
        lvb.a.e(this.f435509b, "[recreateWebView] start recreate, count=" + this.f435510c);
        this.f435508a.f435519f.invoke();
        lvb.a.e(this.f435509b, "[recreateWebView] recreate completed");
    }

    public e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f435508a = r100;
        this.f435509b = "MmWebViewRenderGoneHandler_" + r100.f435514a;
        this.f435512e = true;
    }
}
