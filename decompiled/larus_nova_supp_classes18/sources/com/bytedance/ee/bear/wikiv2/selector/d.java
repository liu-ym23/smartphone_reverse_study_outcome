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
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.CompositeDisposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends BasePresenter<iq5.m, m, m.a> {
    public final com.bytedance.ee.bear.more.b a;
    public final iq5.m b;
    public final m c;
    public final Context d;
    public final td5.b e;
    public final Fragment f;
    public String g;
    public final int h;
    public final String i;
    public int j;
    public final boolean k;
    public final boolean l;
    public final int m;
    public final SelectorConfig n;
    public final Bundle o;
    public final boolean p;
    public final rc5.a q;
    public final ce5.a r;
    public ShareFolderUserPermission s;
    public final CompositeDisposable t;
    public td5.d u;

    public static final class a {
    }

    public final class b implements m.a {
        public final /* synthetic */ d a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[SelectorType.values().length];
                r0[SelectorType.SPACE_SELECT_FOLDER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L27:
                r0[SelectorType.SPACE_SAVE_TEMPLATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L43:
                r0[SelectorType.SPACE_ADD_SHORTCUT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L31:
                r0[SelectorType.SPACE_ADD_TO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
            L35:
                r0[SelectorType.SPACE_MOVE_TO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
            L25:
                r0[SelectorType.SPACE_MAKE_COPY_TO.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
            L37:
                r0[SelectorType.WIKI_MOVE_TO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
            L39:
                r0[SelectorType.WIKI_SHORTCUT_TO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
            L29:
                r0[SelectorType.WIKI_MAKE_COPY_TO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
            L33:
                r0[SelectorType.WIKI_CREATE_TO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
            L13:
                a = r0;
            }
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void M7() {
            tt5.a.h("FolderSelectPresenter", "onCreateFolderClick()...");
            d r1 = this.a;
            r1.getClass();
            tt5.a.h("FolderSelectPresenter", "createFolder()...");
            boolean r3 = true;
            String r5 = null;
            if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L9;
            tt5.a.h("FolderSelectPresenter", "createFolder()...failed for offline.");
            Context r0 = r1.d;
            if (r0 == null) goto L7;
            r5 = r0.getString(2131887951);
        L7:
            Toast.showFailureText(r0, r5, 0);
            return;
        L9:
            if (r1.h != 4) goto L11;
        L14:
            boolean r2 = true;
        L15:
            if (r2 == true) goto L22;
            ShareFolderUserPermission r4 = r1.s;
            if (r4 != null) goto L19;
        L21:
            r3 = false;
            goto L22
        L19:
            if (r1.a.u(r4, "CREATE_SUB_NODE").booleanValue() == false) goto L21;
        L22:
            if (r3 == true) goto L27;
            tt5.a.h("FolderSelectPresenter", "createFolder()...failed for no permission");
            Context r6 = r1.d;
            if (r6 == null) goto L26;
            r5 = r6.getString(2131889821);
        L26:
            Toast.showFailureText(r6, r5);
            return;
        L27:
            FragmentActivity r7 = r1.f.getActivity();
            if (r7 == null) goto L33;
            r1.t.add(r1.b.Y5(r7).subscribe(new iq5.f(r1), new iq5.g(r1, r7)));
            return;
        L33:
            return;
        L11:
            if (r1.k == false) goto L14;
            r2 = false;
            goto L15
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void Z3() {
            tt5.a.h("FolderSelectPresenter", "onBtnBackClick()...");
            this.a.e.back();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void d2() {
            tt5.a.h("FolderSelectPresenter", "onBtnOperateClick()...");
            SelectorType r0 = this.a.n.a;
            switch(a.a[r0.ordinal()]) {
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
            d r1 = this.a;
            Context r2 = r1.getContext();
            d r3 = this.a;
            r1.u = new com.bytedance.ee.bear.wikiv2.wikitreev2.create.w(r2, r3.s, r3.g, r3.j, r3.o, r3.e);
        L28:
            td5.d r4 = this.a.u;
            if (r4 == null) goto L32;
            r4.execute();
            return;
        L32:
            return;
        L7:
            d r5 = this.a;
            Context r6 = r5.getContext();
            d r7 = this.a;
            td5.b r10 = r7.e;
            String r8 = r7.g;
            int r9 = r7.h;
            String r11 = r7.i;
            int r12 = r7.j;
            boolean r13 = r7.k;
            int r14 = r7.m;
            SelectorConfig r15 = r7.n;
            ShareFolderUserPermission r16 = r7.s;
            Bundle r17 = r7.o;
            Intrinsics.checkNotNullParameter(r10, "dependence");
            Intrinsics.checkNotNullParameter(r8, "objToken");
            Intrinsics.checkNotNullParameter(r11, "title");
            Intrinsics.checkNotNullParameter(r15, "selectorConfig");
            ce5.a r18 = this.a.r;
            Intrinsics.checkNotNullParameter(r18, "userComponentAbility");
            boolean r19 = false;
            if (r17 == null) goto L10;
            boolean r20 = r17.getBoolean("src_origin_external");
        L11:
            if (r17 == null) goto L13;
            r19 = r17.getBoolean("src_is_shortcut");
        L13:
            if (r20 == false) goto L18;
            if (r19 == false) goto L18;
            if (r17 == null) goto L17;
            r17.putParcelable("extra_space_bean", sq5.n.a(r17, r11));
        L17:
            td5.d r110 = new com.bytedance.ee.bear.list.folderselect.command.n(r6, r8, r9, r12, r16, r17, r10, r18);
        L19:
            Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.bytedance.ee.bear.list.selector.ICommand");
            r5.u = r110;
        L18:
            r110 = new sq5.i(r6, r16, r8, r9, r12, r13, r14, r17, r10, r18);
            goto L19
        L10:
            r20 = false;
            goto L11
        L20:
            d r21 = this.a;
            Context r22 = r21.getContext();
            d r23 = this.a;
            r21.u = new wq5.i(r22, r23.g, r23.h, r23.j, r23.k, r23.m, r23.s, r23.o, r23.e, r23.r);
            goto L28
        L21:
            d r24 = this.a;
            Context r25 = r24.getContext();
            d r26 = this.a;
            r24.u = new tq5.w(r25, r26.f, r26.s, r26.g, r26.i, r26.h, r26.j, r26.k, r26.m, r26.o, r26.e, r26.r);
            goto L28
        L22:
            d r27 = this.a;
            Context r28 = this.a.getContext();
            d r29 = this.a;
            r27.u = new com.bytedance.ee.bear.list.folderselect.command.n(r28, r29.g, r29.h, r29.j, r29.s, r29.o, r29.e, r29.r);
            goto L28
        L23:
            d r30 = this.a;
            Context r31 = r30.getContext();
            d r32 = this.a;
            r30.u = new d0(r31, r32.f, r32.g, r32.i, r32.h, r32.j, r32.l, r32.k, r32.s, r32.o, r32.e);
            goto L28
        L24:
            d r33 = this.a;
            Context r34 = r33.getContext();
            d r35 = this.a;
            r33.u = new com.bytedance.ee.bear.list.folderselect.command.m(r34, r35.g, r35.i, r35.j, r35.l, r35.s, r35.o, r35.e);
            goto L28
        L25:
            d r36 = this.a;
            Context r37 = r36.getContext();
            d r38 = this.a;
            r36.u = new k0(r37, r38.g, r38.h, r38.j, r38.s, r38.o, r38.e);
            goto L28
        L26:
            d r39 = this.a;
            Context r40 = r39.getContext();
            d r41 = this.a;
            r39.u = new com.bytedance.ee.bear.list.folderselect.command.f(r40, r41.g, r41.j, r41.s, r41.o, r41.e);
            goto L28
        L27:
            d r42 = this.a;
            r42.u = new com.bytedance.ee.bear.list.folderselect.command.g(r42.g, r42.i, r42.e);
            goto L28
        L5:
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void onRefresh() {
            tt5.a.h("FolderSelectPresenter", "on refresh.");
            this.a.I8();
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void p() {
            this.a.e.Ra();
        }

        public b(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.wikiv2.selector.m.a
        public final void f3(int r10, Document r11) {
            Intrinsics.checkNotNullParameter(r11, DocumentType.DOC_NAME);
            tt5.a.h("FolderSelectPresenter", "onItemClick()...position = " + r10);
            td5.b r12 = this.a.e;
            int r1 = r11.getType();
            String r2 = r11.d;
            String r3 = t0.g(this.a.getContext(), r11);
            FolderVersion.a r0 = FolderVersion.Companion;
            int r4 = r11.L1;
            boolean r5 = r11.P1;
            r0.getClass();
            r12.j7(new td5.e(r1, r2, r3, FolderVersion.a.b(r4, r5), FolderSource.MY_SPACE.getSource(), r11.L1, r11.x));
        }
    }

    static {
    }

    public final void I8() {
        if (this.t.isDisposed() == true) goto L6;
        this.t.clear();
    L6:
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L10;
        tt5.a.h("FolderSelectPresenter", "loadData()...failed, for offline.");
        this.c.E(new IOException("No Network"));
        return;
    L10:
        if (this.p == false) goto L12;
        this.t.add(this.q.f(this.g, sbb.e.f.b).flatMap(new iq5.h(this)).subscribe(new iq5.i(this), new iq5.j(this)));
    L14:
        if (this.h == 4) goto L16;
        return;
    L16:
        if (this.n.a != SelectorType.SPACE_MOVE_TO) goto L20;
        qc5.a.i(this.r);
        return;
    L20:
        return;
    L12:
        this.t.add(this.b.o8().subscribe(new iq5.k(this), new iq5.l(this)));
        goto L14
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new b(this);
    }

    public final void create() {
        super.create();
        tt5.a.h("FolderSelectPresenter", "create()...");
        this.c.showLoading();
        I8();
    }

    public final void destroy() {
        super.destroy();
        tt5.a.h("FolderSelectPresenter", "destroy()...");
        if (this.t.isDisposed() == true) goto L5;
        this.t.clear();
    L5:
        td5.d r0 = this.u;
        if (r0 == null) goto L9;
        r0.destroy();
        return;
    }

    public final Context getContext() {
        return this.d;
    }

    public static final void H8(d r3, List r4) {
        ArrayList<Document> r0 = dd5.a.a(r4, r3.r.d.isCurrentEnable("ccm.space.mobile.ai_artifact_folder_visible"));
        tt5.a.h("FolderSelectPresenter", "loadData()...success, rawSize = " + hu5.a.c(r4) + ", visibleSize = " + hu5.a.c(r0));
        r3.c.I(r0);
    }

    public d(com.bytedance.ee.bear.more.b r13, iq5.d r14, e r15, Context r16, td5.b r17, Fragment r18, String r19, int r20, String r21, int r22, boolean r23, boolean r24, int r25, SelectorConfig r26, Bundle r27, boolean r28, rc5.a r29, ce5.a r30) {
        Intrinsics.checkNotNullParameter(r13, "more");
        Intrinsics.checkNotNullParameter(r14, "model");
        Intrinsics.checkNotNullParameter(r15, "view");
        Intrinsics.checkNotNullParameter(r17, "dependence");
        Intrinsics.checkNotNullParameter(r18, "fragment");
        Intrinsics.checkNotNullParameter(r19, "objToken");
        Intrinsics.checkNotNullParameter(r21, "title");
        Intrinsics.checkNotNullParameter(r26, "selectorConfig");
        Intrinsics.checkNotNullParameter(r29, "listImpl");
        Intrinsics.checkNotNullParameter(r30, "userComponentAbility");
        super(r14, r15);
        this.a = r13;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r23;
        this.l = r24;
        this.m = r25;
        this.n = r26;
        this.o = r27;
        this.p = r28;
        this.q = r29;
        this.r = r30;
        this.t = new CompositeDisposable();
    }
}
