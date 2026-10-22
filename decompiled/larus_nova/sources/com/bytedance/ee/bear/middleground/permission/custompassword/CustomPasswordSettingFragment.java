package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.TriggerAction;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.util.ui.n;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0016J\u0012\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010H\u001a\u000202H\u0016J\b\u0010I\u001a\u000202H\u0016J\b\u0010J\u001a\u000202H\u0002J\b\u0010K\u001a\u000202H\u0016J\b\u0010L\u001a\u000202H\u0002J&\u0010M\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010R\u001a\u0002022\u0006\u0010S\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010T\u001a\u000202J\b\u0010U\u001a\u000202H\u0014J\b\u0010V\u001a\u000202H\u0002J8\u0010W\u001a\u0002022\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020Z0Yj\b\u0012\u0004\u0012\u00020Z`[2\u0016\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020Z0Yj\b\u0012\u0004\u0012\u00020Z`[H\u0002J\u0012\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020ZH\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020ZH\u0002J\u0010\u0010a\u001a\u0002022\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u000202H\u0002J\u0010\u0010e\u001a\u0002022\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u000205H\u0002J\b\u0010i\u001a\u000202H\u0002J\b\u0010j\u001a\u000202H\u0002J\b\u0010k\u001a\u000202H\u0002J\b\u0010l\u001a\u000202H\u0002J\u0010\u0010m\u001a\u0002022\u0006\u0010n\u001a\u00020;H\u0002J\b\u0010o\u001a\u000202H\u0016J\b\u0010p\u001a\u000202H\u0016J\u0010\u0010q\u001a\u0002022\u0006\u0010r\u001a\u00020;H\u0002J\u0010\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020tH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001e\u0010(\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001e\u0010+\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001e\u0010.\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010E¨\u0006w"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomPasswordSettingFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "editPasswordFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getEditPasswordFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setEditPasswordFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "iconContainerFromXml", "Landroid/widget/LinearLayout;", "getIconContainerFromXml", "()Landroid/widget/LinearLayout;", "setIconContainerFromXml", "(Landroid/widget/LinearLayout;)V", "levelTxFromXml", "Landroid/widget/TextView;", "getLevelTxFromXml", "()Landroid/widget/TextView;", "setLevelTxFromXml", "(Landroid/widget/TextView;)V", "levelContainerFromXml", "getLevelContainerFromXml", "setLevelContainerFromXml", "levelFirstFromXml", "Landroid/view/View;", "getLevelFirstFromXml", "()Landroid/view/View;", "setLevelFirstFromXml", "(Landroid/view/View;)V", "levelSecFromXml", "getLevelSecFromXml", "setLevelSecFromXml", "levelThirdFromXml", "getLevelThirdFromXml", "setLevelThirdFromXml", "cancelBtnFromXml", "getCancelBtnFromXml", "setCancelBtnFromXml", "saveBtnFromXml", "getSaveBtnFromXml", "setSaveBtnFromXml", "createBtnFromXml", "getCreateBtnFromXml", "setCreateBtnFromXml", "topContainerFromXml", "getTopContainerFromXml", "setTopContainerFromXml", "clearFromXmlViewCache", "", "onDestroyView", "token", "", "type", "", "Ljava/lang/Integer;", "ruleData", "loseFocusByBackground", "", "hasFocusBeforeBg", "canStartCheck", "changeType", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomSettingViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "init", WidgetCostModule.TYPE_ON_START, "initPeekHeight", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "bindObserver", "onFloatDismiss", "showPasswordView", "handleItemShow", "passList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PassWordItemMsg;", "Lkotlin/collections/ArrayList;", "warningList", "getPassItemView", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/PasswordTipView;", "itemStateMsg", "getWarningItemView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "doOnDismiss", "handleStrongShow", "levelMsg", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PasswordLevelMsg;", "getPassword", "bindView", "setInitState", "revertSoftInputMode", "saveSoftInputMode", "handleKeyBoardShow", "show", "onPause", "onStop", "loseFocus", "check", "getReviseTrigger", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/TriggerAction;", "triggerAction", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPasswordSettingFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public String B;
    public final Lazy C;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SpaceEditText f233781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LinearLayout f233782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f233783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f233784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f233785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f233786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View f233787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f233788r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public TextView f233789s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f233790t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f233791u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f233792v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f233793w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f233794x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f233795y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f233796z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f233797a = null;

        static {
            int[] r100 = new int[PasswordLevel.values().length];
            r100[PasswordLevel.STRONG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[PasswordLevel.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[PasswordLevel.WEAK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[PasswordLevel.NO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f233797a = r100;
        }
    }

    static {
    }

    public final SpaceEditText ga0() {
        View r100 = this.f233781k;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.edit_password);
    L8:
        this.f233781k = (SpaceEditText) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (SpaceEditText) r100;
    }

    public final LinearLayout ha0() {
        View r100 = this.f233782l;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.icon_container);
    L8:
        this.f233782l = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final LinearLayout ia0() {
        View r100 = this.f233784n;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.level_container);
    L8:
        this.f233784n = (LinearLayout) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (LinearLayout) r100;
    }

    public final View ja0() {
        View r100 = this.f233785o;
        if (r100 != null) goto L9;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.level_first);
    L8:
        this.f233785o = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final View ka0() {
        View r100 = this.f233786p;
        if (r100 != null) goto L9;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.level_sec);
    L8:
        this.f233786p = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final View la0() {
        View r100 = this.f233787q;
        if (r100 != null) goto L9;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.level_third);
    L8:
        this.f233787q = r100;
        goto L9
    L7:
        r100 = null;
    L9:
        return r100;
    }

    public final TextView ma0() {
        View r100 = this.f233783m;
        if (r100 != null) goto L10;
        View r101 = getView();
        if (r101 == null) goto L7;
        r100 = r101.findViewById(R.id.level_tx);
    L8:
        this.f233783m = (TextView) r100;
        goto L10
    L7:
        r100 = null;
    L10:
        return (TextView) r100;
    }

    public final CustomSettingViewModel na0() {
        return (CustomSettingViewModel) this.C.getValue();
    }

    public CustomPasswordSettingFragment() {
        this.f233792v = "";
        this.f233793w = -1;
        this.f233794x = "";
        this.A = true;
        this.B = "customized";
        this.C = LazyKt.lazy(new CustomPasswordSettingFragment$viewModel$2(this));
    }

    public final void fa0() {
        if (na0().isHasSaveSuccess() == true) goto L5;
        com.bytedance.ee.bear.middleground.permission.c.q("cancel", this.B, null, null, 56);
    L5:
        jg5.j r100 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r101 = this.f233792v;
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r100.getClass();
        rh5.a r102 = (rh5.a) ((HashMap) jg5.j.f499011e).get(r101);
        if (r102 == null) goto L12;
        r102.c(-1, "");
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L7;
        Intent r101 = r100.getIntent();
        if (r101 == null) goto L7;
        int r102 = r101.getIntExtra("softInputMode", -1);
    L8:
        if (r102 == (-1)) goto L14;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L14;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L14;
        r104.setSoftInputMode(r102);
    L14:
        na0().onDestroy();
        return;
    L7:
        r102 = -1;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f233781k = null;
        this.f233782l = null;
        this.f233783m = null;
        this.f233784n = null;
        this.f233785o = null;
        this.f233786p = null;
        this.f233787q = null;
        this.f233788r = null;
        this.f233789s = null;
        this.f233790t = null;
        this.f233791u = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f233796z = ga0().hasFocus();
        this.f233795y = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f233796z == false) goto L5;
        ga0().postDelayed(new m(this), 100);
    L5:
        this.f233795y = false;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        qa0();
    }

    public final void qa0() {
        Dialog r100 = getDialog();     // Catch: Throwable -> L22
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L13;
        Window r102 = r100.getWindow();     // Catch: Throwable -> L22
        if (r102 == null) goto L13;
        View r103 = r102.getDecorView();     // Catch: Throwable -> L22
        if (com.larus.home.impl.utils.c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L22
        Thread r104 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L22
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L11;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");     // Catch: Throwable -> L22
    L11:
        if (r103 == null) goto L13;
        FrameLayout r105 = (FrameLayout) r103.findViewById(R.id.design_bottom_sheet);     // Catch: Throwable -> L22
    L14:
        if (r105 == null) goto L17;
        r101 = r105.getLayoutParams();     // Catch: Throwable -> L22
    L17:
        if ((r101 instanceof CoordinatorLayout.LayoutParams) == false) goto L27;
        CoordinatorLayout.Behavior r106 = ((CoordinatorLayout.LayoutParams) r101).getBehavior();     // Catch: Throwable -> L22
        if ((r106 instanceof BottomSheetBehavior) == false) goto L28;
        ((BottomSheetBehavior) r106).setPeekHeight((int) (((double) n.p(getActivity())) * 0.85d));     // Catch: Throwable -> L22
        r105.getLayoutParams().height = ((BottomSheetBehavior) r106).getPeekHeight();     // Catch: Throwable -> L22
        ((BottomSheetBehavior) r106).setDraggable(false);     // Catch: Throwable -> L22
        ((BottomSheetBehavior) r106).setState(3);     // Catch: Throwable -> L22
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r105 = null;
    L22:
        th = move-exception;
        tt5.a.d("CustomPasswordSettingFragment", th.getMessage());
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment
    public final void W90() {
        fa0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        this.f233792v = r101.getString("token", "");
        this.f233793w = Integer.valueOf(r101.getInt("type", -1));
        this.f233794x = r101.getString("data", "");
    L5:
        na0().init(this.f233794x);
        this.f233796z = true;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        tt5.a.h("CustomPasswordSettingFragment", "onFloatDismiss");     // Catch: Throwable -> L5
        fa0();     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void pa0(jh5.d r100) {
        PasswordLevel r101 = r100.f499091b;
        ma0().setText(r100.f499090a);
        int r102 = b.f233797a[r101.ordinal()];
        if (r102 != 1) goto L5;
        ia0().setVisibility(0);
        ma0().setTextColor(y9c.d.c(getContext(), R.color.function_success_600));
        ja0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.function_success_600));
        ka0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.function_success_600));
        la0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.function_success_600));
        return;
    L5:
        if (r102 != 2) goto L7;
        ia0().setVisibility(0);
        ma0().setTextColor(y9c.d.c(getContext(), R.color.text_link_hover));
        ja0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.text_link_hover));
        ka0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.text_link_hover));
        la0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.icon_disabled));
        return;
    L7:
        if (r102 != 3) goto L9;
        ia0().setVisibility(0);
        ma0().setTextColor(y9c.d.c(getContext(), R.color.function_warning_350));
        ja0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.function_warning_350));
        ka0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.icon_disabled));
        la0().setBackgroundColor(UIUtils.getColor(getContext(), R.color.icon_disabled));
        return;
    L9:
        if (r102 == 4) goto L11;
        ia0().setVisibility(8);
        return;
    L11:
        ia0().setVisibility(8);
    }

    public static final void da0(CustomPasswordSettingFragment r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.ga0().setFocusableInTouchMode(true);
        r100.ga0().setFocusable(true);
        r100.ga0().requestFocus();
        KeyboardUtils.showKeyboard(r100.ga0());
    L5:
        tt5.a.h("CustomPasswordSettingFragment", "handleKeyBoardShow " + r101);
        return;
    L4:
        KeyboardUtils.hideKeyboard(r100.requireContext(), r100.ga0());
        goto L5
    }

    public static final void ea0(CustomPasswordSettingFragment r100, boolean r101) {
        r100.ga0().clearFocus();
        KeyboardUtils.hideKeyboard(r100.requireContext(), r100.ga0());
        if (r101 == false) goto L5;
        r100.na0().updatePasswordView(TriggerAction.LOSE_FOCUS, String.valueOf(r100.ga0().getText()));
    L5:
        tt5.a.h("CustomPasswordSettingFragment", "loseFocus start");
    }

    public final void oa0(ArrayList<jh5.c> r100, ArrayList<jh5.c> r101) {
        ha0().removeAllViews();
        int r102 = r100.size();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L6;
        jh5.c r105 = (jh5.c) ListProtector.get(r100, r104);
        PasswordTipView r106 = new PasswordTipView(requireContext(), null);
        r106.a(r105);
        r106.setLayoutParams(r106.getLayoutParam());
        ha0().addView(r106);
        r104 = r104 + 1;
        goto L4
    L6:
        int r107 = r101.size();
    L7:
        if (r103 >= r107) goto L16;
        jh5.c r108 = (jh5.c) ListProtector.get(r101, r103);
        if (r108.f499089b != PasswordItemState.STATE_WARNING) goto L11;
        PasswordTipView r109 = new PasswordTipView(requireContext(), null);
        r109.b(r108);
        r109.setLayoutParams(r109.getLayoutParam());
    L12:
        if (r109 == null) goto L15;
        ha0().addView(r109);
    L15:
        r103 = r103 + 1;
        goto L7
    L11:
        r109 = null;
        goto L12
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f233788r;
        View r103 = null;
        if (r102 != null) goto L9;
        View r104 = getView();
        if (r104 == null) goto L7;
        r102 = r104.findViewById(R.id.cancel_btn);
    L8:
        this.f233788r = (TextView) r102;
        goto L9
    L7:
        r102 = null;
    L9:
        ((TextView) r102).setOnClickListener(new f(this));
        View r105 = this.f233789s;
        if (r105 != null) goto L16;
        View r106 = getView();
        if (r106 == null) goto L14;
        r105 = r106.findViewById(R.id.save_btn);
    L15:
        this.f233789s = (TextView) r105;
        goto L16
    L14:
        r105 = null;
    L16:
        ((TextView) r105).setOnClickListener(new g(this));
        View r107 = this.f233790t;
        if (r107 != null) goto L23;
        View r108 = getView();
        if (r108 == null) goto L21;
        r107 = r108.findViewById(R.id.create_btn);
    L22:
        this.f233790t = (TextView) r107;
        goto L23
    L21:
        r107 = null;
    L23:
        ((TextView) r107).setOnClickListener(new h(this));
        ga0().addTextChangedListener(new i(this));
        ga0().setInputType(32);
        ga0().setOnFocusChangeListener(new j(this));
        View r109 = this.f233791u;
        if (r109 != null) goto L29;
        View r110 = getView();
        if (r110 == null) goto L28;
        r103 = r110.findViewById(R.id.top_container);
    L28:
        this.f233791u = (LinearLayout) r103;
        r109 = r103;
    L29:
        ((LinearLayout) r109).setOnTouchListener(new k(this));
        ga0().setOnEditorActionListener(new l(this));
        ga0().postDelayed(new m(this), 100);
        na0().getUiResult().observe(getViewLifecycleOwner(), new c(this));
        na0().getPasswordLiveData().observe(getViewLifecycleOwner(), new d(this));
        na0().getSaveResult().observe(getViewLifecycleOwner(), new e(this));
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r100);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ccm_custom_password_layout, r101, false);
        FragmentActivity r104 = getActivity();
        int r105 = -1;
        if (r104 == null) goto L7;
        Intent r106 = r104.getIntent();
        if (r106 == null) goto L7;
        int r107 = r106.getIntExtra("softInputMode", -1);
    L8:
        if (r107 != (-1)) goto L21;
        FragmentActivity r108 = getActivity();
        if (r108 == null) goto L16;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L16;
        WindowManager.LayoutParams r110 = r109.getAttributes();
        if (r110 == null) goto L16;
        r105 = r110.softInputMode;
    L16:
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L21;
        Intent r112 = r111.getIntent();
        if (r112 == null) goto L21;
        r112.putExtra("softInputMode", r105);
    L21:
        Dialog r113 = getDialog();
        if (r113 == null) goto L26;
        Window r114 = r113.getWindow();
        if (r114 == null) goto L26;
        r114.setSoftInputMode(4);
    L26:
        return r103;
    L7:
        r107 = -1;
        goto L8
    }
}
