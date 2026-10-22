package com.bytedance.awemeopen.apps.framework.feed.follow;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/follow/MultiTabPageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class MultiTabPageAdapter extends PagerAdapter {
    public final List<View> a;

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "obj");
        if (r2 != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getCount() {
        return this.a.size();
    }

    public MultiTabPageAdapter(List<View> r2) {
        Intrinsics.checkNotNullParameter(r2, "feedPages");
        this.a = r2;
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        r2.addView((View) ListProtector.get(this.a, r3));
        return ListProtector.get(this.a, r3);
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "object");
        r1.removeView((View) r3);
    }
}
