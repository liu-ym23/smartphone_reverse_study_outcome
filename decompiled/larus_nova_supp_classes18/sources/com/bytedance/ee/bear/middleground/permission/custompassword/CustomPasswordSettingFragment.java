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
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.TriggerAction;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 v2\u00020\u0001:\u0001vB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0016J\u0012\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010H\u001a\u000202H\u0016J\b\u0010I\u001a\u000202H\u0016J\b\u0010J\u001a\u000202H\u0002J\b\u0010K\u001a\u000202H\u0016J\b\u0010L\u001a\u000202H\u0002J&\u0010M\u001a\u0004\u0018\u00010\u001a2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u001a\u0010R\u001a\u0002022\u0006\u0010S\u001a\u00020\u001a2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010T\u001a\u000202J\b\u0010U\u001a\u000202H\u0014J\b\u0010V\u001a\u000202H\u0002J8\u0010W\u001a\u0002022\u0016\u0010X\u001a\u0012\u0012\u0004\u0012\u00020Z0Yj\b\u0012\u0004\u0012\u00020Z`[2\u0016\u0010\\\u001a\u0012\u0012\u0004\u0012\u00020Z0Yj\b\u0012\u0004\u0012\u00020Z`[H\u0002J\u0012\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020ZH\u0002J\u0012\u0010`\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020ZH\u0002J\u0010\u0010a\u001a\u0002022\u0006\u0010b\u001a\u00020cH\u0016J\b\u0010d\u001a\u000202H\u0002J\u0010\u0010e\u001a\u0002022\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u000205H\u0002J\b\u0010i\u001a\u000202H\u0002J\b\u0010j\u001a\u000202H\u0002J\b\u0010k\u001a\u000202H\u0002J\b\u0010l\u001a\u000202H\u0002J\u0010\u0010m\u001a\u0002022\u0006\u0010n\u001a\u00020;H\u0002J\b\u0010o\u001a\u000202H\u0016J\b\u0010p\u001a\u000202H\u0016J\u0010\u0010q\u001a\u0002022\u0006\u0010r\u001a\u00020;H\u0002J\u0010\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020tH\u0002R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001e\u0010\"\u001a\u0004\u0018\u00010\u001a8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001e\u0010%\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001e\u0010(\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R\u001e\u0010+\u001a\u0004\u0018\u00010\u00118FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001e\u0010.\u001a\u0004\u0018\u00010\u000b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010B\u001a\u00020C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bD\u0010E¨\u0006w"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomPasswordSettingFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseBottomSheetDialogFragment;", "<init>", "()V", "editPasswordFromXml", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "getEditPasswordFromXml", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;", "setEditPasswordFromXml", "(Lcom/bytedance/ee/bear/widgets/universedesign/SpaceEditText;)V", "iconContainerFromXml", "Landroid/widget/LinearLayout;", "getIconContainerFromXml", "()Landroid/widget/LinearLayout;", "setIconContainerFromXml", "(Landroid/widget/LinearLayout;)V", "levelTxFromXml", "Landroid/widget/TextView;", "getLevelTxFromXml", "()Landroid/widget/TextView;", "setLevelTxFromXml", "(Landroid/widget/TextView;)V", "levelContainerFromXml", "getLevelContainerFromXml", "setLevelContainerFromXml", "levelFirstFromXml", "Landroid/view/View;", "getLevelFirstFromXml", "()Landroid/view/View;", "setLevelFirstFromXml", "(Landroid/view/View;)V", "levelSecFromXml", "getLevelSecFromXml", "setLevelSecFromXml", "levelThirdFromXml", "getLevelThirdFromXml", "setLevelThirdFromXml", "cancelBtnFromXml", "getCancelBtnFromXml", "setCancelBtnFromXml", "saveBtnFromXml", "getSaveBtnFromXml", "setSaveBtnFromXml", "createBtnFromXml", "getCreateBtnFromXml", "setCreateBtnFromXml", "topContainerFromXml", "getTopContainerFromXml", "setTopContainerFromXml", "clearFromXmlViewCache", "", "onDestroyView", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "Ljava/lang/Integer;", "ruleData", "loseFocusByBackground", "", "hasFocusBeforeBg", "canStartCheck", "changeType", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomSettingViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomSettingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onResume", "onDestroy", "init", "onStart", "initPeekHeight", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "bindObserver", "onFloatDismiss", "showPasswordView", "handleItemShow", "passList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PassWordItemMsg;", "Lkotlin/collections/ArrayList;", "warningList", "getPassItemView", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/PasswordTipView;", "itemStateMsg", "getWarningItemView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "doOnDismiss", "handleStrongShow", "levelMsg", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/PasswordLevelMsg;", "getPassword", "bindView", "setInitState", "revertSoftInputMode", "saveSoftInputMode", "handleKeyBoardShow", "show", "onPause", "onStop", "loseFocus", "check", "getReviseTrigger", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/TriggerAction;", "triggerAction", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPasswordSettingFragment extends BaseBottomSheetDialogFragment {
    public static final /* synthetic */ int D = 0;
    public boolean A;
    public String B;
    public final Lazy C;
    public SpaceEditText k;
    public LinearLayout l;
    public TextView m;
    public LinearLayout n;
    public View o;
    public View p;
    public View q;
    public TextView r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public String v;
    public Integer w;
    public String x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PasswordLevel.values().length];
            r0[PasswordLevel.STRONG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PasswordLevel.MIDDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PasswordLevel.WEAK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PasswordLevel.NO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public final SpaceEditText ga0() {
        UDEditText r0 = this.k;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131371430);
    L8:
        this.k = (SpaceEditText) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (SpaceEditText) r0;
    }

    public final LinearLayout ha0() {
        View r0 = this.l;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131374739);
    L8:
        this.l = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    public final LinearLayout ia0() {
        View r0 = this.n;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131377838);
    L8:
        this.n = (LinearLayout) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (LinearLayout) r0;
    }

    public final View ja0() {
        View r0 = this.o;
        if (r0 != null) goto L9;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131377839);
    L8:
        this.o = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final View ka0() {
        View r0 = this.p;
        if (r0 != null) goto L9;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131377841);
    L8:
        this.p = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final View la0() {
        View r0 = this.q;
        if (r0 != null) goto L9;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131377842);
    L8:
        this.q = r0;
        goto L9
    L7:
        r0 = null;
    L9:
        return r0;
    }

    public final TextView ma0() {
        View r0 = this.m;
        if (r0 != null) goto L10;
        View r1 = getView();
        if (r1 == null) goto L7;
        r0 = r1.findViewById(2131377844);
    L8:
        this.m = (TextView) r0;
        goto L10
    L7:
        r0 = null;
    L10:
        return (TextView) r0;
    }

    public final CustomSettingViewModel na0() {
        return (CustomSettingViewModel) this.C.getValue();
    }

    public CustomPasswordSettingFragment() {
        this.v = "";
        this.w = -1;
        this.x = "";
        this.A = true;
        this.B = "customized";
        this.C = LazyKt.lazy(new CustomPasswordSettingFragment$viewModel$2(this));
    }

    public final void fa0() {
        if (na0().isHasSaveSuccess() == true) goto L5;
        com.bytedance.ee.bear.middleground.permission.c.q(DocFeed$Value$Result.CANCEL, this.B, null, null, 56);
    L5:
        jg5.j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        String r1 = this.v;
        if (r1 != null) goto L8;
        r1 = "";
    L8:
        r0.getClass();
        rh5.a r2 = (rh5.a) ((HashMap) jg5.j.e).get(r1);
        if (r2 == null) goto L12;
        r2.c(-1, "");
        return;
    }

    public final void onDestroy() {
        super.onDestroy();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L7;
        int r2 = r1.getIntExtra("softInputMode", -1);
    L8:
        if (r2 == (-1)) goto L14;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L14;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L14;
        r4.setSoftInputMode(r2);
    L14:
        na0().onDestroy();
        return;
    L7:
        r2 = -1;
        goto L8
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public final void onPause() {
        super/*androidx.fragment.app.Fragment*/.onPause();
        this.z = ga0().hasFocus();
        this.y = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.z == false) goto L5;
        ga0().postDelayed(new m(this), 100);
    L5:
        this.y = false;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        qa0();
    }

    public final void qa0() {
        Dialog r0 = getDialog();     // Catch: Throwable -> L22
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L13;
        Window r2 = r0.getWindow();     // Catch: Throwable -> L22
        if (r2 == null) goto L13;
        View r3 = r2.getDecorView();     // Catch: Throwable -> L22
        if (com.larus.home.impl.utils.c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L22
        Thread r4 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L22
        if (r4 == com.larus.home.impl.utils.c.a) goto L11;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");     // Catch: Throwable -> L22
    L11:
        if (r3 == null) goto L13;
        FrameLayout r5 = (FrameLayout) r3.findViewById(2131368870);     // Catch: Throwable -> L22
    L14:
        if (r5 == null) goto L17;
        r1 = r5.getLayoutParams();     // Catch: Throwable -> L22
    L17:
        if ((r1 instanceof CoordinatorLayout.LayoutParams) == false) goto L27;
        BottomSheetBehavior r6 = ((CoordinatorLayout.LayoutParams) r1).getBehavior();     // Catch: Throwable -> L22
        if ((r6 instanceof BottomSheetBehavior) == false) goto L28;
        r6.setPeekHeight((int) (((double) n.p(getActivity())) * 0.85d));     // Catch: Throwable -> L22
        r5.getLayoutParams().height = r6.getPeekHeight();     // Catch: Throwable -> L22
        r6.setDraggable(false);     // Catch: Throwable -> L22
        r6.setState(3);     // Catch: Throwable -> L22
        return;
    L28:
        return;
    L27:
        return;
    L13:
        r5 = null;
    L22:
        th = move-exception;
        tt5.a.d("CustomPasswordSettingFragment", th.getMessage());
    }

    public final void W90() {
        fa0();
    }

    public final void onStop() {
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        this.v = r5.getString(ResourceData.KEY_TOKEN, "");
        this.w = Integer.valueOf(r5.getInt(ResourceData.KEY_TYPE, -1));
        this.x = r5.getString(WikiFolderPushPlugin.DATA, "");
    L5:
        na0().init(this.x);
        this.z = true;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
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

    public final void pa0(jh5.d r4) {
        PasswordLevel r0 = r4.b;
        ma0().setText(r4.a);
        int r5 = b.a[r0.ordinal()];
        if (r5 != 1) goto L5;
        ia0().setVisibility(0);
        ma0().setTextColor(y9c.d.c(getContext(), 2131102149));
        ja0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102149));
        ka0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102149));
        la0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102149));
        return;
    L5:
        if (r5 != 2) goto L7;
        ia0().setVisibility(0);
        ma0().setTextColor(y9c.d.c(getContext(), 2131106614));
        ja0().setBackgroundColor(UIUtils.getColor(getContext(), 2131106614));
        ka0().setBackgroundColor(UIUtils.getColor(getContext(), 2131106614));
        la0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102417));
        return;
    L7:
        if (r5 != 3) goto L9;
        ia0().setVisibility(0);
        ma0().setTextColor(y9c.d.c(getContext(), 2131102171));
        ja0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102171));
        ka0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102417));
        la0().setBackgroundColor(UIUtils.getColor(getContext(), 2131102417));
        return;
    L9:
        if (r5 == 4) goto L11;
        ia0().setVisibility(8);
        return;
    L11:
        ia0().setVisibility(8);
    }

    public static final void da0(CustomPasswordSettingFragment r2, boolean r3) {
        if (r3 == false) goto L4;
        r2.ga0().setFocusableInTouchMode(true);
        r2.ga0().setFocusable(true);
        r2.ga0().requestFocus();
        KeyboardUtils.showKeyboard(r2.ga0());
    L5:
        tt5.a.h("CustomPasswordSettingFragment", "handleKeyBoardShow " + r3);
        return;
    L4:
        KeyboardUtils.hideKeyboard(r2.requireContext(), r2.ga0());
        goto L5
    }

    public static final void ea0(CustomPasswordSettingFragment r2, boolean r3) {
        r2.ga0().clearFocus();
        KeyboardUtils.hideKeyboard(r2.requireContext(), r2.ga0());
        if (r3 == false) goto L5;
        r2.na0().updatePasswordView(TriggerAction.LOSE_FOCUS, String.valueOf(r2.ga0().getText()));
    L5:
        tt5.a.h("CustomPasswordSettingFragment", "loseFocus start");
    }

    public final void oa0(ArrayList<jh5.c> r8, ArrayList<jh5.c> r9) {
        ha0().removeAllViews();
        int r0 = r8.size();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L6;
        jh5.c r4 = (jh5.c) ListProtector.get(r8, r2);
        PasswordTipView r5 = new PasswordTipView(requireContext(), null);
        r5.a(r4);
        r5.setLayoutParams(r5.getLayoutParam());
        ha0().addView(r5);
        r2 = r2 + 1;
        goto L4
    L6:
        int r10 = r9.size();
    L7:
        if (r1 >= r10) goto L16;
        jh5.c r3 = (jh5.c) ListProtector.get(r9, r1);
        if (r3.b != PasswordItemState.STATE_WARNING) goto L11;
        PasswordTipView r6 = new PasswordTipView(requireContext(), null);
        r6.b(r3);
        r6.setLayoutParams(r6.getLayoutParam());
    L12:
        if (r6 == null) goto L15;
        ha0().addView(r6);
    L15:
        r1 = r1 + 1;
        goto L7
    L11:
        r6 = null;
        goto L12
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatBottomSheetDialogFragment*/.onViewCreated(r4, r5);
        View r6 = this.r;
        View r0 = null;
        if (r6 != null) goto L9;
        View r7 = getView();
        if (r7 == null) goto L7;
        r6 = r7.findViewById(2131365123);
    L8:
        this.r = (TextView) r6;
        goto L9
    L7:
        r6 = null;
    L9:
        ((TextView) r6).setOnClickListener(new f(this));
        View r8 = this.s;
        if (r8 != null) goto L16;
        View r9 = getView();
        if (r9 == null) goto L14;
        r8 = r9.findViewById(2131385089);
    L15:
        this.s = (TextView) r8;
        goto L16
    L14:
        r8 = null;
    L16:
        ((TextView) r8).setOnClickListener(new g(this));
        View r10 = this.t;
        if (r10 != null) goto L23;
        View r11 = getView();
        if (r11 == null) goto L21;
        r10 = r11.findViewById(2131368186);
    L22:
        this.t = (TextView) r10;
        goto L23
    L21:
        r10 = null;
    L23:
        ((TextView) r10).setOnClickListener(new h(this));
        ga0().addTextChangedListener(new i(this));
        ga0().setInputType(32);
        ga0().setOnFocusChangeListener(new j(this));
        View r12 = this.u;
        if (r12 != null) goto L29;
        View r13 = getView();
        if (r13 == null) goto L28;
        r0 = r13.findViewById(2131389138);
    L28:
        this.u = (LinearLayout) r0;
        r12 = r0;
    L29:
        ((LinearLayout) r12).setOnTouchListener(new k(this));
        ga0().setOnEditorActionListener(new l(this));
        ga0().postDelayed(new m(this), 100);
        na0().getUiResult().observe(getViewLifecycleOwner(), new c(this));
        na0().getPasswordLiveData().observe(getViewLifecycleOwner(), new d(this));
        na0().getSaveResult().observe(getViewLifecycleOwner(), new e(this));
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.h.a(r4);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131559268, r3, false);
        FragmentActivity r6 = getActivity();
        int r7 = -1;
        if (r6 == null) goto L7;
        Intent r8 = r6.getIntent();
        if (r8 == null) goto L7;
        int r9 = r8.getIntExtra("softInputMode", -1);
    L8:
        if (r9 != (-1)) goto L21;
        FragmentActivity r10 = getActivity();
        if (r10 == null) goto L16;
        Window r11 = r10.getWindow();
        if (r11 == null) goto L16;
        WindowManager.LayoutParams r12 = r11.getAttributes();
        if (r12 == null) goto L16;
        r7 = r12.softInputMode;
    L16:
        FragmentActivity r13 = getActivity();
        if (r13 == null) goto L21;
        Intent r14 = r13.getIntent();
        if (r14 == null) goto L21;
        r14.putExtra("softInputMode", r7);
    L21:
        Dialog r15 = getDialog();
        if (r15 == null) goto L26;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L26;
        r16.setSoftInputMode(4);
    L26:
        return r5;
    L7:
        r9 = -1;
        goto L8
    }
}
