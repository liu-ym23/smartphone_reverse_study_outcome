package com.ss.android.lark.contact.base.contact_new.mvp;

import com.larksuite.framework.utils.y;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.contact.base.entity.ExternalContactSummary;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class h implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewContactPresenter f418748a;

    public /* synthetic */ h(NewContactPresenter r100) {
        this.f418748a = r100;
    }

    @Override // com.larksuite.framework.utils.y.a
    public final Object get(Object r100) {
        ChatApplication r101 = (ChatApplication) r100;
        this.f418748a.getClass();
        ExternalContactSummary r102 = r101.getExternalContactSummary();
        if (r102 != null) goto L5;
        return null;
    L5:
        NewContactView.a r103 = new NewContactView.a();
        r103.f418723c = r102.getAvatarKey();
        r103.f418724d = com.ss.android.lark.chat.utils.m.c(r102.getI18nName(), r102.getUserName());
        r103.f418721a = r101.getId();
        r103.f418722b = r102.getUseId();
        r103.f418725e = r102.getTenantName();
        r103.f418726f = r102.getTenantNameStatus();
        r103.f418727g = r101.getExtraMessage();
        r103.f418728h = r101.getStatus();
        r103.f418729i = r101.getCertificationInfo();
        return r103;
    }
}
