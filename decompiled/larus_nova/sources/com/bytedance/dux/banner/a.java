package com.bytedance.dux.banner;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerAdapter f204879a;

    public a(BannerAdapter r100) {
        this.f204879a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Object r101 = r100.getTag(R.id.banner_pos_key);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue();
        BannerAdapter r103 = this.f204879a;
        ol4.b r104 = r103.f204846d;
        if (r104 == null) goto L6;
        r104.a((b) ListProtector.get(r103.f204848f, r102), r102);
        return;
    }
}
