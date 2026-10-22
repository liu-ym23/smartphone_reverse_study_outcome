package com.bytedance.ee.bear.lark.header;

import com.bytedance.ee.bear.list.homepage.banner.BitableBannerConfig;
import com.bytedance.ee.bear.list.homepage.banner.MoreButton;
import com.bytedance.ee.bear.list.homepage.banner.RecommendView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f227410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f227411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f227412c;

    public o(n r100, String r101, String r102) {
        this.f227410a = r100;
        this.f227411b = r101;
        this.f227412c = r102;
    }

    public final void a() {
        n r100 = this.f227410a;
        BitableBannerConfig r101 = r100.f227402c;
        if (r101 == null) goto L21;
        String r102 = this.f227411b;
        String r103 = this.f227412c;
        RecommendView r104 = r100.f227400a;
        if (r104 == null) goto L17;
        String r105 = r101.getBannerTitle();
        if (r105 == null) goto L10;
        r102 = r105;
    L10:
        MoreButton r106 = r101.getMoreBtn();
        if (r106 == null) goto L16;
        String r107 = r106.getText();
        if (r107 == null) goto L16;
        r103 = r107;
    L16:
        Intrinsics.checkNotNullParameter(r102, "leftTitle");
        Intrinsics.checkNotNullParameter(r103, "rightTitle");
        r104.f228271a.setLeftTitle(r102);
        r104.f228271a.setRightTitle(r103);
    L17:
        RecommendView r108 = r100.f227400a;
        if (r108 == null) goto L22;
        r108.setCardsData(r101.getCards());
        return;
    L22:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
