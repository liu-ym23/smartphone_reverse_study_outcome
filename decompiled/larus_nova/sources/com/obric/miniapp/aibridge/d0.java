package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d0 extends com.obric.miniapp.utils.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f3.h<AbsTimePickerMethodIDL.b> f397331a;

    public d0(f3.h<AbsTimePickerMethodIDL.b> r100) {
        this.f397331a = r100;
    }

    @Override // com.obric.miniapp.utils.f
    public final void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "pickerUnit");
        f3.h<AbsTimePickerMethodIDL.b> r102 = this.f397331a;
        Intrinsics.checkNotNullParameter(AbsTimePickerMethodIDL.b.class, "<this>");
        BaseModel r103 = k3.c.a(AbsTimePickerMethodIDL.b.class);
        AbsTimePickerMethodIDL.b r104 = (AbsTimePickerMethodIDL.b) r103;
        r104.setValue(r100);
        r104.setUnit(r101);
        f3.h.a.b(r102, (ResultModel) r103);
    }
}
