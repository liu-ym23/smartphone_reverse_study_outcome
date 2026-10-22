package com.bytedance.ies.web.jsbridge2;

/* JADX INFO: loaded from: classes19.dex */
public interface IBridgePermissionConfigurator {

    public static final enum RegionConfig extends Enum<RegionConfig> {
        public static final RegionConfig CN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RegionConfig[] f249276a = null;
        String url;

        static {
            RegionConfig r100 = new RegionConfig();
            CN = r100;
            f249276a = new RegionConfig[]{r100};
        }

        public RegionConfig() {
            super("CN", 0);
            this.url = "https://jsb.snssdk.com/src/server/v2/package";
        }

        public static RegionConfig[] values() {
            return (RegionConfig[]) f249276a.clone();
        }

        public String getUrl() {
            return this.url;
        }

        public static RegionConfig valueOf(String r100) {
            return (RegionConfig) r27.a.a(RegionConfig.class, r100);
        }
    }

    public interface a {
        boolean a();

        boolean shouldIntercept();
    }
}
