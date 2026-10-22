package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.middleground.permission.setting.publicpermset.model.CollaboratorPermissionType;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larus.nova.R;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class v<T1, T2, R> implements BiFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f233588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f233589b;

    public v(s r100, String r101) {
        this.f233588a = r100;
        this.f233589b = r101;
    }

    @Override // io.reactivex.functions.BiFunction
    public final Object apply(Object r100, Object r101) {
        SearchUserResult r102 = (SearchUserResult) r100;
        String r103 = (String) r101;
        Intrinsics.checkNotNullParameter(r102, "result");
        Intrinsics.checkNotNullParameter(r103, "email");
        tt5.a.h("SearchUserResultPresenter", "search user and get email()...success.");
        if (TextUtils.isEmpty(r103) == false) goto L5;
    L18:
        return r102;
    L5:
        if (r102.list != null) goto L7;
        r102.list = new ArrayList();
    L7:
        s r104 = this.f233588a;
        ArrayList<UserInfo> r105 = r102.list;
        String r106 = this.f233589b;
        r104.getClass();
        Iterator<UserInfo> r107 = r105.iterator();
    L9:
        if (r107.hasNext() == false) goto L15;
        if (TextUtils.equals(r107.next().getMailAddress(), r106) == false) goto L9;
        if (TextUtils.isEmpty(r106) == true) goto L9;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L18;
        ArrayList<UserInfo> r109 = r102.list;
        Context r110 = this.f233588a.f233582a.getContext();
        String r111 = this.f233589b;
        int r112 = this.f233588a.f233583b.getType();
        UserInfo r113 = new UserInfo();
        r113.setId(r103);
        r113.setCan_modify_perm(false);
        r113.setExternal(true);
        r113.setOwnerType(29);
        r113.setName(r111);
        r113.setDisplayName(r111);
        r113.setLabel(r110.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(r112, R.string.LarkCCM_ChatShare_EmailInviteWithoutLogin_Desc, R.string.LarkCCM_Docs_InviteEmail_Note_Descrip)));
        r113.setPermission(CollaboratorPermissionType.READ_PERM.getValue());
        r109.add(r113);
        goto L18
    L15:
        r108 = false;
        goto L16
    }
}
