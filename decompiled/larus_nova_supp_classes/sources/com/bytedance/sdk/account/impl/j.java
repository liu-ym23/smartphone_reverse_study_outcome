package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.EventsUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.account.PassportExtraHeaderManager;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import com.ss.android.token.TTTokenMonitor;
import com.ss.android.token.TokenFactory;
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
import org.xmlpull.v1.XmlPullParser;
import ua7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class j<T extends ua7.b> implements WeakHandler.IHandler, ta7.f {
    public static cra.a[] h1;
    public static volatile j k1;
    public static final List<d1> p1 = null;
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
    public final b0 f3J;
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
    public final k a;
    public volatile String b;
    public final Set<ta7.c> b1;
    public final f0 c;
    public final q0 d;
    public final y0 e;
    public final z0 f;
    public final a1 g;
    public volatile String g1;
    public final b1 h;
    public final c1 i;
    public final a j;
    public final b k;
    public final u0 k0;
    public final c l;
    public final d m;
    public final e n;
    public final f o;
    public final g p;
    public final v0 p0;
    public final h q;
    public final i r;
    public final C0004j s;
    public final l t;
    public final m u;
    public final n v;
    public final o w;
    public final p x;
    public final q y;
    public final r z;

    public class a extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("user_gender", 0));
        }

        public a(j r1) {
            this.d = r1;
        }
    }

    public class a0 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("country_code", 0));
        }

        public a0(j r1) {
            this.d = r1;
        }
    }

    public class a1 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("can_be_found_by_phone", 1));
        }

        public a1(j r1) {
            this.d = r1;
        }
    }

    public class b extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_industry", XmlPullParser.NO_NAMESPACE);
        }

        public b(j r1) {
            this.d = r1;
        }
    }

    public class b0 extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("is_new_user", false));
        }

        public b0(j r1) {
            this.d = r1;
        }
    }

    public class b1 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_description", XmlPullParser.NO_NAMESPACE);
        }

        public b1(j r1) {
            this.d = r1;
        }
    }

    public class c extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("is_blocked", 0));
        }

        public c(j r1) {
            this.d = r1;
        }
    }

    public class c0 extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("is_login", false));
        }

        public c0(j r1) {
            this.d = r1;
        }
    }

    public class c1 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_email", XmlPullParser.NO_NAMESPACE);
        }

        public c1(j r1) {
            this.d = r1;
        }
    }

    public class d extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("is_blocking", 0));
        }

        public d(j r1) {
            this.d = r1;
        }
    }

    public class d0 extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("user_has_pwd", false));
        }

        public d0(j r1) {
            this.d = r1;
        }
    }

    public interface d1 {
        void a(ua7.b r1, com.bytedance.sdk.account.impl.f0 r2);
    }

    public class e extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("is_recommend_allowed", false));
        }

        public e(j r1) {
            this.d = r1;
        }
    }

    public class e0 extends com.bytedance.sdk.account.utils.i<Long> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Long b() {
            return Long.valueOf(this.d.P0.getLong("pgc_mediaid", 0));
        }

        public e0(j r1) {
            this.d = r1;
        }
    }

    public static class e1 implements d1 {
        public e1() {
        }

        @Override // com.bytedance.sdk.account.impl.j.d1
        public final void a(ua7.b r13, com.bytedance.sdk.account.impl.f0 r14) {
            if (r13.o == 10001) goto L5;
            return;
        L5:
            if (r13.c == false) goto L61;
            j r0 = j.m(com.ss.android.account.k.d().getApplicationContext());
            Long r1 = Long.valueOf(r0.getUserId());
            boolean r2 = false;
            r0.a(false);
            PassportExtraHeaderManager.m.getClass();
            PassportExtraHeaderManager r3 = PassportExtraHeaderManager.l;
            if (r3 == null) goto L43;
            com.bytedance.sdk.account.settings.common.b.a();
            if (com.bytedance.sdk.account.settings.common.b.b == false) goto L43;
            if (r3.j == false) goto L43;
            r3.h();
            Object r5 = r3.c;
            monitor-enter(r5);
            com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L40
            int r6 = com.bytedance.sdk.account.settings.common.b.f;     // Catch: Throwable -> L40
            AuthTokenMultiProcessSharedProvider.a r7 = r3.i.b();     // Catch: Throwable -> L40
            if (r6 <= 0) goto L19;
            SharedPreferences.Editor r8 = r3.b().edit();     // Catch: Throwable -> L40
        L20:
            LinkedHashMap r9 = new LinkedHashMap();     // Catch: Throwable -> L40
            com.bytedance.sdk.account.settings.common.b.a();     // Catch: Throwable -> L40
            Iterator r10 = com.bytedance.sdk.account.settings.common.b.e.c.iterator();     // Catch: Throwable -> L40
        L22:
            if (r10.hasNext() == false) goto L30;
            String r11 = (String) r10.next();     // Catch: Throwable -> L40
            if (r3.a.containsKey(r11) == false) goto L29;
            r3.a.remove(r11);     // Catch: Throwable -> L40
            r7.b.putNull(r11);     // Catch: Throwable -> L40
            if (r8 == null) goto L28;
            r8.remove(r11);     // Catch: Throwable -> L40
        L28:
            r2 = true;
        L29:
            r9.put(r11, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L40
            goto L22
        L30:
            if (r2 == false) goto L37;
            r3.b++;     // Catch: Throwable -> L40
            int r4 = r3.b;     // Catch: Throwable -> L40
            r7.b.put("passport_extra_header_modify_flag", Integer.valueOf(r4));     // Catch: Throwable -> L40
            r7.a();     // Catch: Throwable -> L40
            if (r8 == null) goto L34;
            r8.putInt("passport_extra_header_modify_flag", r4);     // Catch: Throwable -> L40
        L34:
            if (r8 == null) goto L36;
            r8.apply();     // Catch: Throwable -> L40
        L36:
            r3.a("logout_clean", r4, r9);     // Catch: Throwable -> L40
        L37:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L40
            monitor-exit(r5);
            goto L43
        L19:
            r8 = null;
        L40:
            th = move-exception;
            throw th;
        L43:
            TTTokenMonitor.o(r1, 0L, TTTokenMonitor.a(r13.d), "logout");
            String r15 = XmlPullParser.NO_NAMESPACE;
            if ((r13 instanceof ua7.c) == false) goto L46;
            r15 = ((ua7.c) r13).p;
        L46:
            ta7.b r16 = new ta7.b(1);
            if (TextUtils.isEmpty(r15) == true) goto L50;
            r15.getClass();
        L50:
            ua7.a r17 = r14.a;
            if (r17 == null) goto L53;
            r16.e = r17.onSendBDAccountEvent(r14.b);
        L53:
            r0.e(r16);
            return;
        }
    }

    public class f extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("is_toutiao", false));
        }

        public f(j r1) {
            this.d = r1;
        }
    }

    public class f0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("area", XmlPullParser.NO_NAMESPACE);
        }

        public f0(j r1) {
            this.d = r1;
        }
    }

    public static class f1 implements d1 {
        public f1() {
        }

        @Override // com.bytedance.sdk.account.impl.j.d1
        public final void a(ua7.b r8, com.bytedance.sdk.account.impl.f0 r9) {
            Context r10 = com.ss.android.account.k.d().getApplicationContext();
            if ((r8 instanceof ua7.g) == false) goto L17;
            ua7.g r0 = (ua7.g) r8;
            if (r8.c == false) goto L7;
            Bundle r1 = new Bundle();
            r1.putString("access_token", r0.r);
            r1.putLong("expires_in", r0.s);
            r1.putLong("refresh_time", r0.x);
            r1.putString("open_id", r0.t);
            r1.putString("scopes", r0.w);
            StringBuilder r4 = new StringBuilder("ThirdTokenHandler.handle: api=");
            r4.append(r8.o);
            r4.append(", updatePlatformInfo. resp=");
            r4.append("ThirdTokenResponse{platformName='" + r0.p + "', platformAppId=" + r0.q + ", accessToken='" + cra.a.d(r0.r) + "', expiresIn=" + r0.s + ", openId='" + cra.a.d(r0.t) + "', scopes='" + r0.w + "'}");
            tb7.a.a("BDAccountManager", r4.toString());
            j.m(r10).y(r0.p, r0.q, r1);
            return;
        L7:
            int r2 = ((ua7.b) r0).g;
            if (r2 != 1058) goto L10;
        L11:
            tb7.a.a("BDAccountManager", "ThirdTokenHandler.handle: api=" + r8.o + ", clearPlatformInfoInner. errCode=" + ((ua7.b) r0).g);
            j r11 = j.m(r10);
            String r12 = r0.p;
            int r3 = r0.q;
            if (((ua7.b) r0).g != 1058) goto L14;
            boolean r5 = true;
        L15:
            j.h(r11, r12, r3, r5);
            return;
        L14:
            r5 = false;
            goto L15
        L10:
            if (r2 == 1059) goto L11;
            return;
        }
    }

    public class g extends com.bytedance.sdk.account.utils.i<Long> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Long b() {
            return Long.valueOf(this.d.P0.getLong("media_id", 0));
        }

        public g(j r1) {
            this.d = r1;
        }
    }

    public class g0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("pgc_avatar_url", XmlPullParser.NO_NAMESPACE);
        }

        public g0(j r1) {
            this.d = r1;
        }
    }

    public static class g1 implements d1 {
        public g1() {
        }

        @Override // com.bytedance.sdk.account.impl.j.d1
        public final void a(ua7.b r35, com.bytedance.sdk.account.impl.f0 r36) {
            if ((r35 instanceof ua7.h) == false) goto L6;
            com.ss.android.account.d r0 = ((ua7.h) r35).p;
        L14:
            com.ss.android.account.d r3 = r0;
        L16:
            if (r3 == null) goto L322;
            long r4 = j.k1.getUserId();
            ua7.a r1 = r36.a;
            if (r1 == null) goto L20;
            Map r6 = r1.onSendBDAccountEvent(r35);
        L21:
            String r2 = XmlPullParser.NO_NAMESPACE;
            String r7 = XmlPullParser.NO_NAMESPACE;
            StringBuilder r8 = new StringBuilder();
            List r9 = r35.l;
            if (r9 != null) goto L24;
        L42:
            String r33 = r7;
            String r10 = r2;
            j r11 = j.k1;
            boolean r12 = !TextUtils.isEmpty(r33);
            r11.getClass();
            long r13 = ((sc7.a) r3).a;
            int r5 = ((sc7.a) r3).b;
            boolean r14 = false;
            if (r5 != 0) goto L45;
        L47:
            boolean r15 = false;
        L49:
            if (r13 <= 0) goto L51;
            r11.U.c(r3);
            if (r11.K.a().booleanValue() == true) goto L66;
            r11.K.c(Boolean.TRUE);
            CookieSyncManager.getInstance().sync();     // Catch: Throwable -> L62
        L64:
            r15 = true;
        L62:
            th = move-exception;
            th.printStackTrace();
        L66:
            if (((sc7.a) r3).g == false) goto L69;
            r11.f3J.c(Boolean.TRUE);
        L69:
            if (r11.B.a().longValue() == r13) goto L71;
            r11.B.c(Long.valueOf(r13));
            r15 = true;
            boolean r16 = true;
        L73:
            if (StringUtils.equal(r11.D.a(), ((sc7.a) r3).k) == true) goto L76;
            r11.D.c(((sc7.a) r3).k);
            new gc7.e(((sc7.a) r3).a + XmlPullParser.NO_NAMESPACE, ((sc7.a) r3).e, r11.L0).b();
            r15 = true;
        L76:
            if (StringUtils.equal(r11.G.a(), ((sc7.a) r3).h) == true) goto L79;
            r11.G.c(((sc7.a) r3).h);
            r15 = true;
            r16 = true;
        L79:
            if (StringUtils.equal(r11.q.a(), ((sc7.a) r3).i) == true) goto L82;
            r11.q.c(((sc7.a) r3).i);
            r15 = true;
        L82:
            if (StringUtils.equal(r11.i.a(), ((sc7.a) r3).j) == true) goto L84;
            r11.i.c(((sc7.a) r3).j);
            r15 = true;
        L84:
            boolean r17 = r11.L.a().booleanValue();
            boolean r18 = ((sc7.a) r3).l;
            if (r17 == r18) goto L87;
            r11.L.c(Boolean.valueOf(r18));
            r15 = true;
        L87:
            int r19 = r11.I.a().intValue();
            int r110 = ((sc7.a) r3).f;
            if (r19 == r110) goto L90;
            r11.I.c(Integer.valueOf(r110));
            r15 = true;
        L90:
            boolean r111 = r11.T.a().booleanValue();
            boolean r112 = ((sc7.a) r3).m;
            if (r111 == r112) goto L93;
            r11.T.c(Boolean.valueOf(r112));
            r15 = true;
        L93:
            boolean r113 = r11.W.a().booleanValue();
            boolean r114 = ((sc7.a) r3).n;
            if (r113 == r114) goto L96;
            r11.W.c(Boolean.valueOf(r114));
            r15 = true;
        L96:
            cra.a[] r115 = r11.Z.a();
            int r116 = r115.length;
            int r117 = 0;
            boolean r118 = false;
        L97:
            if (r117 >= r116) goto L112;
            cra.a r119 = r115[r117];
            boolean r20 = r15;
            boolean r21 = r16;
            cra.a r22 = (cra.a) ((HashMap) ((sc7.a) r3).c).get(r119.a);
            if (r22 != null) goto L105;
            if (r119.b == false) goto L103;
            r118 = true;
        L103:
            r119.e();
            r115 = r115;
            r116 = r116;
        L111:
            r117 = r117 + 1;
            r115 = r115;
            r15 = r20;
            r16 = r21;
            r116 = r116;
            goto L97
        L105:
            if (r119.b == true) goto L108;
            r119.b = true;
            r118 = true;
        L108:
            r119.l = r22.l;
            r119.i = r22.i;
            r119.j = r22.j;
            r119.c = r22.c;
            r119.d = r22.d;
            r119.e = r22.e;
            r119.k = r22.k;
            r119.h = r22.h;
            r119.f = r22.f;
            r119.p = r22.p;
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.T == 0) goto L111;
            r119.n = r22.n;
            goto L111
        L112:
            boolean r23 = r15;
            boolean r24 = r16;
            if (r118 == false) goto L115;
            r15 = true;
        L117:
            if (r11.Y.a() != null) goto L119;
        L121:
            r11.Y.c(((sc7.a) r3).p);
            if ((r3 instanceof com.ss.android.account.d) == false) goto L222;
            com.ss.android.account.d r25 = r3;
            if (StringUtils.equal(r11.r.a(), ((com.ss.android.account.a) r25).r) == true) goto L127;
            r11.r.c(((com.ss.android.account.a) r25).r);
            r15 = true;
        L127:
            if (StringUtils.equal(r11.s.a(), r25.u) == true) goto L130;
            r11.s.c(r25.u);
            r15 = true;
        L130:
            if (StringUtils.equal(r11.F.a(), r25.v) == true) goto L132;
            r11.F.c(r25.v);
            r15 = true;
        L132:
            int r120 = r11.j.a().intValue();
            int r121 = r25.K;
            if (r120 == r121) goto L136;
            r11.j.c(Integer.valueOf(r121));
            r15 = true;
        L136:
            if (StringUtils.equal(r11.h.a(), ((com.ss.android.account.a) r25).s) == true) goto L139;
            r11.h.c(((com.ss.android.account.a) r25).s);
            r15 = true;
        L139:
            if (StringUtils.equal(r11.d.a(), ((com.ss.android.account.a) r25).t) == true) goto L141;
            r11.d.c(((com.ss.android.account.a) r25).t);
            r15 = true;
        L141:
            boolean r122 = r11.E.a().booleanValue();
            boolean r123 = r25.L;
            if (r122 == r123) goto L145;
            r11.E.c(Boolean.valueOf(r123));
            r15 = true;
        L145:
            if (StringUtils.equal(r11.f.a(), r25.M) == true) goto L148;
            r11.f.c(r25.M);
            r15 = true;
        L148:
            if (StringUtils.equal(r11.c.a(), r25.N) == true) goto L151;
            r11.c.c(r25.N);
            r15 = true;
        L151:
            if (StringUtils.equal(r11.k.a(), r25.O) == true) goto L153;
            r11.k.c(r25.O);
            r15 = true;
        L153:
            boolean r124 = r11.o.a().booleanValue();
            boolean r125 = r25.R;
            if (r124 == r125) goto L156;
            r11.o.c(Boolean.valueOf(r125));
            r15 = true;
        L156:
            int r126 = r11.m.a().intValue();
            int r127 = r25.P;
            if (r126 == r127) goto L159;
            r11.m.c(Integer.valueOf(r127));
            r15 = true;
        L159:
            int r128 = r11.l.a().intValue();
            int r129 = r25.Q;
            if (r128 == r129) goto L162;
            r11.l.c(Integer.valueOf(r129));
            r15 = true;
        L162:
            boolean r130 = r11.n.a().booleanValue();
            boolean r131 = r25.z;
            if (r130 == r131) goto L166;
            r11.n.c(Boolean.valueOf(r131));
            r15 = true;
        L166:
            if (StringUtils.equal(r11.t.a(), r25.A) == true) goto L168;
            r11.t.c(r25.A);
            r15 = true;
        L168:
            int r132 = r11.g.a().intValue();
            int r133 = r25.D;
            if (r132 == r133) goto L171;
            r11.g.c(Integer.valueOf(r133));
            r15 = true;
        L171:
            int r134 = r11.v.a().intValue();
            int r135 = r25.F;
            if (r134 == r135) goto L174;
            r11.v.c(Integer.valueOf(r135));
            r15 = true;
        L174:
            int r136 = r11.w.a().intValue();
            int r137 = r25.G;
            if (r136 == r137) goto L177;
            r11.w.c(Integer.valueOf(r137));
            r15 = true;
        L177:
            int r138 = r11.u.a().intValue();
            int r139 = r25.E;
            if (r138 == r139) goto L181;
            r11.u.c(Integer.valueOf(r139));
            r15 = true;
        L181:
            if (StringUtils.equal(r11.A.a(), r25.B) == true) goto L183;
            r11.A.c(r25.B);
            r15 = true;
        L183:
            long r140 = r11.p.a().longValue();
            long r141 = r25.H;
            if (r140 == r141) goto L187;
            r11.p.c(Long.valueOf(r141));
            r15 = true;
        L187:
            if (StringUtils.equal(r11.N.a(), r25.x) == true) goto L190;
            r11.N.c(r25.x);
            r15 = true;
        L190:
            if (StringUtils.equal(r11.O.a(), r25.y) == true) goto L192;
            r11.O.c(r25.y);
            r15 = true;
        L192:
            long r142 = r11.M.a().longValue();
            long r143 = r25.w;
            if (r142 == r143) goto L196;
            r11.M.c(Long.valueOf(r143));
            r15 = true;
        L196:
            if (TextUtils.isEmpty(r11.e.a()) == true) goto L202;
            if (TextUtils.isEmpty(r25.I) == true) goto L202;
            if (StringUtils.equal(r11.e.a(), r25.I) == true) goto L202;
        L209:
            r11.e.c(r25.I);
            r15 = true;
        L210:
            int r144 = r11.P.a().intValue();
            int r145 = r25.J;
            if (r144 == r145) goto L214;
            r11.P.c(Integer.valueOf(r145));
            r15 = true;
        L214:
            if (StringUtils.equal(r11.z.a(), r25.C) == true) goto L216;
            r11.z.c(r25.C);
            r15 = true;
        L216:
            r11.X.c(r25.S);
            int r146 = r11.H0.a().intValue();
            int r147 = r25.T;
            if (r146 == r147) goto L219;
            r11.H0.c(Integer.valueOf(r147));
            r15 = true;
        L219:
            boolean r148 = r11.p0.a().booleanValue();
            boolean r26 = r25.U;
            if (r148 == r26) goto L222;
            r11.p0.c(Boolean.valueOf(r26));
            r15 = true;
        L202:
            if (TextUtils.isEmpty(r11.e.a()) == false) goto L206;
            if (TextUtils.isEmpty(r25.I) == false) goto L209;
        L206:
            if (TextUtils.isEmpty(r11.e.a()) == true) goto L210;
            if (TextUtils.isEmpty(r25.I) == false) goto L210;
        L222:
            r11.K.c(Boolean.TRUE);
            r14 = r24;
            boolean r28 = true;
        L223:
            if (r15 == false) goto L225;
            r11.q();
        L225:
            if (r15 == true) goto L227;
            if (r12 == true) goto L227;
        L238:
            if (r15 == true) goto L325;
        L288:
            if (r14 == false) goto L290;
            j.v(r11.B.a().longValue(), r11.k());
            r11.w(XmlPullParser.NO_NAMESPACE);
            r11.x(XmlPullParser.NO_NAMESPACE);
        L290:
            j r29 = j.k1;
            if (TextUtils.equals(r10, r29.k0.a()) == true) goto L294;
            r29.k0.c(r10);
            SharedPreferences.Editor r30 = r29.P0.edit();
            r30.putString("header_session_id", r29.k0.a());
            SharedPrefsEditorCompat.apply(r30);
            j.v(r29.B.a().longValue(), r29.k());
        L294:
            if (TextUtils.isEmpty(r10) == false) goto L316;
            com.bytedance.sdk.account.settings.common.a.a();
            if (com.bytedance.sdk.account.settings.common.a.z == false) goto L316;
            String r31 = r35.d;
            String r32 = r35.a;
            String r34 = ((sc7.a) r3).h;
            String r37 = r8.toString();
            long r38 = ((sc7.a) r3).a;
            HashSet r149 = TTTokenMonitor.b;
            JSONObject r150 = new JSONObject();     // Catch: JSONException -> L314
            r150.put("path", r31);     // Catch: JSONException -> L314
            r150.put("logid", r32);     // Catch: JSONException -> L314
            if (r34 != null) goto L301;
        L311:
            String r151 = XmlPullParser.NO_NAMESPACE;
        L312:
            r150.put("body_session_key", r151);     // Catch: JSONException -> L314
            r150.put("header_keys", r37);     // Catch: JSONException -> L314
            r150.put("uid", r38);     // Catch: JSONException -> L314
            com.bytedance.sdk.account.monitor.a.a("passport_response_header_sessionid_miss", r150);     // Catch: JSONException -> L314
            goto L316
        L301:
            if (r34.isEmpty() == true) goto L311;
            int r39 = r34.length();     // Catch: JSONException -> L314
            r151 = "*";
            if (6 >= r39) goto L312;
            StringBuilder r152 = new StringBuilder();     // Catch: JSONException -> L314
            int r153 = 0;
            r152.append(r34, 0, 3);     // Catch: JSONException -> L314
        L307:
            int r154 = r39 - 3;     // Catch: JSONException -> L314
            if (r153 >= (r154 - 3)) goto L310;
            r152.append("*");     // Catch: JSONException -> L314
            r153 = r153 + 1;     // Catch: JSONException -> L314
            goto L307
        L310:
            r152.append(r34, r154, r39);     // Catch: JSONException -> L314
            r151 = r152.toString();     // Catch: JSONException -> L314
        L314:
            e = move-exception;
            tb7.a.c("AccountSDK", "monitorResponseHeaderSessionIdMiss error", e);
        L316:
            long r40 = ((sc7.a) r3).a;
            if (r4 == r40) goto L356;
            TTTokenMonitor.o(Long.valueOf(r4), Long.valueOf(r40), TTTokenMonitor.a(r35.d), "api");
            return;
        L356:
            return;
        L325:
        L279:
            e = move-exception;
            e.printStackTrace();
        L281:
            kc7.c r41 = null;
        L282:
            gc7.d.a = null;
            gc7.d.b = null;
            if (r41 == null) goto L288;
            com.bytedance.sdk.account.impl.m r42 = new com.bytedance.sdk.account.impl.m();
            com.ss.android.account.k.d().e();
            if (r41.getType() == 7) goto L288;
            new gc7.b(r41, r42).b();
            goto L288
        L241:
            if (gc7.d.a == null) goto L281;
            long r210 = new Date().getTime();     // Catch: Exception -> L279
            JSONObject r155 = ((sc7.a) r3).o;     // Catch: Exception -> L279
            if (r155 == null) goto L275;
            long r156 = ((sc7.a) r3).a;     // Catch: Exception -> L279
            String r157 = ((sc7.a) r3).e;     // Catch: Exception -> L279
            String r158 = r155.optString("screen_name");     // Catch: Exception -> L279
            String r43 = ((sc7.a) r3).o.optString("avatar_url");     // Catch: Exception -> L279
            if (gc7.d.a.intValue() != 6) goto L260;
            Map r44 = ((sc7.a) r3).c;     // Catch: Exception -> L279
            if (r44 == null) goto L258;
            HashMap r45 = (HashMap) r44;     // Catch: Exception -> L279
            Iterator r159 = r45.keySet().iterator();     // Catch: Exception -> L279
            String r160 = null;
            String r161 = null;
        L250:
            if (r159.hasNext() == false) goto L257;
            String r46 = (String) r159.next();     // Catch: Exception -> L279
            String r211 = r43;
            if (r46.contains(gc7.d.b) == false) goto L256;
            gc7.d.b = r46;     // Catch: Exception -> L279
            cra.a r47 = (cra.a) r45.get(r46);     // Catch: Exception -> L279
            if (r47 == null) goto L256;
            String r48 = r47.c;     // Catch: Exception -> L279
            r160 = r47.d;     // Catch: Exception -> L279
            r161 = r48;
        L256:
            r43 = r211;
            goto L250
        L257:
            String r212 = r43;
        L259:
            String r213 = r158;
            long r214 = r156;
            String r215 = r157;
            String r310 = r160;
            String r311 = r161;
            String r216 = r212;
            kc7.a r312 = null;
        L277:
            r41 = new kc7.c(r210, gc7.d.a.intValue(), gc7.d.b, r214, r215, r216, r213, r310, r311, r312);     // Catch: Exception -> L279
            goto L282
        L258:
            r212 = r43;
            r160 = null;
            r161 = null;
            goto L259
        L260:
            String r217 = r43;
            if (gc7.d.a.intValue() != 1) goto L264;
            gc7.d.b = ((sc7.a) r3).i;     // Catch: Exception -> L279
            Integer r49 = Integer.valueOf(((sc7.a) r3).f);     // Catch: Exception -> L279
            kc7.a r50 = new kc7.a();     // Catch: Exception -> L279
            r50.a = r49;     // Catch: Exception -> L279
        L276:
            r312 = r50;
            r213 = r158;
            r214 = r156;
            r215 = r157;
            r216 = r217;
            r310 = null;
            r311 = null;
            goto L277
        L264:
            if (gc7.d.a.intValue() != 2) goto L266;
        L269:
            int r51 = ((sc7.a) r3).f;     // Catch: Exception -> L279
            if (TextUtils.isEmpty(gc7.d.b) == false) goto L272;
        L274:
            Integer r52 = Integer.valueOf(r51);     // Catch: Exception -> L279
            r50 = new kc7.a();     // Catch: Exception -> L279
            r50.a = r52;     // Catch: Exception -> L279
            goto L276
        L272:
            if (gc7.d.b.startsWith("+") == false) goto L274;
            gc7.d.b = gc7.d.b.replace("+" + r51, XmlPullParser.NO_NAMESPACE);     // Catch: Exception -> L279
            goto L274
        L266:
            if (gc7.d.a.intValue() == 3) goto L269;
            r50 = null;
            goto L276
        L275:
            r50 = null;
            r158 = null;
            r156 = 0;
            r157 = null;
            r217 = null;
        L227:
            if (r28 == false) goto L229;
            ta7.e r162 = new ta7.e();
        L230:
            ((ta7.b) r162).b = r28;
            ((ta7.b) r162).e = r6;
            ((ta7.b) r162).d = r14;
            tb7.a.d("BDAccountManager", "notifyUserInfoChange(), extra=" + r6);
            Set<ta7.c> r53 = r11.b1;
            monitor-enter(r53);
            Iterator r54 = ((HashSet) r11.b1).iterator();     // Catch: Throwable -> L319
        L234:
            if (r54.hasNext() == false) goto L236;
            ta7.c r163 = (ta7.c) r54.next();     // Catch: Throwable -> L319
            tb7.a.d("BDAccountManager", "notifyUserInfoChange(), listener=" + r163.getClass().getName());     // Catch: Throwable -> L319
            r163.M(r162);     // Catch: Throwable -> L319
            goto L234
        L236:
            monitor-exit(r53);     // Catch: Throwable -> L319
        L319:
            th = move-exception;
            throw th;
        L229:
            r162 = new ta7.b(0);
            goto L230
        L119:
            if (((sc7.a) r3).o == null) goto L121;
            r11.Y.a().optJSONObject("data");
            goto L121
        L115:
            r15 = r23;
            goto L117
        L71:
            r16 = false;
            goto L73
        L51:
            if (r11.K.a().booleanValue() == false) goto L56;
            b0 r55 = r11.f3J;
            Boolean r164 = Boolean.FALSE;
            r55.c(r164);
            r11.K.c(r164);
            r11.B.c(0L);
            r11.D.c(XmlPullParser.NO_NAMESPACE);
            r11.C.c(0);
            r11.r.c(XmlPullParser.NO_NAMESPACE);
            r11.j.c(0);
            r11.s.c(XmlPullParser.NO_NAMESPACE);
            r11.F.c(XmlPullParser.NO_NAMESPACE);
            r11.d.c(XmlPullParser.NO_NAMESPACE);
            r11.f.c(XmlPullParser.NO_NAMESPACE);
            r11.c.c(XmlPullParser.NO_NAMESPACE);
            r11.k.c(XmlPullParser.NO_NAMESPACE);
            r11.A.c(XmlPullParser.NO_NAMESPACE);
            r11.h.c(XmlPullParser.NO_NAMESPACE);
            r11.E.c(r164);
            r11.n.c(r164);
            r11.G.c(XmlPullParser.NO_NAMESPACE);
            r11.Q.c(0);
            r11.R.c(0);
            r11.S.c(0);
            r11.l.c(0);
            r11.m.c(0);
            r11.o.c(r164);
            r11.L.c(r164);
            r11.p.c(0L);
            r11.e.c(XmlPullParser.NO_NAMESPACE);
            r11.P.c(0);
            r11.N.c(XmlPullParser.NO_NAMESPACE);
            r11.M.c(0L);
            r11.O.c(XmlPullParser.NO_NAMESPACE);
            r11.z.c(XmlPullParser.NO_NAMESPACE);
            r11.T.c(r164);
            r11.H0.c(0);
            r11.p0.c(r164);
            r11.Y.c(null);
            r11.X.c(null);
            r11.U.c(null);
            cra.a[] r56 = r11.Z.a();
            int r165 = r56.length;
            int r166 = 0;
        L53:
            if (r166 >= r165) goto L55;
            r56[r166].e();
            r166 = r166 + 1;
            goto L53
        L55:
            r15 = true;
        L56:
            r28 = false;
            goto L223
        L45:
            if (r5 == r11.C.a().intValue()) goto L47;
            r11.C.c(Integer.valueOf(r5));
            r15 = true;
            goto L49
        L24:
            if (r9.isEmpty() == true) goto L42;
            Iterator r57 = r9.iterator();
        L27:
            if (r57.hasNext() == false) goto L42;
            wqa.i r167 = (wqa.i) r57.next();
            if (r167 == null) goto L27;
            if (TextUtils.isEmpty(r167.a) == true) goto L27;
            if (TextUtils.isEmpty(r167.b) == true) goto L27;
            String r168 = r167.a.toLowerCase();
            r8.append(r168);
            r8.append(",");
            r168.getClass();
            if (r168.equals("x-tt-token") == false) goto L38;
            r7 = r167.b;
            goto L27
        L38:
            if (r168.equals("x-tt-passport-session-id") == false) goto L27;
            r2 = r167.b;
            goto L27
        L20:
            r6 = null;
            goto L21
        L322:
            return;
        L6:
            if ((r35 instanceof ua7.e) == false) goto L12;
            wb7.d r58 = ((ua7.e) r35).p;
            if ((r58 instanceof wb7.d) == false) goto L10;
            r0 = r58.getUserInfo();
            goto L14
        L10:
            r0 = null;
            goto L14
        L12:
            if ((r35 instanceof xa7.g) == false) goto L15;
            r0 = ((xa7.g) r35).v;
            goto L14
        L15:
            r3 = null;
            goto L16
        }
    }

    public class h extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_mobile", XmlPullParser.NO_NAMESPACE);
        }

        public h(j r1) {
            this.d = r1;
        }
    }

    public class h0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("pgc_name", XmlPullParser.NO_NAMESPACE);
        }

        public h0(j r1) {
            this.d = r1;
        }
    }

    public class i extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_name", XmlPullParser.NO_NAMESPACE);
        }

        public i(j r1) {
            this.d = r1;
        }
    }

    public class i0 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("display_ocr_entrance", 0));
        }

        public i0(j r1) {
            this.d = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.impl.j$j, reason: collision with other inner class name */
    public class C0004j extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("screen_name", XmlPullParser.NO_NAMESPACE);
        }

        public C0004j(j r1) {
            this.d = r1;
        }
    }

    public class j0 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("following_count", 0));
        }

        public j0(j r1) {
            this.d = r1;
        }
    }

    public class k extends com.bytedance.sdk.account.utils.i<ta7.h> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final ta7.h b() {
            Context r0 = this.d.L0;
            if (com.bytedance.sdk.account.impl.g.b != null) goto L15;
            monitor-enter(com.bytedance.sdk.account.impl.g.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (com.bytedance.sdk.account.impl.g.b != null) goto L9;
            com.bytedance.sdk.account.impl.g.b = new com.bytedance.sdk.account.impl.g(r0);     // Catch: Throwable -> L11
        L9:
            monitor-exit(com.bytedance.sdk.account.impl.g.class);     // Catch: Throwable -> L11
        L15:
            return com.bytedance.sdk.account.impl.g.b;
        }

        public k(j r1) {
            this.d = r1;
        }
    }

    public class k0 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("followers_count", 0));
        }

        public k0(j r1) {
            this.d = r1;
        }
    }

    public class l extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("recommend_hint_message", XmlPullParser.NO_NAMESPACE);
        }

        public l(j r1) {
            this.d = r1;
        }
    }

    public class l0 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("visitors_count", 0));
        }

        public l0(j r1) {
            this.d = r1;
        }
    }

    public class m extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("can_sync_share", 0));
        }

        public m(j r1) {
            this.d = r1;
        }
    }

    public class m0 extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("is_visitor_account", false));
        }

        public m0(j r1) {
            this.d = r1;
        }
    }

    public class n extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("user_privacy_extend", 0));
        }

        public n(j r1) {
            this.d = r1;
        }
    }

    public class n0 extends com.bytedance.sdk.account.utils.i<sc7.a> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final sc7.a b() {
            j r0 = this.d;
            r0.getClass();
            com.ss.android.account.d r1 = new com.ss.android.account.d(r0.Y.a());
            ((sc7.a) r1).a = r0.B.a().longValue();
            ((sc7.a) r1).b = r0.C.a().intValue();
            ((sc7.a) r1).g = r0.f3J.a().booleanValue();
            ((sc7.a) r1).h = r0.G.a();
            ((com.ss.android.account.a) r1).r = r0.r.a();
            r1.K = r0.j.a().intValue();
            r1.u = r0.s.a();
            r1.v = r0.F.a();
            ((com.ss.android.account.a) r1).t = r0.d.a();
            r1.M = r0.f.a();
            r1.L = r0.E.a().booleanValue();
            r1.N = r0.c.a();
            r1.O = r0.k.a();
            r1.B = r0.A.a();
            ((com.ss.android.account.a) r1).s = r0.h.a();
            r1.z = r0.n.a().booleanValue();
            r1.A = r0.t.a();
            r1.D = r0.g.a().intValue();
            r1.E = r0.u.a().intValue();
            r1.I = r0.e.a();
            r0.Q.a().intValue();
            r0.R.a().intValue();
            r0.S.a().intValue();
            r1.H = r0.p.a().longValue();
            ((sc7.a) r1).j = r0.i.a();
            r1.C = r0.z.a();
            r1.J = r0.P.a().intValue();
            r1.G = r0.w.a().intValue();
            r1.F = r0.v.a().intValue();
            r1.Q = r0.l.a().intValue();
            r1.P = r0.m.a().intValue();
            r1.R = r0.o.a().booleanValue();
            r0.L.a().booleanValue();
            r1.x = r0.N.a();
            r1.w = r0.p.a().longValue();
            r1.y = r0.O.a();
            ((sc7.a) r1).f = r0.I.a().intValue();
            ((sc7.a) r1).k = r0.D.a();
            ((sc7.a) r1).m = r0.T.a().booleanValue();
            ((sc7.a) r1).n = r0.W.a().booleanValue();
            r1.S = r0.X.a();
            cra.a[] r2 = r0.Z.a();
            int r3 = r2.length;
            int r4 = 0;
        L3:
            if (r4 >= r3) goto L12;
            cra.a r5 = r2[r4];
            if (TextUtils.isEmpty(r5.a) == true) goto L11;
            if (r5.b == false) goto L11;
            ((HashMap) ((sc7.a) r1).c).put(r5.a, r5);
        L11:
            r4 = r4 + 1;
            goto L3
        L12:
            r1.T = r0.H0.a().intValue();
            r1.U = r0.p0.a().booleanValue();
            j r6 = this.d;
            Set<String> r7 = r6.P0.getStringSet("store_key_saved_platform_app_id", null);
            if (r7 != null) goto L32;
        L31:
            return r1;
        L32:
            Iterator<String> r8 = r7.iterator();     // Catch: Exception -> L29
        L16:
            if (r8.hasNext() == false) goto L31;
            String r9 = r8.next();     // Catch: Exception -> L29
            String r10 = r6.P0.getString("_platform_" + r9, null);     // Catch: Exception -> L29
            if (TextUtils.isEmpty(r10) == true) goto L16;
            cra.a r11 = j.n(new JSONObject(r10), null);     // Catch: Exception -> L29
            if (r11 == null) goto L16;
            Map r12 = (Map) ((HashMap) ((sc7.a) r1).d).get(r11.a);     // Catch: Exception -> L29
            if (r12 != null) goto L27;
            r12 = new HashMap();     // Catch: Exception -> L29
            ((HashMap) ((sc7.a) r1).d).put(r11.a, r12);     // Catch: Exception -> L29
        L27:
            r12.put(String.valueOf(r11.l), r11);     // Catch: Exception -> L29
        L29:
            e = move-exception;
            e.printStackTrace();
            goto L31
        }

        public n0(j r1) {
            this.d = r1;
        }
    }

    public class o extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("user_privacy_extend_value", 2147483646));
        }

        public o(j r1) {
            this.d = r1;
        }
    }

    public class o0 extends com.bytedance.sdk.account.utils.i<Set<String>> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Set<String> b() {
            return this.d.P0.getStringSet("has_update_sec_uids", new HashSet());
        }

        public o0(j r1) {
            this.d = r1;
        }
    }

    public class p extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("multi_sids", XmlPullParser.NO_NAMESPACE);
        }

        public p(j r1) {
            this.d = r1;
        }
    }

    public class p0 extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("is_kids_mode", false));
        }

        public p0(j r1) {
            this.d = r1;
        }
    }

    public class q extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("sec_multi_sids", XmlPullParser.NO_NAMESPACE);
        }

        public q(j r1) {
            this.d = r1;
        }

        @Override // com.bytedance.sdk.account.utils.i
        public final void c(String r3) {
            String r4 = r3;
            super.c(r4);
            this.d.P0.edit().putString("sec_multi_sids", r4).apply();
        }
    }

    public class q0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("avatar_url", XmlPullParser.NO_NAMESPACE);
        }

        public q0(j r1) {
            this.d = r1;
        }
    }

    public class r extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_auth_info", XmlPullParser.NO_NAMESPACE);
        }

        public r(j r1) {
            this.d = r1;
        }
    }

    public class r0 extends com.bytedance.sdk.account.utils.i<JSONObject> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final JSONObject b() {
            return new JSONObject(this.d.P0.getString("expend_attrs", "{}"));
        L5:
            return new JSONObject();
        }

        public r0(j r1) {
            this.d = r1;
        }
    }

    public class s extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_decoration", XmlPullParser.NO_NAMESPACE);
        }

        public s(j r1) {
            this.d = r1;
        }
    }

    public class s0 extends com.bytedance.sdk.account.utils.i<JSONObject> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final JSONObject b() {
            return new JSONObject(this.d.P0.getString("raw_json", "{}"));
        L5:
            return new JSONObject();
        }

        public s0(j r1) {
            this.d = r1;
        }
    }

    public class t extends com.bytedance.sdk.account.utils.i<Long> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Long b() {
            long r2 = 0;
            long r0 = this.d.P0.getLong("user_id", 0);
            if (this.d.K.a().booleanValue() == false) goto L8;
            if (r0 > 0) goto L8;
            this.d.K.c(Boolean.FALSE);
            this.d.D.c(XmlPullParser.NO_NAMESPACE);
            this.d.C.c(0);
        L14:
            return Long.valueOf(r2);
        L8:
            if (this.d.K.a().booleanValue() == false) goto L10;
        L12:
            r2 = r0;
            goto L14
        L10:
            if (r0 <= 0) goto L12;
            this.d.D.c(XmlPullParser.NO_NAMESPACE);
            this.d.C.c(0);
            goto L14
        }

        public t(j r1) {
            this.d = r1;
        }
    }

    public class t0 extends com.bytedance.sdk.account.utils.i<cra.a[]> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final cra.a[] b() {
            d().getMethod("init", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L5
        L7:
            cra.a[] r2 = j.h1;
            j r3 = this.d;
            r3.getClass();
            int r4 = 0;
        L9:
            if (r4 >= r2.length) goto L22;
            cra.a r5 = r2[r4];
            r5.b = false;
        L19:
            e = move-exception;
            e.printStackTrace();
        L21:
            r4 = r4 + 1;
            goto L9
        L12:
            if (TextUtils.isEmpty(r5.a) == true) goto L21;
            String r6 = r3.P0.getString("_platform_" + r5.a, null);     // Catch: Exception -> L19
            if (TextUtils.isEmpty(r6) == true) goto L21;
            j.n(new JSONObject(r6), r5);     // Catch: Exception -> L19
            goto L21
        L22:
            return r2;
        L5:
            e = move-exception;
            tb7.a.c("BDAccountManager", "try init BDAccountManagerAdapter fail", e);
            goto L7
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class d() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.bytedance.sdk.account.impl.BDAccountManagerAdapter");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

        public t0(j r1) {
            this.d = r1;
        }
    }

    public class u extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("odin_user_type", 0));
        }

        public u(j r1) {
            this.d = r1;
        }
    }

    public class u0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("header_session_id", XmlPullParser.NO_NAMESPACE);
        }

        public u0(j r1) {
            this.d = r1;
        }
    }

    public class v extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("sec_user_id", XmlPullParser.NO_NAMESPACE);
        }

        public v(j r1) {
            this.d = r1;
        }
    }

    public class v0 extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("use_hm_region", false));
        }

        public v0(j r1) {
            this.d = r1;
        }
    }

    public class w extends com.bytedance.sdk.account.utils.i<Boolean> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Boolean b() {
            return Boolean.valueOf(this.d.P0.getBoolean("user_verified", false));
        }

        public w(j r1) {
            this.d = r1;
        }
    }

    public class w0 extends com.bytedance.sdk.account.utils.i<Integer> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final Integer b() {
            return Integer.valueOf(this.d.P0.getInt("hm_region", 0));
        }

        public w0(j r1) {
            this.d = r1;
        }
    }

    public class x extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("verified_content", XmlPullParser.NO_NAMESPACE);
        }

        public x(j r1) {
            this.d = r1;
        }
    }

    public class x0 implements com.ss.android.token.c {
        public final /* synthetic */ j a;

        @Override // com.ss.android.token.c
        public final void onInitFinish() {
            if (this.a.B.a().longValue() <= 0) goto L6;
            j.v(this.a.B.a().longValue(), this.a.k());
            return;
        }

        public x0(j r1) {
            this.a = r1;
        }
    }

    public class y extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("session_key", XmlPullParser.NO_NAMESPACE);
        }

        public y(j r1) {
            this.d = r1;
        }
    }

    public class y0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("bg_img_url", XmlPullParser.NO_NAMESPACE);
        }

        public y0(j r1) {
            this.d = r1;
        }
    }

    public class z extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("session_sign", XmlPullParser.NO_NAMESPACE);
        }

        public z(j r1) {
            this.d = r1;
        }
    }

    public class z0 extends com.bytedance.sdk.account.utils.i<String> {
        public final /* synthetic */ j d;

        @Override // com.bytedance.sdk.account.utils.i
        public final String b() {
            return this.d.P0.getString("user_birthday", XmlPullParser.NO_NAMESPACE);
        }

        public z0(j r1) {
            this.d = r1;
        }
    }

    static {
        h1 = new cra.a[]{new cra.a("mobile"), new cra.a("email"), new cra.a("google"), new cra.a("facebook"), new cra.a("twitter"), new cra.a("instagram"), new cra.a("line"), new cra.a("kakaotalk"), new cra.a("vk"), new cra.a("tiktok")};
        ArrayList r1 = new ArrayList();
        p1 = r1;
        r1.add(new g1());
        r1.add(new e1());
        r1.add(new f1());
    }

    @Override // ta7.f
    public final void f() {
        this.y.c(XmlPullParser.NO_NAMESPACE);
    }

    @Override // ta7.f
    public final void g() {
        this.x.c(XmlPullParser.NO_NAMESPACE);
        this.P0.edit().putString("multi_sids", XmlPullParser.NO_NAMESPACE).apply();
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
        SharedPreferences.Editor r1 = this.P0.edit();
        s(r1);
        t();
        r1.remove("session");
        r1.putBoolean("is_login", this.K.a().booleanValue());
        r1.putLong("user_id", this.B.a().longValue());
        r1.putInt("odin_user_type", this.C.a().intValue());
        r1.putString("sec_user_id", this.D.a());
        r1.putString("session_key", this.G.a());
        r1.putString("session_sign", this.H.a());
        r1.putString("user_name", this.r.a());
        r1.putString("verified_content", this.F.a());
        r1.putInt("user_gender", this.j.a().intValue());
        r1.putString("screen_name", this.s.a());
        r1.putBoolean("user_verified", this.E.a().booleanValue());
        r1.putString("avatar_url", this.d.a());
        r1.putBoolean("is_new_user", this.f3J.a().booleanValue());
        r1.putString("user_email", this.i.a());
        r1.putString("user_mobile", this.q.a());
        r1.putInt("is_blocked", this.l.a().intValue());
        r1.putInt("is_blocking", this.m.a().intValue());
        r1.putBoolean("is_toutiao", this.o.a().booleanValue());
        r1.putBoolean("user_has_pwd", this.L.a().booleanValue());
        r1.putInt("country_code", this.I.a().intValue());
        r1.putString("area", this.c.a());
        r1.putString("user_industry", this.k.a());
        r1.putString("user_decoration", this.A.a());
        r1.putString("user_birthday", this.f.a());
        r1.putLong("pgc_mediaid", this.M.a().longValue());
        r1.putString("pgc_avatar_url", this.N.a());
        r1.putString("pgc_name", this.O.a());
        r1.putString("user_description", this.h.a());
        r1.putBoolean("is_recommend_allowed", this.n.a().booleanValue());
        r1.putString("recommend_hint_message", this.t.a());
        r1.putInt("can_be_found_by_phone", this.g.a().intValue());
        r1.putInt("can_sync_share", this.u.a().intValue());
        r1.putInt("following_count", this.Q.a().intValue());
        r1.putInt("followers_count", this.R.a().intValue());
        r1.putInt("visitors_count", this.S.a().intValue());
        r1.putLong("media_id", this.p.a().longValue());
        r1.putString("bg_img_url", this.e.a());
        r1.putInt("display_ocr_entrance", this.P.a().intValue());
        r1.putString("user_auth_info", this.z.a());
        r1.putInt("user_privacy_extend", this.v.a().intValue());
        r1.putInt("user_privacy_extend_value", this.w.a().intValue());
        r1.putBoolean("is_visitor_account", this.T.a().booleanValue());
        r1.putBoolean("is_kids_mode", this.W.a().booleanValue());
        r(r1);
        if (this.X.a() != null) goto L5;
        r1.putString("expend_attrs", XmlPullParser.NO_NAMESPACE);
    L6:
        r1.putBoolean("use_hm_region", this.p0.a().booleanValue());
        r1.putInt("hm_region", this.H0.a().intValue());
        if (this.Y.a() != null) goto L9;
        r1.putString("raw_json", XmlPullParser.NO_NAMESPACE);
    L10:
        SharedPrefsEditorCompat.apply(r1);
        o("saveData");
        return;
    L9:
        r1.putString("raw_json", this.Y.a().toString());
        goto L10
    L5:
        r1.putString("expend_attrs", this.X.toString());
        goto L6
    }

    public final void t() {
        if (this.U.a() != null) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.P0.edit();
        Set<String> r2 = this.P0.getStringSet("store_key_saved_platform_app_id", null);
        if (r2 == null) goto L27;
        Iterator<String> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L27;
        String r5 = r3.next();
        String r6 = "_platform_" + r5;
        String r7 = this.P0.getString(r6, null);
        if (TextUtils.isEmpty(r7) == true) goto L12;
        Map r8 = (Map) ((HashMap) this.U.a().d).get(new JSONObject(r7).optString("mName"));     // Catch: Exception -> L25
        if (r8 == null) goto L23;
        if (r8.isEmpty() == true) goto L23;
        cra.a r9 = (cra.a) r8.get(r5);     // Catch: Exception -> L25
        if (r9 == null) goto L22;
        if (r9.b == true) goto L9;
    L22:
        r1.remove(r6);     // Catch: Exception -> L25
    L23:
        r1.remove(r6);     // Catch: Exception -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L9
    L12:
        r1.remove(r6);
    L27:
        HashSet r4 = new HashSet();
        Iterator r10 = ((HashMap) this.U.a().d).values().iterator();
    L29:
        if (r10.hasNext() == false) goto L47;
        Map r11 = (Map) r10.next();
        if (r11 == null) goto L29;
        if (r11.isEmpty() == true) goto L29;
        Iterator r12 = r11.keySet().iterator();
    L37:
        if (r12.hasNext() == false) goto L29;
        String r13 = (String) r12.next();
        cra.a r14 = (cra.a) r11.get(r13);
        if (r14 == null) goto L37;
        if (r14.b == false) goto L37;
        JSONObject r15 = j(r14);
        if (r15 == null) goto L37;
        r1.putString("_platform_" + r13, r15.toString());
        r4.add(r13);
        goto L37
    L47:
        r1.putStringSet("store_key_saved_platform_app_id", r4);
        r1.apply();
    }

    public final void u() {
        if (this.V0 != null) goto L5;
        return;
    L5:
        if (com.ss.android.account.k.c == null) goto L7;
        com.ss.android.account.k.c.getClass();
    L7:
        this.V0.sendEmptyMessageDelayed(EventsUtils.FEAT_TYPE_SHUT_DOWN, 600000);
    }

    public final String k() {
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.z == false) goto L7;
        return this.k0.a();
    L7:
        return this.G.a();
    }

    @Override // ta7.f
    public final String b() {
        return this.b;
    }

    @Override // ta7.f
    public final String c() {
        return this.g1;
    }

    public j(Context r5) {
        this.a = new k(this);
        this.b = XmlPullParser.NO_NAMESPACE;
        this.c = new f0(this);
        this.d = new q0(this);
        this.e = new y0(this);
        this.f = new z0(this);
        this.g = new a1(this);
        this.h = new b1(this);
        this.i = new c1(this);
        this.j = new a(this);
        this.k = new b(this);
        this.l = new c(this);
        this.m = new d(this);
        this.n = new e(this);
        this.o = new f(this);
        this.p = new g(this);
        this.q = new h(this);
        this.r = new i(this);
        this.s = new C0004j(this);
        this.t = new l(this);
        this.u = new m(this);
        this.v = new n(this);
        this.w = new o(this);
        this.x = new p(this);
        this.y = new q(this);
        this.z = new r(this);
        this.A = new s(this);
        t r1 = new t(this);
        this.B = r1;
        this.C = new u(this);
        this.D = new v(this);
        this.E = new w(this);
        this.F = new x(this);
        this.G = new y(this);
        this.H = new z(this);
        this.I = new a0(this);
        this.f3J = new b0(this);
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
        this.k0 = new u0(this);
        this.p0 = new v0(this);
        this.H0 = new w0(this);
        this.V0 = new WeakHandler(Looper.getMainLooper(), this);
        this.b1 = new HashSet();
        this.g1 = XmlPullParser.NO_NAMESPACE;
        Context r6 = r5.getApplicationContext();
        this.L0 = r6;
        this.P0 = r6.getSharedPreferences("com.bytedance.sdk.account_setting", 0);
        r1.a();
        x0 r7 = new x0(this);
        boolean r2 = com.ss.android.token.p.a;
        TokenFactory.b(r7);
    }

    public static JSONObject j(cra.a r4) {
        JSONObject r1 = new JSONObject();
        r1.put("mName", r4.a);     // Catch: Exception -> L5
        r1.put("mPlatformId", r4.l);     // Catch: Exception -> L5
        r1.put("mNickname", r4.c);     // Catch: Exception -> L5
        r1.put("mAvatar", r4.d);     // Catch: Exception -> L5
        r1.put("mPlatformUid", r4.e);     // Catch: Exception -> L5
        r1.put("mExpire", r4.i);     // Catch: Exception -> L5
        r1.put("mExpireIn", r4.j);     // Catch: Exception -> L5
        r1.put("isLogin", r4.b);     // Catch: Exception -> L5
        r1.put("mUserId", r4.k);     // Catch: Exception -> L5
        r1.put("mModifyTime", r4.h);     // Catch: Exception -> L5
        r1.put("mSecPlatformUid", r4.f);     // Catch: Exception -> L5
        r1.put("mAccessToken", r4.m);     // Catch: Exception -> L5
        r1.put("mOpenId", r4.n);     // Catch: Exception -> L5
        r1.put("mScope", r4.o);     // Catch: Exception -> L5
        r1.put("refreshAt", r4.q);     // Catch: Exception -> L5
        r1.put("refreshTime", r4.r);     // Catch: Exception -> L5
        return r1;
    L5:
        return null;
    }

    public static j m(Context r2) {
        if (k1 != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (k1 != null) goto L9;
        k1 = new j(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        if (k1.L0 != null) goto L20;
        if (r2.getApplicationContext() == null) goto L20;
        j r1 = k1;
        r1.L0 = r2.getApplicationContext();
    L20:
        return k1;
    }

    @Override // ta7.f
    public final void a(boolean r9) {
        if (this.K.a().booleanValue() == false) goto L15;
        b0 r1 = this.f3J;
        Boolean r3 = Boolean.FALSE;
        r1.c(r3);
        this.K.c(r3);
        this.B.c(0L);
        this.G.c(XmlPullParser.NO_NAMESPACE);
        this.C.c(0);
        this.H.c(XmlPullParser.NO_NAMESPACE);
        this.D.c(XmlPullParser.NO_NAMESPACE);
        v(this.B.a().longValue(), XmlPullParser.NO_NAMESPACE);
        this.r.c(XmlPullParser.NO_NAMESPACE);
        this.j.c(0);
        this.s.c(XmlPullParser.NO_NAMESPACE);
        this.F.c(XmlPullParser.NO_NAMESPACE);
        this.h.c(XmlPullParser.NO_NAMESPACE);
        this.c.c(XmlPullParser.NO_NAMESPACE);
        this.k.c(XmlPullParser.NO_NAMESPACE);
        this.l.c(0);
        this.m.c(0);
        this.A.c(XmlPullParser.NO_NAMESPACE);
        this.f.c(XmlPullParser.NO_NAMESPACE);
        this.E.c(r3);
        this.n.c(r3);
        this.o.c(r3);
        this.I.c(0);
        this.Q.c(0);
        this.R.c(0);
        this.S.c(0);
        this.L.c(r3);
        this.p.c(0L);
        this.e.c(XmlPullParser.NO_NAMESPACE);
        this.i.c(XmlPullParser.NO_NAMESPACE);
        this.q.c(XmlPullParser.NO_NAMESPACE);
        this.P.c(0);
        this.N.c(XmlPullParser.NO_NAMESPACE);
        this.M.c(0L);
        this.O.c(XmlPullParser.NO_NAMESPACE);
        this.z.c(XmlPullParser.NO_NAMESPACE);
        this.T.c(r3);
        cra.a[] r2 = this.Z.a();
        int r4 = r2.length;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L7;
        r2[r5].e();
        r5 = r5 + 1;
        goto L5
    L7:
        Iterator r6 = ((HashMap) this.U.a().d).values().iterator();
    L9:
        if (r6.hasNext() == false) goto L14;
        Iterator r7 = ((Map) r6.next()).values().iterator();
    L12:
        if (r7.hasNext() == false) goto L9;
        ((cra.a) r7.next()).e();
        goto L12
    L14:
        this.H0.c(0);
        this.p0.c(Boolean.FALSE);
        q();
        this.k0.c(XmlPullParser.NO_NAMESPACE);
        SharedPreferences.Editor r8 = this.P0.edit();
        r8.putString("header_session_id", this.k0.a());
        SharedPrefsEditorCompat.apply(r8);
    L15:
        if (r9 == false) goto L32;
        ta7.b r10 = new ta7.b(2);
        r10.b = false;
        if (com.bytedance.sdk.account.impl.h0.d == null) goto L21;
        com.bytedance.sdk.account.impl.h0 r11 = com.bytedance.sdk.account.impl.h0.d;
        com.bytedance.sdk.account.impl.i0 r12 = r11.c;
        r11.c = null;
        if (r12 == null) goto L21;
        r10.c = r12;
    L21:
        Set<ta7.c> r13 = this.b1;
        monitor-enter(r13);
        Iterator r14 = ((HashSet) this.b1).iterator();     // Catch: Throwable -> L29
    L25:
        if (r14.hasNext() == false) goto L27;
        ((ta7.c) r14.next()).M(r10);     // Catch: Throwable -> L29
        goto L25
    L27:
        monitor-exit(r13);     // Catch: Throwable -> L29
        return;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // ta7.f
    public final void d(ta7.c r4) {
        if (r4 != null) goto L5;
        tb7.a.b("BDAccountManager", "addListener(), listener is null, " + Log.getStackTraceString(new Throwable()));
        return;
    L5:
        tb7.a.d("BDAccountManager", "addListener(), ".concat(r4.getClass().getName()));
        Set<ta7.c> r1 = this.b1;
        monitor-enter(r1);
        ((HashSet) this.b1).add(r4);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // ta7.f
    public final void e(ta7.b r4) {
        Set<ta7.c> r1 = this.b1;
        monitor-enter(r1);
        Iterator r2 = ((HashSet) this.b1).iterator();     // Catch: Throwable -> L12
    L6:
        if (r2.hasNext() == false) goto L10;
        ta7.c r3 = (ta7.c) r2.next();     // Catch: Throwable -> L12
        if (r3 == null) goto L6;
        r3.M(r4);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r5) {
        if (r5.what != 100) goto L18;
        Object r1 = r5.obj;
        if ((r1 instanceof com.bytedance.sdk.account.impl.f0) == false) goto L18;
        com.bytedance.sdk.account.impl.f0 r2 = (com.bytedance.sdk.account.impl.f0) r1;
        ua7.b r3 = r2.b;
        if (r3 == null) goto L18;
        Iterator r4 = ((ArrayList) p1).iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((d1) r4.next()).a(r3, r2);
        goto L10
    L12:
        ua7.a r6 = r2.a;
        if (r6 == null) goto L18;
        r6.dispatchOnResponse(r2.b);
        com.bytedance.sdk.account.impl.c0 r7 = ((com.bytedance.sdk.account.impl.a) r6).mJobController;
        if (r7 == null) goto L18;
        r7.e = null;
    L18:
        if (r5.what != 1000) goto L27;
        this.V0.removeMessages(EventsUtils.FEAT_TYPE_SHUT_DOWN);
        if (isLogin() == true) goto L23;
        u();
        return;
    L23:
        if (this.a.a() == null) goto L29;
        this.a.a().b("polling", new com.bytedance.sdk.account.impl.l(this));
        return;
    L29:
        return;
    }

    public final void o(String r9) {
        if (this.U.a() != null) goto L6;
        tb7.a.a("BDAccountManager", "mUserInfo == null");
        return;
    L6:
        tb7.a.a("BDAccountManager", String.format("%s: bind map entities", new Object[]{r9}));
        tb7.a.a("BDAccountManager", "isLogin==" + this.K);
        Iterator r2 = ((HashMap) this.U.a().c).values().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        tb7.a.a("BDAccountManager", String.format("%1s: bind map entity = %2s", new Object[]{r9, ((cra.a) r2.next()).c()}));
        goto L8
    L10:
        tb7.a.a("BDAccountManager", String.format("%s: third platform entities", new Object[]{r9}));
        Iterator r3 = ((HashMap) this.U.a().d).values().iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        Iterator r4 = ((Map) r3.next()).values().iterator();
    L15:
        if (r4.hasNext() == false) goto L12;
        tb7.a.a("BDAccountManager", String.format("%1s: third platform entity = %2s", new Object[]{r9, ((cra.a) r4.next()).c()}));
        goto L15
    }

    public final void p(String r3) {
        if (com.bytedance.sdk.account.impl.h0.d == null) goto L5;
    L14:
        com.bytedance.sdk.account.impl.h0.d.b(r3);
        return;
    L5:
        monitor-enter(com.bytedance.sdk.account.impl.h0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.sdk.account.impl.h0.d != null) goto L9;
        com.bytedance.sdk.account.impl.h0.d = new com.bytedance.sdk.account.impl.h0(this);     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.sdk.account.impl.h0.class);     // Catch: Throwable -> L11
        goto L14
    }

    public final void r(SharedPreferences.Editor r3) {
        if (this.Y.a() != null) goto L5;
        r3.putString("raw_json", XmlPullParser.NO_NAMESPACE);
    L6:
        r3.apply();
        return;
    L5:
        r3.putString("raw_json", this.Y.toString());
        goto L6
    }

    public final void s(SharedPreferences.Editor r8) {
        cra.a[] r1 = this.Z.a();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L11;
        cra.a r4 = r1[r3];
        if (this.K.a().booleanValue() == true) goto L7;
        r8.putString("_platform_" + r4.a, XmlPullParser.NO_NAMESPACE);
    L10:
        r3 = r3 + 1;
        goto L3
    L7:
        JSONObject r5 = j(r4);
        if (r5 == null) goto L10;
        r8.putString("_platform_" + r4.a, r5.toString());
        goto L10
    L11:
        r8.apply();
    }

    public final boolean w(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L7;
        this.b = XmlPullParser.NO_NAMESPACE;
        tb7.a.d("BDAccountManager", "setVerifyPortraitFlag empty");
        return true;
    L7:
        if (r6.contains(".") == false) goto L10;
        tb7.a.d("BDAccountManager", "verify portrait flag contains '.'");
        return false;
    L10:
        this.b = UUID.randomUUID() + "." + r6;
        StringBuilder r7 = new StringBuilder("setVerifyPortraitFlag ");
        r7.append(this.b);
        tb7.a.d("BDAccountManager", r7.toString());
        return true;
    }

    public final boolean x(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L7;
        this.g1 = XmlPullParser.NO_NAMESPACE;
        tb7.a.d("BDAccountManager", "setVerifyPortraitOuterFlag empty");
        return true;
    L7:
        if (r6.contains(".") == false) goto L10;
        tb7.a.d("BDAccountManager", "verify portrait outer flag contains '.'");
        return false;
    L10:
        this.g1 = UUID.randomUUID() + "." + r6;
        StringBuilder r7 = new StringBuilder("setVerifyPortraitOuterFlag ");
        r7.append(this.g1);
        tb7.a.d("BDAccountManager", r7.toString());
        return true;
    }

    public static cra.a n(JSONObject r7, cra.a r8) {
        String r1 = r7.optString("mName", XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return r8;
    L5:
        if (r8 != null) goto L8;
        r8 = new cra.a(r1);
    L8:
        if (TextUtils.equals(r1, r8.a) == true) goto L11;
        return r8;
    L11:
        if (r7.has("mPlatformId") == false) goto L14;
        r8.l = r7.optLong("mPlatformId", 0);
    L14:
        if (r7.has("mNickname") == false) goto L17;
        r8.c = r7.optString("mNickname", XmlPullParser.NO_NAMESPACE);
    L17:
        if (r7.has("mAvatar") == false) goto L20;
        r8.d = r7.optString("mAvatar", XmlPullParser.NO_NAMESPACE);
    L20:
        if (r7.has("mPlatformUid") == false) goto L23;
        r8.e = r7.optString("mPlatformUid", XmlPullParser.NO_NAMESPACE);
    L23:
        if (r7.has("mExpire") == false) goto L26;
        r8.i = r7.optLong("mExpire", r8.i);
    L26:
        if (r7.has("mExpireIn") == false) goto L29;
        r8.j = r7.optLong("mExpireIn", r8.j);
    L29:
        if (r7.has("isLogin") == false) goto L32;
        r8.b = r7.optBoolean("isLogin", false);
    L32:
        if (r7.has("mUserId") == false) goto L35;
        r8.k = r7.optLong("mUserId", 0);
    L35:
        if (r7.has("mModifyTime") == false) goto L38;
        r8.h = r7.optLong("mModifyTime");
    L38:
        if (r7.has("mSecPlatformUid") == false) goto L41;
        r8.f = r7.optString("mSecPlatformUid");
    L41:
        if (r7.has("mAccessToken") == false) goto L44;
        r8.m = r7.optString("mAccessToken");
    L44:
        if (r7.has("mOpenId") == false) goto L47;
        r8.n = r7.optString("mOpenId");
    L47:
        if (r7.has("mScope") == false) goto L50;
        r8.o = r7.optString("mScope");
    L50:
        if (r7.has("refreshAt") == false) goto L53;
        r8.q = r7.optLong("refreshAt", r8.q);
    L53:
        if (r7.has("refreshTime") == false) goto L55;
        r8.r = r7.optLong("refreshTime", r8.r);
    L55:
        return r8;
    }

    public static void v(long r1, String r3) {
        com.bytedance.sdk.account.utils.g r2 = com.ss.android.account.k.d().getMonitor();     // Catch: Exception -> L6
        if (r2 == null) goto L11;
        r2.a(r1, r3);     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public final void y(String r19, int r20, Bundle r21) {
        if (TextUtils.isEmpty(r19) == false) goto L5;
        return;
    L5:
        if (r20 != (-1)) goto L7;
        return;
    L7:
        if (r21.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.K.a().booleanValue() == true) goto L11;
        return;
    L11:
        if (this.U.a() == null) goto L72;
        String r4 = String.valueOf(r20);
        Map r5 = (Map) ((HashMap) this.U.a().d).get(r19);
        if (r5 != null) goto L16;
        r5 = new HashMap();
        ((HashMap) this.U.a().d).put(r19, r5);
    L16:
        cra.a r6 = (cra.a) r5.get(r4);
        if (r6 != null) goto L19;
        r6 = new cra.a(r19);
        r6.l = r20;
        r6.b = true;
        r6.k = this.B.a().longValue();
        r5.put(r4, r6);
    L19:
        cra.a r2 = (cra.a) ((HashMap) this.U.a().c).get(r19);
        if (r2 != null) goto L23;
        ((HashMap) this.U.a().c).put(r19, r6);
        r2 = r6;
    L23:
        if (r21.containsKey("access_token") == false) goto L26;
        String r1 = r21.getString("access_token", null);
        r2.m = r1;
        r6.m = r1;
    L26:
        if (r21.containsKey("expires_in") == false) goto L32;
        long r12 = r21.getLong("expires_in", 0);
        if (r12 == 0) goto L30;
        long r14 = System.currentTimeMillis() + (r12 * 1000);
    L31:
        r2.j = r12;
        r2.i = r14;
        r6.j = r12;
        r6.i = r14;
    L34:
        if (r21.containsKey("open_id") == false) goto L37;
        String r3 = r21.getString("open_id", null);
        r2.n = r3;
        r6.n = r3;
    L37:
        if (r21.containsKey("scopes") == false) goto L40;
        String r7 = r21.getString("scopes", null);
        r2.o = r7;
        r6.o = r7;
    L40:
        if (r21.containsKey("extra") == false) goto L43;
        String r8 = r21.getString("extra", null);
        r2.p = r8;
        r6.p = r8;
    L43:
        if (r21.containsKey("refresh_time") == false) goto L49;
        long r9 = r21.getLong("refresh_time", 0);
        if (r12 <= r9) goto L47;
        long r10 = r6.i - (1000 * r9);
    L48:
        r2.r = r9;
        r2.q = r10;
        r6.r = r9;
        r6.q = r10;
        goto L49
    L47:
        r10 = r6.i;
    L49:
        HashMap r11 = (HashMap) this.U.a().c;
        if (r11 != null) goto L52;
    L63:
        s(this.P0.edit());
        t();
        o("updatePlatformInfo");
        return;
    L52:
        if (r11.isEmpty() == true) goto L63;
        cra.a[] r13 = this.Z.a();
        int r15 = r13.length;
        int r16 = 0;
    L54:
        if (r16 >= r15) goto L63;
        cra.a r17 = r13[r16];
        r17.b = false;
        cra.a r18 = (cra.a) r11.get(r17.a);
        if (r18 != null) goto L59;
        r17.e();
    L62:
        r16 = r16 + 1;
        goto L54
    L59:
        if (r17.b == true) goto L61;
        r17.b = true;
    L61:
        r17.l = r18.l;
        r17.i = r18.i;
        r17.j = r18.j;
        r17.c = r18.c;
        r17.d = r18.d;
        r17.e = r18.e;
        r17.k = r18.k;
        r17.h = r18.h;
        r17.m = r18.m;
        r17.n = r18.n;
        r17.o = r18.o;
        r17.r = r18.r;
        r17.q = r18.q;
        r17.p = r18.p;
        goto L62
    L30:
        r14 = 0;
        goto L31
    L32:
        r12 = 0;
        goto L34
    }

    public static void h(j r6, String r7, int r8, boolean r9) {
        r6.getClass();
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        if (r8 != (-1)) goto L7;
        return;
    L7:
        if (r6.K.a().booleanValue() == true) goto L9;
        return;
    L9:
        if (r6.Y.a() != null) goto L11;
        return;
    L11:
        if (r6.U.a() == null) goto L45;
        if (r9 == false) goto L29;
        cra.a r10 = new cra.a(r7);
        r10.l = r8;
        JSONArray r2 = r6.Y.a().optJSONObject("data").optJSONArray("connects");     // Catch: Exception -> L34
        int r3 = 0;
    L17:
        if (r3 >= r2.length()) goto L24;
        JSONObject r4 = JSONArrayProtectorUtils.getJSONObject(r2, r3);     // Catch: Exception -> L34
        if (TextUtils.equals(r4.optString("platform"), r7) == false) goto L23;
        if (r4.optInt("platform_app_id") != r8) goto L23;
        JSONObject r5 = r6.Y.a().optJSONObject("data");     // Catch: Exception -> L34
        r2.remove(r3);     // Catch: Exception -> L34
        r5.put("connects", r2);     // Catch: Exception -> L34
        sc7.a r1 = r6.U.a();     // Catch: Exception -> L34
        JSONObject r11 = r6.Y.a();     // Catch: Exception -> L34
        r1.p = r11;     // Catch: Exception -> L34
        JSONObject r12 = r11.optJSONObject("data");     // Catch: Exception -> L34
        r1.o = r12;     // Catch: Exception -> L34
        r1.q = r12;     // Catch: Exception -> L34
    L23:
        r3 = r3 + 1;     // Catch: Exception -> L34
    L24:
        ((HashMap) r6.U.a().c).put(r7, r10);     // Catch: Exception -> L34
        Map r13 = (Map) ((HashMap) r6.U.a().d).get(r7);     // Catch: Exception -> L34
        if (r13 == null) goto L27;
        r13.put(String.valueOf(r8), r10);     // Catch: Exception -> L34
    L27:
        SharedPreferences.Editor r14 = r6.P0.edit();     // Catch: Exception -> L34
        r6.r(r14);     // Catch: Exception -> L34
        r6.s(r14);     // Catch: Exception -> L34
        r6.t();     // Catch: Exception -> L34
        r6.o("clearPlatformInfoInner");     // Catch: Exception -> L34
        return;
    L47:
        return;
    L29:
        Bundle r15 = new Bundle();
        r15.putString("access_token", XmlPullParser.NO_NAMESPACE);
        com.bytedance.sdk.account.settings.common.a.a();
        if (com.bytedance.sdk.account.settings.common.a.T != 0) goto L32;
        r15.putString("open_id", XmlPullParser.NO_NAMESPACE);
    L32:
        r15.putString("scopes", XmlPullParser.NO_NAMESPACE);
        r15.putLong("expires_in", 0);
        r15.putLong("refresh_time", 0);
        r6.y(r7, r8, r15);
        return;
    }
}
