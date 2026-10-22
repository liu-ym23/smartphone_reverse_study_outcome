package com.larus.bmhome.chat.component.bottom.voice;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0007J\b\u0010\u0016\u001a\u00020\rH\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/voice/VoiceMixInputPanel;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "visualizer", "Lcom/larus/common_ui/widget/input/AudioVisualizerOpt;", "startVoiceInput", "", "stopVoiceInput", "updateAudioData", "scope", "Lkotlinx/coroutines/CoroutineScope;", "data", "", "setImmersiveMode", "immersiveColor", "initAudioVisualizer", "getVisualizer", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixInputPanel extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioVisualizerOpt f300396a;

    public VoiceMixInputPanel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceMixInputPanel(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final AudioVisualizerOpt getVisualizer() {
        AudioVisualizerOpt r100 = this.f300396a;
        if (r100 == null) goto L7;
        if (r100 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
        goto L7
    L8:
        return r100;
    L7:
        return null;
    }

    public final void setImmersiveMode(int r100) {
        AudioVisualizerOpt r101 = this.f300396a;
        if (r101 == null) goto L7;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
        r101 = null;
    L6:
        r101.setPaintColor(getResources().getColor(R.color.larus_static_white));
    L7:
        TextView r102 = (TextView) findViewById(R.id.audio_hint);
        if (r102 == null) goto L10;
        r102.setTextColor(getResources().getColor(R.color.static_white_transparent_4));
    L10:
        ImageView r103 = (ImageView) findViewById(R.id.control_icon);
        if (r103 == null) goto L13;
        r103.setImageTintList(ColorStateList.valueOf(r100));
    L13:
        RoundConstraintLayout r104 = (RoundConstraintLayout) findViewById(R.id.control_container);
        if (r104 == null) goto L19;
        c29.a r105 = r104.getDelegate();
        if (r105 == null) goto L20;
        r105.a(getResources().getColor(R.color.larus_static_white));
        return;
    L20:
        return;
    }

    public final void a(CoroutineScope r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "data");
        AudioVisualizerOpt r102 = getVisualizer();
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    public VoiceMixInputPanel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        FrameLayout.inflate(r100, R.layout.larus_layout_voice_mix_input_panel, this);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.audio_visualizer_group);
        if (r103 == null) goto L14;
        AudioVisualizerOpt r104 = new AudioVisualizerOpt(getContext());
        this.f300396a = r104;
        r104.setPaintColor(getResources().getColor(v19.c.b(R.attr.larus_primary_50, r103.getContext(), R.color.larus_primary_50)));
        AudioVisualizerOpt r105 = this.f300396a;
        AudioVisualizerOpt r106 = null;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
        r105 = null;
    L8:
        r105.getClass();
        r105.f328673n = RangesKt.coerceAtLeast(5, 0);
        r105.f328674o = RangesKt.coerceAtLeast(5, 0);
        AudioVisualizerOpt r107 = this.f300396a;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("visualizer");
    L12:
        r103.addView(r106, new FrameLayout.LayoutParams(-1, -1));
        return;
    L11:
        r106 = r107;
        goto L12
    }

    public /* synthetic */ VoiceMixInputPanel(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
