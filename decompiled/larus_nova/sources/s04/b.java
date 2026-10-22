package s04;

import android.content.Context;
import android.net.Uri;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfigBuilder;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements s04.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // s04.a
    public final boolean a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return Intrinsics.areEqual(r100.getPath(), "/profile");
    }

    @Override // s04.a
    public final void b(Context r110, Uri r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        String r100 = UriProtector.getQueryParameter(r111, "user_open_id");
        String r101 = "";
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = UriProtector.getQueryParameter(r111, "enter_from");
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if ((!r104) == true) goto L17;
        r103 = null;
    L17:
        String r105 = "outer_schema";
        if (r103 != null) goto L20;
        r103 = "outer_schema";
    L20:
        String r106 = UriProtector.getQueryParameter(r111, "enter_from_merge");
        if (r106 != null) goto L23;
        r106 = "";
    L23:
        String r107 = UriProtector.getQueryParameter(r111, "enter_method");
        if (r107 != null) goto L26;
    L29:
        boolean r108 = true;
    L31:
        if ((!r108) == true) goto L34;
        r107 = null;
    L34:
        if (r107 == null) goto L37;
        r105 = r107;
    L37:
        String r109 = UriProtector.getQueryParameter(r111, "request_id");
        if (r109 == null) goto L41;
        r101 = r109;
    L41:
        String r112 = UriProtector.getQueryParameter(r111, "action_type");
        if (r112 != null) goto L44;
        r112 = "click";
    L44:
        String r113 = UriProtector.getQueryParameter(r111, "host_extra_params");
        if (r113 != null) goto L54;
        JSONObject r114 = null;
    L52:
        int r115 = vz3.a.f557701a;
        ProfilePageConfigBuilder.Companion.getClass();
        ProfilePageConfigBuilder r116 = new ProfilePageConfigBuilder().withOpenId(r102);
        HostEventParameters r117 = new HostEventParameters();
        r117.setEnterFrom(r103);
        r117.setEnterFromMerge(r106);
        r117.setEnterMethod(r105);
        r117.setImpr(r101);
        Unit r118 = Unit.INSTANCE;
        vz3.a.a(r110, r116.withHostEventParameters(r117).build(), null);
        d14.a r119 = b14.a.f16924a;
        t24.a.C7679a.f((t24.a) b14.a.a(t24.a.class), r103, r105, r102, r101, null, r112, false, r114, 164096);
        return;
    L54:
        JSONObject r120 = new JSONObject(r113);     // Catch: Throwable -> L48
    L50:
        r114 = r120;
    L48:
        th = move-exception;
        AoLogger.c("ProfileSchemaHandler", new Object[]{th});
        r120 = null;
        goto L50
    L26:
        if (r107.length() == 0) goto L29;
        r108 = false;
        goto L31
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
        goto L14
    L5:
        r102 = r100;
        goto L6
    }
}
