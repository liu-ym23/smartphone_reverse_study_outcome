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
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\b\u0010\u0013\u001a\u00020\fH\u0002J\u0006\u0010\u0014\u001a\u00020\u0011J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0011J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\tJ\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\nJ\u000e\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/DocumentSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "dataModel", "Lcom/bytedance/ee/bear/document/setting/SettingDataModel;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "autoAuthLeader", "Landroidx/lifecycle/MutableLiveData;", "", "permissionType", "", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "hasLeader", "init", "", "getHasLeader", "getStorePermType", "fetchSetting", "transformHasLeader", "userInfoModel", "Lcom/bytedance/ee/bear/document/setting/model/UserInfoModel;", "refreshPermType", "transformCommonSetting", "autoAuthStr", "", "transformSetting", "settingInfo", "Lcom/bytedance/ee/bear/document/setting/DocumentSettingInfo;", "getAutoAuthLeader", "getPermissionType", "permissionTypeClick", "leaderAuthClick", "autoAuth", "getAnyText", "context", "Landroid/content/Context;", "onDestroyed", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ DocumentSettingViewModel a;

        public b(DocumentSettingViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DocumentSettingInfo r3 = (DocumentSettingInfo) r2;
            DocumentSettingViewModel r0 = this.a;
            Intrinsics.checkNotNull(r3);
            DocumentSettingViewModel.access$transformSetting(r0, r3);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            tt5.a.d(DocumentSettingViewModel.TAG, "fetchSetting");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DocumentSettingViewModel a;

        public d(DocumentSettingViewModel r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r2) {
            UserInfoModel r3 = (UserInfoModel) ((Result) r2).data;
            if (r3 == null) goto L6;
            DocumentSettingViewModel.access$transformHasLeader(this.a, r3);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            tt5.a.d(DocumentSettingViewModel.TAG, "fetchSetting fail, " + ((Throwable) r3).getMessage());
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ DocumentSettingViewModel a;

        public f(DocumentSettingViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DocumentSettingViewModel r0 = this.a;
            DocumentSettingViewModel.access$transformCommonSetting(r0, (String) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public static final g<T> a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            tt5.a.d(DocumentSettingViewModel.TAG, "fetchSetting");
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ boolean a;

        public h(boolean r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            DefaultResponse r4 = (DefaultResponse) r3;
            ay4.b.d("document", 6).putBoolean(DocumentSettingViewModel.KEY_AUTO_LEADER_AUTH, this.a);
            tt5.a.h(DocumentSettingViewModel.TAG, "leaderAuthClick success");
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ DocumentSettingViewModel a;
        public final /* synthetic */ boolean b;

        public i(DocumentSettingViewModel r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getAutoAuthLeader().postValue(Boolean.valueOf(!this.b));
            tt5.a.d(DocumentSettingViewModel.TAG, "leaderAuthClick fail");
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ int a;

        public j(int r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            DefaultResponse r4 = (DefaultResponse) r3;
            ay4.b.d("document", 6).putInt(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, this.a);
            tt5.a.h("DocumentPermTyeActivity", "permissionTypeClick success ");
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ DocumentSettingViewModel a;

        public k(DocumentSettingViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.getPermissionType().postValue(this.a.getPermissionType().getValue());
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
        Disposable r0 = ((com.bytedance.ee.bear.e) org.koin.java.a.c(com.bytedance.ee.bear.e.class, null, null, 6)).b(this.netService).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new b(this), c.a);
        this.compositeDisposable.add(r0);
        com.bytedance.ee.bear.document.setting.j r1 = this.dataModel;
        r1.getClass();
        DocCommonSettingsPuller r2 = new DocCommonSettingsPuller(r1.a);
        DocCommonSettingsPuller.Params r3 = new DocCommonSettingsPuller.Params("im_share_leader");
        Intrinsics.checkNotNullParameter(r3, "params");
        NetService.f r4 = new NetService.f("/space/api/platform/common_setting/get/");
        r4.c = 2;
        r4.b("scene", r3.getScene());
        Disposable r5 = r2.a.Vc(new ax4.f()).a(r4).map(com.bytedance.ee.bear.document.setting.k.a).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new f(this), g.a);
        this.compositeDisposable.add(r5);
        com.bytedance.ee.bear.document.setting.j r6 = this.dataModel;
        r6.getClass();
        NetService.e r7 = new NetService.e();
        r7.b = "/api/user/";
        r7.c = 2;
        Disposable r8 = r6.a.Vc(l.a).a(r7).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new d(this), e.a);
        this.compositeDisposable.add(r8);
    }

    public final void init() {
        boolean r0 = ay4.b.d("document", 6).getBoolean(KEY_AUTO_LEADER_AUTH, false);
        getAutoAuthLeader().setValue(Boolean.valueOf(r0));
        int r1 = getStorePermType();
        getPermissionType().setValue(Integer.valueOf(r1));
        boolean r2 = ay4.b.d("account", 6).getBoolean("key_has_leader", true);
        getHasLeader().setValue(Boolean.valueOf(r2));
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
        int r0 = getStorePermType();
        getPermissionType().postValue(Integer.valueOf(r0));
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

    private final void transformCommonSetting(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
    L7:
        boolean r4 = false;
    L8:
        getAutoAuthLeader().postValue(Boolean.valueOf(r4));
        ay4.b.d("document", 6).putBoolean(KEY_AUTO_LEADER_AUTH, r4);
        return;
    L5:
        if ("auto".equals(r3) == false) goto L7;
        r4 = true;
        goto L8
    }

    private final void transformHasLeader(UserInfoModel r3) {
        getHasLeader().postValue(Boolean.valueOf(r3.getHasLeader()));
        ay4.b.d("account", 6).putBoolean("key_has_leader", r3.getHasLeader());
    }

    private final void transformSetting(DocumentSettingInfo r3) {
        Integer r4 = r3.getPermissionType();
        if (r4 == null) goto L6;
        int r5 = r4.intValue();
        getPermissionType().postValue(Integer.valueOf(r5));
        ay4.b.d("document", 6).putInt(KEY_ACCESS_PERM_TYPE, r5);
        return;
    }

    public final String getAnyText(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        String r5 = xo5.a.c(r4, 2131889539, "tenant_name", ((h0) e0c.k.a(LarkContext.getApplication(), h0.class)).G2().tenantName);
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public final void leaderAuthClick(boolean r9) {
        com.bytedance.ee.bear.document.setting.j r0 = this.dataModel;
        r0.getClass();
        NetService.f r1 = new NetService.f("/space/api/platform/common_setting/update");
        r1.c = 1;
        JSONObject r2 = new JSONObject();
        JSONArray r3 = new JSONArray();     // Catch: Exception -> L9
        JSONObject r4 = new JSONObject();     // Catch: Exception -> L9
        if (r9 == false) goto L6;
        String r5 = "auto";
    L7:
        r4.put("scene", "im_share_leader");     // Catch: Exception -> L9
        r4.put("setting_value", r5);     // Catch: Exception -> L9
        r3.put(r4);     // Catch: Exception -> L9
        r2.put("settings", r3);     // Catch: Exception -> L9
        r1.j = r2.toString();     // Catch: Exception -> L9
    L10:
        Disposable r10 = r0.a.Vc(new ax4.a()).a(r1).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new h(r9), new i(this, r9));
        this.compositeDisposable.add(r10);
        return;
    L6:
        r5 = "close";
    L9:
        tt5.a.d("SettingDataModel", "jsonObject error");
        goto L10
    }

    public final void permissionTypeClick(int r5) {
        DocumentSettingRequest r0 = new DocumentSettingRequest();
        r0.setPermissionType(Integer.valueOf(r5));
        r0.setProperties(new DocumentSettingRequest.Property());
        Disposable r6 = ((com.bytedance.ee.bear.e) org.koin.java.a.c(com.bytedance.ee.bear.e.class, null, null, 6)).a(r0, this.netService).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new j(r5), new k(this));
        this.compositeDisposable.add(r6);
    }

    public static final /* synthetic */ void access$transformCommonSetting(DocumentSettingViewModel r0, String r1) {
        r0.transformCommonSetting(r1);
    }

    public static final /* synthetic */ void access$transformHasLeader(DocumentSettingViewModel r0, UserInfoModel r1) {
        r0.transformHasLeader(r1);
    }

    public static final /* synthetic */ void access$transformSetting(DocumentSettingViewModel r0, DocumentSettingInfo r1) {
        r0.transformSetting(r1);
    }
}
