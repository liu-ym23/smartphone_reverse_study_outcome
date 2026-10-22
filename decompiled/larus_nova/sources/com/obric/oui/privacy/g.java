package com.obric.oui.privacy;

import android.content.res.Configuration;
import android.util.Size;
import android.view.View;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import com.obric.oui.sheet.v2.OSheet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements xla.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f402480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f402481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f402482c;

    @Override // xla.a
    public final void a(OSheet r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "configuration");
        c r102 = this.f402480a;
        int r103 = r101.screenHeightDp;
        View r104 = this.f402481b;
        Size r105 = zma.a.c(r104.getContext());
        int r106 = this.f402482c;
        r102.getClass();
        c.c(r103, r104, r105, r106);
        PrivacyTopDownAlphaMaskRecyclerView r107 = this.f402480a.f402472d;
        if (r107 != null) goto L6;
        return;
    L6:
        if (r101.screenHeightDp <= 650) goto L8;
        r107.setPadding(0, pla.d.n(r107, 16), 0, pla.d.n(r107, 16));
        return;
    L8:
        r107.setPadding(0, 0, 0, 0);
    }

    public g(c r100, View r101, int r102) {
        this.f402480a = r100;
        this.f402481b = r101;
        this.f402482c = r102;
    }
}
