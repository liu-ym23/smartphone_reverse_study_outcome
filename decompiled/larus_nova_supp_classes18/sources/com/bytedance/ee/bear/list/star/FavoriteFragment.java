package com.bytedance.ee.bear.list.star;

import ae5.i;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.bear.list.office.preload.f;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import ed5.d;
import ed5.g;
import f0c.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import uc5.d1;
import wc5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FavoriteFragment extends i implements e, b.a, d0c.c, d, ed5.e {
    public View g;
    public a h;
    public b i;
    public SmartRefreshLayout j;
    public boolean k;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    private void W90() {
        a r0 = this.h;
        boolean r2 = false;
        if (r0.D == false) goto L11;
        f r1 = r0.C;
        if (r1.a == false) goto L11;
        if (r1.b == true) goto L11;
        r2 = true;
        r1.b = true;
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_visible_refresh reason=after_cache_first_draw");
        a.d9(r0);
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        this.h.onRefresh();
    }

    public void V90() {
        ce5.a r6 = new ce5.a(this);
        this.i = new b(getContext(), this.g, this, this, r6);
        ae5.d r2 = new ae5.d(this, getContext(), r6);
        b r1 = this.i;
        Context r3 = getContext();
        Bundle r0 = getArguments();
        String r9 = null;
        if (r0 != null) goto L5;
        String r7 = null;
    L6:
        Bundle r4 = getArguments();
        if (r4 != null) goto L9;
        String r11 = "FAVORITE";
    L10:
        a r8 = new a(r1, r2, r3, this, r6, r7, r11);
        this.h = r8;
        r8.create();
        if (this.j == null) goto L14;
        tt5.a.h("FavoriteFragment", "initMVP()...apply pending refresh layout after view ready.");
        this.i.Y3(this.j);
    L14:
        if (this.k == false) goto L27;
        tt5.a.h("FavoriteFragment", "initMVP()...consume pending onPageSelected.");
        boolean r5 = false;
        this.k = false;
        if (d1.b(this) == true) goto L23;
        Bundle r10 = getArguments();
        if (r10 == null) goto L22;
        r9 = r10.getString("office_preload_request_key_hash");
    L22:
        if (TextUtils.isEmpty(r9) == false) goto L23;
    L24:
        if (r5 == false) goto L28;
        W90();
        return;
    L28:
        return;
    L23:
        r5 = true;
        goto L24
    L27:
        return;
    L9:
        r11 = r4.getString("office_preload_tab", "FAVORITE");
        goto L10
    L5:
        r7 = r0.getString("office_preload_request_key_hash");
        goto L6
    }

    @Override // ed5.d
    public final boolean ZT() {
        b r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.F.a == false) goto L7;
        return true;
    }

    @Override // wc5.e
    public final void onPageSelected() {
        tt5.a.h("FavoriteFragment", "onPageSelected()...");
        if (d1.b(this) == true) goto L12;
        Bundle r0 = getArguments();
        if (r0 != null) goto L7;
        String r1 = null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        boolean r2 = false;
    L13:
        if (r2 == true) goto L16;
        return;
    L16:
        if (this.h != null) goto L19;
        this.k = true;
        return;
    L19:
        W90();
        return;
    L7:
        r1 = r0.getString("office_preload_request_key_hash");
    L12:
        r2 = true;
        goto L13
    }

    @Override // ed5.d
    public final void xk() {
        b r0 = this.i;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // ae5.i
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        a r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        a r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m53provideComponent() {
        return provideComponent();
    }

    public FavoriteFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r3) {
        tt5.a.h("FavoriteFragment", "setRefreshLayout()...refreshLayout = " + r3);
        this.j = r3;
        b r0 = this.i;
        if (r0 == null) goto L5;
        r0.Y3(r3);
        return;
    L5:
        tt5.a.h("FavoriteFragment", "setRefreshLayout()...view not ready, cache refresh layout.");
    }

    @Override // ed5.d
    public final void Dt(Document r2) {
        b r0 = this.i;
        if (r0 == null) goto L6;
        r0.Z3(r2);
        return;
    }

    @Override // ed5.e
    public final void c10(int r3) {
        b r0 = this.i;
        if ((r0 instanceof ed5.e) == false) goto L6;
        r0.c10(r3);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r2) {
        tt5.a.h("FavoriteFragment", "onRefresh()...");
        a r3 = this.h;
        if (r3 == null) goto L6;
        r3.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void sT(Document r2) {
        b r0 = this.i;
        if (r0 == null) goto L6;
        r0.F3(r2);
        return;
    }

    @Override // wc5.e
    public void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        a r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        V90();
    }

    @Override // com.bytedance.ee.bear.list.star.b.a
    public final void t(int r2, int r3) {
        if ((getParentFragment() instanceof wc5.d) == false) goto L6;
        getParentFragment().t(r2, r3);
        return;
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r6, List<Document> r7, g r8) {
        if ((this.i instanceof com.bytedance.ee.bear.list.list.d.b) == false) goto L20;
        if (r7 == null) goto L20;
        if (r7.size() != 1) goto L20;
        Document r9 = (Document) ListProtector.get(r7, 0);
        if (r8.a == false) goto L11;
        boolean r10 = true;
    L12:
        b r0 = this.i;
        if (r6 != ListSelectPanelAction.SHARE) goto L17;
        r0.B0(this.g, -1, r9, r10);
        return true;
    L17:
        if (r6 != ListSelectPanelAction.CANCEL_FAVORITE) goto L20;
        r0.x0(this.g, -1, r9, r10);
        return true;
    L11:
        r10 = false;
    L20:
        return false;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563476, r3, false);
        this.g = r5;
        return r5;
    }
}
