package lx9;

import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.policy.k;
import com.larus.suggest.impl.wcb.policy.q;
import com.larus.suggest.impl.wcb.policy.z;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<d, z> f511238a = null;

    static {
        WcbSurface r100 = WcbSurface.MAIN_CONVERSATION;
        WcbMode r101 = WcbMode.QUICK_EXPERT;
        WcbMode r102 = WcbMode.OFFICE_TASK;
        WcbSurface r103 = WcbSurface.NEW_CONVERSATION;
        List r104 = CollectionsKt.listOf(new z[]{new k(new d(r100, r101), 1), new k(new d(r100, r102), 10), new q(new d(r103, r101), 12), new q(new d(r103, r102), 11)});
        LinkedHashMap r105 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r104, 10)), 16));
        Iterator r106 = r104.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Object r107 = r106.next();
        r105.put(((z) r107).getKey(), r107);
        goto L4
    L6:
        f511238a = r105;
    }
}
