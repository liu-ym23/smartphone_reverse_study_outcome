package com.bytedance.ies.sdk.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.bytedance.ies.sdk.widgets.inflater.IAsyncExecutor;
import com.bytedance.ies.sdk.widgets.inflater.IAsyncInflater;
import com.bytedance.ies.sdk.widgets.inflater.PriorityAsyncLayoutInflater;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.bytedance.ies.sdk.widgets.info.WidgetInfoHelper;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.sdk.widgets.perf.WidgetPerfManager;
import com.bytedance.ies.sdk.widgets.priority.ContinueLoadTask;
import com.bytedance.ies.sdk.widgets.priority.GroupSchedule;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes19.dex */
public class WidgetManager extends Fragment {
    public static final String TAG = null;
    public IAsyncInflater asyncLayoutInflater;
    public boolean configured;
    public View contentView;
    public Context context;
    public DataCenter dataCenter;
    public FragmentManager.FragmentLifecycleCallbacks parentDestroyedCallback;
    public Fragment parentFragment;
    public LayoutInflater syncLayoutInflater;
    public Widget.WidgetCallback widgetCallback;
    public IWidgetConfigHandler widgetConfigHandler;
    public Map<Widget, ViewGroup> widgetViewGroupHashMap;
    public List<Widget> widgets;

    /* JADX INFO: renamed from: com.bytedance.ies.sdk.widgets.WidgetManager$8, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State = null;

        static {
            int[] r100 = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r100;
            r100[Lifecycle.State.INITIALIZED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.DESTROYED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.RESUMED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class Builder {
        boolean async;
        LoadCallback callback;
        ViewGroup container;
        boolean highAsyncPriority;
        final /* synthetic */ WidgetManager this$0;
        Widget widget;

        public void load() {
            ViewGroup r100 = this.container;
            if (r100 == null) goto L5;
            this.this$0.load(r100, this.widget, this.async, this.callback);
            return;
        L5:
            this.this$0.load(this.widget, this.async, this.highAsyncPriority, this.callback);
        }

        public Builder(WidgetManager r100) {
            this.this$0 = r100;
            this.async = false;
            this.highAsyncPriority = false;
        }

        public Builder async(boolean r100) {
            this.async = r100;
            return this;
        }

        public Builder callback(LoadCallback r100) {
            this.callback = r100;
            return this;
        }

        public Builder container(ViewGroup r100) {
            this.container = r100;
            return this;
        }

        public Builder containerId(int r100) {
            this.container = (ViewGroup) this.this$0.contentView.findViewById(r100);
            return this;
        }

        public Builder highAsyncPriority(boolean r100) {
            this.highAsyncPriority = r100;
            return this;
        }

        public Builder widget(Widget r100) {
            this.widget = r100;
            return this;
        }
    }

    public interface IWidgetConfigHandler {
        void onDestroy(Widget r100);

        void onLoad(Widget r100);

        void onUnload(Widget r100);
    }

    public interface LoadCallback {
        void onLoaded(Widget r100);
    }

    public static /* synthetic */ void S90(WidgetManager r100, Widget r101, ViewGroup r102) {
        r100.lambda$innerLoad$0(r101, r102);
    }

    public static /* synthetic */ void T90(WidgetManager r100, Widget r101) {
        r100.lambda$innerLoad$1(r101);
    }

    public void onLoadByAsync(Widget r100) {
    }

    public void onLoadSuccessByAsync(Widget r100) {
    }

    static {
        TAG = WidgetManager.class.getCanonicalName();
    }

    public Builder builder() {
        return new Builder(this);
    }

    public WidgetManager createSubWidgetManager() {
        WidgetManager r100 = of(this, this.contentView);
        r100.setDataCenter(this.dataCenter);
        r100.setWidgetConfigHandler(this.widgetConfigHandler);
        return r100;
    }

    public WidgetManager() {
        this.widgetCallback = new AnonymousClass1(this);
        this.widgets = new CopyOnWriteArrayList();
        this.widgetViewGroupHashMap = new HashMap();
        this.parentDestroyedCallback = new AnonymousClass2(this);
        this.widgetConfigHandler = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.parentFragment = null;
        if (this.widgetConfigHandler == null) goto L8;
        Iterator<Widget> r100 = this.widgets.iterator();
    L6:
        if (r100.hasNext() == false) goto L8;
        Widget r101 = r100.next();
        this.widgetConfigHandler.onDestroy(r101);
    L8:
        this.widgets.clear();
        this.widgetViewGroupHashMap.clear();
        this.dataCenter = null;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public IWidgetConfigHandler getWidgetConfigHandler() {
        return this.widgetConfigHandler;
    }

    private /* synthetic */ void lambda$innerLoad$1(Widget r100) {
        WidgetPerfManager.getInstance().onPerfEnd(r100, WidgetCostModule.TYPE_INFLATE);
        onLoadSuccessByAsync(r100);
        continueLoad(r100);
    }

    public void continueLoad(Widget r100) {
        WidgetPerfManager.getInstance().onPerfStart(r100, WidgetCostModule.TYPE_ON_CONTINUE_LOAD);
        this.widgets.add(r100);
        getLifecycle().addObserver(r100);
        WidgetPerfManager.getInstance().onPerfEnd(r100, WidgetCostModule.TYPE_ON_CONTINUE_LOAD);
    }

    public WidgetInfo getWidgetInfo(Class<Widget> r100) {
        Iterator<Widget> r101 = this.widgets.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Widget r102 = r101.next();
        if (r102.getClass().equals(r100) == false) goto L4;
    L9:
        if (r102 == null) goto L14;
        View r103 = r102.contentView;
        if (r103 == null) goto L14;
        return WidgetInfoHelper.constructInfo(r103);
    L14:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    public WidgetManager load(Widget r100) {
        return load(r100, false);
    }

    public void mayInsertHandlerQueue(Runnable r100) {
        if (r100 == null) goto L5;
        r100.run();
        return;
    }

    public void mayInsertHighPriorityHandlerQueue(Runnable r100) {
        if (r100 == null) goto L5;
        r100.run();
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        Iterator<Widget> r101 = this.widgets.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onConfigurationChanged(r100);
        goto L4
    }

    public WidgetManager setDataCenter(DataCenter r100) {
        this.dataCenter = r100;
        Iterator<Widget> r101 = this.widgets.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().dataCenter = r100;
        goto L4
    L6:
        return this;
    }

    public WidgetManager setWidgetConfigHandler(IWidgetConfigHandler r100) {
        this.widgetConfigHandler = r100;
        return this;
    }

    public WidgetManager unload(Widget r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        getLifecycle().removeObserver(r100);
        if (r100.isViewValid == false) goto L21;
        Lifecycle.State r101 = getLifecycle().getCurrentState();
        int r102 = AnonymousClass8.$SwitchMap$androidx$lifecycle$Lifecycle$State[r101.ordinal()];
        if (r102 == 2) goto L19;
        if (r102 != 3) goto L11;
        r100.onDestroy();
        goto L21
    L11:
        if (r102 != 4) goto L13;
        r100.onStop();
        r100.onDestroy();
        goto L21
    L13:
        if (r102 != 5) goto L21;
        r100.onPause();
        r100.onStop();
        r100.onDestroy();
        goto L21
    L19:
        if (r100.isDestroyed == true) goto L21;
        r100.onDestroy();
    L21:
        r100.containerView = null;
        r100.context = null;
        r100.widgetCallback = null;
        r100.dataCenter = null;
        IWidgetConfigHandler r103 = this.widgetConfigHandler;
        if (r103 == null) goto L24;
        r103.onUnload(r100);
    L24:
        this.widgets.remove(r100);
        if (this.widgetViewGroupHashMap.containsKey(r100) == false) goto L27;
        this.widgetViewGroupHashMap.get(r100).removeAllViews();
        this.widgetViewGroupHashMap.remove(r100);
    L27:
        return this;
    }

    private /* synthetic */ void lambda$innerLoad$0(Widget r100, ViewGroup r101) {
        continueLoad(r100, r101, r100.getLayoutView());
        WidgetPerfManager.getInstance().onPerfEnd(r100, WidgetCostModule.TYPE_ON_LOAD);
    }

    private void mergeContainerAndContent(Widget r100, View r101) {
        if (r101.getClass() != r100.containerView.getClass()) goto L15;
        ViewGroup r102 = (ViewGroup) r101;
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L6:
        if (r104 >= r102.getChildCount()) goto L8;
        r103.add(r102.getChildAt(r104));
        r104 = r104 + 1;
        goto L6
    L8:
        Iterator r105 = r103.iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        View r106 = (View) r105.next();
        r102.removeView(r106);
        r100.containerView.addView(r106, r106.getLayoutParams());
        goto L10
    L12:
        r100.contentView = r100.containerView;
        return;
    L15:
        throw new WidgetMergeException(r100.getClass() + " 的 containerView 和 contentView 必须是一个类型. 然而现在 contentView 是" + r101.getClass() + "  ,containerView 是" + r100.containerView.getClass());
    }

    public static WidgetManager of(Fragment r100, View r101) {
        WidgetManager r102 = new WidgetManager();
        r102.config(null, r100, r101, r100.getContext());
        return r102;
    }

    public WidgetManager load(int r100, Widget r101) {
        return load(r100, r101, true);
    }

    public static WidgetManager of(FragmentActivity r100, View r101) {
        WidgetManager r102 = new WidgetManager();
        r102.config(r100, null, r101, r100);
        return r102;
    }

    public WidgetManager load(Widget r100, boolean r101) {
        return load(r100, r101, false);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ies_sdk_widgets_WidgetManager_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    private void innerLoad(final ViewGroup r100, final Widget r101, boolean r102) {
        if (r101.getLayoutId() != 0) goto L5;
    L13:
        Runnable r103 = new c(this, r101, r100);
        if (r102 == true) goto L16;
    L21:
        GroupSchedule.getInstance().enqueueContinueLoad(r101, r103);
        return;
    L16:
        if (WidgetService.getInstance().getAsyncExecutor() == null) goto L21;
        if (WidgetService.getInstance().getAsyncExecutor() == null) goto L20;
        WidgetService.getInstance().getAsyncExecutor().execute(r101, r103);
        return;
    L20:
        GroupSchedule.getInstance().enqueueContinueLoad(r101, r103);
        return;
    L5:
        if (r101.getLayoutView() != null) goto L13;
        if (r102 == false) goto L10;
        onLoadByAsync(r101);
        WidgetPerfManager.getInstance().onPerfStart(r101, WidgetCostModule.TYPE_INFLATE);
        this.asyncLayoutInflater.inflate(r101.getLayoutId(), r100, new AnonymousClass4(this, r101, r100));
    L11:
        WidgetPerfManager.getInstance().onPerfEnd(r101, WidgetCostModule.TYPE_ON_LOAD);
        return;
    L10:
        WidgetPerfManager.getInstance().onPerfStart(r101, WidgetCostModule.TYPE_INFLATE);
        final View r104 = this.syncLayoutInflater.inflate(r101.getLayoutId(), r100, false);
        WidgetPerfManager.getInstance().onPerfEnd(r101, WidgetCostModule.TYPE_INFLATE);
        GroupSchedule.getInstance().enqueueContinueLoad(r101, new AnonymousClass5(this, r101, r100, r104));
        goto L11
    }

    public void continueLoad(Widget r100, ViewGroup r101, View r102) {
        if (r100.containerView != null) goto L5;
        return;
    L5:
        WidgetPerfManager.getInstance().onPerfStart(r100, WidgetCostModule.TYPE_ON_CONTINUE_LOAD);
        if (r100.isMergeMode() == false) goto L8;
        mergeContainerAndContent(r100, r102);
    L16:
        this.widgets.add(r100);
        getLifecycle().addObserver(r100);
        WidgetPerfManager.getInstance().onPerfEnd(r100, WidgetCostModule.TYPE_ON_CONTINUE_LOAD);
        return;
    L8:
        r100.contentView = r102;
        if (r101 == null) goto L16;
        if (r102 == null) goto L16;
        r101.addView(r102);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        RuntimeException r103 = new RuntimeException(e.getMessage() + " widget:" + r100.getClass().getName());
        r103.setStackTrace(e.getStackTrace());
        throw r103;
    }

    public WidgetManager load(int r100, Widget r101, boolean r102) {
        return load((ViewGroup) this.contentView.findViewById(r100), r101, r102);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        Iterator<Widget> r103 = this.widgets.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onActivityResult(r100, r101, r102);
        goto L4
    }

    private void innerLoad(final Widget r100, boolean r101, boolean r102) {
        if (r101 == false) goto L9;
        WidgetPerfManager.getInstance().onPerfStart(r100, WidgetCostModule.TYPE_INFLATE);
        onLoadByAsync(r100);
        Runnable r103 = new d(this, r100);
        IAsyncExecutor r104 = WidgetService.getInstance().getAsyncExecutor();
        if (r104 == null) goto L6;
        r104.execute(r100, r103);
    L10:
        WidgetPerfManager.getInstance().onPerfEnd(r100, WidgetCostModule.TYPE_ON_LOAD);
        return;
    L6:
        if (r102 == false) goto L8;
        mayInsertHighPriorityHandlerQueue(new ContinueLoadTask(r100, r103));
        goto L10
    L8:
        mayInsertHandlerQueue(new ContinueLoadTask(r100, r103));
        goto L10
    L9:
        GroupSchedule.getInstance().enqueueContinueLoad(r100, new AnonymousClass7(this, r100));
        goto L10
    }

    public WidgetManager load(ViewGroup r100, Widget r101, boolean r102) {
        if (r101 != null) goto L4;
        return this;
    L4:
        load(r100, r101, r102, null);
        return this;
    }

    public WidgetManager load(Widget r100, boolean r101, boolean r102) {
        return load(r100, r101, r102, null);
    }

    public static /* synthetic */ void access$000(WidgetManager r100, ViewGroup r101, Widget r102, boolean r103) {
        r100.innerLoad(r101, r102, r103);
    }

    public static /* synthetic */ void access$100(WidgetManager r100, Widget r101, boolean r102, boolean r103) {
        r100.innerLoad(r101, r102, r103);
    }

    public void config(FragmentActivity r100, Fragment r101, View r102, Context r110) {
        config(r100, r101, r102, r110, false);
    }

    public WidgetManager load(final ViewGroup r100, final Widget r110, final boolean r111, final LoadCallback r112) {
        if (r110 != null) goto L4;
        return this;
    L4:
        WidgetService.getInstance().aLogI("【widget】", "load widget:" + r110.getClass().getCanonicalName() + "@" + r110.hashCode() + ", async: " + r111);
        r110.setWidgetCallback(this.widgetCallback);
        r110.context = this.context;
        r110.dataCenter = this.dataCenter;
        r110.containerView = r100;
        r110.setStatusAsync(r111);
        boolean r101 = false;
        r110.setStatusRecycle(false);
        if (r110.getLayoutId() == 0) goto L7;
        r101 = true;
    L7:
        r110.setStatusHasUI(r101);
        WidgetPerfManager.getInstance().onPerfStart(r110, WidgetCostModule.TYPE_ON_LOAD);
        this.widgetViewGroupHashMap.put(r110, r100);
        IWidgetConfigHandler r102 = this.widgetConfigHandler;
        if (r102 == null) goto L10;
        r102.onLoad(r110);
    L10:
        GroupSchedule.getInstance().enqueueLoad(r110, new AnonymousClass3(this, r100, r110, r111, r112));
        return this;
    }

    public WidgetManager load(final Widget r100, final boolean r110, final boolean r111, final LoadCallback r112) {
        if (r100 != null) goto L4;
        return this;
    L4:
        WidgetService.getInstance().aLogI("【widget】", "load widget:" + r100.getClass().getCanonicalName() + "@" + r100.hashCode() + ", async: " + r110);
        r100.setWidgetCallback(this.widgetCallback);
        r100.context = this.context;
        r100.dataCenter = this.dataCenter;
        r100.setStatusAsync(r110);
        r100.setStatusRecycle(false);
        r100.setStatusHasUI(false);
        WidgetPerfManager.getInstance().onPerfStart(r100, WidgetCostModule.TYPE_ON_LOAD);
        IWidgetConfigHandler r101 = this.widgetConfigHandler;
        if (r101 == null) goto L7;
        r101.onLoad(r100);
    L7:
        GroupSchedule.getInstance().enqueueLoad(r100, new AnonymousClass6(this, r100, r110, r111, r112));
        return this;
    }

    public void config(FragmentActivity r100, Fragment r101, View r102, Context r103, boolean r104) {
        if (this.configured == false) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        FragmentManager r105 = r100.getSupportFragmentManager();
    L9:
        this.parentFragment = r101;
        this.contentView = r102;
        this.context = r103;
        if (r104 == false) goto L12;
        this.asyncLayoutInflater = new PriorityAsyncLayoutInflater(r103);
    L13:
        this.syncLayoutInflater = LayoutInflater.from(r103);
        if (r101 != null) goto L16;
    L18:
        INVOKEVIRTUAL_com_bytedance_ies_sdk_widgets_WidgetManager_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r105.beginTransaction(), this, TAG).commitNowAllowingStateLoss();
        this.configured = true;
        return;
    L16:
        if (r101.getFragmentManager() == null) goto L18;
        r101.getFragmentManager().registerFragmentLifecycleCallbacks(this.parentDestroyedCallback, false);
        goto L18
    L12:
        this.asyncLayoutInflater = new AsyncLayoutInflater(r103);
        goto L13
    L7:
        if (r101 == null) goto L20;
        r105 = r101.getChildFragmentManager();
        goto L9
    }
}
