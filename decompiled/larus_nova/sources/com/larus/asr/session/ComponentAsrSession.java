package com.larus.asr.session;

import com.larus.asr.ChatBottomSpeakerComponent;
import com.larus.asr.VoiceInputType;
import com.larus.asr.session.component.AsrEngineRoute;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class ComponentAsrSession implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f287439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f287440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VoiceInputType f287441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f287442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f2a.d f287443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.larus.asr.session.component.f0 f287444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f287445g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile com.larus.asr.session.component.f0 f287446h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f287447i;

    public static final class a {
    }

    static {
    }

    public abstract com.larus.asr.session.component.d0 b();

    public void h(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public void i(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
    }

    public void j(com.larus.asr.session.component.f0 r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "path");
    }

    @Override // com.larus.asr.session.o
    public final com.larus.bmhome.chat.component.bottom.core.speaker.g J5() {
        return this.f287444f.f287710l.get();
    }

    @Override // com.larus.asr.session.o
    public void clear() {
        com.larus.asr.session.component.f0 r100 = this.f287446h;
        if (r100 == null) goto L5;
        r100.f287706h.set(true);
    L5:
        Iterator<T> r101 = d().iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((com.larus.asr.session.component.o0) r101.next()).onClear();
        goto L7
    L9:
        if (r100 == null) goto L13;
        r100.f(false);
        return;
    }

    public final List<com.larus.asr.session.component.o0> d() {
        return ((com.larus.asr.session.component.d0) this.f287445g.getValue()).f287691b;
    }

    @Override // com.larus.asr.session.o
    public boolean m0() {
        com.larus.asr.session.component.f0 r100 = this.f287446h;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f287704f.get() != true) goto L7;
        return true;
    }

    public final List<com.larus.asr.session.component.q0> k() {
        List<com.larus.asr.session.component.o0> r100 = d();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof com.larus.asr.session.component.q0) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    @Override // com.larus.asr.session.o
    public final void onStop() {
        Iterator<T> r100 = d().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.o0) r100.next()).onStop();
        goto L4
    }

    public static final List a(ComponentAsrSession r100) {
        List<com.larus.asr.session.component.p0> r101 = ((com.larus.asr.session.component.d0) r100.f287445g.getValue()).f287690a;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof com.larus.asr.session.component.n0) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    @Override // com.larus.asr.session.o
    public final void A4(com.larus.bmhome.chat.component.bottom.core.speaker.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287444f.f287709k.add(r100);
    }

    @Override // com.larus.asr.session.o
    public final void B9(com.larus.bmhome.chat.component.bottom.core.speaker.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287444f.f287708j.remove(r100);
    }

    @Override // com.larus.asr.session.o
    public final void K8(com.larus.bmhome.chat.component.bottom.core.speaker.b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287444f.f287709k.remove(r100);
    }

    @Override // com.larus.asr.session.o
    public final void b3(Function1<? super String, com.larus.bmhome.chat.component.bottom.core.speaker.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "withExtHandle");
        Iterator<T> r101 = k().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r101.next()).b(r100);
        goto L4
    }

    public final boolean e(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f287442d.invoke().booleanValue() == true) goto L5;
    L13:
        return false;
    L5:
        if (this.f287446h != r100) goto L13;
        if (g(r100) == false) goto L13;
        if (r100.c() == true) goto L13;
        if (r100.f287705g.get() == true) goto L13;
        return true;
    }

    @Override // com.larus.asr.session.o
    public final void e8(com.larus.bmhome.chat.component.bottom.core.speaker.h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f287444f.f287708j.add(r100);
    }

    public boolean f(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return e(r100);
    }

    public boolean g(com.larus.asr.session.component.f0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return Intrinsics.areEqual(r100.f287699a, this.f287439a.ua());
    }

    @Override // com.larus.asr.session.o
    public final void na(Function2<? super String, ? super Boolean, Unit> r100) {
        Iterator<T> r101 = k().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r101.next()).g(r100);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void oa(com.larus.bmhome.chat.component.bottom.core.speaker.g r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f287444f.e(r100);
    }

    @Override // com.larus.asr.session.o
    public final void ra(Function2<? super String, ? super String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        Iterator r101 = ((ArrayList) k()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r101.next()).k(r100);
        goto L4
    }

    @Override // com.larus.asr.session.o
    public final void sa(ChatBottomSpeakerComponent.f r100) {
        Intrinsics.checkNotNullParameter(r100, "handle");
        this.f287447i = r100;
    }

    public final void c(int r100, com.larus.asr.session.component.b0 r101) {
        if (r101.f287686e.invoke().booleanValue() == true) goto L6;
        com.larus.asr.session.component.f0 r102 = r101.getContext();
        r102.f287706h.set(true);
        r102.f(true);
        return;
    L6:
        com.larus.asr.session.component.p0 r103 = (com.larus.asr.session.component.p0) CollectionsKt.getOrNull(((com.larus.asr.session.component.d0) this.f287445g.getValue()).f287690a, r100);
        if (r103 != null) goto L9;
        return;
    L9:
        r103.b(r101, new i(new AtomicBoolean(false), this, r100, r101));
    }

    @Override // com.larus.asr.session.o
    public void qa(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        com.larus.asr.session.component.f0 r102 = this.f287446h;
        if (r102 == null) goto L5;
        r102.f287706h.set(true);
    L5:
        com.larus.asr.session.component.f0 r103 = this.f287446h;
        if (r103 == null) goto L8;
        r103.f287704f.set(false);
        r103.f287703e.compareAndSet(false, true);
    L8:
        com.larus.asr.session.component.f0 r104 = this.f287446h;
        if (r104 == null) goto L11;
        r104.f(false);
    L11:
        com.larus.asr.session.component.a r105 = new com.larus.asr.session.component.a(r100, r101);
        Iterator<T> r106 = d().iterator();
    L13:
        if (r106.hasNext() == false) goto L15;
        ((com.larus.asr.session.component.o0) r106.next()).d(r105);
        goto L13
    L15:
        Iterator<T> r107 = d().iterator();
    L17:
        if (r107.hasNext() == false) goto L19;
        ((com.larus.asr.session.component.o0) r107.next()).c(r105);
        goto L17
    }

    @Override // com.larus.asr.session.o
    public void ma(String r100, Message r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        com.larus.asr.session.component.f0 r103 = this.f287446h;
        if (r103 == null) goto L5;
        r103.f287703e.set(false);
    L5:
        com.larus.asr.session.component.f0 r104 = this.f287446h;
        if (r104 == null) goto L8;
        r104.d();
    L8:
        com.larus.asr.session.component.j0 r105 = new com.larus.asr.session.component.j0(r100, r101, r102);
        Iterator<T> r106 = d().iterator();
    L10:
        if (r106.hasNext() == false) goto L12;
        ((com.larus.asr.session.component.o0) r106.next()).i(r105);
        goto L10
    L12:
        Iterator<T> r107 = d().iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        ((com.larus.asr.session.component.o0) r107.next()).e(r105);
        goto L14
    }

    public ComponentAsrSession(p r100, String r101, VoiceInputType r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionContext");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "voiceInputType");
        Intrinsics.checkNotNullParameter(r103, "isCurrentSession");
        this.f287439a = r100;
        this.f287440b = r101;
        this.f287441c = r102;
        this.f287442d = r103;
        this.f287443e = new f2a.d("VoiceInput", "ComponentAsrSession");
        this.f287444f = new com.larus.asr.session.component.f0(r101, r103);
        this.f287445g = LazyKt.lazy(new ComponentAsrSession$components$2(this));
        this.f287447i = new k();
    }

    @Override // com.larus.asr.session.o
    public final void la(Function1<? super com.larus.audio.b, Boolean> r100, Function1<? super com.larus.audio.a, Boolean> r101, Function2<? super String, ? super byte[], Unit> r102, Function1<? super String, Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "successResultHandle");
        Intrinsics.checkNotNullParameter(r101, "failResultHandle");
        Intrinsics.checkNotNullParameter(r102, "audioDataHandle");
        Intrinsics.checkNotNullParameter(r103, "handle");
        Iterator r104 = ((ArrayList) k()).iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        ((com.larus.asr.session.component.q0) r104.next()).m(r100, r101, r102, r103);
        goto L4
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [com.larus.asr.session.h] */
    @Override // com.larus.asr.session.o
    public final void pa(String r110, boolean r111, boolean r112, com.larus.audio.asr.c0 r113, long r114, Long r210, Integer r211, d58.a r212) {
        Intrinsics.checkNotNullParameter(r110, "itemId");
        Intrinsics.checkNotNullParameter(r113, "traceInfo");
        Intrinsics.checkNotNullParameter(r212, "durationConfig");
        final com.larus.asr.session.component.f0 r100 = this.f287444f;
        com.larus.asr.session.component.k0 r115 = new com.larus.asr.session.component.k0(r110, r111, r112, r113, r114, r210, r211, r212);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r115, "request");
        r100.f287701c = r115;
        r100.f287703e.set(false);
        r100.f287704f.set(false);
        r100.f287705g.set(false);
        r100.f287706h.set(false);
        r100.f287702d = null;
        r100.f287711m = null;
        r100.f287712n = 0;
        r100.f287713o = AsrEngineRoute.NONE;
        r100.f287707i = null;
        r100.f287715q = false;
        i(r100);
        this.f287446h = r100;
        c(0, new com.larus.asr.session.component.b0(r100, new l(r100, this), new m(this), this.f287447i, new h(this, r100)));
    }
}
