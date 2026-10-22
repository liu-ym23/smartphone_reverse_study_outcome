package com.cmic.sso.sdk.c;

import android.text.TextUtils;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.e.q;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f273374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f273375b;

    public b() {
    }

    public String a() {
        return this.f273374a;
    }

    public com.cmic.sso.sdk.c.c.c a(com.cmic.sso.sdk.c.c.c r100, com.cmic.sso.sdk.c.d.b r101, com.cmic.sso.sdk.a r102) {
        Map<String, List<String>> r103 = r101.b();
        if (TextUtils.isEmpty(this.f273374a) == false) goto L9;
        List<String> r104 = r103.get("pplocation");
        if (r104 == null) goto L9;
        if (r104.isEmpty() == true) goto L9;
        this.f273374a = (String) ListProtector.get(r104, 0);
    L9:
        q.b(r102, String.valueOf(r101.a()));
        List<String> r105 = r103.get("Location");
        if (r105 != null) goto L12;
    L13:
        r105 = r103.get("Location".toLowerCase());
    L14:
        if (r105 != null) goto L16;
    L26:
        com.cmic.sso.sdk.e.c.b("RedirectHandler", "mLocation = " + this.f273375b);
        com.cmic.sso.sdk.c.c.c r106 = a(this.f273375b, r100.f(), "GET", new com.cmic.sso.sdk.c.b.c(r100.j().a()));
        r106.a(r100.g());
        return r106;
    L16:
        if (r105.isEmpty() == true) goto L26;
        String r107 = (String) ListProtector.get(r105, 0);
        this.f273375b = r107;
        if (TextUtils.isEmpty(r107) == true) goto L26;
        String r108 = r102.b(OnekeyLoginConstants.OPERATOR_TYPE, "0");
        if ("2".equals(r108) == false) goto L23;
        q.a(r102, "getUnicomMobile");
        goto L26
    L23:
        if ("3".equals(r108) == false) goto L25;
        q.a(r102, "getTelecomMobile");
        goto L26
    L25:
        q.a(r102, UserProfileEvent.POSITION_NONE);
        goto L26
    L12:
        if (r105.isEmpty() == false) goto L14;
        goto L13
    }

    public com.cmic.sso.sdk.c.c.c b(com.cmic.sso.sdk.c.c.c r100, com.cmic.sso.sdk.c.d.b r101, com.cmic.sso.sdk.a r102) {
        String r103 = r102.b(OnekeyLoginConstants.OPERATOR_TYPE, "0");
        if ("2".equals(r103) == false) goto L6;
        q.a(r102, "getNewUnicomPhoneNumberNotify");
    L9:
        q.b(r102, String.valueOf(r101.a()));
        com.cmic.sso.sdk.c.b.d r104 = new com.cmic.sso.sdk.c.b.d(r100.j().a(), "1.0", r101.c());
        r104.d(r102.b("userCapaid"));
        r104.b(r102.b(OnekeyLoginConstants.OPERATOR_TYPE));
        if (r102.c("logintype") != 3) goto L12;
        r104.c(TeaEventTrack.ACTION_DRAMA_PRE);
    L16:
        com.cmic.sso.sdk.c.c.c r105 = a(this.f273374a, r100.f(), "POST", r104);
        r105.a(r100.g());
        this.f273374a = null;
        return r105;
    L12:
        if (r102.b("isRisk", false) == false) goto L14;
        r104.c(TeaEventTrack.ACTION_DRAMA_PRE);
        goto L16
    L14:
        r104.c("authz");
        goto L16
    L6:
        if ("3".equals(r103) == false) goto L8;
        q.a(r102, "getNewTelecomPhoneNumberNotify");
        goto L9
    L8:
        q.a(r102, UserProfileEvent.POSITION_NONE);
        goto L9
    }

    private com.cmic.sso.sdk.c.c.c a(String r100, String r101, String r102, g r103) {
        com.cmic.sso.sdk.c.c.c r104 = new com.cmic.sso.sdk.c.c.c(r100, r103, r102, r101);
        if (r102.equals("GET") == false) goto L5;
        r104.a("Content-Type", "application/x-www-form-urlencoded");
    L5:
        return r104;
    }
}
