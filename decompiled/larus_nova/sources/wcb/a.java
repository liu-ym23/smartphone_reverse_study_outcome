package wcb;

import android.graphics.RectF;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.export.empty.EmptyProperty;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.tangram.base.style.TCStyle;
import kotlin.jvm.internal.Intrinsics;
import q6c.e;
import vcb.d;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends e<BaseProperty, LKUIRoundableLayout, r6c.a> {
    @Override // q6c.a
    public final String i() {
        return "com.larksuite.component.ui.layout.LKUIRoundableLayout";
    }

    @Override // q6c.e
    public final boolean j() {
        return false;
    }

    @Override // q6c.e, s6c.b
    public final View a(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "size");
        Dp r101 = this.f531875a;
        if (r101 == 0) goto L6;
        LKUIRoundableLayout r102 = new LKUIRoundableLayout(r101.getContext(), null, 6, 0);
        r102.setTag(R.id.virtual_node_id, this.f531876b);
        return r102;
    L6:
        Intrinsics.checkNotNullParameter(r100, "size");
        return null;
    }

    public void update(LKUIRoundableLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r100.getId() != R.id.preview_root_view) goto L5;
        r100.setBackground(null);
        r100.setBackgroundColor(UDColorUtils.getColor(r100.getContext(), R.color.bg_float));
    L5:
        r100.setOnClickListener(null);
        r100.setClickable(false);
    }

    @Override // q6c.e
    public /* bridge */ /* synthetic */ void update(View r100) {
        update((LKUIRoundableLayout) r100);
    }

    public a(EmptyProperty r100, TCStyle r101, d r102) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        Intrinsics.checkNotNullParameter(r102, "dependency");
        super(r100, r101, r102);
    }
}
