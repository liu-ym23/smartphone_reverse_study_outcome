package py;

import com.bytedance.android.live.base.model.user.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class v {
    public static final boolean a(String r100) {
        o0.f58946a.getClass();
        return o0.a.b(r100);
    }

    public static final List<String> b(List<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$transformToString");
        List<Long> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(String.valueOf(((Number) r103.next()).longValue()));
        goto L4
    L6:
        return r102;
    }
}
