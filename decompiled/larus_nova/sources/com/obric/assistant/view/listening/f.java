package com.obric.assistant.view.listening;

import androidx.camera.video.AudioStats;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.component.ObricIntercomComponent;
import com.obric.assistant.voice.IObricVoiceService;
import com.obric.assistant.voice.ObricVoiceServiceImpl;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import laa.n;

/* JADX INFO: loaded from: classes33.dex */
public final class f {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicLong f394312l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f394313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Runnable, Unit> f394314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f394315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f394316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.obric.assistant.view.listening.b f394317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObricListeningVisualMode f394318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ObricListeningVisualMode f394319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f394320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView<com.obric.assistant.view.listening.b, Boolean> f394321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f394322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h f394323k;

    public static final class a {
    }

    public interface b {
        void a();

        void b(ArrayList<Double> r100);

        void c();

        boolean isAvailable();
    }

    static {
        f394312l = new AtomicLong(0);
    }

    public static com.obric.assistant.view.listening.a a() {
        IObricVoiceService.f394360a.getClass();
        IObricVoiceService r100 = IObricVoiceService.a.a();
        if (r100 != null) goto L5;
        return null;
    L5:
        ObricVoiceServiceImpl.b r101 = r100.f();
        if (r101 != null) goto L9;
        return null;
    L9:
        if (sha.b.b() == true) goto L12;
        return null;
    L12:
        return new com.obric.assistant.view.listening.a(r101);
    }

    public final com.obric.assistant.view.listening.b b() {
        com.obric.assistant.view.listening.b r100 = a();
        if (r100 != null) goto L12;
        com.obric.assistant.view.listening.b r101 = this.f394317e;
        if ((r101 instanceof i) == false) goto L8;
        r100 = (i) r101;
    L9:
        if (r100 != null) goto L12;
        r100 = new i(f394312l.incrementAndGet());
        goto L12
    L8:
        r100 = null;
    L12:
        this.f394321i.add(r100);
        return r100;
    }

    public final com.obric.assistant.view.listening.b d(n r100) {
        if ((r100 instanceof com.obric.assistant.view.listening.b) == false) goto L5;
        com.obric.assistant.view.listening.b r101 = (com.obric.assistant.view.listening.b) r100;
    L6:
        if (r101 != null) goto L9;
        return null;
    L9:
        if ((r101 instanceof com.obric.assistant.view.listening.a) == true) goto L11;
    L19:
        return r101;
    L11:
        if (this.f394322j == true) goto L19;
        if (((com.obric.assistant.view.listening.a) r101).f394305a.isActive() == true) goto L19;
        if ((this.f394317e instanceof i) == false) goto L17;
    L18:
        return null;
    L17:
        if (a() != null) goto L19;
    L5:
        r101 = null;
        goto L6
    }

    public final void c(n r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        Intrinsics.checkNotNullParameter(r101, "reason");
        if ((r100 instanceof com.obric.assistant.view.listening.b) == false) goto L5;
        com.obric.assistant.view.listening.b r102 = (com.obric.assistant.view.listening.b) r100;
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if ((r102 instanceof i) == false) goto L12;
        FLogger.f375446a.i("ObricListeningViewController", "finish local listening handle, reason=" + r101 + ", generation=" + ((i) r102).f394327a);
    L14:
        this.f394321i.remove(r102);
        if (Intrinsics.areEqual(this.f394317e, r102) == false) goto L20;
        this.f394317e = null;
        return;
    L20:
        return;
    L12:
        if ((r102 instanceof com.obric.assistant.view.listening.a) == false) goto L19;
        FLogger.f375446a.i("ObricListeningViewController", "publish hidden delegated listening state, reason=".concat(r101));
        ((com.obric.assistant.view.listening.a) r102).f394305a.finish();
        goto L14
    L19:
        throw new NoWhenBranchMatchedException();
    L5:
        r102 = null;
        goto L6
    }

    public final boolean e(com.obric.assistant.view.listening.b r100, double r101) {
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if ((r100 instanceof i) == false) goto L13;
        com.obric.assistant.view.listening.b r102 = this.f394317e;
        if (r102 == null) goto L11;
        if (Intrinsics.areEqual(r102, r100) == true) goto L11;
        return true;
    L13:
        if ((r100 instanceof com.obric.assistant.view.listening.a) == false) goto L30;
        com.obric.assistant.view.listening.a r103 = (com.obric.assistant.view.listening.a) r100;
        if (r103.f394305a.b() == true) goto L17;
        return true;
    L17:
        if (r103.f394305a.isActive() == true) goto L20;
        return true;
    L20:
        if (Intrinsics.areEqual(this.f394317e, r100) == false) goto L22;
        ObricListeningVisualMode r104 = this.f394318f;
    L23:
        com.obric.assistant.voice.d r105 = r103.f394305a;
        if (r101 <= 0.5d) goto L26;
        double r106 = 1.0d;
    L27:
        r105.a(new ObricListeningViewState(r104, true, RangesKt.coerceIn(((float) r106) * 2.5f, 0.0f, 1.0f)));
        r103.f394305a.confirmListeningStarted();
        return true;
    L26:
        r106 = Math.sin(RangesKt.coerceAtLeast(r101, AudioStats.AUDIO_AMPLITUDE_NONE) * 3.141592653589793d);
        goto L27
    L22:
        r104 = ObricListeningVisualMode.CLICK_TALK;
        goto L23
    L30:
        throw new NoWhenBranchMatchedException();
    }

    public f(LifecycleCoroutineScope r100, Function1 r101, ObricIntercomComponent.f r102) {
        Intrinsics.checkNotNullParameter(r100, "coroutineScope");
        Intrinsics.checkNotNullParameter(r101, "runOnUiThread");
        Intrinsics.checkNotNullParameter(r102, "host");
        this.f394313a = r100;
        this.f394314b = r101;
        this.f394315c = r102;
        this.f394318f = ObricListeningVisualMode.CLICK_TALK;
        this.f394321i = ConcurrentHashMap.newKeySet();
        this.f394323k = new h(this);
    }

    public final void g(ObricListeningVisualMode r100, String r101, Function0<Boolean> r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r110, "renderLocal");
        Intrinsics.checkNotNullParameter(r111, "onVisible");
        f(b(), r100, r101, r110, r111);
    }

    public final void f(n r100, ObricListeningVisualMode r101, String r102, Function0<Boolean> r103, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r102, "reason");
        Intrinsics.checkNotNullParameter(r103, "renderLocal");
        Intrinsics.checkNotNullParameter(r110, "onVisible");
        if ((r100 instanceof com.obric.assistant.view.listening.b) == false) goto L5;
        com.obric.assistant.view.listening.b r104 = (com.obric.assistant.view.listening.b) r100;
    L6:
        if (r104 != null) goto L9;
        return;
    L9:
        if ((r104 instanceof i) == false) goto L16;
        if (r103.invoke().booleanValue() == true) goto L14;
        FLogger.f375446a.i("ObricListeningViewController", "skip unavailable local listening View, reason=" + r102 + ", generation=" + ((i) r104).f394327a + ", mode=" + r101);
        return;
    L14:
        this.f394321i.add(r104);
        this.f394317e = r104;
        this.f394318f = r101;
        r110.invoke();
        return;
    L16:
        if ((r104 instanceof com.obric.assistant.view.listening.a) == false) goto L29;
        ObricListeningVisualMode r105 = this.f394319g;
        ObricListeningVisualMode r106 = ObricListeningVisualMode.PRESS_TALK;
        if (r105 == r106) goto L20;
    L22:
        r106 = r101;
    L23:
        com.obric.assistant.view.listening.a r107 = (com.obric.assistant.view.listening.a) r104;
        if (r107.f394305a.isActive() == true) goto L26;
        FLogger.f375446a.i("ObricListeningViewController", "drop stale delegated visible state, reason=" + r102 + ", mode=" + r106);
        return;
    L26:
        this.f394317e = r104;
        this.f394318f = r106;
        this.f394319g = r106;
        FLogger.f375446a.i("ObricListeningViewController", "publish delegated listening state, reason=" + r102 + ", requestedMode=" + r101 + ", mode=" + r106);
        r107.f394305a.a(new ObricListeningViewState(r106, true, 0.0f));
        r110.invoke();
        return;
    L20:
        if (r101 != ObricListeningVisualMode.CLICK_TALK) goto L22;
    L29:
        throw new NoWhenBranchMatchedException();
    L5:
        r104 = null;
        goto L6
    }
}
