package com.larksuite.component.universe_design.icon.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Composer, Integer, Painter> f285044a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, UDIconStyle r101, String r102, Function2<? super Composer, ? super Integer, ? extends Painter> r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "style");
        Intrinsics.checkNotNullParameter(r102, "resourceName");
        Intrinsics.checkNotNullParameter(r103, "painterProvider");
        this.f285044a = r103;
    }
}
