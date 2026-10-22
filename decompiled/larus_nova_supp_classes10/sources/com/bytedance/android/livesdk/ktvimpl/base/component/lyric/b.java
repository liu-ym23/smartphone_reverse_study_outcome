package com.bytedance.android.livesdk.ktvimpl.base.component.lyric;

import android.content.Context;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.KtvComponentCountDownView;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.h;
import com.bytedance.component.lyric.LyricComponentImplManager;
import com.bytedance.component.lyric.ViewPainter;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public com.bytedance.android.livesdk.ktvimpl.base.a a;
    public final KaraokeLyricTimer b;
    public final LyricComponentImplManager c;
    public final Function1<? super Long, Unit> d;
    public final MutableLiveData<String[]> e;
    public final ViewGroup f;
    public final KtvComponentCountDownView g;
    public final com.bytedance.android.livesdk.ktvimpl.base.component.lyric.a h;
    public final Function1<? super Long, Unit> i;

    public static final class a {
    }

    static {
        KtvSettingHelper.j();
    }

    public b(ConstraintLayout r2, KtvComponentCountDownView r3, ViewPainter r4, h r5, Function1 r6) {
        Intrinsics.checkNotNullParameter(r2, "lyricContainer");
        Intrinsics.checkNotNullParameter(r3, "countDownView");
        Intrinsics.checkNotNullParameter(r4, "viewPainter");
        this.f = r2;
        this.g = r3;
        this.h = r5;
        this.i = r6;
        LyricsDisplayConfig r7 = new LyricsDisplayConfig();
        r7.a();
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r4, "painter");
        Context r8 = r4.getContext();
        Intrinsics.checkNotNullParameter(r8, "context");
        LyricComponentImplManager r9 = new LyricComponentImplManager(r8, r7, new com.bytedance.component.lyric.a(r8, r4));
        this.c = r9;
        MutableLiveData<String[]> r10 = new MutableLiveData();
        r10.setValue(null);
        Unit r11 = Unit.INSTANCE;
        this.e = r10;
        Function1<Long, Unit> r12 = new KaraokeLyricPresenter$1(this);
        this.d = r12;
        this.b = new KaraokeLyricTimer(r12);
        KaraokeLyricPresenter$2 r13 = new KaraokeLyricPresenter$2(this);
        Intrinsics.checkNotNullParameter(r13, "factory");
        r9.d = r13;
    }
}
