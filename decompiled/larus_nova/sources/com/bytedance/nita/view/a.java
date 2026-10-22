package com.bytedance.nita.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f266016a = null;

    public a() {
    }

    static {
        f266016a = new a();
    }

    @Override // com.bytedance.nita.view.b
    public final View c(Context r100, ViewGroup r101, int r102) {
        return LayoutInflater.from(r100).inflate(r102, r101, false);
    }
}
