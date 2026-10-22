package com.larus.bmhome.view;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.chat.common.databinding.LarusLayoutTextMessageActionButtonBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.api.IFlowChatThemeConfigProvider;
import com.larus.platform.api.IFlowThemeConfigProvider;
import com.larus.platform.api.ThemeColorKey;
import com.larus.platform.api.ThemeConfigScene;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.LottieAdapterView;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/view/TextAnswerSingleActionButton;", "Lcom/larus/bmhome/view/BaseTextAnswerActionButton;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionButtonBinding;", "getBinding", "()Lcom/larus/chat/common/databinding/LarusLayoutTextMessageActionButtonBinding;", "binding$delegate", "Lkotlin/Lazy;", "lastAction", "Lcom/larus/bmhome/view/actionbar/IAction;", "config", "", "action", "useSubscribedColor", "", "compact", "configLottieAction", "Lcom/larus/bmhome/view/actionbar/LottieAction;", "configImageAction", "Lcom/larus/bmhome/view/actionbar/ImageAction;", "getRoot", "Landroid/view/ViewGroup;", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextAnswerSingleActionButton extends BaseTextAnswerActionButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f315604d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f315605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public rs8.g f315606c;

    public static final class a {
    }

    static {
    }

    public TextAnswerSingleActionButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TextAnswerSingleActionButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public ViewGroup getRoot() {
        return this;
    }

    private final LarusLayoutTextMessageActionButtonBinding getBinding() {
        return (LarusLayoutTextMessageActionButtonBinding) this.f315605b.getValue();
    }

    public TextAnswerSingleActionButton(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setGravity(17);
        this.f315605b = LazyKt.lazy(new m4(r100, this));
    }

    @Override // com.larus.bmhome.view.BaseTextAnswerActionButton, com.larus.bmhome.view.f2
    public final void a(final rs8.g r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "action");
        super.a(r110, r111, r112);
        boolean r100 = r110 instanceof rs8.j;
        if (r100 == false) goto L5;
    L7:
        LarusLayoutTextMessageActionButtonBinding r101 = getBinding();
        if (r112 == false) goto L10;
        int r113 = i5.j0();
    L11:
        r101.f324046e.setPadding(r113, r113, r113, r113);
        boolean r102 = true;
        int r103 = 0;
        if (StringsKt.isBlank(r110.getDescription()) == false) goto L14;
        com.larus.utils.e1.o(r101.f324045d);
    L34:
        if (r100 == false) goto L73;
        rs8.j r104 = (rs8.j) r110;
        LarusLayoutTextMessageActionButtonBinding r105 = getBinding();
        r105.f324046e.setVisibility(0);
        r105.f324044c.cancelAnimation();
        r105.f324044c.setVisibility(8);
        SimpleDraweeView r106 = r105.f324043b;
        if (r104.f539119d != null) goto L39;
        r102 = false;
    L39:
        if (r102 == false) goto L41;
        int r107 = 0;
    L42:
        r106.setVisibility(r107);
        SimpleDraweeView r108 = r105.f324047f;
        if (com.larus.utils.o0.d(r104.f539120e) == true) goto L46;
        r103 = 8;
    L46:
        r108.setVisibility(r103);
        r105.f324043b.setEnabled(r104.f539124i);
        r105.f324043b.setSelected(r104.f539123h);
        r105.f324043b.setRotation(r104.f539121f);
        boolean r114 = Intrinsics.areEqual(r104.f539116a, "fork_conv");
        if (r114 == false) goto L49;
        int r109 = i5.A();
    L50:
        SimpleDraweeView r115 = r105.f324043b;
        ViewGroup.LayoutParams r116 = r115.getLayoutParams();
        r116.width = r109;
        r116.height = r109;
        r115.setLayoutParams(r116);
        SimpleDraweeView r117 = r105.f324043b;
        if (r114 == false) goto L53;
        ImageView.ScaleType r118 = ImageView.ScaleType.FIT_CENTER;
    L54:
        r117.setScaleType(r118);
        Drawable r119 = r104.f539119d;
        if (r119 == null) goto L62;
        r105.f324043b.setImageDrawable(r119);
        ColorFilter r120 = b(r111);
        if (r120 == null) goto L59;
        r105.f324043b.setColorFilter(r120);
    L59:
        IFlowThemeConfigProvider r121 = (IFlowThemeConfigProvider) ServiceManager.get().getService(IFlowThemeConfigProvider.class);
        if (r121 == null) goto L62;
        ThemeColorKey r122 = ThemeColorKey.MESSAGE_ANSWER_ACTION_COLOR;
        ThemeConfigScene r123 = ThemeConfigScene.CHAT;
        AdaptThemeFeatureKey r124 = AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION;
        boolean r125 = v19.h.f552477a;
        r121.g(r119, r122, r123, r124, Boolean.valueOf(v19.h.b(getContext())));
    L62:
        String r126 = r104.f539120e;
        if (r126 == null) goto L68;
        ImageLoaderKt.y(r105.f324047f, r126, "text_message_action_bar", new o4(), 4);
        ColorFilter r127 = b(r111);
        if (r127 == null) goto L68;
        r105.f324047f.setColorFilter(r127);
    L68:
        if (r104.f539124i == false) goto L70;
        float r128 = 1.0f;
    L71:
        setAlpha(r128);
    L94:
        com.larus.utils.e1.d(this, new n4(this, r110));
        this.f315606c = r110;
        return;
    L70:
        r128 = 0.3f;
        goto L71
    L53:
        r118 = ImageView.ScaleType.CENTER_INSIDE;
        goto L54
    L49:
        r109 = i5.C();
        goto L50
    L41:
        r107 = 8;
        goto L42
    L73:
        if ((r110 instanceof rs8.n) == false) goto L94;
        rs8.n r129 = (rs8.n) r110;
        LarusLayoutTextMessageActionButtonBinding r130 = getBinding();
        rs8.g r131 = this.f315606c;
        if ((r131 instanceof rs8.n) == false) goto L81;
        String r132 = r129.f539138e;
        Intrinsics.checkNotNull(r131, "null cannot be cast to non-null type com.larus.bmhome.view.actionbar.LottieAction");
        if (Intrinsics.areEqual(r132, ((rs8.n) r131).f539138e) == false) goto L81;
        if (r130.f324044c.isAnimating() == false) goto L81;
        FLogger.f375446a.i("TextAnswerSingleActionButton", "skip duplicate lottie animation");
    L81:
        r130.f324046e.setVisibility(0);
        r130.f324044c.setVisibility(0);
        r130.f324043b.setVisibility(8);
        r130.f324047f.setVisibility(8);
        r130.f324044c.setImageAssetsFolder(r129.f539137d);
        r130.f324044c.setRepeatMode(r129.f539140g);
        r130.f324044c.setRepeatCount(r129.f539139f);
        com.larus.platform.service.n1.f365777a.a(r130.f324044c);
        LottieAdapterView r133 = r130.f324044c;
        if (r133.isAttachedToWindow() == false) goto L93;
        FLogger.f375446a.i("TextAnswerSingleActionButton", "play lottie animation");
        r130.f324044c.setAnimation(r129.f539138e);
        if (r111 == false) goto L86;
        setLottieValueCallbackForSubscriber(r130.f324044c);
    L86:
        ColorFilter r134 = b(r111);
        if (r134 == null) goto L89;
        r130.f324044c.setColorFilter(r134);
    L89:
        IFlowChatThemeConfigProvider r135 = (IFlowChatThemeConfigProvider) ServiceManager.get().getService(IFlowChatThemeConfigProvider.class);
        if (r135 == null) goto L92;
        r135.e(new p4(this, r130), AdaptThemeFeatureKey.MESSAGE_ANSWER_ACTION_LOTTIE);
    L92:
        r130.f324044c.playAnimation();
        goto L94
    L93:
        r133.addOnAttachStateChangeListener(new q4(r133, r130, r129, r111, this));
        goto L94
    L14:
        com.larus.utils.e1.x(r101.f324045d);
        r101.f324045d.setText(r110.getDescription());
        ActionStyle r136 = r110.getStyle();
        Intrinsics.checkNotNullParameter(r136, "<this>");
        ActionStyle r137 = ActionStyle.HIGHLIGHT;
        if (r136 != r137) goto L17;
    L20:
        boolean r138 = true;
    L22:
        if (r138 == false) goto L28;
        AppCompatTextView r139 = r101.f324045d;
        r139.setTextColor(ContextCompat.getColor(r139.getContext(), R.color.larus_static_white));
        r139.setTextSize(0, i5.m());
        if (r110.getStyle() != r137) goto L26;
        Drawable r140 = ContextCompat.getDrawable(r139.getContext(), R.drawable.larus_highlight_switch_icon);
    L27:
        r139.setCompoundDrawablesWithIntrinsicBounds(null, null, r140, null);
        r139.setCompoundDrawablePadding(i5.z());
    L32:
        Intrinsics.checkNotNull(r139);
        goto L34
    L26:
        r140 = ContextCompat.getDrawable(r139.getContext(), R.drawable.larus_highlight_switch_icon_left);
        goto L27
    L28:
        r139 = r101.f324045d;
        Integer r141 = c(r111);
        if (r141 == null) goto L31;
        r139.setTextColor(r141.intValue());
    L31:
        r139.setTextSize(0, i5.q());
        r139.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        goto L32
    L17:
        if (r136 == ActionStyle.HIGHLIGHT_WITH_LEFT_ICON) goto L20;
        r138 = false;
        goto L22
    L10:
        r113 = i5.n0();
        goto L11
    L5:
        if ((r110 instanceof rs8.n) == true) goto L7;
    }

    public /* synthetic */ TextAnswerSingleActionButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
