package com.bytedance.ug.sdk.share.impl.manager;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import java.util.Iterator;
import java.util.List;
import oo7.r;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f272313a;

    /* JADX INFO: renamed from: com.bytedance.ug.sdk.share.impl.manager.a$a, reason: collision with other inner class name */
    public static class C3811a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f272314a = null;

        static {
            f272314a = new a();
        }
    }

    public a() {
        h.g.f272345a.getClass();
    }

    public final String a(String r110, boolean r111) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return null;
    L5:
        ko7.c r100 = ko7.c.b.f504529a;
        h r101 = h.g.f272345a;
        if (TextUtils.isEmpty(r101.f272334i) == false) goto L8;
        r101.f272334i = bo7.a.C0322a.f19870a.f19869a.b("token_regex", "€[0-9A-Za-z]{5}€[0-9A-Za-z]{6}");
    L8:
        String r102 = ko7.c.a(r110, r101.f272334i);
        if (TextUtils.isEmpty(r102) == false) goto L19;
        List<TokenRefluxInfo> r103 = r101.d();
        if (r103 == null) goto L19;
        if (r103.size() <= 0) goto L19;
        Iterator<TokenRefluxInfo> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L19;
        TokenRefluxInfo r105 = r104.next();
        ko7.c r106 = ko7.c.b.f504529a;
        r102 = ko7.c.a(r110, r105.getToken());
        if (TextUtils.isEmpty(r102) == true) goto L16;
    L19:
        int r107 = 1;
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r102) == false) goto L23;
        int r109 = 0;
    L24:
        r108.put("result", r109);     // Catch: Exception -> L26
        r108.put("command", r102);     // Catch: Exception -> L26
        r.c("check command with server token reg", "reflow", r108, r.f524639a);     // Catch: Exception -> L26
        goto L28
    L23:
        r109 = 1;
    L28:
        if (TextUtils.isEmpty(r102) == false) goto L40;
        if (((Boolean) eo7.a.b.f473353a.c("enable_new_token_rule", Boolean.FALSE)).booleanValue() == false) goto L40;
        oo7.k.e("ClipBoardCheckerManager", "checkTokenByNewRules(), isLoadedNewRuleLibrary is false ");
        if (r111 == false) goto L42;
        this.f272313a = r110;
        oo7.k.a("ClipBoardCheckerManager", "checkTokenByNewRules(), mNewRuleTokenPending = " + this.f272313a);
    L42:
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L41
        if (TextUtils.isEmpty(null) == false) goto L37;
        r107 = 0;
    L37:
        r112.put("result", r107);     // Catch: Exception -> L41
        r112.put("command", null);     // Catch: Exception -> L41
        r.c("check command with client token reg", "reflow", r112, r.f524639a);     // Catch: Exception -> L41
        return null;
    L50:
        return null;
    L40:
        return r102;
    }
}
