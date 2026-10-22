package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class c {
    public final String a;
    public final String b;
    public final int c;

    public static final class a extends c {
        public static final a d = null;

        static {
            d = new a();
        }

        public a() {
            super("resp_has_no_promotion_not_top", MonitorLevel.ERROR);
        }
    }

    public static final class b extends c {
        public static final b d = null;

        static {
            d = new b();
        }

        public b() {
            super("resp_has_no_promotion_with_loading", MonitorLevel.ERROR);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.c$c, reason: collision with other inner class name */
    public static final class C0090c extends c {
        public static final C0090c d = null;

        static {
            d = new C0090c();
        }

        public C0090c() {
            super("req_first_page_error", MonitorLevel.ERROR);
        }
    }

    public static final class d extends c {
        public static final d d = null;

        static {
            d = new d();
        }

        public d() {
            super("req_all_data_but_not_have_all", MonitorLevel.WARN);
        }
    }

    public static final class e extends c {
        public static final e d = null;

        static {
            d = new e();
        }

        public e() {
            super("req_error", MonitorLevel.ERROR);
        }
    }

    public static final class f extends c {
        public static final f d = null;

        static {
            d = new f();
        }

        public f() {
            super("resp_code_not_zero", MonitorLevel.ERROR);
        }
    }

    public c(String r2, int r3) {
        this.a = "ListRefresh";
        this.b = r2;
        this.c = r3;
    }
}
