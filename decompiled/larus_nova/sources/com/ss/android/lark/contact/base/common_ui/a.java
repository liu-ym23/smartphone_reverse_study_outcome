package com.ss.android.lark.contact.base.common_ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.pb.chatters.PullUserAgreementResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PullUserAgreementResponse.UserAgreement.UserAgreementContent f418558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f418559b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        ContactBaseModuleDependency r101 = ContactBaseModuleDependency.f418857b;
        String r102 = this.f418558a.mlink_url;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "url");
        r101.openUrl(r102);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setColor(ContextCompat.getColor(this.f418559b, R.color.blue_6));
    }

    public a(PullUserAgreementResponse.UserAgreement.UserAgreementContent r100, Context r101) {
        this.f418558a = r100;
        this.f418559b = r101;
    }
}
