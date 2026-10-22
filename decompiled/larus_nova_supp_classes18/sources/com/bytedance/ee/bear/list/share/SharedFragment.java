package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SharedFragment extends m implements wc5.e, r4.a, d0c.c, ed5.d, ed5.e {
    public View g;
    public o4 h;
    public r4 i;
    public SmartRefreshLayout j;
    public boolean k;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final void V90() {
        o4 r0 = this.h;
        boolean r2 = false;
        if (r0.D == false) goto L11;
        com.bytedance.ee.bear.list.office.preload.f r1 = r0.C;
        if (r1.a == false) goto L11;
        if (r1.b == true) goto L11;
        r2 = true;
        r1.b = true;
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_visible_refresh reason=after_cache_first_draw");
        o4.d9(r0);
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        this.h.onRefresh();
    }

    @Override // ed5.d
    public final boolean ZT() {
        r4 r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.F.a == false) goto L7;
        return true;
    }

    @Override // wc5.e
    public final void onPageSelected() {
        tt5.a.h("SharedFragment", "onPageSelected()...");
        if (uc5.d1.b(this) == true) goto L12;
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
        V90();
        return;
    L7:
        r1 = r0.getString("office_preload_request_key_hash");
    L12:
        r2 = true;
        goto L13
    }

    @Override // ed5.d
    public final void xk() {
        r4 r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.F.a == false) goto L10;
        r0.G.c();
        r0.B3();
        return;
    }

    public final UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // com.bytedance.ee.bear.list.share.m
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        xk();
        super.onDestroy();
        o4 r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        o4 r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m45provideComponent() {
        return provideComponent();
    }

    public SharedFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r2) {
        this.j = r2;
        r4 r0 = this.i;
        if (r0 == null) goto L6;
        r0.I3(r2);
        return;
    }

    @Override // ed5.d
    public final void Dt(Document r3) {
        r4 r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.q instanceof ed5.c) == false) goto L13;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r0.F.a == false) goto L15;
        r0.G.f(r3);
        r0.B3();
        return;
    L15:
        return;
    }

    @Override // ed5.e
    public final void c10(int r3) {
        r4 r0 = this.i;
        if ((r0 instanceof ed5.e) == false) goto L6;
        r0.c10(r3);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r1) {
        o4 r2 = this.h;
        if (r2 == null) goto L6;
        r2.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void sT(Document r3) {
        r4 r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.q instanceof ed5.c) == false) goto L10;
        r0.G.b(r3);
        r0.B3();
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        o4 r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r11, Bundle r12) {
        super.onViewCreated(r11, r12);
        ce5.a r13 = new ce5.a(this);
        this.i = new r4(getContext(), this.g, this, this, r13);
        i4 r2 = new i4(this, getContext(), r13);
        r4 r1 = this.i;
        Context r3 = getContext();
        Bundle r0 = getArguments();
        String r8 = null;
        if (r0 != null) goto L5;
        String r6 = null;
    L6:
        Bundle r4 = getArguments();
        if (r4 != null) goto L9;
        String r7 = "SHARED";
    L10:
        o4 r14 = new o4(r1, r2, r3, this, r13, r6, r7);
        this.h = r14;
        r14.create();
        SmartRefreshLayout r15 = this.j;
        if (r15 == null) goto L14;
        this.i.I3(r15);
    L14:
        if (this.k == false) goto L27;
        tt5.a.h("SharedFragment", "initMVP()...consume pending onPageSelected.");
        boolean r16 = false;
        this.k = false;
        if (uc5.d1.b(this) == true) goto L23;
        Bundle r17 = getArguments();
        if (r17 == null) goto L22;
        r8 = r17.getString("office_preload_request_key_hash");
    L22:
        if (TextUtils.isEmpty(r8) == false) goto L23;
    L24:
        if (r16 == false) goto L28;
        V90();
        return;
    L28:
        return;
    L23:
        r16 = true;
        goto L24
    L27:
        return;
    L9:
        r7 = r4.getString("office_preload_tab", "SHARED");
        goto L10
    L5:
        r6 = r0.getString("office_preload_request_key_hash");
        goto L6
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r5, List<Document> r6, ed5.g r7) {
        if ((this.i instanceof com.bytedance.ee.bear.list.list.d.b) == false) goto L16;
        if (r6 == null) goto L16;
        if (r6.size() != 1) goto L16;
        Document r8 = (Document) ListProtector.get(r6, 0);
        if (r7.a == false) goto L11;
        boolean r9 = true;
    L12:
        r4 r0 = this.i;
        if (r5 != ListSelectPanelAction.SHARE) goto L16;
        r0.B0(this.g, -1, r8, r9);
        return true;
    L11:
        r9 = false;
    L16:
        return false;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563476, r3, false);
        this.g = r5;
        return r5;
    }
}
