package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.voice_setting.impl.databinding.LarusLayoutVoiceMixBarBinding;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.utils.g;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;
import v2a.p;
import v2a.q;
import v2a.r;
import v2a.s;
import v2a.u;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010)\u001a\u00020\u001a2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-J\u0018\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020,2\b\b\u0002\u00100\u001a\u00020!J\u001e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\r2\u0006\u0010/\u001a\u00020,2\u0006\u00103\u001a\u00020\bJ\u0006\u00104\u001a\u00020\u001aJ\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\b\u00108\u001a\u00020\u001aH\u0002J\b\u00109\u001a\u00020\u001aH\u0002J\b\u0010:\u001a\u00020\u001aH\u0003J\u000e\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0015J\b\u0010=\u001a\u00020>H\u0016J\b\u0010?\u001a\u00020@H\u0016J\u0016\u0010A\u001a\u00020\u001a2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u000e\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020ER\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0010j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR5\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001a0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006G"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceMixBar;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/voice_setting/voice/mix/IVoicePlayButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "loadedVoiceListId", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "nameByKey", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mTabBarState", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "bindToTabLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "binding", "Lcom/larus/voice_setting/impl/databinding/LarusLayoutVoiceMixBarBinding;", "voiceRemoveListener", "Lkotlin/Function0;", "", "getVoiceRemoveListener", "()Lkotlin/jvm/functions/Function0;", "setVoiceRemoveListener", "(Lkotlin/jvm/functions/Function0;)V", "collapseCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", BitableAnalytic.LinkSceneClickType.EXPAND, "getCollapseCallback", "()Lkotlin/jvm/functions/Function1;", "setCollapseCallback", "(Lkotlin/jvm/functions/Function1;)V", "initMixViewByVoiceList", "mixVoiceList", "Ljava/util/ArrayList;", "Lcom/larus/im/bean/bot/MixVoice;", "Lkotlin/collections/ArrayList;", "onVoiceAdd", "voice", "byReset", "onVoiceRemove", "from", "index", "onVoiceClear", "applyState", "applyVoiceCount", "applyTabBarState", "emptyState", "singleState", "mixState", "bindToAppbar", "bindToExpand", "getPlayIcon", "Landroid/widget/ImageView;", "getPlayLottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "delegatePlayMixVoice", "callback", "processVoiceAudition", "update", "Lcom/larus/voice_setting/voice/mix/res/VoiceAuditionUpdate;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixBar extends ConstraintLayout implements com.larus.voice_setting.voice.mix.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f376909h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet<String> f376910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f376911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppBarLayoutStateListener.State f376912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppBarLayout f376913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LarusLayoutVoiceMixBarBinding f376914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f376915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f376916g;

    public static final class a {
    }

    static {
    }

    public VoiceMixBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceMixBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void applyState() {
        if (this.f376912c != AppBarLayoutStateListener.State.COLLAPSED) goto L5;
    L11:
        View r100 = this.f376914e.f376158a;
        if (r100 == null) goto L14;
        r100.setBackgroundResource(c.b(R.attr.larus_bg_voice_edit_area, r100.getContext(), R.drawable.larus_bg_voice_edit_area));
    L14:
        e1.o(this.f376914e.f376159b);
        boolean r101 = true;
    L15:
        if (r101 == true) goto L17;
    L19:
        e1.q(this.f376914e.f376158a);
    L20:
        int r102 = this.f376910a.size();
        if (r102 == 0) goto L25;
        if (r102 == 1) goto L24;
        e1.q(this.f376914e.f376163f);
        e1.q(this.f376914e.f376160c);
        int r103 = this.f376910a.size();
        this.f376914e.f376164g.setText(getResources().getString(R.string.larus_mixed_sound) + '(' + r103 + ')');
        return;
    L24:
        e1.q(this.f376914e.f376163f);
        e1.x(this.f376914e.f376160c);
        this.f376914e.f376164g.setText(this.f376911b.get(CollectionsKt.firstOrNull(this.f376910a)));
        return;
    L25:
        e1.x(this.f376914e.f376163f);
        e1.d(this.f376914e.f376163f, new u());
        View r104 = this.f376914e.f376158a;
        if (r104 == null) goto L28;
        r104.setBackgroundResource(c.b(R.attr.larus_bg_voice_edit_area, r104.getContext(), R.drawable.larus_bg_voice_edit_area));
    L28:
        e1.o(this.f376914e.f376159b);
        return;
    L17:
        if (this.f376910a.size() <= 0) goto L19;
        e1.x(this.f376914e.f376158a);
        goto L20
    L5:
        if (this.f376910a.size() == 0) goto L11;
        View r105 = this.f376914e.f376158a;
        if (r105 == null) goto L10;
        r105.setBackgroundResource(c.b(R.attr.larus_bg_voice_edit_area_upper_half, r105.getContext(), R.drawable.larus_bg_voice_edit_area_upper_half));
    L10:
        r101 = false;
        goto L15
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public ImageView getPlayIcon() {
        return this.f376914e.f376161d;
    }

    @Override // com.larus.voice_setting.voice.mix.a
    public LottieAdapterView getPlayLottieView() {
        return this.f376914e.f376162e;
    }

    public final Function1<Boolean, Unit> getCollapseCallback() {
        return this.f376916g;
    }

    public final Function0<Unit> getVoiceRemoveListener() {
        return this.f376915f;
    }

    public final void setCollapseCallback(Function1<? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f376916g = r100;
    }

    public final void setVoiceRemoveListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f376915f = r100;
    }

    public final void R5(MixVoice r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "voice");
        if (r101 == false) goto L5;
        this.f376910a.clear();
    L5:
        SpeakerVoice r102 = r100.getVoiceItem();
        String r103 = "";
        if (r102 == null) goto L9;
        String r104 = r102.getId();
        if (r104 == null) goto L9;
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L13;
        return;
    L13:
        this.f376910a.add(r104);
        HashMap<String, String> r105 = this.f376911b;
        SpeakerVoice r106 = r100.getVoiceItem();
        if (r106 == null) goto L19;
        String r107 = r106.getName();
        if (r107 == null) goto L19;
        r103 = r107;
    L19:
        r105.put(r104, r103);
        applyState();
        return;
    L9:
        r104 = "";
        goto L11
    }

    public VoiceMixBar(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f376910a = new HashSet();
        this.f376911b = new HashMap();
        this.f376912c = AppBarLayoutStateListener.State.EXPANDED;
        LayoutInflater.from(r110).inflate(R.layout.larus_layout_voice_mix_bar, this);
        int r113 = R.id.divider;
        View r100 = ViewBindings.findChildViewById(this, R.id.divider);
        if (r100 == null) goto L21;
        r113 = R.id.expand_voice_icon;
        AppCompatImageView r114 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.expand_voice_icon);
        if (r114 == null) goto L21;
        r113 = R.id.play_icon;
        AppCompatImageView r115 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.play_icon);
        if (r115 == null) goto L21;
        r113 = R.id.play_lottie;
        LottieAdapterView r101 = (LottieAdapterView) ViewBindings.findChildViewById(this, R.id.play_lottie);
        if (r101 == null) goto L21;
        r113 = R.id.voice_empty;
        LinearLayout r102 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.voice_empty);
        if (r102 == null) goto L21;
        r113 = R.id.voice_icon;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.voice_icon)) == null) goto L21;
        r113 = R.id.voice_remove;
        AppCompatImageView r103 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.voice_remove);
        if (r103 == null) goto L21;
        r113 = R.id.voice_user_name;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.voice_user_name);
        if (r104 == null) goto L21;
        this.f376914e = new LarusLayoutVoiceMixBarBinding(this, r100, r114, r115, r101, r102, r103, r104);
        this.f376915f = new p();
        this.f376916g = new q();
        setBackgroundResource(c.b(R.attr.larus_bg_voice_edit_area, getContext(), R.drawable.larus_bg_voice_edit_area));
        e1.d(r114, new r(this));
        e1.d(r103, new s(this));
        int r116 = g.f377028a;
        g.a(r115, i5.h());
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ VoiceMixBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
