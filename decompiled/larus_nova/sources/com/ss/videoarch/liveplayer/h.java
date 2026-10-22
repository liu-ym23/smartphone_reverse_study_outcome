package com.ss.videoarch.liveplayer;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface h {

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JSONObject f458842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f458843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f458844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f458845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Exception f458846e;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public JSONObject f458847a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f458848b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f458849c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Exception f458850d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f458851e;

            public b build() {
                return new b(this, null);
            }

            private a() {
            }

            public /* synthetic */ a(a r100) {
                this();
            }

            public a setBody(String r100) {
                this.f458848b = r100;
                return this;
            }

            public a setCode(int r100) {
                this.f458851e = r100;
                return this;
            }

            public a setException(Exception r100) {
                this.f458850d = r100;
                return this;
            }

            public a setHeader(String r100) {
                this.f458849c = r100;
                return this;
            }

            public a setResponse(JSONObject r100) {
                this.f458847a = r100;
                return this;
            }
        }

        public static a newBuilder() {
            return new a(null);
        }

        private b(a r100) {
            this.f458842a = r100.f458847a;
            this.f458843b = r100.f458848b;
            this.f458844c = r100.f458849c;
            this.f458846e = r100.f458850d;
            this.f458845d = r100.f458851e;
        }

        public /* synthetic */ b(a r100, a r101) {
            this(r100);
        }
    }

    b doPost(String r100, String r101);

    b doRequest(String r100, String r101);
}
