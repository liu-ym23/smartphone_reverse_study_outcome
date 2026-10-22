package com.ss.android.lark.todo.impl.features.detail.assignee.display;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.utils.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0014\u0010\u0018\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter$ViewHolder;", "enableDelete", "", "listener", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter$AssigneeDisplayAdapterListener;", "<init>", "(ZLcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter$AssigneeDisplayAdapterListener;)V", "getListener", "()Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter$AssigneeDisplayAdapterListener;", "userList", "", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/UserBean;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "updateData", "list", "AvatarBuilder", "ViewHolder", "AssigneeDisplayAdapterListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoAssigneeDisplayAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f442629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f442630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<UserBean> f442631c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/display/TodoAssigneeDisplayAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f442632a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442632a = r100;
        }
    }

    public interface a {
        void a(String r100);

        void b(UserBean r100, View r101);
    }

    public static final class b extends AvatarModel.a<b> {
        public b() {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442631c.size();
    }

    public TodoAssigneeDisplayAdapter(boolean r100, TodoAssigneeDisplayFragment$mAdapter$2.a r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f442629a = r100;
        this.f442630b = r101;
        this.f442631c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        UserBean r103 = (UserBean) ListProtector.get(this.f442631c, r101);
        LarkAvatarView r104 = (LarkAvatarView) r102.f442632a.findViewById(R.id.user_avatar);
        b r105 = new b();
        r105.b(r103.getAvatarKey());
        r105.f(r103.getId());
        r104.j(new AvatarModel(r105));
        ((TextView) r102.f442632a.findViewById(R.id.user_name)).setText(r103.getName());
        if (TextUtils.isEmpty(r103.getDepartment()) == false) goto L5;
        ((TextView) r102.f442632a.findViewById(R.id.user_department)).setVisibility(8);
    L7:
        if (this.f442629a == false) goto L9;
        ImageView r106 = (ImageView) r102.f442632a.findViewById(R.id.user_delete);
        r106.setVisibility(0);
        r106.setBackground(UDIconUtils.getIconDrawable(r102.f442632a.getContext(), R.drawable.ud_icon_close_outlined, i.f444291a.a(R.color.icon_n1)));
        r106.setOnClickListener(new com.ss.android.lark.todo.impl.features.detail.assignee.display.a(this, r103));
    L10:
        r102.f442632a.setOnClickListener(new com.ss.android.lark.todo.impl.features.detail.assignee.display.b(this, r103));
        return;
    L9:
        ((ImageView) r102.f442632a.findViewById(R.id.user_delete)).setVisibility(8);
        goto L10
    L5:
        ((TextView) r102.f442632a.findViewById(R.id.user_department)).setVisibility(0);
        ((TextView) r102.f442632a.findViewById(R.id.user_department)).setText(r103.getDepartment());
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_assginee_fragment_item, r100, false);
        com.ss.android.lark.todo.impl.utils.b.a(r102.findViewById(R.id.user_delete), UIUtils.dp2px(r100.getContext(), 16.0f));
        return new ViewHolder(r102);
    }
}
