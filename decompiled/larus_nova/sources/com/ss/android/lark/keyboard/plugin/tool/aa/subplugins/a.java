package com.ss.android.lark.keyboard.plugin.tool.aa.subplugins;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a implements TextStyleApplier.c, TextStyleApplier.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f429590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextStyleApplier f429591b;

    @Override // com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.TextStyleApplier.c
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
    }

    public a(TextStyleApplier.d<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "spanFactory");
        this.f429590a = true;
        TextStyleApplier r101 = new TextStyleApplier(r100);
        Intrinsics.checkNotNullParameter(this, "listener");
        r101.f429588k = this;
        Intrinsics.checkNotNullParameter(this, "listener");
        r101.f429589l = this;
        this.f429591b = r101;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.aa.subplugins.TextStyleApplier.b
    public final void a(boolean r100) {
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
        throw null;
    }
}
