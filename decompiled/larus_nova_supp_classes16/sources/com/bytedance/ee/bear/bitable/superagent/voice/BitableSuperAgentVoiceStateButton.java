package com.bytedance.ee.bear.bitable.superagent.voice;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\b\u0010\u001c\u001a\u00020\u0014H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceStateButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "micIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "waveformView", "Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceWaveformView;", "spinnerView", "spinnerDrawable", "Lcom/larksuite/component/universe_design/loading/UDLoadingDrawable;", "mode", "Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceStateButton$Mode;", "setLevel", "", "level", "", "setMode", "newMode", "applyMode", "target", "onAttachedToWindow", "onDetachedFromWindow", "Mode", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentVoiceStateButton extends FrameLayout {
    public final AppCompatImageView a;
    public final BitableSuperAgentVoiceWaveformView b;
    public final AppCompatImageView c;
    public final UDLoadingDrawable d;
    public Mode e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/voice/BitableSuperAgentVoiceStateButton$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "STARTING", "RECORDING", "STOPPING", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        public static final Mode IDLE = null;
        public static final Mode RECORDING = null;
        public static final Mode STARTING = null;
        public static final Mode STOPPING = null;
        public static final /* synthetic */ Mode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Mode> getEntries() {
            return b;
        }

        static {
            Mode r0 = new Mode("IDLE", 0);
            IDLE = r0;
            Mode r1 = new Mode("STARTING", 1);
            STARTING = r1;
            Mode r3 = new Mode("RECORDING", 2);
            RECORDING = r3;
            Mode r5 = new Mode("STOPPING", 3);
            STOPPING = r5;
            Mode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
        }

        public Mode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Mode.values().length];
            r0[Mode.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Mode.STARTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Mode.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Mode.STOPPING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public BitableSuperAgentVoiceStateButton(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BitableSuperAgentVoiceStateButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.b.b();
        this.d.stop();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e != Mode.RECORDING) goto L5;
        this.b.a();
    L5:
        Mode r0 = this.e;
        if (r0 != Mode.STARTING) goto L8;
    L9:
        this.d.start();
        return;
    L8:
        if (r0 == Mode.STOPPING) goto L9;
    }

    public final void a(Mode r6) {
        int r7 = a.a[r6.ordinal()];
        if (r7 != 1) goto L5;
        setBackground(null);
        this.a.setVisibility(0);
        this.b.setVisibility(8);
        this.b.b();
        this.c.setVisibility(8);
        this.d.stop();
        return;
    L5:
        if (r7 != 2) goto L7;
        setBackgroundResource(2131232382);
        this.d.setColorSchemeColors(new int[]{ContextCompat.getColor(getContext(), 2131102420)});
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.b.b();
        this.c.setVisibility(0);
        this.d.start();
        return;
    L7:
        if (r7 != 3) goto L9;
        setBackgroundResource(2131232381);
        this.a.setVisibility(8);
        this.c.setVisibility(8);
        this.d.stop();
        this.b.setVisibility(0);
        this.b.a();
        return;
    L9:
        if (r7 != 4) goto L12;
        setBackgroundResource(2131232383);
        this.d.setColorSchemeColors(new int[]{ContextCompat.getColor(getContext(), 2131105544)});
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        this.b.b();
        this.c.setVisibility(0);
        this.d.start();
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final void setLevel(float r2) {
        this.b.setLevel(r2);
    }

    public final void setMode(Mode r2) {
        Intrinsics.checkNotNullParameter(r2, "newMode");
        if (this.e != r2) goto L5;
        return;
    L5:
        this.e = r2;
        a(r2);
    }

    public BitableSuperAgentVoiceStateButton(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        Mode r12 = Mode.IDLE;
        this.e = r12;
        setClipChildren(false);
        setClipToPadding(false);
        AppCompatImageView r0 = new AppCompatImageView(r9);
        r0.setImageResource(2131255118);
        r0.setImageTintList(ContextCompat.getColorStateList(r9, 2131102418));
        int r2 = n.c(6.0f);
        r0.setPadding(r2, r2, r2, r2);
        r0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.a = r0;
        BitableSuperAgentVoiceWaveformView r3 = new BitableSuperAgentVoiceWaveformView(r9, null);
        r3.setLayoutParams(new FrameLayout.LayoutParams(n.c(14.0f), n.c(16.0f), 17));
        r3.setVisibility(8);
        this.b = r3;
        UDLoadingDrawable r5 = new UDLoadingDrawable(r9);
        r5.setColorSchemeColors(new int[]{ContextCompat.getColor(r9, 2131102420)});
        r5.setCenterRadius(n.c(6.0f));
        r5.setStrokeWidth(n.c(1.6f));
        this.d = r5;
        AppCompatImageView r13 = new AppCompatImageView(r9);
        r13.setImageDrawable(r5);
        r13.setLayoutParams(new FrameLayout.LayoutParams(n.c(18.0f), n.c(18.0f), 17));
        r13.setVisibility(8);
        this.c = r13;
        addView(r0);
        addView(r13);
        addView(r3);
        a(r12);
    }

    public /* synthetic */ BitableSuperAgentVoiceStateButton(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
