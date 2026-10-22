package ev5;

import android.os.SystemClock;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ruler.base.models.ExprException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends v97.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<p, Boolean> f474261b;

    public abstract boolean b(String r100, String r101, boolean r102);

    public q(String r100) {
        super(r100);
        this.f474261b = new LruCache(100);
    }

    @Override // v97.b
    public final Object a(List<? extends Object> r100) {
        long r101 = SystemClock.elapsedRealtimeNanos();
        if (((ArrayList) r100).size() != 3) goto L46;
        if ((ListProtector.get(r100, 0) instanceof Collection) == false) goto L46;
        if ((ListProtector.get(r100, 1) instanceof Collection) == false) goto L46;
        if ((ListProtector.get(r100, 2) instanceof Boolean) == false) goto L46;
        Object r102 = ListProtector.get(r100, 0);
        if (r102 == null) goto L44;
        Collection r103 = (Collection) r102;
        Object r104 = ListProtector.get(r100, 1);
        if (r104 == null) goto L42;
        Collection r105 = (Collection) r104;
        if (r103.isEmpty() == true) goto L40;
        if (r105.isEmpty() == true) goto L40;
        Object r106 = ListProtector.get(r100, 2);
        if (r106 == null) goto L38;
        boolean r107 = ((Boolean) r106).booleanValue();
        p r108 = new p(r103, r105, r107);
        Boolean r109 = this.f474261b.get(r108);
        if (r109 == null) goto L25;
        boolean r110 = r109.booleanValue();
        c(r108, r101);
        return Boolean.valueOf(r110);
    L25:
        Iterator r111 = r103.iterator();
    L27:
        if (r111.hasNext() == false) goto L35;
        String r112 = (String) r111.next();
        Iterator r113 = r105.iterator();
    L30:
        if (r113.hasNext() == false) goto L27;
        if (b(r112, (String) r113.next(), r107) == false) goto L30;
        LruCache<p, Boolean> r114 = this.f474261b;
        Boolean r115 = Boolean.TRUE;
        r114.put(r108, r115);
        c(r108, r101);
        return r115;
    L35:
        LruCache<p, Boolean> r116 = this.f474261b;
        Boolean r117 = Boolean.FALSE;
        r116.put(r108, r117);
        c(r108, r101);
        return r117;
    L38:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    L40:
        return Boolean.FALSE;
    L42:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<kotlin.String>");
    L44:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<kotlin.String>");
    L46:
        throw new ExprException(105, "params error");
    }

    public final void c(p r100, long r101) {
        long r102 = (SystemClock.elapsedRealtimeNanos() - r101) / ((long) 1000);
        r100.f474258a.size();
        r100.f474259b.size();
        Objects.toString(this.f474261b);
        r100.hashCode();
    }
}
