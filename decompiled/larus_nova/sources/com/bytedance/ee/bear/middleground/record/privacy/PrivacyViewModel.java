package com.bytedance.ee.bear.middleground.record.privacy;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.record.executor.AvatarSettingResult;
import com.bytedance.ee.bear.middleground.record.executor.PrivacyResult;
import com.bytedance.ee.bear.middleground.record.viewhistory.RecordListResult;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyViewModel f234330a;

        public a(PrivacyViewModel r100) {
            this.f234330a = r100;
        }

        @Override // xi5.f.c
        public final void a(RecordListResult r100) {
            yi5.b.b(true, "recordAdminSetting", PrivacyViewModel.access$000(this.f234330a));
            yi5.b.b(true, PrivacyViewModel.allowReadList, PrivacyViewModel.access$000(this.f234330a));
            PrivacyViewModel.access$102(this.f234330a, null);
            PrivacyViewModel.access$200(this.f234330a).setValue(1);
            PrivacyViewModel.access$300(this.f234330a).setValue(Boolean.TRUE);
        }

        @Override // xi5.f.c
        public final void onError(Throwable r100) throws Exception {
            PrivacyViewModel.access$102(this.f234330a, null);
            if ((r100 instanceof NetService.ServerErrorException) == false) goto L18;
            int r101 = JSONObjectProtectorUtils.getInt(new JSONObject(((NetService.ServerErrorException) r100).getJson()), "code");
            yi5.b.b(true, "recordAdminSetting", PrivacyViewModel.access$000(this.f234330a));
            if (r101 != 1) goto L7;
        L16:
            tt5.a.h(PrivacyViewModel.TAG, "getAdmin: fail");
            PrivacyViewModel.access$200(this.f234330a).setValue(4);
            return;
        L7:
            if (r101 == 2) goto L16;
            if (r101 != 8) goto L13;
            tt5.a.h(PrivacyViewModel.TAG, "getAdmin: no admin");
            yi5.b.b(false, "recordAdminSetting", PrivacyViewModel.access$000(this.f234330a));
            PrivacyViewModel.access$200(this.f234330a).setValue(2);
            return;
        L13:
            if (r101 != 9) goto L15;
            tt5.a.h(PrivacyViewModel.TAG, "getAdmin: no privacy");
            yi5.b.b(false, PrivacyViewModel.allowReadList, PrivacyViewModel.access$000(this.f234330a));
            PrivacyViewModel.access$200(this.f234330a).setValue(1);
            PrivacyViewModel.access$300(this.f234330a).setValue(Boolean.FALSE);
            return;
        L15:
            PrivacyViewModel.access$400(this.f234330a);
            return;
        }
    }

    public class b implements e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyViewModel f234331a;

        public b(PrivacyViewModel r100) {
            this.f234331a = r100;
        }
    }

    public class c implements i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f234332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrivacyViewModel f234333b;

        @Override // xi5.i.c
        public final void a() {
            PrivacyViewModel.access$602(this.f234333b, null);
            if (this.f234332a == false) goto L5;
            com.bytedance.ee.bear.middleground.record.a.b("read_record_open");
        L6:
            Toast.showSuccessText(eu5.b.f474075a, R.string.Doc_Facade_SetSuccess);
            yi5.b.b(this.f234332a, PrivacyViewModel.allowReadList, PrivacyViewModel.access$000(this.f234333b));
            PrivacyViewModel.access$200(this.f234333b).setValue(1);
            PrivacyViewModel.access$300(this.f234333b).setValue(Boolean.valueOf(this.f234332a));
            return;
        L5:
            com.bytedance.ee.bear.middleground.record.a.b("read_record_close");
            goto L6
        }

        @Override // xi5.i.c
        public final void onError(Throwable r100) throws Exception {
            PrivacyViewModel.access$602(this.f234333b, null);
            PrivacyViewModel.access$200(this.f234333b).setValue(3);
            Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Facade_SetFailed);
        }

        public c(PrivacyViewModel r100, boolean r101) {
            this.f234333b = r100;
            this.f234332a = r101;
        }
    }

    public class d implements i.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f234334a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrivacyViewModel f234335b;

        @Override // xi5.i.c
        public final void a() {
            PrivacyViewModel.access$702(this.f234335b, null);
            yi5.b.b(this.f234334a, PrivacyViewModel.allowShowAvatar, PrivacyViewModel.access$000(this.f234335b));
            PrivacyViewModel.access$800(this.f234335b).setValue(Boolean.valueOf(this.f234334a));
            Toast.showSuccessText(eu5.b.f474075a, R.string.Doc_Facade_SetSuccess);
        }

        @Override // xi5.i.c
        public final void onError(Throwable r100) throws Exception {
            PrivacyViewModel.access$702(this.f234335b, null);
            tt5.a.d(PrivacyViewModel.TAG, "pushShowAvatar error" + r100);
            Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Facade_SetFailed);
        }

        public d(PrivacyViewModel r100, boolean r101) {
            this.f234335b = r100;
            this.f234334a = r101;
        }
    }

    public static /* synthetic */ void Mo(Throwable r100) {
        lambda$handleAvatar$2(r100);
    }

    public static /* synthetic */ void No(PrivacyViewModel r100, AvatarSettingResult r101) {
        r100.lambda$handleAvatar$1(r101);
    }

    public static /* synthetic */ AvatarSettingResult yo(Boolean r100, PrivacyResult r101) {
        return lambda$handleAvatar$0(r100, r101);
    }

    private void getPrivacy() {
        tt5.a.h(TAG, "getPrivacy: ..");
        Disposable r100 = this.disposableGet;
        if (r100 == null) goto L5;
        r100.dispose();
        this.disposableGet = null;
    L5:
        e r101 = this.mGetPrivacyExecutor;
        b r102 = new b(this);
        r101.getClass();
        this.disposableGet = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new e.b()).a(new NetService.f("/space/api/user_properties/get/")).subscribe(new xi5.c(r102), new xi5.d(r102));
    }

    private void handleAvatar() {
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L6;
        this.stateMutableLiveData.setValue(11);
        return;
    L6:
        tt5.a.h(TAG, "start handleAvatar");
        g r100 = this.mGetShowAvatarExecutor;
        r100.getClass();
        NetService.f r101 = new NetService.f("/space/api/platform/ccm_setting/admin_tenant_setting");
        r101.f216906c = 2;
        r101.b("settingKey", "allow_config_show_collaboration_avatar");
        NetService r102 = r100.f563960a;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mNetService");
        r102 = null;
    L10:
        Flowable r103 = r102.Vc(new g.a()).a(r101).map(h.f563961a);
        Flowable r104 = this.mGetPrivacyExecutor.f563955a.Vc(new e.b()).a(new NetService.f("/space/api/user_properties/get/")).map(new xi5.b());
        this.compositeDisposable.add(Flowable.zip(r103, r104, new n()).subscribe(new o(this), new p()));
    }

    private void handleCache() {
        boolean r100 = yi5.b.a("avatarAdminSetting", this.delegate);
        boolean r101 = yi5.b.a(allowShowAvatar, this.delegate);
        boolean r102 = yi5.b.a(allowReadList, this.delegate);
        boolean r103 = yi5.b.a("recordAdminSetting", this.delegate);
        j r104 = new j(r102, r100, r103, r101);
        this.userSettingLiveData.setValue(r104);
        if (r100 == true) goto L5;
        if (r103 == true) goto L5;
        return;
    L5:
        this.stateMutableLiveData.setValue(12);
    }

    public void destroy() {
        this.compositeDisposable.clear();
    }

    public void getData() {
        Disposable r100 = this.disposableAdmin;
        if (r100 == null) goto L6;
        r100.dispose();
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
        if (this.stateMutableLiveData.getValue().intValue() == 4) goto L11;
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

    public static /* synthetic */ vo5.a access$000(PrivacyViewModel r100) {
        return r100.delegate;
    }

    public static /* synthetic */ MutableLiveData access$200(PrivacyViewModel r100) {
        return r100.stateMutableLiveData;
    }

    public static /* synthetic */ MutableLiveData access$300(PrivacyViewModel r100) {
        return r100.isCheckMutableLiveData;
    }

    public static /* synthetic */ void access$400(PrivacyViewModel r100) {
        r100.getPrivacy();
    }

    public static /* synthetic */ MutableLiveData access$800(PrivacyViewModel r100) {
        return r100.showAvatarLiveData;
    }

    private /* synthetic */ void lambda$handleAvatar$1(AvatarSettingResult r100) throws Exception {
        tt5.a.h(TAG, "avatar handleAvatar" + r100);
        yi5.b.b(r100.getAvatarAdminSetting(), "avatarAdminSetting", this.delegate);
        yi5.b.b(r100.getAllowShowCollaboration(), allowShowAvatar, this.delegate);
        if (r100.getAvatarAdminSetting() == true) goto L6;
        this.stateMutableLiveData.setValue(5);
        return;
    L6:
        this.stateMutableLiveData.setValue(6);
        this.showAvatarLiveData.setValue(Boolean.valueOf(r100.getAllowShowCollaboration()));
    }

    private static /* synthetic */ void lambda$handleAvatar$2(Throwable r100) throws Exception {
        tt5.a.d(TAG, "getAvatar error" + r100);
    }

    public void pushPrivacy(boolean r100) {
        tt5.a.h(TAG, "pushPrivacy: ..");
        Disposable r101 = this.disposableSet;
        if (r101 == null) goto L5;
        r101.dispose();
        this.disposableSet = null;
    L5:
        this.disposableSet = this.mSetPrivacyExecutor.a(r100, new c(this, r100), allowReadList);
    }

    public void pushShowAvatar(boolean r100) {
        tt5.a.h(TAG, "pushShowAvatar: ..");
        Disposable r101 = this.disposablePushAvatar;
        if (r101 == null) goto L5;
        r101.dispose();
        this.disposablePushAvatar = null;
    L5:
        this.disposablePushAvatar = this.mSetPrivacyExecutor.a(r100, new d(this, r100), allowShowAvatar);
    }

    public static /* synthetic */ Disposable access$102(PrivacyViewModel r100, Disposable r101) {
        r100.disposableAdmin = r101;
        return r101;
    }

    public static /* synthetic */ Disposable access$502(PrivacyViewModel r100, Disposable r101) {
        r100.disposableGet = r101;
        return r101;
    }

    public static /* synthetic */ Disposable access$602(PrivacyViewModel r100, Disposable r101) {
        r100.disposableSet = r101;
        return r101;
    }

    public static /* synthetic */ Disposable access$702(PrivacyViewModel r100, Disposable r101) {
        r100.disposablePushAvatar = r101;
        return r101;
    }

    private static /* synthetic */ AvatarSettingResult lambda$handleAvatar$0(Boolean r100, PrivacyResult r101) throws Exception {
        return new AvatarSettingResult(r101.getAllowShowCollaboration(), r100.booleanValue());
    }

    public void attach(String r100, int r101, NetService r102, vo5.a r103) {
        this.token = r100;
        this.objType = r101;
        this.mGetRecordListExecutor = new f();
        this.mGetPrivacyExecutor = new e(r102);
        this.mSetPrivacyExecutor = new i();
        this.mGetShowAvatarExecutor = new g(r102);
        this.delegate = r103;
    }
}
