package mp9;

import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.model.MediaTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {
    public static final Map<MediaTab, Integer> b(List<c> r100, List<? extends MediaTab> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "allTabs");
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        MediaTab r104 = (MediaTab) r103.next();
        if (r104 == MediaTab.ALL) goto L7;
        MediaType r105 = r104.toMediaType();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r100.iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (((c) r108).getType() != r105) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L10;
        r106.add(r108);
        goto L10
    L14:
        r109 = false;
        goto L15
    L17:
        r102.put(r104, Integer.valueOf(r106.size()));
        goto L4
    L7:
        r102.put(r104, Integer.valueOf(r100.size()));
        goto L4
    L18:
        return r102;
    }

    public static final Map<MediaTab, List<c>> a(List<c> r100, List<? extends MediaTab> r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "allTabs");
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L18;
        MediaTab r104 = (MediaTab) r103.next();
        if (r104 == MediaTab.ALL) goto L7;
        MediaType r105 = r104.toMediaType();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r100.iterator();
    L10:
        if (r107.hasNext() == false) goto L17;
        Object r108 = r107.next();
        if (((c) r108).getType() != r105) goto L14;
        boolean r109 = true;
    L15:
        if (r109 == false) goto L10;
        r106.add(r108);
        goto L10
    L14:
        r109 = false;
        goto L15
    L17:
        r102.put(r104, r106.subList(0, Math.min(r106.size(), r110)));
        goto L4
    L7:
        r102.put(r104, r100.subList(0, Math.min(r100.size(), r110)));
        goto L4
    L18:
        return r102;
    }
}
