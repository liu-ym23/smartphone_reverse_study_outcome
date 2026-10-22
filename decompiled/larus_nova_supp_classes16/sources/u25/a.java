package u25;

import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements c {
    public final String a;
    public final String b;
    public final int c;
    public final List<SubBlockModel> d;
    public final Set<String> e;
    public final Set<String> f;
    public final Function1<a, Unit> g;

    @Override // u25.c
    public final int a() {
        return 0;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a, this.b});
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (a.class != r5.getClass()) goto L17;
        a r6 = (a) r5;
        if (this.a.equals(r6.a) == true) goto L13;
    L15:
        return false;
    L13:
        if (this.b.equals(r6.b) == false) goto L15;
        return true;
    }

    public a(String r1, String r2, List<SubBlockModel> r3, int r4, Function1<a, Unit> r5) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
        this.c = r4;
        this.e = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f = Collections.newSetFromMap(new ConcurrentHashMap());
        this.g = r5;
    }
}
