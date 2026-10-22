package y31;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.viewholder.TitleViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y extends me.drakeet.multitype.b<a, TitleViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f565844a;

        public a() {
        }
    }

    public y() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        TitleViewHolder r102 = (TitleViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "titleViewBinderData");
        ((TextView) r102.f96280a.findViewById(R.id.title)).setVisibility(0);
        ((TextView) r102.f96280a.findViewById(R.id.title)).setText(r103.f565844a);
        ((TextView) r102.f96280a.findViewById(R.id.title)).setTextColor(s1.h(R.color.ttlive_interact_default_text_color));
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new TitleViewHolder(r100.inflate(R.layout.ttlive_item_interact_title, r101, false));
    }
}
