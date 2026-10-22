package com.bytedance.ee.bear.content.creation.mvp;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.contract.j;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e extends BasePresenter<com.bytedance.ee.bear.content.creation.mvp.a, b, b.a> {
    public final Fragment a;
    public SelectCreationMenuViewModel b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public final CompositeDisposable j;
    public final boolean k;

    public class a implements b.a {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.content.creation.mvp.b.a
        public final void j7(SelectCreationMenuItem.ItemType r5) {
            tt5.a.h("SelectCreationMenuPresenter", "onItemClick()...menuType = " + r5.type);
            Fragment r0 = this.a.a;
            if (r0 != null) goto L5;
        L9:
            Fragment r1 = this.a.a;
            if (r1 != null) goto L12;
        L24:
            e r2 = this.a;
            r2.getClass();
            tt5.a.h("SelectCreationMenuPresenter", "createDocument()...menuType = " + r5.type + ", mIsConnect = " + r2.g);
            SelectCreationMenuViewModel r3 = r2.b;
            iw4.b.a r4 = new iw4.b.a();
            r4.a = r5;
            r4.b = r2.d;
            r4.c = r2.c;
            r4.d = r2.e;
            r4.e = r2.f;
            r4.f = r2.h;
            r4.g = r2.i;
            r4.h = r2.k;
            r3.setOnClickCreationMenuItem(new iw4.b(r4));
            return;
        L12:
            if (r1.getParentFragment() == null) goto L24;
            if ((this.a.a.getParentFragment() instanceof DialogFragment) == false) goto L24;
            if (r5 != SelectCreationMenuItem.ItemType.ADD_FOLDER) goto L24;
            this.a.a.getParentFragment().dismissAllowingStateLoss();     // Catch: Exception -> L20
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r6 = DialogFragmentLancet.sLastShowStack;
            if (r6 == null) goto L24;
            com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L24
        L5:
            if (ForsetiHelper.s(r0) == false) goto L9;
            com.suite.lark.component.navroute.forseti.g r7 = com.suite.lark.component.navroute.forseti.f.b(this.a.a);
            if (r7 == null) goto L24;
            r7.g(null);
            goto L24
        }
    }

    public final void create() {
        this.b = (SelectCreationMenuViewModel) ViewModelProviders.of(this.a.getActivity()).get(SelectCreationMenuViewModel.class);
        j r0 = j.a.a;
        this.g = r0.getNetworkState().a();
        ((com.bytedance.ee.bear.content.creation.mvp.a) getModel()).n8(this.g);
        ((b) getView()).v6(this.g);
        ((b) getView()).o1(((com.bytedance.ee.bear.content.creation.mvp.a) getModel()).D3(), ((com.bytedance.ee.bear.content.creation.mvp.a) getModel()).p7());
        r0.a().observe(this.a, new d(this));
        ((rc5.b) org.koin.java.a.a(rc5.b.class)).a(this.c, this.e, this.d);
        super.create();
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new a(this);
    }

    public final void destroy() {
        super.destroy();
        this.b.setSelectCreationMenuState(0);
        this.b.setSelectCreationMenuState(null);
        if (this.j.isDisposed() == true) goto L6;
        this.j.clear();
        return;
    }

    static {
    }

    public e(Fragment r1, b r2, c r3, String r4, String r5, boolean r6, boolean r7, String r8, String r9, boolean r10) {
        super(r3, r2);
        this.j = new CompositeDisposable();
        this.a = r1;
        this.c = r4;
        this.d = r5;
        this.h = r6;
        this.i = r7;
        this.e = r8;
        this.f = r9;
        this.k = r10;
    }
}
