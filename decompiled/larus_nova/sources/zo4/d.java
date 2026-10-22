package zo4;

import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f573116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Calendar f573117b;

    public d(b r100, Calendar r101) {
        this.f573116a = r100;
        this.f573117b = r101;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        List r101 = (List) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        b r102 = this.f573116a;
        Calendar r103 = this.f573117b;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        T r106 = r105.next();
        long r107 = ((Number) r106).longValue();
        r102.f573110d.setTimeInMillis(r107);
        if (r102.f573110d.after(r103) == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        return r104;
    }
}
