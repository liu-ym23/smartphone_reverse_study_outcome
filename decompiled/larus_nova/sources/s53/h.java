package s53;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.widget.flow.TagFlowLayout;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.bytedance.android.shopping.anchorv3.comment.sku.viewmodel.CommentSkuViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentSkuViewModel f540719f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f540720g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.ec.model.response.anchorv3.d> f540721h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f540722i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f540723j;

    public static final class a {
    }

    static {
    }

    public final void d0() {
        List<com.bytedance.android.ec.model.response.anchorv3.d> r100 = this.f540721h;
        if (r100 == null) goto L15;
        Iterator r101 = ((ArrayList) r100).iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L18;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Iterator<T> r105 = ((com.bytedance.android.ec.model.response.anchorv3.d) r103).f47946b.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        TextView r106 = (TextView) r105.next();
        com.bytedance.android.shopping.extensions.f.e(r106, 400);
        int r107 = g1.f45599a;
        r106.setTextColor(g1.a.a(r106.getContext(), R.color.commerce_color_FF161823));
        r106.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_new);
        goto L12
    L14:
        r102 = r104;
        goto L6
    L18:
        return;
    }

    public h(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f540721h = new ArrayList();
        this.f540722i = new LinkedHashMap();
        this.f540723j = new LinkedHashMap();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        this.f540719f = (CommentSkuViewModel) Y().g(CommentSkuViewModel.class);
        this.f540720g = (ViewGroup) Z().b(R.id.sku_select_layout).f();
        CommentSkuViewModel r100 = this.f540719f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        List<PromotionProductSkuStruct> r101 = r100.getSkuInfo().a();
        int r102 = 500;
        if (r101 == null) goto L20;
        Context r103 = Y().c();
        Iterator<T> r111 = r101.iterator();
        int r104 = 0;
    L9:
        if (r111.hasNext() == false) goto L20;
        Object r105 = r111.next();
        int r112 = r104 + 1;
        if (r104 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        PromotionProductSkuStruct r113 = (PromotionProductSkuStruct) r105;
        com.bytedance.android.ec.model.response.anchorv3.d r114 = new com.bytedance.android.ec.model.response.anchorv3.d(r113.getSpecKey(), new ArrayList());
        TextView r106 = new TextView(r103);
        r106.setText(r113.getSpecKey());
        int r107 = g1.f45599a;
        r106.setTextColor(g1.a.a(r103, R.color.commerce_color_161823));
        r106.setTextSize(1, 14.0f);
        com.bytedance.android.shopping.extensions.f.e(r106, Integer.valueOf(r102));
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-2, -2);
        ViewGroup r109 = this.f540720g;
        if (r109 == null) goto L16;
        r109.addView(r106, r108);
    L16:
        TagFlowLayout r115 = new TagFlowLayout(r103);
        r115.setAdapter(new i(r113, r114, r113.getSpecNameList(), this, r103));
        r115.setOnTagClickListener(new j(r113, this));
        ((ArrayList) this.f540721h).add(r114);
        LinearLayout.LayoutParams r116 = new LinearLayout.LayoutParams(-1, -2);
        r116.setMargins(0, com.bytedance.android.shopping.extensions.b.b(12), 0, 0);
        ViewGroup r117 = this.f540720g;
        if (r117 == null) goto L19;
        r117.addView(r115, r116);
    L19:
        r104 = r112;
        r102 = 500;
    L20:
        CommentSkuViewModel r118 = this.f540719f;
        if (r118 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        Map<String, String> r119 = r118.getPreSkuInfo().a();
        if (r119 == null) goto L26;
        this.f540722i.putAll(r119);
        this.f540723j.putAll(r119);
    L26:
        d0();
        Map<String, String> r120 = this.f540722i;
        Intrinsics.checkNotNullParameter(r120, "skuInfo");
        Iterator r121 = ((LinkedHashMap) r120).entrySet().iterator();
    L28:
        if (r121.hasNext() == false) goto L47;
        Map.Entry r122 = (Map.Entry) r121.next();
        Iterator r123 = ((ArrayList) this.f540721h).iterator();
    L30:
        Object r124 = null;
        if (r123.hasNext() == false) goto L35;
        Object r125 = r123.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.model.response.anchorv3.d) r125).f47945a, (String) r122.getKey()) == false) goto L30;
    L36:
        com.bytedance.android.ec.model.response.anchorv3.d r126 = (com.bytedance.android.ec.model.response.anchorv3.d) r125;
        if (r126 == null) goto L28;
        Iterator<T> r127 = r126.f47946b.iterator();
    L40:
        if (r127.hasNext() == false) goto L44;
        Object r128 = r127.next();
        if (Intrinsics.areEqual(((TextView) r128).getText(), (String) r122.getValue()) == false) goto L40;
        r124 = r128;
    L44:
        TextView r129 = (TextView) r124;
        if (r129 == null) goto L28;
        com.bytedance.android.shopping.extensions.f.e(r129, 500);
        int r130 = g1.f45599a;
        r129.setTextColor(g1.a.a(r129.getContext(), R.color.commerce_color_FE2C55));
        r129.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_selected_new);
        goto L28
    L35:
        r125 = null;
        goto L36
    L47:
        CommentSkuViewModel r131 = this.f540719f;
        if (r131 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        r131.getResetSku().b(ECQuickUtilKt.a(Y()), new k(this));
    }

    public final void e0(String r110, String r111, String r112) {
        Object r100 = null;
        if (r111 != null) goto L23;
        Iterator r113 = ((ArrayList) this.f540721h).iterator();
    L6:
        if (r113.hasNext() == false) goto L10;
        Object r101 = r113.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.model.response.anchorv3.d) r101).f47945a, r110) == false) goto L6;
    L11:
        com.bytedance.android.ec.model.response.anchorv3.d r102 = (com.bytedance.android.ec.model.response.anchorv3.d) r101;
        if (r102 == null) goto L92;
        Iterator<T> r114 = r102.f47946b.iterator();
    L15:
        if (r114.hasNext() == false) goto L19;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((TextView) r115).getText(), r112) == false) goto L15;
        r100 = r115;
    L19:
        TextView r103 = (TextView) r100;
        if (r103 == null) goto L93;
        com.bytedance.android.shopping.extensions.f.e(r103, 500);
        int r116 = g1.f45599a;
        r103.setTextColor(g1.a.a(r103.getContext(), R.color.commerce_color_FE2C55));
        r103.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_selected_new);
        return;
    L93:
        return;
    L92:
        return;
    L10:
        r101 = null;
        goto L11
    L23:
        if (Intrinsics.areEqual(r111, r112) == false) goto L42;
        Iterator r117 = ((ArrayList) this.f540721h).iterator();
    L26:
        if (r117.hasNext() == false) goto L30;
        Object r104 = r117.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.model.response.anchorv3.d) r104).f47945a, r110) == false) goto L26;
    L31:
        com.bytedance.android.ec.model.response.anchorv3.d r105 = (com.bytedance.android.ec.model.response.anchorv3.d) r104;
        if (r105 == null) goto L95;
        Iterator<T> r118 = r105.f47946b.iterator();
    L35:
        if (r118.hasNext() == false) goto L39;
        Object r119 = r118.next();
        if (Intrinsics.areEqual(((TextView) r119).getText(), r112) == false) goto L35;
        r100 = r119;
    L39:
        TextView r106 = (TextView) r100;
        if (r106 == null) goto L96;
        int r120 = g1.f45599a;
        r106.setTextColor(g1.a.a(r106.getContext(), R.color.commerce_color_FF161823));
        com.bytedance.android.shopping.extensions.f.e(r106, 400);
        r106.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_new);
        return;
    L96:
        return;
    L95:
        return;
    L30:
        r104 = null;
        goto L31
    L42:
        Iterator r107 = ((ArrayList) this.f540721h).iterator();
    L44:
        if (r107.hasNext() == false) goto L48;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((com.bytedance.android.ec.model.response.anchorv3.d) r108).f47945a, r110) == false) goto L44;
    L49:
        com.bytedance.android.ec.model.response.anchorv3.d r109 = (com.bytedance.android.ec.model.response.anchorv3.d) r108;
        if (r109 == null) goto L98;
        Iterator<T> r121 = r109.f47946b.iterator();
    L53:
        if (r121.hasNext() == false) goto L57;
        Object r122 = r121.next();
        if (Intrinsics.areEqual(((TextView) r122).getText(), r112) == false) goto L53;
    L58:
        TextView r123 = (TextView) r122;
        if (r123 == null) goto L61;
        int r124 = g1.f45599a;
        r123.setTextColor(g1.a.a(r123.getContext(), R.color.commerce_color_FE2C55));
        com.bytedance.android.shopping.extensions.f.e(r123, 500);
        r123.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_selected_new);
    L61:
        Iterator<T> r125 = r109.f47946b.iterator();
    L63:
        if (r125.hasNext() == false) goto L67;
        Object r126 = r125.next();
        if (Intrinsics.areEqual(((TextView) r126).getText(), r111) == false) goto L63;
        r100 = r126;
    L67:
        TextView r127 = (TextView) r100;
        if (r127 == null) goto L99;
        com.bytedance.android.shopping.extensions.f.e(r127, 400);
        int r128 = g1.f45599a;
        r127.setTextColor(g1.a.a(r127.getContext(), R.color.commerce_color_FF161823));
        r127.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_new);
        return;
    L99:
        return;
    L57:
        r122 = null;
        goto L58
    L98:
        return;
    L48:
        r108 = null;
        goto L49
    }
}
