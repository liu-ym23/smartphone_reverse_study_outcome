package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import ntb.a0;
import ntb.q;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 b2\u00020\u0001:\u0001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010,\u001a\u0004\u0018\u00010\"2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\"2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020\u000bH\u0016J\u0010\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010;\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J(\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010\u001a2\u0006\u0010?\u001a\u00020@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\f0BH\u0002J\u0010\u0010C\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\fH\u0002J\u001c\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020F2\b\u0010H\u001a\u0004\u0018\u00010FH\u0002J\u0010\u0010I\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020+2\u0006\u0010:\u001a\u00020\u0007H\u0002J \u0010K\u001a\u00020\f2\u0006\u0010L\u001a\u00020\"2\u0006\u0010?\u001a\u00020@2\u0006\u0010M\u001a\u00020\u000bH\u0002J\"\u0010N\u001a\u00020\f2\u0006\u0010L\u001a\u00020\"2\u0006\u0010O\u001a\u00020+2\b\u0010P\u001a\u0004\u0018\u00010@H\u0002J\u0010\u0010Q\u001a\u00020\f2\u0006\u0010:\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020\fH\u0003J\u0012\u0010S\u001a\u00020\u000b2\b\b\u0002\u0010T\u001a\u00020\u000bH\u0002J\b\u0010U\u001a\u00020\fH\u0016J\u0010\u0010\b\u001a\u00020\f2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020FH\u0002J\u0010\u0010Z\u001a\u00020\u000b2\u0006\u0010[\u001a\u00020FH\u0002J\u001a\u0010\\\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u0005H\u0002J\u001a\u0010`\u001a\u00020\u000b2\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010a\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "mdMarginDefault", "", "panelOptions", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelOptions;", "onDismiss", "Lkotlin/Function2;", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelPickerResult;", "", "", "linkClickResolver", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelLinkClickResolver;", "errorCode", "selectItem", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/SelectPanelItem;", "selectItems", "", "callbackItemId", "selectStyle", "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/ItemSelectInfo;", "titleBarLayout", "Landroid/widget/RelativeLayout;", "panelContent", "Landroid/widget/LinearLayout;", "panelTitle", "Landroid/widget/TextView;", "panelDesc", "leftActionLayout", "rightActionLayout", "panelTitleContainer", "dragBar", "Landroid/view/View;", "panelScrollView", "Landroid/widget/ScrollView;", "titleBarDivider", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheet", "initialY", "isDragging", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "getTheme", "setWindowParam", "options", "setupTitle", "setupActions", "setupActionItem", "layout", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/chameleonv2/lkapi/widget/panel/PanelItem;", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "setupMarkdown", "updateTitleContainerPadding", "resolveMarkdownLink", "", "link", "baseUrl", "setupContent", "isContentInvalid", "setupPanelItem", "itemView", "pickerType", "updateItemSelectState", "selected", "panelItem", "setupDragBar", "setupTitleBarDrag", "getStyleColor", "style", "onDestroyView", "dialog", "Landroid/content/DialogInterface;", "getUDResource", "icon", "getUDColor", "colorName", "dp2px", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dpValue", "px2dp", "pxValue", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelBottomDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f411468y = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f411469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PanelOptions f411470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super PanelPickerResult, ? super Integer, Unit> f411471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f411472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f411473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<g> f411474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public PanelPickerResult f411475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ItemSelectInfo f411476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RelativeLayout f411477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f411478m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f411479n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f411480o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LinearLayout f411481p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LinearLayout f411482q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public LinearLayout f411483r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f411484s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ScrollView f411485t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f411486u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f411487v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f411488w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f411489x;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PanelBottomDialog f411490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DisplayMetrics f411491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f411492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f411493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f411494e;

        public b(PanelBottomDialog r100, DisplayMetrics r101, int r102, int r103, View r104) {
            this.f411490a = r100;
            this.f411491b = r101;
            this.f411492c = r102;
            this.f411493d = r103;
            this.f411494e = r104;
        }

        public final void a() {
            PanelBottomDialog r100 = this.f411490a;
            RelativeLayout r101 = r100.f411477l;
            LinearLayout r102 = r100.f411483r;
            if (r102 == null) goto L14;
            LinearLayout r103 = r100.f411481p;
            if (r103 == null) goto L8;
            int r104 = r103.getMeasuredWidth();
        L9:
            LinearLayout r105 = r100.f411482q;
            if (r105 == null) goto L12;
            int r106 = r105.getMeasuredWidth();
        L13:
            int r107 = Math.max(r104, r106);
            r102.setPadding(r107, r102.getPaddingTop(), r107, r102.getPaddingBottom());
            goto L14
        L12:
            r106 = 0;
            goto L13
        L8:
            r104 = 0;
        L14:
            ScrollView r108 = this.f411490a.f411485t;
            boolean r109 = true;
            Integer r110 = null;
            if (r108 == null) goto L25;
            Integer r111 = Integer.valueOf(r108.getMeasuredWidth());
            if (r111.intValue() <= 0) goto L19;
            boolean r112 = true;
        L20:
            if (r112 == true) goto L23;
            r111 = null;
        L23:
            if (r111 == null) goto L25;
            int r113 = r111.intValue();
        L37:
            if (r101 == null) goto L39;
            r101.measure(View.MeasureSpec.makeMeasureSpec(r113, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        L39:
            LinearLayout r114 = this.f411490a.f411478m;
            if (r114 == null) goto L42;
            r114.measure(View.MeasureSpec.makeMeasureSpec(r113, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        L42:
            LinearLayout r115 = this.f411490a.f411478m;
            if (r115 == null) goto L45;
            int r116 = r115.getMeasuredHeight();
        L46:
            if (r101 == null) goto L48;
            int r117 = r101.getMeasuredHeight();
        L49:
            View r118 = this.f411490a.f411484s;
            if (r118 == null) goto L52;
            int r119 = r118.getMeasuredHeight();
        L53:
            int r120 = (r116 + r117) + r119;
            PanelBottomDialog r121 = this.f411490a;
            int r122 = r120 + r121.U90(r121.getContext(), 16.0f);
            int r123 = this.f411492c;
            if (r122 >= r123) goto L56;
        L55:
            r122 = r123;
        L59:
            Log.i("LK_API_TAG_PanelBottomDialog", "finalHeight:" + r122);
            ViewGroup.LayoutParams r124 = this.f411494e.getLayoutParams();
            r124.height = r122;
            this.f411494e.setLayoutParams(r124);
            BottomSheetBehavior r125 = BottomSheetBehavior.from(this.f411494e);
            r125.setPeekHeight(r122);
            r125.setDraggable(false);
            return;
        L56:
            r123 = this.f411493d;
            if (r122 <= r123) goto L59;
        L52:
            r119 = 0;
            goto L53
        L48:
            r117 = 0;
            goto L49
        L45:
            r116 = 0;
            goto L46
        L19:
            r112 = false;
        L25:
            View r126 = this.f411490a.getView();
            if (r126 == null) goto L33;
            Integer r127 = Integer.valueOf(r126.getMeasuredWidth());
            if (r127.intValue() > 0) goto L31;
            r109 = false;
        L31:
            if (r109 == false) goto L33;
            r110 = r127;
        L33:
            if (r110 == null) goto L35;
            r113 = r110.intValue();
            goto L37
        L35:
            r113 = this.f411491b.widthPixels;
            goto L37
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f411495a;

        public c(Function0<Unit> r100) {
            this.f411495a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f411495a.invoke();
        }
    }

    static {
    }

    @Override // androidx.fragment.app.DialogFragment
    public final int getTheme() {
        return R.style.office_CmlBottomSheetDialogTheme;
    }

    public PanelBottomDialog() {
        this.f411469d = 12.0f;
        this.f411474i = new LinkedHashSet();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f411471f = null;
        this.f411477l = null;
        this.f411478m = null;
        this.f411479n = null;
        this.f411480o = null;
        this.f411481p = null;
        this.f411482q = null;
        this.f411483r = null;
        this.f411484s = null;
        this.f411485t = null;
        this.f411486u = null;
        this.f411487v = null;
        Log.i("LK_API_TAG_PanelBottomDialog", "onDestroyView");
    }

    public static void S90(PanelBottomDialog r100) {
        r100.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void T90(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onDismiss(r100);
        Log.i("LK_API_TAG_PanelBottomDialog", "onDismiss, " + this.f411475j);
        Function2<? super PanelPickerResult, ? super Integer, Unit> r101 = this.f411471f;
        if (r101 == null) goto L6;
        r101.invoke(this.f411475j, Integer.valueOf(this.f411472g));
        return;
    }

    public final int V90(int r100) {
        if (r100 != ColorStyle.Normal.getValue()) goto L6;
        return ContextCompat.getColor(requireContext(), R.color.ud_N800);
    L6:
        if (r100 != ColorStyle.Desc.getValue()) goto L9;
        return ContextCompat.getColor(requireContext(), R.color.ud_N600);
    L9:
        if (r100 != ColorStyle.Select.getValue()) goto L12;
        return ContextCompat.getColor(requireContext(), R.color.ud_B600);
    L12:
        if (r100 != ColorStyle.Warning.getValue()) goto L15;
        return ContextCompat.getColor(requireContext(), R.color.ud_R400);
    L15:
        if (r100 != ColorStyle.Disable.getValue()) goto L18;
        return ContextCompat.getColor(requireContext(), R.color.ud_N400);
    L18:
        if (r100 != ColorStyle.TRANSLATE.getValue()) goto L21;
        return ContextCompat.getColor(requireContext(), R.color.transparent);
    L21:
        return ContextCompat.getColor(requireContext(), R.color.ud_N800);
    }

    public final int W90(String r100) {
        String r101 = "ud_" + StringsKt.replace$default(r100, '-', '_', false, 4, null);
        Context r102 = getContext();
        if (r102 == null) goto L12;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L12;
        Context r104 = getContext();
        if (r104 == null) goto L10;
        String r105 = r104.getPackageName();
        if (r105 == null) goto L10;
    L11:
        int r106 = r103.getIdentifier(r101, "color", r105);
    L13:
        if (r106 == 0) goto L16;
        return ContextCompat.getColor(requireContext(), r106);
    L16:
        return ContextCompat.getColor(requireContext(), R.color.ud_N800);
    L10:
        r105 = "";
    L12:
        r106 = 0;
        goto L13
    }

    public final int X90(String r100) {
        String r101 = "ud_" + StringsKt.replace$default(r100, '-', '_', false, 4, null);
        Context r102 = getContext();
        if (r102 == null) goto L12;
        Resources r103 = r102.getResources();
        if (r103 == null) goto L12;
        Context r104 = getContext();
        if (r104 == null) goto L10;
        String r105 = r104.getPackageName();
        if (r105 == null) goto L10;
    L14:
        return r103.getIdentifier(r101, "drawable", r105);
    L10:
        r105 = "";
    L12:
        return 0;
    }

    public final void Y90(PanelOptions r100) {
        Resources r101 = getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        int r103 = (int) (r102.heightPixels * r100.getMinHeightPercent());
        int r104 = (int) (r102.heightPixels * r100.getMaxHeightPercent());
        Dialog r105 = getDialog();
        if (r105 == null) goto L5;
        View r106 = r105.findViewById(R.id.design_bottom_sheet);
    L6:
        View r107 = r106;
        this.f411487v = r107;
        if (r107 != null) goto L9;
        return;
    L9:
        r107.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.cml_panel_background_v2));
        View r108 = getView();
        if (r108 == null) goto L13;
        r108.post(new b(this, r102, r103, r104, r107));
        return;
    L13:
        return;
    L5:
        r106 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        Log.i("LK_API_TAG_PanelBottomDialog", "onConfigurationChanged");
        PanelOptions r101 = this.f411470e;
        if (r101 == null) goto L6;
        Y90(r101);
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        T90(r100);     // Catch: Throwable -> L5
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

    public final int U90(Context r100, float r101) {
        if (r100 == null) goto L8;
        Resources r102 = r100.getResources();
        if (r102 == null) goto L8;
        DisplayMetrics r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics());
        if (r103 == null) goto L8;
        float r104 = r103.density;
    L10:
        return (int) ((r101 * r104) + 0.5f);
    L8:
        r104 = 0.0f;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r310, Bundle r311) {
        Intrinsics.checkNotNullParameter(r310, "view");
        super.onViewCreated(r310, r311);
        this.f411477l = (RelativeLayout) r310.findViewById(R.id.title_bar_layout);
        this.f411478m = (LinearLayout) r310.findViewById(R.id.panel_content);
        this.f411479n = (TextView) r310.findViewById(R.id.panel_title);
        this.f411480o = (TextView) r310.findViewById(R.id.panel_desc);
        this.f411481p = (LinearLayout) r310.findViewById(R.id.left_action_layout);
        this.f411482q = (LinearLayout) r310.findViewById(R.id.right_action_layout);
        this.f411483r = (LinearLayout) r310.findViewById(R.id.panel_title_container);
        this.f411484s = r310.findViewById(R.id.drag_bar);
        this.f411485t = (ScrollView) r310.findViewById(R.id.panel_scroll_view);
        this.f411486u = r310.findViewById(R.id.title_bar_divider);
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.setBackgroundDrawableResource(android.R.color.transparent);
    L7:
        Dialog r102 = getDialog();
        if (r102 == null) goto L12;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L12;
        r103.setDimAmount(0.6f);
    L12:
        final PanelOptions r104 = this.f411470e;
        if (r104 == null) goto L364;
        ScrollView r105 = this.f411485t;
        if (r105 == null) goto L17;
        r105.setVerticalScrollBarEnabled(r104.getShowScrollBar());
    L17:
        TextView r106 = this.f411479n;
        String r107 = "";
        if (r106 == null) goto L34;
        String r108 = r104.getTitle();
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        r106.setText(r108);
        r106.setTextColor(V90(ColorStyle.Normal.getValue()));
        r106.setMaxLines(r104.getTitleMaxLines());
        String r109 = r104.getTitle();
        if (r109 != null) goto L26;
    L29:
        boolean r110 = true;
    L30:
        if (r110 == false) goto L32;
        int r111 = 8;
    L33:
        r106.setVisibility(r111);
        goto L34
    L32:
        r111 = 0;
        goto L33
    L26:
        if (r109.length() == 0) goto L29;
        r110 = false;
    L34:
        TextView r112 = this.f411480o;
        if (r112 == null) goto L51;
        String r113 = r104.getDesc();
        if (r113 != null) goto L40;
        r113 = "";
    L40:
        r112.setText(r113);
        r112.setTextColor(V90(ColorStyle.Desc.getValue()));
        String r114 = r104.getDesc();
        if (r114 != null) goto L43;
    L46:
        boolean r115 = true;
    L47:
        if (r115 == false) goto L49;
        int r116 = 8;
    L50:
        r112.setVisibility(r116);
        goto L51
    L49:
        r116 = 0;
        goto L50
    L43:
        if (r114.length() == 0) goto L46;
        r115 = false;
    L51:
        View r117 = this.f411486u;
        if (r117 != null) goto L54;
    L58:
        PanelItem r118 = r104.getLeftAction();
        if (r118 == null) goto L65;
        Boolean r119 = r118.getActionCallback();
        if (r119 == null) goto L63;
        final boolean r120 = r119.booleanValue();
    L64:
        Z90(this.f411481p, r118, new PanelBottomDialog$setupActions$1$1(r120, r104, this));
    L68:
        PanelItem r121 = r104.getRightAction();
        if (r121 == null) goto L75;
        Boolean r122 = r121.getActionCallback();
        if (r122 == null) goto L73;
        final boolean r123 = r122.booleanValue();
    L74:
        Z90(this.f411482q, r121, new PanelBottomDialog$setupActions$3$1(r123, r104, this));
    L78:
        View r124 = this.f411484s;
        if (r124 == null) goto L86;
        if (r104.getShowDragBar() == false) goto L83;
        int r125 = 0;
    L84:
        r124.setVisibility(r125);
        goto L86
    L83:
        r125 = 8;
    L86:
        if (r104.getShowDragBar() == false) goto L90;
        RelativeLayout r126 = this.f411477l;
        if (r126 == null) goto L90;
        r126.setOnTouchListener(new d(this));
    L90:
        LinearLayout r127 = this.f411478m;
        if (r127 == null) goto L93;
        r127.removeAllViews();
    L93:
        List<PanelItem> r128 = r104.getData();
        if (r128 != null) goto L96;
    L99:
        boolean r129 = true;
    L101:
        if (r129 == false) goto L114;
        MarkdownInfo r130 = r104.getMarkdownInfo();
        if (r130 == null) goto L105;
        String r131 = r130.getContent();
    L106:
        if (r131 != null) goto L108;
    L111:
        boolean r132 = true;
    L112:
        if (r132 == false) goto L114;
        boolean r133 = true;
    L116:
        if (r133 == false) goto L118;
        this.f411472g = -1;
        S90(this);
    L356:
        Y90(r104);
        return;
    L118:
        final MarkdownInfo r134 = r104.getMarkdownInfo();
        if (r134 == null) goto L121;
        String r135 = r134.getContent();
    L123:
        if (r134 == null) goto L236;
        if (r135 != null) goto L126;
    L129:
        boolean r136 = true;
    L130:
        if (r136 == true) goto L236;
        Margin r137 = r134.getContentMargin();
        Context r138 = getContext();
        if (r137 == null) goto L137;
        Float r139 = r137.getLeft();
        if (r139 == null) goto L137;
        float r140 = r139.floatValue();
    L138:
        int r141 = U90(r138, r140);
        Context r142 = getContext();
        if (r137 == null) goto L143;
        Float r143 = r137.getTop();
        if (r143 == null) goto L143;
        float r144 = r143.floatValue();
    L144:
        int r145 = U90(r142, r144);
        Context r146 = getContext();
        if (r137 == null) goto L149;
        Float r147 = r137.getRight();
        if (r147 == null) goto L149;
        float r148 = r147.floatValue();
    L150:
        int r149 = U90(r146, r148);
        Context r150 = getContext();
        if (r137 == null) goto L155;
        Float r151 = r137.getBottom();
        if (r151 == null) goto L155;
        float r152 = r151.floatValue();
    L156:
        int r153 = U90(r150, r152);
        DependencyContainer r154 = DependencyContainer.f433166a;
        com.ss.android.lark.officesdk.di.core.b r155 = DependencyContainer.a(q.class, null);
        if ((r155 instanceof q) == true) goto L159;
        r155 = null;
    L159:
        final q r156 = (q) r155;
        if (r156 != null) goto L162;
        Log.w("LK_API_TAG_PanelBottomDialog", "setupMarkdown skipped, markdown dependency is not registered");
        goto L236
    L162:
        int r157 = f.f411510a;
        Function1<String, String> r158 = new PanelBottomDialog$setupMarkdown$markdownConfig$1(this, r134);
        Function1<String, Unit> r159 = new PanelBottomDialog$setupMarkdown$markdownConfig$2(this);
        Function0<Unit> r160 = new PanelBottomDialog$setupMarkdown$markdownConfig$3(this, r104);
        Intrinsics.checkNotNullParameter(r134, "markdownInfo");
        Intrinsics.checkNotNullParameter(r158, "resolveMarkdownLink");
        Intrinsics.checkNotNullParameter(r159, RuleConditionBean.OPEN_URL_KEY);
        Float r161 = r134.getLineHeight();
        if (r161 == null) goto L165;
        float r162 = r161.floatValue();
    L166:
        Float r163 = r134.getLineSpacing();
        if (r163 == null) goto L169;
        float r210 = r163.floatValue();
    L170:
        float r211 = RangesKt.coerceAtLeast(r162 - 2, 1.0f);
        Float r164 = r134.getTextSize();
        if (r164 == null) goto L173;
        float r165 = r164.floatValue();
    L174:
        float r166 = zz7.b.d().getMultiplier() * r165;
        if (Intrinsics.areEqual(r134.getNoBlockSpace(), Boolean.FALSE) == false) goto L177;
        float r212 = 17.0f;
    L178:
        String r167 = r134.getContent();
        if (r167 == null) goto L182;
        r107 = r167;
    L182:
        String r168 = new Regex("(?<=[A-Za-z0-9])\\\\?-(?=[A-Za-z0-9])").replace(r107, "-\u200b");
        String r169 = r134.getTextColor();
        if (r169 == null) goto L188;
        String r170 = f.a(r169);
        if (r170 == null) goto L188;
        String r171 = r170;
    L189:
        String r172 = r134.getLinkColor();
        if (r172 == null) goto L192;
        String r213 = f.a(r172);
    L193:
        String r173 = r134.getListItemColor();
        if (r173 == null) goto L199;
        String r174 = f.a(r173);
        if (r174 == null) goto L199;
        String r214 = r174;
    L200:
        MarkdownListMarginInfo r175 = r134.getListMarginInfo();
        if (r175 == null) goto L205;
        Float r176 = r175.getDotDiameter();
        if (r176 == null) goto L205;
        float r215 = r176.floatValue();
    L206:
        MarkdownListMarginInfo r177 = r134.getListMarginInfo();
        if (r177 == null) goto L211;
        Float r178 = r177.getBulletDotOffset();
        if (r178 == null) goto L211;
        float r216 = r178.floatValue();
    L212:
        MarkdownListMarginInfo r179 = r134.getListMarginInfo();
        if (r179 == null) goto L217;
        Float r180 = r179.getTextStartMargin();
        if (r180 == null) goto L217;
        float r181 = r180.floatValue();
    L223:
        float r217 = r181;
    L225:
        final a0 r182 = new a0(r168, r171, r166, r211, r210, r213, r214, r215, r212, r216, r217, r158, null, r159, r160);
        requireContext();
        final View r183 = r156.n();
        r183.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout r184 = this.f411478m;
        if (r184 == null) goto L228;
        r184.addView(r183);
    L228:
        LinearLayout r185 = this.f411478m;
        if (r185 == null) goto L231;
        r185.setPadding(r141, r145, r149, r153);
    L231:
        Function1<Integer, Unit> r186 = new PanelBottomDialog$setupMarkdown$applyMarkdown$1(this, r156, r183, r182, r104);
        if (r183.getWidth() <= 0) goto L234;
        r186.invoke(Integer.valueOf(r183.getWidth()));
    L235:
        Log.i("LK_API_TAG_PanelBottomDialog", "setupMarkdown success");
        boolean r187 = true;
    L237:
        if (r187 == true) goto L247;
        List<PanelItem> r188 = r104.getData();
        if (r188 != null) goto L241;
    L244:
        boolean r189 = true;
    L245:
        if (r189 == false) goto L247;
        this.f411472g = -1;
        S90(this);
        goto L356
    L241:
        if (r188.isEmpty() == true) goto L244;
        r189 = false;
    L247:
        Log.i("LK_API_TAG_PanelBottomDialog", "setupContent start");
        ItemSelectInfo r190 = r104.getItemSelectInfo();
        if (r190 == null) goto L250;
        this.f411476k = r190;
    L250:
        List<PanelItem> r191 = r104.getData();
        if (r191 == null) goto L356;
        Iterator<T> r192 = r191.iterator();
    L254:
        if (r192.hasNext() == false) goto L356;
        PanelItem r193 = (PanelItem) r192.next();
        if (r193.getId() == null) goto L355;
        View r194 = LayoutInflater.from(getContext()).inflate(R.layout.cml_panel_item_v2, this.f411478m, false);
        Intrinsics.checkNotNull(r194);
        int r195 = r104.getPickerType();
        TextView r196 = (TextView) r194.findViewById(R.id.item_left_text);
        ImageView r197 = (ImageView) r194.findViewById(R.id.item_left_icon);
        ImageView r198 = (ImageView) r194.findViewById(R.id.item_left_icon_tag);
        ImageView r199 = (ImageView) r194.findViewById(R.id.item_right_icon);
        TextView r1100 = (TextView) r194.findViewById(R.id.item_desc);
        if (r196 == null) goto L270;
        Text r1101 = r193.getLeftText();
        if (r1101 == null) goto L269;
        r196.setText(r1101.getValue());
        Integer r1102 = r1101.getStyle();
        if (r1102 == null) goto L264;
        int r1103 = r1102.intValue();
    L265:
        r196.setTextColor(V90(r1103));
        r196.setTypeface(r196.getTypeface(), r1101.getBold() ? 1 : 0);
        Integer r1104 = r1101.getMaxLines();
        if (r1104 == null) goto L268;
        r196.setMaxLines(r1104.intValue());
    L268:
        r196.setVisibility(0);
        goto L270
    L264:
        r1103 = ColorStyle.Normal.getValue();
        goto L265
    L269:
        r196.setVisibility(8);
    L270:
        if (r197 == null) goto L286;
        Icon r200 = r193.getLeftIcon();
        if (r200 == null) goto L285;
        String r201 = r200.getUdKey();
        if (r201 == null) goto L285;
        int r202 = X90(r201);
        if (r202 == 0) goto L284;
        r197.setVisibility(0);
        r197.setImageResource(r202);
        Icon r203 = r193.getLeftIcon();
        if (r203 == null) goto L282;
        Integer r204 = r203.getIconStyle();
        if (r204 == null) goto L282;
        int r205 = r204.intValue();
    L283:
        r197.setColorFilter(V90(r205));
    L282:
        r205 = ColorStyle.Normal.getValue();
        goto L283
    L284:
        r197.setVisibility(8);
    L285:
        r197.setVisibility(8);
    L286:
        if (r198 == null) goto L302;
        Icon r206 = r193.getLeftIconTag();
        if (r206 == null) goto L301;
        String r207 = r206.getUdKey();
        if (r207 == null) goto L301;
        int r208 = X90(r207);
        if (r208 == 0) goto L300;
        r198.setVisibility(0);
        r198.setImageResource(r208);
        Icon r209 = r193.getLeftIcon();
        if (r209 == null) goto L298;
        Integer r218 = r209.getIconStyle();
        if (r218 == null) goto L298;
        int r219 = r218.intValue();
    L299:
        r198.setColorFilter(V90(r219));
    L298:
        r219 = ColorStyle.Normal.getValue();
        goto L299
    L300:
        r198.setVisibility(8);
    L301:
        r198.setVisibility(8);
    L302:
        if (r199 == null) goto L318;
        Icon r220 = r193.getRightIcon();
        if (r220 == null) goto L317;
        String r221 = r220.getUdKey();
        if (r221 == null) goto L317;
        int r222 = X90(r221);
        if (r222 == 0) goto L316;
        r199.setVisibility(0);
        r199.setImageResource(r222);
        Icon r223 = r193.getLeftIcon();
        if (r223 == null) goto L314;
        Integer r224 = r223.getIconStyle();
        if (r224 == null) goto L314;
        int r225 = r224.intValue();
    L315:
        r199.setColorFilter(V90(r225));
    L314:
        r225 = ColorStyle.Normal.getValue();
        goto L315
    L316:
        r199.setVisibility(8);
    L317:
        r199.setVisibility(8);
    L318:
        if (r1100 == null) goto L328;
        Text r226 = r193.getDesc();
        if (r226 == null) goto L326;
        r1100.setText(r226.getValue());
        Integer r227 = r226.getStyle();
        if (r227 == null) goto L324;
        int r228 = r227.intValue();
    L325:
        r1100.setTextColor(V90(r228));
        r1100.setVisibility(0);
        goto L328
    L324:
        r228 = ColorStyle.Desc.getValue();
        goto L325
    L326:
        r1100.setVisibility(8);
    L328:
        ItemSelectInfo r229 = this.f411476k;
        g r230 = new g(r193.getId(), r194, r193);
        if (r195 != 0) goto L331;
        if (r229 == null) goto L347;
        if (TextUtils.equals(r229.getSelectId(), r193.getId()) == false) goto L347;
        this.f411473h = r230;
        aa0(r194, true, r193);
    L347:
        r194.setOnClickListener(new com.ss.android.lark.chameleonv2.lkapi.widget.panel.b(this, r193, r230));
    L348:
        LinearLayout r231 = this.f411478m;
        if (r231 == null) goto L351;
        r231.addView(r194);
        Unit r232 = Unit.INSTANCE;
    L352:
        if (r232 != null) goto L254;
    L351:
        r232 = null;
        goto L352
    L331:
        if (r195 != 1) goto L348;
        if (r229 == null) goto L340;
        List<String> r233 = r229.getSelectIds();
        if (r233 == null) goto L337;
        boolean r234 = CollectionsKt.contains(r233, r193.getId());
    L338:
        if (r234 == false) goto L340;
        this.f411474i.add(r230);
        aa0(r194, true, r193);
        goto L340
    L337:
        r234 = false;
    L340:
        r194.setOnClickListener(new com.ss.android.lark.chameleonv2.lkapi.widget.panel.c(this, r230));
    L355:
        this.f411472g = -1;
        S90(this);
        goto L254
    L234:
        r183.post(new com.ss.android.lark.chameleonv2.lkapi.widget.panel.a(r186, r183));
    L217:
        MarkdownListMarginInfo r235 = r134.getListMarginInfo();
        if (r235 == null) goto L220;
        Float r236 = r235.getListMargin();
    L221:
        if (r236 == null) goto L224;
        r181 = r236.floatValue();
        goto L223
    L224:
        r217 = 14.0f;
        goto L225
    L220:
        r236 = null;
    L211:
        r216 = -3.0f;
    L205:
        r215 = 5.0f;
    L199:
        r214 = "N900-80";
        goto L200
    L192:
        r213 = null;
    L188:
        r171 = "N900-80";
        goto L189
    L177:
        r212 = 0.0f;
        goto L178
    L173:
        r165 = 14.0f;
        goto L174
    L169:
        r210 = 4.0f;
        goto L170
    L165:
        r162 = 25.0f;
    L155:
        r152 = this.f411469d;
    L149:
        r148 = this.f411469d;
    L143:
        r144 = this.f411469d;
    L137:
        r140 = this.f411469d;
        goto L138
    L126:
        if (r135.length() == 0) goto L129;
        r136 = false;
    L236:
        r187 = false;
        goto L237
    L121:
        r135 = null;
        goto L123
    L108:
        if (r131.length() == 0) goto L111;
        r132 = false;
        goto L112
    L105:
        r131 = null;
    L114:
        r133 = false;
        goto L116
    L96:
        if (r128.isEmpty() == true) goto L99;
        r129 = false;
        goto L101
    L73:
        r123 = true;
        goto L74
    L75:
        LinearLayout r237 = this.f411482q;
        if (r237 == null) goto L78;
        r237.setVisibility(8);
        goto L78
    L63:
        r120 = false;
        goto L64
    L65:
        LinearLayout r238 = this.f411481p;
        if (r238 == null) goto L68;
        r238.setVisibility(8);
        goto L68
    L54:
        if (r104.getShowTitleDivider() == false) goto L56;
        int r239 = 0;
    L57:
        r117.setVisibility(r239);
        goto L58
    L56:
        r239 = 8;
        goto L57
    }

    public final void Z90(LinearLayout r100, PanelItem r101, Function0<Unit> r102) {
        if (r100 == null) goto L45;
        r100.setVisibility(0);
        r100.setOnClickListener(new c(r102));
        TextView r103 = (TextView) r100.findViewById(R.id.left_action_text);
        if (r103 != null) goto L6;
        r103 = (TextView) r100.findViewById(R.id.right_action_text);
    L6:
        ImageView r104 = (ImageView) r100.findViewById(R.id.left_action_icon);
        if (r104 != null) goto L10;
        r104 = (ImageView) r100.findViewById(R.id.right_action_icon);
    L10:
        if (r103 == null) goto L23;
        Text r105 = r101.getLeftText();
        if (r105 == null) goto L22;
        r103.setText(r105.getValue());
        r103.setVisibility(0);
        String r106 = r105.getUdColor();
        if (r106 == null) goto L16;
        r103.setTextColor(W90(r106));
    L21:
        r103.setTypeface(r103.getTypeface(), r105.getBold() ? 1 : 0);
        goto L23
    L16:
        Integer r107 = r105.getStyle();
        if (r107 == null) goto L19;
        int r108 = r107.intValue();
    L20:
        r103.setTextColor(V90(r108));
        goto L21
    L19:
        r108 = ColorStyle.Normal.getValue();
        goto L20
    L22:
        r103.setVisibility(8);
    L23:
        if (r104 == null) goto L46;
        Icon r109 = r101.getLeftIcon();
        if (r109 == null) goto L43;
        String r110 = r109.getUdKey();
        if (r110 == null) goto L43;
        int r111 = X90(r110);
        if (r111 == 0) goto L42;
        r104.setVisibility(0);
        r104.setImageResource(r111);
        Icon r112 = r101.getLeftIcon();
        if (r112 == null) goto L35;
        String r113 = r112.getUdColor();
        if (r113 == null) goto L35;
        r104.setColorFilter(W90(r113));
        return;
    L35:
        Icon r114 = r101.getLeftIcon();
        if (r114 == null) goto L40;
        Integer r115 = r114.getIconStyle();
        if (r115 == null) goto L40;
        int r116 = r115.intValue();
    L41:
        r104.setColorFilter(V90(r116));
        return;
    L40:
        r116 = ColorStyle.Normal.getValue();
        goto L41
    L42:
        r104.setVisibility(8);
        return;
    L43:
        r104.setVisibility(8);
        return;
    L46:
        return;
    }

    public final void aa0(View r100, boolean r101, PanelItem r102) {
        TextView r103 = (TextView) r100.findViewById(R.id.item_left_text);
        if (this.f411476k != null) goto L16;
        int r104 = ColorStyle.Normal.getValue();
        if (r101 == false) goto L7;
        r104 = ColorStyle.Select.getValue();
    L13:
        if (r103 == null) goto L132;
        r103.setTextColor(V90(r104));
        return;
    L132:
        return;
    L7:
        if (r102 == null) goto L13;
        Text r105 = r102.getLeftText();
        if (r105 == null) goto L13;
        Integer r106 = r105.getStyle();
        if (r106 == null) goto L13;
        r104 = r106.intValue();
        goto L13
    L16:
        TextView r107 = (TextView) r100.findViewById(R.id.item_desc);
        ImageView r108 = (ImageView) r100.findViewById(R.id.item_left_icon);
        ImageView r109 = (ImageView) r100.findViewById(R.id.item_right_icon);
        if (r101 == false) goto L63;
        ItemSelectInfo r110 = this.f411476k;
        if (r110 == null) goto L25;
        Integer r111 = r110.getTextStyle();
        if (r111 == null) goto L25;
        int r112 = r111.intValue();
        if (r103 == null) goto L25;
        r103.setTextColor(V90(r112));
    L25:
        ItemSelectInfo r113 = this.f411476k;
        if (r113 == null) goto L33;
        Integer r114 = r113.getDescStyle();
        if (r114 == null) goto L33;
        int r115 = r114.intValue();
        if (r107 == null) goto L33;
        r107.setTextColor(V90(r115));
    L33:
        if (r108 == null) goto L48;
        ItemSelectInfo r116 = this.f411476k;
        if (r116 == null) goto L48;
        Icon r117 = r116.getLeftIcon();
        if (r117 == null) goto L48;
        String r118 = r117.getUdKey();
        if (r118 == null) goto L44;
        int r119 = X90(r118);
        if (r119 == 0) goto L43;
        r108.setVisibility(0);
        r108.setImageResource(r119);
    L45:
        Integer r120 = r117.getIconStyle();
        if (r120 == null) goto L48;
        r108.setColorFilter(V90(r120.intValue()));
        goto L48
    L43:
        r108.setVisibility(8);
        goto L45
    L44:
        r108.setVisibility(8);
    L48:
        if (r109 == null) goto L133;
        ItemSelectInfo r121 = this.f411476k;
        if (r121 == null) goto L134;
        Icon r122 = r121.getRightIcon();
        if (r122 == null) goto L135;
        String r123 = r122.getUdKey();
        if (r123 == null) goto L59;
        int r124 = X90(r123);
        if (r124 == 0) goto L58;
        r109.setVisibility(0);
        r109.setImageResource(r124);
    L60:
        Integer r125 = r122.getIconStyle();
        if (r125 == null) goto L136;
        r109.setColorFilter(V90(r125.intValue()));
        return;
    L136:
        return;
    L58:
        r109.setVisibility(8);
        goto L60
    L59:
        r109.setVisibility(8);
        goto L60
    L135:
        return;
    L134:
        return;
    L133:
        return;
    L63:
        ItemSelectInfo r126 = this.f411476k;
        if (r126 == null) goto L78;
        Integer r127 = r126.getTextStyle();
        if (r127 == null) goto L78;
        r127.intValue();
        if (r102 == null) goto L74;
        Text r128 = r102.getLeftText();
        if (r128 == null) goto L74;
        Integer r129 = r128.getStyle();
        if (r129 == null) goto L74;
        int r130 = r129.intValue();
    L75:
        int r131 = V90(r130);
        if (r103 == null) goto L78;
        r103.setTextColor(r131);
    L74:
        r130 = ColorStyle.Normal.getValue();
    L78:
        ItemSelectInfo r132 = this.f411476k;
        if (r132 == null) goto L93;
        Integer r133 = r132.getDescStyle();
        if (r133 == null) goto L93;
        r133.intValue();
        if (r102 == null) goto L89;
        Text r134 = r102.getDesc();
        if (r134 == null) goto L89;
        Integer r135 = r134.getStyle();
        if (r135 == null) goto L89;
        int r136 = r135.intValue();
    L90:
        int r137 = V90(r136);
        if (r107 == null) goto L93;
        r107.setTextColor(r137);
    L89:
        r136 = ColorStyle.Desc.getValue();
    L93:
        if (r108 == null) goto L112;
        ItemSelectInfo r138 = this.f411476k;
        if (r138 == null) goto L112;
        Icon r139 = r138.getLeftIcon();
        if (r139 == null) goto L112;
        if (r139.getUdKey() == null) goto L101;
        r108.setVisibility(8);
    L101:
        Integer r140 = r139.getIconStyle();
        if (r140 == null) goto L112;
        r140.intValue();
        if (r102 == null) goto L110;
        Icon r141 = r102.getLeftIcon();
        if (r141 == null) goto L110;
        Integer r142 = r141.getIconStyle();
        if (r142 == null) goto L110;
        int r143 = r142.intValue();
    L111:
        r108.setColorFilter(r143);
    L110:
        r143 = ColorStyle.Normal.getValue();
    L112:
        if (r109 == null) goto L138;
        ItemSelectInfo r144 = this.f411476k;
        if (r144 == null) goto L139;
        Icon r145 = r144.getRightIcon();
        if (r145 != null) goto L118;
        return;
    L118:
        if (r145.getUdKey() == null) goto L120;
        r109.setVisibility(8);
    L120:
        Integer r146 = r145.getIconStyle();
        if (r146 == null) goto L141;
        r146.intValue();
        if (r102 == null) goto L129;
        Icon r147 = r102.getRightIcon();
        if (r147 == null) goto L129;
        Integer r148 = r147.getIconStyle();
        if (r148 == null) goto L129;
        int r149 = r148.intValue();
    L130:
        r109.setColorFilter(r149);
        return;
    L129:
        r149 = ColorStyle.Normal.getValue();
        goto L130
    L141:
        return;
    L139:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.cml_panel_bottom_sheet_v2, r101, false);
    }
}
