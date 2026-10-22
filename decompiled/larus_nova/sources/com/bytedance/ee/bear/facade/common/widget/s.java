package com.bytedance.ee.bear.facade.common.widget;

import android.content.Context;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f226708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f226709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f226710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f226711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f226712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f226713f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f226714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f226715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f226716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f226717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f226718e;

        public a() {
        }
    }

    public String a() {
        return this.f226708a.getString(this.f226713f);
    }

    public String b() {
        String r100 = this.f226708a.getString(R.string.CreationMobile_ECM_Folder_SubmitMaximumToast2);
        return xo5.a.c(this.f226708a, this.f226712e, "customer_service", r100);
    }

    public String c() {
        String r100 = this.f226708a.getString(R.string.appealing_submit);
        return xo5.a.c(this.f226708a, this.f226711d, "submit_appeal", r100);
    }

    public String d() {
        return this.f226708a.getString(this.f226710c);
    }

    public String e() {
        String r100 = this.f226708a.getString(R.string.appealing_submit);
        return xo5.a.c(this.f226708a, this.f226709b, "submit_appeal", r100);
    }

    public s(Context r100) {
        this.f226709b = R.string.CreationMobile_Suspend_Folder_banner;
        this.f226710c = R.string.CreationMobile_appealing_folder_pending;
        this.f226711d = R.string.CreationMobile_appealing_folder_decline;
        this.f226712e = R.string.CreationMobile_ECM_Folder_SubmitMaximumToast;
        this.f226713f = R.string.CreationMobile_ECM_Folder_SubmitThreeTimesToast;
        this.f226708a = r100;
    }

    public s(Context r100, a r101) {
        this.f226709b = R.string.CreationMobile_Suspend_Folder_banner;
        this.f226710c = R.string.CreationMobile_appealing_folder_pending;
        this.f226711d = R.string.CreationMobile_appealing_folder_decline;
        this.f226712e = R.string.CreationMobile_ECM_Folder_SubmitMaximumToast;
        this.f226713f = R.string.CreationMobile_ECM_Folder_SubmitThreeTimesToast;
        this.f226708a = r100;
        this.f226712e = r101.f226717d;
        this.f226713f = r101.f226718e;
        this.f226709b = r101.f226714a;
        this.f226710c = r101.f226715b;
        this.f226711d = r101.f226716c;
    }
}
