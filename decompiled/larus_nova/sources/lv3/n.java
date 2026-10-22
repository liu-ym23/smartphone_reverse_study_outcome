package lv3;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.base.api.ai.conversation.ConversationConstants;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f510919a = null;

    static {
        f510919a = new n();
    }

    public n() {
    }

    public static void a(l0 r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L10;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105) {
        com.larus.platform.service.o r106 = com.larus.platform.service.o.f365780a;
        JSONObject r107 = new JSONObject();
        r107.put("current_page", r103);
        r107.put("to_page", r104);
        r107.put("reason", r105);
        r107.put("hit_strategy", "1");
        r107.put(MusicAppletPage.KEY_MESSAGE_ID, r102);
        r107.put(ConversationConstants.KEY_BCM_ID, r100);
        r107.put("pid", r101);
        Unit r108 = Unit.INSTANCE;
        r106.reportEvent("enter_ecom_page_detect", r107);
    }
}
