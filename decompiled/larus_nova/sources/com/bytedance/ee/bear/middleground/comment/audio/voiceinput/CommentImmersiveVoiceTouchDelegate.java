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

/* JADX INFO: loaded from: classes18.dex */
public final class CommentImmersiveVoiceTouchDelegate {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f230344w = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f230345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f230346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f230347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VoiceInputScene f230348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f230349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f230350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f230351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VoiceInputSpeechScene f230352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImmersiveVoiceInputView f230353i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImmersiveVoiceInputComponent.b f230354j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f230355k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f230356l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<? extends ViewGroup> f230357m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public s f230358n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function2<? super List<String>, ? super Function1<? super Map<String, Boolean>, Unit>, Unit> f230359o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b, Unit> f230360p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f230361q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f230362r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f230363s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f230364t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f230365u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.a f230366v;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentImmersiveVoiceTouchDelegate$a$a, reason: collision with other inner class name */
        public static final class RunnableC3294a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f230367a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f230368b;

            public RunnableC3294a(ViewGroup r100, ViewGroup r101) {
                this.f230367a = r100;
                this.f230368b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f230367a.setElevation(UIUtils.dp2px(this.f230368b.getContext(), 16.0f));     // Catch: Throwable -> L9
                this.f230367a.bringToFront();     // Catch: Throwable -> L9
                ViewParent r100 = this.f230367a.getParent();     // Catch: Throwable -> L9
                if ((r100 instanceof ViewGroup) == false) goto L5;
                ViewGroup r101 = (ViewGroup) r100;     // Catch: Throwable -> L9
            L6:
                if (r101 == null) goto L12;
                r101.requestLayout();     // Catch: Throwable -> L9
                return;
            L12:
                return;
            L5:
                r101 = null;
            L9:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L16;
                throw th;
            }
        }

        public static void a(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b r100, Function0 r101) {
            Intrinsics.checkNotNullParameter(r100, "popupWindow");
            Intrinsics.checkNotNullParameter(r101, "popupContainerProvider");
            AudioPopupWindowImpl.b r102 = r100.s7();
            r102.setClickable(true);
            ViewGroup r103 = (ViewGroup) r101.invoke();
            if (r103 != null) goto L5;
            return;
        L5:
            r103.post(new RunnableC3294a(r102, r103));
        }
    }

    static {
    }

    public final void a() {
        ImmersiveVoiceInputComponent.b r100 = this.f230354j;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f230354j = null;
        View r101 = this.f230356l;
        if (r101 == null) goto L15;
        ImmersiveVoiceInputView r102 = this.f230353i;
        if (r102 == null) goto L15;
        long r103 = SystemClock.uptimeMillis();
        MotionEvent r104 = MotionEvent.obtain(r103, r103, 3, 0.0f, 0.0f, 0);
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L12
        r102.d(r101, r104);     // Catch: Throwable -> L12
        r104.recycle();
    L12:
        th = move-exception;
        r104.recycle();
        throw th;
    L15:
        ImmersiveVoiceInputView r105 = this.f230353i;
        if (r105 == null) goto L19;
        r105.b(false, null, null);
    L19:
        if (this.f230362r == false) goto L22;
        this.f230362r = false;
        this.f230361q.invoke(Boolean.FALSE);
    L22:
        this.f230355k = false;
        this.f230356l = null;
        this.f230357m = CommentImmersiveVoiceTouchDelegate$dismissPopup$2.INSTANCE;
        this.f230358n = null;
        this.f230359o = null;
        this.f230361q = CommentImmersiveVoiceTouchDelegate$dismissPopup$3.INSTANCE;
    }

    public final void d() {
        this.f230363s.put("source_type", "ccm_comment");
        this.f230363s.put("file_id", this.f230350f);
        this.f230363s.put("file_type", this.f230351g);
        this.f230363s.put("location", this.f230364t);
    }

    public static /* synthetic */ void c(CommentImmersiveVoiceTouchDelegate r100, View r110, MotionEvent r111, final Function0 r112, CommentVoiceInputResultConsumer r113, Function1 r114, Function2 r115) {
        r100.b(r110, r111, r112, r113, "input_bottom_button", new CommentImmersiveVoiceTouchDelegate$handleTouch$1(r112), r114, r115);
    }

    public CommentImmersiveVoiceTouchDelegate(Activity r100, Fragment r101, boolean r102, VoiceInputScene r103, String r104, String r105, String r106, VoiceInputSpeechScene r107) {
        this.f230345a = r100;
        this.f230346b = r101;
        this.f230347c = r102;
        this.f230348d = r103;
        this.f230349e = r104;
        this.f230350f = r105;
        this.f230351g = r106;
        this.f230352h = r107;
        this.f230357m = CommentImmersiveVoiceTouchDelegate$popupContainerProvider$1.INSTANCE;
        this.f230360p = new CommentImmersiveVoiceTouchDelegate$onPopupShown$1(this);
        this.f230361q = CommentImmersiveVoiceTouchDelegate$onVoiceRecordingStateChanged$1.INSTANCE;
        CommentVoiceExtraAnalyticParams r108 = CommentVoiceExtraAnalyticParams.f230369a;
        this.f230363s = CommentVoiceExtraAnalyticParams.a(r101);
        this.f230364t = "input_bottom_button";
        this.f230365u = new c();
        this.f230366v = new com.bytedance.ee.bear.middleground.comment.audio.voiceinput.a(this);
    }

    public final void b(View r210, MotionEvent r310, Function0 r311, CommentVoiceInputResultConsumer r312, String r313, Function1 r314, Function1 r315, Function2 r316) {
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r310, "event");
        Intrinsics.checkNotNullParameter(r311, "popupContainerProvider");
        Intrinsics.checkNotNullParameter(r312, "resultConsumer");
        Intrinsics.checkNotNullParameter(r313, "voiceInputLocation");
        Intrinsics.checkNotNullParameter(r314, "onPopupShown");
        Intrinsics.checkNotNullParameter(r315, "onVoiceRecordingStateChanged");
        this.f230364t = r313;
        d();
        this.f230357m = r311;
        this.f230358n = r312;
        this.f230360p = r314;
        this.f230361q = r315;
        this.f230359o = r316;
        d();
        final ImmersiveVoiceInputView r100 = this.f230353i;
        if (r100 == null) goto L6;
    L9:
        if (r100 == null) goto L41;
        this.f230356l = r210;
        int r101 = r310.getAction() & 255;
        if (r101 != 0) goto L14;
        r210.setPressed(true);
        ImmersiveVoiceInputComponent.b r102 = this.f230354j;
        if (r102 == null) goto L38;
        r102.a();
    L38:
        ImmersiveVoiceInputComponent.b r103 = new ImmersiveVoiceInputComponent.b(r210, new CommentImmersiveVoiceTouchDelegate$handleTouch$3(r100, this));
        this.f230354j = r103;
        r103.c(r310);
        return;
    L14:
        if (r101 == 1) goto L28;
        if (r101 != 2) goto L17;
        ImmersiveVoiceInputComponent.b r104 = this.f230354j;
        if (r104 == null) goto L34;
        r104.b(r310);
    L34:
        r100.d(r210, r310);
        return;
    L17:
        if (r101 != 3) goto L34;
        r210.setPressed(false);
        ImmersiveVoiceInputComponent.b r105 = this.f230354j;
        if (r105 == null) goto L22;
        r105.a();
    L22:
        this.f230354j = null;
        if (this.f230355k == true) goto L34;
        this.f230356l = null;
        goto L34
    L28:
        r210.setPressed(false);
        ImmersiveVoiceInputComponent.b r106 = this.f230354j;
        if (r106 == null) goto L31;
        r106.d(r310);
    L31:
        this.f230354j = null;
        if (this.f230355k == true) goto L34;
        this.f230356l = null;
        goto L34
    L41:
        return;
    L6:
        if (this.f230357m.invoke() != null) goto L8;
        tt5.a.k("CommentImmersiveVoiceTouchDelegate", "ensureImmersiveVoiceInputView aborted: popupContainer is null");
        r100 = null;
        goto L9
    L8:
        Application r107 = com.larksuite.framework.utils.b.f285948a;
        Intrinsics.checkNotNull(r107);
        IAudioService r108 = (IAudioService) e0c.k.a(r107, IAudioService.class);
        com.ss.android.lark.audio.voiceinput.service.l r109 = (com.ss.android.lark.audio.voiceinput.service.l) e0c.k.a(r107, com.ss.android.lark.audio.voiceinput.service.l.class);
        com.ss.android.lark.audio.voiceinput.service.o r110 = (com.ss.android.lark.audio.voiceinput.service.o) e0c.k.a(r107, com.ss.android.lark.audio.voiceinput.service.o.class);
        Activity r111 = this.f230345a;
        Fragment r112 = this.f230346b;
        r r113 = k.f230431a;
        k.a("CommentImmersiveVoiceTouchDelegate", new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$dependency$1(this), new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$dependency$2(this), new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$dependency$3(this));
        x r114 = new x(r108, r109, r110, r111, r112);
        boolean r115 = this.f230347c;
        String r116 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        com.ss.android.lark.audio.voiceinput.p r117 = new com.ss.android.lark.audio.voiceinput.p(VoiceInputMode.OnlyAsr, this.f230348d);
        String r118 = this.f230349e;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.a r119 = this.f230366v;
        a0 r120 = new a0(2);
        Map<String, String> r121 = this.f230363s;
        r100 = new ImmersiveVoiceInputView(this.f230345a, r114, new w(r115, r116, r117, r118, r119, new b(this), r121, new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$voiceConfig$2(this), this.f230352h, r120, KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.f429815a, "im.messenger.voice_input_markdown"), 24512), this.f230365u);
        r100.e();
        r100.f(new CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$3$1(this), CommentImmersiveVoiceTouchDelegate$ensureImmersiveVoiceInputView$3$2.INSTANCE);
        this.f230353i = r100;
        goto L9
    }
}
