package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KSongTuningButtonOuterCallback implements bc0.b {
    public final Lazy a;
    public bc0.c b;
    public final CompositeDisposable c;
    public LifecycleOwner d;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a e;
    public final zb0.a f;

    public final int c() {
        return 2;
    }

    public final ec0.a f() {
        return (ec0.a) this.a.getValue();
    }

    public final void clearData() {
        this.c.clear();
        this.b = null;
    }

    public final void g() {
        ec0.a r0 = f();
        final Boolean r1 = null;
        if (r0 == null) goto L5;
        final Boolean r2 = Boolean.valueOf(r0.b());
    L6:
        ec0.a r3 = f();
        if (r3 == null) goto L9;
        r1 = Boolean.valueOf(r3.h());
    L9:
        bc0.c r4 = this.b;
        if (r4 == null) goto L13;
        r4.m2(new KSongTuningButtonOuterCallback$handleScoreSwitchChanged$1(r2, r1), TuningButtonType.SCORE_ITEM, false);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void a(TuningButtonListAdapter r10) {
        Intrinsics.checkNotNullParameter(r10, "tuningButtonUIAbility");
        this.b = r10;
        if (r10 == null) goto L11;
        ArrayList r0 = new ArrayList();
        r0.add(new ac0.a(TuningButtonType.ORIGIN_ITEM, s1.B(2131918604), false, false, 0.0f, 60));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = this.e;
        if (r1 != null) goto L7;
    L9:
        Unit r2 = Unit.INSTANCE;
        r10.y2(r0);
        return;
    L7:
        if (r1.isInRealTimeChorus() == true) goto L9;
        r0.add(new ac0.a(TuningButtonType.SCORE_ITEM, s1.B(2131918335), false, false, 0.0f, 60));
        goto L9
    }

    public final void b(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.d = r2;
    }

    public KSongTuningButtonOuterCallback(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1, KSongTuningPanelOuterCallback r2) {
        this.e = r1;
        this.f = r2;
        this.a = LazyKt.lazy(KSongTuningButtonOuterCallback$tuningMusicControl$2.INSTANCE);
        this.c = new CompositeDisposable();
    }

    public final void d(TuningButtonListAdapter r2, WeakReference r3, LifecycleOwner r4) {
        Intrinsics.checkNotNullParameter(r2, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "owner");
        if (((Context) r3.get()) == null) goto L23;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r5 = this.e;
        if (r5 == null) goto L7;
        r5.i();
    L7:
        bc0.c r6 = this.b;
        if (r6 == null) goto L10;
        r6.m2(new KSongTuningButtonOuterCallback$handleOriginSwitchChanged$1(this), TuningButtonType.ORIGIN_ITEM, false);
    L10:
        ec0.a r7 = f();
        if (r7 == null) goto L16;
        LifecycleOwner r8 = this.d;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mLifecycleOwner");
    L15:
        r7.f(r8, new c(this));
    L16:
        g();
        ec0.a r9 = f();
        if (r9 == null) goto L24;
        LifecycleOwner r10 = this.d;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mLifecycleOwner");
    L21:
        r9.r(r10, new d(this));
        return;
    L24:
        return;
    }

    public final void e(TuningButtonListAdapter r4, ac0.a r5, final boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r5, "tuningButtonData");
        bc0.c r7 = this.b;
        if (r7 == null) goto L5;
        r7.m2(new KSongTuningButtonOuterCallback$onButtonChecked$1(this, r6), r5.getType(), false);
    L5:
        zb0.a r8 = this.f;
        if (r8 == null) goto L9;
        r8.d(r5, r6);
        return;
    }
}
