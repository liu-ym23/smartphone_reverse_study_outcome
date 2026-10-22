package com.bytedance.ee.bear.list.folder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import uc5.c1;
import uc5.d1;
import uc5.d2;
import uc5.f2;
import uc5.k;
import uc5.m0;
import uc5.x1;
import uc5.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FolderDetailFragment extends x1 implements d2, d0c.c, ed5.d, wc5.e, ed5.e {
    public View g;
    public m0 h;
    public c1 i;
    public SmartRefreshLayout j;
    public boolean k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public String q;
    public String r;
    public int s;
    public boolean t;
    public boolean u;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    @Override // ed5.d
    public final boolean ZT() {
        c1 r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.E.a == false) goto L7;
        return true;
    }

    @Override // uc5.d2
    public final void finish() {
        tt5.a.h("FolderDetailFragment", "finish()...");
        if (d1.b(this) == false) goto L11;
        k r0 = d1.a(this);
        if (r0 == null) goto L7;
        boolean r1 = r0.BX(this);
    L8:
        if (r1 == false) goto L11;
        return;
    L7:
        r1 = false;
    L11:
        if (getActivity() == null) goto L14;
        getActivity().finish();
        return;
    }

    @Override // wc5.e
    public final void onPageSelected() {
        tt5.a.h("FolderDetailFragment", "onPageSelected()");
        m0 r0 = this.h;
        if (r0 != null) goto L6;
        tt5.a.k("FolderDetailFragment", "onPageSelected() before presenter ready, cache refresh for later.");
        this.k = true;
        return;
    L6:
        r0.onRefresh();
    }

    @Override // ed5.d
    public final void xk() {
        if (this.h == null) goto L9;
        c1 r0 = this.i;
        if (r0 == null) goto L10;
        r0.j();
        return;
    L10:
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // uc5.x1
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("FolderDetailFragment", "onDestroy()...");
        this.k = false;
        m0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        m0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m11provideComponent() {
        return provideComponent();
    }

    public FolderDetailFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r3) {
        StringBuilder r0 = new StringBuilder("setRefreshLayout()...hasRefreshLayout = ");
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("FolderDetailFragment", r0.toString());
        this.j = r3;
        c1 r2 = this.i;
        if (r2 == null) goto L10;
        r2.J3(r3);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // ed5.d
    public final void Dt(Document r3) {
        if (this.h == null) goto L15;
        c1 r0 = this.i;
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0.q instanceof ed5.c) == false) goto L16;
        if (r3 != null) goto L11;
        return;
    L11:
        if (r0.E.a == false) goto L19;
        r0.F.f(r3);
        r0.F3();
        return;
    L19:
        return;
    L16:
        return;
    }

    @Override // ed5.e
    public final void c10(int r3) {
        c1 r0 = this.i;
        if ((r0 instanceof ed5.e) == false) goto L6;
        r0.c10(r3);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r2) {
        tt5.a.h("FolderDetailFragment", "onRefresh()...");
        m0 r3 = this.h;
        if (r3 == null) goto L6;
        r3.onRefresh();
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        tt5.a.h("FolderDetailFragment", "onCreate()...");
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        this.l = r5.getString(ResourceData.KEY_TOKEN, "");
        this.m = r5.getString("title", getString(2131887757));
        this.o = r5.getString("parent_space_id");
        this.p = r5.getInt("depth", 0);
        this.n = r5.getString(ResourceData.KEY_TYPE);
        this.s = r5.getInt("permission");
        this.t = r5.getBoolean("is_external");
        this.u = r5.getBoolean("is_personal_folder");
        this.q = r5.getString("current_module", "");
        this.r = r5.getString("parent_token", "");
        return;
    }

    @Override // ed5.d
    public final void sT(Document r3) {
        if (this.h == null) goto L12;
        c1 r0 = this.i;
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0.q instanceof ed5.c) == false) goto L14;
        r0.F.b(r3);
        r0.F3();
        return;
    L14:
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        tt5.a.h("FolderDetailFragment", "setUserVisibleHint()...isVisibleToUser = " + r3);
        m0 r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r3);
        return;
    }

    public final void onViewCreated(View r17, Bundle r18) {
        super.onViewCreated(r17, r18);
        tt5.a.h("FolderDetailFragment", "initMVP()...");
        ce5.a r15 = new ce5.a(this);
        this.i = new c1(getContext(), this.g, this, this.l, this.m, this.s, this.t, this.u, this.q, this.r, this.p, r15);
        y r6 = new y(this, getContext(), this.l, this.n, r15);
        m0 r11 = new m0(this.i, r6, getContext(), this, this.l, this.p, this.o, this.q, this, r15);
        this.h = r11;
        r11.create();
        if (this.j == null) goto L5;
        String r1 = "FolderDetailFragment";
        tt5.a.h(r1, "initMVP()...apply pending refresh layout after view ready.");
        this.i.J3(this.j);
    L7:
        if (this.k == false) goto L10;
        tt5.a.h(r1, "initMVP()...consume pending onPageSelected refresh.");
        this.k = false;
        this.h.onRefresh();
        return;
    L10:
        return;
    L5:
        r1 = "FolderDetailFragment";
        goto L7
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r6, List<Document> r7, ed5.g r8) {
        if ((this.i instanceof com.bytedance.ee.bear.list.list.d.b) == false) goto L20;
        if (r7 == null) goto L20;
        if (r7.size() != 1) goto L20;
        Document r9 = (Document) ListProtector.get(r7, 0);
        if (r8.a == false) goto L11;
        boolean r10 = true;
    L12:
        c1 r0 = this.i;
        if (r6 != ListSelectPanelAction.SHARE) goto L17;
        r0.B0(this.g, -1, r9, r10);
        return true;
    L17:
        if (r6 != ListSelectPanelAction.DELETE_SOURCE) goto L20;
        r0.x0(this.g, -1, r9, r10);
        return true;
    L11:
        r10 = false;
    L20:
        return false;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        m0 r6 = this.h;
        if (r6 == null) goto L11;
        r6.getClass();
        tt5.a.h("FolderDetailPresenter", "onActivityResult()...requestCode = " + r3 + ", resultCode = " + r4);
        if (r3 == 1) goto L7;
        return;
    L7:
        if (r4 != (-1)) goto L9;
        ((f2) r6.getView()).f0(ForbiddenBannerView.ForbiddenState.IN_COMPLAINT);
        return;
    L9:
        r6.onRefresh();
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563486, r3, false);
        this.g = r5;
        return r5;
    }
}
