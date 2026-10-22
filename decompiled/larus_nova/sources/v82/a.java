package v82;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.ui.MediaAnchorLinkExpandViewHolder;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends me.drakeet.multitype.b<C7973a, MediaAnchorLinkExpandViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaAnchorLinkExpandViewHolder.a f553658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f553659c;

    /* JADX INFO: renamed from: v82.a$a, reason: collision with other inner class name */
    public static final class C7973a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f553660a;

        public C7973a() {
        }
    }

    public a(MediaAnchorLinkExpandViewHolder.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listenr");
        this.f553658b = r100;
        this.f553659c = false;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, C7973a r101) {
        MediaAnchorLinkExpandViewHolder r102 = (MediaAnchorLinkExpandViewHolder) r100;
        C7973a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        String r104 = r103.f553660a;
        r102.f138130a.setText(r104);
        r102.f138131b.setImageResource(R.drawable.ttlive_pk_userlist_expand_icon);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new MediaAnchorLinkExpandViewHolder(r100.inflate(R.layout.ttlive_item_media_anchor_link_expand_button, r101, false), this.f553658b, this.f553659c);
    }
}
