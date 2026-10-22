package com.ss.android.lark.forwardv2.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import butterknife.ButterKnife;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;
import com.ss.android.lark.desktopmode.base.FloatWindowParams;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.forwardv2.dto.ForwardTemplate;
import com.ss.android.lark.forwardv2.dto.template.ForwardFeature;
import com.ss.android.lark.forwardv2.dto.template.IForwardCancelListener;
import com.ss.android.lark.forwardv2.dto.template.IForwardProxyExecutor;
import com.ss.android.lark.forwardv2.e;
import com.ss.android.lark.forwardv2.impl.statistics.ForwardHitpointExtraParams$Scene;
import com.ss.android.lark.forwardv2.impl.view.BaseForwardView;
import com.ss.android.lark.forwardv2.impl.view.d0;
import com.ss.android.lark.forwardv3.utils.ForwardDataUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import hib.d;
import java.util.Collections;

/* JADX INFO: loaded from: classes36.dex */
public class ForwardPickFragment extends DesktopCompatFragment<FloatWindowParams> implements com.ss.android.lark.ui.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f424893h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f424894d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ForwardPresenter f424895e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ForwardTemplate f424896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f424897g;

    public class a implements BaseForwardView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ForwardPickFragment f424898a;

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void c() {
            ForwardTemplate r100 = this.f424898a.f424896f;
            if (r100 == null) goto L5;
            ForwardFeature r101 = r100.f424787c;
        L5:
            d r102 = e.f424890a;
            e.a.a().b(this.f424898a);
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void finish() {
            if (this.f424898a.getActivity() != null) goto L6;
            Log.e("ForwardPickFragment", "fragment context is null");
            return;
        L6:
            ForwardPickFragment r100 = this.f424898a;
            int r101 = ForwardPickFragment.f424893h;
            r100.T90();
        }

        public final FragmentActivity g() {
            return this.f424898a.getActivity();
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public Context getContext() {
            return this.f424898a.requireContext();
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final FragmentManager getFragmentManager() {
            return this.f424898a.getChildFragmentManager();
        }

        public a(ForwardPickFragment r100) {
            this.f424898a = r100;
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void b(String r100) {
            SearchChatInfo r101 = ForwardDataUtils.c(r100);
            if (r101 == null) goto L6;
            final ForwardPresenter r102 = this.f424898a.f424895e;
            r102.f424900a.s(Collections.singletonList(r101), ForwardHitpointExtraParams$Scene.GROUP_CREATE_FROM_FORWARD.getValue());
            d r103 = e.f424890a;
            d r104 = e.a.a();
            r101.getId();
            r104.e(new ForwardPresenter.AnonymousClass6(r102));
            return;
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void e(iib.c r100) {
            ButterKnife.bind(r100, this.f424898a.getView());
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void f(Bundle r100) {
            if ((this.f424898a.getParentFragment() instanceof com.ss.android.lark.ui.b) == false) goto L6;
            ((com.ss.android.lark.ui.b) this.f424898a.getParentFragment()).Sl("updateTitleBar");
            return;
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void a(Context r100, String r101) {
            e.d().a(r100, r101);
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public final void d(int r100, Intent r101) {
            if (r101 != null) goto L4;
            r101 = new Intent();
        L4:
            ForwardPickFragment r102 = this.f424898a;
            if (r101.getExtras() != null) goto L7;
            Bundle r103 = new Bundle();
        L8:
            zab.a.b(r102, r100, r103);
            return;
        L7:
            r103 = r101.getExtras();
            goto L8
        }

        @Override // com.ss.android.lark.forwardv2.impl.view.BaseForwardView.c
        public void setResult(int r100, Intent r101) {
            if (this.f424898a.getActivity() != null) goto L7;
            Log.e("ForwardPickFragment", "fragment context is null");
            return;
        L7:
            if (DesktopUtil.a(this.f424898a.getActivity()) == false) goto L11;
            ForwardPickFragment r102 = this.f424898a;
            if (r102.f424896f.f424792h.f424848a != 0) goto L11;
            r102.setResult(r100, r101);
            return;
        L11:
            this.f424898a.getActivity().setResult(r100, r101);
        }
    }

    public final boolean onBackPressed() {
        ForwardTemplate r100 = this.f424896f;
        if (r100 != null) goto L5;
        return false;
    L5:
        ForwardFeature r101 = r100.f424787c;
        if (r101 != null) goto L8;
        return false;
    L8:
        IForwardCancelListener r102 = r101.f424837m;
        if (r102 == null) goto L12;
        r102.onCancel();
    L12:
        if (r101.f424833i == false) goto L19;
        FragmentActivity r103 = getActivity();
        if (r103 != null) goto L16;
        return false;
    L16:
        if (isAdded() == false) goto L21;
        r103.moveTaskToBack(true);
        T90();
        return true;
    L21:
        return false;
    L19:
        return false;
    }

    public ForwardPickFragment() {
        this.f424894d = new a(this);
        this.f424897g = 0;
    }

    public final void T90() {
        g r100 = f.b(this);
        if (r100 == null) goto L5;
        r100.g(null);
        return;
    L5:
        com.ss.android.lark.ui.component_container.a.d(this, null);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ForwardPresenter r100 = this.f424895e;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        KeyboardUtils.hideKeyboard(getContext());
    }

    @Override // com.ss.android.lark.ui.b
    public final void Sl(String r100) {
        if (r100.equals("multiSelect") == false) goto L5;
        d0 r101 = this.f424895e.f424900a;
        r101.f424954d.s3(r101.f424956f);
        return;
    L5:
        if (r100.equals("onCancel") == false) goto L11;
        this.f424895e.f424900a.onCancelClick();
        this.f424895e.f424901b.a3();
        this.f424895e.f424900a.k();
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(final Bundle r100) {
        qqb.c.c(new com.ss.android.lark.forwardv2.impl.a(this, r100));
    }

    public static void S90(ForwardPickFragment r100, Bundle r101) {
        super.onActivityCreated(r101);
        Bundle r102 = r100.getArguments();
        if (r102 != null) goto L5;
        r100.T90();
        return;
    L5:
        r100.f424896f = (ForwardTemplate) r102.getParcelable("parcelable_forward_template");
        r100.f424897g = r102.getLong(ILoadStallMonitor.START_TIME);
        ForwardTemplate r103 = r100.f424896f;
        if (r103 != null) goto L8;
    L33:
        r100.T90();
        Log.i("ForwardPickFragment", "onActivityCreated return, Forwardpresenter has not been initialized");
        return;
    L8:
        if (r103.f424787c != null) goto L10;
    L26:
        boolean r104 = false;
    L27:
        if (r104 == false) goto L33;
        r100.getActivity();
        IForwardProxyExecutor r105 = r103.f424795k;
        if (r105 == null) goto L32;
        r105.w();
    L32:
        ForwardPresenter r106 = new ForwardPresenter(r100.f424897g, r100.getActivity(), r100.f424896f, r100.f424894d, r100);
        r100.f424895e = r106;
        r106.create();
        return;
    L10:
        if (r103.f424785a == null) goto L26;
        if (r103.f424786b == null) goto L26;
        if (r103.f424794j != null) goto L18;
        if (r103.f424795k == null) goto L26;
    L18:
        if (r103.f424789e == null) goto L26;
        if (r103.f424788d == null) goto L26;
        if (r103.f424790f == null) goto L26;
        if (r103.f424792h == null) goto L26;
        r104 = true;
        goto L27
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        ForwardPresenter r103 = this.f424895e;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 != 1911) goto L16;
        com.ss.android.lark.forwardv3.plugins.f r104 = r103.f424904e;
        if (r104 != null) goto L10;
        return;
    L10:
        if (r104.b("forward_at_plugin") == null) goto L15;
        r103.f424904e.b("forward_at_plugin").a(r102);
        return;
    L15:
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return r100.inflate(R.layout.activity_forward_pick_chat, r101, false);
    }
}
