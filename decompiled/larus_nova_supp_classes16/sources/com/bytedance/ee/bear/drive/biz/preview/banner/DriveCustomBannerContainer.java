package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/banner/DriveCustomBannerContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "banners", "", "", "Landroid/view/View;", "getBanners", "()Ljava/util/Map;", "banners$delegate", "Lkotlin/Lazy;", "hasBanners", "", "addBanner", "", "bannerId", "banner", "removeBanner", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCustomBannerContainer extends LinearLayout {
    public final Lazy a;

    private final Map<String, View> getBanners() {
        return (Map) this.a.getValue();
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "bannerId");
        if (getBanners().containsKey(r2) == true) goto L5;
        return;
    L5:
        removeView(getBanners().remove(r2));
        if ((!getBanners().isEmpty()) == false) goto L8;
        int r3 = 0;
    L9:
        setVisibility(r3);
        return;
    L8:
        r3 = 8;
        goto L9
    }

    public DriveCustomBannerContainer(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = LazyKt.lazy(DriveCustomBannerContainer$banners$2.INSTANCE);
    }

    public final void a(String r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "bannerId");
        Intrinsics.checkNotNullParameter(r3, "banner");
        if (getBanners().containsKey(r2) == false) goto L5;
        return;
    L5:
        addView(r3);
        getBanners().put(r2, r3);
        if ((!getBanners().isEmpty()) == false) goto L8;
        int r4 = 0;
    L9:
        setVisibility(r4);
        return;
    L8:
        r4 = 8;
        goto L9
    }
}
