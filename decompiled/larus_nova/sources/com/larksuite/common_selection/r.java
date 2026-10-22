package com.larksuite.common_selection;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f282919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f282920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f282921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f282922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f282923e;

    public r(SelectionContainer r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "proxyView");
        Intrinsics.checkNotNullParameter(r101, "invokeDismiss");
        this.f282919a = r100;
        this.f282920b = r101;
        this.f282921c = (ViewGroup) r100.getRootView().findViewById(R.id.content);
        this.f282922d = r100.getContext();
        this.f282923e = View.generateViewId();
    }
}
