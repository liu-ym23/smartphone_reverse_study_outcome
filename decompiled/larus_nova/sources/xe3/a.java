package xe3;

import b93.b;
import b93.d;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<d> f563364a;

    /* JADX INFO: renamed from: xe3.a$a, reason: collision with other inner class name */
    public static final class C8221a {
    }

    static {
    }

    public a() {
        this.f563364a = new CopyOnWriteArrayList();
    }

    @Override // b93.b
    public final void sendEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Iterator r102 = CollectionsKt.toMutableList(this.f563364a).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((d) r102.next()).getClass();
        goto L4
    }
}
