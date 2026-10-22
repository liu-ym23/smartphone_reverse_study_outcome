package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.obric.capabilitykit.entity.ResultCallback;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class h implements ResultCallback<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsIndexIcsDataMethodIDL.b> f397335a;

    public h(f3.h<AbsIndexIcsDataMethodIDL.b> r100) {
        this.f397335a = r100;
    }

    @Override // com.obric.capabilitykit.entity.ResultCallback
    public final void onResult(int r100, String r101, Unit r102) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        if (r100 != 0) goto L5;
    L7:
        f3.h<AbsIndexIcsDataMethodIDL.b> r103 = this.f397335a;
        Intrinsics.checkNotNullParameter(AbsIndexIcsDataMethodIDL.b.class, "<this>");
        f3.h.a.b(r103, (ResultModel) k3.c.a(AbsIndexIcsDataMethodIDL.b.class));
        return;
    L5:
        if (r100 == 301) goto L7;
        f3.h.a.a(this.f397335a, r100 + ": " + r101, null, null, 14);
    }
}
