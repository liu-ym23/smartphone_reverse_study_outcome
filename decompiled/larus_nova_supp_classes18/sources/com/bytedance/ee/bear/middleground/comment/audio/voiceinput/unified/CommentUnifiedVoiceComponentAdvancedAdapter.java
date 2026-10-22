package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.richtext.CommentVoiceEditTextBridge;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.SpannableStringUtils;
import com.ss.android.lark.voiceinput.api.data.config.asr.resultConfig.VoiceAsrMode;
import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentUnifiedVoiceComponentAdvancedAdapter implements CommentUnifiedVoiceComponentSessionCoordinator.d {
    public static final /* synthetic */ int j = 0;
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f a;
    public final Function0<Unit> b;
    public final g c;
    public final Function1<Fragment, CommentUnifiedVoiceComponentSessionCoordinator> d;
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.c e;
    public final Function0<String> f;
    public long g;
    public a h;
    public boolean i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/audio/voiceinput/unified/CommentUnifiedVoiceComponentAdvancedAdapter$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "PREPARED", "RECORDING", "WAITING_FINAL", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase PREPARED = null;
        public static final Phase RECORDING = null;
        public static final Phase WAITING_FINAL = null;
        public static final /* synthetic */ Phase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Phase> getEntries() {
            return b;
        }

        static {
            Phase r0 = new Phase("PREPARED", 0);
            PREPARED = r0;
            Phase r1 = new Phase("RECORDING", 1);
            RECORDING = r1;
            Phase r3 = new Phase("WAITING_FINAL", 2);
            WAITING_FINAL = r3;
            Phase[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Phase[] values() {
            return (Phase[]) a.clone();
        }

        public static Phase valueOf(String r1) {
            return (Phase) r27.a.a(Phase.class, r1);
        }

        public Phase(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final long a;
        public final View b;
        public final ViewGroup c;
        public final CommentUnifiedVoiceComponentSessionCoordinator d;
        public final CommentUnifiedVoiceComponentSessionCoordinator.c e;
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d f;
        public final Lifecycle g;
        public final DefaultLifecycleObserver h;
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.a i;
        public Phase j;
        public final ebc.b k;
        public MotionEvent l;
        public String m;
        public String n;
        public boolean o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public AdvancedVoiceFinishReason t;
        public boolean u;
        public final b v;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
            return false;
        L36:
            if (this.j == r9.j) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r9.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r9.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
            return false;
        L51:
            if (this.o == r9.o) goto L54;
            return false;
        L54:
            if (this.p == r9.p) goto L57;
            return false;
        L57:
            if (this.q == r9.q) goto L60;
            return false;
        L60:
            if (this.r == r9.r) goto L63;
            return false;
        L63:
            if (this.s == r9.s) goto L66;
            return false;
        L66:
            if (this.t == r9.t) goto L69;
            return false;
        L69:
            if (this.u == r9.u) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.v, r9.v) == true) goto L74;
            return false;
        L74:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((((((((((((((((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
            MotionEvent r2 = this.l;
            int r3 = 0;
            if (r2 != null) goto L5;
            int r4 = 0;
        L6:
            int r5 = (r1 + r4) * 31;
            String r6 = this.m;
            if (r6 != null) goto L9;
            int r7 = 0;
        L10:
            int r8 = (r5 + r7) * 31;
            String r9 = this.n;
            if (r9 != null) goto L13;
            int r10 = 0;
        L14:
            int r11 = (r8 + r10) * 31;
            int r12 = 1231;
            if (this.o == false) goto L17;
            int r13 = 1231;
        L18:
            int r14 = (r11 + r13) * 31;
            if (this.p == false) goto L21;
            int r15 = 1231;
        L22:
            int r16 = (r14 + r15) * 31;
            if (this.q == false) goto L25;
            int r17 = 1231;
        L26:
            int r18 = (r16 + r17) * 31;
            if (this.r == false) goto L29;
            int r19 = 1231;
        L30:
            int r20 = (r18 + r19) * 31;
            if (this.s == false) goto L33;
            int r21 = 1231;
        L34:
            int r22 = (r20 + r21) * 31;
            AdvancedVoiceFinishReason r23 = this.t;
            if (r23 == null) goto L38;
            r3 = r23.hashCode();
        L38:
            int r24 = (r22 + r3) * 31;
            if (this.u == true) goto L43;
            r12 = 1237;
        L43:
            return ((r24 + r12) * 31) + this.v.hashCode();
        L33:
            r21 = 1237;
            goto L34
        L29:
            r19 = 1237;
            goto L30
        L25:
            r17 = 1237;
            goto L26
        L21:
            r15 = 1237;
            goto L22
        L17:
            r13 = 1237;
            goto L18
        L13:
            r10 = r9.hashCode();
            goto L14
        L9:
            r7 = r6.hashCode();
            goto L10
        L5:
            r4 = r2.hashCode();
            goto L6
        }

        public final String toString() {
            return "ActiveSession(id=" + this.a + ", sourceView=" + this.b + ", parent=" + this.c + ", coordinator=" + this.d + ", lease=" + this.e + ", provider=" + this.f + ", lifecycle=" + this.g + ", lifecycleObserver=" + this.h + ", touchInterceptGuard=" + this.i + ", phase=" + this.j + ", voiceView=" + this.k + ", lastTouchEvent=" + this.l + ", taskId=" + this.m + ", releaseTextSnapshot=" + this.n + ", bridgeStarted=" + this.o + ", recordUiStopped=" + this.p + ", shellVisible=" + this.q + ", hasVoiceText=" + this.r + ", loadingPrimed=" + this.s + ", pendingFinishReason=" + this.t + ", finalResultDelivered=" + this.u + ", uiState=" + this.v + ')';
        }

        public a(long r4, View r6, ViewGroup r7, CommentUnifiedVoiceComponentSessionCoordinator r8, CommentUnifiedVoiceComponentSessionCoordinator.c r9, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d r10, Lifecycle r11, CommentUnifiedVoiceComponentAdvancedAdapter$onActionDown$lifecycleObserver$1 r12, com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.a r13, ebc.b r14) {
            Phase r0 = Phase.PREPARED;
            b r1 = new b();
            Intrinsics.checkNotNullParameter(r6, "sourceView");
            Intrinsics.checkNotNullParameter(r7, "parent");
            Intrinsics.checkNotNullParameter(r8, "coordinator");
            Intrinsics.checkNotNullParameter(r9, "lease");
            Intrinsics.checkNotNullParameter(r10, "provider");
            Intrinsics.checkNotNullParameter(r11, "lifecycle");
            Intrinsics.checkNotNullParameter(r12, "lifecycleObserver");
            Intrinsics.checkNotNullParameter(r13, "touchInterceptGuard");
            Intrinsics.checkNotNullParameter(r0, "phase");
            Intrinsics.checkNotNullParameter(r14, "voiceView");
            Intrinsics.checkNotNullParameter(r1, "uiState");
            this.a = r4;
            this.b = r6;
            this.c = r7;
            this.d = r8;
            this.e = r9;
            this.f = r10;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = r0;
            this.k = r14;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = false;
            this.p = false;
            this.q = false;
            this.r = false;
            this.s = false;
            this.t = null;
            this.u = false;
            this.v = r1;
        }
    }

    public static final class b {
        public View a;
        public Integer b;
        public ConstraintLayout.LayoutParams c;
        public ConstraintLayout.LayoutParams d;
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q e;
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q f;
        public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q g;

        public b() {
            this.e = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q();
            this.f = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q();
            this.g = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q();
        }
    }

    public static final class c {
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Phase.values().length];
            r0[Phase.PREPARED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L34:
            r0[Phase.RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L46:
            r0[Phase.WAITING_FINAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L8:
            a = r0;
            int[] r1 = new int[VoiceRecordState.values().length];
            r1[VoiceRecordState.Recording.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L36:
            r1[VoiceRecordState.Stopped.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L48:
            r1[VoiceRecordState.Canceled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L30:
            r1[VoiceRecordState.Failed.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L38:
            r1[VoiceRecordState.Idle.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L32:
            r1[VoiceRecordState.Preparing.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L40:
            r1[VoiceRecordState.Prepared.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L44:
            r1[VoiceRecordState.Destroy.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L17:
            b = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentSessionCoordinator.d
    public final void a() {
        a r0 = this.h;
        if (r0 == null) goto L5;
        e(r0, AdvancedVoiceFinishReason.REPLACED);
    L5:
        s();
    }

    public final boolean l() {
        if (this.a.c.c().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        CommentVoiceEditTextBridge r1 = this.a.c;
        r1.getClass();
        Lazy r2 = SpannableStringUtils.a;
        CommentVoiceEditTextBridge.d r3 = r1.i(SpannableStringUtils.a(r1.a.getContext(), new SpannableStringBuilder(), new SpannableStringUtils.a(r1.a), null), true, null);
        tt5.a.h("CommentVoice", "[advanced] prime loading success=" + r3.a);
        return r3.a;
    L5:
        r0 = false;
        goto L6
    }

    public final View n() {
        Function0<View> r0 = this.a.m;
        if (r0 == null) goto L6;
        View r1 = (View) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        Function0<View> r2 = this.a.k;
        if (r2 != null) goto L12;
        return null;
    L12:
        return (View) r2.invoke();
    }

    public final ebc.a p() {
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r1 = this.a;
        com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a r2 = r1.w;
        if (r2 == null) goto L5;
        ebc.a r3 = new ebc.a(r2.a, r2.b, r2.c, r2.d, r2.e, r2.f, r2.g, 800);
    L6:
        Integer r9 = Integer.valueOf(UIUtils.dp2px(this.a.a, 8.0f));
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r4 = this.a;
        if (r4.x == false) goto L9;
        Integer r5 = null;
    L10:
        int r6 = r3.a;
        boolean r7 = r3.b;
        float r8 = r3.c;
        boolean r10 = r3.d;
        Integer r11 = r3.e;
        Integer r12 = r3.g;
        Integer r13 = r3.h;
        return new ebc.a(r6, r7, r8, r10, r11, r9, r12, r13, r5, -16094209);
    L9:
        r5 = Integer.valueOf(UIUtils.dp2px(r4.a, 12.0f));
        goto L10
    L5:
        r3 = new ebc.a(2131890974, false, 14.0f, false, Integer.valueOf(UIUtils.dp2px(r1.a, 48.0f)), null, null, 992);
        goto L6
    }

    public final void s() {
        if (this.i == true) goto L5;
        return;
    L5:
        this.i = false;
        Function1<Boolean, Unit> r0 = this.a.F;
        if (r0 == null) goto L9;
        r0.invoke(Boolean.FALSE);
        return;
    }

    public final void b(a r5) {
        if (r5.o == true) goto L5;
    L11:
        r5.s = false;
        return;
    L5:
        if (r5.s == false) goto L11;
        if (r5.r == true) goto L11;
        CommentVoiceEditTextBridge r0 = this.a.c;
        int r2 = CommentVoiceEditTextBridge.i;
        CommentVoiceEditTextBridge.d r1 = r0.i("", false, null);
        r5.s = false;
        tt5.a.h("CommentVoice", "[advanced] clear primed loading success=" + r1.a);
    }

    public final a c(long r6) {
        a r0 = this.h;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.a != r6) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L19;
        CommentUnifiedVoiceComponentSessionCoordinator.c r8 = r0.e;
        if (r8.b.isCurrent(r8) == true) goto L16;
        return null;
    L16:
        return r0;
    L19:
        return null;
    L7:
        r7 = false;
        goto L8
    }

    public final void h(a r4) {
        if (this.h == r4) goto L5;
        return;
    L5:
        if (r4.j != Phase.RECORDING) goto L10;
        Phase r0 = Phase.WAITING_FINAL;
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r4.j = r0;
        r4.n = this.a.c.c().toString();
        q(r4);
        tt5.a.h("CommentVoice", "[advanced] waiting final session=" + r4.a);
        return;
    }

    public final boolean i(MotionEvent r6) {
        a r1 = this.h;
        if (r1 != null) goto L28;
        return false;
    L28:
        m(r1, r6);     // Catch: Throwable -> L22
        AdvancedVoiceFinishReason r2 = r1.t;     // Catch: Throwable -> L22
        if (r2 == null) goto L14;
        r1.t = null;     // Catch: Throwable -> L22
        if (this.h != r1) goto L11;
        e(r1, r2);     // Catch: Throwable -> L22
    L11:
        r1.i.a();
        return true;
    L14:
        if (r1.u == true) goto L11;
        d(r1, r6);     // Catch: Throwable -> L22
        if (this.h != r1) goto L11;
        if (r1.j == Phase.WAITING_FINAL) goto L11;
        e(r1, AdvancedVoiceFinishReason.CANCEL);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        g("handle advanced action cancel session=" + r1.a, th);     // Catch: Throwable -> L25
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        r1.i.a();
        throw th;
    }

    public final boolean j(MotionEvent r6) {
        a r1 = this.h;
        if (r1 != null) goto L37;
        return false;
    L37:
        m(r1, r6);     // Catch: Throwable -> L31
        AdvancedVoiceFinishReason r2 = r1.t;     // Catch: Throwable -> L31
        if (r2 == null) goto L14;
        r1.t = null;     // Catch: Throwable -> L31
        if (this.h != r1) goto L11;
        e(r1, r2);     // Catch: Throwable -> L31
    L11:
        r1.i.a();
        return true;
    L14:
        if (r1.u == true) goto L11;
        d(r1, r6);     // Catch: Throwable -> L31
        if (this.h != r1) goto L11;
        int r7 = d.a[r1.j.ordinal()];     // Catch: Throwable -> L31
        if (r7 != 1) goto L22;
        e(r1, AdvancedVoiceFinishReason.SHORT_CLICK);     // Catch: Throwable -> L31
        goto L11
    L22:
        if (r7 != 2) goto L24;
        h(r1);     // Catch: Throwable -> L31
        goto L11
    L24:
        if (r7 != 3) goto L27;
        q(r1);     // Catch: Throwable -> L31
        goto L11
    L27:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        g("handle advanced action up session=" + r1.a, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r1.i.a();
        throw th;
    }

    public final CharSequence o(zac.a r4) {
        zac.c r5 = r4.b;
        String r0 = r5.a;
        if (r0 != null) goto L5;
        String r1 = "";
    L6:
        RichText r6 = r5.b;
        if (r6 != null) goto L22;
        return r0;
    L22:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        CommentVoiceEditTextBridge r3 = this.a.c;     // Catch: Throwable -> L11
        r3.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r1, "content");     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r6, "richText");     // Catch: Throwable -> L11
        Object r7 = Result.constructor-impl(CommentVoiceEditTextBridge.a.a(r3.a.getContext(), r1, r6));     // Catch: Throwable -> L11
    L13:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L16;
        g("convert advanced voice rich text", r8);
    L16:
        Object r9 = r1;
        if (Result.isFailure-impl(r7) == true) goto L21;
        r9 = r7;
    L21:
        return (CharSequence) r9;
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L5:
        r1 = r0;
        goto L6
    }

    public final void q(a r8) {
        if (r8.q == false) goto L33;
        r8.k.detach();
        ViewGroup r0 = r8.c;
        b r2 = r8.v;
        View r3 = r2.a;
        if (r3 == null) goto L11;
        Integer r4 = r2.b;
        if (r4 == null) goto L9;
        int r5 = r4.intValue();
    L10:
        r3.setVisibility(r5);
        goto L11
    L9:
        r5 = r3.getVisibility();
    L11:
        Function0<View> r6 = this.a.k;
        if (r6 == null) goto L14;
        View r7 = (View) r6.invoke();
    L15:
        ConstraintLayout.LayoutParams r9 = r2.c;
        if (r9 == null) goto L20;
        if (r7 == null) goto L20;
        r7.setLayoutParams(new ConstraintLayout.LayoutParams(r9));
    L20:
        if ((r0 instanceof ConstraintLayout) == false) goto L25;
        View r10 = r0.findViewById(2131369298);
        ConstraintLayout.LayoutParams r11 = r2.d;
        if (r11 == null) goto L25;
        if (r10 == null) goto L25;
        r10.setLayoutParams(new ConstraintLayout.LayoutParams(r11));
    L25:
        r2.e.c(null, null);
        r2.f.c(null, null);
        r2.g.c(null, null);
        r2.a = null;
        r2.b = null;
        r2.c = null;
        r2.d = null;
        r0.requestLayout();
        if (r8.o == true) goto L28;
    L31:
        r8.q = false;
        this.b.invoke();
        return;
    L28:
        if (r8.p == true) goto L31;
        r8.p = true;
        this.a.c.a.L();
        goto L31
    L14:
        r7 = null;
        goto L15
    L33:
        if (r8.o == true) goto L35;
        return;
    L35:
        if (r8.p == true) goto L41;
        r8.p = true;
        this.a.c.a.L();
        return;
    }

    public final void r(a r14) {
        if (this.h == r14) goto L5;
        return;
    L5:
        if (r14.q == true) goto L151;
        ebc.b r0 = r14.k;
        ViewGroup r1 = r14.c;
        View r2 = n();
        ConstraintLayout.LayoutParams r7 = null;
        if ((r1 instanceof ConstraintLayout) == false) goto L27;
        if (r2 == null) goto L21;
        Integer r3 = Integer.valueOf(r2.getId());
        int r10 = r3.intValue();
        if (this.a.n == true) goto L18;
        if (r10 == (-1)) goto L18;
        if (r2.getParent() != r1) goto L18;
        if (r2.getVisibility() == 8) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L21;
    L22:
        if (r3 == null) goto L24;
        int r5 = r3.intValue();
    L25:
        ConstraintLayout.LayoutParams r6 = new ConstraintLayout.LayoutParams(0, -2);
        r6.startToStart = r5;
        r6.endToEnd = r5;
        r6.bottomToBottom = r5;
        ((ViewGroup.MarginLayoutParams) r6).bottomMargin = this.a.z;
    L30:
        r0.A(r1, r6);
        r14.q = true;
        int r8 = r0.a.getViewId();
        ConstraintLayout r9 = r14.c;
        b r15 = r14.v;
        View r11 = n();
        if (r11 == null) goto L49;
        Function0<View> r12 = this.a.k;
        if (r12 == null) goto L36;
        View r13 = (View) r12.invoke();
    L37:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r16 = this.a;
        if (r16.n == true) goto L50;
        Function0<View> r17 = r16.m;
        if (r17 == null) goto L42;
        View r18 = (View) r17.invoke();
    L43:
        if (r18 == null) goto L45;
        boolean r19 = true;
    L46:
        if (r19 == false) goto L50;
        if (r11 != r13) goto L49;
    L45:
        r19 = false;
        goto L46
    L42:
        r18 = null;
    L50:
        boolean r20 = true;
    L52:
        if (r20 == false) goto L56;
        if (r11 == null) goto L72;
        r15.a = r11;
        r15.b = Integer.valueOf(r11.getVisibility());
        r11.setVisibility(4);
    L72:
        Function0<List<View>> r21 = this.a.t;
        if (r21 == null) goto L92;
        List r22 = (List) r21.invoke();
        if (r22 == null) goto L92;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r22.iterator();
    L78:
        if (r24.hasNext() == false) goto L88;
        Object r110 = r24.next();
        View r111 = (View) r110;
        Function0<View> r112 = this.a.k;
        if (r112 == null) goto L82;
        View r113 = (View) r112.invoke();
    L83:
        if (r111 == r113) goto L85;
        boolean r114 = true;
    L86:
        if (r114 == false) goto L78;
        r23.add(r110);
        goto L78
    L85:
        r114 = false;
        goto L86
    L82:
        r113 = null;
        goto L83
    L88:
        Iterator r25 = r23.iterator();
    L90:
        if (r25.hasNext() == false) goto L92;
        r15.e.d((View) r25.next(), 8);
    L92:
        Function0<List<View>> r26 = this.a.u;
        if (r26 == null) goto L100;
        List r27 = (List) r26.invoke();
        if (r27 == null) goto L100;
        Iterator r28 = r27.iterator();
    L98:
        if (r28.hasNext() == false) goto L100;
        r15.f.d((View) r28.next(), 4);
    L100:
        Function0<List<View>> r29 = this.a.v;
        if (r29 == null) goto L121;
        List r30 = (List) r29.invoke();
        if (r30 == null) goto L121;
        ArrayList r31 = new ArrayList();
        Iterator r32 = r30.iterator();
    L106:
        if (r32.hasNext() == false) goto L116;
        Object r33 = r32.next();
        View r34 = (View) r33;
        Function0<View> r115 = this.a.l;
        if (r115 == null) goto L110;
        View r116 = (View) r115.invoke();
    L111:
        if (r34 == r116) goto L113;
        boolean r35 = true;
    L114:
        if (r35 == false) goto L106;
        r31.add(r33);
        goto L106
    L113:
        r35 = false;
        goto L114
    L110:
        r116 = null;
        goto L111
    L116:
        Iterator r36 = r31.iterator();
    L118:
        if (r36.hasNext() == false) goto L121;
        r15.g.d((View) r36.next(), 0);
    L121:
        if ((r9 instanceof ConstraintLayout) == false) goto L135;
        View r37 = r9.findViewById(2131369298);
        if (r37 == null) goto L125;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
    L127:
        if ((r38 instanceof ConstraintLayout.LayoutParams) == false) goto L129;
        r7 = (ConstraintLayout.LayoutParams) r38;
    L129:
        if (r37 == null) goto L135;
        if (r7 == null) goto L135;
        r15.d = new ConstraintLayout.LayoutParams(r7);
        ConstraintLayout.LayoutParams r117 = new ConstraintLayout.LayoutParams(r7);
        r117.bottomToTop = r8;
        r117.bottomToBottom = -1;
        Integer r39 = this.a.y;
        if (r39 == null) goto L134;
        ((ViewGroup.MarginLayoutParams) r117).bottomMargin = r39.intValue();
    L134:
        r37.setLayoutParams(r117);
        goto L135
    L125:
        r38 = null;
    L135:
        r9.requestLayout();
        return;
    L56:
        if ((r9 instanceof ConstraintLayout) == false) goto L72;
        ConstraintLayout r40 = r9;
        Function0<View> r41 = this.a.k;
        if (r41 == null) goto L72;
        View r42 = (View) r41.invoke();
        if (r42 == null) goto L72;
        if (r42.getParent() != r40) goto L72;
        ConstraintLayout.LayoutParams r43 = r42.getLayoutParams();
        if ((r43 instanceof ConstraintLayout.LayoutParams) == false) goto L68;
        ConstraintLayout.LayoutParams r44 = r43;
    L69:
        if (r44 == null) goto L72;
        r15.c = new ConstraintLayout.LayoutParams(r44);
        ConstraintLayout.LayoutParams r118 = new ConstraintLayout.LayoutParams(r44);
        r118.bottomToTop = r8;
        r118.bottomToBottom = -1;
        r42.setLayoutParams(r118);
        goto L72
    L68:
        r44 = null;
        goto L69
    L36:
        r13 = null;
    L49:
        r20 = false;
        goto L52
    L24:
        r5 = 0;
    L18:
        r4 = false;
    L21:
        r3 = null;
        goto L22
    L27:
        if ((r1 instanceof FrameLayout) == false) goto L29;
        r6 = new FrameLayout.LayoutParams(-1, -2, 80);
        ((FrameLayout.LayoutParams) r6).bottomMargin = this.a.z;
        goto L30
    L29:
        r6 = new ViewGroup.LayoutParams(-1, -2);
        goto L30
    }

    public CommentUnifiedVoiceComponentAdvancedAdapter(com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r6, Function0 r7) {
        CommentUnifiedVoiceComponentToastFeedback r0 = new CommentUnifiedVoiceComponentToastFeedback(r6.a);
        AnonymousClass1 r1 = AnonymousClass1.INSTANCE;
        s r2 = s.a;
        AnonymousClass2 r3 = AnonymousClass2.INSTANCE;
        Intrinsics.checkNotNullParameter(r6, "ctx");
        Intrinsics.checkNotNullParameter(r7, "onAdvancedDismiss");
        Intrinsics.checkNotNullParameter(r0, "feedback");
        Intrinsics.checkNotNullParameter(r1, "coordinatorProvider");
        Intrinsics.checkNotNullParameter(r2, "providerFactory");
        Intrinsics.checkNotNullParameter(r3, "traceIdFactory");
        this.a = r6;
        this.b = r7;
        this.c = r0;
        this.d = r1;
        this.e = r2;
        this.f = r3;
    }

    public static void m(a r1, MotionEvent r2) {
        MotionEvent r0 = r1.l;
        if (r0 == null) goto L5;
        r0.recycle();
    L5:
        r1.l = MotionEvent.obtain(r2);
    }

    public final boolean d(a r4, MotionEvent r5) {
        return r4.f.f(r4.b, r5, CommentUnifiedVoiceComponentAdvancedAdapter$dispatch$1.INSTANCE);
    L4:
        th = move-exception;
        g("dispatch advanced voice touch", th);
        if (this.h != r4) goto L8;
        e(r4, AdvancedVoiceFinishReason.FAILURE);
    L8:
        return false;
    }

    public final void e(a r8, AdvancedVoiceFinishReason r9) {
        if (this.h == r8) goto L5;
        return;
    L5:
        Integer r0 = null;
        this.h = null;
        MotionEvent r1 = r8.l;
        r8.l = null;
        r8.i.a();     // Catch: Throwable -> L8
        th = null;
    L95:
        q(r8);     // Catch: Throwable -> L11
    L17:
        if (r1 != null) goto L94;
    L19:
        Intrinsics.checkNotNullParameter(r9, "reason");     // Catch: Throwable -> L35
        if (r9.getShouldCancelActiveGesture() == false) goto L27;
        if (r0 == null) goto L27;
        boolean r6 = true;
        if (r0.intValue() == 1) goto L27;
        if (r0.intValue() == 3) goto L27;
    L28:
        if (r6 == false) goto L92;
        MotionEvent r2 = MotionEvent.obtain(r1);     // Catch: Throwable -> L35
        r2.setAction(3);     // Catch: Throwable -> L35
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.d r4 = r8.f;     // Catch: Throwable -> L32
        View r5 = r8.b;     // Catch: Throwable -> L32
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L32
        r4.f(r5, r2, CommentUnifiedVoiceComponentAdvancedAdapter$finish$3$1.INSTANCE);     // Catch: Throwable -> L32
        r2.recycle();     // Catch: Throwable -> L35
        goto L92
    L32:
        th = move-exception;
        r2.recycle();     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        if (th != null) goto L38;
        th = th;
        goto L92
    L38:
        if (th == th) goto L92;
        ExceptionsKt.addSuppressed(th, th);
    L92:
        b(r8);     // Catch: Throwable -> L42
    L99:
    L51:
        th = move-exception;
        if (th != null) goto L54;
        th = th;
    L97:
        r8.f.onDestroy();     // Catch: Throwable -> L58
    L84:
        r8.g.removeObserver(r8.h);     // Catch: Throwable -> L65
    L86:
        r8.d.release(r8.e);     // Catch: Throwable -> L72
    L77:
        if (r1 == null) goto L80;
        r1.recycle();
    L80:
        if (th == null) goto L82;
        g("cleanup advanced voice session=" + r8.a + ", reason=" + r9, th);
    L82:
        StringBuilder r3 = new StringBuilder("[advanced] finish session=");
        r3.append(r8.a);
        r3.append(", reason=");
        r3.append(r9);
        r3.append(", phase=");
        r3.append(r8.j);
        r3.append(", bridgeStarted=");
        r3.append(r8.o);
        r3.append(", hasVoiceText=");
        r3.append(r8.r);
        r3.append(", ");
        CommentVoiceLog r10 = CommentVoiceLog.a;
        String r11 = r8.m;
        r10.getClass();
        r3.append(CommentVoiceLog.d("taskId", r11));
        tt5.a.h("CommentVoice", r3.toString());
        return;
    L72:
        th = move-exception;
        if (th != null) goto L75;
        th = th;
        goto L77
    L75:
        if (th == th) goto L77;
        ExceptionsKt.addSuppressed(th, th);
    L65:
        th = move-exception;
        if (th != null) goto L68;
        th = th;
        goto L86
    L68:
        if (th == th) goto L86;
        ExceptionsKt.addSuppressed(th, th);
    L58:
        th = move-exception;
        if (th != null) goto L61;
        th = th;
        goto L84
    L61:
        if (th == th) goto L84;
        ExceptionsKt.addSuppressed(th, th);
        goto L84
    L54:
        if (th == th) goto L97;
        ExceptionsKt.addSuppressed(th, th);
        goto L97
    L48:
        if (r8.o == false) goto L97;
        CommentVoiceEditTextBridge r7 = this.a.c;     // Catch: Throwable -> L51
        r7.b = false;     // Catch: Throwable -> L51
        r7.c = 0;     // Catch: Throwable -> L51
        r7.d = 0;     // Catch: Throwable -> L51
        r7.e = 0;     // Catch: Throwable -> L51
        r7.f = false;     // Catch: Throwable -> L51
        r7.g = "";     // Catch: Throwable -> L51
        ((LinkedHashMap) r7.h).clear();     // Catch: Throwable -> L51
    L42:
        th = move-exception;
        if (th != null) goto L45;
        th = th;
        goto L99
    L45:
        if (th == th) goto L99;
        ExceptionsKt.addSuppressed(th, th);
    L27:
        r6 = false;
        goto L28
    L94:
        r0 = Integer.valueOf(r1.getActionMasked());     // Catch: Throwable -> L35
    L11:
        th = move-exception;
        if (th != null) goto L14;
        th = th;
        goto L17
    L14:
        if (th == th) goto L17;
        ExceptionsKt.addSuppressed(th, th);
    L8:
        th = th;
        goto L95
    }

    public final void f(a r3, AdvancedVoiceFinishReason r4) {
        MotionEvent r0 = r3.l;
        if (r0 == null) goto L5;
        Integer r1 = Integer.valueOf(r0.getActionMasked());
    L6:
        if (r1 != null) goto L9;
    L10:
        if (r1 != null) goto L13;
    L15:
        e(r3, r4);
        return;
    L13:
        if (r1.intValue() != 2) goto L15;
    L17:
        r3.t = r4;
        r3.u = true;
        return;
    L9:
        if (r1.intValue() == 0) goto L17;
    L5:
        r1 = null;
        goto L6
    }

    public final void g(String r4, Throwable r5) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        tt5.a.e("CommentVoice", "[advanced] " + r4, r5, false);     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final boolean k(View r35, MotionEvent r36) {
        Intrinsics.checkNotNullParameter(r35, "view");
        Intrinsics.checkNotNullParameter(r36, "event");
        int r2 = r36.getActionMasked();
        if (r2 == 0) goto L28;
        if (r2 != 1) goto L6;
        boolean r15 = j(r36);     // Catch: Throwable -> L25
        s();
        return r15;
    L25:
        th = move-exception;
        s();
        throw th;
    L6:
        if (r2 != 2) goto L8;
        a r3 = this.h;
        if (r3 == null) goto L11;
        m(r3, r36);
        d(r3, r36);
    L13:
        return true;
    L11:
        return false;
    L8:
        if (r2 == 3) goto L184;
        a r4 = this.h;
        if (r4 == null) goto L11;
        m(r4, r36);
        d(r4, r36);
        goto L13
    L184:
        boolean r16 = i(r36);     // Catch: Throwable -> L16
        s();
        return r16;
    L16:
        th = move-exception;
        s();
        throw th;
    L28:
        a r5 = this.h;
        if (r5 == null) goto L32;
        e(r5, AdvancedVoiceFinishReason.REPLACED);
    L32:
        if (this.i == true) goto L37;
        this.i = true;
        Function1<Boolean, Unit> r6 = this.a.F;
        if (r6 == null) goto L37;
        r6.invoke(Boolean.TRUE);
    L37:
        LifecycleOwner r7 = this.a.b;
        if (r7 != null) goto L40;
        tt5.a.k("CommentVoice", "[advanced] action down aborted: host fragment is missing");
    L159:
        boolean r17 = false;
    L160:
        if (r17 == true) goto L202;
        s();
        return r17;
    L202:
        return r17;
    L40:
        View r8 = n();
        Unit r25 = null;
        if (r8 == null) goto L43;
        ViewParent r9 = r8.getParent();
    L45:
        if ((r9 instanceof ViewGroup) == false) goto L47;
        ViewGroup r10 = (ViewGroup) r9;
    L48:
        if (r10 != null) goto L53;
        Function0<ViewGroup> r11 = this.a.d;
        if (r11 == null) goto L52;
        r10 = (ViewGroup) r11.invoke();
        goto L53
    L52:
        ViewGroup r12 = null;
    L54:
        if (r12 != null) goto L186;
        tt5.a.k("CommentVoice", "[advanced] action down aborted: attach parent is missing");
        goto L159
    L186:
        CommentUnifiedVoiceComponentSessionCoordinator r13 = (CommentUnifiedVoiceComponentSessionCoordinator) this.d.invoke(r7);     // Catch: Throwable -> L157
        CommentUnifiedVoiceComponentSessionCoordinator.c r14 = r13.acquire(this);     // Catch: Throwable -> L155
        if (r14.b.isCurrent(r14) == true) goto L61;
        r13.release(r14);
        tt5.a.k("CommentVoice", "[advanced] action down aborted: lease=" + r14.a + " was superseded");
        goto L159
    L61:
        final long r18 = this.g + 1;
        this.g = r18;
        LifecycleOwner r19 = (LifecycleOwner) r7.getViewLifecycleOwnerLiveData().getValue();     // Catch: Throwable -> L126
        if (r19 != null) goto L65;
        r19 = r7;
    L65:
        Lifecycle r110 = r19.getLifecycle();     // Catch: Throwable -> L126
    L122:
        th = th;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.a r31 = null;
    L124:
        r r20 = null;
        LifecycleObserver r21 = null;
        ebc.b r22 = null;
    L125:
        Lifecycle r111 = r110;
    L128:
        g("prepare advanced voice failed", th);
        if (r21 == null) goto L169;
        if (r111 == null) goto L169;
        r111.removeObserver(r21);
    L169:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L138
        if (r20 == null) goto L135;
        r20.onDestroy();     // Catch: Throwable -> L138
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L138
    L136:
        Object r23 = Result.constructor-impl(r1);     // Catch: Throwable -> L138
    L140:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L143;
        g("destroy advanced provider after prepare failure", r24);
    L143:
        if (r22 != null) goto L173;
    L145:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L147
    L149:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L152;
        g("detach advanced voice view after prepare failure", r27);
    L152:
        if (r31 == null) goto L154;
        r31.a();
    L154:
        r13.release(r14);
    L147:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L149
    L173:
        r22.detach();     // Catch: Throwable -> L147
        r25 = Unit.INSTANCE;     // Catch: Throwable -> L147
        goto L145
    L135:
        r1 = null;
    L138:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L140
    L67:
        if (r110.getCurrentState() != Lifecycle.State.DESTROYED) goto L69;
        r13.release(r14);     // Catch: Throwable -> L122
        tt5.a.k("CommentVoice", "[advanced] action down aborted: lifecycle destroyed, lease=" + r14.a);     // Catch: Throwable -> L122
        goto L159
    L69:
        r31 = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.a(r35.getParent());     // Catch: Throwable -> L122
        LifecycleObserver r30 = new CommentUnifiedVoiceComponentAdvancedAdapter$onActionDown$lifecycleObserver$1(this, r18);     // Catch: Throwable -> L120
        r110.addObserver(r30);     // Catch: Throwable -> L115
        LifecycleObserver r210 = r30;
        r110 = r110;
        ebc.b r32 = new ebc.b(r12.getContext(), p(), r12.getContext().getString(2131890970));     // Catch: Throwable -> L110
        String r112 = (String) this.f.invoke();     // Catch: Throwable -> L107
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.c r33 = this.e;     // Catch: Throwable -> L107
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r113 = this.a;     // Catch: Throwable -> L107
        String r114 = r113.e;     // Catch: Throwable -> L107
        String r34 = r113.g;     // Catch: Throwable -> L107
        String r115 = r113.h;     // Catch: Throwable -> L107
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L107
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L79;
        VoiceAsrMode r116 = VoiceAsrMode.FinalOnly;     // Catch: Throwable -> L107
    L80:
        r31 = r31;
        r13 = r13;
        r r37 = r33.a(new e(r7, r114, r34, r115, r112, r116, r32, new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.b(new CommentUnifiedVoiceComponentAdvancedAdapter$onActionDown$provider$1(this, r18), new CommentUnifiedVoiceComponentAdvancedAdapter$onActionDown$provider$2(this, r18), new CommentUnifiedVoiceComponentAdvancedAdapter$onActionDown$provider$3(this, r18))));     // Catch: Throwable -> L100
        ebc.b r117 = r32;
        r110 = r110;
        r14 = r14;
        a r38 = new a(r18, r35, r12, r13, r14, r37, r110, r210, r31, r117);     // Catch: Throwable -> L95
        this.h = r38;     // Catch: Throwable -> L95
        StringBuilder r39 = new StringBuilder("[advanced] prepare session=");     // Catch: Throwable -> L95
        r39.append(r38.a);     // Catch: Throwable -> L95
        r39.append(", lease=");     // Catch: Throwable -> L95
        r39.append(r14.a);     // Catch: Throwable -> L95
        r39.append(", ");     // Catch: Throwable -> L95
        CommentVoiceLog.a.getClass();     // Catch: Throwable -> L95
        r39.append(CommentVoiceLog.d("traceId", r112));     // Catch: Throwable -> L95
        r39.append(", ");     // Catch: Throwable -> L95
        r39.append(CommentVoiceLog.d("fileId", this.a.g));     // Catch: Throwable -> L95
        tt5.a.h("CommentVoice", r39.toString());     // Catch: Throwable -> L95
        m(r38, r36);     // Catch: Throwable -> L95
        boolean r40 = d(r38, r36);     // Catch: Throwable -> L95
        if (r40 == false) goto L92;
    L94:
        r17 = r40;
        goto L160
    L92:
        if (this.h != r38) goto L94;
        e(r38, AdvancedVoiceFinishReason.FAILURE);     // Catch: Throwable -> L95
    L95:
        th = th;
    L99:
        r22 = r117;
        r20 = r37;
    L119:
        r21 = r210;
    L97:
        th = th;
        r117 = r32;
        r110 = r110;
        r14 = r14;
    L100:
        th = th;
    L102:
        r14 = r14;
    L109:
        r22 = r32;
        r20 = null;
    L103:
        th = th;
        r13 = r13;
    L105:
        th = th;
        r32 = r32;
        r14 = r14;
        r13 = r13;
        goto L109
    L79:
        r116 = VoiceAsrMode.Streaming;     // Catch: Throwable -> L107
    L107:
        th = th;
        r32 = r32;
        r13 = r13;
        r31 = r31;
        r14 = r14;
    L110:
        th = th;
        r110 = r110;
    L112:
        r14 = r14;
        r20 = null;
        r22 = null;
    L113:
        th = th;
    L117:
        r110 = r110;
    L115:
        th = th;
        r210 = r30;
    L120:
        th = th;
        r31 = r31;
    L126:
        th = th;
        r14 = r14;
        r13 = r13;
        r20 = null;
        r21 = null;
        r22 = null;
        r111 = null;
        r31 = null;
    L155:
        th = move-exception;
        g("acquire advanced voice session", th);
    L157:
        th = move-exception;
        g("get advanced voice coordinator", th);
    L53:
        r12 = r10;
        goto L54
    L47:
        r10 = null;
        goto L48
    L43:
        r9 = null;
        goto L45
    }

    public final void t(a r8, CharSequence r9, boolean r10) {
        int r2 = CommentVoiceEditTextBridge.i;
        CommentVoiceEditTextBridge.d r0 = this.a.c.i(r9, !r10, null);
        if (r0.a == true) goto L7;
        StringBuilder r1 = new StringBuilder("[advanced] write voice text failed, session=");
        r1.append(r8.a);
        r1.append(", isFinal=");
        r1.append(r10);
        r1.append(", ");
        CommentVoiceLog.a.getClass();
        r1.append(CommentVoiceLog.i("text", r9));
        tt5.a.k("CommentVoice", r1.toString());
        return;
    L7:
        if (r8.r == false) goto L9;
    L12:
        boolean r3 = true;
    L13:
        r8.r = r3;
        if (r0.b == false) goto L21;
        if (r10 == false) goto L17;
    L18:
        Function0<Unit> r4 = this.a.D;
        if (r4 == null) goto L21;
        r4.invoke();
        goto L21
    L17:
        if (r0.d == true) goto L18;
    L21:
        if (r10 == false) goto L24;
        StringBuilder r11 = new StringBuilder("[advanced] write final text, session=");
        r11.append(r8.a);
        r11.append(", wroteNonEmpty=");
        r11.append(r0.c);
        r11.append(", mentionChanged=");
        r11.append(r0.b);
        r11.append(", ");
        CommentVoiceLog.a.getClass();
        r11.append(CommentVoiceLog.i("text", r9));
        tt5.a.h("CommentVoice", r11.toString());
        return;
    L24:
        return;
    L9:
        if (r0.c == true) goto L12;
        r3 = false;
        goto L13
    }
}
