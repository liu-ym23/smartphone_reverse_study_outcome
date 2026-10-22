package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper;

import android.os.Handler;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.framework.datawithstate.ListState;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.FeedPagerListViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.servicesapi.monitor.common.AoCommonMonitorService;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/helper/SlideEventReportHelper;", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class SlideEventReportHelper extends ViewPager.SimpleOnPageChangeListener {
    public final FeedPagerListViewModel a;
    public int b;
    public int c;
    public final AoCommonMonitorService d;
    public final Handler e;

    public final void onPageScrolled(int r1, float r2, int r3) {
    }

    public SlideEventReportHelper(FeedPagerListViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        this.a = r2;
        this.b = -1;
        this.d = j64.a.a(AoCommonMonitorService.class);
        this.e = new Handler();
    }

    public final r14.c a(int r2) {
        ListState r0 = (ListState) this.a.getDataList().getValue();
        if (r0 == null) goto L9;
        List r1 = (List) r0.a;
        if (r1 == null) goto L9;
        jz3.a r3 = (jz3.a) CollectionsKt.getOrNull(r1, r2);
        if (r3 == null) goto L9;
        return r3.a;
    L9:
        return null;
    }

    public final void onPageScrollStateChanged(int r4) {
        super.onPageScrollStateChanged(r4);
        AoLogger.g("fps_log", new Object[]{"onPageScrollStateChanged state = " + r4});
        if (r4 == 0) goto L8;
        AoCommonMonitorService r5 = this.d;
        if (r5 == null) goto L9;
        r5.S();
        return;
    L9:
        return;
    }

    public final void onPageSelected(int r6) {
        super.onPageSelected(r6);
        AoLogger.g("fps_log", new Object[]{"onPageSelected position = " + r6});
        AoCommonMonitorService r0 = this.d;
        if (r0 == null) goto L5;
        r0.N1();
    L5:
        this.b = r6;
        final int r1 = this.c;
        this.e.postDelayed(new n(this, r1), 10);
        this.c = r6;
    }
}
