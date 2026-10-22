package com.bytedance.ug.sdk.luckycat.impl.browser.webview;

import com.bytedance.ug.sdk.luckycat.impl.model.ContainerType;
import com.bytedance.ug.sdk.luckycat.impl.model.PageLoadReason;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final class PageInfo {
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean E;
    public PAGE_LOAD_STATUS F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f271117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f271118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PageLoadReason f271119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f271120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f271121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f271122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f271123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f271124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ContainerType f271125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f271126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f271127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f271128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSONObject f271129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f271130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f271131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f271132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f271133q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f271134r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f271135s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f271136t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f271137u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f271138v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f271139w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f271140x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f271141y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long f271142z;

    public static final enum PAGE_LOAD_STATUS extends Enum<PAGE_LOAD_STATUS> {
        public static final PAGE_LOAD_STATUS FIRST_SCREEN = null;
        public static final PAGE_LOAD_STATUS LOAD_TEMPLATE_READY_END = null;
        public static final PAGE_LOAD_STATUS LOAD_TEMPLATE_READY_START = null;
        public static final PAGE_LOAD_STATUS LOAD_TEMPLATE_SUCCESS = null;
        public static final PAGE_LOAD_STATUS LYNX_PAGE_START = null;
        public static final PAGE_LOAD_STATUS PAGE_LOAD_END = null;
        public static final PAGE_LOAD_STATUS READ_TEMPLATE_END = null;
        public static final PAGE_LOAD_STATUS READ_TEMPLATE_START = null;
        public static final PAGE_LOAD_STATUS RENDER_END = null;
        public static final PAGE_LOAD_STATUS RENDER_START = null;
        public static final PAGE_LOAD_STATUS UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PAGE_LOAD_STATUS[] f271143a = null;
        private String value;

        static {
            PAGE_LOAD_STATUS r100 = new PAGE_LOAD_STATUS("UNKNOWN", 0, "unknown");
            UNKNOWN = r100;
            PAGE_LOAD_STATUS r101 = new PAGE_LOAD_STATUS("LOAD_TEMPLATE_READY_START", 1, "load_template_start");
            LOAD_TEMPLATE_READY_START = r101;
            PAGE_LOAD_STATUS r102 = new PAGE_LOAD_STATUS("LOAD_TEMPLATE_READY_END", 2, "load_template_end");
            LOAD_TEMPLATE_READY_END = r102;
            PAGE_LOAD_STATUS r103 = new PAGE_LOAD_STATUS("READ_TEMPLATE_START", 3, "read_template_start");
            READ_TEMPLATE_START = r103;
            PAGE_LOAD_STATUS r104 = new PAGE_LOAD_STATUS("READ_TEMPLATE_END", 4, "read_template_end");
            READ_TEMPLATE_END = r104;
            PAGE_LOAD_STATUS r105 = new PAGE_LOAD_STATUS("LOAD_TEMPLATE_SUCCESS", 5, "load_template_success");
            LOAD_TEMPLATE_SUCCESS = r105;
            PAGE_LOAD_STATUS r110 = new PAGE_LOAD_STATUS(ChameleonOpenTracker.EventType.RENDER_START, 6, "render_start");
            RENDER_START = r110;
            PAGE_LOAD_STATUS r111 = new PAGE_LOAD_STATUS("LYNX_PAGE_START", 7, "lynx_page_start");
            LYNX_PAGE_START = r111;
            PAGE_LOAD_STATUS r112 = new PAGE_LOAD_STATUS(ChameleonOpenTracker.EventType.RENDER_END, 8, "render_end");
            RENDER_END = r112;
            PAGE_LOAD_STATUS r113 = new PAGE_LOAD_STATUS("FIRST_SCREEN", 9, "first_screen");
            FIRST_SCREEN = r113;
            PAGE_LOAD_STATUS r114 = new PAGE_LOAD_STATUS("PAGE_LOAD_END", 10, "page_load_end");
            PAGE_LOAD_END = r114;
            f271143a = new PAGE_LOAD_STATUS[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static PAGE_LOAD_STATUS[] values() {
            return (PAGE_LOAD_STATUS[]) f271143a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static /* synthetic */ String access$000(PAGE_LOAD_STATUS r100) {
            return r100.value;
        }

        public static PAGE_LOAD_STATUS valueOf(String r100) {
            return (PAGE_LOAD_STATUS) a.a(PAGE_LOAD_STATUS.class, r100);
        }

        public PAGE_LOAD_STATUS(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public PageInfo() {
        this.f271117a = "";
        this.f271118b = "";
        this.f271124h = false;
        this.f271126j = false;
        this.f271127k = -1;
        this.f271130n = "";
        this.f271131o = false;
        this.f271132p = "init";
        this.f271133q = false;
        this.f271134r = -1;
        this.f271135s = -1;
        this.f271136t = -1;
        this.f271137u = -1;
        this.f271138v = -1;
        this.f271139w = -1;
        this.f271140x = -1;
        this.f271141y = -1;
        this.f271142z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.D = -1;
        this.E = false;
        this.F = PAGE_LOAD_STATUS.UNKNOWN;
    }
}
