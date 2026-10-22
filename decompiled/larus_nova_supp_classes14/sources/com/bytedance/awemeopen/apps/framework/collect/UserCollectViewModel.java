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
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bY\u0010ZJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001f\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010/R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a008\u0006¢\u0006\f\n\u0004\b6\u00102\u001a\u0004\b7\u00104R\"\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001080-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010/R%\u0010:\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001a\u0018\u000108008\u0006¢\u0006\f\n\u0004\b:\u00102\u001a\u0004\b;\u00104R\u001c\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010/R\u001f\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010<008\u0006¢\u0006\f\n\u0004\b>\u00102\u001a\u0004\b?\u00104R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010/R\u001f\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014008\u0006¢\u0006\f\n\u0004\bA\u00102\u001a\u0004\bB\u00104R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010/R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\t008\u0006¢\u0006\f\n\u0004\bD\u00102\u001a\u0004\bE\u00104R\u001c\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F0-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010/R\u001f\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010F008\u0006¢\u0006\f\n\u0004\bH\u00102\u001a\u0004\bI\u00104R\"\u0010K\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020J\u0018\u0001080-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010/R%\u0010L\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020J\u0018\u000108008\u0006¢\u0006\f\n\u0004\bL\u00102\u001a\u0004\bM\u00104R\u0018\u0010N\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010$\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010$\u001a\u0004\bT\u0010Q\"\u0004\bU\u0010SR\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010/R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\t008\u0006¢\u0006\f\n\u0004\bW\u00102\u001a\u0004\bX\u00104¨\u0006["}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/collect/UserCollectViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfig;", "config", "", "initPageConfig", "getPageConfig", "", "userIdIsSameWithCachedFeedItemInfo", "", "v", "updatePage", "currentSelectedIndex", "Ljz3/a;", "getCachedFeedItemEntity", "cachedFeedUser", "setCachedFeedItemEntity", "clearUserInfo", "userInfoHasBeenCleared", "updateLocalUserInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/User;", "info", "updateServerUserInfo", "Landroid/content/Context;", "context", "getUserInfo", "", "enterMethod", "Ljava/lang/String;", "getEnterMethod", "()Ljava/lang/String;", "setEnterMethod", "(Ljava/lang/String;)V", "CollectPageConfig", "Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfig;", "hasUpdateLocalUserInfo", "Z", "isPullingUserInfo", "Lq04/b;", "profileIds", "Lq04/b;", "getProfileIds", "()Lq04/b;", "setProfileIds", "(Lq04/b;)V", "Landroidx/lifecycle/MutableLiveData;", "_userName", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "userName", "Landroidx/lifecycle/LiveData;", "getUserName", "()Landroidx/lifecycle/LiveData;", "_userDesc", "userDesc", "getUserDesc", "", "_headerImage", "headerImage", "getHeaderImage", "Lq04/a;", "_followModel", "followModel", "getFollowModel", "_serverUserInfo", "serverUserInfo", "getServerUserInfo", "_serverUserStatus", "serverUserStatus", "getServerUserStatus", "Lq04/c;", "_userVerifyInfo", "userVerifyInfo", "getUserVerifyInfo", "Lcom/bytedance/awemeopen/bizmodels/profile/c;", "_cardEntryStructs", "cardEntryStructs", "getCardEntryStructs", "cachedFeedItemEntity", "Ljz3/a;", "isNestingUsed", "()Z", "setNestingUsed", "(Z)V", "isShowingInNestingPage", "setShowingInNestingPage", "_selectedIndex", "selectedIndex", "getSelectedIndex", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
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
        public final /* synthetic */ UserCollectViewModel a;
        public final /* synthetic */ Context b;

        public final void onFail(Exception r4) {
            UserCollectViewModel.access$setPullingUserInfo$p(this.a, false);
            UserCollectViewModel.access$get_userName$p(this.a).setValue(this.b.getString(2131894160));
            UserCollectViewModel.access$get_serverUserStatus$p(this.a).postValue(0);
        }

        public final void onSuccess(Object r5) {
            User r6 = (User) r5;
            Intrinsics.checkNotNullParameter(r6, "data");
            boolean r1 = false;
            UserCollectViewModel.access$setPullingUserInfo$p(this.a, false);
            UserCollectViewModel.access$get_serverUserStatus$p(this.a).postValue(1);
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

        public a(UserCollectViewModel r1, Context r2) {
            this.a = r1;
            this.b = r2;
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

    public final CollectPageConfig getPageConfig() {
        CollectPageConfig r0 = this.CollectPageConfig;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("CollectPageConfig");
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
        this._userVerifyInfo.setValue(p0.b(r12));
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

    public UserCollectViewModel() {
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
        r8.setValue(0);
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

    public static final /* synthetic */ MutableLiveData access$get_serverUserStatus$p(UserCollectViewModel r0) {
        return r0._serverUserStatus;
    }

    public static final /* synthetic */ MutableLiveData access$get_userName$p(UserCollectViewModel r0) {
        return r0._userName;
    }

    public final void getUserInfo(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r1 = true;
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
        CharSequence r2 = (CharSequence) this._userName.getValue();
        if (r2 != null) goto L17;
    L20:
        if (r1 == false) goto L22;
        this._userName.setValue(r4.getString(2131894161));
    L22:
        d14.a r3 = b14.a.a;
        m24.c r5 = b14.a.a(m24.c.class);
        a r6 = new a(this, r4);
        String r7 = this.profileIds.b;
        if (r7 != null) goto L25;
        r7 = "";
    L25:
        r5.T2(r4, r7, r6);
        return;
    L17:
        if (r2.length() == 0) goto L20;
        r1 = false;
        goto L20
    L5:
        r0 = false;
        goto L6
    }

    public final void initPageConfig(CollectPageConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.CollectPageConfig = r3;
        q04.b r0 = this.profileIds;
        String r4 = r3.getOpenId();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.b = r4;
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

    public final void setShowingInNestingPage(boolean r1) {
        this.isShowingInNestingPage = r1;
    }

    public final void updatePage(int r2) {
        this._selectedIndex.setValue(Integer.valueOf(r2));
    }

    public final void updateServerUserInfo(User r11) {
        if (r11 == null) goto L41;
        this._userName.setValue(r11.t());
        CharSequence r0 = (CharSequence) this._userDesc.getValue();
        if (r0 != null) goto L6;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        this._userDesc.setValue(r11.F());
    L12:
        Collection r2 = (Collection) this._headerImage.getValue();
        if (r2 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L26;
        MutableLiveData<List<String>> r4 = this._headerImage;
        t14.a r5 = r11.a();
        if (r5 == null) goto L23;
        List r6 = r5.g();
    L24:
        r4.setValue(r6);
        goto L26
    L23:
        r6 = null;
    L26:
        if (this._followModel.getValue() != null) goto L37;
        MutableLiveData<q04.a> r7 = this._followModel;
        String r8 = r11.u();
        int r9 = r11.m();
        boolean r10 = r11.S();
        if (r11.D() == true) goto L30;
    L34:
        boolean r12 = false;
    L35:
        r7.setValue(new q04.a(r8, r9, r10, r12, p0.c(r11)));
        goto L37
    L30:
        if (r11.M() == true) goto L34;
        d14.a r13 = b14.a.a;
        if (b14.a.a(z24.a.class).isAvailable() == false) goto L34;
        r12 = true;
    L37:
        if (this._cardEntryStructs.getValue() != null) goto L39;
        this._cardEntryStructs.setValue(r11.c());
    L39:
        this._userVerifyInfo.setValue(p0.b(r11));
        this._serverUserInfo.postValue(r11);
        return;
    L15:
        if (r2.isEmpty() == true) goto L18;
        r3 = false;
        goto L19
    L6:
        if (r0.length() == 0) goto L9;
        r1 = false;
        goto L10
    }

    public static final /* synthetic */ void access$setPullingUserInfo$p(UserCollectViewModel r0, boolean r1) {
        r0.isPullingUserInfo = r1;
    }
}
