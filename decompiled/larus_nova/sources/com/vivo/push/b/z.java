package com.vivo.push.b;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class z extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f462272a;

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "TagCommand";
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        super.c(r100);
        r100.a(PromotionProductPrivilegesStruct.TAGS, this.f462272a);
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        super.d(r100);
        this.f462272a = r100.c(PromotionProductPrivilegesStruct.TAGS);
    }

    public z(boolean r100, String r101, ArrayList<String> r102) {
        if (r100 == false) goto L4;
        int r103 = 2004;
    L5:
        super(r103, r101);
        this.f462272a = r102;
        return;
    L4:
        r103 = 2005;
        goto L5
    }
}
