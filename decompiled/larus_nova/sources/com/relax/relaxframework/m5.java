package com.relax.relaxframework;

import com.relax.runtime.gen.NativeLayoutProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class m5 extends RxAttributedElementImpl implements f2 {
    @Override // com.relax.relaxframework.RxElementImpl
    public boolean I() {
        return true;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public boolean U() {
        return true;
    }

    @Override // com.relax.relaxframework.RxElementImpl
    public void x(int r100) {
        NativeLayoutProxy r101 = this.f404932u.getLayoutProxy();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public m5(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "tagName");
        super(r100, r101);
    }
}
