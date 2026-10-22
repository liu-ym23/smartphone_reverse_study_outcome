package com.larus.avlink.env.diary.style;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.avlink.impl.databinding.LarusDialogDiaryStyleInputBinding;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0012H\u0002J\u0012\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00101\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\"\u00103\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u0019H\u0002J\u0010\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0019H\u0002J\u0012\u00108\u001a\u0002092\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016J\b\u0010?\u001a\u00020\u0012H\u0002J\b\u0010@\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0093\u0001\u0010\b\u001a{\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012E\u0012C\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017Ra\u0010\u0018\u001aI\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleInputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "TAG", "", "binding", "Lcom/larus/avlink/impl/databinding/LarusDialogDiaryStyleInputBinding;", "onSaveListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", EventConstant.Key.RETAIN_PROMPT, "Lkotlin/Function2;", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "result", "", "errorCode", "", "onResult", "getOnSaveListener", "()Lkotlin/jvm/functions/Function3;", "setOnSaveListener", "(Lkotlin/jvm/functions/Function3;)V", "onDraftListener", "", "saved", "getOnDraftListener", "setOnDraftListener", "isTextChanging", "hasNotifiedDraft", "getMode", "", "shouldHandleDraft", "notifyDraftOnce", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupInputListener", "handleNameChanged", "editable", "Landroid/text/Editable;", "handlePromptChanged", "updateCountByFocusedInput", "updateInputCount", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "shouldTrimOverflow", "updateSaveButtonStyle", "hasContent", "onCreateDialog", "Landroid/app/Dialog;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", WidgetCostModule.TYPE_ON_START, "wakeUpSoftInput", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiaryStyleInputDialog extends DialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f292112j = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f292113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusDialogDiaryStyleInputBinding f292114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function3<? super String, ? super String, ? super Function2<? super e0, ? super Long, Unit>, Unit> f292115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function3<? super String, ? super String, ? super Boolean, Unit> f292116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f292117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f292118i;

    public static final class a {
    }

    static {
    }

    public DiaryStyleInputDialog() {
        this.f292113d = "DiaryStyleInputDialog";
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f292114e = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        r101.setBackgroundDrawable(null);
        r101.setLayout(-1, -2);
        r101.setGravity(80);
        r101.setSoftInputMode(21);
    L7:
        LarusDialogDiaryStyleInputBinding r102 = this.f292114e;
        if (r102 == null) goto L14;
        final EditText r103 = r102.f293185d;
        if (r103 == null) goto L15;
        r103.post(new v(this, r103));
        r103.post(new w(r103));
        return;
    L15:
        return;
    }

    public final void S90(Editable r100) {
        LarusDialogDiaryStyleInputBinding r101 = this.f292114e;
        if (r101 == null) goto L9;
        EditText r102 = r101.f293184c;
        if (r102 == null) goto L9;
        boolean r103 = true;
        if (r102.hasFocus() != true) goto L9;
    L10:
        if (r103 == false) goto L13;
        V90(r100, 20);
        return;
    L13:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public final void T90(Editable r100) {
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.length();
    L7:
        if (r102 <= 0) goto L9;
        boolean r103 = true;
    L10:
        W90(r103);
        LarusDialogDiaryStyleInputBinding r104 = this.f292114e;
        if (r104 == null) goto L17;
        EditText r105 = r104.f293185d;
        if (r105 == null) goto L17;
        if (r105.hasFocus() != true) goto L17;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L27;
        LarusDialogDiaryStyleInputBinding r107 = this.f292114e;
        if (r107 == null) goto L26;
        EditText r108 = r107.f293184c;
        if (r108 == null) goto L26;
        if (r108.hasFocus() != true) goto L26;
        r101 = true;
    L26:
        if (r101 == false) goto L27;
        return;
    L27:
        V90(r100, 200);
        return;
    L17:
        r106 = false;
        goto L18
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = 0;
        goto L7
    }

    public final void U90(boolean r100) {
        Bundle r101 = getArguments();
        if (r101 == null) goto L5;
        int r102 = r101.getInt("mode", 1);
    L6:
        if (r102 != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L12;
        return;
    L12:
        if (this.f292118i == false) goto L14;
        return;
    L14:
        this.f292118i = true;
        LarusDialogDiaryStyleInputBinding r104 = this.f292114e;
        String r105 = null;
        if (r104 == null) goto L21;
        EditText r106 = r104.f293184c;
        if (r106 == null) goto L21;
        Editable r107 = r106.getText();
        if (r107 == null) goto L21;
        String r108 = r107.toString();
    L22:
        String r109 = "";
        if (r108 != null) goto L25;
        r108 = "";
    L25:
        if (r104 == null) goto L31;
        EditText r110 = r104.f293185d;
        if (r110 == null) goto L31;
        Editable r111 = r110.getText();
        if (r111 == null) goto L31;
        r105 = r111.toString();
    L31:
        if (r105 == null) goto L34;
        r109 = r105;
    L34:
        Function3<? super String, ? super String, ? super Boolean, Unit> r112 = this.f292116g;
        if (r112 == null) goto L38;
        r112.invoke(r108, r109, Boolean.valueOf(r100));
        return;
    L38:
        return;
    L21:
        r108 = null;
        goto L22
    L8:
        r103 = false;
        goto L9
    L5:
        r102 = 1;
        goto L6
    }

    public final void W90(boolean r100) {
        Context r101 = getContext();
        if (r101 == null) goto L18;
        LarusDialogDiaryStyleInputBinding r102 = this.f292114e;
        if (r102 == null) goto L9;
        TextView r103 = r102.f293186e;
        if (r103 == null) goto L9;
        r103.setClickable(r100);
    L9:
        if (r100 == false) goto L11;
        int r104 = v19.c.b(R.attr.larus_primary_50, r101, R.color.larus_primary_50);
    L12:
        LarusDialogDiaryStyleInputBinding r105 = this.f292114e;
        if (r105 == null) goto L19;
        TextView r106 = r105.f293186e;
        if (r106 == null) goto L20;
        r106.setTextColor(ContextCompat.getColor(r101, r104));
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r104 = v19.c.b(R.attr.larus_neutral_50, r101, R.color.larus_neutral_50);
        goto L12
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        U90(false);
        super.onCancel(r100);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setSoftInputMode(16);
    L5:
        return r101;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        U90(false);     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
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

    public final void V90(Editable r100, int r101) {
        if (this.f292117h == false) goto L5;
        return;
    L5:
        boolean r102 = true;
        this.f292117h = true;
        if (r100 == null) goto L8;
        int r103 = r100.length();
    L9:
        if (r103 <= r101) goto L11;
        boolean r104 = true;
    L12:
        if (r100 == null) goto L15;
        if (r104 == false) goto L15;
        r100.delete(r101, r103);
        r103 = r101;
    L15:
        LarusDialogDiaryStyleInputBinding r105 = this.f292114e;
        if (r105 == null) goto L20;
        TextView r106 = r105.f293187f;
        if (r106 == null) goto L20;
        r106.setVisibility(0);
    L20:
        if (r101 <= 0) goto L23;
        if (r103 < r101) goto L23;
    L25:
        if (r102 == false) goto L31;
        StringBuilder r107 = new StringBuilder();
        r107.append(r103);
        r107.append('/');
        r107.append(r101);
        String r108 = r107.toString();
        int r109 = String.valueOf(r103).length();
        SpannableString r110 = new SpannableString(r108);
        r110.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF3B30")), 0, r109, 33);
        LarusDialogDiaryStyleInputBinding r111 = this.f292114e;
        if (r111 == null) goto L43;
        TextView r112 = r111.f293187f;
        if (r112 == null) goto L43;
        r112.setText(r110);
    L43:
        this.f292117h = false;
        return;
    L31:
        LarusDialogDiaryStyleInputBinding r113 = this.f292114e;
        if (r113 == null) goto L36;
        TextView r114 = r113.f293187f;
        if (r114 == null) goto L36;
        StringBuilder r115 = new StringBuilder();
        r115.append(r103);
        r115.append('/');
        r115.append(r101);
        r114.setText(r115.toString());
    L36:
        Context r116 = getContext();
        if (r116 == null) goto L43;
        LarusDialogDiaryStyleInputBinding r117 = this.f292114e;
        if (r117 == null) goto L43;
        TextView r118 = r117.f293187f;
        if (r118 == null) goto L43;
        r118.setTextColor(ContextCompat.getColor(r116, v19.c.b(R.attr.larus_neutral_50, r116, R.color.larus_neutral_50)));
    L23:
        r102 = false;
        goto L25
    L11:
        r104 = false;
        goto L12
    L8:
        r103 = 0;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogDiaryStyleInputBinding r102 = this.f292114e;
        if (r102 == null) goto L7;
        EditText r103 = r102.f293184c;
        if (r103 == null) goto L7;
        r103.setOnFocusChangeListener(new a0(this));
    L7:
        LarusDialogDiaryStyleInputBinding r104 = this.f292114e;
        if (r104 == null) goto L12;
        EditText r105 = r104.f293185d;
        if (r105 == null) goto L12;
        r105.setOnFocusChangeListener(new b0(this));
    L12:
        LarusDialogDiaryStyleInputBinding r106 = this.f292114e;
        if (r106 == null) goto L17;
        EditText r107 = r106.f293184c;
        if (r107 == null) goto L17;
        r107.addTextChangedListener(new c0(this));
    L17:
        LarusDialogDiaryStyleInputBinding r108 = this.f292114e;
        if (r108 == null) goto L22;
        EditText r109 = r108.f293185d;
        if (r109 == null) goto L22;
        r109.addTextChangedListener(new d0(this));
    L22:
        Bundle r110 = getArguments();
        boolean r111 = true;
        if (r110 == null) goto L25;
        int r112 = r110.getInt("mode", 1);
    L26:
        if (r112 != 1) goto L45;
        Bundle r113 = getArguments();
        if (r113 == null) goto L36;
        String r114 = r113.getString("name");
        if (r114 == null) goto L36;
        LarusDialogDiaryStyleInputBinding r115 = this.f292114e;
        if (r115 == null) goto L36;
        EditText r116 = r115.f293184c;
        if (r116 == null) goto L36;
        r116.setText(r114);
    L36:
        Bundle r117 = getArguments();
        if (r117 == null) goto L63;
        String r118 = r117.getString(EventConstant.Key.RETAIN_PROMPT);
        if (r118 == null) goto L63;
        LarusDialogDiaryStyleInputBinding r119 = this.f292114e;
        if (r119 == null) goto L63;
        EditText r120 = r119.f293185d;
        if (r120 == null) goto L63;
        r120.setText(r118);
    L63:
        LarusDialogDiaryStyleInputBinding r121 = this.f292114e;
        if (r121 == null) goto L70;
        EditText r122 = r121.f293184c;
        if (r122 == null) goto L70;
        if (r122.hasFocus() != true) goto L70;
        boolean r123 = true;
    L71:
        Editable r124 = null;
        if (r123 == false) goto L79;
        LarusDialogDiaryStyleInputBinding r125 = this.f292114e;
        if (r125 == null) goto L78;
        EditText r126 = r125.f293184c;
        if (r126 == null) goto L78;
        r124 = r126.getText();
    L78:
        S90(r124);
    L85:
        LarusDialogDiaryStyleInputBinding r127 = this.f292114e;
        if (r127 == null) goto L94;
        EditText r128 = r127.f293185d;
        if (r128 == null) goto L94;
        Editable r129 = r128.getText();
        if (r129 == null) goto L94;
        if ((!StringsKt.isBlank(r129)) != true) goto L94;
    L95:
        W90(r111);
        LarusDialogDiaryStyleInputBinding r130 = this.f292114e;
        if (r130 == null) goto L100;
        TextView r131 = r130.f293183b;
        if (r131 == null) goto L100;
        r131.setOnClickListener(new x(this));
    L100:
        LarusDialogDiaryStyleInputBinding r132 = this.f292114e;
        if (r132 == null) goto L106;
        TextView r133 = r132.f293186e;
        if (r133 == null) goto L107;
        r133.setOnClickListener(new y(this));
        return;
    L107:
        return;
    L106:
        return;
    L94:
        r111 = false;
        goto L95
    L79:
        LarusDialogDiaryStyleInputBinding r134 = this.f292114e;
        if (r134 == null) goto L84;
        EditText r135 = r134.f293185d;
        if (r135 == null) goto L84;
        r124 = r135.getText();
    L84:
        T90(r124);
    L70:
        r123 = false;
        goto L71
    L45:
        Bundle r136 = getArguments();
        if (r136 == null) goto L54;
        String r137 = r136.getString("draft_name");
        if (r137 == null) goto L54;
        LarusDialogDiaryStyleInputBinding r138 = this.f292114e;
        if (r138 == null) goto L54;
        EditText r139 = r138.f293184c;
        if (r139 == null) goto L54;
        r139.setText(r137);
    L54:
        Bundle r140 = getArguments();
        if (r140 == null) goto L63;
        String r141 = r140.getString("draft_prompt");
        if (r141 == null) goto L63;
        LarusDialogDiaryStyleInputBinding r142 = this.f292114e;
        if (r142 == null) goto L63;
        EditText r143 = r142.f293185d;
        if (r143 == null) goto L63;
        r143.setText(r141);
        goto L63
    L25:
        r112 = 1;
        goto L26
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r102 = r100.inflate(R.layout.larus_dialog_diary_style_input, r101, false);
        int r103 = R.id.diary_style_dialog_cancel;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r102, R.id.diary_style_dialog_cancel);
        if (r104 == null) goto L20;
        r103 = R.id.diary_style_dialog_name;
        EditText r105 = (EditText) ViewBindings.findChildViewById(r102, R.id.diary_style_dialog_name);
        if (r105 == null) goto L20;
        r103 = R.id.diary_style_dialog_prompt;
        EditText r106 = (EditText) ViewBindings.findChildViewById(r102, R.id.diary_style_dialog_prompt);
        if (r106 == null) goto L20;
        r103 = R.id.diary_style_dialog_save;
        TextView r107 = (TextView) ViewBindings.findChildViewById(r102, R.id.diary_style_dialog_save);
        if (r107 == null) goto L20;
        r103 = R.id.diary_style_dialog_title;
        if (((TextView) ViewBindings.findChildViewById(r102, R.id.diary_style_dialog_title)) == null) goto L20;
        r103 = R.id.diary_style_prompt_count;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r102, R.id.diary_style_prompt_count);
        if (r108 == null) goto L20;
        ConstraintLayout r109 = (ConstraintLayout) r102;
        this.f292114e = new LarusDialogDiaryStyleInputBinding(r109, r104, r105, r106, r107, r108);
        if (r109 == null) goto L18;
        return r109;
    L18:
        return new View(getContext());
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r103)));
    }
}
