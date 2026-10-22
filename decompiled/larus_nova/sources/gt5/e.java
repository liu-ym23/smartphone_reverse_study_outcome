package gt5;

import com.byted.cast.mediacommon.MediaCaptureError;
import com.bytedance.sdk.open.aweme.CommonConstants;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f482517a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f482518b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f482519c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f482520d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f482521e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f482522f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f482523g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f482524h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f482525i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f482526j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b f482527k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f482528l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f482529m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final b f482530n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final b f482531o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f482532p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final b f482533q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final C6064e f482534r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final C6064e f482535s = null;

    public static final class a extends OPMonitorCode {
        public a(OPMonitorLevel r100) {
            super("client.larkwebview.api", 5000, r100, "web biz api invoke");
        }
    }

    public static final class b extends OPMonitorCode {
        public b(int r100, OPMonitorLevel r101, String r102) {
            super("client.larkwebview.base", r100, r101, r102);
        }
    }

    public static final class c extends OPMonitorCode {
        public c(int r100, OPMonitorLevel r101, String r102) {
            super("client.larkwebview.bridge", r100, r101, r102);
        }
    }

    public static final class d extends OPMonitorCode {
        public d(int r100, OPMonitorLevel r101, String r102) {
            super("client.larkwebview.pool", r100, r101, r102);
        }
    }

    /* JADX INFO: renamed from: gt5.e$e, reason: collision with other inner class name */
    public static final class C6064e extends OPMonitorCode {
        public C6064e(int r100, OPMonitorLevel r101, String r102) {
            super("client.larkwebview.quality", r100, r101, r102);
        }
    }

    static {
        OPMonitorLevel r100 = OPMonitorLevel.NORMAL;
        f482517a = new b(20001, r100, "load url start");
        f482518b = new b(20002, r100, "load url end");
        OPMonitorLevel r101 = OPMonitorLevel.ERROR;
        f482519c = new b(20003, r101, "load res failed");
        new b(20004, r101, "evaluate javascript");
        OPMonitorLevel r102 = OPMonitorLevel.WARN;
        new b(20005, r102, "evaluate javascript error");
        f482520d = new b(20006, r100, "larkwebview html tag");
        f482521e = new b(20008, r101, "load url failed");
        f482522f = new b(20009, r100, "create larkwebview");
        f482523g = new b(20010, r101, "setwebviewclient failed");
        f482524h = new b(20011, r101, "setwebchromeclient failed");
        f482525i = new b(20012, r101, "load url received error");
        f482526j = new b(CommonConstants.ShareErrorCode.CANCEL_PUBLISH, r100, "browse url begin");
        f482527k = new b(20014, r100, "browse url end");
        f482528l = new b(CommonConstants.ShareErrorCode.SAVE_TO_DRAFT, r100, "destroy webview");
        f482529m = new b(CommonConstants.ShareErrorCode.PUBLISH_FAIL_UNKNOWN, r100, "web container onresume");
        f482530n = new b(20017, r100, "web container onpause");
        new b(20018, r100, "web container load url check encode");
        new b(20019, r100, "report fmp");
        f482531o = new b(20020, r100, "override url loading");
        f482532p = new b(20021, r101, "invalid web client");
        f482533q = new b(20022, r100, "web load duration");
        new C6064e(40001, r101, "schema intercept");
        new C6064e(40002, r101, "schema navigate");
        new C6064e(40003, r101, "seclink check");
        new C6064e(40004, r101, "load url cost");
        new C6064e(40005, r101, "eva js cost");
        new C6064e(40006, r100, "first content paint");
        new C6064e(40007, r100, "blank check result not blank");
        new C6064e(40008, r101, "occur black screen");
        new C6064e(40009, r100, "larkwebview performance timing");
        f482534r = new C6064e(40010, r101, "larkwebview render process gone");
        new C6064e(40011, r101, "blank check result is blank");
        new C6064e(40012, r102, "overrideurlloading not safe url ");
        new C6064e(40013, r101, "larkwebview occur gloom");
        f482535s = new C6064e(40014, r101, "larkwebview error page");
        new d(30000, r101, "register_existing_identifier");
        new d(30001, r101, "identifier_not_exist");
        new d(30002, r101, "webview_type_error");
        new d(30003, r100, "reigster pool");
        new d(30004, r101, "web pool recycle , but get tag failed");
        new d(30005, r101, "web pool recycle, but get tag empty");
        new d(MediaCaptureError.ERROR_CAST_CONNECTION_NOT_BUILT, r100, "web pool recycle");
        new d(30007, r100, "web pool release");
        new a(r100);
    }
}
