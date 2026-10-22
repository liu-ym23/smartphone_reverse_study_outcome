package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.platform.service.o;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001QB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0002J>\u0010%\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eJ\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\u0016\u0010+\u001a\u00020\u00102\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-J\u0016\u0010/\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001001H\u0016J\u0018\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020.2\b\b\u0002\u00104\u001a\u00020\u0016J$\u00105\u001a\u00020\u00102\f\u00106\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u00107\u001a\u0002082\u0006\u00103\u001a\u00020.J\u0006\u00109\u001a\u00020\u0010J\u0018\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\u0016H\u0002J\u0006\u0010=\u001a\u00020\u0010J\u000e\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020@J\u0016\u0010A\u001a\u00020\u00102\u0006\u00103\u001a\u00020.2\u0006\u0010B\u001a\u00020\bJ\u0014\u0010C\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020.0-J\u0010\u0010D\u001a\u00020\u00102\b\u0010E\u001a\u0004\u0018\u00010FJ \u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u000fH\u0002J\f\u0010K\u001a\u00020\u0010*\u00020LH\u0002J\n\u0010M\u001a\u0004\u0018\u00010NH\u0016J\n\u0010O\u001a\u0004\u0018\u00010PH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006R"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceEditArea;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoicePlayButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/voice_setting/voice/mix/ILayoutVoiceEditAreaBinding;", "pitchChangeAction", "Lkotlin/Function1;", "", "", "speechRateChangeAction", "selectVoiceMode", "Ljava/lang/Integer;", "renderingItemCount", "defaultExpandMixVoiceView", "", "defaultCollapsing", "getDefaultCollapsing", "()Z", "setDefaultCollapsing", "(Z)V", "voiceMixView", "Lcom/larus/voice_setting/voice/mix/VoiceMixedView;", "getVoiceMixView", "()Lcom/larus/voice_setting/voice/mix/VoiceMixedView;", "voiceSingleView", "Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "getVoiceSingleView", "()Lcom/larus/voice_setting/voice/mix/VoiceSingleView;", "initViewBindingByMode", "initViews", "processVoiceAudition", "update", "Lcom/larus/voice_setting/voice/mix/res/VoiceAuditionUpdate;", "hidePitchAndRate", "initPitchAndRate", "initMixViewByVoiceList", "voiceList", "", "Lcom/larus/im/bean/bot/MixVoice;", "delegatePlayMixVoice", "callback", "Lkotlin/Function0;", "onVoiceAdd", "voice", "byReset", "onVoiceRemove", "mixVoiceList", "from", "", "onVoiceClear", "applyCheckSingleVoice", "count", "defaultCollapse", "expandDefaultCollapsing", "refreshPitchAndRate", "data", "Lcom/larus/voice_setting/voice/editvoice/VoicePitchAndRate;", "onVoiceUpdate", "index", "onVoiceListUpdate", "onSingleVoiceSelected", "speakVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "reportVoiceEditResult", "scene", "voicePith", "voiceSpeed", "updateVoiceEmptyText", "Landroid/view/View;", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceEditArea extends ConstraintLayout implements com.larus.voice_setting.voice.mix.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f376899h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v2a.a f376900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Float, Unit> f376901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Float, Unit> f376902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f376903d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f376904e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f376905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f376906g;

    public static final class a {
    }

    static {
    }

    public VoiceEditArea(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceEditArea(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void T5() {
        v2a.a r100 = this.f376900a;
        if (r100 == null) goto L7;
        ConstraintLayout r101 = r100.a();
        if (r101 == null) goto L7;
        r101.setVisibility(8);
    L7:
        v2a.a r102 = this.f376900a;
        if (r102 == null) goto L12;
        View r103 = r102.f();
        if (r103 == null) goto L12;
        r103.setVisibility(0);
    L12:
        v2a.a r104 = this.f376900a;
        if (r104 == null) goto L18;
        VoiceMixedView r105 = r104.d();
        if (r105 == null) goto L19;
        r105.f376946k.clear();
        r105.removeAllViews();
        return;
    L19:
        return;
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public ImageView getPlayIcon() {
        v2a.a r100 = this.f376900a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPlayIcon();
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public LottieAdapterView getPlayLottieView() {
        v2a.a r100 = this.f376900a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    public final VoiceMixedView getVoiceMixView() {
        v2a.a r100 = this.f376900a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    public final VoiceSingleView getVoiceSingleView() {
        v2a.a r100 = this.f376900a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.k();
    }

    public final boolean getDefaultCollapsing() {
        return this.f376906g;
    }

    public final void setDefaultCollapsing(boolean r100) {
        this.f376906g = r100;
    }

    public final void S5(int r100, boolean r101) {
        if (r100 <= 1) goto L9;
        v2a.a r102 = this.f376900a;
        if (r102 == null) goto L15;
        View r103 = r102.e();
        if (r103 == null) goto L15;
        e1.x(r103);
    L15:
        if (r100 <= 0) goto L21;
        v2a.a r104 = this.f376900a;
        if (r104 == null) goto L26;
        View r105 = r104.f();
        if (r105 == null) goto L26;
        r105.setVisibility(8);
    L26:
        if (r100 <= 0) goto L31;
        if (r101 == true) goto L31;
        v2a.a r106 = this.f376900a;
        if (r106 == null) goto L35;
        r106.a().setVisibility(0);
        return;
    L35:
        return;
    L31:
        v2a.a r107 = this.f376900a;
        if (r107 == null) goto L37;
        r107.a().setVisibility(8);
        return;
    L37:
        return;
    L21:
        v2a.a r108 = this.f376900a;
        if (r108 == null) goto L26;
        View r109 = r108.f();
        if (r109 == null) goto L26;
        r109.setVisibility(0);
        goto L26
    L9:
        v2a.a r110 = this.f376900a;
        if (r110 == null) goto L15;
        View r111 = r110.e();
        if (r111 == null) goto L15;
        e1.o(r111);
        goto L15
    }

    public VoiceEditArea(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ VoiceEditArea(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static final void R5(VoiceEditArea r100, String r101, float r102, float r103) {
        r100.getClass();
        JSONObject r104 = new JSONObject();
        r104.put("edit_scene", r101);
        r104.put("voice_pitch", Float.valueOf(r102));
        r104.put("voice_speed", Float.valueOf(r103));
        o.f365780a.reportEvent("voice_edit_result", r104);
    }
}
