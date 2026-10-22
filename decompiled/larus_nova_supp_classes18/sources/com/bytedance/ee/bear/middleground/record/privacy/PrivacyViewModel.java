package com.bytedance.ee.bear.middleground.record.privacy;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.record.executor.AvatarSettingResult;
import com.bytedance.ee.bear.middleground.record.executor.PrivacyResult;
import com.bytedance.ee.bear.middleground.record.viewhistory.RecordListResult;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xi5.e;
import xi5.f;
import xi5.g;
import xi5.h;
import xi5.i;
import xi5.j;
import yi5.n;
import yi5.o;
import yi5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class PrivacyViewModel extends ViewModel {
    private static final int CODE_NO_ADMIN = 8;
    private static final int CODE_NO_PRIVACY = 9;
    public static final int STATE_AVATAR_ADMIN = 5;
    public static final int STATE_GET_FAILED = 4;
    public static final int STATE_HANDLE_CACHE = 12;
    public static final int STATE_LOADING = 0;
    public static final int STATE_NOT_NETWORK = 11;
    public static final int STATE_NO_ADMIN = 2;
    public static final int STATE_SET_FAILED = 3;
    public static final int STATE_SHOW_AVATAR = 6;
    public static final int STATE_SUCCESS = 1;
    private static final String TAG = "PrivacyModel";
    private static final String allowReadList = "allow_read_list_setting";
    private static final String allowShowAvatar = "allow_show_collaboration_avatar";
    private CompositeDisposable compositeDisposable;
    private vo5.a delegate;
    private Disposable disposableAdmin;
    private Disposable disposableGet;
    private Disposable disposablePushAvatar;
    private Disposable disposableSet;
    private MutableLiveData<Boolean> isCheckMutableLiveData;
    private e mGetPrivacyExecutor;
    private f mGetRecordListExecutor;
    private g mGetShowAvatarExecutor;
    private i mSetPrivacyExecutor;
    private int objType;
    private MutableLiveData<Boolean> showAvatarLiveData;
    private MutableLiveData<Integer> stateMutableLiveData;
    private String token;
    private MutableLiveData<j> userSettingLiveData;

    public class a implements f.c {
        public final /* synthetic */ PrivacyViewModel a;

        public a(PrivacyViewModel r1) {
            this.a = r1;
        }

        @Override // xi5.f.c
        public final void a(RecordListResult r3) {
            yi5.b.b(true, "recordAdminSetting", PrivacyViewModel.access$000(this.a));
            yi5.b.b(true, PrivacyViewModel.allowReadList, PrivacyViewModel.access$000(this.a));
            PrivacyViewModel.access$102(this.a, null);
            PrivacyViewModel.access$200(this.a).setValue(1);
            PrivacyViewModel.access$300(this.a).setValue(Boolean.TRUE);
        }

        @Override // xi5.f.c
        public final void onError(Throwable r7) throws Exception {
            PrivacyViewModel.access$102(this.a, null);
            if ((r7 instanceof NetService.ServerErrorException) == false) goto L18;
            int r8 = JSONObjectProtectorUtils.getInt(new JSONObject(((NetService.ServerErrorException) r7).getJson()), "code");
            yi5.b.b(true, "recordAdminSetting", PrivacyViewModel.access$000(this.a));
            if (r8 != 1) goto L7;
        L16:
            tt5.a.h(PrivacyViewModel.TAG, "getAdmin: fail");
            PrivacyViewModel.access$200(this.a).setValue(4);
            return;
        L7:
            if (r8 == 2) goto L16;
            if (r8 != 8) goto L13;
            tt5.a.h(PrivacyViewModel.TAG, "getAdmin: no admin");
            yi5.b.b(false, "recordAdminSetting", PrivacyViewModel.access$000(this.a));
            PrivacyViewModel.access$200(this.a).setValue(2);
            return;
        L13:
            if (r8 != 9) goto L15;
            tt5.a.h(PrivacyViewModel.TAG, "getAdmin: no privacy");
            yi5.b.b(false, PrivacyViewModel.allowReadList, PrivacyViewModel.access$000(this.a));
            PrivacyViewModel.access$200(this.a).setValue(1);
            PrivacyViewModel.access$300(this.a).setValue(Boolean.FALSE);
            return;
        L15:
            PrivacyViewModel.access$400(this.a);
            return;
        }
    }

    public class b implements e.a {
        public final /* synthetic */ PrivacyViewModel a;

        public b(PrivacyViewModel r1) {
            this.a = r1;
        }
    }

    public class c implements i.c {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PrivacyViewModel b;

        @Override // xi5.i.c
        public final void a() {
            PrivacyViewModel.access$602(this.b, null);
            if (this.a == false) goto L5;
            com.bytedance.ee.bear.middleground.record.a.b("read_record_open");
        L6:
            Toast.showSuccessText(eu5.b.a, 2131887831);
            yi5.b.b(this.a, PrivacyViewModel.allowReadList, PrivacyViewModel.access$000(this.b));
            PrivacyViewModel.access$200(this.b).setValue(1);
            PrivacyViewModel.access$300(this.b).setValue(Boolean.valueOf(this.a));
            return;
        L5:
            com.bytedance.ee.bear.middleground.record.a.b("read_record_close");
            goto L6
        }

        @Override // xi5.i.c
        public final void onError(Throwable r2) throws Exception {
            PrivacyViewModel.access$602(this.b, null);
            PrivacyViewModel.access$200(this.b).setValue(3);
            Toast.showFailureText(eu5.b.a, 2131887830);
        }

        public c(PrivacyViewModel r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class d implements i.c {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PrivacyViewModel b;

        @Override // xi5.i.c
        public final void a() {
            PrivacyViewModel.access$702(this.b, null);
            yi5.b.b(this.a, PrivacyViewModel.allowShowAvatar, PrivacyViewModel.access$000(this.b));
            PrivacyViewModel.access$800(this.b).setValue(Boolean.valueOf(this.a));
            Toast.showSuccessText(eu5.b.a, 2131887831);
        }

        @Override // xi5.i.c
        public final void onError(Throwable r3) throws Exception {
            PrivacyViewModel.access$702(this.b, null);
            tt5.a.d(PrivacyViewModel.TAG, "pushShowAvatar error" + r3);
            Toast.showFailureText(eu5.b.a, 2131887830);
        }

        public d(PrivacyViewModel r1, boolean r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static /* synthetic */ void Mo(Throwable r0) {
        lambda$handleAvatar$2(r0);
    }

    public static /* synthetic */ void No(PrivacyViewModel r0, AvatarSettingResult r1) {
        r0.lambda$handleAvatar$1(r1);
    }

    public static /* synthetic */ AvatarSettingResult yo(Boolean r0, PrivacyResult r1) {
        return lambda$handleAvatar$0(r0, r1);
    }

    private void getPrivacy() {
        tt5.a.h(TAG, "getPrivacy: ..");
        Disposable r0 = this.disposableGet;
        if (r0 == null) goto L5;
        r0.dispose();
        this.disposableGet = null;
    L5:
        e r1 = this.mGetPrivacyExecutor;
        b r2 = new b(this);
        r1.getClass();
        this.disposableGet = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new e.b()).a(new NetService.f("/space/api/user_properties/get/")).subscribe(new xi5.c(r2), new xi5.d(r2));
    }

    private void handleAvatar() {
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
        this.stateMutableLiveData.setValue(11);
        return;
    L6:
        tt5.a.h(TAG, "start handleAvatar");
        g r0 = this.mGetShowAvatarExecutor;
        r0.getClass();
        NetService.f r1 = new NetService.f("/space/api/platform/ccm_setting/admin_tenant_setting");
        ((NetService.e) r1).c = 2;
        r1.b("settingKey", "allow_config_show_collaboration_avatar");
        NetService r2 = r0.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
        r2 = null;
    L10:
        Flowable r3 = r2.Vc(new g.a()).a(r1).map(h.a);
        Flowable r4 = this.mGetPrivacyExecutor.a.Vc(new e.b()).a(new NetService.f("/space/api/user_properties/get/")).map(new xi5.b());
        this.compositeDisposable.add(Flowable.zip(r3, r4, new n()).subscribe(new o(this), new p()));
    }

    private void handleCache() {
        boolean r0 = yi5.b.a("avatarAdminSetting", this.delegate);
        boolean r1 = yi5.b.a(allowShowAvatar, this.delegate);
        boolean r2 = yi5.b.a(allowReadList, this.delegate);
        boolean r3 = yi5.b.a("recordAdminSetting", this.delegate);
        j r4 = new j(r2, r0, r3, r1);
        this.userSettingLiveData.setValue(r4);
        if (r0 == true) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        this.stateMutableLiveData.setValue(12);
    }

    public void destroy() {
        this.compositeDisposable.clear();
    }

    public void getData() {
        Disposable r0 = this.disposableAdmin;
        if (r0 == null) goto L6;
        r0.dispose();
        this.disposableAdmin = null;
    L6:
        if (this.stateMutableLiveData.getValue() != null) goto L8;
    L9:
        this.stateMutableLiveData.setValue(0);
    L11:
        if (((ai5.a) org.koin.java.a.a(ai5.a.class)).b() == false) goto L13;
        handleCache();
        handleAvatar();
    L13:
        this.disposableAdmin = this.mGetRecordListExecutor.a(new xi5.a(this.token, this.objType, "", 1, true), new a(this));
        return;
    L8:
        if (((Integer) this.stateMutableLiveData.getValue()).intValue() == 4) goto L11;
        goto L9
    }

    public PrivacyViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.isCheckMutableLiveData = new MutableLiveData();
        this.stateMutableLiveData = new MutableLiveData();
        this.showAvatarLiveData = new MutableLiveData();
        this.userSettingLiveData = new MutableLiveData();
    }

    public MutableLiveData<Boolean> getIsCheckMutableLiveData() {
        return this.isCheckMutableLiveData;
    }

    public MutableLiveData<Boolean> getShowAvatarLiveData() {
        return this.showAvatarLiveData;
    }

    public MutableLiveData<Integer> getStateMutableLiveData() {
        return this.stateMutableLiveData;
    }

    public MutableLiveData<j> getUserSettingLiveData() {
        return this.userSettingLiveData;
    }

    public static /* synthetic */ vo5.a access$000(PrivacyViewModel r0) {
        return r0.delegate;
    }

    public static /* synthetic */ MutableLiveData access$200(PrivacyViewModel r0) {
        return r0.stateMutableLiveData;
    }

    public static /* synthetic */ MutableLiveData access$300(PrivacyViewModel r0) {
        return r0.isCheckMutableLiveData;
    }

    public static /* synthetic */ void access$400(PrivacyViewModel r0) {
        r0.getPrivacy();
    }

    public static /* synthetic */ MutableLiveData access$800(PrivacyViewModel r0) {
        return r0.showAvatarLiveData;
    }

    private /* synthetic */ void lambda$handleAvatar$1(AvatarSettingResult r4) throws Exception {
        tt5.a.h(TAG, "avatar handleAvatar" + r4);
        yi5.b.b(r4.getAvatarAdminSetting(), "avatarAdminSetting", this.delegate);
        yi5.b.b(r4.getAllowShowCollaboration(), allowShowAvatar, this.delegate);
        if (r4.getAvatarAdminSetting() == true) goto L6;
        this.stateMutableLiveData.setValue(5);
        return;
    L6:
        this.stateMutableLiveData.setValue(6);
        this.showAvatarLiveData.setValue(Boolean.valueOf(r4.getAllowShowCollaboration()));
    }

    private static /* synthetic */ void lambda$handleAvatar$2(Throwable r2) throws Exception {
        tt5.a.d(TAG, "getAvatar error" + r2);
    }

    public void pushPrivacy(boolean r4) {
        tt5.a.h(TAG, "pushPrivacy: ..");
        Disposable r0 = this.disposableSet;
        if (r0 == null) goto L5;
        r0.dispose();
        this.disposableSet = null;
    L5:
        this.disposableSet = this.mSetPrivacyExecutor.a(r4, new c(this, r4), allowReadList);
    }

    public void pushShowAvatar(boolean r4) {
        tt5.a.h(TAG, "pushShowAvatar: ..");
        Disposable r0 = this.disposablePushAvatar;
        if (r0 == null) goto L5;
        r0.dispose();
        this.disposablePushAvatar = null;
    L5:
        this.disposablePushAvatar = this.mSetPrivacyExecutor.a(r4, new d(this, r4), allowShowAvatar);
    }

    public static /* synthetic */ Disposable access$102(PrivacyViewModel r0, Disposable r1) {
        r0.disposableAdmin = r1;
        return r1;
    }

    public static /* synthetic */ Disposable access$502(PrivacyViewModel r0, Disposable r1) {
        r0.disposableGet = r1;
        return r1;
    }

    public static /* synthetic */ Disposable access$602(PrivacyViewModel r0, Disposable r1) {
        r0.disposableSet = r1;
        return r1;
    }

    public static /* synthetic */ Disposable access$702(PrivacyViewModel r0, Disposable r1) {
        r0.disposablePushAvatar = r1;
        return r1;
    }

    private static /* synthetic */ AvatarSettingResult lambda$handleAvatar$0(Boolean r1, PrivacyResult r2) throws Exception {
        return new AvatarSettingResult(r2.getAllowShowCollaboration(), r1.booleanValue());
    }

    public void attach(String r1, int r2, NetService r3, vo5.a r4) {
        this.token = r1;
        this.objType = r2;
        this.mGetRecordListExecutor = new f();
        this.mGetPrivacyExecutor = new e(r3);
        this.mSetPrivacyExecutor = new i();
        this.mGetShowAvatarExecutor = new g(r3);
        this.delegate = r4;
    }
}
