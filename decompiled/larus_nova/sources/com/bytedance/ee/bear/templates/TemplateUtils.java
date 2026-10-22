package com.bytedance.ee.bear.templates;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import s45.p;

/* JADX INFO: loaded from: classes18.dex */
public final class TemplateUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TemplateUtils f238776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f238777b = null;

    public interface a {
        void onResult(String r100);
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f238778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<String> f238779b;

        public b(a r100, Function0<String> r101) {
            this.f238778a = r100;
            this.f238779b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f238778a.onResult(this.f238779b.invoke());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Boolean> f238780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TemplateCenterViewModel f238781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ RouteBean f238782c;

        public c(Function0<Boolean> r100, TemplateCenterViewModel r101, RouteBean r102) {
            this.f238780a = r100;
            this.f238781b = r101;
            this.f238782c = r102;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "previewUrl");
            if (this.f238780a.invoke().booleanValue() == true) goto L6;
            return;
        L6:
            if (this.f238781b.isOnlyNewLarkForm() == false) goto L8;
            r100 = UriProtector.parse(r100).buildUpon().appendQueryParameter("larkForm", "1").appendQueryParameter("isTemplatePreview", "true").build().toString();
        L8:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r100, this.f238782c);
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Boolean> f238783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RouteBean f238784b;

        public d(Function0<Boolean> r100, RouteBean r101) {
            this.f238783a = r100;
            this.f238784b = r101;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            if (this.f238783a.invoke().booleanValue() == true) goto L5;
            return;
        L5:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r100, this.f238784b);
        }
    }

    public static final class e implements bn4.a.InterfaceC0319a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f238785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f238786b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f238787c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f238788d;

        @Override // bn4.a.InterfaceC0319a
        public final void onResult(boolean r100) {
            tt5.a.h("TemplateUtils", "prepareBitablePreviewPathAsync. isApp: " + r100);
            if (this.f238785a.compareAndSet(false, true) == false) goto L6;
            this.f238786b.removeCallbacks(this.f238787c);
            this.f238788d.invoke();
            return;
        }

        public e(AtomicBoolean r100, Handler r101, f r102, Function0 r103) {
            this.f238785a = r100;
            this.f238786b = r101;
            this.f238787c = r102;
            this.f238788d = r103;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f238789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f238790b;

        public f(AtomicBoolean r100, Function0<Unit> r101) {
            this.f238789a = r100;
            this.f238790b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f238789a.compareAndSet(false, true) == false) goto L9;
            tt5.a.k("TemplateUtils", "prepareBitablePreviewPathAsync timeout");     // Catch: Throwable -> L6
            this.f238790b.invoke();     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f238791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.templates.c f238792b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f238793c;

        public g(Context r100, com.bytedance.ee.bear.templates.c r101, Function0<Unit> r102) {
            this.f238791a = r100;
            this.f238792b = r101;
            this.f238793c = r102;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TemplateUtils r101 = TemplateUtils.f238776a;
            Context r102 = this.f238791a;
            com.bytedance.ee.bear.templates.c r103 = this.f238792b;
            r101.getClass();
            TemplateUtils.o(r102, r103);
            this.f238793c.invoke();
        }
    }

    public static final class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.templates.c f238794a;

        public h(com.bytedance.ee.bear.templates.c r100) {
            this.f238794a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            TemplateUtils r101 = TemplateUtils.f238776a;
            com.bytedance.ee.bear.templates.c r102 = this.f238794a;
            int r103 = r102.f238869a;
            String r104 = r102.f238870b;
            r101.getClass();
            TemplateUtils.k(r103, r104);
        }
    }

    public static final class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f238795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f238796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.templates.c f238797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f238798d;

        public static final class a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f238799a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ee.bear.templates.c f238800b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f238801c;

            public a(Function0<Unit> r100, com.bytedance.ee.bear.templates.c r101, Function0<Unit> r102) {
                this.f238799a = r100;
                this.f238800b = r101;
                this.f238801c = r102;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                this.f238799a.invoke();
                TemplateUtils r102 = TemplateUtils.f238776a;
                NetService r103 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
                com.bytedance.ee.bear.templates.c r104 = this.f238800b;
                int r105 = r104.f238869a;
                String r106 = r104.f238870b;
                Function0<Unit> r107 = this.f238801c;
                r102.getClass();
                TemplateReport.b("click_delete");
                NetService.f r108 = new NetService.f("/api/obj_template/delete/");
                r108.f216906c = 1;
                r108.b("obj_type", String.valueOf(r105));
                r108.b("obj_token", r106);
                r103.Vc(com.bytedance.ee.bear.templates.i.f239119a).a(r108).subscribe(new com.bytedance.ee.bear.templates.j(r107), com.bytedance.ee.bear.templates.k.f239121a);
            }
        }

        public i(Context r100, Function0<Unit> r101, com.bytedance.ee.bear.templates.c r102, Function0<Unit> r103) {
            this.f238795a = r100;
            this.f238796b = r101;
            this.f238797c = r102;
            this.f238798d = r103;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Context r101 = this.f238795a;
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            UDDialogBuilder r102 = new UDDialogBuilder(r101);
            r102.autoDismiss(true);
            r102.title(R.string.Doc_List_CustomTemplateDeleteTitle);
            r102.message(R.string.Doc_List_CustomTemplateDelete);
            a r103 = new a(this.f238796b, this.f238797c, this.f238798d);
            r102.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Doc_Facade_Delete).textColorRes(R.color.function_danger_fill_default).onClickListener(r103));
            r102.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, null);
            UDDialog r104 = r102.build();
            if (DialogLancet.shouldBlockDialogShow(r104) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r104);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r104);
            r104.show();
            DialogLancet.afterDialogShow(r104);
        }
    }

    public static final class j<T1, T2, R> implements BiFunction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.templates.c f238802a;

        public j(com.bytedance.ee.bear.templates.c r100) {
            this.f238802a = r100;
        }

        @Override // io.reactivex.functions.BiFunction
        public final Object apply(Object r100, Object r101) {
            DocMetaInfo r102 = (DocMetaInfo) r100;
            DocContainerInfo r103 = (DocContainerInfo) r101;
            Intrinsics.checkNotNullParameter(r102, "docMetaInfo");
            Intrinsics.checkNotNullParameter(r103, "docContainerInfo");
            com.bytedance.ee.bear.templates.c.a r104 = this.f238802a.f238874f;
            int r105 = r103.getBiz_type();
            int r106 = com.bytedance.ee.bear.a.f206186a;
            if (r105 != 2) goto L5;
            boolean r107 = true;
        L6:
            r104.f238875a = r107;
            return r102;
        L5:
            r107 = false;
            goto L6
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f238803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.templates.c f238804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f238805c;

        public k(Context r100, com.bytedance.ee.bear.templates.c r101, String r102) {
            this.f238803a = r100;
            this.f238804b = r101;
            this.f238805c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocMetaInfo r101 = (DocMetaInfo) r100;
            if (r101.getUrl().length() <= 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
            TemplateUtils r103 = TemplateUtils.f238776a;
            Context r104 = this.f238803a;
            com.bytedance.ee.bear.templates.c r105 = this.f238804b;
            String r106 = r101.getUrl();
            r103.getClass();
            TemplateUtils.l(r104, r105, r106);
            return;
        L8:
            TemplateUtils r107 = TemplateUtils.f238776a;
            Context r108 = this.f238803a;
            com.bytedance.ee.bear.templates.c r109 = this.f238804b;
            String r110 = this.f238805c;
            r107.getClass();
            TemplateUtils.l(r108, r109, r110);
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class l<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f238806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ee.bear.templates.c f238807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f238808c;

        public l(Context r100, com.bytedance.ee.bear.templates.c r101, String r102) {
            this.f238806a = r100;
            this.f238807b = r101;
            this.f238808c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            TemplateUtils r102 = TemplateUtils.f238776a;
            Context r103 = this.f238806a;
            com.bytedance.ee.bear.templates.c r104 = this.f238807b;
            String r105 = this.f238808c;
            r102.getClass();
            TemplateUtils.l(r103, r104, r105);
        }
    }

    public TemplateUtils() {
    }

    static {
        f238776a = new TemplateUtils();
        f238777b = LazyKt.lazy(TemplateUtils$isDowngradeForsetiTemplatePreview$2.INSTANCE);
    }

    public static void g(a r100, Function0 r101) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.onResult((String) r101.invoke());
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new b(r100, r101));
    }

    public static void k(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "objToken");
        String r102 = p.a().ua(sbb.e.d(r100).getType(), r101, "");
        RouteBean r103 = new RouteBean();
        r103.f236638c = 1;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r102, r103);
    }

    public static void m(String r100, Function0 r101) {
        AtomicBoolean r102 = new AtomicBoolean(false);
        Handler r103 = new Handler(Looper.getMainLooper());
        f r104 = new f(r102, r101);
        r103.postDelayed(r104, 10000);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L5
        ((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).o(r100, new e(r102, r103, r104, r101));     // Catch: Throwable -> L5
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L15;
        tt5.a.e("TemplateUtils", "prepareBitablePreviewPathAsync", r107, false);
        if (r102.compareAndSet(false, true) == false) goto L16;
        r103.removeCallbacks(r104);
        r101.invoke();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void o(Context r100, com.bytedance.ee.bear.templates.c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        String r102 = p.a().ua(sbb.e.d(r101.f238869a).getType(), r101.f238870b, "");
        Flowable.zip(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r101.f238870b, r101.f238869a), ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).d(r101.f238870b, r101.f238869a), new j(r101)).subscribe(new k(r100, r101, r102), new l(r100, r101, r102));
    }

    public static ArrayList a(JSONObject r100, Locale r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "templatesObject");
        Intrinsics.checkNotNullParameter(r101, "locale");
        ArrayList r102 = new ArrayList();
        if (r100.has("2") == false) goto L5;
        int r103 = n.f239126a;
        ArrayList r104 = n.b(JSONObjectProtectorUtils.getJSONArray(r100, "2"), null, r101, r110);
    L7:
        if (r100.has("3") == false) goto L9;
        int r105 = n.f239126a;
        ArrayList r106 = n.b(JSONObjectProtectorUtils.getJSONArray(r100, "3"), null, r101, r110);
    L11:
        if (r100.has("11") == false) goto L13;
        int r107 = n.f239126a;
        ArrayList r108 = n.b(JSONObjectProtectorUtils.getJSONArray(r100, "11"), null, r101, r110);
    L15:
        if (r100.has("8") == false) goto L17;
        int r109 = n.f239126a;
        ArrayList r111 = n.b(JSONObjectProtectorUtils.getJSONArray(r100, "8"), null, r101, r110);
    L19:
        if (r100.has("22") == false) goto L21;
        int r112 = n.f239126a;
        ArrayList r113 = n.b(JSONObjectProtectorUtils.getJSONArray(r100, "22"), null, r101, r110);
    L22:
        r102.addAll(r104);
        r102.addAll(r106);
        r102.addAll(r108);
        r102.addAll(r111);
        r102.addAll(r113);
        return r102;
    L21:
        r113 = new ArrayList();
        goto L22
    L17:
        r111 = new ArrayList();
        goto L19
    L13:
        r108 = new ArrayList();
        goto L15
    L9:
        r106 = new ArrayList();
        goto L11
    L5:
        r104 = new ArrayList();
        goto L7
    }

    public static String b(int r100, String r101, String r102) {
        return p.a().Le(sbb.e.d(r100).getType(), r101, MapsKt.mapOf(new Pair[]{TuplesKt.to("from", "template_preview"), TuplesKt.to("template_preview_source", r102)}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(Context r100, com.bytedance.ee.bear.templates.c r101, String r102) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        ShareParams r103 = new ShareParams.ShareParamsBuilder((FragmentActivity) r100, null, 2, 0 == true ? 1 : 0).source(r101.f238873e).token(r101.f238870b).type(r101.f238869a).realToken(r101.f238870b).realType(r101.f238869a).isWiki(r101.f238874f.f238875a).isOwner(true).url(r102).docName(r101.f238871c).build();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.b(r101.f238869a) == false) goto L5;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).id(r103, null);
        return;
    L5:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).aa(r103, null, null);
    }

    public static void p(Context r100, com.bytedance.ee.bear.templates.c r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r102 != null) goto L5;
    L11:
        o(r100, r101);
        return;
    L5:
        if (r102.length() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        l(r100, r101, r102);
        return;
    L7:
        r103 = false;
        goto L8
    }

    public static void c(final int r100, final String r101, final String r102, final a r103) {
        Intrinsics.checkNotNullParameter(r103, "callback");
        boolean r104 = false;
        if (r100 == 8) goto L5;
    L13:
        if (r104 == true) goto L16;
        g(r103, new TemplateUtils$buildPreviewTemplateUrlAsync$1(r100, r101, r102));
        return;
    L16:
        if (r101 != null) goto L18;
        String r105 = "";
    L19:
        m(r105, new TemplateUtils$buildPreviewTemplateUrlAsync$2(r103, r100, r101, r102));
        return;
    L18:
        r105 = r101;
        goto L19
    L5:
        if (r101 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == true) goto L13;
        r104 = true;
        goto L13
    L7:
        if (StringsKt.isBlank(r101) == true) goto L10;
        r106 = false;
        goto L11
    }

    public static void j(TemplateV4 r210, List r211, Bundle r212, Function0 r213) {
        Intrinsics.checkNotNullParameter(r210, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r213, "canNavigate");
        LinkedList r110 = new LinkedList();
        if (r211 != null) goto L37;
        int r111 = 0;
    L30:
        String r100 = TemplateReportV2.f238770c;
        String r101 = TemplateReportV2.f238773f;
        CreateSelectResult.CREATOR.getClass();
        CommonPreviewTemplateData r102 = new CommonPreviewTemplateData(r100, "", r101, CameraParam.TYPE_SYSTEM_CAMERA, "", "", "", CreateSelectResult.a.d(CreateSelectResult.a.b()), r111, "", r110);
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put(DocViewModel.KEY_TEMPLATE_PREVIEW_LIST, JSON.toJSONString(r102));
        if (r212 == null) goto L33;
        r212.putString("key_template_select_template_id", r210.getId());
    L33:
        RouteBean r104 = new RouteBean();
        r104.f236638c = 1;
        r104.f236646k = r103;
        r104.f236649n = r212;
        c(r210.getObjType(), r210.getObjToken(), CameraParam.TYPE_SYSTEM_CAMERA, new d(r213, r104));
        return;
    L37:
        Iterator r105 = r211.iterator();     // Catch: Throwable -> L25
        int r106 = 0;
        int r107 = 0;
    L35:
    L23:
        th = th;
    L27:
        tt5.a.e("TemplateUtils", "handlePreviewTemplateForCategory", th, false);
    L28:
        r111 = r106;
        goto L30
    L7:
        if (r105.hasNext() == false) goto L28;
        Iterator<T> r108 = ((ao5.a) r105.next()).f15786c.iterator();     // Catch: Throwable -> L23
    L10:
        if (r108.hasNext() == false) goto L35;
        TemplateV4 r109 = (TemplateV4) r108.next();     // Catch: Throwable -> L23
        if (r109.isSceneTemplate() == true) goto L10;
        if (TextUtils.isEmpty(r109.getObjToken()) == true) goto L10;
        int r214 = r107;
        Item r112 = new Item(r109.getObjToken(), r109.getName(), r109.getObjType(), r109.getSource(), r214, r109.getId());     // Catch: Throwable -> L23
        r112.setCategorySdkTemplate(true);     // Catch: Throwable -> L23
        r110.add(r112);     // Catch: Throwable -> L23
        if (TextUtils.equals(r210.getId(), r109.getId()) == true) goto L18;
    L22:
        r107 = r107 + 1;
        goto L10
    L18:
        if (TextUtils.equals(r210.getObjToken(), r109.getObjToken()) == false) goto L22;
        if (r210.getObjType() != r109.getObjType()) goto L22;
        r106 = r107;
    L25:
        th = th;
        r106 = 0;
        goto L27
    }

    public static String d(int r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r103, "templateCenterSource");
        Intrinsics.checkNotNullParameter(r104, GXTemplateKey.GAIAX_TEMPLATE_TYPE);
        return p.a().Le(sbb.e.d(r100).getType(), r101, MapsKt.mapOf(new Pair[]{TuplesKt.to("from", "template_preview"), TuplesKt.to("template_preview_source", "scene"), TuplesKt.to("collectionId", r102), TuplesKt.to(GXTemplateKey.GAIAX_TEMPLATE_TYPE, r104), TuplesKt.to("templatecenter_source", r103)}));
    }

    public static void n(Context r100, com.bytedance.ee.bear.templates.c r101, Function0 r102, Function0 r103, Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "shareClickListener");
        Intrinsics.checkNotNullParameter(r103, "deleteClickListener");
        Intrinsics.checkNotNullParameter(r104, "deleteSuccessListener");
        com.bytedance.ee.bear.widgets.a r105 = new com.bytedance.ee.bear.widgets.a(r100);
        r105.g(r100.getText(R.string.Doc_Facade_Share), new g(r100, r101, r102));
        if (r101.f238872d == false) goto L5;
        r105.g(r100.getText(R.string.Bitable_Common_ButtonEdit), new h(r101));
    L5:
        r105.i(r100.getText(R.string.Doc_Facade_Delete), new i(r100, r103, r101, r104));
        r105.a();
        r105.q();
    }

    public static void e(final int r100, final String r110, final String r111, final String r112, final String r113, final a r114) {
        Intrinsics.checkNotNullParameter(r112, "templateCenterSource");
        Intrinsics.checkNotNullParameter(r113, GXTemplateKey.GAIAX_TEMPLATE_TYPE);
        Intrinsics.checkNotNullParameter(r114, "callback");
        boolean r101 = false;
        if (r100 == 8) goto L5;
    L13:
        if (r101 == true) goto L16;
        g(r114, new TemplateUtils$buildSetTemplatePreviewUrlAsync$1(r100, r110, r111, r112, r113));
        return;
    L16:
        if (r110 != null) goto L18;
        String r102 = "";
    L19:
        m(r102, new TemplateUtils$buildSetTemplatePreviewUrlAsync$2(r114, r100, r110, r111, r112, r113));
        return;
    L18:
        r102 = r110;
        goto L19
    L5:
        if (r110 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
        r101 = true;
        goto L13
    L7:
        if (StringsKt.isBlank(r110) == true) goto L10;
        r103 = false;
        goto L11
    }

    public static void h(TemplateV4 r210, TemplateCenterViewModel r211, List r212, String r213, String r214, Function0 r215) {
        Intrinsics.checkNotNullParameter(r210, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r211, "templateCenterViewModel");
        Intrinsics.checkNotNullParameter(r213, "templateCenterSource");
        Intrinsics.checkNotNullParameter(r214, "keywords");
        Intrinsics.checkNotNullParameter(r215, "canNavigate");
        LinkedList r110 = new LinkedList();
        if (r212 != null) goto L32;
        int r111 = 0;
    L26:
        String r100 = TemplateReportV2.f238770c;
        String r101 = TemplateReportV2.f238773f;
        String r102 = r211.getCurrentTabTag();
        String r103 = r211.getCreateSelectResult().f216826c;
        String r112 = r211.getModule();
        String r113 = r211.getSpaceId();
        CreateSelectResult.a r104 = CreateSelectResult.CREATOR;
        CreateSelectResult r114 = r211.getCreateSelectResult();
        r104.getClass();
        CommonPreviewTemplateData r105 = new CommonPreviewTemplateData(r100, r213, r101, r102, r103, r112, r113, CreateSelectResult.a.d(r114), r111, r214, r110);
        LinkedHashMap r106 = new LinkedHashMap();
        r106.put(DocViewModel.KEY_TEMPLATE_PREVIEW_LIST, JSON.toJSONString(r105));
        RouteBean r107 = new RouteBean();
        r107.f236638c = 1;
        r107.f236646k = r106;
        if (((Boolean) f238777b.getValue()).booleanValue() == false) goto L29;
        String r108 = "";
    L30:
        r107.f236645j = r108;
        c(r210.getObjType(), r210.getObjToken(), r211.getCurrentTabTag(), new c(r215, r211, r107));
        return;
    L29:
        r108 = "scene_template";
        goto L30
    L32:
        Iterator r109 = r212.iterator();     // Catch: ConcurrentModificationException -> L21
        int r115 = 0;
        int r116 = 0;
    L34:
    L19:
        e = e;
    L23:
        tt5.a.f("TemplateUtils", e, false);
    L24:
        r111 = r115;
        goto L26
    L7:
        if (r109.hasNext() == false) goto L24;
        Iterator<T> r117 = ((ao5.a) r109.next()).f15786c.iterator();     // Catch: ConcurrentModificationException -> L19
    L10:
        if (r117.hasNext() == false) goto L34;
        TemplateV4 r118 = (TemplateV4) r117.next();     // Catch: ConcurrentModificationException -> L19
        if (r118.isSceneTemplate() == true) goto L10;
        if (TextUtils.isEmpty(r118.getObjToken()) == true) goto L10;
        int r216 = r116;
        r110.add(new Item(r118.getObjToken(), r118.getName(), r118.getObjType(), r118.getSource(), r216, r118.getId()));     // Catch: ConcurrentModificationException -> L19
        if (r210 != r118) goto L18;
        r115 = r116;
    L18:
        r116 = r116 + 1;
    L21:
        e = e;
        r115 = 0;
        goto L23
    }

    public static /* synthetic */ void i(TemplateUtils r100, TemplateV4 r101, TemplateCenterViewModel r110, List r111, String r112, Function0 r113, int r114) {
        String r102 = "";
        if ((r114 & 8) == 0) goto L5;
        String r103 = "";
    L7:
        if ((r114 & 16) != 0) goto L10;
        r102 = null;
    L10:
        String r104 = r102;
        if ((r114 & 32) == 0) goto L13;
        r113 = TemplateUtils$handlePreviewTemplate$1.INSTANCE;
    L13:
        r100.getClass();
        h(r101, r110, r111, r103, r104, r113);
        return;
    L5:
        r103 = r112;
        goto L7
    }

    public static /* synthetic */ void f(TemplateUtils r100, int r101, String r110, String r111, String r112, String r113, a r114, int r115) {
        if ((r115 & 8) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r115 & 16) == 0) goto L9;
        String r103 = "";
    L10:
        r100.getClass();
        e(r101, r110, r111, r102, r103, r114);
        return;
    L9:
        r103 = r113;
        goto L10
    L5:
        r102 = r112;
        goto L7
    }
}
