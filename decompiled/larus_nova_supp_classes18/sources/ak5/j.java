package ak5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface j {

    public static abstract class a implements j {
        public String a;
        public boolean b;

        public a() {
        }
    }

    public static class b extends a {
        public b() {
            this.a = "https://internal-api-space.feishu-boe.cn";
        }
    }

    public static class c extends a {
        public c() {
            this.a = "https://internal-api-space.feishu.cn";
        }
    }

    public static class d extends a {
        public d() {
            this.a = "https://internal-api-space.larksuite.com";
        }
    }

    public static class e extends a {
        public e() {
            this.a = "https://internal-api-space.larksuite-staging.com";
        }
    }

    public static class f extends a {
        public f() {
            this.a = "https://internal-api-space.feishu-staging.cn";
        }
    }
}
