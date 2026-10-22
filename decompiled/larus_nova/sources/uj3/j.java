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
import com.larus.bmhome.share.panel.ShareChannel;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
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

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public String f550296J;
    public String K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f550297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<j> f550298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f550299c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f550300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f550301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f550302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f550303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<q> f550304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<r> f550305i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends StoreV2ProductItemVO> f550306j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f550307k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f550308l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f550309m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Map<String, String> f550310n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f550311o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f550312p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f550313q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f550314r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f550315s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Integer f550316t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f550317u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f550318v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ECStoreDynamicTabData f550319w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ECStoreDynamicTabConfig f550320x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f550321y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Long f550322z;

    public static final class a {
        public a() {
        }

        public static boolean a(Integer r100, ECStoreDynamicTabDTO r101) {
            if (r100 != null) goto L6;
        L7:
            if (r100 != null) goto L10;
            return false;
        L10:
            if (r100.intValue() != 3) goto L28;
        L11:
            ECStoreDynamicTabConfig r102 = null;
            if (r101 == null) goto L14;
            String r103 = r101.getBundleUrl();
        L16:
            if (r103 != null) goto L18;
        L21:
            boolean r104 = true;
        L22:
            if (r104 == false) goto L26;
            if (r101 == null) goto L25;
            r102 = r101.getConfig();
        L25:
            if (r102 != null) goto L26;
            return false;
        L26:
            return true;
        L18:
            if (StringsKt.isBlank(r103) == true) goto L21;
            r104 = false;
            goto L22
        L14:
            r103 = null;
            goto L16
        L28:
            return false;
        L6:
            if (r100.intValue() == 2) goto L11;
            goto L7
        }
    }

    static {
        L = new a();
    }

    public final String b() {
        String r100 = this.A;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L34;
        String r102 = null;
        if (e() == false) goto L16;
        ECStoreDynamicTabConfig r103 = this.f550320x;
        if (r103 == null) goto L33;
        r102 = r103.getEventName();
    L33:
        this.A = r102;
        goto L34
    L16:
        if (i() == false) goto L18;
        r102 = "products";
        goto L33
    L18:
        int r104 = this.f550300d;
        if (r104 != TabEnum.HOMEPAGE_TAB.getType()) goto L22;
        r102 = "homepage";
        goto L33
    L22:
        if (r104 != TabEnum.MOMENTS_TAB.getType()) goto L25;
        r102 = ShareChannel.WX_MOMENTS;
        goto L33
    L25:
        if (r104 != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L28;
        r102 = "Bservice";
        goto L33
    L28:
        if (r104 != TabEnum.SHEET_TAB.getType()) goto L31;
        r102 = "shop_live_ing";
        goto L33
    L31:
        if (r104 != TabEnum.LIVE_TAB.getType()) goto L33;
        r102 = "shop_live_tab";
    L34:
        String r105 = this.A;
        if (r105 != null) goto L38;
        return "";
    L38:
        return r105;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean d() {
        if (this.f550300d != TabEnum.BIGSALE_TAB.getType()) goto L5;
    L8:
        return true;
    L5:
        if (this.f550300d == TabEnum.BIGSALE_TAB_WHITE.getType()) goto L8;
        return false;
    }

    public final boolean e() {
        L.getClass();
        Intrinsics.checkNotNullParameter(this, "tabVO");
        Integer r100 = this.f550316t;
        ECStoreDynamicTabDTO.Companion.getClass();
        return a.a(r100, ECStoreDynamicTabDTO.a.a(this));
    }

    public final boolean f() {
        if (this.f550300d != TabEnum.HOMEPAGE_TAB.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean g() {
        Integer r100 = this.f550316t;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 5) goto L8;
        return true;
    }

    public final boolean h() {
        if (this.f550300d != TabEnum.LIVE_TAB.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        if (this.f550300d != TabEnum.PRODUCT_TAB.getType()) goto L5;
    L10:
        return true;
    L5:
        if (this.f550300d == TabEnum.PRODUCT_NESTED_TAB.getType()) goto L10;
        if (this.f550300d == TabEnum.PRODUCT_WHITE_BRAND.getType()) goto L10;
        return false;
    }

    public final boolean j() {
        if (this.f550300d != TabEnum.SHEET_TAB.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public j() {
        this.f550301e = "";
        this.f550302f = true;
        this.f550306j = CollectionsKt.emptyList();
        this.f550313q = "";
    }

    public final String c() {
        if (e() == false) goto L13;
        ECStoreDynamicTabConfig r100 = this.f550320x;
        if (r100 == null) goto L7;
        String r101 = r100.getEventName();
    L8:
        if (r101 != null) goto L11;
        return "";
    L11:
        return r101;
    L7:
        r101 = null;
        goto L8
    L13:
        if (i() == false) goto L16;
        return "products";
    L16:
        int r102 = this.f550300d;
        if (r102 != TabEnum.HOMEPAGE_TAB.getType()) goto L20;
        return "homepage";
    L20:
        if (r102 != TabEnum.MOMENTS_TAB.getType()) goto L23;
        return ShareChannel.WX_MOMENTS;
    L23:
        if (r102 != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L29;
        return "Bservice";
    L29:
        return "";
    }

    public final String a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int r101 = this.f550300d;
        if (r101 != TabEnum.SELECTION_TAB.getType()) goto L5;
    L37:
        String r102 = "a1.b6269.c45075.d34426";
    L39:
        return BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder(r102, Boolean.FALSE).withView(r100).build());
    L5:
        if (r101 == TabEnum.ISV_TAB.getType()) goto L37;
        if (r101 == TabEnum.ISV_PLUS_TAB.getType()) goto L37;
        if (r101 != TabEnum.PRODUCT_TAB.getType()) goto L12;
    L36:
        r102 = "a1.b6269.c45075.d9124";
        goto L39
    L12:
        if (r101 == TabEnum.PRODUCT_NESTED_TAB.getType()) goto L36;
        if (r101 != TabEnum.CATEGORY_TAB.getType()) goto L18;
        r102 = "a1.b6269.c45075.d6413";
        goto L39
    L18:
        if (r101 != TabEnum.BIGSALE_TAB.getType()) goto L21;
        r102 = "a1.b6269.c45075.d8395";
        goto L39
    L21:
        if (r101 != TabEnum.MEMBER_TAB.getType()) goto L24;
        r102 = "a1.b6269.c45075.d0113";
        goto L39
    L24:
        if (r101 != TabEnum.CUSTOM_SERVICE_TAB.getType()) goto L27;
        r102 = "a1.b6269.c45075.d50039";
        goto L39
    L27:
        if (r101 != TabEnum.MOMENTS_TAB.getType()) goto L30;
        r102 = "a1.b6269.c45075.d9370";
        goto L39
    L30:
        if (r101 != TabEnum.HOMEPAGE_TAB.getType()) goto L33;
        r102 = "a1.b6269.c45075.d585832";
        goto L39
    L33:
        if (r101 != TabEnum.NEW_PRODUCT.getType()) goto L35;
        r102 = "a1.b6269.c45075.d429332";
        goto L39
    L35:
        r102 = "";
        goto L39
    }
}
