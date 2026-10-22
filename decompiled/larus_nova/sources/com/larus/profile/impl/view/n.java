package com.larus.profile.impl.view;

import androidx.appcompat.widget.AppCompatTextView;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.profile.impl.databinding.LarusItemProfileInfoHeaderBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public final /* synthetic */ class n implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusItemProfileInfoHeaderBinding f366924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r38.b f366925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ProfileHeaderUserInfoView f366926c;

    public /* synthetic */ n(LarusItemProfileInfoHeaderBinding r100, r38.b r101, ProfileHeaderUserInfoView r102) {
        this.f366924a = r100;
        this.f366925b = r101;
        this.f366926c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        LarusItemProfileInfoHeaderBinding r100 = this.f366924a;
        r38.b r101 = this.f366925b;
        ProfileHeaderUserInfoView r102 = this.f366926c;
        int r103 = ProfileHeaderUserInfoView.f366889b;
        AppCompatTextView r104 = r100.f366484i;
        String r105 = null;
        if (AppHost.f326268a.isOversea() == false) goto L8;
        StringBuilder r106 = new StringBuilder("@");
        if (r101 == null) goto L7;
        r105 = r101.g();
    L7:
        r106.append(r105);
        String r107 = r106.toString();
    L12:
        r104.setText(r107);
        return Unit.INSTANCE;
    L8:
        StringBuilder r108 = new StringBuilder();
        r108.append(r102.getContext().getString(R.string.larus_doubao_id));
        r108.append(' ');
        if (r101 == null) goto L11;
        r105 = r101.g();
    L11:
        r108.append(r105);
        r107 = r108.toString();
        goto L12
    }
}
