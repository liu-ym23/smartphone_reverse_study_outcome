package com.bytedance.dux.dialog.base;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.dux.api.DuxComponent;
import com.bytedance.dux.common.DuxConfig;
import com.bytedance.dux.common.PadAdaptScene;
import com.bytedance.dux.window.controller.DuxBreakPointController;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class AbstractDialog extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f204962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f204963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f204964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f204965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f204966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f204967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CloseIconStyle f204968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f204969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f204970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.dux.window.controller.a f204971j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Boolean> f204972k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/dux/dialog/base/AbstractDialog$CloseIconStyle;", "", "LIGHT", "DARK", "CUSTOM", "dux_release"}, k = 1, mv = {1, 7, 1})
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CloseIconStyle[] f204973a = null;

        public static CloseIconStyle valueOf(String r100) {
            return (CloseIconStyle) r27.a.a(CloseIconStyle.class, r100);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) f204973a.clone();
        }

        static {
            CloseIconStyle r100 = new CloseIconStyle("LIGHT", 0);
            LIGHT = r100;
            CloseIconStyle r101 = new CloseIconStyle("DARK", 1);
            DARK = r101;
            CloseIconStyle r102 = new CloseIconStyle("CUSTOM", 2);
            CUSTOM = r102;
            f204973a = new CloseIconStyle[]{r100, r101, r102};
        }

        public CloseIconStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f204974a = null;

        static {
            int[] r100 = new int[CloseIconStyle.values().length];
            r100[CloseIconStyle.DARK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CloseIconStyle.LIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CloseIconStyle.CUSTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f204974a = r100;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractDialog f204975a;

        public c(AbstractDialog r100) {
            this.f204975a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AbstractDialog r101 = this.f204975a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
        L17:
            View.OnClickListener r103 = this.f204975a.f204969h;
            if (r103 == null) goto L26;
            r103.onClick(r100);
            return;
        L26:
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r104 == null) goto L16;
            com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
            goto L17
        }
    }

    public static final class d implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractDialog f204976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnDismissListener f204977b;

        public d(AbstractDialog r100, DialogInterface.OnDismissListener r101) {
            this.f204976a = r100;
            this.f204977b = r101;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            DuxBreakPointController r101 = gm4.a.f481672a;
            com.bytedance.dux.window.controller.a r102 = this.f204976a.f204971j;
            if (r102 == null) goto L6;
            gm4.a.f481672a.a(r102);
        L6:
            DialogInterface.OnDismissListener r103 = this.f204977b;
            if (r103 == null) goto L10;
            r103.onDismiss(r100);
            return;
        }
    }

    static {
        DuxComponent r100 = DuxComponent.DIALOG;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        Function0<Boolean> r100 = this.f204972k;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        super.onBackPressed();
        return;
    L5:
        if (r100.invoke().booleanValue() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        Window r100 = getWindow();
        if (r100 == null) goto L18;
        r100.setBackgroundDrawableResource(R.color.transparent);
        r100.addFlags(2);
        WindowManager.LayoutParams r101 = r100.getAttributes();
        r101.dimAmount = 0.5f;
        r101.gravity = 1;
        if (this.f204962a == false) goto L12;
        int r102 = -1;
    L13:
        r101.height = r102;
        r100.setAttributes(r101);
        return;
    L12:
        r102 = -2;
        goto L13
    L18:
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public AbstractDialog(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f204962a = false;
        this.f204963b = false;
        this.f204968g = CloseIconStyle.DARK;
        Map<PadAdaptScene, Boolean> r101 = DuxConfig.f204897a;
        this.f204970i = DuxConfig.a(PadAdaptScene.DIALOG);
        Window r102 = getWindow();
        if (r102 == null) goto L5;
        r102.requestFeature(1);
    L5:
        setContentView(com.larus.nova.R.layout.dux_base_dialog_new);
        View r103 = findViewById(com.larus.nova.R.id.root_view);
        this.f204964c = r103;
        this.f204966e = (ImageView) findViewById(com.larus.nova.R.id.btn_close);
        this.f204965d = findViewById(com.larus.nova.R.id.close_container);
        b(this.f204967f, null);
        ViewStub r104 = (ViewStub) findViewById(com.larus.nova.R.id.contentView);
        r104.setLayoutResource(com.larus.nova.R.layout.dux_alert_dialog_new);
        r104.inflate();
        DuxBreakPointController r105 = gm4.a.f481672a;
        hm4.c r106 = new hm4.c(r103);
        r106.f485932b = 1;
        gm4.a.a(r106, new ql4.a((com.bytedance.dux.dialog.alert.d) this));
        this.f204971j = com.bytedance.dux.window.controller.a.f205935a;
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener r100) {
        super.setOnDismissListener(new d(this, r100));
    }

    public final void b(boolean r100, View.OnClickListener r101) {
        this.f204967f = r100;
        this.f204969h = r101;
        ImageView r102 = this.f204966e;
        if (r102 == null) goto L16;
        Resources r103 = Resources.getSystem();
        n.a(r102, MathKt.roundToInt(TypedValue.applyDimension(1, 44, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()))));
        if (r100 == false) goto L12;
        View r104 = this.f204965d;
        if (r104 == null) goto L9;
        n.f(r104);
    L9:
        a(this.f204968g, null, null);
        View r105 = this.f204965d;
        if (r105 == null) goto L17;
        r105.setOnClickListener(new c(this));
        return;
    L17:
        return;
    L12:
        View r106 = this.f204965d;
        if (r106 == null) goto L19;
        n.e(r106);
        return;
    L19:
        return;
    }

    public final void a(CloseIconStyle r100, Integer r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "style");
        if (this.f204967f == false) goto L37;
        int r103 = b.f204974a[r100.ordinal()];
        int r104 = com.larus.nova.R.color.ConstTextInverse;
        if (r103 != 1) goto L7;
        r102 = Integer.valueOf(com.larus.nova.R.color.ConstBGContainer7);
    L16:
        ImageView r105 = this.f204966e;
        if (r105 == null) goto L20;
        r105.setImageTintList(ContextCompat.getColorStateList(getContext(), r104));
    L20:
        GradientDrawable r106 = null;
        if (r102 != null) goto L26;
        View r107 = this.f204965d;
        if (r107 == null) goto L39;
        r107.setBackground(null);
        return;
    L39:
        return;
    L26:
        View r108 = this.f204965d;
        if (r108 == null) goto L29;
        Drawable r109 = r108.getBackground();
    L31:
        if ((r109 instanceof GradientDrawable) == false) goto L33;
        r106 = (GradientDrawable) r109;
    L33:
        if (r106 == null) goto L40;
        r106.setColor(ContextCompat.getColorStateList(getContext(), r102.intValue()));
        return;
    L40:
        return;
    L29:
        r109 = null;
        goto L31
    L7:
        if (r103 != 2) goto L9;
        r102 = Integer.valueOf(com.larus.nova.R.color.ConstTextInverse5);
        r104 = com.larus.nova.R.color.TextReverse;
        goto L16
    L9:
        if (r103 != 3) goto L13;
        if (r101 == null) goto L16;
        r104 = r101.intValue();
        goto L16
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
