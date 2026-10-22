package l63;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import j63.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<String> f507664a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashSet<LifecycleOwner> f507665b = null;

    static {
        f507664a = new ArrayList();
        f507665b = new LinkedHashSet();
    }

    public static void a(List r100) {
        Intrinsics.checkNotNullParameter(r100, "productList");
        ArrayList<String> r101 = f507664a;
        int r102 = r101.size();
        if ((r100.size() + r102) <= 100) goto L5;
        r101.removeAll(r101.subList(0, r102 - r100.size()));
    L5:
        Iterator r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L25;
        c r104 = (c) r103.next();
        Integer r105 = r104.getType();
        String r106 = null;
        if (r105 == null) goto L17;
        if (r105.intValue() != 1) goto L17;
        StringBuilder r107 = new StringBuilder("1_");
        ItemCardLiveStruct r108 = r104.b();
        if (r108 == null) goto L16;
        r106 = r108.getRoomId();
    L16:
        r107.append(r106);
        f507664a.add(r107.toString());
    L17:
        if (r105 == null) goto L7;
        if (r105.intValue() != 2) goto L7;
        ItemCardProductStruct r109 = r104.d();
        if (r109 == null) goto L24;
        r106 = r109.getProductId();
    L24:
        f507664a.add("2_" + r106);
        goto L7
    }
}
