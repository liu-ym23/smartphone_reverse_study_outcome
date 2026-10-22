package com.larus.kmp.voice_setting.voice.screen.doubletab;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class VoiceEditRegionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e4 f354171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableState f354172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState f354173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableState f354174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableState f354175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableState f354176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableState f354177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableState f354178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableState f354179i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final MutableState f354180j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MutableState f354181k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MutableState f354182l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutableState f354183m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public e8 f354184n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f354185o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f354186p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableState f354187q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final MutableState f354188r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final State f354189s;

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e() {
        return ((Boolean) this.f354178h.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final h i() {
        return (h) this.f354177g.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i j() {
        return (i) this.f354176f.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.larus.kmp.voice_setting.voice.component.s4 k() {
        return (com.larus.kmp.voice_setting.voice.component.s4) this.f354173c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final k1 l() {
        return (k1) this.f354175e.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int m() {
        return ((Number) this.f354179i.getValue()).intValue();
    }

    public final float n() {
        return RangesKt.coerceIn(this.f354171a.getState().b(), this.f354171a.getState().c(), d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean o() {
        return ((Boolean) this.f354188r.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final com.larus.kmp.voice_setting.voice.component.i5 p() {
        return (com.larus.kmp.voice_setting.voice.component.i5) this.f354174d.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float d() {
        if (r() == true) goto L5;
        return 0.0f;
    L5:
        float r100 = this.f354171a.getState().c();
        return RangesKt.coerceIn(((Number) this.f354181k.getValue()).floatValue() + r100, r100, 0.0f);
    }

    public final boolean f() {
        return k().b();
    }

    public final float g() {
        if (r() == false) goto L6;
        return 1.0f;
    L6:
        return RangesKt.coerceIn(this.f354171a.getState().a(), 0.0f, 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float h() {
        if (r() == true) goto L5;
        return 0.0f;
    L5:
        float r100 = this.f354171a.getState().c();
        return RangesKt.coerceIn(n() - r100, 0.0f, ((Number) this.f354181k.getValue()).floatValue());
    }

    public final boolean q() {
        if (ih9.f.a().f489918b == false) goto L6;
        return ((Boolean) this.f354189s.getValue()).booleanValue();
    L6:
        if (g() < 0.98f) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean r() {
        if (f() == true) goto L5;
    L9:
        return false;
    L5:
        if (k().f352536h == false) goto L9;
        if (k().f352535g == true) goto L9;
        return true;
    }

    public final boolean s() {
        return k().d();
    }

    public VoiceEditRegionState(x3 r210) {
        Intrinsics.checkNotNullParameter(r210, "scrollBehavior");
        this.f354171a = r210;
        this.f354172b = SnapshotStateKt.mutableStateOf$default(new com.larus.kmp.voice_setting.voice.component.p(0), null, 2, null);
        this.f354173c = SnapshotStateKt.mutableStateOf$default(new com.larus.kmp.voice_setting.voice.component.s4(null, false, false, null, false, false, false, false, 0, null, null, null, 0, null, null, null, 131071), null, 2, null);
        this.f354174d = SnapshotStateKt.mutableStateOf$default(new com.larus.kmp.voice_setting.voice.component.i5(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK), null, 2, null);
        this.f354175e = SnapshotStateKt.mutableStateOf$default(new k1(0), null, 2, null);
        this.f354176f = SnapshotStateKt.mutableStateOf$default(new i(0), null, 2, null);
        this.f354177g = SnapshotStateKt.mutableStateOf$default(new h(0), null, 2, null);
        Boolean r100 = Boolean.FALSE;
        this.f354178h = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.f354179i = SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        Float r101 = Float.valueOf(0.0f);
        this.f354180j = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
        this.f354181k = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
        this.f354182l = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.f354183m = SnapshotStateKt.mutableStateOf$default("", null, 2, null);
        this.f354186p = "";
        this.f354187q = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.f354188r = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.f354189s = SnapshotStateKt.derivedStateOf(new g8(this));
    }

    public final float c(float r100) {
        float r101 = 0.0f;
        if (e() == true) goto L5;
    L17:
        return 0.0f;
    L5:
        if (r100 != 0.0f) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L17;
        float r103 = this.f354171a.getState().c();
        float r104 = this.f354171a.getState().b();
        if (r100 <= 0.0f) goto L13;
        r101 = d();
    L13:
        float r105 = RangesKt.coerceIn(r100 + r104, r103, r101);
        float r106 = r105 - r104;
        if (Math.abs(r106) <= 0.5f) goto L16;
        this.f354171a.getState().d(r105);
    L16:
        return r106;
    L7:
        r102 = false;
        goto L8
    }

    public final void v(boolean r100) {
        this.f354188r.setValue(Boolean.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(boolean r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onAppBarCollapsedChanged");
        if (Intrinsics.areEqual((Boolean) this.f354182l.getValue(), Boolean.valueOf(r100)) == true) goto L6;
        this.f354182l.setValue(Boolean.valueOf(r100));
        e.a("[editAreaCollapse:publish] collapsed=" + r100 + " mode=" + k().f352529a + " fraction=" + g() + " offset=" + this.f354171a.getState().b() + " limit=" + this.f354171a.getState().c() + " height=" + m());
        r101.invoke(Boolean.valueOf(r100));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(float r110, float r111) {
        float r100 = 0.0f;
        this.f354180j.setValue(Float.valueOf(RangesKt.coerceAtLeast(r110, 0.0f)));
        this.f354181k.setValue(Float.valueOf(RangesKt.coerceAtLeast(r111, 0.0f)));
        float r112 = -RangesKt.coerceAtLeast(r110, 0.0f);
        float r101 = this.f354171a.getState().c();
        float r102 = this.f354171a.getState().b();
        boolean r103 = false;
        if (r101 < 0.0f) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.f354171a.getState().e(r112);
        float r105 = d();
        if (r112 != 0.0f) goto L11;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L15;
    L25:
        this.f354171a.getState().d(r100);
        if (r101 != r112) goto L28;
        r103 = true;
    L28:
        if (r103 == true) goto L30;
    L31:
        e.a("[editAreaRange] mode=" + k().f352529a + " mixCount=" + p().f352294e.size() + " collapsed=" + k().f352536h + " range=" + r110 + " limit=" + r101 + "->" + r112 + " upper=" + r105 + " offset=" + r102 + "->" + r100 + " height=" + m() + " canScroll=" + e() + " gestureExpand=" + k().f352535g + " gestureReveal=" + ((Number) this.f354181k.getValue()).floatValue());
        return;
    L30:
        if (Math.abs(r102 - r100) > 0.5f) goto L31;
        return;
    L15:
        if (k().f352536h == true) goto L17;
    L24:
        r100 = RangesKt.coerceIn(r102, r112, r105);
        goto L25
    L17:
        if (f() == false) goto L24;
        if (r101 != 0.0f) goto L20;
        boolean r107 = true;
    L21:
        if (r107 == true) goto L23;
        if (r104 == false) goto L24;
    L23:
        r100 = r112;
        goto L25
    L20:
        r107 = false;
        goto L21
    L11:
        r106 = false;
        goto L12
    L5:
        if (Math.abs(r102 - r101) > 1.0f) goto L7;
        r104 = true;
        goto L8
    }

    public final Object a(boolean r100, Function1<? super Boolean, Unit> r101, Continuation<? super Unit> r102) {
        float r103 = 0.0f;
        if (f() == true) goto L6;
        this.f354171a.getState().d(0.0f);
        u(false, r101);
        return Unit.INSTANCE;
    L6:
        if (r100 == false) goto L8;
        r103 = this.f354171a.getState().c();
    L8:
        Object r104 = b(r100, r103, r101, r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r104;
    L12:
        return Unit.INSTANCE;
    }

    public final Object b(boolean r110, float r111, Function1<? super Boolean, Unit> r112, Continuation<? super Unit> r113) {
        if ((r113 instanceof VoiceEditRegionState$animateExplicitToOffset$1) == false) goto L7;
        VoiceEditRegionState$animateExplicitToOffset$1 r100 = (VoiceEditRegionState$animateExplicitToOffset$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        VoiceEditRegionState$animateExplicitToOffset$1 r102 = r100;
        Object r114 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        r111 = r102.F$0;
        r110 = r102.Z$0;
        r112 = (Function1) r102.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Throwable -> L22
    L20:
        Object r115 = Result.m9449constructorimpl((AnimationResult) r114);     // Catch: Throwable -> L22
    L25:
        if (Result.m9452exceptionOrNullimpl(r115) == null) goto L27;
        this.f354171a.getState().d(r111);
    L27:
        this.f354187q.setValue(null);
        this.f354171a.getState().d(r111);
        u(r110, r112);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r114);
        this.f354187q.setValue(Boxing.boxBoolean(r110));
        float r116 = this.f354171a.getState().b();
        e.a("[editAreaVisual:animate] collapsed=" + r110 + " mode=" + k().f352529a + " layout=" + k().f352532d + " mixCount=" + p().f352294e.size() + " offset=" + r116 + "->" + r111 + " limit=" + this.f354171a.getState().c());
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L22
        Animatable r106 = AnimatableKt.Animatable$default(r116, 0.0f, 2, null);     // Catch: Throwable -> L22
        Float r117 = Boxing.boxFloat(r111);     // Catch: Throwable -> L22
        TweenSpec r107 = AnimationSpecKt.tween$default(260, 0, EasingKt.getFastOutSlowInEasing(), 2, null);     // Catch: Throwable -> L22
        Function1 r108 = new f8(this);     // Catch: Throwable -> L22
        r102.L$0 = r112;     // Catch: Throwable -> L22
        r102.Z$0 = r110;     // Catch: Throwable -> L22
        r102.F$0 = r111;     // Catch: Throwable -> L22
        r102.label = 1;     // Catch: Throwable -> L22
        r114 = Animatable.animateTo$default(r106, r117, r107, null, r108, r102, 4, null);     // Catch: Throwable -> L22
        if (r114 != r103) goto L20;
        return r103;
    L22:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new VoiceEditRegionState$animateExplicitToOffset$1(this, r113);
        goto L8
    }

    public final void t(int r110, int r111, int r112, float r113) {
        if (r110 > 0) goto L5;
        return;
    L5:
        if (this.f354185o == true) goto L7;
    L13:
        boolean r100 = false;
    L15:
        if (r113 > 0.01f) goto L18;
    L24:
        int r101 = r110;
    L27:
        if (r101 == m()) goto L43;
        int r102 = m();
        boolean r103 = this.f354185o;
        String r104 = this.f354186p;
        this.f354179i.setValue(Integer.valueOf(r101));
        v(false);
        if (r103 == false) goto L32;
        this.f354185o = false;
        this.f354186p = "";
    L32:
        if (f() == false) goto L38;
        int r114 = RangesKt.coerceAtLeast((r112 + r101) - r111, 0);
        if (r() == false) goto L36;
        float r115 = r112;
    L37:
        w(r114, r115);
        goto L38
    L36:
        r115 = 0.0f;
    L38:
        StringBuilder r116 = new StringBuilder("[editAreaMeasure:size] mode=");
        r116.append(k().f352529a);
        r116.append(" collapsed=");
        r116.append(k().f352536h);
        r116.append(" fraction=");
        r116.append(r113);
        r116.append(" measured=");
        r116.append(r110);
        r116.append(" height=");
        r116.append(r102);
        r116.append("->");
        r116.append(r101);
        r116.append(" structuralShrink=");
        r116.append(r100);
        r116.append(" reason=");
        if (StringsKt.isBlank(r104) == false) goto L41;
        r104 = "none";
    L41:
        r116.append(r104);
        e.a(r116.toString());
        return;
    L43:
        if (o() == false) goto L51;
        v(false);
        if (this.f354185o == true) goto L47;
        return;
    L47:
        if (r110 < m()) goto L53;
        this.f354185o = false;
        this.f354186p = "";
        return;
    L53:
        return;
    L51:
        return;
    L18:
        if (m() == 0) goto L24;
        if (r110 > m()) goto L24;
        if (r100 == true) goto L24;
        r101 = m();
        goto L27
    L7:
        if (r110 >= m()) goto L13;
        if (o() == false) goto L11;
    L12:
        r100 = true;
        goto L15
    L11:
        if (r113 > 0.01f) goto L13;
        goto L12
    }
}
