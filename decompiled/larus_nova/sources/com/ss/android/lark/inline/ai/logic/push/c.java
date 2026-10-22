package com.ss.android.lark.inline.ai.logic.push;

import androidx.collection.LruCache;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.C5058b f427341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f427342b;

    public c(b.C5058b r100, String r101) {
        this.f427341a = r100;
        this.f427342b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        obb.b r101 = (obb.b) r100;
        LruCache<String, obb.b> r102 = this.f427341a.f427340b;
        String r103 = this.f427342b;
        Intrinsics.checkNotNull(r101);
        r102.put(r103, r101);
        this.f427341a.a(this.f427342b, r101);
    }
}
