package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends com.obric.miniapp.utils.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsDatePickerMethodIDL.b> f397324a;

    public a(f3.h<AbsDatePickerMethodIDL.b> r100) {
        this.f397324a = r100;
    }

    @Override // com.obric.miniapp.utils.g
    public final void a(Long r100) {
        if (r100 == null) goto L4;
        f3.h<AbsDatePickerMethodIDL.b> r101 = this.f397324a;
        Intrinsics.checkNotNullParameter(AbsDatePickerMethodIDL.b.class, "<this>");
        BaseModel r102 = k3.c.a(AbsDatePickerMethodIDL.b.class);
        ((AbsDatePickerMethodIDL.b) r102).setTime(r100.longValue());
        f3.h.a.b(r101, (ResultModel) r102);
        return;
    L4:
        f3.h.a.a(this.f397324a, "用户取消选择", null, null, 14);
    }
}
