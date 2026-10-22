package com.ss.android.lark.todo.impl.features.center.v3.sidebar;

import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import com.bytedance.lark.pb.todo.v1.IconInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.larkicon.IconScene;
import com.ss.android.lark.todo.impl.features.center.v3.type.ContainerType;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000534567B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u001c\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\n\u0010\u0017\u001a\u00060\u001dR\u00020\u0000H\u0002J(\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0002J\u001c\u0010%\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\n\u0010\u0017\u001a\u00060&R\u00020\u0000H\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020(H\u0002J\u0010\u0010*\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020\u0011H\u0016J\u001a\u00100\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010-2\b\u00102\u001a\u0004\u0018\u00010/R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dependency", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$IDependency;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$IDependency;)V", "getDependency", "()Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$IDependency;", "items", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerItemData;", "Lkotlin/collections/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "diffData", "", "groupList", "", "onBindViewHolder", "holder", "position", "getItem", "getItemViewType", "bindItem", "data", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$QuickAccessViewHolder;", "bindTaskListIcon", "taskListIcon", "Landroid/widget/ImageView;", "dividerView", "Landroid/view/View;", "shouldSelected", "", "bindHeader", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$HeaderViewHolder;", "shouldShowCreateButton", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ViewType;", "shouldShowMoreButton", "shouldShowTopDivider", "getItemCount", "curSelectContainer", "Lcom/ss/android/lark/todo/impl/features/center/v3/type/ContainerType;", "curSelectTaskListId", "", "setSelectItem", "type", "taskListId", "Companion", "QuickAccessViewHolder", "HeaderViewHolder", "GroupDiffCallback", "IDependency", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContainerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f441641e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f441642f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f441643g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f441644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<com.ss.android.lark.todo.impl.features.center.v3.sidebar.c> f441645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ContainerType f441646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f441647d;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$GroupDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerItemData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GroupDiffCallback extends DiffUtil.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.ss.android.lark.todo.impl.features.center.v3.sidebar.c> f441648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.ss.android.lark.todo.impl.features.center.v3.sidebar.c> f441649b;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getNewListSize() {
            return this.f441649b.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final int getOldListSize() {
            return this.f441648a.size();
        }

        public GroupDiffCallback(List<com.ss.android.lark.todo.impl.features.center.v3.sidebar.c> r100, List<com.ss.android.lark.todo.impl.features.center.v3.sidebar.c> r101) {
            Intrinsics.checkNotNullParameter(r100, "oldItems");
            Intrinsics.checkNotNullParameter(r101, "newItems");
            this.f441648a = r100;
            this.f441649b = r101;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areContentsTheSame(int r100, int r101) {
            return Intrinsics.areEqual(ListProtector.get(this.f441649b, r101), ListProtector.get(this.f441648a, r100));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public final boolean areItemsTheSame(int r100, int r101) {
            if (Intrinsics.areEqual(((com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441649b, r101)).f441696b, ((com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441648a, r100)).f441696b) == true) goto L5;
        L7:
            return false;
        L5:
            if (((com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441649b, r101)).f441698d != ((com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441648a, r100)).f441698d) goto L7;
            return true;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter;Landroid/view/View;)V", "buttonHeaderLayout", "getButtonHeaderLayout", "()Landroid/view/View;", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "headerArrowView", "Landroid/widget/ImageView;", "getHeaderArrowView", "()Landroid/widget/ImageView;", "arrowViewSmall", "getArrowViewSmall", "createBtn", "getCreateBtn", "moreBtn", "getMoreBtn", "dividerForTaskListTop", "getDividerForTaskListTop", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class HeaderViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f441650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f441651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f441652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f441653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f441654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f441655f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final View f441656g;

        public HeaderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f441650a = r100.findViewById(R.id.button_header_layout);
            this.f441651b = (TextView) r100.findViewById(R.id.text_container_header_name);
            this.f441652c = (ImageView) r100.findViewById(R.id.image_container_header_arrow);
            this.f441653d = (ImageView) r100.findViewById(R.id.image_container_header_arrow_small);
            this.f441654e = r100.findViewById(R.id.button_create_task_list);
            this.f441655f = r100.findViewById(R.id.button_task_list_section_more);
            this.f441656g = r100.findViewById(R.id.divider_for_tasklist_top);
            ButterKnife.bind(this, r100);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter$QuickAccessViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/center/v3/sidebar/ContainerAdapter;Landroid/view/View;)V", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "moreBtn", "getMoreBtn", "()Landroid/view/View;", "archiveView", "getArchiveView", "selectLayout", "getSelectLayout", "taskListIcon", "Landroid/widget/ImageView;", "getTaskListIcon", "()Landroid/widget/ImageView;", "dividerView", "getDividerView", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class QuickAccessViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f441657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f441658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f441659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f441660d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f441661e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final View f441662f;

        public QuickAccessViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f441657a = (TextView) r100.findViewById(R.id.tv_container_name);
            this.f441658b = r100.findViewById(R.id.button_action_more);
            this.f441659c = r100.findViewById(R.id.image_archive);
            this.f441660d = r100.findViewById(R.id.layout_select_item);
            this.f441661e = (ImageView) r100.findViewById(R.id.img_task_list_icon);
            this.f441662f = r100.findViewById(R.id.divider_view);
            ButterKnife.bind(this, r100);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(com.ss.android.lark.todo.impl.features.center.v3.sidebar.c r100);

        void b(com.ss.android.lark.todo.impl.features.center.v3.sidebar.c r100);

        void c();

        void d(com.ss.android.lark.todo.impl.features.center.v3.sidebar.c r100);
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441663a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f441664b = null;

        static {
            int[] r100 = new int[ViewType.values().length];
            r100[ViewType.HEADER_QUICK_ACCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[ViewType.HEADER_TASK_LIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L45:
            r100[ViewType.HEADER_ARCHIVE_LIST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L33:
            r100[ViewType.HEADER_TASK_LIST_MANAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[ViewType.HEADER_TASK_LIST_SECTION.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L27:
            r100[ViewType.HEADER_CREATE_SECTION.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L37:
            r100[ViewType.CONTAINER_ITEM.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L39:
            r100[ViewType.TASK_LIST_ITEM.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L12:
            f441663a = r100;
            int[] r101 = new int[BgType.values().length];
            r101[BgType.NO_BG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L29:
            r101[BgType.BG_MIDDLE_IN_SECTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L15:
            f441664b = r101;
        }
    }

    static {
        f441641e = UIHelper.getDimens(R.dimen.dp_4);
        f441642f = UIHelper.getDimens(R.dimen.dp_5);
        f441643g = UIHelper.getDimens(R.dimen.dp_6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f441645b.size();
    }

    public ContainerAdapter(TodoSidebarFragment$containerAdapter$2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f441644a = r100;
        this.f441645b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return ((com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441645b, r100)).f441695a.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        ViewGroup.MarginLayoutParams r100 = null;
        boolean r112 = true;
        int r113 = 0;
        if ((r110 instanceof QuickAccessViewHolder) == false) goto L89;
        final com.ss.android.lark.todo.impl.features.center.v3.sidebar.c r101 = (com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441645b, r111);
        QuickAccessViewHolder r102 = (QuickAccessViewHolder) r110;
        ContainerType r103 = r101.f441698d;
        ContainerType r114 = this.f441646c;
        if (r103 != r114) goto L8;
        if (r114 == null) goto L8;
    L11:
        boolean r104 = true;
    L13:
        TextView r115 = r102.f441657a;
        r115.setSelected(r104);
        r115.setText(r101.f441697c);
        r115.getPaint().setFakeBoldText(r104);
        r102.itemView.setSelected(r104);
        ViewGroup.LayoutParams r116 = r102.f441658b.getLayoutParams();
        r116.width = com.ss.android.lark.todo.impl.utils.m.a(40);
        r116.height = com.ss.android.lark.todo.impl.utils.m.a(40);
        View r117 = r102.f441658b;
        ViewType r118 = r101.f441695a;
        ViewType r119 = ViewType.TASK_LIST_ITEM;
        if (r118 != r119) goto L16;
        boolean r120 = true;
    L17:
        com.larksuite.framework.section.utils.a.d(r117, r120);
        ViewGroup.LayoutParams r121 = r102.f441659c.getLayoutParams();
        r121.width = com.ss.android.lark.todo.impl.utils.m.a(40);
        r121.height = com.ss.android.lark.todo.impl.utils.m.a(40);
        com.larksuite.framework.section.utils.a.d(r102.f441659c, r101.f441702h);
        ImageView r122 = r102.f441661e;
        View r123 = r102.f441662f;
        if (r101.f441695a != r119) goto L35;
        r122.setVisibility(0);
        r123.setVisibility(0);
        if (r104 == false) goto L22;
        Drawable r105 = UDIconUtils.getIconDrawable(r122.getContext(), R.drawable.ud_icon_tasklist_filled, UDColorUtils.getColor(r122.getContext(), R.color.primary_content_default));
    L23:
        int r106 = obb.c.f522646p;
        IconInfo r107 = r101.f441704j;
        if (r107 == null) goto L28;
        Integer r108 = r107.type;
        if (r108 == null) goto L28;
        int r109 = r108.intValue();
    L29:
        IconInfo r124 = r101.f441704j;
        if (r124 == null) goto L33;
        String r125 = r124.key;
        if (r125 == null) goto L33;
    L34:
        obb.c.a r126 = obb.c.b.a(r109, r125);
        IconScene r127 = IconScene.TODO;
        Intrinsics.checkNotNullParameter(r127, "scene");
        r126.f522674m = r127;
        r126.f522670i = r105;
        r126.f522671j = r105;
        mbb.c.h(r122, new obb.c(r126));
    L36:
        View r128 = r102.f441660d;
        if (r101.f441695a != r119) goto L43;
        BgType r129 = r101.f441703i;
        int r130 = c.f441664b[r129.ordinal()];
        if (r130 == 1) goto L43;
        if (r130 == 2) goto L42;
        int r131 = R.drawable.todo_tasklist_item_bg_bottom;
    L44:
        r128.setBackgroundResource(r131);
        View r132 = r102.f441660d;
        if (r101.f441695a != r119) goto L64;
        BgType r133 = r101.f441703i;
        if (r133 == BgType.NO_BG) goto L64;
        if (r133 == BgType.BG_MIDDLE_IN_SECTION) goto L64;
        ViewGroup.LayoutParams r134 = r132.getLayoutParams();
        Intrinsics.checkNotNull(r134, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r135 = (ViewGroup.MarginLayoutParams) r134;
        ViewGroup.LayoutParams r136 = r132.getLayoutParams();
        if ((r136 instanceof ViewGroup.MarginLayoutParams) == false) goto L53;
        int r137 = ((ViewGroup.MarginLayoutParams) r136).getMarginStart();
    L54:
        ViewGroup.LayoutParams r138 = r132.getLayoutParams();
        if ((r138 instanceof ViewGroup.MarginLayoutParams) == false) goto L57;
        r100 = (ViewGroup.MarginLayoutParams) r138;
    L57:
        if (r100 == null) goto L59;
        int r139 = r100.topMargin;
    L60:
        ViewGroup.LayoutParams r140 = r132.getLayoutParams();
        if ((r140 instanceof ViewGroup.MarginLayoutParams) == false) goto L63;
        r113 = ((ViewGroup.MarginLayoutParams) r140).getMarginEnd();
    L63:
        r135.setMargins(r137, r139, r113, f441643g);
    L79:
        View r141 = r102.itemView;
        if (r101.f441695a != r119) goto L86;
        BgType r142 = r101.f441703i;
        int r143 = c.f441664b[r142.ordinal()];
        if (r143 == 1) goto L86;
        if (r143 == 2) goto L85;
        int r144 = R.drawable.bg_todo_sidebar_section_bottom;
    L87:
        r141.setBackgroundResource(r144);
        com.ss.android.lark.todo.impl.features.center.v3.sidebar.a.a(r102.itemView, new ContainerAdapter$bindItem$6(this, r101));
        com.ss.android.lark.todo.impl.features.center.v3.sidebar.a.a(r102.f441658b, new ContainerAdapter$bindItem$7(this, r101));
        return;
    L85:
        r144 = R.drawable.bg_todo_sidebar_section_middle;
    L86:
        r144 = R.drawable.todo_container_item_bg;
        goto L87
    L59:
        r139 = 0;
        goto L60
    L53:
        r137 = 0;
    L64:
        ViewGroup.LayoutParams r145 = r132.getLayoutParams();
        Intrinsics.checkNotNull(r145, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r146 = (ViewGroup.MarginLayoutParams) r145;
        ViewGroup.LayoutParams r147 = r132.getLayoutParams();
        if ((r147 instanceof ViewGroup.MarginLayoutParams) == false) goto L67;
        int r148 = ((ViewGroup.MarginLayoutParams) r147).getMarginStart();
    L68:
        ViewGroup.LayoutParams r149 = r132.getLayoutParams();
        if ((r149 instanceof ViewGroup.MarginLayoutParams) == false) goto L71;
        r100 = (ViewGroup.MarginLayoutParams) r149;
    L71:
        if (r100 == null) goto L73;
        int r150 = r100.topMargin;
    L74:
        ViewGroup.LayoutParams r151 = r132.getLayoutParams();
        if ((r151 instanceof ViewGroup.MarginLayoutParams) == false) goto L77;
        int r152 = ((ViewGroup.MarginLayoutParams) r151).getMarginEnd();
    L78:
        r146.setMargins(r148, r150, r152, 0);
        goto L79
    L77:
        r152 = 0;
        goto L78
    L73:
        r150 = 0;
        goto L74
    L67:
        r148 = 0;
        goto L68
    L42:
        r131 = R.drawable.todo_tasklist_item_bg_middle;
    L43:
        r131 = R.color.color_transparent;
    L33:
        r125 = "";
    L28:
        r109 = 0;
        goto L29
    L22:
        r105 = UDIconUtils.getIconDrawable(r122.getContext(), R.drawable.ud_icon_tasklist_outlined, UDColorUtils.getColor(r122.getContext(), R.color.icon_n3));
        goto L23
    L35:
        r122.setVisibility(4);
        r123.setVisibility(8);
        goto L36
    L16:
        r120 = false;
    L8:
        if (Intrinsics.areEqual(r101.f441696b, this.f441647d) == true) goto L10;
    L12:
        r104 = false;
        goto L13
    L10:
        if (this.f441647d == null) goto L12;
    L89:
        if ((r110 instanceof HeaderViewHolder) == false) goto L214;
        final com.ss.android.lark.todo.impl.features.center.v3.sidebar.c r153 = (com.ss.android.lark.todo.impl.features.center.v3.sidebar.c) ListProtector.get(this.f441645b, r111);
        HeaderViewHolder r154 = (HeaderViewHolder) r110;
        ContainerType r155 = r153.f441698d;
        ContainerType r156 = this.f441646c;
        if (r155 != r156) goto L94;
        if (r156 == null) goto L94;
        boolean r157 = true;
    L95:
        TextView r158 = r154.f441651b;
        if (r153.f441700f == true) goto L100;
        if (r157 == true) goto L100;
        boolean r159 = false;
    L101:
        r158.setSelected(r159);
        TextPaint r160 = r158.getPaint();
        if (r157 == true) goto L111;
        ViewType r161 = r153.f441695a;
        if (r161 == ViewType.HEADER_QUICK_ACCESS) goto L111;
        if (r161 == ViewType.HEADER_TASK_LIST_MANAGE) goto L111;
        if (r161 == ViewType.HEADER_TASK_LIST_SECTION) goto L111;
        boolean r162 = false;
    L112:
        r160.setFakeBoldText(r162);
        r158.setText(r153.f441697c);
        ViewType r163 = r153.f441695a;
        ViewType r164 = ViewType.HEADER_ARCHIVE_LIST;
        if (r163 != r164) goto L115;
    L118:
        r158.setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.a(R.color.text_caption));
    L120:
        if (r153.f441695a != r164) goto L122;
        float r165 = 14.0f;
    L123:
        r158.setTextSize(2, r165);
        ImageView r166 = r154.f441652c;
        if (r153.f441695a == r164) goto L126;
        boolean r167 = true;
    L127:
        com.larksuite.framework.section.utils.a.e(r166, r167);
        ViewType r168 = r153.f441695a;
        int[] r169 = c.f441663a;
        int r170 = r169[r168.ordinal()];
        float r171 = 0.0f;
        if (r170 != 4) goto L130;
        r166.setImageResource(R.drawable.ud_icon_tasklist_outlined);
        r166.setPadding(0, 0, 0, 0);
    L138:
        ImageView r172 = r154.f441653d;
        if (r153.f441695a != r164) goto L141;
        boolean r173 = true;
    L142:
        com.larksuite.framework.section.utils.a.d(r172, r173);
        if (r153.f441701g == false) goto L145;
        r171 = 180.0f;
    L145:
        r172.setRotation(r171);
        View r174 = r154.itemView;
        if (r153.f441695a != r164) goto L148;
        boolean r175 = true;
    L149:
        r174.setTag(Boolean.valueOf(r175));
        r174.setSelected(r157);
        View r176 = r154.f441650a;
        int r177 = r169[r153.f441695a.ordinal()];
        if (r177 != 3) goto L152;
        int r178 = R.color.bg_body;
    L159:
        r176.setBackgroundResource(r178);
        ViewType r179 = r153.f441695a;
        ViewType r180 = ViewType.HEADER_TASK_LIST_SECTION;
        if (r179 != r180) goto L162;
    L179:
        ViewGroup.LayoutParams r181 = r176.getLayoutParams();
        Intrinsics.checkNotNull(r181, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r182 = (ViewGroup.MarginLayoutParams) r181;
        ViewGroup.LayoutParams r183 = r176.getLayoutParams();
        if ((r183 instanceof ViewGroup.MarginLayoutParams) == false) goto L182;
        int r184 = ((ViewGroup.MarginLayoutParams) r183).getMarginStart();
    L183:
        int r185 = f441642f;
        ViewGroup.LayoutParams r186 = r176.getLayoutParams();
        if ((r186 instanceof ViewGroup.MarginLayoutParams) == false) goto L186;
        int r187 = ((ViewGroup.MarginLayoutParams) r186).getMarginEnd();
    L187:
        ViewGroup.LayoutParams r188 = r176.getLayoutParams();
        if ((r188 instanceof ViewGroup.MarginLayoutParams) == false) goto L190;
        r100 = (ViewGroup.MarginLayoutParams) r188;
    L190:
        if (r100 == null) goto L192;
        int r189 = r100.bottomMargin;
    L193:
        r182.setMargins(r184, r185, r187, r189);
    L194:
        com.ss.android.lark.todo.impl.features.center.v3.sidebar.a.a(r154.itemView, new ContainerAdapter$bindHeader$6(this, r153));
        View r190 = r154.f441654e;
        ViewGroup.LayoutParams r191 = r190.getLayoutParams();
        r191.width = com.ss.android.lark.todo.impl.utils.m.a(40);
        r191.height = com.ss.android.lark.todo.impl.utils.m.a(40);
        ViewType r192 = r153.f441695a;
        ViewType r193 = ViewType.HEADER_TASK_LIST;
        if (r192 != r193) goto L197;
    L200:
        boolean r194 = true;
    L201:
        com.larksuite.framework.section.utils.a.d(r190, r194);
        com.ss.android.lark.todo.impl.features.center.v3.sidebar.a.a(r190, new ContainerAdapter$bindHeader$7$2(this));
        ViewGroup.LayoutParams r195 = r154.f441655f.getLayoutParams();
        r195.width = com.ss.android.lark.todo.impl.utils.m.a(40);
        r195.height = com.ss.android.lark.todo.impl.utils.m.a(40);
        View r196 = r154.f441655f;
        if (r153.f441695a != r180) goto L204;
        boolean r197 = true;
    L205:
        com.larksuite.framework.section.utils.a.d(r196, r197);
        com.ss.android.lark.todo.impl.features.center.v3.sidebar.a.a(r154.f441655f, new ContainerAdapter$bindHeader$9(this, r153));
        View r198 = r154.f441656g;
        ViewType r199 = r153.f441695a;
        if (r199 != r193) goto L208;
    L211:
        com.larksuite.framework.section.utils.a.d(r198, r112);
        return;
    L208:
        if (r199 == ViewType.HEADER_TASK_LIST_MANAGE) goto L211;
        r112 = false;
        goto L211
    L204:
        r197 = false;
        goto L205
    L197:
        if (r192 == ViewType.HEADER_TASK_LIST_MANAGE) goto L200;
        r194 = false;
        goto L201
    L192:
        r189 = 0;
        goto L193
    L186:
        r187 = 0;
        goto L187
    L182:
        r184 = 0;
        goto L183
    L162:
        if (r179 == ViewType.HEADER_CREATE_SECTION) goto L179;
        ViewGroup.LayoutParams r200 = r176.getLayoutParams();
        Intrinsics.checkNotNull(r200, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r201 = (ViewGroup.MarginLayoutParams) r200;
        ViewGroup.LayoutParams r202 = r176.getLayoutParams();
        if ((r202 instanceof ViewGroup.MarginLayoutParams) == false) goto L167;
        int r203 = ((ViewGroup.MarginLayoutParams) r202).getMarginStart();
    L168:
        ViewGroup.LayoutParams r204 = r176.getLayoutParams();
        if ((r204 instanceof ViewGroup.MarginLayoutParams) == false) goto L171;
        int r205 = ((ViewGroup.MarginLayoutParams) r204).getMarginEnd();
    L172:
        ViewGroup.LayoutParams r206 = r176.getLayoutParams();
        if ((r206 instanceof ViewGroup.MarginLayoutParams) == false) goto L175;
        r100 = (ViewGroup.MarginLayoutParams) r206;
    L175:
        if (r100 == null) goto L177;
        int r207 = r100.bottomMargin;
    L178:
        r201.setMargins(r203, 0, r205, r207);
        goto L194
    L177:
        r207 = 0;
        goto L178
    L171:
        r205 = 0;
        goto L172
    L167:
        r203 = 0;
        goto L168
    L152:
        if (r177 == 5) goto L155;
        r178 = R.drawable.todo_container_item_bg;
        goto L159
    L155:
        if (r153.f441703i != BgType.BG_FIRST_IN_SECTION) goto L157;
        r178 = R.drawable.bg_todo_sidebar_section_top;
        goto L159
    L157:
        r178 = R.drawable.bg_todo_sidebar_section_round;
        goto L159
    L148:
        r175 = false;
        goto L149
    L141:
        r173 = false;
        goto L142
    L130:
        if (r170 == 6) goto L136;
        r166.setImageResource(R.drawable.ud_icon_expand_down_filled);
        int r208 = f441641e;
        r166.setPadding(r208, r208, r208, r208);
        if (r153.f441701g == false) goto L134;
        float r209 = 0.0f;
    L135:
        r166.setRotation(r209);
        goto L138
    L134:
        r209 = -90.0f;
        goto L135
    L136:
        r166.setImageResource(R.drawable.ud_icon_add_middle_outlined);
        r166.setPadding(0, 0, 0, 0);
        goto L138
    L126:
        r167 = false;
        goto L127
    L122:
        r165 = 16.0f;
        goto L123
    L115:
        if (r163 == ViewType.HEADER_CREATE_SECTION) goto L118;
        r158.setTextColor(com.ss.android.lark.todo.impl.utils.i.f444291a.b());
    L111:
        r162 = true;
    L100:
        r159 = true;
    L94:
        r157 = false;
        goto L95
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        ViewType.Companion.getClass();
        ViewType r102 = ViewType.HEADER_QUICK_ACCESS;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.CONTAINER_ITEM;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.HEADER_TASK_LIST;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.TASK_LIST_ITEM;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.HEADER_ARCHIVE_LIST;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.HEADER_TASK_LIST_MANAGE;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.HEADER_TASK_LIST_SECTION;
        if (r101 == r102.getValue()) goto L26;
        r102 = ViewType.HEADER_CREATE_SECTION;
        if (r101 == r102.getValue()) goto L26;
        throw new IllegalArgumentException("Invalid viewType:" + r101);
    L26:
        switch(c.f441663a[r102.ordinal()]) {
            case 1: goto L30;
            case 2: goto L30;
            case 3: goto L30;
            case 4: goto L30;
            case 5: goto L30;
            case 6: goto L30;
            case 7: goto L29;
            case 8: goto L29;
            default: goto L28;
        };
    L29:
        View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_task_container, r100, false);
        Intrinsics.checkNotNull(r103);
        return new QuickAccessViewHolder(r103);
    L30:
        View r104 = LayoutInflater.from(r100.getContext()).inflate(R.layout.item_task_container_header, r100, false);
        Intrinsics.checkNotNull(r104);
        return new HeaderViewHolder(r104);
    L28:
        throw new NoWhenBranchMatchedException();
    }

    public final void y2(ContainerType r100, String r101) {
        this.f441646c = r100;
        this.f441647d = r101;
        notifyDataSetChanged();
    }
}
