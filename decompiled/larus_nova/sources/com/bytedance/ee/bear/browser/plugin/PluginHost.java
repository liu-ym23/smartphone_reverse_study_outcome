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
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;

/* JADX INFO: loaded from: classes16.dex */
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

        ViewGroup getContainer(int r100);

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
        WeakReference<a> r100 = this.delegateRef;
        if (r100 != null) goto L5;
    L7:
        return null;
    L5:
        if (r100.get() == null) goto L7;
        return this.delegateRef.get().getHostFragment();
    }

    public LifecycleOwner getLifecycleOwner() {
        a r100 = this.delegateRef.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLifecycleOwner();
    }

    public yv4.f getPluginMounter() {
        yv4.f r100 = this.pluginMounter;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new yv4.c(this);
    }

    public List<f> getPluginsReadOnly() {
        return Collections.unmodifiableList(this.attachedPlugins);
    }

    public vo5.a getUserComponent() {
        WeakReference<a> r100 = this.delegateRef;
        if (r100 == null) goto L8;
        a r101 = r100.get();
        if (r101 == null) goto L8;
        return r101.ej();
    L8:
        com.ss.android.lark.officesdk.utils.di.j.f(this.TAG, "getUserComponent delegate is null");
        return new h(new k());
    }

    public void onDestroy() {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, LiveCommonConstants.REASON_ON_DEDTROY);
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
        Iterator<f> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        f r101 = r100.next();
        if ((r101 instanceof sa5.d) == false) goto L4;
        if (((sa5.d) r101).onBackPressed() == false) goto L4;
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "Back press consumed by plugin:" + r101);
        return true;
    L11:
        return false;
    }

    public void onDispatchOnPause() {
        Iterator<f> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onPause(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(null);
    }

    public void onDispatchOnResume() {
        Iterator<f> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onResume(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(this);
    }

    public void onDispatchOnStart() {
        Iterator<f> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onStart(this);
        goto L4
    }

    public void onDispatchOnStop() {
        Iterator<f> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onStop(this);
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

    @Override // androidx.lifecycle.ViewModelStoreOwner
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

    public static PluginHost fromFragment(Fragment r100) throws PluginInfoExtractException {
        Bundle r101 = r100.getArguments();
        if (r101 == null) goto L5;
        int r102 = r101.getInt(ARGS_PLUGIN_HOST_HASH, Integer.MIN_VALUE);
    L7:
        if (r102 == Integer.MIN_VALUE) goto L17;
        p r103 = p.d();
        r103.getClass();
        Iterator r104 = new ArrayList(r103.f216634a.values()).iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        PluginHost r105 = (PluginHost) r104.next();
        if (r105.hashCode() != r102) goto L10;
        return r105;
    L15:
        throw new PluginInfoExtractException("No matched plugin host found :" + r102 + "," + r100);
    L17:
        throw new PluginInfoExtractException("No plugin info found :" + r102 + "," + r100);
    L5:
        r102 = Integer.MIN_VALUE;
        goto L7
    }

    public final void addPlugins(n r100) {
        this.pluginsWithMetaData = n.c(this.pluginsWithMetaData, r100);
        t r101 = this.uiContainer;
        if (r101 == null) goto L5;
        t.a r102 = r101.getLayoutStrategy();
        c r103 = (c) r102;
        r103.e(this.pluginsWithMetaData);
    L5:
        getPluginMounter().a(this.pluginsWithMetaData);
    }

    public void attachPlugin(f r100) {
        if (isPluginAttached(r100) == true) goto L8;
        this.attachedPlugins.add(r100);
        r100.onAttachToHost(this);
        if (this.uiContainer == null) goto L9;
        attachPluginUIContainer(r100);
        return;
    L9:
        return;
    }

    public void attachPluginUIContainer(f r100) {
        r100.onAttachToUIContainer(this, this.uiContainer);
    }

    public void detachPlugin(f r100) {
        if (this.attachedPlugins.contains(r100) == false) goto L9;
        this.attachedPlugins.remove(r100);
        if (this.uiContainer == null) goto L7;
        detachPluginUIContainer(r100);
    L7:
        r100.onDetachFromHost(this);
        return;
    }

    public void detachPluginUIContainer(f r100) {
        r100.onDetachFromUIContainer(this, this.uiContainer);
    }

    public <T> T findActivityDelegate(Class<T> r100) {
        return (T) sa5.m.a.a(this.activity, r100);
    }

    public <P extends f<?>> P findPlugin(Class<P> r100) {
        if (r100 == null) goto L15;
        Iterator r101 = ((ArrayList) this.pluginsWithMetaData.f216628b).iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        f r102 = (f) r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == true) goto L9;
        if ((r102 instanceof e) == false) goto L6;
        f<?> r103 = ((e) r102).findPluginInner(r100);
        if (r103 == null) goto L6;
        Pair r104 = new Pair(r102, r103);
    L16:
        if (r104 == null) goto L18;
        getPluginMounter().c((f) r104.getFirst());
    L19:
        if (r104 != null) goto L22;
        return null;
    L22:
        return (P) r104.getSecond();
    L18:
        com.ss.android.lark.officesdk.utils.di.j.f(this.TAG, "Plugin not found with type:" + r100);
        goto L19
    L9:
        r104 = new Pair(r102, r102);
    L15:
        r104 = null;
        goto L16
    }

    public f findPluginByInterface(Class<?> r100) {
        if (r100 == null) goto L14;
        Iterator<f> r101 = this.pluginsWithMetaData.f216628b.iterator();
    L6:
        if (r101.hasNext() == false) goto L15;
        f r102 = r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L6;
        return r102;
    L15:
        return null;
    L14:
        return null;
    }

    public ViewGroup getContainer(int r100) {
        a r101 = getDelegate();
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getContainer(r100);
    }

    public <T extends i> T getHostAbility(Class<T> r100) {
        T r101 = (T) getHostAbilityOrNull(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("No host ability:" + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends i> T getHostAbilityOrNull(Class<T> r100) {
        Iterator<i> r101 = this.hostAbilities.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        T r102 = (T) r101.next();
        if (r100.isInstance(r102) == false) goto L4;
        getPluginMounter().b(r102);
        return r102;
    L10:
        if (r100.isInstance(this) == true) goto L12;
        return null;
    L12:
        return (T) this;
    }

    public boolean isPluginAttached(f r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.attachedPlugins.contains(r100) == false) goto L6;
        return true;
    }

    public void onCreate(a r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, WidgetCostModule.TYPE_ON_CREATE);
        setDelegate(r100);
        this.activity = r100.getActivity();
        this.destroyed = false;
        this.pluginsWithMetaData = new n(new n.a[0]);
    }

    public void onDispatchConfigurationChanged(Configuration r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchConfigurationChanged");
        Iterator<f> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onConfigurationChanged(r100);
        goto L4
    }

    public void onDispatchUIAttach(t r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchUIAttach");
        this.uiContainer = r100;
        r100.j(this.savedUIState);
        t.a r101 = r100.getLayoutStrategy();
        c r102 = (c) r101;
        r102.e(this.pluginsWithMetaData);
        Iterator<f> r103 = this.attachedPlugins.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        attachPluginUIContainer(r103.next());
        goto L4
    }

    public void onDispatchUIDetach(t r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchUIDetach");
        this.savedUIState = r100.saveUIState();
        Iterator<f> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        detachPluginUIContainer(r101.next());
        goto L4
    L6:
        this.uiContainer = null;
    }

    public void onDispatchUserVisibleHint(boolean r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchUserVisibleHint:" + r100);
        Iterator<f> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setUserVisibleHint(r100);
        goto L4
    }

    public void registerHostAbility(i r100) {
        if (this.hostAbilities.contains(r100) == true) goto L6;
        this.hostAbilities.add(r100);
        return;
    }

    public void setDelegate(a r100) {
        this.delegateRef = new WeakReference(r100);
    }

    public void setPluginMounter(yv4.f r100) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "setPluginMounter:" + r100);
        this.pluginMounter = r100;
    }

    public void unregisterHostAbility(i r100) {
        this.hostAbilities.remove(r100);
    }

    public static <Host> Host fromFragment(Fragment r100, Class<Host> r101) throws PluginInfoExtractException {
        Host r102 = (Host) fromFragment(r100);
        if (r102.getClass().isAssignableFrom(r101) == false) goto L6;
        return r102;
    L6:
        throw new PluginInfoExtractException("fromFragment");
    }

    public static void writePluginHostToBundle(Fragment r100, Bundle r101) {
        writePluginHostToBundle(r101, fromFragment(r100));     // Catch: PluginInfoExtractException -> L4
        return;
    L4:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d(TAG_CLASS, e);
    }

    public <P extends f<?>> void findPluginToDo(Class<P> r100, g<P> r101) {
        f r102 = findPlugin(r100);
        if (r102 == null) goto L7;
        if (r101 == null) goto L8;
        r101.a(r102);
        return;
    L8:
        return;
    }

    public static void writePluginHostToBundle(Bundle r100, PluginHost r101) {
        r100.putInt(ARGS_PLUGIN_HOST_HASH, r101.hashCode());
    }

    public static void writePluginHostToBundle(Bundle r100, f r101) {
        writePluginHostToBundle(r100, r101.getHost());
    }

    public void onDispatchActivityResult(int r100, int r101, Intent r102) {
        com.ss.android.lark.officesdk.utils.di.j.e(this.TAG, "onDispatchActivityResult:" + r100 + "," + r101);
        Iterator<f> r103 = this.attachedPlugins.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        f r104 = r103.next();
        if ((r104 instanceof sa5.a) == false) goto L4;
        ((sa5.a) r104).onActivityResult(r100, r101, r102);
        goto L4
    }
}
