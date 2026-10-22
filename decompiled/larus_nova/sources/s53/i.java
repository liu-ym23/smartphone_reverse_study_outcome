package s53;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.ec.core.utils.g1;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductSkuStruct;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
public final class i extends ei.a<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PromotionProductSkuStruct f540724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.ec.model.response.anchorv3.d f540725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f540726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Context f540727f;

    @Override // ei.a
    public final View a(Object r100) {
        h r101 = this.f540726e;
        Context r102 = this.f540727f;
        this.f540724c.getSpecKey();
        r101.getClass();
        TextView r103 = new TextView(r102);
        r103.setText((String) r100);
        int r104 = g1.f45599a;
        r103.setTextColor(g1.a.a(r102, R.color.commerce_color_FF161823));
        r103.setTextSize(1, 14.0f);
        ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-2, -2);
        r105.setMargins(0, 0, com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(8));
        Unit r106 = Unit.INSTANCE;
        r103.setLayoutParams(r105);
        r103.setMaxWidth(k1.m(r102) - com.bytedance.android.shopping.extensions.b.b(40));
        r103.setPadding(com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(10), com.bytedance.android.shopping.extensions.b.b(16), com.bytedance.android.shopping.extensions.b.b(10));
        com.bytedance.android.shopping.extensions.f.e(r103, 400);
        r103.setBackgroundResource(R.drawable.ec_commerce_comment_sku_tag_new);
        r103.setGravity(GravityCompat.START);
        this.f540725d.f47946b.add(r103);
        return r103;
    }

    public i(PromotionProductSkuStruct r100, com.bytedance.android.ec.model.response.anchorv3.d r101, List r102, h r103, Context r104) {
        this.f540724c = r100;
        this.f540725d = r101;
        this.f540726e = r103;
        this.f540727f = r104;
        super(r102);
    }
}
