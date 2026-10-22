package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.component.ui.imageview.LKUILottieAnimationView;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$DeleteBtnAttrs;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0018\u0018\u0000 '2\u00020\u0001:\u0001'B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ\u0016\u0010\"\u001a\u00020\u001d2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0$J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton;", "Lcom/larksuite/component/ui/imageview/LKUILottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "finalBias", "", "initBias", "maxDeltaY", "", "getMaxDeltaY", "()I", "finalPadding", "initPadding", "mShakyRunnable", "Ljava/lang/Runnable;", "getMShakyRunnable", "()Ljava/lang/Runnable;", "mShakyRunnable$delegate", "Lkotlin/Lazy;", "mShakyListener", "com/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton$mShakyListener$2$1", "getMShakyListener", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioLottieTrashButton$mShakyListener$2$1;", "mShakyListener$delegate", BasicTestActionHandler.TEST_ACTION_RESET, "", "onDragging", "offsetY", "playOpenAnim", "playCloseAnim", "playEndAnim", "onAnimEnd", "Lkotlin/Function0;", "playShakyAnim", "cancelShakyAnim", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioLottieTrashButton extends LKUILottieAnimationView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f430005h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f430006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f430007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f430010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f430011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f430012g;

    public static final class a {
    }

    static {
    }

    private final AudioLottieTrashButton$mShakyListener$2.a getMShakyListener() {
        return (AudioLottieTrashButton$mShakyListener$2.a) this.f430012g.getValue();
    }

    private final Runnable getMShakyRunnable() {
        return (Runnable) this.f430011f.getValue();
    }

    public final void l() {
        removeAnimatorListener(getMShakyListener());
        removeCallbacks(getMShakyRunnable());
    }

    public final int getMaxDeltaY() {
        return this.f430008c;
    }

    public static final /* synthetic */ Runnable j(AudioLottieTrashButton r100) {
        return r100.getMShakyRunnable();
    }

    public final void m(float r100) {
        final float r101 = r100 / this.f430008c;
        int r102 = c.f430003a;
        c.p(this, new AudioLottieTrashButton$onDragging$1(this, r101));
        int r103 = this.f430010e;
        int r104 = (int) (r103 + (r101 * (this.f430009d - r103)));
        setPadding(r104, r104, r104, r104);
    }

    public AudioLottieTrashButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        AudioPluginEnums$DeleteBtnAttrs r102 = AudioPluginEnums$DeleteBtnAttrs.FINAL;
        this.f430006a = r102.getBias();
        AudioPluginEnums$DeleteBtnAttrs r103 = AudioPluginEnums$DeleteBtnAttrs.INIT;
        this.f430007b = r103.getBias();
        int r104 = c.f430003a;
        this.f430008c = c.m(this, 60);
        this.f430009d = c.m(this, Integer.valueOf(r102.getPadding()));
        this.f430010e = c.m(this, Integer.valueOf(r103.getPadding()));
        this.f430011f = LazyKt.lazy(new AudioLottieTrashButton$mShakyRunnable$2(this));
        this.f430012g = LazyKt.lazy(new AudioLottieTrashButton$mShakyListener$2(this));
    }
}
