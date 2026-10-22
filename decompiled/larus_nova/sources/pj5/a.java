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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends com.larksuite.component.universe_design.timepicker.impl.action.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f529462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public pj5.c f529463m;

    /* JADX INFO: renamed from: pj5.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7201a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f529464a;

        public ViewOnClickListenerC7201a(a r100) {
            this.f529464a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            UDDialog r101 = this.f529464a.getMDialog();
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
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
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

    public static final class b implements c18.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f529465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f529466b;

        public b(TextView r100, a r101) {
            this.f529465a = r100;
            this.f529466b = r101;
        }

        @Override // c18.a
        public final void a(int r100, int r101, int r102, int r103, int r104) {
            if (pj5.b.d(r100, r101, r102) == false) goto L5;
            this.f529465a.setTextColor(UDColorUtils.getColor(this.f529466b.getContext(), R.color.primary_content_default));
            return;
        L5:
            this.f529465a.setTextColor(UDColorUtils.getColor(this.f529466b.getContext(), R.color.text_disabled));
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UDTimePicker f529467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f529468b;

        public c(UDTimePicker r100, a r101) {
            this.f529467a = r100;
            this.f529468b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Calendar r101 = this.f529467a.getSelectedCalendar();
            int r102 = pj5.b.f529469a;
            if (pj5.b.d(r101.get(1), r101.get(2), r101.get(5)) == true) goto L5;
            return;
        L5:
            pj5.c r103 = this.f529468b.f529463m;
            if (r103 == null) goto L8;
            r103.a(r101);
        L8:
            UDDialog r104 = this.f529468b.getMDialog();
            if (r104 == null) goto L27;
            Handler r105 = DialogLancet.resolveDialogHandler(r104);
            if (r105 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r104);
            r104.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r104);
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r106 == null) goto L24;
            com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r104);
            throw th;
        L13:
            if (Looper.myLooper() == r105.getLooper()) goto L15;
            r105.post(DialogLancet.createDismissRunnable(r104));
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.timepicker.impl.action.a, com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = LayoutInflater.from(getContext()).inflate(R.layout.custom_time_root_view, null);
        TextView r101 = (TextView) r100.findViewById(R.id.cancel);
        TextView r102 = (TextView) r100.findViewById(R.id.open);
        UDTimePicker r103 = (UDTimePicker) r100.findViewById(R.id.time_picker);
        int r104 = pj5.b.f529469a;
        long r105 = this.f529462l;
        Calendar r106 = Calendar.getInstance();
        r106.setTimeInMillis(r105);
        r106.setTime(new Date(r105));
        Intrinsics.checkNotNull(r106);
        r103.setSelectedCalendar(r106);
        r101.setOnClickListener(new ViewOnClickListenerC7201a(this));
        r103.setDatePickerListener(new b(r102, this));
        r102.setOnClickListener(new c(r103, this));
        return r100;
    }

    public a(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f529462l = r101;
    }
}
