package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.pb.todo.v1.TodoAssignee;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.blockit.hashtag.widget.SwipeLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.chatlist.item.TodoDisplayItem;
import com.ss.android.lark.todo.impl.features.chatlist.mvvm.TodoChatListFragment;
import com.ss.android.lark.todo.impl.features.chatlist.mvvm.TodoChatListViewModel;
import com.ss.android.lark.todo.impl.features.common.helper.MultiCompleteHelper;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.LKUILightTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003*+,B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u001f\u001a\u00020\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010!J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0018H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter;", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/PinnedHeaderAdapter;", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatItemViewHolder;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListViewModel;", "<init>", "(Landroidx/fragment/app/Fragment;Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListViewModel;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "operationListener", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter$ITitleOperationListener;", "getOperationListener$todo_productionChinaRelease", "()Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter$ITitleOperationListener;", "setOperationListener$todo_productionChinaRelease", "(Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter$ITitleOperationListener;)V", "mDiffer", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/ss/android/lark/todo/impl/features/chatlist/item/TodoDisplayItem;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getSwipeLayoutResourceId", "resetAll", "newList", "", "isPinnedPosition", "", "pinnedHeaderClick", "firstVisiblePos", "getItem", "", "getPinnedHeaderViewPosition", "isPositionInvalid", "Companion", "ITitleClickListener", "ITitleOperationListener", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoChatListAdapter extends PinnedHeaderAdapter<TodoChatItemViewHolder> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TodoChatListAdapter$Companion$DIFF_CALLBACK$1 f442203f = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f442204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TodoChatListViewModel f442205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f442206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AsyncListDiffer<TodoDisplayItem> f442207e;

    public static final class a {
    }

    public interface b {
        void a(TodoDisplayItem.ChatListTitleType r100);
    }

    public interface c {
        void a(TodoDisplayItem.ChatListTitleType r100, boolean r101);
    }

    @Override // py7.a
    public final int B0() {
        return R.id.swipeLayout;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.todo.impl.features.chatlist.adapter.TodoChatListAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f442203f = new TodoChatListAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f442207e.getCurrentList().size();
    }

    @Override // com.ss.android.lark.todo.impl.features.chatlist.adapter.PinnedHeaderAdapter
    public final boolean A2(int r100) {
        if (r100 != (-1)) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return false;
    L12:
        return ((TodoDisplayItem) ListProtector.get(this.f442207e.getCurrentList(), r100)).f442255r;
    L5:
        if (r100 >= getItemCount()) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.ss.android.lark.todo.impl.features.chatlist.adapter.PinnedHeaderAdapter
    public final void B2(int r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        if ((-1) >= r100) goto L10;
        if (A2(r100) == true) goto L12;
        r100 = r100 - 1;
    L12:
        if (r100 != (-1)) goto L14;
    L17:
        boolean r101 = true;
    L18:
        if (r101 == false) goto L20;
        return;
    L20:
        TodoDisplayItem r102 = (TodoDisplayItem) ListProtector.get(this.f442207e.getCurrentList(), r100);
        if (r102.f442255r == false) goto L28;
        c r103 = this.f442206d;
        if (r103 == null) goto L29;
        r103.a(r102.f442257t, !r102.f442258u);
        return;
    L29:
        return;
    L28:
        return;
    L14:
        if (r100 >= getItemCount()) goto L17;
        r101 = false;
        goto L18
    L10:
        r100 = -1;
        goto L12
    }

    public TodoChatListAdapter(TodoChatListFragment r100, TodoChatListViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        this.f442204b = r100;
        this.f442205c = r101;
        this.f442207e = new AsyncListDiffer(this, f442203f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, int r211) {
        TodoChatItemViewHolder r100 = (TodoChatItemViewHolder) r210;
        Intrinsics.checkNotNullParameter(r100, "holder");
        if (r211 != (-1)) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L126;
        TodoDisplayItem r102 = (TodoDisplayItem) ListProtector.get(this.f442207e.getCurrentList(), r211);
        ((SwipeLayout) r100.f442199a.findViewById(R.id.swipeLayout)).setSwipeEnabled(false);
        ((SwipeLayout) r100.f442199a.findViewById(R.id.swipeLayout)).setShowMode(SwipeLayout.ShowMode.LayDown);
        r100.f442201c = new j(r102, this);
        TodoChatListViewModel r103 = this.f442205c;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r103, "viewModel");
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        String r110 = "";
        if (r102.f442255r == false) goto L26;
        ((LinearLayout) r100.f442199a.findViewById(R.id.content_title_view)).setVisibility(0);
        LinearLayout r104 = (LinearLayout) r100.f442199a.findViewById(R.id.content_title_view);
        com.ss.android.lark.todo.impl.utils.i r105 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r102.f442258u == false) goto L16;
        int r106 = R.drawable.todo_main_fragment_title_bg_round_top;
    L17:
        r104.setBackground(r105.c(r106));
        ((LinearLayout) r100.f442199a.findViewById(R.id.content_container_view)).setVisibility(8);
        if (r102.f442258u == false) goto L20;
        int r107 = R.drawable.ud_icon_expand_down_filled;
    L21:
        ((ImageView) r100.f442199a.findViewById(R.id.list_icon_img)).setImageDrawable(UDIconUtils.getIconDrawable(r100.f442199a.getContext(), r107, UIUtils.getColor(r100.f442199a.getContext(), R.color.icon_n2)));
        ((TextView) r100.f442199a.findViewById(R.id.list_icon_title_tv)).setText(r102.f442259v);
        TextView r108 = (TextView) r100.f442199a.findViewById(R.id.list_icon_count_tv);
        if (r102.f442257t == TodoDisplayItem.ChatListTitleType.COMPLETED) goto L25;
        r110 = String.valueOf(r102.f442260w);
    L25:
        r108.setText(r110);
        ((LinearLayout) r100.f442199a.findViewById(R.id.content_title_view)).setOnClickListener(new d(r100, r102));
    L119:
        if (r102.f442255r == true) goto L125;
        this.f283058a.a(r100.itemView, r211);
        return;
    L125:
        return;
    L20:
        r107 = R.drawable.ud_icon_expand_right_filled;
        goto L21
    L16:
        r106 = R.drawable.todo_main_fragment_title_bg_round;
        goto L17
    L26:
        ((LinearLayout) r100.f442199a.findViewById(R.id.content_title_view)).setVisibility(8);
        ((LinearLayout) r100.f442199a.findViewById(R.id.content_container_view)).setVisibility(0);
        View r109 = r100.f442199a;
        ViewGroup.LayoutParams r111 = ((SwipeLayout) r109.findViewById(R.id.swipeLayout)).getLayoutParams();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;
        ViewGroup.LayoutParams r113 = r109.findViewById(R.id.divider_todo_item).getLayoutParams();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r113;
        boolean r115 = r102.B;
        if (r115 == true) goto L29;
    L31:
        if (r115 == false) goto L35;
        r112.setMargins(0, TodoChatItemViewHolder.f442195e, 0, 0);
        r114.setMargins(TodoChatItemViewHolder.f442197g, 0, 0, 0);
        ((LinearLayout) r109.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.bg_setting_group_item_round_top));
        r109.findViewById(R.id.divider_todo_item).setVisibility(0);
    L41:
        ((SwipeLayout) r109.findViewById(R.id.swipeLayout)).setLayoutParams(r112);
        r109.findViewById(R.id.divider_todo_item).setLayoutParams(r114);
        ViewGroup.LayoutParams r116 = ((RelativeLayout) r100.f442199a.findViewById(R.id.complete_checkbox_container)).getLayoutParams();
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r117 = (LinearLayout.LayoutParams) r116;
        if (r102.K == false) goto L44;
        int r118 = 16;
    L45:
        r117.gravity = r118;
        ((RelativeLayout) r100.f442199a.findViewById(R.id.complete_checkbox_container)).setLayoutParams(r117);
        View r119 = r100.f442199a;
        b8c.b r120 = (b8c.b) r100.f442202d.getValue();
        h r121 = new h(r102, r103, r119, r100);
        r120.getClass();
        Intrinsics.checkNotNullParameter(r121, "listener");
        r120.f18243b = r121;
        ((LinearLayout) r119.findViewById(R.id.content_container_view)).setOnClickListener((b8c.b) r100.f442202d.getValue());
        r119.findViewById(R.id.item_finish_line).setVisibility(r102.M);
        ((LinearLayout) r119.findViewById(R.id.ll_end_time)).setVisibility(r102.L);
        if (r102.f442241d == false) goto L48;
        ((ImageView) r119.findViewById(R.id.img_end_time)).setImageDrawable(UDIconUtils.getIconDrawable(r119.getContext(), R.drawable.ud_icon_calendar_done_outlined, r102.f442246i));
    L49:
        ((TextView) r119.findViewById(R.id.tv_end_time)).setText(r102.f442245h);
        ((TextView) r119.findViewById(R.id.tv_end_time)).setTextColor(r102.f442246i);
        com.larksuite.framework.section.utils.a.d(r119.findViewById(R.id.todo_repeat_status), r102.H);
        com.larksuite.framework.section.utils.a.d(r119.findViewById(R.id.todo_reminder_status), r102.I);
        Drawable r122 = UDIconUtils.getIconDrawable(r119.getContext(), R.drawable.ud_icon_bell_outlined, r102.f442246i);
        Drawable r123 = UDIconUtils.getIconDrawable(r119.getContext(), R.drawable.ud_icon_repeat_outlined, r102.f442246i);
        ((ImageView) r119.findViewById(R.id.todo_reminder_status)).setImageDrawable(r122);
        ((ImageView) r119.findViewById(R.id.todo_repeat_status)).setImageDrawable(r123);
        ((TaskUDAvatarList) r119.findViewById(R.id.task_owners)).setVisibility(8);
        List<TodoAssignee> r124 = r102.E;
        if (r124 == null) goto L67;
        ((TaskUDAvatarList) r119.findViewById(R.id.task_owners)).setVisibility(0);
        TaskUDAvatarList r125 = (TaskUDAvatarList) r119.findViewById(R.id.task_owners);
        ArrayList r126 = new ArrayList();
        Iterator<T> r127 = r124.iterator();
    L53:
        if (r127.hasNext() == false) goto L66;
        TodoAssignee r128 = (TodoAssignee) r127.next();
        String r129 = r128.assignee_id;
        TodoAssignee.User r130 = r128.user;
        TodoUser r131 = r130.user;
        if (r131 == null) goto L58;
        String r132 = r131.avatar_key;
        if (r132 == null) goto L58;
    L60:
        if (r130.completed_milli_time.longValue() <= 0) goto L64;
        int r133 = MultiCompleteHelper.f442436a;
        if (MultiCompleteHelper.e(r102.f442262y, r102.f442263z) == false) goto L64;
        boolean r134 = true;
    L65:
        r126.add(new com.ss.android.lark.todo.impl.features.detail.sections.c(r129, r132, r134, 0));
    L64:
        r134 = false;
    L58:
        r132 = "";
        goto L60
    L66:
        r125.setAdapter(new i(r126));
    L67:
        View r135 = r100.f442199a;
        boolean r136 = r102.f442237J;
        ImageView r137 = (ImageView) r135.findViewById(R.id.complete_checkbox);
        if (r102.f442241d == false) goto L82;
        if (r102.f442250m == false) goto L76;
        ((RelativeLayout) r135.findViewById(R.id.complete_checkbox_container)).setEnabled(true);
        com.ss.android.lark.todo.impl.utils.i r138 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r136 == false) goto L74;
        int r139 = R.drawable.todo_svg_icon_milestone_checked_new;
    L75:
        Drawable r140 = r138.c(r139);
    L93:
        r137.setImageDrawable(r140);
        ((ImageView) r135.findViewById(R.id.complete_checkbox)).setScaleType(ImageView.ScaleType.CENTER);
        View r141 = r100.f442199a;
        com.ss.android.lark.todo.impl.utils.i r142 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r102.f442241d == false) goto L96;
        int r143 = R.color.text_caption;
    L97:
        int r144 = r142.a(r143);
        int r145 = (int) UIHelper.sp2px(16.0f);
        int r146 = (int) UIHelper.sp2px(20.0f);
        iec.g.a r147 = new iec.g.a();
        r147.f489531d.f489512a = false;
        iec.a r148 = r147.f489532e;
        r148.f489508a = true;
        r148.f489511d = r144;
        r147.b(new iec.f(r141.getContext(), r146, r145));
        iec.g r149 = r147.a();
        p8c.a.b(r102.f442239b);
        CharSequence r150 = com.ss.android.lark.widget.richtext.i.d(r102.f442239b, r149);
        boolean r151 = true;
        ((LKUILightTextView) r141.findViewById(R.id.title_rich_text)).setMaxLines(1);
        ((LKUILightTextView) r141.findViewById(R.id.title_rich_text)).setEllipsize(TextUtils.TruncateAt.END);
        ((LKUILightTextView) r141.findViewById(R.id.title_rich_text)).setTextColor(r144);
        ((LKUILightTextView) r141.findViewById(R.id.title_rich_text)).setTextSize(r145);
        LKUILightTextView r152 = (LKUILightTextView) r141.findViewById(R.id.title_rich_text);
        Intrinsics.checkNotNull(r150);
        r152.setContentText(r150);
        if (r102.f442237J == false) goto L100;
        ((RelativeLayout) r100.f442199a.findViewById(R.id.complete_checkbox_container)).setOnClickListener(new e(r103, r102, r100));
    L101:
        View r153 = r100.f442199a;
        v7c.a r154 = r102.f442254q;
        if (r154 != null) goto L104;
    L106:
        r151 = false;
    L108:
        if (r151 == false) goto L112;
        r153.findViewById(R.id.ll_message_divider).setVisibility(8);
        ((LinearLayout) r153.findViewById(R.id.ll_message_container)).setVisibility(8);
        int r155 = ((LinearLayout) r153.findViewById(R.id.ll_todo_content_container)).getHeight();
        int r156 = TodoChatItemViewHolder.f442198h;
        if (r155 >= r156) goto L119;
        ViewGroup.LayoutParams r157 = ((LinearLayout) r153.findViewById(R.id.ll_todo_content_container)).getLayoutParams();
        Intrinsics.checkNotNull(r157, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r158 = (LinearLayout.LayoutParams) r157;
        r158.height = r156;
        ((LinearLayout) r153.findViewById(R.id.ll_todo_content_container)).setLayoutParams(r158);
        goto L119
    L112:
        r153.findViewById(R.id.ll_message_divider).setVisibility(0);
        ((LinearLayout) r153.findViewById(R.id.ll_message_container)).setVisibility(0);
        TextView r159 = (TextView) r153.findViewById(R.id.tv_message_info);
        v7c.a r160 = r102.f442254q;
        if (r160 == null) goto L117;
        String r161 = r160.f553583b;
        if (r161 == null) goto L117;
        r110 = r161;
    L117:
        r159.setText(r110);
        ((LinearLayout) r153.findViewById(R.id.ll_message_container)).setOnClickListener(new f(r102, r153));
        goto L119
    L104:
        if (r154.f553582a == true) goto L106;
    L100:
        ((RelativeLayout) r100.f442199a.findViewById(R.id.complete_checkbox_container)).setOnClickListener(new g(r103, r102, r100));
        goto L101
    L96:
        r143 = R.color.text_title;
        goto L97
    L74:
        r139 = R.drawable.todo_svg_icon_checked_new;
        goto L75
    L76:
        ((RelativeLayout) r135.findViewById(R.id.complete_checkbox_container)).setEnabled(false);
        com.ss.android.lark.todo.impl.utils.i r162 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r136 == false) goto L79;
        int r163 = R.drawable.todo_svg_icon_milestone_disable_checked_new;
    L80:
        r140 = r162.c(r163);
        goto L93
    L79:
        r163 = R.drawable.todo_svg_icon_checked_dis_new;
        goto L80
    L82:
        if (r102.f442250m == true) goto L88;
        ((RelativeLayout) r135.findViewById(R.id.complete_checkbox_container)).setEnabled(false);
        com.ss.android.lark.todo.impl.utils.i r164 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r136 == false) goto L86;
        int r165 = R.drawable.todo_svg_icon_milestone_disable;
    L87:
        r140 = r164.c(r165);
        goto L93
    L86:
        r165 = R.drawable.todo_svg_icon_uncheckable_new;
        goto L87
    L88:
        ((RelativeLayout) r135.findViewById(R.id.complete_checkbox_container)).setEnabled(true);
        com.ss.android.lark.todo.impl.utils.i r166 = com.ss.android.lark.todo.impl.utils.i.f444291a;
        if (r136 == false) goto L91;
        int r167 = R.drawable.todo_svg_icon_milestone_unchecked;
    L92:
        r140 = r166.c(r167);
        goto L93
    L91:
        r167 = R.drawable.todo_svg_icon_uncheck_new;
        goto L92
    L48:
        ((ImageView) r119.findViewById(R.id.img_end_time)).setImageDrawable(UDIconUtils.getIconDrawable(r119.getContext(), R.drawable.ud_icon_calendar_date_outlined, r102.f442246i));
        goto L49
    L44:
        r118 = 48;
        goto L45
    L35:
        if (r102.A == false) goto L37;
        r112.setMargins(0, 0, 0, 0);
        r114.setMargins(TodoChatItemViewHolder.f442197g, 0, 0, TodoChatItemViewHolder.f442196f);
        ((LinearLayout) r109.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.bg_setting_group_item_round_bottom));
        r109.findViewById(R.id.divider_todo_item).setVisibility(4);
        goto L41
    L37:
        r112.setMargins(0, 0, 0, 0);
        if (r102.C == false) goto L40;
        r114.setMargins(TodoChatItemViewHolder.f442197g, 0, 0, TodoChatItemViewHolder.f442196f);
        ((LinearLayout) r109.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.bg_setting_group_item_round_bottom));
        r109.findViewById(R.id.divider_todo_item).setVisibility(4);
        goto L41
    L40:
        r114.setMargins(TodoChatItemViewHolder.f442197g, 0, 0, 0);
        ((LinearLayout) r109.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.bg_setting_group_item_rectangle));
        r109.findViewById(R.id.divider_todo_item).setVisibility(0);
        goto L41
    L29:
        if (r102.A == false) goto L31;
        r112.setMargins(0, TodoChatItemViewHolder.f442195e, 0, 0);
        r114.setMargins(TodoChatItemViewHolder.f442197g, 0, 0, TodoChatItemViewHolder.f442196f);
        ((LinearLayout) r109.findViewById(R.id.content_container_view)).setBackground(com.ss.android.lark.todo.impl.utils.i.f444291a.c(R.drawable.bg_setting_group_item_round));
        r109.findViewById(R.id.divider_todo_item).setVisibility(4);
        goto L41
    L126:
        return;
    L5:
        if (r211 >= getItemCount()) goto L8;
        r101 = false;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        int r102 = TodoChatItemViewHolder.f442195e;
        Fragment r103 = this.f442204b;
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r103, WidgetService.PARAM_FRAGMENT);
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_chat_item_bg, r100, false);
        Intrinsics.checkNotNull(r104);
        return new TodoChatItemViewHolder(r104, r103);
    }
}
