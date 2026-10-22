package gda;

import android.os.Bundle;
import com.larus.platform.service.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f480986a = null;

    static {
        f480986a = new a();
    }

    public a() {
    }

    public final void a(Bundle r100, Function1<? super Bundle, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "traceInfo");
        if (r101 == null) goto L5;
        r101.invoke(r100);
    L5:
        o.f365780a.b("obric_card_item_click", r100);
    }
}
