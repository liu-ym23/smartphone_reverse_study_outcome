package com.ss.android.lark.ug.banner;

import com.ss.android.lark.ug.banner.ui.template.BannerTemplateView;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends BannerTemplateView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f444368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f444369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f444370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f444371d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f444372e;

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String c() {
        return null;
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final Integer getBackgroundColor() {
        return Integer.valueOf(this.f444370c);
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final Integer getBorderColor() {
        return Integer.valueOf(this.f444371d);
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String a() {
        return this.f444372e;
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String b() {
        return this.f444369b;
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.b
    public final String getTitle() {
        return this.f444368a;
    }

    public h(String r100, String r101, int r102, int r103, String r104) {
        this.f444368a = r100;
        this.f444369b = r101;
        this.f444370c = r102;
        this.f444371d = r103;
        this.f444372e = r104;
    }
}
