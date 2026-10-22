package com.bytedance.jedi.ext.adapter.decorator.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static View a(ViewGroup r100, int r101) {
        return LayoutInflater.from(r100.getContext()).inflate(r101, r100, false);
    }
}
