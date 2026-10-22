package lc2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.o;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<d> f508405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f508406b = null;

    public c() {
    }

    static {
        f508406b = new c();
        f508405a = CollectionsKt.listOf(d.f508407a);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.o
    public final void a(f<?> r100, e52.a r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "config");
        Iterator<T> r102 = f508405a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((d) r102.next()).a(r100, r101);
        goto L4
    }
}
