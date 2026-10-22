package lv3;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public static void a(l0 r3) {
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
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void b(String r3, String r4, String r5, String r6, String r7, String r8) {
        com.larus.platform.service.o r0 = com.larus.platform.service.o.a;
        JSONObject r1 = new JSONObject();
        r1.put("current_page", r6);
        r1.put("to_page", r7);
        r1.put("reason", r8);
        r1.put("hit_strategy", CommentScene.COMMENTSCENE_NO_AWEME);
        r1.put("message_id", r5);
        r1.put("bcm_id", r3);
        r1.put("pid", r4);
        Unit r9 = Unit.INSTANCE;
        r0.reportEvent("enter_ecom_page_detect", r1);
    }
}
