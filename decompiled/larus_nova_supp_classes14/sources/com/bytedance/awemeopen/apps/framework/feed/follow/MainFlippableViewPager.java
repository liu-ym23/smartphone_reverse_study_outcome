package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/MainFlippableViewPager;", "Lcom/bytedance/awemeopen/apps/framework/feed/follow/FlippableViewPager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MainFlippableViewPager extends FlippableViewPager {
    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void q() {
    }

    public MainFlippableViewPager(Context r2) {
        new LinkedHashMap();
        super(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (r2.getAction() != 0) goto L6;
        r2.getX();
        r2.getY();
    L6:
        return super.dispatchTouchEvent(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.FlippableViewPager, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super.onConfigurationChanged(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.FlippableViewPager, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super.onInterceptTouchEvent(r2);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.FlippableViewPager, com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return super.onTouchEvent(r2);
    }

    public MainFlippableViewPager(Context r2, AttributeSet r3) {
        new LinkedHashMap();
        super(r2, r3);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager
    public final void A(int r1, boolean r2) {
        super.A(r1, true);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.follow.DmtViewPager, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }
}
