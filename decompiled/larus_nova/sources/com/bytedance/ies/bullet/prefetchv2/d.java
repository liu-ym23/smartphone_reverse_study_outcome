package com.bytedance.ies.bullet.prefetchv2;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public interface d {

    public interface a {
        void a(Throwable r100);

        void b(b r100);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f247520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f247521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f247522c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f247523d;

        public b() {
            this.f247523d = -1;
        }
    }

    public interface c {
        void a(Throwable r100);

        void b(b r100);

        void c(b r100);
    }

    void a(String r100, Map r101, boolean r102, z.d r103);

    void b(String r100, Map r101, String r102, JSONObject r103, boolean r104, z.d r105);
}
