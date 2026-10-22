package com.bytedance.ee.bear.document.selection;

import android.util.Pair;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class u extends p<View> {
    public final DocumentPluginHost M;

    public class a implements ActionMode.Callback, p.d {
        public final p<View>.c a;

        @Override // com.bytedance.ee.bear.document.selection.p.d
        public final boolean a() {
            return this.a.f();
        }

        public a(u r2) {
            this.a = new p.c(r2);
        }

        @Override // com.bytedance.ee.bear.document.selection.p.d
        public final void b(LinkedHashMap<String, String> r2) {
            this.a.e(r2);
        }

        @Override // com.bytedance.ee.bear.document.selection.p.d
        public final ActionMode.Callback c(ActionMode.Callback r2) {
            tt5.a.h("SelectionNewVL", "proxyCallback " + this);
            return this;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            this.a.c(r2);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
            return this.a.a(r2, r3);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r2, Menu r3) {
            this.a.b(r2, r3);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            return this.a.d(r2, r3);
        }
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final boolean p() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final boolean k() {
        Iterator r0 = ((ArrayList) this.w).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((View) r0.next()).getVisibility() != 0) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final ActionMode r() {
        return this.a.getWebView().startActionMode(this.f);
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void s() {
        Iterator r0 = ((ArrayList) this.w).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).setOnTouchListener(null);
        goto L4
    L6:
        ((ArrayList) this.w).clear();
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final boolean i() {
        s();
        Iterator r0 = ((ArrayList) u()).iterator();
        boolean r2 = true;
    L4:
        if (r0.hasNext() == false) goto L7;
        View r3 = (View) r0.next();
        ((ArrayList) this.w).add(r3);
        r3.setOnTouchListener(new p.e(this, r2));
        r2 = !r2;
        goto L4
    L7:
        if (((ArrayList) this.w).size() > 0) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void b(z4 r1) {
        super.b(r1);
        this.f = new a(this);
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final Pair<View, Boolean> d(ViewGroup r4) {
        return new Pair(r4, Boolean.valueOf("PopupTouchHandleDrawable".equals(r4.getClass().getSimpleName())));
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final UserPermissionEntity h(String r4) {
        DocumentPluginHost r0 = this.M;
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.a() == null) goto L13;
        if (this.M.a().getDocumentInfoData() == null) goto L13;
        if (this.M.a().getDocumentInfoData().getDocPermissionByToken(r4) == null) goto L13;
        return new UserPermissionEntity(this.M.a().getDocumentInfoData().getDocPermissionByToken(r4), null);
    }

    public u(DocumentPluginHost r1, com.bytedance.ee.bear.contract.d r2) {
        super(r2, r1);
        this.M = r1;
    }
}
