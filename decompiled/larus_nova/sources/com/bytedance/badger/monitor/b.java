package com.bytedance.badger.monitor;

import com.bytedance.badger.t.e;
import com.bytedance.badger.t.g;
import com.bytedance.badger.t.i;
import com.bytedance.badger.t.j;
import com.bytedance.badger.t.l;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
final class b extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f199041a = null;

    static {
        f199041a = new b();
    }

    public b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r110) {
        l r100 = (l) r110;
        if ((r100 instanceof j) == false) goto L42;
        j r101 = (j) r100;
        if (r101.f199205a.size() < 6) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L40;
        Object r103 = ListProtector.get(r101.f199205a, 0);
        if (r103 == null) goto L38;
        int r104 = ((g) r103).f199202a;
        Object r105 = ListProtector.get(r101.f199205a, 1);
        if (r105 == null) goto L36;
        long r106 = ((i) r105).f199204a;
        Object r107 = ListProtector.get(r101.f199205a, 2);
        if (r107 == null) goto L34;
        long r108 = ((i) r107).f199204a;
        Object r109 = ListProtector.get(r101.f199205a, 3);
        if (r109 == null) goto L32;
        long r111 = ((i) r109).f199204a;
        Object r112 = ListProtector.get(r101.f199205a, 4);
        if (r112 == null) goto L30;
        boolean r113 = ((e) r112).f199200a;
        Object r114 = ListProtector.get(r101.f199205a, 5);
        if (r114 == null) goto L28;
        boolean r115 = ((e) r114).f199200a;
        Object r116 = ListProtector.get(r101.f199205a, 6);
        if (r116 == null) goto L26;
        return new c74.a(r104, r106, r108, r111, r113, r115, ((e) r116).f199200a);
    L26:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.BoolVal");
    L28:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.BoolVal");
    L30:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.BoolVal");
    L32:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.LongVal");
    L34:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.LongVal");
    L36:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.LongVal");
    L38:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.badger.bridge.TLVNode.IntVal");
    L40:
        throw new IllegalArgumentException("Insufficient fields in node".toString());
    L7:
        r102 = false;
        goto L8
    L42:
        throw new IllegalArgumentException("Expected ObjectVal node".toString());
    }
}
