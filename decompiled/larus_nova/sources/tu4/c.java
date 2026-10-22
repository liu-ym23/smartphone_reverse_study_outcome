package tu4;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$OpenFile$OpenType;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.m;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.ui.j;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import vv4.k;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements BitableReportPlugin.c, e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f547623j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f547625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f547626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x2 f547627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f547628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DocViewModel f547629f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f547630g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f547631h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DocumentPluginHost f547632i;

    public static final class a {

        /* JADX INFO: renamed from: tu4.c$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C7779a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f547633a = null;

            static {
                int[] r100 = new int[BitableStatisticConstant$OpenFile$OpenType.values().length];
                r100[BitableStatisticConstant$OpenFile$OpenType.Main.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[BitableStatisticConstant$OpenFile$OpenType.ShareRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[BitableStatisticConstant$OpenFile$OpenType.FastAdd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f547633a = r100;
            }
        }

        public static f a(BitableStatisticConstant$OpenFile$OpenType r100) {
            Intrinsics.checkNotNullParameter(r100, "openType");
            int r101 = C7779a.f547633a[r100.ordinal()];
            if (r101 == 1) goto L13;
            if (r101 == 2) goto L15;
            if (r101 != 3) goto L10;
            return new com.bytedance.ee.bear.bitable.statistic.business.openfile.fastadd.b();
        L10:
            throw new NoWhenBranchMatchedException();
        L15:
            return new com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord.b();
        L13:
            return new com.bytedance.ee.bear.bitable.statistic.business.openfile.main.c();
        }
    }

    public static final class b implements m0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f547634a;

        @Override // com.bytedance.ee.bear.contract.m0
        public final void c() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void d() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void e() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void h() {
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void a() {
            c r100 = this.f547634a;
            if (r100.f547624a == false) goto L8;
            String r101 = r100.f547628e;
            if (r101 == null) goto L9;
            long r102 = System.currentTimeMillis();
            Lazy r103 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r104 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_RENDER_CACHE", r102, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r101, r104);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.c(r101, System.currentTimeMillis(), null, true, 4);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
            c r100 = this.f547634a;
            String r101 = r100.f547628e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.f547624a == false) goto L7;
            long r102 = System.currentTimeMillis();
            Lazy r103 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r104 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_END_RENDER", r102, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r101, r104);
            return;
        L7:
            long r105 = System.currentTimeMillis();
            Lazy r106 = tu4.b.f547622a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r107 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_END_RENDER", r105, false, 12);
            tu4.b.c().addNormalPoint(r101, r107);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
            c r100 = this.f547634a;
            String r101 = r100.f547628e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.f547624a == false) goto L7;
            long r102 = System.currentTimeMillis();
            Lazy r103 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r104 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_TEMPLATE_PRELOAD_START", r102, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r101, r104);
            return;
        L7:
            long r105 = System.currentTimeMillis();
            Lazy r106 = tu4.b.f547622a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r107 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TEMPLATE_PRELOAD_START", r105, false, 12);
            tu4.b.c().addNormalPoint(r101, r107);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
            c r100 = this.f547634a;
            String r101 = r100.f547628e;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100.f547624a == false) goto L7;
            long r102 = System.currentTimeMillis();
            Lazy r103 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r104 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_TEMPLATE_PRELOAD_END", r102, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r101, r104);
            return;
        L7:
            long r105 = System.currentTimeMillis();
            Lazy r106 = tu4.b.f547622a;
            Intrinsics.checkNotNullParameter(r101, "traceId");
            BitableStatisticEventModel$NormalPointModel r107 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TEMPLATE_PRELOAD_END", r105, false, 12);
            tu4.b.c().addNormalPoint(r101, r107);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
            long r100 = System.currentTimeMillis();
            c r101 = this.f547634a;
            String r102 = r101.f547628e;
            if (r102 != null) goto L5;
        L8:
            c r103 = this.f547634a;
            if (r103.f547624a == true) goto L12;
            int r104 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
            com.bytedance.ee.bear.bitable.chameleon.a.c(r103.f547632i, "BITABLE_NATIVE_LOAD_URL", r100);
            com.bytedance.ee.bear.bitable.chameleon.a.c(this.f547634a.f547632i, "BITABLE_NATIVE_CALL_JS_RENDER", r100);
            return;
        L12:
            return;
        L5:
            if (r101.f547624a == false) goto L7;
            Lazy r105 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.f215603a;
            Intrinsics.checkNotNullParameter(r102, "traceId");
            BitableStatisticEventModel$NormalPointModel r106 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_START_RENDER", r100, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r102, r106);
            goto L8
        L7:
            Lazy r107 = tu4.b.f547622a;
            Intrinsics.checkNotNullParameter(r102, "traceId");
            BitableStatisticEventModel$NormalPointModel r108 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_START_RENDER", r100, false, 12);
            tu4.b.c().addNormalPoint(r102, r108);
            goto L8
        }

        public b(c r100) {
            this.f547634a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r100) {
            c r101 = this.f547634a;
            String r102 = r101.f547628e;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r101.f547624a == true) goto L9;
            long r103 = System.currentTimeMillis();
            Lazy r104 = tu4.b.f547622a;
            Intrinsics.checkNotNullParameter(r102, "traceId");
            BitableStatisticEventModel$NormalPointModel r105 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_OLD_RENDER_SUCCESS", r103, false, 12);
            r105.addExtras(r100);
            tu4.b.c().addNormalPoint(r102, r105);
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(DocException r100, Map r101) {
            c r102 = this.f547634a;
            String r103 = r102.f547628e;
            if (r103 == null) goto L6;
            j.d(new d(r102, r103, r101), 200);
            return;
        }
    }

    static {
    }

    @Override // tu4.e
    public final boolean d() {
        return this.f547624a;
    }

    @Override // tu4.e
    public final String e() {
        return this.f547628e;
    }

    @Override // tu4.e
    public final x2 f() {
        return this.f547627d;
    }

    public c(boolean r100) {
        this.f547624a = r100;
        this.f547625b = org.koin.java.a.d(m.class);
        this.f547626c = org.koin.java.a.d(com.bytedance.ee.bear.contract.d.class);
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin.c
    public final void a(DocumentPluginHost r100) {
        this.f547629f = null;
        this.f547631h = null;
        b r101 = this.f547630g;
        if (r101 == null) goto L10;
        if (r100 == null) goto L6;
        k r102 = r100.getWeb();
    L8:
        if ((r102 instanceof z4) == false) goto L10;
        ((z4) r102).m(r101);
        goto L10
    L6:
        r102 = null;
    L10:
        this.f547630g = null;
        this.f547627d = null;
        this.f547632i = null;
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin.c
    public final void b(DocumentPluginHost r100) {
        this.f547632i = r100;
        Long r101 = null;
        String r102 = null;
        if (r100 == null) goto L5;
        x2 r103 = r100.getDocumentLoader();
    L6:
        this.f547627d = r103;
        if (r100 == null) goto L9;
        DocViewModel r104 = r100.a();
    L10:
        this.f547629f = r104;
        if (r100 == null) goto L13;
        k r105 = r100.getWeb();
    L15:
        if ((r105 instanceof z4) == false) goto L17;
        b r106 = new b(this);
        this.f547630g = r106;
        ((z4) r105).x(r106);
    L17:
        boolean r107 = true;
        if (this.f547624a == false) goto L31;
        DocViewModel r108 = this.f547629f;
        if (r108 == null) goto L22;
        Intrinsics.checkNotNullParameter(r108, "<this>");
        r102 = tu4.b.b(r108);
    L22:
        int r109 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        tt5.a.h("BitableStatistic", "ReportFileHandler " + ("existTraceId=" + r102 + " this=" + this));
        if (r102 != null) goto L25;
    L28:
        if (r107 == true) goto L30;
        this.f547628e = r102;
    L30:
        this.f547631h = a.a(BitableStatisticConstant$OpenFile$OpenType.Main);
        return;
    L25:
        if (r102.length() == 0) goto L28;
        r107 = false;
        goto L28
    L31:
        int r110 = com.bytedance.ee.bear.bitable.chameleon.a.f209646a;
        com.bytedance.ee.bear.bitable.chameleon.b r111 = com.bytedance.ee.bear.bitable.chameleon.a.a(r100);
        if (r111 == null) goto L35;
        this.f547628e = r111.getTraceId();
        this.f547631h = r111.getProxy();
        return;
    L35:
        String r112 = ((m) this.f547625b.getValue()).createNormalTrace(null);
        this.f547628e = r112;
        DocViewModel r113 = this.f547629f;
        if (r113 == null) goto L38;
        r113.setExtraData("OPEN_FILE_TRACE_ID", r112);
    L38:
        DocViewModel r114 = this.f547629f;
        if (r114 == null) goto L41;
        BearUrl r115 = r114.getBearUrl();
    L43:
        if (fx4.a.b(r115) == false) goto L45;
        BitableStatisticConstant$OpenFile$OpenType r116 = BitableStatisticConstant$OpenFile$OpenType.ShareRecord;
    L54:
        f r117 = a.a(r116);
        this.f547631h = r117;
        com.bytedance.ee.bear.bitable.statistic.j r118 = r117.a();
        if (r100 == null) goto L59;
        DocViewModel r119 = r100.a();
        if (r119 == null) goto L59;
        BearUrl r120 = r119.getOriginBearUrl();
    L61:
        if (fx4.a.g(r120) == true) goto L63;
    L65:
        ((m) this.f547625b.getValue()).addNormalConsumer(r112, r118);
        String r121 = ((com.bytedance.ee.bear.contract.d) this.f547626c.getValue()).e("start_open", ILoadStallMonitor.START_TIME);
        if (r121 == null) goto L68;
        r101 = StringsKt.toLongOrNull(r121);
    L68:
        tu4.b.j(r112, r101, r115, r116);
        return;
    L63:
        if ((r118 instanceof tu4.a) == false) goto L65;
        tu4.a r122 = (tu4.a) r118;
        r122.getClass();
        Intrinsics.checkNotNullParameter(EventConstant.Key.MODULE, "key");
        Intrinsics.checkNotNullParameter("wiki", "value");
        r122.f215610b.put(EventConstant.Key.MODULE, "wiki");
    L59:
        r120 = null;
        goto L61
    L45:
        DocViewModel r123 = this.f547629f;
        if (r123 != null) goto L48;
    L50:
        r107 = false;
    L51:
        if (r107 == false) goto L53;
        r116 = BitableStatisticConstant$OpenFile$OpenType.FastAdd;
        goto L54
    L53:
        r116 = BitableStatisticConstant$OpenFile$OpenType.Main;
        goto L54
    L48:
        if (r123.isType(sbb.e.f541299j) != true) goto L50;
    L41:
        r115 = null;
        goto L43
    L13:
        r105 = null;
        goto L15
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableReportPlugin.c
    public final void c(BitableReportPlugin.ReportModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        int r101 = com.bytedance.ee.bear.bitable.statistic.common.e.f215628a;
        StringBuilder r102 = new StringBuilder("handle ");
        if (this.f547624a == false) goto L5;
        String r103 = "doc ";
    L6:
        r102.append(r103);
        r102.append(r100.getEvent());
        r102.append(' ');
        r102.append(r100.getExtra());
        tt5.a.h("BitableStatistic", "ReportFileHandler " + r102.toString());
        DocViewModel r104 = this.f547629f;
        if (r104 == null) goto L11;
        BearUrl r105 = r104.getOriginBearUrl();
        if (r105 == null) goto L11;
        String r106 = r105.f222561b;
    L13:
        if (Intrinsics.areEqual(r100.getToken(), r106) == true) goto L25;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("ReportFileHandler", "token not match " + r100.getEvent() + ' ' + du5.b.g(r106) + ' ' + du5.b.g(r100.getToken()));
        String r107 = this.f547628e;
        if (r107 == null) goto L25;
        int r108 = com.bytedance.ee.bear.bitable.statistic.common.d.f215627a;
        m r109 = (m) this.f547625b.getValue();
        Map r110 = MapsKt.mapOf(TuplesKt.to("event", r100.getEvent()));
        Intrinsics.checkNotNullParameter(r109, "statisticService");
        Intrinsics.checkNotNullParameter(r107, "traceId");
        Intrinsics.checkNotNullParameter("token_not_match", "reason");
        JSONObject r111 = new JSONObject();
        r111.put("reason", "token_not_match");
        if (r110 == null) goto L24;
        Iterator r112 = r110.entrySet().iterator();
    L20:
        if (r112.hasNext() == false) goto L24;
        Map.Entry r113 = (Map.Entry) r112.next();
        if (r113.getValue() == null) goto L20;
        r111.put((String) r113.getKey(), r113.getValue());
    L24:
        Unit r114 = Unit.INSTANCE;
        r109.reportError(r107, "base_mobile_performance_warning_point", r111);
    L25:
        f r115 = this.f547631h;
        if (r115 == null) goto L34;
        r115.b(this, r100);
        return;
    L34:
        return;
    L11:
        r106 = null;
        goto L13
    L5:
        r103 = "";
        goto L6
    }
}
