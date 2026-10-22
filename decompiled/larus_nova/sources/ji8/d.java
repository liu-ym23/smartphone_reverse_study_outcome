package ji8;

import com.larus.bmhome.chat.api.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f499226a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, Set<c>> f499227b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<b> f499228c = null;

    public d() {
    }

    static {
        f499226a = new d();
        f499227b = new HashMap();
        f499228c = new LinkedHashSet();
    }

    @Override // com.larus.bmhome.chat.api.y
    public final void d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f499228c.add(r100);
    }

    @Override // com.larus.bmhome.chat.api.y
    public final void e(b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        f499228c.remove(r100);
    }

    @Override // com.larus.bmhome.chat.api.y
    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Set<c> r102 = f499227b.get(r100);
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        ((c) r103.next()).a();
        goto L6
    L10:
        return;
    }
}
