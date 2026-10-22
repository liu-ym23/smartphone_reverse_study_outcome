package com.bytedance.android.livesdk.ktvimpl.base.component.midi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.ktv.common.midi.k;
import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdk.config.q40;
import com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.midi.KtvComponentMidiView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/component/midi/KaraokeMidiComponent;", "Lcom/bytedance/android/livesdk/ktvimpl/base/component/AbsViewComponent;", "", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KaraokeMidiComponent extends AbsViewComponent {
    public static final /* synthetic */ int m = 0;
    public KaraokeMidiViewModel g;
    public KtvComponentMidiView h;
    public int i;
    public final md2.b j;
    public final md2.c k;
    public final md2.a l;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ com.bytedance.android.live.ktv.common.util.c a;

        public b(KtvComponentMidiView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function2 r0 = this.a.getOneDrawCallback();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            Unit r1 = (Unit) r0.invoke(Boolean.TRUE, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KaraokeMidiComponent a;

        public c(KaraokeMidiComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            KaraokeMidiComponent r0 = this.a;
            int r1 = KaraokeMidiComponent.m;
            r0.getClass();
            List r6 = (List) r5;
            if (r6 != null) goto L5;
        L8:
            boolean r7 = true;
        L10:
            if (r7 == false) goto L12;
            md2.e.a("KaraokeMidiComponent", "handleMidiResDone fail");
            return;
        L12:
            KaraokeMidiViewModel r8 = r0.g;
            if (r8 == null) goto L15;
            Pair<Integer, Integer> r9 = r8.calcToneRange();
        L16:
            md2.e.a("KaraokeMidiComponent", "handleMidiResDone toneRange " + r9);
            KtvComponentMidiView r2 = r0.h;
            if (r2 == null) goto L21;
            r2.xc(r9);
            return;
        L21:
            return;
        L15:
            r9 = null;
            goto L16
        L5:
            if (r6.isEmpty() == true) goto L8;
            r7 = false;
            goto L10
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KaraokeMidiComponent a;

        public d(KaraokeMidiComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            g0 r3 = (g0) r2;
            KaraokeMidiComponent r0 = this.a;
            if (r3 != null) goto L5;
            int r4 = KaraokeMidiComponent.m;
            r0.getClass();
            return;
        L5:
            KtvComponentMidiView r1 = r0.h;
            if (r1 == null) goto L10;
            r1.setConfig(r3);
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ KaraokeMidiComponent a;

        public e(KaraokeMidiComponent r1) {
            this.a = r1;
        }

        public final void onChanged(Object r21) {
            Pair r0 = (Pair) r21;
            KaraokeMidiComponent r2 = this.a;
            int r3 = KaraokeMidiComponent.m;
            r2.getClass();
            k r4 = null;
            if (r0 == null) goto L5;
            Long r5 = (Long) r0.getFirst();
        L6:
            if (r0 == null) goto L8;
            r4 = (k) r0.getSecond();
        L8:
            com.bytedance.android.live.ktv.common.util.c r1 = r2.h;
            boolean r6 = false;
            if (r1 != null) goto L11;
        L20:
            if (r4 == null) goto L41;
            int r7 = r4.e;
            int r8 = r2.i;
            if (r7 > r8) goto L28;
            if (r7 == 0) goto L25;
        L29:
            if (r6 == false) goto L39;
            com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r9 = r2.l.c();
            if (r9 == null) goto L39;
            com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a r10 = r9.d();
            if (r10 == null) goto L39;
            float r11 = r4.c;
            float r12 = r4.d;
            float r13 = r4.b;
            float r14 = r4.a;
            int r15 = r4.e;
            if (r5 == null) goto L37;
            float r18 = r5.longValue();
        L38:
            r10.a(new KaraokeMidiScoreInfo(r11, r12, r13, r14, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r15, r18));
            goto L39
        L37:
            r18 = 0.0f;
        L39:
            r2.i = r4.e;
            return;
        L25:
            if (r4.c <= 0) goto L29;
            if (r8 != (-1)) goto L29;
        L28:
            r6 = true;
            goto L29
        L41:
            return;
        L11:
            if (r1.getVisibility() != 0) goto L20;
            if (r4 == null) goto L16;
            KtvComponentMidiView r16 = r2.h;
            if (r16 == null) goto L16;
            r16.F9(r4, r5, false);
        L16:
            if (r5 == null) goto L20;
            r5.longValue();
            KtvComponentMidiView r17 = r2.h;
            if (r17 == null) goto L20;
            r17.R2(r5.longValue());
            goto L20
        L5:
            r5 = null;
            goto L6
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final ViewGroup c() {
        View r0 = LayoutInflater.from(this.f.getContext()).inflate(2131565310, this.f, false);
        if (r0 == null) goto L7;
        return (ViewGroup) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void e() {
        ViewGroup r0 = this.d;
        Boolean r1 = null;
        if (r0 == null) goto L5;
        KtvComponentMidiView r2 = (KtvComponentMidiView) r0.findViewById(2131365695);
    L6:
        this.h = r2;
        if (r2 == null) goto L9;
        r2.setPerformStrategy(this.k);
    L9:
        KtvComponentMidiView r3 = this.h;
        if (r3 == null) goto L12;
        r3.qc(this.j);
    L12:
        KtvComponentMidiView r4 = this.h;
        if ((r4 instanceof com.bytedance.android.live.ktv.common.util.c) == true) goto L15;
        r4 = null;
    L15:
        if (r4 == null) goto L20;
        this.l.b();
        ViewGroup r5 = this.f;
        if (r5 == null) goto L19;
        r1 = Boolean.valueOf(r5.postDelayed(new b(r4), ((Long) q40.a.getValue()).longValue()));
    L19:
        r1.booleanValue();
    L20:
        KaraokeMidiViewModel r6 = this.g;
        if (r6 == null) goto L26;
        KtvComponentMidiView r7 = this.h;
        if (r7 == null) goto L27;
        r7.Gk(r6, this.k);
        return;
    L27:
        return;
    L26:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void f() {
        KaraokeMidiViewModel r0 = (KaraokeMidiViewModel) new ViewModelProvider(this, new KaraokeMidiViewModelFactory(this.l)).get(KaraokeMidiViewModel.class);
        this.g = r0;
        if (r0 == null) goto L5;
        r0.onCreate();
    L5:
        KaraokeMidiViewModel r1 = this.g;
        if (r1 == null) goto L10;
        MutableLiveData<List<cb0.c>> r2 = r1.getMidiData();
        if (r2 == null) goto L10;
        r2.observe(this, new c(this));
    L10:
        KaraokeMidiViewModel r3 = this.g;
        if (r3 == null) goto L15;
        MutableLiveData<g0> r4 = r3.getMidiConfig();
        if (r4 == null) goto L15;
        r4.observe(this, new d(this));
    L15:
        KaraokeMidiViewModel r5 = this.g;
        if (r5 == null) goto L21;
        MutableLiveData<Pair<Long, k>> r6 = r5.m20getScoreInfo();
        if (r6 == null) goto L22;
        r6.observe(this, new e(this));
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.component.AbsViewComponent
    public final void onDestroy() {
        KtvComponentMidiView r0 = this.h;
        if (r0 == null) goto L5;
        r0.onDetach();
    L5:
        super.onDestroy();
    }

    public KaraokeMidiComponent(LifecycleOwner r2, ViewGroup r3, com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.k r4) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "containerView");
        Intrinsics.checkNotNullParameter(r4, "midiRunContext");
        super(r2, r3);
        this.l = r4;
        this.i = -1;
        this.j = new md2.b();
        this.k = new md2.c();
    }
}
