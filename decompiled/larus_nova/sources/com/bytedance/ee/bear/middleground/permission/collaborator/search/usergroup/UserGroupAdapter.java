package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.CustomTitleView;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003./0B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u00020\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012J\u001e\u0010\u001c\u001a\u00020\u00182\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020$H\u0016J\u001c\u0010)\u001a\u00020\u00182\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010+\u001a\u00020$H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter$UserGroupViewHolder;", "userId", "", "canReAdd", "", "<init>", "(Ljava/lang/String;Z)V", "getUserId", "()Ljava/lang/String;", "getCanReAdd", "()Z", "visibleUserGroupResult", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/GetUserGroupResult;", "selectedUserGroupList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroup;", "Lkotlin/collections/ArrayList;", "originUserList", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "itemClickListener", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter$OnItemClickListener;", "setVisibleUserGroup", "", "visibleUserGroup", "setOriginUsers", "originUsers", "setSelectUserGroups", "selectedUserGroups", "removeSelectedDep", "userGroup", "addSelectedUserGroup", "setItemClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "isCollaborator", "id", "Companion", "UserGroupViewHolder", "OnItemClickListener", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGroupAdapter extends RecyclerView.Adapter<UserGroupViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f233645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public GetUserGroupResult f233646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<UserGroup> f233647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<UserInfo> f233648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f233649e;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter$UserGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter;Landroid/view/View;)V", "bindViewHolder", "", "userGroup", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroup;", "setEnable", "isCollaborator", "", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class UserGroupViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserGroupAdapter f233650a;

        public UserGroupViewHolder(UserGroupAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f233650a = r100;
            super(r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void h(UserGroup r100, boolean r101);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return hu5.a.c(this.f233646b.getVisibleGroups());
    }

    public UserGroupAdapter(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f233645a = r101;
        this.f233646b = new GetUserGroupResult();
        this.f233647c = new ArrayList();
        this.f233648d = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        UserGroupViewHolder r101 = (UserGroupViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        UserGroup r111 = (UserGroup) ListProtector.get(this.f233646b.getVisibleGroups(), r110);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r111, "userGroup");
        UserGroupAdapter r102 = r101.f233650a;
        String r103 = r111.f233642a;
        boolean r104 = false;
        if (r102.f233645a == true) goto L32;
        List<Member> r105 = r102.f233646b.getExistsMembers();
        if (r105 == null) goto L13;
        Iterator<T> r106 = r105.iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        if (TextUtils.equals(r103, ((Member) r106.next()).getMemberId()) == false) goto L9;
    L31:
        boolean r107 = true;
    L33:
        boolean r108 = r101.f233650a.f233647c.contains(r111);
        ((CustomTitleView) r101.itemView.findViewById(R.id.share_item_name)).setTitle(r111.f233643b);
        UDCheckBox r109 = (UDCheckBox) r101.itemView.findViewById(R.id.share_checkbox);
        if (r108 == true) goto L36;
        if (r107 == true) goto L36;
    L37:
        r109.setChecked(r104);
        ((TextView) r101.itemView.findViewById(R.id.share_item_subtitle)).setVisibility(8);
        boolean r112 = !r107;
        if (r112 == false) goto L40;
        float r113 = 1.0f;
    L41:
        r101.itemView.setEnabled(r112);
        ((UDCheckBox) r101.itemView.findViewById(R.id.share_checkbox)).setAlpha(r113);
        ((CustomTitleView) r101.itemView.findViewById(R.id.share_item_name)).setAlpha(r113);
        r101.itemView.setOnClickListener(new f(r101, r101.f233650a, r111));
        return;
    L40:
        r113 = 0.3f;
    L36:
        r104 = true;
    L13:
        ArrayList<UserInfo> r114 = r102.f233648d;
        ArrayList r115 = new ArrayList();
        Iterator<UserInfo> r116 = r114.iterator();
    L15:
        if (r116.hasNext() == false) goto L22;
        UserInfo r117 = r116.next();
        if (r117.getOwnerType() == 108) goto L19;
        boolean r118 = true;
    L20:
        if (r118 == false) goto L15;
        r115.add(r117);
        goto L15
    L19:
        r118 = false;
        goto L20
    L22:
        Iterator r119 = r115.iterator();
    L24:
        if (r119.hasNext() == false) goto L28;
        Object r120 = r119.next();
        if (TextUtils.equals(r103, ((UserInfo) r120).getId()) == false) goto L24;
    L30:
        if (((UserInfo) r120) == null) goto L32;
    L28:
        r120 = null;
    L32:
        r107 = false;
        goto L33
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new UserGroupViewHolder(this, LayoutInflater.from(r100.getContext()).inflate(R.layout.permission_user_group_item, r100, false));
    }
}
