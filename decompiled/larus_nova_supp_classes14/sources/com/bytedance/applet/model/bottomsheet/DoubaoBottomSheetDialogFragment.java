package com.bytedance.applet.model.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ai.api.AppletBottomSheetAction;
import com.bytedance.ai.api.AppletBottomSheetButtonRole;
import com.bytedance.ai.api.AppletBottomSheetCancelSource;
import com.bytedance.applet.databinding.LarusDoubaoBottomSheetDialogBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.common_ui.widget.roundlayout.RoundFrameLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import iw3.e;
import iw3.f;
import iw3.g;
import iw3.h;
import iw3.i;
import iw3.j;
import iw3.k;
import iw3.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 O2\u00020\u0001:\u0002NOB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\"\u001a\u00020\u0007*\u00020\u00132\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0014\u0010'\u001a\u00020\u0007*\u00020\u00132\u0006\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020\u0007*\u00020\u0013H\u0002J\f\u0010+\u001a\u00020\u0007*\u00020\u0013H\u0002J\u001a\u0010,\u001a\u00020\u0007*\u00020\u00132\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0018\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0002J\f\u00104\u001a\u00020\u0007*\u00020\u0013H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\u00072\u0006\u00108\u001a\u000209H\u0016J\b\u0010;\u001a\u00020\u0007H\u0016J\u000e\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0006H\u0002J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\rH\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\rH\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010=\u001a\u00020>H\u0002J\b\u0010E\u001a\u00020\u0007H\u0002J\u0016\u0010F\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010G\u001a\u00020\u0017H\u0002J\u000e\u0010H\u001a\u0004\u0018\u00010\u0006*\u00020)H\u0002J\f\u0010I\u001a\u00020$*\u00020)H\u0002J\f\u0010J\u001a\u00020)*\u00020)H\u0002J\f\u0010K\u001a\u00020)*\u00020)H\u0002J\f\u0010L\u001a\u000203*\u000203H\u0002J\b\u0010M\u001a\u000203H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/bytedance/applet/model/bottomsheet/DoubaoBottomSheetDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onButtonClick", "Lkotlin/Function1;", "Lcom/bytedance/ai/api/AppletBottomSheetButtonRole;", "", "getOnButtonClick", "()Lkotlin/jvm/functions/Function1;", "setOnButtonClick", "(Lkotlin/jvm/functions/Function1;)V", "onCancelClick", "Lcom/bytedance/ai/api/AppletBottomSheetCancelSource;", "getOnCancelClick", "setOnCancelClick", "completed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "binding", "Lcom/bytedance/applet/databinding/LarusDoubaoBottomSheetDialogBinding;", "pendingCancelSource", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "updateHeaderLayout", "hasAppInfo", "", "hasAppName", "hasIcon", "bindContent", "contentHtml", "", "setupContentNestedScroll", "setupContentFade", "bindButtons", "buttons", "", "Lcom/bytedance/applet/model/bottomsheet/DoubaoBottomSheetDialogFragment$ButtonUiModel;", "createButtonView", "button", "index", "", "setupBottomInsets", "updateContentHeightLimit", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onDestroyView", "dismissWithResult", "result", "Lcom/bytedance/ai/api/AppletBottomSheetResult;", "dismissWithButtonRole", "role", "dismissWithCancelSource", "source", "resolveCancel", "resolve", "clearHandlers", "readButtons", "args", "toButtonRole", "hasSupportedHtmlTag", "normalizeParagraphHtml", "toPlainTextFallback", "dpToPx", "getTheme", "ButtonUiModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoubaoBottomSheetDialogFragment extends BottomSheetDialogFragment {
    public static final Regex i = null;
    public static final Regex j = null;
    public static final Regex k = null;
    public Function1<? super AppletBottomSheetButtonRole, Unit> d;
    public Function1<? super AppletBottomSheetCancelSource, Unit> e;
    public final AtomicBoolean f;
    public LarusDoubaoBottomSheetDialogBinding g;
    public AppletBottomSheetCancelSource h;

    public static final class a {
        public final AppletBottomSheetButtonRole a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ButtonUiModel(role=" + this.a + ", text=" + this.b + ')';
        }

        public a(AppletBottomSheetButtonRole r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "role");
            Intrinsics.checkNotNullParameter(r3, "text");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[AppletBottomSheetButtonRole.values().length];
            r0[AppletBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[AppletBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[AppletBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            a = r0;
            int[] r1 = new int[AppletBottomSheetAction.values().length];
            r1[AppletBottomSheetAction.BUTTON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[AppletBottomSheetAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    public static final class d extends BottomSheetBehavior.BottomSheetCallback {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ BottomSheetBehavior<View> b;
        public final /* synthetic */ DoubaoBottomSheetDialogFragment c;

        public final void onSlide(View r1, float r2) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public final void onStateChanged(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "bottomSheet");
            boolean r5 = this.a;
            if (r5 == false) goto L5;
        L11:
            if (r5 == false) goto L17;
            if (r4 == 5) goto L14;
            return;
        L14:
            if (this.c.f.get() == true) goto L19;
            DoubaoBottomSheetDialogFragment r6 = this.c;
            AppletBottomSheetCancelSource r7 = AppletBottomSheetCancelSource.GESTURE;
            r6.h = r7;
            r6.T90(r7);
            DoubaoBottomSheetDialogFragment.S90(r6);
            return;
        L19:
            return;
        L17:
            return;
        L5:
            if (r4 != 1) goto L7;
        L9:
            this.b.setState(3);
            return;
        L7:
            if (r4 == 4) goto L9;
            if (r4 != 5) goto L11;
            goto L9
        }

        public d(boolean r1, BottomSheetBehavior<View> r2, DoubaoBottomSheetDialogFragment r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public final int getTheme() {
        return 2131954335;
    }

    public final void onDestroyView() {
        this.g = null;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    static {
        RegexOption r1 = RegexOption.IGNORE_CASE;
        i = new Regex("</?\\s*(p|b|a)\\b", r1);
        j = new Regex("<p\\b[^>]*>", r1);
        k = new Regex("</p>", r1);
    }

    public final void U90() {
        final LarusDoubaoBottomSheetDialogBinding r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.a.getHeight();
        int r2 = r0.h.getHeight();
        int r3 = r0.e.getMeasuredHeight();
        if (r1 <= 0) goto L19;
        if (r2 <= 0) goto L20;
        if (r3 <= 0) goto L21;
        Resources r4 = getResources();
        Resources r5 = getResources();
        int r6 = RangesKt.coerceAtMost(r3, RangesKt.coerceAtLeast(((int) (WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).heightPixels * 0.85f)) - (r1 - r2), (int) ((72 * WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density) + 0.5f)));
        NestedScrollView r7 = r0.h;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        if (r8 == null) goto L18;
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        if (r9.height == r6) goto L15;
        r9.height = r6;
    L15:
        r7.setLayoutParams(r9);
        r0.h.post(new j(r0));
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L21:
        return;
    L20:
        return;
    }

    public DoubaoBottomSheetDialogFragment() {
        this.f = new AtomicBoolean(false);
        this.h = AppletBottomSheetCancelSource.MASK;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        final boolean r0 = requireArguments().getBoolean("arg_dismiss_on_mask_tap", true);
        Dialog r1 = getDialog();
        if (r1 == null) goto L5;
        r1.setCanceledOnTouchOutside(r0);
    L5:
        Dialog r2 = getDialog();
        if (r2 == null) goto L10;
        View r3 = r2.findViewById(2131389274);
        if (r3 == null) goto L10;
        r3.setOnClickListener(new e(this, r0));
    L10:
        Dialog r4 = getDialog();
        if (r4 == null) goto L23;
        View r5 = r4.findViewById(2131368870);
        if (r5 == null) goto L24;
        r5.setBackgroundColor(0);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L17
        BottomSheetBehavior r7 = BottomSheetBehavior.from(r5);     // Catch: Throwable -> L17
        r7.setState(3);     // Catch: Throwable -> L17
        r7.setSkipCollapsed(true);     // Catch: Throwable -> L17
        r7.setHideable(r0);     // Catch: Throwable -> L17
        r7.setBottomSheetCallback(new d(r0, r7, this));     // Catch: Throwable -> L17
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.box-impl(r8);
        return;
    L17:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L24:
        return;
    }

    public static void S90(DoubaoBottomSheetDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(AppletBottomSheetCancelSource r4) {
        if (this.f.compareAndSet(false, true) == false) goto L9;
        Function1<? super AppletBottomSheetCancelSource, Unit> r0 = this.e;
        if (r0 == null) goto L7;
        r0.invoke(r4);
    L7:
        this.d = null;
        this.e = null;
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onCancel(r2);
        T90(this.h);
    }

    public final void onCreate(Bundle r3) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r3);
        setCancelable(requireArguments().getBoolean("arg_dismiss_on_mask_tap", true));
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = super.onCreateDialog(r2);
        r3.setOnKeyListener(new iw3.d(this));
        return r3;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L5
        T90(this.h);     // Catch: Throwable -> L5
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

    /* JADX WARN: Type inference failed for: r0v32, types: [iw3.f] */
    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r18, r19);
        Bundle r2 = requireArguments();
        final LarusDoubaoBottomSheetDialogBinding r3 = this.g;
        if (r3 == null) goto L151;
        String r0 = r2.getString("arg_app_name");
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        String r5 = r2.getString("arg_icon_url");
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        if ((!StringsKt.isBlank(r0)) == false) goto L13;
    L16:
        boolean r6 = true;
    L17:
        SimpleDraweeView r9 = r3.b;
        int r11 = 8;
        if ((!StringsKt.isBlank(r5)) == false) goto L20;
        int r10 = 0;
    L21:
        r9.setVisibility(r10);
        TextView r12 = r3.c;
        if ((!StringsKt.isBlank(r0)) == false) goto L24;
        r11 = 0;
    L24:
        r12.setVisibility(r11);
        boolean r13 = !StringsKt.isBlank(r0);
        boolean r14 = !StringsKt.isBlank(r5);
        int r15 = getResources().getDimensionPixelSize(2131166064);
        int r16 = getResources().getDimensionPixelSize(2131166277);
        int r17 = getResources().getDimensionPixelSize(2131165976);
        TextView r110 = r3.c;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L150;
        ConstraintLayout.LayoutParams r7 = (ConstraintLayout.LayoutParams) r111;
        if (r14 == false) goto L29;
        r7.startToStart = -1;
        r7.startToEnd = 2131363092;
        r7.topToTop = 2131363092;
        r7.bottomToBottom = 2131363092;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = 0;
        r7.setMarginStart(r16);
        int r112 = -1;
    L30:
        r110.setLayoutParams(r7);
        TextView r8 = r3.i;
        ViewGroup.LayoutParams r20 = r8.getLayoutParams();
        if (r20 == null) goto L148;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        if (r14 == false) goto L36;
        r21.startToStart = 2131363092;
        r21.topToTop = r112;
        r21.topToBottom = 2131363092;
        r21.setMarginStart(0);
        ((ViewGroup.MarginLayoutParams) r21).topMargin = r17;
    L39:
        r8.setLayoutParams(r21);
        FrameLayout r22 = r3.g;
        ViewGroup.LayoutParams r23 = r22.getLayoutParams();
        if (r23 == null) goto L146;
        ConstraintLayout.LayoutParams r24 = (ConstraintLayout.LayoutParams) r23;
        if (r6 == false) goto L44;
        int r25 = 2131388772;
    L45:
        r24.startToStart = r25;
        if (r6 == false) goto L48;
        r15 = 0;
    L48:
        r24.setMarginStart(r15);
        r22.setLayoutParams(r24);
        r3.c.setText(r0);
        if ((!StringsKt.isBlank(r5)) == false) goto L51;
        ImageLoaderKt.u(r3.b, r5, "AppletBottomSheet");
    L51:
        TextView r1 = r3.i;
        String r26 = r2.getString("arg_title");
        if (r26 != null) goto L54;
        r26 = "";
    L54:
        r1.setText(r26);
        String r4 = r2.getString("arg_content");
        if (r4 != null) goto L57;
        String r27 = "";
    L58:
        r3.e.setOnClickListener(new m(this));
        if (i.containsMatchIn(r27) == true) goto L152;
        r3.e.setText(r27);
    L77:
        ViewCompat.setNestedScrollingEnabled(r3.h, true);
        final ?? r28 = new f(r3);
        r3.h.getViewTreeObserver().addOnScrollChangedListener(new g(r28));
        r3.h.post(new h(r28));
        List r29 = r2.getStringArrayList("arg_button_roles");
        if (r29 != null) goto L80;
        r29 = CollectionsKt.emptyList();
    L80:
        Iterable r30 = r2.getStringArrayList("arg_button_texts");
        if (r30 != null) goto L83;
        r30 = CollectionsKt.emptyList();
    L83:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
        int r33 = 0;
    L85:
        if (r32.hasNext() == false) goto L115;
        Object r34 = r32.next();
        int r35 = r33 + 1;
        if (r33 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        String r36 = (String) r34;
        String r37 = (String) CollectionsKt.getOrNull(r29, r33);
        a r38 = null;
        if (r37 == null) goto L112;
        int r39 = r37.hashCode();
        if (r39 == (-934710369)) goto L106;
        if (r39 == 974829189) goto L103;
        if (r39 == 1832567796) goto L99;
    L107:
        AppletBottomSheetButtonRole r40 = null;
    L109:
        if (r40 == null) goto L112;
        Intrinsics.checkNotNull(r36);
        r38 = new a(r40, r36);
        goto L112
    L99:
        if (r37.equals("agreeSub") == false) goto L107;
        r40 = AppletBottomSheetButtonRole.AGREE_SUB;
        goto L109
    L103:
        if (r37.equals("agreeMain") == false) goto L107;
        r40 = AppletBottomSheetButtonRole.AGREE_MAIN;
        goto L109
    L106:
        if (r37.equals("reject") == false) goto L107;
        r40 = AppletBottomSheetButtonRole.REJECT;
    L112:
        if (r38 == null) goto L114;
        r31.add(r38);
    L114:
        r33 = r35;
        goto L85
    L115:
        r3.d.removeAllViews();
        Iterator r41 = r31.iterator();
        int r42 = 0;
    L117:
        if (r41.hasNext() == false) goto L144;
        Object r43 = r41.next();
        int r44 = r42 + 1;
        if (r42 >= 0) goto L121;
        CollectionsKt.throwIndexOverflow();
    L121:
        final a r45 = (a) r43;
        LinearLayout r46 = r3.d;
        Context r47 = requireContext();
        int r48 = getResources().getDimensionPixelSize(2131166231);
        int r49 = v19.c.b(2130971208, r47, 2131166786);
        if (r42 != 0) goto L124;
        int r50 = 0;
    L125:
        AppletBottomSheetButtonRole r113 = r45.a;
        int[] r114 = c.a;
        int r115 = r114[r113.ordinal()];
        if (r115 == 1) goto L133;
        if (r115 == 2) goto L132;
        if (r115 == 3) goto L132;
        throw new NoWhenBranchMatchedException();
    L132:
        int r116 = 2131103685;
    L134:
        int r117 = r114[r45.a.ordinal()];
        if (r117 == 1) goto L142;
        if (r117 == 2) goto L141;
        if (r117 == 3) goto L141;
        throw new NoWhenBranchMatchedException();
    L141:
        int r118 = 2131103681;
    L143:
        RoundFrameLayout r119 = new RoundFrameLayout(r47);
        LinearLayout.LayoutParams r120 = new LinearLayout.LayoutParams(-1, r48);
        r120.topMargin = r50;
        r119.setLayoutParams(r120);
        int r51 = ContextCompat.getColor(r47, r116);
        r119.getDelegate().e(r119.getResources().getDimensionPixelSize(r49));
        c29.a r52 = r119.getDelegate();
        r52.s = false;
        r52.e = r51;
        r52.g = r51;
        r52.c();
        TextView r53 = new TextView(r47);
        r53.setGravity(17);
        r53.setMaxLines(1);
        r53.setEllipsize(TextUtils.TruncateAt.END);
        r53.setText(r45.b);
        r53.setTextSize(17.0f);
        r53.setTypeface(Typeface.DEFAULT_BOLD);
        r53.setTextColor(ContextCompat.getColor(r47, r118));
        r119.addView(r53, new FrameLayout.LayoutParams(-1, -2, 17));
        e1.d(r119, new k(this, r45));
        r46.addView(r119);
        r42 = r44;
        goto L117
    L142:
        r118 = 2131103298;
        goto L143
    L133:
        r116 = 2131105539;
        goto L134
    L124:
        r50 = getResources().getDimensionPixelSize(r49);
        goto L125
    L144:
        final int r54 = getResources().getDimensionPixelSize(2131165976);
        ViewCompat.setOnApplyWindowInsetsListener(r3.a, new i(r54, this));
        ViewCompat.requestApplyInsets(r3.a);
        r3.a.post(new iw3.c(this));
        return;
    L152:
        Result.Companion r55 = Result.Companion;     // Catch: Throwable -> L62
        r3.e.setUrlSpannedText(k.replace(j.replace(StringsKt.trim(r27).toString(), ""), "<br/>"));     // Catch: Throwable -> L62
        Object r56 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L62
    L64:
        Object r57 = r56;
        if (Result.exceptionOrNull-impl(r57) == null) goto L75;
        UrlSpanTextView r58 = r3.e;
        Object r59 = Result.constructor-impl(HtmlCompat.fromHtml(r27, 0).toString());     // Catch: Throwable -> L69
    L71:
        Object r60 = r27;
        if (Result.exceptionOrNull-impl(r59) != null) goto L74;
        r60 = r59;
    L74:
        r58.setText((String) r60);
    L69:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r59 = Result.constructor-impl(ResultKt.createFailure(th));
    L75:
        Result.box-impl(r57);
    L62:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        r56 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L64
    L57:
        r27 = r4;
        goto L58
    L44:
        r25 = 0;
        goto L45
    L146:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L36:
        if (r13 == false) goto L38;
        r21.startToStart = 0;
        r21.topToTop = r112;
        r21.topToBottom = 2131363103;
        r21.setMarginStart(r15);
        ((ViewGroup.MarginLayoutParams) r21).topMargin = r17;
        goto L39
    L38:
        r21.startToStart = 0;
        r21.topToBottom = r112;
        r21.topToTop = 0;
        r21.setMarginStart(r15);
        ((ViewGroup.MarginLayoutParams) r21).topMargin = r15;
        goto L39
    L148:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L29:
        r112 = -1;
        r7.startToEnd = -1;
        r7.startToStart = 0;
        r7.topToTop = 0;
        r7.bottomToBottom = -1;
        ((ViewGroup.MarginLayoutParams) r7).topMargin = r15;
        r7.setMarginStart(r15);
        goto L30
    L150:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L20:
        r10 = 8;
        goto L21
    L13:
        if ((!StringsKt.isBlank(r5)) == true) goto L16;
        r6 = false;
        goto L17
    }

    public final View onCreateView(LayoutInflater r11, ViewGroup r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "inflater");
        ConstraintLayout r14 = r11.inflate(2131562318, r12, false);
        int r15 = 2131363092;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(r14, 2131363092);
        if (r2 == null) goto L25;
        r15 = 2131363103;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r14, 2131363103);
        if (r3 == null) goto L25;
        r15 = 2131365005;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, 2131365005);
        if (r4 == null) goto L25;
        r15 = 2131367794;
        UrlSpanTextView r5 = ViewBindings.findChildViewById(r14, 2131367794);
        if (r5 == null) goto L25;
        r15 = 2131367808;
        View r6 = ViewBindings.findChildViewById(r14, 2131367808);
        if (r6 == null) goto L25;
        r15 = 2131367812;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r14, 2131367812);
        if (r7 == null) goto L25;
        r15 = 2131367850;
        NestedScrollView r8 = ViewBindings.findChildViewById(r14, 2131367850);
        if (r8 == null) goto L25;
        ConstraintLayout r16 = r14;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r14, 2131388772);
        if (r9 == null) goto L23;
        this.g = new LarusDoubaoBottomSheetDialogBinding(r16, r2, r3, r4, r5, r6, r7, r8, r9);
        if (r16 == null) goto L22;
        return r16;
    L22:
        return new View(requireContext());
    L23:
        r15 = 2131388772;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r15)));
    }
}
