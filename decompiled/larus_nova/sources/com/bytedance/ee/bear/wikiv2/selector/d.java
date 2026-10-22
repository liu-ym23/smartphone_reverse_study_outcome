package com.bytedance.ee.bear.wikiv2.selector;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.folderselect.command.d0;
import com.bytedance.ee.bear.list.folderselect.command.k0;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.list.selector.SelectorType;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import io.reactivex.disposables.CompositeDisposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends BasePresenter<iq5.m, m, m.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.b f241150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final iq5.m f241151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f241152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f241153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final td5.b f241154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f241155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f241156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f241157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f241158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f241159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f241160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f241161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f241162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SelectorConfig f241163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Bundle f241164o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f241165p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final rc5.a f241166q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ce5.a f241167r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ShareFolderUserPermission f241168s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CompositeDisposable f241169t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public td5.d f241170u;

    public static final class a {
    }

    public final class b implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f241171a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f241172a = null;

            static {
                int[] r100 = new int[SelectorType.values().length];
                r100[SelectorType.SPACE_SELECT_FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L27:
                r100[SelectorType.SPACE_SAVE_TEMPLATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L43:
                r100[SelectorType.SPACE_ADD_SHORTCUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L31:
                r100[SelectorType.SPACE_ADD_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
            L35:
                r100[SelectorType.SPACE_MOVE_TO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
            L25:
                r100[SelectorType.SPACE_MAKE_COPY_TO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
            L37:
                r100[SelectorType.WIKI_MOVE_TO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
            L39:
                r100[SelectorType.WIKI_SHORTCUT_TO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
            L29:
                r100[SelectorType.WIKI_MAKE_COPY_TO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
            L33:
                r100[SelectorType.WIKI_CREATE_TO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
            L13:
                f241172a = r100;
            }
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void M7() {
            tt5.a.h("FolderSelectPresenter", "onCreateFolderClick()...");
            d r100 = this.f241171a;
            r100.getClass();
            tt5.a.h("FolderSelectPresenter", "createFolder()...");
            boolean r101 = true;
            String r102 = null;
            if ((!com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a()) == false) goto L9;
            tt5.a.h("FolderSelectPresenter", "createFolder()...failed for offline.");
            Context r103 = r100.f241153d;
            if (r103 == null) goto L7;
            r102 = r103.getString(R.string.Doc_List_OperateFailedNoNet);
        L7:
            Toast.showFailureText(r103, r102, 0);
            return;
        L9:
            if (r100.f241157h != 4) goto L11;
        L14:
            boolean r104 = true;
        L15:
            if (r104 == true) goto L22;
            ShareFolderUserPermission r105 = r100.f241168s;
            if (r105 != null) goto L19;
        L21:
            r101 = false;
            goto L22
        L19:
            if (r100.f241150a.u(r105, "CREATE_SUB_NODE").booleanValue() == false) goto L21;
        L22:
            if (r101 == true) goto L27;
            tt5.a.h("FolderSelectPresenter", "createFolder()...failed for no permission");
            Context r106 = r100.f241153d;
            if (r106 == null) goto L26;
            r102 = r106.getString(R.string.LarkCCM_Wiki_NoPerms_NewFolder_Tooltip);
        L26:
            Toast.showFailureText(r106, r102);
            return;
        L27:
            FragmentActivity r107 = r100.f241155f.getActivity();
            if (r107 == null) goto L33;
            r100.f241169t.add(r100.f241151b.Y5(r107).subscribe(new iq5.f(r100), new iq5.g(r100, r107)));
            return;
        L33:
            return;
        L11:
            if (r100.f241160k == false) goto L14;
            r104 = false;
            goto L15
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void Z3() {
            tt5.a.h("FolderSelectPresenter", "onBtnBackClick()...");
            this.f241171a.f241154e.back();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void d2() {
            tt5.a.h("FolderSelectPresenter", "onBtnOperateClick()...");
            SelectorType r100 = this.f241171a.f241163n.f229369a;
            switch(a.f241172a[r100.ordinal()]) {
                case 1: goto L27;
                case 2: goto L26;
                case 3: goto L25;
                case 4: goto L24;
                case 5: goto L23;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L7;
                case 10: goto L6;
                default: goto L5;
            };
        L6:
            d r101 = this.f241171a;
            Context r102 = r101.getContext();
            d r103 = this.f241171a;
            r101.f241170u = new com.bytedance.ee.bear.wikiv2.wikitreev2.create.w(r102, r103.f241168s, r103.f241156g, r103.f241159j, r103.f241164o, r103.f241154e);
        L28:
            td5.d r104 = this.f241171a.f241170u;
            if (r104 == null) goto L32;
            r104.execute();
            return;
        L32:
            return;
        L7:
            d r105 = this.f241171a;
            Context r106 = r105.getContext();
            d r107 = this.f241171a;
            td5.b r110 = r107.f241154e;
            String r108 = r107.f241156g;
            int r109 = r107.f241157h;
            String r111 = r107.f241158i;
            int r112 = r107.f241159j;
            boolean r113 = r107.f241160k;
            int r114 = r107.f241162m;
            SelectorConfig r115 = r107.f241163n;
            ShareFolderUserPermission r116 = r107.f241168s;
            Bundle r117 = r107.f241164o;
            Intrinsics.checkNotNullParameter(r110, "dependence");
            Intrinsics.checkNotNullParameter(r108, "objToken");
            Intrinsics.checkNotNullParameter(r111, "title");
            Intrinsics.checkNotNullParameter(r115, "selectorConfig");
            ce5.a r118 = this.f241171a.f241167r;
            Intrinsics.checkNotNullParameter(r118, "userComponentAbility");
            boolean r119 = false;
            if (r117 == null) goto L10;
            boolean r120 = r117.getBoolean("src_origin_external");
        L11:
            if (r117 == null) goto L13;
            r119 = r117.getBoolean("src_is_shortcut");
        L13:
            if (r120 == false) goto L18;
            if (r119 == false) goto L18;
            if (r117 == null) goto L17;
            r117.putParcelable("extra_space_bean", sq5.n.a(r117, r111));
        L17:
            td5.d r121 = new com.bytedance.ee.bear.list.folderselect.command.n(r106, r108, r109, r112, r116, r117, r110, r118);
        L19:
            Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type com.bytedance.ee.bear.list.selector.ICommand");
            r105.f241170u = r121;
        L18:
            r121 = new sq5.i(r106, r116, r108, r109, r112, r113, r114, r117, r110, r118);
            goto L19
        L10:
            r120 = false;
            goto L11
        L20:
            d r122 = this.f241171a;
            Context r123 = r122.getContext();
            d r124 = this.f241171a;
            r122.f241170u = new wq5.i(r123, r124.f241156g, r124.f241157h, r124.f241159j, r124.f241160k, r124.f241162m, r124.f241168s, r124.f241164o, r124.f241154e, r124.f241167r);
            goto L28
        L21:
            d r125 = this.f241171a;
            Context r126 = r125.getContext();
            d r127 = this.f241171a;
            r125.f241170u = new tq5.w(r126, r127.f241155f, r127.f241168s, r127.f241156g, r127.f241158i, r127.f241157h, r127.f241159j, r127.f241160k, r127.f241162m, r127.f241164o, r127.f241154e, r127.f241167r);
            goto L28
        L22:
            d r128 = this.f241171a;
            Context r129 = this.f241171a.getContext();
            d r130 = this.f241171a;
            r128.f241170u = new com.bytedance.ee.bear.list.folderselect.command.n(r129, r130.f241156g, r130.f241157h, r130.f241159j, r130.f241168s, r130.f241164o, r130.f241154e, r130.f241167r);
            goto L28
        L23:
            d r131 = this.f241171a;
            Context r132 = r131.getContext();
            d r133 = this.f241171a;
            r131.f241170u = new d0(r132, r133.f241155f, r133.f241156g, r133.f241158i, r133.f241157h, r133.f241159j, r133.f241161l, r133.f241160k, r133.f241168s, r133.f241164o, r133.f241154e);
            goto L28
        L24:
            d r134 = this.f241171a;
            Context r135 = r134.getContext();
            d r136 = this.f241171a;
            r134.f241170u = new com.bytedance.ee.bear.list.folderselect.command.m(r135, r136.f241156g, r136.f241158i, r136.f241159j, r136.f241161l, r136.f241168s, r136.f241164o, r136.f241154e);
            goto L28
        L25:
            d r137 = this.f241171a;
            Context r138 = r137.getContext();
            d r139 = this.f241171a;
            r137.f241170u = new k0(r138, r139.f241156g, r139.f241157h, r139.f241159j, r139.f241168s, r139.f241164o, r139.f241154e);
            goto L28
        L26:
            d r140 = this.f241171a;
            Context r141 = r140.getContext();
            d r142 = this.f241171a;
            r140.f241170u = new com.bytedance.ee.bear.list.folderselect.command.f(r141, r142.f241156g, r142.f241159j, r142.f241168s, r142.f241164o, r142.f241154e);
            goto L28
        L27:
            d r143 = this.f241171a;
            r143.f241170u = new com.bytedance.ee.bear.list.folderselect.command.g(r143.f241156g, r143.f241158i, r143.f241154e);
            goto L28
        L5:
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void onRefresh() {
            tt5.a.h("FolderSelectPresenter", "on refresh.");
            this.f241171a.I8();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void p() {
            this.f241171a.f241154e.Ra();
        }

        public b(d r100) {
            this.f241171a = r100;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void f3(int r110, Document r111) {
            Intrinsics.checkNotNullParameter(r111, "doc");
            tt5.a.h("FolderSelectPresenter", "onItemClick()...position = " + r110);
            td5.b r112 = this.f241171a.f241154e;
            int r100 = r111.getType();
            String r101 = r111.f227873d;
            String r102 = t0.g(this.f241171a.getContext(), r111);
            FolderVersion.a r103 = FolderVersion.Companion;
            int r104 = r111.L1;
            boolean r105 = r111.P1;
            r103.getClass();
            r112.j7(new td5.e(r100, r101, r102, FolderVersion.a.b(r104, r105), FolderSource.MY_SPACE.getSource(), r111.L1, r111.f227904x));
        }
    }

    static {
    }

    public final void I8() {
        if (this.f241169t.isDisposed() == true) goto L6;
        this.f241169t.clear();
    L6:
        if ((!com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a()) == false) goto L10;
        tt5.a.h("FolderSelectPresenter", "loadData()...failed, for offline.");
        this.f241152c.E(new IOException("No Network"));
        return;
    L10:
        if (this.f241165p == false) goto L12;
        this.f241169t.add(this.f241166q.f(this.f241156g, sbb.e.f541295f.f541317b).flatMap(new iq5.h(this)).subscribe(new iq5.i(this), new iq5.j(this)));
    L14:
        if (this.f241157h == 4) goto L16;
        return;
    L16:
        if (this.f241163n.f229369a != SelectorType.SPACE_MOVE_TO) goto L20;
        qc5.a.i(this.f241167r);
        return;
    L20:
        return;
    L12:
        this.f241169t.add(this.f241151b.o8().subscribe(new iq5.k(this), new iq5.l(this)));
        goto L14
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        tt5.a.h("FolderSelectPresenter", "create()...");
        this.f241152c.showLoading();
        I8();
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        tt5.a.h("FolderSelectPresenter", "destroy()...");
        if (this.f241169t.isDisposed() == true) goto L5;
        this.f241169t.clear();
    L5:
        td5.d r100 = this.f241170u;
        if (r100 == null) goto L9;
        r100.destroy();
        return;
    }

    public final Context getContext() {
        return this.f241153d;
    }

    public static final void H8(d r100, List r101) {
        ArrayList<Document> r102 = dd5.a.a(r101, r100.f241167r.f23449d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        tt5.a.h("FolderSelectPresenter", "loadData()...success, rawSize = " + hu5.a.c(r101) + ", visibleSize = " + hu5.a.c(r102));
        r100.f241152c.I(r102);
    }

    public d(com.bytedance.ee.bear.more.b r110, iq5.d r111, e r112, Context r113, td5.b r114, Fragment r115, String r116, int r210, String r211, int r212, boolean r213, boolean r214, int r215, SelectorConfig r216, Bundle r217, boolean r218, rc5.a r219, ce5.a r310) {
        Intrinsics.checkNotNullParameter(r110, "more");
        Intrinsics.checkNotNullParameter(r111, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r112, "view");
        Intrinsics.checkNotNullParameter(r114, "dependence");
        Intrinsics.checkNotNullParameter(r115, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r116, "objToken");
        Intrinsics.checkNotNullParameter(r211, "title");
        Intrinsics.checkNotNullParameter(r216, "selectorConfig");
        Intrinsics.checkNotNullParameter(r219, "listImpl");
        Intrinsics.checkNotNullParameter(r310, "userComponentAbility");
        super(r111, r112);
        this.f241150a = r110;
        this.f241151b = r111;
        this.f241152c = r112;
        this.f241153d = r113;
        this.f241154e = r114;
        this.f241155f = r115;
        this.f241156g = r116;
        this.f241157h = r210;
        this.f241158i = r211;
        this.f241159j = r212;
        this.f241160k = r213;
        this.f241161l = r214;
        this.f241162m = r215;
        this.f241163n = r216;
        this.f241164o = r217;
        this.f241165p = r218;
        this.f241166q = r219;
        this.f241167r = r310;
        this.f241169t = new CompositeDisposable();
    }
}
