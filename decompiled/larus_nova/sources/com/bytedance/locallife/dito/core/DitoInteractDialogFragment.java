package com.bytedance.locallife.dito.core;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 w2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001xB\u0007¢\u0006\u0004\bu\u0010vJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u000bJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020\u000bH\u0007J\u000e\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u0019J\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010%\u001a\u00020\u0019J \u0010)\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u000b2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'J\u0010\u0010+\u001a\u00020\b2\b\b\u0001\u0010*\u001a\u00020\u000bJ\u0010\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0012\u00100\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u00102\u001a\u0002012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0016\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u00106\u001a\u00020\b2\u0006\u00103\u001a\u000205H\u0016J\u0010\u00107\u001a\u00020\b2\u0006\u00103\u001a\u000205H\u0016J\b\u00109\u001a\u0004\u0018\u000108J\u0012\u0010:\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010;\u001a\u00020\bH\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\bH\u0016J\b\u0010?\u001a\u00020\bH\u0016J\b\u0010@\u001a\u00020\bH\u0016R\u0018\u0010B\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\"\u0010G\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010H\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\"\u0010P\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010Q\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR\"\u0010Y\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010H\u001a\u0004\bZ\u0010J\"\u0004\b[\u0010LR$\u0010\\\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010b\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010Q\u001a\u0004\bc\u0010S\"\u0004\bd\u0010UR\"\u0010e\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010Q\u001a\u0004\bf\u0010S\"\u0004\bg\u0010UR\"\u0010h\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010Q\u001a\u0004\bi\u0010S\"\u0004\bj\u0010UR\u0016\u0010k\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010HR\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010lR\u0016\u0010m\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bm\u0010HR$\u0010o\u001a\u0004\u0018\u00010n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006y"}, d2 = {"Lcom/bytedance/locallife/dito/core/DitoInteractDialogFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/os/Bundle;", "savedInstanceState", "Lcom/bytedance/locallife/dito/core/f;", "onCreateDialog", "", "adjustViewHeight", "updateContentBg", "", "style", "theme", "setStyle", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "Landroidx/fragment/app/FragmentTransaction;", "transaction", "showNow", "dismiss", "dismissAllowingStateLoss", "", "allowStateLoss", "fromOnDismiss", "dismissInternal", "getDialog", "requireDialog", "getTheme", "cancelable", "setCancelable", "isCancelable", "showsDialog", "setShowsDialog", "getShowsDialog", "height", "Lkotlin/Function0;", "clickOuterSpace", "setViewHeight", "contentBgColor", "setContentBackground", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "onAttach", "onDetach", WidgetCostModule.TYPE_ON_CREATE, "Landroid/view/LayoutInflater;", "onGetLayoutInflater", "dialog", "setupDialog", "Landroid/content/DialogInterface;", "onCancel", "onDismiss", "Landroid/view/Window;", "getWindow", "onActivityCreated", WidgetCostModule.TYPE_ON_START, "outState", "onSaveInstanceState", "onStop", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "mDismissRunnable", "Ljava/lang/Runnable;", "mStyle", "I", "getMStyle", "()I", "setMStyle", "(I)V", "mTheme", "getMTheme", "setMTheme", "mCancelable", "Z", "getMCancelable", "()Z", "setMCancelable", "(Z)V", "mShowsDialog", "getMShowsDialog", "setMShowsDialog", "mBackStackId", "getMBackStackId", "setMBackStackId", "mDialog", "Lcom/bytedance/locallife/dito/core/f;", "getMDialog", "()Lcom/bytedance/locallife/dito/core/f;", "setMDialog", "(Lcom/bytedance/locallife/dito/core/f;)V", "mViewDestroyed", "getMViewDestroyed", "setMViewDestroyed", "mDismissed", "getMDismissed", "setMDismissed", "mShownByMe", "getMShownByMe", "setMShownByMe", "viewHeight", "Lkotlin/jvm/functions/Function0;", "contentBackgroundColor", "Lcom/bytedance/locallife/dito/core/f0;", "mListener", "Lcom/bytedance/locallife/dito/core/f0;", "getMListener", "()Lcom/bytedance/locallife/dito/core/f0;", "setMListener", "(Lcom/bytedance/locallife/dito/core/f0;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class DitoInteractDialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final a Companion = null;
    public static final String SAVED_BACK_STACK_ID = "android:backStackId";
    public static final String SAVED_CANCELABLE = "android:cancelable";
    public static final String SAVED_CONTENT_BACKGROUND_COLOR = "app:contentBackgroundColor";
    public static final String SAVED_DIALOG_STATE_TAG = "android:savedDialogState";
    public static final String SAVED_SHOWS_DIALOG = "android:showsDialog";
    public static final String SAVED_STYLE = "android:style";
    public static final String SAVED_THEME = "android:theme";
    public static final String SAVED_VIEW_HEIGHT = "app:viewHeight";
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private Function0<Unit> clickOuterSpace;
    private int contentBackgroundColor;
    private int mBackStackId;
    private boolean mCancelable;
    private f mDialog;
    private final Runnable mDismissRunnable;
    private boolean mDismissed;
    private Handler mHandler;
    private f0 mListener;
    private boolean mShownByMe;
    private boolean mShowsDialog;
    private int mStyle;
    private int mTheme;
    private boolean mViewDestroyed;
    private int viewHeight;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoInteractDialogFragment f257853a;

        public b(DitoInteractDialogFragment r100) {
            this.f257853a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0 r101 = DitoInteractDialogFragment.access$getClickOuterSpace$p(this.f257853a);
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DitoInteractDialogFragment f257854a;

        public c(DitoInteractDialogFragment r100) {
            this.f257854a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.f257854a.getMDialog() == null) goto L9;
            DitoInteractDialogFragment r100 = this.f257854a;     // Catch: Throwable -> L6
            f r101 = r100.getMDialog();     // Catch: Throwable -> L6
            Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L6
            r100.onDismiss(r101);     // Catch: Throwable -> L6
            return;
        }
    }

    static {
        Companion = new a();
    }

    public final void dismiss() {
        dismissInternal(false, false);
    }

    public final void dismissAllowingStateLoss() {
        dismissInternal(true, false);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    private final void adjustViewHeight() {
        if (this.viewHeight <= 0) goto L24;
        View r100 = getView();
        if (r100 == null) goto L25;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        View r102 = null;
        if (r101 == null) goto L18;
        int r103 = r101.height;
        int r104 = this.viewHeight;
        if (r103 == r104) goto L18;
        r101.height = r104;
        if ((r101 instanceof FrameLayout.LayoutParams) == false) goto L13;
        FrameLayout.LayoutParams r105 = (FrameLayout.LayoutParams) r101;
    L14:
        if (r105 == null) goto L17;
        r105.gravity = 80;
    L17:
        r100.setLayoutParams(r101);
        goto L18
    L13:
        r105 = null;
    L18:
        Object r106 = r100.getParent();
        if ((r106 instanceof View) == false) goto L21;
        r102 = (View) r106;
    L21:
        if (r102 == null) goto L26;
        r102.setOnClickListener(new b(this));
        return;
    L26:
        return;
    L25:
        return;
    }

    private final void updateContentBg() {
        if (this.contentBackgroundColor == 0) goto L14;
        View r100 = getView();
        View r101 = null;
        if (r100 == null) goto L7;
        ViewParent r102 = r100.getParent();
    L9:
        if ((r102 instanceof View) == false) goto L11;
        r101 = (View) r102;
    L11:
        if (r101 == null) goto L15;
        r101.setBackgroundColor(this.contentBackgroundColor);
        return;
    L15:
        return;
    L7:
        r102 = null;
        goto L9
    }

    public final Window getWindow() {
        f r100 = this.mDialog;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getWindow();
    }

    public DitoInteractDialogFragment() {
        this.mDismissRunnable = new c(this);
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.viewHeight = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.clickOuterSpace = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        f r100 = this.mDialog;
        if (r100 == null) goto L9;
        this.mViewDestroyed = true;
        Intrinsics.checkNotNull(r100);
        r100.setOnDismissListener(null);
        f r101 = this.mDialog;
        Intrinsics.checkNotNull(r101);
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r101);
        if (this.mDismissed == true) goto L7;
        f r102 = this.mDialog;
        Intrinsics.checkNotNull(r102);
        onDismiss(r102);
    L7:
        this.mDialog = null;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.mShownByMe == false) goto L5;
        return;
    L5:
        if (this.mDismissed == true) goto L9;
        this.mDismissed = true;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        f r100 = this.mDialog;
        if (r100 == null) goto L16;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
    L8:
        if (r102 == null) goto L11;
        r102.dimAmount = 0.0f;
    L11:
        if (r101 == null) goto L14;
        r101.setAttributes(r102);
    L14:
        adjustViewHeight();
        updateContentBg();
        this.mViewDestroyed = false;
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r100);
        return;
    L7:
        r102 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        f r100 = this.mDialog;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        r100.hide();
        return;
    }

    public final f requireDialog() {
        f r100 = getDialog();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public final f getDialog() {
        return this.mDialog;
    }

    public final int getMBackStackId() {
        return this.mBackStackId;
    }

    public final boolean getMCancelable() {
        return this.mCancelable;
    }

    public final f getMDialog() {
        return this.mDialog;
    }

    public final boolean getMDismissed() {
        return this.mDismissed;
    }

    public final f0 getMListener() {
        return this.mListener;
    }

    public final boolean getMShownByMe() {
        return this.mShownByMe;
    }

    public final boolean getMShowsDialog() {
        return this.mShowsDialog;
    }

    public final int getMStyle() {
        return this.mStyle;
    }

    public final int getMTheme() {
        return this.mTheme;
    }

    public final boolean getMViewDestroyed() {
        return this.mViewDestroyed;
    }

    public final boolean getShowsDialog() {
        return this.mShowsDialog;
    }

    public final int getTheme() {
        return this.mTheme;
    }

    public final boolean isCancelable() {
        return this.mCancelable;
    }

    public static View INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(f r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(f r100) {
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public static final /* synthetic */ Function0 access$getClickOuterSpace$p(DitoInteractDialogFragment r100) {
        return r100.clickOuterSpace;
    }

    private final f onCreateDialog(Bundle r100) {
        return new f(requireContext(), getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (this.mShowsDialog == true) goto L5;
        return;
    L5:
        View r101 = getView();
        if (r101 != null) goto L8;
    L15:
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L20;
        f r103 = this.mDialog;
        if (r103 == null) goto L20;
        r103.setOwnerActivity(r102);
    L20:
        f r104 = this.mDialog;
        if (r104 == null) goto L23;
        r104.setCancelable(this.mCancelable);
    L23:
        f r105 = this.mDialog;
        if (r105 == null) goto L26;
        r105.setOnCancelListener(this);
    L26:
        f r106 = this.mDialog;
        if (r106 == null) goto L29;
        r106.setOnDismissListener(this);
    L29:
        if (r100 == null) goto L33;
        Bundle r107 = r100.getBundle(SAVED_DIALOG_STATE_TAG);
        if (r107 == null) goto L33;
        f r108 = this.mDialog;
        Intrinsics.checkNotNull(r108);
        r108.onRestoreInstanceState(r107);
    L33:
        f r109 = this.mDialog;
        if (r109 == null) goto L40;
        Window r110 = r109.getWindow();
        if (r110 == null) goto L41;
        r110.clearFlags(67108864);
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r110).setSystemUiVisibility(1280);
        r110.addFlags(Integer.MIN_VALUE);
        r110.setStatusBarColor(0);
        r110.setNavigationBarColor(0);
        return;
    L41:
        return;
    L40:
        return;
    L8:
        if (r101.getParent() != null) goto L10;
        boolean r111 = true;
    L11:
        if (r111 == false) goto L14;
        f r112 = this.mDialog;
        Intrinsics.checkNotNull(r112);
        r112.setContentView(r101);
        goto L15
    L14:
        throw new IllegalStateException("DialogFragment can not be attached to a container view".toString());
    L10:
        r111 = false;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        if (this.mShownByMe == true) goto L6;
        this.mDismissed = false;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mHandler = new Handler();
        this.mShowsDialog = true;
        if (r100 == null) goto L6;
        this.mStyle = r100.getInt(SAVED_STYLE, 0);
        this.mTheme = r100.getInt(SAVED_THEME, 0);
        this.mCancelable = r100.getBoolean(SAVED_CANCELABLE, true);
        this.mShowsDialog = r100.getBoolean(SAVED_SHOWS_DIALOG, this.mShowsDialog);
        this.mBackStackId = r100.getInt(SAVED_BACK_STACK_ID, -1);
        this.viewHeight = r100.getInt(SAVED_VIEW_HEIGHT, -1);
        this.contentBackgroundColor = r100.getInt(SAVED_CONTENT_BACKGROUND_COLOR, 0);
        return;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (this.mViewDestroyed == true) goto L6;
        dismissInternal(true, true);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle r100) {
        if (this.mShowsDialog == false) goto L5;
        f r101 = onCreateDialog(r100);
        this.mDialog = r101;
        if (r101 == null) goto L13;
        if (r101 == null) goto L11;
        r101.f257913a = this.mListener;
    L11:
        Intrinsics.checkNotNull(r101);
        setupDialog(r101, this.mStyle);
        f r102 = this.mDialog;
        Intrinsics.checkNotNull(r102);
        Object r103 = r102.getContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.LayoutInflater");
        return (LayoutInflater) r103;
    L13:
        Context r104 = getContext();
        LayoutInflater r105 = null;
        if (r104 == null) goto L16;
        Object r106 = r104.getSystemService("layout_inflater");
    L18:
        if ((r106 instanceof LayoutInflater) == false) goto L20;
        r105 = (LayoutInflater) r106;
    L20:
        if (r105 == null) goto L23;
        return r105;
    L23:
        return super.onGetLayoutInflater(r100);
    L16:
        r106 = null;
        goto L18
    L5:
        return super.onGetLayoutInflater(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "outState");
        super.onSaveInstanceState(r100);
        f r101 = this.mDialog;
        if (r101 == null) goto L9;
        if (r101 == null) goto L6;
        Bundle r102 = r101.onSaveInstanceState();
    L7:
        if (r102 == null) goto L9;
        r100.putBundle(SAVED_DIALOG_STATE_TAG, r102);
        goto L9
    L6:
        r102 = null;
    L9:
        int r103 = this.mStyle;
        if (r103 == 0) goto L12;
        r100.putInt(SAVED_STYLE, r103);
    L12:
        int r104 = this.mTheme;
        if (r104 == 0) goto L15;
        r100.putInt(SAVED_THEME, r104);
    L15:
        boolean r105 = this.mCancelable;
        if (r105 == true) goto L18;
        r100.putBoolean(SAVED_CANCELABLE, r105);
    L18:
        boolean r106 = this.mShowsDialog;
        if (r106 == true) goto L21;
        r100.putBoolean(SAVED_SHOWS_DIALOG, r106);
    L21:
        int r107 = this.mBackStackId;
        if (r107 == (-1)) goto L24;
        r100.putInt(SAVED_BACK_STACK_ID, r107);
    L24:
        int r108 = this.viewHeight;
        if (r108 == (-1)) goto L27;
        r100.putInt(SAVED_VIEW_HEIGHT, r108);
    L27:
        int r109 = this.contentBackgroundColor;
        if (r109 == 0) goto L31;
        r100.putInt(SAVED_CONTENT_BACKGROUND_COLOR, r109);
        return;
    }

    public final void setCancelable(boolean r100) {
        this.mCancelable = r100;
        f r101 = this.mDialog;
        if (r101 == null) goto L6;
        Intrinsics.checkNotNull(r101);
        r101.setCancelable(r100);
        return;
    }

    public final void setContentBackground(int r100) {
        this.contentBackgroundColor = r100;
        updateContentBg();
    }

    public final void setMBackStackId(int r100) {
        this.mBackStackId = r100;
    }

    public final void setMCancelable(boolean r100) {
        this.mCancelable = r100;
    }

    public final void setMDialog(f r100) {
        this.mDialog = r100;
    }

    public final void setMDismissed(boolean r100) {
        this.mDismissed = r100;
    }

    public final void setMListener(f0 r100) {
        this.mListener = r100;
    }

    public final void setMShownByMe(boolean r100) {
        this.mShownByMe = r100;
    }

    public final void setMShowsDialog(boolean r100) {
        this.mShowsDialog = r100;
    }

    public final void setMStyle(int r100) {
        this.mStyle = r100;
    }

    public final void setMTheme(int r100) {
        this.mTheme = r100;
    }

    public final void setMViewDestroyed(boolean r100) {
        this.mViewDestroyed = r100;
    }

    public final void setShowsDialog(boolean r100) {
        this.mShowsDialog = r100;
    }

    public final void dismissInternal(boolean r100, boolean r101) {
        if (this.mDismissed == false) goto L5;
        return;
    L5:
        this.mDismissed = true;
        this.mShownByMe = false;
        f r102 = this.mDialog;
        if (r102 == null) goto L17;
        if (r102 == null) goto L9;
        r102.setOnDismissListener(null);
    L9:
        f r103 = this.mDialog;
        if (r103 == null) goto L12;
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r103);
    L12:
        if (r101 == true) goto L17;
        Looper r104 = Looper.myLooper();
        Handler r105 = this.mHandler;
        Intrinsics.checkNotNull(r105);
        if (Intrinsics.areEqual(r104, r105.getLooper()) == false) goto L16;
        f r106 = this.mDialog;
        Intrinsics.checkNotNull(r106);
        onDismiss(r106);
        goto L17
    L16:
        Handler r107 = this.mHandler;
        Intrinsics.checkNotNull(r107);
        r107.post(this.mDismissRunnable);
    L17:
        this.mViewDestroyed = true;
        if (this.mBackStackId < 0) goto L20;
        requireFragmentManager().popBackStack(this.mBackStackId, 1);
        this.mBackStackId = -1;
        return;
    L20:
        FragmentTransaction r108 = requireFragmentManager().beginTransaction();
        r108.remove(this);
        if (r100 == false) goto L23;
        r108.commitAllowingStateLoss();
        return;
    L23:
        r108.commit();
    }

    public final void setStyle(int r100, int r101) {
        this.mStyle = r100;
        if (r101 == 0) goto L6;
        this.mTheme = r101;
        return;
    }

    public final void setViewHeight(int r100, Function0<Unit> r101) {
        this.viewHeight = r100;
        this.clickOuterSpace = r101;
        adjustViewHeight();
    }

    public final void setupDialog(f r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        if (r101 != 1) goto L5;
    L13:
        r100.requestWindowFeature(1);
        return;
    L5:
        if (r101 == 2) goto L13;
        if (r101 != 3) goto L16;
        Window r102 = r100.getWindow();
        if (r102 == null) goto L12;
        r102.addFlags(24);
    L12:
        r100.requestWindowFeature(1);
        return;
    }

    public final int show(FragmentTransaction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "transaction");
        this.mDismissed = false;
        this.mShownByMe = true;
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r100, this, r101);
        this.mViewDestroyed = false;
        int r102 = r100.commitAllowingStateLoss();
        this.mBackStackId = r102;
        return r102;
    }

    public final void showNow(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r102 = r100.beginTransaction();
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r102, this, r101);
        r102.commitNow();
    }

    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.mDismissed = false;
        this.mShownByMe = true;
        FragmentTransaction r102 = r100.beginTransaction();
        INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r102, this, r101);
        r102.commitAllowingStateLoss();
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_locallife_dito_core_DitoInteractDialogFragment_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setViewHeight$default(DitoInteractDialogFragment r100, int r101, Function0 r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = null;
    L6:
        r100.setViewHeight(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setViewHeight");
    }
}
