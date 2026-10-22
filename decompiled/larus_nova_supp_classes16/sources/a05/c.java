package a05;

import android.app.Application;
import android.app.KeyguardManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.debug.DebugUtils;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.RenderStage;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.util.deviceinfo.DeviceInfoDetector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.ttnet.TTNetInit;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.TTWebViewUtil;
import eu5.i;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import oxb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.document.render.node.f {
    public static final AtomicBoolean r = null;
    public static final AtomicBoolean s = null;
    public static long t;
    public static final String u = null;
    public static long v;
    public static long w;
    public static int x;
    public final ConnectionService a;
    public final com.bytedance.ee.bear.contract.d b;
    public final b0 c;
    public final com.bytedance.ee.bear.contract.f d;
    public final String e;
    public final com.bytedance.ee.bear.document.d f;
    public final boolean g;
    public String h;
    public long i;
    public long j;
    public long k;
    public String l;
    public String m;
    public long n;
    public String o;
    public int p;
    public int q;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    /* JADX INFO: renamed from: a05.c$c, reason: collision with other inner class name */
    public static final class C0000c {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class d {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RenderStage.values().length];
            r0[RenderStage.RENDERING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[RenderStage.RENDER_CACHE_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[RenderStage.RENDER_CACHE_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[RenderStage.PULL_DATA_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[RenderStage.PULL_DATA_END.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[RenderStage.RENDER_DOC_START.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[RenderStage.RENDER_DOC_END.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;

        public f(c r1, long r2, long r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            String r1 = this.a.b.e("start_open", "start_time");
            this.a.b.e("start_open", "click_timestamp");
            long r3 = 0;
            if (TextUtils.isEmpty(r1) == true) goto L22;
            long r5 = this.b;
            Intrinsics.checkNotNull(r1);
            long r6 = r5 - CastLongProtector.parseLong(r1);
            long r7 = vv4.g.a - CastLongProtector.parseLong(r1);
            if (r7 > 0) goto L7;
            r7 = 0;
        L7:
            long r9 = vv4.g.c;
            if (r9 > 0) goto L10;
            long r10 = 0;
            long r11 = 0;
            long r13 = 0;
        L11:
            vv4.g.c = 0;
            long r8 = this.c;
            AtomicBoolean r2 = c.r;
            long r17 = r8 - 0;
            r3 = this.b - r8;
            if (Intrinsics.areEqual(this.a.y(), sbb.e.n.getType()) == false) goto L20;
            long r12 = c.v - CastLongProtector.parseLong(r1);
            long r4 = 0;
            if (r12 > 0) goto L16;
            r12 = 0;
        L16:
            long r19 = c.w - c.v;
            long r21 = vv4.g.a - c.w;
            if (r21 <= 0) goto L21;
            long r26 = r12;
            long r14 = r6;
            long r16 = r17;
            long r27 = r19;
            long r29 = r21;
        L23:
            long r18 = r3;
            long r20 = this.a.w(this.b);
            String r110 = d25.d.j;
            if (TextUtils.isEmpty(r110) == true) goto L26;
            String r31 = r110;
            int r32 = 1;
        L27:
            JSONObject r111 = new JSONObject();
            r111.put("cost_time", r14);
            r111.put("cost_time_start_click", r20);
            r111.put("cost_time_webfragmentoncreate", r7);
            r111.put("cost_time_newpluginlist", r13);
            r111.put("cost_time_attchpluginlist", r10);
            r111.put("cost_time_onviewcreated", r11);
            r111.put("cost_time_loadurlstart", r16);
            r111.put("cost_time_create_ui", r18);
            long r22 = r26;
            r111.put("cost_time_containerfragmentoncreate", r22);
            long r23 = r27;
            r111.put("cost_time_loadcontentinfo", r23);
            long r24 = r29;
            r111.put("cost_time_loadcontentfragment", r24);
            r111.put("stage", "create_ui");
            r111.put("docs_result_key", "other");
            r111.put("docs_result_code", 0);
            r111.put("file_type", this.a.y());
            r111.put("sub_type", this.a.z());
            c r28 = this.a;
            if (Intrinsics.areEqual(r28.h, "") == false) goto L30;
            r28.h = du5.b.g(d25.d.d);
        L30:
            r111.put("file_id", r28.h);
            r111.put("version_type", this.a.e);
            r111.put("enable_x5", this.a.g);
            r111.put("scm_version", ow4.a.a);
            r111.put("doc_has_cache", this.a.p);
            r111.put("doc_from", this.a.x());
            AtomicBoolean r30 = c.r;
            r111.put("doc_sub_from", null);
            r111.put("open_doc_desc", null);
            this.a.getClass();
            r111.put("isCoverEnabled", DocOpenConfig.i ? 1 : 0);
            AtomicBoolean r33 = c.r;
            r111.put("is_first_open_docs", String.valueOf(r33.get()));
            r111.put("doc_has_info_cache", c.x);
            r111.put("is_version", r32);
            r111.put("edition_id", r31);
            String r34 = d25.d.d();
            if (r34 != null) goto L33;
            String r36 = "";
        L34:
            r111.put("doc_app_id", r36);
            tt5.a.h("DocReport", "***reportOpenDoc*** CreateUI create_ui: " + r111.get("cost_time") + "    cost_time_webfragmentoncreate: " + r7 + "    cost_time_newpluginlist: " + r13 + "    cost_time_attchpluginlist: " + r10 + "    cost_time_onviewcreated: " + r11 + "    cost_time_loadurlstart: " + r16 + "    cost_time_create_ui: " + r18 + "    cost_time_cotainerfragmentoncreate: " + r22 + "    cost_time_loadcontentinfo: " + r23 + "    cost_time_loadcontentfragment: " + r24 + "    isFirstOpenDocs: " + r33.get());
            com.bytedance.ee.bear.contract.d r0 = this.a.b;
            int r37 = C0000c.a;
            r0.a("dev_performance_stage", r111);
            return;
        L33:
            r36 = r34;
            goto L34
        L26:
            r31 = "none";
            r32 = 0;
        L21:
            r26 = r4;
            r27 = r26;
            r29 = r27;
            r14 = r6;
            r16 = r17;
            goto L23
        L20:
            r4 = 0;
            goto L21
        L10:
            long r112 = vv4.g.b;
            r13 = r112 - vv4.g.a;
            r10 = r9 - r112;
            AtomicBoolean r38 = c.r;
            r11 = 0 - vv4.g.c;
            goto L11
        L22:
            r14 = 0;
            r16 = 0;
            r7 = 0;
            r10 = 0;
            r11 = 0;
            r13 = 0;
            r26 = 0;
            r27 = 0;
            r29 = 0;
            goto L23
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ c a;

        public g(c r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a() {
            String r0 = "";
            c r1 = this.a;
            r1.getClass();
            String r5 = d25.d.j;     // Catch: Throwable -> L20
            if (TextUtils.isEmpty(r5) == true) goto L6;
            int r6 = 1;
        L7:
            JSONObject r7 = new JSONObject();     // Catch: Throwable -> L20
            r7.put("stage", "load_url_start");     // Catch: Throwable -> L20
            r7.put("docs_result_key", "other");     // Catch: Throwable -> L20
            r7.put("docs_result_code", 0);     // Catch: Throwable -> L20
            r7.put("version_type", r1.e);     // Catch: Throwable -> L20
            r7.put("file_type", r1.y());     // Catch: Throwable -> L20
            r7.put("sub_type", r1.z());     // Catch: Throwable -> L20
            r7.put("enable_x5", r1.g);     // Catch: Throwable -> L20
            r7.put("scm_version", ow4.a.a);     // Catch: Throwable -> L20
            r7.put("doc_has_cache", r1.p);     // Catch: Throwable -> L20
            r7.put("doc_from", r1.x());     // Catch: Throwable -> L20
            r7.put("doc_sub_from", null);     // Catch: Throwable -> L20
            r7.put("open_doc_desc", null);     // Catch: Throwable -> L20
            if (Intrinsics.areEqual(r1.h, "") == false) goto L10;
            r1.h = du5.b.g(d25.d.d);     // Catch: Throwable -> L20
        L10:
            r7.put("file_id", r1.h);     // Catch: Throwable -> L20
            r7.put("isCoverEnabled", DocOpenConfig.i ? 1 : 0);     // Catch: Throwable -> L20
            r7.put("is_first_open_docs", String.valueOf(c.r.get()));     // Catch: Throwable -> L20
            r7.put("doc_has_info_cache", c.x);     // Catch: Throwable -> L20
            r7.put("is_version", r6);     // Catch: Throwable -> L20
            r7.put("edition_id", r5);     // Catch: Throwable -> L20
            String r8 = d25.d.d();     // Catch: Throwable -> L20
            if (r8 == null) goto L14;
            r0 = r8;
        L14:
            r7.put("doc_app_id", r0);     // Catch: Throwable -> L20
            String r2 = r1.b.e("start_open", "start_time");     // Catch: Throwable -> L20
            if (r2 == null) goto L18;
            r7.put("cost_time", r1.n - CastLongProtector.parseLong(r2));     // Catch: Throwable -> L20
        L18:
            tt5.a.h("DocReport", "***reportOpenDoc*** LoadUrlStart: " + r7.get("cost_time"));     // Catch: Throwable -> L20
            com.bytedance.ee.bear.contract.d r3 = r1.b;     // Catch: Throwable -> L20
            int r4 = C0000c.a;     // Catch: Throwable -> L20
            r3.a("dev_performance_stage", r7);     // Catch: Throwable -> L20
            return;
        L6:
            r5 = "none";
            r6 = 0;
        L20:
            th = move-exception;
            tt5.a.f("DocReport", th, false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        r = new AtomicBoolean(true);
        s = new AtomicBoolean(true);
        Lazy r0 = TTWebViewUtil.a;
        TTWebViewUtil.a.b().p();
        u = "";
    }

    public final void B() {
        String r0 = this.b.e("wait_download_resource", "start_time");
        if (r0 != null) goto L5;
        long r1 = 0;
    L6:
        this.j = r1;
        this.b.c("wait_download_resource");
        return;
    L5:
        r1 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r0);
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void q() {
        String r0 = this.b.e("wait_preload", "start_time");
        if (r0 != null) goto L5;
        long r5 = 0;
    L6:
        this.i = r5;
        this.b.c("wait_preload");
        String r1 = this.b.e("wait_preload_html", "end_time");
        if (r0 == null) goto L11;
        if (r1 == null) goto L11;
        long r2 = CastLongProtector.parseLong(r1) - CastLongProtector.parseLong(r0);
    L12:
        this.k = r2;
        if (r2 >= 0) goto L15;
        this.k = 0;
    L15:
        this.b.c("wait_preload_html");
        return;
    L11:
        r2 = 0;
        goto L12
    L5:
        r5 = SystemClock.uptimeMillis() - CastLongProtector.parseLong(r0);
        goto L6
    }

    public final String x() {
        int r0 = a05.e.a;
        com.bytedance.ee.bear.document.d r1 = this.f;
        String r2 = this.o;
        if (r1 == null) goto L16;
        BearUrl r3 = r1.getOriginBearUrl();
        if (r3 == null) goto L17;
        String r4 = r3.h;
        if (r4 != null) goto L9;
        return r2;
    L9:
        if ((!StringsKt.isBlank(r4)) == true) goto L12;
        r4 = null;
    L12:
        if (r4 != null) goto L15;
        return r2;
    L15:
        return r4;
    L17:
        return r2;
    L16:
        return r2;
    }

    public final String y() {
        int r0 = a05.e.a;
        com.bytedance.ee.bear.document.d r1 = this.f;
        String r2 = d25.d.g;
        Intrinsics.checkNotNullParameter(r2, "legacyFileType");
        if (r1 == null) goto L16;
        BearUrl r3 = r1.getOriginBearUrl();
        if (r3 == null) goto L17;
        String r4 = r3.a;
        if (r4 != null) goto L9;
        return r2;
    L9:
        if ((!StringsKt.isBlank(r4)) == true) goto L12;
        r4 = null;
    L12:
        if (r4 != null) goto L15;
        return r2;
    L15:
        return r4;
    L17:
        return r2;
    L16:
        return r2;
    }

    public final String z() {
        int r0 = a05.e.a;
        com.bytedance.ee.bear.document.d r1 = this.f;
        String r2 = d25.d.h;
        Intrinsics.checkNotNullParameter(r2, "legacySubType");
        String r3 = null;
        if (r1 == null) goto L7;
        BearUrl r4 = r1.getOriginBearUrl();
        if (r4 == null) goto L7;
        String r5 = r4.a;
    L9:
        if (Intrinsics.areEqual(r5, FileInfoPuller.CALLER_WIKI) == false) goto L20;
        if (r1 == null) goto L21;
        String r6 = r1.getDocumentType();
        if (r6 != null) goto L14;
        return r2;
    L14:
        if ((!StringsKt.isBlank(r6)) == false) goto L16;
        r3 = r6;
    L16:
        if (r3 != null) goto L19;
        return r2;
    L19:
        return r3;
    L21:
        return r2;
    L20:
        return r2;
    L7:
        r5 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void e() {
        iu5.f.a(new f(this, System.currentTimeMillis(), this.n));
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final String getFrom() {
        String r0 = x();
        if (r0 != null) goto L6;
        return "tab_other";
    L6:
        return r0;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final long b() {
        return this.n;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final int h() {
        return this.p;
    }

    public static otb.e A(WebView r1) {
        if ((r1 instanceof ChameleonWebView) == false) goto L9;
        n r2 = ((ChameleonWebView) r1).getServiceManager();
        if (r2 == null) goto L9;
        oxb.f r3 = r2.a(oxb.f.class);
        if (r3 == null) goto L9;
        return r3.B();
    L9:
        return null;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void a(int r8) {
        tt5.a.h("DocReport", "reportLoginFail");
        String r2 = d25.d.j;     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r2) == true) goto L6;
        int r3 = 1;
    L7:
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L12
        r4.put("stage", "pull_data");     // Catch: Throwable -> L12
        r4.put("docs_result_key", "login_fail");     // Catch: Throwable -> L12
        r4.put("docs_result_code", r8);     // Catch: Throwable -> L12
        r4.put("file_type", y());     // Catch: Throwable -> L12
        r4.put("sub_type", z());     // Catch: Throwable -> L12
        r4.put("file_id", du5.b.g(d25.d.d));     // Catch: Throwable -> L12
        r4.put("version_type", this.e);     // Catch: Throwable -> L12
        r4.put("scm_version", ow4.a.a);     // Catch: Throwable -> L12
        r4.put("doc_has_cache", this.p);     // Catch: Throwable -> L12
        r4.put("doc_from", x());     // Catch: Throwable -> L12
        r4.put("doc_sub_from", null);     // Catch: Throwable -> L12
        r4.put("open_doc_desc", null);     // Catch: Throwable -> L12
        r4.put("is_first_open_docs", String.valueOf(r.get()));     // Catch: Throwable -> L12
        r4.put("doc_has_info_cache", x);     // Catch: Throwable -> L12
        r4.put("is_version", r3);     // Catch: Throwable -> L12
        r4.put("edition_id", r2);     // Catch: Throwable -> L12
        String r5 = d25.d.d();     // Catch: Throwable -> L12
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r4.put("doc_app_id", r5);     // Catch: Throwable -> L12
        com.bytedance.ee.bear.contract.d r9 = this.b;     // Catch: Throwable -> L12
        int r6 = C0000c.a;     // Catch: Throwable -> L12
        r9.a("dev_performance_stage", r4);     // Catch: Throwable -> L12
        return;
    L6:
        r2 = "none";
        r3 = 0;
    L12:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.m = r2;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void k(int r1) {
        this.q = r1;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void n(long r1) {
        this.n = r1;
        iu5.f.a(new g(this));
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void p(int r1) {
        this.p = r1;
    }

    public final void r(JSONObject r6) {
        if (Intrinsics.areEqual(r6.optString("isDocHtmlCache"), "true") == false) goto L5;
        r6.put("ssr_preload_from", this.m);
    L14:
        if (Intrinsics.areEqual(r6.optString("clientvar_from"), "CACHE") == false) goto L16;
        r6.put("clientvar_preload_from", this.l);
        return;
    L16:
        Map<String, Set<String>> r0 = d25.d.a;
        tt5.a.b("OfflineUtils", "getClientVarUnusedReason");
        if (TextUtils.equals(d25.d.o, "no_cache") == true) goto L19;
    L21:
        String r1 = d25.d.o;
        if (r1 == null) goto L26;
        r6.put("clientvar_unused_reason", r1);
        return;
    L26:
        return;
    L19:
        if (d25.d.m == false) goto L21;
        d25.d.o = "no_memory_cache";
        goto L21
    L5:
        Map<String, Set<String>> r2 = d25.d.a;
        tt5.a.b("OfflineUtils", "getSsrUnusedReason");
        if (TextUtils.equals(d25.d.n, "no_cache") == true) goto L8;
    L10:
        String r3 = d25.d.n;
        if (r3 == null) goto L14;
        r6.put("ssr_unused_reason", r3);
        goto L14
    L8:
        if (d25.d.l == false) goto L10;
        d25.d.n = "no_memory_cache";
        goto L10
    }

    public final void s(JSONObject r5) {
        r5.put("is_first_open_docs", String.valueOf(r.get()));     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r1 = this.c.getDeviceInfo();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r1.d) == false) goto L5;
        String r2 = DiagramData$RESULT.SUCCESS;
    L6:
        r5.put("cpu_core_numbers", r2);     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r3 = this.c.getDeviceInfo();     // Catch: Exception -> L25
        String r4 = "";
        if (TextUtils.isEmpty(r3.b) == false) goto L10;
        String r6 = "";
    L11:
        r5.put("cpu_name", r6);     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r7 = this.c.getDeviceInfo();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r7.c) == false) goto L14;
        String r8 = "";
    L15:
        r5.put("max_cpu_freq", r8);     // Catch: Exception -> L25
        DeviceInfoDetector.DeviceInfo r9 = this.c.getDeviceInfo();     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r9.e) == false) goto L18;
        String r10 = "";
    L19:
        r5.put("total_mem", r10);     // Catch: Exception -> L25
        r5.put("tt_web_so_version_code", u);     // Catch: Exception -> L25
        int r0 = d.a;     // Catch: Exception -> L25
        r5.put("network_quality_type", TTNetInit.getEffectiveConnectionType());     // Catch: Exception -> L25
        r5.put("file_id", du5.b.g(d25.d.d));     // Catch: Exception -> L25
        String r11 = d25.d.d();     // Catch: Exception -> L25
        if (r11 == null) goto L23;
        r4 = r11;
    L23:
        r5.put("doc_app_id", r4);     // Catch: Exception -> L25
        r5.put("is_emulator", String.valueOf(ku5.c.j()));     // Catch: Exception -> L25
        r5.put("render_process_memory", eu5.g.f(eu5.b.a));     // Catch: Exception -> L25
        return;
    L18:
        r10 = r9.e;     // Catch: Exception -> L25
        goto L19
    L14:
        r8 = r7.c;     // Catch: Exception -> L25
        goto L15
    L10:
        r6 = r3.b;     // Catch: Exception -> L25
        goto L11
    L5:
        r2 = r1.d;     // Catch: Exception -> L25
    L25:
        e = move-exception;
        tt5.a.m("DocReport", e);
    }

    public final void t(JSONObject r4) {
        int r0 = sbb.e.g(y());
        String r1 = z();
        com.bytedance.ee.bear.document.forecast.a.d(r0);
        if (r0 == 16) goto L5;
    L7:
        r4.put("interrupt_webview_preload", String.valueOf(false));
        r4.put("interrupt_template_preload", String.valueOf(DocOpenConfig.e().contains(y())));
        return;
    L5:
        if (Intrinsics.areEqual(r1, "unknown") == true) goto L7;
        com.bytedance.ee.bear.document.forecast.a.d(sbb.e.g(r1));
        goto L7
    }

    public final long w(long r6) {
        String r0 = this.b.e("start_open", "click_timestamp");
        if (TextUtils.isEmpty(r0) == true) goto L15;
        long r1 = CastLongProtector.parseLong(r0);     // Catch: Exception -> L9
        if (r1 > 0) goto L8;
        return -1;
    L8:
        return r6 - r1;
    L9:
        e = move-exception;
        tt5.a.e("DocReport", "parse click timestamp error", e, false);
        return -1;
    L15:
        return -1;
    }

    public static void u(JSONObject r2, boolean r3) {
        r2.put("is_forseti_fg_on", ForsetiHelper.p());
        r2.put("is_in_forseti", r3);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final int c(DocLoadingState r4, com.bytedance.ee.bear.document.render.node.g r5) {
        int r0 = b.a;
        if (r4 != DocLoadingState.INIT) goto L6;
        return 400;
    L6:
        if (r4 != DocLoadingState.WAITING_DOWNLOAD) goto L9;
        return VersionPayLoadData.OPERATION_UPDATE;
    L9:
        if (r4 != DocLoadingState.WAITING_PRELOAD) goto L12;
        return 100;
    L12:
        if (r4 != DocLoadingState.RENDERING) goto L46;
        boolean r6 = false;
        if (r5 != null) goto L16;
    L18:
        if (r6 == false) goto L30;
        RenderStage r7 = r5.b();
        switch(e.a[r7.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            default: goto L22;
        };
    L23:
        return 507;
    L24:
        return 506;
    L25:
        return 505;
    L26:
        return 504;
    L27:
        return 503;
    L28:
        return 502;
    L29:
        return 501;
    L22:
        throw new NoWhenBranchMatchedException();
    L30:
        if (r5 == null) goto L32;
        RenderStage r8 = r5.b();
    L33:
        if (r8 != null) goto L35;
        int r9 = -1;
    L36:
        switch(r9) {
            case -1: goto L46;
            case 0: goto L38;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            default: goto L38;
        };
    L39:
        return 607;
    L40:
        return 606;
    L41:
        return 605;
    L42:
        return 604;
    L43:
        return 603;
    L44:
        return 602;
    L45:
        return 601;
    L38:
        throw new NoWhenBranchMatchedException();
    L35:
        r9 = e.a[r8.ordinal()];
        goto L36
    L32:
        r8 = null;
        goto L33
    L16:
        if (r5.f() != true) goto L18;
        r6 = true;
    L46:
        return 999;
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void j(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        tt5.a.b("DocReport", "reportJsReady");
        JSONObject r1 = new JSONObject();
        r1.put("file_type", r4);     // Catch: Throwable -> L5
        r1.put("ordinal", -1);     // Catch: Throwable -> L5
        r1.put("stage", "js_ready");     // Catch: Throwable -> L5
        r1.put("render_process_memory", eu5.g.f(eu5.b.a));     // Catch: Throwable -> L5
    L7:
        v(r1, r5);
        return;
    L5:
        th = move-exception;
        tt5.a.j("DocReport", th);
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void l(long r6, long r8) {
        tt5.a.b("DocReport", "reportHtmlReady");
        JSONObject r2 = new JSONObject();
        r2.put("stage", "html_ready");     // Catch: Throwable -> L9
        String r3 = this.b.e("load_template_gap", "start_time");     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        long r9 = r8 - CastLongProtector.parseLong(r3);     // Catch: Throwable -> L9
    L7:
        r2.put("load_template_gap_time", r9);     // Catch: Throwable -> L9
        r2.put("render_process_memory", eu5.g.f(eu5.b.a));     // Catch: Throwable -> L9
    L11:
        v(r2, r6);
        this.b.c("load_template_gap");
        return;
    L6:
        r9 = -1;
    L9:
        th = move-exception;
        tt5.a.j("DocReport", th);
        goto L11
    }

    public final void v(JSONObject r11, long r12) {
        Intrinsics.checkNotNullParameter(r11, "map");
        if (r12 > 0) goto L16;
        return;
    L16:
        long r6 = SystemClock.uptimeMillis();     // Catch: Throwable -> L13
        long r13 = r6 - r12;     // Catch: Throwable -> L13
        tt5.a.b("DocReport", "reportJsReady duration = " + r13);     // Catch: Throwable -> L13
        r11.put("cost_time", r13);     // Catch: Throwable -> L13
        if (s.compareAndSet(true, false) == false) goto L8;
        long r7 = r6 - this.c.d();     // Catch: Throwable -> L13
        long r14 = this.c.d() - this.c.a();     // Catch: Throwable -> L13
        long r2 = Math.max(0 - this.c.a(), 0);     // Catch: Throwable -> L13
        r11.put("doc_init_trace", this.c.i());     // Catch: Throwable -> L13
        r11.put("time_to_fill_pool", r2);     // Catch: Throwable -> L13
        r11.put("cost_time_preload_finish_to_doc_init", r7);     // Catch: Throwable -> L13
        r11.put("cost_time_p0_launch_to_open_doc", r7);     // Catch: Throwable -> L13
        r11.put("cost_time_app_launch_to_doc_init", r14);     // Catch: Throwable -> L13
        r11.put("cost_time_app_launch_to_open_doc", r7 + r14);     // Catch: Throwable -> L13
        this.c.u();     // Catch: Throwable -> L13
    L8:
        Object r3 = null;
        r11.put("app_visible", String.valueOf(((com.bytedance.ee.bear.contract.f) org.koin.java.a.c(com.bytedance.ee.bear.contract.f.class, null, null, 6)).a()));     // Catch: Throwable -> L13
        Application r16 = eu5.b.a;     // Catch: Throwable -> L13
        if (r16 == null) goto L11;
        r3 = r16.getSystemService("keyguard");     // Catch: Throwable -> L13
    L11:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.KeyguardManager");     // Catch: Throwable -> L13
        r11.put("screen_status", String.valueOf(((KeyguardManager) r3).inKeyguardRestrictedInputMode()));     // Catch: Throwable -> L13
        r11.put("version_type", this.e);     // Catch: Throwable -> L13
        r11.put("enable_x5", this.g);     // Catch: Throwable -> L13
        r11.put("scm_version", ow4.a.a);     // Catch: Throwable -> L13
        com.bytedance.ee.bear.contract.d r17 = this.b;     // Catch: Throwable -> L13
        int r18 = C0000c.a;     // Catch: Throwable -> L13
        r17.a("dev_performance_doc_template_preload", r11);     // Catch: Throwable -> L13
        tt5.a.h("DocReport", "reportJsReady reportLoadFinish: " + r11);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public /* synthetic */ c(j r8, com.bytedance.ee.bear.contract.d r9, b0 r10, com.bytedance.ee.bear.contract.f r11, String r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void o(Map<String, ? extends Object> r20, boolean r21, int r22, String r23, boolean r24) {
        long r7 = SystemClock.uptimeMillis();     // Catch: Throwable -> L76
        if (r20 == null) goto L6;
        JSONObject r9 = new JSONObject(r20);     // Catch: Throwable -> L76
    L7:
        r9.put("docs_result_key", "other");     // Catch: Throwable -> L76
        r9.put("docs_result_code", 0);     // Catch: Throwable -> L76
        r9.put("file_type", y());     // Catch: Throwable -> L76
        r9.put("sub_type", z());     // Catch: Throwable -> L76
        if (r21 == false) goto L10;
        Object r11 = "preload";
    L11:
        r9.put("docs_open_type", r11);     // Catch: Throwable -> L76
        r9.put("wait_preload_template_time", this.i);     // Catch: Throwable -> L76
        r9.put("wait_resource_time", this.j);     // Catch: Throwable -> L76
        r9.put("version_type", this.e);     // Catch: Throwable -> L76
        r9.put("enable_x5", this.g);     // Catch: Throwable -> L76
        r9.put("scm_version", ow4.a.a);     // Catch: Throwable -> L76
        r9.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L76
        r9.put("doc_has_cache", this.p);     // Catch: Throwable -> L76
        r9.put("doc_from", x());     // Catch: Throwable -> L76
        r9.put("doc_sub_from", null);     // Catch: Throwable -> L76
        r9.put("open_doc_desc", null);     // Catch: Throwable -> L76
        r9.put("preload_html_enabled", 1);     // Catch: Throwable -> L76
        r9.put("app_visible", String.valueOf(this.d.a()));     // Catch: Throwable -> L76
        r9.put("isLarkWebview", false);     // Catch: Throwable -> L76
        r9.put("doc_has_info_cache", x);     // Catch: Throwable -> L76
        r9.put("is_version", r22);     // Catch: Throwable -> L76
        r9.put("edition_id", r23);     // Catch: Throwable -> L76
        r9.put("is_blank_webview", false);     // Catch: Throwable -> L76
        r(r9);     // Catch: Throwable -> L76
        s(r9);     // Catch: Throwable -> L76
        u(r9, r24);     // Catch: Throwable -> L76
        String r10 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L76
        if (r10 == null) goto L43;
        if (r20 == null) goto L16;
        Object r0 = r20.get("timestamp");     // Catch: Throwable -> L76
    L17:
        String r1 = (String) r0;     // Catch: Throwable -> L76
        if (r1 == null) goto L20;
        long r16 = CastLongProtector.parseLong(r1);     // Catch: Throwable -> L76
    L21:
        long r6 = r16;
        long r12 = r6 - CastLongProtector.parseLong(r10);     // Catch: Throwable -> L76
        r9.put("cost_time", r12);     // Catch: Throwable -> L76
        long r8 = w(r6);     // Catch: Throwable -> L76
        r9.put("cost_time_start_click", r8);     // Catch: Throwable -> L76
        Object r2 = this.b.f("render_cache", "start_time");     // Catch: Throwable -> L76
        if (r2 != null) goto L24;
        Object r13 = Long.valueOf(r12);     // Catch: Throwable -> L76
    L25:
        r9.put("time_to_visit", r13);     // Catch: Throwable -> L76
        Object r14 = this.b.f("render_cache", "value_render_cache_cost_time_click");     // Catch: Throwable -> L76
        if ((r14 instanceof Number) == false) goto L29;
        Long r17 = Long.valueOf(((Number) r14).longValue());     // Catch: Throwable -> L76
    L32:
        if (r17 == null) goto L34;
        r8 = r17.longValue();     // Catch: Throwable -> L76
    L34:
        r9.put("time_to_visit_click", r8);     // Catch: Throwable -> L76
        if (idb.f.a().isCurrentEnable("ccm.docx.open_docs_record_optimize") == false) goto L39;
        if (r2 == null) goto L39;
        r9.put("isDocHtmlCache", true);     // Catch: Throwable -> L76
    L39:
        if (r.compareAndSet(true, false) == false) goto L41;
        long r18 = r7 - this.c.d();     // Catch: Throwable -> L76
        long r19 = this.c.d() - this.c.a();     // Catch: Throwable -> L76
        r9.put("cost_time_p0_launch_to_open_doc", r18);     // Catch: Throwable -> L76
        r9.put("cost_time_app_launch_to_doc_init", r19);     // Catch: Throwable -> L76
        r9.put("cost_time_app_launch_to_open_doc", r18 + r19);     // Catch: Throwable -> L76
    L41:
        t = CastLongProtector.parseLong(r10);     // Catch: Throwable -> L76
        goto L43
    L29:
        if ((r14 instanceof String) == false) goto L31;
        r17 = StringsKt.toLongOrNull((String) r14);     // Catch: Throwable -> L76
        goto L32
    L31:
        r17 = null;
        goto L32
    L24:
        r13 = r2;
        goto L25
    L20:
        r16 = System.currentTimeMillis();     // Catch: Throwable -> L76
        goto L21
    L16:
        r0 = null;
    L43:
        Object r3 = this.b.e("render_cache", "render_cache_from");     // Catch: Throwable -> L76
        if (r3 == null) goto L46;
        r9.put("doc_html_cache_from", r3);     // Catch: Throwable -> L76
    L46:
        String r4 = this.b.e("render_cache", "value_render_cache_ssrwebview_wait_preload_time");     // Catch: Throwable -> L76
        if (r4 != null) goto L49;
    L52:
        boolean r26 = true;
    L53:
        if (r26 == false) goto L55;
        r4 = DiagramData$RESULT.FAIL;
    L55:
        r9.put("wait_ssrwebview_preload_time", r4);     // Catch: Throwable -> L76
        String r5 = this.b.e("render_cache", "value_render_cache_ssrwebview_is_ready");     // Catch: Throwable -> L76
        if (r5 != null) goto L58;
    L61:
        boolean r27 = true;
    L62:
        if (r27 == false) goto L64;
        r5 = "true";
    L64:
        r9.put("ssrwebview_is_ready", r5);     // Catch: Throwable -> L76
        Object r28 = this.b.e("render_cache", "value_render_cache_prompt_count");     // Catch: Throwable -> L76
        if (r28 == null) goto L67;
        r9.put("prompt_count", r28);     // Catch: Throwable -> L76
    L67:
        Object r29 = this.b.e("render_cache", "render_cache_over_limit");     // Catch: Throwable -> L76
        if (r29 == null) goto L70;
        r9.put("prompt_get_html_over_limit", r29);     // Catch: Throwable -> L76
    L70:
        r9.put("wait_preload_html_time", this.k);     // Catch: Throwable -> L76
        if (DocOpenConfig.m == false) goto L73;
        int r110 = 1;
    L74:
        r9.put("load_ssr_after_preload_html", r110);     // Catch: Throwable -> L76
        t(r9);     // Catch: Throwable -> L76
        this.b.c("start_open");     // Catch: Throwable -> L76
        this.b.c("render_cache");     // Catch: Throwable -> L76
        com.bytedance.ee.bear.contract.d r30 = this.b;     // Catch: Throwable -> L76
        int r31 = C0000c.a;     // Catch: Throwable -> L76
        r30.a("dev_performance_doc_open_finish", r9);     // Catch: Throwable -> L76
        tt5.a.h("DocReport", "***reportOpenDoc*** Success  costtime: " + r9.opt("cost_time") + "    map:  " + r9);     // Catch: Throwable -> L76
        return;
    L73:
        r110 = 0;
        goto L74
    L58:
        if (r5.length() == 0) goto L61;
        r27 = false;
        goto L62
    L49:
        if (r4.length() == 0) goto L52;
        r26 = false;
        goto L53
    L10:
        r11 = "render";
        goto L11
    L6:
        r9 = new JSONObject();     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    public c(j r2, com.bytedance.ee.bear.contract.d r3, b0 r4, com.bytedance.ee.bear.contract.f r5, String r6, com.bytedance.ee.bear.document.d r7) {
        Intrinsics.checkNotNullParameter(r2, "mConnectionService");
        Intrinsics.checkNotNullParameter(r3, "mAnalyticService");
        Intrinsics.checkNotNullParameter(r4, "infoService");
        Intrinsics.checkNotNullParameter(r5, "appVisibleService");
        Intrinsics.checkNotNullParameter(r6, "versionType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        Lazy r8 = TTWebViewUtil.a;
        TTWebViewUtil.a.d(null);
        this.g = false;
        this.h = "";
        this.l = "unknown";
        this.m = "unknown";
        this.o = "tab_other";
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void g(Map<String, ? extends Object> r9, boolean r10, WebView r11, int r12, String r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "webview");
    L42:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
        return;
    L4:
        if (i.b() == false) goto L6;
    L46:
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  isWifiProxy");     // Catch: Throwable -> L42
        return;
    L6:
        if (i.a() == true) goto L46;
        ml5.b r4 = DebugUtils.a();     // Catch: Throwable -> L42
        Boolean r6 = Boolean.TRUE;     // Catch: Throwable -> L42
        if (((Boolean) r4.a("renderAccelerate", r6)).booleanValue() == true) goto L11;
    L44:
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  Render not Open");     // Catch: Throwable -> L42
        return;
    L11:
        if (((Boolean) DebugUtils.a().a("resourceIntercept", r6)).booleanValue() == false) goto L44;
        if (TextUtils.isEmpty(d25.d.d) == false) goto L18;
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed  no token");     // Catch: Throwable -> L42
        return;
    L18:
        if (this.c.getPackageName() != null) goto L20;
    L23:
        otb.e r16 = A(r11);     // Catch: Throwable -> L42
        JSONObject r5 = new JSONObject(r9);     // Catch: Throwable -> L42
        r5.put("file_type", y());     // Catch: Throwable -> L42
        r5.put("sub_type", z());     // Catch: Throwable -> L42
        if (r10 == false) goto L26;
        String r17 = "preload";
    L27:
        r5.put("docs_open_type", r17);     // Catch: Throwable -> L42
        r5.put("wait_preload_template_time", this.i);     // Catch: Throwable -> L42
        r5.put("wait_resource_time", this.j);     // Catch: Throwable -> L42
        r5.put("version_type", this.e);     // Catch: Throwable -> L42
        r5.put("enable_x5", this.g);     // Catch: Throwable -> L42
        r5.put("scm_version", ow4.a.a);     // Catch: Throwable -> L42
        r5.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L42
        r5.put("doc_has_cache", this.p);     // Catch: Throwable -> L42
        r5.put("doc_from", x());     // Catch: Throwable -> L42
        r5.put("doc_sub_from", null);     // Catch: Throwable -> L42
        r5.put("open_doc_desc", null);     // Catch: Throwable -> L42
        r5.put("preload_html_enabled", 1);     // Catch: Throwable -> L42
        if (r16 == null) goto L30;
        r16.getLoadingStatusCode();     // Catch: Throwable -> L42
        Long r7 = 0L;     // Catch: Throwable -> L42
    L31:
        r5.put("doc_webview_status_code", r7);     // Catch: Throwable -> L42
        r5.put("app_visible", String.valueOf(this.d.a()));     // Catch: Throwable -> L42
        r5.put("isLarkWebview", false);     // Catch: Throwable -> L42
        r5.put("doc_has_info_cache", x);     // Catch: Throwable -> L42
        r5.put("is_version", r12);     // Catch: Throwable -> L42
        r5.put("edition_id", r13);     // Catch: Throwable -> L42
        r5.put("is_blank_webview", false);     // Catch: Throwable -> L42
        t(r5);     // Catch: Throwable -> L42
        r(r5);     // Catch: Throwable -> L42
        s(r5);     // Catch: Throwable -> L42
        u(r5, r14);     // Catch: Throwable -> L42
        String r18 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L42
        if (r18 == null) goto L38;
        String r19 = (String) r9.get("timestamp");     // Catch: Throwable -> L42
        if (r19 == null) goto L37;
        r5.put("cost_time", CastLongProtector.parseLong(r19) - CastLongProtector.parseLong(r18));     // Catch: Throwable -> L42
        goto L38
    L37:
        r5.put("cost_time", System.currentTimeMillis() - CastLongProtector.parseLong(r18));     // Catch: Throwable -> L42
    L38:
        this.b.c("start_open");     // Catch: Throwable -> L42
        this.b.c("render_cache");     // Catch: Throwable -> L42
        com.bytedance.ee.bear.contract.d r20 = this.b;     // Catch: Throwable -> L42
        int r110 = C0000c.a;     // Catch: Throwable -> L42
        r20.a("dev_performance_doc_open_finish", r5);     // Catch: Throwable -> L42
        StringBuilder r21 = new StringBuilder("***reportOpenDoc*** Failed : ");     // Catch: Throwable -> L42
        r21.append(r5);     // Catch: Throwable -> L42
        r21.append("    performanceTiming:  ");     // Catch: Throwable -> L42
        if (r16 == null) goto L41;
        r16.getPerformanceTiming();     // Catch: Throwable -> L42
    L41:
        r21.append(null);     // Catch: Throwable -> L42
        tt5.a.d("DocReport", r21.toString());     // Catch: Throwable -> L42
        return;
    L30:
        r7 = null;
        goto L31
    L26:
        r17 = "render";
        goto L27
    L20:
        if (StringsKt.contains$default(this.c.getPackageName(), "debug", false, 2, null) == false) goto L23;
        tt5.a.k("DocReport", "***reportOpenDoc*** Failed Filter the internal test package of the debug package name");     // Catch: Throwable -> L42
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void i(int r8, boolean r9, int r10, String r11, WebView r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "webview");
        otb.e r14 = A(r12);     // Catch: Throwable -> L21
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L21
        r4.put("docs_result_key", "cancel");     // Catch: Throwable -> L21
        r4.put("docs_result_code", r8);     // Catch: Throwable -> L21
        r4.put("file_type", y());     // Catch: Throwable -> L21
        r4.put("sub_type", z());     // Catch: Throwable -> L21
        if (r9 == false) goto L6;
        String r16 = "preload";
    L7:
        r4.put("docs_open_type", r16);     // Catch: Throwable -> L21
        int r17 = b.a;     // Catch: Throwable -> L21
        if (r8 != 100) goto L11;
        q();     // Catch: Throwable -> L21
    L13:
        r4.put("wait_preload_template_time", this.i);     // Catch: Throwable -> L21
        r4.put("wait_resource_time", this.j);     // Catch: Throwable -> L21
        r4.put("version_type", this.e);     // Catch: Throwable -> L21
        r4.put("enable_x5", this.g);     // Catch: Throwable -> L21
        r4.put("scm_version", ow4.a.a);     // Catch: Throwable -> L21
        r4.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L21
        r4.put("doc_has_cache", this.p);     // Catch: Throwable -> L21
        r4.put("doc_from", x());     // Catch: Throwable -> L21
        Long r18 = null;
        r4.put("doc_sub_from", null);     // Catch: Throwable -> L21
        r4.put("open_doc_desc", null);     // Catch: Throwable -> L21
        r4.put("preload_html_enabled", 1);     // Catch: Throwable -> L21
        r4.put("file_length", this.q);     // Catch: Throwable -> L21
        if (r14 == null) goto L16;
        r14.getLoadingStatusCode();     // Catch: Throwable -> L21
        r18 = 0L;     // Catch: Throwable -> L21
    L16:
        r4.put("doc_webview_status_code", r18);     // Catch: Throwable -> L21
        r4.put("app_visible", String.valueOf(this.d.a()));     // Catch: Throwable -> L21
        r4.put("isLarkWebview", false);     // Catch: Throwable -> L21
        r4.put("doc_has_info_cache", x);     // Catch: Throwable -> L21
        r4.put("is_version", r10);     // Catch: Throwable -> L21
        r4.put("edition_id", r11);     // Catch: Throwable -> L21
        r4.put("is_blank_webview", false);     // Catch: Throwable -> L21
        r4.put("cost_time_start_click", w(System.currentTimeMillis()));     // Catch: Throwable -> L21
        t(r4);     // Catch: Throwable -> L21
        s(r4);     // Catch: Throwable -> L21
        u(r4, r13);     // Catch: Throwable -> L21
        String r19 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L21
        if (r19 == null) goto L19;
        r4.put("cost_time", ((System.currentTimeMillis() - CastLongProtector.parseLong(r19)) - this.j) - this.i);     // Catch: Throwable -> L21
    L19:
        this.b.c("start_open");     // Catch: Throwable -> L21
        this.b.c("render_cache");     // Catch: Throwable -> L21
        com.bytedance.ee.bear.contract.d r20 = this.b;     // Catch: Throwable -> L21
        int r21 = C0000c.a;     // Catch: Throwable -> L21
        r20.a("dev_performance_doc_open_finish", r4);     // Catch: Throwable -> L21
        tt5.a.d("DocReport", "***reportOpenDoc*** CancelDoc : " + r4 + "    performanceTiming:  ");     // Catch: Throwable -> L21
        return;
    L11:
        if (r8 != 101) goto L13;
        B();     // Catch: Throwable -> L21
        goto L13
    L6:
        r16 = "render";
    L21:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
    }

    @Override // com.bytedance.ee.bear.document.render.node.f
    public final void m(int r18, boolean r19, WebView r20, int r21, String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r20, "webview");
    L50:
        th = move-exception;
        tt5.a.f("DocReport", th, false);
        return;
    L4:
        if (i.b() == false) goto L6;
    L54:
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  isWifiProxy");     // Catch: Throwable -> L50
        return;
    L6:
        if (i.a() == true) goto L54;
        ml5.b r7 = DebugUtils.a();     // Catch: Throwable -> L50
        Boolean r9 = Boolean.TRUE;     // Catch: Throwable -> L50
        if (((Boolean) r7.a("renderAccelerate", r9)).booleanValue() == true) goto L11;
    L52:
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  Render not Open");     // Catch: Throwable -> L50
        return;
    L11:
        if (((Boolean) DebugUtils.a().a("resourceIntercept", r9)).booleanValue() == false) goto L52;
        if (TextUtils.isEmpty(d25.d.d) == false) goto L18;
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime  no token");     // Catch: Throwable -> L50
        return;
    L18:
        if (this.c.getPackageName() != null) goto L20;
    L23:
        otb.e r8 = A(r20);     // Catch: Throwable -> L50
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L50
        r10.put("docs_result_key", "overtime");     // Catch: Throwable -> L50
        r10.put("docs_result_code", r18);     // Catch: Throwable -> L50
        r10.put("file_type", y());     // Catch: Throwable -> L50
        r10.put("sub_type", z());     // Catch: Throwable -> L50
        if (r19 == false) goto L26;
        String r11 = "preload";
    L27:
        r10.put("docs_open_type", r11);     // Catch: Throwable -> L50
        int r12 = b.a;     // Catch: Throwable -> L50
        if (r18 != 100) goto L31;
        q();     // Catch: Throwable -> L50
    L33:
        r10.put("wait_preload_template_time", this.i);     // Catch: Throwable -> L50
        r10.put("wait_resource_time", this.j);     // Catch: Throwable -> L50
        r10.put("version_type", this.e);     // Catch: Throwable -> L50
        r10.put("enable_x5", this.g);     // Catch: Throwable -> L50
        r10.put("scm_version", ow4.a.a);     // Catch: Throwable -> L50
        r10.put("file_id", du5.b.g(d25.d.d));     // Catch: Throwable -> L50
        r10.put("doc_network_status", fw4.d.a().ordinal());     // Catch: Throwable -> L50
        r10.put("doc_has_cache", this.p);     // Catch: Throwable -> L50
        r10.put("doc_from", x());     // Catch: Throwable -> L50
        r10.put("doc_sub_from", null);     // Catch: Throwable -> L50
        r10.put("open_doc_desc", null);     // Catch: Throwable -> L50
        boolean r13 = true;
        r10.put("preload_html_enabled", 1);     // Catch: Throwable -> L50
        if (r8 == null) goto L36;
        r8.getLoadingStatusCode();     // Catch: Throwable -> L50
        Long r14 = 0L;     // Catch: Throwable -> L50
    L37:
        r10.put("doc_webview_status_code", r14);     // Catch: Throwable -> L50
        int r0 = r20.getVisibility();     // Catch: Throwable -> L50
        int r6 = r20.getWindowVisibility();     // Catch: Throwable -> L50
        boolean r16 = this.d.a();     // Catch: Throwable -> L50
        if (r0 != 0) goto L42;
        if (r6 != 0) goto L42;
        if (r16 == false) goto L42;
    L43:
        r10.put("app_visible", r13);     // Catch: Throwable -> L50
        r10.put("isLarkWebview", false);     // Catch: Throwable -> L50
        r10.put("doc_has_info_cache", x);     // Catch: Throwable -> L50
        r10.put("is_version", r21);     // Catch: Throwable -> L50
        r10.put("edition_id", r22);     // Catch: Throwable -> L50
        r10.put("is_blank_webview", false);     // Catch: Throwable -> L50
        t(r10);     // Catch: Throwable -> L50
        s(r10);     // Catch: Throwable -> L50
        u(r10, r23);     // Catch: Throwable -> L50
        String r17 = this.b.e("start_open", "start_time");     // Catch: Throwable -> L50
        if (r17 == null) goto L46;
        r10.put("cost_time", System.currentTimeMillis() - CastLongProtector.parseLong(r17));     // Catch: Throwable -> L50
    L46:
        this.b.c("start_open");     // Catch: Throwable -> L50
        this.b.c("render_cache");     // Catch: Throwable -> L50
        com.bytedance.ee.bear.contract.d r2 = this.b;     // Catch: Throwable -> L50
        int r110 = C0000c.a;     // Catch: Throwable -> L50
        r2.a("dev_performance_doc_open_finish", r10);     // Catch: Throwable -> L50
        StringBuilder r3 = new StringBuilder("***reportOpenDoc*** Overtime : ");     // Catch: Throwable -> L50
        r3.append(r10);     // Catch: Throwable -> L50
        r3.append("    performanceTiming:  ");     // Catch: Throwable -> L50
        if (r8 == null) goto L49;
        r8.getPerformanceTiming();     // Catch: Throwable -> L50
    L49:
        r3.append(null);     // Catch: Throwable -> L50
        r3.append("    visibility:  ");     // Catch: Throwable -> L50
        r3.append(r0);     // Catch: Throwable -> L50
        r3.append("    windowVisibility:  ");     // Catch: Throwable -> L50
        r3.append(r6);     // Catch: Throwable -> L50
        r3.append("    appIsVisible:  ");     // Catch: Throwable -> L50
        r3.append(r16);     // Catch: Throwable -> L50
        tt5.a.d("DocReport", r3.toString());     // Catch: Throwable -> L50
        return;
    L42:
        r13 = false;
        goto L43
    L36:
        r14 = null;
        goto L37
    L31:
        if (r18 != 101) goto L33;
        B();     // Catch: Throwable -> L50
        goto L33
    L26:
        r11 = "render";
        goto L27
    L20:
        if (StringsKt.contains$default(this.c.getPackageName(), "debug", false, 2, null) == false) goto L23;
        tt5.a.k("DocReport", "***reportOpenDoc*** Overtime Filter the internal test package of the debug package name");     // Catch: Throwable -> L50
    }
}
