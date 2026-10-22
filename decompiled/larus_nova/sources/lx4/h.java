package lx4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f511184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f511185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f511186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Dialog f511187d;

    public interface a {
        void dismiss();
    }

    public static final class b implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f511188a;

        public b(h r100) {
            this.f511188a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f511188a.f511185b.dismiss();
        }
    }

    public final void a() {
        if (this.f511186c != null) goto L6;
        this.f511186c = LayoutInflater.from(this.f511184a).inflate(R.layout.auto_run_dialog_view, null);
    L6:
        if (this.f511187d != null) goto L8;
        Dialog r100 = new Dialog(this.f511184a, R.style.loading_dialog);
        this.f511187d = r100;
        Intrinsics.checkNotNull(r100);
        View r101 = this.f511186c;
        Intrinsics.checkNotNull(r101);
        r100.setContentView(r101, new ViewGroup.LayoutParams(-1, -1));
    L8:
        Dialog r102 = this.f511187d;
        Intrinsics.checkNotNull(r102);
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r102);
    L13:
        Dialog r103 = this.f511187d;
        Intrinsics.checkNotNull(r103);
        r103.setOnCancelListener(new b(this));
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        goto L13
    }

    public h(Context r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "dialogListener");
        this.f511184a = r100;
        this.f511185b = r101;
    }
}
