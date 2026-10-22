package com.relax.relaxreact;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j1 extends o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d1 f405528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Object> f405529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f405530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f405531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<p1> f405532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f405533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p1 f405534j;

    @Override // com.relax.relaxreact.o1
    public final boolean a(o1 r100) {
        Intrinsics.checkNotNullParameter(r100, "vnode");
        if (super.a(r100) == false) goto L11;
        d1 r101 = this.f405528d;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L9:
        if (r100.c(r101) == false) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // com.relax.relaxreact.o1
    public final boolean c(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        d1 r101 = this.f405528d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("snapshot");
        r101 = null;
    L6:
        if (r101 != r100) goto L8;
        return true;
    L8:
        return false;
    }

    public j1(d1 r100, ArrayList r101, boolean r102, p1 r103) {
        Intrinsics.checkNotNullParameter(r100, "snapshot");
        super(VNodeType.Snapshot);
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f405528d = r100;
        this.f405529e = r101;
        this.f405530f = false;
        this.f405531g = null;
        this.f405532h = null;
        this.f405533i = r102;
        this.f405534j = r103;
    }
}
