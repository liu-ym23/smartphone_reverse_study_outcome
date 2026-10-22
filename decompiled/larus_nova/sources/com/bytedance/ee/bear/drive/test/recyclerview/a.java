package com.bytedance.ee.bear.drive.test.recyclerview;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f224701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DriveBusinessTestButtonAdapter f224702b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((z85.a) ListProtector.get(this.f224702b.f224698b, this.f224701a)).a().onClick(r100);
    }

    public a(DriveBusinessTestButtonAdapter r100, int r101) {
        this.f224702b = r100;
        this.f224701a = r101;
    }
}
