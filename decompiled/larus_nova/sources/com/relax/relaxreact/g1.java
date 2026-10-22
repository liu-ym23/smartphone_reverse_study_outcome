package com.relax.relaxreact;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g1 extends t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f405507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public u f405508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<u> f405509g;

    public g1(SnapshotInstance r100, j1 r101) {
        Intrinsics.checkNotNullParameter(r100, "el");
        Intrinsics.checkNotNullParameter(r101, "vnode");
        super(FiberType.Snapshot, r100, r101);
    }
}
