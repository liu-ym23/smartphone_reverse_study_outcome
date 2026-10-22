package com.bytedance.ee.bear.templates.topic;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.center.TemplateCenterViewModel;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BaseTopicPresenter extends BasePresenter<TopicModel, e, e.a> implements e.a {
    public final Fragment a;
    public final TopicModel b;
    public final e c;
    public final CompositeDisposable d;
    public final Lazy e;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BaseTopicPresenter a;
        public final /* synthetic */ int b;

        public b(BaseTopicPresenter r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            TopicDataResult r4 = (TopicDataResult) r3;
            e r0 = this.a.c;
            Intrinsics.checkNotNull(r4);
            r0.y3(r4);
            List<TemplateV4> r5 = ((TopicData) ((Result) r4).data).getTemplates();     // Catch: Throwable -> L12
            if (r5 == null) goto L9;
            boolean r1 = true;
            if ((!r5.isEmpty()) != true) goto L9;
        L10:
            TemplateReportV2 r6 = TemplateReportV2.a;
            TemplateReportV2.f(sbb.e.d(this.b), r1, "ccm_template_banner_view_click");
            return;
        L9:
            r1 = false;
            goto L10
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BaseTopicPresenter a;

        public c(BaseTopicPresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("SearchListPresenter", "loadData err:", r5, false);
            e r0 = this.a.c;
            Intrinsics.checkNotNull(r5);
            r0.m(r5);
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    @Override // com.bytedance.ee.bear.templates.topic.e.a
    public final void onLoadFailed() {
    }

    public final void destroy() {
        super.destroy();
        if (this.d.isDisposed() == true) goto L6;
        this.d.dispose();
        return;
    }

    @Override // com.bytedance.ee.bear.templates.topic.e.a
    public final void P2(String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "topicID");
        this.c.d();
        if (StringsKt.isBlank(r5) == false) goto L5;
    L15:
        this.c.m(new RuntimeException("topic is empty"));
        return;
    L5:
        if (r5.length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L15;
        TopicModel r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "topicID");
        h r3 = new h(r6);
        NetService.d r4 = ((NetService) r2.b.getValue()).Vc(r3);
        Intrinsics.checkNotNullParameter(r5, "topicID");
        NetService.f r0 = new NetService.f("/space/api/platform/template/topic_template_list/");
        r0.b("topic_id", r5);
        r0.b("platform", "mobile");
        if (com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.template_docx", false) == false) goto L13;
        r0.b("docx_template", "1");
    L13:
        ((NetService.e) r0).c = 2;
        Disposable r7 = r4.a(r0).onErrorReturn(g.a).subscribe(new b(this, r6), new c(this));
        this.d.add(r7);
        return;
    L7:
        r1 = false;
        goto L8
    }

    public BaseTopicPresenter(Fragment r2, TopicModel r3, e r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new CompositeDisposable();
        this.e = LazyKt.lazy(new BaseTopicPresenter$templateCenterViewModel$2(this));
    }

    @Override // com.bytedance.ee.bear.templates.topic.e.a
    public final void h(int r17, TemplateV4 r18, String r19) {
        Intrinsics.checkNotNullParameter(r18, ThumbGlideUrl.SOURCE_TEMPLATE);
        tt5.a.b("SearchListPresenter", "onTemplateSelected()...template = " + r18);
        ConnectionService.NetworkState r1 = j.a.a.getNetworkState();
        boolean r3 = r1.a() ^ true;
        if (r18.getEnable() == true) goto L7;
        if (r3 == false) goto L7;
        tt5.a.h("SearchListPresenter", "create template offline, state:" + r1 + ", template enable: " + r18.getEnable());
        Toast.showFailureText(this.a.getContext(), 2131887937);
        return;
    L7:
        TemplateUtils r2 = TemplateUtils.a;
        TemplateCenterViewModel r4 = (TemplateCenterViewModel) this.e.getValue();
        ao5.a[] r5 = new ao5.a[1];
        ArrayList r12 = new ArrayList();
        List<TemplateV4> r6 = this.c.getCurrentList();
        if (r6 == null) goto L10;
        r12.addAll(r6);
    L10:
        Unit r7 = Unit.INSTANCE;
        r5[0] = new ao5.a(null, false, r12, 0, 123);
        ArrayList r8 = CollectionsKt.arrayListOf(r5);
        TemplateReportV2 r9 = TemplateReportV2.a;
        if (Intrinsics.areEqual(TemplateReportV2.d, "template_center") == false) goto L13;
        String r10 = "templatecenter_banner";
    L14:
        TemplateUtils.i(r2, r18, r4, r8, r10, new BaseTopicPresenter$onTemplateClicked$2(this), 16);
        TemplateReportV2.k(r18, new com.bytedance.ee.bear.templates.e(null, Integer.valueOf(r17), r19, null, 18));
        return;
    L13:
        r10 = "";
        goto L14
    }
}
