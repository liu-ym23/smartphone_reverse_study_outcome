package com.larus.setting.api.trace;

import at9.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J1\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J \u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J$\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u000f2\u0006\u0010)\u001a\u00020\u001cH\u0016J\b\u0010*\u001a\u00020\nH\u0016J\b\u0010+\u001a\u00020\nH\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006/"}, d2 = {"Lcom/larus/setting/api/trace/SettingTrackDelegate;", "Lcom/larus/setting/api/trace/ISettingTrackApi;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/setting/api/trace/ISettingTrackApi;", "impl$delegate", "Lkotlin/Lazy;", "enterPage", "", "clickClearContext", "clickSettingLanguage", "clickChooseLanguage", "language", "", "clickSettingFeedback", "currentPage", "clickDiscordEntrance", "clickSettingProtocol", "clickSettingPrivacy", "clickSettingPrivacyAbs", "clickSettingLogout", "clickLogoutConfirm", "clickLogoutCancel", "logoutResult", "scene", "success", "", "errCode", "errTips", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;)V", "clickSettingClearAccount", "clickClearAccountConfirm", "clickClearAccountCancel", "clickAccountSetting", "settingClearContextResult", "result", "changeVoice", "botID", "voice", "ifAuto", "enterCommunityGuideline", "enterProtectGuideline", "clickWebPromotionBanner", "clickEcommerceQualificationRules", "clickShoppingPaymentFaq", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingTrackDelegate implements ISettingTrackApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingTrackDelegate f367926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f367927b = null;

    private SettingTrackDelegate() {
    }

    static {
        f367926a = new SettingTrackDelegate();
        f367927b = LazyKt.lazy(new a());
    }

    public static ISettingTrackApi h() {
        return (ISettingTrackApi) f367927b.getValue();
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void a() {
        ISettingTrackApi r100 = h();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void c() {
        ISettingTrackApi r100 = h();
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void d() {
        ISettingTrackApi r100 = h();
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void e() {
        ISettingTrackApi r100 = h();
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void f() {
        ISettingTrackApi r100 = h();
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void g() {
        ISettingTrackApi r100 = h();
        if (r100 == null) goto L6;
        r100.g();
        return;
    }

    @Override // com.larus.setting.api.trace.ISettingTrackApi
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "currentPage");
        ISettingTrackApi r101 = h();
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
