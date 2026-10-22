package ne7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    static {
    }

    public static Object a(Object r100) {
        boolean r101 = true;
        if ((r100 instanceof Number) == false) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = r100 instanceof Boolean;
    L9:
        if (r101 == false) goto L12;
        return r100;
    L12:
        if ((r100 instanceof List) == false) goto L15;
        return b((List) r100);
    L15:
        if ((r100 instanceof Map) == false) goto L18;
        return c((Map) r100);
    L18:
        if ((r100 instanceof XBaseModel) == true) goto L24;
        return null;
    L24:
        return ((XBaseModel) r100).toJSON();
    L5:
        r102 = r100 instanceof String;
        goto L6
    }

    @JvmStatic
    public static final JSONArray b(List<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JSONArray r101 = new JSONArray();
        List r102 = CollectionsKt.filterNotNull(r100);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(a(r104.next()));
        goto L4
    L6:
        Iterator r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        Object r106 = r105.next();
        if (r106 == null) goto L8;
        r101.put(r106);
        goto L8
    L12:
        return r101;
    }

    @JvmStatic
    public static final JSONObject c(Map<?, ?> r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        JSONObject r101 = new JSONObject();
        ArrayList r102 = new ArrayList(r100.size());
        Iterator<Map.Entry<?, ?>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<?, ?> r104 = r103.next();
        Object r105 = r104.getValue();
        r102.add(TuplesKt.to(r104.getKey(), a(r105)));
        goto L4
    L6:
        Iterator r106 = r102.iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        Pair r107 = (Pair) r106.next();
        Object r108 = r107.getFirst();
        if (r108 == null) goto L8;
        if ((r108 instanceof String) == false) goto L8;
        r101.put((String) r108, r107.getSecond());
        goto L8
    L14:
        return r101;
    }
}
