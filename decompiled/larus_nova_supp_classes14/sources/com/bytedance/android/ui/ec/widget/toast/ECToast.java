package com.bytedance.android.ui.ec.widget.toast;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.android.ui.base.widget.icon.IconExtKt;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.bytedance.android.ui.ec.widget.loading.ECLoadingDialog;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006J)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u0018J]\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u001eJ3\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ+\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010 J3\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001c\u001a\u00020\u001a2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!J)\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/toast/ECToast;", "", "()V", "showCustomToast", "", "context", "Landroid/content/Context;", "text", "", "iconDrawable", "Landroid/graphics/drawable/Drawable;", "isShortDuration", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/Boolean;)V", "showFailToast", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V", "showLoadingToast", "Landroid/app/Dialog;", "showSuccessToast", "showSystemToast", "Landroid/widget/Toast;", "contentView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/Boolean;)Landroid/widget/Toast;", "iconId", "", "textRes", "textIcon", "textIconDrawable", "(Landroid/content/Context;ILandroid/graphics/drawable/Drawable;ILjava/lang/CharSequence;ILandroid/graphics/drawable/Drawable;Ljava/lang/Boolean;)Landroid/widget/Toast;", "showToast", "(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/Boolean;)Landroid/widget/Toast;", "(Landroid/content/Context;Ljava/lang/CharSequence;ILjava/lang/Boolean;)V", "(Landroid/content/Context;ILjava/lang/Boolean;)V", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECToast {
    public static final ECToast INSTANCE = null;

    private ECToast() {
    }

    static {
        INSTANCE = new ECToast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_toast_ECToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(ECLoadingDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final Dialog showLoadingToast(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ECLoadingDialog r0 = new ECLoadingDialog(r4, 2131954218);
        r0.setShowCloseBtn(true);
        r0.setDialogCancelable(false);
        INVOKEVIRTUAL_com_bytedance_android_ui_ec_widget_toast_ECToast_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r0);
        return new ECLoadingDialog(r4, 2131954218);
    }

    private final Toast showSystemToast(Context r2, View r3, Boolean r4) {
        Toast r0 = new Toast(r2.getApplicationContext());
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L5;
        r0.setDuration(0);
    L6:
        r0.setGravity(17, 0, 0);
        r0.setView(r3);
        r0.show();
        return r0;
    L5:
        r0.setDuration(1);
        goto L6
    }

    public final void showFailToast(Context r3, String r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Drawable r0 = ContextCompat.getDrawable(r3, 2131234505);
        if (r0 == null) goto L6;
        Drawable r1 = DrawableCompat.wrap(r0);
        DrawableCompat.setTint(r1, ContextCompat.getColor(r3, 2131109402));
        INSTANCE.showCustomToast(r3, r4, r1, r5);
        return;
    }

    public final void showSuccessToast(Context r3, String r4, Boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Drawable r0 = ContextCompat.getDrawable(r3, 2131234500);
        if (r0 == null) goto L6;
        Drawable r1 = IconExtKt.coloredDrawable(r0, ContextCompat.getColor(r3, 2131109402));
        INSTANCE.showCustomToast(r3, r4, r1, r5);
        return;
    }

    public final Toast showToast(Context r11, CharSequence r12, Boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        return showSystemToast(r11, 0, null, 0, r12, 0, null, r13);
    }

    public final void showToast(Context r11, int r12, Boolean r13) {
        Intrinsics.checkNotNullParameter(r11, "context");
        showSystemToast(r11, 0, null, r12, null, 0, null, r13);
    }

    private final void showCustomToast(Context r10, CharSequence r11, Drawable r12, Boolean r13) {
        showSystemToast(r10, 0, r12, 0, r11, 0, null, r13);
    }

    public final void showToast(Context r11, CharSequence r12, int r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        showSystemToast(r11, 0, null, 0, r12, r13, null, r14);
    }

    public final void showToast(Context r11, CharSequence r12, Drawable r13, Boolean r14) {
        Intrinsics.checkNotNullParameter(r11, "context");
        showSystemToast(r11, 0, null, 0, r12, 0, r13, r14);
    }

    public static /* synthetic */ void showFailToast$default(ECToast r0, Context r1, String r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.showFailToast(r1, r2, r3);
    }

    public static /* synthetic */ void showSuccessToast$default(ECToast r0, Context r1, String r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.showSuccessToast(r1, r2, r3);
    }

    public static /* synthetic */ Toast showSystemToast$default(ECToast r0, Context r1, View r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = Boolean.FALSE;
    L6:
        return r0.showSystemToast(r1, r2, r3);
    }

    public static /* synthetic */ Toast showToast$default(ECToast r0, Context r1, CharSequence r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.showToast(r1, r2, r3);
    }

    public static /* synthetic */ void showToast$default(ECToast r0, Context r1, int r2, Boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        r0.showToast(r1, r2, r3);
    }

    public static /* synthetic */ void showCustomToast$default(ECToast r0, Context r1, CharSequence r2, Drawable r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.showCustomToast(r1, r2, r3, r4);
    }

    public static /* synthetic */ void showToast$default(ECToast r0, Context r1, CharSequence r2, int r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.showToast(r1, r2, r3, r4);
    }

    public static /* synthetic */ void showToast$default(ECToast r0, Context r1, CharSequence r2, Drawable r3, Boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.showToast(r1, r2, r3, r4);
    }

    private final Toast showSystemToast(Context r7, int r8, Drawable r9, int r10, CharSequence r11, int r12, Drawable r13, Boolean r14) {
        View r1 = LayoutInflater.from(r7).inflate(2131560676, null);     // Catch: Exception -> L25
        ImageView r2 = (ImageView) r1.findViewById(2131374718);     // Catch: Exception -> L25
        LinearLayout r3 = (LinearLayout) r1.findViewById(2131388944);     // Catch: Exception -> L25
        if (r8 == 0) goto L6;
        r2.setImageResource(r8);     // Catch: Exception -> L25
    L16:
        TextView r15 = (TextView) r1.findViewById(2131388367);     // Catch: Exception -> L25
        r15.setTextColor(ContextCompat.getColor(r7, 2131109391));     // Catch: Exception -> L25
        if (r10 == 0) goto L19;
        r15.setText(r10);     // Catch: Exception -> L25
    L20:
        if (r12 == 0) goto L22;
        r15.setCompoundDrawablesWithIntrinsicBounds(r12, 0, 0, 0);     // Catch: Exception -> L25
    L23:
        return showSystemToast(r7, r1, r14);
    L22:
        r15.setCompoundDrawablesWithIntrinsicBounds(r13, null, null, null);     // Catch: Exception -> L25
        goto L23
    L19:
        r15.setText(r11);     // Catch: Exception -> L25
        goto L20
    L6:
        if (r9 == null) goto L8;
        r2.setImageDrawable(r9);     // Catch: Exception -> L25
        goto L16
    L8:
        r2.setVisibility(8);     // Catch: Exception -> L25
        r3.setMinimumHeight(0);     // Catch: Exception -> L25
        r3.setMinimumWidth(0);     // Catch: Exception -> L25
        r3.setPadding(UnitExtensionKt.dp2px(16), UnitExtensionKt.dp2px(10), UnitExtensionKt.dp2px(16), UnitExtensionKt.dp2px(10));     // Catch: Exception -> L25
        Drawable r16 = r3.getBackground();     // Catch: Exception -> L25
        if ((r16 instanceof BackgroundDrawable) == true) goto L11;
        r16 = null;
    L11:
        BackgroundDrawable r17 = (BackgroundDrawable) r16;     // Catch: Exception -> L25
        if (r17 == null) goto L16;
        BackgroundDrawable r18 = r17.setCornerRadius(UnitExtensionKt.dp2px(20));     // Catch: Exception -> L25
        if (r18 == null) goto L16;
        r18.invalidate();     // Catch: Exception -> L25
    L25:
        return null;
    }
}
