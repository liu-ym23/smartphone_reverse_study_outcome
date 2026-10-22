package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningbutton.view.TuningButtonListAdapter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class KSongViceSingerTuningButtonOuterCallback implements bc0.b {
    public final CompositeDisposable a;
    public bc0.c b;
    public final Lazy c;

    public final int c() {
        return 1;
    }

    public com.bytedance.android.live.ktv.common.tuningpanel.ability.a f() {
        return (com.bytedance.android.live.ktv.common.tuningpanel.ability.a) this.c.getValue();
    }

    public final void clearData() {
        this.a.clear();
        this.b = null;
    }

    public KSongViceSingerTuningButtonOuterCallback() {
        this.a = new CompositeDisposable();
        this.c = LazyKt.lazy(KSongViceSingerTuningButtonOuterCallback$tuningCore$2.INSTANCE);
    }

    public boolean g() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = f();
        if (r0 == null) goto L7;
        r0.i();
        return false;
    L7:
        return false;
    }

    public final void h() {
        if (g() == false) goto L36;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = f();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.h() == true) goto L38;
        bc0.c r1 = this.b;
        if (r1 == null) goto L39;
        TuningButtonType r2 = TuningButtonType.ECHO_ITEM;
        String r3 = s1.B(2131918380);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r4 = f();
        boolean r5 = false;
        if (r4 == null) goto L17;
        MutableLiveData r6 = r4.F();
        if (r6 == null) goto L17;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L17;
        boolean r8 = r7.booleanValue();
    L18:
        Boolean r9 = null;
        if (r8 == false) goto L27;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = f();
        if (r10 == null) goto L23;
        Boolean r11 = r10.I();
    L25:
        if (Intrinsics.areEqual(r11, Boolean.TRUE) == false) goto L27;
        r5 = true;
        goto L27
    L23:
        r11 = null;
    L27:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r12 = f();
        if (r12 == null) goto L31;
        r9 = r12.I();
    L31:
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L33;
        float r13 = 1.0f;
    L34:
        r1.j0(new ac0.a(r2, r3, r5, false, r13, 40));
        return;
    L33:
        r13 = 0.5f;
    L17:
        r8 = false;
        goto L18
    L39:
        return;
    L38:
        return;
    }

    public final void a(TuningButtonListAdapter r10) {
        Intrinsics.checkNotNullParameter(r10, "tuningButtonUIAbility");
        if (g() == true) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        r0.add(new ac0.a(TuningButtonType.ECHO_ITEM, s1.B(2131918380), false, false, 0.0f, 60));
        Unit r1 = Unit.INSTANCE;
        r10.y2(r0);
    }

    public final void b(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
    }

    public final void d(TuningButtonListAdapter r3, WeakReference r4, LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r3, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "owner");
        this.b = r3;
        if (g() == true) goto L5;
        return;
    L5:
        Context r6 = (Context) r4.get();
        Object r0 = null;
        if (r6 == null) goto L8;
        Object r7 = r6.getSystemService("audio");
    L10:
        if ((r7 instanceof AudioManager) == false) goto L13;
        r0 = r7;
    L13:
        AudioManager r1 = (AudioManager) r0;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r8 = f();
        if (r8 == null) goto L21;
        if (r1 == null) goto L19;
        boolean r2 = true;
        if (r1.isWiredHeadsetOn() != true) goto L19;
    L20:
        r8.K(r2);
    L19:
        r2 = false;
    L21:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r9 = f();
        if (r9 == null) goto L24;
        r9.t(r5, new o(this));
    L24:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r10 = f();
        if (r10 == null) goto L27;
        r10.a0(r5, new p(this));
    L27:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r11 = f();
        if (r11 == null) goto L32;
        MutableLiveData r12 = r11.F();
        if (r12 == null) goto L32;
        r12.observe(r5, new q(this, r3));
    L32:
        h();
        Disposable r13 = xs2.b.a().b(cb0.b.class).subscribe(new r(this));
        if (r13 == null) goto L36;
        RxUtilKt.c(r13, this.a);
        return;
    L36:
        return;
    L8:
        r7 = null;
        goto L10
    }

    public final void e(TuningButtonListAdapter r2, ac0.a r3, final boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "tuningButtonUIAbility");
        Intrinsics.checkNotNullParameter(r3, "tuningButtonData");
        r2.m2(new KSongViceSingerTuningButtonOuterCallback$onButtonChecked$1(this, r4), r3.getType(), false);
    }
}
