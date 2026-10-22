package com.bytedance.ee.bear.document.edit_toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.edit.component.toolbar2.a0;
import com.bytedance.ee.bear.edit.component.toolbar2.z;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.j;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocToolbarV2Compat extends ViewModel implements a0, NonProguard {
    private static final String INSERT_IMAGE = "insertImage";
    private static final String TAG = "DocToolbarV2Compat";
    private final long DELAY_TIME;
    private ArrayMap<String, FragmentManager.FragmentLifecycleCallbacks> callbacksMap;
    private FragmentManager.FragmentLifecycleCallbacks forsetiFragmentLifecycleCallbacks;
    private final MutableLiveData<Boolean> handleKeyboard;
    private Observer<Boolean> handleKeyboardObserver;
    private PluginHost pluginHost;
    private ArraySet<String> registerSet;
    private final MutableLiveData<String> showingPanel;
    private Observer<String> showingPanelObserver;
    private a0.a toolbarV2Delegate;

    public class a extends FragmentManager.FragmentLifecycleCallbacks {
        public final /* synthetic */ DocToolbarV2Compat a;

        public a(DocToolbarV2Compat r1) {
            this.a = r1;
        }

        public final void onFragmentViewDestroyed(FragmentManager r1, Fragment r2) {
            super.onFragmentViewDestroyed(r1, r2);
            DocToolbarV2Compat.access$100(this.a, r2);
        }

        public final void onFragmentCreated(FragmentManager r1, Fragment r2, Bundle r3) {
            super.onFragmentCreated(r1, r2, r3);
            DocToolbarV2Compat.access$000(this.a, r2);
        }
    }

    public class b implements LifecycleEventObserver {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ DocToolbarV2Compat b;

        public b(DocToolbarV2Compat r1, FragmentActivity r2) {
            this.b = r1;
            this.a = r2;
        }

        public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
            tt5.a.h(DocToolbarV2Compat.TAG, "host onStateChanged() called with: source = [" + r3 + "], event = [" + r4 + "]");
            if (r4 != Lifecycle.Event.ON_DESTROY) goto L6;
            r3.getLifecycle().removeObserver(this);
            rcb.c.c(this.a);
            return;
        L6:
            if (r4 != Lifecycle.Event.ON_STOP) goto L15;
            tt5.a.h(DocToolbarV2Compat.TAG, "hide all toolbar");
            if (DocToolbarV2Compat.access$200(this.b) != null) goto L10;
            return;
        L10:
            if (this.b.hasShowingPanel() == true) goto L12;
            DocToolbarV2Compat.access$200(this.b).hideAllToolbar();
            return;
        L12:
            tt5.a.d(DocToolbarV2Compat.TAG, "showing insert image");
            return;
        }
    }

    public static /* synthetic */ void Mo(DocToolbarV2Compat r0, FragmentActivity r1, PluginHost r2, Boolean r3) {
        r0.lambda$attach$2(r1, r2, r3);
    }

    public static /* synthetic */ void No(FragmentActivity r0) {
        lambda$attach$1(r0);
    }

    public static /* synthetic */ void yo(String r0) {
        lambda$attach$0(r0);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public void onToolbarItemClick(String r1) {
    }

    private FragmentManager.FragmentLifecycleCallbacks generateFragmentLifecycleCallbacks() {
        return new a(this);
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public void forceClearToolbar() {
        a0.a r0 = this.toolbarV2Delegate;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public boolean hasShowingPanel() {
        if (this.showingPanel.getValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public void hideAllToolbar() {
        a0.a r0 = this.toolbarV2Delegate;
        if (r0 == null) goto L6;
        r0.hideAllToolbar();
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public boolean isShowingFunctionPanel() {
        if (this.showingPanel.getValue() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public boolean onKeyboardToolbarItemClick() {
        a0.a r0 = this.toolbarV2Delegate;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.a() == false) goto L10;
        handleKeyboard(true);
        return true;
    L10:
        return false;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public void onToolbarChanged() {
        a0.a r0 = this.toolbarV2Delegate;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b() == true) goto L7;
        return;
    L7:
        if (this.toolbarV2Delegate.d() == true) goto L9;
        return;
    L9:
        if (this.showingPanel.getValue() != null) goto L15;
        tt5.a.h(TAG, "onToolbarChanged: keyboard arise");
        handleKeyboard(true);
        return;
    }

    public DocToolbarV2Compat() {
        this.registerSet = new ArraySet(4);
        this.callbacksMap = new ArrayMap(2);
        if (AppInfoUtils.f().booleanValue() == false) goto L5;
        this.DELAY_TIME = 100;
    L6:
        this.showingPanel = new MutableLiveData();
        this.handleKeyboard = new MutableLiveData();
        return;
    L5:
        this.DELAY_TIME = 50;
        goto L6
    }

    public static /* synthetic */ a0.a access$200(DocToolbarV2Compat r0) {
        return r0.toolbarV2Delegate;
    }

    private void handleOnFragmentCreated(Fragment r4) {
        tt5.a.b(TAG, "onFragmentCreated: ".concat(r4.getClass().getName()));
        if (isFunctionPanel(r4) == true) goto L10;
        return;
    L10:
        setShowingPanel(r4.getClass().getName());     // Catch: Exception -> L7
        notifyFunctionPanelShowingChanged(true);     // Catch: Exception -> L7
        handleKeyboard(false);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.e(TAG, "onFragmentCreated: ", e, false);
    }

    private void handleOnFragmentViewDestroyed(Fragment r5) {
        tt5.a.b(TAG, "onFragmentViewDestroyed: ".concat(r5.getClass().getName()));
    L16:
        e = move-exception;
        tt5.a.e(TAG, "onFragmentCreated: ", e, false);
        return;
    L4:
        if (isFunctionPanel(r5) == true) goto L6;
        return;
    L6:
        if (TextUtils.equals((CharSequence) this.showingPanel.getValue(), r5.getClass().getName()) == false) goto L22;
        setShowingPanel(null);     // Catch: Exception -> L16
        if ((r5 instanceof a0.b) == false) goto L11;
        handleKeyboard(((a0.b) r5).f9());     // Catch: Exception -> L16
    L14:
        notifyFunctionPanelShowingChanged(false);     // Catch: Exception -> L16
        return;
    L11:
        if ((r5 instanceof an4.c) == false) goto L13;
        handleKeyboard(((an4.c) r5).shouldHandleKeyboardOnDismiss());     // Catch: Exception -> L16
        goto L14
    L13:
        handleKeyboard(true);     // Catch: Exception -> L16
        goto L14
    }

    private static boolean isFunctionPanel(Fragment r2) {
        Bundle r3 = r2.getArguments();
        if (r3 != null) goto L5;
        return false;
    L5:
        return r3.getBoolean("key_is_function_panel", false);
    }

    private static /* synthetic */ void lambda$attach$0(String r2) {
        tt5.a.d(TAG, "showingPanelObserver onChanged: " + r2);
    }

    private static /* synthetic */ void lambda$attach$1(FragmentActivity r0) {
        rcb.c.g(r0);
    }

    private void notifyFunctionPanelShowingChanged(boolean r2) {
        PluginHost r3 = this.pluginHost;
        if (r3 != null) goto L5;
        return;
    L5:
        z r4 = (z) r3.getHostAbilityOrNull(z.class);
        if (r4 == null) goto L9;
        r4.kg();
        return;
    }

    public static a0 of(FragmentActivity r1) {
        return ViewModelProviders.of(r1).get(DocToolbarV2Compat.class);
    }

    private void registerFragmentLifecycleCallbacks(FragmentManager r3) {
        FragmentManager.FragmentLifecycleCallbacks r0 = generateFragmentLifecycleCallbacks();
        r3.registerFragmentLifecycleCallbacks(r0, false);
        this.callbacksMap.put(String.valueOf(r3.hashCode()), r0);
    }

    private void unregisterFragmentLifecycleCallbacks(FragmentManager r3) {
        if (r3 == null) goto L7;
        FragmentManager.FragmentLifecycleCallbacks r0 = (FragmentManager.FragmentLifecycleCallbacks) this.callbacksMap.get(String.valueOf(r3.hashCode()));
        if (r0 == null) goto L8;
        r3.unregisterFragmentLifecycleCallbacks(r0);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public void detach(PluginHost r2) {
        unregisterFragmentLifecycleCallbacks(r2.getActivity().getSupportFragmentManager());
        unregisterFragmentLifecycleCallbacks(r2.getUIContainer().getFragmentManager());
        if (ForsetiHelper.s(r2.getHostFragment()) == false) goto L5;
        unregisterFragmentLifecycleCallbacksInForseti(r2.getActivity(), this.forsetiFragmentLifecycleCallbacks);
    L5:
        this.showingPanel.removeObserver(this.showingPanelObserver);
        this.handleKeyboard.removeObserver(this.handleKeyboardObserver);
        this.showingPanel.setValue(null);
        this.handleKeyboard.setValue(null);
        this.toolbarV2Delegate = null;
        this.pluginHost = null;
    }

    public void handleKeyboard(boolean r2) {
        this.handleKeyboard.setValue(Boolean.valueOf(r2));
    }

    public void setShowingPanel(String r3) {
        this.showingPanel.setValue(r3);
        tt5.a.h(TAG, "showingPanel: " + r3);
    }

    public static /* synthetic */ void access$000(DocToolbarV2Compat r0, Fragment r1) {
        r0.handleOnFragmentCreated(r1);
    }

    public static /* synthetic */ void access$100(DocToolbarV2Compat r0, Fragment r1) {
        r0.handleOnFragmentViewDestroyed(r1);
    }

    private void unregisterFragmentLifecycleCallbacksInForseti(FragmentActivity r3, FragmentManager.FragmentLifecycleCallbacks r4) {
        sua.a r0 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r0 == null) goto L11;
        if (r3 == null) goto L12;
        tua.b r5 = r0.tryGetChainManager(r3);
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.forsetiFragmentLifecycleCallbacks == null) goto L14;
        tt5.a.h(TAG, "unregisterFragmentLifecycleCallbacksInForseti");
        r5.B(r4);
        return;
    L14:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.a0
    public void attach(final PluginHost r3, a0.a r4) {
        this.pluginHost = r3;
        this.toolbarV2Delegate = r4;
        final FragmentActivity r5 = r3.getActivity();
        registerFragmentLifecycleCallbacks(r5.getSupportFragmentManager());
        registerFragmentLifecycleCallbacks(r3.getUIContainer().getFragmentManager());
        if (ForsetiHelper.s(r3.getHostFragment()) == false) goto L9;
        sua.a r0 = (sua.a) ApiUtils.getApi(sua.a.class);
        if (r0 == null) goto L9;
        tua.b r1 = r0.tryGetChainManager(r5);
        if (r1 == null) goto L9;
        FragmentManager.FragmentLifecycleCallbacks r2 = generateFragmentLifecycleCallbacks();
        this.forsetiFragmentLifecycleCallbacks = r2;
        r1.S(r2);
    L9:
        Lifecycle r6 = r5.getLifecycle();
        if (r3.getLifecycleOwner() == null) goto L12;
        r6 = r3.getLifecycleOwner().getLifecycle();
    L12:
        r6.addObserver(new b(this, r5));
        MutableLiveData<String> r7 = this.showingPanel;
        Observer<String> r8 = new c();
        this.showingPanelObserver = r8;
        r7.observeForever(r8);
        MutableLiveData<Boolean> r9 = this.handleKeyboard;
        Observer<Boolean> r10 = new d(this, r5, r3);
        this.handleKeyboardObserver = r10;
        r9.observeForever(r10);
    }

    private /* synthetic */ void lambda$attach$2(final FragmentActivity r3, PluginHost r4, Boolean r5) {
        tt5.a.d(TAG, "handleKeyboardObserver onChanged: " + r5);
        if (com.bytedance.ee.util.ui.b.a(r3) == true) goto L6;
        tt5.a.h(TAG, "toolbar : activity isActive: false");
        return;
    L6:
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.booleanValue() == false) goto L17;
        a0.a r6 = this.toolbarV2Delegate;
        if (r6 != null) goto L12;
    L16:
        tt5.a.h(TAG, "toolbar not show!");
    L18:
        a0.a r7 = this.toolbarV2Delegate;
        if (r7 == null) goto L23;
        r7.e();
        return;
    L23:
        return;
    L12:
        if (r6.b() == false) goto L16;
        if (rcb.b.a(r4.getContext()) == true) goto L16;
        j.d(new e(r3), this.DELAY_TIME);
        goto L18
    L17:
        rcb.c.c(r3);
        goto L18
    }
}
