package com.bytedance.pia.core.api;

import android.os.Build;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes21.dex */
public final class PiaAppInfo {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f266135l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f266136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f266137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f266138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f266139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f266140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f266141f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f266142g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f266143h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f266144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f266145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<String> f266146k;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f266147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f266148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f266149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f266150d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f266151e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f266152f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f266153g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f266154h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f266155i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f266156j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List<String> f266157k;

        public Builder() {
            this.f266147a = 0;
            this.f266148b = -1;
            this.f266149c = "";
            this.f266150d = "";
            this.f266151e = "";
            this.f266152f = "";
            this.f266153g = Build.PRODUCT;
            this.f266154h = Build.VERSION.RELEASE;
            this.f266155i = "";
            this.f266156j = false;
        }

        public Builder setDebuggable(boolean r100) {
            this.f266156j = r100;
            return this;
        }

        public Builder setDeviceType(String r100) {
            this.f266153g = r100;
            return this;
        }

        public Builder setOsVersion(String r100) {
            this.f266154h = r100;
            return this;
        }

        public Builder setUserID(String r100) {
            this.f266149c = r100;
            return this;
        }

        public Builder setWhiteList(List<String> r100) {
            this.f266157k = r100;
            return this;
        }
    }

    static {
        f266135l = PatternProtector.compile("^(\\d+(\\.\\d+){0,3})\\.*");
    }

    public PiaAppInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, List r107, boolean r108, long r110, long r111) {
        this.f266138c = r100;
        this.f266139d = r101;
        this.f266140e = r102;
        this.f266141f = r103;
        this.f266142g = r104;
        this.f266143h = r105;
        this.f266144i = r106;
        this.f266136a = r110;
        this.f266137b = r111;
        this.f266145j = r108;
        this.f266146k = r107;
    }
}
