package mx;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n extends m {
    public n() {
        super(false);
    }

    @Override // mx.m, me.drakeet.multitype.b
    public final /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, o r101) {
        h(r100, r101);
    }

    @Override // mx.m
    public final void h(RecyclerView.ViewHolder r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        super.h(r100, r101);
        View r102 = r100.itemView;
        if (r102 == null) goto L7;
        ((TextView) r102).setTextColor(ColorProtector.parseColor("#80161823"));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
