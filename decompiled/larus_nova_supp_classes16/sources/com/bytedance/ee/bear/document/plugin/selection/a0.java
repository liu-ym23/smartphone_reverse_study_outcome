package com.bytedance.ee.bear.document.plugin.selection;

import android.util.Pair;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a0 extends v<View> {

    public class a implements ActionMode.Callback, v.d {
        public final v<View>.c a;

        @Override // com.bytedance.ee.bear.document.plugin.selection.v.d
        public final boolean a() {
            return this.a.f();
        }

        public a(a0 r2) {
            this.a = new v.c(r2);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.v.d
        public final void b(LinkedHashMap<String, String> r2) {
            this.a.e(r2);
        }

        @Override // com.bytedance.ee.bear.document.plugin.selection.v.d
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

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final boolean n() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final boolean i() {
        Iterator r0 = ((ArrayList) this.v).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((View) r0.next()).getVisibility() != 0) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final ActionMode p() {
        return this.a.u(this.f, -1);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void q() {
        Iterator r0 = ((ArrayList) this.v).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((View) r0.next()).setOnTouchListener(null);
        goto L4
    L6:
        ((ArrayList) this.v).clear();
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final boolean h() {
        q();
        Iterator r0 = ((ArrayList) s()).iterator();
        boolean r2 = true;
    L4:
        if (r0.hasNext() == false) goto L7;
        View r3 = (View) r0.next();
        ((ArrayList) this.v).add(r3);
        r3.setOnTouchListener(new v.e(this, r2));
        r2 = !r2;
        goto L4
    L7:
        if (((ArrayList) this.v).size() > 0) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final void b(ChameleonWebView r1) {
        super.b(r1);
        this.f = new a(this);
    }

    @Override // com.bytedance.ee.bear.document.plugin.selection.v
    public final Pair<View, Boolean> d(ViewGroup r4) {
        return new Pair(r4, Boolean.valueOf("PopupTouchHandleDrawable".equals(r4.getClass().getSimpleName())));
    }

    public a0(ChameleonPluginHost r1, com.bytedance.ee.bear.contract.d r2) {
        super(r2, r1);
    }
}
