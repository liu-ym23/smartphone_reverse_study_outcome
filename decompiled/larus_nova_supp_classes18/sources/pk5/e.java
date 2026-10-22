package pk5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.LocationHelper;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements gk5.c {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r13, JSONObject r14, p r15) {
        Intrinsics.checkNotNullParameter(r13, "activity");
        Intrinsics.checkNotNullParameter(r14, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r15, "callback");
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        String r3 = r14.optString("name");     // Catch: Throwable -> L19
        if ((!StringsKt.isBlank(r3)) == false) goto L6;
        String r5 = r3;
    L7:
        String r4 = r14.optString("address");     // Catch: Throwable -> L19
        if ((!StringsKt.isBlank(r4)) == false) goto L10;
        String r6 = r4;
    L12:
        if (r14.has("scale") == true) goto L14;
    L16:
        Integer r7 = null;
    L17:
        Object r16 = Result.constructor-impl(new LocationHelper.OpenLocationRequest(r5, r6, r7, JSONObjectProtectorUtils.getDouble(r14, "latitude"), JSONObjectProtectorUtils.getDouble(r14, "longitude")));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r16) == true) goto L25;
        r1 = r16;
    L25:
        LocationHelper.OpenLocationRequest r8 = (LocationHelper.OpenLocationRequest) r1;
        if (r8 != null) goto L36;
        nk5.b.d(r15, "invalid latitude or longitude");
        return;
    L36:
        LocationHelper.b(r13, r8);     // Catch: Throwable -> L31
        r15.onSuccess(new JSONObject());     // Catch: Throwable -> L31
        return;
    L31:
        th = move-exception;
        nk5.b.c(r15, th);
        return;
    L14:
        if (r14.isNull("scale") == true) goto L16;
        r7 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r14, "scale"));     // Catch: Throwable -> L19
        goto L17
    L10:
        r6 = null;
        goto L12
    L6:
        r5 = null;
    L19:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
