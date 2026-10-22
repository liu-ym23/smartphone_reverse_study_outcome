package com.ss.android.lark.flow.chat.message.block.audio;

import android.content.Context;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.chat.base.view.vo.message.AudioContentVO;
import com.ss.android.lark.flow.chat.databinding.FlowChatAudioPlayBarBinding;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.PlayControlBar;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002BCB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ8\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010!\u001a\u00020\bJ\u0017\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010$J\u0015\u0010%\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010$J*\u0010&\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0016\u0010'\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\bH\u0002J2\u0010*\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002J\b\u00100\u001a\u00020\u0019H\u0002J\u0012\u00101\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u000103H\u0017J\u0010\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u00020\bH\u0016J\b\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u00020-H\u0016J\u0010\u00109\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010:\u001a\u00020\u0019H\u0016J\b\u0010;\u001a\u00020\u0019H\u0016J\b\u0010<\u001a\u00020\u0019H\u0016J\b\u0010=\u001a\u00020\u0019H\u0016J\b\u0010>\u001a\u00020\u0019H\u0016J\b\u0010?\u001a\u00020\u0019H\u0016J\u0012\u0010@\u001a\u00020\u00192\b\u0010A\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/suite/lark/platform/component/widget_biz_chatkeyboard/widget/IAudioView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/ss/android/lark/flow/chat/databinding/FlowChatAudioPlayBarBinding;", "hasSetupWaveDragListener", "", "audioPlayBarListener", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar$OnAudioPlayBarListener;", "getAudioPlayBarListener", "()Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar$OnAudioPlayBarListener;", "setAudioPlayBarListener", "(Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioPlayBar$OnAudioPlayBarListener;)V", "audioViewListener", "Lcom/suite/lark/platform/component/widget_biz_chatkeyboard/widget/IAudioView$IAudioViewListener;", "primaryColor", "update", "", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "Lcom/ss/android/lark/blueprint/ICell;", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "Lcom/ss/android/lark/chat/base/view/vo/message/AudioContentVO;", "block", "Lcom/ss/android/lark/flow/chat/message/block/audio/FlowAudioContentBlock;", "data", "color", "setMatchTextWidthPx", "textWidthPx", "(Ljava/lang/Integer;)V", "updateMatchTextWidth", "updatePlayCb", "updateDuration", "updateDurationText", "durationInMs", "updateWave", "updateProgress", "progress", "", "updateViewStatusPlaying", "updateViewStatusPaused", "updateViewStatusStopped", "setDelegate", "mDelegate", "Lcom/suite/lark/platform/component/widget_biz_chatkeyboard/widget/PlayControlBar$PlayControlBarDelegate;", "setDuration", "duration", "getDurationText", "", "getProgress", "setProgress", "toggle", "togglePlay", "startPlay", "stopPlay", "pausePlay", "resumePlay", "setListener", "listener", "Companion", "OnAudioPlayBarListener", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowAudioPlayBar extends ConstraintLayout implements com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<String, byte[]> f422376e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlowChatAudioPlayBarBinding f422377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f422378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f422379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f422380d;

    public static final class a {
    }

    public interface b extends FlowAudioWaveView.b {
        void b(CheckBox r100);
    }

    public FlowAudioPlayBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowAudioPlayBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public float getProgress() {
        return 0.3f;
    }

    @Deprecated(message = "FlowAudioPlayBar 使用 OnAudioPlayBarListener 向外发送事件")
    public void setDelegate(PlayControlBar.a r100) {
    }

    public void setListener(com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a.InterfaceC5531a r100) {
    }

    static {
        f422376e = new LruCache(30);
    }

    public final void S5() {
        Log.d("FlowAudioPlayBar", "startPlay");
        this.f422377a.f422104b.setChecked(true);
        FlowAudioWaveView r100 = this.f422377a.f422106d;
        r100.getClass();
        r100.f422393m = FlowAudioWaveView.PlayState.PLAYING;
        r100.f422392l = r100.f422391k;
        r100.invalidate();
    }

    public String getDurationText() {
        return this.f422377a.f422105c.getText().toString();
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void pausePlay() {
        this.f422377a.f422104b.setChecked(false);
        FlowAudioWaveView r100 = this.f422377a.f422106d;
        r100.getClass();
        r100.f422393m = FlowAudioWaveView.PlayState.PAUSED;
        r100.f422392l = r100.f422391k;
        r100.invalidate();
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void stopPlay() {
        this.f422377a.f422104b.setChecked(false);
        FlowAudioWaveView r100 = this.f422377a.f422106d;
        r100.getClass();
        r100.f422393m = FlowAudioWaveView.PlayState.STOPPED;
        r100.f422392l = 0.0f;
        r100.invalidate();
        this.f422377a.f422106d.setProgress(0.0f);
    }

    public final b getAudioPlayBarListener() {
        return this.f422379c;
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void resumePlay() {
        S5();
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public final void startPlay() {
        S5();
    }

    private final void setMatchTextWidthPx(Integer r100) {
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == null) goto L7;
        int r102 = r100.intValue();
    L8:
        if (r102 > 0) goto L12;
        r102 = -2;
    L12:
        if (r101.width == r102) goto L15;
        r101.width = r102;
        setLayoutParams(r101);
        requestLayout();
        return;
    L15:
        return;
    L7:
        r102 = 0;
        goto L8
    }

    public final void R5(int r100) {
        this.f422377a.f422105c.setText(String.valueOf(r100 / 1000) + Typography.doublePrime);
        this.f422377a.f422105c.setTextColor(UDColorUtils.getColor(getContext(), this.f422380d));
    }

    public final void setAudioPlayBarListener(b r100) {
        this.f422379c = r100;
    }

    public void setDuration(int r100) {
        R5(r100);
    }

    @Override // com.suite.lark.platform.component.widget_biz_chatkeyboard.widget.a
    public void setProgress(float r100) {
        this.f422377a.f422106d.setProgress(r100);
    }

    public FlowAudioPlayBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f422380d = R.color.flow_ud_primary_80;
        LayoutInflater.from(getContext()).inflate(R.layout.flow_chat_audio_play_bar, this, true);
        int r103 = R.id.audio_bar_play_cb;
        CheckBox r104 = (CheckBox) ViewBindings.findChildViewById(this, R.id.audio_bar_play_cb);
        if (r104 == null) goto L11;
        r103 = R.id.audio_duration_tv;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.audio_duration_tv);
        if (r105 == null) goto L11;
        r103 = R.id.audio_wave_view;
        FlowAudioWaveView r106 = (FlowAudioWaveView) ViewBindings.findChildViewById(this, R.id.audio_wave_view);
        if (r106 == null) goto L11;
        this.f422377a = new FlowChatAudioPlayBarBinding(this, r104, r105, r106);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ FlowAudioPlayBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void update(m<y6b.a<AudioContentVO>> r100, FlowAudioContentBlock r101, y6b.a<AudioContentVO> r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "block");
        Intrinsics.checkNotNullParameter(r102, "data");
        setTag(R.id.audio_message_id_tag, r102.getId());
        this.f422380d = r103;
        this.f422377a.f422104b.setButtonDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.flow_audio_play_bt_selector, UDColorUtils.getColor(getContext(), this.f422380d)));
        this.f422377a.f422104b.setBackground(null);
        this.f422377a.f422104b.setOnClickListener(new com.ss.android.lark.flow.chat.message.block.audio.b(this));
        R5(r102.b().g());
        String r104 = r102.getId();
        FlowAudioWaveView r105 = this.f422377a.f422106d;
        r105.setBarSpacingPx(UIUtils.dp2px(r105.getContext(), 2.0f));
        r105.setBarWidthPx(UIUtils.dp2px(r105.getContext(), 2.5f));
        r105.setCornerRadiusPx(UIUtils.dp2px(r105.getContext(), 5.0f));
        r105.setMinBarHeightPx(UIUtils.dp2px(r105.getContext(), 3.5f));
        r105.setPlayedColor(UIUtils.getColor(r105.getContext(), this.f422380d));
        r105.setUnPlayedColor(UIUtils.getColor(r105.getContext(), this.f422380d) & 1275068415);
        byte[] r106 = r102.b().f411852v;
        boolean r107 = false;
        if (r106 != null) goto L5;
    L11:
        if (r107 == false) goto L13;
        f422376e.put(r104, (byte[]) r106.clone());
    L14:
        r105.setWaveformBytes(r106);
        if (this.f422378b == true) goto L17;
        this.f422378b = true;
        r105.setOnProgressDragListener(new c(this));
    L17:
        r105.setOnLongClickListener(new d(r100, r101, r102));
        return;
    L13:
        r106 = f422376e.get(r104);
        goto L14
    L5:
        if (r106.length != 0) goto L7;
        boolean r108 = true;
    L9:
        if ((!r108) != true) goto L11;
        r107 = true;
        goto L11
    L7:
        r108 = false;
        goto L9
    }
}
