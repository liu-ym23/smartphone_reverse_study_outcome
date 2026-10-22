package com.ss.videoarch.liveplayer;

import com.ss.videoarch.liveplayer.log.LiveLoggerService;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f459568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f459569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f459570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f459571d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.ss.videoarch.liveplayer.model.a f459572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LiveLoggerService f459573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f459574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List<String> f459575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ymc.a f459576e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<String> f459577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f459578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f459579h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f459580i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f459581j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public anc.a f459582k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f459583l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f459584m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f459585n;

        public a() {
            this.f459572a = new com.ss.videoarch.liveplayer.model.a();
            this.f459574c = "tcp";
            this.f459575d = null;
            this.f459577f = null;
            this.f459578g = "none";
            this.f459579h = null;
            this.f459580i = "none";
            this.f459581j = "none";
            this.f459583l = null;
            this.f459584m = "";
            this.f459585n = false;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f459586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f459587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f459588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f459589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f459590e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f459591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f459592g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f459593h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f459594i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f459595j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f459596k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f459597l;

        public b() {
            this.f459586a = 0;
            this.f459587b = 0;
            this.f459588c = true;
            this.f459589d = 0;
            this.f459590e = 0;
            this.f459591f = 1;
            this.f459592g = false;
            this.f459593h = false;
            this.f459594i = false;
            this.f459595j = true;
            this.f459596k = true;
            this.f459597l = false;
        }
    }

    public p() {
    }

    public a getDNSParserData() {
        return this.f459570c;
    }

    public b getDnsToggles() {
        return this.f459571d;
    }

    public String getHost() {
        return this.f459569b;
    }

    public String getPlayUrl() {
        return this.f459568a;
    }

    public void setDNSParserData(a r100) {
        this.f459570c = r100;
    }

    public void setDnsToggles(b r100) {
        this.f459571d = r100;
    }

    public void setHost(String r100) {
        this.f459569b = r100;
    }

    public void setPlayUrl(String r100) {
        this.f459568a = r100;
    }
}
