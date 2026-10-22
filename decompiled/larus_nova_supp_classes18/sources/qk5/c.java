package qk5;

import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.PhoneHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.UriProtector;
import com.suite.lark.emm.impl.clipboard.utils.TextViewMenuUtilsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements gk5.c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r5, JSONObject r6, p r7) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r8 = r6.optString("phoneNumber");
        if ((!StringsKt.isBlank(r8)) == true) goto L6;
        r8 = null;
    L6:
        if (r8 != null) goto L9;
        nk5.b.d(r7, "invalid phoneNumber");
        return;
    L9:
        int r3 = PhoneHelper.a;
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r8, "phoneNumber");
        Intent r1 = new Intent("android.intent.action.DIAL");     // Catch: Throwable -> L12
        TextViewMenuUtilsKt.a(r1);     // Catch: Throwable -> L12
        r1.setData(UriProtector.parse("tel:".concat(r8)));     // Catch: Throwable -> L12
        r5.startActivity(r1);     // Catch: Throwable -> L12
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L12
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 != null) goto L17;
        Unit r12 = (Unit) r10;
        r7.onSuccess(new JSONObject());
        return;
    L17:
        nk5.b.c(r7, r11);
        return;
    L12:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }
}
