package com.ss.android.lark.feed.app.tablayout;

import android.view.View;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FeedTabLayoutConfig extends FeedSelectorConfig {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RefactoredFeedTabLayout f420779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f420780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f420781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f420782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f420783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f420784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f420785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f420786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function2<? super View, ? super Integer, ? extends TextView> f420787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Function3<? super Integer, ? super Integer, ? super Float, Integer> f420788q;

    public FeedTabLayoutConfig(RefactoredFeedTabLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "tabLayout");
        this.f420779h = r100;
        this.f420780i = true;
        this.f420782k = -1;
        this.f420783l = ColorProtector.parseColor("#999999");
        this.f420785n = new h();
        this.f420786o = -1;
        this.f420787p = new FeedTabLayoutConfig$onGetTextStyleView$1(this);
        this.f420788q = new FeedTabLayoutConfig$onGetGradientIndicatorColor$1(this);
        Function3<View, Integer, Boolean, Unit> r101 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f420761c = r101;
        Function4<Integer, List<? extends Integer>, Boolean, Boolean, Unit> r102 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f420763e = r102;
    }
}
