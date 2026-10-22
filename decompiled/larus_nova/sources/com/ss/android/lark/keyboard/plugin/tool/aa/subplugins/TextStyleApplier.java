package com.ss.android.lark.keyboard.plugin.tool.aa.subplugins;

import android.text.Editable;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class TextStyleApplier {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f429577m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<?> f429578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f429579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f429580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oob.d f429581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f429582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<Editable, Integer, Integer, Unit> f429583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function3<Editable, Integer, Integer, Unit> f429584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function3<Editable, Integer, Integer, Unit> f429585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function3<? super Editable, ? super Integer, ? super Integer, Unit> f429586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f429587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f429588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f429589l;

    public static final class a {
    }

    public interface b {
        void a(boolean r100);
    }

    public interface c {
        void b(Object r100);
    }

    public interface d<T> {
        T a();

        Class<T> b();
    }

    static {
    }

    public final Object b() {
        Object r100 = this.f429578a.a();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void f() {
        oob.d r100 = this.f429581d;
        int r101 = r100.f524673a;
        if (r101 != (-1)) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        boolean r103 = this.f429580c;
        int r104 = r100.f524674b;
        if ((r104 - r101) <= 0) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L29;
        if (r103 == true) goto L22;
        this.f429580c = true;
        b r106 = this.f429589l;
        if (r106 == null) goto L20;
        r106.a(true);
    L20:
        if (this.f429582e != 0) goto L42;
        this.f429586i = this.f429584g;
        return;
    L42:
        return;
    L22:
        this.f429580c = false;
        b r107 = this.f429589l;
        if (r107 == null) goto L25;
        r107.a(false);
    L25:
        this.f429586i = this.f429583f;
        if (this.f429582e == 0) goto L44;
        this.f429586i = this.f429585h;
        return;
    L44:
        return;
    L29:
        Editable r108 = r100.f524675c;
        if (r108 != null) goto L32;
        return;
    L32:
        int r109 = this.f429582e;
        if (r109 == 0) goto L39;
        if (r109 == 1) goto L39;
        if (r109 != 3) goto L40;
        d(r108, r101, r104);
    L40:
        oob.d r110 = this.f429581d;
        c(r110.f524675c, r110.f524673a, r110.f524674b);
        return;
    L39:
        e(r108, r101, r104);
        goto L40
    L13:
        r105 = false;
        goto L14
    L5:
        if (r100.f524674b == (-1)) goto L7;
        r102 = true;
        goto L8
    }

    public TextStyleApplier(d<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "spanFactory");
        this.f429578a = r100;
        this.f429579b = LazyKt.lazy(LazyThreadSafetyMode.NONE, new TextStyleApplier$spanClass$2(this));
        this.f429581d = new oob.d();
        TextStyleApplier$emptyAction$1 r101 = TextStyleApplier$emptyAction$1.INSTANCE;
        this.f429583f = r101;
        this.f429584g = new TextStyleApplier$actionSetSpan$1(this);
        this.f429585h = new TextStyleApplier$actionRemoveSpan$1(this);
        this.f429586i = r101;
    }

    public final void a(Editable r110) {
        int r100 = this.f429587j + 1;
        this.f429587j = r100;
        if ((r100 % 10) <= 0) goto L5;
        return;
    L5:
        int r101 = 0;
        Object[] r102 = r110.getSpans(0, r110.length() - 1, (Class) this.f429579b.getValue());
        boolean[] r103 = new boolean[r110.length() + 1];
        Intrinsics.checkNotNull(r102);
        int r104 = r102.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L12;
        Object r106 = r102[r105];
        int r107 = r110.getSpanStart(r106);
        int r108 = r110.getSpanEnd(r106);
    L8:
        if (r107 > r108) goto L10;
        r103[r107] = true;
        r107 = r107 + 1;
        goto L8
    L10:
        r110.removeSpan(r106);
        r105 = r105 + 1;
    L12:
        if (r101 >= r110.length()) goto L23;
        if (r103[r101] == false) goto L22;
        int r109 = r101;
    L17:
        if (r109 >= r110.length()) goto L21;
        if (r103[r109] == false) goto L21;
        r109 = r109 + 1;
    L21:
        r110.setSpan(b(), r101, r109 - 1, 34);
        r101 = r109;
    L22:
        r101 = r101 + 1;
        goto L12
    }

    public final void c(Editable r110, int r111, int r112) {
        int r113 = r112 - r111;
        if (r110 == null) goto L52;
        if (r113 < 0) goto L56;
        this.f429582e = 0;
        oob.d r100 = this.f429581d;
        r100.f524675c = r110;
        int r101 = r111 + r113;
        r100.f524673a = r111;
        r100.f524674b = r101;
        Object[] r102 = r110.getSpans(r111, r101, (Class) this.f429579b.getValue());
        int r103 = r113 + 1;
        boolean[] r104 = new boolean[r103];
        Intrinsics.checkNotNull(r102);
        int r105 = r102.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L22;
        Object r107 = r102[r106];
        int r108 = r110.getSpanStart(r107);
        int r109 = r110.getSpanEnd(r107);
    L10:
        if (r108 > r109) goto L20;
        int r114 = r108 - r111;
        if (r114 <= r113) goto L14;
        r114 = r113;
    L14:
        if (r114 == 0) goto L19;
        if (r114 >= 0) goto L18;
        r114 = 0;
    L18:
        r104[r114] = true;
    L19:
        r108 = r108 + 1;
        goto L10
    L20:
        r106 = r106 + 1;
        goto L8
    L22:
        if (ArraysKt.contains(r104, true) == false) goto L24;
        this.f429582e |= 1;
    L24:
        boolean r115 = !ArraysKt.contains(r104, false);
        if (r103 > 1) goto L27;
    L29:
        boolean r116 = false;
    L30:
        if (r115 == true) goto L32;
        if (r116 == true) goto L32;
    L34:
        if (this.f429582e != 0) goto L40;
        this.f429580c = false;
        b r117 = this.f429589l;
        if (r117 == null) goto L38;
        r117.a(false);
    L38:
        this.f429586i = this.f429583f;
        return;
    L40:
        if (this.f429580c == true) goto L54;
        this.f429580c = true;
        b r118 = this.f429589l;
        if (r118 == null) goto L45;
        r118.a(true);
    L45:
        if (this.f429582e != 0) goto L55;
        this.f429586i = this.f429584g;
        return;
    L55:
        return;
    L54:
        return;
    L32:
        this.f429582e |= 3;
        goto L34
    L27:
        if (ArraysKt.takeLast(r104, r113).contains(Boolean.FALSE) == true) goto L29;
        r116 = true;
        goto L30
    L56:
        return;
    }

    public final void d(Editable r110, int r111, int r112) {
        ArrayList r100 = new ArrayList();
        HashMap r101 = new HashMap();
        Object[] r102 = r110.getSpans(r111, r112, (Class) this.f429579b.getValue());
        Intrinsics.checkNotNull(r102);
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        Object r105 = r102[r104];
        int r106 = r110.getSpanStart(r105);
        int r107 = r110.getSpanEnd(r105);
        if (r106 >= r111) goto L7;
        r101.put(TuplesKt.to(Integer.valueOf(r106), Integer.valueOf(r111)), b());
    L7:
        if (r107 <= r112) goto L9;
        r101.put(TuplesKt.to(Integer.valueOf(r112), Integer.valueOf(r107)), b());
    L9:
        Intrinsics.checkNotNull(r105);
        r100.add(r105);
        r104 = r104 + 1;
        goto L3
    L10:
        Pair r113 = TuplesKt.to(r100, r101);
        List r114 = (List) r113.component1();
        HashMap r115 = (HashMap) r113.component2();
        Iterator r116 = r114.iterator();     // Catch: Exception -> L16
    L13:
        if (r116.hasNext() == false) goto L18;
        r110.removeSpan(r116.next());     // Catch: Exception -> L16
    L18:
        Iterator r117 = r115.entrySet().iterator();
    L20:
        if (r117.hasNext() == false) goto L22;
        Map.Entry r118 = (Map.Entry) r117.next();
        Pair r108 = (Pair) r118.getKey();
        r110.setSpan(r118.getValue(), ((Number) r108.component1()).intValue(), ((Number) r108.component2()).intValue(), 34);
        goto L20
    L22:
        a(r110);
        return;
    L16:
        e = move-exception;
        Log.e("BaseTextStyleApplier", "removeSpanInner: There is something wrong with Editable#removeSpan, we catch and consume this exception to prevent crash. exception is " + ExceptionsKt.stackTraceToString(e));
        goto L18
    }

    public final void e(Editable r100, int r101, int r102) {
        Object r103 = b();
        Log.d("BaseTextStyleApplier", "setSpanInner: span is " + r103.getClass().getName() + ", start=" + r101 + ", end=" + r102);
        c r104 = this.f429588k;
        if (r104 == null) goto L5;
        r104.b(r103);
    L5:
        r100.setSpan(b(), r101, r102, 34);
        a(r100);
    }
}
