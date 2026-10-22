package com.bytedance.ee.bear.middleground.permission.collaborator.search.searchresult;

import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.SearchUserResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class p<T, R> implements Function {
    public final /* synthetic */ m a;

    public p(m r1) {
        this.a = r1;
    }

    public final Object apply(Object r10) {
        SearchUserResult r11 = (SearchUserResult) r10;
        Intrinsics.checkNotNullParameter(r11, "it");
        tt5.a.h("SearchUserResultModel", "doSearchByWord()...success.");
        m r0 = this.a;
        if (r0.f != 0) goto L5;
        boolean r1 = true;
    L6:
        r11.refresh = r1;
        r11.isRecent = TextUtils.isEmpty(r0.e);
        m r2 = this.a;
        ArrayList<UserInfo> r3 = r11.list;
        InviteMemberParams r4 = r2.c;
        String r5 = r4.a;
        Integer r6 = Integer.valueOf(r4.getType());
        int r7 = su5.a.a;
        boolean r8 = su5.a.a(r2.e);
        String[] r9 = PermissionAnalytic.a;
        HashMap r12 = new HashMap();     // Catch: Exception -> L32
        r12.put("file_id", du5.b.g(r5));     // Catch: Exception -> L32
        if (r6 == null) goto L10;
        int r13 = r6.intValue();     // Catch: Exception -> L32
    L11:
        r12.put("file_type", sbb.e.c(r13));     // Catch: Exception -> L32
        r12.put("product", "suite");     // Catch: Exception -> L32
        if (r8 == false) goto L14;
        String r14 = "phone";
    L15:
        r12.put("search_type", r14);     // Catch: Exception -> L32
        String r15 = "";
        if (r3 == null) goto L29;
        Iterator<T> r16 = r3.iterator();     // Catch: Exception -> L32
        String r17 = "";
        int r18 = 0;
    L20:
        if (r16.hasNext() == false) goto L30;
        T r19 = r16.next();     // Catch: Exception -> L32
        int r20 = r18 + 1;     // Catch: Exception -> L32
        if (r18 >= 0) goto L24;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L32
    L24:
        UserInfo r21 = (UserInfo) r19;     // Catch: Exception -> L32
        if (r18 != 0) goto L27;
        r15 = PermissionAnalytic.c(r21.getId());     // Catch: Exception -> L32
        r17 = PermissionAnalytic.a(r21);     // Catch: Exception -> L32
    L28:
        r18 = r20;
        goto L20
    L27:
        String r22 = r15 + ',' + PermissionAnalytic.c(r21.getId());     // Catch: Exception -> L32
        r17 = r17 + ',' + PermissionAnalytic.a(r21);     // Catch: Exception -> L32
        r15 = r22;
    L30:
        r12.put("searchresult_user_id", r15);     // Catch: Exception -> L32
        r12.put("searchresult_user_type", r17);     // Catch: Exception -> L32
        PermissionAnalytic.b().v("click_search_inviter", r12);     // Catch: Exception -> L32
    L34:
        return r11;
    L29:
        r17 = "";
        goto L30
    L14:
        r14 = "nickname";
        goto L15
    L10:
        r13 = sbb.e.e.b;     // Catch: Exception -> L32
    L32:
        e = move-exception;
        tt5.a.f("PermissionAnalytic", e, false);
        goto L34
    L5:
        r1 = false;
        goto L6
    }
}
