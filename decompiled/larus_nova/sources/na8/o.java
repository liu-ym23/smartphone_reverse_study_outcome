package na8;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public abstract class o extends bx7.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f518476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f518477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gk5.b f518478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gk5.a f518479e;

    public static final class a {
    }

    static {
    }

    public boolean f(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return false;
    }

    @Override // bx7.c, com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void release() {
        i(null);
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final String getName() {
        return this.f518476b;
    }

    public static Map g(JSONObject r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, h(r100.opt(r103)));
        goto L4
    L6:
        return r101;
    }

    public static Object h(Object r100) {
        if (r100 == null) goto L16;
        if (Intrinsics.areEqual(r100, JSONObject.NULL) == true) goto L16;
        if ((r100 instanceof JSONObject) == false) goto L10;
        return g((JSONObject) r100);
    L10:
        if ((r100 instanceof JSONArray) == false) goto L19;
        JSONArray r101 = (JSONArray) r100;
        int r102 = r101.length();
        ArrayList r103 = new ArrayList(r102);
        int r104 = 0;
    L12:
        if (r104 >= r102) goto L20;
        r103.add(h(r101.opt(r104)));
        r104 = r104 + 1;
        goto L12
    L20:
        return r103;
    L19:
        return r100;
    L16:
        return JSONObject.NULL;
    }

    public final void i(gk5.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L18;
    L8:
        Pair r101 = new Pair(this.f518478d, this.f518479e);     // Catch: Throwable -> L15
        this.f518478d = null;     // Catch: Throwable -> L15
        this.f518479e = null;     // Catch: Throwable -> L15
        monitor-exit(this);
        gk5.b r102 = (gk5.b) r101.component1();
        gk5.a r103 = (gk5.a) r101.component2();
        if (r102 == null) goto L20;
        if (r103 == null) goto L21;
        r102.b(r103);
        return;
    L21:
        return;
    L20:
        return;
    L15:
        th = move-exception;
        throw th;
    L18:
        if (this.f518479e == r100) goto L8;
        monitor-exit(this);
    }

    public o(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f518476b = r100;
        this.f518477c = r101;
    }

    @Override // com.ivy.ivykit.api.bridge.core.IvyBridgeMethod
    public final void a(dx7.b r100, ux7.d.C7943d r110, IvyBridgePlatformType r111) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Intrinsics.checkNotNullParameter(r111, "type");
        FLogger r101 = FLogger.f375446a;
        r101.i("OfficeCCMH5JSBMethod", "handle request, method=" + this.f518476b + ", platform=" + r111);
        String r102 = "";
        if (this.f518477c == null) goto L15;
        p56.b r112 = (p56.b) e(p56.b.class);
        if (r112 == null) goto L8;
        String r113 = r112.provideContainerID();
    L9:
        if (r113 == null) goto L13;
        r102 = r113;
    L13:
        if (StringsKt.isBlank(r102) == false) goto L15;
        r101.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.f518476b + ", reason=container_id_unavailable");
        bx7.c.c(this, r110, 0, "container ID unavailable", 8);
        r102 = null;
        goto L15
    L8:
        r113 = null;
    L15:
        if (r102 != null) goto L17;
        return;
    L17:
        Context r114 = (Context) e(Context.class);
        if (r114 == null) goto L21;
        Activity r115 = com.bytedance.ies.xbridge.utils.f.f249557a.getActivity(r114);
        if (r115 == null) goto L21;
    L23:
        if ((r115 instanceof FragmentActivity) == false) goto L25;
        FragmentActivity r116 = (FragmentActivity) r115;
    L26:
        if (r116 != null) goto L28;
    L81:
        r101.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.f518476b + ", reason=activity_unavailable");
        bx7.c.c(this, r110, 0, "activity unavailable", 8);
        return;
    L28:
        if (r116.isFinishing() == false) goto L30;
    L32:
        boolean r103 = false;
    L33:
        if (r103 == false) goto L81;
        Object r104 = xp9.o.f564776a;
        if ((r104 instanceof OfficeSDKUserApi) == false) goto L38;
        OfficeSDKUserApi r105 = (OfficeSDKUserApi) r104;
    L39:
        if (r105 == null) goto L41;
        gk5.d r106 = (gk5.d) r105.getService(gk5.d.class);
    L42:
        if (r106 != null) goto L45;
        r101.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.f518476b + ", reason=service_unavailable");
        bx7.c.c(this, r110, 0, "Office CCM H5 JSB service unavailable", 8);
        return;
    L45:
        gk5.c r107 = r106.Y5(this.f518476b);
        if (r107 != null) goto L50;
        r101.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.f518476b + ", reason=handler_unavailable");
        bx7.c.c(this, r110, 0, "Office CCM H5 JSB handler unavailable", 8);
        return;
    L50:
        if (this.f518477c != null) goto L52;
    L55:
        i(null);
        AtomicBoolean r108 = new AtomicBoolean(false);
        p r109 = new p(r108, this, r110, r102);
        if (this.f518477c != null) goto L58;
    L83:
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L69
        r107.a(r116, new JSONObject(r100.a()), r109);     // Catch: Throwable -> L69
        Object r118 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
    L71:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L87;
        i(r109);
        FLogger r120 = FLogger.f375446a;
        r120.e("OfficeCCMH5JSBMethod", "handle " + this.f518476b + " failed", r119);
        if (r108.compareAndSet(false, true) == false) goto L79;
        String r121 = r119.getMessage();
        if (r121 != null) goto L78;
        r121 = "Office CCM H5 JSB handle failed";
    L78:
        bx7.c.c(this, r110, 0, r121, 8);
        return;
    L79:
        r120.w("OfficeCCMH5JSBMethod", "ignore exception after completion, method=" + this.f518476b);
        return;
    L87:
        return;
    L69:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L71
    L58:
        if ((r107 instanceof gk5.b) == false) goto L83;
        gk5.b r123 = (gk5.b) r107;
        monitor-enter(this);
        this.f518478d = r123;     // Catch: Throwable -> L64
        this.f518479e = r109;     // Catch: Throwable -> L64
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L64
        monitor-exit(this);
    L64:
        th = move-exception;
        throw th;
    L52:
        if ((r107 instanceof gk5.b) == true) goto L55;
        r101.w("OfficeCCMH5JSBMethod", "reject request, method=" + this.f518476b + ", reason=event_handler_unavailable");
        bx7.c.c(this, r110, 0, "Office CCM H5 JSB event handler unavailable", 8);
        return;
    L41:
        r106 = null;
        goto L42
    L38:
        r105 = null;
        goto L39
    L30:
        if (r116.isDestroyed() == true) goto L32;
        r103 = true;
        goto L33
    L25:
        r116 = null;
    L21:
        r115 = AppHost.f326268a.a().getCurrentActivity();
        goto L23
    }
}
