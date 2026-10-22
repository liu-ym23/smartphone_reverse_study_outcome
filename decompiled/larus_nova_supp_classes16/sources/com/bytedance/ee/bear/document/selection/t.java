package com.bytedance.ee.bear.document.selection;

import android.graphics.Rect;
import android.util.Pair;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.scroll.ScrollOffsetPlugin;
import com.bytedance.ee.bear.document.z4;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t extends p<ViewGroup> {
    public ScrollOffsetPlugin.c M;
    public final DocumentPluginHost N;
    public final s O;
    public final a P;
    public final b Q;

    public class a implements ScrollOffsetPlugin.d {
        public final /* synthetic */ t a;

        public a(t r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.scroll.ScrollOffsetPlugin.d
        public final void a(ScrollOffsetPlugin.c r3) {
            t r0 = this.a;
            r0.M = r3;
            if (r0.e == null) goto L6;
            com.bytedance.ee.util.ui.j.e(r0.Q);
            com.bytedance.ee.util.ui.j.d(this.a.Q, 50);
            return;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ t a;

        @Override // java.lang.Runnable
        public final void run() {
            ActionMode r0 = this.a.e;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.invalidateContentRect();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public b(t r1) {
            this.a = r1;
        }
    }

    public class c implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public c(View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            this.a.setOnTouchListener(null);
            this.a.removeOnAttachStateChangeListener(this);
        }
    }

    public class d extends ActionMode.Callback2 implements p.d {
        public ActionMode.Callback a;
        public final p<ViewGroup>.c b;
        public final /* synthetic */ t c;

        @Override // com.bytedance.ee.bear.document.selection.p.d
        public final boolean a() {
            return this.b.f();
        }

        public d(t r2) {
            this.c = r2;
            this.b = new p.c(r2);
        }

        @Override // com.bytedance.ee.bear.document.selection.p.d
        public final void b(LinkedHashMap<String, String> r2) {
            this.b.e(r2);
        }

        @Override // com.bytedance.ee.bear.document.selection.p.d
        public final ActionMode.Callback c(ActionMode.Callback r3) {
            tt5.a.h("SelectionNewVH", "proxyCallback " + this);
            if (r3 == this) goto L5;
            this.a = r3;
        L5:
            return this;
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r2) {
            this.b.c(r2);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
            return this.b.a(r2, r3);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r3, Menu r4) {
            if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.docx_selection_bugfix") == false) goto L5;
            r3.hide(50);
        L5:
            this.b.b(r3, r4);
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
            return this.b.d(r2, r3);
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r3, View r4, Rect r5) {
            tt5.a.h("SelectionNewVH", "onGetContentRect " + this.c.l + "   outRect " + r5);
            if (this.c.l.isEmpty() == true) goto L5;
            r5.set(this.c.l);
            r5.offset(0, -(this.c.a.getWebView().getScrollY() + this.c.M.a));
            return;
        L5:
            ActionMode.Callback r0 = this.a;
            if ((r0 instanceof ActionMode.Callback2) == false) goto L10;
            ((ActionMode.Callback2) r0).onGetContentRect(r3, r4, r5);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final boolean k() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final boolean p() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void f() {
        Iterator r0 = ((ArrayList) this.w).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ViewGroup r1 = (ViewGroup) r0.next();
        r1.getLocationOnScreen(this.v);
        int r2 = (com.bytedance.ee.util.ui.n.u(r1.getContext()) - this.d) - com.bytedance.ee.util.ui.n.d(50);
        tt5.a.h("SelectionNewVH", "updateSelectionHandleVisible:" + r2 + "  " + this.v[1]);
        if (this.d <= 0) goto L10;
        if (this.v[1] <= r2) goto L10;
        r1.setVisibility(4);
    L10:
        r1.setVisibility(0);
        goto L4
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void j() {
        ActionMode r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getType() == 1) goto L7;
        return;
    L7:
        if (this.l.isEmpty() == true) goto L12;
        this.e.hide(500);
        com.bytedance.ee.util.ui.j.e(this.Q);
        com.bytedance.ee.util.ui.j.d(this.Q, 300);
        return;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final ActionMode r() {
        return ((zv4.b) this.a.getWebView()).startActionMode(this.f, 1);
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void s() {
        Iterator r0 = ((ArrayList) this.w).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View r1 = w((ViewGroup) r0.next());
        if (r1 == null) goto L4;
        r1.setOnTouchListener(null);
        goto L4
    L8:
        ((ArrayList) this.w).clear();
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void e() {
        super.e();
        this.a.F(this.O);
        com.bytedance.ee.util.ui.j.e(this.Q);
        if (this.A == false) goto L10;
        DocumentPluginHost r0 = this.N;
        if (r0 == null) goto L11;
        ScrollOffsetPlugin r1 = (ScrollOffsetPlugin) r0.findPlugin(ScrollOffsetPlugin.class);
        if (r1 == null) goto L12;
        r1.removeWebScrollOffsetChangeListner(this.P);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final boolean i() {
        s();
        ArrayList r0 = (ArrayList) u();
        Iterator r1 = r0.iterator();
        boolean r3 = true;
    L4:
        if (r1.hasNext() == false) goto L11;
        ViewGroup r4 = (ViewGroup) r1.next();
        View r5 = w(r4);
        if (r5 == null) goto L4;
        ((ArrayList) this.w).add(r4);
        r5.setOnTouchListener(new p.e(this, r3));
        r5.addOnAttachStateChangeListener(new c(r5));
        r3 = !r3;
        if (r0.size() != 1) goto L4;
        r5.setVisibility(4);
        r5.setAlpha(0.0f);
        goto L4
    L11:
        if (((ArrayList) this.w).size() > 0) goto L22;
        return false;
    L22:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void b(z4 r2) {
        super.b(r2);
        r2.d(this.O);
        this.f = new d(this);
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final Pair<View, Boolean> d(ViewGroup r3) {
        View r4 = w(r3);
        if (r4 == null) goto L5;
        boolean r1 = true;
    L7:
        return new Pair(r4, Boolean.valueOf(r1));
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final UserPermissionEntity h(String r4) {
        DocumentPluginHost r0 = this.N;
        if (r0 != null) goto L5;
    L13:
        return null;
    L5:
        if (r0.a() == null) goto L13;
        if (this.N.a().getDocumentInfoData() == null) goto L13;
        if (this.N.a().getDocumentInfoData().getDocPermissionByToken(r4) == null) goto L13;
        return new UserPermissionEntity(this.N.a().getDocumentInfoData().getDocPermissionByToken(r4), null);
    }

    public final View w(ViewGroup r6) {
        int r0 = r6.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L9;
        View r1 = r6.getChildAt(r0);
        tt5.a.h("SelectionNewVH", "tryFindPopupTouchHandler()... child name is ".concat(r1.getClass().getSimpleName()));
        if ("PopupTouchHandleDrawable".equals(r1.getClass().getSimpleName()) == true) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        tt5.a.h("SelectionNewVH", "tryFindPopupTouchHandler()... find PopupTouchHandleDrawable success");
        return r1;
    L9:
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.ee.bear.document.selection.s] */
    public t(com.bytedance.ee.bear.contract.d r2, DocumentPluginHost r3) {
        super(r2, r3);
        this.M = new ScrollOffsetPlugin.c();
        this.N = null;
        this.O = new s(this);
        a r4 = new a(this);
        this.P = r4;
        this.Q = new b(this);
        this.N = r3;
        if (this.A == false) goto L8;
        ScrollOffsetPlugin r5 = (ScrollOffsetPlugin) r3.findPlugin(ScrollOffsetPlugin.class);
        if (r5 == null) goto L9;
        r5.addWebScrollOffsetListner(r4);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.document.selection.p
    public final void n(JSONObject r2, Rect r3) throws JSONException {
        super.n(r2, r3);
        this.l.offset(0, this.M.a);
    }
}
