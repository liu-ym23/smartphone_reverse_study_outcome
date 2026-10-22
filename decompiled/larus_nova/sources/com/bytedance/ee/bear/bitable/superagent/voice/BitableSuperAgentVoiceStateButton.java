package com.bytedance.ee.bear.bitable.superagent.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.bean.State;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceStateButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "micIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "waveformView", "Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceWaveformView;", "spinnerView", "spinnerDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "mode", "Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceStateButton$Mode;", "setLevel", "", "level", "", "setMode", "newMode", "applyMode", PickerReporterConstants.KEY.TARGET, "onAttachedToWindow", "onDetachedFromWindow", "Mode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentVoiceStateButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatImageView f215921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableSuperAgentVoiceWaveformView f215922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppCompatImageView f215923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UDLoadingDrawable f215924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Mode f215925e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceStateButton$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", State.RECORDING, "STOPPING", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode IDLE = null;
        public static final Mode RECORDING = null;
        public static final Mode STARTING = null;
        public static final Mode STOPPING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f215926a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f215927b = null;

        public static EnumEntries<Mode> getEntries() {
            return f215927b;
        }

        static {
            Mode r100 = new Mode("IDLE", 0);
            IDLE = r100;
            Mode r101 = new Mode("STARTING", 1);
            STARTING = r101;
            Mode r102 = new Mode(State.RECORDING, 2);
            RECORDING = r102;
            Mode r103 = new Mode("STOPPING", 3);
            STOPPING = r103;
            Mode[] r104 = {r100, r101, r102, r103};
            f215926a = r104;
            f215927b = EnumEntriesKt.enumEntries(r104);
        }

        public static Mode[] values() {
            return (Mode[]) f215926a.clone();
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f215928a = null;

        static {
            int[] r100 = new int[Mode.values().length];
            r100[Mode.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[Mode.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[Mode.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Mode.STOPPING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f215928a = r100;
        }
    }

    public BitableSuperAgentVoiceStateButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableSuperAgentVoiceStateButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f215922b.b();
        this.f215924d.stop();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f215925e != Mode.RECORDING) goto L5;
        this.f215922b.a();
    L5:
        Mode r100 = this.f215925e;
        if (r100 != Mode.STARTING) goto L8;
    L9:
        this.f215924d.start();
        return;
    L8:
        if (r100 == Mode.STOPPING) goto L9;
    }

    public final void a(Mode r100) {
        int r101 = a.f215928a[r100.ordinal()];
        if (r101 != 1) goto L5;
        setBackground(null);
        this.f215921a.setVisibility(0);
        this.f215922b.setVisibility(8);
        this.f215922b.b();
        this.f215923c.setVisibility(8);
        this.f215924d.stop();
        return;
    L5:
        if (r101 != 2) goto L7;
        setBackgroundResource(R.drawable.bitable_superagent_voice_starting_bg);
        this.f215924d.setColorSchemeColors(new int[]{ContextCompat.getColor(getContext(), R.color.icon_n3)});
        this.f215921a.setVisibility(8);
        this.f215922b.setVisibility(8);
        this.f215922b.b();
        this.f215923c.setVisibility(0);
        this.f215924d.start();
        return;
    L7:
        if (r101 != 3) goto L9;
        setBackgroundResource(R.drawable.bitable_superagent_voice_recording_bg);
        this.f215921a.setVisibility(8);
        this.f215923c.setVisibility(8);
        this.f215924d.stop();
        this.f215922b.setVisibility(0);
        this.f215922b.a();
        return;
    L9:
        if (r101 != 4) goto L12;
        setBackgroundResource(R.drawable.bitable_superagent_voice_stopping_bg);
        this.f215924d.setColorSchemeColors(new int[]{ContextCompat.getColor(getContext(), R.color.primary_content_loading)});
        this.f215921a.setVisibility(8);
        this.f215922b.setVisibility(8);
        this.f215922b.b();
        this.f215923c.setVisibility(0);
        this.f215924d.start();
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void setLevel(float r100) {
        this.f215922b.setLevel(r100);
    }

    public final void setMode(Mode r100) {
        Intrinsics.checkNotNullParameter(r100, "newMode");
        if (this.f215925e != r100) goto L5;
        return;
    L5:
        this.f215925e = r100;
        a(r100);
    }

    public BitableSuperAgentVoiceStateButton(Context r100, AttributeSet r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r110, r111);
        Mode r112 = Mode.IDLE;
        this.f215925e = r112;
        setClipChildren(false);
        setClipToPadding(false);
        AppCompatImageView r101 = new AppCompatImageView(r100);
        r101.setImageResource(R.drawable.ud_icon_mic_outlined);
        r101.setImageTintList(ContextCompat.getColorStateList(r100, R.color.icon_n1));
        int r102 = n.c(6.0f);
        r101.setPadding(r102, r102, r102, r102);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.f215921a = r101;
        BitableSuperAgentVoiceWaveformView r103 = new BitableSuperAgentVoiceWaveformView(r100, null);
        r103.setLayoutParams(new FrameLayout.LayoutParams(n.c(14.0f), n.c(16.0f), 17));
        r103.setVisibility(8);
        this.f215922b = r103;
        UDLoadingDrawable r104 = new UDLoadingDrawable(r100);
        r104.setColorSchemeColors(new int[]{ContextCompat.getColor(r100, R.color.icon_n3)});
        r104.setCenterRadius(n.c(6.0f));
        r104.setStrokeWidth(n.c(1.6f));
        this.f215924d = r104;
        AppCompatImageView r113 = new AppCompatImageView(r100);
        r113.setImageDrawable(r104);
        r113.setLayoutParams(new FrameLayout.LayoutParams(n.c(18.0f), n.c(18.0f), 17));
        r113.setVisibility(8);
        this.f215923c = r113;
        addView(r101);
        addView(r113);
        addView(r103);
        a(r112);
    }

    public /* synthetic */ BitableSuperAgentVoiceStateButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
