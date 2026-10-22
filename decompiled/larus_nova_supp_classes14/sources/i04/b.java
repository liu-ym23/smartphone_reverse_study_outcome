package i04;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog;
import com.bytedance.awemeopen.domain.user.login.onekey.OneKeyLogin;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements c24.b {
    public b() {
    }

    public final void a(Activity r8, String r9, Map r10, String r11, OneKeyLogin.login.handler.1.a r12) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "loginSource");
        Intrinsics.checkNotNullParameter(r11, "phoneNumber");
        Intrinsics.checkNotNullParameter(r12, "callback");
        d14.a r1 = b14.a.a;
        t24.a r2 = b14.a.a(t24.a.class);
        String r3 = com.bytedance.awemeopen.bizmodels.user.a.a(r9);
        if (r10 != null) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r6 == true) goto L10;
    L12:
        boolean r4 = false;
    L13:
        r2.p1(r3, r4);
        int r5 = PhoneNumberLoginDialog.b;
        a r7 = new a(r12, r9, r10);
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "phoneNumber");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r11, "phoneNumber");
        if ((r8 instanceof Activity) == false) goto L16;
        Activity r13 = r8;
    L17:
        if (r13 != null) goto L19;
        return;
    L19:
        if (r13.isFinishing() == true) goto L32;
        PhoneNumberLoginDialog r14 = new PhoneNumberLoginDialog(r8, r8.getString(2131894249), r8.getString(2131894248, new Object[]{r11}), r7);
        if (DialogLancet.shouldBlockDialogShow(r14) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r14);
        return;
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        DialogLancet.beforeDialogShow(r14);
        r14.show();
        DialogLancet.afterDialogShow(r14);
        return;
    L32:
        return;
    L16:
        r13 = null;
        goto L17
    L10:
        if (Intrinsics.areEqual(r10.get("is_card_mode"), CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L12;
        r4 = true;
        goto L13
    L5:
        if (r10.containsKey("is_card_mode") != true) goto L7;
        r6 = true;
        goto L8
    }
}
