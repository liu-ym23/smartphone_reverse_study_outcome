package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.todo.v1.TodoSource;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIBadgeView;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.todo.impl.features.center.v3.data.SectionHeaderItem;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/ss/android/lark/todo/impl/features/center/v3/view/SectionItemViewHolder;", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/TaskListAdapter$BaseViewHolder;", "view", "Landroid/view/View;", "listener", "Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;)V", "getView", "()Landroid/view/View;", "getListener", "()Lcom/ss/android/lark/todo/impl/features/center/v3/view/IListItemClickListener;", "sectionGuid", "", "getSectionGuid", "()Ljava/lang/String;", "setSectionGuid", "(Ljava/lang/String;)V", "bind", "", "baseItem", "Lcom/ss/android/lark/todo/impl/features/center/v3/data/BaseItem;", "reviseHeaderView", "bindMore", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/center/v3/data/SectionHeaderItem;", "bindCount", "bindTitleName", "bindMembers", "bindOneMember", "bindBackground", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemViewHolder extends TaskListAdapter.BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f441892c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f441893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f441894b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441895a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f441896b = null;

        static {
            int[] r100 = new int[TodoSource.values().length];
            r100[TodoSource.CHAT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r100[TodoSource.DOCX.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r100[TodoSource.OAPI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f441895a = r100;
            int[] r101 = new int[SectionHeaderItem.HeaderType.values().length];
            r101[SectionHeaderItem.HeaderType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r101[SectionHeaderItem.HeaderType.CREATOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r101[SectionHeaderItem.HeaderType.ASSIGNEES.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[SectionHeaderItem.HeaderType.SOURCE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f441896b = r101;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f441897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SectionItemViewHolder f441898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SectionHeaderItem f441899c;

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            long r101 = this.f441897a;
            long r102 = System.currentTimeMillis();
            this.f441897a = r102;
            if ((r102 - r101) >= 500) goto L5;
            return;
        L5:
            t r103 = this.f441898b.f441894b;
            SectionHeaderItem r104 = this.f441899c;
            r103.m(r104.f441435a, !r104.f441442h);
        }

        public c(SectionItemViewHolder r100, SectionHeaderItem r101) {
            this.f441898b = r100;
            this.f441899c = r101;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.todo.impl.features.center.v3.view.TaskListAdapter.BaseViewHolder
    public final void T3(com.ss.android.lark.todo.impl.features.center.v3.data.a r110) {
        Intrinsics.checkNotNullParameter(r110, "baseItem");
        if ((r110 instanceof SectionHeaderItem) == false) goto L5;
        SectionHeaderItem r111 = (SectionHeaderItem) r110;
    L6:
        if (r111 != null) goto L8;
        return;
    L8:
        ViewGroup.LayoutParams r100 = this.f441893a.getLayoutParams();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r101 = (ViewGroup.MarginLayoutParams) r100;
        if (r111.f441453s == true) goto L11;
        int r102 = 0;
    L12:
        r101.setMargins(0, 0, 0, r102);
        this.f441893a.setLayoutParams(r101);
        View r103 = this.f441893a;
        Context r104 = r103.getContext();
        if (r111.f441453s == true) goto L15;
        int r105 = R.drawable.todo_main_fragment_title_bg_round_top;
    L16:
        r103.setBackground(y9c.d.e(r104, r105));
        com.larksuite.framework.section.utils.a.d(this.f441893a.findViewById(R.id.divider_todo_item), !r111.f441453s);
        com.larksuite.framework.section.utils.a.d(this.f441893a.findViewById(R.id.list_icon_img), r111.f441441g);
        ImageView r106 = (ImageView) this.f441893a.findViewById(R.id.list_icon_img);
        Context r107 = this.f441893a.getContext();
        if (r111.f441442h == false) goto L19;
        int r108 = R.drawable.ud_icon_expand_down_filled;
    L20:
        r106.setImageDrawable(UDIconUtils.getIconDrawable(r107, r108, UIUtils.getColor(this.f441893a.getContext(), R.color.icon_n2)));
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setVisibility(8);
        ((LinearLayout) this.f441893a.findViewById(R.id.member_one_container)).setVisibility(8);
        ((TaskUDAvatarList) this.f441893a.findViewById(R.id.task_members)).setVisibility(8);
        ((ImageView) this.f441893a.findViewById(R.id.section_source_icon)).setVisibility(8);
        int r109 = b.f441896b[r111.f441446l.ordinal()];
        if (r109 != 1) goto L23;
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setVisibility(0);
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setText(r111.f441436b);
    L55:
        if (r111.f441439e <= 0) goto L76;
        ((LKUIBadgeView) this.f441893a.findViewById(R.id.list_icon_count_red_badge)).setVisibility(0);
        ((TextView) this.f441893a.findViewById(R.id.list_icon_count_tv)).setVisibility(8);
        int r112 = r111.f441439e;
        if (r112 >= 10) goto L60;
        int r113 = R.drawable.badge_orange_single_count_bg_no_stroke;
    L63:
        LKUIBadgeView r114 = (LKUIBadgeView) this.f441893a.findViewById(R.id.list_icon_count_red_badge);
        com.larksuite.component.ui.imageview.a r115 = r114.f284166a;
        Context r116 = r114.getContext();
        r115.getClass();
        float r117 = j08.b.a(r116, 1.0f);
        if (r115.f284173f == r117) goto L66;
        r115.f284173f = r117;
    L66:
        r115.f284175h = true;
        String r118 = String.valueOf(r111.f441439e);
        com.larksuite.component.ui.imageview.a r119 = r114.f284166a;
        if (r118 == null) goto L69;
    L70:
        if (r118 != null) goto L72;
        r119.getClass();
    L75:
        r114.b(r113);
        r114.a();
    L81:
        if (r111.f441443i == true) goto L83;
    L86:
        ((ImageView) this.f441893a.findViewById(R.id.more)).setVisibility(8);
    L87:
        this.f441893a.setOnClickListener(new c(this, r111));
        return;
    L83:
        if (r111.f441448n == false) goto L86;
        ViewGroup.LayoutParams r120 = ((ImageView) this.f441893a.findViewById(R.id.more)).getLayoutParams();
        r120.width = com.ss.android.lark.todo.impl.utils.m.a(36);
        r120.height = com.ss.android.lark.todo.impl.utils.m.a(36);
        ((ImageView) this.f441893a.findViewById(R.id.more)).setVisibility(0);
        this.f441893a.findViewById(R.id.more).setOnClickListener(new y(this, r111));
        goto L87
    L72:
        if (r118.equals(r119.f284168a) == true) goto L75;
    L73:
        r119.f284168a = r118;
        r119.f284175h = true;
        goto L75
    L69:
        if (r119.f284168a != null) goto L73;
    L60:
        if (r112 >= 999) goto L62;
        r113 = R.drawable.badge_orange_multi_count_bg_no_stroke;
        goto L63
    L62:
        r113 = R.drawable.badge_orange_bg_etc_count;
        goto L63
    L76:
        ((LKUIBadgeView) this.f441893a.findViewById(R.id.list_icon_count_red_badge)).setVisibility(8);
        if (r111.f441438d <= 0) goto L79;
        ((TextView) this.f441893a.findViewById(R.id.list_icon_count_tv)).setVisibility(0);
        ((TextView) this.f441893a.findViewById(R.id.list_icon_count_tv)).setText(String.valueOf(r111.f441438d));
        goto L81
    L79:
        ((TextView) this.f441893a.findViewById(R.id.list_icon_count_tv)).setVisibility(8);
        goto L81
    L23:
        if (r109 != 2) goto L25;
        V3(r111);
        goto L55
    L25:
        if (r109 == 3) goto L39;
        if (r109 != 4) goto L37;
        ((ImageView) this.f441893a.findViewById(R.id.section_source_icon)).setVisibility(0);
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setVisibility(0);
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setText(r111.f441436b);
        int r121 = b.f441895a[r111.f441447m.ordinal()];
        if (r121 == 1) goto L35;
        if (r121 == 2) goto L34;
        if (r121 == 3) goto L33;
        ((ImageView) this.f441893a.findViewById(R.id.section_source_icon)).setVisibility(8);
        goto L55
    L33:
        ((ImageView) this.f441893a.findViewById(R.id.section_source_icon)).setImageResource(R.drawable.ud_icon_robot_outlined);
        goto L55
    L34:
        ((ImageView) this.f441893a.findViewById(R.id.section_source_icon)).setImageResource(R.drawable.ud_icon_file_link_docx_outlined);
        goto L55
    L35:
        ((ImageView) this.f441893a.findViewById(R.id.section_source_icon)).setImageResource(R.drawable.ud_icon_chat_outlined);
        goto L55
    L37:
        throw new NoWhenBranchMatchedException();
    L39:
        if (r111.f441440f.isEmpty() == false) goto L42;
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setVisibility(0);
        ((TextView) this.f441893a.findViewById(R.id.list_icon_title_tv)).setText(r111.f441436b);
        goto L55
    L42:
        if (r111.f441440f.size() >= 2) goto L45;
        V3(r111);
        goto L55
    L45:
        if (r111.f441440f.size() < 2) goto L55;
        ((TaskUDAvatarList) this.f441893a.findViewById(R.id.task_members)).setVisibility(0);
        TaskUDAvatarList r122 = (TaskUDAvatarList) this.f441893a.findViewById(R.id.task_members);
        List<TodoUser> r123 = r111.f441440f;
        ArrayList r124 = new ArrayList();
        Iterator<T> r125 = r123.iterator();
    L49:
        if (r125.hasNext() == false) goto L51;
        TodoUser r126 = (TodoUser) r125.next();
        r124.add(new com.ss.android.lark.todo.impl.features.detail.sections.c(r126.user_id, r126.avatar_key, false, 0));
        goto L49
    L51:
        r122.setAdapter(new x(r124));
        goto L55
    L19:
        r108 = R.drawable.ud_icon_expand_right_filled;
        goto L20
    L15:
        r105 = R.drawable.todo_main_fragment_title_bg_round;
        goto L16
    L11:
        r102 = y9c.d.a(16);
        goto L12
    L5:
        r111 = null;
        goto L6
    }

    public final void V3(SectionHeaderItem r100) {
        if (r100.f441440f.isEmpty() == false) goto L5;
        return;
    L5:
        ((LinearLayout) this.f441893a.findViewById(R.id.member_one_container)).setVisibility(0);
        int r101 = com.ss.android.lark.todo.impl.utils.m.a(20);
        AvatarImage r102 = AvatarImage.Builder.obtain(((TodoUser) ListProtector.get(r100.f441440f, 0)).avatar_key, ((TodoUser) ListProtector.get(r100.f441440f, 0)).user_id, r101, r101).build();
        ImageLoader.with(this.f441893a.getContext()).load(r102).placeholder(new ColorDrawable(UIUtils.getColor(this.f441893a.getContext(), R.color.fill_tag))).override(r101, r101).into((ImageView) this.f441893a.findViewById(R.id.member_avatar));
        ((TextView) this.f441893a.findViewById(R.id.member_name)).setText(((TodoUser) ListProtector.get(r100.f441440f, 0)).name);
    }

    public SectionItemViewHolder(View r100, u0 r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "listener");
        super(r100);
        this.f441893a = r100;
        this.f441894b = r101;
    }
}
