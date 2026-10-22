package com.ss.android.lark.picker.doubao.organization;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mtb.c;
import mtb.i;
import mtb.j;
import uz7.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003)*+BC\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u001c\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 H\u0016J\u0018\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010(\u001a\u00020 H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemState", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "onSelect", "", "onNextLevel", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "nextLevelTitle", "", "getNextLevelTitle", "()Ljava/lang/String;", "setNextLevelTitle", "(Ljava/lang/String;)V", "isDepartmentSelectable", "", "()Z", "setDepartmentSelectable", "(Z)V", "isMultipleSelect", "setMultipleSelect", "items", "", LocationMonitorConst.SUBMIT, "data", "", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getItemCount", "Companion", "DepartmentHolder", "UserHolder", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class OrganizationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = null;
    private static final int TYPE_DEPARTMENT = 1;
    private static final int TYPE_USER = 2;
    private boolean isDepartmentSelectable;
    private boolean isMultipleSelect;
    private final Function1<c, DoubaoOrganizationItemState> itemState;
    private final List<c> items;
    private String nextLevelTitle;
    private final Function1<i, Unit> onNextLevel;
    private final Function1<c, Unit> onSelect;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter$Companion;", "", "<init>", "()V", "TYPE_DEPARTMENT", "", "TYPE_USER", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JV\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter$DepartmentHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "checkboxContainer", "checkbox", "Landroid/widget/ImageView;", "subtitle", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuDepartmentItem;", "state", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "nextLevelTitle", "", "isDepartmentSelectable", "", "isMultipleSelect", "onSelect", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "onNextLevel", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DepartmentHolder extends RecyclerView.ViewHolder {
        private final ImageView checkbox;
        private final View checkboxContainer;
        private final TextView subtitle;
        private final TextView title;

        public DepartmentHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.title = (TextView) r100.findViewById(R.id.organization_item_title);
            this.checkboxContainer = r100.findViewById(R.id.organization_checkbox);
            this.checkbox = (ImageView) r100.findViewById(R.id.iv_doubao_checkbox);
            this.subtitle = (TextView) r100.findViewById(R.id.organization_item_subtitle);
        }

        public final void bind(final i r100, final DoubaoOrganizationItemState r101, String r110, boolean r111, boolean r112, final Function1<? super c, Unit> r113, final Function1<? super i, Unit> r114) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r110, "nextLevelTitle");
            Intrinsics.checkNotNullParameter(r113, "onSelect");
            Intrinsics.checkNotNullParameter(r114, "onNextLevel");
            int r102 = 0;
            if (r112 == false) goto L6;
            if (r111 == false) goto L6;
            boolean r115 = true;
        L7:
            this.title.setText(r100.f515684a);
            this.subtitle.setText(r110);
            View r116 = this.checkboxContainer;
            if (r115 == true) goto L11;
            r102 = 8;
        L11:
            r116.setVisibility(r102);
            ImageView r117 = this.checkbox;
            if (r101.isSelected() == false) goto L14;
            int r118 = R.drawable.ic_doubao_checkbox_checked;
        L15:
            r117.setImageResource(r118);
            this.checkbox.setEnabled(r101.isEnabled());
            ImageView r119 = this.checkbox;
            float r103 = 1.0f;
            if (r101.isEnabled() == false) goto L18;
            float r120 = 1.0f;
        L19:
            r119.setAlpha(r120);
            TextView r121 = this.subtitle;
            if (r115 == true) goto L22;
        L24:
            r121.setAlpha(r103);
            final boolean r104 = r115;
            this.itemView.setOnClickListener(new OrganizationAdapter$DepartmentHolder$bind$1(r104, r101, r113, r100, r114));
            this.subtitle.setOnClickListener(new OrganizationAdapter$DepartmentHolder$bind$2(r104, r101, this, r114, r100));
            return;
        L22:
            if (r101.isSelected() == false) goto L24;
            r103 = 0.4f;
            goto L24
        L18:
            r120 = 0.4f;
            goto L19
        L14:
            r118 = R.drawable.ic_doubao_checkbox_unchecked;
        L6:
            r115 = false;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000e0\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/picker/doubao/organization/OrganizationAdapter$UserHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "checkboxContainer", "checkbox", "Landroid/widget/ImageView;", "avatar", "Lcom/larksuite/component/ui/avatar/v2/LarkAvatarView;", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeFeishuUserItem;", "state", "Lcom/ss/android/lark/picker/doubao/organization/DoubaoOrganizationItemState;", "isMultipleSelect", "", "onSelect", "Lkotlin/Function1;", "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactEnterpriseModel;", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserHolder extends RecyclerView.ViewHolder {
        private final LarkAvatarView avatar;
        private final ImageView checkbox;
        private final View checkboxContainer;
        private final TextView title;

        public UserHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.title = (TextView) r100.findViewById(R.id.organization_item_title);
            this.checkboxContainer = r100.findViewById(R.id.organization_checkbox);
            this.checkbox = (ImageView) r100.findViewById(R.id.iv_doubao_checkbox);
            this.avatar = (LarkAvatarView) r100.findViewById(R.id.organization_user_avatar);
        }

        public final void bind(final j r100, DoubaoOrganizationItemState r101, boolean r102, final Function1<? super c, Unit> r103) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "state");
            Intrinsics.checkNotNullParameter(r103, "onSelect");
            this.title.setText(r100.f515686a);
            View r104 = this.checkboxContainer;
            if (r102 == false) goto L5;
            int r105 = 0;
        L6:
            r104.setVisibility(r105);
            ImageView r106 = this.checkbox;
            if (r101.isSelected() == false) goto L9;
            int r107 = R.drawable.ic_doubao_checkbox_checked;
        L10:
            r106.setImageResource(r107);
            this.checkbox.setEnabled(r101.isEnabled());
            View r108 = this.itemView;
            if (r101.isEnabled() == false) goto L13;
            float r109 = 1.0f;
        L14:
            r108.setAlpha(r109);
            LarkAvatarView r110 = this.avatar;
            a.C7948a r111 = new a.C7948a();
            r111.b(r100.f515688c);
            r111.f(r100.f515687b);
            r110.j(new a(r111));
            this.itemView.setOnClickListener(new OrganizationAdapter$UserHolder$bind$1(r103, r100));
            return;
        L13:
            r109 = 0.4f;
            goto L14
        L9:
            r107 = R.drawable.ic_doubao_checkbox_unchecked;
            goto L10
        L5:
            r105 = 8;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public final String getNextLevelTitle() {
        return this.nextLevelTitle;
    }

    public final boolean isDepartmentSelectable() {
        return this.isDepartmentSelectable;
    }

    public final boolean isMultipleSelect() {
        return this.isMultipleSelect;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r100) {
        c r101 = (c) ListProtector.get(this.items, r100);
        if ((r101 instanceof i) == false) goto L6;
        return 1;
    L6:
        if ((r101 instanceof j) == false) goto L10;
        return 2;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void setDepartmentSelectable(boolean r100) {
        this.isDepartmentSelectable = r100;
    }

    public final void setMultipleSelect(boolean r100) {
        this.isMultipleSelect = r100;
    }

    public final void setNextLevelTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nextLevelTitle = r100;
    }

    public final void submit(List<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.items.clear();
        this.items.addAll(r100);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        c r112 = (c) ListProtector.get(this.items, r111);
        if ((r110 instanceof DepartmentHolder) == false) goto L8;
        if ((r112 instanceof i) == false) goto L8;
        ((DepartmentHolder) r110).bind((i) r112, this.itemState.invoke(r112), this.nextLevelTitle, this.isDepartmentSelectable, this.isMultipleSelect, this.onSelect, this.onNextLevel);
        return;
    L8:
        if ((r110 instanceof UserHolder) == true) goto L10;
        return;
    L10:
        if ((r112 instanceof j) == false) goto L15;
        ((UserHolder) r110).bind((j) r112, this.itemState.invoke(r112), this.isMultipleSelect, this.onSelect);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 1) goto L6;
        return new DepartmentHolder(r102.inflate(R.layout.item_doubao_organization_department, r100, false));
    L6:
        return new UserHolder(r102.inflate(R.layout.item_doubao_organization_user, r100, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OrganizationAdapter(Function1<? super c, DoubaoOrganizationItemState> r100, Function1<? super c, Unit> r101, Function1<? super i, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemState");
        Intrinsics.checkNotNullParameter(r101, "onSelect");
        Intrinsics.checkNotNullParameter(r102, "onNextLevel");
        this.itemState = r100;
        this.onSelect = r101;
        this.onNextLevel = r102;
        this.nextLevelTitle = "";
        this.items = new ArrayList();
    }
}
