package v38;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.account.impl.b0;
import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import com.larus.account.saas.security.api.IAccountSecurityService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import wqa.i;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements jb7.a {

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // jb7.a
    public final String getName() {
        return "passport_user_ban";
    }

    @Override // jb7.a
    public final boolean b(int r100, Map r101, ua7.b r102, b0 r103) {
        List<i> r104 = r102.f549258l;
        String r105 = null;
        if (r104 == null) goto L14;
        Iterator<T> r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L10;
        Object r107 = r106.next();
        if (StringsKt.equals(((i) r107).f560775a, "x-tt-passport-user-ban", true) == false) goto L6;
    L11:
        i r108 = (i) r107;
        if (r108 == null) goto L14;
        String r109 = r108.f560776b;
    L16:
        if (StringsKt.equals(r109, "1", true) == true) goto L19;
        return false;
    L19:
        if (v38.a.f552948a.get() <= 0) goto L21;
        boolean r110 = true;
    L22:
        if (r110 == false) goto L24;
        return false;
    L24:
        JSONObject r111 = new JSONObject();
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
        Object r113 = Result.m9449constructorimpl(UriProtector.parse(r102.f549250d));     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r113) == false) goto L32;
        r113 = null;
    L32:
        Uri r114 = (Uri) r113;
        if (r114 == null) goto L35;
        String r115 = r114.getPath();
    L36:
        r111.put("path", r115);
        r111.put("logId", r102.f549247a);
        r111.put("scene", "passport");
        SaasTracking.f286464a.reportEvent("doubao_account_banned", r111);
        JSONObject r116 = r102.f549259m;
        if (r116 == null) goto L45;
        JSONObject r117 = r116.optJSONObject("data");
        if (r117 == null) goto L45;
        String r118 = r117.optString("verify_ticket");
        if (r118 == null) goto L45;
        if ((!StringsKt.isBlank(r118)) == false) goto L45;
    L46:
        String r119 = FlowAccountSdk.f().getAccountInfo().f17594b;
        if ((!StringsKt.isBlank(r119)) == false) goto L49;
        r105 = r119;
    L49:
        if (r118 != null) goto L51;
    L54:
        boolean r120 = true;
    L55:
        if (r120 == false) goto L64;
        if (r105 != null) goto L58;
    L61:
        boolean r121 = true;
    L62:
        if (r121 == false) goto L64;
        return false;
    L58:
        if (StringsKt.isBlank(r105) == true) goto L61;
        r121 = false;
    L64:
        IAccountSecurityService.f286489a.b(r118, r105);
        r103.a(false, false, MapsKt.emptyMap());
        return true;
    L51:
        if (StringsKt.isBlank(r118) == true) goto L54;
        r120 = false;
    L45:
        r118 = null;
        goto L46
    L35:
        r115 = null;
    L27:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L21:
        r110 = false;
        goto L22
    L10:
        r107 = null;
    L14:
        r109 = null;
        goto L16
    }
}
