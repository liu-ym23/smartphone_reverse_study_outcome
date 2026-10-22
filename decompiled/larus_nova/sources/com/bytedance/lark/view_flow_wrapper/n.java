package com.bytedance.lark.view_flow_wrapper;

import java.lang.AutoCloseable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public class n<M extends AutoCloseable> implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f254445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final buc.a f254446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f254447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public M f254448d;

    public n() {
        Intrinsics.checkNotNullParameter("UserForeground", "type");
        this.f254445a = "UserForeground";
        this.f254446b = buc.b.a(false);
        this.f254447c = LazyKt.lazy(new MoltenModule$identity$2(this));
    }

    @Override // com.bytedance.lark.view_flow_wrapper.m
    public final void dispose() {
        if (this.f254446b.a(false, true) == false) goto L13;
        M r100 = this.f254448d;
        if (r100 == null) goto L8;
        r100.close();
    L8:
        y r101 = ViewFlowPlugin.f254409a;
        if (r101 == null) goto L12;
        r101.a(new o((String) this.f254447c.getValue(), this.f254445a));
        return;
    L12:
        return;
    }
}
