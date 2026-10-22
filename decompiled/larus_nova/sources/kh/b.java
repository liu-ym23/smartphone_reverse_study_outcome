package kh;

import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.data.model.CheckPointType;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements com.bytedance.android.ec.core.monitor.param.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503410a;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        this.f503410a = r100;
    }

    @Override // com.bytedance.android.ec.core.monitor.param.b
    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "curKey");
        String r101 = this.f503410a;
        int r102 = r101.hashCode();
        if (r102 == 83197) goto L11;
        if (r102 == 2043610225) goto L8;
    L13:
        return false;
    L8:
        if (r101.equals("Detail") == false) goto L13;
        return CollectionsKt.listOf(new String[]{"outer_buyNow", "outer_ultimateBuy"}).contains(r100);
    L11:
        if (r101.equals("Sku") == false) goto L13;
        return CollectionsKt.listOf("outer_buyNow").contains(r100);
    }

    @Override // com.bytedance.android.ec.core.monitor.param.b
    public final void b(String r100, JSONObject r101, Map<String, ? extends JSONObject> r102) {
        Intrinsics.checkNotNullParameter(r100, "curKey");
        Intrinsics.checkNotNullParameter(r102, "pageParams");
        String r103 = this.f503410a;
        int r104 = r103.hashCode();
        if (r104 == 83197) goto L11;
        if (r104 == 2043610225) goto L8;
    L13:
        String r105 = null;
    L15:
        switch(r100.hashCode()) {
            case 169829394: goto L27;
            case 243376817: goto L24;
            case 611142324: goto L21;
            case 1142016945: goto L18;
            default: goto L39;
        };
    L39:
        String r106 = null;
    L30:
        if (r105 == null) goto L40;
        if (r106 == null) goto L41;
        int r107 = ECSdk.f48106a;
        pi.b r108 = (pi.b) ECSdk.a(pi.b.class);
        if (r108 == null) goto L42;
        r108.monitorEvent("schema_report", k.b(MapsKt.mapOf(new Pair[]{TuplesKt.to("in_schema", ((ConcurrentHashMap) r102).get(CheckPointType.ENTER_PAGE)), TuplesKt.to("out_schema", r101), TuplesKt.to("location", r106), TuplesKt.to("business", r105)})), null, null);
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L18:
        if (r100.equals("request_cartAdd") == true) goto L28;
        r106 = null;
    L28:
        r106 = "addCart";
        goto L30
    L21:
        if (r100.equals("outer_buyNow") == false) goto L36;
        r106 = PageType.BUYNOW;
        goto L30
    L36:
        r106 = null;
        goto L30
    L24:
        if (r100.equals("outer_ultimateBuy") == false) goto L37;
        r106 = "ultimateBuy";
        goto L30
    L37:
        r106 = null;
        goto L30
    L27:
        if (r100.equals("request_cartAdd_new") == true) goto L28;
        r106 = null;
        goto L30
    L8:
        if (r103.equals("Detail") == false) goto L13;
        r105 = "productDetail";
        goto L15
    L11:
        if (r103.equals("Sku") == false) goto L13;
        r105 = "commonSKU";
        goto L15
    }
}
