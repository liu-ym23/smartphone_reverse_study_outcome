package com.ss.android.lark.widget.light.layout;

import android.text.Layout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextLayoutBuilder.a f446154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<Layout, Unit>> f446155b;

    public d(TextLayoutBuilder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "textLayoutPrams");
        this.f446154a = r100;
        this.f446155b = new ArrayList();
    }
}
