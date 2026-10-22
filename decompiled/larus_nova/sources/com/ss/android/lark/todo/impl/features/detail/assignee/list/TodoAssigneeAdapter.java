package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.dialog.UDListDialogController;
import com.larksuite.component.universe_design.dialog.actionpanel.UDActionPanelBuilder;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.AssigneeBean;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\"#$B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0014\u0010\u001f\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter$ViewHolder;", "listener", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter$AssigneeAdapterListener;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter$AssigneeAdapterListener;)V", "assigneeList", "", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/AssigneeBean;", "getAssigneeList", "()Ljava/util/List;", "setAssigneeList", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "deleteDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "showDeleteSelfDialog", "showMoreDialog", MapController.ITEM_LAYER_TAG, "updateData", "list", "assigneeMarkComplete", "AvatarBuilder", "ViewHolder", "AssigneeAdapterListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoAssigneeAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f442671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<AssigneeBean> f442672b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoAssigneeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f442673a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442673a = r100;
        }
    }

    public interface a {
        void a(com.ss.android.lark.todo.impl.features.detail.viewmodel.c r100);

        void b(String r100);

        void c(String r100);
    }

    public static final class b extends AvatarModel.a<b> {
        public b() {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442672b.size();
    }

    public TodoAssigneeAdapter(a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f442671a = r100;
        this.f442672b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        AssigneeBean r103 = (AssigneeBean) ListProtector.get(this.f442672b, r101);
        LarkAvatarView r104 = (LarkAvatarView) r102.f442673a.findViewById(R.id.user_avatar);
        b r105 = new b();
        r105.b(r103.getAvatarKey());
        r105.f(r103.getId());
        r104.j(new AvatarModel(r105));
        ((TextView) r102.f442673a.findViewById(R.id.user_name)).setText(r103.getName());
        r102.f442673a.setOnClickListener(new com.ss.android.lark.todo.impl.features.detail.assignee.list.a(r102, r103));
        int r106 = r103.getDeleteState();
        if (r106 != 0) goto L5;
        ((LinearLayout) r102.f442673a.findViewById(R.id.user_more)).setVisibility(8);
        ImageView r107 = (ImageView) r102.f442673a.findViewById(R.id.user_delete);
        r107.setVisibility(0);
        r107.setBackground(UDIconUtils.getIconDrawable(r102.f442673a.getContext(), R.drawable.ud_icon_close_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n1)));
        r107.setOnClickListener(new c(r103, this, r107));
        return;
    L5:
        if (r106 != 1) goto L7;
        ((LinearLayout) r102.f442673a.findViewById(R.id.user_more)).setVisibility(8);
        ImageView r108 = (ImageView) r102.f442673a.findViewById(R.id.user_delete);
        r108.setVisibility(0);
        r108.setBackground(UDIconUtils.getIconDrawable(r102.f442673a.getContext(), R.drawable.ud_icon_close_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n3)));
        r108.setOnClickListener(com.ss.android.lark.todo.impl.features.detail.assignee.list.b.f442696a);
        return;
    L7:
        if (r106 != 2) goto L9;
        ((LinearLayout) r102.f442673a.findViewById(R.id.user_more)).setVisibility(8);
        ((ImageView) r102.f442673a.findViewById(R.id.user_delete)).setVisibility(8);
        return;
    L9:
        if (r106 != 3) goto L11;
        ((ImageView) r102.f442673a.findViewById(R.id.user_delete)).setVisibility(8);
        LinearLayout r109 = (LinearLayout) r102.f442673a.findViewById(R.id.user_more);
        r109.setVisibility(0);
        r109.setOnClickListener(new d(this, r109, r103));
        return;
    L11:
        if (r106 != 4) goto L23;
        ((ImageView) r102.f442673a.findViewById(R.id.user_delete)).setVisibility(8);
        LinearLayout r110 = (LinearLayout) r102.f442673a.findViewById(R.id.user_more);
        r110.setVisibility(0);
        r110.setOnClickListener(new e(r103, this, r110));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_assginee_fragment_item, r100, false);
        com.ss.android.lark.todo.impl.utils.b.a(r102.findViewById(R.id.user_delete), UIUtils.dp2px(r100.getContext(), 16.0f));
        return new ViewHolder(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void y2(TodoAssigneeAdapter r100, Context r101, UDListDialogController.OnItemClickListener r102) {
        r100.getClass();
        UDActionPanelBuilder r103 = new UDActionPanelBuilder(r101);
        com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        ((UDActionPanelBuilder) r103.items(Collections.singletonList(r104.g(R.string.Todo_RemoveOwner_Button))).itemClickListener(r102).addActionButton(R.id.ud_dialog_btn_cancel, r104.g(R.string.Todo_Common_Cancel), null)).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void z2(TodoAssigneeAdapter r100, Context r101, UDListDialogController.OnItemClickListener r102) {
        r100.getClass();
        UDActionPanelBuilder r103 = new UDActionPanelBuilder(r101);
        com.ss.android.lark.todo.impl.utils.i r104 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        ((UDActionPanelBuilder) ((UDActionPanelBuilder) r103.title(r104.g(R.string.Todo_Task_RemoveOneselfFromAssigneesDialogContent))).items(Collections.singletonList(r104.g(R.string.Todo_Task_RemoveOneselfFromAssigneesRemoveButton))).itemClickListener(r102).addActionButton(R.id.ud_dialog_btn_cancel, r104.g(R.string.Todo_Common_Cancel), null)).show();
    }
}
