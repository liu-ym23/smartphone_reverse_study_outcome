package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.larus.voice_setting.impl.databinding.LarusLayoutSingleVoiceBarBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0016\u0010\u001e\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120 H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/larus/voice_setting/voice/mix/SingleVoiceBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoicePlayButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusLayoutSingleVoiceBarBinding;", "voiceSingleView", "Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "getVoiceSingleView", "()Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "init", "", "expandClickListener", "Landroid/view/View$OnClickListener;", "getExpandIconView", "Landroid/view/View;", "onSingleVoiceSelected", "speakVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "delegatePlayMixVoice", "callback", "Lkotlin/Function0;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleVoiceBar extends ConstraintLayout implements com.larus.voice_setting.voice.mix.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f376897b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutSingleVoiceBarBinding f376898a;

    public static final class a {
    }

    static {
    }

    public SingleVoiceBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SingleVoiceBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final View getExpandIconView() {
        LarusLayoutSingleVoiceBarBinding r100 = this.f376898a;
        if (r100 == null) goto L7;
        VoiceSingleView r101 = r100.f376132b;
        if (r101 == null) goto L7;
        return r101.getExpandIconView();
    L7:
        return null;
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public ImageView getPlayIcon() {
        return this.f376898a.f376132b.getPlayIcon();
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public LottieAdapterView getPlayLottieView() {
        return this.f376898a.f376132b.getPlayLottie();
    }

    public final VoiceSingleView getVoiceSingleView() {
        return this.f376898a.f376132b;
    }

    public SingleVoiceBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_single_voice_bar, this);
        int r103 = R.id.single_view_content;
        VoiceSingleView r104 = (VoiceSingleView) ViewBindings.findChildViewById(this, R.id.single_view_content);
        if (r104 == null) goto L9;
        r103 = R.id.voice_empty;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.voice_empty);
        if (r105 == null) goto L9;
        this.f376898a = new LarusLayoutSingleVoiceBarBinding(this, r104, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ SingleVoiceBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
