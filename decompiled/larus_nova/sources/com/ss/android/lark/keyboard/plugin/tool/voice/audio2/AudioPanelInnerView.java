package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.audio.voiceinput.AudioPluginFeature;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.SendType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rob.j;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\rR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPanelInnerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "mController", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;", "mFeature", "Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "<init>", "(Landroid/content/Context;Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/AudioPluginController;Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;)V", "mHintTv", "Landroidx/appcompat/widget/AppCompatTextView;", "getMHintTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "mHintTv$delegate", "Lkotlin/Lazy;", "mMainBtn", "Lcom/larksuite/component/universe_design/button/UDButton;", "getMMainBtn", "()Lcom/larksuite/component/universe_design/button/UDButton;", "mMainBtn$delegate", "mSwitchLanguageTv", "getMSwitchLanguageTv", "mSwitchLanguageTv$delegate", "mOnLongPressedRunnable", "Ljava/lang/Runnable;", "isSingleClick", "", "mDownX", "", "mDownY", "getOnTouchListener", "Landroid/view/View$OnTouchListener;", "onActionDown", "event", "Landroid/view/MotionEvent;", "getMainButtonTopRawY", "", "getMainBtnBottomMargin", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioPanelInnerView extends ConstraintLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f429905h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f429906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioPluginFeature f429907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f429908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f429909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f429910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f429911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f429912g;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioPanelInnerView$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/larksuite/component/universe_design/button/ButtonDrawableParams;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function1<com.larksuite.component.universe_design.button.a, Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.larksuite.component.universe_design.button.a r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$showDrawable");
            r100.f284589c = 2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.larksuite.component.universe_design.button.a r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    public static final class a implements AudioAsrLanguageSwitcher.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatTextView f429913a;

        public a(AppCompatTextView r100) {
            this.f429913a = r100;
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void a(j r100) {
            Intrinsics.checkNotNullParameter(r100, "itemData");
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void b(rob.e r100) {
            Intrinsics.checkNotNullParameter(r100, "itemData");
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void d(SendType r100) {
            Intrinsics.checkNotNullParameter(r100, "sendType");
        }

        @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioAsrLanguageSwitcher.b
        public final void c(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "languageName");
            Intrinsics.checkNotNullParameter(r101, "<unused var>");
            this.f429913a.setText(r100);
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f429914a = null;

        static {
            int[] r100 = new int[AudioPluginFeature.values().length];
            r100[AudioPluginFeature.RECOGNIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f429914a = r100;
        }
    }

    public static final class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioPanelInnerView f429915a;

        public d(AudioPanelInnerView r100) {
            this.f429915a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            if (r102 == 0) goto L15;
            if (r102 != 1) goto L6;
            Log.i("AudioPanelInnerView", "onActionUp");
            this.f429915a.getParent().requestDisallowInterceptTouchEvent(false);
            AudioPanelInnerView r103 = this.f429915a;
            r103.removeCallbacks(r103.f429911f);
            AudioPanelInnerView r104 = this.f429915a;
            if (r104.f429912g == true) goto L13;
        L11:
            h r105 = this.f429915a.f429906a;
            Intrinsics.checkNotNull(r101);
            r105.j(r101);
            return true;
        L13:
            h r106 = r104.f429906a;
            AudioPanelInnerView.S5(r104);
            AudioPanelInnerView.R5(this.f429915a);
            r106.getClass();
            throw null;
        L6:
            if (r102 != 3) goto L11;
            Log.i("AudioPanelInnerView", "onActionCancel");
            this.f429915a.getParent().requestDisallowInterceptTouchEvent(false);
            AudioPanelInnerView r107 = this.f429915a;
            r107.removeCallbacks(r107.f429911f);
            goto L11
        L15:
            AudioPanelInnerView r108 = this.f429915a;
            Intrinsics.checkNotNull(r101);
            int r109 = AudioPanelInnerView.f429905h;
            r108.getClass();
            Log.i("AudioPanelInnerView", "onActionDown");
            r101.getX();
            r101.getY();
            int r110 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
            if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(r108.getContext()) == true) goto L19;
            com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.j(ContextsKt.requireActivity(r108.getContext()), AudioPanelInnerView$onActionDown$1.INSTANCE);
            return false;
        L19:
            if (r108.f429907b == AudioPluginFeature.RECOGNIZE) goto L21;
        L25:
            r108.f429912g = true;
            g r111 = new g(r108, r101);
            r108.f429911f = r111;
            AudioPluginFeature r112 = r108.f429907b;
            if (c.f429914a[r112.ordinal()] != 1) goto L28;
            long r113 = 300;
        L29:
            r108.postDelayed(r111, r113);
            return true;
        L28:
            r113 = 100;
            goto L29
        L21:
            if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.h() == false) goto L25;
            Log.i("AudioPanelInnerView", "onActionDown / Network unavailable");
            r108.f429906a.getClass();
            throw null;
        }
    }

    static {
    }

    private final int getMainButtonTopRawY() {
        int[] r100 = new int[2];
        getMMainBtn().getLocationOnScreen(r100);
        return r100[1];
    }

    private final AppCompatTextView getMHintTv() {
        return (AppCompatTextView) this.f429908c.getValue();
    }

    private final UDButton getMMainBtn() {
        return (UDButton) this.f429909d.getValue();
    }

    private final AppCompatTextView getMSwitchLanguageTv() {
        return (AppCompatTextView) this.f429910e.getValue();
    }

    private final View.OnTouchListener getOnTouchListener() {
        return new d(this);
    }

    private final int getMainBtnBottomMargin() {
        return getMeasuredHeight() - getMMainBtn().getBottom();
    }

    public static final /* synthetic */ int R5(AudioPanelInnerView r100) {
        return r100.getMainBtnBottomMargin();
    }

    public static final /* synthetic */ int S5(AudioPanelInnerView r100) {
        return r100.getMainButtonTopRawY();
    }

    public AudioPanelInnerView(Context r100, h r101, AudioPluginFeature r102) {
        super(r100);
        this.f429906a = r101;
        this.f429907b = r102;
        this.f429908c = LazyKt.lazy(new AudioPanelInnerView$mHintTv$2(this));
        this.f429909d = LazyKt.lazy(new AudioPanelInnerView$mMainBtn$2(this));
        this.f429910e = LazyKt.lazy(new AudioPanelInnerView$mSwitchLanguageTv$2(this));
        LayoutInflater.from(r100).inflate(R.layout.layout_audio_panel_inner_view, this);
        getMMainBtn().setOnTouchListener(getOnTouchListener());
        AppCompatTextView r103 = getMSwitchLanguageTv();
        int r104 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        Drawable r105 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.d(r103, R.drawable.ud_icon_down_bold_outlined);
        r105.setBounds(0, 0, com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.m(r103, 10), com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.m(r103, 10));
        r103.setCompoundDrawables(null, null, r105, null);
        a r106 = new a(r103);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r106, "onLanguageSwitchListener");
        throw null;
    }
}
