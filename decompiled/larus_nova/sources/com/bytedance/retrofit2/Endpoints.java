package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public final class Endpoints {
    private static final String DEFAULT_NAME = "default";

    public static class FixedEndpoint implements Endpoint {
        private final String apiUrl;
        private final String name;

        @Override // com.bytedance.retrofit2.Endpoint
        public String getName() {
            return this.name;
        }

        @Override // com.bytedance.retrofit2.Endpoint
        public String getUrl() {
            return this.apiUrl;
        }

        public FixedEndpoint(String r100, String r101) {
            this.apiUrl = r100;
            this.name = r101;
        }
    }

    private Endpoints() {
    }

    public static Endpoint newFixedEndpoint(String r100) {
        return new FixedEndpoint(r100, "default");
    }

    public static Endpoint newFixedEndpoint(String r100, String r101) {
        return new FixedEndpoint(r100, r101);
    }
}
