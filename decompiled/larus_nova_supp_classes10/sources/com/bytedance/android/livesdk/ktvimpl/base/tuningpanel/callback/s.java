package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.callback;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.TuningVolumeContentArea;
import com.bytedance.android.livesdk.widget.SeekBarWithProgress;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class s implements gc0.d {
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a a;

    public static final class a<T> implements Observer {
        public final /* synthetic */ s a;
        public final /* synthetic */ TuningVolumeContentArea b;

        public a(s r1, TuningVolumeContentArea r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            View r4 = this.b.b(TuningVolumeType.EAR_BACK_VOLUME);
            if (r4 == null) goto L9;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 == null) goto L7;
            r0.i();
        L7:
            r4.setVisibility(8);
            return;
        }
    }

    public static final class b implements gc0.c {
        public final /* synthetic */ s a;

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 != null) goto L7;
            return 100;
        L7:
            return r0.U();
        }

        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.f();
        }

        public final String a() {
            return s1.B(2131918382);
        }

        public b(s r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r2) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 == null) goto L6;
            r0.g(r2);
            return;
        }
    }

    public static final class c implements gc0.c {
        public final /* synthetic */ s a;

        public final SeekBarWithProgress.b b() {
            return new gc0.b();
        }

        public final int c() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 != null) goto L7;
            return 100;
        L7:
            return r0.w();
        }

        public final int d() {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 != null) goto L7;
            return 50;
        L7:
            return (int) r0.e();
        }

        public final String a() {
            return s1.B(2131918643);
        }

        public c(s r1) {
            this.a = r1;
        }

        public final void onProgressChanged(int r3) {
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a.a;
            if (r0 == null) goto L6;
            com.bytedance.android.live.ktv.common.tuningpanel.ability.a.a.b(r0, r3, 6);
            return;
        }
    }

    public s(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r1) {
        this.a = r1;
    }

    public final void a(TuningVolumeContentArea r3) {
        Intrinsics.checkNotNullParameter(r3, "tuningVolumeContentArea");
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = this.a;
        if (r0 == null) goto L7;
        MutableLiveData r1 = r0.F();
        if (r1 == null) goto L7;
        r1.observe(r3, new a(this, r3));
    L7:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r4 = this.a;
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
        r6.removeAllViews();
        Context r8 = r7.get();
        if (r8 == null) goto L6;
        r6.a(TuningVolumeType.EAR_BACK_VOLUME, new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new b(this), r8, false, 28));
        TuningVolumeType r0 = TuningVolumeType.VOCAL_VOLUME;
        com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j r1 = new com.bytedance.android.live.ktv.common.tuningpanel.tuningvolume.view.j(new c(this), r8, false, 28);
        r1.setPadding(s1.f(16.0f), s1.f(25.0f), s1.f(16.0f), s1.f(25.0f));
        Unit r9 = Unit.INSTANCE;
        r6.a(r0, r1);
        return;
    }
}
