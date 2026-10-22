package com.ss.android.lark.todo.impl.features.detail.comment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.utils.FileUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAttachmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "attachmentDataList", "", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAttachmentData;", "isExpand", "", "expandClick", "Lkotlin/Function0;", "", "<init>", "(Ljava/util/List;ZLkotlin/jvm/functions/Function0;)V", "()Z", "setExpand", "(Z)V", "getExpandClick", "()Lkotlin/jvm/functions/Function0;", "data", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "isShouldShowExpandBtn", "AttachmentViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentAttachmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f442838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f442839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<TodoAttachmentData> f442840c;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAttachmentAdapter$AttachmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/comment/CommentAttachmentAdapter;Landroid/view/View;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAttachmentData;", "position", "", "initViewAction", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AttachmentViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentAttachmentAdapter f442841a;

        public AttachmentViewHolder(CommentAttachmentAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f442841a = r100;
            super(r101);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        if (this.f442840c.size() > 3) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L11;
        return 3;
    L11:
        return this.f442840c.size();
    L5:
        if (this.f442838a == true) goto L7;
        r100 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        TodoAttachmentData r102 = (TodoAttachmentData) ListProtector.get(this.f442840c, r101);
        if ((r100 instanceof AttachmentViewHolder) == false) goto L18;
        if (r102 == null) goto L19;
        AttachmentViewHolder r103 = (AttachmentViewHolder) r100;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        ((TextView) r103.itemView.findViewById(R.id.text_attachment_name)).setText(r102.getName());
        ((TextView) r103.itemView.findViewById(R.id.text_attachment_size)).setText(FileUtils.h(CastLongProtector.parseLong(r102.getFileSize())));
        boolean r104 = true;
        ((AppCompatImageView) r103.itemView.findViewById(R.id.image_attachment_icon)).setImageResource(com.ss.android.lark.utils.a0.b(FileUtils.p(r102.getName()), r102.getName(), 1));
        View r105 = r103.itemView.findViewById(R.id.detail_attachment_more);
        if (r101 != 2) goto L15;
        CommentAttachmentAdapter r106 = r103.f442841a;
        if (r106.f442840c.size() > 3) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r107 == false) goto L15;
    L16:
        com.larksuite.framework.section.utils.a.d(r105, r104);
        TextView r108 = (TextView) r103.itemView.findViewById(R.id.detail_attachment_more);
        com.ss.android.lark.todo.impl.utils.i r109 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        r108.setText(com.ss.android.lark.todo.impl.utils.i.d(R.string.Todo_ViewMoreAttachments_Button, "num", String.valueOf(r103.f442841a.f442840c.size() - 3)));
        ((LinearLayout) r103.itemView.findViewById(R.id.layout_attachment_item)).setOnClickListener(new o(r102));
        ((TextView) r103.itemView.findViewById(R.id.detail_attachment_more)).setOnClickListener(new p(r103.f442841a));
        return;
    L10:
        if (r106.f442838a == true) goto L12;
        r107 = true;
    L15:
        r104 = false;
        goto L16
    L19:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_comment_item_attachment, r100, false);
        Intrinsics.checkNotNull(r102);
        return new AttachmentViewHolder(this, r102);
    }

    public CommentAttachmentAdapter(List<TodoAttachmentData> r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "attachmentDataList");
        Intrinsics.checkNotNullParameter(r102, "expandClick");
        this.f442838a = r101;
        this.f442839b = r102;
        this.f442840c = r100;
    }
}
