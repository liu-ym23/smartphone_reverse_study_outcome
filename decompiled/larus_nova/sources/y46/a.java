package y46;

import android.graphics.Rect;
import com.bytedance.ies.ugc.aweme.fmp.core.diff.DiffType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Pair<Rect, e>> f566040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f566041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f566042c;

    public a() {
        this.f566040a = new LinkedHashMap();
        this.f566041b = -1;
    }

    public final b a(a r110, int r111, int r112, long r113) {
        a r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "another");
        Set r101 = null;
        if ((r100 instanceof a) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L10;
        return new b(r111, r112, CollectionsKt.emptyList(), r113, null);
    L10:
        if (r100.f566041b <= this.f566041b) goto L12;
        Map r102 = MapsKt.toMutableMap(this.f566040a);
    L14:
        if (r100.f566041b <= this.f566041b) goto L16;
        Map r103 = MapsKt.toMutableMap(r100.f566040a);
    L17:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.entrySet().iterator();
    L19:
        if (r105.hasNext() == false) goto L50;
        Map.Entry r106 = (Map.Entry) r105.next();
        String r114 = (String) r106.getKey();
        Pair r107 = (Pair) r106.getValue();
        Pair r108 = (Pair) r102.remove(r114);
        if (r108 == null) goto L22;
        Rect r109 = (Rect) r108.getFirst();
        Rect r115 = (Rect) r107.getFirst();
        boolean r116 = false;
        if (r109.left == r115.left) goto L26;
    L32:
        boolean r117 = false;
    L33:
        if (r117 == true) goto L19;
        Rect r118 = (Rect) r108.getFirst();
        Rect r119 = (Rect) r107.getFirst();
        if (r118.width() == r119.width()) goto L37;
    L39:
        boolean r120 = false;
    L40:
        if (r120 == true) goto L41;
        Rect r121 = (Rect) r108.getFirst();
        Rect r122 = (Rect) r107.getFirst();
        if (r121.left == r122.left) goto L45;
    L47:
        if (r116 == true) goto L48;
        r104.add(new c(r114, DiffType.LOCATION_SIZE_CHANGE, (Rect) r108.getFirst(), (Rect) r107.getFirst(), (e) r107.getSecond()));
        goto L19
    L48:
        r104.add(new c(r114, DiffType.SIZE_CHANGE, (Rect) r108.getFirst(), (Rect) r107.getFirst(), (e) r107.getSecond()));
        goto L19
    L45:
        if (r121.top != r122.top) goto L47;
        r116 = true;
        goto L47
    L41:
        r104.add(new c(r114, DiffType.LOCATION_CHANGE, (Rect) r108.getFirst(), (Rect) r107.getFirst(), (e) r107.getSecond()));
        goto L19
    L37:
        if (r118.height() != r119.height()) goto L39;
        r120 = true;
        goto L40
    L26:
        if (r109.right != r115.right) goto L32;
        if (r109.bottom != r115.bottom) goto L32;
        if (r109.top != r115.top) goto L32;
        r117 = true;
        goto L33
    L22:
        r104.add(new c(r114, DiffType.ADD, null, (Rect) r107.getFirst(), (e) r107.getSecond()));
        goto L19
    L50:
        Iterator r123 = r102.entrySet().iterator();
    L52:
        if (r123.hasNext() == false) goto L55;
        Map.Entry r124 = (Map.Entry) r123.next();
        r104.add(new c((String) r124.getKey(), DiffType.REMOVE, (Rect) ((Pair) r124.getValue()).getFirst(), null, (e) ((Pair) r124.getValue()).getSecond()));
        goto L52
    L55:
        if (r100.f566041b <= this.f566041b) goto L57;
        Set<String> r125 = r100.f566042c;
    L58:
        if (r125 == null) goto L61;
        r101 = CollectionsKt.toMutableSet(r125);
    L61:
        return new b(r111, r112, r104, r113, r101);
    L57:
        r125 = this.f566042c;
        goto L58
    L16:
        r103 = MapsKt.toMutableMap(this.f566040a);
        goto L17
    L12:
        r102 = MapsKt.toMutableMap(r100.f566040a);
        goto L14
    }
}
