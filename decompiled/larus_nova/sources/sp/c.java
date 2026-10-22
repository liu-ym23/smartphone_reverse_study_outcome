package sp;

import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.repository.vo.k;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends QFragmentPresenter {
    public c(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        if ((r100 instanceof k) == true) goto L5;
        r100 = null;
    L5:
        k r101 = (k) r100;
        if (r101 == null) goto L27;
        dm.a.a("chenlong_hz_筛选").a("onBind=" + r101.f49504b + ',' + r101.f49505c);
        TextView r102 = (TextView) Z().b(R.id.tv_sort).f();
        ImageView r103 = (ImageView) Z().b(R.id.iv_sort).f();
        View r104 = Z().b(R.id.iv_red_dot).f();
        r102.setText(r101.f49504b);
        if (r101.f49506d == false) goto L16;
        r103.setVisibility(0);
        if (r101.f49505c == true) goto L12;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_unselect_new);
    L18:
        if (r101.f49509g == false) goto L20;
        r104.setVisibility(0);
    L22:
        if (r101.f49505c == false) goto L24;
        r102.setTextColor(th.a.a(Y().c(), R.color.ec_shop_FFFF3344));
    L25:
        a0().setOnClickListener(new b(r101));
        return;
    L24:
        r102.setTextColor(th.a.a(Y().c(), R.color.ec_shop_tab_indicator_text_color));
        r102.setTypeface(Typeface.defaultFromStyle(0));
        goto L25
    L20:
        r104.setVisibility(8);
        goto L22
    L12:
        if (r101.f49507e != 0) goto L14;
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_desc_pink);
        goto L18
    L14:
        r103.setImageResource(R.drawable.ecommerce_store_ic_sort_asc_pink);
        goto L18
    L16:
        r103.setVisibility(8);
        goto L18
    }
}
