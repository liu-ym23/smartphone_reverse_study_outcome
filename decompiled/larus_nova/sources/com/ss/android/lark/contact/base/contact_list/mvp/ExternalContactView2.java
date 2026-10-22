package com.ss.android.lark.contact.base.contact_list.mvp;

import android.content.Context;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.loading.LKUIStatus;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.contact.base.common_ui.IndexBar;
import com.ss.android.lark.contact.base.contact_list.page.ExternalContactFragment2;
import com.ss.android.lark.contact.base.contact_list.view.ExternalContactAdapter2;
import com.ss.android.lark.contact.base.contact_list.view.FloatingBarItemDecoration;
import com.ss.android.lark.contact.base.contact_list.view.IndexRecyclerViewAdapter;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.dynamicconfig.interfaces.IFeatureSwitchService$FeatureKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.q;
import com.ss.android.lark.widget.ChatWindowPtrLoadingHeader;
import com.ss.android.lark.widget.ptr.LKUIPtrClassicFrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class ExternalContactView2 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f418577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f418578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m.a f418579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ExternalContactAdapter2 f418580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LKUIStatus f418581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f418582f;

    @BindView(8807)
    View mExternalAddLayout;

    @BindView(8808)
    TextView mExternalAddTv;

    @BindView(8809)
    ViewGroup mExternalContactContentLayout;

    @BindView(8810)
    View mExternalContactEmptyLayout;

    @BindView(8811)
    ViewGroup mExternalContactLayout;

    @BindView(8813)
    RecyclerView mExternalContactRV;

    @BindView(8812)
    LKUIPtrClassicFrameLayout mPtrFrame;

    @BindView(8814)
    CommonTitleBar mTitleBar;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FloatingBarItemDecoration f418583a;

        public a() {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FrameLayout f418584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f418585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final IndexBar f418586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Vibrator f418587d;

        public b(ViewGroup r100) {
            this.f418584a = (FrameLayout) r100.findViewById(R.id.index_bar_layout);
            TextView r101 = (TextView) r100.findViewById(R.id.index_bar_tip);
            this.f418585b = r101;
            this.f418586c = (IndexBar) r100.findViewById(R.id.index_bar);
            r101.setVisibility(8);
        }
    }

    public interface c {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f418578b = null;
        this.f418579c = null;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ButterKnife.bind(this, ((ExternalContactFragment2.a) this.f418578b).f418614a.f418612e);
        this.f418577a = this.mTitleBar.getContext();
        boolean r100 = FeatureGatingModule.getFeatureGatingService().isEnable("contact.external.alphabetic.group");
        if (r100 == false) goto L14;
        yob.e.a().getClass();
        com.ss.android.lark.language.service.impl.c r101 = com.ss.android.lark.language.service.impl.c.a.f431101a;
        if (r101 == null) goto L14;
        if (r101.b() == false) goto L9;
    L12:
        boolean r102 = true;
    L13:
        this.f418582f = r102;
        goto L14
    L9:
        if (r101.c() == true) goto L12;
        r102 = false;
    L14:
        Log.i("ExternalContactView2", "isGroupFgEnable: " + r100 + ", isEnOrZhLang: " + this.f418582f);
        if (ContactBaseModuleDependency.f418857b.isSmallB() == false) goto L17;
        int r103 = R.string.Lark_Legacy_Contact;
    L18:
        this.mTitleBar.setTitle(r103);
        int r104 = com.ss.android.lark.contact.base.service.a.f418904a;
        Intrinsics.checkNotNullParameter("invite.external.enable", "featureName");
        boolean r105 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.external.enable", false);
        Intrinsics.checkNotNullParameter("invite.union.enable", "featureName");
        boolean r106 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable("invite.union.enable", false);
        Intrinsics.checkNotNullParameter(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, "featureName");
        boolean r107 = FeatureGatingModule.getFeatureGatingService().isCurrentEnable(IFeatureSwitchService$FeatureKey.SUITE_TO_C_ENABLE, false);
        Log.i("ExternalContactView2", "inviteExternalEnable: " + r105 + ", inviteUnionEnable: " + r106 + ", suiteToCEnable: " + r107);
        if (r106 == false) goto L23;
        if (r105 == true) goto L22;
        if (r107 == false) goto L23;
    L22:
        String r108 = h9b.c.a();
        this.mExternalAddLayout.setVisibility(0);
        this.mExternalAddTv.setText(r108);
        q.a(this.mExternalAddLayout);
        this.mExternalAddLayout.setOnClickListener(new com.ss.android.lark.contact.base.contact_list.mvp.b(this));
    L24:
        ChatWindowPtrLoadingHeader r109 = new ChatWindowPtrLoadingHeader(this.f418577a);
        this.mPtrFrame.setKeepHeaderWhenRefresh(true);
        this.mPtrFrame.setFooterView(r109);
        this.mPtrFrame.addPtrUIHandler(r109);
        this.mPtrFrame.disableWhenHorizontalMove(true);
        this.mExternalContactRV.setLayoutManager(new LinearLayoutManager(this.f418577a, 1, false));
        if (this.f418580d != null) goto L27;
        this.f418580d = new ExternalContactAdapter2();
    L27:
        ExternalContactAdapter2 r110 = this.f418580d;
        r110.f418616e = new g(this);
        this.mExternalContactRV.setAdapter(r110);
        if (this.f418582f == false) goto L30;
        this.f418580d.f418628c = true;
        final b r111 = new b(this.mExternalContactLayout);
        final RecyclerView r112 = this.mExternalContactRV;
        r111.f418586c.setOnTouchingLetterChangedListener(new j(r111, r112));
        ((IndexRecyclerViewAdapter) r112.getAdapter()).A2(new i(r111, r112));
        r112.addOnScrollListener(new k(r111));
        a r113 = new a();
        RecyclerView r114 = this.mExternalContactRV;
        FloatingBarItemDecoration r115 = new FloatingBarItemDecoration(r114.getContext(), this.f418580d.f418627b);
        r113.f418583a = r115;
        r114.addItemDecoration(r115);
        ((IndexRecyclerViewAdapter) r114.getAdapter()).A2(new h(r113, r114));
    L33:
        this.f418581e = new LKUIStatus(new LKUIStatus.b(this.mExternalContactContentLayout));
        return;
    L30:
        this.f418580d.f418628c = false;
        ViewGroup r116 = this.mExternalContactLayout;
        FrameLayout r117 = (FrameLayout) r116.findViewById(R.id.index_bar_layout);
        TextView r118 = (TextView) r116.findViewById(R.id.index_bar_tip);
        IndexBar r119 = (IndexBar) r116.findViewById(R.id.index_bar);
        r118.setVisibility(8);
        if (r117 == null) goto L33;
        r117.setVisibility(8);
    L23:
        this.mExternalAddLayout.setVisibility(8);
        goto L24
    L17:
        r103 = R.string.Lark_Legacy_StructureExternal;
        goto L18
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void hideLoading() {
        this.f418581e.b();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final List<w8b.a> j6() {
        ExternalContactAdapter2 r100 = this.f418580d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getItems();
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void l3() {
        this.mPtrFrame.setVisibility(8);
        this.mExternalContactEmptyLayout.setVisibility(0);
        y9c.d.k(this.mExternalContactEmptyLayout);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void showLoading() {
        LKUIStatus r100 = this.f418581e;
        r100.f284249f = r100.f284249f;
        r100.f284252i = 3;
        r100.f284244a.postDelayed(r100.f284254k, 300);
    }

    public ExternalContactView2(c r100) {
        this.f418578b = r100;
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void O6(w8b.a r100) {
        this.f418580d.remove(r100);
        if (CollectionUtils.isEmpty(this.f418580d.getItems()) == false) goto L6;
        l3();
        return;
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void Q4(Chatter r100) {
        ExternalContactFragment2.a r101 = (ExternalContactFragment2.a) this.f418578b;
        r101.getClass();
        ContactBaseModuleDependency.f418857b.jumpProfilePage(r101.f418614a.getActivity(), r100);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void o2(List<w8b.a> r100) {
        this.mPtrFrame.setVisibility(0);
        this.mExternalContactEmptyLayout.setVisibility(8);
        if (this.f418582f == false) goto L6;
        if (r100 == null) goto L6;
        Collections.sort(r100);
    L6:
        this.f418580d.clear();
        this.f418580d.addAll(r100);
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void p4(w8b.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.f558707e;
        boolean r102 = r100.f558713k;
        if (TextUtils.isEmpty(r101) == false) goto L8;
        Log.e("remove external contact failed: chatter id is empty");
        return;
    L8:
        List<w8b.a> r103 = this.f418580d.getItems();
        if (r102 == false) goto L18;
        Iterator<w8b.a> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L34;
        w8b.a r105 = r104.next();
        if (r105 == null) goto L12;
        if (TextUtils.equals(r101, r105.f558707e) == false) goto L12;
        this.f418580d.remove(r105);
    L34:
        if (CollectionUtils.isEmpty(r103) == false) goto L36;
        l3();
        return;
    L36:
        this.mPtrFrame.setVisibility(0);
        this.mExternalContactEmptyLayout.setVisibility(8);
        return;
    L18:
        int r106 = 0;
    L20:
        if (r106 >= r103.size()) goto L27;
        w8b.a r107 = (w8b.a) ListProtector.get(r103, r106);
        if (r107 == null) goto L26;
        if (TextUtils.equals(r101, r107.f558707e) == false) goto L26;
        ListProtector.set(r103, r106, r100);
        this.f418580d.notifyItemChanged(r100);
        boolean r108 = true;
    L28:
        if (r108 == true) goto L34;
        if (this.f418582f == false) goto L32;
        ArrayList r109 = new ArrayList(r103);
        r109.add(r100);
        Collections.sort(r109);
        this.f418580d.diff(r109);
        goto L34
    L32:
        this.f418580d.add(r100);
    L26:
        r106 = r106 + 1;
        goto L20
    L27:
        r108 = false;
        goto L28
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f418579c = (m.a) r100;
    }

    @Override // com.ss.android.lark.contact.base.contact_list.mvp.m
    public final void z(int r100) {
        Context r101 = this.f418577a;
        if (r101 == null) goto L6;
        UDToast.show(r101, R.string.Lark_Legacy_DeleteFail);
        return;
    }
}
