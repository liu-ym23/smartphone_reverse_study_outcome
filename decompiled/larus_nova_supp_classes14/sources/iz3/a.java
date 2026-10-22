package iz3;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.feed.layout.layout.AosFeedPagerListLayout;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosFeedPagerListFragment;
import k54.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final com.bytedance.awemeopen.apps.framework.utils.audio.a a(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r1) {
        Intrinsics.checkNotNullParameter(r1, "feedGroupParameters");
        return r1.a();
    }

    public static final View b(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r1) {
        Intrinsics.checkNotNullParameter(r1, "feedGroupParameters");
        LifecycleOwner r2 = r1.e.d;
        if ((r2 instanceof AosFeedPagerListFragment) == false) goto L6;
        return ((AosFeedPagerListFragment) r2).getView();
    L6:
        if ((r2 instanceof AosFeedPagerListLayout) == true) goto L11;
        return null;
    L11:
        return (View) r2;
    }

    public static final c c(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r1) {
        Intrinsics.checkNotNullParameter(r1, "feedGroupParameters");
        return r1.b();
    }
}
