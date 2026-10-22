package com.ss.android.lark.search.doubao.chat.holder.msg;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/search/doubao/chat/holder/msg/MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "userAvatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "kotlin.jvm.PlatformType", "userName", "Landroid/widget/TextView;", "messageContent", "messageTime", "bindData", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchMessageInfo;", "search-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarkAvatarView f440076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f440077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f440078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f440079d;

    public MessageViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f440076a = (LarkAvatarView) r100.findViewById(R.id.user_avatar);
        this.f440077b = (TextView) r100.findViewById(R.id.user_name);
        this.f440078c = (TextView) r100.findViewById(R.id.message_content);
        this.f440079d = (TextView) r100.findViewById(R.id.message_time);
    }
}
