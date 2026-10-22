package f63;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {
    public static final List<ECUrlModel> a(List<a> r100) {
        Intrinsics.checkNotNullParameter(r100, "groupImages");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.addAll(((a) r102.next()).f475691c);
        goto L4
    L6:
        return r101;
    }
}
