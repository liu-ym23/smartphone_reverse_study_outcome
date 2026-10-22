package com.bytedance.ee.bear.browser.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PluginHost implements ViewModelStoreOwner {
    private static final String ARGS_PLUGIN_HOST_HASH = "Browser#PluginHostHash";
    private static final String TAG_CLASS = "PluginHost";
    protected final String TAG;
    private FragmentActivity activity;
    private final List<f> attachedPlugins;
    private WeakReference<a> delegateRef;
    private boolean destroyed;
    private final List<i> hostAbilities;
    private yv4.f pluginMounter;
    private n pluginsWithMetaData;
    private u savedUIState;
    private t uiContainer;
    protected ViewModelStore viewModelStore;

    public interface a {
        vo5.a ej();

        FragmentActivity getActivity();

        ViewGroup getContainer(int r1);

        Fragment getHostFragment();

        LifecycleOwner getLifecycleOwner();

        o getPluginListProvider();
    }

    public interface b {
        PluginHost createPluginHost();
    }

    private void checkState() {
    }

    public a getDelegate() {
        return this.delegateRef.get();
    }

    public Fragment getHostFragment() {
        WeakReference<a> r0 = this.delegateRef;
        if (r0 != null) goto L5;
    L7:
        return null;
    L5:
        if (r0.get() == null) goto L7;
        return this.delegateRef.get().getHostFragment();
    }

    public LifecycleOwner getLifecycleOwner() {
        a r0 = this.delegateRef.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getLifecycleOwner();
    }

    public yv4.f getPluginMounter() {
        yv4.f r0 = this.pluginMounter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new yv4.c(this);
    }

    public List<f> getPluginsReadOnly() {
        return Collections.unmodifiableList(this.attachedPlugins);
    }

    public vo5.a getUserComponent() {
        WeakReference<a> r0 = this.delegateRef;
        if (r0 == null) goto L8;
        a r1 = r0.get();
        if (r1 == null) goto L8;
        return r1.ej();
    L8:
        com.ss.android.lark.officesdk.utils.di.j.f(this.TAG, "getUserComponent delegate is null");
        return new h(new k());
    }

    public void onDestroy() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDestroy");
    L4:
        if (this.attachedPlugins.isEmpty() == true) goto L6;
        detachPlugin((f) ListProtector.get(this.attachedPlugins, 0));
        goto L4
    L6:
        getViewModelStore().clear();
        getPluginMounter().release();
        this.destroyed = true;
    }

    public boolean onDispatchBackPressed() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchBackPressed");
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        f r1 = r0.next();
        if ((r1 instanceof sa5.d) == false) goto L4;
        if (((sa5.d) r1).onBackPressed() == false) goto L4;
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "Back press consumed by plugin:" + r1);
        return true;
    L11:
        return false;
    }

    public void onDispatchOnPause() {
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPause(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(null);
    }

    public void onDispatchOnResume() {
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onResume(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(this);
    }

    public void onDispatchOnStart() {
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStart(this);
        goto L4
    }

    public void onDispatchOnStop() {
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onStop(this);
        goto L4
    }

    public PluginHost() {
        this.TAG = "PluginHost#" + Integer.toHexString(hashCode());
        this.attachedPlugins = new CopyOnWriteArrayList();
        this.viewModelStore = new ViewModelStore();
        this.hostAbilities = new ArrayList();
    }

    public Context getContext() {
        return getActivity();
    }

    public ViewModelStore getViewModelStore() {
        checkState();
        return this.viewModelStore;
    }

    public FragmentActivity getActivity() {
        return this.activity;
    }

    public t getUIContainer() {
        return this.uiContainer;
    }

    public boolean isDestroyed() {
        return this.destroyed;
    }

    public static PluginHost fromFragment(Fragment r5) throws PluginInfoExtractException {
        Bundle r0 = r5.getArguments();
        if (r0 == null) goto L5;
        int r1 = r0.getInt(ARGS_PLUGIN_HOST_HASH, ShareItemModel.SRC_TINT_UNDEFINED);
    L7:
        if (r1 == Integer.MIN_VALUE) goto L17;
        p r2 = p.d();
        r2.getClass();
        Iterator r3 = new ArrayList(r2.a.values()).iterator();
    L10:
        if (r3.hasNext() == false) goto L15;
        PluginHost r4 = (PluginHost) r3.next();
        if (r4.hashCode() != r1) goto L10;
        return r4;
    L15:
        throw new PluginInfoExtractException("No matched plugin host found :" + r1 + "," + r5);
    L17:
        throw new PluginInfoExtractException("No plugin info found :" + r1 + "," + r5);
    L5:
        r1 = ShareItemModel.SRC_TINT_UNDEFINED;
        goto L7
    }

    public final void addPlugins(n r2) {
        this.pluginsWithMetaData = n.c(this.pluginsWithMetaData, r2);
        t r3 = this.uiContainer;
        if (r3 == null) goto L5;
        t.a r4 = r3.getLayoutStrategy();
        c r5 = (c) r4;
        r5.e(this.pluginsWithMetaData);
    L5:
        getPluginMounter().a(this.pluginsWithMetaData);
    }

    public void attachPlugin(f r2) {
        if (isPluginAttached(r2) == true) goto L8;
        this.attachedPlugins.add(r2);
        r2.onAttachToHost(this);
        if (this.uiContainer == null) goto L9;
        attachPluginUIContainer(r2);
        return;
    L9:
        return;
    }

    public void attachPluginUIContainer(f r2) {
        r2.onAttachToUIContainer(this, this.uiContainer);
    }

    public void detachPlugin(f r2) {
        if (this.attachedPlugins.contains(r2) == false) goto L9;
        this.attachedPlugins.remove(r2);
        if (this.uiContainer == null) goto L7;
        detachPluginUIContainer(r2);
    L7:
        r2.onDetachFromHost(this);
        return;
    }

    public void detachPluginUIContainer(f r2) {
        r2.onDetachFromUIContainer(this, this.uiContainer);
    }

    public <T> T findActivityDelegate(Class<T> r2) {
        return (T) sa5.m.a.a(this.activity, r2);
    }

    public <P extends f<?>> P findPlugin(Class<P> r6) {
        if (r6 == null) goto L15;
        Iterator r1 = ((ArrayList) this.pluginsWithMetaData.b).iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        f r2 = (f) r1.next();
        if (r6.isAssignableFrom(r2.getClass()) == true) goto L9;
        if ((r2 instanceof e) == false) goto L6;
        f<?> r3 = ((e) r2).findPluginInner(r6);
        if (r3 == null) goto L6;
        Pair r4 = new Pair(r2, r3);
    L16:
        if (r4 == null) goto L18;
        getPluginMounter().c((f) r4.getFirst());
    L19:
        if (r4 != null) goto L22;
        return null;
    L22:
        return (P) r4.getSecond();
    L18:
        com.ss.android.lark.officesdk.utils.di.j.f(this.TAG, "Plugin not found with type:" + r6);
        goto L19
    L9:
        r4 = new Pair(r2, r2);
    L15:
        r4 = null;
        goto L16
    }

    public f findPluginByInterface(Class<?> r5) {
        if (r5 == null) goto L14;
        Iterator<f> r1 = this.pluginsWithMetaData.b.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        f r2 = r1.next();
        if (r5.isAssignableFrom(r2.getClass()) == false) goto L6;
        return r2;
    L15:
        return null;
    L14:
        return null;
    }

    public ViewGroup getContainer(int r2) {
        a r0 = getDelegate();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getContainer(r2);
    }

    public <T extends i> T getHostAbility(Class<T> r4) {
        T r0 = (T) getHostAbilityOrNull(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("No host ability:" + r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends i> T getHostAbilityOrNull(Class<T> r4) {
        Iterator<i> r0 = this.hostAbilities.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        T r1 = (T) r0.next();
        if (r4.isInstance(r1) == false) goto L4;
        getPluginMounter().b(r1);
        return r1;
    L10:
        if (r4.isInstance(this) == true) goto L12;
        return null;
    L12:
        return (T) this;
    }

    public boolean isPluginAttached(f r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.attachedPlugins.contains(r2) == false) goto L6;
        return true;
    }

    public void onCreate(a r3) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onCreate");
        setDelegate(r3);
        this.activity = r3.getActivity();
        this.destroyed = false;
        this.pluginsWithMetaData = new n(new n.a[0]);
    }

    public void onDispatchConfigurationChanged(Configuration r3) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchConfigurationChanged");
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onConfigurationChanged(r3);
        goto L4
    }

    public void onDispatchUIAttach(t r3) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchUIAttach");
        this.uiContainer = r3;
        r3.j(this.savedUIState);
        t.a r4 = r3.getLayoutStrategy();
        c r5 = (c) r4;
        r5.e(this.pluginsWithMetaData);
        Iterator<f> r6 = this.attachedPlugins.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        attachPluginUIContainer(r6.next());
        goto L4
    }

    public void onDispatchUIDetach(t r3) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchUIDetach");
        this.savedUIState = r3.saveUIState();
        Iterator<f> r4 = this.attachedPlugins.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        detachPluginUIContainer(r4.next());
        goto L4
    L6:
        this.uiContainer = null;
    }

    public void onDispatchUserVisibleHint(boolean r4) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchUserVisibleHint:" + r4);
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().setUserVisibleHint(r4);
        goto L4
    }

    public void registerHostAbility(i r2) {
        if (this.hostAbilities.contains(r2) == true) goto L6;
        this.hostAbilities.add(r2);
        return;
    }

    public void setDelegate(a r2) {
        this.delegateRef = new WeakReference(r2);
    }

    public void setPluginMounter(yv4.f r4) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "setPluginMounter:" + r4);
        this.pluginMounter = r4;
    }

    public void unregisterHostAbility(i r2) {
        this.hostAbilities.remove(r2);
    }

    public static <Host> Host fromFragment(Fragment r1, Class<Host> r2) throws PluginInfoExtractException {
        Host r3 = (Host) fromFragment(r1);
        if (r3.getClass().isAssignableFrom(r2) == false) goto L6;
        return r3;
    L6:
        throw new PluginInfoExtractException("fromFragment");
    }

    public static void writePluginHostToBundle(Fragment r0, Bundle r1) {
        writePluginHostToBundle(r1, fromFragment(r0));     // Catch: PluginInfoExtractException -> L4
        return;
    L4:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d(TAG_CLASS, e);
    }

    public <P extends f<?>> void findPluginToDo(Class<P> r1, g<P> r2) {
        f r3 = findPlugin(r1);
        if (r3 == null) goto L7;
        if (r2 == null) goto L8;
        r2.a(r3);
        return;
    L8:
        return;
    }

    public static void writePluginHostToBundle(Bundle r1, PluginHost r2) {
        r1.putInt(ARGS_PLUGIN_HOST_HASH, r2.hashCode());
    }

    public static void writePluginHostToBundle(Bundle r0, f r1) {
        writePluginHostToBundle(r0, r1.getHost());
    }

    public void onDispatchActivityResult(int r4, int r5, Intent r6) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchActivityResult:" + r4 + "," + r5);
        Iterator<f> r0 = this.attachedPlugins.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        f r1 = r0.next();
        if ((r1 instanceof sa5.a) == false) goto L4;
        ((sa5.a) r1).onActivityResult(r4, r5, r6);
        goto L4
    }
}
