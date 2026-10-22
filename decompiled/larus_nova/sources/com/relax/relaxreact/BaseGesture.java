package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class BaseGesture implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f405383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GestureTypeInner f405384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Object> f405385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Function2<Object, Object, Unit>> f405386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<BaseGesture> f405387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<BaseGesture> f405388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<BaseGesture> f405389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<BaseGesture> f405390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<BaseGesture> f405391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<BaseGesture> f405392j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList<BaseGesture> f405393k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<BaseGesture> f405394l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<BaseGesture> f405395m;

    @Override // com.relax.relaxreact.c0
    public final ArrayList<BaseGesture> a() {
        return com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[]{this});
    }

    @Override // com.relax.relaxreact.c0
    public final Map<String, Object> serialize() {
        LinkedHashMap r100 = new LinkedHashMap();
        Integer r101 = Integer.valueOf(this.f405383a);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("id", r101);
        Integer r102 = Integer.valueOf(getType().getValue());
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("type", r102);
        Map<String, Object> r103 = this.f405385c;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("config", r103);
        ArrayList r104 = com.bytedance.rts.kmp.foundation.i.e(this.f405387e, AnonymousClass1.INSTANCE);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("simultaneousWith", r104);
        ArrayList r105 = com.bytedance.rts.kmp.foundation.i.e(this.f405388f, AnonymousClass2.INSTANCE);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("waitFor", r105);
        ArrayList r106 = com.bytedance.rts.kmp.foundation.i.e(this.f405389g, AnonymousClass3.INSTANCE);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("continueWith", r106);
        final ArrayList r107 = com.bytedance.rts.kmp.foundation.i.b(new String[0]);
        com.bytedance.rts.kmp.foundation.j.b(this.f405386d, new BaseGesture$__getCallbackNames$1(r107));
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type kotlin.Any");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.put("callbacks", r107);
        return r100;
    }

    @Override // com.relax.relaxreact.x, com.relax.relaxreact.c0
    public GestureTypeInner getType() {
        return this.f405384b;
    }

    public BaseGesture(GestureTypeInner r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f405383a = -1;
        this.f405384b = GestureTypeInner.Default;
        LinkedHashMap r101 = new LinkedHashMap();
        this.f405385c = r101;
        this.f405386d = new LinkedHashMap();
        this.f405387e = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405388f = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405389g = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405390h = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405391i = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405392j = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405393k = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405394l = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405395m = com.bytedance.rts.kmp.foundation.i.b(new BaseGesture[0]);
        this.f405384b = r100;
        int r102 = v.f405593a;
        v.f405593a = r102 + 1;
        this.f405383a = r102;
        Boolean r103 = Boolean.TRUE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        r101.put("enabled", r103);
    }

    public final boolean d(String r110) {
        if (Intrinsics.areEqual(r110, "simultaneous") == false) goto L6;
        ArrayList<BaseGesture> r100 = this.f405390h;
    L10:
        if (Intrinsics.areEqual(r110, "simultaneous") == false) goto L13;
        ArrayList<BaseGesture> r101 = this.f405393k;
    L16:
        final ArrayList<BaseGesture> r102 = com.bytedance.rts.kmp.foundation.i.h(r100);
        com.bytedance.rts.kmp.foundation.i.c(r101, new BaseGesture$__extendRelation$1(r102));
        if (Intrinsics.areEqual(r110, "simultaneous") == false) goto L20;
        ArrayList<BaseGesture> r103 = this.f405387e;
    L23:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        int r105 = r103.size();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        Intrinsics.checkNotNullParameter(r102, "<this>");
        int r106 = r102.size();
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r105 != r106) goto L31;
        int r107 = 0;
    L27:
        IntCompanionObject r108 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        int r109 = r103.size();
        Intrinsics.checkNotNullParameter(r108, "<this>");
        if (r107 >= r109) goto L33;
        if (((BaseGesture) ListProtector.get(r103, r107)).f405383a != ((BaseGesture) ListProtector.get(r102, r107)).f405383a) goto L31;
        r107 = r107 + 1;
        goto L27
    L33:
        boolean r111 = true;
    L34:
        if (r111 == false) goto L37;
        return false;
    L37:
        if (Intrinsics.areEqual(r110, "simultaneous") == false) goto L40;
        this.f405387e = r102;
    L43:
        return true;
    L40:
        if (Intrinsics.areEqual(r110, "continueWith") == false) goto L42;
        this.f405389g = r102;
        goto L43
    L42:
        this.f405388f = r102;
    L31:
        r111 = false;
        goto L34
    L20:
        if (Intrinsics.areEqual(r110, "continueWith") == false) goto L22;
        r103 = this.f405389g;
        goto L23
    L22:
        r103 = this.f405388f;
        goto L23
    L13:
        if (Intrinsics.areEqual(r110, "continueWith") == false) goto L15;
        r101 = this.f405395m;
        goto L16
    L15:
        r101 = this.f405394l;
        goto L16
    L6:
        if (Intrinsics.areEqual(r110, "continueWith") == false) goto L8;
        r100 = this.f405392j;
        goto L10
    L8:
        r100 = this.f405391i;
        goto L10
    }

    public final void e(Object r100) {
        Intrinsics.checkNotNullParameter("minDistance", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        Object r101 = com.bytedance.rts.kmp.foundation.j.c(this.f405385c, "minDistance");
        if (r101 != null) goto L5;
    L7:
        com.bytedance.rts.kmp.foundation.j.e(this.f405385c, "minDistance", r100);
        return;
    L5:
        if (p0.a(r101, r100) == false) goto L7;
    }

    public final void b(String r100, BaseGesture r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "gesture");
        if (Intrinsics.areEqual(r100, "simultaneous") == false) goto L6;
        ArrayList<BaseGesture> r102 = this.f405390h;
    L9:
        int r103 = 0;
    L10:
        IntCompanionObject r104 = IntCompanionObject.INSTANCE;
        int r105 = com.bytedance.rts.kmp.foundation.i.a(r102);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (r103 >= r105) goto L16;
        if (((BaseGesture) ListProtector.get(r102, r103)).f405383a == r101.f405383a) goto L14;
        r103 = r103 + 1;
        goto L10
    L14:
        return;
    L16:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        r102.add(r101);
        d(r100);
        return;
    L6:
        if (Intrinsics.areEqual(r100, "continueWith") == false) goto L8;
        r102 = this.f405392j;
        goto L9
    L8:
        r102 = this.f405391i;
        goto L9
    }

    public final boolean c(String r100, ArrayList<BaseGesture> r101) {
        if (Intrinsics.areEqual(r100, "simultaneous") == false) goto L6;
        this.f405393k = com.bytedance.rts.kmp.foundation.i.h(r101);
    L10:
        return d(r100);
    L6:
        if (Intrinsics.areEqual(r100, "continueWith") == false) goto L8;
        this.f405395m = com.bytedance.rts.kmp.foundation.i.h(r101);
        goto L10
    L8:
        this.f405394l = com.bytedance.rts.kmp.foundation.i.h(r101);
        goto L10
    }
}
