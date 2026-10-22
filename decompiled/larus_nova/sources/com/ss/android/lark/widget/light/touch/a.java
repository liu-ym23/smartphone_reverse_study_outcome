package com.ss.android.lark.widget.light.touch;

import android.text.Spanned;
import android.text.style.ClickableSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements TouchConsumeView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickableSpan[] f446300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TouchConsumeView f446301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ClickableSpan f446302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Spanned f446303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f446304e;

    @Override // com.ss.android.lark.widget.light.touch.TouchConsumeView.b
    public final void a(TouchConsumeView r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
    }

    public a(ClickableSpan[] r100, TouchConsumeView r101, ClickableSpan r102, Spanned r103, int r104) {
        this.f446300a = r100;
        this.f446301b = r101;
        this.f446302c = r102;
        this.f446303d = r103;
        this.f446304e = r104;
    }
}
