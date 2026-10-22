package com.larus.setting.impl.track;

import com.larus.applog.api.IApplog;
import com.larus.setting.api.trace.ISettingTrackApi;
import com.larus.utils.f;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J1\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J \u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\nH\u0016J$\u0010!\u001a\u00020\u00052\b\u0010\"\u001a\u0004\u0018\u00010\n2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016¨\u0006*"}, d2 = {"Lcom/larus/setting/impl/track/SettingTrace;", "Lcom/larus/setting/api/trace/ISettingTrackApi;", "<init>", "()V", "enterPage", "", "clickClearContext", "clickSettingLanguage", "clickChooseLanguage", "language", "", "clickSettingFeedback", "currentPage", "clickDiscordEntrance", "clickSettingProtocol", "clickSettingPrivacyAbs", "clickSettingPrivacy", "clickSettingLogout", "clickLogoutConfirm", "clickLogoutCancel", "logoutResult", "scene", "success", "", "errCode", "errTips", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)V", "clickSettingClearAccount", "clickClearAccountConfirm", "clickClearAccountCancel", "clickAccountSetting", "settingClearContextResult", "result", "changeVoice", "botID", "voice", "ifAuto", "enterCommunityGuideline", "enterProtectGuideline", "clickWebPromotionBanner", "clickEcommerceQualificationRules", "clickShoppingPaymentFaq", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingTrace implements ISettingTrackApi {
    public SettingTrace() {
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void a() {
        IApplog.f287053a.b("click_ecommerce_qualification_rules", f.c(new Pair[0]));
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void c() {
        IApplog.f287053a.b("enter_protection_guideline", f.c(new Pair[0]));
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void d() {
        IApplog.f287053a.b("click_setting_privacy", f.c(new Pair[0]));
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void e() {
        IApplog.f287053a.b("enter_community_guideline", f.c(new Pair[0]));
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void f() {
        IApplog.f287053a.b("click_setting_protocol", f.c(new Pair[0]));
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void g() {
        IApplog.f287053a.b("click_shopping_payment_faq", f.c(new Pair[0]));
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        IApplog.f287053a.b("click_setting_feedback", f.c(new Pair[]{TuplesKt.to("current_page", r100)}));
    }
}
