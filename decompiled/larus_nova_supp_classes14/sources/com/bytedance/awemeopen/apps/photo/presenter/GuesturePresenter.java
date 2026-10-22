package com.bytedance.awemeopen.apps.photo.presenter;

import android.content.Context;
import android.os.Message;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.awemeopen.apps.framework.base.view.DiggLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class GuesturePresenter extends f04.a<Unit> implements com.bytedance.awemeopen.apps.framework.utils.r0.a {
    public static final /* synthetic */ int p = 0;
    public final a14.a d;
    public final PhotoFeedPagerViewModel e;
    public final Function0<Unit> f;
    public final GestureDetector g;
    public final com.bytedance.awemeopen.apps.framework.utils.h h;
    public boolean i;
    public final DiggLayout j;
    public final View k;
    public final Lazy l;
    public final FrameLayout m;
    public final a14.b n;
    public View.OnClickListener o;

    public static final class a {
    }

    static {
    }

    @Override // f04.a
    public final void k() {
        if (this.j.getChildCount() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        this.j.removeAllViews();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r2) {
        boolean r0 = false;
        if (r2 != null) goto L5;
    L7:
        if (r0 == false) goto L12;
        View.OnClickListener r3 = this.o;
        if (r3 == null) goto L13;
        r3.onClick(this.k);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r2.what != 0) goto L7;
        r0 = true;
        goto L7
    }

    @Override // f04.a
    public final void j(Unit r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public GuesturePresenter(a14.a r3, PhotoFeedPagerViewModel r4, Function0<Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "pgParameters");
        Intrinsics.checkNotNullParameter(r4, "photoVM");
        super(r3.b);
        this.d = r3;
        this.e = r4;
        this.f = r5;
        com.bytedance.awemeopen.apps.framework.utils.r0 r6 = new com.bytedance.awemeopen.apps.framework.utils.r0(this);
        this.j = (DiggLayout) i(2131375734);
        View r7 = i(2131375768);
        this.k = r7;
        this.l = LazyKt.lazy(new GuesturePresenter$pagePinchVM$2(this));
        this.m = (FrameLayout) i(2131382254);
        a14.b r8 = new a14.b();
        r8.a = new GuesturePresenter$config$1$1(this);
        this.n = r8;
        this.g = new GestureDetector(getContext(), new w(this));
        int r9 = com.bytedance.awemeopen.apps.framework.utils.g.a;
        Context r10 = getContext();
        x r0 = new x(this);
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r6, "handler");
        Intrinsics.checkNotNullParameter(r0, "listener");
        this.h = new com.bytedance.awemeopen.apps.framework.utils.h(r10, r0, r6);
        r7.setOnTouchListener(new v(this));
    }
}
