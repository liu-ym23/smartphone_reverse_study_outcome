package si3;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements bf.c {
    public c() {
    }

    public final void a() {
    }

    public final String b() {
        return "ec_shop/goods/list";
    }

    public final boolean c(Context r2, Uri r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uri");
        a.a(r2, r3, r4);
        return true;
    }
}
