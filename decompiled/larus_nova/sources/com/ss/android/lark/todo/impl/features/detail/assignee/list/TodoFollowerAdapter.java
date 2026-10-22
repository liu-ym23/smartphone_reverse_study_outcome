package com.ss.android.lark.todo.impl.features.detail.assignee.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.p;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001b\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoFollowerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoFollowerAdapter$ViewHolder;", "viewAbility", "Lcom/larksuite/framework/section/IViewAbility;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/ITodoDetailViewDataStore;", "<init>", "(Lcom/larksuite/framework/section/IViewAbility;)V", "followerList", "", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/FollowerBean;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "deleteDialog", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "listener", "Lcom/larksuite/component/universe_design/dialog/UDListDialogController$OnItemClickListener;", "showDeleteSelfDialog", "updateData", "list", "AvatarBuilder", "ViewHolder", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoFollowerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.framework.section.e<p> f442690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.ss.android.lark.todo.impl.features.detail.viewmodel.i> f442691b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/list/TodoFollowerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f442692a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442692a = r100;
        }
    }

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoFollowerAdapter f442693a;

        public a(TodoFollowerAdapter r100) {
            this.f442693a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List<com.ss.android.lark.todo.impl.features.detail.viewmodel.i> r101 = (List) r100;
            TodoFollowerAdapter r102 = this.f442693a;
            Intrinsics.checkNotNull(r101);
            r102.f442691b = r101;
            r102.notifyDataSetChanged();
        }
    }

    public static final class b extends AvatarModel.a<b> {
        public b() {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442691b.size();
    }

    public TodoFollowerAdapter(com.larksuite.framework.section.e<p> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAbility");
        this.f442690a = r100;
        this.f442691b = new ArrayList();
        r100.a().getFollowers().observe(r100.b(), new a(this));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        com.ss.android.lark.todo.impl.features.detail.viewmodel.i r103 = (com.ss.android.lark.todo.impl.features.detail.viewmodel.i) ListProtector.get(this.f442691b, r101);
        LarkAvatarView r104 = (LarkAvatarView) r102.f442692a.findViewById(R.id.user_avatar);
        b r105 = new b();
        r105.b(r103.f443885c);
        r105.f(r103.f443883a);
        r104.j(new AvatarModel(r105));
        ((TextView) r102.f442692a.findViewById(R.id.user_name)).setText(r103.f443884b);
        if (r103.f443886d == false) goto L5;
        ImageView r106 = (ImageView) r102.f442692a.findViewById(R.id.user_delete);
        r106.setVisibility(0);
        r106.setBackground(UDIconUtils.getIconDrawable(r102.f442692a.getContext(), R.drawable.ud_icon_close_outlined, com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.icon_n1)));
        r106.setOnClickListener(new m(r103, this, r106));
    L6:
        r102.f442692a.setOnClickListener(new n(r102, r103));
        return;
    L5:
        ((ImageView) r102.f442692a.findViewById(R.id.user_delete)).setVisibility(8);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_assginee_fragment_item, r100, false);
        com.ss.android.lark.todo.impl.utils.b.a(r102.findViewById(R.id.user_delete), UIUtils.dp2px(r100.getContext(), 16.0f));
        return new ViewHolder(r102);
    }
}
