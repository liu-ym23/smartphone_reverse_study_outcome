package o83;

import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f522361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f522362b;

    public final String toString() {
        List<b> r100 = this.f522361a;
        if (r100 == null) goto L9;
        List<b> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        b r104 = (b) r103.next();
        r102.add("addressType=" + r104.f522366c + " bizcode=" + r104.f522368e);
        goto L6
    L8:
        String r105 = CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null);
    L10:
        if (r105 != null) goto L14;
        return "";
    L14:
        return r105;
    L9:
        r105 = null;
        goto L10
    }

    public a(List r100, Integer r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f522361a = r100;
        this.f522362b = r101;
    }

    public final JSONObject a(boolean r110, Set<String> r111, Set<String> r112) {
        JSONObject r100 = new JSONObject();
        if (r112 != null) goto L5;
    L6:
        JSONArray r101 = new JSONArray();
        List<b> r102 = this.f522361a;
        if (r102 == null) goto L28;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L28;
        b r104 = (b) r103.next();
        if (r111 == null) goto L15;
        if (CollectionsKt.contains(r111, r104.f522368e) == false) goto L10;
    L15:
        r104.getClass();
        JSONObject r105 = new JSONObject();
        JSONObject r106 = r104.f522364a;
        int r107 = b.f522363f;
        if (r106 == null) goto L20;
        if (r110 == false) goto L19;
        r106 = b.a.a(r106, false);
    L19:
        r105.put("address", r106);
    L20:
        if (r110 == true) goto L27;
        JSONObject r108 = r104.f522365b;
        if (r108 == null) goto L26;
        if (r110 == false) goto L25;
        r108 = b.a.a(r108, false);
    L25:
        r105.put("latest_address", r108);
    L26:
        r105.put("address_type", r104.f522366c);
        r105.put("is_main_page", r104.f522367d);
    L27:
        r105.put(UniContext.KEY_OF_BIZ_CODE, r104.f522368e);
        r101.put(r105);
    L28:
        Unit r113 = Unit.INSTANCE;
        r100.put("address_list", r101);
    L29:
        Integer r114 = this.f522362b;
        if (r114 == null) goto L36;
        int r115 = r114.intValue();
        if (r112 != null) goto L34;
    L35:
        r100.put("error_code", r115);
        goto L36
    L34:
        if (r112.contains("error_code") == true) goto L35;
    L36:
        return r100;
    L5:
        if (r112.contains("address_list") == false) goto L29;
        goto L6
    }
}
