package com.bytedance.ee.bear.templates.scene;

import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePresenter<com.bytedance.ee.bear.templates.scene.c, d, d.a> implements d.a {
    public final Fragment a;
    public final com.bytedance.ee.bear.templates.scene.c b;
    public final d c;
    public final CompositeDisposable d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.templates.scene.a$a, reason: collision with other inner class name */
    public static final class C0189a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            TopicDataResult r3 = (TopicDataResult) r2;
            d r0 = this.a.c;
            Intrinsics.checkNotNull(r3);
            r0.a7(r3);
            ArrayList<TemplateV4> r4 = ((TopicData) ((Result) r3).data).getTemplates();     // Catch: Throwable -> L7
            if (r4 == null) goto L10;
            r4.isEmpty();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("SearchListPresenter", "loadData err:", r5, false);
            d r0 = this.a.c;
            Intrinsics.checkNotNull(r5);
            r0.m(r5);
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.scene.d.a
    public final void onLoadFailed() {
    }

    public final void destroy() {
        super.destroy();
        if (this.d.isDisposed() == true) goto L6;
        this.d.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.scene.d.a
    public final void v0(String r3) {
        Intrinsics.checkNotNullParameter(r3, "topicID");
        this.c.d();
        if (StringsKt.isBlank(r3) == false) goto L5;
    L12:
        this.c.m(new RuntimeException("topic is empty"));
        return;
    L5:
        if (r3.length() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        Disposable r4 = this.b.v0(r3).subscribe(new b(this), new c(this));
        this.d.add(r4);
        return;
    L7:
        r0 = false;
        goto L8
    }

    public a(Fragment r2, com.bytedance.ee.bear.templates.scene.c r3, d r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.ee.bear.templates.scene.d.a
    public final void h(int r6, TemplateV4 r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("SearchListPresenter", "onTemplateSelected()...template = " + r7);
        ConnectionService.NetworkState r1 = j.a.a.getNetworkState();
        boolean r3 = r1.a() ^ true;
        if (r7.getEnable() == true) goto L7;
        if (r3 == false) goto L7;
        tt5.a.h("SearchListPresenter", "create template offline, state:" + r1 + ", template enable: " + r7.getEnable());
        Toast.showFailureText(this.a.getContext(), 2131887937);
        return;
    L7:
        this.b.b4(r7);
        TemplateReportV2 r2 = TemplateReportV2.a;
        Intrinsics.checkNotNullParameter(r7, ThumbGlideUrl.SOURCE_TEMPLATE);
        JSONObject r0 = new JSONObject();
        r0.put("click_type", "use_click");
        r0.put("template_token", r7.getReportToken());
        r0.put("template_name", r7.getReportName());
        r0.put("use_source", ExportShareModel.EXPORT_SHARE_TYPE_IMAGE);
        r0.put("position_index", Integer.valueOf(r6 + 1));
        if (r8 == null) goto L10;
        r0.put("sub_template_sort", r8);
    L10:
        r0.put("create_file_type", sbb.e.c(r7.getObjType()));
        r0.put("target", "ccm_docs_page_view");
        r0.put("template_source", TemplateReportV2.c);
        r0.put("template_type", TemplateReportV2.b(r7));
        TemplateReportV2.a().o("ccm_template_banner_view_click", r0, r7.checkToken());
    }
}
