package com.bytedance.ee.bear.document.export.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0004/012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0016J\u0006\u0010-\u001a\u00020\u0012J\b\u0010.\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "optionClickListener", "Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnOptionClickListener;", "getOptionClickListener", "()Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnOptionClickListener;", "setOptionClickListener", "(Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnOptionClickListener;)V", "disabledOptionClickListener", "Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnDisabledOptionClickListener;", "getDisabledOptionClickListener", "()Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnDisabledOptionClickListener;", "setDisabledOptionClickListener", "(Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnDisabledOptionClickListener;)V", "dismissListener", "Lkotlin/Function0;", "", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "titleTextView", "Landroid/widget/TextView;", "closeView", "Landroid/widget/ImageView;", "optionContainer", "Landroid/widget/LinearLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", WidgetCostModule.TYPE_ON_START, "renderOptions", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "clearListeners", LiveCommonConstants.REASON_ON_DEDTROY, "DownloadOption", "OnOptionClickListener", "OnDisabledOptionClickListener", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectDownloadDialogFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f219724n = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f219725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f219726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function0<Unit> f219727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f219728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f219729l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f219730m;

    public static final class a {
        @JvmStatic
        public static SelectDownloadDialogFragment a(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            Intrinsics.checkNotNullParameter(r101, "options");
            SelectDownloadDialogFragment r102 = new SelectDownloadDialogFragment();
            Pair[] r103 = new Pair[4];
            r103[0] = TuplesKt.to("arg_title", r100);
            List r104 = r101;
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator r106 = r104.iterator();
        L4:
            if (r106.hasNext() == false) goto L6;
            r105.add(((b) r106.next()).f219731a);
            goto L4
        L6:
            r103[1] = TuplesKt.to("arg_option_ids", new ArrayList(r105));
            ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator r108 = r104.iterator();
        L8:
            if (r108.hasNext() == false) goto L10;
            r107.add(((b) r108.next()).f219732b);
            goto L8
        L10:
            r103[2] = TuplesKt.to("arg_option_titles", new ArrayList(r107));
            ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
            Iterator r110 = r104.iterator();
        L12:
            if (r110.hasNext() == false) goto L14;
            r109.add(Boolean.valueOf(((b) r110.next()).f219733c));
            goto L12
        L14:
            r103[3] = TuplesKt.to("arg_option_enabled", CollectionsKt.toBooleanArray(r109));
            r102.setArguments(BundleKt.bundleOf(r103));
            return r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f219731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f219732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f219733c;

        public /* synthetic */ b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f219731a, r101.f219731a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f219732b, r101.f219732b) == true) goto L15;
            return false;
        L15:
            if (this.f219733c == r101.f219733c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f219731a.hashCode() * 31) + this.f219732b.hashCode()) * 31;
            if (this.f219733c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "DownloadOption(id=" + this.f219731a + ", title=" + this.f219732b + ", enabled=" + this.f219733c + ')';
        }

        public b(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f219731a = r100;
            this.f219732b = r101;
            this.f219733c = r102;
        }
    }

    public interface c {
        void a(b r100, int r101);
    }

    public interface d {
        void a(b r100, int r101);
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectDownloadDialogFragment f219734a;

        public e(SelectDownloadDialogFragment r100) {
            this.f219734a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f219734a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f219735a = null;

        static {
            f219735a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
        }
    }

    public static final class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectDownloadDialogFragment f219736a;

        public g(SelectDownloadDialogFragment r100) {
            this.f219736a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f219736a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        this.f219725h = null;
        this.f219726i = null;
        this.f219727j = null;
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f219728k = null;
        this.f219729l = null;
        this.f219730m = null;
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L18;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L19;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.width = -1;
        r102.height = -1;
        r102.softInputMode = 16;
        r102.gravity = 80;
        r101.setAttributes(r102);
        r101.setDimAmount(0.2f);
        r101.setWindowAnimations(R.style.ActionSheetAnimation);
        r101.setBackgroundDrawableResource(android.R.color.transparent);
        View r103 = r101.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L12;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L12;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L12:
        if ((r103 instanceof FrameLayout) == false) goto L14;
        FrameLayout r105 = (FrameLayout) r103;
    L15:
        if (r105 == null) goto L20;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r105);
        return;
    L20:
        return;
    L14:
        r105 = null;
        goto L15
    L19:
        return;
    }

    public SelectDownloadDialogFragment() {
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        Function0<Unit> r101 = this.f219727j;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.invoke();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        r110.setOnClickListener(new e(this));
        r110.findViewById(R.id.download_dialog_panel).setOnClickListener(f.f219735a);
        this.f219728k = (TextView) r110.findViewById(R.id.download_dialog_title);
        this.f219729l = (ImageView) r110.findViewById(R.id.download_dialog_close);
        this.f219730m = (LinearLayout) r110.findViewById(R.id.download_dialog_option_container);
        TextView r100 = this.f219728k;
        if (r100 == null) goto L8;
        String r101 = requireArguments().getString("arg_title");
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.setText(r101);
    L8:
        ImageView r102 = this.f219729l;
        if (r102 == null) goto L11;
        r102.setOnClickListener(new g(this));
    L11:
        LayoutInflater r103 = getLayoutInflater();
        LinearLayout r104 = this.f219730m;
        if (r104 == null) goto L58;
        r104.removeAllViews();
        List r105 = requireArguments().getStringArrayList("arg_option_ids");
        if (r105 != null) goto L17;
        r105 = CollectionsKt.emptyList();
    L17:
        List r106 = requireArguments().getStringArrayList("arg_option_titles");
        if (r106 != null) goto L20;
        r106 = CollectionsKt.emptyList();
    L20:
        boolean[] r107 = requireArguments().getBooleanArray("arg_option_enabled");
        if (r107 == null) goto L23;
        List r108 = ArraysKt.toList(r107);
    L24:
        if (r108 != null) goto L26;
        r108 = CollectionsKt.emptyList();
    L26:
        Iterator r109 = r106.iterator();
        boolean r112 = false;
        int r113 = 0;
    L28:
        if (r109.hasNext() == false) goto L64;
        Object r114 = r109.next();
        int r115 = r113 + 1;
        if (r113 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        String r116 = (String) r114;
        View r117 = r103.inflate(R.layout.document_select_download_dialog_item, r104, r112);
        TextView r118 = (TextView) r117.findViewById(R.id.download_option_title);
        View r119 = r117.findViewById(R.id.download_option_divider);
        String r120 = (String) CollectionsKt.getOrNull(r105, r113);
        if (r120 != null) goto L35;
        String r121 = "";
    L36:
        Intrinsics.checkNotNull(r116);
        Boolean r122 = (Boolean) CollectionsKt.getOrNull(r108, r113);
        LayoutInflater r123 = r103;
        if (r122 == null) goto L39;
        boolean r124 = r122.booleanValue();
    L40:
        b r125 = new b(r121, r116, r124);
        r118.setText(r116);
        Context r126 = r118.getContext();
        if (r125.f219733c == false) goto L43;
        int r127 = R.color.text_title;
    L44:
        r118.setTextColor(ContextCompat.getColor(r126, r127));
        if (r113 != CollectionsKt.getLastIndex(r106)) goto L47;
        int r128 = 8;
    L48:
        r119.setVisibility(r128);
        if (r106.size() != 1) goto L51;
        int r129 = R.drawable.document_select_download_item_single_bg;
    L57:
        r117.setBackgroundResource(r129);
        r117.setClickable(true);
        r117.setOnClickListener(new com.bytedance.ee.bear.document.export.dialog.a(r125, this, r113));
        r104.addView(r117);
        r103 = r123;
        r113 = r115;
        r112 = false;
        goto L28
    L51:
        if (r113 != 0) goto L54;
        r129 = R.drawable.document_select_download_item_top_bg;
        goto L57
    L54:
        if (r113 != CollectionsKt.getLastIndex(r106)) goto L56;
        r129 = R.drawable.document_select_download_item_bottom_bg;
        goto L57
    L56:
        r129 = R.drawable.document_select_download_item_middle_bg;
        goto L57
    L47:
        r128 = 0;
        goto L48
    L43:
        r127 = R.color.text_disable;
        goto L44
    L39:
        r124 = true;
        goto L40
    L35:
        r121 = r120;
        goto L36
    L64:
        return;
    L23:
        r108 = null;
        goto L24
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.document_select_download_dialog, r101, false);
    }
}
