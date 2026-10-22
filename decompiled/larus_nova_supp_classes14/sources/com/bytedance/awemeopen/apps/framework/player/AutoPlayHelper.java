package com.bytedance.awemeopen.apps.framework.player;

import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.event.AutoPlayAction;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AutoPlayHelper extends ViewPager.SimpleOnPageChangeListener {
    public static final /* synthetic */ int g = 0;
    public final AosPagerListViewModel<jz3.a> a;
    public final c54.c b;
    public boolean c;
    public boolean d;
    public final MutableLiveData<Integer> e;
    public final com.bytedance.awemeopen.apps.framework.player.a f;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AutoPlayAction.values().length];
            r0[AutoPlayAction.TRY_STOP_AUTOPLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AutoPlayAction.STOP_AUTOPLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AutoPlayAction.REOPEN_AUTOPLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public final boolean a() {
        if (this.c == true) goto L6;
        return false;
    L6:
        if (this.b.getAutoPlayState() == true) goto L9;
        return false;
    L9:
        if (this.b.b() > this.a.getCurrentIndex()) goto L11;
        return false;
    L11:
        return true;
    }

    public final void b() {
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.a.class).removeObserver(this.f);
    }

    public final void onPageScrollStateChanged(int r2) {
        if (r2 != 0) goto L4;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        return;
    L4:
        if (r2 != 1) goto L10;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.player.a] */
    public AutoPlayHelper(AosPagerListViewModel<jz3.a> r2, c54.c r3) {
        Intrinsics.checkNotNullParameter(r2, "vm");
        Intrinsics.checkNotNullParameter(r3, "autoPlayConfig");
        this.a = r2;
        this.b = r3;
        this.c = true;
        this.d = true;
        this.e = new MutableLiveData();
        ?? r4 = new com.bytedance.awemeopen.apps.framework.player.a(this);
        this.f = r4;
        LiveDataBus r5 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.a.class).observeForever(r4);
    }
}
