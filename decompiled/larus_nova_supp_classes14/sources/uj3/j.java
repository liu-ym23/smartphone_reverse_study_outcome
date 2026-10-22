package uj3;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.n;
import com.bytedance.android.ec.store.repository.vo.q;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.shopping.store.home.entity.ECShopHeadInfoBlock;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabConfig;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabDTO;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabData;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final a L = null;
    public String A;
    public n B;
    public Integer C;
    public Map<String, ? extends Object> D;
    public ECShopHeadInfoBlock E;
    public List<com.bytedance.android.ec.store.repository.dto.g> F;
    public Map<String, String> G;
    public ECHybridListDTO H;
    public k I;
    public String J;
    public String K;
    public j a;
    public List<j> b;
    public Integer c;
    public int d;
    public String e;
    public boolean f;
    public Integer g;
    public List<q> h;
    public List<r> i;
    public List<? extends StoreV2ProductItemVO> j;
    public boolean k;
    public String l;
    public String m;
    public Map<String, String> n;
    public Integer o;
    public String p;
    public String q;
    public long r;
    public Integer s;
    public Integer t;
    public String u;
    public String v;
    public ECStoreDynamicTabData w;
    public ECStoreDynamicTabConfig x;
    public String y;
    public Long z;

    public static final class a {
        public a() {
        }

        public static boolean a(Integer r3, ECStoreDynamicTabDTO r4) {
            if (r3 != null) goto L6;
        L7:
            if (r3 != null) goto L10;
            return false;
        L10:
            if (r3.intValue() != 3) goto L28;
        L11:
            ECStoreDynamicTabConfig r5 = null;
            if (r4 == null) goto L14;
            String r1 = r4.getBundleUrl();
        L16:
            if (r1 != null) goto L18;
        L21:
            boolean r2 = true;
        L22:
            if (r2 == false) goto L26;
            if (r4 == null) goto L25;
            r5 = r4.getConfig();
        L25:
            if (r5 != null) goto L26;
            return false;
        L26:
            return true;
        L18:
            if (StringsKt.isBlank(r1) == true) goto L21;
            r2 = false;
            goto L22
        L14:
            r1 = null;
            goto L16
        L28:
            return false;
        L6:
            if (r3.intValue() == 2) goto L11;
            goto L7
        }
    }

    static {
        L = new a();
    }

    public final String b() {
        String r0 = this.A;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L34;
        String r2 = null;
        if (e() == false) goto L16;
        ECStoreDynamicTabConfig r3 = this.x;
        if (r3 == null) goto L33;
        r2 = r3.getEventName();
    L33:
        this.A = r2;
        goto L34
    L16:
        if (i() == false) goto L18;
        r2 = "products";
        goto L33
    L18:
        int r4 = this.d;
        if (r4 != TabEnum.HOMEPAGE_TAB.getType()) goto L22;
        r2 = "homepage";
        goto L33
    L22:
        if (r4 != TabEnum.MOMENTS_TAB.getType()) goto L25;
        r2 = "moments";
        goto L33
    L25:
        if (r4 != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L28;
        r2 = "Bservice";
        goto L33
    L28:
        if (r4 != TabEnum.SHEET_TAB.getType()) goto L31;
        r2 = "shop_live_ing";
        goto L33
    L31:
        if (r4 != TabEnum.LIVE_TAB.getType()) goto L33;
        r2 = "shop_live_tab";
    L34:
        String r5 = this.A;
        if (r5 != null) goto L38;
        return "";
    L38:
        return r5;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean d() {
        if (this.d != TabEnum.BIGSALE_TAB.getType()) goto L5;
    L8:
        return true;
    L5:
        if (this.d == TabEnum.BIGSALE_TAB_WHITE.getType()) goto L8;
        return false;
    }

    public final boolean e() {
        L.getClass();
        Intrinsics.checkNotNullParameter(this, "tabVO");
        Integer r0 = this.t;
        ECStoreDynamicTabDTO.Companion.getClass();
        return a.a(r0, ECStoreDynamicTabDTO.a.a(this));
    }

    public final boolean f() {
        if (this.d != TabEnum.HOMEPAGE_TAB.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g() {
        Integer r0 = this.t;
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 5) goto L8;
        return true;
    }

    public final boolean h() {
        if (this.d != TabEnum.LIVE_TAB.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        if (this.d != TabEnum.PRODUCT_TAB.getType()) goto L5;
    L10:
        return true;
    L5:
        if (this.d == TabEnum.PRODUCT_NESTED_TAB.getType()) goto L10;
        if (this.d == TabEnum.PRODUCT_WHITE_BRAND.getType()) goto L10;
        return false;
    }

    public final boolean j() {
        if (this.d != TabEnum.SHEET_TAB.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public j() {
        this.e = "";
        this.f = true;
        this.j = CollectionsKt.emptyList();
        this.q = "";
    }

    public final String c() {
        if (e() == false) goto L13;
        ECStoreDynamicTabConfig r0 = this.x;
        if (r0 == null) goto L7;
        String r1 = r0.getEventName();
    L8:
        if (r1 != null) goto L11;
        return "";
    L11:
        return r1;
    L7:
        r1 = null;
        goto L8
    L13:
        if (i() == false) goto L16;
        return "products";
    L16:
        int r2 = this.d;
        if (r2 != TabEnum.HOMEPAGE_TAB.getType()) goto L20;
        return "homepage";
    L20:
        if (r2 != TabEnum.MOMENTS_TAB.getType()) goto L23;
        return "moments";
    L23:
        if (r2 != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L29;
        return "Bservice";
    L29:
        return "";
    }

    public final String a(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        int r0 = this.d;
        if (r0 != TabEnum.SELECTION_TAB.getType()) goto L5;
    L37:
        String r1 = "a1.b6269.c45075.d34426";
    L39:
        return BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r1, Boolean.FALSE).withView(r5).build());
    L5:
        if (r0 == TabEnum.ISV_TAB.getType()) goto L37;
        if (r0 == TabEnum.ISV_PLUS_TAB.getType()) goto L37;
        if (r0 != TabEnum.PRODUCT_TAB.getType()) goto L12;
    L36:
        r1 = "a1.b6269.c45075.d9124";
        goto L39
    L12:
        if (r0 == TabEnum.PRODUCT_NESTED_TAB.getType()) goto L36;
        if (r0 != TabEnum.CATEGORY_TAB.getType()) goto L18;
        r1 = "a1.b6269.c45075.d6413";
        goto L39
    L18:
        if (r0 != TabEnum.BIGSALE_TAB.getType()) goto L21;
        r1 = "a1.b6269.c45075.d8395";
        goto L39
    L21:
        if (r0 != TabEnum.MEMBER_TAB.getType()) goto L24;
        r1 = "a1.b6269.c45075.d0113";
        goto L39
    L24:
        if (r0 != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L27;
        r1 = "a1.b6269.c45075.d50039";
        goto L39
    L27:
        if (r0 != TabEnum.MOMENTS_TAB.getType()) goto L30;
        r1 = "a1.b6269.c45075.d9370";
        goto L39
    L30:
        if (r0 != TabEnum.HOMEPAGE_TAB.getType()) goto L33;
        r1 = "a1.b6269.c45075.d585832";
        goto L39
    L33:
        if (r0 != TabEnum.NEW_PRODUCT.getType()) goto L35;
        r1 = "a1.b6269.c45075.d429332";
        goto L39
    L35:
        r1 = "";
        goto L39
    }
}
