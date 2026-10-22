package com.bytedance.ee.bear.templates.horizontal;

import android.os.Bundle;
import android.os.IBinder;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.ee.bear.templates.TemplateReportV2;
import com.bytedance.ee.bear.templates.TemplateUtils;
import com.bytedance.ee.bear.templates.bean.SelectTemplateConfig;
import com.bytedance.ee.bear.templates.data.TemplateV4;
import com.bytedance.ee.bear.templates.dto.BinderISelectTemplateCallback;
import com.bytedance.ee.bear.templates.preview.data.Item;
import com.bytedance.ee.bear.templates.preview.single.common.CustomTemplateCreator;
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
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 B2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001BB_\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000208H\u0002J\b\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u00020\u0004H\u0014J\b\u0010<\u001a\u000208H\u0016J\u0018\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020.H\u0016J\b\u0010@\u001a\u000208H\u0016J\u0010\u0010A\u001a\u0002082\u0006\u00105\u001a\u00020\u0006H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0013\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010#R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010#R\u0011\u0010\u0016\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000606X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplatePresenter;", "Lcom/larksuite/framework/mvp/BasePresenter;", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IModel;", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IView;", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IView$IViewDelegate;", "Landroidx/lifecycle/Observer;", "", "model", "Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateModel;", "view", "fragment", "Landroidx/fragment/app/Fragment;", "categoryId", "", "pageSize", "", "module", "", "subModule", "parentToken", "isFolder", "isFromEmpty", "showSize", "<init>", "(Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateModel;Lcom/bytedance/ee/bear/templates/horizontal/HorizontalTemplateContract$IView;Landroidx/fragment/app/Fragment;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZI)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "getCategoryId", "()J", "getPageSize", "()I", "getModule", "()Ljava/lang/String;", "getSubModule", "getParentToken", "()Z", "getShowSize", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable$delegate", "Lkotlin/Lazy;", "hasData", "dataList", "", "Lcom/bytedance/ee/bear/templates/data/TemplateV4;", "binderCallback", "Lcom/bytedance/ee/bear/templates/dto/BinderISelectTemplateCallback$Stub;", "selectTemplateConfig", "Lcom/bytedance/ee/bear/templates/bean/SelectTemplateConfig;", "customTemplateCreator", "Lcom/bytedance/ee/bear/templates/preview/single/common/CustomTemplateCreator;", "previewActive", "Landroidx/lifecycle/MutableLiveData;", "create", "", "loadData", "observeNetwork", "createViewDelegate", "onMoreClicked", "onTemplateSelected", "position", ThumbGlideUrl.SOURCE_TEMPLATE, "destroy", "onChanged", "Companion", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HorizontalTemplatePresenter extends BasePresenter<com.bytedance.ee.bear.templates.horizontal.a, com.bytedance.ee.bear.templates.horizontal.b, com.bytedance.ee.bear.templates.horizontal.b.a> implements com.bytedance.ee.bear.templates.horizontal.b.a, Observer<Boolean> {
    public final Fragment a;
    public final long b;
    public final int c;
    public final Lazy d;
    public boolean e;
    public List<TemplateV4> f;
    public BinderISelectTemplateCallback.Stub g;
    public SelectTemplateConfig h;
    public CustomTemplateCreator i;
    public final MutableLiveData<Boolean> j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ HorizontalTemplatePresenter a;

        public b(HorizontalTemplatePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            HorizontalTemplates r6 = (HorizontalTemplates) r5;
            if (r6.getSource() == 2) goto L5;
        L12:
            boolean r3 = true;
            this.a.e = !r6.getTemplates().isEmpty();
            this.a.f = r6.getTemplates();
            tt5.a.h("HorizontalTemplatePresenter", "start showTemplates hasData=" + this.a.e + " source=" + r6.getSource() + " size=" + r6.getTemplates().size() + " hasMore=" + r6.getHasMore());
            if (this.a.e == true) goto L20;
            if (r6.getSource() != 2) goto L20;
            BinderISelectTemplateCallback.Stub r0 = this.a.g;
            if (r0 == null) goto L20;
            r0.onError(1);
        L20:
            if (r6.getTemplates().size() <= this.a.c) goto L22;
            List<TemplateV4> r7 = r6.getTemplates().subList(0, this.a.c);
        L23:
            Intrinsics.checkNotNull(r7);
            ((com.bytedance.ee.bear.templates.horizontal.b) this.a.getView()).F5(r7, r3);
            return;
        L22:
            r7 = r6.getTemplates();
            r3 = false;
            goto L23
        L5:
            if (r6.getErr() == null) goto L12;
            HorizontalTemplatePresenter r1 = this.a;
            if (r1.e == true) goto L25;
            BinderISelectTemplateCallback.Stub r2 = r1.g;
            if (r2 == null) goto L11;
            r2.onError(-1);
        L11:
            ((com.bytedance.ee.bear.templates.horizontal.b) this.a.getView()).E(r6.getErr());
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ HorizontalTemplatePresenter a;

        public c(HorizontalTemplatePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "t");
            tt5.a.f("HorizontalTemplatePresenter", r4, false);
            BinderISelectTemplateCallback.Stub r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.onError(-1);
        L5:
            ((com.bytedance.ee.bear.templates.horizontal.b) this.a.getView()).E(r4);
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return this;
    }

    public final void H8() {
        ((CompositeDisposable) this.d.getValue()).clear();
        Disposable r0 = ((com.bytedance.ee.bear.templates.horizontal.a) getModel()).K().subscribe(new b(this), new c(this));
        ((CompositeDisposable) this.d.getValue()).add(r0);
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b.a
    public final void o() {
        RouteBean r0 = new RouteBean();
        r0.a(this.a);
        PostCard r1 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).yd("/list/template4/activity", r0).f("categoryId", this.b).m(536870912).c("key_template_select_callback_bundle", this.a.getArguments());
        SelectTemplateConfig r2 = this.h;
        if (r2 == null) goto L5;
        String r3 = r2.c;
    L6:
        PostCard r4 = r1.i("fromAppLink", r3);
        SelectTemplateConfig r5 = this.h;
        if (r5 == null) goto L9;
        String r6 = r5.c;
    L10:
        r4.i("template_source", r6).e();
        TemplateReportV2 r7 = TemplateReportV2.a;
        TemplateReportV2.g("click_template_systemcenter", null);
        return;
    L9:
        r6 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public final void create() {
        super.create();
        Bundle r0 = this.a.getArguments();
        SelectTemplateConfig r1 = null;
        if (r0 == null) goto L5;
        IBinder r2 = r0.getBinder("key_template_select_callback");
    L7:
        if ((r2 instanceof BinderISelectTemplateCallback.Stub) == false) goto L9;
        this.g = (BinderISelectTemplateCallback.Stub) r2;
    L10:
        Bundle r3 = this.a.getArguments();
        if (r3 == null) goto L13;
        r1 = (SelectTemplateConfig) r3.getParcelable("key_template_select_template_config");
    L13:
        this.h = r1;
        this.i = new CustomTemplateCreator(this.g, this.h);
        ((com.bytedance.ee.bear.templates.horizontal.b) getView()).d();
        H8();
        com.bytedance.ee.bear.contract.j.a.a.a().observe(this.a, new f(this));
        this.j.observe(this.a, this);
        return;
    L9:
        tt5.a.k("HorizontalTemplatePresenter", "cb=" + r2);
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    public final void destroy() {
        super.destroy();
        if (((CompositeDisposable) this.d.getValue()).isDisposed() == true) goto L5;
        ((CompositeDisposable) this.d.getValue()).dispose();
    L5:
        this.j.removeObservers(this.a);
    }

    public final void onChanged(Object r3) {
        tt5.a.h("HorizontalTemplatePresenter", "previewActive ret=" + ((Boolean) r3).booleanValue());
    }

    @Override // com.bytedance.ee.bear.templates.horizontal.b.a
    public final void L(int r10, TemplateV4 r11) {
        Intrinsics.checkNotNullParameter(r11, ThumbGlideUrl.SOURCE_TEMPLATE);
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
        tt5.a.h("HorizontalTemplatePresenter", "onTemplateSelected offline");
        Toast.showFailureText(this.a.getContext(), 2131887937);
        return;
    L6:
        SelectTemplateConfig r0 = this.h;
        if (r0 == null) goto L11;
        boolean r2 = true;
        if (r0.d != true) goto L11;
    L12:
        if (r2 == false) goto L21;
        tt5.a.h("HorizontalTemplatePresenter", "enablePreviewDetail true");
        ArrayList r12 = new ArrayList();
        if (hu5.a.d(this.f) == true) goto L19;
        List<TemplateV4> r5 = this.f;
        if (r5 != null) goto L18;
        return;
    L18:
        r12.add(new ao5.a(null, false, r5, 0, 123));
    L20:
        TemplateUtils r1 = TemplateUtils.a;
        Bundle r3 = this.a.getArguments();
        Function0<Boolean> r4 = new HorizontalTemplatePresenter$onTemplateSelected$1(this);
        r1.getClass();
        TemplateUtils.j(r11, r12, r3, r4);
        TemplateReportV2 r13 = TemplateReportV2.a;
        TemplateReportV2.g("click_vc_template", r11);
        return;
    L19:
        tt5.a.d("HorizontalTemplatePresenter", "onTemplateSelected dataList is empty");
        goto L20
    L21:
        tt5.a.h("HorizontalTemplatePresenter", "enablePreviewDetail false, customTemplateCreator=" + this.i);
        CustomTemplateCreator r6 = this.i;
        if (r6 == null) goto L26;
        r6.a(new Item(r11.getObjToken(), r11.getName(), r11.getObjType(), 0, r10, r11.getId()), null, this.j);
        return;
    L26:
        return;
    L11:
        r2 = false;
        goto L12
    }

    public HorizontalTemplatePresenter(HorizontalTemplateModel r2, g r3, Fragment r4, long r5, String r7, String r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "fragment");
        Intrinsics.checkNotNullParameter(r7, "module");
        Intrinsics.checkNotNullParameter(r8, "subModule");
        Intrinsics.checkNotNullParameter(r9, "parentToken");
        super(r2, r3);
        this.a = r4;
        this.b = r5;
        this.c = r10;
        this.d = LazyKt.lazy(HorizontalTemplatePresenter$compositeDisposable$2.INSTANCE);
        this.j = new MutableLiveData();
    }
}
