package com.bytedance.android.livesdk.ktvimpl.base.lyrics;

import android.view.KeyEvent;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.component.lyric.model.LyricsDisplayConfig;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/lyrics/KtvRoomLyricHolder;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lub0/a;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomLyricHolder implements Observer<ub0.a> {
    public final d a;
    public final KtvListenerLyricPresenter b;
    public final View c;
    public final CompositeDisposable d;
    public boolean e;
    public boolean f;
    public final a g;
    public final Function1<Long, Unit> h;

    public final Function1<LyricsDisplayConfig, Unit> a() {
        if (this.e == false) goto L5;
        this.a.getClass();
        Function1<LyricsDisplayConfig, Unit> r0 = KtvSingerLyricPresenter$configDisplay$1.INSTANCE;
    L6:
        KeyEvent.Callback r1 = this.c;
        if ((r1 instanceof a) == true) goto L9;
        r1 = null;
    L9:
        a r2 = (a) r1;
        if (r2 == null) goto L14;
        LyricsDisplayConfig r3 = r2.getDisplayConfig();
        if (r3 == null) goto L14;
        r0.invoke(r3);
        ((a) this.c).onConfigComplete();
    L14:
        return r0;
    L5:
        this.b.getClass();
        r0 = KtvListenerLyricPresenter$configDisplay$1.INSTANCE;
        goto L6
    }

    public final void b() {
        View r0 = this.c;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getVisibility());
    L7:
        if (r1.intValue() != 0) goto L12;
        View r2 = this.c;
        if (r2 == null) goto L13;
        r2.setVisibility(8);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void c() {
        LyricsDisplayConfig r0 = this.g.getDisplayConfig();
        KtvRoomLyricHolder$defaultConfigDisplayOpt$1.INSTANCE.invoke(r0);
        this.g.onConfigComplete();
        this.f = true;
    }

    public final void onChanged(Object r4) {
        ub0.a r5 = (ub0.a) r4;
        if (r5 == null) goto L9;
        Intrinsics.checkNotNullParameter(r5, "lyricsChangeEvent");
        String r0 = "onLyricsChange current Is Singer:" + this.e + "， songid：" + r5.a;
        ALogger.i(bb0.b.b().concat("-lyric"), r0 + ", invoke class :KtvRoomLyricHolder");
        if (this.e == false) goto L7;
        this.a.a(r5);
        return;
    L7:
        this.b.a(r5);
        return;
    }

    public KtvRoomLyricHolder(KtvSingAndListenerLyricViewV2 r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r11, "lyricView");
        this.g = r11;
        this.h = r12;
        d r1 = new d(r11);
        this.a = r1;
        KtvListenerLyricPresenter r2 = new KtvListenerLyricPresenter(r11, r12);
        this.b = r2;
        this.c = r11;
        CompositeDisposable r13 = new CompositeDisposable();
        this.d = r13;
        KtvContext.Companion.getClass();
        KtvContext.a.g().getLyricsChangeLiveData().observeForever(this);
        Disposable r3 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new c(this), 3, null);
        if (r3 == null) goto L5;
        RxUtilKt.c(r3, r13);
    L5:
        Intrinsics.checkNotNullParameter(r11, "lyricView");
        r1.a = r11;
        Intrinsics.checkNotNullParameter(r11, "lyricView");
        r2.a = r11;
        a();
    }
}
