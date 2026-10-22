package com.bytedance.ee.bear.bitable.filter.view.ddui;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.panel.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableFilterConjunctionFragment f212093a;

    @Override // com.bytedance.ee.bear.bitable.panel.m
    public final void b(String r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "s");
    }

    @Override // com.bytedance.ee.bear.bitable.panel.m
    public final void onClick(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
    }

    public a(BitableFilterConjunctionFragment r100) {
        this.f212093a = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.panel.m
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (TextUtils.equals(r100, "exit") == false) goto L7;
        BitableFilterConjunctionFragment r101 = this.f212093a;
        bs4.a r102 = r101.V;
        if (r102 == null) goto L11;
        r102.b(r101.getComponentType());
        return;
    L11:
        return;
    L7:
        BitableFilterConjunctionFragment r103 = this.f212093a;
        bs4.b r104 = r103.W;
        if (r104 == null) goto L13;
        r104.q(r103.getComponentType(), r100, null);
        return;
    }
}
