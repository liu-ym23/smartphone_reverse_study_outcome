package com.bytedance.applet.aibridge.datepicker;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.crash.d;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import f3.h;
import hv3.c;
import hv3.e;
import hv3.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/datepicker/CustomPickerMethod;", "Lcom/bytedance/applet/aibridge/datepicker/AbsCustomPickerMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/applet/aibridge/datepicker/AbsCustomPickerMethodIDL$CustomPickerParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/datepicker/AbsCustomPickerMethodIDL$CustomPickerResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomPickerMethod extends AbsCustomPickerMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public CustomPickerMethod() {
    }

    public static void b(AppCompatDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static DisplayMetrics c(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public final void handle(e3.d r20, ParamModel r21, final h r22) {
        AbsCustomPickerMethodIDL.a r1 = (AbsCustomPickerMethodIDL.a) r21;
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        Activity r2 = AppHost.a.a().getCurrentActivity();
        if ((r2 instanceof Context) == false) goto L5;
        Activity r7 = r2;
    L7:
        if (r7 != null) goto L10;
        h.a.a(r22, "No available activity context", null, null, 14);
        return;
    L10:
        if (a.b() == null) goto L12;
        h.a.a(r22, "The custom picker has been shown already", null, null, 14);
        return;
    L12:
        final AppCompatDialog r3 = new AppCompatDialog(r7, 2131952439);
        Context r13 = r3.getContext();
        List<List<String>> r11 = r1.getOptionList();
        if (r11.isEmpty() == true) goto L51;
        List<List<String>> r5 = r11;
        if ((r5 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r6 = r5.iterator();
    L21:
        if (r6.hasNext() == false) goto L25;
        if (((List) r6.next()).isEmpty() == false) goto L21;
        boolean r8 = true;
    L26:
        if (r8 == true) goto L51;
        int[] r12 = i.a(r11, r1.getSelectedOptionList());
        int r9 = ContextCompat.getColor(r7, 2131103185);
        int r10 = ContextCompat.getColor(r7, 2131103184);
        final AtomicBoolean r4 = new AtomicBoolean(false);
        FrameLayout r14 = new FrameLayout(r13);
        r14.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r14.setPadding(0, 0, 0, 0);
        final a.c r15 = new a.c(r3, r7, r14, r9, r10, r11, r12);
        r3.setOnDismissListener(new hv3.a(r15, r4, r22));
        FrameLayout r16 = new FrameLayout(r13);
        r16.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        float r17 = 20;
        float r18 = 8;
        r16.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r17, c(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 12, c(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r17, c(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r18, c(Resources.getSystem()))));
        TextView r19 = new TextView(r13);
        r19.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        String r23 = r1.getTitle();
        if (r23 != null) goto L32;
        r23 = r13.getString(2131899906);
    L32:
        r19.setText(r23);
        r19.setTextColor(ContextCompat.getColor(r13, 2131103182));
        r19.setTextSize(17.0f);
        r19.setTypeface(Typeface.create("sans-serif-medium", 1));
        r16.addView(r19);
        LinearLayout r24 = new LinearLayout(r13);
        r24.setOrientation(0);
        r24.setGravity(17);
        r24.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r24.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r17, c(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r18, c(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, r17, c(Resources.getSystem()))), MathKt.roundToInt(TypedValue.applyDimension(1, 16, c(Resources.getSystem()))));
        ViewCompat.setOnApplyWindowInsetsListener(r24, new hv3.b());
        Button r25 = new Button(r13);
        float r110 = 36;
        LinearLayout.LayoutParams r26 = new LinearLayout.LayoutParams(0, MathKt.roundToInt(TypedValue.applyDimension(1, r110, c(Resources.getSystem()))), 1.0f);
        float r111 = 10;
        r26.setMarginEnd(MathKt.roundToInt(TypedValue.applyDimension(1, r111, c(Resources.getSystem()))));
        r25.setLayoutParams(r26);
        r25.setText(r13.getString(2131899903));
        r25.setBackgroundResource(2131238491);
        r25.setPadding(0, 0, 0, 0);
        r25.setIncludeFontPadding(false);
        r25.setTextColor(ContextCompat.getColor(r13, 2131103182));
        r25.setTextSize(16.0f);
        r25.setTypeface(Typeface.create("sans-serif-medium", 0));
        r25.setElevation(0.0f);
        r25.setOnClickListener(new c(r3));
        Button r112 = new Button(r13);
        LinearLayout.LayoutParams r27 = new LinearLayout.LayoutParams(0, MathKt.roundToInt(TypedValue.applyDimension(1, r110, c(Resources.getSystem()))), 1.0f);
        r27.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r111, c(Resources.getSystem()))));
        r112.setLayoutParams(r27);
        r112.setText(r13.getString(2131899905));
        r112.setBackgroundResource(2131238492);
        r112.setPadding(0, 0, 0, 0);
        r112.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(r13, 2131103178)));
        r112.setTextColor(ContextCompat.getColor(r13, R.color.white));
        r112.setTextSize(16.0f);
        r112.setTypeface(Typeface.create("sans-serif-medium", 0));
        r112.setElevation(0.0f);
        r112.setOnClickListener(new hv3.d(r15, r4, r22, r3));
        r24.addView(r25);
        r24.addView(r112);
        LinearLayout r0 = new LinearLayout(r13);
        r0.setOrientation(1);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        r0.setBackgroundResource(2131238490);
        r0.setClickable(true);
        r0.addView(r16);
        r0.addView(r14);
        r0.addView(r24);
        FrameLayout r28 = new FrameLayout(r13);
        r28.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r28.setOnClickListener(new e(r3));
        r28.addView(r0);
        r3.setContentView(r28);
        a.c r29 = a.a;
        Intrinsics.checkNotNullParameter(r15, "session");
        a.c r30 = a.a;
        if (r30 == null) goto L42;
        if (r30 == r15) goto L42;
        if (r30.r == true) goto L42;
        r30.r = true;
        r30.c();
        b r31 = r30.q;
        if (r31 == null) goto L41;
        AppHost.a.a().f(r31);
    L41:
        r30.q = null;
    L42:
        a.a = r15;
        if (DialogLancet.shouldBlockDialogShow(r3) == false) goto L54;
        DialogLancet.handleBlockedDialogShow(r3);
    L47:
        Window r32 = r3.getWindow();
        if (r32 == null) goto L50;
        WindowCompat.setDecorFitsSystemWindows(r32, false);
        r32.setLayout(-1, -1);
        r32.setGravity(80);
        r32.setBackgroundDrawable(new ColorDrawable(0));
        r32.setNavigationBarColor(0);
    L50:
        ViewCompat.requestApplyInsets(r24);
        return;
    L54:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L53
    L46:
        DialogLancet.beforeDialogShow(r3);
        r3.show();
        DialogLancet.afterDialogShow(r3);
    L25:
        r8 = false;
        goto L26
    L17:
        if (r5.isEmpty() == false) goto L19;
    L51:
        h.a.a(r22, "optionList is Empty", null, null, 14);
        return;
    L5:
        r7 = null;
        goto L7
    }
}
