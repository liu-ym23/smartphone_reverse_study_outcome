package com.larus.audio.call.plugins;

import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.ReducerPosition;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes24.dex */
public class CommonHelloPlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements y0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f289364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f289365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.larus.audio.call.o f289366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f289367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MajorState.From f289368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f289369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HelloDownReducer f289370l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Job f289371m;

    public static final class a implements com.larus.audio.call.mgr.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonHelloPlugin<C> f289372a;

        public a(CommonHelloPlugin<C> r100) {
            this.f289372a = r100;
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r100, MajorState r101) {
            Intrinsics.checkNotNullParameter(r100, "prev");
            Intrinsics.checkNotNullParameter(r101, "current");
            CommonHelloPlugin<C> r102 = this.f289372a;
            r102.f289367i = r101.f289171a;
            if ((r101 instanceof MajorState.d) == false) goto L13;
            MajorState.From r103 = ((MajorState.d) r101).f289182c;
            if (r103 == MajorState.From.PLAY_COMPLETE) goto L7;
            return;
        L7:
            if (r102.f289369k == false) goto L15;
            r102.f289369k = false;
            r102.f289368j = r103;
            com.larus.audio.call.o r104 = r102.f289366h;
            if (r104 == null) goto L11;
            r104.a();
        L11:
            r102.f289366h = null;
            com.larus.audio.call.arch.b.a(this.f289372a.getContext()).l1();
            com.larus.audio.call.util.e.f289645a.i(this.f289372a.T2(), "Listening , isFromTriggerHello , startAudioRecord!!");
            return;
        L15:
            return;
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f289373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CommonHelloPlugin<C> f289374b;

        @Override // com.larus.im.service.audio.z0
        public final String g() {
            return this.f289373a;
        }

        public b(CommonHelloPlugin<C> r100) {
            this.f289374b = r100;
            this.f289373a = r100.T2();
        }

        @Override // com.larus.im.service.audio.z0
        public final void n(com.larus.im.service.audio.z0.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            Intrinsics.checkNotNullParameter(r100, "event");
            if ((r100 instanceof pf9.r) == false) goto L14;
            pf9.r r101 = (pf9.r) r100;
            if (r101.getType() != TriggerMode.HELLO) goto L7;
        L10:
            boolean r102 = true;
        L11:
            if (r102 == false) goto L15;
            this.f289374b.f289365g = true;
            return;
        L15:
            return;
        L7:
            if (r101.getType() == TriggerMode.HELLO_NEW) goto L10;
            r102 = false;
            goto L11
        }
    }

    public void C1() {
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.v R2() {
        return new CommonHelloPlugin$createSessionConnStateListener$1(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public boolean j3() {
        com.larus.audio.call.util.e.f289645a.i(T2(), "[CALL] canSendHelloEvent [" + this.f289365g + "][" + getContext().params().A + "][" + getContext().params().I + "][" + getContext().params().f288759s + ']');
        if (this.f289365g == false) goto L5;
    L11:
        return false;
    L5:
        if (getContext().params().A == false) goto L7;
    L10:
        return true;
    L7:
        if (getContext().params().I < 0) goto L11;
        if (getContext().params().f288759s == AudioSessionType.SAMI) goto L11;
        goto L10
    }

    public void k3() {
        ouc.e0 r100 = new ouc.e0();
        q68.d.b(r100, "enter_method", getContext().params().f288756p.f288861i);
        String r101 = getContext().params().f288756p.f288853a;
        boolean r102 = true;
        if ((!StringsKt.isBlank(r101)) == false) goto L5;
        q68.d.b(r100, MusicAppletPage.KEY_MESSAGE_ID, r101);
    L5:
        String r103 = getContext().params().f288756p.f288868p;
        if (r103 != null) goto L8;
    L16:
        ouc.d0 r104 = r100.a();
        id9.d r105 = getContext().j();
        if (r105 == null) goto L20;
        r105.p(TriggerMode.HELLO, r104.toString());
        return;
    L20:
        return;
    L8:
        if (r103.length() > 0) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L14;
        r103 = null;
    L14:
        if (r103 == null) goto L16;
        q68.d.b(r100, "bot_say_hello_text_key", r103);
        goto L16
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r100 = this.f289371m;
        if (r100 != null) goto L7;
    L8:
        this.f289371m = U2(new CommonHelloPlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r100.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    @Override // com.larus.audio.call.plugins.y0
    public boolean b1() {
        return j3();
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        getContext().a().F2(this.f289370l, ReducerPosition.APPEND);
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f289364f;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
    }

    public CommonHelloPlugin(C r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f289364f = "CommonHelloPlugin";
        this.f289367i = -1;
        this.f289370l = new HelloDownReducer();
    }
}
