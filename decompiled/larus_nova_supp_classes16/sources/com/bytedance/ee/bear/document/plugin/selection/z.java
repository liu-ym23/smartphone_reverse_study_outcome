package com.bytedance.ee.bear.document.plugin.selection;

import android.graphics.Rect;
import android.util.Pair;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class z extends v<ViewGroup> {
    public final y J;
    public final a K;

    public class a implements Runnable {
        public final /* synthetic */ z a;

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

        public a(z r1) {
            this.a = r1;
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r1) {
        }

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            this.a.setOnTouchListener(null);
            this.a.removeOnAttachStateChangeListener(this);
        }
    }

    public class c extends ActionMode.Callback2 implements v.d {
        public ActionMode.Callback a;
        public final v<ViewGroup>.c b;
        public final /* synthetic */ z c;

        @Override // com.bytedance.ee.bear.document.plugin.selection.v.d
        public final boolean a() {
            return this.b.f();
        }

        public c(z r2) {
            this.c = r2;
            this.b = new v.c(r2);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.v.d
        public final void b(LinkedHashMap<String, String> r2) {
            this.b.e(r2);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.v.d
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
            tt5.a.h("SelectionNewVH", "onGetContentRect " + this.c.k + "   outRect " + r5);
            if (this.c.k.isEmpty() == true) goto L5;
            r5.set(this.c.k);
            r5.offset(0, -this.c.a.getScrollY());
            return;
        L5:
            ActionMode.Callback r0 = this.a;
            if ((r0 instanceof ActionMode.Callback2) == false) goto L10;
            ((ActionMode.Callback2) r0).onGetContentRect(r3, r4, r5);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final boolean i() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final boolean n() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void f() {
        Iterator r0 = ((ArrayList) this.v).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        ViewGroup r1 = (ViewGroup) r0.next();
        r1.getLocationOnScreen(this.u);
        int r2 = (com.bytedance.ee.util.ui.n.u(r1.getContext()) - this.d) - com.bytedance.ee.util.ui.n.d(50);
        tt5.a.h("SelectionNewVH", "updateSelectionHandleVisible:" + r2 + "  " + this.u[1]);
        if (this.d <= 0) goto L10;
        if (this.u[1] <= r2) goto L10;
        r1.setVisibility(4);
    L10:
        r1.setVisibility(0);
        goto L4
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final ActionMode p() {
        return this.a.u(this.f, 1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void q() {
        Iterator r0 = ((ArrayList) this.v).iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        View r1 = u((ViewGroup) r0.next());
        if (r1 == null) goto L4;
        r1.setOnTouchListener(null);
        goto L4
    L8:
        ((ArrayList) this.v).clear();
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void e() {
        super.e();
        this.a.B(this.J);
        com.bytedance.ee.util.ui.j.e(this.K);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final boolean h() {
        q();
        ArrayList r0 = (ArrayList) s();
        Iterator r1 = r0.iterator();
        boolean r3 = true;
    L4:
        if (r1.hasNext() == false) goto L11;
        ViewGroup r4 = (ViewGroup) r1.next();
        View r5 = u(r4);
        if (r5 == null) goto L4;
        ((ArrayList) this.v).add(r4);
        r5.setOnTouchListener(new v.e(this, r3));
        r5.addOnAttachStateChangeListener(new b(r5));
        r3 = !r3;
        if (r0.size() != 1) goto L4;
        r5.setVisibility(4);
        r5.setAlpha(0.0f);
        goto L4
    L11:
        if (((ArrayList) this.v).size() > 0) goto L22;
        return false;
    L22:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void b(ChameleonWebView r2) {
        super.b(r2);
        r2.x(this.J);
        this.f = new c(this);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final Pair<View, Boolean> d(ViewGroup r3) {
        View r4 = u(r3);
        if (r4 == null) goto L5;
        boolean r1 = true;
    L7:
        return new Pair(r4, Boolean.valueOf(r1));
    L5:
        r1 = false;
        goto L7
    }

    public final View u(ViewGroup r6) {
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

    /* JADX WARN: Type inference failed for: r1v1, types: [com.bytedance.ee.bear.document.plugin.selection.y] */
    public z(com.bytedance.ee.bear.contract.d r1, ChameleonPluginHost r2) {
        super(r1, r2);
        this.J = new y(this);
        this.K = new a(this);
    }
}
