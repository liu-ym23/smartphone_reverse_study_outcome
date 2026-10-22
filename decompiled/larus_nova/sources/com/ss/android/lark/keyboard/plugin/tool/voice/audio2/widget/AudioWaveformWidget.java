package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$WaveformState;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.AudioPluginEnums$WaveformWidgetTheme;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001bJ\u0012\u0010'\u001a\u00020\u00002\b\b\u0001\u0010(\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+H\u0002R\u001b\u0010\b\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveformWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mWaveformBg", "getMWaveformBg", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mWaveformBg$delegate", "Lkotlin/Lazy;", "mWaveform", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveform;", "getMWaveform", "()Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioWaveform;", "mWaveform$delegate", "mDurationTv", "Landroidx/appcompat/widget/AppCompatTextView;", "getMDurationTv", "()Landroidx/appcompat/widget/AppCompatTextView;", "mDurationTv$delegate", "bgPaddingVertical", "", "bgPaddingHorizontal", "mTheme", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformWidgetTheme;", "onStartRecord", "", "onStopRecord", "theme", BasicTestActionHandler.TEST_ACTION_RESET, "setVolume", ITTVideoEngineEventSource.KEY_VOLUME, "setDuration", "duration", "", "setColorTheme", "setBgColor", "colorRes", "toggleDurationVisibility", "visible", "", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioWaveformWidget extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f430051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f430052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f430053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430054d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f430055e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AudioPluginEnums$WaveformWidgetTheme f430056f;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f430057a = null;

        static {
            int[] r100 = new int[AudioPluginEnums$WaveformWidgetTheme.values().length];
            r100[AudioPluginEnums$WaveformWidgetTheme.BLUE_SIMPLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AudioPluginEnums$WaveformWidgetTheme.BLUE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AudioPluginEnums$WaveformWidgetTheme.GRAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f430057a = r100;
        }
    }

    static {
    }

    private final AppCompatTextView getMDurationTv() {
        return (AppCompatTextView) this.f430053c.getValue();
    }

    private final AudioWaveform getMWaveform() {
        return (AudioWaveform) this.f430052b.getValue();
    }

    private final ConstraintLayout getMWaveformBg() {
        return (ConstraintLayout) this.f430051a.getValue();
    }

    public final void R5() {
        AudioWaveform r100 = getMWaveform();
        r100.getClass();
        r100.f430050n = AudioPluginEnums$WaveformState.INIT;
        r100.f430043g.clear();
        r100.getClass();
        PthreadTimer r101 = r100.f430049m;
        if (r101 == null) goto L5;
        r101.cancel();
        r101.purge();
    L5:
        r100.f430049m = null;
        r100.invalidate();
        getMDurationTv().setText("0:00");
    }

    public final void S5(AudioPluginEnums$WaveformWidgetTheme r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        this.f430056f = r100;
        AudioWaveform r101 = getMWaveform();
        int r102 = r100.getWaveColorRes();
        int r103 = r100.getFadeColorRes();
        Paint r104 = r101.f430045i;
        int r105 = c.f430003a;
        r104.setColor(c.c(r101, r102));
        r101.f430047k.setColor(c.c(r101, r103));
        r101.invalidate();
        getMDurationTv().setTextColor(c.c(this, r100.getTextColorRes()));
        int r106 = r100.getBgColorRes();
        ConstraintLayout r107 = getMWaveformBg();
        if (r106 != R.color.transparent) goto L5;
        r107.setBackground(null);
        r107.setPadding(0, 0, 0, 0);
    L6:
        invalidate();
        int r108 = b.f430057a[r100.ordinal()];
        if (r108 != 1) goto L9;
        U5(false);
        return;
    L9:
        if (r108 != 2) goto L11;
        U5(true);
        return;
    L11:
        if (r108 != 3) goto L14;
        U5(true);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    L5:
        Drawable r109 = c.d(this, R.drawable.bg_audio_waveform_widget);
        r109.setTint(c.c(this, r106));
        r107.setBackground(r109);
        int r110 = this.f430055e;
        int r111 = this.f430054d;
        r107.setPadding(r110, r111, r110, r111);
        goto L6
    }

    public final void T5(int r100) {
        getMWaveform().setVolume(r100);
    }

    public final void U5(boolean r100) {
        if (r100 == false) goto L4;
        getMDurationTv().setVisibility(0);
        AppCompatTextView r101 = getMDurationTv();
        int r102 = c.f430003a;
        r101.setTextColor(c.c(this, this.f430056f.getTextColorRes()));
        return;
    L4:
        getMDurationTv().setVisibility(8);
    }

    public AudioWaveformWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f430051a = LazyKt.lazy(new AudioWaveformWidget$mWaveformBg$2(this));
        this.f430052b = LazyKt.lazy(new AudioWaveformWidget$mWaveform$2(this));
        this.f430053c = LazyKt.lazy(new AudioWaveformWidget$mDurationTv$2(this));
        int r102 = c.f430003a;
        this.f430054d = c.m(this, 9);
        this.f430055e = c.m(this, 12);
        this.f430056f = AudioPluginEnums$WaveformWidgetTheme.BLUE_SIMPLE;
        LayoutInflater.from(r100).inflate(R.layout.layout_audio_waveform_widget, this);
        S5(this.f430056f);
        R5();
    }
}
