package n35;

import android.text.TextUtils;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ m a;
    public final /* synthetic */ m0 b;

    public n(m r1, m0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r7) {
        Boolean r8 = (Boolean) r7;
        tt5.a.h(this.a.b, "docResourceDataSaveSuccess");
        m0 r9 = this.b;
        String r0 = r9.k;
        this.a.getClass();
        String r1 = r9.b;
        boolean r3 = false;
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        if (r3 == false) goto L16;
        tt5.a.h(this.a.b, du5.b.g(r0) + " setDocDataCached");
        List<r> r10 = l.a;
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNullParameter(r0, "objToken");
        Iterator r11 = ((ArrayList) l.a).iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        ((r) r11.next()).j(r0);
        goto L12
    L14:
        a05.d.a(r0, "client_vars_size", String.valueOf(this.b.c.length()));
    L16:
        if (lbb.a.a(r0) == false) goto L20;
        tt5.a.h(this.a.b, du5.b.g(r0) + "--" + this.b.b);
        return;
    L20:
        return;
    L5:
        if (StringsKt.contains$default(r1, "CLIENT_VARS", false, 2, null) == false) goto L9;
        if (TextUtils.isEmpty(r9.c) == true) goto L9;
        r3 = true;
        goto L9
    }
}
