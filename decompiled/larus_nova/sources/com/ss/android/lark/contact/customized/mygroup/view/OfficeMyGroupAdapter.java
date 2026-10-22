package com.ss.android.lark.contact.customized.mygroup.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\"\u0010\u0015\u001a\u00020\f2\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nJ\u0014\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter$GroupItemViewHolder;", "<init>", "()V", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "Lkotlin/collections/ArrayList;", "onItemClickListener", "Lkotlin/Function2;", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "setOnItemClickListener", "listener", "diff", "newItems", "", "bindAvatar", "avatarView", "Landroid/widget/ImageView;", MapController.ITEM_LAYER_TAG, "GroupItemViewHolder", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeMyGroupAdapter extends RecyclerView.Adapter<GroupItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Chat> f419295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Chat, ? super Integer, Unit> f419296b;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/contact/customized/mygroup/view/OfficeMyGroupAdapter$GroupItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", RootDescription.ROOT_ELEMENT, "getRoot", "()Landroid/view/View;", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GroupItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f419297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f419298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f419299c;

        public GroupItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f419297a = r100;
            this.f419298b = (ImageView) r100.findViewById(R.id.group_avatar_iv);
            this.f419299c = (TextView) r100.findViewById(R.id.group_name_tv);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f419295a.size();
    }

    public OfficeMyGroupAdapter() {
        this.f419295a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        GroupItemViewHolder r102 = (GroupItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Chat r103 = (Chat) CollectionsKt.getOrNull(this.f419295a, r101);
        if (r103 == null) goto L7;
        r102.f419299c.setText(r103.getName());
        ImageView r104 = r102.f419298b;
        Context r105 = r104.getContext();
        int r106 = UIHelper.dp2px(48.0f);
        String r107 = r103.getAvatarKey();
        String r108 = r103.getId();
        LoadParams r109 = new LoadParams();
        r109.f426328a = r106;
        r109.f426329b = r106;
        ImageModule.a(r105, r104, r107, r108, r109);
        r102.f419297a.setOnClickListener(new a(this, r103, r101));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.contact_db_item_group_chat, r100, false);
        Intrinsics.checkNotNull(r102);
        return new GroupItemViewHolder(r102);
    }
}
