package vy4;

import android.content.Context;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f557615a;

    public b(Context r100) {
        this.f557615a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        a.c(this.f557615a, "docs_lynx_channel");
        tt5.a.h("ResCleanUtils", "cleanResource, clean lynx gecko dir success");
    }
}
