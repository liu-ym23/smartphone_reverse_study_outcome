package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/MainFlippableViewPager;", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/FlippableViewPager;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MainFlippableViewPager extends FlippableViewPager {
    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void q() {
    }

    public MainFlippableViewPager(Context r100) {
        new LinkedHashMap();
        super(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L6;
        r100.getX();
        r100.getY();
    L6:
        return super.dispatchTouchEvent(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.FlippableViewPager, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.FlippableViewPager, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return super.onInterceptTouchEvent(r100);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.FlippableViewPager, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return super.onTouchEvent(r100);
    }

    public MainFlippableViewPager(Context r100, AttributeSet r101) {
        new LinkedHashMap();
        super(r100, r101);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void A(int r100, boolean r101) {
        super.A(r100, true);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
