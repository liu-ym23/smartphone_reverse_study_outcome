package com.bytedance.awemeopen.domain.feed.preload.aweme;

import android.text.TextUtils;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.ConstantsKt;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.net.AoNet;
import com.bytedance.awemeopen.infra.base.net.AoNetResponse;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r14.a0;
import r14.e0;
import r34.f;

/* JADX INFO: loaded from: classes44.dex */
public final class AosAwemeRequesterImpl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f198331c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f198332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f198333b;

    public static final class Companion {
        public static String a(List r110) {
            Intrinsics.checkNotNullParameter(r110, "param");
            return CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, AosAwemeRequesterImpl$Companion$awemeList2ids$1.INSTANCE, 30, null);
        }

        public static String b(List r100) {
            Intrinsics.checkNotNullParameter(r100, "param");
            Iterator r101 = r100.iterator();
            String r102 = "";
            int r103 = 0;
        L4:
            if (r101.hasNext() == false) goto L22;
            Object r104 = r101.next();
            int r105 = r103 + 1;
            if (r103 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            String r106 = (String) r104;
            if (r106 != null) goto L11;
        L16:
            boolean r107 = false;
        L17:
            if (r107 == false) goto L21;
            r102 = r102 + r106;
            if (r103 == (r100.size() - 1)) goto L21;
            r102 = r102 + ',';
        L21:
            r103 = r105;
            goto L4
        L11:
            if (r106.length() <= 0) goto L13;
            boolean r108 = true;
        L14:
            if (r108 != true) goto L16;
            r107 = true;
            goto L17
        L13:
            r108 = false;
            goto L14
        L22:
            return r102;
        }
    }

    static {
    }

    public AosAwemeRequesterImpl(boolean r100) {
        this.f198332a = r100;
        this.f198333b = ConstantsKt.a() + "/aweme/open/export_sdk/specified/items";
    }

    public static void a(final e0 r100, Exception r101, final f r102) {
        Function1<e0, Unit> r103 = new AosAwemeRequesterImpl$invokeCallback$1(r102, r100);
        Function2<Exception, Integer, Unit> r104 = new AosAwemeRequesterImpl$invokeCallback$2(r102);
        Intrinsics.checkNotNullParameter(r103, "success");
        Intrinsics.checkNotNullParameter(r104, "fail");
        if (r100 == null) goto L8;
        if (r101 != null) goto L8;
        if (r100.a() != 0) goto L8;
        r103.invoke(r100);
        return;
    L8:
        if (r100 == null) goto L10;
        int r105 = r100.a();
    L11:
        r104.invoke(r101, Integer.valueOf(r105));
        return;
    L10:
        r105 = -1;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v11, types: [T, java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r4v11, types: [T, java.lang.Object] */
    public final void b(List<String> r110, String r111, String r112, String r113, List<String> r210, String r211, Map<String, String> r212, String r213, String r214, String r215, boolean r216, final f r217) {
        String r100 = r215;
        Intrinsics.checkNotNullParameter(r110, "aidParam");
        Intrinsics.checkNotNullParameter(r210, "gidParam");
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        LinkedHashMap r115 = new LinkedHashMap();     // Catch: Exception -> L153
        String r116 = AoEnv.c();     // Catch: Exception -> L153
        if (TextUtils.isEmpty(r116) == true) goto L8;
        r115.put("device_id", r116);     // Catch: Exception -> L153
    L8:
        if ((!r110.isEmpty()) == false) goto L12;
        r115.put("aweme_ids", Companion.b(r110));     // Catch: Exception -> L153
    L12:
        if ((!r210.isEmpty()) == false) goto L15;
        r115.put("host_gids", Companion.b(r210));     // Catch: Exception -> L153
    L15:
        if (r112 != null) goto L17;
    L22:
        boolean r102 = false;
    L23:
        if (r102 == false) goto L25;
        r115.put("aweme_ids", r112);     // Catch: Exception -> L153
    L25:
        if (r113 != null) goto L27;
    L32:
        boolean r103 = false;
    L33:
        if (r103 == false) goto L35;
        r115.put("host_gids", r113);     // Catch: Exception -> L153
    L35:
        if (r100 != null) goto L37;
    L42:
        boolean r104 = false;
    L44:
        if (r104 == false) goto L47;
        r115.put("host_enter_from", r100);     // Catch: Exception -> L153
    L47:
        if (r100 != null) goto L49;
        r100 = "";
    L49:
        r115.put("host_enter_from", r100);     // Catch: Exception -> L153
        if (r214 != null) goto L52;
    L57:
        boolean r105 = false;
    L58:
        if (r105 == true) goto L60;
    L62:
        if (r216 == false) goto L64;
        r115.put("is_preload", "true");     // Catch: Exception -> L153
    L64:
        r115.put("ao_op_feed_type", "specified");     // Catch: Exception -> L153
        int r106 = com.bytedance.awemeopen.domain.base.repo.b.f198240b;     // Catch: Exception -> L153
        String r107 = com.bytedance.awemeopen.domain.base.repo.b.a.a(this.f198333b, r115);     // Catch: Exception -> L153
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L153
        if (r212 == null) goto L70;
        Iterator<Map.Entry<String, String>> r109 = r212.entrySet().iterator();     // Catch: Exception -> L153
    L68:
        if (r109.hasNext() == false) goto L70;
        Map.Entry<String, String> r117 = r109.next();     // Catch: Exception -> L153
        r108.put(r117.getKey(), r117.getValue());     // Catch: Exception -> L153
    L70:
        Function0<String> r118 = AoNet.f198669a;     // Catch: Exception -> L153
        Pair[] r119 = new Pair[2];     // Catch: Exception -> L153
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L153
        if (r211 != null) goto L73;
        String r121 = "";
    L74:
        r119[0] = TuplesKt.to("ao-host-custom-params", r120.put("host_client_local_params", r121).toString());     // Catch: Exception -> L153
        r119[1] = TuplesKt.to("ao-host-client-params", r108.toString());     // Catch: Exception -> L153
        Map r122 = MapsKt.mapOf(r119);     // Catch: Exception -> L153
        Intrinsics.checkNotNullParameter(r107, "url");     // Catch: Exception -> L153
        Intrinsics.checkNotNullParameter(r122, "headerMap");     // Catch: Exception -> L153
        AoNetResponse r123 = AoNet.a(r107, r122);     // Catch: Exception -> L153
        List<r14.c> r124 = null;
        if (r123.isSuccessful() == true) goto L77;
    L80:
        String r125 = null;
    L81:
        if (r125 == null) goto L151;
        ?? r126 = GsonHolder.a().fromJson(r125, e0.class);     // Catch: Exception -> L153
        r101.element = r126;     // Catch: Exception -> L153
        e0 r127 = (e0) r126;     // Catch: Exception -> L153
        if (r127 == null) goto L106;
        List<r14.c> r128 = r127.f();     // Catch: Exception -> L153
        if (r128 == null) goto L106;
        Iterator<T> r129 = r128.iterator();     // Catch: Exception -> L153
    L88:
        if (r129.hasNext() == false) goto L106;
        r14.c r130 = (r14.c) r129.next();     // Catch: Exception -> L153
        User r131 = r130.f();     // Catch: Exception -> L153
        if (r131 == null) goto L96;
        String r132 = r130.r().f535650b;     // Catch: Exception -> L153
        if (r132 != null) goto L95;
        r132 = "";
    L95:
        r131.T(r132);     // Catch: Exception -> L153
    L96:
        if (r111 != null) goto L98;
    L103:
        boolean r133 = false;
    L104:
        if (r133 == false) goto L88;
        a0 r134 = new a0();     // Catch: Exception -> L153
        r134.b(r111);     // Catch: Exception -> L153
        r130.f535622d = r134;     // Catch: Exception -> L153
        goto L88
    L98:
        if (r111.length() <= 0) goto L100;
        boolean r135 = true;
    L101:
        if (r135 != true) goto L103;
        r133 = true;
        goto L104
    L100:
        r135 = false;
    L106:
        ArrayList r136 = new ArrayList();     // Catch: Exception -> L153
        if (r213 == null) goto L109;
        Sequence r137 = StringsKt.splitToSequence$default(r213, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L153
    L110:
        if (r137 == null) goto L130;
        Iterator r138 = r137.iterator();     // Catch: Exception -> L153
    L113:
        if (r138.hasNext() == false) goto L130;
        String r139 = (String) r138.next();     // Catch: Exception -> L153
        e0 r140 = (e0) r101.element;     // Catch: Exception -> L153
        if (r140 == null) goto L113;
        List<r14.c> r141 = r140.f();     // Catch: Exception -> L153
        if (r141 == null) goto L113;
        Iterator<T> r142 = r141.iterator();     // Catch: Exception -> L153
    L120:
        if (r142.hasNext() == false) goto L113;
        r14.c r143 = (r14.c) r142.next();     // Catch: Exception -> L153
        if (r143.c().length() <= 0) goto L124;
        boolean r144 = true;
    L125:
        if (r144 == false) goto L120;
        if (TextUtils.equals(r143.c(), r139) == false) goto L120;
        r136.add(r143);     // Catch: Exception -> L153
        goto L120
    L124:
        r144 = false;
    L130:
        if ((!r136.isEmpty()) == false) goto L135;
        e0 r145 = (e0) r101.element;     // Catch: Exception -> L153
        if (r145 == null) goto L135;
        r145.h(r136);     // Catch: Exception -> L153
    L135:
        if (r216 == true) goto L156;
        T r146 = r101.element;     // Catch: Exception -> L153
        e0 r147 = (e0) r146;     // Catch: Exception -> L153
        if (r147 == null) goto L156;
        e0 r148 = (e0) r146;     // Catch: Exception -> L153
        if (r148 == null) goto L150;
        List<r14.c> r149 = r148.f();     // Catch: Exception -> L153
        if (r149 == null) goto L150;
        ArrayList r150 = new ArrayList();     // Catch: Exception -> L153
        Iterator<T> r151 = r149.iterator();     // Catch: Exception -> L153
    L145:
        if (r151.hasNext() == false) goto L149;
        Object r152 = r151.next();     // Catch: Exception -> L153
        if ((!Intrinsics.areEqual(((r14.c) r152).r().f535653e, Boolean.TRUE)) == false) goto L145;
        r150.add(r152);     // Catch: Exception -> L153
        goto L145
    L149:
        r124 = CollectionsKt.toMutableList(r150);     // Catch: Exception -> L153
    L150:
        r147.h(r124);     // Catch: Exception -> L153
    L156:
        if (this.f198332a == false) goto L158;
        AoPool.g(new AosAwemeRequesterImpl$innerRequest$4(this, r101, r114, r217));
        return;
    L158:
        a((e0) r101.element, (Exception) r114.element, r217);
        return;
    L109:
        r137 = null;
        goto L110
    L151:
        r114.element = new Exception("fetchFeed but got empty body result");     // Catch: Exception -> L153
        goto L156
    L77:
        if (r123.getBody() == null) goto L80;
        r125 = r123.stringBody();     // Catch: Exception -> L153
        goto L81
    L73:
        r121 = r211;
        goto L74
    L60:
        if (Intrinsics.areEqual(r214, "pic_detail") == true) goto L62;
        r115.put("ao_content_scene", r214);     // Catch: Exception -> L153
        goto L62
    L52:
        if (r214.length() <= 0) goto L54;
        boolean r153 = true;
    L55:
        if (r153 != true) goto L57;
        r105 = true;
        goto L58
    L54:
        r153 = false;
        goto L55
    L37:
        if (r215.length() <= 0) goto L39;
        boolean r154 = true;
    L40:
        if (r154 != true) goto L42;
        r104 = true;
        goto L44
    L39:
        r154 = false;
        goto L40
    L27:
        if (r113.length() <= 0) goto L29;
        boolean r155 = true;
    L30:
        if (r155 != true) goto L32;
        r103 = true;
        goto L33
    L29:
        r155 = false;
        goto L30
    L17:
        if (r112.length() <= 0) goto L19;
        boolean r156 = true;
    L20:
        if (r156 != true) goto L22;
        r102 = true;
        goto L23
    L19:
        r156 = false;
    L153:
        e = move-exception;
        r114.element = e;
        goto L156
    }
}
