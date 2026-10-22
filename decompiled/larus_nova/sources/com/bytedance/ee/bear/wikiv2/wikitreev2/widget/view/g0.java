package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.view.View;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f242483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WikNodePerm f242484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j f242485c;

    public g0(c0 r100, WikNodePerm r101, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102) {
        this.f242483a = r100;
        this.f242484b = r101;
        this.f242485c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        c0 r101 = this.f242483a;
        WikNodePerm r102 = this.f242484b;
        Intrinsics.checkNotNull(r102);
        r101.k(r102, this.f242485c);
    }
}
