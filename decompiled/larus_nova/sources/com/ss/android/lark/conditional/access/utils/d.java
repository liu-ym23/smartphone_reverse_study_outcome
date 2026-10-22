package com.ss.android.lark.conditional.access.utils;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements u8b.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f418488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f418489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f418490c;

    @Override // u8b.c.a
    public final void Vg(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        View.OnClickListener r101 = this.f418488a;
        if (r101 == null) goto L5;
        r101.onClick(r100);
    L5:
        int r102 = g.f418493a;
        g.a(this.f418489b, this.f418490c);
    }

    public d(PrivacyPolicyUtils$mustache$provider$1.a r100, Context r101, String r102) {
        this.f418488a = r100;
        this.f418489b = r101;
        this.f418490c = r102;
    }
}
