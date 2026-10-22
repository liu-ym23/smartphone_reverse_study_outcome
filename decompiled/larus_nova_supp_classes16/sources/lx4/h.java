package lx4;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {
    public final Context a;
    public final a b;
    public View c;
    public Dialog d;

    public interface a {
        void dismiss();
    }

    public static final class b implements DialogInterface.OnCancelListener {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r1) {
            this.a.b.dismiss();
        }
    }

    public final void a() {
        if (this.c != null) goto L6;
        this.c = LayoutInflater.from(this.a).inflate(2131558752, null);
    L6:
        if (this.d != null) goto L8;
        Dialog r0 = new Dialog(this.a, 2131954396);
        this.d = r0;
        Intrinsics.checkNotNull(r0);
        View r1 = this.c;
        Intrinsics.checkNotNull(r1);
        r0.setContentView(r1, new ViewGroup.LayoutParams(-1, -1));
    L8:
        Dialog r2 = this.d;
        Intrinsics.checkNotNull(r2);
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(r2);
    L13:
        Dialog r3 = this.d;
        Intrinsics.checkNotNull(r3);
        r3.setOnCancelListener(new b(this));
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L12:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        goto L13
    }

    public h(Context r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "dialogListener");
        this.a = r2;
        this.b = r3;
    }
}
