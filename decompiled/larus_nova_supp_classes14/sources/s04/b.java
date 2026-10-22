package s04;

import android.content.Context;
import android.net.Uri;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfigBuilder;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements s04.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // s04.a
    public final boolean a(Uri r2) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return Intrinsics.areEqual(r2.getPath(), "/profile");
    }

    @Override // s04.a
    public final void b(Context r13, Uri r14) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "uri");
        String r0 = UriProtector.getQueryParameter(r14, "user_open_id");
        String r1 = "";
        if (r0 != null) goto L5;
        String r5 = "";
    L6:
        String r2 = UriProtector.getQueryParameter(r14, "enter_from");
        if (r2 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if ((!r4) == true) goto L17;
        r2 = null;
    L17:
        String r6 = "outer_schema";
        if (r2 != null) goto L20;
        r2 = "outer_schema";
    L20:
        String r7 = UriProtector.getQueryParameter(r14, "enter_from_merge");
        if (r7 != null) goto L23;
        r7 = "";
    L23:
        String r8 = UriProtector.getQueryParameter(r14, "enter_method");
        if (r8 != null) goto L26;
    L29:
        boolean r9 = true;
    L31:
        if ((!r9) == true) goto L34;
        r8 = null;
    L34:
        if (r8 == null) goto L37;
        r6 = r8;
    L37:
        String r10 = UriProtector.getQueryParameter(r14, "request_id");
        if (r10 == null) goto L41;
        r1 = r10;
    L41:
        String r11 = UriProtector.getQueryParameter(r14, "action_type");
        if (r11 != null) goto L44;
        r11 = PinchEnterMethod.CLICK;
    L44:
        String r15 = UriProtector.getQueryParameter(r14, "host_extra_params");
        if (r15 != null) goto L54;
        JSONObject r12 = null;
    L52:
        int r16 = vz3.a.a;
        ProfilePageConfigBuilder.Companion.getClass();
        ProfilePageConfigBuilder r17 = new ProfilePageConfigBuilder().withOpenId(r5);
        HostEventParameters r3 = new HostEventParameters();
        r3.setEnterFrom(r2);
        r3.setEnterFromMerge(r7);
        r3.setEnterMethod(r6);
        r3.setImpr(r1);
        Unit r18 = Unit.INSTANCE;
        vz3.a.a(r13, r17.withHostEventParameters(r3).build(), null);
        d14.a r19 = b14.a.a;
        t24.a.a.f(b14.a.a(t24.a.class), r2, r6, r5, r1, null, r11, false, r12, 164096);
        return;
    L54:
        JSONObject r20 = new JSONObject(r15);     // Catch: Throwable -> L48
    L50:
        r12 = r20;
    L48:
        th = move-exception;
        AoLogger.c("ProfileSchemaHandler", new Object[]{th});
        r20 = null;
        goto L50
    L26:
        if (r8.length() == 0) goto L29;
        r9 = false;
        goto L31
    L9:
        if (r2.length() == 0) goto L12;
        r4 = false;
        goto L14
    L5:
        r5 = r0;
        goto L6
    }
}
