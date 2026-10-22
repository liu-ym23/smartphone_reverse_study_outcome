package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.flow.performance.thermal.SystemBatteryRecoder;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.account.PassportExtraHeaderManager;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import com.ss.android.token.TTTokenMonitor;
import com.ss.android.token.TokenFactory;
import com.tencent.connect.common.Constants;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import ua7.b;

/* JADX INFO: loaded from: classes.dex */
public final class j<T extends ua7.b> implements WeakHandler.IHandler, ta7.f {

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static cra.a[] f269009h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static volatile j f269010k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final List<d1> f269011p1 = null;
    public final s A;
    public final t B;
    public final u C;
    public final v D;
    public final w E;
    public final x F;
    public final y G;
    public final z H;
    public final w0 H0;
    public final a0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final b0 f269012J;
    public final c0 K;
    public final d0 L;
    public Context L0;
    public final e0 M;
    public final g0 N;
    public final h0 O;
    public final i0 P;
    public final SharedPreferences P0;
    public final j0 Q;
    public final k0 R;
    public final l0 S;
    public final m0 T;
    public final n0 U;
    public final o0 V;
    public final WeakHandler V0;
    public final p0 W;
    public final r0 X;
    public final s0 Y;
    public final t0 Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f269013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f269014b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final Set<ta7.c> f269015b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f269016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0 f269017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y0 f269018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final z0 f269019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a1 f269020g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public volatile String f269021g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1 f269022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c1 f269023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f269024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f269025k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final u0 f269026k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f269027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f269028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f269029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f269030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final g f269031p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final v0 f269032p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final h f269033q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final i f269034r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final C3759j f269035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final l f269036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m f269037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final n f269038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final o f269039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final p f269040x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final q f269041y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final r f269042z;

    public class a extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269043d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269043d.P0.getInt("user_gender", 0));
        }

        public a(j r100) {
            this.f269043d = r100;
        }
    }

    public class a0 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269044d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269044d.P0.getInt("country_code", 0));
        }

        public a0(j r100) {
            this.f269044d = r100;
        }
    }

    public class a1 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269045d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269045d.P0.getInt("can_be_found_by_phone", 1));
        }

        public a1(j r100) {
            this.f269045d = r100;
        }
    }

    public class b extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269046d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269046d.P0.getString("user_industry", "");
        }

        public b(j r100) {
            this.f269046d = r100;
        }
    }

    public class b0 extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269047d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269047d.P0.getBoolean("is_new_user", false));
        }

        public b0(j r100) {
            this.f269047d = r100;
        }
    }

    public class b1 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269048d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269048d.P0.getString("user_description", "");
        }

        public b1(j r100) {
            this.f269048d = r100;
        }
    }

    public class c extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269049d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269049d.P0.getInt("is_blocked", 0));
        }

        public c(j r100) {
            this.f269049d = r100;
        }
    }

    public class c0 extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269050d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269050d.P0.getBoolean("is_login", false));
        }

        public c0(j r100) {
            this.f269050d = r100;
        }
    }

    public class c1 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269051d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269051d.P0.getString("user_email", "");
        }

        public c1(j r100) {
            this.f269051d = r100;
        }
    }

    public class d extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269052d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269052d.P0.getInt("is_blocking", 0));
        }

        public d(j r100) {
            this.f269052d = r100;
        }
    }

    public class d0 extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269053d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269053d.P0.getBoolean("user_has_pwd", false));
        }

        public d0(j r100) {
            this.f269053d = r100;
        }
    }

    public interface d1 {
        void a(ua7.b r100, com.bytedance.sdk.account.impl.f0 r101);
    }

    public class e extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269054d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269054d.P0.getBoolean("is_recommend_allowed", false));
        }

        public e(j r100) {
            this.f269054d = r100;
        }
    }

    public class e0 extends com.bytedance.sdk.account.utils.i<Long> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269055d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Long b() {
            return Long.valueOf(this.f269055d.P0.getLong("pgc_mediaid", 0));
        }

        public e0(j r100) {
            this.f269055d = r100;
        }
    }

    public static class e1 implements d1 {
        public e1() {
        }

        @Override // com.bytedance.sdk.account.impl.j.d1
        public final void a(ua7.b r110, com.bytedance.sdk.account.impl.f0 r111) {
            if (r110.f549261o == 10001) goto L5;
            return;
        L5:
            if (r110.f549249c == false) goto L61;
            j r100 = j.m(com.ss.android.account.k.d().getApplicationContext());
            Long r101 = Long.valueOf(r100.getUserId());
            boolean r102 = false;
            r100.a(false);
            PassportExtraHeaderManager.f406212m.getClass();
            PassportExtraHeaderManager r103 = PassportExtraHeaderManager.f406211l;
            if (r103 == null) goto L43;
            com.bytedance.sdk.account.settings.common.b.a();
            if (com.bytedance.sdk.account.settings.common.b.f269404b == false) goto L43;
            if (r103.f406222j == false) goto L43;
            r103.h();
            Object r104 = r103.f406215c;
            monitor-enter(r104);
            com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L40
            int r105 = com.bytedance.sdk.account.settings.common.b.f269408f;     // Catch: Throwable -> L40
            AuthTokenMultiProcessSharedProvider.a r106 = r103.f406221i.b();     // Catch: Throwable -> L40
            if (r105 <= 0) goto L19;
            SharedPreferences.Editor r107 = r103.b().edit();     // Catch: Throwable -> L40
        L20:
            LinkedHashMap r108 = new LinkedHashMap();     // Catch: Throwable -> L40
            com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L40
            Iterator<String> r109 = com.bytedance.sdk.account.settings.common.b.f269407e.f269551c.iterator();     // Catch: Throwable -> L40
        L22:
            if (r109.hasNext() == false) goto L30;
            String r112 = r109.next();     // Catch: Throwable -> L40
            if (r103.f406213a.containsKey(r112) == false) goto L29;
            r103.f406213a.remove(r112);     // Catch: Throwable -> L40
            r106.f449628b.putNull(r112);     // Catch: Throwable -> L40
            if (r107 == null) goto L28;
            r107.remove(r112);     // Catch: Throwable -> L40
        L28:
            r102 = true;
        L29:
            r108.put(r112, "");     // Catch: Throwable -> L40
            goto L22
        L30:
            if (r102 == false) goto L37;
            r103.f406214b++;     // Catch: Throwable -> L40
            int r113 = r103.f406214b;     // Catch: Throwable -> L40
            r106.f449628b.put("passport_extra_header_modify_flag", Integer.valueOf(r113));     // Catch: Throwable -> L40
            r106.a();     // Catch: Throwable -> L40
            if (r107 == null) goto L34;
            r107.putInt("passport_extra_header_modify_flag", r113);     // Catch: Throwable -> L40
        L34:
            if (r107 == null) goto L36;
            r107.apply();     // Catch: Throwable -> L40
        L36:
            r103.a("logout_clean", r113, r108);     // Catch: Throwable -> L40
        L37:
            Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L40
            monitor-exit(r104);
            goto L43
        L19:
            r107 = null;
        L40:
            th = move-exception;
            throw th;
        L43:
            TTTokenMonitor.o(r101, 0L, TTTokenMonitor.a(r110.f549250d), "logout");
            String r115 = "";
            if ((r110 instanceof ua7.c) == false) goto L46;
            r115 = ((ua7.c) r110).f549262p;
        L46:
            ta7.b r116 = new ta7.b(1);
            if (TextUtils.isEmpty(r115) == true) goto L50;
            r115.getClass();
        L50:
            ua7.a<T> r117 = r111.f268992a;
            if (r117 == null) goto L53;
            r116.f545199e = r117.onSendBDAccountEvent(r111.f268993b);
        L53:
            r100.e(r116);
            return;
        }
    }

    public class f extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269056d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269056d.P0.getBoolean("is_toutiao", false));
        }

        public f(j r100) {
            this.f269056d = r100;
        }
    }

    public class f0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269057d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269057d.P0.getString("area", "");
        }

        public f0(j r100) {
            this.f269057d = r100;
        }
    }

    public static class f1 implements d1 {
        public f1() {
        }

        @Override // com.bytedance.sdk.account.impl.j.d1
        public final void a(ua7.b r100, com.bytedance.sdk.account.impl.f0 r101) {
            Context r102 = com.ss.android.account.k.d().getApplicationContext();
            if ((r100 instanceof ua7.g) == false) goto L17;
            ua7.g r103 = (ua7.g) r100;
            if (r100.f549249c == false) goto L7;
            Bundle r104 = new Bundle();
            r104.putString("access_token", r103.f549270r);
            r104.putLong("expires_in", r103.f549271s);
            r104.putLong("refresh_time", r103.f549276x);
            r104.putString(Constants.JumpUrlConstants.URL_KEY_OPENID, r103.f549272t);
            r104.putString(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r103.f549275w);
            StringBuilder r105 = new StringBuilder("ThirdTokenHandler.handle: api=");
            r105.append(r100.f549261o);
            r105.append(", updatePlatformInfo. resp=");
            r105.append("ThirdTokenResponse{platformName='" + r103.f549268p + "', platformAppId=" + r103.f549269q + ", accessToken='" + cra.a.d(r103.f549270r) + "', expiresIn=" + r103.f549271s + ", openId='" + cra.a.d(r103.f549272t) + "', scopes='" + r103.f549275w + "'}");
            tb7.a.a("BDAccountManager", r105.toString());
            j.m(r102).y(r103.f549268p, r103.f549269q, r104);
            return;
        L7:
            int r106 = r103.f549253g;
            if (r106 != 1058) goto L10;
        L11:
            tb7.a.a("BDAccountManager", "ThirdTokenHandler.handle: api=" + r100.f549261o + ", clearPlatformInfoInner. errCode=" + r103.f549253g);
            j r107 = j.m(r102);
            String r108 = r103.f549268p;
            int r109 = r103.f549269q;
            if (r103.f549253g != 1058) goto L14;
            boolean r110 = true;
        L15:
            j.h(r107, r108, r109, r110);
            return;
        L14:
            r110 = false;
            goto L15
        L10:
            if (r106 == 1059) goto L11;
            return;
        }
    }

    public class g extends com.bytedance.sdk.account.utils.i<Long> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269058d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Long b() {
            return Long.valueOf(this.f269058d.P0.getLong(AppConstants.BUNDLE_MEDIA_ID, 0));
        }

        public g(j r100) {
            this.f269058d = r100;
        }
    }

    public class g0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269059d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269059d.P0.getString("pgc_avatar_url", "");
        }

        public g0(j r100) {
            this.f269059d = r100;
        }
    }

    public static class g1 implements d1 {
        public g1() {
        }

        @Override // com.bytedance.sdk.account.impl.j.d1
        public final void a(ua7.b r310, com.bytedance.sdk.account.impl.f0 r311) {
            if ((r310 instanceof ua7.h) == false) goto L6;
            sc7.a r100 = ((ua7.h) r310).f549279p;
        L14:
            sc7.a r101 = r100;
        L16:
            if (r101 == null) goto L322;
            long r102 = j.f269010k1.getUserId();
            ua7.a<T> r103 = r311.f268992a;
            if (r103 == null) goto L20;
            Map<String, String> r104 = r103.onSendBDAccountEvent(r310);
        L21:
            String r105 = "";
            String r106 = "";
            StringBuilder r107 = new StringBuilder();
            List<wqa.i> r108 = r310.f549258l;
            if (r108 != null) goto L24;
        L42:
            String r312 = r106;
            String r109 = r105;
            j r110 = j.f269010k1;
            boolean r111 = !TextUtils.isEmpty(r312);
            r110.getClass();
            long r112 = r101.f541360a;
            int r113 = r101.f541361b;
            boolean r114 = false;
            if (r113 != 0) goto L45;
        L47:
            boolean r115 = false;
        L49:
            if (r112 <= 0) goto L51;
            r110.U.c(r101);
            if (r110.K.a().booleanValue() == true) goto L66;
            r110.K.c(Boolean.TRUE);
            CookieSyncManager.getInstance().sync();     // Catch: Throwable -> L62
        L64:
            r115 = true;
        L62:
            th = move-exception;
            th.printStackTrace();
        L66:
            if (r101.f541366g == false) goto L69;
            r110.f269012J.c(Boolean.TRUE);
        L69:
            if (r110.B.a().longValue() == r112) goto L71;
            r110.B.c(Long.valueOf(r112));
            r115 = true;
            boolean r116 = true;
        L73:
            if (StringUtils.equal(r110.D.a(), r101.f541370k) == true) goto L76;
            r110.D.c(r101.f541370k);
            new gc7.e(r101.f541360a + "", r101.f541364e, r110.L0).b();
            r115 = true;
        L76:
            if (StringUtils.equal(r110.G.a(), r101.f541367h) == true) goto L79;
            r110.G.c(r101.f541367h);
            r115 = true;
            r116 = true;
        L79:
            if (StringUtils.equal(r110.f269033q.a(), r101.f541368i) == true) goto L82;
            r110.f269033q.c(r101.f541368i);
            r115 = true;
        L82:
            if (StringUtils.equal(r110.f269023i.a(), r101.f541369j) == true) goto L84;
            r110.f269023i.c(r101.f541369j);
            r115 = true;
        L84:
            boolean r117 = r110.L.a().booleanValue();
            boolean r118 = r101.f541371l;
            if (r117 == r118) goto L87;
            r110.L.c(Boolean.valueOf(r118));
            r115 = true;
        L87:
            int r119 = r110.I.a().intValue();
            int r120 = r101.f541365f;
            if (r119 == r120) goto L90;
            r110.I.c(Integer.valueOf(r120));
            r115 = true;
        L90:
            boolean r121 = r110.T.a().booleanValue();
            boolean r122 = r101.f541372m;
            if (r121 == r122) goto L93;
            r110.T.c(Boolean.valueOf(r122));
            r115 = true;
        L93:
            boolean r123 = r110.W.a().booleanValue();
            boolean r124 = r101.f541373n;
            if (r123 == r124) goto L96;
            r110.W.c(Boolean.valueOf(r124));
            r115 = true;
        L96:
            cra.a[] r125 = r110.Z.a();
            int r126 = r125.length;
            int r127 = 0;
            boolean r128 = false;
        L97:
            if (r127 >= r126) goto L112;
            cra.a r129 = r125[r127];
            boolean r210 = r115;
            boolean r211 = r116;
            cra.a r130 = (cra.a) ((HashMap) r101.f541362c).get(r129.f465119a);
            if (r130 != null) goto L105;
            if (r129.f465120b == false) goto L103;
            r128 = true;
        L103:
            r129.e();
            r125 = r125;
            r126 = r126;
        L111:
            r127 = r127 + 1;
            r125 = r125;
            r115 = r210;
            r116 = r211;
            r126 = r126;
            goto L97
        L105:
            if (r129.f465120b == true) goto L108;
            r129.f465120b = true;
            r128 = true;
        L108:
            r129.f465130l = r130.f465130l;
            r129.f465127i = r130.f465127i;
            r129.f465128j = r130.f465128j;
            r129.f465121c = r130.f465121c;
            r129.f465122d = r130.f465122d;
            r129.f465123e = r130.f465123e;
            r129.f465129k = r130.f465129k;
            r129.f465126h = r130.f465126h;
            r129.f465124f = r130.f465124f;
            r129.f465134p = r130.f465134p;
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.T == 0) goto L111;
            r129.f465132n = r130.f465132n;
            goto L111
        L112:
            boolean r212 = r115;
            boolean r213 = r116;
            if (r128 == false) goto L115;
            r115 = true;
        L117:
            if (r110.Y.a() != null) goto L119;
        L121:
            r110.Y.c(r101.f541375p);
            if ((r101 instanceof com.ss.android.account.d) == false) goto L222;
            com.ss.android.account.d r131 = (com.ss.android.account.d) r101;
            if (StringUtils.equal(r110.f269034r.a(), r131.f406230r) == true) goto L127;
            r110.f269034r.c(r131.f406230r);
            r115 = true;
        L127:
            if (StringUtils.equal(r110.f269035s.a(), r131.f406241u) == true) goto L130;
            r110.f269035s.c(r131.f406241u);
            r115 = true;
        L130:
            if (StringUtils.equal(r110.F.a(), r131.f406242v) == true) goto L132;
            r110.F.c(r131.f406242v);
            r115 = true;
        L132:
            int r132 = r110.f269024j.a().intValue();
            int r133 = r131.K;
            if (r132 == r133) goto L136;
            r110.f269024j.c(Integer.valueOf(r133));
            r115 = true;
        L136:
            if (StringUtils.equal(r110.f269022h.a(), r131.f406231s) == true) goto L139;
            r110.f269022h.c(r131.f406231s);
            r115 = true;
        L139:
            if (StringUtils.equal(r110.f269017d.a(), r131.f406232t) == true) goto L141;
            r110.f269017d.c(r131.f406232t);
            r115 = true;
        L141:
            boolean r134 = r110.E.a().booleanValue();
            boolean r135 = r131.L;
            if (r134 == r135) goto L145;
            r110.E.c(Boolean.valueOf(r135));
            r115 = true;
        L145:
            if (StringUtils.equal(r110.f269019f.a(), r131.M) == true) goto L148;
            r110.f269019f.c(r131.M);
            r115 = true;
        L148:
            if (StringUtils.equal(r110.f269016c.a(), r131.N) == true) goto L151;
            r110.f269016c.c(r131.N);
            r115 = true;
        L151:
            if (StringUtils.equal(r110.f269025k.a(), r131.O) == true) goto L153;
            r110.f269025k.c(r131.O);
            r115 = true;
        L153:
            boolean r136 = r110.f269030o.a().booleanValue();
            boolean r137 = r131.R;
            if (r136 == r137) goto L156;
            r110.f269030o.c(Boolean.valueOf(r137));
            r115 = true;
        L156:
            int r138 = r110.f269028m.a().intValue();
            int r139 = r131.P;
            if (r138 == r139) goto L159;
            r110.f269028m.c(Integer.valueOf(r139));
            r115 = true;
        L159:
            int r140 = r110.f269027l.a().intValue();
            int r141 = r131.Q;
            if (r140 == r141) goto L162;
            r110.f269027l.c(Integer.valueOf(r141));
            r115 = true;
        L162:
            boolean r142 = r110.f269029n.a().booleanValue();
            boolean r143 = r131.f406246z;
            if (r142 == r143) goto L166;
            r110.f269029n.c(Boolean.valueOf(r143));
            r115 = true;
        L166:
            if (StringUtils.equal(r110.f269036t.a(), r131.A) == true) goto L168;
            r110.f269036t.c(r131.A);
            r115 = true;
        L168:
            int r144 = r110.f269020g.a().intValue();
            int r145 = r131.D;
            if (r144 == r145) goto L171;
            r110.f269020g.c(Integer.valueOf(r145));
            r115 = true;
        L171:
            int r146 = r110.f269038v.a().intValue();
            int r147 = r131.F;
            if (r146 == r147) goto L174;
            r110.f269038v.c(Integer.valueOf(r147));
            r115 = true;
        L174:
            int r148 = r110.f269039w.a().intValue();
            int r149 = r131.G;
            if (r148 == r149) goto L177;
            r110.f269039w.c(Integer.valueOf(r149));
            r115 = true;
        L177:
            int r150 = r110.f269037u.a().intValue();
            int r151 = r131.E;
            if (r150 == r151) goto L181;
            r110.f269037u.c(Integer.valueOf(r151));
            r115 = true;
        L181:
            if (StringUtils.equal(r110.A.a(), r131.B) == true) goto L183;
            r110.A.c(r131.B);
            r115 = true;
        L183:
            long r152 = r110.f269031p.a().longValue();
            long r153 = r131.H;
            if (r152 == r153) goto L187;
            r110.f269031p.c(Long.valueOf(r153));
            r115 = true;
        L187:
            if (StringUtils.equal(r110.N.a(), r131.f406244x) == true) goto L190;
            r110.N.c(r131.f406244x);
            r115 = true;
        L190:
            if (StringUtils.equal(r110.O.a(), r131.f406245y) == true) goto L192;
            r110.O.c(r131.f406245y);
            r115 = true;
        L192:
            long r154 = r110.M.a().longValue();
            long r155 = r131.f406243w;
            if (r154 == r155) goto L196;
            r110.M.c(Long.valueOf(r155));
            r115 = true;
        L196:
            if (TextUtils.isEmpty(r110.f269018e.a()) == true) goto L202;
            if (TextUtils.isEmpty(r131.I) == true) goto L202;
            if (StringUtils.equal(r110.f269018e.a(), r131.I) == true) goto L202;
        L209:
            r110.f269018e.c(r131.I);
            r115 = true;
        L210:
            int r156 = r110.P.a().intValue();
            int r157 = r131.f406240J;
            if (r156 == r157) goto L214;
            r110.P.c(Integer.valueOf(r157));
            r115 = true;
        L214:
            if (StringUtils.equal(r110.f269042z.a(), r131.C) == true) goto L216;
            r110.f269042z.c(r131.C);
            r115 = true;
        L216:
            r110.X.c(r131.S);
            int r158 = r110.H0.a().intValue();
            int r159 = r131.T;
            if (r158 == r159) goto L219;
            r110.H0.c(Integer.valueOf(r159));
            r115 = true;
        L219:
            boolean r160 = r110.f269032p0.a().booleanValue();
            boolean r161 = r131.U;
            if (r160 == r161) goto L222;
            r110.f269032p0.c(Boolean.valueOf(r161));
            r115 = true;
        L202:
            if (TextUtils.isEmpty(r110.f269018e.a()) == false) goto L206;
            if (TextUtils.isEmpty(r131.I) == false) goto L209;
        L206:
            if (TextUtils.isEmpty(r110.f269018e.a()) == true) goto L210;
            if (TextUtils.isEmpty(r131.I) == false) goto L210;
        L222:
            r110.K.c(Boolean.TRUE);
            r114 = r213;
            boolean r162 = true;
        L223:
            if (r115 == false) goto L225;
            r110.q();
        L225:
            if (r115 == true) goto L227;
            if (r111 == true) goto L227;
        L238:
            if (r115 == true) goto L325;
        L288:
            if (r114 == false) goto L290;
            j.v(r110.B.a().longValue(), r110.k());
            r110.w("");
            r110.x("");
        L290:
            j r163 = j.f269010k1;
            if (TextUtils.equals(r109, r163.f269026k0.a()) == true) goto L294;
            r163.f269026k0.c(r109);
            SharedPreferences.Editor r164 = r163.P0.edit();
            r164.putString("header_session_id", r163.f269026k0.a());
            SharedPrefsEditorCompat.apply(r164);
            j.v(r163.B.a().longValue(), r163.k());
        L294:
            if (TextUtils.isEmpty(r109) == false) goto L316;
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.f269402z == false) goto L316;
            String r165 = r310.f549250d;
            String r166 = r310.f549247a;
            String r167 = r101.f541367h;
            String r168 = r107.toString();
            long r169 = r101.f541360a;
            HashSet<String> r170 = TTTokenMonitor.f449649b;
            JSONObject r171 = new JSONObject();     // Catch: JSONException -> L314
            r171.put("path", r165);     // Catch: JSONException -> L314
            r171.put(CronetDataStorageAccess.LOGID, r166);     // Catch: JSONException -> L314
            if (r167 != null) goto L301;
        L311:
            String r172 = "";
        L312:
            r171.put("body_session_key", r172);     // Catch: JSONException -> L314
            r171.put(AdDownloadModel.JsonKey.HEADER_KEYS, r168);     // Catch: JSONException -> L314
            r171.put("uid", r169);     // Catch: JSONException -> L314
            com.bytedance.sdk.account.monitor.a.a("passport_response_header_sessionid_miss", r171);     // Catch: JSONException -> L314
            goto L316
        L301:
            if (r167.isEmpty() == true) goto L311;
            int r173 = r167.length();     // Catch: JSONException -> L314
            r172 = "*";
            if (6 >= r173) goto L312;
            StringBuilder r174 = new StringBuilder();     // Catch: JSONException -> L314
            int r175 = 0;
            r174.append(r167, 0, 3);     // Catch: JSONException -> L314
        L307:
            int r176 = r173 - 3;     // Catch: JSONException -> L314
            if (r175 >= (r176 - 3)) goto L310;
            r174.append("*");     // Catch: JSONException -> L314
            r175 = r175 + 1;     // Catch: JSONException -> L314
            goto L307
        L310:
            r174.append(r167, r176, r173);     // Catch: JSONException -> L314
            r172 = r174.toString();     // Catch: JSONException -> L314
        L314:
            e = move-exception;
            tb7.a.c("AccountSDK", "monitorResponseHeaderSessionIdMiss error", e);
        L316:
            long r177 = r101.f541360a;
            if (r102 == r177) goto L356;
            TTTokenMonitor.o(Long.valueOf(r102), Long.valueOf(r177), TTTokenMonitor.a(r310.f549250d), "api");
            return;
        L356:
            return;
        L325:
        L279:
            e = move-exception;
            e.printStackTrace();
        L281:
            kc7.c r178 = null;
        L282:
            gc7.d.f480866a = null;
            gc7.d.f480867b = null;
            if (r178 == null) goto L288;
            com.bytedance.sdk.account.impl.m r179 = new com.bytedance.sdk.account.impl.m();
            com.ss.android.account.k.d().e();
            if (r178.getType() == 7) goto L288;
            new gc7.b(r178, r179).b();
            goto L288
        L241:
            if (gc7.d.f480866a == null) goto L281;
            long r214 = new Date().getTime();     // Catch: Exception -> L279
            JSONObject r180 = r101.f541374o;     // Catch: Exception -> L279
            if (r180 == null) goto L275;
            long r181 = r101.f541360a;     // Catch: Exception -> L279
            String r182 = r101.f541364e;     // Catch: Exception -> L279
            String r183 = r180.optString("screen_name");     // Catch: Exception -> L279
            String r184 = r101.f541374o.optString("avatar_url");     // Catch: Exception -> L279
            if (gc7.d.f480866a.intValue() != 6) goto L260;
            Map<String, cra.a> r185 = r101.f541362c;     // Catch: Exception -> L279
            if (r185 == null) goto L258;
            HashMap r186 = (HashMap) r185;     // Catch: Exception -> L279
            Iterator r187 = r186.keySet().iterator();     // Catch: Exception -> L279
            String r188 = null;
            String r189 = null;
        L250:
            if (r187.hasNext() == false) goto L257;
            String r190 = (String) r187.next();     // Catch: Exception -> L279
            String r215 = r184;
            if (r190.contains(gc7.d.f480867b) == false) goto L256;
            gc7.d.f480867b = r190;     // Catch: Exception -> L279
            cra.a r191 = (cra.a) r186.get(r190);     // Catch: Exception -> L279
            if (r191 == null) goto L256;
            String r192 = r191.f465121c;     // Catch: Exception -> L279
            r188 = r191.f465122d;     // Catch: Exception -> L279
            r189 = r192;
        L256:
            r184 = r215;
            goto L250
        L257:
            String r216 = r184;
        L259:
            String r217 = r183;
            long r218 = r181;
            String r219 = r182;
            String r313 = r188;
            String r314 = r189;
            String r220 = r216;
            kc7.a r315 = null;
        L277:
            r178 = new kc7.c(r214, gc7.d.f480866a.intValue(), gc7.d.f480867b, r218, r219, r220, r217, r313, r314, r315);     // Catch: Exception -> L279
            goto L282
        L258:
            r216 = r184;
            r188 = null;
            r189 = null;
            goto L259
        L260:
            String r221 = r184;
            if (gc7.d.f480866a.intValue() != 1) goto L264;
            gc7.d.f480867b = r101.f541368i;     // Catch: Exception -> L279
            Integer r193 = Integer.valueOf(r101.f541365f);     // Catch: Exception -> L279
            kc7.a r194 = new kc7.a();     // Catch: Exception -> L279
            r194.f502412a = r193;     // Catch: Exception -> L279
        L276:
            r315 = r194;
            r217 = r183;
            r218 = r181;
            r219 = r182;
            r220 = r221;
            r313 = null;
            r314 = null;
            goto L277
        L264:
            if (gc7.d.f480866a.intValue() != 2) goto L266;
        L269:
            int r195 = r101.f541365f;     // Catch: Exception -> L279
            if (TextUtils.isEmpty(gc7.d.f480867b) == false) goto L272;
        L274:
            Integer r196 = Integer.valueOf(r195);     // Catch: Exception -> L279
            r194 = new kc7.a();     // Catch: Exception -> L279
            r194.f502412a = r196;     // Catch: Exception -> L279
            goto L276
        L272:
            if (gc7.d.f480867b.startsWith(Marker.ANY_NON_NULL_MARKER) == false) goto L274;
            gc7.d.f480867b = gc7.d.f480867b.replace(Marker.ANY_NON_NULL_MARKER + r195, "");     // Catch: Exception -> L279
            goto L274
        L266:
            if (gc7.d.f480866a.intValue() == 3) goto L269;
            r194 = null;
            goto L276
        L275:
            r194 = null;
            r183 = null;
            r181 = 0;
            r182 = null;
            r221 = null;
        L227:
            if (r162 == false) goto L229;
            ta7.b r197 = new ta7.e();
        L230:
            r197.f545196b = r162;
            r197.f545199e = r104;
            r197.f545198d = r114;
            tb7.a.d("BDAccountManager", "notifyUserInfoChange(), extra=" + r104);
            Set<ta7.c> r198 = r110.f269015b1;
            monitor-enter(r198);
            Iterator r199 = ((HashSet) r110.f269015b1).iterator();     // Catch: Throwable -> L319
        L234:
            if (r199.hasNext() == false) goto L236;
            ta7.c r1100 = (ta7.c) r199.next();     // Catch: Throwable -> L319
            tb7.a.d("BDAccountManager", "notifyUserInfoChange(), listener=" + r1100.getClass().getName());     // Catch: Throwable -> L319
            r1100.M(r197);     // Catch: Throwable -> L319
            goto L234
        L236:
            monitor-exit(r198);     // Catch: Throwable -> L319
        L319:
            th = move-exception;
            throw th;
        L229:
            r197 = new ta7.b(0);
            goto L230
        L119:
            if (r101.f541374o == null) goto L121;
            r110.Y.a().optJSONObject("data");
            goto L121
        L115:
            r115 = r212;
            goto L117
        L71:
            r116 = false;
            goto L73
        L51:
            if (r110.K.a().booleanValue() == false) goto L56;
            b0 r200 = r110.f269012J;
            Boolean r1101 = Boolean.FALSE;
            r200.c(r1101);
            r110.K.c(r1101);
            r110.B.c(0L);
            r110.D.c("");
            r110.C.c(0);
            r110.f269034r.c("");
            r110.f269024j.c(0);
            r110.f269035s.c("");
            r110.F.c("");
            r110.f269017d.c("");
            r110.f269019f.c("");
            r110.f269016c.c("");
            r110.f269025k.c("");
            r110.A.c("");
            r110.f269022h.c("");
            r110.E.c(r1101);
            r110.f269029n.c(r1101);
            r110.G.c("");
            r110.Q.c(0);
            r110.R.c(0);
            r110.S.c(0);
            r110.f269027l.c(0);
            r110.f269028m.c(0);
            r110.f269030o.c(r1101);
            r110.L.c(r1101);
            r110.f269031p.c(0L);
            r110.f269018e.c("");
            r110.P.c(0);
            r110.N.c("");
            r110.M.c(0L);
            r110.O.c("");
            r110.f269042z.c("");
            r110.T.c(r1101);
            r110.H0.c(0);
            r110.f269032p0.c(r1101);
            r110.Y.c(null);
            r110.X.c(null);
            r110.U.c(null);
            cra.a[] r201 = r110.Z.a();
            int r1102 = r201.length;
            int r1103 = 0;
        L53:
            if (r1103 >= r1102) goto L55;
            r201[r1103].e();
            r1103 = r1103 + 1;
            goto L53
        L55:
            r115 = true;
        L56:
            r162 = false;
            goto L223
        L45:
            if (r113 == r110.C.a().intValue()) goto L47;
            r110.C.c(Integer.valueOf(r113));
            r115 = true;
            goto L49
        L24:
            if (r108.isEmpty() == true) goto L42;
            Iterator<wqa.i> r202 = r108.iterator();
        L27:
            if (r202.hasNext() == false) goto L42;
            wqa.i r1104 = r202.next();
            if (r1104 == null) goto L27;
            if (TextUtils.isEmpty(r1104.f560775a) == true) goto L27;
            if (TextUtils.isEmpty(r1104.f560776b) == true) goto L27;
            String r1105 = r1104.f560775a.toLowerCase();
            r107.append(r1105);
            r107.append(",");
            r1105.getClass();
            if (r1105.equals("x-tt-token") == false) goto L38;
            r106 = r1104.f560776b;
            goto L27
        L38:
            if (r1105.equals("x-tt-passport-session-id") == false) goto L27;
            r105 = r1104.f560776b;
            goto L27
        L20:
            r104 = null;
            goto L21
        L322:
            return;
        L6:
            if ((r310 instanceof ua7.e) == false) goto L12;
            T r203 = ((ua7.e) r310).f549264p;
            if ((r203 instanceof wb7.d) == false) goto L10;
            r100 = ((wb7.d) r203).getUserInfo();
            goto L14
        L10:
            r100 = null;
            goto L14
        L12:
            if ((r310 instanceof xa7.g) == false) goto L15;
            r100 = ((xa7.g) r310).f563088v;
            goto L14
        L15:
            r101 = null;
            goto L16
        }
    }

    public class h extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269060d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269060d.P0.getString("user_mobile", "");
        }

        public h(j r100) {
            this.f269060d = r100;
        }
    }

    public class h0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269061d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269061d.P0.getString("pgc_name", "");
        }

        public h0(j r100) {
            this.f269061d = r100;
        }
    }

    public class i extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269062d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269062d.P0.getString(ITwitterService.ResponseConstants.USER_NAME, "");
        }

        public i(j r100) {
            this.f269062d = r100;
        }
    }

    public class i0 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269063d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269063d.P0.getInt("display_ocr_entrance", 0));
        }

        public i0(j r100) {
            this.f269063d = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.impl.j$j, reason: collision with other inner class name */
    public class C3759j extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269064d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269064d.P0.getString("screen_name", "");
        }

        public C3759j(j r100) {
            this.f269064d = r100;
        }
    }

    public class j0 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269065d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269065d.P0.getInt("following_count", 0));
        }

        public j0(j r100) {
            this.f269065d = r100;
        }
    }

    public class k extends com.bytedance.sdk.account.utils.i<ta7.h> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269066d;

        @Override // com.bytedance.sdk.account.utils.i
        public final ta7.h b() {
            Context r100 = this.f269066d.L0;
            if (com.bytedance.sdk.account.impl.g.f268994b != null) goto L15;
            monitor-enter(com.bytedance.sdk.account.impl.g.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (com.bytedance.sdk.account.impl.g.f268994b != null) goto L9;
            com.bytedance.sdk.account.impl.g.f268994b = new com.bytedance.sdk.account.impl.g(r100);     // Catch: Throwable -> L11
        L9:
            monitor-exit(com.bytedance.sdk.account.impl.g.class);     // Catch: Throwable -> L11
        L15:
            return com.bytedance.sdk.account.impl.g.f268994b;
        }

        public k(j r100) {
            this.f269066d = r100;
        }
    }

    public class k0 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269067d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269067d.P0.getInt("followers_count", 0));
        }

        public k0(j r100) {
            this.f269067d = r100;
        }
    }

    public class l extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269068d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269068d.P0.getString("recommend_hint_message", "");
        }

        public l(j r100) {
            this.f269068d = r100;
        }
    }

    public class l0 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269069d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269069d.P0.getInt("visitors_count", 0));
        }

        public l0(j r100) {
            this.f269069d = r100;
        }
    }

    public class m extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269070d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269070d.P0.getInt("can_sync_share", 0));
        }

        public m(j r100) {
            this.f269070d = r100;
        }
    }

    public class m0 extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269071d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269071d.P0.getBoolean("is_visitor_account", false));
        }

        public m0(j r100) {
            this.f269071d = r100;
        }
    }

    public class n extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269072d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269072d.P0.getInt("user_privacy_extend", 0));
        }

        public n(j r100) {
            this.f269072d = r100;
        }
    }

    public class n0 extends com.bytedance.sdk.account.utils.i<sc7.a> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269073d;

        @Override // com.bytedance.sdk.account.utils.i
        public final sc7.a b() {
            j r100 = this.f269073d;
            r100.getClass();
            com.ss.android.account.d r101 = new com.ss.android.account.d(r100.Y.a());
            r101.f541360a = r100.B.a().longValue();
            r101.f541361b = r100.C.a().intValue();
            r101.f541366g = r100.f269012J.a().booleanValue();
            r101.f541367h = r100.G.a();
            r101.f406230r = r100.f269034r.a();
            r101.K = r100.f269024j.a().intValue();
            r101.f406241u = r100.f269035s.a();
            r101.f406242v = r100.F.a();
            r101.f406232t = r100.f269017d.a();
            r101.M = r100.f269019f.a();
            r101.L = r100.E.a().booleanValue();
            r101.N = r100.f269016c.a();
            r101.O = r100.f269025k.a();
            r101.B = r100.A.a();
            r101.f406231s = r100.f269022h.a();
            r101.f406246z = r100.f269029n.a().booleanValue();
            r101.A = r100.f269036t.a();
            r101.D = r100.f269020g.a().intValue();
            r101.E = r100.f269037u.a().intValue();
            r101.I = r100.f269018e.a();
            r100.Q.a().intValue();
            r100.R.a().intValue();
            r100.S.a().intValue();
            r101.H = r100.f269031p.a().longValue();
            r101.f541369j = r100.f269023i.a();
            r101.C = r100.f269042z.a();
            r101.f406240J = r100.P.a().intValue();
            r101.G = r100.f269039w.a().intValue();
            r101.F = r100.f269038v.a().intValue();
            r101.Q = r100.f269027l.a().intValue();
            r101.P = r100.f269028m.a().intValue();
            r101.R = r100.f269030o.a().booleanValue();
            r100.L.a().booleanValue();
            r101.f406244x = r100.N.a();
            r101.f406243w = r100.f269031p.a().longValue();
            r101.f406245y = r100.O.a();
            r101.f541365f = r100.I.a().intValue();
            r101.f541370k = r100.D.a();
            r101.f541372m = r100.T.a().booleanValue();
            r101.f541373n = r100.W.a().booleanValue();
            r101.S = r100.X.a();
            cra.a[] r102 = r100.Z.a();
            int r103 = r102.length;
            int r104 = 0;
        L3:
            if (r104 >= r103) goto L12;
            cra.a r105 = r102[r104];
            if (TextUtils.isEmpty(r105.f465119a) == true) goto L11;
            if (r105.f465120b == false) goto L11;
            ((HashMap) r101.f541362c).put(r105.f465119a, r105);
        L11:
            r104 = r104 + 1;
            goto L3
        L12:
            r101.T = r100.H0.a().intValue();
            r101.U = r100.f269032p0.a().booleanValue();
            j r106 = this.f269073d;
            Set<String> r107 = r106.P0.getStringSet("store_key_saved_platform_app_id", null);
            if (r107 != null) goto L32;
        L31:
            return r101;
        L32:
            Iterator<String> r108 = r107.iterator();     // Catch: Exception -> L29
        L16:
            if (r108.hasNext() == false) goto L31;
            String r109 = r108.next();     // Catch: Exception -> L29
            String r110 = r106.P0.getString("_platform_" + r109, null);     // Catch: Exception -> L29
            if (TextUtils.isEmpty(r110) == true) goto L16;
            cra.a r111 = j.n(new JSONObject(r110), null);     // Catch: Exception -> L29
            if (r111 == null) goto L16;
            Map r112 = (Map) ((HashMap) r101.f541363d).get(r111.f465119a);     // Catch: Exception -> L29
            if (r112 != null) goto L27;
            r112 = new HashMap();     // Catch: Exception -> L29
            ((HashMap) r101.f541363d).put(r111.f465119a, r112);     // Catch: Exception -> L29
        L27:
            r112.put(String.valueOf(r111.f465130l), r111);     // Catch: Exception -> L29
        L29:
            e = move-exception;
            e.printStackTrace();
            goto L31
        }

        public n0(j r100) {
            this.f269073d = r100;
        }
    }

    public class o extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269074d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269074d.P0.getInt("user_privacy_extend_value", 2147483646));
        }

        public o(j r100) {
            this.f269074d = r100;
        }
    }

    public class o0 extends com.bytedance.sdk.account.utils.i<Set<String>> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269075d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Set<String> b() {
            return this.f269075d.P0.getStringSet("has_update_sec_uids", new HashSet());
        }

        public o0(j r100) {
            this.f269075d = r100;
        }
    }

    public class p extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269076d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269076d.P0.getString("multi_sids", "");
        }

        public p(j r100) {
            this.f269076d = r100;
        }
    }

    public class p0 extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269077d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269077d.P0.getBoolean("is_kids_mode", false));
        }

        public p0(j r100) {
            this.f269077d = r100;
        }
    }

    public class q extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269078d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269078d.P0.getString("sec_multi_sids", "");
        }

        public q(j r100) {
            this.f269078d = r100;
        }

        @Override // com.bytedance.sdk.account.utils.i
        public final void c(String r100) {
            String r101 = r100;
            super.c(r101);
            this.f269078d.P0.edit().putString("sec_multi_sids", r101).apply();
        }
    }

    public class q0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269079d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269079d.P0.getString("avatar_url", "");
        }

        public q0(j r100) {
            this.f269079d = r100;
        }
    }

    public class r extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269080d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269080d.P0.getString("user_auth_info", "");
        }

        public r(j r100) {
            this.f269080d = r100;
        }
    }

    public class r0 extends com.bytedance.sdk.account.utils.i<JSONObject> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269081d;

        @Override // com.bytedance.sdk.account.utils.i
        public final JSONObject b() {
            return new JSONObject(this.f269081d.P0.getString("expend_attrs", SliceInitService.DEFAULT_SWITCH));
        L5:
            return new JSONObject();
        }

        public r0(j r100) {
            this.f269081d = r100;
        }
    }

    public class s extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269082d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269082d.P0.getString("user_decoration", "");
        }

        public s(j r100) {
            this.f269082d = r100;
        }
    }

    public class s0 extends com.bytedance.sdk.account.utils.i<JSONObject> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269083d;

        @Override // com.bytedance.sdk.account.utils.i
        public final JSONObject b() {
            return new JSONObject(this.f269083d.P0.getString("raw_json", SliceInitService.DEFAULT_SWITCH));
        L5:
            return new JSONObject();
        }

        public s0(j r100) {
            this.f269083d = r100;
        }
    }

    public class t extends com.bytedance.sdk.account.utils.i<Long> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269084d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Long b() {
            long r100 = 0;
            long r101 = this.f269084d.P0.getLong("user_id", 0);
            if (this.f269084d.K.a().booleanValue() == false) goto L8;
            if (r101 > 0) goto L8;
            this.f269084d.K.c(Boolean.FALSE);
            this.f269084d.D.c("");
            this.f269084d.C.c(0);
        L14:
            return Long.valueOf(r100);
        L8:
            if (this.f269084d.K.a().booleanValue() == false) goto L10;
        L12:
            r100 = r101;
            goto L14
        L10:
            if (r101 <= 0) goto L12;
            this.f269084d.D.c("");
            this.f269084d.C.c(0);
            goto L14
        }

        public t(j r100) {
            this.f269084d = r100;
        }
    }

    public class t0 extends com.bytedance.sdk.account.utils.i<cra.a[]> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269085d;

        @Override // com.bytedance.sdk.account.utils.i
        public final cra.a[] b() {
            d().getMethod("init", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        L7:
            cra.a[] r100 = j.f269009h1;
            j r101 = this.f269085d;
            r101.getClass();
            int r102 = 0;
        L9:
            if (r102 >= r100.length) goto L22;
            cra.a r103 = r100[r102];
            r103.f465120b = false;
        L19:
            e = move-exception;
            e.printStackTrace();
        L21:
            r102 = r102 + 1;
            goto L9
        L12:
            if (TextUtils.isEmpty(r103.f465119a) == true) goto L21;
            String r104 = r101.P0.getString("_platform_" + r103.f465119a, null);     // Catch: Exception -> L19
            if (TextUtils.isEmpty(r104) == true) goto L21;
            j.n(new JSONObject(r104), r103);     // Catch: Exception -> L19
            goto L21
        L22:
            return r100;
        L5:
            e = move-exception;
            tb7.a.c("BDAccountManager", "try init BDAccountManagerAdapter fail", e);
            goto L7
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class d() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");
        }

        public t0(j r100) {
            this.f269085d = r100;
        }
    }

    public class u extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269086d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269086d.P0.getInt("odin_user_type", 0));
        }

        public u(j r100) {
            this.f269086d = r100;
        }
    }

    public class u0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269087d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269087d.P0.getString("header_session_id", "");
        }

        public u0(j r100) {
            this.f269087d = r100;
        }
    }

    public class v extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269088d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269088d.P0.getString("sec_user_id", "");
        }

        public v(j r100) {
            this.f269088d = r100;
        }
    }

    public class v0 extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269089d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269089d.P0.getBoolean("use_hm_region", false));
        }

        public v0(j r100) {
            this.f269089d = r100;
        }
    }

    public class w extends com.bytedance.sdk.account.utils.i<Boolean> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269090d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.f269090d.P0.getBoolean("user_verified", false));
        }

        public w(j r100) {
            this.f269090d = r100;
        }
    }

    public class w0 extends com.bytedance.sdk.account.utils.i<Integer> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269091d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.f269091d.P0.getInt("hm_region", 0));
        }

        public w0(j r100) {
            this.f269091d = r100;
        }
    }

    public class x extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269092d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269092d.P0.getString("verified_content", "");
        }

        public x(j r100) {
            this.f269092d = r100;
        }
    }

    public class x0 implements com.ss.android.token.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f269093a;

        @Override // com.ss.android.token.c
        public final void onInitFinish() {
            if (this.f269093a.B.a().longValue() <= 0) goto L6;
            j.v(this.f269093a.B.a().longValue(), this.f269093a.k());
            return;
        }

        public x0(j r100) {
            this.f269093a = r100;
        }
    }

    public class y extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269094d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269094d.P0.getString("session_key", "");
        }

        public y(j r100) {
            this.f269094d = r100;
        }
    }

    public class y0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269095d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269095d.P0.getString("bg_img_url", "");
        }

        public y0(j r100) {
            this.f269095d = r100;
        }
    }

    public class z extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269096d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269096d.P0.getString("session_sign", "");
        }

        public z(j r100) {
            this.f269096d = r100;
        }
    }

    public class z0 extends com.bytedance.sdk.account.utils.i<String> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j f269097d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.f269097d.P0.getString("user_birthday", "");
        }

        public z0(j r100) {
            this.f269097d = r100;
        }
    }

    static {
        f269009h1 = new cra.a[]{new cra.a("mobile"), new cra.a("email"), new cra.a("google"), new cra.a("facebook"), new cra.a("twitter"), new cra.a("instagram"), new cra.a("line"), new cra.a("kakaotalk"), new cra.a("vk"), new cra.a("tiktok")};
        ArrayList r100 = new ArrayList();
        f269011p1 = r100;
        r100.add(new g1());
        r100.add(new e1());
        r100.add(new f1());
    }

    @Override // ta7.f
    public final void f() {
        this.f269041y.c("");
    }

    @Override // ta7.f
    public final void g() {
        this.f269040x.c("");
        this.P0.edit().putString("multi_sids", "").apply();
    }

    @Override // ta7.f
    public final String getSecUserId() {
        return this.D.a();
    }

    @Override // ta7.f
    public final long getUserId() {
        return this.B.a().longValue();
    }

    public final int i() {
        return this.C.a().intValue();
    }

    @Override // ta7.f
    public final boolean isLogin() {
        return this.K.a().booleanValue();
    }

    public final sc7.a l() {
        return this.U.a();
    }

    public final void q() {
        SharedPreferences.Editor r100 = this.P0.edit();
        s(r100);
        t();
        r100.remove(AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        r100.putBoolean("is_login", this.K.a().booleanValue());
        r100.putLong("user_id", this.B.a().longValue());
        r100.putInt("odin_user_type", this.C.a().intValue());
        r100.putString("sec_user_id", this.D.a());
        r100.putString("session_key", this.G.a());
        r100.putString("session_sign", this.H.a());
        r100.putString(ITwitterService.ResponseConstants.USER_NAME, this.f269034r.a());
        r100.putString("verified_content", this.F.a());
        r100.putInt("user_gender", this.f269024j.a().intValue());
        r100.putString("screen_name", this.f269035s.a());
        r100.putBoolean("user_verified", this.E.a().booleanValue());
        r100.putString("avatar_url", this.f269017d.a());
        r100.putBoolean("is_new_user", this.f269012J.a().booleanValue());
        r100.putString("user_email", this.f269023i.a());
        r100.putString("user_mobile", this.f269033q.a());
        r100.putInt("is_blocked", this.f269027l.a().intValue());
        r100.putInt("is_blocking", this.f269028m.a().intValue());
        r100.putBoolean("is_toutiao", this.f269030o.a().booleanValue());
        r100.putBoolean("user_has_pwd", this.L.a().booleanValue());
        r100.putInt("country_code", this.I.a().intValue());
        r100.putString("area", this.f269016c.a());
        r100.putString("user_industry", this.f269025k.a());
        r100.putString("user_decoration", this.A.a());
        r100.putString("user_birthday", this.f269019f.a());
        r100.putLong("pgc_mediaid", this.M.a().longValue());
        r100.putString("pgc_avatar_url", this.N.a());
        r100.putString("pgc_name", this.O.a());
        r100.putString("user_description", this.f269022h.a());
        r100.putBoolean("is_recommend_allowed", this.f269029n.a().booleanValue());
        r100.putString("recommend_hint_message", this.f269036t.a());
        r100.putInt("can_be_found_by_phone", this.f269020g.a().intValue());
        r100.putInt("can_sync_share", this.f269037u.a().intValue());
        r100.putInt("following_count", this.Q.a().intValue());
        r100.putInt("followers_count", this.R.a().intValue());
        r100.putInt("visitors_count", this.S.a().intValue());
        r100.putLong(AppConstants.BUNDLE_MEDIA_ID, this.f269031p.a().longValue());
        r100.putString("bg_img_url", this.f269018e.a());
        r100.putInt("display_ocr_entrance", this.P.a().intValue());
        r100.putString("user_auth_info", this.f269042z.a());
        r100.putInt("user_privacy_extend", this.f269038v.a().intValue());
        r100.putInt("user_privacy_extend_value", this.f269039w.a().intValue());
        r100.putBoolean("is_visitor_account", this.T.a().booleanValue());
        r100.putBoolean("is_kids_mode", this.W.a().booleanValue());
        r(r100);
        if (this.X.a() != null) goto L5;
        r100.putString("expend_attrs", "");
    L6:
        r100.putBoolean("use_hm_region", this.f269032p0.a().booleanValue());
        r100.putInt("hm_region", this.H0.a().intValue());
        if (this.Y.a() != null) goto L9;
        r100.putString("raw_json", "");
    L10:
        SharedPrefsEditorCompat.apply(r100);
        o("saveData");
        return;
    L9:
        r100.putString("raw_json", this.Y.a().toString());
        goto L10
    L5:
        r100.putString("expend_attrs", this.X.toString());
        goto L6
    }

    public final void t() {
        if (this.U.a() != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r100 = this.P0.edit();
        Set<String> r101 = this.P0.getStringSet("store_key_saved_platform_app_id", null);
        if (r101 == null) goto L27;
        Iterator<String> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L27;
        String r103 = r102.next();
        String r104 = "_platform_" + r103;
        String r105 = this.P0.getString(r104, null);
        if (TextUtils.isEmpty(r105) == true) goto L12;
        Map r106 = (Map) ((HashMap) this.U.a().f541363d).get(new JSONObject(r105).optString("mName"));     // Catch: Exception -> L25
        if (r106 == null) goto L23;
        if (r106.isEmpty() == true) goto L23;
        cra.a r107 = (cra.a) r106.get(r103);     // Catch: Exception -> L25
        if (r107 == null) goto L22;
        if (r107.f465120b == true) goto L9;
    L22:
        r100.remove(r104);     // Catch: Exception -> L25
    L23:
        r100.remove(r104);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        r100.remove(r104);
    L27:
        HashSet r108 = new HashSet();
        Iterator r109 = ((HashMap) this.U.a().f541363d).values().iterator();
    L29:
        if (r109.hasNext() == false) goto L47;
        Map r110 = (Map) r109.next();
        if (r110 == null) goto L29;
        if (r110.isEmpty() == true) goto L29;
        Iterator r111 = r110.keySet().iterator();
    L37:
        if (r111.hasNext() == false) goto L29;
        String r112 = (String) r111.next();
        cra.a r113 = (cra.a) r110.get(r112);
        if (r113 == null) goto L37;
        if (r113.f465120b == false) goto L37;
        JSONObject r114 = j(r113);
        if (r114 == null) goto L37;
        r100.putString("_platform_" + r112, r114.toString());
        r108.add(r112);
        goto L37
    L47:
        r100.putStringSet("store_key_saved_platform_app_id", r108);
        r100.apply();
    }

    public final void u() {
        if (this.V0 != null) goto L5;
        return;
    L5:
        if (com.ss.android.account.k.f406319c == null) goto L7;
        com.ss.android.account.k.f406319c.getClass();
    L7:
        this.V0.sendEmptyMessageDelayed(1000, 600000);
    }

    public final String k() {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.f269402z == false) goto L7;
        return this.f269026k0.a();
    L7:
        return this.G.a();
    }

    @Override // ta7.f
    public final String b() {
        return this.f269014b;
    }

    @Override // ta7.f
    public final String c() {
        return this.f269021g1;
    }

    public j(Context r100) {
        this.f269013a = new k(this);
        this.f269014b = "";
        this.f269016c = new f0(this);
        this.f269017d = new q0(this);
        this.f269018e = new y0(this);
        this.f269019f = new z0(this);
        this.f269020g = new a1(this);
        this.f269022h = new b1(this);
        this.f269023i = new c1(this);
        this.f269024j = new a(this);
        this.f269025k = new b(this);
        this.f269027l = new c(this);
        this.f269028m = new d(this);
        this.f269029n = new e(this);
        this.f269030o = new f(this);
        this.f269031p = new g(this);
        this.f269033q = new h(this);
        this.f269034r = new i(this);
        this.f269035s = new C3759j(this);
        this.f269036t = new l(this);
        this.f269037u = new m(this);
        this.f269038v = new n(this);
        this.f269039w = new o(this);
        this.f269040x = new p(this);
        this.f269041y = new q(this);
        this.f269042z = new r(this);
        this.A = new s(this);
        t r101 = new t(this);
        this.B = r101;
        this.C = new u(this);
        this.D = new v(this);
        this.E = new w(this);
        this.F = new x(this);
        this.G = new y(this);
        this.H = new z(this);
        this.I = new a0(this);
        this.f269012J = new b0(this);
        this.K = new c0(this);
        this.L = new d0(this);
        this.M = new e0(this);
        this.N = new g0(this);
        this.O = new h0(this);
        this.P = new i0(this);
        this.Q = new j0(this);
        this.R = new k0(this);
        this.S = new l0(this);
        this.T = new m0(this);
        this.U = new n0(this);
        this.V = new o0(this);
        this.W = new p0(this);
        this.X = new r0(this);
        this.Y = new s0(this);
        this.Z = new t0(this);
        this.f269026k0 = new u0(this);
        this.f269032p0 = new v0(this);
        this.H0 = new w0(this);
        this.V0 = new WeakHandler(Looper.getMainLooper(), this);
        this.f269015b1 = new HashSet();
        this.f269021g1 = "";
        Context r102 = r100.getApplicationContext();
        this.L0 = r102;
        this.P0 = r102.getSharedPreferences("com.bytedance.sdk.account_setting", 0);
        r101.a();
        x0 r103 = new x0(this);
        boolean r104 = com.ss.android.token.p.f449777a;
        TokenFactory.b(r103);
    }

    public static JSONObject j(cra.a r100) {
        JSONObject r101 = new JSONObject();
        r101.put("mName", r100.f465119a);     // Catch: Exception -> L5
        r101.put("mPlatformId", r100.f465130l);     // Catch: Exception -> L5
        r101.put("mNickname", r100.f465121c);     // Catch: Exception -> L5
        r101.put("mAvatar", r100.f465122d);     // Catch: Exception -> L5
        r101.put("mPlatformUid", r100.f465123e);     // Catch: Exception -> L5
        r101.put("mExpire", r100.f465127i);     // Catch: Exception -> L5
        r101.put("mExpireIn", r100.f465128j);     // Catch: Exception -> L5
        r101.put(Keys.API_RETURN_KEY_IS_LOGIN, r100.f465120b);     // Catch: Exception -> L5
        r101.put("mUserId", r100.f465129k);     // Catch: Exception -> L5
        r101.put("mModifyTime", r100.f465126h);     // Catch: Exception -> L5
        r101.put("mSecPlatformUid", r100.f465124f);     // Catch: Exception -> L5
        r101.put("mAccessToken", r100.f465131m);     // Catch: Exception -> L5
        r101.put("mOpenId", r100.f465132n);     // Catch: Exception -> L5
        r101.put("mScope", r100.f465133o);     // Catch: Exception -> L5
        r101.put("refreshAt", r100.f465135q);     // Catch: Exception -> L5
        r101.put("refreshTime", r100.f465136r);     // Catch: Exception -> L5
        return r101;
    L5:
        return null;
    }

    public static j m(Context r100) {
        if (f269010k1 != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f269010k1 != null) goto L9;
        f269010k1 = new j(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        if (f269010k1.L0 != null) goto L20;
        if (r100.getApplicationContext() == null) goto L20;
        j r101 = f269010k1;
        r101.L0 = r100.getApplicationContext();
    L20:
        return f269010k1;
    }

    @Override // ta7.f
    public final void a(boolean r100) {
        if (this.K.a().booleanValue() == false) goto L15;
        b0 r101 = this.f269012J;
        Boolean r102 = Boolean.FALSE;
        r101.c(r102);
        this.K.c(r102);
        this.B.c(0L);
        this.G.c("");
        this.C.c(0);
        this.H.c("");
        this.D.c("");
        v(this.B.a().longValue(), "");
        this.f269034r.c("");
        this.f269024j.c(0);
        this.f269035s.c("");
        this.F.c("");
        this.f269022h.c("");
        this.f269016c.c("");
        this.f269025k.c("");
        this.f269027l.c(0);
        this.f269028m.c(0);
        this.A.c("");
        this.f269019f.c("");
        this.E.c(r102);
        this.f269029n.c(r102);
        this.f269030o.c(r102);
        this.I.c(0);
        this.Q.c(0);
        this.R.c(0);
        this.S.c(0);
        this.L.c(r102);
        this.f269031p.c(0L);
        this.f269018e.c("");
        this.f269023i.c("");
        this.f269033q.c("");
        this.P.c(0);
        this.N.c("");
        this.M.c(0L);
        this.O.c("");
        this.f269042z.c("");
        this.T.c(r102);
        cra.a[] r103 = this.Z.a();
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L7;
        r103[r105].e();
        r105 = r105 + 1;
        goto L5
    L7:
        Iterator r106 = ((HashMap) this.U.a().f541363d).values().iterator();
    L9:
        if (r106.hasNext() == false) goto L14;
        Iterator r107 = ((Map) r106.next()).values().iterator();
    L12:
        if (r107.hasNext() == false) goto L9;
        ((cra.a) r107.next()).e();
        goto L12
    L14:
        this.H0.c(0);
        this.f269032p0.c(Boolean.FALSE);
        q();
        this.f269026k0.c("");
        SharedPreferences.Editor r108 = this.P0.edit();
        r108.putString("header_session_id", this.f269026k0.a());
        SharedPrefsEditorCompat.apply(r108);
    L15:
        if (r100 == false) goto L32;
        ta7.b r109 = new ta7.b(2);
        r109.f545196b = false;
        if (com.bytedance.sdk.account.impl.h0.f268998d == null) goto L21;
        com.bytedance.sdk.account.impl.h0 r110 = com.bytedance.sdk.account.impl.h0.f268998d;
        com.bytedance.sdk.account.impl.i0 r111 = r110.f269001c;
        r110.f269001c = null;
        if (r111 == null) goto L21;
        r109.f545197c = r111;
    L21:
        Set<ta7.c> r112 = this.f269015b1;
        monitor-enter(r112);
        Iterator r113 = ((HashSet) this.f269015b1).iterator();     // Catch: Throwable -> L29
    L25:
        if (r113.hasNext() == false) goto L27;
        ((ta7.c) r113.next()).M(r109);     // Catch: Throwable -> L29
        goto L25
    L27:
        monitor-exit(r112);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // ta7.f
    public final void d(ta7.c r100) {
        if (r100 != null) goto L5;
        tb7.a.b("BDAccountManager", "addListener(), listener is null, " + Log.getStackTraceString(new Throwable()));
        return;
    L5:
        tb7.a.d("BDAccountManager", "addListener(), ".concat(r100.getClass().getName()));
        Set<ta7.c> r101 = this.f269015b1;
        monitor-enter(r101);
        ((HashSet) this.f269015b1).add(r100);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // ta7.f
    public final void e(ta7.b r100) {
        Set<ta7.c> r101 = this.f269015b1;
        monitor-enter(r101);
        Iterator r102 = ((HashSet) this.f269015b1).iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        ta7.c r103 = (ta7.c) r102.next();     // Catch: Throwable -> L12
        if (r103 == null) goto L6;
        r103.M(r100);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100.what != 100) goto L18;
        Object r101 = r100.obj;
        if ((r101 instanceof com.bytedance.sdk.account.impl.f0) == false) goto L18;
        com.bytedance.sdk.account.impl.f0 r102 = (com.bytedance.sdk.account.impl.f0) r101;
        T r103 = r102.f268993b;
        if (r103 == null) goto L18;
        Iterator r104 = ((ArrayList) f269011p1).iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((d1) r104.next()).a(r103, r102);
        goto L10
    L12:
        ua7.a<T> r105 = r102.f268992a;
        if (r105 == null) goto L18;
        r105.dispatchOnResponse(r102.f268993b);
        wa7.a r106 = r105.mJobController;
        if (r106 == null) goto L18;
        ((com.bytedance.sdk.account.impl.c0) r106).f268956e = null;
    L18:
        if (r100.what != 1000) goto L27;
        this.V0.removeMessages(1000);
        if (isLogin() == true) goto L23;
        u();
        return;
    L23:
        if (this.f269013a.a() == null) goto L29;
        this.f269013a.a().b(SystemBatteryRecoder.BatteryRecordReason.POLLING, new com.bytedance.sdk.account.impl.l(this));
        return;
    L29:
        return;
    }

    public final void o(String r100) {
        if (this.U.a() != null) goto L6;
        tb7.a.a("BDAccountManager", "mUserInfo == null");
        return;
    L6:
        tb7.a.a("BDAccountManager", String.format("%s: bind map entities", new Object[]{r100}));
        tb7.a.a("BDAccountManager", "isLogin==" + this.K);
        Iterator r101 = ((HashMap) this.U.a().f541362c).values().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        tb7.a.a("BDAccountManager", String.format("%1s: bind map entity = %2s", new Object[]{r100, ((cra.a) r101.next()).c()}));
        goto L8
    L10:
        tb7.a.a("BDAccountManager", String.format("%s: third platform entities", new Object[]{r100}));
        Iterator r102 = ((HashMap) this.U.a().f541363d).values().iterator();
    L12:
        if (r102.hasNext() == false) goto L17;
        Iterator r103 = ((Map) r102.next()).values().iterator();
    L15:
        if (r103.hasNext() == false) goto L12;
        tb7.a.a("BDAccountManager", String.format("%1s: third platform entity = %2s", new Object[]{r100, ((cra.a) r103.next()).c()}));
        goto L15
    }

    public final void p(String r100) {
        if (com.bytedance.sdk.account.impl.h0.f268998d == null) goto L5;
    L14:
        com.bytedance.sdk.account.impl.h0.f268998d.b(r100);
        return;
    L5:
        monitor-enter(com.bytedance.sdk.account.impl.h0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.sdk.account.impl.h0.f268998d != null) goto L9;
        com.bytedance.sdk.account.impl.h0.f268998d = new com.bytedance.sdk.account.impl.h0(this);     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.sdk.account.impl.h0.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void r(SharedPreferences.Editor r100) {
        if (this.Y.a() != null) goto L5;
        r100.putString("raw_json", "");
    L6:
        r100.apply();
        return;
    L5:
        r100.putString("raw_json", this.Y.toString());
        goto L6
    }

    public final void s(SharedPreferences.Editor r100) {
        cra.a[] r101 = this.Z.a();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        cra.a r104 = r101[r103];
        if (this.K.a().booleanValue() == true) goto L7;
        r100.putString("_platform_" + r104.f465119a, "");
    L10:
        r103 = r103 + 1;
        goto L3
    L7:
        JSONObject r105 = j(r104);
        if (r105 == null) goto L10;
        r100.putString("_platform_" + r104.f465119a, r105.toString());
        goto L10
    L11:
        r100.apply();
    }

    public final boolean w(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        this.f269014b = "";
        tb7.a.d("BDAccountManager", "setVerifyPortraitFlag empty");
        return true;
    L7:
        if (r100.contains(".") == false) goto L10;
        tb7.a.d("BDAccountManager", "verify portrait flag contains '.'");
        return false;
    L10:
        this.f269014b = UUID.randomUUID() + "." + r100;
        StringBuilder r101 = new StringBuilder("setVerifyPortraitFlag ");
        r101.append(this.f269014b);
        tb7.a.d("BDAccountManager", r101.toString());
        return true;
    }

    public final boolean x(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        this.f269021g1 = "";
        tb7.a.d("BDAccountManager", "setVerifyPortraitOuterFlag empty");
        return true;
    L7:
        if (r100.contains(".") == false) goto L10;
        tb7.a.d("BDAccountManager", "verify portrait outer flag contains '.'");
        return false;
    L10:
        this.f269021g1 = UUID.randomUUID() + "." + r100;
        StringBuilder r101 = new StringBuilder("setVerifyPortraitOuterFlag ");
        r101.append(this.f269021g1);
        tb7.a.d("BDAccountManager", r101.toString());
        return true;
    }

    public static cra.a n(JSONObject r100, cra.a r101) {
        String r102 = r100.optString("mName", "");
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return r101;
    L5:
        if (r101 != null) goto L8;
        r101 = new cra.a(r102);
    L8:
        if (TextUtils.equals(r102, r101.f465119a) == true) goto L11;
        return r101;
    L11:
        if (r100.has("mPlatformId") == false) goto L14;
        r101.f465130l = r100.optLong("mPlatformId", 0);
    L14:
        if (r100.has("mNickname") == false) goto L17;
        r101.f465121c = r100.optString("mNickname", "");
    L17:
        if (r100.has("mAvatar") == false) goto L20;
        r101.f465122d = r100.optString("mAvatar", "");
    L20:
        if (r100.has("mPlatformUid") == false) goto L23;
        r101.f465123e = r100.optString("mPlatformUid", "");
    L23:
        if (r100.has("mExpire") == false) goto L26;
        r101.f465127i = r100.optLong("mExpire", r101.f465127i);
    L26:
        if (r100.has("mExpireIn") == false) goto L29;
        r101.f465128j = r100.optLong("mExpireIn", r101.f465128j);
    L29:
        if (r100.has(Keys.API_RETURN_KEY_IS_LOGIN) == false) goto L32;
        r101.f465120b = r100.optBoolean(Keys.API_RETURN_KEY_IS_LOGIN, false);
    L32:
        if (r100.has("mUserId") == false) goto L35;
        r101.f465129k = r100.optLong("mUserId", 0);
    L35:
        if (r100.has("mModifyTime") == false) goto L38;
        r101.f465126h = r100.optLong("mModifyTime");
    L38:
        if (r100.has("mSecPlatformUid") == false) goto L41;
        r101.f465124f = r100.optString("mSecPlatformUid");
    L41:
        if (r100.has("mAccessToken") == false) goto L44;
        r101.f465131m = r100.optString("mAccessToken");
    L44:
        if (r100.has("mOpenId") == false) goto L47;
        r101.f465132n = r100.optString("mOpenId");
    L47:
        if (r100.has("mScope") == false) goto L50;
        r101.f465133o = r100.optString("mScope");
    L50:
        if (r100.has("refreshAt") == false) goto L53;
        r101.f465135q = r100.optLong("refreshAt", r101.f465135q);
    L53:
        if (r100.has("refreshTime") == false) goto L55;
        r101.f465136r = r100.optLong("refreshTime", r101.f465136r);
    L55:
        return r101;
    }

    public static void v(long r100, String r101) {
        com.bytedance.sdk.account.utils.g r102 = com.ss.android.account.k.d().getMonitor();     // Catch: Exception -> L6
        if (r102 == null) goto L11;
        r102.a(r100, r101);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final void y(String r110, int r210, Bundle r211) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        if (r210 != (-1)) goto L7;
        return;
    L7:
        if (r211.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.K.a().booleanValue() == true) goto L11;
        return;
    L11:
        if (this.U.a() == null) goto L72;
        String r100 = String.valueOf(r210);
        Map r101 = (Map) ((HashMap) this.U.a().f541363d).get(r110);
        if (r101 != null) goto L16;
        r101 = new HashMap();
        ((HashMap) this.U.a().f541363d).put(r110, r101);
    L16:
        cra.a r102 = (cra.a) r101.get(r100);
        if (r102 != null) goto L19;
        r102 = new cra.a(r110);
        r102.f465130l = r210;
        r102.f465120b = true;
        r102.f465129k = this.B.a().longValue();
        r101.put(r100, r102);
    L19:
        cra.a r103 = (cra.a) ((HashMap) this.U.a().f541362c).get(r110);
        if (r103 != null) goto L23;
        ((HashMap) this.U.a().f541362c).put(r110, r102);
        r103 = r102;
    L23:
        if (r211.containsKey("access_token") == false) goto L26;
        String r104 = r211.getString("access_token", null);
        r103.f465131m = r104;
        r102.f465131m = r104;
    L26:
        if (r211.containsKey("expires_in") == false) goto L32;
        long r111 = r211.getLong("expires_in", 0);
        if (r111 == 0) goto L30;
        long r112 = System.currentTimeMillis() + (r111 * 1000);
    L31:
        r103.f465128j = r111;
        r103.f465127i = r112;
        r102.f465128j = r111;
        r102.f465127i = r112;
    L34:
        if (r211.containsKey(Constants.JumpUrlConstants.URL_KEY_OPENID) == false) goto L37;
        String r105 = r211.getString(Constants.JumpUrlConstants.URL_KEY_OPENID, null);
        r103.f465132n = r105;
        r102.f465132n = r105;
    L37:
        if (r211.containsKey(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE) == false) goto L40;
        String r106 = r211.getString(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, null);
        r103.f465133o = r106;
        r102.f465133o = r106;
    L40:
        if (r211.containsKey("extra") == false) goto L43;
        String r107 = r211.getString("extra", null);
        r103.f465134p = r107;
        r102.f465134p = r107;
    L43:
        if (r211.containsKey("refresh_time") == false) goto L49;
        long r108 = r211.getLong("refresh_time", 0);
        if (r111 <= r108) goto L47;
        long r113 = r102.f465127i - (1000 * r108);
    L48:
        r103.f465136r = r108;
        r103.f465135q = r113;
        r102.f465136r = r108;
        r102.f465135q = r113;
        goto L49
    L47:
        r113 = r102.f465127i;
    L49:
        HashMap r109 = (HashMap) this.U.a().f541362c;
        if (r109 != null) goto L52;
    L63:
        s(this.P0.edit());
        t();
        o("updatePlatformInfo");
        return;
    L52:
        if (r109.isEmpty() == true) goto L63;
        cra.a[] r114 = this.Z.a();
        int r115 = r114.length;
        int r116 = 0;
    L54:
        if (r116 >= r115) goto L63;
        cra.a r117 = r114[r116];
        r117.f465120b = false;
        cra.a r118 = (cra.a) r109.get(r117.f465119a);
        if (r118 != null) goto L59;
        r117.e();
    L62:
        r116 = r116 + 1;
        goto L54
    L59:
        if (r117.f465120b == true) goto L61;
        r117.f465120b = true;
    L61:
        r117.f465130l = r118.f465130l;
        r117.f465127i = r118.f465127i;
        r117.f465128j = r118.f465128j;
        r117.f465121c = r118.f465121c;
        r117.f465122d = r118.f465122d;
        r117.f465123e = r118.f465123e;
        r117.f465129k = r118.f465129k;
        r117.f465126h = r118.f465126h;
        r117.f465131m = r118.f465131m;
        r117.f465132n = r118.f465132n;
        r117.f465133o = r118.f465133o;
        r117.f465136r = r118.f465136r;
        r117.f465135q = r118.f465135q;
        r117.f465134p = r118.f465134p;
        goto L62
    L30:
        r112 = 0;
        goto L31
    L32:
        r111 = 0;
        goto L34
    }

    public static void h(j r100, String r101, int r102, boolean r103) {
        r100.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        if (r102 != (-1)) goto L7;
        return;
    L7:
        if (r100.K.a().booleanValue() == true) goto L9;
        return;
    L9:
        if (r100.Y.a() != null) goto L11;
        return;
    L11:
        if (r100.U.a() == null) goto L45;
        if (r103 == false) goto L29;
        cra.a r104 = new cra.a(r101);
        r104.f465130l = r102;
        JSONArray r105 = r100.Y.a().optJSONObject("data").optJSONArray("connects");     // Catch: Exception -> L34
        int r106 = 0;
    L17:
        if (r106 >= r105.length()) goto L24;
        JSONObject r107 = JSONArrayProtectorUtils.getJSONObject(r105, r106);     // Catch: Exception -> L34
        if (TextUtils.equals(r107.optString("platform"), r101) == false) goto L23;
        if (r107.optInt("platform_app_id") != r102) goto L23;
        JSONObject r108 = r100.Y.a().optJSONObject("data");     // Catch: Exception -> L34
        r105.remove(r106);     // Catch: Exception -> L34
        r108.put("connects", r105);     // Catch: Exception -> L34
        sc7.a r109 = r100.U.a();     // Catch: Exception -> L34
        JSONObject r110 = r100.Y.a();     // Catch: Exception -> L34
        r109.f541375p = r110;     // Catch: Exception -> L34
        JSONObject r111 = r110.optJSONObject("data");     // Catch: Exception -> L34
        r109.f541374o = r111;     // Catch: Exception -> L34
        r109.f541376q = r111;     // Catch: Exception -> L34
    L23:
        r106 = r106 + 1;     // Catch: Exception -> L34
    L24:
        ((HashMap) r100.U.a().f541362c).put(r101, r104);     // Catch: Exception -> L34
        Map r112 = (Map) ((HashMap) r100.U.a().f541363d).get(r101);     // Catch: Exception -> L34
        if (r112 == null) goto L27;
        r112.put(String.valueOf(r102), r104);     // Catch: Exception -> L34
    L27:
        SharedPreferences.Editor r113 = r100.P0.edit();     // Catch: Exception -> L34
        r100.r(r113);     // Catch: Exception -> L34
        r100.s(r113);     // Catch: Exception -> L34
        r100.t();     // Catch: Exception -> L34
        r100.o("clearPlatformInfoInner");     // Catch: Exception -> L34
        return;
    L47:
        return;
    L29:
        Bundle r114 = new Bundle();
        r114.putString("access_token", "");
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.T != 0) goto L32;
        r114.putString(Constants.JumpUrlConstants.URL_KEY_OPENID, "");
    L32:
        r114.putString(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, "");
        r114.putLong("expires_in", 0);
        r114.putLong("refresh_time", 0);
        r100.y(r101, r102, r114);
        return;
    }
}
