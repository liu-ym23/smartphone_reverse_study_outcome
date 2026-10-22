package com.larus.profile.impl.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.account.base.api.ILoginService;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.BotOnBoarding;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotStatistic;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.profile.impl.databinding.LarusViewBotProfileBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.ss.android.lark.thirdshare.base.export.ShareAnswerType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\rH\u0002J\u0014\u0010\u0011\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/profile/impl/view/BotProfileView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/profile/impl/databinding/LarusViewBotProfileBinding;", "bindData", "", "data", "Lcom/larus/profile/api/bean/ProfileBot;", "updateReviewTagStartConstraint", "setAddItemClick", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "getSubtitle", "", "bot", "bindPrivateData", "privateStatus", "bindHeatData", "botStatus", "Lcom/larus/im/bean/bot/BotStatistic;", "isTagVisible", "visible", "", "isCreator", "creatorId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotProfileView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f366873b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusViewBotProfileBinding f366874a;

    public BotProfileView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BotProfileView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5(fs9.n r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        LarusViewBotProfileBinding r100 = this.f366874a;
        r100.f366554g.setText(r110.n());
        r100.f366549b.setVisibility(8);
        if (this.f366874a.f366549b.getVisibility() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        int r102 = R.id.iv_immersive_icon;
    L9:
        ConstraintSet r103 = new ConstraintSet();
        r103.clone(this);
        r103.connect(R.id.profile_bot_review_tag, 6, r102, 7, i5.j0());
        r103.setHorizontalBias(R.id.profile_bot_review_tag, 0.0f);
        r103.applyTo(this);
        if (Intrinsics.areEqual(r110.l(), "rollback") == false) goto L12;
    L15:
        r100.f366555h.setVisibility(0);
        r100.f366555h.setMaxWidth((int) (((double) ((((com.larus.utils.i.d(getContext()) - i5.q()) - i5.k0()) - i5.q()) - i5.q())) * 0.7d));
    L17:
        if (r100.f366555h.getVisibility() != 0) goto L19;
        boolean r104 = true;
    L21:
        if (r104 == true) goto L23;
    L28:
        Number r105 = 0;
    L30:
        if (r100.f366549b.getVisibility() != 0) goto L32;
        boolean r106 = true;
    L33:
        if (r106 == false) goto L35;
        int r107 = i5.v() + (i5.j0() * 2);
    L36:
        r100.f366554g.setMaxWidth((((((com.larus.utils.i.d(getContext()) - i5.q()) - i5.k0()) - i5.q()) - Math.min(r100.f366555h.getMaxWidth(), r105.intValue())) - i5.q()) - r107);
        BotIconImage r108 = r110.m();
        String r109 = null;
        if (r108 == null) goto L39;
        String r111 = r108.getTinyUrl();
    L41:
        if (o0.d(r111) == false) goto L47;
        SimpleDraweeView r112 = r100.f366552e;
        BotIconImage r113 = r110.m();
        if (r113 == null) goto L45;
        String r114 = r113.getTinyUrl();
    L46:
        ImageLoaderKt.y(r112, r114, "settings_itg.bot", new b(), 4);
    L59:
        AppCompatTextView r115 = r100.f366553f;
        String r116 = r110.d();
        String r117 = "";
        if (r116 == null) goto L63;
        String r118 = StringsKt.replace$default(r116, "\n", "", false, 4, null);
        if (r118 == null) goto L63;
    L64:
        BotOnBoarding r119 = r110.f();
        if (r119 == null) goto L67;
        String r120 = r119.d();
    L68:
        FeatureKitDelegate r121 = FeatureKitDelegate.f295792b;
        if (r121.R().b() == true) goto L71;
    L73:
        if (r120 != null) goto L75;
    L77:
        boolean r122 = false;
    L78:
        if (r122 == false) goto L80;
        r118 = r120;
    L81:
        r115.setText(r118);
        BotCreatorInfo r123 = r110.k();
        if (r123 == null) goto L84;
        String r124 = r123.getId();
    L85:
        ILoginService.Companion r125 = ILoginService.f286097a;
        if (Intrinsics.areEqual(r124, r125.getAccountInfo().f531530c) == false) goto L88;
        r100.f366551d.setVisibility(8);
    L96:
        if (r121.b().b() == false) goto L123;
        BotCreatorInfo r126 = r110.k();
        if (r126 == null) goto L100;
        r109 = r126.getId();
    L100:
        if (r109 == null) goto L103;
        r117 = r109;
    L103:
        String r127 = r125.getAccountInfo().f531530c;
        FLogger.f375446a.d("BotProfileView", "isCreator called: creatorId = " + r117 + ", userId = " + r127);
        if (Intrinsics.areEqual(r117, r127) == false) goto L122;
        Integer r128 = r110.o();
        if (r128 != null) goto L109;
    L110:
        if (r128 != null) goto L113;
    L115:
        S5(r110.g());
        return;
    L113:
        if (r128.intValue() != 3) goto L115;
    L116:
        int r129 = r128.intValue();
        LarusViewBotProfileBinding r130 = this.f366874a;
        if (r129 == 2) goto L121;
        if (r129 == 3) goto L120;
        T5(false);
        return;
    L120:
        T5(true);
        r130.f366550c.setImageResource(R.drawable.larus_ic_tag_unlisted_new);
        r130.f366557j.setText(getContext().getString(R.string.larus_Bot_visibility_unlisted));
        return;
    L121:
        T5(true);
        r130.f366550c.setImageResource(R.drawable.larus_icon_tag_private);
        r130.f366557j.setText(getContext().getString(R.string.larus_visibility_double_check_private));
        return;
    L109:
        if (r128.intValue() == 2) goto L116;
    L122:
        S5(r110.g());
        return;
    L123:
        T5(false);
        return;
    L88:
        AppCompatImageView r131 = r100.f366551d;
        Context r132 = getContext();
        if (r110.p() == true) goto L91;
    L93:
        int r133 = R.drawable.ic_bot_add;
    L94:
        r131.setImageDrawable(ContextCompat.getDrawable(r132, r133));
        r100.f366556i.setVisibility(0);
        goto L96
    L91:
        if (r110.q() == true) goto L93;
        r133 = R.drawable.ic_bot_remove;
        goto L94
    L84:
        r124 = null;
        goto L85
    L80:
        r118 = getContext().getString(R.string.larus_im_list_message_placeholder);
        Intrinsics.checkNotNull(r118);
        goto L81
    L75:
        if (o0.d(r120) != true) goto L77;
        r122 = true;
        goto L78
    L71:
        if (o0.d(r118) == false) goto L73;
    L67:
        r120 = null;
    L63:
        r118 = "";
        goto L64
    L45:
        r114 = null;
        goto L46
    L47:
        BotIconImage r134 = r110.m();
        if (r134 == null) goto L50;
        String r135 = r134.getOriginUrl();
    L52:
        if (o0.d(r135) == false) goto L58;
        SimpleDraweeView r136 = r100.f366552e;
        BotIconImage r137 = r110.m();
        if (r137 == null) goto L56;
        String r138 = r137.getOriginUrl();
    L57:
        ImageLoaderKt.y(r136, r138, "settings_itg.bot", new c(this), 4);
        goto L59
    L56:
        r138 = null;
        goto L57
    L58:
        ImageLoaderKt.y(r100.f366552e, y0.k(new Uri.Builder().scheme("res").path(String.valueOf(R.drawable.larus_common_ui_avatar_placeholder)).build()), "settings_itg.bot", new d(), 4);
        goto L59
    L50:
        r135 = null;
        goto L52
    L39:
        r111 = null;
        goto L41
    L35:
        r107 = 0;
        goto L36
    L32:
        r106 = false;
        goto L33
    L23:
        if (r100.f366555h.getText().length() <= 0) goto L25;
        boolean r139 = true;
    L26:
        if (r139 == false) goto L28;
        r105 = Float.valueOf((r100.f366555h.getPaint().measureText(r100.f366555h.getText().toString()) + (i5.j0() * 2)) + i5.r0());
        goto L30
    L25:
        r139 = false;
        goto L26
    L19:
        r104 = false;
        goto L21
    L12:
        if (Intrinsics.areEqual(r110.l(), ShareAnswerType.BAN) == true) goto L15;
        r100.f366555h.setVisibility(8);
        goto L17
    L8:
        r102 = R.id.profile_bot_name;
        goto L9
    L5:
        r101 = false;
        goto L6
    }

    public final void S5(BotStatistic r100) {
        LarusViewBotProfileBinding r101 = this.f366874a;
        String r102 = null;
        if (r100 == null) goto L5;
        String r103 = r100.getDisplayHeatScore();
    L7:
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        T5(false);
        return;
    L15:
        T5(true);
        r101.f366550c.setImageResource(R.drawable.larus_icon_tag_hot);
        AppCompatTextView r105 = r101.f366557j;
        if (r100 == null) goto L18;
        r102 = r100.getDisplayHeatScore();
    L18:
        r105.setText(r102);
        return;
    L9:
        if (r103.length() == 0) goto L12;
        r104 = false;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public final void T5(boolean r100) {
        LarusViewBotProfileBinding r101 = this.f366874a;
        AppCompatImageView r102 = r101.f366550c;
        int r103 = 0;
        if (r100 == false) goto L5;
        int r104 = 0;
    L6:
        r102.setVisibility(r104);
        AppCompatTextView r105 = r101.f366557j;
        if (r100 == true) goto L10;
        r103 = 8;
    L10:
        r105.setVisibility(r103);
        return;
    L5:
        r104 = 8;
        goto L6
    }

    public final void setAddItemClick(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        e1.d(this.f366874a.f366551d, new a(r100));
    }

    public BotProfileView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_view_bot_profile, this);
        int r113 = R.id.iv_immersive_icon;
        AppCompatImageView r100 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_immersive_icon);
        if (r100 == null) goto L23;
        r113 = R.id.iv_tag;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_tag);
        if (r101 == null) goto L23;
        r113 = R.id.profile_add_bot_btn;
        AppCompatImageView r102 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.profile_add_bot_btn);
        if (r102 == null) goto L23;
        r113 = R.id.profile_bot_avatar;
        SimpleDraweeView r103 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.profile_bot_avatar);
        if (r103 == null) goto L23;
        r113 = R.id.profile_bot_intro;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.profile_bot_intro);
        if (r104 == null) goto L23;
        r113 = R.id.profile_bot_name;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.profile_bot_name);
        if (r105 == null) goto L23;
        r113 = R.id.profile_bot_review_tag;
        AppCompatTextView r106 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.profile_bot_review_tag);
        if (r106 == null) goto L23;
        r113 = R.id.profile_layout_right_action;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.profile_layout_right_action);
        if (r107 == null) goto L23;
        r113 = R.id.tv_tag;
        AppCompatTextView r114 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.tv_tag);
        if (r114 == null) goto L23;
        this.f366874a = new LarusViewBotProfileBinding(this, r100, r101, r102, r103, r104, r105, r106, r107, r114);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ BotProfileView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
