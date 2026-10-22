package f20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.OpenFeatureTabListItemViewHolder;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends g<f10.f, OpenFeatureTabListItemViewHolder> {
    @Override // f20.c
    public final boolean accept(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return false;
    }

    public b() {
    }

    @Override // f20.a
    public final RecyclerView.ViewHolder a(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L7;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L7;
        Room r104 = r103.getValue();
    L9:
        if (r104 == null) goto L11;
        View r105 = r100.inflate(R.layout.ttlive_open_feature_icon_tab_item, r101, false);
    L13:
        return new OpenFeatureTabListItemViewHolder(r105, null);
    L11:
        r105 = r100.inflate(R.layout.ttlive_open_feature_icon_tab_item_before_live, r101, false);
    L7:
        r104 = null;
        goto L9
    }
}
