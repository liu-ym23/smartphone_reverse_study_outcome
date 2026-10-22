package com.bytedance.android.livesdk.log.filter;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.s8;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n0 extends com.bytedance.android.livesdk.log.filter.a<am2.x> implements t {
    public TypeToken<HashMap<String, Object>> A;
    public final boolean B;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public final Map<String, String> q;
    public final Map<String, String> r;
    public final Map<String, String> s;
    public final Map<String, String> t;
    public final Map<String, String> u;
    public int v;
    public String w;
    public boolean x;
    public String y;
    public String z;

    public class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void o() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String D() {
        return this.s.get("group_member_id");
    }

    public final void J() {
        this.q.clear();
    }

    public final void K() {
        this.t.clear();
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String q() {
        Map<String, String> r0 = this.b;
        if (r0 != null) goto L5;
        return null;
    L5:
        String r1 = r0.get("live_recommend_info");
        if (r1 != null) goto L8;
    L22:
        return null;
    L8:
        if (r1.isEmpty() == true) goto L22;
        if (this.A != null) goto L13;
        this.A = new a();
    L13:
        HashMap r2 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.get(), r1, this.A.getType());
        if (r2 != null) goto L16;
        return "";
    L16:
        if ((r2.get("anchor_identity") instanceof String) == true) goto L19;
        return "";
    L19:
        return (String) r2.get("anchor_identity");
    }

    public n0() {
        this.p = 0;
        this.q = Collections.synchronizedMap(new HashMap());
        this.r = Collections.synchronizedMap(new HashMap());
        this.s = Collections.synchronizedMap(new HashMap());
        this.t = Collections.synchronizedMap(new HashMap());
        this.u = Collections.synchronizedMap(new HashMap());
        this.v = -1;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = ((Boolean) s8.a.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String A() {
        return this.n;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String B() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String b() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String d() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String e() {
        return this.l;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String f() {
        return this.m;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String g() {
        return this.o;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final int getApplyType() {
        return this.v;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String getMatchType() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String getRoomTag() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String i() {
        return this.z;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final boolean j() {
        return this.x;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String k() {
        return this.k;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String l() {
        return this.j;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String m() {
        return this.w;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String p() {
        return this.i;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String w() {
        return this.h;
    }

    public static void N(Map r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (tb1.c.a == true) goto L7;
        return;
    L7:
        if (r3.containsKey("enter_from_ad_type") == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty((CharSequence) r3.get("enter_from_ad_type")) == true) goto L14;
        r3.put("enter_from_merge", (String) r3.get("enter_from_ad_type"));
        r3.remove("enter_from_ad_type");
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void F(String r1) {
        this.j = r1;
    }

    public final void L(Map<String, String> r2) {
        this.t.putAll(r2);
    }

    public final void M(Bundle r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<String> r0 = r5.keySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        this.r.put(r1, r5.getString(r1, ""));
        goto L6
    }

    public final void O(String r1) {
        this.w = r1;
    }

    public final void P(int r1) {
        this.v = r1;
    }

    public final void Q(String r1) {
        this.k = r1;
    }

    public final void R(String r1) {
        this.n = r1;
    }

    public final void S(String r1) {
        this.m = r1;
    }

    public final void T(String r1) {
        this.d = r1;
    }

    public final void U(String r1) {
        this.i = r1;
    }

    public final void V(String r1) {
        this.o = r1;
    }

    public final void W(String r1) {
        this.e = r1;
    }

    public final void X(String r1) {
        this.f = r1;
    }

    public final void Y(String r1) {
        this.z = r1;
    }

    public final void Z(String r1) {
        this.y = r1;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r3) {
        super.a(r3);
        r3.putAll(this.t);
        r3.putAll(this.q);
        r3.putAll(this.r);
        if (this.B == false) goto L5;
        r3.putAll(this.s);
    L5:
        r3.putAll(this.u);
        N(r3);
        String r0 = this.i;
        if (r0 == null) goto L8;
        r3.put("distribute_source", r0);
    L8:
        r3.put("room_rank", String.valueOf(this.p));
        IHostBusiness r1 = jc1.k.f(IHostBusiness.class);
        if (r1 == null) goto L14;
        String r2 = r1.getDesktopParams();
        if (r2 == null) goto L15;
        r3.put("launch_method", r2);
        return;
    L15:
        return;
    }

    public final void a0(String r1) {
        this.g = r1;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String h(String r2) {
        return this.q.get(r2);
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void r(boolean r1) {
        if (r1 == false) goto L4;
        this.s.clear();
        return;
    L4:
        this.r.clear();
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void s(Map<String, String> r2) {
        this.q.putAll(r2);
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void t(String r1) {
        this.l = r1;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void E(String r2, String r3) {
        this.q.put(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void G(Map<String, String> r1, boolean r2) {
        if (r2 == false) goto L4;
        this.s.putAll(r1);
        return;
    L4:
        this.r.putAll(r1);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r4, am2.x r5) {
        am2.x r6 = r5;
        super.u(r4, r6);
        r4.putAll(this.q);
        r4.putAll(this.r);
        r4.putAll(this.s);
        r4.putAll(this.u);
        if (r6 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r6.b) == true) goto L9;
        r4.put("event_page", r6.b);
    L9:
        if (StringUtils.isEmpty(r6.c) == true) goto L12;
        r4.put("event_module", r6.c);
    L12:
        if (StringUtils.isEmpty(null) == true) goto L15;
        r4.put("source", null);
    L15:
        if (StringUtils.isEmpty(r6.d) == true) goto L18;
        r4.put("enter_from", r6.d);
    L18:
        if (StringUtils.isEmpty(r6.a) == true) goto L21;
        r4.put("event_belong", r6.a);
    L21:
        if (StringUtils.isEmpty(r6.e) == true) goto L24;
        r4.put("event_type", r6.e);
    L24:
        if (StringUtils.isEmpty(r6.f) == true) goto L27;
        r4.put("action_type", r6.f);
    L27:
        if (StringUtils.isEmpty(null) == true) goto L29;
        r4.put("top_message_type", null);
    L29:
        N(r4);
        String r7 = this.i;
        if (r7 == null) goto L32;
        r4.put("distribute_source", r7);
    L32:
        r4.put("room_rank", String.valueOf(this.p));
        IHostBusiness r8 = jc1.k.f(IHostBusiness.class);
        if (r8 == null) goto L38;
        String r9 = r8.getDesktopParams();
        if (r9 == null) goto L39;
        r4.put("launch_method", r9);
        return;
    L39:
        return;
    }
}
