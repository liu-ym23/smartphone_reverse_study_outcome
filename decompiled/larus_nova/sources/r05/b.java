package r05;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.crash.d;
import com.larksuite.framework.ui.BaseDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Integer> f535456c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseDialog f535457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f535458b;

    public interface a {
        void a(String r100);
    }

    /* JADX INFO: renamed from: r05.b$b, reason: collision with other inner class name */
    public static final class C7411b {
    }

    static {
        f535456c = MapsKt.hashMapOf(new Pair[]{new Pair("PUBLISH_ANNOUNCEMENT", Integer.valueOf(R.drawable.icon_announce_outlined_nor)), new Pair("HISTORY_RECORD", Integer.valueOf(R.drawable.ud_icon_history_outlined)), new Pair("DISASSOCIATE_DOC", Integer.valueOf(R.drawable.ud_icon_unbound_group_outlined))});
    }

    public final void a() {
        BaseDialog r100 = this.f535457a;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.isShowing() != true) goto L7;
    L8:
        if (r101 == false) goto L33;
        BaseDialog r102 = this.f535457a;
        if (r102 == null) goto L28;
        Handler r103 = DialogLancet.resolveDialogHandler(r102);
        if (r103 != null) goto L14;
    L16:
        DialogLancet.beforeDialogDismiss(r102);
        r102.dismiss();     // Catch: Throwable -> L19 Exception -> L21
    L25:
        DialogLancet.afterDialogDismiss(r102);
        goto L28
    L19:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r102);
        throw th;
    L21:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L19
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L19
        if (r104 == null) goto L25;
        d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L19
        goto L25
    L14:
        if (Looper.myLooper() == r103.getLooper()) goto L16;
        r103.post(DialogLancet.createDismissRunnable(r102));
    L28:
        this.f535457a = null;
        return;
    L33:
        return;
    L7:
        r101 = false;
        goto L8
    }

    public b() {
        this.f535458b = new ArrayList();
    }
}
