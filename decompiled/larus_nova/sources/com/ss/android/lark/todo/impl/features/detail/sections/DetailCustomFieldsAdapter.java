package com.ss.android.lark.todo.impl.features.detail.sections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.basic.v1.RichContent;
import com.bytedance.lark.pb.todo.v1.FieldType;
import com.bytedance.lark.pb.todo.v1.SelectFieldOption;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import com.larksuite.framework.ui.flowlayout.FlowLayout;
import com.larksuite.framework.ui.flowlayout.TagFlowLayout;
import com.larus.nova.R;
import com.ss.android.lark.todo.impl.features.common.widget.TaskUDAvatarList;
import com.ss.android.lark.todo.impl.features.detail.customfields.CustomFieldsTagColorHelper;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.TodoCustomFieldData;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.richtext.RichTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0013\u0014\u0015B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailCustomFieldsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoCustomFieldData;", "Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailCustomFieldsAdapter$CustomFieldViewHolder;", "viewAbility", "Lcom/larksuite/framework/section/IViewAbility;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/ITodoDetailViewDataStore;", "<init>", "(Lcom/larksuite/framework/section/IViewAbility;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemViewType", "Companion", "CustomFieldViewHolder", "FieldTagAdapter", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DetailCustomFieldsAdapter extends ListAdapter<TodoCustomFieldData, CustomFieldViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larksuite.framework.section.e<com.ss.android.lark.todo.impl.features.detail.viewmodel.p> f443175a;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailCustomFieldsAdapter$CustomFieldViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/ss/android/lark/todo/impl/features/detail/sections/DetailCustomFieldsAdapter;Landroid/view/View;)V", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoCustomFieldData;", "bindFieldValue", "bindAvatar", "bindText", "bindTags", "bindRichText", "bindEllipsizeLayout", "generateCustomFiledIcon", "", "fieldType", "Lcom/bytedance/lark/pb/todo/v1/FieldType;", "initViewAction", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class CustomFieldViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DetailCustomFieldsAdapter f443176a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f443177a = null;

            static {
                int[] r100 = new int[FieldType.values().length];
                r100[FieldType.MEMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
            L19:
                r100[FieldType.SINGLE_SELECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
            L27:
                r100[FieldType.MULTI_SELECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
            L21:
                r100[FieldType.TEXT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            L23:
                r100[FieldType.DATETIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
            L17:
                r100[FieldType.NUMBER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
            L9:
                f443177a = r100;
            }
        }

        public final void T3(TodoCustomFieldData r100) {
            TextView r101 = (TextView) this.itemView.findViewById(R.id.text_field_value);
            com.larksuite.framework.section.utils.a.d(r101, true);
            if (r100.d() == false) goto L5;
            int r102 = R.color.text_title;
        L6:
            r101.setTextColor(UIHelper.getColor(r102));
            r101.setText(r100.a());
            return;
        L5:
            r102 = R.color.text_placeholder;
            goto L6
        }

        public CustomFieldViewHolder(DetailCustomFieldsAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f443176a = r100;
            super(r101);
        }
    }

    public static final class a {
    }

    public static final class b extends p28.a<SelectFieldOption> {
        public b(List<SelectFieldOption> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            super(r100);
        }

        @Override // p28.a
        public final View a(FlowLayout r100, Object r101) {
            SelectFieldOption r102 = (SelectFieldOption) r101;
            Intrinsics.checkNotNullParameter(r100, "parent");
            Intrinsics.checkNotNullParameter(r102, "tagValue");
            int r103 = UIHelper.getDimens(R.dimen.dp_8);
            ImageView r104 = new ImageView(r100.getContext());
            ViewGroup.MarginLayoutParams r105 = new ViewGroup.MarginLayoutParams(-2, -2);
            r105.setMarginEnd(r103);
            r105.bottomMargin = UIHelper.getDimens(R.dimen.dp_4);
            r105.topMargin = UIHelper.getDimens(R.dimen.dp_4);
            r104.setLayoutParams(r105);
            Lazy r106 = CustomFieldsTagColorHelper.f443038a;
            com.ss.android.lark.todo.impl.features.detail.customfields.c r107 = CustomFieldsTagColorHelper.b(r102.color_index.intValue());
            UDTagsDrawable.a r108 = new UDTagsDrawable.a(r100.getContext());
            UDTagsDrawable.d.a r109 = new UDTagsDrawable.d.a(r100.getContext());
            r109.f285353c = r102.name;
            r109.a(UDColorUtils.getColor(r100.getContext(), r107.f443044a));
            r109.f285354d = UDColorUtils.getColor(r100.getContext(), r107.f443045b);
            r109.f285358h = r102.is_hidden.booleanValue();
            r108.a(r109.b());
            if (r100.getMeasuredWidth() <= r103) goto L5;
            Number r110 = Integer.valueOf(r100.getMeasuredWidth() - r103);
        L6:
            r108.f285332f = r110.floatValue();
            r108.f285328b = h18.d.f(r100.getContext(), 13.0f);
            r108.f285329c = h18.d.b(r100.getContext(), 4);
            r108.f285330d = h18.d.f(r100.getContext(), 20.0f);
            UDTagsDrawable r111 = r108.b();
            if (r111 == null) goto L9;
            r111.d(r104);
        L9:
            return r104;
        L5:
            r110 = Float.valueOf(Float.MAX_VALUE);
            goto L6
        }
    }

    static {
    }

    public DetailCustomFieldsAdapter(com.larksuite.framework.section.g r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAbility");
        super(new AnonymousClass1());
        this.f443175a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        FieldType r101 = getItem(r100).getType();
        if (r101 == FieldType.SINGLE_SELECT) goto L9;
        if (r101 == FieldType.MULTI_SELECT) goto L9;
        return r101.ordinal();
    L9:
        return getItem(r100).f443839d.hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        CustomFieldViewHolder r112 = (CustomFieldViewHolder) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        TodoCustomFieldData r113 = getItem(r111);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
        AppCompatImageView r100 = (AppCompatImageView) r112.itemView.findViewById(R.id.image_field_icon);
        int r101 = CustomFieldViewHolder.a.f443177a[r113.getType().ordinal()];
        if (r101 == 1) goto L14;
        if (r101 == 3) goto L13;
        if (r101 == 4) goto L12;
        if (r101 != 5) goto L8;
        int r102 = R.drawable.ud_icon_calendar_line_outlined;
    L15:
        r100.setImageResource(r102);
        ((TextView) r112.itemView.findViewById(R.id.text_field_name)).setText(r113.f443840e);
        r112.itemView.setOnClickListener(new b0(r112.f443176a, r113));
        ViewGroup r103 = (ViewGroup) r112.itemView.findViewById(R.id.layout_field_value);
        int r104 = r103.getChildCount();
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L19;
        View r106 = r103.getChildAt(r105);
        Intrinsics.checkNotNull(r106);
        com.larksuite.framework.section.utils.a.d(r106, false);
        r105 = r105 + 1;
        goto L16
    L19:
        if (r113.d() == true) goto L21;
        r112.T3(r113);
        return;
    L21:
        int r107 = CustomFieldViewHolder.a.f443177a[r113.getType().ordinal()];
        if (r107 != 1) goto L24;
        com.larksuite.framework.section.utils.a.d(r112.itemView.findViewById(R.id.layout_field_avatar), true);
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.e r108 = r113.f443844i;
        if (r108 == null) goto L38;
        List<TodoUser> r109 = r108.f443854b;
        if (r109 == null) goto L38;
    L40:
        if (r109.size() != 1) goto L42;
        boolean r114 = true;
    L44:
        if (r114 == false) goto L46;
        r112.itemView.findViewById(R.id.layout_field_avatar).setBackgroundResource(R.drawable.todo_keyboard_item_bg);
        com.larksuite.framework.section.utils.a.d(r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_text), true);
        ((TextView) r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_text)).setText(r113.a());
        com.larksuite.framework.section.utils.a.d(r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_close_icon), r113.f443838c);
        ((AppCompatImageView) r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_close_icon)).setOnClickListener(new v(r112.f443176a, r113));
    L47:
        TaskUDAvatarList r115 = (TaskUDAvatarList) r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_list_view);
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r109.iterator();
    L49:
        if (r117.hasNext() == false) goto L51;
        TodoUser r118 = (TodoUser) r117.next();
        r116.add(new c(r118.user_id, r118.avatar_key, false, 0));
        goto L49
    L51:
        if (r114 == false) goto L53;
        int r119 = R.color.bg_body_overlay;
    L54:
        r115.setAdapter(new d(r116, r119, 4));
        r115.setOverlapWidth(new UDDimension.b(4.0f));
        r115.setMaxCount(5);
        return;
    L53:
        r119 = R.color.bg_body;
        goto L54
    L46:
        r112.itemView.findViewById(R.id.layout_field_avatar).setBackgroundResource(0);
        com.larksuite.framework.section.utils.a.d(r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_text), false);
        com.larksuite.framework.section.utils.a.d(r112.itemView.findViewById(R.id.layout_field_avatar).findViewById(R.id.avatar_close_icon), false);
        goto L47
    L42:
        r114 = false;
    L38:
        r109 = CollectionsKt.emptyList();
        goto L40
    L24:
        if (r107 == 2) goto L33;
        if (r107 == 3) goto L33;
        if (r107 == 4) goto L28;
        r112.T3(r113);
        return;
    L28:
        com.larksuite.framework.section.utils.a.d(r112.itemView.findViewById(R.id.layout_rich_text_field_value), true);
        EllipsizeFrameLayout r120 = (EllipsizeFrameLayout) r112.itemView.findViewById(R.id.ellipsize_layout_text_field_value);
        r120.setEnableEllipsize(true);
        r120.setMaxHeightFactor(new EllipsizeFrameLayout.a(0.6f, 0.5f));
        r120.setEllipsizeListener(new w(r120, r112));
        ((TextView) r112.itemView.findViewById(R.id.text_field_value_more)).setOnClickListener(new x(r120));
        RichTextView r121 = (RichTextView) r112.itemView.findViewById(R.id.rich_text_field_value);
        r121.setAtTextColor(R.color.text_link_normal);
        r121.setTextSize(UIHelper.dp2px(14.0f));
        r121.setAtSelfTextColor(R.color.text_link_normal);
        r121.setAtOtherChatUserTextColor(R.color.text_link_normal);
        r121.setAtSelfBgColor(R.color.lkui_transparent);
        r121.setDefaultAtUserColor(UIHelper.getColor(R.color.text_link_normal));
        r121.setUrlTextColor(UIHelper.getColor(R.color.text_link_normal));
        r121.setShowImage(false);
        r121.setShowVideo(false);
        r121.setNeedToRecognizePhone(false);
        r121.setUrlStringClickListner(new y(r121));
        r121.setAtStringClickListner(new z(r121));
        com.ss.android.lark.todo.impl.features.detail.viewmodel.data.j r122 = r113.f443843h;
        if (r122 == null) goto L31;
        RichContent r123 = r122.f443863a;
    L32:
        r121.setInfo(j8c.f.a(r123));
        return;
    L31:
        r123 = null;
    L33:
        TagFlowLayout r124 = (TagFlowLayout) r112.itemView.findViewById(R.id.layout_field_tag);
        com.larksuite.framework.section.utils.a.d(r124, true);
        r124.post(new a0(r124, r113));
        r124.setClickable(false);
        return;
    L8:
        if (r101 == 6) goto L10;
        r102 = R.drawable.ud_icon_down_round_outlined;
        goto L15
    L10:
        r102 = R.drawable.ud_icon_number_outlined;
        goto L15
    L12:
        r102 = R.drawable.ud_icon_style_outlined;
        goto L15
    L13:
        r102 = R.drawable.ud_icon_multiple_outlined;
        goto L15
    L14:
        r102 = R.drawable.ud_icon_member_outlined;
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.todo_detail_item_custom_fields, r100, false);
        Intrinsics.checkNotNull(r102);
        return new CustomFieldViewHolder(this, r102);
    }
}
