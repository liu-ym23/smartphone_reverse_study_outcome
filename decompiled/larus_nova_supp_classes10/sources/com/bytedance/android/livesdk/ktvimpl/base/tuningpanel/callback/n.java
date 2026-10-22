package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.TuningVolumeContentArea;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements gc0.d {
    public LifecycleOwner a;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a b;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ n a;
        public final /* synthetic */ TuningVolumeContentArea b;

        public b(n r1, TuningVolumeContentArea r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            View r4 = this.b.b(TuningVolumeType.EAR_BACK_VOLUME);
            if (r4 != null) goto L5;
            return;
        L5:
            if (this.a.b.h() == true) goto L7;
            this.a.b.i();
        L7:
            r4.setVisibility(8);
        }
    }

    public static final class c implements gc0.c {
        public final /* synthetic */ n a;

        public final String a() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L8;
            if (r0.isInRealTimeChorus() != true) goto L8;
            return s1.B(2131918411);
        L8:
            return s1.B(2131918382);
        }

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 100;
        L7:
            return r0.U();
        }

        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.f();
        }

        public c(n r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r2) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }
    }

    public static final class d implements gc0.c {
        public final /* synthetic */ n a;

        public static final class a implements SeekBarWithProgress.b {
            public final /* synthetic */ d a;
            public final /* synthetic */ Ref.BooleanRef b;

            public final boolean a() {
                d r0 = this.a;
                com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = r0.a.b;
                if (r1 != null) goto L5;
            L12:
                boolean r2 = true;
            L13:
                if (r2 == true) goto L18;
                Ref.BooleanRef r3 = this.b;
                if (r3.element == true) goto L17;
                r3.element = true;
                f2.b(2131915795, 0);
                UtilityKotlinExtentionsKt.s(KtvSingChallengeViewModel.CHALLENGE_RESULT_SHOW_DURATION, false, false, new KSongTuningVolumeOuterCallback$fillTuningVolumeItem$$inlined$let$lambda$2$1$1(this), 6);
            L17:
                return true;
            L18:
                return false;
            L5:
                if (r1.isInRealTimeChorus() != true) goto L12;
                com.bytedance.android.live.ktv.common.tuningpanel.ability.a r4 = r0.a.b;
                if (r4 == null) goto L12;
                if (r4.r() != true) goto L12;
                r2 = false;
                goto L13
            }

            public a(d r1, Ref.BooleanRef r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        public final String a() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L8;
            if (r0.isInRealTimeChorus() != true) goto L8;
            return s1.B(2131918412);
        L8:
            return s1.B(2131918643);
        }

        public final SeekBarWithProgress.b b() {
            Ref.BooleanRef r0 = new Ref.BooleanRef();
            r0.element = false;
            return new a(this, r0);
        }

        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 100;
        L7:
            return r0.w();
        }

        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.e();
        }

        public d(n r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r3) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L6;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.b(r0, r3, 6);
            return;
        }
    }

    public static final class e implements gc0.c {
        public final /* synthetic */ n a;

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L5;
            Integer r1 = Integer.valueOf(r0.D());
        L7:
            return r1.intValue();
        L5:
            r1 = null;
            goto L7
        }

        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L5;
            Float r1 = Float.valueOf(r0.V());
        L7:
            return (int) r1.floatValue();
        L5:
            r1 = null;
            goto L7
        }

        public final String a() {
            return s1.B(2131918273);
        }

        public e(n r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r2) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.j(r2);
            return;
        }
    }

    public static final class f implements gc0.c {
        public final /* synthetic */ n a;

        public static final class a implements SeekBarWithProgress.b {
            public final /* synthetic */ f a;

            public final boolean a() {
                com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a.b;
                if (r0 != null) goto L5;
                return true;
            L5:
                if (r0.d(TuningVolumeType.ACCOMPANIMENT_VOLUME) != true) goto L10;
                return false;
            L10:
                return true;
            }

            public a(f r1) {
                this.a = r1;
            }
        }

        public final String a() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L8;
            if (r0.isInRealTimeChorus() != true) goto L8;
            return s1.B(2131918272);
        L8:
            return s1.B(2131918450);
        }

        public final SeekBarWithProgress.b b() {
            return new a(this);
        }

        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 100;
        L7:
            return r0.N();
        }

        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.A();
        }

        public f(n r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r2) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.G(r2);
            return;
        }
    }

    public static final class g implements gc0.a {
        public final /* synthetic */ n a;

        public final int a() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.u();
        }

        public final void b() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.c0(1.0d);
            return;
        }

        public final void c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.g0(1.0d);
            return;
        }

        public g(n r1) {
            this.a = r1;
        }

        public final boolean d(TuningVolumeType r2) {
            Intrinsics.checkNotNullParameter(r2, "toneVolume");
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.d(r2) != true) goto L7;
            return true;
        }
    }

    static {
    }

    public n(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1) {
        this.b = r1;
    }

    public final void a(TuningVolumeContentArea r4) {
        Intrinsics.checkNotNullParameter(r4, "tuningVolumeContentArea");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.b;
        if (r0 == null) goto L10;
        MutableLiveData r1 = r0.F();
        if (r1 == null) goto L10;
        LifecycleOwner r2 = this.a;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
    L9:
        r1.observe(r2, new b(this, r4));
    L10:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r5 = this.b;
        if (r5 == null) goto L14;
        r5.L();
        return;
    }

    public final void b(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.a = r2;
    }

    public final void c(TuningVolumeContentArea r7, WeakReference<Context> r8) {
        Intrinsics.checkNotNullParameter(r7, "tuningVolumeContentArea");
        Intrinsics.checkNotNullParameter(r8, "context");
        r7.removeAllViews();
        Context r9 = r8.get();
        if (r9 == null) goto L15;
        r7.a(TuningVolumeType.EAR_BACK_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new c(this), r9, false, 28));
        r7.a(TuningVolumeType.VOCAL_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new d(this), r9, false, 28));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.b;
        if (r0 != null) goto L7;
    L9:
        r7.a(TuningVolumeType.ACCOMPANIMENT_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new f(this), r9, false, 28));
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1 = this.b;
        if (r1 != null) goto L12;
    L13:
        r7.a(TuningVolumeType.TONE_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.c(new g(this), r9, false, 28));
        return;
    L12:
        if (r1.isInRealTimeChorus() != true) goto L13;
        return;
    L7:
        if (r0.n() != true) goto L9;
        r7.a(TuningVolumeType.CHORUS_SINGER_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new e(this), r9, false, 28));
        goto L9
    }
}
