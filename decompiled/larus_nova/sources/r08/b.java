package r08;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import h18.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends UDListDialogController {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f535505h;

    public static final class a {
    }

    /* JADX INFO: renamed from: r08.b$b, reason: collision with other inner class name */
    public static final class C7414b extends BottomSheetBehavior.BottomSheetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f535506a;

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View r100, float r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
        }

        public C7414b(b r100) {
            this.f535506a = r100;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "bottomSheet");
            if (r101 != 5) goto L23;
            UDDialog r102 = this.f535506a.getMDialog();
            if (r102 == null) goto L27;
            Handler r103 = DialogLancet.resolveDialogHandler(r102);
            if (r103 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r102);
            r102.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r102);
            return;
        L16:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r104 == null) goto L20;
            d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r102);
            throw th;
        L9:
            if (Looper.myLooper() == r103.getLooper()) goto L11;
            r103.post(DialogLancet.createDismissRunnable(r102));
            return;
        L27:
            return;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f535507a;

        public c(b r100) {
            this.f535507a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            UDDialog r101 = this.f535507a.getMDialog();
            if (r101 == null) goto L21;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L7:
            if (Looper.myLooper() == r102.getLooper()) goto L9;
            r102.post(DialogLancet.createDismissRunnable(r101));
            return;
        }
    }

    static {
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultRootRes() {
        return R.layout.ud_bottom_sheet_default_root;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        if (r100 != null) goto L5;
        return null;
    L5:
        View r101 = r100.findViewById(R.id.ud_dialog_action_sheet_peek);
        if (r101 == null) goto L15;
        BottomSheetBehavior r102 = BottomSheetBehavior.from(r101);
        int r103 = r102.getPeekHeight();
        float r104 = this.f535505h;
        if (r104 <= 0.0f) goto L10;
        r102.setPeekHeight((int) getSize(r104, g.a(getContext()).getHeight()));
    L12:
        r102.setHideable(false);
        r102.setBottomSheetCallback(new C7414b(this));
        if (getMBackground() == null) goto L15;
        r100.setBackground(null);
        r101.setBackground(getMBackground());
        goto L15
    L10:
        if (r103 != 0) goto L12;
        r102.setPeekHeight((int) getSize(0.5f, g.a(getContext()).getHeight()));
    L15:
        View r105 = r100.findViewById(R.id.ud_dialog_action_sheet_outside_holder);
        if (Intrinsics.areEqual(getMCanceledOnTouchOutside(), Boolean.FALSE) == true) goto L19;
        if (r105 == null) goto L19;
        r105.setOnClickListener(new c(this));
    L19:
        return r100;
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.larksuite.component.universe_design.dialog.UDListDialogController, com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof r08.a) == false) goto L7;
        super.apply(r100, r101);
        this.f535505h = ((r08.a) r100).f535504a;
        return;
    L7:
        throw new IllegalArgumentException("builder should be UDActionSheetBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
