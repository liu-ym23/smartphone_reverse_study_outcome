package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.adapter.binding.SimpleSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mx.j;

/* JADX INFO: loaded from: classes45.dex */
public final class k<T extends j> extends me.drakeet.multitype.b<T, SimpleSettingViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super SimpleSettingViewHolder, Unit> f516145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f516146c;

    public k(boolean r100) {
        this.f516146c = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, Object r101) {
        SimpleSettingViewHolder r102 = (SimpleSettingViewHolder) r100;
        j r103 = (j) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.T3(r103);
        r102.itemView.setOnClickListener(r103.f516144l);
        if (this.f516146c == false) goto L16;
        TextView r104 = r102.f58542a;
        if (r104 == null) goto L7;
        r104.setTextColor(s1.h(R.color.ttlive_dialog_main_text));
    L7:
        TextView r105 = r102.f58543b;
        if (r105 == null) goto L10;
        r105.setTextColor(s1.h(R.color.ttlive_dialog_sub_content_text));
    L10:
        View r106 = r102.itemView;
        if (r106 == null) goto L17;
        ImageView r107 = (ImageView) r106.findViewById(R.id.iv_arrow);
        if (r107 == null) goto L18;
        r107.setImageDrawable(s1.m(R.drawable.ttlive_panel_enter_dark));
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        SimpleSettingViewHolder r102 = new SimpleSettingViewHolder(r100.inflate(R.layout.ttlive_item_simple_setting, r101, false));
        Function1<? super SimpleSettingViewHolder, Unit> r103 = this.f516145b;
        if (r103 == null) goto L5;
        Unit r104 = r103.invoke(r102);
    L5:
        return r102;
    }
}
