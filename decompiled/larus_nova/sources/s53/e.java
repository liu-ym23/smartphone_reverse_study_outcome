package s53;

import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommentSkuViewModel f540712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f540713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f540714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f540715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<PromotionProductSkuStruct> f540716j;

    public static final class a {
    }

    static {
    }

    public final void d0() {
        TextView r100 = this.f540714h;
        if (r100 == null) goto L49;
        StringBuilder r101 = new StringBuilder();
        if ((!this.f540716j.isEmpty()) == true) goto L7;
        String r102 = r101.toString();
    L34:
        r100.setText(r102);
        return;
    L7:
        if (this.f540716j.size() != this.f540715i.size()) goto L21;
        int r103 = g1.f45599a;
        r101.append(g1.a.c(Y().c(), R.string.commerce_sku_already_select, new Object[0]));
        List<PromotionProductSkuStruct> r104 = this.f540716j;
        if (r104 == null) goto L20;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L20;
        PromotionProductSkuStruct r106 = (PromotionProductSkuStruct) r105.next();
        Map<String, String> r107 = this.f540715i;
        String r108 = r106.getSpecKey();
        if (r107 == null) goto L19;
        if (r107.containsKey(r108) == false) goto L12;
        r101.append(this.f540715i.get(r106.getSpecKey()));
        r101.append("、");
        goto L12
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L20:
        r101.deleteCharAt(r101.length() - 1);
        r102 = r101.toString();
        goto L34
    L21:
        Iterator<T> r109 = this.f540716j.iterator();
    L23:
        if (r109.hasNext() == false) goto L32;
        PromotionProductSkuStruct r110 = (PromotionProductSkuStruct) r109.next();
        Map<String, String> r111 = this.f540715i;
        String r112 = r110.getSpecKey();
        if (r111 == null) goto L31;
        if (r111.containsKey(r112) == true) goto L28;
        int r113 = g1.f45599a;
        r101.append(g1.a.c(Y().c(), R.string.commerce_sku_please_select, new Object[0]));
        r101.append(r110.getSpecKey());
        r101.append("；");
        goto L23
    L28:
        int r114 = g1.f45599a;
        r101.append(g1.a.c(Y().c(), R.string.commerce_sku_already_select, new Object[0]));
        r101.append(this.f540715i.get(r110.getSpecKey()));
        r101.append(com.alipay.sdk.m.u.i.f25853b);
        goto L23
    L31:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L32:
        r101.deleteCharAt(r101.length() - 1);
        r102 = r101.toString();
        goto L34
    }

    public e(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f540715i = new LinkedHashMap();
        this.f540716j = new ArrayList();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f540712f = (CommentSkuViewModel) Y().g(CommentSkuViewModel.class);
        TextView r101 = (TextView) Z().b(R.id.product_title).f();
        this.f540713g = r101;
        r101.setMaxWidth(k1.m(Y().c()) - com.bytedance.android.shopping.extensions.b.b(68));
        this.f540714h = (TextView) Z().b(R.id.sku_select_desc).f();
        CommentSkuViewModel r102 = this.f540712f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        List<PromotionProductSkuStruct> r103 = r102.getSkuInfo().a();
        if (r103 == null) goto L8;
        this.f540716j = r103;
    L8:
        CommentSkuViewModel r104 = this.f540712f;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        Map<String, String> r105 = r104.getPreSkuInfo().a();
        if (r105 == null) goto L14;
        this.f540715i = r105;
    L14:
        CommentSkuViewModel r106 = this.f540712f;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        String r107 = r106.getProductTitle().a();
        if (r107 == null) goto L22;
        TextView r108 = this.f540713g;
        if (r108 == null) goto L22;
        r108.setText(r107);
    L22:
        CommentSkuViewModel r109 = this.f540712f;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        r109.getSkuInfo().b(ECQuickUtilKt.a(Y()), new f(this));
        CommentSkuViewModel r110 = this.f540712f;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r110.getSkuRequestInfo().b(ECQuickUtilKt.a(Y()), new g(this));
        d0();
    }
}
