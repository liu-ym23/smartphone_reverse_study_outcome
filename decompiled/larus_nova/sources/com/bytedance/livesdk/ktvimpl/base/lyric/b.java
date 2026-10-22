package com.bytedance.livesdk.ktvimpl.base.lyric;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.base.a f256334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KaraokeLyricTimerV2 f256335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super Long, Unit> f256336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f256337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f256338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final KtvComponentCountDownView f256339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a f256340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<? super Long, Unit> f256341h;

    public static final class a {
    }

    static {
    }

    public b(d r100, ConstraintLayout r101, KtvComponentCountDownView r102, i r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, "lyricComponentLoader");
        Intrinsics.checkNotNullParameter(r101, "lyricContainer");
        Intrinsics.checkNotNullParameter(r102, "countDownView");
        this.f256337d = r100;
        this.f256338e = r101;
        this.f256339f = r102;
        this.f256340g = r103;
        this.f256341h = r104;
        Function1<Long, Unit> r105 = new KaraokeLyricPresenterV2$1(this);
        this.f256336c = r105;
        this.f256335b = new KaraokeLyricTimerV2(r105);
        ng4.e r106 = r100.f256343a;
        if (r106 == null) goto L6;
        r106.b(new KaraokeLyricPresenterV2$2(this));
        return;
    }
}
