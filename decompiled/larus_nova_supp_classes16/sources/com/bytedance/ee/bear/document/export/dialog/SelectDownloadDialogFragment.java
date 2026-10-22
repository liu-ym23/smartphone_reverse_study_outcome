package com.bytedance.ee.bear.document.export.dialog;

import android.R;
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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0004/012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,H\u0016J\u0006\u0010-\u001a\u00020\u0012J\b\u0010.\u001a\u00020\u0012H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "optionClickListener", "Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnOptionClickListener;", "getOptionClickListener", "()Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnOptionClickListener;", "setOptionClickListener", "(Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnOptionClickListener;)V", "disabledOptionClickListener", "Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnDisabledOptionClickListener;", "getDisabledOptionClickListener", "()Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnDisabledOptionClickListener;", "setDisabledOptionClickListener", "(Lcom/bytedance/ee/bear/document/export/dialog/SelectDownloadDialogFragment$OnDisabledOptionClickListener;)V", "dismissListener", "Lkotlin/Function0;", "", "getDismissListener", "()Lkotlin/jvm/functions/Function0;", "setDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "titleTextView", "Landroid/widget/TextView;", "closeView", "Landroid/widget/ImageView;", "optionContainer", "Landroid/widget/LinearLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "renderOptions", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "clearListeners", "onDestroy", "DownloadOption", "OnOptionClickListener", "OnDisabledOptionClickListener", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SelectDownloadDialogFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int n = 0;
    public d h;
    public c i;
    public Function0<Unit> j;
    public TextView k;
    public ImageView l;
    public LinearLayout m;

    public static final class a {
        @JvmStatic
        public static SelectDownloadDialogFragment a(String r5, List r6) {
            Intrinsics.checkNotNullParameter(r5, "title");
            Intrinsics.checkNotNullParameter(r6, "options");
            SelectDownloadDialogFragment r0 = new SelectDownloadDialogFragment();
            Pair[] r1 = new Pair[4];
            r1[0] = TuplesKt.to("arg_title", r5);
            List r7 = r6;
            ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r3 = r7.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            r8.add(((b) r3.next()).a);
            goto L4
        L6:
            r1[1] = TuplesKt.to("arg_option_ids", new ArrayList(r8));
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r4 = r7.iterator();
        L8:
            if (r4.hasNext() == false) goto L10;
            r9.add(((b) r4.next()).b);
            goto L8
        L10:
            r1[2] = TuplesKt.to("arg_option_titles", new ArrayList(r9));
            ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator r11 = r7.iterator();
        L12:
            if (r11.hasNext() == false) goto L14;
            r10.add(Boolean.valueOf(((b) r11.next()).c));
            goto L12
        L14:
            r1[3] = TuplesKt.to("arg_option_enabled", CollectionsKt.toBooleanArray(r10));
            r0.setArguments(BundleKt.bundleOf(r1));
            return r0;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final boolean c;

        public /* synthetic */ b() {
            throw null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "DownloadOption(id=" + this.a + ", title=" + this.b + ", enabled=" + this.c + ')';
        }

        public b(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "title");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public interface c {
        void a(b r1, int r2);
    }

    public interface d {
        void a(b r1, int r2);
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ SelectDownloadDialogFragment a;

        public e(SelectDownloadDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class f implements View.OnClickListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ SelectDownloadDialogFragment a;

        public g(SelectDownloadDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        this.h = null;
        this.i = null;
        this.j = null;
        super.onDestroy();
    }

    public final void onDestroyView() {
        this.k = null;
        this.l = null;
        this.m = null;
        super.onDestroyView();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L18;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L19;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -1;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        View r3 = r1.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L12;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r4 = ThreadMethodProxy.currentThread();
        if (r4 == com.larus.home.impl.utils.c.a) goto L12;
        com.larus.home.impl.utils.c.a(r4, "getDecorView");
    L12:
        if ((r3 instanceof FrameLayout) == false) goto L14;
        FrameLayout r5 = (FrameLayout) r3;
    L15:
        if (r5 == null) goto L20;
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r5);
        return;
    L20:
        return;
    L14:
        r5 = null;
        goto L15
    L19:
        return;
    }

    public SelectDownloadDialogFragment() {
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        Function0<Unit> r3 = this.j;     // Catch: Throwable -> L7
        if (r3 == null) goto L5;
        r3.invoke();     // Catch: Throwable -> L7
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

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r18, "view");
        super.onViewCreated(r18, r19);
        r18.setOnClickListener(new e(this));
        r18.findViewById(2131370169).setOnClickListener(f.a);
        this.k = (TextView) r18.findViewById(2131370171);
        this.l = (ImageView) r18.findViewById(2131370167);
        this.m = (LinearLayout) r18.findViewById(2131370168);
        TextView r1 = this.k;
        if (r1 == null) goto L8;
        String r3 = requireArguments().getString("arg_title");
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r1.setText(r3);
    L8:
        ImageView r2 = this.l;
        if (r2 == null) goto L11;
        r2.setOnClickListener(new g(this));
    L11:
        LayoutInflater r4 = getLayoutInflater();
        LinearLayout r5 = this.m;
        if (r5 == null) goto L58;
        r5.removeAllViews();
        List r6 = requireArguments().getStringArrayList("arg_option_ids");
        if (r6 != null) goto L17;
        r6 = CollectionsKt.emptyList();
    L17:
        List r7 = requireArguments().getStringArrayList("arg_option_titles");
        if (r7 != null) goto L20;
        r7 = CollectionsKt.emptyList();
    L20:
        boolean[] r8 = requireArguments().getBooleanArray("arg_option_enabled");
        if (r8 == null) goto L23;
        List r9 = ArraysKt.toList(r8);
    L24:
        if (r9 != null) goto L26;
        r9 = CollectionsKt.emptyList();
    L26:
        Iterator r10 = r7.iterator();
        boolean r11 = false;
        int r12 = 0;
    L28:
        if (r10.hasNext() == false) goto L64;
        Object r13 = r10.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        String r16 = (String) r13;
        View r17 = r4.inflate(2131560127, r5, r11);
        TextView r110 = (TextView) r17.findViewById(2131370183);
        View r111 = r17.findViewById(2131370182);
        String r112 = (String) CollectionsKt.getOrNull(r6, r12);
        if (r112 != null) goto L35;
        String r20 = "";
    L36:
        Intrinsics.checkNotNull(r16);
        Boolean r113 = (Boolean) CollectionsKt.getOrNull(r9, r12);
        LayoutInflater r114 = r4;
        if (r113 == null) goto L39;
        boolean r21 = r113.booleanValue();
    L40:
        b r115 = new b(r20, r16, r21);
        r110.setText(r16);
        Context r22 = r110.getContext();
        if (r115.c == false) goto L43;
        int r23 = 2131106622;
    L44:
        r110.setTextColor(ContextCompat.getColor(r22, r23));
        if (r12 != CollectionsKt.getLastIndex(r7)) goto L47;
        int r24 = 8;
    L48:
        r111.setVisibility(r24);
        if (r7.size() != 1) goto L51;
        int r26 = 2131233918;
    L57:
        r17.setBackgroundResource(r26);
        r17.setClickable(true);
        r17.setOnClickListener(new com.bytedance.ee.bear.document.export.dialog.a(r115, this, r12));
        r5.addView(r17);
        r4 = r114;
        r12 = r14;
        r11 = false;
        goto L28
    L51:
        if (r12 != 0) goto L54;
        r26 = 2131233919;
        goto L57
    L54:
        if (r12 != CollectionsKt.getLastIndex(r7)) goto L56;
        r26 = 2131233916;
        goto L57
    L56:
        r26 = 2131233917;
        goto L57
    L47:
        r24 = 0;
        goto L48
    L43:
        r23 = 2131106610;
        goto L44
    L39:
        r21 = true;
        goto L40
    L35:
        r20 = r112;
        goto L36
    L64:
        return;
    L23:
        r9 = null;
        goto L24
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131560126, r3, false);
    }
}
