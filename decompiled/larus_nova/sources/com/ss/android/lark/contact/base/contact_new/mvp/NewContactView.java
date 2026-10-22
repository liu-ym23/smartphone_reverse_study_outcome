package com.ss.android.lark.contact.base.contact_new.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.lark.pb.basic.v1.CertificationInfo;
import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.contact_new.page.NewContactFragment;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.q;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class NewContactView implements com.ss.android.lark.contact.base.contact_new.mvp.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f418716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.contact.base.contact_new.mvp.b.a f418717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f418718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NewContactAdapter f418719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LKUIStatus f418720e;

    @BindView(8717)
    ViewGroup mContentView;

    @BindView(9196)
    View mNewContactEmptyLayout;

    @BindView(9198)
    RecyclerView mNewContactRV;

    @BindView(9197)
    LKUIPtrClassicFrameLayout mPtrFrame;

    @BindView(9199)
    CommonTitleBar mTitleBar;

    @BindView(9193)
    RelativeLayout newContactAddExtRl;

    @BindView(9194)
    TextView newContactAddExtTv;

    @BindView(9195)
    TextView newContactSubTitleTv;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f418721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f418722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f418723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f418724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f418725e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public TenantNameStatus f418726f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f418727g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ChatApplication.Status f418728h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CertificationInfo f418729i;

        public a() {
        }

        public final boolean equals(Object r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (this != r100) goto L9;
            return true;
        L9:
            if ((r100 instanceof a) == true) goto L11;
            return false;
        L11:
            a r101 = (a) r100;
            String r102 = this.f418721a;
            if (r102 != null) goto L17;
            if (r101.f418721a != null) goto L18;
            return true;
        L18:
            return false;
        L17:
            return r102.equals(r101.f418721a);
        }
    }

    public interface b {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f418718c = null;
        this.f418717b = null;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void E6() {
        this.mContentView.setVisibility(8);
        this.mNewContactEmptyLayout.setVisibility(0);
        y9c.d.k(this.mNewContactEmptyLayout);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ButterKnife.bind(this, ((NewContactFragment.a) this.f418718c).f418758a.f418756e);
        this.f418716a = this.mTitleBar.getContext();
        this.mTitleBar.setTitle(R.string.Lark_Legacy_ContactsNew);
        this.mTitleBar.setVisibility(0);
        this.mTitleBar.setImmersive(true);
        this.mTitleBar.setLeftClickListener(new k(this));
        int r100 = com.ss.android.lark.contact.base.service.a.f418904a;
        Intrinsics.checkNotNullParameter("invite.external.enable", "featureName");
        boolean r101 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.external.enable", false);
        Intrinsics.checkNotNullParameter("invite.union.enable", "featureName");
        boolean r102 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.union.enable", false);
        Intrinsics.checkNotNullParameter(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, "featureName");
        boolean r103 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, false);
        if (r102 == false) goto L7;
        if (r101 == true) goto L6;
        if (r103 == false) goto L7;
    L6:
        this.newContactAddExtRl.setVisibility(0);
        q.a(this.newContactAddExtRl);
        this.newContactAddExtRl.setOnClickListener(new i(this));
        String r104 = h9b.c.a();
        this.newContactAddExtTv.setText(r104);
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.client.contact.opt") == false) goto L11;
        this.newContactSubTitleTv.setVisibility(0);
    L12:
        ChatWindowPtrLoadingHeader r105 = new ChatWindowPtrLoadingHeader(this.f418716a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r105);
        this.mPtrFrame.addPtrUIHandler(r105);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mPtrFrame.setPtrHandler(new l(this));
        LinearLayoutManager r106 = new LinearLayoutManager(this.f418716a, 1, false);
        this.mNewContactRV.setLayoutManager(r106);
        if (this.f418719d != null) goto L15;
        this.f418719d = new NewContactAdapter();
    L15:
        NewContactAdapter r107 = this.f418719d;
        r107.f418709b = new m(this);
        this.mNewContactRV.setAdapter(r107);
        int r108 = DesktopUtil.f420394a;
        this.f418720e = new LKUIStatus(new LKUIStatus.b(this.mContentView));
        return;
    L11:
        this.newContactSubTitleTv.setVisibility(8);
    L7:
        this.newContactAddExtRl.setVisibility(8);
        goto L9
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void hideLoading() {
        this.f418720e.b();
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void n() {
        this.mPtrFrame.refreshComplete();
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void showLoading() {
        LKUIStatus r100 = this.f418720e;
        r100.f284249f = r100.f284249f;
        r100.f284252i = 3;
        r100.f284244a.postDelayed(r100.f284254k, 300);
    }

    public NewContactView(b r100) {
        this.f418718c = r100;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void B1(List<a> r100) {
        Iterator r101 = ((ArrayList) r100).iterator();
    L4:
        if (r101.hasNext() == false) goto L28;
        a r102 = (a) r101.next();
        List<a> r103 = this.f418719d.getItems();
        if (r103.contains(r102) == false) goto L25;
        a r104 = (a) ListProtector.get(r103, r103.indexOf(r102));
        ChatApplication.Status r105 = r102.f418728h;
        r104.f418728h = r105;
        CertificationInfo r106 = r102.f418729i;
        if (r106 == null) goto L10;
        r104.f418729i = r106;
    L10:
        String r107 = r102.f418725e;
        if (r107 == null) goto L13;
        r104.f418725e = r107;
    L13:
        r104.f418726f = r102.f418726f;
        if (r105 != ChatApplication.Status.AGREED) goto L16;
    L23:
        this.f418719d.notifyItemChanged(r104);
        goto L25
    L16:
        if (r105 == ChatApplication.Status.PEDING) goto L23;
        if (r105 == ChatApplication.Status.EXPIRED) goto L23;
        if (r105 != ChatApplication.Status.DELETED) goto L25;
        this.f418719d.remove(r104);
    L25:
        if (CollectionUtils.isEmpty(r103) == true) goto L26;
        this.mContentView.setVisibility(0);
        this.mNewContactEmptyLayout.setVisibility(8);
        goto L4
    L26:
        E6();
        goto L4
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void G3(List<a> r100) {
        this.mContentView.setVisibility(0);
        this.mNewContactEmptyLayout.setVisibility(8);
        this.f418719d.addAll(r100);
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void e7(a r100) {
        this.f418719d.remove(r100);
        if (CollectionUtils.isEmpty(this.f418719d.getItems()) == false) goto L6;
        E6();
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f418717b = (com.ss.android.lark.contact.base.contact_new.mvp.b.a) r100;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void z(int r100) {
        Context r101 = this.f418716a;
        if (r101 == null) goto L6;
        UDToast.show(r101, R.string.Lark_Legacy_DeleteFail);
        return;
    }

    @Override // com.ss.android.lark.contact.base.contact_new.mvp.b
    public final void J(String r100, String r101) {
        NewContactFragment.a r102 = (NewContactFragment.a) this.f418718c;
        r102.getClass();
        ContactBaseModuleDependency.f418857b.startNewContactProfilePage(r102.f418758a.getActivity(), r100, r101);
    }
}
