package com.larus.bmhome.chat.layout.holder.image;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class r implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseImageBox f303885a;

    public /* synthetic */ r(BaseImageBox r100) {
        this.f303885a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        BaseImageBox r101 = this.f303885a;
        int r102 = ((Integer) r100).intValue();
        List<TemplateInfo$TemplateInfo> r103 = r101.f303709v;
        if (r103 != null) goto L5;
        return null;
    L5:
        if (r103.size() <= r102) goto L7;
        TemplateInfo$TemplateInfo r104 = (TemplateInfo$TemplateInfo) ListProtector.get(r103, r102);
    L8:
        if (r104 != null) goto L11;
        return null;
    L11:
        return r104;
    L7:
        r104 = null;
        goto L8
    }
}
