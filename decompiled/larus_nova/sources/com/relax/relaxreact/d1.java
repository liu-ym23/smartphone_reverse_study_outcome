package com.relax.relaxreact;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f405484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<z0, SnapshotInstance, ArrayList<p>> f405485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> f405486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> f405487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<z0, SnapshotInstance, Unit> f405488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function4<z0, SnapshotInstance, Integer, Object, Unit> f405489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Integer> f405490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f405491h;

    public /* synthetic */ d1(Function2 r100, ArrayList r101, ArrayList r110) {
        this(r100, r101, r110, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d1(Function2<? super z0, ? super SnapshotInstance, ? extends ArrayList<p>> r100, ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r101, ArrayList<Integer> r102, ArrayList<Function4<z0, SnapshotInstance, Integer, Object, Unit>> r103, Function2<? super z0, ? super SnapshotInstance, Unit> r104, Function4<? super z0, ? super SnapshotInstance, ? super Integer, Object, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "create");
        long r105 = SnapshotKt.f405454a;
        this.f405484a = r105;
        SnapshotKt.f405454a = r105 + 1;
        this.f405485b = r100;
        this.f405486c = r101;
        this.f405487d = r103;
        this.f405488e = r104;
        this.f405489f = r110;
        this.f405490g = r102;
        boolean r106 = false;
        if (r102 == null) goto L9;
        IntCompanionObject r107 = IntCompanionObject.INSTANCE;
        Intrinsics.checkNotNull(r102);
        int r108 = com.bytedance.rts.kmp.foundation.i.a(r102);
        Intrinsics.checkNotNullParameter(r107, "<this>");
        if (r108 != 1) goto L9;
        Intrinsics.checkNotNull(r102);
        if ((((Number) ListProtector.get(r102, 0)).intValue() & (-16777216)) != 33554432) goto L9;
        r106 = true;
    L9:
        this.f405491h = r106;
    }
}
