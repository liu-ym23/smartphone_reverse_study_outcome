package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.TuningVolumeContentArea;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ConcertTuningVolumeOuterCallback implements gc0.d {
    public final Lazy a;
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a b;
    public final ld2.b c;
    public final boolean d;
    public final int e;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ConcertTuningVolumeOuterCallback a;
        public final /* synthetic */ TuningVolumeContentArea b;

        public b(ConcertTuningVolumeOuterCallback r1, TuningVolumeContentArea r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            View r4 = this.b.b(TuningVolumeType.EAR_BACK_VOLUME);
            if (r4 == null) goto L9;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.b;
            if (r0 == null) goto L7;
            r0.i();
        L7:
            r4.setVisibility(8);
            return;
        }
    }

    public static final class c implements gc0.c {
        public final /* synthetic */ ConcertTuningVolumeOuterCallback a;

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int d() {
            ld2.b r0 = this.a.c;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.e();
        }

        public final String a() {
            String r0 = s1.B(2131918414);
            ConcertTuningVolumeOuterCallback r1 = this.a;
            r1.getClass();
            if (v.a() == true) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == false) goto L24;
            StringBuilder r3 = new StringBuilder();
            r3.append(r0);
            r3.append('(');
            int r4 = this.a.e;
            if (r4 != 1) goto L12;
            String r5 = s1.B(2131918356);
        L22:
            r3.append(r5);
            r3.append(')');
            return r3.toString();
        L12:
            if (r4 != 2) goto L14;
            r5 = s1.B(2131918355);
            goto L22
        L14:
            if (r4 != 3) goto L16;
            r5 = s1.B(2131918353);
            goto L22
        L16:
            if (r4 == 4) goto L18;
            r5 = "";
            goto L22
        L18:
            r5 = s1.B(2131918354);
            goto L22
        L24:
            return r0;
        L5:
            if (((Boolean) r1.a.getValue()).booleanValue() == false) goto L7;
            r2 = true;
            goto L8
        }

        public final int c() {
            return KtvSettingHelper.d().f();
        }

        public c(ConcertTuningVolumeOuterCallback r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r2) {
            ld2.b r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.b(r2);
            return;
        }
    }

    public static final class d implements gc0.c {
        public final /* synthetic */ ConcertTuningVolumeOuterCallback a;

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int d() {
            ld2.b r0 = this.a.c;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.f();
        }

        public final String a() {
            return s1.B(2131918413);
        }

        public final int c() {
            return KtvSettingHelper.d().d();
        }

        public d(ConcertTuningVolumeOuterCallback r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r2) {
            ld2.b r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }
    }

    public static final class e implements gc0.c {
        public final /* synthetic */ ConcertTuningVolumeOuterCallback a;

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int d() {
            ld2.b r0 = this.a.c;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return r0.a();
        }

        public final String a() {
            return s1.B(2131918352);
        }

        public final int c() {
            return KtvSettingHelper.d().e();
        }

        public e(ConcertTuningVolumeOuterCallback r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r3) {
            ALogger.i("ConcertTuningVolumeOuterCallback", "other volume change, volume: " + r3);
            ld2.b r0 = this.a.c;
            if (r0 == null) goto L6;
            r0.c(r3);
            return;
        }
    }

    static {
    }

    public final void a(TuningVolumeContentArea r3) {
        Intrinsics.checkNotNullParameter(r3, "tuningVolumeContentArea");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.b;
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.F();
        if (r1 == null) goto L7;
        r1.observe(r3, new b(this, r3));
    L7:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r4 = this.b;
        if (r4 == null) goto L11;
        r4.L();
        return;
    }

    public final void b(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
    }

    public final void c(TuningVolumeContentArea r6, WeakReference<Context> r7) {
        Intrinsics.checkNotNullParameter(r6, "tuningVolumeContentArea");
        Intrinsics.checkNotNullParameter(r7, "context");
        r6.setPadding(r6.getPaddingLeft(), r6.getPaddingTop(), r6.getPaddingRight(), UtilityKotlinExtentionsKt.i(16));
        r6.removeAllViews();
        Context r8 = r7.get();
        if (r8 != null) goto L5;
        return;
    L5:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L7;
        r6.a(TuningVolumeType.VOCAL_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new c(this), r8, false, 28));
    L7:
        r6.a(TuningVolumeType.EAR_BACK_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new d(this), r8, false, 28));
        if (this.d == true) goto L12;
        TuningVolumeType r0 = TuningVolumeType.CHORUS_SINGER_VOLUME;
        com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j r3 = new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new e(this), r8, false, 28);
        r3.setPadding(s1.f(16.0f), s1.f(16.0f), s1.f(16.0f), s1.f(25.0f));
        Unit r9 = Unit.INSTANCE;
        r6.a(r0, r3);
        return;
    }

    public ConcertTuningVolumeOuterCallback(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1, ld2.b r2, boolean r3, int r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = LazyKt.lazy(ConcertTuningVolumeOuterCallback$needShowRoleTips$2.INSTANCE);
    }
}
