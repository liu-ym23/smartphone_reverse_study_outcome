package com.ss.android.lark.keyboard.plugin.tool.voice.immersive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ImmersiveVoiceInputComponent implements IKeyboardContent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f430093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<g0> f430094b = null;

    public static final class a implements IKeyboardContent.a {

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent$a$a, reason: collision with other inner class name */
        public static final class C5112a implements com.ss.android.lark.audio.voiceinput.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public com.ss.android.lark.keyboard.plugin.tool.voice.b f430095a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f430096b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f430097c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ImmersiveVoiceViewModel f430098d;

            @Override // com.ss.android.lark.audio.voiceinput.h
            public final void a() {
                com.ss.android.lark.keyboard.plugin.tool.voice.b r100 = this.f430095a;
                if (r100 == null) goto L5;
                Lazy<AudioRecordMutexController> r101 = AudioRecordMutexController.f429805d;
                AudioRecordMutexController r102 = AudioRecordMutexController.a.a();
                r102.getClass();
                Intrinsics.checkNotNullParameter(r100, "listener");
                r102.f429807b.remove(r100);
            L5:
                this.f430095a = null;
                Lazy<AudioRecordMutexController> r103 = AudioRecordMutexController.f429805d;
                AudioRecordMutexController.a(AudioRecordMutexController.a.a());
            }

            @Override // com.ss.android.lark.audio.voiceinput.h
            public final boolean b() {
                Context r100 = this.f430096b;
                com.ss.android.lark.keyboard.plugin.tool.voice.b r101 = this.f430095a;
                if (r101 == null) goto L5;
                Lazy<AudioRecordMutexController> r102 = AudioRecordMutexController.f429805d;
                AudioRecordMutexController r103 = AudioRecordMutexController.a.a();
                r103.getClass();
                Intrinsics.checkNotNullParameter(r101, "listener");
                r103.f429807b.remove(r101);
            L5:
                this.f430095a = null;
                Lazy<AudioRecordMutexController> r104 = AudioRecordMutexController.f429805d;
                AudioRecordMutexController r105 = AudioRecordMutexController.a.a();
                final boolean r106 = this.f430097c;
                final ImmersiveVoiceViewModel r107 = this.f430098d;
                Function0<Unit> r108 = new ImmersiveVoiceInputComponent$Key$initViewModelWithKeyIfNeed$1$1$addInterceptionListener$1(r106, r107);
                r105.getClass();
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                com.ss.android.lark.keyboard.plugin.tool.voice.b r109 = new com.ss.android.lark.keyboard.plugin.tool.voice.b(r108, r100, r105);
                this.f430095a = r109;
                AudioRecordMutexController r110 = AudioRecordMutexController.a.a();
                r110.getClass();
                Intrinsics.checkNotNullParameter(r109, "listener");
                r110.f429807b.add(r109);
                return AudioRecordMutexController.b(AudioRecordMutexController.a.a(), this.f430096b);
            }

            public C5112a(Context r100, boolean r101, ImmersiveVoiceViewModel r102) {
                this.f430096b = r100;
                this.f430097c = r101;
                this.f430098d = r102;
            }
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent.a
        public final String getTag() {
            return "ImmersiveVoiceKeyboardKey";
        }

        public a() {
        }

        public static ImmersiveVoiceViewModel a(boolean r100, x r101, w r102, Context r103) {
            Intrinsics.checkNotNullParameter(r101, "voiceInputDependency");
            Intrinsics.checkNotNullParameter(r102, "voiceInputConfig");
            Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
            String r104 = "androidx.lifecycle.ViewModelProvider.DefaultKey.SimpleImmersiveVoiceView:" + ImmersiveVoiceViewModel.Companion.getClass().getCanonicalName();
            if (r100 == false) goto L5;
            Fragment r105 = r101.f430718e;
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
            ImmersiveVoiceViewModel r106 = (ImmersiveVoiceViewModel) new ViewModelProvider(r105).get(r104, ImmersiveVoiceViewModel.class);
        L7:
            if (r106.isNeedInit() == false) goto L14;
            r106.setEnableVoiceInputSdk(r102.f430596a);
            r106.setAsrEnable(r102.f430599d.a());
            r106.setAsrNerEnable(r102.f430597b);
            if (r102.f430599d.f409283b != VoiceInputScene.SecretChat) goto L12;
            boolean r107 = true;
        L13:
            r106.setSupportPartialUpload(!r107);
            r106.setAutoSendOnRecognizeFinish(r102.f430604i);
            r106.setOnlyAsrRecognizingTipsProvider(r102.f430605j);
            r106.setHidePopupOnReleaseKeepSession(r102.f430606k);
            r106.init(r101, r102, new C5112a(r103, r100, r106), r102.f430601f);
            goto L14
        L12:
            r107 = false;
        L14:
            return r106;
        L5:
            Fragment r108 = r101.f430718e;
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
            r106 = (ImmersiveVoiceViewModel) new ViewModelProvider(r108).get(ImmersiveVoiceViewModel.class);
            goto L7
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f430099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f430100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f430101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f430102d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f430103e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f430104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f430105g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a f430106h;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f430107a;

            public a(b r100) {
                this.f430107a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Function0<Unit> r100 = this.f430107a.f430100b;     // Catch: Throwable -> L6
                if (r100 == null) goto L9;
                r100.invoke();     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public final void a() {
            this.f430099a.removeCallbacks(this.f430106h);
        }

        public final void b(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f430103e = r100.getX();
            this.f430104f = r100.getY();
        }

        public final void c(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f430099a.postDelayed(this.f430106h, this.f430101c);
            this.f430103e = r100.getX();
            this.f430104f = r100.getY();
            this.f430105g = System.currentTimeMillis();
        }

        public final void d(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            float r101 = r100.getX() - this.f430103e;
            float r102 = r100.getY() - this.f430104f;
            if (Math.abs(r101) < this.f430102d) goto L5;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == false) goto L12;
            this.f430099a.performClick();
        L12:
            a();
            return;
        L5:
            if (Math.abs(r102) >= this.f430102d) goto L9;
            if ((System.currentTimeMillis() - this.f430105g) >= this.f430101c) goto L9;
            r103 = true;
            goto L10
        }

        public b(View r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "host");
            this.f430099a = r100;
            this.f430100b = r101;
            this.f430101c = 300;
            this.f430102d = 10.0f;
            this.f430106h = new a(this);
        }
    }

    public ImmersiveVoiceInputComponent() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void c(int r100) {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.a getKey() {
        return null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onHide() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onShow() {
    }

    static {
        f430093a = new a();
        f430094b = new ArrayList();
    }

    private final Activity getContext() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final IKeyboardContent.ViewInitStrategy a() {
        return IKeyboardContent.ViewInitStrategy.Lazy;
    }

    public final int e() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onCreate() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onDestroy() {
        throw null;
    }

    public static final /* synthetic */ Activity d(ImmersiveVoiceInputComponent r100) {
        return r100.getContext();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent$getTouchListener$2] */
    public static ImmersiveVoiceInputComponent$getTouchListener$2 f(final ImmersiveVoiceInputComponent r100, final Function0 r101) {
        Intrinsics.checkNotNullParameter(ImmersiveVoiceInputComponent$getTouchListener$1.INSTANCE, "longPressInterceptor");
        return new ImmersiveVoiceInputComponent$getTouchListener$2(r100, r101);
    }

    public final void g(int r100, boolean r101) {
        com.ss.android.lark.c.a(null);
        PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        if (r101 == false) goto L7;
        throw null;
    L7:
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent
    public final void onActivityResult(int r100, int r101, Intent r102) {
        if (r100 == 10000) goto L6;
        return;
    L6:
        throw null;
    }
}
