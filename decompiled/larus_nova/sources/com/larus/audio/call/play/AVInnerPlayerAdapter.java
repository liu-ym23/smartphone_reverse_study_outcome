package com.larus.audio.call.play;

import com.bytedance.ai.event.MessageIndication;
import com.larus.im.service.audio.q;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.w1;
import ouc.d0;
import ouc.g0;
import ouc.k;

/* JADX INFO: loaded from: classes24.dex */
public final class AVInnerPlayerAdapter implements u68.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f289275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f289276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f289277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f289278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f289279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f289280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CoroutineScope f289281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AVInnerPlayerAdapter$linkPlayerCallback$1 f289282h;

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AVInnerPlayerAdapter f289283a;

        public a(CoroutineExceptionHandler.Key r100, AVInnerPlayerAdapter r101) {
            this.f289283a = r101;
            super(r100);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public final void handleException(CoroutineContext r100, Throwable r101) {
            com.larus.audio.call.util.e.f289645a.w(this.f289283a.f289276b, "[dispatchScope] exception: " + r101.getMessage(), r101);
        }
    }

    @Override // u68.a
    public final void a() {
    }

    @Override // u68.a
    public final void e(boolean r100) {
    }

    @Override // u68.c
    public final void f() {
    }

    @Override // u68.b
    public final void g(h r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // u68.a
    public final void b() {
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[interrupt]");
        this.f289279e = true;
        LinkedHashMap r100 = new LinkedHashMap();
        g0 r101 = k.c("client_interrupt");
        Intrinsics.checkNotNullParameter("end_type", "key");
        Intrinsics.checkNotNullParameter(r101, "element");
        ouc.i r102 = (ouc.i) r100.put("end_type", r101);
        d0 r103 = new d0(r100);
        if (this.f289280f == false) goto L5;
        this.f289280f = false;
        this.f289277c.e(MessageIndication.STATUS_INTERRUPT, true, r103.toString());
        return;
    L5:
        this.f289277c.g(r103.toString());
    }

    @Override // u68.a
    public final void h() {
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[clearTTS], unresolved");
    }

    @Override // u68.c
    public final void init() {
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[init]");
        this.f289277c.init();
        this.f289277c.f().l(this.f289282h);
    }

    @Override // u68.a
    public final boolean isPlaying() {
        if (this.f289277c.f().isPlaying() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f289277c.f().a() == true) goto L8;
        return false;
    }

    @Override // u68.a
    public final void c(boolean r100) {
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[mutePlay], enable: " + r100);
        this.f289277c.c(r100);
    }

    @Override // u68.a
    public final void i(u68.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f289278d.h(r100);
    }

    @Override // u68.a
    public final void j(u68.a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        f r101 = this.f289278d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (((CopyOnWriteArraySet) r101.f289323b).contains(r100) == false) goto L7;
        ((CopyOnWriteArraySet) r101.f289323b).remove(r100);
        return;
    }

    @Override // u68.a
    public final void pause(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[pause], caller: " + r100);
        this.f289277c.pausePlay(r100);
    }

    @Override // u68.a
    public final void release(boolean r100) {
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[release], finishCall: " + r100);
        this.f289277c.f().q(this.f289282h);
        this.f289277c.a("release");
        if (CoroutineScopeKt.isActive(this.f289281g) == false) goto L6;
        CoroutineScopeKt.cancel$default(this.f289281g, null, 1, null);
        return;
    }

    @Override // u68.a
    public final void resume(String r100) {
        Intrinsics.checkNotNullParameter(r100, "caller");
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[resume], caller: " + r100);
        this.f289277c.d(r100);
    }

    @Override // u68.a
    public final void setVolume(float r100) {
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[setVolume], gain: " + r100);
        this.f289277c.setVolume(RangesKt.coerceIn(r100 * ((float) 100), 0.0f, 100.0f));
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.larus.audio.call.play.AVInnerPlayerAdapter$linkPlayerCallback$1] */
    public AVInnerPlayerAdapter(id9.d r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "dumpConfig");
        this.f289275a = r101;
        this.f289276b = "AVInnerPlayerAdapter_" + hashCode();
        this.f289277c = r100.v();
        this.f289278d = new f();
        this.f289281g = CoroutineScopeKt.CoroutineScope(w1.a(1, "AVInnerPlayer").plus(new a(CoroutineExceptionHandler.Key, this)));
        this.f289282h = new AVInnerPlayerAdapter$linkPlayerCallback$1(this);
    }

    @Override // u68.a
    public final void d(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "endType");
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[stop], immediate: " + r100 + ", releaseTrack: " + r101 + ", caller: " + r102);
        q r103 = this.f289277c;
        LinkedHashMap r104 = new LinkedHashMap();
        g0 r105 = k.c(r102);
        Intrinsics.checkNotNullParameter("end_type", "key");
        Intrinsics.checkNotNullParameter(r105, "element");
        ouc.i r106 = (ouc.i) r104.put("end_type", r105);
        Unit r107 = Unit.INSTANCE;
        r103.e(r102, r100, new d0(r104).toString());
    }

    @Override // u68.a
    public final void k(boolean r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "caller");
        com.larus.audio.call.util.e.f289645a.i(this.f289276b, "[play], flushBeforeStart: " + r100 + ", createAudioTrackWhenNotExist: " + r101 + ", caller: " + r102);
        if (r101 == false) goto L6;
        this.f289277c.startPlay(r102);
        return;
    L6:
        if (this.f289277c.f().a() == false) goto L10;
        this.f289277c.d(r102);
        return;
    }
}
