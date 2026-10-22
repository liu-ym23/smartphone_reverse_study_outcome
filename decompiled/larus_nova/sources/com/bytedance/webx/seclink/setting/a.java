package com.bytedance.webx.seclink.setting;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C3815a f272605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, c> f272606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f272607c;

    /* JADX INFO: renamed from: com.bytedance.webx.seclink.setting.a$a, reason: collision with other inner class name */
    public static class C3815a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f272608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f272609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f272610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f272611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f272612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f272613f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public double f272614g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<String> f272615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<String> f272616i;

        public C3815a() {
            this.f272613f = true;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f272617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f272618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f272619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Set<String> f272620d;

        public b() {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f272621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f272622b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f272623c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f272624d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Set<String> f272625e;

        public c() {
        }

        public final String toString() {
            return "SceneConfig{name='" + this.f272621a + "', enable=" + this.f272622b + ", async_mode=" + this.f272623c + ", scheme=" + this.f272625e + '}';
        }
    }

    public a() {
    }

    public final String toString() {
        return "SettingConfig{common=" + this.f272605a + ", scenes=" + this.f272606b + '}';
    }
}
