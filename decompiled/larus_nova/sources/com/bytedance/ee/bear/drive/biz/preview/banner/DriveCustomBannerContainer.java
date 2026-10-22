package com.bytedance.ee.bear.drive.biz.preview.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nR'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/banner/DriveCustomBannerContainer;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", PromotionProductPrivilegesStruct.BANNERS, "", "", "Landroid/view/View;", "getBanners", "()Ljava/util/Map;", "banners$delegate", "Lkotlin/Lazy;", "hasBanners", "", "addBanner", "", "bannerId", "banner", "removeBanner", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveCustomBannerContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f223194a;

    private final Map<String, View> getBanners() {
        return (Map) this.f223194a.getValue();
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bannerId");
        if (getBanners().containsKey(r100) == true) goto L5;
        return;
    L5:
        removeView(getBanners().remove(r100));
        if ((!getBanners().isEmpty()) == false) goto L8;
        int r101 = 0;
    L9:
        setVisibility(r101);
        return;
    L8:
        r101 = 8;
        goto L9
    }

    public DriveCustomBannerContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f223194a = LazyKt.lazy(DriveCustomBannerContainer$banners$2.INSTANCE);
    }

    public final void a(String r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "bannerId");
        Intrinsics.checkNotNullParameter(r101, "banner");
        if (getBanners().containsKey(r100) == false) goto L5;
        return;
    L5:
        addView(r101);
        getBanners().put(r100, r101);
        if ((!getBanners().isEmpty()) == false) goto L8;
        int r102 = 0;
    L9:
        setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    }
}
