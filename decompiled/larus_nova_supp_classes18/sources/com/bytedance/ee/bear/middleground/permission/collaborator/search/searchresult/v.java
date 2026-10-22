package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v<T1, T2, R> implements BiFunction {
    public final /* synthetic */ s a;
    public final /* synthetic */ String b;

    public v(s r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r8, Object r9) {
        SearchUserResult r10 = (SearchUserResult) r8;
        String r11 = (String) r9;
        Intrinsics.checkNotNullParameter(r10, "result");
        Intrinsics.checkNotNullParameter(r11, "email");
        tt5.a.h("SearchUserResultPresenter", "search user and get email()...success.");
        if (TextUtils.isEmpty(r11) == false) goto L5;
    L18:
        return r10;
    L5:
        if (r10.list != null) goto L7;
        r10.list = new ArrayList();
    L7:
        s r0 = this.a;
        ArrayList<UserInfo> r1 = r10.list;
        String r2 = this.b;
        r0.getClass();
        Iterator<UserInfo> r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L15;
        if (TextUtils.equals(r3.next().getMailAddress(), r2) == false) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
        ArrayList<UserInfo> r5 = r10.list;
        Context r6 = this.a.a.getContext();
        String r7 = this.b;
        int r12 = this.a.b.getType();
        UserInfo r13 = new UserInfo();
        r13.setId(r11);
        r13.setCan_modify_perm(false);
        r13.setExternal(true);
        r13.setOwnerType(29);
        r13.setName(r7);
        r13.setDisplayName(r7);
        r13.setLabel(r6.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r12, 2131888868, 2131889097)));
        r13.setPermission(CollaboratorPermissionType.READ_PERM.getValue());
        r5.add(r13);
        goto L18
    L15:
        r4 = false;
        goto L16
    }
}
