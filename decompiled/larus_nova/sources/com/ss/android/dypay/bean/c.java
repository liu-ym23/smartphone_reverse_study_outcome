package com.ss.android.dypay.bean;

import com.ss.android.dypay.api.DyPayConstant;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f408457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f408458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f408459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f408460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f408461e;

    public static final class a {
        public static void a(c r100, Function1 r101) {
            r100.f408457a = (String) r101.invoke("appid");
            r100.f408458b = (String) r101.invoke(DyPayConstant.K_PAY_INFO_PARAM_PARTNERID);
            r100.f408459c = (String) r101.invoke(DyPayConstant.K_PAY_INFO_PARAM_PREPAYID);
            String r102 = (String) r101.invoke("package");
            String r103 = (String) r101.invoke(DyPayConstant.K_PAY_INFO_PARAM_NONCESTR);
            String r104 = (String) r101.invoke("timestamp");
            String r105 = (String) r101.invoke("sign");
            r100.f408460d = (String) r101.invoke(DyPayConstant.K_PAY_INFO_PARAM_PRE_ENTRUSTWEB_ID);
            r100.f408461e = (String) r101.invoke(DyPayConstant.K_PAY_INFO_PAYSCORE_APPLY_TOKEN);
        }
    }

    public c() {
        this.f408457a = "";
        this.f408458b = "";
        this.f408459c = "";
        this.f408460d = "";
        this.f408461e = "";
    }
}
