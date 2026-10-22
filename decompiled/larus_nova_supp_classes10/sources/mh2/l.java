package mh2;

import android.graphics.Bitmap;
import android.widget.TextView;
import io.reactivex.functions.Function;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l<T, R> implements Function {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;
    public final /* synthetic */ float c;
    public final /* synthetic */ float d;
    public final /* synthetic */ TextView e;
    public final /* synthetic */ boolean f;

    public l(List r1, String r2, float r3, float r4, TextView r5, boolean r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final Object apply(Object r7) {
        Object[] r8 = (Object[]) r7;
        Intrinsics.checkNotNullParameter(r8, "rets");
        Iterator<T> r9 = CollectionsKt.sortedWith(ArraysKt.filterIsInstance(r8, r.b.class), new k()).iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r.b r0 = (r.b) r9.next();
        this.a.add(r0.b);
        goto L4
    L6:
        HashMap<String, WeakReference<Bitmap>> r10 = q.a;
        return q.c(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
