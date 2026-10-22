package jc4;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public final class m extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f498121n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f498122o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f498123p;

    @Override // jc4.a
    public final boolean b() {
        a r100 = this.f498122o;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.b();
    }

    @Override // jc4.a
    public final boolean d() {
        a r100 = this.f498122o;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.d();
    }

    @Override // jc4.a
    public final String e() {
        a r100 = this.f498122o;
        if (r100 == null) goto L6;
        String r101 = r100.e();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // jc4.a
    public final String g() {
        a r100 = this.f498122o;
        if (r100 == null) goto L6;
        String r101 = r100.g();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // jc4.a
    public int getType() {
        a r100 = this.f498122o;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getType();
    }

    @Override // jc4.a
    public final int c() {
        return this.f498123p;
    }

    public m(String r210) {
        Intrinsics.checkNotNullParameter(r210, "riskInfo");
        this.f498121n = r210;
        this.f498123p = 6000;
        JSONObject r100 = new JSONObject(r210);     // Catch: Exception -> L166
        String r101 = r100.optString("log_id");     // Catch: Exception -> L166
        long r102 = r100.optLong("code");     // Catch: Exception -> L166
        String r110 = r100.optString(PushAction$ESubType.KEY_NAME);     // Catch: Exception -> L166
        String r111 = r100.optString(EffectConfiguration.KEY_REGION);     // Catch: Exception -> L166
        String r103 = r100.optString("maxEVS");     // Catch: Exception -> L166
        String r112 = r100.optString("verify_scene");     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r112, "<set-?>");     // Catch: Exception -> L166
        this.f498095f = r112;     // Catch: Exception -> L166
        if (r100.optInt("h5_popup", 0) != 1) goto L6;
        boolean r113 = true;
    L7:
        this.f498094e = r113;     // Catch: Exception -> L166
        String r114 = r100.optString("replay_data", "");     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r114, "<set-?>");     // Catch: Exception -> L166
        this.f498098i = r114;     // Catch: Exception -> L166
        String r115 = r100.optString("detail", "");     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r115, "<set-?>");     // Catch: Exception -> L166
        this.f498099j = r115;     // Catch: Exception -> L166
        this.f498100k = r102;     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Exception -> L166
        this.f498101l = r110;     // Catch: Exception -> L166
        if (TextUtils.isEmpty(r103) == false) goto L169;
    L12:
        int r104 = r110.hashCode();     // Catch: Exception -> L166
        if (r104 == (-135762164)) goto L28;
        if (r104 == 3600) goto L24;
        if (r104 == 114009) goto L20;
    L30:
        if (r102 != 10000) goto L33;
        g r105 = new g(0);     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Exception -> L166
        r105.f498115o = r110;     // Catch: Exception -> L166
        this.f498122o = r105;     // Catch: Exception -> L166
    L91:
        a r106 = this.f498122o;     // Catch: Exception -> L166
        if (r106 == null) goto L95;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Exception -> L166
        r106.f498093d = r101;     // Catch: Exception -> L166
    L95:
        a r107 = this.f498122o;     // Catch: Exception -> L166
        if (r107 == null) goto L99;
        r107.f498094e = this.f498094e;     // Catch: Exception -> L166
    L99:
        if (r107 == null) goto L102;
        String r108 = this.f498095f;     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r108, "<set-?>");     // Catch: Exception -> L166
        r107.f498095f = r108;     // Catch: Exception -> L166
    L102:
        a r109 = this.f498122o;     // Catch: Exception -> L166
        if (r109 == null) goto L106;
        String r116 = this.f498098i;     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r116, "<set-?>");     // Catch: Exception -> L166
        r109.f498098i = r116;     // Catch: Exception -> L166
    L106:
        a r117 = this.f498122o;     // Catch: Exception -> L166
        if (r117 == null) goto L110;
        String r118 = this.f498099j;     // Catch: Exception -> L166
        Intrinsics.checkNotNullParameter(r118, "<set-?>");     // Catch: Exception -> L166
        r117.f498099j = r118;     // Catch: Exception -> L166
    L110:
        a r119 = this.f498122o;     // Catch: Exception -> L166
        if (r119 == null) goto L114;
        r119.f498100k = r102;     // Catch: Exception -> L166
    L114:
        if (r119 == null) goto L117;
        Intrinsics.checkNotNullParameter(r110, "<set-?>");     // Catch: Exception -> L166
        r119.f498101l = r110;     // Catch: Exception -> L166
    L117:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Exception -> L166
        this.f498093d = r101;     // Catch: Exception -> L166
        if (r111 == null) goto L174;
        int r120 = r111.hashCode();     // Catch: Exception -> L166
        if (r120 == 3179) goto L159;
        if (r120 == 3365) goto L152;
        if (r120 == 3668) goto L145;
        if (r120 == 3755) goto L138;
        if (r120 == 97720) goto L131;
        return;
    L131:
        if (r111.equals("boe") == false) goto L176;
        BdTuringConfig r121 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L166
        if (r121 == null) goto L177;
        r121.setRegionType(BdTuringConfig.RegionType.REGION_BOE);     // Catch: Exception -> L166
        return;
    L177:
        return;
    L176:
        return;
    L138:
        if (r111.equals("va") == false) goto L179;
        BdTuringConfig r122 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L166
        if (r122 == null) goto L180;
        r122.setRegionType(BdTuringConfig.RegionType.REGION_USA_EAST);     // Catch: Exception -> L166
        return;
    L180:
        return;
    L179:
        return;
    L145:
        if (r111.equals(EnvConst$GEO.SG) == false) goto L182;
        BdTuringConfig r123 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L166
        if (r123 == null) goto L183;
        r123.setRegionType(BdTuringConfig.RegionType.REGION_SINGAPOER);     // Catch: Exception -> L166
        return;
    L183:
        return;
    L182:
        return;
    L152:
        if (r111.equals("in") == false) goto L185;
        BdTuringConfig r124 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L166
        if (r124 == null) goto L186;
        r124.setRegionType(BdTuringConfig.RegionType.REGION_INDIA);     // Catch: Exception -> L166
        return;
    L186:
        return;
    L185:
        return;
    L159:
        if (r111.equals("cn") == false) goto L188;
        BdTuringConfig r125 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L166
        if (r125 == null) goto L189;
        r125.setRegionType(BdTuringConfig.RegionType.REGION_CN);     // Catch: Exception -> L166
        return;
    L189:
        return;
    L188:
        return;
    L174:
        return;
    L33:
        if (r102 != 20000) goto L60;
        String r126 = r100.optString("mfa_decision", "");     // Catch: Exception -> L166
        if (TextUtils.isEmpty(r126) == true) goto L37;
        this.f498122o = new q(r126, r110);     // Catch: Exception -> L166
        goto L91
    L37:
        String r127 = r100.optString("verify_ticket");     // Catch: Exception -> L166
        String r128 = r100.optString("channel_mobile");     // Catch: Exception -> L166
        String r129 = r100.optString("sms_content");     // Catch: Exception -> L166
        String r130 = r100.optString("mobile");     // Catch: Exception -> L166
        switch(r110.hashCode()) {
            case -797498437: goto L57;
            case 300626556: goto L53;
            case 307350857: goto L49;
            case 312290780: goto L45;
            case 705104230: goto L41;
            default: goto L91;
        };     // Catch: Exception -> L166
    L41:
        if (r110.equals("mobile_up_sms_verify") == false) goto L91;
        this.f498122o = new r(r127, r128, r129);     // Catch: Exception -> L166
        goto L91
    L45:
        if (r110.equals("mobile_sms_verify") == false) goto L91;
        this.f498122o = new b(r127, r130);     // Catch: Exception -> L166
        goto L91
    L49:
        if (r110.equals("mobile_voice_sms_verify") == false) goto L91;
        this.f498122o = new s(r127);     // Catch: Exception -> L166
        goto L91
    L53:
        if (r110.equals("email_verify") == false) goto L91;
        this.f498122o = new d(r127);     // Catch: Exception -> L166
        goto L91
    L57:
        if (r110.equals("pwd_verify") == false) goto L91;
        this.f498122o = new k(r127);     // Catch: Exception -> L166
        goto L91
    L60:
        if (r102 != 30000) goto L67;
        String r131 = r100.optString("identity_scene");     // Catch: Exception -> L166
        String r211 = r100.optString(BytedCertConstant.CertKey.FLOW);     // Catch: Exception -> L166
        String r212 = r100.optString("identity_action");     // Catch: Exception -> L166
        String r213 = r100.optString("detail", "");     // Catch: Exception -> L166
        String r214 = r100.optString("identity_ticket", "");     // Catch: Exception -> L166
        String r215 = r100.optString(PushAction$ESubType.KEY_NAME, "");     // Catch: Exception -> L166
        long r132 = r100.optLong("aid", 0);     // Catch: Exception -> L166
        if (r100.optBoolean("identity_no_need_popups", false) == true) goto L64;
        boolean r216 = true;
    L65:
        this.f498122o = new f(r132, r131, r211, r212, r213, r214, r216, r215);     // Catch: Exception -> L166
        goto L91
    L64:
        r216 = false;
        goto L65
    L67:
        if (r102 != ShareImageDataPlugin.TRANSFER_TIMEOUT) goto L91;
        switch(r110.hashCode()) {
            case -520509031: goto L87;
            case 3322092: goto L84;
            case 103149417: goto L75;
            case 1733167236: goto L72;
            default: goto L91;
        };     // Catch: Exception -> L166
    L72:
        if (r110.equals("nocaptcha_collect") == false) goto L91;
    L89:
        this.f498122o = new n(r110, r100.optString("detail"));     // Catch: Exception -> L166
        goto L91
    L75:
        if (r110.equals("login") == false) goto L91;
        String r133 = r100.optString("toast", "");     // Catch: Exception -> L166
        r133 = URLDecoder.decode(r133, "UTF-8");     // Catch: Exception -> L80
    L82:
        this.f498122o = new j(r133);     // Catch: Exception -> L166
        goto L91
    L80:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L166
        goto L82
    L84:
        if (r110.equals("live") == false) goto L91;
        this.f498122o = new i(r100.optString("detail", ""), r110);     // Catch: Exception -> L166
        goto L91
    L87:
        if (r110.equals("nocaptcha") == true) goto L89;
    L20:
        if (r110.equals("sms") == false) goto L30;
        this.f498122o = new p();     // Catch: Exception -> L166
        goto L91
    L24:
        if (r110.equals("qa") == false) goto L30;
        this.f498122o = new l();     // Catch: Exception -> L166
        goto L91
    L28:
        if (r110.equals("identify") == false) goto L30;
        this.f498122o = new e();     // Catch: Exception -> L166
        goto L91
    L169:
        this.f498123p = CastIntegerProtector.parseInt(r103);     // Catch: Exception -> L11
    L11:
        this.f498123p = 6000;     // Catch: Exception -> L166
        goto L12
    L6:
        r113 = false;
    L166:
        e = move-exception;
        int r134 = qb4.n.f532367a;
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
    }

    @Override // jc4.a
    public final void a(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "queryBuilder");
        a r101 = this.f498122o;
        if (r101 == null) goto L5;
        r101.a(r100);
    L5:
        hc4.f.c(r100, "verify_data", this.f498121n);
    }
}
