package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.DefaultPluginMounter;
import com.ss.android.lark.chameleon.pluginsystem.plugin.lazy.PluginMounter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public class PluginHost implements ViewModelStoreOwner {
    private static final String ARGS_PLUGIN_HOST_HASH = "Browser#PluginHostHash";
    private static final String TAG_CLASS = "PluginHost";
    protected final String TAG;
    private FragmentActivity activity;
    private final List<Plugin> attachedPlugins;
    private WeakReference<Delegate> delegateRef;
    private boolean destroyed;
    private final List<PluginHostAbility> hostAbilities;
    private PluginMounter pluginMounter;
    private PluginList pluginsWithMetaData;
    private UIState savedUIState;
    private UIContainer uiContainer;
    private final ViewModelStore viewModelStore;

    public interface Delegate {

        /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost$Delegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Fragment $default$getHostFragment(Delegate r100) {
                return null;
            }
        }

        FragmentActivity getActivity();

        Fragment getHostFragment();

        LifecycleOwner getLifecycleOwner();

        PluginListProvider getPluginListProvider();
    }

    public interface Factory {
        PluginHost createPluginHost();
    }

    private void checkState() {
        if (this.destroyed == false) goto L6;
        Log.e(this.TAG, new IllegalStateException("getViewModelStore after destroyed !").toString());
        return;
    }

    public Delegate getDelegate() {
        return this.delegateRef.get();
    }

    public Fragment getHostFragment() {
        WeakReference<Delegate> r100 = this.delegateRef;
        if (r100 != null) goto L5;
    L7:
        return null;
    L5:
        if (r100.get() == null) goto L7;
        return this.delegateRef.get().getHostFragment();
    }

    public LifecycleOwner getLifecycleOwner() {
        Delegate r100 = this.delegateRef.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getLifecycleOwner();
    }

    public PluginMounter getPluginMounter() {
        PluginMounter r100 = this.pluginMounter;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new DefaultPluginMounter(this);
    }

    public List<Plugin> getPluginsReadOnly() {
        return Collections.unmodifiableList(this.attachedPlugins);
    }

    public void onDestroy() {
        Log.i(this.TAG, LiveCommonConstants.REASON_ON_DEDTROY);
    L4:
        if (this.attachedPlugins.isEmpty() == true) goto L6;
        detachPlugin((Plugin) ListProtector.get(this.attachedPlugins, 0));
        goto L4
    L6:
        getViewModelStore().clear();
        getPluginMounter().release();
        this.activity = null;
        this.uiContainer = null;
        this.destroyed = true;
    }

    public boolean onDispatchBackPressed() {
        Log.i(this.TAG, "onDispatchBackPressed");
        Iterator<Plugin> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Plugin r101 = r100.next();
        if ((r101 instanceof BackPressHandler) == false) goto L4;
        if (((BackPressHandler) r101).onBackPressed() == false) goto L4;
        Log.i(this.TAG, "Back press consumed by plugin:" + r101);
        return true;
    L11:
        return false;
    }

    public void onDispatchOnPause() {
        Iterator<Plugin> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onPause(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(null);
    }

    public void onDispatchOnResume() {
        Iterator<Plugin> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onResume(this);
        goto L4
    L6:
        ((PluginHostViewModel) new ViewModelProvider(this.activity).get(PluginHostViewModel.class)).setPluginHost(this);
    }

    public void onDispatchOnStart() {
        Iterator<Plugin> r100 = this.attachedPlugins.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onStart(this);
        goto L4
    }

    public void onDispatchOnStop() {
        Iterator<Plugin> r100 = this.attachedPlugins.iterator();
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

    public UIContainer getUIContainer() {
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
        Iterator<PluginHost> r103 = PluginRuntime.getInstance().allPluginHost().iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        PluginHost r104 = r103.next();
        if (r104.hashCode() != r102) goto L10;
        return r104;
    L15:
        throw new PluginInfoExtractException("No matched plugin host found :" + r102 + "," + r100);
    L17:
        throw new PluginInfoExtractException("No plugin info found :" + r102 + "," + r100);
    L5:
        r102 = Integer.MIN_VALUE;
        goto L7
    }

    public final void addPlugins(PluginList r100) {
        this.pluginsWithMetaData = PluginList.merge(this.pluginsWithMetaData, r100);
        UIContainer r101 = this.uiContainer;
        if (r101 == null) goto L5;
        r101.getLayoutStrategy().updateLayoutStrategy(this.pluginsWithMetaData);
    L5:
        getPluginMounter().mountPlugins(this.pluginsWithMetaData);
    }

    public void attachPlugin(Plugin r100) {
        if (isPluginAttached(r100) == true) goto L8;
        this.attachedPlugins.add(r100);
        r100.onAttachToHost(this);
        if (this.uiContainer == null) goto L9;
        attachPluginUIContainer(r100);
        return;
    L9:
        return;
    }

    public void attachPluginUIContainer(Plugin r100) {
        r100.onAttachToUIContainer(this, this.uiContainer);
    }

    public void detachPlugin(Plugin r100) {
        if (this.attachedPlugins.contains(r100) == false) goto L9;
        this.attachedPlugins.remove(r100);
        if (this.uiContainer == null) goto L7;
        detachPluginUIContainer(r100);
    L7:
        r100.onDetachFromHost(this);
        return;
    }

    public void detachPluginUIContainer(Plugin r100) {
        r100.onDetachFromUIContainer(this, this.uiContainer);
    }

    public <P extends Plugin<?>> P findPlugin(Class<P> r100) {
        if (r100 == null) goto L4;
        P r101 = (P) this.pluginsWithMetaData.findPlugin(r100);
    L5:
        if (r101 == null) goto L7;
        getPluginMounter().onFindPlugin(r101);
    L8:
        return r101;
    L7:
        Log.w(this.TAG, "Plugin not found with type:" + r100);
        goto L8
    L4:
        r101 = null;
        goto L5
    }

    public Plugin findPluginByInterface(Class<?> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return this.pluginsWithMetaData.findPluginByInterface(r100);
    }

    public <T extends PluginHostAbility> T getHostAbility(Class<T> r100) {
        T r101 = (T) getHostAbilityOrNull(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("No host ability:" + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends PluginHostAbility> T getHostAbilityOrNull(Class<T> r100) {
        Iterator<PluginHostAbility> r101 = this.hostAbilities.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        T r102 = (T) r101.next();
        if (r100.isInstance(r102) == false) goto L4;
        getPluginMounter().onFindAbility(r102);
        return r102;
    L10:
        if (r100.isInstance(this) == true) goto L12;
        return null;
    L12:
        return (T) this;
    }

    public boolean isPluginAttached(Plugin r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.attachedPlugins.contains(r100) == false) goto L6;
        return true;
    }

    public void onCreate(Delegate r100) {
        Log.i(this.TAG, WidgetCostModule.TYPE_ON_CREATE);
        setDelegate(r100);
        this.activity = r100.getActivity();
        this.destroyed = false;
        this.pluginsWithMetaData = PluginList.newList(new PluginList.Metadata[0]);
    }

    public void onDispatchConfigurationChanged(Configuration r100) {
        Log.i(this.TAG, "onDispatchConfigurationChanged");
        Iterator<Plugin> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onConfigurationChanged(r100);
        goto L4
    }

    public void onDispatchUIAttach(UIContainer r100) {
        Log.i(this.TAG, "onDispatchUIAttach");
        this.uiContainer = r100;
        r100.restoreUIState(this.savedUIState);
        r100.getLayoutStrategy().updateLayoutStrategy(this.pluginsWithMetaData);
        Iterator<Plugin> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        attachPluginUIContainer(r101.next());
        goto L4
    }

    public void onDispatchUIDetach(UIContainer r100) {
        Log.i(this.TAG, "onDispatchUIDetach");
        this.savedUIState = r100.saveUIState();
        Iterator<Plugin> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        detachPluginUIContainer(r101.next());
        goto L4
    L6:
        this.uiContainer = null;
    }

    public void onDispatchUserVisibleHint(boolean r100) {
        Log.i(this.TAG, "onDispatchUserVisibleHint:" + r100);
        Iterator<Plugin> r101 = this.attachedPlugins.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setUserVisibleHint(r100);
        goto L4
    }

    public void registerHostAbility(PluginHostAbility r100) {
        if (this.hostAbilities.contains(r100) == true) goto L6;
        this.hostAbilities.add(r100);
        return;
    }

    public void setDelegate(Delegate r100) {
        this.delegateRef = new WeakReference(r100);
    }

    public void setPluginMounter(PluginMounter r100) {
        Log.i(this.TAG, "setPluginMounter:" + r100);
        this.pluginMounter = r100;
    }

    public void unregisterHostAbility(PluginHostAbility r100) {
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
        Log.e(TAG_CLASS, e.toString());
    }

    public <P extends Plugin<?>> void findPluginToDo(Class<P> r100, PluginFindAction<P> r101) {
        Plugin r102 = findPlugin(r100);
        if (r102 == null) goto L7;
        if (r101 == null) goto L8;
        r101.onPluginFound(r102);
        return;
    L8:
        return;
    }

    public static void writePluginHostToBundle(Bundle r100, PluginHost r101) {
        r100.putInt(ARGS_PLUGIN_HOST_HASH, r101.hashCode());
    }

    public static void writePluginHostToBundle(Bundle r100, Plugin r101) {
        writePluginHostToBundle(r100, r101.getHost());
    }

    public void onDispatchActivityResult(int r100, int r101, Intent r102) {
        Log.i(this.TAG, "onDispatchActivityResult:" + r100 + "," + r101);
        Iterator<Plugin> r103 = this.attachedPlugins.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Plugin r104 = r103.next();
        if ((r104 instanceof ActivityResultHandler) == false) goto L4;
        ((ActivityResultHandler) r104).onActivityResult(r100, r101, r102);
        goto L4
    }
}
