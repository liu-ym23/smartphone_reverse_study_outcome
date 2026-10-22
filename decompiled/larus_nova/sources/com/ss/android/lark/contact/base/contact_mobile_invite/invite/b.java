package com.ss.android.lark.contact.base.contact_mobile_invite.invite;

import android.content.Context;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ViewUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements ApiUtils.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f418673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f418674b;

    public b(a r100, Context r101) {
        this.f418673a = r100;
        this.f418674b = r101;
    }

    @Override // com.ss.android.lark.utils.ApiUtils.a
    public final void consume(Object r100) {
        z8b.a r101 = (z8b.a) r100;
        if (r101 != null) goto L5;
        ViewUtils.showCommonErrorTip();
        return;
    L5:
        ErrorResult r102 = r101.f570974c;
        if (r102 == null) goto L8;
        ViewUtils.showToastShort(r102.getDisplayMsg());
        return;
    L8:
        String r103 = a.f418663k;
        InvitationInfo r104 = r101.f570973b;
        String r105 = "";
        if (r104 == null) goto L11;
        String r106 = r104.invMsg;
    L12:
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        a.f418663k = r106;
        InvitationInfo r107 = r101.f570973b;
        if (r107 == null) goto L15;
        r105 = r107.uniqueId;
    L15:
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        a.f418664l = r105;
        a.c(this.f418673a, this.f418674b);
        return;
    L11:
        r106 = "";
        goto L12
    }
}
