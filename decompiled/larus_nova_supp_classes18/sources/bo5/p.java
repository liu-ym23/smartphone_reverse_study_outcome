package bo5;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.document.template.TemplateTypeSwitchItemV2;
import com.bytedance.ee.bear.document.templatePlugin.GroupTemplatePreviewPlugin;
import com.bytedance.ee.bear.list.create.g0;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.templates.BaseAnnounceTemplateViewModel;
import com.bytedance.ee.bear.templates.bean.SceneTemplateData;
import com.bytedance.ee.bear.templates.bean.SimpleTemplateRequest;
import com.bytedance.ee.bear.templates.preview.announce.AnnounceTemplateViewModel;
import com.bytedance.ee.bear.templates.recommend.NewRecommendTemplateFragment;
import com.bytedance.ee.bear.templates.recommend.NewRecommendTemplateViewModel;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.integrator.ccm.CCMApiImpl;
import io.reactivex.Flowable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p implements wn5.a {
    public boolean a;

    @Override // wn5.a
    public final void k() {
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/list/template4/activity").e();
    }

    public p() {
        this.a = false;
    }

    @Override // wn5.a
    public final void d(FragmentActivity r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        View r3 = r2.findViewById(2131388346);
        if (r3 == null) goto L8;
        r3.setVisibility(0);
        return;
    }

    @Override // wn5.a
    public final void e(FragmentActivity r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        View r3 = r2.findViewById(2131388346);
        if (r3 == null) goto L8;
        r3.setVisibility(8);
        return;
    }

    @Override // wn5.a
    public final BaseAnnounceTemplateViewModel i(PluginHost r2) {
        return (BaseAnnounceTemplateViewModel) new ViewModelProvider(r2).get(AnnounceTemplateViewModel.class);
    }

    @Override // wn5.a
    public final Flowable<SceneTemplateData> j(String r3) {
        NetService.f r0 = new NetService.f("/space/api/platform/template/preview_template_collection/");
        ((NetService.e) r0).c = 2;
        r0.b("collection_id", r3);
        NetService r4 = (NetService) org.koin.java.a.a(NetService.class);
        int r1 = co5.a.a;
        return r4.Vc(new l()).a(r0).map(new m());
    }

    @Override // wn5.a
    public final boolean o(int r3) {
        return q(new NetService.ServerErrorException(r3, "", "", ""));
    }

    @Override // wn5.a
    public final LiveData p(FragmentActivity r2) {
        return ((NewRecommendTemplateViewModel) ViewModelProviders.of(r2).get(NewRecommendTemplateViewModel.class)).m586getSelectedTemplate();
    }

    @Override // wn5.a
    public final boolean q(Throwable r4) {
        if (k0.c(r4) == false) goto L6;
        return true;
    L6:
        if ((r4 instanceof NetService.ServerErrorException) == false) goto L34;
        int r5 = ((NetService.ServerErrorException) r4).getCode();
        if (((t) org.koin.java.a.a(t.class)).l(r5, null) == false) goto L11;
        return true;
    L11:
        if (r5 != 600) goto L14;
        UDToast.show(eu5.b.a, 2131887357);
        return true;
    L14:
        if (r5 != 10002) goto L16;
    L33:
        UDToast.show(eu5.b.a, 2131887997);
        return true;
    L16:
        if (r5 == 10007) goto L33;
        if (r5 != 10006) goto L22;
        UDToast.show(eu5.b.a, 2131887112);
        return true;
    L22:
        if (r5 != 210020001) goto L25;
        UDToast.show(eu5.b.a, 2131887439);
        return true;
    L25:
        if (r5 != 210020002) goto L28;
        UDToast.show(eu5.b.a, 2131889777);
        return true;
    L28:
        if (r5 != 90003088) goto L31;
        UDToast.show(eu5.b.a, 2131889780);
        return true;
    L31:
        if (r5 != 602134072) goto L34;
        UDToast.show(eu5.b.a, 2131889750);
        return true;
    L34:
        return false;
    }

    @Override // wn5.a
    public final void r(yn5.c r6) {
        int r1 = com.bytedance.ee.bear.templates.g.a;     // Catch: JSONException -> L13
        boolean r2 = true;
        if (r6.f != 1) goto L6;
        boolean r3 = true;
    L7:
        JSONObject r7 = s(r3, r6);     // Catch: JSONException -> L13
        com.bytedance.ee.bear.contract.d r4 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: JSONException -> L13
        if (r3 == false) goto L11;
        r2 = false;
    L11:
        r4.d("ccm_template_content_page_view", r7, r2);     // Catch: JSONException -> L13
        return;
    L6:
        r3 = false;
    L13:
        e = move-exception;
        tt5.a.e("TemplatesImpl", "reportTemplateDocShow()...error = ", e, false);
    }

    public static JSONObject s(boolean r4, yn5.c r5) throws JSONException {
        int r0 = com.bytedance.ee.bear.templates.g.a;
        int r1 = r5.f;
        if (r1 != 1) goto L5;
        String r2 = "pgc";
    L9:
        JSONObject r3 = new JSONObject();
        String r6 = r5.a;
        if (r4 == true) goto L13;
        r6 = du5.b.g(r6);
    L13:
        r3.put("template_token", r6);
        String r7 = r5.b;
        if (r4 == true) goto L17;
        r7 = du5.b.g(r7);
    L17:
        r3.put("template_name", r7);
        r3.put("template_type", r2);
        r3.put("file_id", du5.b.g(r5.c));
        r3.put("file_type", r5.d);
        r3.put("source", r5.e);
        int r8 = r5.d;
        if (r5.g == false) goto L20;
        String r9 = DocumentType.WIKI_NAME;
    L21:
        r3.put("module", r9);
        return r3;
    L20:
        r9 = sbb.e.c(r8);
        goto L21
    L5:
        if (r1 == 2) goto L7;
        r2 = "egc";
        goto L9
    L7:
        r2 = "ugc";
        goto L9
    }

    @Override // wn5.a
    public final Fragment c(Context r5, yn5.b r6) {
        int r0 = NewRecommendTemplateFragment.l;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "params");
        Bundle r1 = new Bundle();
        String r2 = r6.a;
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.putString("extra_parent_token", r2);
        String r4 = r6.b;
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1.putString("extra_module", r4);
        String r7 = r6.c;
        if (r7 == null) goto L12;
        r3 = r7;
    L12:
        r1.putString("extra_sub_module", r3);
        r1.putBoolean("key_is_folder", r6.d);
        r1.putBoolean("key_is_from_empty", r6.e);
        r1.putBoolean("extra_show_title_bg", r6.f);
        CreateSelectResult.a r8 = CreateSelectResult.CREATOR;
        String r9 = r6.g;
        r8.getClass();
        r1.putParcelable("CREATION_LOCATION", CreateSelectResult.a.c(r9));
        r1.putString("SPACE_ID", r6.h);
        return Fragment.instantiate(r5, NewRecommendTemplateFragment.class.getName(), r1);
    }

    @Override // wn5.a
    public final void n(String r7, yn5.c r8) {
        int r2 = com.bytedance.ee.bear.templates.g.a;     // Catch: JSONException -> L13
        boolean r3 = true;
        if (r8.f != 1) goto L6;
        boolean r4 = true;
    L7:
        JSONObject r5 = s(r4, r8);     // Catch: JSONException -> L13
        r5.put("create_file_type", r8.h);     // Catch: JSONException -> L13
        r5.put("click", r7);     // Catch: JSONException -> L13
        com.bytedance.ee.bear.contract.d r9 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);     // Catch: JSONException -> L13
        if (r4 == false) goto L11;
        r3 = false;
    L11:
        r9.d("ccm_template_content_page_click", r5, r3);     // Catch: JSONException -> L13
        return;
    L6:
        r4 = false;
    L13:
        e = move-exception;
        tt5.a.e("TemplatesImpl", "reportTemplateBannerClick()...error = ", e, false);
    }

    public final void u(final com.bytedance.ee.bear.templates.dto.d r3, NetService.f r4) {
        ((NetService) org.koin.java.a.a(NetService.class)).Vc(new a()).a(r4).subscribe(new b(this, r3), new e(this, r3));
    }

    @Override // wn5.a
    public final void a(FragmentActivity r5, yn5.e r6, com.bytedance.ee.bear.templates.dto.d r7) {
        if (r6.d == false) goto L5;
        com.bytedance.ee.bear.bizwidget.d r0 = new com.bytedance.ee.bear.bizwidget.d(r5);
        r0.e = 2131887993;
        r0.b();
    L6:
        NetService.f r8 = new NetService.f("/api/obj_template/create/");
        ((NetService.e) r8).c = 1;
        r8.b("obj_type", String.valueOf(r6.getType()));
        r8.b(ResourceData.KEY_OBJ_TOKEN, r6.b);
        r8.b("obj_template_name", r6.c);
        r8.b("new_custom_fg", r6.e);
        HashMap r1 = new HashMap();
        r1.put("time_zone", zu5.b.c());
        r8.b("extra_info", JSON.toJSONString(r1));
        u(new o(r7, r0, r6), r8);
        return;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [bo5.h, java.lang.Object] */
    @Override // wn5.a
    public final co5.h f(Activity r6, ViewGroup r7, yn5.a r8) {
        GroupTemplatePreviewPlugin.e r0 = GroupTemplatePreviewPlugin.e.a;
        int r1 = co5.e.e;
        ?? r2 = new h();
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "vg");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r2, "cb");
        co5.e r3 = new co5.e(r6, new SceneTemplateData(), r8.b, r8.c);
        ((wn5.a) org.koin.java.a.c(wn5.a.class, null, null, 6)).j(r8.a).subscribe(new co5.c(r6, r3, r7, r2), co5.d.a);
        return new co5.h(r3);
    }

    @Override // wn5.a
    public final Flowable<SimpleTemplateRequest.SimpleTemplateInfo> l(String r3, String r4, int r5) {
        NetService.f r0 = new NetService.f("/space/api/platform/template/template_info_v2/");
        ((NetService.e) r0).c = 2;
        r0.b("template_id", r3);
        r0.b(ResourceData.KEY_OBJ_TOKEN, r4);
        r0.b("obj_type", String.valueOf(r5));
        NetService r6 = (NetService) org.koin.java.a.a(NetService.class);
        int r7 = com.bytedance.ee.bear.templates.d.a;
        return r6.Vc(new c()).a(r0).map(new d());
    }

    @Override // wn5.a
    public final void m(int r3, String r4, TemplateTypeSwitchItemV2.c r5) {
        NetService.f r0 = new NetService.f("/api/obj_template/delete/");
        ((NetService.e) r0).c = 1;
        r0.b("obj_type", String.valueOf(r3));
        r0.b(ResourceData.KEY_OBJ_TOKEN, r4);
        r0.b("new_custom_fg", "1");
        u(new n(r5), r0);
    }

    @Override // wn5.a
    public final void b(String r16, String r17, String r18, final CCMApiImpl.f r19) {
        tt5.a.b("TemplatesImpl", "createDocByTemplate objToken:" + r16 + " docType：" + r17 + " templateId:" + r18);
        new g0().b(new com.bytedance.ee.bear.list.create.l(r16, na5.a.a(r17), "", false, "", false, r18, null, CreateSelectResult.b())).subscribe(new f(this, r19), new g(this, r19));
    }

    @Override // wn5.a
    public final void g(FragmentActivity r15, String r16, int r17, yn5.d r18, com.bytedance.ee.bear.document.tips.d r19) {
        t(r15, r16, r17, "template_banner_tag", null, null, "", "", "", false, "", r18, r19);
    }

    @Override // wn5.a
    public final void h(FragmentActivity r15, String r16, int r17, String r18, String r19, String r20, String r21, String r22, String r23, boolean r24, String r25, com.bytedance.ee.bear.templates.dto.e r26) {
        t(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, null, r26);
    }

    public final void t(FragmentActivity r17, final String r18, final int r19, String r20, String r21, final String r22, String r23, String r24, String r25, boolean r26, String r27, yn5.d r28, final com.bytedance.ee.bear.templates.dto.e r29) {
        if (this.a == false) goto L6;
        tt5.a.h("TemplatesImpl", "createTemplateIng is true");
        return;
    L6:
        this.a = true;
        final com.bytedance.ee.bear.bizwidget.d r4 = new com.bytedance.ee.bear.bizwidget.d(r17);
        r4.e = 2131887993;
        r4.b();
        if (TextUtils.isEmpty(r25) == false) goto L9;
        CreateSelectResult r5 = CreateSelectResult.b();
    L10:
        CreateSelectResult r15 = r5;
        g0 r6 = new g0();
        com.bytedance.ee.bear.list.create.l r14 = new com.bytedance.ee.bear.list.create.l(r18, r19, r24, false, r20, !TextUtils.isEmpty(r21), r21, r22, r15);
        r14.o = null;
        Intrinsics.checkNotNullParameter(r27, "<set-?>");
        r14.n = r27;
        if (r28 == null) goto L13;
        r14.p = new er5.c(r28.a, r28.b);
    L13:
        r6.b(r14).doOnTerminate(new i(this, r4)).subscribe(new j(this, r22, r29), new k(this, r18, r19));
        return;
    L9:
        CreateSelectResult.CREATOR.getClass();
        r5 = CreateSelectResult.a.a(r25, r23, r26, r27);
        goto L10
    }
}
