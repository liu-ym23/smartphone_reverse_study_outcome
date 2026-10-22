package com.bytedance.awemeopen.apps.framework.collect;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.apps.framework.utils.p0;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.export.api.pageconfig.collect.CollectPageConfig;
import com.bytedance.awemeopen.infra.base.live.AoLive;
import com.bytedance.awemeopen.servicesapi.livepreview.AoLiveService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bY\u0010ZJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001f\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010/R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a008\u0006¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\"\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001080-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010/R%\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u000108008\u0006¢\u0006\f\n\u0004\b:\u00102\u001a\u0004\b;\u00104R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010/R\u001f\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<008\u0006¢\u0006\f\n\u0004\b>\u00102\u001a\u0004\b?\u00104R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010/R\u001f\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014008\u0006¢\u0006\f\n\u0004\bA\u00102\u001a\u0004\bB\u00104R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010/R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\t008\u0006¢\u0006\f\n\u0004\bD\u00102\u001a\u0004\bE\u00104R\u001c\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010/R\u001f\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F008\u0006¢\u0006\f\n\u0004\bH\u00102\u001a\u0004\bI\u00104R\"\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020J\u0018\u0001080-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010/R%\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020J\u0018\u000108008\u0006¢\u0006\f\n\u0004\bL\u00102\u001a\u0004\bM\u00104R\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010$\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010$\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010/R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\t008\u0006¢\u0006\f\n\u0004\bW\u00102\u001a\u0004\bX\u00104¨\u0006["}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/UserCollectViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfig;", "config", "", "initPageConfig", "getPageConfig", "", "userIdIsSameWithCachedFeedItemInfo", "", BaseSwitches.V, "updatePage", "currentSelectedIndex", "Ljz3/a;", "getCachedFeedItemEntity", "cachedFeedUser", "setCachedFeedItemEntity", "clearUserInfo", "userInfoHasBeenCleared", "updateLocalUserInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "info", "updateServerUserInfo", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "getUserInfo", "", "enterMethod", "Ljava/lang/String;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "CollectPageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfig;", "hasUpdateLocalUserInfo", "Z", "isPullingUserInfo", "Lq04/b;", "profileIds", "Lq04/b;", "getProfileIds", "()Lq04/b;", "setProfileIds", "(Lq04/b;)V", "Landroidx/lifecycle/MutableLiveData;", "_userName", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "userName", "Landroidx/lifecycle/LiveData;", "getUserName", "()Landroidx/lifecycle/LiveData;", "_userDesc", "userDesc", "getUserDesc", "", "_headerImage", "headerImage", "getHeaderImage", "Lq04/a;", "_followModel", "followModel", "getFollowModel", "_serverUserInfo", "serverUserInfo", "getServerUserInfo", "_serverUserStatus", "serverUserStatus", "getServerUserStatus", "Lq04/c;", "_userVerifyInfo", "userVerifyInfo", "getUserVerifyInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/c;", "_cardEntryStructs", "cardEntryStructs", "getCardEntryStructs", "cachedFeedItemEntity", "Ljz3/a;", "isNestingUsed", "()Z", "setNestingUsed", "(Z)V", "isShowingInNestingPage", "setShowingInNestingPage", "_selectedIndex", "selectedIndex", "getSelectedIndex", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class UserCollectViewModel extends AosViewModel {
    private CollectPageConfig CollectPageConfig;
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
    private final LiveData<Integer> selectedIndex;
    private final LiveData<User> serverUserInfo;
    private final LiveData<Integer> serverUserStatus;
    private final LiveData<String> userDesc;
    private final LiveData<String> userName;
    private final LiveData<q04.c> userVerifyInfo;

    public static final class a implements r34.e<User> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserCollectViewModel f193969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f193970b;

        @Override // r34.e
        public final void onFail(Exception r100) {
            UserCollectViewModel.access$setPullingUserInfo$p(this.f193969a, false);
            UserCollectViewModel.access$get_userName$p(this.f193969a).setValue(this.f193970b.getString(R.string.aos_collect_username_load_failed));
            UserCollectViewModel.access$get_serverUserStatus$p(this.f193969a).postValue(0);
        }

        @Override // r34.e
        public final void onSuccess(User r100) {
            User r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            boolean r102 = false;
            UserCollectViewModel.access$setPullingUserInfo$p(this.f193969a, false);
            UserCollectViewModel.access$get_serverUserStatus$p(this.f193969a).postValue(1);
            String r103 = r101.u();
            if (r103 != null) goto L5;
        L6:
            r102 = true;
        L7:
            if (r102 == false) goto L9;
            r101.T(this.f193969a.getProfileIds().f531182b);
        L9:
            this.f193969a.updateServerUserInfo(r101);
            return;
        L5:
            if (r103.length() != 0) goto L7;
            goto L6
        }

        public a(UserCollectViewModel r100, Context r101) {
            this.f193969a = r100;
            this.f193970b = r101;
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

    public final CollectPageConfig getPageConfig() {
        CollectPageConfig r100 = this.CollectPageConfig;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("CollectPageConfig");
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
        this._userVerifyInfo.setValue(p0.b(r112));
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

    public UserCollectViewModel() {
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
        r108.setValue(0);
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

    public static final /* synthetic */ MutableLiveData access$get_serverUserStatus$p(UserCollectViewModel r100) {
        return r100._serverUserStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_userName$p(UserCollectViewModel r100) {
        return r100._userName;
    }

    public final void getUserInfo(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r101 = true;
        if (this.profileIds.f531182b.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        return;
    L9:
        if (this.serverUserInfo.getValue() == null) goto L12;
        return;
    L12:
        if (this.isPullingUserInfo == false) goto L14;
        return;
    L14:
        this.isPullingUserInfo = true;
        String r103 = this._userName.getValue();
        if (r103 != null) goto L17;
    L20:
        if (r101 == false) goto L22;
        this._userName.setValue(r100.getString(R.string.aos_collect_username_loading));
    L22:
        d14.a r104 = b14.a.f16924a;
        m24.c r105 = (m24.c) b14.a.a(m24.c.class);
        a r106 = new a(this, r100);
        String r107 = this.profileIds.f531182b;
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        r105.T2(r100, r107, r106);
        return;
    L17:
        if (r103.length() == 0) goto L20;
        r101 = false;
        goto L20
    L5:
        r102 = false;
        goto L6
    }

    public final void initPageConfig(CollectPageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.CollectPageConfig = r100;
        q04.b r101 = this.profileIds;
        String r102 = r100.getOpenId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f531182b = r102;
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

    public final void setShowingInNestingPage(boolean r100) {
        this.isShowingInNestingPage = r100;
    }

    public final void updatePage(int r100) {
        this._selectedIndex.setValue(Integer.valueOf(r100));
    }

    public final void updateServerUserInfo(User r110) {
        if (r110 == null) goto L41;
        this._userName.setValue(r110.t());
        String r100 = this._userDesc.getValue();
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        this._userDesc.setValue(r110.F());
    L12:
        List<String> r102 = this._headerImage.getValue();
        if (r102 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L26;
        MutableLiveData<List<String>> r104 = this._headerImage;
        t14.a r105 = r110.a();
        if (r105 == null) goto L23;
        List<String> r106 = r105.g();
    L24:
        r104.setValue(r106);
        goto L26
    L23:
        r106 = null;
    L26:
        if (this._followModel.getValue() != null) goto L37;
        MutableLiveData<q04.a> r107 = this._followModel;
        String r108 = r110.u();
        int r109 = r110.m();
        boolean r111 = r110.S();
        if (r110.D() == true) goto L30;
    L34:
        boolean r112 = false;
    L35:
        r107.setValue(new q04.a(r108, r109, r111, r112, p0.c(r110)));
        goto L37
    L30:
        if (r110.M() == true) goto L34;
        d14.a r113 = b14.a.f16924a;
        if (((z24.a) b14.a.a(z24.a.class)).isAvailable() == false) goto L34;
        r112 = true;
    L37:
        if (this._cardEntryStructs.getValue() != null) goto L39;
        this._cardEntryStructs.setValue(r110.c());
    L39:
        this._userVerifyInfo.setValue(p0.b(r110));
        this._serverUserInfo.postValue(r110);
        return;
    L15:
        if (r102.isEmpty() == true) goto L18;
        r103 = false;
        goto L19
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
        goto L10
    }

    public static final /* synthetic */ void access$setPullingUserInfo$p(UserCollectViewModel r100, boolean r101) {
        r100.isPullingUserInfo = r101;
    }
}
