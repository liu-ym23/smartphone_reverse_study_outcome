package l36;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.s;
import com.bytedance.ies.bullet.service.base.t;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.api.FailedBinderCallBack;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import q26.k;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends s26.a implements t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f507262b;

    @Override // com.bytedance.ies.bullet.service.base.t
    public final s getPageConfig() {
        return this.f507262b;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "pageConfig");
        this.f507262b = r100;
    }

    @Override // q26.f
    public final boolean u0(Context r100, Uri r101, k r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r110, "config");
        Class<? extends Activity> r102 = this.f507262b.b();
        boolean r103 = false;
        if (r102 != null) goto L5;
        return false;
    L5:
        Intent r104 = new Intent();
        r104.setComponent(new ComponentName(r100, r102));
        r104.setData(r101);
        boolean r105 = r100 instanceof Activity;
        if (r105 == true) goto L8;
        r104.addFlags(268435456);
    L8:
        Integer r106 = r110.f531445a;
        if (r106 == null) goto L11;
        r104.addFlags(r106.intValue());
    L11:
        Unit r107 = null;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L20
        String r109 = UriProtector.getQueryParameter(r101, "url");     // Catch: Throwable -> L20
        if (r109 == null) goto L17;
        Uri r111 = UriProtector.parse(r109);     // Catch: Throwable -> L20
        if (r111 == null) goto L17;
        String r112 = UriProtector.getQueryParameter(r111, "ug_campaign_launch_mode");     // Catch: Throwable -> L20
    L18:
        Object r113 = Result.m9449constructorimpl(r112);     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r113) == false) goto L25;
        r113 = null;
    L25:
        String r114 = (String) r113;
        if (Intrinsics.areEqual(r114, "clear_top") == false) goto L28;
        Integer r115 = 67108864;
    L31:
        if (r115 == null) goto L33;
        r104.addFlags(r115.intValue());
    L33:
        r104.putExtras(r110.f531448d);
        if (r105 == false) goto L44;
        Integer r116 = r110.f531450f;
        if (r116 == null) goto L44;
        int r117 = r116.intValue();
        Bundle r118 = r110.f531449e;
        if (r118 == null) goto L40;
        ((Activity) r100).startActivityForResult(r104, r117, r118);
        Unit r119 = Unit.INSTANCE;
    L41:
        if (r119 != null) goto L43;
        ((Activity) r100).startActivityForResult(r104, r117);
    L43:
        r103 = true;
        goto L44
    L40:
        r119 = null;
    L44:
        if (r103 == true) goto L50;
        Bundle r120 = r110.f531449e;
        if (r120 == null) goto L48;
        r100.startActivity(r104, r120);
        r107 = Unit.INSTANCE;
    L48:
        if (r107 != null) goto L50;
        r100.startActivity(r104);
    L50:
        HybridLogger r121 = HybridLogger.f246343a;
        Map r122 = MapsKt.mapOf(TuplesKt.to("url", r101.toString()));
        com.bytedance.ies.bullet.base.utils.logger.a r123 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r123.a("session_id", r110.f531446b);
        r123.a(FailedBinderCallBack.CALLER_ID, r110.f531447c);
        Unit r124 = Unit.INSTANCE;
        HybridLogger.k("XRouter", "create page container successfully", r122, r123);
        return true;
    L28:
        if (r114 == null) goto L30;
        r115 = StringsKt.toIntOrNull(r114);
        goto L31
    L30:
        r115 = null;
    L17:
        r112 = null;
    L20:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
