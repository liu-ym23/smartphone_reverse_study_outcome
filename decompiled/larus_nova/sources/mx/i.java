package mx;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.adapter.binding.LinkmicSubtitleSettingViewHolder;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import mx.h;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T extends h> extends me.drakeet.multitype.b<T, LinkmicSubtitleSettingViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f516143b;

    public i(boolean r100) {
        this.f516143b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, Object r101) {
        LinkmicSubtitleSettingViewHolder r102 = (LinkmicSubtitleSettingViewHolder) r100;
        h r103 = (h) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.T3(r103);
        r102.itemView.setOnClickListener(r103.f516142l);
        if (this.f516143b == false) goto L11;
        TextView r104 = r102.f58542a;
        if (r104 == null) goto L7;
        r104.setTextColor(s1.h(R.color.ttlive_dialog_main_text));
    L7:
        TextView r105 = r102.f58543b;
        if (r105 == null) goto L12;
        r105.setTextColor(s1.h(R.color.ttlive_dialog_sub_content_text));
        return;
    L12:
        return;
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new LinkmicSubtitleSettingViewHolder(r100.inflate(R.layout.ttlive_item_simple_setting_subtitle, r101, false));
    }
}
