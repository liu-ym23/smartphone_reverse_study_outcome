package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common_res.common_ui.databinding.LarusDialogSpanableBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020)2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u00100\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/common_ui/dialog/SpanableDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogSpanableBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "", "mBottomIndividualText", "mScrollViewHeight", "", "mConfirmText", "mConfirmTextColor", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mSpannaleClickListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "mMessageTestStyle", "Lcom/larus/common_ui/dialog/SpannableDialogMessageTextStyleConfig;", "mConfirmTextStyle", "Lcom/larus/common_ui/dialog/SpannableDialogButtonTextStyleConfig;", "mCancelTextStyle", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onResume", "setUpMessageTextStyle", "setUpConfirmTextStyle", "setUpCancelTextStyle", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupView", "Companion", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpanableDialog extends DialogFragment {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f327275r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogSpanableBinding f327276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f327277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f327278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f327279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f327280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f327281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f327282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p0 f327283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f327284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u f327285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public k1 f327286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j1 f327287o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i1 f327288p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public i1 f327289q;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnKeyListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    static {
    }

    public SpanableDialog() {
        this.f327277e = "";
        this.f327278f = true;
        this.f327279g = "";
        this.f327280h = "";
        this.f327281i = -1;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        System.currentTimeMillis();
        Dialog r100 = getDialog();
        if (r100 == null) goto L10;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L10;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r102.width = r104;
        if (r104 <= i5.L()) goto L9;
        r102.width = i5.L();
    L9:
        r101.setAttributes(r102);
    L10:
        Dialog r105 = getDialog();
        if (r105 == null) goto L14;
        r105.setOnKeyListener(new b());
        return;
    }

    public static void S90(Dialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        System.currentTimeMillis();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        System.currentTimeMillis();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogSpanableBinding r102 = this.f327276d;
        LarusDialogSpanableBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r102.f326688f.setText(this.f327277e);
        LarusDialogSpanableBinding r104 = this.f327276d;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L8:
        UrlSpanTextView r105 = r104.f326687e;
        if (this.f327278f == false) goto L11;
        int r106 = 0;
    L12:
        r105.setVisibility(r106);
        LarusDialogSpanableBinding r107 = this.f327276d;
        if (r107 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L15:
        r107.f326687e.setUrlSpannedText(String.valueOf(this.f327279g));
        LarusDialogSpanableBinding r108 = this.f327276d;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L18:
        r108.f326687e.setOnClickListener(new g1(this));
        if (this.f327281i <= 0) goto L25;
        LarusDialogSpanableBinding r109 = this.f327276d;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r109 = null;
    L23:
        r109.f326689g.getLayoutParams().height = this.f327281i;
    L25:
        if ((this.f327279g instanceof SpannableString) == false) goto L33;
        LarusDialogSpanableBinding r110 = this.f327276d;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L29:
        r110.f326687e.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableBinding r111 = this.f327276d;
        if (r111 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L32:
        r111.f326687e.setHighlightColor(0);
    L33:
        String r112 = this.f327282j;
        boolean r113 = true;
        if (r112 != null) goto L36;
    L39:
        boolean r114 = true;
    L40:
        if (r114 == true) goto L45;
        LarusDialogSpanableBinding r115 = this.f327276d;
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L44:
        r115.f326686d.setText(this.f327282j);
    L45:
        Context r116 = getContext();
        if (r116 == null) goto L51;
        LarusDialogSpanableBinding r117 = this.f327276d;
        if (r117 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L50:
        r117.f326686d.setTextColor(ContextCompat.getColor(r116, v19.c.b(R.attr.larus_primary_50, r116, R.color.larus_primary_50)));
    L51:
        LarusDialogSpanableBinding r118 = this.f327276d;
        if (r118 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L54:
        r118.f326686d.setOnClickListener(new e1(this));
        String r119 = this.f327284l;
        if (r119 != null) goto L57;
    L60:
        boolean r120 = true;
    L61:
        if (r120 == true) goto L66;
        LarusDialogSpanableBinding r121 = this.f327276d;
        if (r121 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L65:
        r121.f326685c.setText(this.f327284l);
    L66:
        LarusDialogSpanableBinding r122 = this.f327276d;
        if (r122 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r122 = null;
    L69:
        r122.f326685c.setOnClickListener(new f1(this));
        CharSequence r123 = this.f327280h;
        if (r123 != null) goto L72;
    L75:
        if (r113 == true) goto L92;
        LarusDialogSpanableBinding r124 = this.f327276d;
        if (r124 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L79:
        r124.f326684b.setVisibility(0);
        LarusDialogSpanableBinding r125 = this.f327276d;
        if (r125 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r125 = null;
    L82:
        r125.f326684b.setUrlSpannedText(String.valueOf(this.f327280h));
        LarusDialogSpanableBinding r126 = this.f327276d;
        if (r126 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L85:
        r126.f326684b.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableBinding r127 = this.f327276d;
        if (r127 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r127 = null;
    L88:
        r127.f326684b.setHighlightColor(0);
        LarusDialogSpanableBinding r128 = this.f327276d;
        if (r128 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r128 = null;
    L91:
        r128.f326684b.setOnClickListener(new h1(this));
    L92:
        j1 r129 = this.f327287o;
        if (r129 == null) goto L132;
        Integer r130 = r129.f327355a;
        if (r130 == null) goto L100;
        int r131 = r130.intValue();
        LarusDialogSpanableBinding r132 = this.f327276d;
        if (r132 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L99:
        r132.f326687e.setTextSize(r131);
    L100:
        Integer r133 = r129.f327356b;
        if (r133 == null) goto L110;
        int r134 = r133.intValue();
        LarusDialogSpanableBinding r135 = this.f327276d;
        if (r135 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r135 = null;
    L105:
        UrlSpanTextView r136 = r135.f326687e;
        Context r137 = getContext();
        if (r137 == null) goto L108;
        ColorStateList r138 = AppCompatResources.getColorStateList(r137, r134);
    L109:
        r136.setTextColor(r138);
        goto L110
    L108:
        r138 = null;
    L110:
        Typeface r139 = r129.f327357c;
        if (r139 == null) goto L116;
        LarusDialogSpanableBinding r140 = this.f327276d;
        if (r140 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r140 = null;
    L115:
        r140.f326687e.setTypeface(r139);
    L116:
        Integer r141 = r129.f327358d;
        if (r141 == null) goto L126;
        int r142 = r141.intValue();
        Context r143 = getContext();
        if (r143 == null) goto L126;
        ColorStateList r144 = AppCompatResources.getColorStateList(r143, r142);
        if (r144 == null) goto L126;
        LarusDialogSpanableBinding r145 = this.f327276d;
        if (r145 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r145 = null;
    L125:
        r145.f326687e.setUrlTextColor(r144);
    L126:
        Integer r146 = r129.f327359e;
        if (r146 == null) goto L132;
        int r147 = r146.intValue();
        LarusDialogSpanableBinding r148 = this.f327276d;
        if (r148 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r148 = null;
    L131:
        r148.f326687e.setGravity(r147);
    L132:
        i1 r149 = this.f327288p;
        if (r149 == null) goto L156;
        Integer r150 = r149.f327317a;
        if (r150 == null) goto L140;
        int r151 = r150.intValue();
        LarusDialogSpanableBinding r152 = this.f327276d;
        if (r152 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r152 = null;
    L139:
        r152.f326686d.setTextSize(r151);
    L140:
        Integer r153 = r149.f327318b;
        if (r153 == null) goto L150;
        int r154 = r153.intValue();
        LarusDialogSpanableBinding r155 = this.f327276d;
        if (r155 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r155 = null;
    L145:
        TextView r156 = r155.f326686d;
        Context r157 = getContext();
        if (r157 == null) goto L148;
        ColorStateList r158 = AppCompatResources.getColorStateList(r157, r154);
    L149:
        r156.setTextColor(r158);
        goto L150
    L148:
        r158 = null;
    L150:
        Typeface r159 = r149.f327319c;
        if (r159 == null) goto L156;
        LarusDialogSpanableBinding r160 = this.f327276d;
        if (r160 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r160 = null;
    L155:
        r160.f326686d.setTypeface(r159);
    L156:
        i1 r161 = this.f327289q;
        if (r161 == null) goto L181;
        Integer r162 = r161.f327317a;
        if (r162 == null) goto L164;
        int r163 = r162.intValue();
        LarusDialogSpanableBinding r164 = this.f327276d;
        if (r164 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r164 = null;
    L163:
        r164.f326685c.setTextSize(r163);
    L164:
        Integer r165 = r161.f327318b;
        if (r165 == null) goto L174;
        int r166 = r165.intValue();
        LarusDialogSpanableBinding r167 = this.f327276d;
        if (r167 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r167 = null;
    L169:
        TextView r168 = r167.f326685c;
        Context r169 = getContext();
        if (r169 == null) goto L172;
        ColorStateList r170 = AppCompatResources.getColorStateList(r169, r166);
    L173:
        r168.setTextColor(r170);
        goto L174
    L172:
        r170 = null;
    L174:
        Typeface r171 = r161.f327319c;
        if (r171 == null) goto L181;
        LarusDialogSpanableBinding r172 = this.f327276d;
        if (r172 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L180:
        r103.f326685c.setTypeface(r171);
        goto L181
    L179:
        r103 = r172;
    L181:
        Dialog r173 = getDialog();
        if (r173 == null) goto L185;
        r173.setCanceledOnTouchOutside(false);
        return;
    L185:
        return;
    L72:
        if (r123.length() == 0) goto L75;
        r113 = false;
        goto L75
    L57:
        if (r119.length() == 0) goto L60;
        r120 = false;
        goto L61
    L36:
        if (r112.length() == 0) goto L39;
        r114 = false;
        goto L40
    L11:
        r106 = 8;
        goto L12
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r113 = r110.inflate(R.layout.larus_dialog_spanable, r111, false);
        int r114 = R.id.bottom_individual_text;
        UrlSpanTextView r100 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.bottom_individual_text);
        if (r100 == null) goto L25;
        r114 = R.id.cancel;
        TextView r101 = (TextView) ViewBindings.findChildViewById(r113, R.id.cancel);
        if (r101 == null) goto L25;
        r114 = R.id.confirm;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r113, R.id.confirm);
        if (r102 == null) goto L25;
        r114 = R.id.dialog_message;
        UrlSpanTextView r103 = (UrlSpanTextView) ViewBindings.findChildViewById(r113, R.id.dialog_message);
        if (r103 == null) goto L25;
        r114 = R.id.dialog_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r113, R.id.dialog_title);
        if (r104 == null) goto L25;
        r114 = R.id.scroll_content;
        ScrollView r105 = (ScrollView) ViewBindings.findChildViewById(r113, R.id.scroll_content);
        if (r105 == null) goto L25;
        this.f327276d = new LarusDialogSpanableBinding((ConstraintLayout) r113, r100, r101, r102, r103, r104, r105);
        Dialog r115 = getDialog();
        if (r115 == null) goto L19;
        Window r116 = r115.getWindow();
        if (r116 == null) goto L19;
        r116.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        LarusDialogSpanableBinding r117 = this.f327276d;
        if (r117 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L23:
        return r117.f326683a;
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
