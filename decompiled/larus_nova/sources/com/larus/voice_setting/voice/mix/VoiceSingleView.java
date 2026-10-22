package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusItemVoiceMixSingleNewBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v2a.d;
import v2a.e;
import v2a.k0;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001cH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0012H\u0016J\b\u0010$\u001a\u00020\u0012H\u0016J\b\u0010%\u001a\u0004\u0018\u00010&J\b\u0010'\u001a\u0004\u0018\u00010(J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoiceMixSingleView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusItemVoiceMixSingleNewBinding;", "data", "Lcom/larus/im/bean/bot/MixVoice;", "init", "", "listener", "Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "getListener", "()Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;", "setListener", "(Lcom/larus/voice_setting/voice/mix/IVoiceMixItemClickListener;)V", "bindData", MapController.ITEM_LAYER_TAG, "playing", "", "updatePlayStatus", "isPlaying", "getData", "updateVoice", "voice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "resumePlayLottie", "cancelPlayLottie", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottie", "Lcom/lynx/lottieadapter/LottieAdapterView;", "getExpandIconView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceSingleView extends ConstraintLayout implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f376954d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusItemVoiceMixSingleNewBinding f376955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MixVoice f376956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f376957c;

    @Override // v2a.c
    public final void V2() {
        S5(false);
    }

    @Override // v2a.c
    public final void X0() {
        S5(true);
    }

    @Override // v2a.e
    public View getExpandIconView() {
        LarusItemVoiceMixSingleNewBinding r100 = this.f376955a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f376126b;
    }

    public final ImageView getPlayIcon() {
        LarusItemVoiceMixSingleNewBinding r100 = this.f376955a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f376127c;
    }

    public final LottieAdapterView getPlayLottie() {
        LarusItemVoiceMixSingleNewBinding r100 = this.f376955a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f376128d;
    }

    public final void R5() {
        LayoutInflater.from(getContext()).inflate(R.layout.larus_item_voice_mix_single_new, this);
        int r100 = R.id.expand_voice_icon;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.expand_voice_icon);
        if (r101 == null) goto L17;
        r100 = R.id.play_icon;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.play_icon);
        if (r102 == null) goto L17;
        r100 = R.id.play_lottie;
        LottieAdapterView r103 = (LottieAdapterView) ViewBindings.findChildViewById(this, R.id.play_lottie);
        if (r103 == null) goto L17;
        r100 = R.id.voice_icon;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.voice_icon)) == null) goto L17;
        r100 = R.id.voice_remove;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.voice_remove);
        if (r104 == null) goto L17;
        r100 = R.id.voice_user_name;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.voice_user_name);
        if (r105 == null) goto L17;
        this.f376955a = new LarusItemVoiceMixSingleNewBinding(this, r101, r102, r103, r104, r105);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r100)));
    }

    @Override // v2a.c
    public MixVoice getData() {
        return this.f376956b;
    }

    public d getListener() {
        return this.f376957c;
    }

    public VoiceSingleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5();
    }

    public final void S5(boolean r100) {
        LarusItemVoiceMixSingleNewBinding r101 = this.f376955a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.f376127c.setVisibility(8);
        r101.f376128d.setVisibility(0);
        r101.f376128d.cancelAnimation();
        r101.f376128d.setAnimation("lottie/text_msg_voice_playing.json");
        r101.f376128d.playAnimation();
        return;
    L7:
        r101.f376127c.setVisibility(0);
        r101.f376128d.setVisibility(8);
        r101.f376128d.cancelAnimation();
    }

    @Override // v2a.c
    public final void m2(SpeakerVoice r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        MixVoice r101 = this.f376956b;
        if (r101 == null) goto L7;
        r101.setVoiceItem(r100);
    L7:
        LarusItemVoiceMixSingleNewBinding r102 = this.f376955a;
        if (r102 == null) goto L13;
        AppCompatTextView r103 = r102.f376130f;
        if (r103 == null) goto L14;
        r103.setText(r100.getName());
        return;
    L14:
        return;
    }

    public void setListener(d r100) {
        this.f376957c = r100;
    }

    public VoiceSingleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5();
    }

    @Override // v2a.c
    public final void p1(final MixVoice r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        SpeakerVoice r102 = r100.getVoiceItem();
        if (r102 != null) goto L5;
        return;
    L5:
        this.f376956b = r100;
        LarusItemVoiceMixSingleNewBinding r103 = this.f376955a;
        if (r103 == null) goto L9;
        r103.f376130f.setText(r102.getName());
        e1.d(r103.f376129e, new k0(this, r100));
        return;
    }

    public VoiceSingleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5();
    }
}
