package com.bytedance.awemeopen.apps.framework.player;

import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.awemeopen.apps.framework.event.AutoPlayAction;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosPagerListViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/AutoPlayHelper;", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class AutoPlayHelper extends ViewPager.SimpleOnPageChangeListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f197227g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AosPagerListViewModel<jz3.a> f197228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c54.c f197229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f197230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f197231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<Integer> f197232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.player.a f197233f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f197234a = null;

        static {
            int[] r100 = new int[AutoPlayAction.values().length];
            r100[AutoPlayAction.TRY_STOP_AUTOPLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AutoPlayAction.STOP_AUTOPLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AutoPlayAction.REOPEN_AUTOPLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f197234a = r100;
        }
    }

    static {
    }

    public final boolean a() {
        if (this.f197230c == true) goto L6;
        return false;
    L6:
        if (this.f197229b.getAutoPlayState() == true) goto L9;
        return false;
    L9:
        if (this.f197229b.b() > this.f197228a.getCurrentIndex()) goto L11;
        return false;
    L11:
        return true;
    }

    public final void b() {
        LiveDataBus r100 = LiveDataBus.f196946c;
        LiveDataBus.a.a(gz3.a.class).removeObserver(this.f197233f);
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int r100) {
        if (r100 != 0) goto L4;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        return;
    L4:
        if (r100 != 1) goto L10;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        return;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.lifecycle.Observer, com.bytedance.awemeopen.apps.framework.player.a] */
    public AutoPlayHelper(AosPagerListViewModel<jz3.a> r100, c54.c r101) {
        Intrinsics.checkNotNullParameter(r100, "vm");
        Intrinsics.checkNotNullParameter(r101, "autoPlayConfig");
        this.f197228a = r100;
        this.f197229b = r101;
        this.f197230c = true;
        this.f197231d = true;
        this.f197232e = new MutableLiveData();
        ?? r102 = new com.bytedance.awemeopen.apps.framework.player.a(this);
        this.f197233f = r102;
        LiveDataBus r103 = LiveDataBus.f196946c;
        LiveDataBus.a.a(gz3.a.class).observeForever(r102);
    }
}
