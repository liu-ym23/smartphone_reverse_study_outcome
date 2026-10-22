package com.ss.android.ugc.route_monitor.impl.route_out.control;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f454657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f454658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f454659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f454660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f454661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Uri f454662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f454663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f454664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f454665i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f454666j;

    public final String toString() {
        return "{jumpCertPair=" + this.f454659c + ", fromScene=" + this.f454660d + ", targetPackageName=" + this.f454661e + ", versionCode=" + this.f454663g + ", os=android, appId=" + this.f454664h + ", bizData=" + this.f454666j + ", productDiversion=" + this.f454665i + ", androidIntentAction=" + this.f454657a + ", scheme=" + this.f454658b + ", openUrl=" + this.f454662f + '}';
    }

    public o(String r100, String r101, d r102, String r103, String r104, Uri r105, long r106, String r107, boolean r110, Map r111) {
        this.f454657a = r100;
        this.f454658b = r101;
        this.f454659c = r102;
        this.f454660d = r103;
        this.f454661e = r104;
        this.f454662f = r105;
        this.f454663g = r106;
        this.f454664h = r107;
        this.f454665i = r110;
        this.f454666j = r111;
    }
}
