package i62;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelChatViewHolder;
import com.larus.nova.R;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements com.bytedance.android.livesdk.interactivity.service.messagelist.c, View.OnClickListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f488360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final User f488361b;

    /* JADX INFO: renamed from: i62.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC6232a<T extends a> extends me.drakeet.multitype.b<T, ChatChannelChatViewHolder> {
        public abstract void h(ChatChannelChatViewHolder r100, T r101);

        public AbstractC6232a() {
        }

        @Override // me.drakeet.multitype.b
        public final void b(RecyclerView.ViewHolder r100, Object r101) {
            ChatChannelChatViewHolder r102 = (ChatChannelChatViewHolder) r100;
            a r103 = (a) r101;
            Intrinsics.checkNotNullParameter(r102, "holder");
            Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
            if ((r103 instanceof wb2.d.a) == true) goto L5;
            Object r104 = null;
        L6:
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, "onClickListener");
            Intrinsics.checkNotNullParameter(r103, "longClickListener");
            r102.f134332d = (wb2.d.a) r104;
            HSImageView r105 = r102.f134329a;
            if (r105 == null) goto L9;
            r105.setOnClickListener(r103);
            r105.setOnLongClickListener(r103);
        L9:
            TextView r106 = r102.f134330b;
            if (r106 == null) goto L12;
            r106.setOnLongClickListener(r103);
        L12:
            r102.itemView.setOnLongClickListener(r103);
            TextView r107 = r102.f134331c;
            if (r107 == null) goto L15;
            r107.setOnClickListener(k62.c.f501951a);
            r107.setOnLongClickListener(r103);
        L15:
            h(r102, r103);
            return;
        L5:
            r104 = r103;
            goto L6
        }

        @Override // me.drakeet.multitype.b
        public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "inflater");
            Intrinsics.checkNotNullParameter(r101, "parent");
            int r102 = ChatChannelChatViewHolder.f134327e;
            Intrinsics.checkNotNullParameter(r100, "inflater");
            Intrinsics.checkNotNullParameter(r101, "parent");
            return new ChatChannelChatViewHolder(r100.inflate(R.layout.ttlive_item_chat_channel_chat_message, r101, false));
        }
    }

    public abstract String e();

    public abstract boolean f();

    public a(User r100) {
        this.f488361b = r100;
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getCastSecUid();
    L6:
        IUserService r103 = (IUserService) k.f(IUserService.class);
        if (r103 == null) goto L13;
        com.bytedance.android.livesdk.user.f r104 = r103.user();
        if (r104 == null) goto L13;
        IUser r105 = r104.b();
        if (r105 == null) goto L13;
        Intrinsics.checkNotNullParameter(r105, "$this$secUidExt");
        r101 = r105.getCastSecUid();
    L13:
        this.f488360a = Intrinsics.areEqual(r102, r101);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        User r101 = this.f488361b;
        if (r101 != null) goto L5;
        return;
    L5:
        String r102 = e();
        if (r102 != null) goto L8;
        return;
    L8:
        int r103 = e62.d.f471125a;
        e62.d.b(r101, getId(), r102);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        User r101 = this.f488361b;
        if (r101 != null) goto L6;
        return false;
    L6:
        int r102 = e62.d.f471125a;
        e62.d.c(r101, getId(), getChannelId());
        return true;
    }
}
