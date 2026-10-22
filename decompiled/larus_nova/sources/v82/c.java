package v82;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkTitleViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends me.drakeet.multitype.b<a, MediaAnchorLinkTitleViewHolder> {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f553664a;

        public a() {
        }
    }

    public c() {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, a r101) {
        MediaAnchorLinkTitleViewHolder r102 = (MediaAnchorLinkTitleViewHolder) r100;
        a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        String r104 = r103.f553664a;
        r102.f138142a.setText(r104);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new MediaAnchorLinkTitleViewHolder(r100.inflate(R.layout.ttlive_item_media_anchor_link_title, r101, false));
    }
}
