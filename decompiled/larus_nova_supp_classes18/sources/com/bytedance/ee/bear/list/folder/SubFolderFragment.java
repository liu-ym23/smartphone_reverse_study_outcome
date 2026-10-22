package com.bytedance.ee.bear.list.folder;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.document.a4;
import com.bytedance.ee.bear.facade.common.widget.ForbiddenBannerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.list.multiselect.ListSelectPanelAction;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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
import uc5.d1;
import uc5.d2;
import uc5.e4;
import uc5.g1;
import uc5.k;
import uc5.y3;
import uc5.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SubFolderFragment extends z1 implements d2, d0c.c, ed5.d, wc5.e, ed5.e {
    public View g;
    public h h;
    public i i;
    public SmartRefreshLayout j;
    public boolean k;
    public String l;
    public String m;
    public int n;
    public String o;
    public String p;
    public boolean q;
    public boolean r;

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
        i r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.E.a == false) goto L7;
        return true;
    }

    @Override // uc5.d2
    public final void finish() {
        tt5.a.h("SubFolderFragment", "finish()...");
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
        tt5.a.h("SubFolderFragment", "onPageSelected()");
        h r0 = this.h;
        if (r0 != null) goto L6;
        tt5.a.k("SubFolderFragment", "onPageSelected() before presenter ready, cache refresh for later.");
        this.k = true;
        return;
    L6:
        r0.onRefresh();
    }

    @Override // ed5.d
    public final void xk() {
        i r0 = this.i;
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

    @Override // uc5.z1
    public Context getContext() {
        return ContextsKt.findActivity(super.getContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        tt5.a.h("SubFolderFragment", "onDestroy()...");
        this.k = false;
        h r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        h r0 = this.h;
        if (r0 == null) goto L6;
        r0.onResume();
        return;
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m15provideComponent() {
        return provideComponent();
    }

    public SubFolderFragment() {
    }

    @Override // wc5.e
    public final void Co(SmartRefreshLayout r3) {
        StringBuilder r0 = new StringBuilder("setRefreshLayout()...hasRefreshLayout = ");
        if (r3 == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        tt5.a.h("SubFolderFragment", r0.toString());
        this.j = r3;
        i r2 = this.i;
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
        i r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.q instanceof ed5.c) == false) goto L13;
        if (r3 != null) goto L8;
        return;
    L8:
        if (r0.E.a == false) goto L15;
        r0.F.f(r3);
        r0.F3();
        return;
    L15:
        return;
    }

    @Override // ed5.e
    public final void c10(int r3) {
        i r0 = this.i;
        if ((r0 instanceof ed5.e) == false) goto L6;
        r0.c10(r3);
        return;
    }

    @Override // wc5.e
    public final void d2(cqa.h r2) {
        tt5.a.h("SubFolderFragment", "onRefresh()...");
        h r3 = this.h;
        if (r3 == null) goto L6;
        r3.onRefresh();
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        tt5.a.h("SubFolderFragment", "onCreate()...");
        Bundle r5 = getArguments();
        if (r5 == null) goto L6;
        this.l = r5.getString(ResourceData.KEY_TOKEN, "");
        this.m = r5.getString("title", getString(2131887757));
        this.n = r5.getInt("depth", 0);
        this.q = r5.getBoolean("is_external");
        this.r = r5.getBoolean("is_personal_folder");
        this.o = r5.getString("current_module", "");
        this.p = r5.getString("parent_token", "");
        return;
    }

    @Override // ed5.d
    public final void sT(Document r3) {
        i r0 = this.i;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0.q instanceof ed5.c) == false) goto L10;
        r0.F.b(r3);
        r0.F3();
        return;
    }

    @Override // wc5.e
    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        tt5.a.h("SubFolderFragment", "setUserVisibleHint()...isVisibleToUser = " + r3);
        h r0 = this.h;
        if (r0 == null) goto L6;
        r0.setUserVisibleHint(r3);
        return;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        super.onViewCreated(r14, r15);
        tt5.a.h("SubFolderFragment", "initMVP()...");
        ce5.a r16 = new ce5.a(this);
        this.i = new i(getContext(), this.g, this, this.l, this.m, this.q, this.r, this.o, this.p, this.n, r16);
        y3 r2 = new y3(this, getContext(), this.l, r16);
        h r11 = new h(this.i, r2, getContext(), this, this.l, this.r, this.n, this.o, this, r16);
        this.h = r11;
        r11.create();
        if (this.j == null) goto L6;
        tt5.a.h("SubFolderFragment", "initMVP()...apply pending refresh layout after view ready.");
        this.i.J3(this.j);
    L6:
        if (this.k == false) goto L9;
        tt5.a.h("SubFolderFragment", "initMVP()...consume pending onPageSelected refresh.");
        this.k = false;
        this.h.onRefresh();
        return;
    }

    @Override // ed5.d
    public final boolean KL(ListSelectPanelAction r11, List<Document> r12, ed5.g r13) {
        boolean r1 = false;
        if (hu5.a.d(r12) == false) goto L6;
        return false;
    L6:
        if (r12.size() < 2) goto L76;
        if (r11 != ListSelectPanelAction.DELETE_SOURCE) goto L76;
        final h r14 = this.h;
        if (r14 != null) goto L12;
        return false;
    L12:
        ArrayList r15 = new ArrayList(r12);
        tt5.a.h("SubFolderPresenter", "onMultiDeleteClick()...selectedSize = " + r15.size());
        if (hu5.a.d(r15) == false) goto L16;
    L74:
        return true;
    L16:
        if (t0.b(r14.a, g1.c(r15), "batch_delete") == true) goto L74;
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
        goto L74
    L35:
        final ArrayList<String> r19 = g1.a(r15);
        if (hu5.a.d(r19) == false) goto L38;
        Context r110 = r14.a;
        Toast.showFailureText(r110, r110.getResources().getString(2131887737), 0);
        goto L74
    L38:
        final ArrayList r3 = new ArrayList(r15);
        boolean r111 = AppInfoUtils.f().booleanValue();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("lark.scs.legalhold.delete") == false) goto L41;
        int r4 = 60;
    L42:
        String r5 = String.valueOf(r4);
        if (r111 == false) goto L45;
        String r6 = r14.a.getString(2131889414);
    L50:
        if (r111 == false) goto L53;
    L55:
        String r7 = "";
    L56:
        fp5.a r8 = new fp5.a(r14.a);
        if (r111 == false) goto L59;
        String r9 = r14.a.getResources().getQuantityString(2131755035, r19.size(), new Object[]{Integer.valueOf(r19.size())});
    L60:
        fp5.a r10 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r8.title(r9)).titleSize(16)).titleGravity(8388611)).message(r6)).messageGravity(8388611);
        r10.b(r7);
        r10.e = false;
        UDBaseDialogBuilder.ActionBuilder r20 = new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).textColorRes(2131102093);
        if (r111 == false) goto L63;
        int r21 = 2131889413;
    L64:
        fp5.a r112 = (fp5.a) r10.addActionButton(r20.text(r21).onClickListener(new e4(r14, r3, r19)));
        if (r111 == false) goto L67;
        int r113 = 2131888904;
    L68:
        Dialog r114 = ((fp5.a) r112.addActionButton(2131391778, r113, null)).build();
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L90;
        DialogLancet.handleBlockedDialogShow(r114);
    L73:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).s(r114);
        goto L74
    L90:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L89
    L72:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        goto L73
    L67:
        r113 = 2131887716;
        goto L68
    L63:
        r21 = 2131887736;
        goto L64
    L59:
        r9 = r14.a.getString(2131889601);
        goto L60
    L53:
        if (g1.b(r3) == false) goto L55;
        r7 = r14.a.getString(2131889585);
        goto L56
    L45:
        Context r22 = r14.a;
        if (g1.b(r3) == false) goto L48;
        int r23 = 2131887253;
    L49:
        r6 = xo5.a.c(r22, r23, "num", r5);
        goto L50
    L48:
        r23 = 2131889588;
        goto L49
    L41:
        r4 = 30;
    L31:
        r17 = false;
    L76:
        if ((this.i instanceof com.bytedance.ee.bear.list.list.d.b) == true) goto L78;
    L88:
        return false;
    L78:
        if (r12.size() != 1) goto L88;
        if (r11 == ListSelectPanelAction.SHARE) goto L83;
        return false;
    L83:
        Document r115 = (Document) ListProtector.get(r12, 0);
        if (r13.a == false) goto L86;
        r1 = true;
    L86:
        this.i.B0(this.g, -1, r115, r1);
        return true;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r3, r4, r5);
        h r6 = this.h;
        if (r6 == null) goto L11;
        r6.getClass();
        tt5.a.h("SubFolderPresenter", "onActivityResult()...requestCode = " + r3 + ", resultCode = " + r4);
        if (r3 == 1) goto L7;
        return;
    L7:
        if (r4 != (-1)) goto L9;
        ((e) r6.getView()).f0(ForbiddenBannerView.ForbiddenState.IN_COMPLAINT);
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
