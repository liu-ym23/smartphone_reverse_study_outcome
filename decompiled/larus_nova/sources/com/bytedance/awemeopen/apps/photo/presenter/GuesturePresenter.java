package com.bytedance.awemeopen.apps.photo.presenter;

import android.content.Context;
import android.os.Message;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.DiggLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class GuesturePresenter extends f04.a<Unit> implements com.bytedance.awemeopen.apps.framework.utils.r0.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f197848p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a14.a f197849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PhotoFeedPagerViewModel f197850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f197851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final GestureDetector f197852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.utils.h f197853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f197854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DiggLayout f197855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f197856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f197857l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final FrameLayout f197858m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a14.b f197859n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View.OnClickListener f197860o;

    public static final class a {
    }

    static {
    }

    @Override // f04.a
    public final void k() {
        if (this.f197855j.getChildCount() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        this.f197855j.removeAllViews();
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L12;
        View.OnClickListener r102 = this.f197860o;
        if (r102 == null) goto L13;
        r102.onClick(this.f197856k);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r100.what != 0) goto L7;
        r101 = true;
        goto L7
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public GuesturePresenter(a14.a r100, PhotoFeedPagerViewModel r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        Intrinsics.checkNotNullParameter(r101, "photoVM");
        super(r100.f1367b);
        this.f197849d = r100;
        this.f197850e = r101;
        this.f197851f = r102;
        com.bytedance.awemeopen.apps.framework.utils.r0 r103 = new com.bytedance.awemeopen.apps.framework.utils.r0(this);
        this.f197855j = (DiggLayout) i(R.id.item_digg_layout);
        View r104 = i(R.id.item_gesture_fl);
        this.f197856k = r104;
        this.f197857l = LazyKt.lazy(new GuesturePresenter$pagePinchVM$2(this));
        this.f197858m = (FrameLayout) i(R.id.photos_container);
        a14.b r105 = new a14.b();
        r105.f1372a = new GuesturePresenter$config$1$1(this);
        this.f197859n = r105;
        this.f197852g = new GestureDetector(getContext(), new w(this));
        int r106 = com.bytedance.awemeopen.apps.framework.utils.g.f197696a;
        Context r107 = getContext();
        x r108 = new x(this);
        Intrinsics.checkNotNullParameter(r107, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "handler");
        Intrinsics.checkNotNullParameter(r108, "listener");
        this.f197853h = new com.bytedance.awemeopen.apps.framework.utils.h(r107, r108, r103);
        r104.setOnTouchListener(new v(this));
    }
}
