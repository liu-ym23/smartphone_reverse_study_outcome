package com.bytedance.ee.bear.document.setting;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.document.setting.model.UserInfoModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u0013\u001a\u00020\fH\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\tJ\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataModel", "Lcom/bytedance/ee/bear/document/setting/SettingDataModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "autoAuthLeader", "Landroidx/lifecycle/MutableLiveData;", "", "permissionType", "", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "hasLeader", "init", "", "getHasLeader", "getStorePermType", "fetchSetting", "transformHasLeader", "userInfoModel", "Lcom/bytedance/ee/bear/document/setting/model/UserInfoModel;", "refreshPermType", "transformCommonSetting", "autoAuthStr", "", "transformSetting", "settingInfo", "Lcom/bytedance/ee/bear/document/setting/DocumentSettingInfo;", "getAutoAuthLeader", "getPermissionType", "permissionTypeClick", "leaderAuthClick", "autoAuth", "getAnyText", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "onDestroyed", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentSettingViewModel extends ViewModel {
    public static final a Companion = null;
    public static final boolean DEFAULT_AUTO_LEADER_AUTH = false;
    public static final String KEY_ACCESS_PERM_TYPE = "perm_type";
    public static final String KEY_AUTO_LEADER_AUTH = "auto_leader_auth";
    public static final String TAG = "DocumentSettingViewModel";
    private MutableLiveData<Boolean> autoAuthLeader;
    private CompositeDisposable compositeDisposable;
    private final com.bytedance.ee.bear.document.setting.j dataModel;
    private MutableLiveData<Boolean> hasLeader;
    private NetService netService;
    private MutableLiveData<Integer> permissionType;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentSettingViewModel f221739a;

        public b(DocumentSettingViewModel r100) {
            this.f221739a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocumentSettingInfo r101 = (DocumentSettingInfo) r100;
            DocumentSettingViewModel r102 = this.f221739a;
            Intrinsics.checkNotNull(r101);
            DocumentSettingViewModel.access$transformSetting(r102, r101);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f221740a = null;

        static {
            f221740a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d(DocumentSettingViewModel.TAG, "fetchSetting");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentSettingViewModel f221741a;

        public d(DocumentSettingViewModel r100) {
            this.f221741a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UserInfoModel r101 = (UserInfoModel) ((Result) r100).data;
            if (r101 == null) goto L6;
            DocumentSettingViewModel.access$transformHasLeader(this.f221741a, r101);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e<T> f221742a = null;

        static {
            f221742a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.d(DocumentSettingViewModel.TAG, "fetchSetting fail, " + ((Throwable) r100).getMessage());
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentSettingViewModel f221743a;

        public f(DocumentSettingViewModel r100) {
            this.f221743a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocumentSettingViewModel r101 = this.f221743a;
            DocumentSettingViewModel.access$transformCommonSetting(r101, (String) r100);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f221744a = null;

        static {
            f221744a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.d(DocumentSettingViewModel.TAG, "fetchSetting");
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f221745a;

        public h(boolean r100) {
            this.f221745a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DefaultResponse r101 = (DefaultResponse) r100;
            ay4.b.d("document", 6).putBoolean(DocumentSettingViewModel.KEY_AUTO_LEADER_AUTH, this.f221745a);
            tt5.a.h(DocumentSettingViewModel.TAG, "leaderAuthClick success");
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentSettingViewModel f221746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f221747b;

        public i(DocumentSettingViewModel r100, boolean r101) {
            this.f221746a = r100;
            this.f221747b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f221746a.getAutoAuthLeader().postValue(Boolean.valueOf(!this.f221747b));
            tt5.a.d(DocumentSettingViewModel.TAG, "leaderAuthClick fail");
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f221748a;

        public j(int r100) {
            this.f221748a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DefaultResponse r101 = (DefaultResponse) r100;
            ay4.b.d("document", 6).putInt(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, this.f221748a);
            tt5.a.h("DocumentPermTyeActivity", "permissionTypeClick success ");
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DocumentSettingViewModel f221749a;

        public k(DocumentSettingViewModel r100) {
            this.f221749a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f221749a.getPermissionType().postValue(this.f221749a.getPermissionType().getValue());
            tt5.a.d("DocumentPermTyeActivity", "permissionTypeClick fail ");
        }
    }

    static {
        Companion = new a();
    }

    private final int getStorePermType() {
        return ay4.b.d("document", 6).getInt(KEY_ACCESS_PERM_TYPE, 1);
    }

    public final void fetchSetting() {
        Disposable r100 = ((com.bytedance.ee.bear.e) org.koin.java.a.c(com.bytedance.ee.bear.e.class, null, null, 6)).b(this.netService).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new b(this), c.f221740a);
        this.compositeDisposable.add(r100);
        com.bytedance.ee.bear.document.setting.j r101 = this.dataModel;
        r101.getClass();
        DocCommonSettingsPuller r102 = new DocCommonSettingsPuller(r101.f221758a);
        DocCommonSettingsPuller.Params r103 = new DocCommonSettingsPuller.Params("im_share_leader");
        Intrinsics.checkNotNullParameter(r103, "params");
        NetService.f r104 = new NetService.f("/space/api/platform/common_setting/get/");
        r104.f216906c = 2;
        r104.b("scene", r103.getScene());
        Disposable r105 = r102.f221724a.Vc(new ax4.f()).a(r104).map(com.bytedance.ee.bear.document.setting.k.f221759a).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new f(this), g.f221744a);
        this.compositeDisposable.add(r105);
        com.bytedance.ee.bear.document.setting.j r106 = this.dataModel;
        r106.getClass();
        NetService.e r107 = new NetService.e();
        r107.f216905b = "/api/user/";
        r107.f216906c = 2;
        Disposable r108 = r106.f221758a.Vc(l.f221760a).a(r107).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new d(this), e.f221742a);
        this.compositeDisposable.add(r108);
    }

    public final void init() {
        boolean r100 = ay4.b.d("document", 6).getBoolean(KEY_AUTO_LEADER_AUTH, false);
        getAutoAuthLeader().setValue(Boolean.valueOf(r100));
        int r101 = getStorePermType();
        getPermissionType().setValue(Integer.valueOf(r101));
        boolean r102 = ay4.b.d("account", 6).getBoolean("key_has_leader", true);
        getHasLeader().setValue(Boolean.valueOf(r102));
        fetchSetting();
    }

    public final void onDestroyed() {
        this.compositeDisposable.dispose();
    }

    public DocumentSettingViewModel() {
        this.dataModel = new com.bytedance.ee.bear.document.setting.j((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class));
        this.compositeDisposable = new CompositeDisposable();
        this.autoAuthLeader = new MutableLiveData();
        this.permissionType = new MutableLiveData();
        this.netService = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        this.hasLeader = new MutableLiveData();
    }

    public final void refreshPermType() {
        int r100 = getStorePermType();
        getPermissionType().postValue(Integer.valueOf(r100));
    }

    public final MutableLiveData<Boolean> getAutoAuthLeader() {
        return this.autoAuthLeader;
    }

    public final MutableLiveData<Boolean> getHasLeader() {
        return this.hasLeader;
    }

    public final MutableLiveData<Integer> getPermissionType() {
        return this.permissionType;
    }

    private final void transformCommonSetting(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        getAutoAuthLeader().postValue(Boolean.valueOf(r101));
        ay4.b.d("document", 6).putBoolean(KEY_AUTO_LEADER_AUTH, r101);
        return;
    L5:
        if ("auto".equals(r100) == false) goto L7;
        r101 = true;
        goto L8
    }

    private final void transformHasLeader(UserInfoModel r100) {
        getHasLeader().postValue(Boolean.valueOf(r100.getHasLeader()));
        ay4.b.d("account", 6).putBoolean("key_has_leader", r100.getHasLeader());
    }

    private final void transformSetting(DocumentSettingInfo r100) {
        Integer r101 = r100.getPermissionType();
        if (r101 == null) goto L6;
        int r102 = r101.intValue();
        getPermissionType().postValue(Integer.valueOf(r102));
        ay4.b.d("document", 6).putInt(KEY_ACCESS_PERM_TYPE, r102);
        return;
    }

    public final String getAnyText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = xo5.a.c(r100, R.string.LarkCCM_IM_SharingSuggestions_AnyoneWithLinkCanView_Radio_Mob, "tenant_name", ((h0) e0c.k.a(LarkContext.getApplication(), h0.class)).G2().tenantName);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public final void leaderAuthClick(boolean r100) {
        com.bytedance.ee.bear.document.setting.j r101 = this.dataModel;
        r101.getClass();
        NetService.f r102 = new NetService.f("/space/api/platform/common_setting/update");
        r102.f216906c = 1;
        JSONObject r103 = new JSONObject();
        JSONArray r104 = new JSONArray();     // Catch: Exception -> L9
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L9
        if (r100 == false) goto L6;
        String r106 = "auto";
    L7:
        r105.put("scene", "im_share_leader");     // Catch: Exception -> L9
        r105.put("setting_value", r106);     // Catch: Exception -> L9
        r104.put(r105);     // Catch: Exception -> L9
        r103.put("settings", r104);     // Catch: Exception -> L9
        r102.f216913j = r103.toString();     // Catch: Exception -> L9
    L10:
        Disposable r107 = r101.f221758a.Vc(new ax4.a()).a(r102).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new h(r100), new i(this, r100));
        this.compositeDisposable.add(r107);
        return;
    L6:
        r106 = "close";
    L9:
        tt5.a.d("SettingDataModel", "jsonObject error");
        goto L10
    }

    public final void permissionTypeClick(int r100) {
        DocumentSettingRequest r101 = new DocumentSettingRequest();
        r101.setPermissionType(Integer.valueOf(r100));
        r101.setProperties(new DocumentSettingRequest.Property());
        Disposable r102 = ((com.bytedance.ee.bear.e) org.koin.java.a.c(com.bytedance.ee.bear.e.class, null, null, 6)).a(r101, this.netService).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new j(r100), new k(this));
        this.compositeDisposable.add(r102);
    }

    public static final /* synthetic */ void access$transformCommonSetting(DocumentSettingViewModel r100, String r101) {
        r100.transformCommonSetting(r101);
    }

    public static final /* synthetic */ void access$transformHasLeader(DocumentSettingViewModel r100, UserInfoModel r101) {
        r100.transformHasLeader(r101);
    }

    public static final /* synthetic */ void access$transformSetting(DocumentSettingViewModel r100, DocumentSettingInfo r101) {
        r100.transformSetting(r101);
    }
}
