package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.nova.R;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0005¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0005J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0004J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0004J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0004¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/view/BaseTextAnswerActionButton;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/view/ITextAnswerActionButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "config", "", "action", "Lcom/larus/bmhome/view/actionbar/IAction;", "useSubscribedColor", "", "compact", "getTextColorForSubscriber", "(Z)Ljava/lang/Integer;", "getTintColorForSubscriber", "getColorFilterForSubscriber", "Landroid/graphics/ColorFilter;", "setLottieValueCallbackForSubscriber", "lottieView", "Lcom/lynx/lottieadapter/LottieAdapterView;", "setLottieValueCallback", "color", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseTextAnswerActionButton extends LinearLayout implements f2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f315380a = 0;

    public BaseTextAnswerActionButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseTextAnswerActionButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.view.f2
    public abstract /* synthetic */ ViewGroup getRoot();

    public final ColorFilter b(boolean r100) {
        if (r100 == true) goto L6;
        return null;
    L6:
        return new PorterDuffColorFilter(ContextCompat.getColor(getContext(), v19.c.b(R.attr.additional_purple_premium_1, getContext(), R.color.additional_purple_premium_1)), PorterDuff.Mode.SRC_ATOP);
    }

    public final Integer c(boolean r100) {
        if (r100 == false) goto L5;
        return Integer.valueOf(ContextCompat.getColor(getContext(), v19.c.b(R.attr.additional_purple_premium_1, getContext(), R.color.additional_purple_premium_1)));
    L5:
        return Integer.valueOf(ContextCompat.getColor(getContext(), v19.c.b(R.attr.larus_primary_50, getContext(), R.color.larus_primary_50)));
    }

    public final void setLottieValueCallbackForSubscriber(LottieAdapterView r100) {
        Intrinsics.checkNotNullParameter(r100, "lottieView");
        int r101 = ContextCompat.getColor(getContext(), v19.c.b(R.attr.additional_purple_premium_1, getContext(), R.color.additional_purple_premium_1));
        Intrinsics.checkNotNullParameter(r100, "lottieView");
        r100.addValueCallback(new d6a.a(new String[]{"**"}), c6a.d.C, new a(r101));
    }

    public BaseTextAnswerActionButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // com.larus.bmhome.view.f2
    public void a(rs8.g r100, boolean r101, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "action");
        setId(r100.getId());
        ViewGroup.MarginLayoutParams r102 = null;
        if (r101 == true) goto L5;
        ActionStyle r103 = r100.getStyle();
        Intrinsics.checkNotNullParameter(r103, "<this>");
        if (r103 != ActionStyle.HIGHLIGHT) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L19;
        setBackgroundResource(R.drawable.larus_bg_sug_bar_normal_highlight);
    L22:
        IFlowThemeConfigProvider r105 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r105 == null) goto L26;
        Drawable r106 = getBackground();
        ThemeColorKey r107 = ThemeColorKey.MESSAGE_ANSWER_ACTION_BACKGROUND_COLOR;
        ThemeConfigScene r108 = ThemeConfigScene.CHAT;
        AdaptThemeFeatureKey r109 = AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION_BACKGROUND;
        boolean r111 = v19.h.f552477a;
        r105.g(r106, r107, r108, r109, Boolean.valueOf(v19.h.b(getContext())));
    L26:
        if (r100.getId() == R.id.msg_action_re_tts) goto L28;
    L30:
        ViewGroup.LayoutParams r112 = getLayoutParams();
        if ((r112 instanceof ViewGroup.MarginLayoutParams) == false) goto L33;
        r102 = (ViewGroup.MarginLayoutParams) r112;
    L33:
        if (r102 != null) goto L36;
        r102 = generateDefaultLayoutParams();
    L36:
        if (r100.b() != MessageActionBarAlign.END) goto L38;
        r102.setMarginEnd(i5.r0());
    L40:
        if (StringsKt.isBlank(r100.getDescription()) == true) goto L42;
    L52:
        r102.width = -2;
        r102.height = -2;
    L53:
        setLayoutParams(r102);
        setContentDescription(r100.d());
        return;
    L42:
        if ((r100 instanceof rs8.o) == true) goto L52;
        if (r110 == false) goto L46;
        int r113 = 34;
    L47:
        r102.width = c7.b(r113);
        if (r110 == false) goto L50;
        int r114 = 34;
    L51:
        r102.height = c7.b(r114);
        goto L53
    L50:
        r114 = 36;
        goto L51
    L46:
        r113 = 36;
        goto L47
    L38:
        r102.setMarginStart(i5.r0());
        goto L40
    L28:
        if (AudioServiceDelegate.f288288a.g() == false) goto L30;
        setAlpha(0.3f);
        goto L30
    L19:
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L21;
        setBackgroundResource(R.drawable.larus_bg_sug_bar_normal_enterprise);
        goto L22
    L21:
        setBackgroundResource(v19.c.b(R.attr.larus_bg_sug_bar_normal, null, R.drawable.larus_bg_sug_bar_normal));
        goto L22
    L12:
        if (r103 == ActionStyle.HIGHLIGHT_WITH_LEFT_ICON) goto L15;
        r104 = false;
        goto L16
    L5:
        if (com.larus.platform.service.n0.f365775a.b() == false) goto L7;
        int r115 = R.drawable.larus_bg_sug_bar_subscribed_enterprise;
    L8:
        setBackgroundResource(r115);
        goto L22
    L7:
        r115 = v19.c.b(R.attr.larus_bg_sug_bar_subscribed, null, R.drawable.larus_bg_sug_bar_subscribed);
        goto L8
    }

    public /* synthetic */ BaseTextAnswerActionButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
