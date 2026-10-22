package com.bytedance.ee.bear.document.offline.sync;

import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.offline.DocWikiInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockType;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.EmbedDocList;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.PreloadSubblock;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.ResDetail;
import com.bytedance.ee.bear.document.offline.sync.preloadtask.ResDetaildata;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocxPreloadStrategyV2 extends CommonRNPreloadStrategy {
    public static final /* synthetic */ int C = 0;
    public final boolean A;
    public final Map<String, CopyOnWriteArrayList<String>> B;
    public z05.d w;
    public final String x;
    public boolean y;
    public String z;

    public final class a implements tb5.i<PreloadSubblock> {
        public final /* synthetic */ DocxPreloadStrategyV2 a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(DocxPreloadStrategyV2 r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            PreloadSubblock r5 = (PreloadSubblock) r3;
            if (r5 == null) goto L6;
            DocxPreloadStrategyV2 r0 = this.a;
            int r1 = DocxPreloadStrategyV2.C;
            r0.C(r5, r4);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ List<SubBlockModel> b;
        public final /* synthetic */ List<ResDetaildata> c;
        public final /* synthetic */ List<ResDetaildata> d;
        public final /* synthetic */ String e;
        public final /* synthetic */ DocxPreloadStrategyV2 f;
        public final /* synthetic */ String g;

        public b(boolean r1, List<SubBlockModel> r2, List<ResDetaildata> r3, List<ResDetaildata> r4, String r5, DocxPreloadStrategyV2 r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void accept(Object r8) {
            String r9 = (String) r8;
            if (this.a == true) goto L5;
            String r10 = this.e;
            if (r10 == null) goto L55;
            DocxPreloadStrategyV2 r1 = this.f;
            List<SubBlockModel> r2 = this.b;
            String r3 = this.g;
            List<ResDetaildata> r4 = this.c;
            List<ResDetaildata> r5 = this.d;
            r1.D(true, r2, r10, r3);
            DocxPreloadStrategyV2.z(r1, r4, r10, r3);
            DocxPreloadStrategyV2.z(r1, r5, r10, r3);
            return;
        L55:
            return;
        L5:
            if (this.b.size() <= h0.l.getDocxImageBlockPreloadNumber()) goto L7;
            ArrayList r11 = new ArrayList(this.b.subList(0, h0.l.getDocxImageBlockPreloadNumber()));
        L8:
            ArrayList r6 = new ArrayList();
            Iterator<T> r7 = this.c.iterator();
        L10:
            if (r7.hasNext() == false) goto L18;
            ResDetaildata r12 = (ResDetaildata) r7.next();
            if (r6.size() >= h0.l.getDocxVideoBlockPreloadNumber()) goto L10;
            Long r13 = r12.getSize();
            if (r13 == null) goto L10;
            if (((int) r13.longValue()) >= h0.l.getDocxVideoblockPreloadSize()) goto L10;
            r6.add(r12);
            goto L10
        L18:
            ArrayList r14 = new ArrayList();
            Iterator<T> r16 = this.d.iterator();
        L20:
            if (r16.hasNext() == false) goto L28;
            ResDetaildata r17 = (ResDetaildata) r16.next();
            if (r14.size() >= h0.l.getDocxOfficeBlockPreloadNumber()) goto L20;
            Long r18 = r17.getSize();
            if (r18 == null) goto L20;
            if (((int) r18.longValue()) >= h0.l.getDocxOfficeblockPreloadSize()) goto L20;
            r14.add(r17);
            goto L20
        L28:
            String r19 = this.e;
            if (r19 == null) goto L53;
            DocxPreloadStrategyV2 r20 = this.f;
            String r21 = this.g;
            r20.D(true, r11, r19, r21);
            DocxPreloadStrategyV2.z(r20, r6, r19, r21);
            DocxPreloadStrategyV2.z(r20, r14, r19, r21);
            return;
        L53:
            return;
        L7:
            r11 = new ArrayList(this.b);
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DocxPreloadStrategyV2 a;

        public c(DocxPreloadStrategyV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = this.a.a;
            tt5.a.e(r0, "doPreload failed", (Throwable) r4, false);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ DocxPreloadStrategyV2 a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ List<SubBlockModel> c;
        public final /* synthetic */ List<ResDetaildata> d;
        public final /* synthetic */ List<ResDetaildata> e;
        public final /* synthetic */ PreloadSubblock f;
        public final /* synthetic */ Ref.ObjectRef<String> g;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ DocxPreloadStrategyV2 a;
            public final /* synthetic */ List<SubBlockModel> b;
            public final /* synthetic */ List<ResDetaildata> c;
            public final /* synthetic */ List<ResDetaildata> d;
            public final /* synthetic */ PreloadSubblock e;
            public final /* synthetic */ Ref.ObjectRef<String> f;

            public a(DocxPreloadStrategyV2 r1, List<SubBlockModel> r2, List<ResDetaildata> r3, List<ResDetaildata> r4, PreloadSubblock r5, Ref.ObjectRef<String> r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r8, int r9) {
                tt5.a.h(this.a.a, "handlePreloadSubblock dialog wifi");
                DocxPreloadStrategyV2 r0 = this.a;
                List<SubBlockModel> r1 = this.b;
                List<ResDetaildata> r2 = this.c;
                List<ResDetaildata> r3 = this.d;
                String r4 = this.e.getToken();
                String r5 = (String) this.f.element;
                int r10 = DocxPreloadStrategyV2.C;
                r0.A(r1, r2, r3, r4, r5, true);
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ DocxPreloadStrategyV2 a;
            public final /* synthetic */ Ref.ObjectRef<String> b;
            public final /* synthetic */ List<SubBlockModel> c;
            public final /* synthetic */ List<ResDetaildata> d;
            public final /* synthetic */ List<ResDetaildata> e;
            public final /* synthetic */ PreloadSubblock f;

            public b(DocxPreloadStrategyV2 r1, Ref.ObjectRef<String> r2, List<SubBlockModel> r3, List<ResDetaildata> r4, List<ResDetaildata> r5, PreloadSubblock r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r9, int r10) {
                tt5.a.h(this.a.a, "handlePreloadSubblock dialog mobile");
                ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).k((String) this.b.element, 1);
                DocxPreloadStrategyV2 r1 = this.a;
                List<SubBlockModel> r2 = this.c;
                List<ResDetaildata> r3 = this.d;
                List<ResDetaildata> r4 = this.e;
                String r5 = this.f.getToken();
                String r6 = (String) this.b.element;
                int r11 = DocxPreloadStrategyV2.C;
                r1.A(r2, r3, r4, r5, r6, false);
            }
        }

        public static final class c implements DialogInterface.OnClickListener {
            public final /* synthetic */ DocxPreloadStrategyV2 a;
            public final /* synthetic */ List<SubBlockModel> b;
            public final /* synthetic */ List<ResDetaildata> c;
            public final /* synthetic */ List<ResDetaildata> d;
            public final /* synthetic */ PreloadSubblock e;
            public final /* synthetic */ Ref.ObjectRef<String> f;

            public c(DocxPreloadStrategyV2 r1, List<SubBlockModel> r2, List<ResDetaildata> r3, List<ResDetaildata> r4, PreloadSubblock r5, Ref.ObjectRef<String> r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r8, int r9) {
                tt5.a.h(this.a.a, "handlePreloadSubblock dialog cancel");
                DocxPreloadStrategyV2 r0 = this.a;
                List<SubBlockModel> r1 = this.b;
                List<ResDetaildata> r2 = this.c;
                List<ResDetaildata> r3 = this.d;
                String r4 = this.e.getToken();
                String r5 = (String) this.f.element;
                int r10 = DocxPreloadStrategyV2.C;
                r0.A(r1, r2, r3, r4, r5, true);
            }
        }

        public d(DocxPreloadStrategyV2 r1, Ref.LongRef r2, List<SubBlockModel> r3, List<ResDetaildata> r4, List<ResDetaildata> r5, PreloadSubblock r6, Ref.ObjectRef<String> r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void a() {
            Activity r0 = AppLifecycle.a.a.f();
            if (r0 != null) goto L6;
            return;
        L6:
            if (com.bytedance.ee.util.ui.n.A(r0) == true) goto L9;
            tt5.a.k(this.a.a, "Activity is not running.");
            return;
        L9:
            tt5.a.k(this.a.a, "Activity : ".concat(r0.getClass().getSimpleName()));
            String r1 = r0.getString(2131887791);
            String r2 = xo5.a.c(r0, 2131887796, "size", FileUtils.A(this.b.element));
            Intrinsics.checkNotNullParameter(r0, "context");
            UDDialogBuilder r3 = new UDDialogBuilder(r0);
            r3.autoDismiss(true);
            Intrinsics.checkNotNullParameter(r1, "value");
            r3.title(r1);
            Intrinsics.checkNotNull(r2);
            Intrinsics.checkNotNullParameter(r2, "value");
            r3.message(r2);
            r3.messageGravity(8388611);
            BearUDDialogBuilder.ActionBottomOrientation r4 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
            Intrinsics.checkNotNullParameter(r4, "value");
            if (r4 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L12;
            UDBaseDialogBuilder.ActionBottomOrientation r5 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
        L13:
            r3.actionButtonOrientation(r5);
            r3.addActionButton(2131391777, 2131887799, new a(this.a, this.c, this.d, this.e, this.f, this.g));
            r3.addActionButton(2131391778, 2131887797, new b(this.a, this.g, this.c, this.d, this.e, this.f));
            r3.addActionButton(2131391779, 2131887716, new c(this.a, this.c, this.d, this.e, this.f, this.g));
            r3.cancelable(false);
            UDDialog r6 = r3.build();
            if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r6);
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L17:
            DialogLancet.beforeDialogShow(r6);
            r6.show();
            DialogLancet.afterDialogShow(r6);
            return;
        L12:
            r5 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
            goto L13
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

    public static final class e implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ PreloadSubblock b;

        public e(int r1, PreloadSubblock r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r0 = (this.a * 100) / this.b.getResList().size();     // Catch: Throwable -> L4
            Application r1 = eu5.b.a;     // Catch: Throwable -> L4
            Toast.showText(r1, xo5.a.c(r1, 2131889253, "num", String.valueOf(r0)), 1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DocxPreloadStrategyV2 a;

        public f(DocxPreloadStrategyV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            tt5.a.h(this.a.a, "init : ");
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ DocxPreloadStrategyV2 a;

        public g(DocxPreloadStrategyV2 r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            String r0 = this.a.a;
            tt5.a.e(r0, "init error: ", (Throwable) r4, false);
        }
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final String u() {
        return "biz.docx.loadComplete";
    }

    public DocxPreloadStrategyV2() {
        this.x = "biz.util.preloadSubblock";
        this.A = true;
        this.B = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final boolean v() {
        return this.A;
    }

    public static String B(ResDetaildata r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        return "https://" + s45.p.u + '/' + r2.getToken() + "?width=" + r2.getWidth() + "&height=" + r2.getHeight() + "&scale=" + r2.getScale() + "&contentType=" + r2.getMimeType() + "&type=image";
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy, com.bytedance.ee.bear.document.offline.sync.q
    public final void f(AccountService$Account r4) {
        Intrinsics.checkNotNullParameter(r4, "account");
        super.f(r4);
        this.a = "DocxPreloadStrategyV2";
        this.y = h0.m.booleanValue();
        this.f = r4.tenantId + '_' + r4.uid + "_CLIENT_VARS";
        this.z = r4.tenantId + '_' + r4.uid + "_SHEET_CLIENT_VARS";
        this.g = PreloadConfigModel.VERSION_CHECK_TYPE_DOCX;
        this.j = new v25.c();
        Flowable r5 = ((com.bytedance.ee.bear.rn.j) org.koin.java.a.c(com.bytedance.ee.bear.rn.j.class, null, null, 6)).d(new DocxPreloadStrategyV2$init$1(this));
        if (r5 == null) goto L6;
        r5.subscribe(new f(this), new g(this));
        return;
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final OfflineDoc h(OfflineDoc r5) {
        if (r5 != null) goto L4;
    L16:
        return r5;
    L4:
        if (TextUtils.isEmpty(r5.getEdition_id()) == true) goto L16;
        String r0 = r5.getObj_token();
        Integer r1 = Integer.valueOf(r5.getType());
        String r2 = r5.getEdition_id();
        if (this.w != null) goto L8;
        this.w = new z05.d();
    L8:
        z05.d r3 = this.w;
        if (r3 == null) goto L14;
        if (r1 == null) goto L12;
        int r4 = r1.intValue();
    L13:
        String r6 = (String) r3.a(r0, r4, r2).map(j.a).singleOrError().blockingGet();
    L15:
        r5.setObj_token(r6);
        goto L16
    L12:
        r4 = sbb.e.o.b;
        goto L13
    L14:
        r6 = "";
        goto L15
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.CommonRNPreloadStrategy
    public final void s(String r6) {
        Intrinsics.checkNotNullParameter(r6, "data");
        JSONObject r1 = new JSONObject(r6);     // Catch: JSONException -> L7
        String r7 = r1.optString("docxToken");     // Catch: JSONException -> L7
        int r2 = r1.optInt("code");     // Catch: JSONException -> L7
        String r3 = r1.optString("type");     // Catch: JSONException -> L7
        tt5.a.h(this.a, "updateSubBlockStatus: type: " + r3 + "--objToken: " + du5.b.g(r7) + "--code: " + r2);     // Catch: JSONException -> L7
        if (Intrinsics.areEqual(SubBlockType.ALL_DATA_COMPLETE.getSubBlockType(), r3) == false) goto L12;
        t(r7, r2);     // Catch: JSONException -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        tt5.a.l(this.a, "executeRNLoadCompletedData error: ", e);
    }

    public final void C(PreloadSubblock r23, tb5.m r24) {
        tt5.a.h(this.a, "handlePreloadSubblock data : " + r23 + "  ,  mFg : " + this.y);
        if (r23.getCode() == 0) goto L5;
        return;
    L5:
        if (r23.getToken() == null) goto L198;
        Map<String, OfflineDoc> r0 = this.t;
        String r1 = r23.getToken();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        OfflineDoc r2 = (OfflineDoc) ((ConcurrentHashMap) r0).get(r1);
        if (this.y == false) goto L17;
        if (r2 == null) goto L13;
        String r3 = r2.getFrom_source();
    L15:
        if (TextUtils.equals("tab_manual_offline", r3) == false) goto L17;
        boolean r4 = true;
    L18:
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        int r12 = (h0.l.getDocxImageBlockPreloadNumber() + h0.l.getDocxVideoBlockPreloadNumber()) + h0.l.getDocxOfficeBlockPreloadNumber();
        if (h0.o == false) goto L21;
        r12 = SmallLoadingPlugin.DURATION_MAX;
    L21:
        Ref.LongRef r13 = new Ref.LongRef();
        CopyOnWriteArrayList r14 = new CopyOnWriteArrayList();
        String r16 = r23.getToken();
        if (r16 == null) goto L24;
        ((ConcurrentHashMap) this.B).put(r16, r14);
    L24:
        Iterator r5 = r23.getResList().iterator();
        DocxPreloadStrategyV2 r17 = this;
        boolean r6 = false;
        int r7 = 0;
    L26:
        if (r5.hasNext() == false) goto L128;
        Object r18 = r5.next();
        int r19 = r7 + 1;
        if (r7 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        ResDetail r110 = (ResDetail) r18;
        if (r7 < r12) goto L33;
        Iterator r111 = r5;
        int r20 = r12;
        CopyOnWriteArrayList r21 = r14;
    L127:
        r7 = r19;
        r5 = r111;
        r12 = r20;
        r14 = r21;
        goto L26
    L33:
        r111 = r5;
        long r8 = r13.element;
        ResDetaildata r112 = r110.getData();
        if (r112 == null) goto L38;
        Long r113 = r112.getSize();
        if (r113 == null) goto L38;
        long r22 = r113.longValue();
    L39:
        r13.element = r8 + r22;
        ResDetaildata r26 = r110.getData();
        if (r26 == null) goto L44;
        String r27 = r26.getToken();
        if (r27 == null) goto L44;
        r14.add(r27);
    L44:
        String r28 = r110.getType();
        int r29 = r28.hashCode();
        r20 = r12;
        if (r29 != 3143036) goto L47;
        r21 = r14;
        if (r28.equals("file") == true) goto L99;
    L98:
        tt5.a.h(this.a, "handlePreloadSubblock else ");
    L126:
        r17 = this;
        goto L127
    L99:
        ResDetaildata r30 = r110.getData();
        if (r4 == true) goto L102;
        boolean r31 = true;
    L118:
        if (r31 == false) goto L124;
        String r32 = this.a;
        StringBuilder r114 = new StringBuilder("addFiles officeList size : ");
        r114.append(r11.size());
        r114.append(" , data?.size : ");
        if (r30 == null) goto L122;
        Long r33 = r30.getSize();
    L123:
        r114.append(r33);
        tt5.a.h(r32, r114.toString());
        goto L124
    L122:
        r33 = null;
    L124:
        if (r31 == false) goto L126;
    L125:
        r17 = this;
        r6 = true;
        goto L127
    L102:
        if (r11.size() > h0.l.getDocxOfficeBlockPreloadNumber()) goto L112;
        if (r30 == null) goto L112;
        Long r34 = r30.getSize();
        if (r34 == null) goto L112;
        if (((int) r34.longValue()) >= h0.l.getDocxOfficeblockPreloadSize()) goto L112;
        if (h0.o == true) goto L111;
        r11.add(r30);
    L111:
        r31 = false;
    L114:
        if (h0.o == false) goto L118;
        if (r30 == null) goto L118;
        r11.add(r30);
    L112:
        r31 = true;
        goto L114
    L47:
        if (r29 != 100313435) goto L49;
        r21 = r14;
        if (r28.equals("image") == false) goto L98;
        String r36 = r23.getToken();
        ResDetaildata r37 = r110.getData();
        if (r4 == false) goto L91;
        r9.add(new SubBlockModel(r36, sbb.e.o.b, SubBlockType.IMAGE_DATA, B(r37)));
        if (r9.size() <= h0.l.getDocxImageBlockPreloadNumber()) goto L93;
        tt5.a.h(this.a, "addImages imagesList size : " + r9.size());
        boolean r38 = true;
    L94:
        if (r38 == false) goto L126;
    L93:
        r38 = false;
        goto L94
    L91:
        if (r9.size() >= 10) goto L93;
        r9.add(new SubBlockModel(r36, sbb.e.o.b, SubBlockType.IMAGE_DATA, B(r37)));
        goto L93
    L49:
        if (r29 == 112202875) goto L52;
    L53:
        r21 = r14;
        goto L98
    L52:
        if (r28.equals(VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE) == false) goto L53;
        ResDetaildata r39 = r110.getData();
        if (r4 == true) goto L57;
        r21 = r14;
        boolean r40 = true;
    L74:
        if (r40 == false) goto L80;
        String r115 = this.a;
        StringBuilder r116 = new StringBuilder("addvideos videoList size : ");
        r116.append(r10.size());
        r116.append(" , data?.size : ");
        if (r39 == null) goto L78;
        Long r41 = r39.getSize();
    L79:
        r116.append(r41);
        tt5.a.h(r115, r116.toString());
        goto L80
    L78:
        r41 = null;
    L80:
        if (r40 == false) goto L126;
    L57:
        if (r10.size() > h0.l.getDocxVideoBlockPreloadNumber()) goto L67;
        if (r39 == null) goto L67;
        Long r42 = r39.getSize();
        if (r42 == null) goto L67;
        r21 = r14;
        if (((int) r42.longValue()) < h0.l.getDocxVideoblockPreloadSize()) goto L64;
    L68:
        r40 = true;
    L70:
        if (h0.o == false) goto L74;
        if (r39 == null) goto L74;
        r10.add(r39);
        goto L74
    L64:
        if (h0.o == true) goto L66;
        r10.add(r39);
    L66:
        r40 = false;
    L67:
        r21 = r14;
    L38:
        r22 = 0;
        goto L39
    L128:
        int r43 = (r9.size() + r10.size()) + r11.size();
        String r44 = r17.a;
        StringBuilder r46 = new StringBuilder("handlePreloadSubblock imagesList.size : ");
        r46.append(r9.size());
        r46.append("   , videoList.size : ");
        r46.append(r10.size());
        r46.append("  , officeList.size : ");
        r46.append(r11.size());
        r46.append(" , data.resList.size : ");
        r46.append(r23.getResList().size());
        r46.append("  , embedDocList.size : ");
        r46.append(r23.getEmbedDocList().size());
        r46.append(" ,  fg : ");
        r46.append(r4);
        r46.append(" ,  sDocxBlockOptimize : ");
        boolean r117 = h0.o;
        r46.append(r117);
        r46.append("   fileSize : ");
        r46.append(r13.element);
        r46.append("  overSize : ");
        r46.append(r6);
        r46.append("  doctoken : ");
        r46.append(du5.b.i(r23.getToken()));
        r46.append(')');
        tt5.a.h(r44, r46.toString());
        if (r4 == false) goto L191;
        ArrayList<EmbedDocList> r47 = r23.getEmbedDocList();
        if (r47.size() <= 0) goto L134;
        Flowable.just("").observeOn(fo5.d.c()).map(new k(r47, r17)).observeOn(fo5.d.d()).subscribe(new l(r24), new m(r17));
    L134:
        if (r117 == false) goto L175;
        Ref.ObjectRef r48 = new Ref.ObjectRef();
        r48.element = r23.getToken();
        if (r2 != null) goto L138;
    L140:
        boolean r49 = false;
    L141:
        if (r49 == false) goto L147;
        DocWikiInfo r50 = r2.getWikiInfo();
        if (r50 == null) goto L145;
        String r51 = r50.getWiki_token();
    L146:
        r48.element = r51;
        goto L147
    L145:
        r51 = null;
    L147:
        if (r2 == null) goto L149;
        Integer r52 = Integer.valueOf(r2.getDownloadStatus());
    L150:
        if (r52 == null) goto L155;
        if (r52.intValue() != 1) goto L155;
    L159:
        if (r17.e.getNetworkState().c() == true) goto L173;
        if (r6 == false) goto L173;
        if (r2 != null) goto L163;
    L165:
        String r53 = r23.getToken();
        String r54 = (String) r48.element;
        if (r52 != null) goto L169;
    L170:
        boolean r118 = true;
    L172:
        A(r9, r10, r11, r53, r54, r118);
        return;
    L169:
        if (r52.intValue() != 1) goto L170;
        r118 = false;
        goto L172
    L163:
        if (r2.getTriggerTime() <= (-1)) goto L165;
        com.bytedance.ee.util.ui.j.c(new d(this, r13, r9, r10, r11, r23, r48));
        return;
    L173:
        A(r9, r10, r11, r23.getToken(), (String) r48.element, false);
        return;
    L155:
        if (r6 == false) goto L157;
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).k((String) r48.element, 2);
        goto L159
    L157:
        ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).k((String) r48.element, 1);
        goto L159
    L149:
        r52 = null;
        goto L150
    L138:
        if (r2.getIs_wiki() != true) goto L140;
        r49 = true;
        goto L141
    L175:
        if (r43 <= 0) goto L190;
        if (r23.getResList().size() <= 0) goto L190;
        if (r43 >= r23.getResList().size()) goto L190;
        if (r2 == null) goto L182;
        String r56 = r2.getFrom_source();
    L184:
        if (TextUtils.equals("tab_manual_offline", r56) == false) goto L190;
        if (r2 == null) goto L190;
        if (r2.getTriggerTime() <= (-1)) goto L190;
        com.bytedance.ee.util.ui.j.c(new e(r43, r23));
        goto L190
    L182:
        r56 = null;
    L190:
        A(r9, r10, r11, r23.getToken(), "", false);
        return;
    L191:
        r17.D(false, r9, r23.getToken(), "");
        return;
    L13:
        r3 = null;
    L17:
        r4 = false;
        goto L18
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f, com.bytedance.ee.bear.document.offline.sync.q
    public final k25.m0 g(String r2, Map<String, String> r3) {
        Intrinsics.checkNotNullParameter(r3, "queries");
        if (TextUtils.isEmpty(this.f) == true) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        return k25.e0.m().s(this.f, r2);
    L9:
        return new k25.m0();
    }

    @Override // com.bytedance.ee.bear.document.offline.sync.f
    public final com.alibaba.fastjson.JSONObject l(String r4, Map<String, String> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "queries");
        com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject();
        r7.put("operation", "docx.fetchData");
        com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject();
        r0.put("type", Integer.valueOf(sbb.e.o.b));
        if (r4 == null) goto L5;
        r0.put("docxToken", r4);
    L5:
        if (r6 == false) goto L7;
        String r8 = "offline";
    L8:
        r0.put("eventType", r8);
        r0.put("resourceLimit", Integer.valueOf(h0.l.getDocxBlockPreloadNumber()));
        r0.put("embedDocLimit", Integer.valueOf(h0.l.getDocxMentionDocblockPreloadNumber()));
        r7.put("body", r0);
        return r7;
    L7:
        r8 = "preload";
        goto L8
    }

    public static final void z(DocxPreloadStrategyV2 r5, List r6, String r7, String r8) {
        CopyOnWriteArrayList r0 = (CopyOnWriteArrayList) ((ConcurrentHashMap) r5.B).get(r7);
        Iterator r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        String r1 = ((ResDetaildata) r9.next()).getToken();
        if (r1 == null) goto L4;
        Bundle r2 = new Bundle();
        r2.putString("module", "drive");
        pw4.d r3 = new pw4.d();
        r3.a = r1;
        r3.c = r2;
        ((com.bytedance.ee.bear.h) org.koin.java.a.c(com.bytedance.ee.bear.h.class, null, null, 6)).j3(false, r3, new n(r5, r0, r7, r8));
        goto L4
    }

    public final void D(boolean r10, List<SubBlockModel> r11, final String r12, final String r13) {
        k25.m0 r0 = k25.e0.m().n(this.f, r12);
        if (r11.size() <= 0) goto L13;
        if (r10 == false) goto L6;
        tt5.a.h(this.a, "preloadImages batchImgPreloadJobs 1 imagesList.size: " + r11.size());
        final CopyOnWriteArrayList r14 = (CopyOnWriteArrayList) ((ConcurrentHashMap) this.B).get(r12);
        Long r1 = h0.j;
        h0.b.a.b(this.f, r12, sbb.e.o.b, r11, true, new DocxPreloadStrategyV2$preloadImages$1(this, r14, r12, r13));
    L16:
        p r16 = this.n;
        if (r16 == null) goto L19;
        ((r25.e.a) r16).a(r12, System.currentTimeMillis());
    L19:
        k25.e0.m().I(r0);
        return;
    L6:
        x25.f r17 = r0.u;
        if (r17 != null) goto L9;
    L12:
        Long r18 = h0.j;
        h0.b.a.b(this.f, r12, sbb.e.o.b, r11, false, null);
        goto L16
    L9:
        if (r17.b(SubBlockType.IMAGE_DATA) == false) goto L12;
        tt5.a.h(this.a, "Image block has been preloaded.");
        goto L16
    L13:
        tt5.a.h(this.a, "Image block not exist.");
        x25.f r19 = r0.u;
        if (r19 == null) goto L16;
        r19.c(1);
        goto L16
    }

    public final void A(List<SubBlockModel> r12, List<ResDetaildata> r13, List<ResDetaildata> r14, String r16, String r17, boolean r18) {
        tt5.a.h(this.a, "doPreload start hasLimit : " + r18 + ' ');
        Flowable.just("").observeOn(fo5.d.c()).subscribe(new b(r18, r12, r13, r14, r16, this, r17), new c(this));
    }
}
