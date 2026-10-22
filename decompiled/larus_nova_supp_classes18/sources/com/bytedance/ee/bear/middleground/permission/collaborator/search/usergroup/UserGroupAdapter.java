package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003./0B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u00020\u00182\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012J\u001e\u0010\u001c\u001a\u00020\u00182\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00060\u0002R\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020$H\u0016J\u001c\u0010)\u001a\u00020\u00182\n\u0010*\u001a\u00060\u0002R\u00020\u00002\u0006\u0010+\u001a\u00020$H\u0016J\u0012\u0010,\u001a\u00020\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0010j\b\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter$UserGroupViewHolder;", "userId", "", "canReAdd", "", "<init>", "(Ljava/lang/String;Z)V", "getUserId", "()Ljava/lang/String;", "getCanReAdd", "()Z", "visibleUserGroupResult", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/GetUserGroupResult;", "selectedUserGroupList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroup;", "Lkotlin/collections/ArrayList;", "originUserList", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "itemClickListener", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter$OnItemClickListener;", "setVisibleUserGroup", "", "visibleUserGroup", "setOriginUsers", "originUsers", "setSelectUserGroups", "selectedUserGroups", "removeSelectedDep", "userGroup", "addSelectedUserGroup", "setItemClickListener", "listener", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "isCollaborator", ResourceData.KEY_ID, "Companion", "UserGroupViewHolder", "OnItemClickListener", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserGroupAdapter extends RecyclerView.Adapter<UserGroupViewHolder> {
    public final boolean a;
    public GetUserGroupResult b;
    public final ArrayList<UserGroup> c;
    public final ArrayList<UserInfo> d;
    public b e;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter$UserGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroupAdapter;Landroid/view/View;)V", "bindViewHolder", "", "userGroup", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/usergroup/UserGroup;", "setEnable", "isCollaborator", "", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class UserGroupViewHolder extends RecyclerView.ViewHolder {
        public final /* synthetic */ UserGroupAdapter a;

        public UserGroupViewHolder(UserGroupAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.a = r2;
            super(r3);
        }
    }

    public static final class a {
    }

    public interface b {
        void h(UserGroup r1, boolean r2);
    }

    static {
    }

    public final int getItemCount() {
        return hu5.a.c(this.b.getVisibleGroups());
    }

    public UserGroupAdapter(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.a = r3;
        this.b = new GetUserGroupResult();
        this.c = new ArrayList();
        this.d = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        UserGroupViewHolder r11 = (UserGroupViewHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        UserGroup r12 = (UserGroup) ListProtector.get(this.b.getVisibleGroups(), r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "userGroup");
        UserGroupAdapter r0 = r11.a;
        String r1 = r12.a;
        boolean r3 = false;
        if (r0.a == true) goto L32;
        List<Member> r2 = r0.b.getExistsMembers();
        if (r2 == null) goto L13;
        Iterator<T> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if (TextUtils.equals(r1, ((Member) r4.next()).getMemberId()) == false) goto L9;
    L31:
        boolean r5 = true;
    L33:
        boolean r6 = r11.a.c.contains(r12);
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131386091).setTitle(r12.b);
        UDCheckBox r7 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131386067);
        if (r6 == true) goto L36;
        if (r5 == true) goto L36;
    L37:
        r7.setChecked(r3);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131386094)).setVisibility(8);
        boolean r8 = !r5;
        if (r8 == false) goto L40;
        float r13 = 1.0f;
    L41:
        ((RecyclerView.ViewHolder) r11).itemView.setEnabled(r8);
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131386067).setAlpha(r13);
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131386091).setAlpha(r13);
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new f(r11, r11.a, r12));
        return;
    L40:
        r13 = 0.3f;
    L36:
        r3 = true;
    L13:
        ArrayList<UserInfo> r14 = r0.d;
        ArrayList r15 = new ArrayList();
        Iterator<UserInfo> r16 = r14.iterator();
    L15:
        if (r16.hasNext() == false) goto L22;
        UserInfo r17 = r16.next();
        if (r17.getOwnerType() == 108) goto L19;
        boolean r18 = true;
    L20:
        if (r18 == false) goto L15;
        r15.add(r17);
        goto L15
    L19:
        r18 = false;
        goto L20
    L22:
        Iterator r19 = r15.iterator();
    L24:
        if (r19.hasNext() == false) goto L28;
        Object r20 = r19.next();
        if (TextUtils.equals(r1, ((UserInfo) r20).getId()) == false) goto L24;
    L30:
        if (((UserInfo) r20) == null) goto L32;
    L28:
        r20 = null;
    L32:
        r5 = false;
        goto L33
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new UserGroupViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131564195, r4, false));
    }
}
