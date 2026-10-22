package com.bytedance.awemeopen.apps.framework.profile;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.profile.works.RecentlySeeHelper;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.profile.ProfilePageConfig;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bb\u0010cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001f\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00108R\u001f\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#098\u0006¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R\"\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010A068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00108R%\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010A098\u0006¢\u0006\f\n\u0004\bC\u0010;\u001a\u0004\bD\u0010=R\u001c\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00108R\u001f\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E098\u0006¢\u0006\f\n\u0004\bG\u0010;\u001a\u0004\bH\u0010=R\u001c\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u00108R\u001f\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011098\u0006¢\u0006\f\n\u0004\bJ\u0010;\u001a\u0004\bK\u0010=R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u00108R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\t098\u0006¢\u0006\f\n\u0004\bM\u0010;\u001a\u0004\bN\u0010=R\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u00108R\u001f\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O098\u0006¢\u0006\f\n\u0004\bQ\u0010;\u001a\u0004\bR\u0010=R\"\u0010T\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020S\u0018\u00010A068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u00108R%\u0010U\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020S\u0018\u00010A098\u0006¢\u0006\f\n\u0004\bU\u0010;\u001a\u0004\bV\u0010=R\u0018\u0010W\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Y\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010-\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010-\u001a\u0004\b]\u0010Z\"\u0004\b^\u0010\\R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\t068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00108R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\t098\u0006¢\u0006\f\n\u0004\b`\u0010;\u001a\u0004\ba\u0010=¨\u0006d"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/UserProfileViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfig;", "config", "", "initPageConfig", "getPageConfig", "", "userIdIsSameWithCachedFeedItemInfo", "", "v", "updatePage", "currentSelectedIndex", "Ljz3/a;", "getCachedFeedItemEntity", "cachedFeedUser", "setCachedFeedItemEntity", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "user", "isBlockOrPrivateUser", "clearUserInfo", "userInfoHasBeenCleared", "updateLocalUserInfo", "info", "updateServerUserInfo", "Landroid/content/Context;", "context", "getUserInfo", "Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;", "recentlySeeHelper", "Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;", "getRecentlySeeHelper", "()Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;", "setRecentlySeeHelper", "(Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;)V", "", "enterMethod", "Ljava/lang/String;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "profilePageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfig;", "hasUpdateLocalUserInfo", "Z", "isPullingUserInfo", "Lq04/b;", "profileIds", "Lq04/b;", "getProfileIds", "()Lq04/b;", "setProfileIds", "(Lq04/b;)V", "Landroidx/lifecycle/MutableLiveData;", "_userName", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "userName", "Landroidx/lifecycle/LiveData;", "getUserName", "()Landroidx/lifecycle/LiveData;", "_userDesc", "userDesc", "getUserDesc", "", "_headerImage", "headerImage", "getHeaderImage", "Lq04/a;", "_followModel", "followModel", "getFollowModel", "_serverUserInfo", "serverUserInfo", "getServerUserInfo", "_serverUserStatus", "serverUserStatus", "getServerUserStatus", "Lq04/c;", "_userVerifyInfo", "userVerifyInfo", "getUserVerifyInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/c;", "_cardEntryStructs", "cardEntryStructs", "getCardEntryStructs", "cachedFeedItemEntity", "Ljz3/a;", "isNestingUsed", "()Z", "setNestingUsed", "(Z)V", "isShowingInNestingPage", "setShowingInNestingPage", "_selectedIndex", "selectedIndex", "getSelectedIndex", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserProfileViewModel extends AosViewModel {
    private final MutableLiveData<List<com.bytedance.awemeopen.bizmodels.profile.c>> _cardEntryStructs;
    private final MutableLiveData<q04.a> _followModel;
    private final MutableLiveData<List<String>> _headerImage;
    private MutableLiveData<Integer> _selectedIndex;
    private final MutableLiveData<User> _serverUserInfo;
    private final MutableLiveData<Integer> _serverUserStatus;
    private final MutableLiveData<String> _userDesc;
    private final MutableLiveData<String> _userName;
    private final MutableLiveData<q04.c> _userVerifyInfo;
    private jz3.a cachedFeedItemEntity;
    private final LiveData<List<com.bytedance.awemeopen.bizmodels.profile.c>> cardEntryStructs;
    private String enterMethod;
    private final LiveData<q04.a> followModel;
    private boolean hasUpdateLocalUserInfo;
    private final LiveData<List<String>> headerImage;
    private boolean isNestingUsed;
    private boolean isPullingUserInfo;
    private boolean isShowingInNestingPage;
    private q04.b profileIds;
    private ProfilePageConfig profilePageConfig;
    private RecentlySeeHelper recentlySeeHelper;
    private final LiveData<Integer> selectedIndex;
    private final LiveData<User> serverUserInfo;
    private final LiveData<Integer> serverUserStatus;
    private final LiveData<String> userDesc;
    private final LiveData<String> userName;
    private final LiveData<q04.c> userVerifyInfo;

    public static final class a implements r34.e<User> {
        public final /* synthetic */ UserProfileViewModel a;

        public a(UserProfileViewModel r1) {
            this.a = r1;
        }

        public final void onFail(Exception r2) {
            UserProfileViewModel.access$setPullingUserInfo$p(this.a, false);
            UserProfileViewModel.access$get_serverUserStatus$p(this.a).postValue(0);
        }

        public final void onSuccess(Object r5) {
            User r6 = (User) r5;
            Intrinsics.checkNotNullParameter(r6, "data");
            boolean r1 = false;
            UserProfileViewModel.access$setPullingUserInfo$p(this.a, false);
            UserProfileViewModel.access$get_serverUserStatus$p(this.a).postValue(1);
            String r0 = r6.u();
            if (r0 != null) goto L5;
        L6:
            r1 = true;
        L7:
            if (r1 == false) goto L9;
            r6.T(this.a.getProfileIds().b);
        L9:
            this.a.updateServerUserInfo(r6);
            return;
        L5:
            if (r0.length() != 0) goto L7;
            goto L6
        }
    }

    public final void clearUserInfo() {
        this._userName.setValue("");
        this._userDesc.setValue(null);
        this._headerImage.setValue(null);
        this._followModel.setValue(null);
        this._serverUserInfo.setValue(null);
        this._serverUserStatus.setValue(-1);
        this._userVerifyInfo.setValue(null);
        this._cardEntryStructs.setValue(null);
        this.hasUpdateLocalUserInfo = false;
        this.isPullingUserInfo = false;
    }

    public final int currentSelectedIndex() {
        Object r0 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r0);
        return ((Number) r0).intValue();
    }

    public final ProfilePageConfig getPageConfig() {
        ProfilePageConfig r0 = this.profilePageConfig;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("profilePageConfig");
        return null;
    L6:
        return r0;
    }

    public final void updateLocalUserInfo() {
        jz3.a r0 = this.cachedFeedItemEntity;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.hasUpdateLocalUserInfo == false) goto L7;
        return;
    L7:
        q04.b r1 = this.profileIds;
        List r2 = null;
        r1.a = null;
        String r3 = "";
        r1.b = "";
        r1.a = r0.a.c();
        d14.a r4 = b14.a.a;
        if (b14.a.a(x24.a.class).f2(r0.a) == false) goto L11;
        b14.a.a(l24.b.class).p0(r0.a.H());
        q04.b r5 = this.profileIds;
        r5.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r5.b = "";
        this._followModel.setValue(null);
        this._userName.setValue(null);
        this._userVerifyInfo.setValue(null);
        this._userDesc.setValue(null);
        this._headerImage.setValue(null);
    L28:
        this.hasUpdateLocalUserInfo = true;
        return;
    L11:
        if (b14.a.a(x24.a.class).G2(r0.a) == false) goto L18;
        AoLiveService r6 = AoLive.a;
        v14.a r7 = r0.a.j();
        if (r7 == null) goto L16;
        String r8 = r7.a();
        if (r8 == null) goto L16;
    L17:
        AoLive.a(r8);
        q04.b r9 = this.profileIds;
        r9.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r9.b = "";
        this._followModel.setValue(null);
        this._userName.setValue(null);
        this._userVerifyInfo.setValue(null);
        this._userDesc.setValue(null);
        this._headerImage.setValue(null);
    L16:
        r8 = "";
        goto L17
    L18:
        q04.b r10 = this.profileIds;
        String r11 = r0.a.r().b;
        if (r11 == null) goto L22;
        r3 = r11;
    L22:
        r10.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r10.b = r3;
        User r12 = r0.a.f();
        if (r12 == null) goto L28;
        this._userName.setValue(r12.t());
        this._userDesc.setValue(r12.F());
        MutableLiveData<List<String>> r13 = this._headerImage;
        t14.a r14 = r12.a();
        if (r14 == null) goto L27;
        r2 = r14.g();
    L27:
        r13.setValue(r2);
        goto L28
    }

    public final boolean userIdIsSameWithCachedFeedItemInfo() {
        String r0 = this.profileIds.a;
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        jz3.a r2 = this.cachedFeedItemEntity;
        if (r2 == null) goto L14;
        r14.c r3 = r2.a;
        if (r3 == null) goto L14;
        String r4 = r3.c();
        if (r4 == null) goto L14;
        r1 = r4;
    L14:
        return Intrinsics.areEqual(r0, r1);
    }

    public final boolean userInfoHasBeenCleared() {
        if (this.hasUpdateLocalUserInfo == false) goto L5;
    L7:
        return false;
    L5:
        if (this.serverUserInfo.getValue() != null) goto L7;
        return true;
    }

    public UserProfileViewModel() {
        this.recentlySeeHelper = new RecentlySeeHelper();
        this.enterMethod = "";
        this.profileIds = new q04.b();
        MutableLiveData<String> r0 = new MutableLiveData();
        this._userName = r0;
        this.userName = r0;
        MutableLiveData<String> r1 = new MutableLiveData();
        this._userDesc = r1;
        this.userDesc = r1;
        MutableLiveData<List<String>> r2 = new MutableLiveData();
        this._headerImage = r2;
        this.headerImage = r2;
        MutableLiveData<q04.a> r3 = new MutableLiveData();
        this._followModel = r3;
        this.followModel = r3;
        MutableLiveData<User> r4 = new MutableLiveData();
        this._serverUserInfo = r4;
        this.serverUserInfo = r4;
        MutableLiveData<Integer> r5 = new MutableLiveData();
        r5.setValue(-1);
        this._serverUserStatus = r5;
        this.serverUserStatus = r5;
        MutableLiveData<q04.c> r6 = new MutableLiveData();
        this._userVerifyInfo = r6;
        this.userVerifyInfo = r6;
        MutableLiveData<List<com.bytedance.awemeopen.bizmodels.profile.c>> r7 = new MutableLiveData();
        this._cardEntryStructs = r7;
        this.cardEntryStructs = r7;
        MutableLiveData<Integer> r8 = new MutableLiveData();
        r8.setValue(-1);
        this._selectedIndex = r8;
        this.selectedIndex = r8;
    }

    public final jz3.a getCachedFeedItemEntity() {
        return this.cachedFeedItemEntity;
    }

    public final LiveData<List<com.bytedance.awemeopen.bizmodels.profile.c>> getCardEntryStructs() {
        return this.cardEntryStructs;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final LiveData<q04.a> getFollowModel() {
        return this.followModel;
    }

    public final LiveData<List<String>> getHeaderImage() {
        return this.headerImage;
    }

    public final q04.b getProfileIds() {
        return this.profileIds;
    }

    public final RecentlySeeHelper getRecentlySeeHelper() {
        return this.recentlySeeHelper;
    }

    public final LiveData<Integer> getSelectedIndex() {
        return this.selectedIndex;
    }

    public final LiveData<User> getServerUserInfo() {
        return this.serverUserInfo;
    }

    public final LiveData<Integer> getServerUserStatus() {
        return this.serverUserStatus;
    }

    public final LiveData<String> getUserDesc() {
        return this.userDesc;
    }

    public final LiveData<String> getUserName() {
        return this.userName;
    }

    public final LiveData<q04.c> getUserVerifyInfo() {
        return this.userVerifyInfo;
    }

    public final boolean isNestingUsed() {
        return this.isNestingUsed;
    }

    public final boolean isShowingInNestingPage() {
        return this.isShowingInNestingPage;
    }

    public static final /* synthetic */ MutableLiveData access$get_serverUserStatus$p(UserProfileViewModel r0) {
        return r0._serverUserStatus;
    }

    public final void getUserInfo(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (this.profileIds.b.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.serverUserInfo.getValue() == null) goto L12;
        return;
    L12:
        if (this.isPullingUserInfo == false) goto L14;
        return;
    L14:
        this.isPullingUserInfo = true;
        d14.a r1 = b14.a.a;
        m24.c r2 = b14.a.a(m24.c.class);
        a r3 = new a(this);
        String r5 = this.profileIds.b;
        if (r5 != null) goto L17;
        r5 = "";
    L17:
        r2.T2(r4, r5, r3);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void initPageConfig(ProfilePageConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.profilePageConfig = r3;
        q04.b r0 = this.profileIds;
        String r4 = r3.getOpenId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
    }

    public final boolean isBlockOrPrivateUser(User r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.M() == false) goto L7;
    L8:
        return true;
    L7:
        if (p0.d(r3) == true) goto L8;
        return false;
    }

    public final void setCachedFeedItemEntity(jz3.a r1) {
        this.cachedFeedItemEntity = r1;
    }

    public final void setEnterMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterMethod = r2;
    }

    public final void setNestingUsed(boolean r1) {
        this.isNestingUsed = r1;
    }

    public final void setProfileIds(q04.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.profileIds = r2;
    }

    public final void setRecentlySeeHelper(RecentlySeeHelper r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.recentlySeeHelper = r2;
    }

    public final void setShowingInNestingPage(boolean r1) {
        this.isShowingInNestingPage = r1;
    }

    public final void updatePage(int r2) {
        this._selectedIndex.setValue(Integer.valueOf(r2));
    }

    public final void updateServerUserInfo(User r11) {
        if (r11 == null) goto L50;
        CharSequence r0 = (CharSequence) this._userName.getValue();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        this._userName.setValue(r11.t());
    L12:
        CharSequence r2 = (CharSequence) this._userDesc.getValue();
        if (r2 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L21;
        this._userDesc.setValue(r11.F());
    L21:
        Collection r4 = (Collection) this._headerImage.getValue();
        if (r4 != null) goto L24;
    L27:
        boolean r5 = true;
    L28:
        if (r5 == false) goto L35;
        MutableLiveData<List<String>> r6 = this._headerImage;
        t14.a r7 = r11.a();
        if (r7 == null) goto L32;
        List r8 = r7.g();
    L33:
        r6.setValue(r8);
        goto L35
    L32:
        r8 = null;
    L35:
        if (this._followModel.getValue() != null) goto L46;
        MutableLiveData<q04.a> r9 = this._followModel;
        String r10 = r11.u();
        int r12 = r11.m();
        boolean r13 = r11.S();
        if (r11.D() == true) goto L39;
    L43:
        boolean r14 = false;
    L44:
        r9.setValue(new q04.a(r10, r12, r13, r14, p0.c(r11)));
        goto L46
    L39:
        if (r11.M() == true) goto L43;
        d14.a r15 = b14.a.a;
        if (b14.a.a(z24.a.class).isAvailable() == false) goto L43;
        r14 = true;
    L46:
        if (this._cardEntryStructs.getValue() != null) goto L48;
        this._cardEntryStructs.setValue(r11.c());
    L48:
        this._userVerifyInfo.setValue(p0.b(r11));
        this._serverUserInfo.postValue(r11);
        return;
    L24:
        if (r4.isEmpty() == true) goto L27;
        r5 = false;
        goto L28
    L15:
        if (r2.length() == 0) goto L18;
        r3 = false;
        goto L19
    L6:
        if (r0.length() == 0) goto L9;
        r1 = false;
        goto L10
    }

    public static final /* synthetic */ void access$setPullingUserInfo$p(UserProfileViewModel r0, boolean r1) {
        r0.isPullingUserInfo = r1;
    }
}
