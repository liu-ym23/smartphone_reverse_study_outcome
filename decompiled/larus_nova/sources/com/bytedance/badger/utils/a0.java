package com.bytedance.badger.utils;

import android.content.Context;
import com.bytedance.bd_sec_tee.core.TeeProvider;

/* JADX INFO: loaded from: classes47.dex */
public final class a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a0 f199214b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TeeProvider f199215a;

    public a0(Context r100) {
        h74.a.C6109a r101 = new h74.a.C6109a(r100);
        r101.f483986b = new z();
        this.f199215a = new TeeProvider(new h74.a(r101));
    }
}
