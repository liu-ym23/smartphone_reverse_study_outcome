package com.bytedance.ee.bear.list.share;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.larksuite.framework.mvp.IModel;
import com.larksuite.framework.mvp.IView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k1 extends b3 {

    public static class a implements com.bytedance.ee.bear.list.s.c {
        public final WeakReference<k1> a;

        public a(k1 r2) {
            this.a = new WeakReference(r2);
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void a(DocumentListInfo r4) {
            tt5.a.h("NewShareFolderPresenter", "DeleteOnlineItemCallback onAuthorityFail()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("NewShareFolderPresenter", "DeleteOnlineItemCallback#onAuthorityFail()...presenterRef = null");
            return;
        L6:
            k1 r0 = this.a.get();
            r0.g9().s6(false);
            com.bytedance.ee.bear.list.folder.a.C0014a r1 = new com.bytedance.ee.bear.list.folder.a.C0014a();
            com.bytedance.ee.bear.list.folder.a.b r2 = r1.a;
            r2.a = r4;
            r2.b = new i1();
            r2.c = new j1();
            com.bytedance.ee.bear.list.folder.a r5 = r1.a(r0.a, r0.r);
            if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L13;
            DialogLancet.handleBlockedDialogShow(r5);
            return;
        L13:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            DialogLancet.beforeDialogShow(r5);
            r5.show();
            DialogLancet.afterDialogShow(r5);
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void onSuccess(String r4) {
            tt5.a.h("NewShareFolderPresenter", "DeleteOnlineItemCallback onSuccess()...");
            if (this.a.get() != null) goto L6;
            tt5.a.h("NewShareFolderPresenter", "DeleteOnlineItemCallback#onSuccess()...presenterRef = null");
            return;
        L6:
            k1 r0 = this.a.get();
            r0.f9().c(r4);
            r0.g9().s6(false);
            Context r5 = r0.a;
            Toast.showSuccessText(r5, r5.getResources().getString(2131887742), 0);
        }

        @Override // com.bytedance.ee.bear.list.s.c
        public final void b(String r2, int r3, Throwable r4) {
            tt5.a.h("NewShareFolderPresenter", "DeleteOnlineItemCallback#onFail()...throwable = " + r4);
            if (this.a.get() != null) goto L6;
            tt5.a.h("NewShareFolderPresenter", "DeleteOnlineItemCallback#onFail()...presenterRef = null");
            return;
        L6:
            k1 r5 = this.a.get();
            r5.g9().s6(false);
            if (com.bytedance.ee.bear.contract.k0.c(r4) == false) goto L10;
            return;
        L10:
            if (ax4.d.b(r4, 4202) == false) goto L13;
            Toast.showFailureText(r5.a, 2131887146);
            return;
        L13:
            if (ax4.d.b(r4, 4) == false) goto L15;
            Context r6 = r5.a;
            Toast.showFailureText(r6, r6.getResources().getString(2131887803), 0);
            return;
        L15:
            gj5.b r7 = (gj5.b) org.koin.java.a.a(gj5.b.class);
            if (ax4.d.b(r4, 900099011) == false) goto L18;
            return;
        L18:
            Context r8 = r5.a;
            Toast.showFailureText(r8, r8.getResources().getString(2131887737), 0);
        }
    }

    @Override // com.bytedance.ee.bear.list.share.b3, com.bytedance.ee.bear.list.list.b
    public final String M8() {
        return "NewShareFolderPresenter";
    }

    @Override // com.bytedance.ee.bear.list.share.b3, com.bytedance.ee.bear.list.list.b
    public final String J8() {
        if (qc5.a.g(this.x) == false) goto L6;
        return "new_drive";
    L6:
        return "shared";
    }

    @Override // com.bytedance.ee.bear.list.share.b3
    public final String d9() {
        if (qc5.a.g(this.x) == false) goto L6;
        return "ccm_space_drive_page_click";
    L6:
        return "ccm_space_folder_click";
    }

    @Override // com.bytedance.ee.bear.list.share.b3, com.bytedance.ee.bear.list.list.b
    public final void create() {
        super.create();
        if (qc5.a.g(this.x) == false) goto L6;
        Disposable r0 = f9().R().subscribe(new g1(this), new h1());
        this.t.add(r0);
        return;
    }

    public final h0 f9() {
        return (h0) super.getModel();
    }

    public final i0 g9() {
        return (i0) super.getView();
    }

    public final /* bridge */ /* synthetic */ IModel getModel() {
        return f9();
    }

    public final /* bridge */ /* synthetic */ IView getView() {
        return g9();
    }

    @Override // com.bytedance.ee.bear.list.share.b3, dd5.n1
    public final void b5(String r3) {
        g9().a8(true);
        f9().c(r3);
    }

    @Override // com.bytedance.ee.bear.list.share.b3
    public final void e9(Document r3) {
        tt5.a.h("NewShareFolderPresenter", "removeItem(). ");
        g9().s6(true);
        if (r3.getType() == sbb.e.f.b) goto L5;
    L7:
        com.bytedance.ee.bear.list.s.d(r3, new a(this));
        return;
    L5:
        if (TextUtils.isEmpty(r3.c) == false) goto L7;
        r3.c = r3.d;
        goto L7
    }

    @Override // com.bytedance.ee.bear.list.list.b, com.bytedance.ee.bear.list.list.e.a
    public final void s8(int r3, boolean r4) {
        g9().a8(f9().P0().booleanValue());
        super.s8(r3, r4);
        if (hu5.a.d(g9().G()) == false) goto L7;
        if (r3 != 0) goto L8;
        S8(new ArrayList(0));
        return;
    L8:
        return;
    }

    public k1(i3 r1, f1 r2, Context r3, LifeCycleFragment r4, ce5.a r5) {
        super(r1, r2, r3, r4, r5);
        this.x = r5;
    }
}
