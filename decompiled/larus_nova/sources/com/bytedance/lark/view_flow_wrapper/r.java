package com.bytedance.lark.view_flow_wrapper;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.lang.AutoCloseable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public abstract class r<VF extends AutoCloseable> extends MoltenFlowBase<VF> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<AutoCloseable> f254455h;

    @Override // com.bytedance.lark.view_flow_wrapper.MoltenFlowBase
    public final void c() {
        Iterator<T> r100 = this.f254455h.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((AutoCloseable) r100.next()).close();
        goto L4
    L6:
        super.c();
    }

    public r(v r100) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        super(r100);
        this.f254455h = new ArrayList();
    }
}
