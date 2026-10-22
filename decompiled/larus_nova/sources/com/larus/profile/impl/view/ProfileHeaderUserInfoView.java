package com.larus.profile.impl.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.api.IFlowProfileThemeConfigProvider;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.e2;
import com.larus.profile.impl.databinding.LarusItemProfileInfoHeaderBinding;
import com.larus.settings.value.e10;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0014\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u0014\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u0014\u0010\u0017\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001bH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/profile/impl/view/ProfileHeaderUserInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/profile/impl/databinding/LarusItemProfileInfoHeaderBinding;", "bindData", "", "userInfo", "Lcom/larus/account/base/model/profile/UserInfo;", "botsCount", "refreshTagsByUserType", "setAvatarClick", "avatarClick", "Lkotlin/Function0;", "setEditClick", "editClick", "setQrCodeClick", "qrCodeClick", "adaptForPad", "configuration", "Landroid/content/res/Configuration;", "onConfigurationChanged", "newConfig", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileHeaderUserInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f366889b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemProfileInfoHeaderBinding f366890a;

    public static final class a {
    }

    static {
    }

    public ProfileHeaderUserInfoView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProfileHeaderUserInfoView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5(Configuration r100) {
        if (e2.f365734a.isPad() == false) goto L13;
        SimpleDraweeView r101 = this.f366890a.f366479d;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L12;
        ConstraintLayout.LayoutParams r103 = (ConstraintLayout.LayoutParams) r102;
        if (r100.orientation != 2) goto L9;
        int r104 = i5.e();
    L10:
        ((ViewGroup.MarginLayoutParams) r103).width = r104;
        ((ViewGroup.MarginLayoutParams) r103).height = r104;
        r101.setLayoutParams(r103);
        return;
    L9:
        r104 = i5.r();
        goto L10
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        e2 r101 = e2.f365734a;
        Context r102 = getContext();
        if ((r102 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r102;
    L7:
        if (r101.a(r103, r100) == false) goto L10;
        R5(r100);
        return;
    L10:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final void setAvatarClick(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "avatarClick");
        e1.d(this.f366890a.f366479d, new j(r100));
    }

    public final void setEditClick(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "editClick");
        e1.d(this.f366890a.f366477b, new k(r100));
    }

    public final void setQrCodeClick(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "qrCodeClick");
        e1.d(this.f366890a.f366478c, new l(r100));
    }

    public final void S5(r38.b r110, int r111) {
        LarusItemProfileInfoHeaderBinding r100 = this.f366890a;
        String r101 = null;
        if (r110 == null) goto L5;
        String r102 = r110.f();
    L6:
        boolean r103 = Intrinsics.areEqual(r102, ILoginService.f286097a.getAccountInfo().f531530c);
        AppCompatTextView r104 = r100.f366481f;
        if (r110 == null) goto L9;
        String r105 = r110.d();
    L10:
        r104.setText(r105);
        e10 r106 = e10.f368561a;
        int r107 = 8;
        if (e10.h0().a() == false) goto L14;
        if (r103 == false) goto L14;
        r100.f366482g.setVisibility(0);
        e1.d(r100.f366483h, new m(this));
    L15:
        n r108 = new n(r100, r110, this);
        if (r103 == false) goto L20;
        IFlowProfileThemeConfigProvider r109 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r109 == null) goto L21;
        r109.c(r108, new o(r100), AdaptThemeFeatureKey.PROFILE_DOUBAO_NAME);
    L21:
        LarusItemProfileInfoHeaderBinding r112 = this.f366890a;
        boolean r113 = true;
        if (r112 == null) goto L44;
        if (r110 == null) goto L30;
        Integer r114 = r110.h();
        if (r114 == null) goto L30;
        if (r114.intValue() != 2) goto L30;
        boolean r115 = true;
    L31:
        if (r115 == true) goto L43;
        if (r110 == null) goto L39;
        Integer r116 = r110.h();
        if (r116 == null) goto L39;
        if (r116.intValue() != 3) goto L39;
        boolean r117 = true;
    L40:
        if (r117 == true) goto L43;
        r112.f366484i.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        r112.f366484i.setCompoundDrawablePadding(0);
    L39:
        r117 = false;
    L43:
        r112.f366484i.setCompoundDrawablesWithIntrinsicBounds(null, null, AppCompatResources.getDrawable(getContext(), R.drawable.larus_ic_profile_certificated_tag), null);
        r112.f366484i.setCompoundDrawablePadding(i5.z());
    L30:
        r115 = false;
    L44:
        SimpleDraweeView r118 = r100.f366479d;
        if (r110 == null) goto L49;
        AvatarInfo r119 = r110.a();
        if (r119 == null) goto L49;
        r101 = r119.a();
    L49:
        ImageLoaderKt.y(r118, r101, "settings_itg.user", new p(), 4);
        if (r111 <= 0) goto L52;
        r100.f366480e.setVisibility(8);
        AppCompatTextView r120 = r100.f366480e;
        StringCompanionObject r121 = StringCompanionObject.INSTANCE;
        r120.setText(String.format(getContext().getString(R.string.larus_number_of_bots), Arrays.copyOf(new Object[]{String.valueOf(r111)}, 1)));
    L53:
        TextView r122 = r100.f366477b;
        if (r103 == false) goto L56;
        int r123 = 0;
    L57:
        r122.setVisibility(r123);
        LarkSocialExp.f365340a.getClass();
        if (LarkSocialExp.e() == false) goto L63;
        if (r103 == false) goto L63;
        if (AppHost.f326268a.isOversea() == true) goto L63;
    L64:
        ImageView r124 = r100.f366478c;
        if (r113 == false) goto L67;
        r107 = 0;
    L67:
        r124.setVisibility(r107);
        IFlowProfileThemeConfigProvider r125 = (IFlowProfileThemeConfigProvider) ServiceManager.get().getService(IFlowProfileThemeConfigProvider.class);
        if (r125 == null) goto L70;
        r125.b(r100.f366477b, AdaptThemeFeatureKey.PROFILE_EDIT_INFO);
    L70:
        R5(getResources().getConfiguration());
        return;
    L63:
        r113 = false;
        goto L64
    L56:
        r123 = 8;
        goto L57
    L52:
        r100.f366480e.setVisibility(8);
        goto L53
    L20:
        r108.invoke();
    L14:
        r100.f366482g.setVisibility(8);
        r100.f366483h.setClickable(false);
        goto L15
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public ProfileHeaderUserInfoView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        LayoutInflater.from(r110).inflate(R.layout.larus_item_profile_info_header, this);
        int r113 = R.id.edit_profile;
        TextView r100 = (TextView) ViewBindings.findChildViewById(this, R.id.edit_profile);
        if (r100 == null) goto L23;
        r113 = R.id.my_qr_code;
        ImageView r101 = (ImageView) ViewBindings.findChildViewById(this, R.id.my_qr_code);
        if (r101 == null) goto L23;
        r113 = R.id.profile_info_avatar;
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.profile_info_avatar);
        if (r102 == null) goto L23;
        r113 = R.id.profile_info_bots_count;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.profile_info_bots_count);
        if (r103 == null) goto L23;
        r113 = R.id.profile_info_nickname;
        AppCompatTextView r104 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.profile_info_nickname);
        if (r104 == null) goto L23;
        r113 = R.id.profile_info_nickname_chevron;
        ImageView r105 = (ImageView) ViewBindings.findChildViewById(this, R.id.profile_info_nickname_chevron);
        if (r105 == null) goto L23;
        r113 = R.id.profile_info_nickname_container;
        ConstraintLayout r106 = (ConstraintLayout) ViewBindings.findChildViewById(this, R.id.profile_info_nickname_container);
        if (r106 == null) goto L23;
        r113 = R.id.profile_info_username;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.profile_info_username);
        if (r107 == null) goto L23;
        r113 = R.id.profile_user_info;
        if (((LinearLayout) ViewBindings.findChildViewById(this, R.id.profile_user_info)) == null) goto L23;
        this.f366890a = new LarusItemProfileInfoHeaderBinding(this, r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r113)));
    }

    public /* synthetic */ ProfileHeaderUserInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
