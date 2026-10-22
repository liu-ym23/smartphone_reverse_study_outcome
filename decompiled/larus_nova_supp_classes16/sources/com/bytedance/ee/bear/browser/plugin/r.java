package com.bytedance.ee.bear.browser.plugin;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class r implements t {
    public final String a;
    public final Context b;
    public final View c;
    public final FragmentManager d;
    public TitleBar e;
    public final LayoutInflater f;
    public t.a g;
    public final Map<String, s> h;
    public final Map<String, WeakReference<Fragment>> i;

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void a() {
        Context r0 = this.b;
        if ((r0 instanceof Activity) == false) goto L6;
        ((Activity) r0).getWindow().clearFlags(1024);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void disablePluginsFitSystemWindow() {
        View r0 = new View(getContext());
        r0.setFitsSystemWindows(true);
        ((c) this.g).d.addView(r0, 0);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final TitleBar getTitleBar() {
        if (this.e != null) goto L6;
        String r0 = this.a;
        IllegalStateException r1 = new IllegalStateException("No title bar injected !");
        int r2 = com.ss.android.lark.officesdk.utils.di.j.a;
        Intrinsics.checkNotNullParameter(r0, "tag");
        Intrinsics.checkNotNullParameter(r1, "throwable");
        com.ss.android.lark.officesdk.utils.di.j.g(r0, "", r1);
    L6:
        return this.e;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void hideStatusBar() {
        Context r0 = this.b;
        if ((r0 instanceof Activity) == false) goto L6;
        ((Activity) r0).getWindow().addFlags(1024);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final u saveUIState() {
        c r0 = (c) this.g;
        r0.getClass();
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L4:
        if (r2 >= r0.d.getChildCount()) goto L10;
        View r3 = r0.d.getChildAt(r2);
        if (r3.getTag(2131382479) == null) goto L8;
        r1.add(new Pair(r3.getTag(), Integer.valueOf(r3.getId())));
    L8:
        r2 = r2 + 1;
        goto L4
    L10:
        return new u(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View getContentView() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public Context getContext() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final FragmentManager getFragmentManager() {
        return this.d;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final t.a getLayoutStrategy() {
        return this.g;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public ViewGroup c(f r2) {
        return ((c) this.g).d(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void d(f r7) {
        String r0 = n(r7);     // Catch: Exception -> L22
        s r1 = (s) ((HashMap) this.h).remove(r0);     // Catch: Exception -> L22
        Fragment r8 = l(r7);     // Catch: Exception -> L22
        WeakReference r2 = (WeakReference) ((HashMap) this.i).remove(r0);     // Catch: Exception -> L22
        if (r8 != null) goto L6;
        if (r2 == null) goto L6;
        r8 = (Fragment) r2.get();     // Catch: Exception -> L22
    L6:
        if (r8 == null) goto L12;
        FragmentTransaction r3 = this.d.beginTransaction();     // Catch: Exception -> L22
        if (r1 == null) goto L10;
        r3.setCustomAnimations(r1.a, r1.b, r1.c, r1.d);     // Catch: Exception -> L22
    L10:
        r3.remove(r8).commitAllowingStateLoss();     // Catch: Exception -> L22
    L12:
        if (this.d.isStateSaved() == false) goto L15;
        com.ss.android.lark.officesdk.utils.di.j.f(this.a, "Can not perform this action after onSaveInstanceState");     // Catch: Exception -> L22
        return;
    L15:
        int r9 = this.d.getBackStackEntryCount() - 1;     // Catch: Exception -> L22
    L16:
        if (r9 < 0) goto L29;
        if (r0.equals(this.d.getBackStackEntryAt(r9).getName()) == true) goto L19;
        r9 = r9 - 1;
        goto L16
    L19:
        this.d.popBackStack(r0, 1);     // Catch: Exception -> L22
        return;
    L29:
        return;
    L22:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c(this.a, "onDestroy: ", e);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final boolean f(f r2) {
        return !((HashMap) this.i).containsKey(n(r2));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View findView(int r2) {
        return this.c.findViewById(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void g(TitleBar r1) {
        this.e = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void j(u r4) {
        c r0 = (c) this.g;
        r0.a();
        if (r4 == null) goto L8;
        Iterator<Pair<Object, Integer>> r5 = r4.a.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        Pair<Object, Integer> r1 = r5.next();
        r0.b(r1.first, ((Integer) r1.second).intValue());
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final void k(c r1) {
        this.g = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final Fragment l(f r2) {
        String r3 = n(r2);
        Fragment r4 = this.d.findFragmentByTag(r3);
        if (r4 != null) goto L5;
    L7:
        return null;
    L5:
        if (r4.isAdded() == false) goto L7;
        return r4;
    }

    public String n(f r1) {
        return r1.getClass().getName();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View findView(Object r2) {
        return this.c.findViewWithTag(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public final View b(f r4, int r5) {
        ViewGroup r0 = c(r4);
        View r6 = this.f.inflate(r5, r0, false);
        h(r4, r6);
        return r6;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void h(f r1, View r2) {
        c(r1).addView(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void i(f r2, Fragment r3) {
        e(r2, r3, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void m(f r1, View r2) {
        c(r1).removeView(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.t
    public void e(f r7, Fragment r8, s r9) {
        String r0 = n(r7);     // Catch: Exception -> L13
        FragmentTransaction r1 = this.d.beginTransaction();     // Catch: Exception -> L13
        if (r9 == null) goto L7;
        r1.setCustomAnimations(r9.a, r9.b, r9.c, r9.d);     // Catch: Exception -> L13
        if (r9.e == false) goto L7;
        r1.addToBackStack(r0);     // Catch: Exception -> L13
    L7:
        ((HashMap) this.h).put(r0, r9);     // Catch: Exception -> L13
        Map<String, WeakReference<Fragment>> r10 = this.i;     // Catch: Exception -> L13
        HashMap r11 = (HashMap) r10;     // Catch: Exception -> L13
        r11.put(r0, new WeakReference(r8));     // Catch: Exception -> L13
        int r12 = c(r7).getId();     // Catch: Exception -> L13
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r0, r12) == true) goto L11;
        r1.replace(r12, r8, r0);     // Catch: Exception -> L13
    L11:
        r1.commitAllowingStateLoss();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c(this.a, "addOrReplaceFragment: ", e);
    }

    public r(Context r3, View r4, FragmentManager r5, TitleBar r6) {
        this.a = "BaseUIContainer#" + Integer.toHexString(hashCode());
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = LayoutInflater.from(r3);
        this.h = new HashMap();
        this.i = new HashMap();
    }
}
