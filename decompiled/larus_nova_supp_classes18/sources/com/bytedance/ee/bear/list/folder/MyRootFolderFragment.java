package com.bytedance.ee.bear.list.folder;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import e0c.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import uc5.b3;
import uc5.d1;
import uc5.g1;
import uc5.q2;
import uc5.y1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MyRootFolderFragment extends y1 implements wc5.e, g.b, d0c.c, ed5.d, ed5.e {
    public View g;
    public f h;
    public g i;
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

    public void V90() {
        ce5.a r6 = new ce5.a(this);
        this.i = new g(getContext(), this.g, this, this, r6);
        q2 r2 = new q2(this, getContext(), r6);
        g r1 = this.i;
        Context r3 = getContext();
        Bundle r0 = getArguments();
        String r9 = null;
        if (r0 != null) goto L5;
        String r7 = null;
    L6:
        Bundle r4 = getArguments();
        if (r4 != null) goto L9;
        String r11 = "MINE";
    L10:
        f r8 = new f(r1, r2, r3, this, r6, r7, r11);
        this.h = r8;
        r8.create();
        if (this.j == null) goto L14;
        tt5.a.h("MyRootFolderFragment", "initMVP()...apply pending refresh layout after view ready.");
        this.i.J3(this.j);
    L14:
        if (this.k == false) goto L27;
        tt5.a.h("MyRootFolderFragment", "initMVP()...consume pending onPageSelected.");
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
        r11 = r4.getString("office_preload_tab", "MINE");
        goto L10
    L5:
        r7 = r0.getString("office_preload_request_key_hash");
        goto L6
    }

    public final void W90() {
        f r0 = this.h;
        boolean r2 = false;
        if (r0.B == false) goto L11;
        com.bytedance.ee.bear.list.office.preload.f r1 = r0.A;
        if (r1.a == false) goto L11;
        if (r1.b == true) goto L11;
        r2 = true;
        r1.b = true;
        tt5.a.h("OfficeSpacePreloadStarter", "office_space_preload_visible_refresh reason=after_cache_first_draw");
        f.d9(r0);
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        this.h.onRefresh();
    }

    @Override // ed5.d
    public final boolean ZT() {
        g r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.F.a == false) goto L7;
        return true;
    }

    @Override // wc5.e
    public final void onPageSelected() {
        tt5.a.h("MyRootFolderFragment", "onPageSelected()...");
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
        g r0 = this.i;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public UserSession e9() {
        if ((getActivity() instanceof d0c.c) == false) goto L7;
        return getActivity().e9();
    L7:
        return new ce5.a().b;
    }

    @Override // uc5.y1
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    @Override // com.bytedance.ee.bear.list.folder.g.b
    public final void m3() {
        if (getParentFragment() == null) goto L10;
        if (getParentFragment().getParentFragment() == null) goto L10;
        if ((getParentFragment().getParentFragment() instanceof wc5.g) == false) goto L10;
        getParentFragment().getParentFragment().onMenuCreateClick(null);
    L10:
        if ((getActivity() instanceof wc5.g) == false) goto L13;
        getActivity().onMenuCreateClick(null);
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        f r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // com.bytedance.ee.bear.list.folder.g.b
    public final void onRefresh() {
        if ((getParentFragment() instanceof wc5.d) == false) goto L6;
        getParentFragment().Cu();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        f r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m14provideComponent() {
        return provideComponent();
    }

    public MyRootFolderFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r3) {
        tt5.a.h("MyRootFolderFragment", "setRefreshLayout()...refreshLayout = " + r3);
        this.j = r3;
        g r0 = this.i;
        if (r0 == null) goto L5;
        r0.J3(r3);
        return;
    L5:
        tt5.a.h("MyRootFolderFragment", "setRefreshLayout()...view not ready, cache refresh layout.");
    }

    @Override // ed5.d
    public final void Dt(Document r2) {
        g r0 = this.i;
        if (r0 == null) goto L6;
        r0.M3(r2);
        return;
    }

    @Override // ed5.e
    public final void c10(int r3) {
        g r0 = this.i;
        if ((r0 instanceof ed5.e) == false) goto L6;
        r0.c10(r3);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r2) {
        tt5.a.h("MyRootFolderFragment", "onRefresh()...");
        f r3 = this.h;
        if (r3 == null) goto L6;
        r3.onRefresh();
        return;
    }

    @Override // ed5.d
    public final void sT(Document r2) {
        g r0 = this.i;
        if (r0 == null) goto L6;
        r0.F3(r2);
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        f r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r2);
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        V90();
    }

    @Override // com.bytedance.ee.bear.list.folder.g.b
    public final void t(int r2, int r3) {
        if ((getParentFragment() instanceof wc5.d) == false) goto L6;
        getParentFragment().t(r2, r3);
        return;
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r11, List<Document> r12, ed5.g r13) {
        if (hu5.a.d(r12) == false) goto L6;
        return false;
    L6:
        if (r12.size() < 2) goto L72;
        if (r11 != ListSelectPanelAction.DELETE_SOURCE) goto L72;
        final f r14 = this.h;
        if (r14 != null) goto L12;
        return false;
    L12:
        ArrayList r15 = new ArrayList(r12);
        tt5.a.h("MyRootFolderPresenter", "onMultiDeleteClick()...selectedSize = " + r15.size());
        if (hu5.a.d(r15) == false) goto L16;
    L70:
        return true;
    L16:
        if (t0.b(r14.a, g1.c(r15), "batch_delete") == true) goto L70;
        a4 r16 = (a4) org.koin.java.a.a(a4.class);
        Objects.requireNonNull(r16);
        if (hu5.a.d(r15) == true) goto L31;
        Iterator r0 = r15.iterator();
    L22:
        if (r0.hasNext() == false) goto L31;
        Document r2 = (Document) r0.next();
        if (r2 == null) goto L22;
        if (g1.d(r2.d) == true) goto L22;
        if (r16.c(r2.d) == false) goto L22;
        boolean r17 = true;
    L33:
        if (r17 == false) goto L35;
        Context r18 = r14.a;
        Toast.showFailureText(r18, r18.getResources().getString(2131887737), 0);
        goto L70
    L35:
        final ArrayList<String> r19 = g1.a(r15);
        if (hu5.a.d(r19) == false) goto L38;
        Context r110 = r14.a;
        Toast.showFailureText(r110, r110.getResources().getString(2131887737), 0);
        goto L70
    L38:
        final ArrayList r1 = new ArrayList(r15);
        boolean r111 = AppInfoUtils.f().booleanValue();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L41;
        int r3 = 60;
    L42:
        String r4 = String.valueOf(r3);
        if (r111 == false) goto L45;
        String r5 = r14.a.getString(2131889414);
    L46:
        if (r111 == false) goto L49;
    L51:
        String r6 = "";
    L52:
        fp5.a r7 = new fp5.a(r14.a);
        if (r111 == false) goto L55;
        String r8 = r14.a.getResources().getQuantityString(2131755035, r19.size(), new Object[]{Integer.valueOf(r19.size())});
    L56:
        fp5.a r9 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r7.title(r8)).titleSize(16)).titleGravity(8388611)).message(r5)).messageTextSize(14)).messageGravity(8388611);
        r9.b(r6);
        r9.e = false;
        UDBaseDialogBuilder.ActionBuilder r10 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (r111 == false) goto L59;
        int r20 = 2131889413;
    L60:
        fp5.a r112 = (fp5.a) r9.addActionButton(r10.text(r20).onClickListener(new b3(r14, r1, r19)));
        if (r111 == false) goto L63;
        int r113 = 2131888904;
    L64:
        Dialog r114 = ((fp5.a) r112.addActionButton(2131391778, r113, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L90;
        DialogLancet.handleBlockedDialogShow(r114);
    L69:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r114);
        goto L70
    L90:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L89
    L68:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L69
    L63:
        r113 = 2131887716;
        goto L64
    L59:
        r20 = 2131887736;
        goto L60
    L55:
        r8 = r14.a.getString(2131889601);
        goto L56
    L49:
        if (g1.b(r1) == false) goto L51;
        r6 = r14.a.getString(2131889585);
        goto L52
    L45:
        r5 = xo5.a.c(r14.a, 2131889588, "num", r4);
        goto L46
    L41:
        r3 = 30;
    L31:
        r17 = false;
    L72:
        if ((this.i instanceof com.bytedance.ee.bear.list.list.d.b) == true) goto L74;
    L88:
        return false;
    L74:
        if (r12.size() != 1) goto L88;
        Document r115 = (Document) ListProtector.get(r12, 0);
        if (r13.a == false) goto L79;
        boolean r116 = true;
    L80:
        g r21 = this.i;
        if (r11 != ListSelectPanelAction.SHARE) goto L85;
        r21.B0(this.g, -1, r115, r116);
        return true;
    L85:
        if (r11 != ListSelectPanelAction.DELETE_SOURCE) goto L88;
        r21.x0(this.g, -1, r115, r116);
        return true;
    L79:
        r116 = false;
        goto L80
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(2131563476, r3, false);
        this.g = r5;
        return r5;
    }
}
