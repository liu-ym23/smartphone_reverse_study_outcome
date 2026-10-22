package com.bytedance.creativex.mediaimport.view.internal.scroller;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.creativex.mediaimport.widget.scroller.TouchableFrameLayout;
import com.larus.common.apphost.AppHost;
import com.ss.android.ugc.tools.utils.i;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ti4.e;
import ti4.f;
import ti4.g;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f204068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f204069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi4.b f204070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f204071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject f204072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublishSubject f204073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<Long> f204074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PublishSubject<Long> f204075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TouchableFrameLayout f204076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f204077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f204078k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f204079l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f204080m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f204081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f204082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f204083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f204084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f204085e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f204086f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function1<? super com.bytedance.creativex.mediaimport.view.internal.scroller.a.C2960a, Unit> f204087g;

        public a(int r100) {
            float r101 = i.b(AppHost.f326268a.getApplication()) / 4.0f;
            this.f204081a = 3.0f;
            this.f204082b = r101;
            this.f204083c = 3000;
            this.f204084d = 0;
            this.f204085e = 50;
            this.f204086f = 2.1f;
            this.f204087g = null;
        }
    }

    @Override // ti4.f
    public final Observable<f.a> a() {
        return this.f204073f.hide();
    }

    public final TouchableFrameLayout b() {
        TouchableFrameLayout r100 = this.f204076i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("scrollerContent");
        return null;
    }

    public b(ViewGroup r100, RecyclerView r101, ListSectionIndexer r102, xi4.b r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r101, "recyclerView");
        Intrinsics.checkNotNullParameter(r102, "sectionIndexer");
        Intrinsics.checkNotNullParameter(r103, "imageLoadingSwitcher");
        this.f204068a = r100;
        this.f204069b = r102;
        this.f204070c = r103;
        a r105 = new a(0);
        this.f204071d = r105;
        this.f204072e = PublishSubject.create();
        this.f204073f = PublishSubject.create();
        this.f204074g = PublishSubject.create();
        this.f204075h = PublishSubject.create();
        this.f204078k = true;
        RecyclerView.OnScrollListener r106 = new ListScrollerView$scrollListener$1(this);
        if (r104 == null) goto L5;
        r104.invoke(r105);
    L5:
        r101.addOnScrollListener(r106);
        this.f204080m = new c(this);
    }
}
