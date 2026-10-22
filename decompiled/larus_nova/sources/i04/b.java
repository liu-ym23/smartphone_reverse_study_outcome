package i04;

import android.app.Activity;
import androidx.autofill.HintConstants;
import com.bytedance.awemeopen.domain.user.login.dialog.PhoneNumberLoginDialog;
import com.bytedance.awemeopen.domain.user.login.onekey.OneKeyLogin$login$handler$1;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements c24.b {
    public b() {
    }

    @Override // c24.b
    public final void a(Activity r100, String r101, Map r110, String r111, OneKeyLogin$login$handler$1.a r112) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "loginSource");
        Intrinsics.checkNotNullParameter(r111, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r112, "callback");
        d14.a r102 = b14.a.f16924a;
        t24.a r103 = (t24.a) b14.a.a(t24.a.class);
        String r104 = com.bytedance.awemeopen.bizmodels.user.a.a(r101);
        if (r110 != null) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
    L12:
        boolean r106 = false;
    L13:
        r103.p1(r104, r106);
        int r107 = PhoneNumberLoginDialog.f198517b;
        a r108 = new a(r112, r101, r110);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
        if ((r100 instanceof Activity) == false) goto L16;
        Activity r109 = r100;
    L17:
        if (r109 != null) goto L19;
        return;
    L19:
        if (r109.isFinishing() == true) goto L32;
        PhoneNumberLoginDialog r113 = new PhoneNumberLoginDialog(r100, r100.getString(R.string.aos_phone_number_login_title), r100.getString(R.string.aos_phone_number_login_related, new Object[]{r111}), r108);
        if (DialogLancet.shouldBlockDialogShow(r113) == false) goto L28;
        DialogLancet.handleBlockedDialogShow(r113);
        return;
    L28:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        DialogLancet.beforeDialogShow(r113);
        r113.show();
        DialogLancet.afterDialogShow(r113);
        return;
    L32:
        return;
    L16:
        r109 = null;
        goto L17
    L10:
        if (Intrinsics.areEqual(r110.get("is_card_mode"), "1") == false) goto L12;
        r106 = true;
        goto L13
    L5:
        if (r110.containsKey("is_card_mode") != true) goto L7;
        r105 = true;
        goto L8
    }
}
