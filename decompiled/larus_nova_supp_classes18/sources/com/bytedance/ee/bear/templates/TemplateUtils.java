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
import com.bytedance.ee.bear.DocContainerInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.preview.data.CommonPreviewTemplateData;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TemplateUtils {
    public static final TemplateUtils a = null;
    public static final Lazy b = null;

    public interface a {
        void onResult(String r1);
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function0<String> b;

        public b(a r1, Function0<String> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onResult((String) this.b.invoke());     // Catch: Throwable -> L4
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
        public final /* synthetic */ Function0<Boolean> a;
        public final /* synthetic */ TemplateCenterViewModel b;
        public final /* synthetic */ RouteBean c;

        public c(Function0<Boolean> r1, TemplateCenterViewModel r2, RouteBean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r4) {
            Intrinsics.checkNotNullParameter(r4, "previewUrl");
            if (((Boolean) this.a.invoke()).booleanValue() == true) goto L6;
            return;
        L6:
            if (this.b.isOnlyNewLarkForm() == false) goto L8;
            r4 = UriProtector.parse(r4).buildUpon().appendQueryParameter("larkForm", "1").appendQueryParameter("isTemplatePreview", "true").build().toString();
        L8:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r4, this.c);
        }
    }

    public static final class d implements a {
        public final /* synthetic */ Function0<Boolean> a;
        public final /* synthetic */ RouteBean b;

        public d(Function0<Boolean> r1, RouteBean r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.ee.bear.templates.TemplateUtils.a
        public final void onResult(String r4) {
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_URL);
            if (((Boolean) this.a.invoke()).booleanValue() == true) goto L5;
            return;
        L5:
            ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r4, this.b);
        }
    }

    public static final class e implements bn4.a.a {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ Runnable c;
        public final /* synthetic */ Function0<Unit> d;

        public final void onResult(boolean r3) {
            tt5.a.h("TemplateUtils", "prepareBitablePreviewPathAsync. isApp: " + r3);
            if (this.a.compareAndSet(false, true) == false) goto L6;
            this.b.removeCallbacks(this.c);
            this.d.invoke();
            return;
        }

        public e(AtomicBoolean r1, Handler r2, f r3, Function0 r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Function0<Unit> b;

        public f(AtomicBoolean r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
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
            if (this.a.compareAndSet(false, true) == false) goto L9;
            tt5.a.k("TemplateUtils", "prepareBitablePreviewPathAsync timeout");     // Catch: Throwable -> L6
            this.b.invoke();     // Catch: Throwable -> L6
            return;
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ com.bytedance.ee.bear.templates.c b;
        public final /* synthetic */ Function0<Unit> c;

        public g(Context r1, com.bytedance.ee.bear.templates.c r2, Function0<Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            TemplateUtils r4 = TemplateUtils.a;
            Context r0 = this.a;
            com.bytedance.ee.bear.templates.c r1 = this.b;
            r4.getClass();
            TemplateUtils.o(r0, r1);
            this.c.invoke();
        }
    }

    public static final class h implements View.OnClickListener {
        public final /* synthetic */ com.bytedance.ee.bear.templates.c a;

        public h(com.bytedance.ee.bear.templates.c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            TemplateUtils r4 = TemplateUtils.a;
            com.bytedance.ee.bear.templates.c r0 = this.a;
            int r1 = r0.a;
            String r2 = r0.b;
            r4.getClass();
            TemplateUtils.k(r1, r2);
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ com.bytedance.ee.bear.templates.c c;
        public final /* synthetic */ Function0<Unit> d;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ Function0<Unit> a;
            public final /* synthetic */ com.bytedance.ee.bear.templates.c b;
            public final /* synthetic */ Function0<Unit> c;

            public a(Function0<Unit> r1, com.bytedance.ee.bear.templates.c r2, Function0<Unit> r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r5, int r6) {
                this.a.invoke();
                TemplateUtils r7 = TemplateUtils.a;
                NetService r8 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
                com.bytedance.ee.bear.templates.c r0 = this.b;
                int r1 = r0.a;
                String r2 = r0.b;
                Function0<Unit> r3 = this.c;
                r7.getClass();
                TemplateReport.b("click_delete");
                NetService.f r9 = new NetService.f("/api/obj_template/delete/");
                ((NetService.e) r9).c = 1;
                r9.b("obj_type", String.valueOf(r1));
                r9.b(ResourceData.KEY_OBJ_TOKEN, r2);
                r8.Vc(com.bytedance.ee.bear.templates.i.a).a(r9).subscribe(new com.bytedance.ee.bear.templates.j(r3), com.bytedance.ee.bear.templates.k.a);
            }
        }

        public i(Context r1, Function0<Unit> r2, com.bytedance.ee.bear.templates.c r3, Function0<Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Context r6 = this.a;
            Intrinsics.checkNotNullParameter(r6, "context");
            UDDialogBuilder r0 = new UDDialogBuilder(r6);
            r0.autoDismiss(true);
            r0.title(2131887888);
            r0.message(2131887887);
            a r7 = new a(this.b, this.c, this.d);
            r0.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887736).textColorRes(2131102093).onClickListener(r7));
            r0.addActionButton(2131391778, 2131887716, null);
            UDDialog r8 = r0.build();
            if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r8);
            return;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r8);
            r8.show();
            DialogLancet.afterDialogShow(r8);
        }
    }

    public static final class j<T1, T2, R> implements BiFunction {
        public final /* synthetic */ com.bytedance.ee.bear.templates.c a;

        public j(com.bytedance.ee.bear.templates.c r1) {
            this.a = r1;
        }

        public final Object apply(Object r3, Object r4) {
            DocMetaInfo r5 = (DocMetaInfo) r3;
            DocContainerInfo r6 = (DocContainerInfo) r4;
            Intrinsics.checkNotNullParameter(r5, "docMetaInfo");
            Intrinsics.checkNotNullParameter(r6, "docContainerInfo");
            com.bytedance.ee.bear.templates.c.a r0 = this.a.f;
            int r7 = r6.getBiz_type();
            int r1 = com.bytedance.ee.bear.a.a;
            if (r7 != 2) goto L5;
            boolean r8 = true;
        L6:
            r0.a = r8;
            return r5;
        L5:
            r8 = false;
            goto L6
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ com.bytedance.ee.bear.templates.c b;
        public final /* synthetic */ String c;

        public k(Context r1, com.bytedance.ee.bear.templates.c r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            DocMetaInfo r5 = (DocMetaInfo) r4;
            if (r5.getUrl().length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            TemplateUtils r1 = TemplateUtils.a;
            Context r2 = this.a;
            com.bytedance.ee.bear.templates.c r3 = this.b;
            String r6 = r5.getUrl();
            r1.getClass();
            TemplateUtils.l(r2, r3, r6);
            return;
        L8:
            TemplateUtils r7 = TemplateUtils.a;
            Context r8 = this.a;
            com.bytedance.ee.bear.templates.c r9 = this.b;
            String r10 = this.c;
            r7.getClass();
            TemplateUtils.l(r8, r9, r10);
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ Context a;
        public final /* synthetic */ com.bytedance.ee.bear.templates.c b;
        public final /* synthetic */ String c;

        public l(Context r1, com.bytedance.ee.bear.templates.c r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TemplateUtils r6 = TemplateUtils.a;
            Context r0 = this.a;
            com.bytedance.ee.bear.templates.c r1 = this.b;
            String r2 = this.c;
            r6.getClass();
            TemplateUtils.l(r0, r1, r2);
        }
    }

    public TemplateUtils() {
    }

    static {
        a = new TemplateUtils();
        b = LazyKt.lazy(TemplateUtils$isDowngradeForsetiTemplatePreview$2.INSTANCE);
    }

    public static void g(a r2, Function0 r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.onResult((String) r3.invoke());
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new b(r2, r3));
    }

    public static void k(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "objToken");
        String r5 = p.a().ua(sbb.e.d(r3).getType(), r4, "");
        RouteBean r6 = new RouteBean();
        r6.c = 1;
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(r5, r6);
    }

    public static void m(String r7, Function0 r8) {
        AtomicBoolean r0 = new AtomicBoolean(false);
        Handler r2 = new Handler(Looper.getMainLooper());
        f r3 = new f(r0, r8);
        r2.postDelayed(r3, 10000);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L5
        ((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).o(r7, new e(r0, r2, r3, r8));     // Catch: Throwable -> L5
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L15;
        tt5.a.e("TemplateUtils", "prepareBitablePreviewPathAsync", r10, false);
        if (r0.compareAndSet(false, true) == false) goto L16;
        r2.removeCallbacks(r3);
        r8.invoke();
        return;
    L16:
        return;
    L15:
        return;
    L5:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static void o(Context r6, com.bytedance.ee.bear.templates.c r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "params");
        String r0 = p.a().ua(sbb.e.d(r7.a).getType(), r7.b, "");
        Flowable.zip(((a4) org.koin.java.a.c(a4.class, null, null, 6)).b(r7.b, r7.a), ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).d(r7.b, r7.a), new j(r7)).subscribe(new k(r6, r7, r0), new l(r6, r7, r0));
    }

    public static ArrayList a(JSONObject r8, Locale r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "templatesObject");
        Intrinsics.checkNotNullParameter(r9, "locale");
        ArrayList r0 = new ArrayList();
        if (r8.has("2") == false) goto L5;
        int r2 = n.a;
        ArrayList r1 = n.b(JSONObjectProtectorUtils.getJSONArray(r8, "2"), null, r9, r10);
    L7:
        if (r8.has("3") == false) goto L9;
        int r4 = n.a;
        ArrayList r3 = n.b(JSONObjectProtectorUtils.getJSONArray(r8, "3"), null, r9, r10);
    L11:
        if (r8.has("11") == false) goto L13;
        int r5 = n.a;
        ArrayList r6 = n.b(JSONObjectProtectorUtils.getJSONArray(r8, "11"), null, r9, r10);
    L15:
        if (r8.has("8") == false) goto L17;
        int r7 = n.a;
        ArrayList r11 = n.b(JSONObjectProtectorUtils.getJSONArray(r8, "8"), null, r9, r10);
    L19:
        if (r8.has("22") == false) goto L21;
        int r12 = n.a;
        ArrayList r13 = n.b(JSONObjectProtectorUtils.getJSONArray(r8, "22"), null, r9, r10);
    L22:
        r0.addAll(r1);
        r0.addAll(r3);
        r0.addAll(r6);
        r0.addAll(r11);
        r0.addAll(r13);
        return r0;
    L21:
        r13 = new ArrayList();
        goto L22
    L17:
        r11 = new ArrayList();
        goto L19
    L13:
        r6 = new ArrayList();
        goto L15
    L9:
        r3 = new ArrayList();
        goto L11
    L5:
        r1 = new ArrayList();
        goto L7
    }

    public static String b(int r3, String r4, String r5) {
        return p.a().Le(sbb.e.d(r3).getType(), r4, MapsKt.mapOf(new Pair[]{TuplesKt.to("from", "template_preview"), TuplesKt.to("template_preview_source", r5)}));
    }

    public static void l(Context r3, com.bytedance.ee.bear.templates.c r4, String r5) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        ShareParams r6 = new ShareParams.ShareParamsBuilder((FragmentActivity) r3, null, 2, null).source(r4.e).token(r4.b).type(r4.a).realToken(r4.b).realType(r4.a).isWiki(r4.f.a).isOwner(true).url(r5).docName(r4.c).build();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.b(r4.a) == false) goto L5;
        ((cj5.c) org.koin.java.a.c(cj5.c.class, null, null, 6)).id(r6, null);
        return;
    L5:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).aa(r6, null, null);
    }

    public static void p(Context r1, com.bytedance.ee.bear.templates.c r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r3 != null) goto L5;
    L11:
        o(r1, r2);
        return;
    L5:
        if (r3.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L11;
        l(r1, r2, r3);
        return;
    L7:
        r0 = false;
        goto L8
    }

    public static void c(final int r3, final String r4, final String r5, final a r6) {
        Intrinsics.checkNotNullParameter(r6, "callback");
        boolean r1 = false;
        if (r3 == 8) goto L5;
    L13:
        if (r1 == true) goto L16;
        g(r6, new TemplateUtils$buildPreviewTemplateUrlAsync$1(r3, r4, r5));
        return;
    L16:
        if (r4 != null) goto L18;
        String r0 = "";
    L19:
        m(r0, new TemplateUtils$buildPreviewTemplateUrlAsync$2(r6, r3, r4, r5));
        return;
    L18:
        r0 = r4;
        goto L19
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        r1 = true;
        goto L13
    L7:
        if (StringsKt.isBlank(r4) == true) goto L10;
        r2 = false;
        goto L11
    }

    public static void j(TemplateV4 r23, List r24, Bundle r25, Function0 r26) {
        Intrinsics.checkNotNullParameter(r23, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r26, "canNavigate");
        LinkedList r15 = new LinkedList();
        if (r24 != null) goto L37;
        int r13 = 0;
    L30:
        String r5 = TemplateReportV2.c;
        String r7 = TemplateReportV2.f;
        CreateSelectResult.CREATOR.getClass();
        CommonPreviewTemplateData r0 = new CommonPreviewTemplateData(r5, "", r7, "system", "", "", "", CreateSelectResult.a.d(CreateSelectResult.a.b()), r13, "", r15);
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("template_preview_list", JSON.toJSONString(r0));
        if (r25 == null) goto L33;
        r25.putString("key_template_select_template_id", r23.getId());
    L33:
        RouteBean r1 = new RouteBean();
        r1.c = 1;
        r1.k = r4;
        r1.n = r25;
        c(r23.getObjType(), r23.getObjToken(), "system", new d(r26, r1));
        return;
    L37:
        Iterator r2 = r24.iterator();     // Catch: Throwable -> L25
        int r6 = 0;
        int r8 = 0;
    L35:
    L23:
        th = th;
    L27:
        tt5.a.e("TemplateUtils", "handlePreviewTemplateForCategory", th, false);
    L28:
        r13 = r6;
        goto L30
    L7:
        if (r2.hasNext() == false) goto L28;
        Iterator<T> r9 = ((ao5.a) r2.next()).c.iterator();     // Catch: Throwable -> L23
    L10:
        if (r9.hasNext() == false) goto L35;
        TemplateV4 r10 = (TemplateV4) r9.next();     // Catch: Throwable -> L23
        if (r10.isSceneTemplate() == true) goto L10;
        if (TextUtils.isEmpty(r10.getObjToken()) == true) goto L10;
        int r21 = r8;
        Item r11 = new Item(r10.getObjToken(), r10.getName(), r10.getObjType(), r10.getSource(), r21, r10.getId());     // Catch: Throwable -> L23
        r11.setCategorySdkTemplate(true);     // Catch: Throwable -> L23
        r15.add(r11);     // Catch: Throwable -> L23
        if (TextUtils.equals(r23.getId(), r10.getId()) == true) goto L18;
    L22:
        r8 = r8 + 1;
        goto L10
    L18:
        if (TextUtils.equals(r23.getObjToken(), r10.getObjToken()) == false) goto L22;
        if (r23.getObjType() != r10.getObjType()) goto L22;
        r6 = r8;
    L25:
        th = th;
        r6 = 0;
        goto L27
    }

    public static String d(int r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "templateCenterSource");
        Intrinsics.checkNotNullParameter(r8, "templateType");
        return p.a().Le(sbb.e.d(r4).getType(), r5, MapsKt.mapOf(new Pair[]{TuplesKt.to("from", "template_preview"), TuplesKt.to("template_preview_source", "scene"), TuplesKt.to("collectionId", r6), TuplesKt.to("templateType", r8), TuplesKt.to("templatecenter_source", r7)}));
    }

    public static void n(Context r3, com.bytedance.ee.bear.templates.c r4, Function0 r5, Function0 r6, Function0 r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "shareClickListener");
        Intrinsics.checkNotNullParameter(r6, "deleteClickListener");
        Intrinsics.checkNotNullParameter(r7, "deleteSuccessListener");
        com.bytedance.ee.bear.widgets.a r0 = new com.bytedance.ee.bear.widgets.a(r3);
        r0.g(r3.getText(2131887832), new g(r3, r4, r5));
        if (r4.d == false) goto L5;
        r0.g(r3.getText(2131886354), new h(r4));
    L5:
        r0.i(r3.getText(2131887736), new i(r3, r6, r4, r7));
        r0.a();
        r0.q();
    }

    public static void e(final int r9, final String r10, final String r11, final String r12, final String r13, final a r14) {
        Intrinsics.checkNotNullParameter(r12, "templateCenterSource");
        Intrinsics.checkNotNullParameter(r13, "templateType");
        Intrinsics.checkNotNullParameter(r14, "callback");
        boolean r1 = false;
        if (r9 == 8) goto L5;
    L13:
        if (r1 == true) goto L16;
        g(r14, new TemplateUtils$buildSetTemplatePreviewUrlAsync$1(r9, r10, r11, r12, r13));
        return;
    L16:
        if (r10 != null) goto L18;
        String r0 = "";
    L19:
        m(r0, new TemplateUtils$buildSetTemplatePreviewUrlAsync$2(r14, r9, r10, r11, r12, r13));
        return;
    L18:
        r0 = r10;
        goto L19
    L5:
        if (r10 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        r1 = true;
        goto L13
    L7:
        if (StringsKt.isBlank(r10) == true) goto L10;
        r2 = false;
        goto L11
    }

    public static void h(TemplateV4 r23, TemplateCenterViewModel r24, List r25, String r26, String r27, Function0 r28) {
        Intrinsics.checkNotNullParameter(r23, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r24, "templateCenterViewModel");
        Intrinsics.checkNotNullParameter(r26, "templateCenterSource");
        Intrinsics.checkNotNullParameter(r27, "keywords");
        Intrinsics.checkNotNullParameter(r28, "canNavigate");
        LinkedList r15 = new LinkedList();
        if (r25 != null) goto L32;
        int r13 = 0;
    L26:
        String r5 = TemplateReportV2.c;
        String r7 = TemplateReportV2.f;
        String r8 = r24.getCurrentTabTag();
        String r9 = r24.getCreateSelectResult().c;
        String r10 = r24.getModule();
        String r11 = r24.getSpaceId();
        CreateSelectResult.a r4 = CreateSelectResult.CREATOR;
        CreateSelectResult r12 = r24.getCreateSelectResult();
        r4.getClass();
        CommonPreviewTemplateData r0 = new CommonPreviewTemplateData(r5, r26, r7, r8, r9, r10, r11, CreateSelectResult.a.d(r12), r13, r27, r15);
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("template_preview_list", JSON.toJSONString(r0));
        RouteBean r1 = new RouteBean();
        r1.c = 1;
        r1.k = r6;
        if (((Boolean) b.getValue()).booleanValue() == false) goto L29;
        String r14 = "";
    L30:
        r1.j = r14;
        c(r23.getObjType(), r23.getObjToken(), r24.getCurrentTabTag(), new c(r28, r24, r1));
        return;
    L29:
        r14 = "scene_template";
        goto L30
    L32:
        Iterator r2 = r25.iterator();     // Catch: ConcurrentModificationException -> L21
        int r16 = 0;
        int r17 = 0;
    L34:
    L19:
        e = e;
    L23:
        tt5.a.f("TemplateUtils", e, false);
    L24:
        r13 = r16;
        goto L26
    L7:
        if (r2.hasNext() == false) goto L24;
        Iterator<T> r18 = ((ao5.a) r2.next()).c.iterator();     // Catch: ConcurrentModificationException -> L19
    L10:
        if (r18.hasNext() == false) goto L34;
        TemplateV4 r19 = (TemplateV4) r18.next();     // Catch: ConcurrentModificationException -> L19
        if (r19.isSceneTemplate() == true) goto L10;
        if (TextUtils.isEmpty(r19.getObjToken()) == true) goto L10;
        int r21 = r17;
        r15.add(new Item(r19.getObjToken(), r19.getName(), r19.getObjType(), r19.getSource(), r21, r19.getId()));     // Catch: ConcurrentModificationException -> L19
        if (r23 != r19) goto L18;
        r16 = r17;
    L18:
        r17 = r17 + 1;
    L21:
        e = e;
        r16 = 0;
        goto L23
    }

    public static /* synthetic */ void i(TemplateUtils r8, TemplateV4 r9, TemplateCenterViewModel r10, List r11, String r12, Function0 r13, int r14) {
        String r1 = "";
        if ((r14 & 8) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r14 & 16) != 0) goto L10;
        r1 = null;
    L10:
        String r6 = r1;
        if ((r14 & 32) == 0) goto L13;
        r13 = TemplateUtils$handlePreviewTemplate$1.INSTANCE;
    L13:
        r8.getClass();
        h(r9, r10, r11, r5, r6, r13);
        return;
    L5:
        r5 = r12;
        goto L7
    }

    public static /* synthetic */ void f(TemplateUtils r8, int r9, String r10, String r11, String r12, String r13, a r14, int r15) {
        if ((r15 & 8) == 0) goto L5;
        String r5 = "";
    L7:
        if ((r15 & 16) == 0) goto L9;
        String r6 = "";
    L10:
        r8.getClass();
        e(r9, r10, r11, r5, r6, r14);
        return;
    L9:
        r6 = r13;
        goto L10
    L5:
        r5 = r12;
        goto L7
    }
}
