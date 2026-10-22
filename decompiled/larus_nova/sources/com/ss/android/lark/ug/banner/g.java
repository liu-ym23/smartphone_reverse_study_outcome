package com.ss.android.lark.ug.banner;

import com.ss.android.lark.ug.banner.ui.template.BannerTemplateView;

/* JADX INFO: loaded from: classes38.dex */
public final class g extends BannerTemplateView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f444362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f444363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f444364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f444365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f444366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f444367f;

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final Integer getBackgroundColor() {
        return Integer.valueOf(this.f444365d);
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final Integer getBorderColor() {
        return Integer.valueOf(this.f444366e);
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String a() {
        return this.f444367f;
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String b() {
        return this.f444364c;
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String c() {
        return this.f444363b;
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String getTitle() {
        return this.f444362a;
    }

    public g(String r100, String r101, String r102, int r103, int r104, String r105) {
        this.f444362a = r100;
        this.f444363b = r101;
        this.f444364c = r102;
        this.f444365d = r103;
        this.f444366e = r104;
        this.f444367f = r105;
    }
}
