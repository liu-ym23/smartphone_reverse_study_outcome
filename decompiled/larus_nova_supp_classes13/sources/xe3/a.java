package xe3;

import b93.b;
import b93.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements b {
    public final CopyOnWriteArrayList<d> a;

    /* JADX INFO: renamed from: xe3.a$a, reason: collision with other inner class name */
    public static final class C0241a {
    }

    static {
    }

    public a() {
        this.a = new CopyOnWriteArrayList();
    }

    @Override // b93.b
    public final void sendEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        Intrinsics.checkNotNullParameter(r3, "params");
        Iterator r4 = CollectionsKt.toMutableList(this.a).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((d) r4.next()).getClass();
        goto L4
    }
}
