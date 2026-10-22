package vy4;

import android.content.Context;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ Context a;

    public b(Context r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Boolean r3 = (Boolean) r2;
        a.c(this.a, "docs_lynx_channel");
        tt5.a.h("ResCleanUtils", "cleanResource, clean lynx gecko dir success");
    }
}
