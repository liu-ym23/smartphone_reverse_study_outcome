package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.audio.voiceinput.AudioPluginUseType;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.p;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenu;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.PanelMenuItem;
import com.ss.android.lark.keyboard.keyboard2.content.IKeyboardContent;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.z;
import com.ss.android.lark.keyboard.plugin.tool.voice.utils.AudioPluginHelper;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
public final class AudioKBPlugin extends PanelMenuItem {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f429860v = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f429861d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qob.a f429862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f429863f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IVoiceFaceDependency f429864g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f429865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function1<com.ss.android.lark.keyboard.b, Unit> f429866i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final KeyboardMenuItemKey f429867j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f429868k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AudioPanelContainer f429869l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppCompatImageView f429870m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f429871n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Unit> f429872o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f429873p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f429874q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CoroutineScope f429875r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f429876s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<z> f429877t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e f429878u;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f429879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AudioKBPlugin f429880b;

        public b(Function0<Unit> r100, AudioKBPlugin r101) {
            this.f429879a = r100;
            this.f429880b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f429879a.invoke();
            this.f429880b.getClass();
            throw null;
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioKBPlugin f429881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.keyboard2.i.a f429882b;

        public c(AudioKBPlugin r100, com.ss.android.lark.keyboard.keyboard2.i.a r101) {
            this.f429881a = r100;
            this.f429882b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f429881a.f429872o.invoke();
            this.f429881a.getClass();
            this.f429882b.performClick();
        }
    }

    static {
    }

    public AudioKBPlugin() {
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final int a() {
        return R.drawable.ud_icon_voice_outlined;
    }

    public final Activity H() {
        return (Activity) this.f429868k.getValue();
    }

    public final h J() {
        return (h) this.f429874q.getValue();
    }

    public final boolean K() {
        AudioPluginHelper r100 = (AudioPluginHelper) this.f429876s.getValue();
        boolean r101 = true;
        if (r100.f430824e == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L10;
    L16:
        Log.i("AudioSendTypeHelper", "enableUseNewAudioPlugin: " + r101);
        Log.i("AudioKBPlugin", "isImmersiveVoicePluginEnable: " + r101);
        return r101;
    L10:
        if (r100.f430820a.f429863f.f409283b != VoiceInputScene.EnterpriseAnswer) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        r101 = false;
        goto L16
    L12:
        r103 = false;
        goto L13
    L5:
        if (r100.f430822c != AudioPluginUseType.NEW) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void u() {
        ((AudioPluginHelper) this.f429876s.getValue()).a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final Integer q() {
        return Integer.valueOf(R.string.test_kb_plugin_audio);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void v() {
        if (K() == true) goto L5;
        J().i();
    L5:
        n().v();
        this.f429862e.getChatId();
        throw null;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final KeyboardMenuItemKey g() {
        return this.f429867j;
    }

    public AudioKBPlugin(AudioKBPlugin r100) {
        Intrinsics.checkNotNullParameter(r100, "audioKBPlugin");
        r100.getClass();
        boolean r101 = r100.f429861d;
        qob.a r102 = r100.f429862e;
        p r103 = r100.f429863f;
        IVoiceFaceDependency r104 = r100.f429864g;
        String r105 = r100.f429865h;
        Function1<com.ss.android.lark.keyboard.b, Unit> r106 = r100.f429866i;
        Intrinsics.checkNotNullParameter(null, "chatAppDependency");
        Intrinsics.checkNotNullParameter(r102, "audioDataProcessorDependency");
        Intrinsics.checkNotNullParameter(r103, "voiceInputModeWithScene");
        Intrinsics.checkNotNullParameter(r105, "hitPointPageScene");
        this.f429861d = r101;
        this.f429862e = r102;
        this.f429863f = r103;
        this.f429864g = r104;
        this.f429865h = r105;
        this.f429866i = r106;
        this.f429867j = KeyboardMenuItemKey.Voice;
        this.f429868k = LazyKt.lazy(new AudioKBPlugin$mContext$2(this));
        this.f429872o = AudioKBPlugin$mPluginClickListener$1.INSTANCE;
        this.f429873p = LazyKt.lazy(new AudioKBPlugin$mViewModel$2(this));
        this.f429874q = LazyKt.lazy(new AudioKBPlugin$mController$2(this));
        this.f429875r = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(CoreThreadPool.getDefault().getCachedThreadPool()).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f429876s = LazyKt.lazy(new AudioKBPlugin$audioPluginHelper$2(this));
        this.f429877t = new ArrayList();
        this.f429878u = new e(this);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.o
    public final void A(boolean r100) {
        ((AudioViewModel) this.f429873p.getValue()).onAudioPluginSelectChange(r100);
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.PanelMenuItem
    public final View G(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        View r101 = LayoutInflater.from(H()).inflate(R.layout.layout_audio_panel_container, r100, false);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelContainer");
        AudioPanelContainer r102 = (AudioPanelContainer) r101;
        this.f429869l = r102;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
        r102 = null;
    L5:
        h r103 = J();
        AudioViewModel r104 = (AudioViewModel) this.f429873p.getValue();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "controller");
        Intrinsics.checkNotNullParameter(r104, "viewModel");
        r102.f429887c = r103;
        r102.f429888d = r104;
        r102.V5(this.f429863f.a(), this.f429863f.a(), new AudioKBPlugin$onCreatePanel$1(this));
        AudioPanelContainer r105 = this.f429869l;
        if (r105 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mPanelContainer");
        return null;
    L9:
        return r105;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.m
    public final void x(com.ss.android.lark.keyboard.keyboard2.i r100) {
        Intrinsics.checkNotNullParameter(r100, "iconHolder");
        if (K() == true) goto L36;
        Function1<com.ss.android.lark.keyboard.b, Unit> r101 = this.f429866i;
        if (r101 == null) goto L7;
        r101.invoke(n());
    L7:
        View r102 = r100.f429551a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        AppCompatImageView r103 = (AppCompatImageView) r102;
        r103.setActivated(this.f429861d);
        if (this.f429861d == false) goto L10;
    L16:
        r103.setHapticFeedbackEnabled(true);
        r103.setBackground(null);
        KeyboardMenu.f r104 = r100.f429552b.a();
        if (K() == false) goto L33;
        com.ss.android.lark.keyboard.keyboard2.content.c r105 = n().v();
        ImmersiveVoiceInputComponent.a r106 = ImmersiveVoiceInputComponent.f430093a;
        IKeyboardContent r107 = r105.getContent();
        if ((r107 instanceof ImmersiveVoiceInputComponent) == false) goto L21;
        final ImmersiveVoiceInputComponent r108 = (ImmersiveVoiceInputComponent) r107;
    L22:
        if (r108 == null) goto L34;
        ImmersiveVoiceInputComponent.f430094b.add(new com.ss.android.lark.keyboard.plugin.tool.voice.audio2.c(this));
        if (this.f429863f.a() == false) goto L31;
        KeyboardVoiceFGUtils r109 = KeyboardVoiceFGUtils.f429815a;
        if (KeyboardVoiceFGUtils.a("im.messenger.new_speech_to_text", null) == false) goto L31;
        if (KeyboardVoiceFGUtils.a("im.messenger.advance_mode_refactor", null) == false) goto L30;
        r103.setOnTouchListener(null);
    L32:
        r103.setOnClickListener(new b(new AudioKBPlugin$onIconCreated$1$hideImeWrapper$1(r108), this));
        goto L34
    L30:
        throw null;
    L31:
        r103.setOnTouchListener(ImmersiveVoiceInputComponent.f(r108, new AudioKBPlugin$onIconCreated$1$1(r108)));
    L34:
        n().e().of(this).d(InputSupportType.class, new AudioKBPlugin$onIconCreated$3(this));
        this.f429870m = r103;
        return;
    L21:
        r108 = null;
        goto L22
    L33:
        r103.setOnTouchListener(new d(this, new c(this, r104)));
        goto L34
    L10:
        if (this.f429863f.a() == false) goto L16;
        if (K() == false) goto L14;
        r103.setImageDrawable(UIUtils.getDrawable(H(), R.drawable.ud_icon_mic_outlined));
        goto L16
    L14:
        J().getClass();
        throw null;
    L36:
        throw null;
    }
}
