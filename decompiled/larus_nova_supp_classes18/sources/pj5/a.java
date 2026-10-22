package pj5;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.timepicker.UDTimePicker;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends com.larksuite.component.universe_design.timepicker.impl.action.a {
    public final long l;
    public pj5.c m;

    /* JADX INFO: renamed from: pj5.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0289a implements View.OnClickListener {
        public final /* synthetic */ a a;

        public ViewOnClickListenerC0289a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            UDDialog r5 = this.a.getMDialog();
            if (r5 == null) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public static final class b implements c18.a {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ a b;

        public b(TextView r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(int r1, int r2, int r3, int r4, int r5) {
            if (pj5.b.d(r1, r2, r3) == false) goto L5;
            this.a.setTextColor(UDColorUtils.getColor(this.b.getContext(), 2131105542));
            return;
        L5:
            this.a.setTextColor(UDColorUtils.getColor(this.b.getContext(), 2131106611));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ UDTimePicker a;
        public final /* synthetic */ a b;

        public c(UDTimePicker r1, a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Calendar r5 = this.a.getSelectedCalendar();
            int r0 = pj5.b.a;
            if (pj5.b.d(r5.get(1), r5.get(2), r5.get(5)) == true) goto L5;
            return;
        L5:
            pj5.c r1 = this.b.m;
            if (r1 == null) goto L8;
            r1.a(r5);
        L8:
            UDDialog r6 = this.b.getMDialog();
            if (r6 == null) goto L27;
            Handler r2 = DialogLancet.resolveDialogHandler(r6);
            if (r2 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r3 == null) goto L24;
            com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L13:
            if (Looper.myLooper() == r2.getLooper()) goto L15;
            r2.post(DialogLancet.createDismissRunnable(r6));
            return;
        }
    }

    public final View createView() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131559983, null);
        TextView r1 = (TextView) r0.findViewById(2131365114);
        TextView r2 = (TextView) r0.findViewById(2131381493);
        UDTimePicker r3 = r0.findViewById(2131388673);
        int r4 = pj5.b.a;
        long r5 = this.l;
        Calendar r6 = Calendar.getInstance();
        r6.setTimeInMillis(r5);
        r6.setTime(new Date(r5));
        Intrinsics.checkNotNull(r6);
        r3.setSelectedCalendar(r6);
        r1.setOnClickListener(new ViewOnClickListenerC0289a(this));
        r3.setDatePickerListener(new b(r2, this));
        r2.setOnClickListener(new c(r3, this));
        return r0;
    }

    public a(Context r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.l = r3;
    }
}
