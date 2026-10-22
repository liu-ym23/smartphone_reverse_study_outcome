package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larksuite.framework.utils.FileUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoAttachmentData;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0014B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailAttachmentAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAttachmentData;", "Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailAttachmentAdapter$AttachmentViewHolder;", "viewAbility", "Lcom/larksuite/framework/section/IViewAbility;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/ITodoDetailViewDataStore;", "<init>", "(Lcom/larksuite/framework/section/IViewAbility;)V", "isCreateTodo", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "AttachmentViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetailAttachmentAdapter extends ListAdapter<TodoAttachmentData, AttachmentViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f443172a;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailAttachmentAdapter$AttachmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailAttachmentAdapter;Landroid/view/View;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAttachmentData;", "initViewAction", "showDeleteDialog", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AttachmentViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f443173b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailAttachmentAdapter f443174a;

        public AttachmentViewHolder(DetailAttachmentAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f443174a = r100;
            super(r101);
        }
    }

    public DetailAttachmentAdapter(com.larksuite.framework.section.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAbility");
        super(new AnonymousClass1());
        this.f443172a = r100;
        ((com.ss.android.lark.todo.impl.features.detail.viewmodel.p) r100.f285689b).getTodoDataLiveData().observe(r100.b(), new q(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        AttachmentViewHolder r102 = (AttachmentViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        TodoAttachmentData r103 = getItem(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        String r104 = r103.getFileToken();
        boolean r105 = false;
        if (r104 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        boolean r107 = !r106;
        ((TextView) r102.itemView.findViewById(R.id.text_attachment_name)).setText(r103.getName());
        ((TextView) r102.itemView.findViewById(R.id.text_attachment_size)).setTextColor(UIHelper.getColor(R.color.text_placeholder));
        if (r107 == false) goto L13;
        ((TextView) r102.itemView.findViewById(R.id.text_attachment_size)).setText(FileUtils.h(CastLongProtector.parseLong(r103.getFileSize())));
    L16:
        ((AppCompatImageView) r102.itemView.findViewById(R.id.image_attachment_icon)).setImageResource(com.ss.android.lark.utils.a0.b(FileUtils.p(r103.getName()), r103.getName(), 1));
        ViewGroup.LayoutParams r108 = ((AppCompatImageView) r102.itemView.findViewById(R.id.button_attachment_delete)).getLayoutParams();
        r108.width = com.ss.android.lark.todo.impl.utils.m.a(44);
        r108.height = com.ss.android.lark.todo.impl.utils.m.a(44);
        com.larksuite.framework.section.utils.a.d(r102.itemView.findViewById(R.id.button_attachment_delete), r103.getCanDelete());
        if (r107 == false) goto L19;
        ((AppCompatImageView) r102.itemView.findViewById(R.id.button_attachment_delete)).setImageResource(R.drawable.ud_icon_delete_trash_outlined);
    L20:
        View r109 = r102.itemView.findViewById(R.id.progressbar_attachment);
        String r110 = r103.getFileToken();
        if (r110 != null) goto L23;
    L26:
        boolean r111 = true;
    L27:
        if (r111 == true) goto L29;
    L31:
        com.larksuite.framework.section.utils.a.d(r109, r105);
        ((UDProgress) r102.itemView.findViewById(R.id.progressbar_attachment)).setProgress((int) ((r103.getBytesTransferred() / r103.getBytesTotal()) * 100));
        ViewGroup.LayoutParams r112 = ((AppCompatImageView) r102.itemView.findViewById(R.id.button_attachment_retry)).getLayoutParams();
        r112.width = com.ss.android.lark.todo.impl.utils.m.a(44);
        r112.height = com.ss.android.lark.todo.impl.utils.m.a(44);
        com.larksuite.framework.section.utils.a.d(r102.itemView.findViewById(R.id.button_attachment_retry), r103.getStatusFail());
        if (r103.getStatusFail() == false) goto L34;
        ((LKUIRoundableLayout) r102.itemView.findViewById(R.id.layout_attachment_container)).setBackgroundResource(R.drawable.todo_attachment_background_fail);
    L35:
        ((LinearLayout) r102.itemView.findViewById(R.id.layout_attachment_item)).setOnClickListener(new r(r103, r102.f443174a));
        ((AppCompatImageView) r102.itemView.findViewById(R.id.button_attachment_delete)).setOnClickListener(new s(r102.f443174a, r102, r103));
        ((AppCompatImageView) r102.itemView.findViewById(R.id.button_attachment_retry)).setOnClickListener(new t(r102.f443174a, r103));
        return;
    L34:
        ((LKUIRoundableLayout) r102.itemView.findViewById(R.id.layout_attachment_container)).setBackgroundResource(R.drawable.todo_attachment_background);
        goto L35
    L29:
        if (r103.getStatusFail() == true) goto L31;
        r105 = true;
        goto L31
    L23:
        if (r110.length() == 0) goto L26;
        r111 = false;
        goto L27
    L19:
        ((AppCompatImageView) r102.itemView.findViewById(R.id.button_attachment_delete)).setImageResource(R.drawable.ud_icon_close_outlined);
        goto L20
    L13:
        if (r103.getStatusFail() == false) goto L15;
        ((TextView) r102.itemView.findViewById(R.id.text_attachment_size)).setTextColor(UIHelper.getColor(R.color.function_danger_fill_default));
        ((TextView) r102.itemView.findViewById(R.id.text_attachment_size)).setText(R.string.Todo_TaskAttachment_UnableToUpload_Label);
        goto L16
    L15:
        ((TextView) r102.itemView.findViewById(R.id.text_attachment_size)).setText(FileUtils.h(r103.getBytesTransferred()) + " / " + FileUtils.h(r103.getBytesTotal()));
        goto L16
    L5:
        if (r104.length() == 0) goto L8;
        r106 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_item_attachment, r100, false);
        Intrinsics.checkNotNull(r102);
        return new AttachmentViewHolder(this, r102);
    }
}
