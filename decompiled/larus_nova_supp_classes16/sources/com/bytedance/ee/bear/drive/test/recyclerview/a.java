package com.bytedance.ee.bear.drive.test.recyclerview;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ DriveBusinessTestButtonAdapter b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ((z85.a) ListProtector.get(this.b.b, this.a)).a().onClick(r3);
    }

    public a(DriveBusinessTestButtonAdapter r1, int r2) {
        this.b = r1;
        this.a = r2;
    }
}
