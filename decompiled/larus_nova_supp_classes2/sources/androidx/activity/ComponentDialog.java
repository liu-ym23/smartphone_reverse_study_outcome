package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020 H\u0017J\b\u0010&\u001a\u00020 H\u0017J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0015J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020 H\u0015J\b\u0010,\u001a\u00020 H\u0015J\u0010\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010-\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\u00020\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/activity/ComponentDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "_lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "lifecycleRegistry", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "()V", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "addContentView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "initializeViewTreeOwners", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "onStart", "onStop", "setContentView", "layoutResID", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ComponentDialog extends Dialog implements LifecycleOwner, OnBackPressedDispatcherOwner, SavedStateRegistryOwner {
    private LifecycleRegistry _lifecycleRegistry;
    private final OnBackPressedDispatcher onBackPressedDispatcher;
    private final SavedStateRegistryController savedStateRegistryController;

    public ComponentDialog(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r2 = 0;
        this(r4, r2, 2, null);
    }

    public static /* synthetic */ void a(ComponentDialog r0) {
        onBackPressedDispatcher$lambda$1(r0);
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    @Override // android.app.Dialog
    public void onStart() {
        androidx_activity_ComponentDialog_com_obric_assistant_interaction_impl_window_helpers_ComponentDialogLancet_onStart(this);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry r0 = this._lifecycleRegistry;
        if (r0 != null) goto L6;
        LifecycleRegistry r1 = new LifecycleRegistry(this);
        this._lifecycleRegistry = r1;
        return r1;
    L6:
        return r0;
    }

    public SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    public void androidx_activity_ComponentDialog__onStart$___twin___() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public void initializeViewTreeOwners() {
        Window r0 = getWindow();
        Intrinsics.checkNotNull(r0);
        ViewTreeLifecycleOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0), this);
        Window r1 = getWindow();
        Intrinsics.checkNotNull(r1);
        ViewTreeOnBackPressedDispatcherOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r1), this);
        Window r2 = getWindow();
        Intrinsics.checkNotNull(r2);
        ViewTreeSavedStateRegistryOwner.set(INVOKEVIRTUAL_androidx_activity_ComponentDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r2), this);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle r0 = super.onSaveInstanceState();
        this.savedStateRegistryController.performSave(r0);
        return r0;
    }

    @Override // android.app.Dialog
    public void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    public static View INVOKEVIRTUAL_androidx_activity_ComponentDialog_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void androidx_activity_ComponentDialog_com_obric_assistant_interaction_impl_window_helpers_ComponentDialogLancet_onStart(ComponentDialog r1) {
        r1.androidx_activity_ComponentDialog__onStart$___twin___();
        DialogLancet.handleDialogPreAddViewOnStart(r1, "componentDialog:onStart");
    }

    private static final void onBackPressedDispatcher$lambda$1(ComponentDialog r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        if (Build.VERSION.SDK_INT < 33) goto L5;
        this.onBackPressedDispatcher.setOnBackInvokedDispatcher(getOnBackInvokedDispatcher());
    L5:
        this.savedStateRegistryController.performRestore(r3);
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initializeViewTreeOwners();
        super.setContentView(r2);
    }

    @Override // android.app.Dialog
    public void setContentView(int r1) {
        initializeViewTreeOwners();
        super.setContentView(r1);
    }

    public ComponentDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create(this);
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new f(this));
    }

    @Override // android.app.Dialog
    public void addContentView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initializeViewTreeOwners();
        super.addContentView(r2, r3);
    }

    @Override // android.app.Dialog
    public void setContentView(View r2, ViewGroup.LayoutParams r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        initializeViewTreeOwners();
        super.setContentView(r2, r3);
    }

    public /* synthetic */ ComponentDialog(Context r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        this(r1, r2);
    }
}
