package com.larus.bmhome.chat.component.bottom.voice.service;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.k0;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes25.dex */
public final class VoiceMixInputManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f300443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f300444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f300445c;

    public static final class TextStreamWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f300446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CoroutineScope f300447b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final StateFlowImpl f300448c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ValueAnimator f300449d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f300450e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f300451f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f300452g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f300453h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public r19.b f300454i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f300455j;

        public final void c() {
            ValueAnimator r100 = this.f300449d;
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == false) goto L11;
            int r102 = d0.f300410d;
            d0.a.a("tryUpdateFinalTextStream");
            BuildersKt.launch$default(this.f300447b, null, null, new VoiceMixInputManager$TextStreamWrapper$tryUpdateFinalTextStream$1(this, null), 3, null);
            return;
        L11:
            return;
        L5:
            if (r100.isRunning() == true) goto L7;
            r101 = true;
            goto L8
        }

        public final Unit d() {
            SpannableString r100 = new SpannableString(this.f300451f + this.f300450e);
            if (this.f300455j == true) goto L5;
            Resources r101 = this.f300446a.getResources();
            int r102 = v19.c.b(R.attr.larus_neutral_100, this.f300446a, R.color.larus_neutral_100);
        L6:
            r100.setSpan(new ForegroundColorSpan(r101.getColor(r102)), 0, r100.length(), 17);
            Unit r103 = a(r100, false, true);
            if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
            return r103;
        L10:
            return Unit.INSTANCE;
        L5:
            r101 = this.f300446a.getResources();
            r102 = R.color.larus_static_white;
            goto L6
        }

        public final Object b(Continuation<? super Unit> r100) {
            if ((r100 instanceof VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1) == false) goto L7;
            VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1 r101 = (VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L14;
            if (r105 != 1) goto L13;
            ResultKt.throwOnFailure(r103);
        L21:
            if (this.f300454i != null) goto L28;
            if (this.f300455j == true) goto L25;
            int r106 = R.drawable.larus_chat_common_loading_dot;
        L26:
            this.f300454i = new r19.b(r106, this.f300446a);
            goto L28
        L25:
            r106 = R.drawable.larus_dot_immers;
        L28:
            if (this.f300449d != null) goto L30;
            ValueAnimator r107 = ValueAnimator.ofInt(new int[]{0, 255});
            r107.setDuration(400);
            r107.setRepeatCount(-1);
            r107.setRepeatMode(2);
            r107.addUpdateListener(new r(this));
            this.f300449d = r107;
        L30:
            ValueAnimator r108 = this.f300449d;
            if (r108 == null) goto L34;
            r108.start();
        L34:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r103);
            int r109 = d0.f300410d;
            d0.a.a("startUpdateTextStream");
            d0.a.a("stopUpdateTextStream");
            ValueAnimator r110 = this.f300449d;
            if (r110 == null) goto L17;
            r110.cancel();
        L17:
            this.f300450e = "";
            this.f300453h = false;
            r101.label = 1;
            this.f300448c.setValue(null);
            Unit r111 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (r111 != r104) goto L21;
            return r104;
        L7:
            r101 = new VoiceMixInputManager$TextStreamWrapper$startUpdateTextStream$1(this, r100);
            goto L8
        }

        public TextStreamWrapper(Context r100, CoroutineScope r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "scope");
            this.f300446a = r100;
            this.f300447b = r101;
            this.f300448c = j1.a(null);
            this.f300450e = "";
            this.f300451f = "";
            this.f300452g = "";
        }

        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "textContext");
            Intrinsics.checkNotNullParameter(r101, "textContent");
            int r102 = d0.f300410d;
            d0.a.a("updateTextStream: textContext=" + r100 + " textContent=" + r101 + " updateHint=false");
            this.f300451f = r100;
            this.f300450e = r101;
            this.f300453h = false;
            c();
        }

        public final Unit a(CharSequence r100, boolean r101, boolean r102) {
            this.f300448c.setValue(new h(r100, r101, r102));
            Unit r103 = Unit.INSTANCE;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            return r103;
        }
    }

    public static final class Timer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CoroutineScope f300456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f300457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function1<? super Continuation<? super Unit>, ? extends Object> f300458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f300459d;

        public Timer(CoroutineScope r100, final long r101) {
            Intrinsics.checkNotNullParameter(r100, "scope");
            this.f300456a = r100;
            this.f300457b = true;
            this.f300458c = new VoiceMixInputManager$Timer$onTimerFinish$1(null);
            this.f300459d = LazyKt.lazy(new s(r101, this));
        }
    }

    public static final class a {
    }

    static {
    }

    public final void b() {
        int r100 = d0.f300410d;
        d0.a.a("stop voice mix input");
        boolean r101 = true;
        if (this.f300444b.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L23;
        d0.a.a("real stop voice mix input");
        String r103 = this.f300444b;
        IFlowSdkDepend r104 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r104 == null) goto L17;
        com.larus.home.impl.sdk.s r105 = r104.s0();
        if (r105 == null) goto L17;
        Integer r106 = r105.l();
        if (r106 == null) goto L17;
        if (r106.intValue() != 2) goto L17;
    L19:
        if (r101 == false) goto L21;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VoiceMixInputManager$stopASR$1(null), 3, null);
    L21:
        d0.a.a("stop asr");
        k0.a.a(AudioServiceDelegate.f288288a.x(), r103, null);
        a(this.f300444b, false);
        this.f300444b = "";
        return;
    L17:
        r101 = false;
        goto L19
    L23:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public VoiceMixInputManager() {
        this.f300443a = LazyKt.lazy(new i());
        this.f300444b = "";
        this.f300445c = true;
    }

    public static void a(String r100, boolean r101) {
        String r102 = "VoiceMixInputManager-" + r100;
        if (r101 == false) goto L5;
        fa9.e.f476067a.a("voice_input", r102);
        return;
    L5:
        fa9.e.f476067a.f("voice_input", r102);
    }
}
