package com.bytedance.ee.bear.middleground.permission.collaborator.search.department;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004;<=>B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0014J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001aJN\u0010&\u001a\u00020\u001c2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0010j\b\u0012\u0004\u0012\u00020\u0016`\u00122\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0011J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0014J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020/H\u0016J\u0018\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020/H\u0016J\u0018\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016J\u0012\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010:\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0010j\b\u0012\u0004\u0012\u00020\u0016`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0010j\b\u0012\u0004\u0012\u00020\u0018`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "userId", "", "canReAdd", "", "<init>", "(Ljava/lang/String;Z)V", "getUserId", "()Ljava/lang/String;", "getCanReAdd", "()Z", "department", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/Department;", "selectedDep", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleDepartment;", "Lkotlin/collections/ArrayList;", "selectedDepTopUser", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleTopUserInDep;", "originUserList", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "existsUserList", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/existmember/Member;", "itemClickListener", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter$DepItemClickListener;", "setDepartment", "", "newDepartment", "appendDepartment", "appendDep", "removeSelectedDep", "visibleDepartment", "removeSelectedTopUser", "visibleTopUserInDep", "setDepItemClickListener", "listener", "setOriginUsers", "originUsers", "selectedDeps", "selectedTopUsers", "addSelectedDep", "dep", "addSelectedTopUser", "topUser", "getItemViewType", "", "position", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "isCollaborator", "id", "isSelf", "Companion", "DepViewHolder", "DepTopUserViewHolder", "DepItemClickListener", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f233417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f233418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Department f233419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<VisibleDepartment> f233420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<VisibleTopUserInDep> f233421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<UserInfo> f233422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Member> f233423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f233424h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter$DepTopUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter;Landroid/view/View;)V", "bindViewHolder", "", "topUserInDep", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleTopUserInDep;", "setEnable", "isCollaborator", "", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DepTopUserViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DepartmentAdapter f233425a;

        public DepTopUserViewHolder(DepartmentAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f233425a = r100;
            super(r101);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter$DepViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter;Landroid/view/View;)V", "bindViewHolder", "", "dep", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleDepartment;", "setNextEnable", "isSelected", "", "isCollaborator", "setEnable", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DepViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int f233426b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DepartmentAdapter f233427a;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f233428a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ DepartmentAdapter f233429b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ VisibleDepartment f233430c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ boolean f233431d;

            public a(boolean r100, DepartmentAdapter r101, VisibleDepartment r102, boolean r103) {
                this.f233428a = r100;
                this.f233429b = r101;
                this.f233430c = r102;
                this.f233431d = r103;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                if (this.f233428a == true) goto L8;
                b r101 = this.f233429b.f233424h;
                if (r101 == null) goto L9;
                r101.P(this.f233430c, this.f233431d);
                return;
            L9:
                return;
            }
        }

        public DepViewHolder(DepartmentAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f233427a = r100;
            super(r101);
        }

        public final void T3(boolean r100, boolean r101, VisibleDepartment r102) {
            TextView r103 = (TextView) this.itemView.findViewById(R.id.permDepNext);
            if (r100 == true) goto L7;
            if (r101 == true) goto L7;
            float r104 = 1.0f;
        L8:
            r103.setAlpha(r104);
            ((TextView) this.itemView.findViewById(R.id.permDepNext)).setOnClickListener(new a(r101, this.f233427a, r102, r100));
            return;
        L7:
            r104 = 0.3f;
            goto L8
        }
    }

    public static final class a {
    }

    public interface b {
        void D(VisibleDepartment r100, boolean r101);

        void P(VisibleDepartment r100, boolean r101);

        void k(VisibleTopUserInDep r100, boolean r101);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f233419c.getVisibleDepartments().size() + this.f233419c.getVisibleTopUserInDep().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        if (r100 >= this.f233419c.getVisibleDepartments().size()) goto L5;
        return 0;
    L5:
        return 1;
    }

    public final void z2(Department r100) {
        Intrinsics.checkNotNullParameter(r100, "appendDep");
        if (r100.getVisibleDepartments().size() <= 0) goto L6;
        this.f233419c.getVisibleDepartments().addAll(r100.getVisibleDepartments());
    L6:
        if (r100.getVisibleTopUserInDep().size() <= 0) goto L9;
        this.f233419c.getVisibleTopUserInDep().addAll(r100.getVisibleTopUserInDep());
    L9:
        if (r100.getExistsMembers().size() <= 0) goto L11;
        this.f233423g.addAll(r100.getExistsMembers());
    L11:
        notifyDataSetChanged();
    }

    public DepartmentAdapter(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f233417a = r100;
        this.f233418b = r110;
        this.f233419c = new Department(null, null, false, null, 15, null);
        this.f233420d = new ArrayList();
        this.f233421e = new ArrayList();
        this.f233422f = new ArrayList();
        this.f233423g = new ArrayList();
    }

    public static final boolean y2(DepartmentAdapter r100, String r101) {
        if (r100.f233418b == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r100.f233417a) == false) goto L8;
    L10:
        Iterator<Member> r102 = r100.f233423g.iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        if (TextUtils.equals(r101, r102.next().getMemberId()) == false) goto L12;
    L9:
        return true;
    L16:
        ArrayList<UserInfo> r103 = r100.f233422f;
        ArrayList r104 = new ArrayList();
        Iterator<UserInfo> r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L25;
        UserInfo r106 = r105.next();
        if (r106.getOwnerType() == 108) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L18;
        r104.add(r106);
        goto L18
    L22:
        r107 = false;
        goto L23
    L25:
        Iterator r108 = r104.iterator();
    L27:
        if (r108.hasNext() == false) goto L31;
        Object r109 = r108.next();
        if (TextUtils.equals(r101, ((UserInfo) r109).getId()) == false) goto L27;
    L33:
        if (((UserInfo) r109) != null) goto L9;
        return false;
    L31:
        r109 = null;
        goto L33
    L8:
        if (TextUtils.equals(r101, r100.f233417a) == false) goto L10;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        float r100 = 1.0f;
        boolean r101 = false;
        if ((r110 instanceof DepViewHolder) == false) goto L14;
        VisibleDepartment r112 = (VisibleDepartment) ListProtector.get(this.f233419c.getVisibleDepartments(), r111);
        DepViewHolder r113 = (DepViewHolder) r110;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r112, "dep");
        boolean r102 = y2(r113.f233427a, r112.f233444a);
        boolean r103 = r113.f233427a.f233420d.contains(r112);
        ((TextView) r113.itemView.findViewById(R.id.permDepName)).setText(r112.f233445b);
        UDCheckBox r104 = (UDCheckBox) r113.itemView.findViewById(R.id.permDepCheckbox);
        if (r103 == true) goto L7;
        if (r102 == true) goto L7;
    L8:
        r104.setChecked(r101);
        r113.T3(r103, r102, r112);
        boolean r105 = !r102;
        if (r105 == true) goto L12;
        r100 = 0.3f;
    L12:
        r113.itemView.setEnabled(r105);
        ((UDCheckBox) r113.itemView.findViewById(R.id.permDepCheckbox)).setAlpha(r100);
        ((TextView) r113.itemView.findViewById(R.id.permDepName)).setAlpha(r100);
        r113.itemView.setOnClickListener(new com.bytedance.ee.bear.middleground.permission.collaborator.search.department.b(r113, r113.f233427a, r112, r102));
        return;
    L7:
        r101 = true;
        goto L8
    L14:
        if ((r110 instanceof DepTopUserViewHolder) == false) goto L38;
        VisibleTopUserInDep r114 = (VisibleTopUserInDep) ListProtector.get(this.f233419c.getVisibleTopUserInDep(), r111 - this.f233419c.getVisibleDepartments().size());
        DepTopUserViewHolder r115 = (DepTopUserViewHolder) r110;
        r115.getClass();
        Intrinsics.checkNotNullParameter(r114, "topUserInDep");
        Glide.with(r115.itemView).load(new BearGlideUrl(r114.f233449c)).placeholder(R.drawable.facade_common_avatar_place_holder).into((ImageView) r115.itemView.findViewById(R.id.permDepTopUserAvatar));
        DepartmentAdapter r106 = r115.f233425a;
        String r107 = r114.f233447a;
        if (TextUtils.isEmpty(r106.f233417a) == false) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == false) goto L23;
    L26:
        boolean r109 = true;
    L27:
        ((TextView) r115.itemView.findViewById(R.id.permDepTopUserName)).setText(r114.f233448b);
        UDCheckBox r116 = (UDCheckBox) r115.itemView.findViewById(R.id.permDepTopUserCheckbox);
        if (r115.f233425a.f233421e.contains(r114) == true) goto L30;
        if (r109 == true) goto L30;
    L31:
        r116.setChecked(r101);
        r115.itemView.setOnClickListener(new com.bytedance.ee.bear.middleground.permission.collaborator.search.department.a(r115.f233425a, r114, r115));
        boolean r117 = !r109;
        if (r117 == true) goto L35;
        r100 = 0.3f;
    L35:
        r115.itemView.setEnabled(r117);
        ((UDCheckBox) r115.itemView.findViewById(R.id.permDepTopUserCheckbox)).setAlpha(r100);
        ((UDAvatar) r115.itemView.findViewById(R.id.permDepTopUserAvatar)).setAlpha(r100);
        ((TextView) r115.itemView.findViewById(R.id.permDepTopUserName)).setAlpha(r100);
        return;
    L30:
        r101 = true;
        goto L31
    L23:
        if (y2(r115.f233425a, r114.f233447a) == true) goto L26;
        r109 = false;
        goto L27
    L18:
        if (TextUtils.equals(r107, r106.f233417a) == false) goto L20;
        r108 = true;
        goto L21
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LayoutInflater r102 = LayoutInflater.from(r100.getContext());
        if (r101 != 0) goto L5;
        View r103 = r102.inflate(R.layout.permission_dep_item, r100, false);
        Intrinsics.checkNotNull(r103);
        return new DepViewHolder(this, r103);
    L5:
        View r104 = r102.inflate(R.layout.permission_dep_top_user_item, r100, false);
        Intrinsics.checkNotNull(r104);
        return new DepTopUserViewHolder(this, r104);
    }
}
