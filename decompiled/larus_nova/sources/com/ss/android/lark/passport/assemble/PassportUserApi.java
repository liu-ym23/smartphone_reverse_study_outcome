package com.ss.android.lark.passport.assemble;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import com.ss.android.lark.passport.signinsdk_api.account.Tenant;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.entity.LoginInfo;
import com.ss.android.lark.utils.LarkContext;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@ClaymoreImpl(xzb.a.class)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010!\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\"H\u0016¨\u0006%"}, d2 = {"Lcom/ss/android/lark/passport/assemble/PassportUserApi;", "Lcom/ss/android/lark/passport_user/api/IPassportUserApi;", "<init>", "()V", "getUserId", "", "getForegroundUser", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "getSessions", "", "Lcom/ss/android/lark/passport/signinsdk_api/account/SessionInfo;", "getTenantId", "isCustomer", "", "isPrimaryHost", "isSmallBUser", "getLoginInfo", "Lcom/ss/android/lark/passport/signinsdk_api/entity/LoginInfo;", "getSession", "getTenantName", "getUserName", Keys.API_RETURN_KEY_IS_LOGIN, "registerLoginListener", "", "listener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/login/OnLoginListener;", "unregisterLoginListener", "registerLogoutListener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/logout/OnLogoutListener;", "unregisterLogoutListener", "registerUserSwitchListener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/user_switch/OnUserSwitchListener;", "unregisterUserSwitchListener", "registerUserListChangeListener", "Lcom/ss/android/lark/passport/signinsdk_api/feature/listener/OnUserListChangeListener;", "unregisterUserListChangeListener", "Companion", "passport-officesdk-assembly_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PassportUserApi implements xzb.a {
    public static final a Companion = null;
    public static final String TAG = "PassportUserApi";
    private static final Set<nzb.b> loginListeners = null;
    private static final Set<ozb.c> logoutListeners = null;
    private static final Set<mzb.a> userListChangeListeners = null;

    public static final class a {
        public a() {
        }
    }

    public PassportUserApi() {
    }

    @Override // xzb.a
    public void registerUserSwitchListener(qzb.a r100) {
    }

    @Override // xzb.a
    public void unregisterUserSwitchListener(qzb.a r100) {
    }

    static {
        Companion = new a();
        LinkedHashSet r100 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        loginListeners = Collections.synchronizedSet(r100);
        LinkedHashSet r101 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r101, "<this>");
        logoutListeners = Collections.synchronizedSet(r101);
        LinkedHashSet r102 = new LinkedHashSet();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        userListChangeListeners = Collections.synchronizedSet(r102);
    }

    public User getForegroundUser() {
        User r100 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).getForegroundUser();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new User();
    }

    @Override // xzb.a
    public String getUserId() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).c();
    }

    public boolean isLogin() {
        return ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).isLogin();
    }

    public LoginInfo getLoginInfo() {
        User r100 = getForegroundUser();
        String r101 = null;
        if (r100 == null) goto L16;
        LoginInfo r102 = new LoginInfo();
        r102.setSession(r100.getSession());
        r102.setSessionUuid(r100.getSessionUuid());
        r102.setSessionInfoMap(r100.getSessionWithDomainMap());
        r102.setUserId(r100.userId);
        r102.setUserName(b0c.a.a(r100));
        r102.setUserNameEn(r100.getUserNameEn());
        r102.setAvatarUrl(r100.avatarUrl);
        r102.setAvatarKey(r100.avatarKey);
        Tenant r103 = r100.tenant;
        if (r103 == null) goto L8;
        String r104 = r103.tenantId;
    L9:
        r102.setTenantId(r104);
        Tenant r105 = r100.tenant;
        if (r105 == null) goto L14;
        r101 = r105.localizedName(((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.f285948a, zzb.a.class)).getLanguageSetting());
        if (r101 != null) goto L14;
        r101 = "";
    L14:
        r102.setTenantName(r101);
        r102.setTenantIconUrl(r100.getTenantIconUrl());
        r102.setTenantCode(r100.getTenantCode());
        ((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.f285948a, zzb.a.class)).a();
        r102.setIdpType("");
        return r102;
    L8:
        r104 = null;
        goto L9
    L16:
        return null;
    }

    @Override // xzb.a
    public String getSession() {
        String r100 = getForegroundUser().getSession();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public Map<String, SessionInfo> getSessions() {
        Map<String, SessionInfo> r100 = getForegroundUser().getSessionWithDomainMap();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // xzb.a
    public String getTenantId() {
        return getForegroundUser().getTenantId();
    }

    public String getTenantName() {
        Tenant r100 = getForegroundUser().tenant;
        if (r100 == null) goto L6;
        String r101 = r100.localizedName(((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.f285948a, zzb.a.class)).getLanguageSetting());
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // xzb.a
    public String getUserName() {
        User r100 = getForegroundUser();
        if (r100 == null) goto L6;
        String r101 = r100.localizedName(((zzb.a) e0c.k.a(com.larksuite.framework.utils.b.f285948a, zzb.a.class)).getLanguageSetting());
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public boolean isCustomer() {
        String r100 = getTenantId();
        int r101 = com.ss.android.lark.passport.signinsdk_api.contants.a.f438069a;
        return Intrinsics.areEqual(r100, "0");
    }

    public boolean isPrimaryHost() {
        String r100 = getTenantId();
        int r101 = com.ss.android.lark.passport.signinsdk_api.contants.a.f438069a;
        return Intrinsics.areEqual(r100, "1");
    }

    public boolean isSmallBUser() {
        return getForegroundUser().isSmallB();
    }

    public static final /* synthetic */ Set access$getLoginListeners$cp() {
        return loginListeners;
    }

    public static final /* synthetic */ Set access$getLogoutListeners$cp() {
        return logoutListeners;
    }

    public static final /* synthetic */ Set access$getUserListChangeListeners$cp() {
        return userListChangeListeners;
    }

    @Override // xzb.a
    public void registerLoginListener(nzb.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        loginListeners.add(r100);
    }

    @Override // xzb.a
    public void registerLogoutListener(ozb.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        logoutListeners.add(r100);
    }

    @Override // xzb.a
    public void registerUserListChangeListener(mzb.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        userListChangeListeners.add(r100);
    }

    public void unregisterLoginListener(nzb.b r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        loginListeners.remove(r100);
    }

    public void unregisterLogoutListener(ozb.c r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        logoutListeners.remove(r100);
    }

    @Override // xzb.a
    public void unregisterUserListChangeListener(mzb.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        userListChangeListeners.remove(r100);
    }
}
