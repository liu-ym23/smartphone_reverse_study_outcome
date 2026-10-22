package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.app.Activity;
import android.app.Application;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark.CommentVoiceInputResultConsumer;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.VoiceInputSpeechScene;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputView;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.a0;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.s;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.x;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentImmersiveVoiceTouchDelegate {
    public static final /* synthetic */ int w = 0;
    public final Activity a;
    public final Fragment b;
    public final boolean c;
    public final VoiceInputScene d;
    public final String e;
    public final String f;
    public final String g;
    public final VoiceInputSpeechScene h;
    public ImmersiveVoiceInputView i;
    public ImmersiveVoiceInputComponent.b j;
    public boolean k;
    public View l;
    public Function0<? extends ViewGroup> m;
    public s n;
    public Function2<? super List<String>, ? super Function1<? super Map<String, Boolean>, Unit>, Unit> o;
    public Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> p;
    public Function1<? super Boolean, Unit> q;
    public boolean r;
    public final Map<String, String> s;
    public String t;
    public final c u;
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.a v;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate$a$a, reason: collision with other inner class name */
        public static final class RunnableC0047a implements Runnable {
            public final /* synthetic */ ViewGroup a;
            public final /* synthetic */ ViewGroup b;

            public RunnableC0047a(ViewGroup r1, ViewGroup r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.setElevation(UIUtils.dp2px(this.b.getContext(), 16.0f));     // Catch: Throwable -> L9
                this.a.bringToFront();     // Catch: Throwable -> L9
                ViewParent r0 = this.a.getParent();     // Catch: Throwable -> L9
                if ((r0 instanceof ViewGroup) == false) goto L5;
                ViewGroup r1 = (ViewGroup) r0;     // Catch: Throwable -> L9
            L6:
                if (r1 == null) goto L12;
                r1.requestLayout();     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L5:
                r1 = null;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public static void a(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b r1, Function0 r2) {
            Intrinsics.checkNotNullParameter(r1, "popupWindow");
            Intrinsics.checkNotNullParameter(r2, "popupContainerProvider");
            AudioPopupWindowImpl.b r3 = r1.s7();
            r3.setClickable(true);
            ViewGroup r4 = (ViewGroup) r2.invoke();
            if (r4 != null) goto L5;
            return;
        L5:
            r4.post(new RunnableC0047a(r3, r4));
        }
    }

    static {
    }

    public final void a() {
        ImmersiveVoiceInputComponent.b r0 = this.j;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.j = null;
        View r1 = this.l;
        if (r1 == null) goto L15;
        ImmersiveVoiceInputView r2 = this.i;
        if (r2 == null) goto L15;
        long r5 = SystemClock.uptimeMillis();
        MotionEvent r3 = MotionEvent.obtain(r5, r5, 3, 0.0f, 0.0f, 0);
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L12
        r2.d(r1, r3);     // Catch: Throwable -> L12
        r3.recycle();
    L12:
        th = move-exception;
        r3.recycle();
        throw th;
    L15:
        ImmersiveVoiceInputView r4 = this.i;
        if (r4 == null) goto L19;
        r4.b(false, null, null);
    L19:
        if (this.r == false) goto L22;
        this.r = false;
        this.q.invoke(Boolean.FALSE);
    L22:
        this.k = false;
        this.l = null;
        this.m = CommentImmersiveVoiceTouchDelegate$dismissPopup$2.INSTANCE;
        this.n = null;
        this.o = null;
        this.q = CommentImmersiveVoiceTouchDelegate$dismissPopup$3.INSTANCE;
    }

    public final void d() {
        this.s.put("source_type", "ccm_comment");
        this.s.put("file_id", this.f);
        this.s.put("file_type", this.g);
        this.s.put("location", this.t);
    }

    public static /* synthetic */ void c(CommentImmersiveVoiceTouchDelegate r9, View r10, MotionEvent r11, final Function0 r12, CommentVoiceInputResultConsumer r13, Function1 r14, Function2 r15) {
        r9.b(r10, r11, r12, r13, "input_bottom_button", new CommentImmersiveVoiceTouchDelegate$handleTouch$1(r12), r14, r15);
    }

    public CommentImmersiveVoiceTouchDelegate(Activity r1, Fragment r2, boolean r3, VoiceInputScene r4, String r5, String r6, String r7, VoiceInputSpeechScene r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.m = CommentImmersiveVoiceTouchDelegate$popupContainerProvider$1.INSTANCE;
        this.p = new CommentImmersiveVoiceTouchDelegate$onPopupShown$1(this);
        this.q = CommentImmersiveVoiceTouchDelegate$onVoiceRecordingStateChanged$1.INSTANCE;
        CommentVoiceExtraAnalyticParams r9 = CommentVoiceExtraAnalyticParams.a;
        this.s = CommentVoiceExtraAnalyticParams.a(r2);
        this.t = "input_bottom_button";
        this.u = new c();
        this.v = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.a(this);
    }

    public final void b(View r29, MotionEvent r30, Function0 r31, CommentVoiceInputResultConsumer r32, String r33, Function1 r34, Function1 r35, Function2 r36) {
        Intrinsics.checkNotNullParameter(r29, "view");
        Intrinsics.checkNotNullParameter(r30, "event");
        Intrinsics.checkNotNullParameter(r31, "popupContainerProvider");
        Intrinsics.checkNotNullParameter(r32, "resultConsumer");
        Intrinsics.checkNotNullParameter(r33, "voiceInputLocation");
        Intrinsics.checkNotNullParameter(r34, "onPopupShown");
        Intrinsics.checkNotNullParameter(r35, "onVoiceRecordingStateChanged");
        this.t = r33;
        d();
        this.m = r31;
        this.n = r32;
        this.p = r34;
        this.q = r35;
        this.o = r36;
        d();
        final ImmersiveVoiceInputView r3 = this.i;
        if (r3 == null) goto L6;
    L9:
        if (r3 == null) goto L41;
        this.l = r29;
        int r6 = r30.getAction() & 255;
        if (r6 != 0) goto L14;
        r29.setPressed(true);
        ImmersiveVoiceInputComponent.b r4 = this.j;
        if (r4 == null) goto L38;
        r4.a();
    L38:
        ImmersiveVoiceInputComponent.b r5 = new ImmersiveVoiceInputComponent.b(r29, new CommentImmersiveVoiceTouchDelegate$handleTouch$3(r3, this));
        this.j = r5;
        r5.c(r30);
        return;
    L14:
        if (r6 == 1) goto L28;
        if (r6 != 2) goto L17;
        ImmersiveVoiceInputComponent.b r7 = this.j;
        if (r7 == null) goto L34;
        r7.b(r30);
    L34:
        r3.d(r29, r30);
        return;
    L17:
        if (r6 != 3) goto L34;
        r29.setPressed(false);
        ImmersiveVoiceInputComponent.b r8 = this.j;
        if (r8 == null) goto L22;
        r8.a();
    L22:
        this.j = null;
        if (this.k == true) goto L34;
        this.l = null;
        goto L34
    L28:
        r29.setPressed(false);
        ImmersiveVoiceInputComponent.b r9 = this.j;
        if (r9 == null) goto L31;
        r9.d(r30);
    L31:
        this.j = null;
        if (this.k == true) goto L34;
        this.l = null;
        goto L34
    L41:
        return;
    L6:
        if (((ViewGroup) this.m.invoke()) != null) goto L8;
        tt5.a.k("CommentImmersiveVoiceTouchDelegate", "ensureImmersiveVoiceInputView aborted: popupContainer is null");
        r3 = null;
        goto L9
    L8:
        Application r10 = com.larksuite.framework.utils.b.a;
        Intrinsics.checkNotNull(r10);
        IAudioService r11 = (IAudioService) e0c.k.a(r10, IAudioService.class);
        com.ss.android.lark.audio.voiceinput.service.l r12 = (com.ss.android.lark.audio.voiceinput.service.l) e0c.k.a(r10, com.ss.android.lark.audio.voiceinput.service.l.class);
        com.ss.android.lark.audio.voiceinput.service.o r13 = (com.ss.android.lark.audio.voiceinput.service.o) e0c.k.a(r10, com.ss.android.lark.audio.voiceinput.service.o.class);
        Activity r14 = this.a;
        Fragment r15 = this.b;
        r r16 = k.a;
        k.a("CommentImmersiveVoiceTouchDelegate", new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$dependency$1(this), new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$dependency$2(this), new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$dependency$3(this));
        x r17 = new x(r11, r12, r13, r14, r15);
        boolean r18 = this.c;
        String r19 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        com.ss.android.lark.audio.voiceinput.p r20 = new com.ss.android.lark.audio.voiceinput.p(VoiceInputMode.OnlyAsr, this.d);
        String r21 = this.e;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.a r22 = this.v;
        a0 r110 = new a0(2);
        Map<String, String> r111 = this.s;
        r3 = new ImmersiveVoiceInputView(this.a, r17, new w(r18, r19, r20, r21, r22, new b(this), r111, new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$voiceConfig$2(this), this.h, r110, KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.a, "im.messenger.voice_input_markdown"), 24512), this.u);
        r3.e();
        r3.f(new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$3$1(this), CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$3$2.INSTANCE);
        this.i = r3;
        goto L9
    }
}
