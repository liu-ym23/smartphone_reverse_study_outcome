package com.bytedance.ee.bear.document.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.g7;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.document.y3;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.pluginapi.ChameleonContextAbility;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;
import vv4.m;
import vv4.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends ChameleonPluginHost {
    public static final Map<c, List<i>> c = null;
    public final DocumentPluginHost a;
    public final LinkedHashSet<i> b;

    public static final class a {
    }

    static {
        c = Collections.synchronizedMap(new IdentityHashMap());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        DocumentPluginHost r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = CollectionsKt.toList(this.b).iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        i r2 = (i) r1.next();
        r0.unregisterHostAbility(r2);
        tt5.a.h(((PluginHost) this).TAG, "release forwarded chameleon ability, ability=".concat(r2.getClass().getSimpleName()));
        goto L7
    L9:
        this.b.clear();
        c.remove(this);
    }

    public final DocumentPluginHost c() {
        DocumentPluginHost r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("DocumentChameleonPluginHostAdapter is not initialized".toString());
    }

    public final int hashCode() {
        DocumentPluginHost r0 = this.a;
        if (r0 == null) goto L6;
        return r0.hashCode();
    L6:
        return super/*java.lang.Object*/.hashCode();
    }

    public FragmentActivity getActivity() {
        return c().getActivity();
    }

    public Context getContext() {
        return c().getContext();
    }

    public final LifecycleOwner getLifecycleOwner() {
        return c().getLifecycleOwner();
    }

    public final t getUIContainer() {
        DocumentPluginHost r0 = c();
        return new d(r0.getUIContainer(), r0);
    }

    public final ViewModelStore getViewModelStore() {
        return c().getViewModelStore();
    }

    public final k getWeb() {
        return c().getWeb();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(DocumentPluginHost r26) {
        Intrinsics.checkNotNullParameter(r26, "documentHost");
        k r1 = r26.getWeb();
        DocViewModel r0 = r26.a();
        Fragment r11 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getUrl();
    L6:
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r2;
        DocViewModel r4 = r26.a();
        if (r4 == null) goto L11;
        String r14 = r4.getUrl();
    L12:
        super(r1, r3, new ChameleonConfig(null, r14, null, null, null, null, null, null, null, null, 1021, null), "", new n(), null, 32, null);
        this.b = new LinkedHashSet();
        List<i> r5 = c.remove(this);
        this.a = r26;
        if (r5 == null) goto L18;
        Iterator<T> r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        a(r26, (i) r6.next(), "replay");
    L18:
        DocViewModel r7 = r26.a();
        if (r7 == null) goto L21;
        String r8 = r7.getUrl();
    L22:
        if (r8 != null) goto L24;
    L27:
        boolean r9 = true;
    L28:
        if (r9 == false) goto L30;
        tt5.a.k(((PluginHost) this).TAG, "document host url is empty when building chameleon host adapter");
    L30:
        WebFragment r10 = r26.c();
        if ((r10 instanceof Fragment) == false) goto L33;
        r11 = r10;
    L33:
        if (r11 != null) goto L35;
        r11 = new Fragment();
        tt5.a.k(((PluginHost) this).TAG, "document host has no WebViewFragment, fallback to empty Fragment");
    L35:
        setFragment(r11);
        setLoader(new e());
        return;
    L24:
        if (r8.length() == 0) goto L27;
        r9 = false;
        goto L28
    L21:
        r8 = null;
        goto L22
    L11:
        r14 = null;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        DocumentPluginHost r1 = this.a;
        if (r1 != null) goto L9;
        return false;
    L9:
        if ((r5 instanceof c) == true) goto L11;
    L13:
        return false;
    L11:
        if (Intrinsics.areEqual(r1, ((c) r5).a) == false) goto L13;
        return true;
    }

    public final <P extends com.bytedance.ee.bear.browser.plugin.f<?>> P findPlugin(Class<P> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return (P) c().findPlugin(r2);
    }

    public final com.bytedance.ee.bear.browser.plugin.f<?> findPluginByInterface(Class<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return c().findPluginByInterface(r2);
    }

    public final ViewGroup getContainer(int r2) {
        return c().getContainer(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends i> T getHostAbility(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        T r0 = (T) getHostAbilityOrNull(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return (T) super/*com.bytedance.ee.bear.browser.plugin.PluginHost*/.getHostAbility(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends i> T getHostAbilityOrNull(Class<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "clazz");
        T r0 = (T) c().getHostAbilityOrNull(r5);
        if (r0 != null) goto L40;
        ViewModel r1 = c();
        if (r5.isAssignableFrom(DocumentPluginHost.class) == false) goto L8;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.bytedance.ee.bear.document.adapter.DocumentChameleonPluginHostAdapter.resolveLegacyHostAbility");
    L34:
        if (r1 == null) goto L36;
        tt5.a.h(((PluginHost) this).TAG, "resolve legacy host ability by direct field, ability=".concat(r5.getSimpleName()));
    L37:
        if (r1 == null) goto L39;
        return (T) r1;
    L39:
        return (T) super/*com.bytedance.ee.bear.browser.plugin.PluginHost*/.getHostAbilityOrNull(r5);
    L36:
        r1 = (T) null;
        goto L37
    L8:
        if (r5.isAssignableFrom(g7.class) == false) goto L11;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.bytedance.ee.bear.document.adapter.DocumentChameleonPluginHostAdapter.resolveLegacyHostAbility");
        goto L34
    L11:
        if (r5.isAssignableFrom(e4.class) == false) goto L14;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type T of com.bytedance.ee.bear.document.adapter.DocumentChameleonPluginHostAdapter.resolveLegacyHostAbility");
        goto L34
    L14:
        if (r5.isAssignableFrom(x2.class) == false) goto L19;
        r1 = r1.getDocumentLoader();
        if ((r1 instanceof i) == true) goto L34;
    L33:
        r1 = null;
        goto L34
    L19:
        if (r5.isAssignableFrom(DocViewModel.class) == false) goto L24;
        r1 = r1.a();
        if ((r1 instanceof i) == false) goto L33;
    L24:
        if (r5.isAssignableFrom(y3.class) == false) goto L29;
        r1 = r1.a();
        if ((r1 instanceof i) == false) goto L33;
    L29:
        if (r5.isAssignableFrom(com.bytedance.ee.bear.document.d.class) == false) goto L33;
        r1 = r1.a();
        if ((r1 instanceof i) == false) goto L33;
    L40:
        return r0;
    }

    public final <P extends m> P getWebService(Class<P> r1) {
        return (P) super.getWebService(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void registerHostAbility(i r3) {
        Intrinsics.checkNotNullParameter(r3, "ability");
        super/*com.bytedance.ee.bear.browser.plugin.PluginHost*/.registerHostAbility(r3);
        if ((!(r3 instanceof ChameleonContextAbility)) == false) goto L14;
        DocumentPluginHost r0 = this.a;
        if (r0 != null) goto L11;
        Map<c, List<i>> r1 = c;
        List<i> r2 = r1.get(this);
        if (r2 != null) goto L10;
        r2 = new ArrayList();
        r1.put(this, r2);
    L10:
        r2.add(r3);
        tt5.a.h(((PluginHost) this).TAG, "cache chameleon ability before document host ready, ability=".concat(r3.getClass().getSimpleName()));
        return;
    L11:
        a(r0, r3, "forward");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void unregisterHostAbility(i r3) {
        Intrinsics.checkNotNullParameter(r3, "ability");
        super/*com.bytedance.ee.bear.browser.plugin.PluginHost*/.unregisterHostAbility(r3);
        if ((!(r3 instanceof ChameleonContextAbility)) == false) goto L17;
        DocumentPluginHost r0 = this.a;
        if (r0 != null) goto L11;
        List<i> r1 = c.get(this);
        if (r1 == null) goto L14;
        r1.remove(r3);
        return;
    L14:
        return;
    L11:
        if (this.b.remove(r3) == false) goto L16;
        r0.unregisterHostAbility(r3);
        tt5.a.h(((PluginHost) this).TAG, "unforward chameleon ability, ability=".concat(r3.getClass().getSimpleName()));
        return;
    L16:
        return;
    }

    public final <P extends com.bytedance.ee.bear.browser.plugin.f<?>> void findPluginToDo(Class<P> r2, com.bytedance.ee.bear.browser.plugin.g<P> r3) {
        c().findPluginToDo(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(DocumentPluginHost r2, i r3, String r4) {
        if (this.b.add(r3) == false) goto L6;
        r2.registerHostAbility(r3);
        tt5.a.h(((PluginHost) this).TAG, r4 + " chameleon ability to document host, ability=" + r3.getClass().getSimpleName());
        return;
    }
}
