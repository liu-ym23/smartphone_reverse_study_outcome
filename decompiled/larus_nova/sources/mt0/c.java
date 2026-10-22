package mt0;

import com.bytedance.android.live.profile.model.CompareOperation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f515594a = 0;

    static {
    }

    public static b a(List r100, Map r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "newData");
        Intrinsics.checkNotNullParameter(r101, "loadedItemInfo");
        Intrinsics.checkNotNullParameter(r102, "getType");
        LinkedHashMap r103 = new LinkedHashMap();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r100.iterator();
    L4:
        if (r106.hasNext() == false) goto L11;
        Object r107 = r106.next();
        Object r108 = r102.invoke(r107);
        r103.put(r108, r107);
        if (r101.containsKey(r108) == false) goto L7;
        if (r101.containsKey(r108) == false) goto L4;
        r105.add(r108);
        goto L4
    L7:
        r104.add(r108);
        goto L4
    L11:
        ArrayList r109 = new ArrayList(r103.size());
        Iterator r110 = r103.entrySet().iterator();
    L13:
        if (r110.hasNext() == false) goto L22;
        Map.Entry r111 = (Map.Entry) r110.next();
        Object r112 = r111.getKey();
        Object r113 = r111.getValue();
        Object r114 = r111.getKey();
        if (r104.contains(r114) == false) goto L18;
        CompareOperation r115 = CompareOperation.Create;
    L21:
        r109.add(new a(r112, r113, r115));
        goto L13
    L18:
        if (r105.contains(r114) == false) goto L20;
        r115 = CompareOperation.Update;
        goto L21
    L20:
        r115 = CompareOperation.Remove;
        goto L21
    L22:
        ArrayList r116 = new ArrayList(r101.size());
        Iterator r117 = ((LinkedHashMap) r101).entrySet().iterator();
    L24:
        if (r117.hasNext() == false) goto L27;
        r116.add(((Map.Entry) r117.next()).getKey());
        goto L24
    L27:
        return new b(r109, CollectionsKt.minus(r116, CollectionsKt.toSet(r105)));
    }
}
