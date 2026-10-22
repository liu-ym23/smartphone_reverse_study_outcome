package com.ss.android.lark.ug.banner;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.ug.banner.ui.template.BannerTemplateView;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends BannerTemplateView.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<BannerTemplateView.a> f444373b;

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.c
    public final int size() {
        return this.f444373b.size();
    }

    public i(Function0<? extends ArrayList<BannerTemplateView.a>> r100) {
        this.f444373b = r100.invoke();
    }

    @Override // com.ss.android.lark.ug.banner.ui.template.TemplateItemAdapter.c
    public final BannerTemplateView.a getItem(int r100) {
        if (r100 < this.f444373b.size()) goto L7;
        return null;
    L7:
        return (BannerTemplateView.a) ListProtector.get(this.f444373b, r100);
    }
}
