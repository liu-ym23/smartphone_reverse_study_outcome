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
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bb\u0010cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001f\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001c\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00108R\u001f\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#098\u0006¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R\"\u0010B\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010A068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u00108R%\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020#\u0018\u00010A098\u0006¢\u0006\f\n\u0004\bC\u0010;\u001a\u0004\bD\u0010=R\u001c\u0010F\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u00108R\u001f\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010E098\u0006¢\u0006\f\n\u0004\bG\u0010;\u001a\u0004\bH\u0010=R\u001c\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u00108R\u001f\u0010J\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011098\u0006¢\u0006\f\n\u0004\bJ\u0010;\u001a\u0004\bK\u0010=R\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u00108R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\t098\u0006¢\u0006\f\n\u0004\bM\u0010;\u001a\u0004\bN\u0010=R\u001c\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u00108R\u001f\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010O098\u0006¢\u0006\f\n\u0004\bQ\u0010;\u001a\u0004\bR\u0010=R\"\u0010T\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020S\u0018\u00010A068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u00108R%\u0010U\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020S\u0018\u00010A098\u0006¢\u0006\f\n\u0004\bU\u0010;\u001a\u0004\bV\u0010=R\u0018\u0010W\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010Y\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010-\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010-\u001a\u0004\b]\u0010Z\"\u0004\b^\u0010\\R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\t068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u00108R\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020\t098\u0006¢\u0006\f\n\u0004\b`\u0010;\u001a\u0004\ba\u0010=¨\u0006d"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/profile/UserProfileViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfig;", "config", "", "initPageConfig", "getPageConfig", "", "userIdIsSameWithCachedFeedItemInfo", "", BaseSwitches.V, "updatePage", "currentSelectedIndex", "Ljz3/a;", "getCachedFeedItemEntity", "cachedFeedUser", "setCachedFeedItemEntity", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "user", "isBlockOrPrivateUser", "clearUserInfo", "userInfoHasBeenCleared", "updateLocalUserInfo", "info", "updateServerUserInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "getUserInfo", "Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;", "recentlySeeHelper", "Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;", "getRecentlySeeHelper", "()Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;", "setRecentlySeeHelper", "(Lcom/bytedance/awemeopen/apps/framework/profile/works/RecentlySeeHelper;)V", "", "enterMethod", "Ljava/lang/String;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "profilePageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfig;", "hasUpdateLocalUserInfo", "Z", "isPullingUserInfo", "Lq04/b;", "profileIds", "Lq04/b;", "getProfileIds", "()Lq04/b;", "setProfileIds", "(Lq04/b;)V", "Landroidx/lifecycle/MutableLiveData;", "_userName", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "userName", "Landroidx/lifecycle/LiveData;", "getUserName", "()Landroidx/lifecycle/LiveData;", "_userDesc", "userDesc", "getUserDesc", "", "_headerImage", "headerImage", "getHeaderImage", "Lq04/a;", "_followModel", "followModel", "getFollowModel", "_serverUserInfo", "serverUserInfo", "getServerUserInfo", "_serverUserStatus", "serverUserStatus", "getServerUserStatus", "Lq04/c;", "_userVerifyInfo", "userVerifyInfo", "getUserVerifyInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/c;", "_cardEntryStructs", "cardEntryStructs", "getCardEntryStructs", "cachedFeedItemEntity", "Ljz3/a;", "isNestingUsed", "()Z", "setNestingUsed", "(Z)V", "isShowingInNestingPage", "setShowingInNestingPage", "_selectedIndex", "selectedIndex", "getSelectedIndex", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserProfileViewModel f197319a;

        public a(UserProfileViewModel r100) {
            this.f197319a = r100;
        }

        @Override // r34.e
        public final void onFail(Exception r100) {
            UserProfileViewModel.access$setPullingUserInfo$p(this.f197319a, false);
            UserProfileViewModel.access$get_serverUserStatus$p(this.f197319a).postValue(0);
        }

        @Override // r34.e
        public final void onSuccess(User r100) {
            User r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            boolean r102 = false;
            UserProfileViewModel.access$setPullingUserInfo$p(this.f197319a, false);
            UserProfileViewModel.access$get_serverUserStatus$p(this.f197319a).postValue(1);
            String r103 = r101.u();
            if (r103 != null) goto L5;
        L6:
            r102 = true;
        L7:
            if (r102 == false) goto L9;
            r101.T(this.f197319a.getProfileIds().f531182b);
        L9:
            this.f197319a.updateServerUserInfo(r101);
            return;
        L5:
            if (r103.length() != 0) goto L7;
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
        Integer r100 = this._selectedIndex.getValue();
        Intrinsics.checkNotNull(r100);
        return r100.intValue();
    }

    public final ProfilePageConfig getPageConfig() {
        ProfilePageConfig r100 = this.profilePageConfig;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("profilePageConfig");
        return null;
    L6:
        return r100;
    }

    public final void updateLocalUserInfo() {
        jz3.a r100 = this.cachedFeedItemEntity;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.hasUpdateLocalUserInfo == false) goto L7;
        return;
    L7:
        q04.b r101 = this.profileIds;
        List<String> r102 = null;
        r101.f531181a = null;
        String r103 = "";
        r101.f531182b = "";
        r101.f531181a = r100.f501173a.c();
        d14.a r104 = b14.a.f16924a;
        if (((x24.a) b14.a.a(x24.a.class)).f2(r100.f501173a) == false) goto L11;
        ((l24.b) b14.a.a(l24.b.class)).p0(r100.f501173a.H());
        q04.b r105 = this.profileIds;
        r105.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r105.f531182b = "";
        this._followModel.setValue(null);
        this._userName.setValue(null);
        this._userVerifyInfo.setValue(null);
        this._userDesc.setValue(null);
        this._headerImage.setValue(null);
    L28:
        this.hasUpdateLocalUserInfo = true;
        return;
    L11:
        if (((x24.a) b14.a.a(x24.a.class)).G2(r100.f501173a) == false) goto L18;
        AoLiveService r106 = AoLive.f198644a;
        v14.a r107 = r100.f501173a.j();
        if (r107 == null) goto L16;
        String r108 = r107.a();
        if (r108 == null) goto L16;
    L17:
        AoLive.a(r108);
        q04.b r109 = this.profileIds;
        r109.getClass();
        Intrinsics.checkNotNullParameter("", "<set-?>");
        r109.f531182b = "";
        this._followModel.setValue(null);
        this._userName.setValue(null);
        this._userVerifyInfo.setValue(null);
        this._userDesc.setValue(null);
        this._headerImage.setValue(null);
    L16:
        r108 = "";
        goto L17
    L18:
        q04.b r110 = this.profileIds;
        String r111 = r100.f501173a.r().f535650b;
        if (r111 == null) goto L22;
        r103 = r111;
    L22:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r110.f531182b = r103;
        User r112 = r100.f501173a.f();
        if (r112 == null) goto L28;
        this._userName.setValue(r112.t());
        this._userDesc.setValue(r112.F());
        MutableLiveData<List<String>> r113 = this._headerImage;
        t14.a r114 = r112.a();
        if (r114 == null) goto L27;
        r102 = r114.g();
    L27:
        r113.setValue(r102);
        goto L28
    }

    public final boolean userIdIsSameWithCachedFeedItemInfo() {
        String r100 = this.profileIds.f531181a;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        jz3.a r102 = this.cachedFeedItemEntity;
        if (r102 == null) goto L14;
        r14.c r103 = r102.f501173a;
        if (r103 == null) goto L14;
        String r104 = r103.c();
        if (r104 == null) goto L14;
        r101 = r104;
    L14:
        return Intrinsics.areEqual(r100, r101);
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
        MutableLiveData<String> r100 = new MutableLiveData();
        this._userName = r100;
        this.userName = r100;
        MutableLiveData<String> r101 = new MutableLiveData();
        this._userDesc = r101;
        this.userDesc = r101;
        MutableLiveData<List<String>> r102 = new MutableLiveData();
        this._headerImage = r102;
        this.headerImage = r102;
        MutableLiveData<q04.a> r103 = new MutableLiveData();
        this._followModel = r103;
        this.followModel = r103;
        MutableLiveData<User> r104 = new MutableLiveData();
        this._serverUserInfo = r104;
        this.serverUserInfo = r104;
        MutableLiveData<Integer> r105 = new MutableLiveData();
        r105.setValue(-1);
        this._serverUserStatus = r105;
        this.serverUserStatus = r105;
        MutableLiveData<q04.c> r106 = new MutableLiveData();
        this._userVerifyInfo = r106;
        this.userVerifyInfo = r106;
        MutableLiveData<List<com.bytedance.awemeopen.bizmodels.profile.c>> r107 = new MutableLiveData();
        this._cardEntryStructs = r107;
        this.cardEntryStructs = r107;
        MutableLiveData<Integer> r108 = new MutableLiveData();
        r108.setValue(-1);
        this._selectedIndex = r108;
        this.selectedIndex = r108;
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

    public static final /* synthetic */ MutableLiveData access$get_serverUserStatus$p(UserProfileViewModel r100) {
        return r100._serverUserStatus;
    }

    public final void getUserInfo(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.profileIds.f531182b.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        return;
    L9:
        if (this.serverUserInfo.getValue() == null) goto L12;
        return;
    L12:
        if (this.isPullingUserInfo == false) goto L14;
        return;
    L14:
        this.isPullingUserInfo = true;
        d14.a r102 = b14.a.f16924a;
        m24.c r103 = (m24.c) b14.a.a(m24.c.class);
        a r104 = new a(this);
        String r105 = this.profileIds.f531182b;
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        r103.T2(r100, r105, r104);
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void initPageConfig(ProfilePageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.profilePageConfig = r100;
        q04.b r101 = this.profileIds;
        String r102 = r100.getOpenId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f531182b = r102;
    }

    public final boolean isBlockOrPrivateUser(User r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.M() == false) goto L7;
    L8:
        return true;
    L7:
        if (p0.d(r100) == true) goto L8;
        return false;
    }

    public final void setCachedFeedItemEntity(jz3.a r100) {
        this.cachedFeedItemEntity = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setNestingUsed(boolean r100) {
        this.isNestingUsed = r100;
    }

    public final void setProfileIds(q04.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.profileIds = r100;
    }

    public final void setRecentlySeeHelper(RecentlySeeHelper r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recentlySeeHelper = r100;
    }

    public final void setShowingInNestingPage(boolean r100) {
        this.isShowingInNestingPage = r100;
    }

    public final void updatePage(int r100) {
        this._selectedIndex.setValue(Integer.valueOf(r100));
    }

    public final void updateServerUserInfo(User r110) {
        if (r110 == null) goto L50;
        String r100 = this._userName.getValue();
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        this._userName.setValue(r110.t());
    L12:
        String r102 = this._userDesc.getValue();
        if (r102 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L21;
        this._userDesc.setValue(r110.F());
    L21:
        List<String> r104 = this._headerImage.getValue();
        if (r104 != null) goto L24;
    L27:
        boolean r105 = true;
    L28:
        if (r105 == false) goto L35;
        MutableLiveData<List<String>> r106 = this._headerImage;
        t14.a r107 = r110.a();
        if (r107 == null) goto L32;
        List<String> r108 = r107.g();
    L33:
        r106.setValue(r108);
        goto L35
    L32:
        r108 = null;
    L35:
        if (this._followModel.getValue() != null) goto L46;
        MutableLiveData<q04.a> r109 = this._followModel;
        String r111 = r110.u();
        int r112 = r110.m();
        boolean r113 = r110.S();
        if (r110.D() == true) goto L39;
    L43:
        boolean r114 = false;
    L44:
        r109.setValue(new q04.a(r111, r112, r113, r114, p0.c(r110)));
        goto L46
    L39:
        if (r110.M() == true) goto L43;
        d14.a r115 = b14.a.f16924a;
        if (((z24.a) b14.a.a(z24.a.class)).isAvailable() == false) goto L43;
        r114 = true;
    L46:
        if (this._cardEntryStructs.getValue() != null) goto L48;
        this._cardEntryStructs.setValue(r110.c());
    L48:
        this._userVerifyInfo.setValue(p0.b(r110));
        this._serverUserInfo.postValue(r110);
        return;
    L24:
        if (r104.isEmpty() == true) goto L27;
        r105 = false;
        goto L28
    L15:
        if (r102.length() == 0) goto L18;
        r103 = false;
        goto L19
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
        goto L10
    }

    public static final /* synthetic */ void access$setPullingUserInfo$p(UserProfileViewModel r100, boolean r101) {
        r100.isPullingUserInfo = r101;
    }
}
