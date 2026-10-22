package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.todo.v1.TaskItemMember;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TodoChat;
import com.bytedance.lark.pb.todo.v1.TodoDoc;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.AvatarModel;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z7c.p;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004+,-.B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u001dH\u0016J\u0014\u0010&\u001a\u00020\u001f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100(J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter$ViewHolder;", "operatorRole", "Lcom/bytedance/lark/pb/todo/v1/TodoItemMemberRole;", "isInvitePanel", "", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/TodoItemMemberRole;Z)V", "()Z", "operatorId", "", "getOperatorId", "()Ljava/lang/String;", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/bytedance/lark/pb/todo/v1/TaskListMember;", "adapterListener", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter$ITaskListMemberListener;", "getAdapterListener", "()Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter$ITaskListMemberListener;", "setAdapterListener", "(Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter$ITaskListMemberListener;)V", "dialogListener", "Lcom/ss/android/lark/todo/impl/features/common/dialog/TaskListMemberDialogBuilder$TaskListMemberDialogListener;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "bindRoleView", MapController.ITEM_LAYER_TAG, "bindMemberView", "getItemCount", "updateData", "data", "", "updateOperatorRole", "role", "Companion", "AvatarBuilder", "ViewHolder", "ITaskListMemberListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListMembersAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TaskListMembersAdapter$Companion$DIFF_CALLBACK$1 f442185f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TodoItemMemberRole f442186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f442187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncListDiffer<TaskListMember> f442188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f442189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f442190e;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TaskListMembersAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f442191a;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f442191a = r100;
        }
    }

    public static final class a extends AvatarModel.a<a> {
        public a() {
        }
    }

    public static final class b {
    }

    public interface c {
        void a(TodoItemMemberRole r100, String r101);

        void b(String r100);
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442192a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f442193b = null;

        static {
            int[] r100 = new int[TodoItemMemberRole.values().length];
            r100[TodoItemMemberRole.OWNER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[TodoItemMemberRole.WRITER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[TodoItemMemberRole.READER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[TodoItemMemberRole.INHERIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f442192a = r100;
            int[] r101 = new int[TodoItemMemberType.values().length];
            r101[TodoItemMemberType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[TodoItemMemberType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[TodoItemMemberType.DOCS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f442193b = r101;
        }
    }

    public static final class e implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TaskListMembersAdapter f442194a;

        public e(TaskListMembersAdapter r100) {
            this.f442194a = r100;
        }

        @Override // z7c.p.a
        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "memberId");
            c r101 = this.f442194a.f442189d;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        @Override // z7c.p.a
        public final void a(TodoItemMemberRole r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "role");
            Intrinsics.checkNotNullParameter(r101, "memberId");
            c r102 = this.f442194a.f442189d;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.todo.impl.features.chatlist.adapter.TaskListMembersAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f442185f = new TaskListMembersAdapter$Companion$DIFF_CALLBACK$1();
    }

    public TaskListMembersAdapter() {
        this(TodoItemMemberRole.NONE, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442188c.getCurrentList().size();
    }

    public TaskListMembersAdapter(TodoItemMemberRole r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "operatorRole");
        this.f442186a = r100;
        this.f442187b = r101;
        TodoDependencyHolder.a().loginDependency().getUserId();
        this.f442188c = new AsyncListDiffer(this, f442185f);
        this.f442190e = new e(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        ViewHolder r112 = (ViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        TaskListMember r113 = (TaskListMember) ListProtector.get(this.f442188c.getCurrentList(), r111);
        Intrinsics.checkNotNull(r113);
        TaskItemMember r100 = r113.member;
        if (r100 == null) goto L5;
        TodoItemMemberType r101 = r100.type;
    L6:
        int r102 = -1;
        if (r101 != null) goto L9;
        int r103 = -1;
    L10:
        int r104 = 8;
        if (r103 == 1) goto L56;
        if (r103 == 2) goto L37;
        if (r103 != 3) goto L75;
        LarkAvatarView r105 = (LarkAvatarView) r112.f442191a.findViewById(R.id.collaborator_avatar);
        a r114 = new a();
        r114.d(kac.a.b(R.drawable.ud_icon_wiki_doc_circle_colorful));
        r105.j(new AvatarModel(r114));
        TextView r106 = (TextView) r112.f442191a.findViewById(R.id.collaborator_name);
        TaskItemMember r107 = r113.member;
        if (r107 == null) goto L35;
        TodoDoc r115 = r107.f253777doc;
        if (r115 == null) goto L20;
        String r116 = r115.name;
    L21:
        if (r116 != null) goto L23;
    L26:
        boolean r117 = true;
    L27:
        if (r117 == false) goto L36;
        TodoDoc r108 = r107.f253777doc;
        if (r108 == null) goto L31;
        boolean r109 = Intrinsics.areEqual(r108.has_permission, Boolean.TRUE);
    L32:
        if (r109 == false) goto L34;
        r116 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Doc_UntitledDocument_Title);
        goto L36
    L34:
        r116 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Activities_DocNameUnauthorized_Text);
        goto L36
    L31:
        r109 = false;
    L36:
        r106.setText(r116);
        r112.f442191a.findViewById(R.id.collaborator_avatar).setOnClickListener(new com.ss.android.lark.todo.impl.features.chatlist.adapter.b(r112, r113));
        goto L75
    L23:
        if (r116.length() == 0) goto L26;
        r117 = false;
        goto L27
    L20:
        r116 = null;
        goto L21
    L35:
        r116 = null;
    L75:
        TextView r118 = (TextView) r112.f442191a.findViewById(R.id.collaborator_role_tv);
        TodoItemMemberRole r119 = r113.role;
        if (r119 != null) goto L78;
        int r120 = -1;
    L80:
        if (r120 == 1) goto L88;
        if (r120 == 2) goto L87;
        if (r120 == 3) goto L86;
        if (r120 == 4) goto L85;
        String r121 = "";
    L89:
        r118.setText(r121);
        ImageView r122 = (ImageView) r112.f442191a.findViewById(R.id.collaborator_role_icon);
        TodoItemMemberRole r123 = r113.role;
        if (r123 == null) goto L93;
        r102 = d.f442192a[r123.ordinal()];
    L93:
        if (r102 == 1) goto L106;
        if (r102 == 2) goto L101;
        if (r102 == 3) goto L99;
        if (r102 == 4) goto L101;
    L105:
        r104 = 0;
        goto L106
    L99:
        if (this.f442186a == TodoItemMemberRole.NONE) goto L106;
    L101:
        TodoItemMemberRole r124 = this.f442186a;
        if (r124 == TodoItemMemberRole.WRITER) goto L105;
        if (r124 == TodoItemMemberRole.OWNER) goto L105;
    L106:
        r122.setVisibility(r104);
        if (((ImageView) r112.f442191a.findViewById(R.id.collaborator_role_icon)).getVisibility() != 0) goto L109;
        r112.f442191a.findViewById(R.id.collaborator_more).setOnClickListener(new com.ss.android.lark.todo.impl.features.chatlist.adapter.c(r112, r113, this));
        return;
    L109:
        ((RelativeLayout) r112.f442191a.findViewById(R.id.collaborator_more)).setOnClickListener(null);
        return;
    L85:
        r121 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_Doc_FollowDocsPermissions_Button);
        goto L89
    L86:
        r121 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_ShareList_ManageCollaboratorsCanView_Text);
        goto L89
    L87:
        r121 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_ShareList_ManageCollaboratorsCanEdit_Text);
        goto L89
    L88:
        r121 = com.ss.android.lark.todo.impl.utils.i.f444291a.g(R.string.Todo_ShareList_ManageCollaboratorsCanManage_Text);
        goto L89
    L78:
        r120 = d.f442192a[r119.ordinal()];
        goto L80
    L37:
        LarkAvatarView r125 = (LarkAvatarView) r112.f442191a.findViewById(R.id.collaborator_avatar);
        a r126 = new a();
        TaskItemMember r127 = r113.member;
        if (r127 == null) goto L42;
        TodoChat r128 = r127.chat;
        if (r128 == null) goto L42;
        String r129 = r128.avatar_key;
    L43:
        r126.b(r129);
        TaskItemMember r130 = r113.member;
        if (r130 == null) goto L48;
        TodoChat r131 = r130.chat;
        if (r131 == null) goto L48;
        String r132 = r131.chat_id;
    L49:
        r126.f(r132);
        r125.j(new AvatarModel(r126));
        TextView r133 = (TextView) r112.f442191a.findViewById(R.id.collaborator_name);
        TaskItemMember r134 = r113.member;
        if (r134 == null) goto L54;
        TodoChat r135 = r134.chat;
        if (r135 == null) goto L54;
        String r136 = r135.name;
    L55:
        r133.setText(r136);
        ((TextView) r112.f442191a.findViewById(R.id.collaborator_department)).setVisibility(8);
    L54:
        r136 = null;
    L48:
        r132 = null;
    L42:
        r129 = null;
        goto L43
    L56:
        LarkAvatarView r137 = (LarkAvatarView) r112.f442191a.findViewById(R.id.collaborator_avatar);
        a r138 = new a();
        TaskItemMember r139 = r113.member;
        if (r139 == null) goto L61;
        TodoUser r140 = r139.user;
        if (r140 == null) goto L61;
        String r141 = r140.avatar_key;
    L62:
        r138.b(r141);
        TaskItemMember r142 = r113.member;
        if (r142 == null) goto L67;
        TodoUser r143 = r142.user;
        if (r143 == null) goto L67;
        String r144 = r143.user_id;
    L68:
        r138.f(r144);
        r137.j(new AvatarModel(r138));
        TextView r145 = (TextView) r112.f442191a.findViewById(R.id.collaborator_name);
        TaskItemMember r146 = r113.member;
        if (r146 == null) goto L73;
        TodoUser r147 = r146.user;
        if (r147 == null) goto L73;
        String r148 = r147.name;
    L74:
        r145.setText(r148);
        r112.f442191a.findViewById(R.id.collaborator_avatar).setOnClickListener(new com.ss.android.lark.todo.impl.features.chatlist.adapter.a(r112, r113));
    L73:
        r148 = null;
    L67:
        r144 = null;
    L61:
        r141 = null;
        goto L62
    L9:
        r103 = d.f442193b[r101.ordinal()];
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.task_list_member_item, r100, false));
    }
}
