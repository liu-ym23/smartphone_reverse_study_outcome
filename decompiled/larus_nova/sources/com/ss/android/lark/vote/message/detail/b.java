package com.ss.android.lark.vote.message.detail;

import android.view.View;
import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.profile.utils.IProfileLauncherV2;
import com.ss.android.lark.vote.message.content.VoteUser;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoterListBinder f445239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoteUser f445240b;

    public b(VoterListBinder r100, VoteUser r101) {
        this.f445239a = r100;
        this.f445240b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        IProfileLauncherV2.f438837a.getClass();
        IProfileLauncherV2.a.a(IProfileLauncherV2.Companion.a(), this.f445239a.f445235a, this.f445240b.getUserId(), this.f445239a.f445237c, new ContactSource(new ContactSource.a()), 154);
    }
}
