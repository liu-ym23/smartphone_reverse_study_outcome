package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes37.dex */
public class SigninParams implements Serializable {
    public static final SigninParams DEFAULT = null;
    private boolean clearTask;
    private int[] enterAnimation;
    private int[] exitAnimation;
    private boolean fromGuide;

    @Nullable
    private LoginFromSource fromSource;
    private boolean isInWipeOut;
    private boolean isLogoutSettingDeepErase;
    private boolean isRegister;
    private boolean showCloseIcon;
    private boolean showDefaultAnimation;
    private boolean showLanguageSwitcher;
    private boolean showLoginBackIcon;
    private boolean skipOneKeyAuth;

    @Nullable
    private String wipeDescription;

    public static final enum LoginFromSource extends Enum<LoginFromSource> {
        public static final LoginFromSource KNOWLEDGE_AI = null;
        public static final LoginFromSource MEMPOPE = null;
        public static final String TAG_LOGIN_FROM_SOURCE = "tag_login_from_source";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoginFromSource[] f438077a = null;
        public final int source;

        static {
            LoginFromSource r100 = new LoginFromSource("KNOWLEDGE_AI", 0, 9);
            KNOWLEDGE_AI = r100;
            LoginFromSource r101 = new LoginFromSource("MEMPOPE", 1, 11);
            MEMPOPE = r101;
            f438077a = new LoginFromSource[]{r100, r101};
        }

        public static LoginFromSource[] values() {
            return (LoginFromSource[]) f438077a.clone();
        }

        public static LoginFromSource valueOf(String r100) {
            return (LoginFromSource) r27.a.a(LoginFromSource.class, r100);
        }

        public LoginFromSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.source = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SigninParams f438078a;

        public a() {
            this.f438078a = new SigninParams();
        }
    }

    public static a newBuilder() {
        a r100 = new a();
        if (com.ss.android.lark.passport.a.b() == false) goto L5;
        LoginFromSource r101 = LoginFromSource.MEMPOPE;
        access$1102(r100.f438078a, r101);
    L5:
        return r100;
    }

    static {
        DEFAULT = access$1500(newBuilder().f438078a);
    }

    public SigninParams() {
        this.isRegister = false;
        this.clearTask = false;
        this.showLoginBackIcon = false;
        this.showCloseIcon = false;
        this.showLanguageSwitcher = true;
        this.fromGuide = false;
        this.skipOneKeyAuth = false;
        this.showDefaultAnimation = false;
        this.isLogoutSettingDeepErase = false;
        this.wipeDescription = null;
        this.isInWipeOut = false;
        this.fromSource = null;
    }

    public a buildUpon() {
        a r100 = newBuilder();
        boolean r101 = this.isRegister;
        access$102(r100.f438078a, r101);
        boolean r102 = this.clearTask;
        access$202(r100.f438078a, r102);
        boolean r103 = this.showLoginBackIcon;
        access$402(r100.f438078a, r103);
        boolean r104 = this.showCloseIcon;
        access$1002(r100.f438078a, r104);
        boolean r105 = this.showLanguageSwitcher;
        access$702(r100.f438078a, r105);
        boolean r106 = this.fromGuide;
        access$302(r100.f438078a, r106);
        boolean r107 = this.skipOneKeyAuth;
        access$502(r100.f438078a, r107);
        boolean r108 = this.showDefaultAnimation;
        access$602(r100.f438078a, r108);
        int[] r109 = this.enterAnimation;
        access$802(r100.f438078a, r109);
        int[] r110 = this.exitAnimation;
        access$902(r100.f438078a, r110);
        LoginFromSource r111 = this.fromSource;
        access$1102(r100.f438078a, r111);
        boolean r112 = this.isLogoutSettingDeepErase;
        access$1202(r100.f438078a, r112);
        String r113 = this.wipeDescription;
        access$1302(r100.f438078a, r113);
        boolean r114 = this.isInWipeOut;
        access$1402(r100.f438078a, r114);
        return r100;
    }

    public int[] getEnterAnimation() {
        return this.enterAnimation;
    }

    public int[] getExitAnimation() {
        return this.exitAnimation;
    }

    @Nullable
    public LoginFromSource getFromSource() {
        return this.fromSource;
    }

    @Nullable
    public String getWipeDescription() {
        return this.wipeDescription;
    }

    public boolean isClearTask() {
        return this.clearTask;
    }

    public boolean isFromGuide() {
        return this.fromGuide;
    }

    public boolean isInWipeOut() {
        return this.isInWipeOut;
    }

    public boolean isLogoutSettingDeepErase() {
        return this.isLogoutSettingDeepErase;
    }

    public boolean isRegister() {
        return this.isRegister;
    }

    public boolean isShowCloseIcon() {
        return this.showCloseIcon;
    }

    public boolean isShowDefaultAnimation() {
        return this.showDefaultAnimation;
    }

    public boolean isShowLanguageSwitcher() {
        return this.showLanguageSwitcher;
    }

    public boolean isShowLoginBackIcon() {
        return this.showLoginBackIcon;
    }

    public boolean isSkipOneKeyAuth() {
        return this.skipOneKeyAuth;
    }

    public static SigninParams access$1500(SigninParams r100) {
        SigninParams r101 = new SigninParams();
        r101.isRegister = r100.isRegister();
        r101.clearTask = r100.isClearTask();
        r101.fromGuide = r100.isFromGuide();
        r101.skipOneKeyAuth = r100.isSkipOneKeyAuth();
        r101.showLoginBackIcon = r100.isShowLoginBackIcon();
        r101.showDefaultAnimation = r100.isShowDefaultAnimation();
        r101.showLanguageSwitcher = r100.isShowLanguageSwitcher();
        r101.enterAnimation = r100.getEnterAnimation();
        r101.exitAnimation = r100.getExitAnimation();
        r101.showCloseIcon = r100.isShowCloseIcon();
        r101.fromSource = r100.getFromSource();
        r101.isLogoutSettingDeepErase = r100.isLogoutSettingDeepErase();
        r101.wipeDescription = r100.getWipeDescription();
        r101.isInWipeOut = r100.isInWipeOut();
        return r101;
    }

    public static /* synthetic */ boolean access$1002(SigninParams r100, boolean r101) {
        r100.showCloseIcon = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$102(SigninParams r100, boolean r101) {
        r100.isRegister = r101;
        return r101;
    }

    public static /* synthetic */ LoginFromSource access$1102(SigninParams r100, LoginFromSource r101) {
        r100.fromSource = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1202(SigninParams r100, boolean r101) {
        r100.isLogoutSettingDeepErase = r101;
        return r101;
    }

    public static /* synthetic */ String access$1302(SigninParams r100, String r101) {
        r100.wipeDescription = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1402(SigninParams r100, boolean r101) {
        r100.isInWipeOut = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(SigninParams r100, boolean r101) {
        r100.clearTask = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(SigninParams r100, boolean r101) {
        r100.fromGuide = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$402(SigninParams r100, boolean r101) {
        r100.showLoginBackIcon = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$502(SigninParams r100, boolean r101) {
        r100.skipOneKeyAuth = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$602(SigninParams r100, boolean r101) {
        r100.showDefaultAnimation = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(SigninParams r100, boolean r101) {
        r100.showLanguageSwitcher = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$802(SigninParams r100, int[] r101) {
        r100.enterAnimation = r101;
        return r101;
    }

    public static /* synthetic */ int[] access$902(SigninParams r100, int[] r101) {
        r100.exitAnimation = r101;
        return r101;
    }
}
