package com.larus.dora.impl.ota.g2;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class g4 {
    private static final Set<InstallPhase> ACTIVE_INSTALL_PHASES = null;
    private static final a Companion = null;
    public static final int G1_PRODUCT_ID = 16;
    private static final Set<Integer> G2_PRODUCT_IDS = null;
    private static final Set<PackagePhase> MIGRATABLE_LATEST_PACKAGE_PHASES = null;
    public static final int MIN_SUPPORTED_SCHEMA = 1;
    public static final int SCHEMA_VERSION = 2;
    private final Gson gson;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        private final int schema;
        private final b5 state;

        public b() {
            this(null, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.schema == r101.schema) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.state, r101.state) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.schema * 31) + this.state.hashCode();
        }

        public final String toString() {
            return "SnapshotEnvelope(schema=" + this.schema + ", state=" + this.state + ')';
        }

        public final int a() {
            return this.schema;
        }

        public final b5 b() {
            return this.state;
        }

        public b(b5 r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            int r102 = 2;
        L7:
            if ((r101 & 2) == 0) goto L9;
            r100 = new b5(0, 16383);
        L9:
            Intrinsics.checkNotNullParameter(r100, "state");
            this.schema = r102;
            this.state = r100;
            return;
        L5:
            r102 = 0;
            goto L7
        }
    }

    static {
        Companion = new a();
        G2_PRODUCT_IDS = SetsKt.setOf(new Integer[]{17, 18, 19});
        MIGRATABLE_LATEST_PACKAGE_PHASES = SetsKt.setOf(new PackagePhase[]{PackagePhase.PARTIAL, PackagePhase.READY, PackagePhase.UNCONFIRMED});
        ACTIVE_INSTALL_PHASES = SetsKt.setOf(new InstallPhase[]{InstallPhase.DECLARING_TYPE, InstallPhase.CONNECTING, InstallPhase.TRANSFERRING, InstallPhase.CANCELLING, InstallPhase.DEVICE_OWNED, InstallPhase.AWAITING_RECONNECT, InstallPhase.TERMINAL_PENDING_ACK});
    }

    public g4(int r100) {
        Gson r101 = new GsonBuilder().registerTypeAdapter(ManualOnlyReason.class, new f4()).enableComplexMapKeySerialization().create();
        Intrinsics.checkNotNullParameter(r101, "gson");
        this.gson = r101;
    }

    public final b5 a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        b r102 = (b) this.gson.fromJson(r100, b.class);     // Catch: Throwable -> L16
        int r103 = r102.a();     // Catch: Throwable -> L16
        boolean r104 = false;
        if (1 <= r103) goto L6;
    L8:
        boolean r105 = false;
    L9:
        if (r105 == false) goto L15;
        b5 r106 = r102.b();     // Catch: Throwable -> L16
        if (r102.a() >= 2) goto L13;
        r104 = true;
    L13:
        Object r107 = Result.m9449constructorimpl(c(r106, r104));     // Catch: Throwable -> L16
    L19:
        if (Result.m9455isFailureimpl(r107) == false) goto L22;
        r107 = null;
    L22:
        return (b5) r107;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L16
    L6:
        if (r103 >= 3) goto L8;
        r105 = true;
    L16:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public final String b(b5 r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return GsonProtectorUtils.toJson(this.gson, new b(r100, 1));
    }

    public static b5 c(b5 r310, boolean r311) {
        Map<e, f> r100 = r310.c();
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<e, f>> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L23;
        Map.Entry<e, f> r103 = r102.next();
        e r104 = r103.getKey();
        f r105 = r103.getValue();
        if ((!StringsKt.isBlank(r104.b())) == true) goto L8;
    L20:
        boolean r106 = false;
    L21:
        if (r106 == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L8:
        if (Intrinsics.areEqual(r104, r105.g()) == false) goto L20;
        if (G2_PRODUCT_IDS.contains(Integer.valueOf(r104.a())) == false) goto L20;
        if (d(r105.h(), r104) == false) goto L20;
        if (d(r105.l().h(), r104) == false) goto L20;
        if (r105.c().k() != null) goto L18;
    L19:
        r106 = true;
        goto L21
    L18:
        if (Intrinsics.areEqual(r105.c().k().a(), r104) == false) goto L20;
    L23:
        LinkedHashMap r107 = new LinkedHashMap(MapsKt.mapCapacity(r101.size()));
        Iterator r108 = r101.entrySet().iterator();
    L25:
        if (r108.hasNext() == false) goto L137;
        Map.Entry r109 = (Map.Entry) r108.next();
        Object r110 = r109.getKey();
        e r111 = (e) r109.getKey();
        f r112 = (f) r109.getValue();
        List<c5> r113 = r112.k();
        a5 r114 = r112.j();
        if (r114 != null) goto L29;
        a5 r210 = null;
    L33:
        e5 r115 = r112.h();
        if (r115 != null) goto L53;
        r115 = r112.l().h();
        if (r115 == null) goto L52;
        if (r311 == true) goto L39;
    L49:
        boolean r116 = false;
    L50:
        if (r116 == false) goto L52;
    L39:
        if (MIGRATABLE_LATEST_PACKAGE_PHASES.contains(r112.l().f()) == false) goto L49;
        if (r112.m().g() != 0) goto L49;
        s5 r117 = r112.r();
        if (r117 == null) goto L45;
        TerminalResult r118 = r117.b();
    L47:
        if (r118 == TerminalResult.SUCCESS) goto L49;
        r116 = true;
        goto L50
    L45:
        r118 = null;
    L52:
        e5 r119 = null;
    L54:
        if (r210 != null) goto L56;
    L80:
        boolean r120 = true;
    L81:
        if (r120 == false) goto L136;
        if (r112.l().e() != null) goto L85;
        boolean r121 = true;
    L87:
        if (r112.l().d() != null) goto L89;
        boolean r122 = true;
    L90:
        if (r121 != r122) goto L92;
        boolean r123 = true;
    L93:
        if (r123 == false) goto L134;
        d5 r124 = r112.l().d();
        if (r124 != null) goto L97;
    L99:
        boolean r125 = false;
    L101:
        if ((!r125) == false) goto L132;
        if (r113 != null) goto L104;
        r113 = CollectionsKt.emptyList();
    L104:
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r113.iterator();
    L106:
        if (r127.hasNext() == false) goto L124;
        Object r128 = r127.next();
        c5 r129 = (c5) r128;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L116
        if (r129.b() > 0) goto L111;
    L113:
        boolean r131 = false;
    L114:
        Object r132 = Result.m9449constructorimpl(Boolean.valueOf(r131));     // Catch: Throwable -> L116
    L118:
        Boolean r133 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r132) == false) goto L122;
        r132 = r133;
    L122:
        if (((Boolean) r132).booleanValue() == false) goto L106;
        r126.add(r128);
        goto L106
    L111:
        if (d(r129.d(), r111) == false) goto L113;
        r131 = true;
    L116:
        th = move-exception;
        Result.Companion r134 = Result.Companion;
        r132 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L118
    L124:
        HashSet r135 = new HashSet();
        ArrayList r136 = new ArrayList();
        Iterator r137 = r126.iterator();
    L126:
        if (r137.hasNext() == false) goto L130;
        Object r138 = r137.next();
        if (r135.add(Long.valueOf(((c5) r138).b())) == false) goto L126;
        r136.add(r138);
        goto L126
    L130:
        r107.put(r110, f.a(r112, null, null, null, null, null, null, r119, null, r136, null, null, null, null, null, null, null, r210, 130431));
        goto L25
    L132:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L97:
        if (e(r124, r111) == true) goto L99;
        r125 = true;
        goto L101
    L134:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L92:
        r123 = false;
        goto L93
    L89:
        r122 = false;
        goto L90
    L85:
        r121 = false;
        goto L87
    L136:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L56:
        if ((!StringsKt.isBlank(r210.g())) == true) goto L58;
    L76:
        boolean r139 = false;
    L77:
        if (r139 == true) goto L80;
        r120 = false;
        goto L81
    L58:
        if (r210.c() < 0) goto L76;
        if (r210.d() <= 0) goto L76;
        if (r210.h() == null) goto L66;
        if (Intrinsics.areEqual(r210.h().a(), r111) == false) goto L76;
    L66:
        if (r210.f() == false) goto L70;
        if (r210.c() != 0) goto L70;
    L75:
        r139 = true;
    L70:
        if (r210.f() == true) goto L76;
        if (r210.b() == false) goto L76;
        if (r210.c() <= 0) goto L76;
    L53:
        r119 = r115;
        goto L54
    L29:
        if (r114.d() != 0) goto L31;
        r114 = a5.a(r114, 0, false, null, 7200000, 63);
    L31:
        r210 = r114;
        goto L33
    L137:
        Set r140 = r107.keySet();
        k r141 = r310.d();
        if (r141 == null) goto L170;
        DownloadOwnerKind r142 = r141.c();
        DownloadOwnerKind r143 = DownloadOwnerKind.G1_MANUAL;
        if (r142 != r143) goto L154;
        if (r141.b().a() != 16) goto L154;
        if ((!StringsKt.isBlank(r141.b().b())) == false) goto L154;
        String r144 = r141.e();
        if (r144 != null) goto L148;
    L151:
        boolean r145 = true;
    L152:
        if (r145 == true) goto L154;
    L166:
        boolean r146 = true;
    L168:
        if (r146 == false) goto L170;
        k r147 = r141;
    L171:
        List<y4> r148 = r310.j();
        t4 r149 = r310.h();
        if (r149 != null) goto L174;
    L199:
        t4 r150 = null;
    L201:
        if (r310.h() == null) goto L205;
        if (r150 != null) goto L205;
        boolean r151 = false;
    L206:
        if (r151 == false) goto L343;
        if (r310.l() == null) goto L216;
        if (r150 == null) goto L211;
        String r152 = r150.e();
    L213:
        if (Intrinsics.areEqual(r152, r310.l().d()) == true) goto L216;
        boolean r153 = false;
    L217:
        if (r153 == false) goto L341;
        Collection r154 = r107.values();
        if ((r154 instanceof Collection) == true) goto L221;
    L223:
        Iterator r155 = r154.iterator();
    L225:
        if (r155.hasNext() == false) goto L237;
        f r156 = (f) r155.next();
        if (ACTIVE_INSTALL_PHASES.contains(r156.f().j()) == false) goto L234;
        if (r150 == null) goto L230;
        e r157 = r150.c();
    L232:
        if (Intrinsics.areEqual(r157, r156.g()) == true) goto L234;
        boolean r158 = true;
    L235:
        if (r158 == false) goto L225;
        boolean r159 = false;
    L238:
        if (r159 == false) goto L339;
        Long r160 = Long.valueOf(r310.g());
        if (r160.longValue() <= 0) goto L242;
        boolean r161 = true;
    L243:
        if (r161 == true) goto L246;
        r160 = null;
    L246:
        if (r160 == null) goto L248;
        long r162 = r160.longValue();
    L249:
        long r163 = RangesKt.coerceAtLeast(r310.n(), 0);
        List<e> r164 = r310.m();
        ArrayList r165 = new ArrayList();
        Iterator<T> r166 = r164.iterator();
    L251:
        if (r166.hasNext() == false) goto L255;
        Object r167 = r166.next();
        if (r140.contains((e) r167) == false) goto L251;
        r165.add(r167);
        goto L251
    L255:
        List r168 = CollectionsKt.distinct(r165);
        if (r148 != null) goto L258;
        r148 = CollectionsKt.emptyList();
    L258:
        ArrayList r169 = new ArrayList();
        Iterator<T> r170 = r148.iterator();
    L260:
        if (r170.hasNext() == false) goto L274;
        Object r171 = r170.next();
        y4 r172 = (y4) r171;
        if (r172.a().a() == 16) goto L264;
    L270:
        boolean r173 = false;
    L271:
        if (r173 == false) goto L260;
        r169.add(r171);
        goto L260
    L264:
        if ((!StringsKt.isBlank(r172.a().b())) == false) goto L270;
        if ((!StringsKt.isBlank(r172.b())) == false) goto L270;
        if (r172.c() <= 0) goto L270;
        r173 = true;
        goto L271
    L274:
        HashSet r174 = new HashSet();
        ArrayList r175 = new ArrayList();
        Iterator r176 = r169.iterator();
    L276:
        if (r176.hasNext() == false) goto L280;
        Object r177 = r176.next();
        if (r174.add(((y4) r177).b()) == false) goto L276;
        r175.add(r177);
        goto L276
    L280:
        t5 r178 = r310.o();
        if (r178 != null) goto L283;
    L290:
        r178 = null;
    L291:
        List<u4> r179 = r310.i();
        ArrayList r180 = new ArrayList();
        Iterator<T> r181 = r179.iterator();
    L293:
        if (r181.hasNext() == false) goto L303;
        Object r182 = r181.next();
        u4 r183 = (u4) r182;
        if (r183.c() != InstallOwnerKind.G1_MANUAL) goto L297;
    L299:
        boolean r184 = false;
    L300:
        if (r184 == false) goto L293;
        r180.add(r182);
        goto L293
    L297:
        if (r140.contains(r183.b()) == false) goto L299;
        r184 = true;
        goto L300
    L303:
        HashSet r185 = new HashSet();
        ArrayList r186 = new ArrayList();
        Iterator r187 = r180.iterator();
    L305:
        if (r187.hasNext() == false) goto L309;
        Object r188 = r187.next();
        if (r185.add(((u4) r188).b()) == false) goto L305;
        r186.add(r188);
        goto L305
    L309:
        h5 r189 = r310.l();
        if (r189 == null) goto L322;
        if (r150 == null) goto L313;
        String r190 = r150.e();
    L315:
        if (Intrinsics.areEqual(r190, r189.d()) == true) goto L317;
    L319:
        boolean r191 = false;
    L320:
        if (r191 == false) goto L322;
    L323:
        z4 r192 = r310.e();
        if (r192 != null) goto L326;
    L335:
        z4 r193 = null;
    L337:
        return b5.a(r310, false, r162, r163, null, r147, r168, r175, r150, r178, r193, r186, r189, r107, RangesKt.coerceAtLeast(r310.k(), 1), 9);
    L326:
        if (r192.c().a() == 16) goto L328;
    L332:
        boolean r194 = false;
    L333:
        if (r194 == false) goto L335;
        r193 = r192;
        goto L337
    L328:
        if ((!StringsKt.isBlank(r192.c().b())) == false) goto L332;
        if (r192.b() <= 0) goto L332;
        r194 = true;
        goto L333
    L317:
        if (Intrinsics.areEqual(r150.c(), r189.b()) == false) goto L319;
        r191 = true;
        goto L320
    L313:
        r190 = null;
    L322:
        r189 = null;
        goto L323
    L283:
        if (r140.contains(r178.a()) == true) goto L285;
    L287:
        boolean r195 = false;
    L288:
        if (r195 == false) goto L290;
    L285:
        if ((!StringsKt.isBlank(r178.b())) == false) goto L287;
        r195 = true;
        goto L288
    L248:
        r162 = 1800000;
        goto L249
    L242:
        r161 = false;
        goto L243
    L339:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L230:
        r157 = null;
    L234:
        r158 = false;
    L237:
        r159 = true;
        goto L238
    L221:
        if (r154.isEmpty() == false) goto L223;
    L341:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L211:
        r152 = null;
    L216:
        r153 = true;
        goto L217
    L343:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L205:
        r151 = true;
        goto L206
    L174:
        if (r149.d() != InstallOwnerKind.G1_MANUAL) goto L182;
        if (r149.c().a() != 16) goto L182;
        if ((!StringsKt.isBlank(r149.c().b())) == false) goto L182;
        if ((!StringsKt.isBlank(r149.e())) == false) goto L182;
    L195:
        boolean r196 = true;
    L197:
        if (r196 == false) goto L199;
        r150 = r149;
    L182:
        if (r140.contains(r149.c()) == false) goto L196;
        f r197 = (f) r107.get(r149.c());
        if (r197 == null) goto L188;
        v4 r198 = r197.f();
        if (r198 == null) goto L188;
        String r199 = r198.h();
    L190:
        if (Intrinsics.areEqual(r199, r149.e()) == false) goto L196;
        if (r149.g() == null) goto L195;
        if (Intrinsics.areEqual(r149.g().a(), r149.c()) == false) goto L196;
    L188:
        r199 = null;
    L196:
        r196 = false;
        goto L197
    L148:
        if (StringsKt.isBlank(r144) == true) goto L151;
        r145 = false;
    L154:
        if (r141.c() != r143) goto L156;
    L167:
        r146 = false;
        goto L168
    L156:
        if (r140.contains(r141.b()) == false) goto L167;
        f r1100 = (f) r107.get(r141.b());
        if (r1100 == null) goto L164;
        l r1101 = r1100.c();
        if (r1101 == null) goto L164;
        if (r1101.i() != r141.d()) goto L164;
        boolean r1102 = true;
    L165:
        if (r1102 == false) goto L167;
    L164:
        r1102 = false;
    L170:
        r147 = null;
        goto L171
    }

    public static boolean d(e5 r100, e r101) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (e(r100.h(), r101) == true) goto L7;
    L11:
        return false;
    L7:
        if (Intrinsics.areEqual(r100.h().b(), r100.g()) == false) goto L11;
        if ((!StringsKt.isBlank(r100.g())) == false) goto L11;
        return true;
    }

    public static boolean e(d5 r100, e r101) {
        if (Intrinsics.areEqual(r100.a(), r101) == true) goto L5;
        return false;
    L5:
        if (r100.c() > 0) goto L7;
        return false;
    L7:
        if ((!StringsKt.isBlank(r100.f())) == false) goto L25;
        int r102 = r100.getType();
        if (1 <= r102) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L16;
        return false;
    L16:
        if (r100.e() > 0) goto L18;
        return false;
    L18:
        if ((!StringsKt.isBlank(r100.d())) == true) goto L20;
        return false;
    L20:
        if ((!StringsKt.isBlank(r100.b())) == false) goto L29;
        return true;
    L29:
        return false;
    L11:
        if (r102 >= 3) goto L13;
        r103 = true;
        goto L14
    L25:
        return false;
    }
}
