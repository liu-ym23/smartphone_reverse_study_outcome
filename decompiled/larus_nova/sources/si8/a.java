package si8;

import com.larus.im.bean.message.ImageDisplaySize;
import com.larus.im.bean.message.ItemData;
import com.larus.im.bean.message.SearchImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oi8.k;
import pi8.o;
import yc9.s;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements pi8.a {
    public a() {
    }

    @Override // pi8.a
    public final o a(k r310, oi8.c r311) {
        Intrinsics.checkNotNullParameter(r310, "originData");
        ArrayList r100 = new ArrayList();
        com.larus.bmhome.chat.search.b r101 = r310.e();
        if (r101 == null) goto L7;
        com.larus.bmhome.chat.search.b.a r102 = r101.c();
        if (r102 == null) goto L7;
        List<SearchImageInfo> r103 = r102.a();
    L8:
        List<SearchImageInfo> r104 = r103;
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L19;
        return new o(r100, true);
    L19:
        if (r103.size() != 1) goto L22;
        SearchImageInfo r106 = (SearchImageInfo) CollectionsKt.first(r103);
        r106.setDisplaySetting(new s(ImageDisplaySize.medium, true, true, true, true));
        r106.setFoldImageInfoList(null);
        r100.add(r106);
        return new o(r100, true);
    L22:
        Iterator r107 = CollectionsKt.take(r103, 4).iterator();
        int r108 = 0;
    L24:
        if (r107.hasNext() == false) goto L37;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        SearchImageInfo r111 = (SearchImageInfo) r109;
        if (r110 == 4) goto L31;
        r111.setFoldImageInfoList(null);
    L35:
        r100.add(r111);
        r108 = r110;
        goto L24
    L31:
        if (Math.max(0, r103.size() - 4) <= 0) goto L33;
        r111.setFoldImageInfoList(r103.subList(4, r103.size()));
        goto L35
    L33:
        r111.setFoldImageInfoList(null);
        goto L35
    L37:
        if (r100.size() != 3) goto L39;
        SearchImageInfo r112 = new SearchImageInfo(-1L, "search_image_placeholder", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048572, null);
        r112.setPlaceHolder(true);
        r100.add(r112);
    L39:
        Iterator r113 = r100.iterator();
        int r114 = 0;
    L41:
        if (r113.hasNext() == false) goto L71;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L45;
        CollectionsKt.throwIndexOverflow();
    L45:
        ItemData r117 = (ItemData) r115;
        if ((r117 instanceof SearchImageInfo) == false) goto L69;
        if (r114 != 0) goto L49;
        boolean r118 = true;
    L51:
        if (r116 < 2) goto L53;
    L54:
        if (r116 != 2) goto L56;
    L55:
        boolean r119 = true;
    L58:
        if ((((((r100.size() + 2) - 1) / 2) - 1) * 2) != r114) goto L60;
        boolean r120 = true;
    L62:
        if (r116 != r100.size()) goto L67;
        if (r116 >= 2) goto L65;
    L66:
        boolean r121 = true;
    L68:
        ((SearchImageInfo) r117).setDisplaySetting(new s(ImageDisplaySize.small, r118, r119, r120, r121));
        goto L69
    L65:
        if ((r116 % 2) == 0) goto L66;
    L67:
        r121 = false;
        goto L68
    L60:
        r120 = false;
        goto L62
    L56:
        r119 = false;
        goto L58
    L53:
        if (r116 == r100.size()) goto L55;
    L49:
        r118 = false;
    L69:
        r114 = r116;
        goto L41
    L71:
        return new o(r100, true);
    L11:
        if (r104.isEmpty() == true) goto L14;
        r105 = false;
    L7:
        r103 = null;
        goto L8
    }
}
