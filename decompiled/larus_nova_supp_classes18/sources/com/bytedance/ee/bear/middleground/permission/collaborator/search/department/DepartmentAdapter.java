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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004;<=>B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u000eJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0014J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u001aJN\u0010&\u001a\u00020\u001c2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0010j\b\u0012\u0004\u0012\u00020\u0016`\u00122\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0011J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u0014J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020/H\u0016J\u0018\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020/H\u0016J\u0018\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00022\u0006\u00100\u001a\u00020/H\u0016J\u0012\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010:\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0010j\b\u0012\u0004\u0012\u00020\u0016`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0010j\b\u0012\u0004\u0012\u00020\u0018`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "userId", "", "canReAdd", "", "<init>", "(Ljava/lang/String;Z)V", "getUserId", "()Ljava/lang/String;", "getCanReAdd", "()Z", "department", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/Department;", "selectedDep", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleDepartment;", "Lkotlin/collections/ArrayList;", "selectedDepTopUser", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleTopUserInDep;", "originUserList", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "existsUserList", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/existmember/Member;", "itemClickListener", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter$DepItemClickListener;", "setDepartment", "", "newDepartment", "appendDepartment", "appendDep", "removeSelectedDep", "visibleDepartment", "removeSelectedTopUser", "visibleTopUserInDep", "setDepItemClickListener", "listener", "setOriginUsers", "originUsers", "selectedDeps", "selectedTopUsers", "addSelectedDep", "dep", "addSelectedTopUser", "topUser", "getItemViewType", "", "position", "getItemCount", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "isCollaborator", ResourceData.KEY_ID, "isSelf", "Companion", "DepViewHolder", "DepTopUserViewHolder", "DepItemClickListener", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DepartmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final String a;
    public final boolean b;
    public final Department c;
    public final ArrayList<VisibleDepartment> d;
    public final ArrayList<VisibleTopUserInDep> e;
    public final ArrayList<UserInfo> f;
    public final ArrayList<Member> g;
    public b h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter$DepTopUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter;Landroid/view/View;)V", "bindViewHolder", "", "topUserInDep", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleTopUserInDep;", "setEnable", "isCollaborator", "", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DepTopUserViewHolder extends RecyclerView.ViewHolder {
        public final /* synthetic */ DepartmentAdapter a;

        public DepTopUserViewHolder(DepartmentAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.a = r2;
            super(r3);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter$DepViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/DepartmentAdapter;Landroid/view/View;)V", "bindViewHolder", "", "dep", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/department/VisibleDepartment;", "setNextEnable", "isSelected", "", "isCollaborator", "setEnable", "middleground-permission-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DepViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int b = 0;
        public final /* synthetic */ DepartmentAdapter a;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ boolean a;
            public final /* synthetic */ DepartmentAdapter b;
            public final /* synthetic */ VisibleDepartment c;
            public final /* synthetic */ boolean d;

            public a(boolean r1, DepartmentAdapter r2, VisibleDepartment r3, boolean r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r3) {
                if (this.a == true) goto L8;
                b r4 = this.b.h;
                if (r4 == null) goto L9;
                r4.P(this.c, this.d);
                return;
            L9:
                return;
            }
        }

        public DepViewHolder(DepartmentAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.a = r2;
            super(r3);
        }

        public final void T3(boolean r4, boolean r5, VisibleDepartment r6) {
            TextView r0 = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131382112);
            if (r4 == true) goto L7;
            if (r5 == true) goto L7;
            float r2 = 1.0f;
        L8:
            r0.setAlpha(r2);
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131382112)).setOnClickListener(new a(r5, this.a, r6, r4));
            return;
        L7:
            r2 = 0.3f;
            goto L8
        }
    }

    public static final class a {
    }

    public interface b {
        void D(VisibleDepartment r1, boolean r2);

        void P(VisibleDepartment r1, boolean r2);

        void k(VisibleTopUserInDep r1, boolean r2);
    }

    static {
    }

    public final int getItemCount() {
        return this.c.getVisibleDepartments().size() + this.c.getVisibleTopUserInDep().size();
    }

    public final int getItemViewType(int r2) {
        if (r2 >= this.c.getVisibleDepartments().size()) goto L5;
        return 0;
    L5:
        return 1;
    }

    public final void z2(Department r3) {
        Intrinsics.checkNotNullParameter(r3, "appendDep");
        if (r3.getVisibleDepartments().size() <= 0) goto L6;
        this.c.getVisibleDepartments().addAll(r3.getVisibleDepartments());
    L6:
        if (r3.getVisibleTopUserInDep().size() <= 0) goto L9;
        this.c.getVisibleTopUserInDep().addAll(r3.getVisibleTopUserInDep());
    L9:
        if (r3.getExistsMembers().size() <= 0) goto L11;
        this.g.addAll(r3.getExistsMembers());
    L11:
        notifyDataSetChanged();
    }

    public DepartmentAdapter(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        this.a = r9;
        this.b = r10;
        this.c = new Department(null, null, false, null, 15, null);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static final boolean y2(DepartmentAdapter r6, String r7) {
        if (r6.b == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r6.a) == false) goto L8;
    L10:
        Iterator<Member> r0 = r6.g.iterator();
    L12:
        if (r0.hasNext() == false) goto L16;
        if (TextUtils.equals(r7, r0.next().getMemberId()) == false) goto L12;
    L9:
        return true;
    L16:
        ArrayList<UserInfo> r8 = r6.f;
        ArrayList r1 = new ArrayList();
        Iterator<UserInfo> r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L25;
        UserInfo r3 = r9.next();
        if (r3.getOwnerType() == 108) goto L22;
        boolean r4 = true;
    L23:
        if (r4 == false) goto L18;
        r1.add(r3);
        goto L18
    L22:
        r4 = false;
        goto L23
    L25:
        Iterator r10 = r1.iterator();
    L27:
        if (r10.hasNext() == false) goto L31;
        Object r2 = r10.next();
        if (TextUtils.equals(r7, ((UserInfo) r2).getId()) == false) goto L27;
    L33:
        if (((UserInfo) r2) != null) goto L9;
        return false;
    L31:
        r2 = null;
        goto L33
    L8:
        if (TextUtils.equals(r7, r6.a) == false) goto L10;
        goto L9
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        float r1 = 1.0f;
        boolean r3 = false;
        if ((r11 instanceof DepViewHolder) == false) goto L14;
        VisibleDepartment r13 = (VisibleDepartment) ListProtector.get(this.c.getVisibleDepartments(), r12);
        DepViewHolder r14 = (DepViewHolder) r11;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "dep");
        boolean r0 = y2(r14.a, r13.a);
        boolean r5 = r14.a.d.contains(r13);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131382111)).setText(r13.b);
        UDCheckBox r6 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131382106);
        if (r5 == true) goto L7;
        if (r0 == true) goto L7;
    L8:
        r6.setChecked(r3);
        r14.T3(r5, r0, r13);
        boolean r4 = !r0;
        if (r4 == true) goto L12;
        r1 = 0.3f;
    L12:
        ((RecyclerView.ViewHolder) r14).itemView.setEnabled(r4);
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131382106).setAlpha(r1);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131382111)).setAlpha(r1);
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new com.bytedance.ee.bear.middleground.permission.collaborator.search.department.b(r14, r14.a, r13, r0));
        return;
    L7:
        r3 = true;
        goto L8
    L14:
        if ((r11 instanceof DepTopUserViewHolder) == false) goto L38;
        VisibleTopUserInDep r15 = (VisibleTopUserInDep) ListProtector.get(this.c.getVisibleTopUserInDep(), r12 - this.c.getVisibleDepartments().size());
        DepTopUserViewHolder r16 = (DepTopUserViewHolder) r11;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "topUserInDep");
        Glide.with(((RecyclerView.ViewHolder) r16).itemView).load(new BearGlideUrl(r15.c)).placeholder(2131235295).into((ImageView) ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131382116));
        DepartmentAdapter r2 = r16.a;
        String r7 = r15.a;
        if (TextUtils.isEmpty(r2.a) == false) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == false) goto L23;
    L26:
        boolean r9 = true;
    L27:
        ((TextView) ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131382118)).setText(r15.b);
        UDCheckBox r10 = ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131382117);
        if (r16.a.e.contains(r15) == true) goto L30;
        if (r9 == true) goto L30;
    L31:
        r10.setChecked(r3);
        ((RecyclerView.ViewHolder) r16).itemView.setOnClickListener(new com.bytedance.ee.bear.middleground.permission.collaborator.search.department.a(r16.a, r15, r16));
        boolean r17 = !r9;
        if (r17 == true) goto L35;
        r1 = 0.3f;
    L35:
        ((RecyclerView.ViewHolder) r16).itemView.setEnabled(r17);
        ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131382117).setAlpha(r1);
        ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131382116).setAlpha(r1);
        ((TextView) ((RecyclerView.ViewHolder) r16).itemView.findViewById(2131382118)).setAlpha(r1);
        return;
    L30:
        r3 = true;
        goto L31
    L23:
        if (y2(r16.a, r15.a) == true) goto L26;
        r9 = false;
        goto L27
    L18:
        if (TextUtils.equals(r7, r2.a) == false) goto L20;
        r8 = true;
        goto L21
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        LayoutInflater r0 = LayoutInflater.from(r3.getContext());
        if (r4 != 0) goto L5;
        View r5 = r0.inflate(2131564179, r3, false);
        Intrinsics.checkNotNull(r5);
        return new DepViewHolder(this, r5);
    L5:
        View r6 = r0.inflate(2131564180, r3, false);
        Intrinsics.checkNotNull(r6);
        return new DepTopUserViewHolder(this, r6);
    }
}
