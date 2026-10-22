package gv6;

import com.bytedance.locallife.live.goodsshelves.bean.LiveGoodsShelvesCard;
import com.bytedance.locallife.live.goodsshelves.bean.LiveLocalLifeCardData;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f482831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f482832b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f482833c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f482834d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f482835e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Set<String>> f482836f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f482837g;

    static {
        f482831a = new LinkedHashSet();
        f482832b = new LinkedHashSet();
        f482833c = new LinkedHashSet();
        f482834d = new LinkedHashSet();
        f482835e = new LinkedHashSet();
        f482836f = new LinkedHashMap();
        f482837g = "all";
    }

    public static void a(LiveGoodsShelvesCard r100) {
        if (r100 == null) goto L30;
        LiveLocalLifeCardData r101 = r100.getCard_data();
        if (r101 == null) goto L31;
        String r102 = r101.getGrouponId();
        if (r102 == null) goto L32;
        f482832b.add(r102);
        if (r100.getLive_card_type() != 20) goto L10;
        f482833c.add(r102);
    L10:
        LiveLocalLifeCardData r103 = r100.getCard_data();
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == false) goto L18;
        f482834d.add(r102);
    L18:
        LiveLocalLifeCardData r105 = r100.getCard_data();
        if (r105 == null) goto L21;
        Integer r106 = Integer.valueOf(r105.getProductType());
    L23:
        if (LiveLocalLifeUtil.j(r106) == false) goto L25;
        f482835e.add(r102);
    L25:
        Map<String, Set<String>> r107 = f482836f;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        Set<String> r109 = (Set) r108.get(f482837g);
        if (r109 != null) goto L28;
        r109 = new LinkedHashSet();
        r107.put(f482837g, r109);
    L28:
        r109.add(r102);
        return;
    L21:
        r106 = null;
        goto L23
    L13:
        if (r103.getProductType() != 14) goto L15;
        r104 = true;
        goto L16
    L32:
        return;
    L31:
        return;
    }
}
