package tu4;

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
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.util.ui.j;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements BitableReportPlugin.c, e {
    public static final /* synthetic */ int j = 0;
    public final boolean a;
    public final Lazy b;
    public final Lazy c;
    public x2 d;
    public String e;
    public DocViewModel f;
    public b g;
    public f h;
    public DocumentPluginHost i;

    public static final class a {

        /* JADX INFO: renamed from: tu4.c$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0298a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[BitableStatisticConstant$OpenFile$OpenType.values().length];
                r0[BitableStatisticConstant$OpenFile$OpenType.Main.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[BitableStatisticConstant$OpenFile$OpenType.ShareRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[BitableStatisticConstant$OpenFile$OpenType.FastAdd.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public static f a(BitableStatisticConstant$OpenFile$OpenType r1) {
            Intrinsics.checkNotNullParameter(r1, "openType");
            int r2 = C0298a.a[r1.ordinal()];
            if (r2 == 1) goto L13;
            if (r2 == 2) goto L15;
            if (r2 != 3) goto L10;
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
        public final /* synthetic */ c a;

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
            c r0 = this.a;
            if (r0.a == false) goto L8;
            String r2 = r0.e;
            if (r2 == null) goto L9;
            long r5 = System.currentTimeMillis();
            Lazy r1 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.a;
            Intrinsics.checkNotNullParameter(r2, "traceId");
            BitableStatisticEventModel$NormalPointModel r3 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_RENDER_CACHE", r5, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r2, r3);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.c(r2, System.currentTimeMillis(), null, true, 4);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void b() {
            c r0 = this.a;
            String r1 = r0.e;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.a == false) goto L7;
            long r5 = System.currentTimeMillis();
            Lazy r2 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r3 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_END_RENDER", r5, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r1, r3);
            return;
        L7:
            long r6 = System.currentTimeMillis();
            Lazy r4 = tu4.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r7 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_END_RENDER", r6, false, 12);
            tu4.b.c().addNormalPoint(r1, r7);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void f() {
            c r0 = this.a;
            String r1 = r0.e;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.a == false) goto L7;
            long r5 = System.currentTimeMillis();
            Lazy r2 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r3 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_TEMPLATE_PRELOAD_START", r5, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r1, r3);
            return;
        L7:
            long r6 = System.currentTimeMillis();
            Lazy r4 = tu4.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r7 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TEMPLATE_PRELOAD_START", r6, false, 12);
            tu4.b.c().addNormalPoint(r1, r7);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void g() {
            c r0 = this.a;
            String r1 = r0.e;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.a == false) goto L7;
            long r5 = System.currentTimeMillis();
            Lazy r2 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r3 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_TEMPLATE_PRELOAD_END", r5, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r1, r3);
            return;
        L7:
            long r6 = System.currentTimeMillis();
            Lazy r4 = tu4.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r7 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_TEMPLATE_PRELOAD_END", r6, false, 12);
            tu4.b.c().addNormalPoint(r1, r7);
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void j() {
            long r6 = System.currentTimeMillis();
            c r0 = this.a;
            String r8 = r0.e;
            if (r8 != null) goto L5;
        L8:
            c r1 = this.a;
            if (r1.a == true) goto L12;
            int r2 = com.bytedance.ee.bear.bitable.chameleon.a.a;
            com.bytedance.ee.bear.bitable.chameleon.a.c(r1.i, "BITABLE_NATIVE_LOAD_URL", r6);
            com.bytedance.ee.bear.bitable.chameleon.a.c(this.a.i, "BITABLE_NATIVE_CALL_JS_RENDER", r6);
            return;
        L12:
            return;
        L5:
            if (r0.a == false) goto L7;
            Lazy r3 = com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.a;
            Intrinsics.checkNotNullParameter(r8, "traceId");
            BitableStatisticEventModel$NormalPointModel r4 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "LINK_DOCX_START_RENDER", r6, false, 12);
            com.bytedance.ee.bear.bitable.statistic.business.openfile.main.b.b().addNormalPoint(r8, r4);
            goto L8
        L7:
            Lazy r5 = tu4.b.a;
            Intrinsics.checkNotNullParameter(r8, "traceId");
            BitableStatisticEventModel$NormalPointModel r7 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_START_RENDER", r6, false, 12);
            tu4.b.c().addNormalPoint(r8, r7);
            goto L8
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void m(Map<String, String> r9) {
            c r0 = this.a;
            String r1 = r0.e;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r0.a == true) goto L9;
            long r4 = System.currentTimeMillis();
            Lazy r2 = tu4.b.a;
            Intrinsics.checkNotNullParameter(r1, "traceId");
            BitableStatisticEventModel$NormalPointModel r3 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_FILE_OLD_RENDER_SUCCESS", r4, false, 12);
            r3.addExtras(r9);
            tu4.b.c().addNormalPoint(r1, r3);
            return;
        }

        @Override // com.bytedance.ee.bear.contract.m0
        public final void i(DocException r3, Map r4) {
            c r5 = this.a;
            String r0 = r5.e;
            if (r0 == null) goto L6;
            j.d(new d(r5, r0, r4), 200);
            return;
        }
    }

    static {
    }

    @Override // tu4.e
    public final boolean d() {
        return this.a;
    }

    @Override // tu4.e
    public final String e() {
        return this.e;
    }

    @Override // tu4.e
    public final x2 f() {
        return this.d;
    }

    public c(boolean r1) {
        this.a = r1;
        this.b = org.koin.java.a.d(m.class);
        this.c = org.koin.java.a.d(com.bytedance.ee.bear.contract.d.class);
    }

    public final void a(DocumentPluginHost r4) {
        this.f = null;
        this.h = null;
        b r1 = this.g;
        if (r1 == null) goto L10;
        if (r4 == null) goto L6;
        k r5 = r4.getWeb();
    L8:
        if ((r5 instanceof z4) == false) goto L10;
        ((z4) r5).m(r1);
        goto L10
    L6:
        r5 = null;
    L10:
        this.g = null;
        this.d = null;
        this.i = null;
    }

    public final void b(DocumentPluginHost r9) {
        this.i = r9;
        Long r0 = null;
        String r1 = null;
        if (r9 == null) goto L5;
        x2 r2 = r9.getDocumentLoader();
    L6:
        this.d = r2;
        if (r9 == null) goto L9;
        DocViewModel r3 = r9.a();
    L10:
        this.f = r3;
        if (r9 == null) goto L13;
        k r4 = r9.getWeb();
    L15:
        if ((r4 instanceof z4) == false) goto L17;
        b r5 = new b(this);
        this.g = r5;
        ((z4) r4).x(r5);
    L17:
        boolean r6 = true;
        if (this.a == false) goto L31;
        DocViewModel r10 = this.f;
        if (r10 == null) goto L22;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r1 = tu4.b.b(r10);
    L22:
        int r11 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        tt5.a.h("BitableStatistic", "ReportFileHandler " + ("existTraceId=" + r1 + " this=" + this));
        if (r1 != null) goto L25;
    L28:
        if (r6 == true) goto L30;
        this.e = r1;
    L30:
        this.h = a.a(BitableStatisticConstant$OpenFile$OpenType.Main);
        return;
    L25:
        if (r1.length() == 0) goto L28;
        r6 = false;
        goto L28
    L31:
        int r7 = com.bytedance.ee.bear.bitable.chameleon.a.a;
        com.bytedance.ee.bear.bitable.chameleon.b r8 = com.bytedance.ee.bear.bitable.chameleon.a.a(r9);
        if (r8 == null) goto L35;
        this.e = r8.getTraceId();
        this.h = r8.getProxy();
        return;
    L35:
        String r12 = ((m) this.b.getValue()).createNormalTrace(null);
        this.e = r12;
        DocViewModel r13 = this.f;
        if (r13 == null) goto L38;
        r13.setExtraData("OPEN_FILE_TRACE_ID", r12);
    L38:
        DocViewModel r14 = this.f;
        if (r14 == null) goto L41;
        BearUrl r16 = r14.getBearUrl();
    L43:
        if (fx4.a.b(r16) == false) goto L45;
        BitableStatisticConstant$OpenFile$OpenType r17 = BitableStatisticConstant$OpenFile$OpenType.ShareRecord;
    L54:
        f r18 = a.a(r17);
        this.h = r18;
        com.bytedance.ee.bear.bitable.statistic.j r19 = r18.a();
        if (r9 == null) goto L59;
        DocViewModel r20 = r9.a();
        if (r20 == null) goto L59;
        BearUrl r21 = r20.getOriginBearUrl();
    L61:
        if (fx4.a.g(r21) == true) goto L63;
    L65:
        ((m) this.b.getValue()).addNormalConsumer(r12, r19);
        String r22 = ((com.bytedance.ee.bear.contract.d) this.c.getValue()).e("start_open", "start_time");
        if (r22 == null) goto L68;
        r0 = StringsKt.toLongOrNull(r22);
    L68:
        tu4.b.j(r12, r0, r16, r17);
        return;
    L63:
        if ((r19 instanceof tu4.a) == false) goto L65;
        tu4.a r23 = (tu4.a) r19;
        r23.getClass();
        Intrinsics.checkNotNullParameter("module", "key");
        Intrinsics.checkNotNullParameter(FileInfoPuller.CALLER_WIKI, "value");
        r23.b.put("module", FileInfoPuller.CALLER_WIKI);
    L59:
        r21 = null;
        goto L61
    L45:
        DocViewModel r24 = this.f;
        if (r24 != null) goto L48;
    L50:
        r6 = false;
    L51:
        if (r6 == false) goto L53;
        r17 = BitableStatisticConstant$OpenFile$OpenType.FastAdd;
        goto L54
    L53:
        r17 = BitableStatisticConstant$OpenFile$OpenType.Main;
        goto L54
    L48:
        if (r24.isType(sbb.e.j) != true) goto L50;
    L41:
        r16 = null;
        goto L43
    L13:
        r4 = null;
        goto L15
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void c(BitableReportPlugin.ReportModel r7) {
        Intrinsics.checkNotNullParameter(r7, "model");
        int r0 = com.bytedance.ee.bear.bitable.statistic.common.e.a;
        StringBuilder r1 = new StringBuilder("handle ");
        if (this.a == false) goto L5;
        String r2 = "doc ";
    L6:
        r1.append(r2);
        r1.append(r7.getEvent());
        r1.append(' ');
        r1.append(r7.getExtra());
        tt5.a.h("BitableStatistic", "ReportFileHandler " + r1.toString());
        DocViewModel r3 = this.f;
        if (r3 == null) goto L11;
        BearUrl r4 = r3.getOriginBearUrl();
        if (r4 == null) goto L11;
        String r5 = r4.b;
    L13:
        if (Intrinsics.areEqual(r7.getToken(), r5) == true) goto L25;
        com.bytedance.ee.bear.bitable.statistic.common.e.c("ReportFileHandler", "token not match " + r7.getEvent() + ' ' + du5.b.g(r5) + ' ' + du5.b.g(r7.getToken()));
        String r6 = this.e;
        if (r6 == null) goto L25;
        int r8 = com.bytedance.ee.bear.bitable.statistic.common.d.a;
        m r9 = (m) this.b.getValue();
        Map r10 = MapsKt.mapOf(TuplesKt.to("event", r7.getEvent()));
        Intrinsics.checkNotNullParameter(r9, "statisticService");
        Intrinsics.checkNotNullParameter(r6, "traceId");
        Intrinsics.checkNotNullParameter("token_not_match", "reason");
        JSONObject r11 = new JSONObject();
        r11.put("reason", "token_not_match");
        if (r10 == null) goto L24;
        Iterator r12 = r10.entrySet().iterator();
    L20:
        if (r12.hasNext() == false) goto L24;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (r13.getValue() == null) goto L20;
        r11.put((String) r13.getKey(), r13.getValue());
    L24:
        Unit r14 = Unit.INSTANCE;
        r9.reportError(r6, "base_mobile_performance_warning_point", r11);
    L25:
        f r16 = this.h;
        if (r16 == null) goto L34;
        r16.b(this, r7);
        return;
    L34:
        return;
    L11:
        r5 = null;
        goto L13
    L5:
        r2 = "";
        goto L6
    }
}
