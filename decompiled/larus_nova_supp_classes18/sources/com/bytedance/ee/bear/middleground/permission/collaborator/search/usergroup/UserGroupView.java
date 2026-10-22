package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class UserGroupView implements b, UserGroupAdapter.b {
    public final Context a;
    public final View b;
    public final String c;
    public final boolean d;
    public UserGroupAdapter e;
    public b.a f;

    public static final class a implements View.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public final void destroy() {
    }

    public final void create() {
        this.e = new UserGroupAdapter(this.c, this.d);
        RecyclerView r0 = this.b.findViewById(2131382120);
        UserGroupAdapter r2 = this.e;
        UserGroupAdapter r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L5:
        r0.setAdapter(r2);
        this.b.findViewById(2131382120).setLayoutManager(new LinearLayoutManager(this.a));
        UserGroupAdapter r1 = this.e;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r3.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r3.e = this;
        this.b.findViewById(2131382120).addOnScrollListener(new AnonymousClass1());
        this.b.setOnClickListener(a.a);
        return;
    L8:
        r3 = r1;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void hideLoading() {
        this.b.findViewById(2131382121).cancelAnimation();
        this.b.findViewById(2131382121).setVisibility(8);
        this.b.findViewById(2131382120).setVisibility(0);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void showLoading() {
        this.b.findViewById(2131382120).setVisibility(8);
        this.b.findViewById(2131382121).playAnimation();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void E0(UserGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "userGroup");
        UserGroupAdapter r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "userGroup");
        if (r1.c.contains(r3) == false) goto L9;
        r1.c.remove(r3);
        r1.notifyDataSetChanged();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void Y2(GetUserGroupResult r3) {
        Intrinsics.checkNotNullParameter(r3, "visibleUserGroups");
        UserGroupAdapter r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "visibleUserGroup");
        r0.b = r3;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void a1(UserGroup r3) {
        Intrinsics.checkNotNullParameter(r3, "userGroup");
        UserGroupAdapter r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r1 = null;
    L5:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "userGroup");
        if (r1.c.contains(r3) == true) goto L9;
        r1.c.add(r3);
        r1.notifyDataSetChanged();
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.f = (b.a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.UserGroupAdapter.b
    public final void h(UserGroup r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "userGroup");
        if (r3 == false) goto L7;
        b.a r4 = this.f;
        if (r4 == null) goto L11;
        r4.S1(r2);
        return;
    L11:
        return;
    L7:
        b.a r5 = this.f;
        if (r5 == null) goto L13;
        r5.z8(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.b
    public final void n3(ArrayList<UserInfo> r6, ArrayList<UserGroup> r7) {
        Intrinsics.checkNotNullParameter(r6, "originUsers");
        Intrinsics.checkNotNullParameter(r7, "selectedUserGroups");
        UserGroupAdapter r2 = this.e;
        UserGroupAdapter r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L5:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r6, "originUsers");
        r2.d.clear();
        r2.d.addAll(r6);
        UserGroupAdapter r8 = this.e;
        if (r8 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L9:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "selectedUserGroups");
        r3.c.clear();
        r3.c.addAll(r7);
        return;
    L8:
        r3 = r8;
        goto L9
    }

    public UserGroupView(Context r2, View r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "uid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
