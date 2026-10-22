package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class t extends s {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f226719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f226720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f226721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f226722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f226723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f226724l;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String a() {
        String r100 = this.f226719g.getString(R.string.LarkCCM_Security_ContactSupport_Link);
        return xo5.a.c(this.f226719g, this.f226723k, "contact_support", r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String b() {
        String r100 = this.f226719g.getString(R.string.LarkCCM_Security_ContactSupport_Link);
        return xo5.a.c(this.f226719g, this.f226722j, "contact_support", r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String c() {
        String r100 = this.f226719g.getString(R.string.LarkCCM_Security_Appeal_Link);
        return xo5.a.c(this.f226719g, this.f226724l, "appeal", r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String d() {
        String r100 = this.f226719g.getString(R.string.LarkCCM_Security_AppealProgress_Link);
        return xo5.a.c(this.f226719g, this.f226721i, "progress", r100);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.s
    public final String e() {
        String r100 = this.f226719g.getString(R.string.LarkCCM_Security_UserAgreement_Link);
        String r101 = this.f226719g.getString(R.string.LarkCCM_Security_SubmitAppeal_Link);
        HashMap r102 = new HashMap();
        r102.put("appeal", r101);
        r102.put("agreement", r100);
        return xo5.a.d(this.f226719g, this.f226720h, r102);
    }

    public t(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100);
        this.f226719g = r100;
        this.f226720h = R.string.LarkCCM_Security_DocShareSuspend_UserAgreeMent_Banner;
        this.f226721i = R.string.LarkCCM_Security_AppealInProcess_Banner;
        this.f226722j = R.string.LarkCCM_Security_AppealFailed_Limits_Banner;
        this.f226723k = R.string.LarkCCM_Security_AppealFailed_LimitsToday_Banner;
        this.f226724l = R.string.LarkCCM_Security_AppealFailed_Banner;
    }
}
