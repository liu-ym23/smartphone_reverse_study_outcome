package r05;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.larksuite.framework.ui.BaseDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final Map<String, Integer> c = null;
    public BaseDialog a;
    public final List<View> b;

    public interface a {
        void a(String r1);
    }

    /* JADX INFO: renamed from: r05.b$b, reason: collision with other inner class name */
    public static final class C0281b {
    }

    static {
        c = MapsKt.hashMapOf(new Pair[]{new Pair("PUBLISH_ANNOUNCEMENT", 2131237714), new Pair("HISTORY_RECORD", 2131254879), new Pair("DISASSOCIATE_DOC", 2131256059)});
    }

    public final void a() {
        BaseDialog r0 = this.a;
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.isShowing() != true) goto L7;
    L8:
        if (r1 == false) goto L33;
        BaseDialog r2 = this.a;
        if (r2 == null) goto L28;
        Handler r3 = DialogLancet.resolveDialogHandler(r2);
        if (r3 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r2);
        r2.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r2);
        goto L28
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r2);
        throw th;
    L21:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r4 == null) goto L25;
        d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r3.getLooper()) goto L16;
        r3.post(DialogLancet.createDismissRunnable(r2));
    L28:
        this.a = null;
        return;
    L33:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public b() {
        this.b = new ArrayList();
    }
}
