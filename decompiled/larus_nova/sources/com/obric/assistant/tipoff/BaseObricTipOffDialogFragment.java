package com.obric.assistant.tipoff;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.tipoff.BaseTipOffDialog;
import com.larus.common_ui.widget.MaxHeightScrollView;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0004J\b\u0010\u0015\u001a\u00020\tH\u0004J(\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0004J4\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0002J\"\u0010!\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0018H\u0002J \u0001\u0010$\u001a\u00020\u001d2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010'\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u00101\u001a\u00020\u001dH\u0084@¢\u0006\u0002\u00102R\u0012\u0010\u0004\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u00064"}, d2 = {"Lcom/obric/assistant/tipoff/BaseObricTipOffDialogFragment;", "Lcom/larus/bmhome/tipoff/BaseTipOffDialog;", "<init>", "()V", "logTag", "", "getLogTag", "()Ljava/lang/String;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "showNow", "configDialogWindow", "setTransparentWindowBackground", "applyNavigationBarInsets", "containerLayout", "Landroid/view/View;", "scrollContentView", "Lcom/larus/common_ui/widget/MaxHeightScrollView;", "scrollBoundaryDivider", "updateScrollContentMaxHeight", "", "keyboardOffset", "state", "Lcom/obric/assistant/tipoff/BaseObricTipOffDialogFragment$ScrollContentHeightState;", "calculateFixedContainerHeight", "calculateViewOccupiedHeight", "view", "reportFeedbackToObric", "tagList", "", "content", "messageIdList", "filePathList", "omniTaskId", "feedbackMsgId", "feedbackSource", "feedbackBizType", "searchTool", "isConsentChecked", com.bytedance.android.ec.core.event.a.KEY_SCORE, "needUploadImage", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ScrollContentHeightState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseObricTipOffDialogFragment extends BaseTipOffDialog {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f393420d = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f393421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f393422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f393423c;

        public a() {
        }
    }

    public abstract String getLogTag();

    public final void Y90() {
        Dialog r100 = getDialog();
        if (r100 == null) goto L10;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L11;
        WindowCompat.setDecorFitsSystemWindows(r101, false);
        r101.setSoftInputMode(48);
        r101.setStatusBarColor(0);
        r101.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT < 29) goto L12;
        r101.setStatusBarContrastEnforced(false);
        r101.setNavigationBarContrastEnforced(false);
        return;
    L12:
        return;
    L11:
        return;
    }

    public BaseObricTipOffDialogFragment() {
    }

    public static final boolean U90(WindowInsetsAnimationCompat r100) {
        if ((r100.getTypeMask() & WindowInsetsCompat.Type.ime()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int X90(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Integer r102 = null;
        if ((r101 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r101;
    L6:
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.height;
    L10:
        Integer r106 = Integer.valueOf(r105);
        if (r106.intValue() <= 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        r102 = r106;
    L16:
        if (r102 == null) goto L18;
        int r108 = r102.intValue();
    L19:
        int r109 = Math.max(r100.getMeasuredHeight(), r108);
        if (r103 == null) goto L22;
        int r110 = r103.topMargin;
    L23:
        int r111 = r109 + r110;
        if (r103 == null) goto L27;
        r104 = r103.bottomMargin;
    L27:
        return r111 + r104;
    L22:
        r110 = 0;
        goto L23
    L18:
        r108 = 0;
        goto L19
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(2, R.style.Theme_FlowFullScreenDialog);
    }

    public static final boolean V90(Set<WindowInsetsAnimationCompat> r100, Set<WindowInsetsAnimationCompat> r101) {
        if ((!r100.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!r101.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int show(FragmentTransaction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "transaction");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, this, r102) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        return super.show(r100, r101);
    L17:
        return -1;
    L9:
        e = move-exception;
        FLogger.f375446a.e(getLogTag(), "show error: " + e.getMessage(), e);
        return -1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void showNow(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        super.showNow(r100, r101);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e(getLogTag(), "showNow error: " + e.getMessage(), e);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L9
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r101, r102);     // Catch: Exception -> L9
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r100, this, r102) == true) goto L17;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L7:
        super.show(r100, r101);     // Catch: Exception -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e(getLogTag(), "show error: " + e.getMessage(), e);
    }

    public static boolean Z90(View r100, MaxHeightScrollView r101, View r110, int r111, a r112) {
        if (r101 != null) goto L6;
        return true;
    L6:
        if (ViewCompat.isAttachedToWindow(r100) == true) goto L8;
    L85:
        return true;
    L8:
        if (ViewCompat.isAttachedToWindow(r101) == false) goto L85;
        if (ViewCompat.isLaidOut(r100) == true) goto L13;
    L84:
        return false;
    L13:
        if (ViewCompat.isLaidOut(r101) == false) goto L84;
        Object r102 = r100.getParent();
        ViewGroup r103 = null;
        if ((r102 instanceof View) == false) goto L18;
        View r104 = (View) r102;
    L19:
        if (r104 == null) goto L21;
        int r105 = r104.getHeight();
    L22:
        Integer r106 = Integer.valueOf(r105);
        if (r106.intValue() <= 0) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == true) goto L29;
        r106 = null;
    L29:
        if (r106 == null) goto L31;
        int r108 = r106.intValue();
    L32:
        if (r108 > 0) goto L34;
        return false;
    L34:
        ViewGroup.LayoutParams r109 = r100.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L37;
        ViewGroup.MarginLayoutParams r113 = (ViewGroup.MarginLayoutParams) r109;
    L38:
        if (r113 == null) goto L40;
        int r114 = r113.topMargin;
    L41:
        int r115 = (r108 - r114) - r111;
        if ((r100 instanceof ViewGroup) == false) goto L44;
        r103 = (ViewGroup) r100;
    L44:
        int r116 = 8;
        if (r103 != null) goto L47;
        int r117 = 0;
    L57:
        int r118 = r115 - r117;
        View r119 = r101.getChildAt(0);
        if (r119 == null) goto L60;
        int r120 = r119.getMeasuredHeight();
    L61:
        if (r120 <= r118) goto L63;
        boolean r121 = true;
    L64:
        if (r121 == false) goto L66;
        r116 = 0;
    L66:
        if (r110 == null) goto L73;
        Integer r122 = r112.f393423c;
        if (r122 != null) goto L71;
    L72:
        r110.setVisibility(r116);
        r112.f393423c = Integer.valueOf(r116);
        goto L73
    L71:
        if (r122.intValue() != r116) goto L72;
    L73:
        if (r121 == false) goto L76;
        if (r110 == null) goto L76;
        int r123 = X90(r110);
    L77:
        int r124 = Math.max(0, r118 - r123);
        Integer r125 = r112.f393422b;
        if (r125 != null) goto L81;
    L82:
        r101.setMaxHeight(r124);
        r112.f393422b = Integer.valueOf(r124);
    L83:
        return true;
    L81:
        if (r125.intValue() == r124) goto L83;
    L76:
        r123 = 0;
        goto L77
    L63:
        r121 = false;
        goto L64
    L60:
        r120 = 0;
        goto L61
    L47:
        r117 = r103.getPaddingTop() + r103.getPaddingBottom();
        int r126 = r103.getChildCount();
        int r127 = 0;
    L48:
        if (r127 >= r126) goto L57;
        View r128 = r103.getChildAt(r127);
        if (r128 == r101) goto L56;
        if (r128 == r110) goto L56;
        if (r128.getVisibility() == 8) goto L56;
        Intrinsics.checkNotNull(r128);
        r117 = r117 + X90(r128);
    L56:
        r127 = r127 + 1;
        goto L48
    L40:
        r114 = 0;
        goto L41
    L37:
        r113 = null;
        goto L38
    L31:
        r108 = r100.getRootView().getHeight();
        goto L32
    L25:
        r107 = false;
        goto L26
    L21:
        r105 = 0;
        goto L22
    L18:
        r104 = null;
        goto L19
    }

    public static final void W90(BaseObricTipOffDialogFragment r100, MaxHeightScrollView r101, View r102, a r110, int r111, View r112, WindowInsetsCompat r113) {
        int r103 = r113.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r114 = r111 + r103;
        if (r112.getPaddingBottom() == r114) goto L5;
        r112.setPadding(r112.getPaddingLeft(), r112.getPaddingTop(), r112.getPaddingRight(), r114);
    L5:
        int r104 = Math.max(0, r113.getInsets(WindowInsetsCompat.Type.ime()).bottom - r103);
        float r115 = -r104;
        if (Math.abs(r112.getTranslationY() - r115) > 0.5f) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == true) goto L11;
        r112.setTranslationY(r115);
    L11:
        r100.getClass();
        if (Z90(r112, r101, r102, r104, r110) == false) goto L14;
        return;
    L14:
        if (r110.f393421a == false) goto L16;
        return;
    L16:
        if (ViewCompat.isAttachedToWindow(r112) == false) goto L39;
        r110.f393421a = true;
        if (ViewCompat.isLaidOut(r112) == false) goto L25;
        if (r101 == null) goto L25;
        if (ViewCompat.isLaidOut(r101) == true) goto L25;
        View r116 = r101;
    L27:
        if (r116.isLaidOut() == true) goto L29;
    L33:
        r116.addOnLayoutChangeListener(new d(r110, r112, r100, r101, r102, r104));
        return;
    L29:
        if (r116.isLayoutRequested() == true) goto L33;
        r110.f393421a = false;
        if (ViewCompat.isAttachedToWindow(r112) == false) goto L37;
        Z90(r112, r101, r102, r104, r110);
        return;
    L37:
        return;
    L25:
        r116 = r112;
        goto L27
    L39:
        return;
    L8:
        r105 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void T90(View r110, Ref.ObjectRef r111, BaseObricTipOffDialogFragment r112, MaxHeightScrollView r113, View r114, a r115, int r116, String r117) {
        WindowInsetsCompat r100 = ViewCompat.getRootWindowInsets(r110);
        if (r100 != null) goto L5;
        WindowInsetsCompat r101 = (WindowInsetsCompat) r111.element;
    L6:
        if (r100 == null) goto L9;
        String r102 = RootDescription.ROOT_ELEMENT;
    L12:
        r111.element = null;
        FLogger.f375446a.i(r112.getLogTag(), "Apply final IME insets, reason=" + r117 + ", source=" + r102);
        if (r101 == null) goto L16;
        W90(r112, r113, r114, r115, r116, r110, r101);
        return;
    L16:
        return;
    L9:
        if (r111.element == 0) goto L11;
        r102 = AiBotPollingAuthResult.STATUS_PENDING;
        goto L12
    L11:
        r102 = "none";
        goto L12
    L5:
        r101 = r100;
        goto L6
    }
}
