package com.bytedance.applet.aibridge.auth;

import android.app.Application;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.i0;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.y4;
import com.larus.platform.api.z4;
import f3.h;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import t19.s;
import tx9.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements y4 {
    public final /* synthetic */ ISdkDouyinAuth a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ h<AbsOpenAuthDouyinByHostMethodIDL.b> c;

    public static final class a implements z4 {
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ h<AbsOpenAuthDouyinByHostMethodIDL.b> c;

        public final void onSuccess(String r13) {
            Bundle r14 = this.a;
            if (r14 == null) goto L6;
            String r15 = r14.getString("granted_permission");
            if (r15 == null) goto L6;
        L7:
            String r4 = r15;
            w0.d(null, "host", null, 1, r4, null, null, null, null, null, this.b, 3045);
            h<AbsOpenAuthDouyinByHostMethodIDL.b> r0 = this.c;
            Intrinsics.checkNotNullParameter(AbsOpenAuthDouyinByHostMethodIDL.b.class, "<this>");
            AbsOpenAuthDouyinByHostMethodIDL.b r1 = k3.c.a(AbsOpenAuthDouyinByHostMethodIDL.b.class);
            AbsOpenAuthDouyinByHostMethodIDL.b r2 = r1;
            r2.setAuthorized(true);
            r2.setScopes(r15);
            h.a.b(r0, r1);
            return;
        L6:
            r15 = "";
            goto L7
        }

        public a(Bundle r1, JSONObject r2, h<AbsOpenAuthDouyinByHostMethodIDL.b> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(int r18, String r19, String r20, String r21) {
            if (OpenAuthDouyinByHostMethod.a.contains(String.valueOf(r18)) == false) goto L10;
            s r1 = s.a;
            AppHost.Companion r3 = AppHost.a;
            Application r4 = r3.getApplication();
            if (r19 != null) goto L7;
            String r5 = r3.getApplication().getString(2131908252);
        L8:
            r1.getClass();
            s.t(r4, r5);
        L23:
            w0.d(null, "host", null, 0, null, null, null, null, null, null, this.b, 3045);
            h<AbsOpenAuthDouyinByHostMethodIDL.b> r2 = this.c;
            Intrinsics.checkNotNullParameter(AbsOpenAuthDouyinByHostMethodIDL.b.class, "<this>");
            AbsOpenAuthDouyinByHostMethodIDL.b r6 = k3.c.a(AbsOpenAuthDouyinByHostMethodIDL.b.class);
            r6.setAuthorized(false);
            h.a.b(r2, r6);
            return;
        L7:
            r5 = r19;
            goto L8
        L10:
            if (r18 != 4048) goto L12;
            s r7 = s.a;
            AppHost.Companion r8 = AppHost.a;
            Application r9 = r8.getApplication();
            String r10 = r8.getApplication().getString(2131899061);
            r7.getClass();
            s.t(r9, r10);
            w0.a();
            goto L23
        L12:
            s r11 = s.a;
            AppHost.Companion r12 = AppHost.a;
            Application r13 = r12.getApplication();
            if (r19 != null) goto L15;
        L18:
            boolean r14 = true;
        L19:
            if (r14 == false) goto L21;
            String r15 = r12.getApplication().getString(2131907052);
        L22:
            Intrinsics.checkNotNull(r15);
            r11.getClass();
            s.t(r13, r15);
            goto L23
        L21:
            r15 = r19;
            goto L22
        L15:
            if (r19.length() == 0) goto L18;
            r14 = false;
            goto L19
        }
    }

    public final void a(String r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "token");
        ISdkDouyinAuth r0 = this.a;
        List r1 = i0.a;
        r0.g(r5, new a(r6, this.b, this.c));
    }

    public final void onFailure(String r21, String r22) {
        Intrinsics.checkNotNullParameter(r21, "errorMessage");
        if (Intrinsics.areEqual(r22, "-2") == false) goto L5;
        s r2 = s.a;
        AppHost.Companion r1 = AppHost.a;
        s.j(r2, r1.getApplication(), r1.getApplication().getString(2131905280), null, false, 28);
    L5:
        w0.d(null, "host", null, 0, null, null, null, null, null, null, this.b, 3045);
        h<AbsOpenAuthDouyinByHostMethodIDL.b> r3 = this.c;
        Intrinsics.checkNotNullParameter(AbsOpenAuthDouyinByHostMethodIDL.b.class, "<this>");
        AbsOpenAuthDouyinByHostMethodIDL.b r4 = k3.c.a(AbsOpenAuthDouyinByHostMethodIDL.b.class);
        r4.setAuthorized(false);
        h.a.b(r3, r4);
    }

    public d(ISdkDouyinAuth r1, JSONObject r2, h<AbsOpenAuthDouyinByHostMethodIDL.b> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
