package u5;

import com.bytedance.ai.uiu.objects.UIOperationDef;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Character, UIOperationDef> f548757a = null;

    static {
        Iterable r100 = StringsKt.withIndex("cligbnpt");
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        IndexedValue r103 = (IndexedValue) r102.next();
        int r104 = r103.component1();
        Character r105 = Character.valueOf(((Character) r103.component2()).charValue());
        switch(r104) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        UIOperationDef r106 = UIOperationDef.SCROLL_TOP;
    L17:
        Pair r107 = TuplesKt.to(r105, r106);
        r101.put(r107.getFirst(), r107.getSecond());
        goto L4
    L10:
        r106 = UIOperationDef.SCROLL_PREVIOUS;
        goto L17
    L11:
        r106 = UIOperationDef.SCROLL_NEXT;
        goto L17
    L12:
        r106 = UIOperationDef.SCROLL_BOTTOM;
        goto L17
    L13:
        r106 = UIOperationDef.INPUT_GO;
        goto L17
    L14:
        r106 = UIOperationDef.INPUT;
        goto L17
    L15:
        r106 = UIOperationDef.LONG_CLICK;
        goto L17
    L16:
        r106 = UIOperationDef.CLICK;
        goto L17
    L8:
        throw new IllegalArgumentException("Invalid operation index: " + r104);
    L18:
        f548757a = r101;
    }
}
