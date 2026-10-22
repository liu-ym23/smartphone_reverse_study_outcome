package com.ss.android.lark.todo.impl.features.chatlist.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010$\u001a\u00020%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006+"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/view/View;Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "onTitleClickListener", "Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter$ITitleClickListener;", "getOnTitleClickListener", "()Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter$ITitleClickListener;", "setOnTitleClickListener", "(Lcom/ss/android/lark/todo/impl/features/chatlist/adapter/TodoChatListAdapter$ITitleClickListener;)V", "itemClickListener", "Lcom/ss/android/lark/todo/impl/features/common/listener/ListItemClickListener;", "getItemClickListener", "()Lcom/ss/android/lark/todo/impl/features/common/listener/ListItemClickListener;", "itemClickListener$delegate", "Lkotlin/Lazy;", "bind", "", "viewModel", "Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TodoChatListViewModel;", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/chatlist/item/TodoDisplayItem;", "bindBackground", "bindMsgView", "bindView", "bindTitleText", "bindCompleteCheckBox", "bindCheckBoxAction", "bindMileStoneTodoCheckAction", "bindNormalTodoCheckAnimation", "getSwipeLayout", "Lcom/larksuite/component/blockit/hashtag/widget/SwipeLayout;", "getShowAssignees", "", "Lcom/bytedance/lark/pb/todo/v1/TodoAssignee;", "assignees", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoChatItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f442195e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f442196f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f442197g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f442198h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f442199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f442200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TodoChatListAdapter.b f442201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f442202d;

    public static final class a {
    }

    static {
        f442195e = y9c.d.a(16);
        f442196f = y9c.d.a(6);
        f442197g = y9c.d.a(44);
        f442198h = y9c.d.a(70);
    }

    public TodoChatItemViewHolder(View r100, Fragment r101) {
        super(r100);
        this.f442199a = r100;
        this.f442200b = r101;
        this.f442202d = LazyKt.lazy(TodoChatItemViewHolder$itemClickListener$2.INSTANCE);
        ((LKUILightTextView) r100.findViewById(R.id.title_rich_text)).setShouldLayoutZeroLengthText(true);
    }
}
