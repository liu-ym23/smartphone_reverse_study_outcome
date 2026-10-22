package com.larus.im.internal.delegate;

import com.larus.im.FlowRuntime;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 implements gd9.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d1 f348206b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gd9.a0 f348207c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gd9.a0 f348208a;

    @Override // gd9.a0
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f348208a.b(r100, r101);
    }

    static {
        f348206b = new d1();
        f348207c = FlowRuntime.b().d();
    }

    public d1() {
        this.f348208a = FlowRuntime.b().d();
    }

    @Override // gd9.a0
    public final void a(String r100, ouc.d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ouc.e0 r102 = new ouc.e0();
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, ouc.i>> r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, ouc.i> r104 = r103.next();
        r102.b(r104.getKey(), r104.getValue());
    L8:
        ouc.j.c(r102, "params_for_special", "flow_im_sdk");
        f348207c.a(r100, r102.a());
        c0.f348199b.i("FlowTrackingDelegate", r100 + ": " + r101);
    }
}
