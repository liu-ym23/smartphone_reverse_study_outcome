package com.larksuite.framework.utils;

import android.view.LayoutInflater;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o0 {
    public static final LayoutInflater a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return LayoutInflater.from(r100.getContext());
    }
}
