package xs8;

import android.content.Context;
import androidx.collection.SieveCacheKt;
import com.bytedance.keva.Keva;
import com.larus.bmhome.actionbar.model.a0;
import com.larus.bmhome.actionbar.model.c0;
import com.larus.bmhome.actionbar.model.f0;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.CollaboratedMultiFeatureSelectorWidget;
import com.larus.bmhome.view.actionbar.edit.component.j0;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import ouc.v;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends up8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f565007l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.b f565008m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f565009n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<Integer, Long> f565010o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<Integer, Integer> f565011p;

    @Override // up8.b
    public int getType() {
        return 8;
    }

    @Override // up8.b
    public final int i() {
        return 9;
    }

    public final void G() {
        com.larus.bmhome.actionbar.model.b r100 = this.f565008m;
        if (r100 == null) goto L5;
        r100.f294981c = this.f565009n;
    L5:
        a0 r101 = s();
        if (r101 == null) goto L8;
        List<f0> r102 = r101.f294961c;
    L9:
        if (r102 != null) goto L11;
        r102 = CollectionsKt.emptyList();
    L11:
        Iterator<T> r103 = r102.iterator();
    L13:
        if (r103.hasNext() == false) goto L53;
        f0 r104 = (f0) r103.next();
        Integer r105 = r104.f();
        if (r105 == null) goto L13;
        int r106 = r105.intValue();
        com.larus.bmhome.actionbar.model.h r107 = r104.d();
        if (r107 == null) goto L41;
        Long r108 = (Long) ((LinkedHashMap) this.f565010o).get(Integer.valueOf(r106));
        List<w> r109 = r107.f295167e;
        if (r109 == null) goto L30;
        List<w> r110 = r109;
        ArrayList r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator<T> r112 = r110.iterator();
    L22:
        if (r112.hasNext() == false) goto L31;
        w r113 = (w) r112.next();
        if (r108 != null) goto L26;
    L28:
        int r114 = 0;
    L29:
        r111.add(w.a(r113, null, null, Integer.valueOf(r114), null, null, null, 8126463));
        goto L22
    L26:
        if (Intrinsics.areEqual(r113.f295510a, r108) == false) goto L28;
        r114 = 1;
    L31:
        r107.f295167e = r111;
        r104.f295113c = r107;
        r104.f295120j = r111;
        r104.f295119i = r107.f295166d;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L34
        Object r116 = Result.m9449constructorimpl(xt7.d.f565073b.a(com.larus.bmhome.actionbar.model.h.Companion.serializer(), r107));     // Catch: Throwable -> L34
    L36:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L40;
        FLogger.f375446a.e("CollaboratedMultiFeatureSelectorController", "sync dropdown template failed", r117);
        r116 = r104.f295112b;
    L40:
        r104.f295112b = (String) r116;
    L34:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L30:
        r111 = null;
    L41:
        com.larus.bmhome.actionbar.model.j r119 = r104.e();
        if (r119 == null) goto L13;
        Integer r120 = (Integer) ((LinkedHashMap) this.f565011p).get(Integer.valueOf(r106));
        r119.f295213i = r120;
        r104.f295114d = r119;
        r104.f295132v = r120;
        r104.f295119i = r119.f295207c;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L46
        Object r122 = Result.m9449constructorimpl(xt7.d.f565073b.a(com.larus.bmhome.actionbar.model.j.Companion.serializer(), r119));     // Catch: Throwable -> L46
    L48:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L52;
        FLogger.f375446a.e("CollaboratedMultiFeatureSelectorController", "sync duration template failed", r123);
        r122 = r104.f295112b;
    L52:
        r104.f295112b = (String) r122;
    L46:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L48
    L53:
        return;
    L8:
        r102 = null;
        goto L9
    }

    @Override // up8.d
    public final String g() {
        com.larus.bmhome.actionbar.model.b r100 = this.f565008m;
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        G();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(xt7.d.f565073b.a(kuc.a.d(com.larus.bmhome.actionbar.model.b.Companion.serializer()), r100));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == true) goto L15;
        r101 = r103;
    L15:
        return (String) r101;
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final a0 s() {
        com.larus.bmhome.actionbar.model.b r100 = this.f565008m;
        if (r100 == null) goto L5;
        Map<String, a0> r101 = r100.f294979a;
    L6:
        if (r101 != null) goto L8;
        r101 = MapsKt.emptyMap();
    L8:
        String r102 = this.f565009n;
        if (r102 == null) goto L13;
        a0 r103 = r101.get(r102);
        if (r103 == null) goto L13;
        return r103;
    L13:
        return (a0) CollectionsKt.firstOrNull(r101.values());
    L5:
        r101 = null;
        goto L6
    }

    public final Map<Integer, Long> z() {
        return MapsKt.toMap(this.f565010o);
    }

    public d() {
        this.f565007l = LazyKt.lazy(new b());
        this.f565010o = new LinkedHashMap();
        this.f565011p = new LinkedHashMap();
    }

    @Override // up8.d
    public final boolean a() {
        a0 r100 = s();
        if (r100 == null) goto L5;
        List<f0> r101 = r100.f294961c;
    L6:
        if (r101 != null) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        List<f0> r102 = r101;
        if ((r102 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r103 = r102.iterator();
    L15:
        if (r103.hasNext() == false) goto L42;
        f0 r104 = (f0) r103.next();
        Integer r105 = r104.f();
        if (r105 == null) goto L32;
        int r106 = r105.intValue();
        com.larus.bmhome.actionbar.model.h r107 = r104.d();
        if (r107 != null) goto L21;
        com.larus.bmhome.actionbar.model.j r108 = r104.e();
        if (r108 == null) goto L32;
        if (Intrinsics.areEqual(r108.f295214j, Boolean.TRUE) == true) goto L32;
        Map<Integer, Integer> r109 = this.f565011p;
        LinkedHashMap r110 = (LinkedHashMap) r109;
        if (r110.get(Integer.valueOf(r106)) != null) goto L32;
    L25:
        boolean r111 = false;
    L33:
        if (r111 == true) goto L15;
        return false;
    L21:
        if (Intrinsics.areEqual(r107.f295170h, Boolean.TRUE) == true) goto L32;
        Map<Integer, Long> r112 = this.f565010o;
        LinkedHashMap r113 = (LinkedHashMap) r112;
        if (r113.get(Integer.valueOf(r106)) == null) goto L25;
    L32:
        r111 = true;
        goto L33
    L42:
        return true;
    L11:
        if (r102.isEmpty() == false) goto L13;
        return true;
    L5:
        r101 = null;
        goto L6
    }

    public static Long E(com.larus.bmhome.actionbar.model.h r100) {
        List<w> r101 = r100.f295167e;
        if (r101 == null) goto L26;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        Integer r104 = ((w) r103).f295528s;
        if (r104 == null) goto L13;
        boolean r105 = true;
        if (r104.intValue() != 1) goto L13;
    L14:
        if (r105 == false) goto L6;
    L17:
        w r106 = (w) r103;
        if (r106 != null) goto L20;
        return null;
    L20:
        return r106.f295510a;
    L13:
        r105 = false;
        goto L14
    L16:
        r103 = null;
        goto L17
    L26:
        return null;
    }

    public static com.larus.bmhome.actionbar.model.h u(c0 r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        v r102 = xt7.d.f565073b;     // Catch: Throwable -> L7
        juc.d<com.larus.bmhome.actionbar.model.h> r103 = com.larus.bmhome.actionbar.model.h.Companion.serializer();     // Catch: Throwable -> L7
        String r104 = r100.f295033c;     // Catch: Throwable -> L7
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        Object r105 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.h) r102.c(r103, r104));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r105) == false) goto L13;
        r105 = null;
    L13:
        return (com.larus.bmhome.actionbar.model.h) r105;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static Long x(com.larus.bmhome.actionbar.model.h r100) {
        if (Intrinsics.areEqual(r100.f295170h, Boolean.TRUE) == false) goto L5;
        return null;
    L5:
        Long r101 = r100.f295169g;
        if (r101 != null) goto L8;
    L14:
        Integer r102 = r100.f295168f;
        if (r102 == null) goto L17;
        int r103 = r102.intValue();
    L18:
        List<w> r104 = r100.f295167e;
        if (r104 == null) goto L24;
        w r105 = (w) CollectionsKt.getOrNull(r104, r103);
        if (r105 != null) goto L23;
        return null;
    L23:
        return r105.f295510a;
    L24:
        return null;
    L17:
        r103 = -1;
        goto L18
    L8:
        if (w(r100, Long.valueOf(r101.longValue())) == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        return Long.valueOf(r101.longValue());
    }

    public final void F(Long r100) {
        if (r100 == null) goto L22;
        String r101 = r100.toString();
        if (r101 == null) goto L23;
        com.larus.bmhome.actionbar.model.b r102 = this.f565008m;
        if (r102 == null) goto L8;
        Map<String, a0> r103 = r102.f294979a;
    L9:
        if (r103 != null) goto L12;
        r103 = MapsKt.emptyMap();
    L12:
        if (r103.containsKey(r101) == true) goto L15;
        r101 = null;
    L15:
        if (r101 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(r101, this.f565009n) == false) goto L20;
        return;
    L20:
        this.f565009n = r101;
        B(true, true);
        G();
        FLogger.f375446a.i("CollaboratedMultiFeatureSelectorController", "switchActiveConfigByOptionId activeConfigKey=" + this.f565009n);
        return;
    L8:
        r103 = null;
        goto L9
    L23:
        return;
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new CollaboratedMultiFeatureSelectorWidget(r100);
    }

    @Override // up8.b
    public final void m(Map<String, ?> r110) {
        Intrinsics.checkNotNullParameter(r110, "instructionDefaultParams");
        Object r111 = r110.get("2");
        if ((r111 instanceof Map) == false) goto L5;
        Map r112 = (Map) r111;
    L6:
        com.larus.bmhome.actionbar.model.b r100 = this.f565008m;
        if (r100 == null) goto L24;
        Integer r101 = r100.f294980b;
        if (r101 == null) goto L24;
        String r102 = y(r112, r101.intValue(), false);
        if (r102 == null) goto L24;
        com.larus.bmhome.actionbar.model.b r103 = this.f565008m;
        if (r103 == null) goto L15;
        Map<String, a0> r104 = r103.f294979a;
    L16:
        if (r104 != null) goto L19;
        r104 = MapsKt.emptyMap();
    L19:
        if (r104.containsKey(r102) == true) goto L22;
        r102 = null;
    L22:
        if (r102 == null) goto L24;
        this.f565009n = r102;
        goto L24
    L15:
        r104 = null;
    L24:
        a0 r105 = s();
        if (r105 != null) goto L27;
        return;
    L27:
        List<f0> r106 = r105.f294961c;
        if (r106 != null) goto L31;
        r106 = CollectionsKt.emptyList();
    L31:
        if (r106.isEmpty() == false) goto L33;
        return;
    L33:
        t(r105, false, false);
        Iterator<T> r107 = r106.iterator();
    L34:
        boolean r108 = true;
        if (r107.hasNext() == false) goto L88;
        f0 r109 = (f0) r107.next();
        Integer r113 = r109.f();
        if (r113 == null) goto L34;
        int r114 = r113.intValue();
        com.larus.bmhome.actionbar.model.h r115 = r109.d();
        if (r115 == null) goto L34;
        Integer r116 = this.f551067g;
        if (r116 != null) goto L45;
    L52:
        if (r116 != null) goto L55;
    L56:
        if (r116 != null) goto L59;
    L66:
        r108 = false;
    L67:
        String r117 = y(r112, r114, r108);
        if (r117 == null) goto L34;
        List<w> r118 = r115.f295167e;
        if (r118 == null) goto L34;
        Iterator<T> r119 = r118.iterator();
    L74:
        if (r119.hasNext() == false) goto L82;
        Object r120 = r119.next();
        Long r121 = ((w) r120).f295510a;
        if (r121 == null) goto L78;
        String r122 = r121.toString();
    L80:
        if (Intrinsics.areEqual(r122, r117) == false) goto L74;
    L83:
        w r123 = (w) r120;
        if (r123 == null) goto L34;
        Long r124 = r123.f295510a;
        if (r124 == null) goto L34;
        long r125 = r124.longValue();
        this.f565010o.put(Integer.valueOf(r114), Long.valueOf(r125));
        goto L34
    L78:
        r122 = null;
        goto L80
    L82:
        r120 = null;
        goto L83
    L59:
        if (r116.intValue() != 24) goto L66;
    L60:
        Integer r126 = r115.f295164b;
        if (r126 == null) goto L66;
        if (r126.intValue() != 1) goto L66;
    L55:
        if (r116.intValue() == 18) goto L60;
    L45:
        if (r116.intValue() != 4) goto L52;
        Integer r127 = r115.f295164b;
        if (r127 == null) goto L66;
        if (r127.intValue() != 2) goto L66;
    L88:
        B(false, true);
        G();
        return;
    L5:
        r112 = null;
        goto L6
    }

    @Override // up8.b
    public final wa8.a0 n(String r110) {
        if (r110 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L11;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        Object r111 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.b) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r110));     // Catch: Throwable -> L14
    L16:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r111);
        if (r102 != null) goto L76;
        com.larus.bmhome.actionbar.model.b r112 = (com.larus.bmhome.actionbar.model.b) r111;
        this.f565008m = r112;
        Map<String, a0> r103 = r112.f294979a;
        if (r103 != null) goto L21;
        r103 = MapsKt.emptyMap();
    L21:
        String r104 = r112.f294981c;
        String r105 = null;
        if (r104 != null) goto L24;
    L29:
        com.larus.bmhome.actionbar.model.b r106 = this.f565008m;
        if (r106 == null) goto L63;
        Integer r107 = r106.f294980b;
        if (r107 == null) goto L63;
        int r108 = r107.intValue();
        up8.b r109 = this.f551066f;
        if (r109 == null) goto L63;
        List<up8.b> r113 = r109.f();
        if (r113 == null) goto L63;
        ArrayList r114 = new ArrayList();
        Iterator<T> r115 = r113.iterator();
    L39:
        if (r115.hasNext() == false) goto L43;
        Object r116 = r115.next();
        if ((r116 instanceof g) == false) goto L39;
        r114.add(r116);
        goto L39
    L43:
        Iterator r117 = r114.iterator();
    L45:
        if (r117.hasNext() == false) goto L57;
        Object r118 = r117.next();
        com.larus.bmhome.actionbar.model.h r119 = ((g) r118).f565019l;
        if (r119 == null) goto L54;
        Integer r120 = r119.f295164b;
        if (r120 == null) goto L54;
        if (r120.intValue() != r108) goto L54;
        boolean r121 = true;
    L55:
        if (r121 == false) goto L45;
    L58:
        g r122 = (g) r118;
        if (r122 == null) goto L63;
        com.larus.bmhome.actionbar.model.h r123 = r122.f565019l;
        if (r123 == null) goto L63;
        Long r124 = E(r123);
    L64:
        if (r124 == null) goto L72;
        String r125 = r124.toString();
        if (r125 == null) goto L72;
        if (r103.containsKey(r125) == false) goto L70;
        r105 = r125;
    L70:
        if (r105 == null) goto L72;
        r104 = r105;
    L73:
        this.f565009n = r104;
        t(s(), true, true);
        G();
        FLogger.f375446a.i("CollaboratedMultiFeatureSelectorController", "parseTemplate activeConfigKey=" + this.f565009n + ", collaboratedDropdownBoxId=" + r112.f294980b);
        return new wa8.a0(Boolean.TRUE, "");
    L72:
        r104 = (String) CollectionsKt.firstOrNull(r103.keySet());
    L54:
        r121 = false;
        goto L55
    L57:
        r118 = null;
    L63:
        r124 = null;
        goto L64
    L24:
        if (r103.containsKey(r104) == true) goto L27;
        r104 = null;
    L27:
        if (r104 == null) goto L29;
    L76:
        return new wa8.a0(Boolean.FALSE, r102.getMessage());
    L14:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L11:
        return new wa8.a0(Boolean.FALSE, "collaborated multi feature selector is empty template");
    L5:
        if (r110.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public static boolean A(com.larus.bmhome.actionbar.model.j r100, Integer r101) {
        if (r101 == null) goto L28;
        r101.intValue();
        Integer r102 = r100.f295208d;
        if (r102 == null) goto L29;
        int r103 = r102.intValue();
        Integer r104 = r100.f295209e;
        if (r104 == null) goto L30;
        int r105 = r104.intValue();
        Integer r106 = r100.f295210f;
        if (r106 == null) goto L11;
        int r107 = r106.intValue();
    L12:
        Integer r108 = Integer.valueOf(r107);
        if (r108.intValue() <= 0) goto L15;
        boolean r109 = true;
    L16:
        if (r109 == true) goto L19;
        r108 = null;
    L19:
        if (r108 == null) goto L21;
        int r110 = r108.intValue();
    L23:
        if (new IntRange(r103, r105).contains(r101.intValue()) == true) goto L25;
        return false;
    L25:
        if (((r101.intValue() - r103) % r110) != 0) goto L32;
        return true;
    L32:
        return false;
    L21:
        r110 = 1;
        goto L23
    L15:
        r109 = false;
        goto L16
    L11:
        r107 = 1;
        goto L12
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    }

    public static boolean w(com.larus.bmhome.actionbar.model.h r100, Long r101) {
        if (r101 == null) goto L24;
        r101.longValue();
        List<w> r102 = r100.f295167e;
        if (r102 == null) goto L25;
        List<w> r103 = r102;
        if ((r103 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r104 = r103.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((w) r104.next()).f295510a, r101) == false) goto L13;
        boolean r105 = true;
    L18:
        if (r105 != true) goto L26;
        return true;
    L26:
        return false;
    L17:
        r105 = false;
        goto L18
    L9:
        if (r103.isEmpty() == false) goto L11;
    L25:
        return false;
    L24:
        return false;
    }

    public final void B(boolean r100, boolean r101) {
        t(s(), r101, r100);
    }

    public final Long C(int r110, String r111) {
        String r100 = D(r110, r111);
        boolean r101 = false;
        if (((Keva) this.f565007l.getValue()).contains(r100) == false) goto L10;
        Long r112 = Long.valueOf(((Keva) this.f565007l.getValue()).getLong(r100, -1));
        if (r112.longValue() == (-1)) goto L7;
        r101 = true;
    L7:
        if (r101 == true) goto L9;
        return null;
    L9:
        return r112;
    L10:
        Keva r102 = (Keva) this.f565007l.getValue();
        String r103 = this.f565009n;
        if (r103 != null) goto L18;
        a0 r104 = s();
        if (r104 == null) goto L15;
        r103 = r104.f294959a;
    L16:
        if (r103 != null) goto L18;
        r103 = "default";
        goto L18
    L15:
        r103 = null;
    L18:
        StringBuilder r105 = new StringBuilder("collab_");
        com.larus.bmhome.view.actionbar.edit.c r106 = this.f551063c;
        if (r106 == null) goto L21;
        Integer r107 = r106.getInstructionType();
    L22:
        r105.append(r107);
        r105.append('_');
        r105.append(this.f551067g);
        r105.append('_');
        u r113 = this.f551062b;
        if (r113 == null) goto L25;
        Integer r114 = r113.f295474a;
    L26:
        r105.append(r114);
        r105.append('_');
        com.larus.bmhome.actionbar.model.b r115 = this.f565008m;
        if (r115 == null) goto L29;
        Integer r116 = r115.f294980b;
    L30:
        r105.append(r116);
        r105.append('_');
        r105.append(r103);
        r105.append('_');
        r105.append(r110);
        r105.append('_');
        r105.append(r111);
        Long r117 = Long.valueOf(r102.getLong(r105.toString(), -1));
        if (r117.longValue() == (-1)) goto L33;
        r101 = true;
    L33:
        if (r101 == true) goto L36;
        r117 = null;
    L36:
        if (r117 == null) goto L40;
        ((Keva) this.f565007l.getValue()).storeLong(r100, r117.longValue());
        return r117;
    L40:
        return null;
    L29:
        r116 = null;
        goto L30
    L25:
        r114 = null;
        goto L26
    L21:
        r107 = null;
        goto L22
    }

    public final String D(int r100, String r101) {
        StringBuilder r102 = new StringBuilder("collab_");
        com.larus.bmhome.view.actionbar.edit.c r103 = this.f551063c;
        Integer r104 = null;
        if (r103 == null) goto L5;
        Integer r105 = r103.getInstructionType();
    L6:
        r102.append(r105);
        r102.append('_');
        r102.append(this.f551067g);
        r102.append('_');
        u r106 = this.f551062b;
        if (r106 == null) goto L9;
        Integer r107 = r106.f295474a;
    L10:
        r102.append(r107);
        r102.append('_');
        com.larus.bmhome.actionbar.model.b r108 = this.f565008m;
        if (r108 == null) goto L13;
        r104 = r108.f294980b;
    L13:
        r102.append(r104);
        r102.append('_');
        r102.append(r100);
        r102.append('_');
        r102.append(r101);
        return r102.toString();
    L9:
        r107 = null;
        goto L10
    L5:
        r105 = null;
        goto L6
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl((com.larus.bmhome.actionbar.model.b) xt7.d.f565073b.c(com.larus.bmhome.actionbar.model.b.Companion.serializer(), r100));     // Catch: Throwable -> L5
    L7:
        List<f0> r104 = null;
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        com.larus.bmhome.actionbar.model.b r105 = (com.larus.bmhome.actionbar.model.b) r103;
        if (r105 != null) goto L13;
        return;
    L13:
        String r106 = r105.f294981c;
        if (r106 == null) goto L27;
        com.larus.bmhome.actionbar.model.b r107 = this.f565008m;
        if (r107 == null) goto L18;
        Map<String, a0> r108 = r107.f294979a;
    L19:
        if (r108 != null) goto L22;
        r108 = MapsKt.emptyMap();
    L22:
        if (r108.containsKey(r106) == true) goto L25;
        r106 = null;
    L25:
        if (r106 == null) goto L27;
    L28:
        this.f565009n = r106;
        a0 r109 = r105.d();
        if (r109 == null) goto L31;
        r104 = r109.f294961c;
    L31:
        if (r104 != null) goto L33;
        r104 = CollectionsKt.emptyList();
    L33:
        Iterator<T> r110 = r104.iterator();
    L35:
        if (r110.hasNext() == false) goto L48;
        f0 r111 = (f0) r110.next();
        Integer r112 = r111.f();
        if (r112 == null) goto L35;
        int r113 = r112.intValue();
        com.larus.bmhome.actionbar.model.h r114 = r111.d();
        if (r114 == null) goto L43;
        Long r115 = E(r114);
        if (r115 == null) goto L43;
        long r116 = r115.longValue();
        this.f565010o.put(Integer.valueOf(r113), Long.valueOf(r116));
    L43:
        com.larus.bmhome.actionbar.model.j r117 = r111.e();
        if (r117 == null) goto L35;
        Integer r118 = r117.f295213i;
        if (r118 == null) goto L35;
        int r119 = r118.intValue();
        this.f565011p.put(Integer.valueOf(r113), Integer.valueOf(r119));
        goto L35
    L48:
        B(false, true);
        G();
        return;
    L18:
        r108 = null;
    L27:
        r106 = this.f565009n;
    L5:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void v(Map<Integer, Long> r100, Map<Integer, Integer> r101) {
        Intrinsics.checkNotNullParameter(r100, "selectedDropdownOptionIds");
        Intrinsics.checkNotNullParameter(r101, "selectedDurations");
        ((LinkedHashMap) this.f565010o).clear();
        this.f565010o.putAll(r100);
        ((LinkedHashMap) this.f565011p).clear();
        this.f565011p.putAll(r101);
        B(false, true);
        a0 r102 = s();
        if (r102 == null) goto L5;
        List<f0> r103 = r102.f294961c;
    L6:
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L27;
        f0 r105 = (f0) r104.next();
        Integer r106 = r105.f();
        if (r106 == null) goto L10;
        int r107 = r106.intValue();
        com.larus.bmhome.actionbar.model.h r108 = r105.d();
        if (r108 != null) goto L16;
    L20:
        com.larus.bmhome.actionbar.model.j r109 = r105.e();
        if (r109 == null) goto L10;
        if (Intrinsics.areEqual(r109.f295215k, Boolean.TRUE) == false) goto L10;
        Integer r110 = (Integer) ((LinkedHashMap) this.f565011p).get(Integer.valueOf(r107));
        if (r110 == null) goto L10;
        ((Keva) this.f565007l.getValue()).storeLong(D(r107, "duration"), r110.intValue());
        goto L10
    L16:
        if (Intrinsics.areEqual(r108.f295171i, Boolean.TRUE) == false) goto L20;
        Long r111 = (Long) ((LinkedHashMap) this.f565010o).get(Integer.valueOf(r107));
        if (r111 == null) goto L20;
        ((Keva) this.f565007l.getValue()).storeLong(D(r107, "dropdown"), r111.longValue());
        goto L20
    L27:
        G();
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static String y(Map r100, int r101, boolean r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Object r103 = r100.get(String.valueOf(r101));
        if (r103 != null) goto L13;
        r103 = r100.get(Integer.valueOf(r101));
        if (r103 != null) goto L13;
        if (r102 == false) goto L11;
        r103 = r100.get("match_all_id");
        goto L13
    L11:
        r103 = null;
    L13:
        if ((r103 instanceof Map) == false) goto L15;
        Map r104 = (Map) r103;
    L16:
        if (r104 == null) goto L21;
        Object r105 = r104.get("default_select_id");
        if (r105 != null) goto L20;
        return null;
    L20:
        return r105.toString();
    L21:
        return null;
    L15:
        r104 = null;
        goto L16
    }

    public final void t(a0 r110, boolean r111, boolean r210) {
        if (r110 == null) goto L5;
        List<f0> r100 = r110.f294961c;
    L6:
        if (r100 != null) goto L8;
        r100 = CollectionsKt.emptyList();
    L8:
        Iterator<T> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L212;
        f0 r102 = (f0) r101.next();
        Integer r103 = r102.f();
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
        com.larus.bmhome.actionbar.model.h r105 = r102.d();
        long r106 = -1;
        boolean r107 = false;
        if (r105 == null) goto L103;
        Object r112 = ((LinkedHashMap) this.f565010o).get(Integer.valueOf(r104));
        Long r113 = (Long) r112;
        if (r111 == true) goto L18;
    L20:
        boolean r114 = false;
    L21:
        if (r114 == true) goto L24;
        r112 = null;
    L24:
        Long r115 = (Long) r112;
        if (r210 == true) goto L27;
    L29:
        Long r116 = null;
    L30:
        if (r210 == true) goto L32;
    L36:
        Long r117 = null;
    L37:
        if (r115 != null) goto L43;
        if (r117 != null) goto L42;
        r115 = E(r105);
        if (r115 != null) goto L43;
        r115 = x(r105);
        goto L43
    L42:
        r115 = r117;
    L43:
        List<w> r118 = r105.f295167e;
        if (r118 == null) goto L53;
        Iterator<T> r119 = r118.iterator();
    L47:
        if (r119.hasNext() == false) goto L51;
        Object r120 = r119.next();
        if (Intrinsics.areEqual(((w) r120).f295510a, r115) == false) goto L47;
    L52:
        w r121 = (w) r120;
    L54:
        if (r121 == null) goto L59;
        if (j0.g(r121) == true) goto L59;
    L88:
        this.f565010o.put(Integer.valueOf(r104), r115);
        if (r210 == true) goto L91;
    L94:
        boolean r108 = false;
    L95:
        if (r108 == false) goto L103;
        if (Intrinsics.areEqual(r116, r115) == true) goto L103;
        if (r115 == null) goto L101;
        long r122 = r115.longValue();
    L102:
        ((Keva) this.f565007l.getValue()).storeLong(D(r104, "dropdown"), r122);
        goto L103
    L101:
        r122 = -1;
        goto L102
    L91:
        if (Intrinsics.areEqual(r105.f295171i, Boolean.TRUE) == false) goto L94;
        if (r116 == null) goto L94;
        r108 = true;
    L59:
        if (Intrinsics.areEqual(r105.f295170h, Boolean.TRUE) == false) goto L61;
    L60:
        r115 = null;
        goto L88
    L61:
        r115 = x(r105);
        List<w> r123 = r105.f295167e;
        if (r123 == null) goto L71;
        Iterator<T> r124 = r123.iterator();
    L65:
        if (r124.hasNext() == false) goto L69;
        Object r125 = r124.next();
        if (Intrinsics.areEqual(((w) r125).f295510a, r115) == false) goto L65;
    L70:
        w r126 = (w) r125;
    L72:
        if (r126 != null) goto L74;
    L76:
        List<w> r127 = r105.f295167e;
        if (r127 == null) goto L60;
        Iterator<T> r128 = r127.iterator();
    L80:
        if (r128.hasNext() == false) goto L84;
        Object r129 = r128.next();
        if ((!j0.g((w) r129)) == false) goto L80;
    L85:
        w r130 = (w) r129;
        if (r130 == null) goto L60;
        r115 = r130.f295510a;
        goto L88
    L84:
        r129 = null;
        goto L85
    L74:
        if (j0.g(r126) == true) goto L76;
    L69:
        r125 = null;
        goto L70
    L71:
        r126 = null;
        goto L72
    L51:
        r120 = null;
        goto L52
    L53:
        r121 = null;
        goto L54
    L32:
        if (Intrinsics.areEqual(r105.f295171i, Boolean.TRUE) == false) goto L36;
        if (w(r105, r116) == false) goto L36;
        r117 = r116;
        goto L37
    L27:
        if (Intrinsics.areEqual(r105.f295171i, Boolean.TRUE) == false) goto L29;
        r116 = C(r104, "dropdown");
        goto L30
    L18:
        if (w(r105, r113) == false) goto L20;
        r114 = true;
    L103:
        com.larus.bmhome.actionbar.model.j r109 = r102.e();
        if (r109 == null) goto L10;
        Object r131 = ((LinkedHashMap) this.f565011p).get(Integer.valueOf(r104));
        Integer r132 = (Integer) r131;
        if (r111 == true) goto L108;
    L110:
        boolean r133 = false;
    L111:
        if (r133 == true) goto L114;
        r131 = null;
    L114:
        Integer r134 = (Integer) r131;
        if (r210 == true) goto L117;
    L131:
        Integer r135 = null;
    L132:
        if (r210 == true) goto L134;
    L138:
        Integer r136 = null;
    L139:
        if (r134 != null) goto L157;
        if (r136 != null) goto L155;
        r134 = r109.f295213i;
        if (A(r109, r134) == true) goto L145;
        r134 = null;
    L145:
        if (r134 != null) goto L157;
        r134 = r109.f295212h;
        if (Intrinsics.areEqual(r109.f295214j, Boolean.TRUE) == false) goto L149;
    L151:
        boolean r137 = false;
    L152:
        if (r137 == true) goto L157;
        r134 = null;
        goto L157
    L149:
        if (A(r109, r134) == false) goto L151;
        r137 = true;
        goto L152
    L155:
        r134 = r136;
    L157:
        if (A(r109, r134) == false) goto L162;
        if (j0.f(r109, r134) == true) goto L162;
    L193:
        this.f565011p.put(Integer.valueOf(r104), r134);
        if (r210 == true) goto L196;
    L199:
        if (r135 == null) goto L201;
        Long r138 = Long.valueOf(r135.intValue());
    L202:
        if (r134 == null) goto L204;
        Long r139 = Long.valueOf(r134.intValue());
    L205:
        if (r107 == false) goto L10;
        if (Intrinsics.areEqual(r138, r139) == true) goto L10;
        if (r139 == null) goto L211;
        r106 = r139.longValue();
    L211:
        ((Keva) this.f565007l.getValue()).storeLong(D(r104, "duration"), r106);
        goto L10
    L204:
        r139 = null;
        goto L205
    L201:
        r138 = null;
        goto L202
    L196:
        if (Intrinsics.areEqual(r109.f295215k, Boolean.TRUE) == false) goto L199;
        if (r135 == null) goto L199;
        r107 = true;
    L162:
        if (Intrinsics.areEqual(r109.f295214j, Boolean.TRUE) == true) goto L192;
        r134 = r109.f295212h;
        if (A(r109, r134) == true) goto L167;
    L169:
        Integer r140 = r109.f295208d;
        if (r140 == null) goto L192;
        int r141 = r140.intValue();
        Integer r142 = r109.f295209e;
        if (r142 == null) goto L192;
        int r143 = r142.intValue();
        Integer r144 = r109.f295210f;
        if (r144 == null) goto L176;
        int r145 = r144.intValue();
    L177:
        Integer r146 = Integer.valueOf(r145);
        if (r146.intValue() <= 0) goto L180;
        boolean r147 = true;
    L181:
        if (r147 == true) goto L184;
        r146 = null;
    L184:
        if (r146 == null) goto L186;
        int r148 = r146.intValue();
    L187:
        if (r141 > r143) goto L192;
        if (j0.f(r109, Integer.valueOf(r141)) == false) goto L190;
        r141 = r141 + r148;
        goto L187
    L190:
        r134 = Integer.valueOf(r141);
        goto L193
    L186:
        r148 = 1;
        goto L187
    L180:
        r147 = false;
        goto L181
    L176:
        r145 = 1;
        goto L177
    L167:
        if (j0.f(r109, r134) == true) goto L169;
    L192:
        r134 = null;
        goto L193
    L134:
        if (Intrinsics.areEqual(r109.f295215k, Boolean.TRUE) == false) goto L138;
        if (A(r109, r135) == false) goto L138;
        r136 = r135;
        goto L139
    L117:
        if (Intrinsics.areEqual(r109.f295215k, Boolean.TRUE) == false) goto L131;
        Long r149 = C(r104, "duration");
        if (r149 == null) goto L131;
        long r150 = r149.longValue();
        if (r150 >= SieveCacheKt.NodeMetaAndPreviousMask) goto L123;
    L125:
        boolean r151 = false;
    L126:
        if (r151 == true) goto L129;
        r149 = null;
    L129:
        if (r149 == null) goto L131;
        r135 = Integer.valueOf((int) r149.longValue());
        goto L132
    L123:
        if (r150 > SieveCacheKt.NodeLinkMask) goto L125;
        r151 = true;
        goto L126
    L108:
        if (A(r109, r132) == false) goto L110;
        r133 = true;
        goto L111
    L212:
        return;
    L5:
        r100 = null;
        goto L6
    }
}
