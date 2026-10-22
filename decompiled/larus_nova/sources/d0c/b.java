package d0c;

import android.app.Application;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.y;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import dagger.hilt.android.internal.Contexts;
import e0c.k;
import e0c.l;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class b {
    public static m a(c r100) {
        return (m) k.b(r100.provideComponent(), m.class);
    }

    public static l b(c r100) {
        UserSession r101 = r100.e9();
        Application r102 = Contexts.getApplication(d.a(r100).getApplicationContext());
        Intrinsics.checkNotNull(r102);
        l r103 = ((v) k.a(r102, v.class)).c(r101);
        UserSession r104 = ((m) k.b(r103, m.class)).getSession();
        if (y.a(r101.f438138b) == false) goto L5;
    L18:
        return r103;
    L5:
        if (y.a(r104.f438138b) == false) goto L18;
        int r105 = m0c.c.f511551a;
        Intrinsics.checkNotNullParameter(r102, "app");
        Intrinsics.checkNotNullParameter(r100, "scopeView");
        Intrinsics.checkNotNullParameter(r101, "userSession");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r107 = new JSONObject();     // Catch: Throwable -> L9
        r107.put("scenario", "user_container_not_found");     // Catch: Throwable -> L9
        r107.put("payload1", r100.getClass().getSimpleName());     // Catch: Throwable -> L9
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r108) == false) goto L14;
        r108 = null;
    L14:
        JSONObject r109 = (JSONObject) r108;
        if (r109 == null) goto L17;
        ((o5c.b) k.a(r102, o5c.b.class)).sendEvent("lark_user_container_runtime_defect_dev", r109);
    L17:
        Log.w("passport_container", "[lark_user_container_runtime_defect_dev](scenario: user_container_not_found, view_simple_name: " + r100.getClass().getSimpleName() + ", uid: " + r101.f438138b + ", view_full_name: " + r100.getClass().getCanonicalName() + ')');
    L9:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
