package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.app.Application;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.CreatePasswordResult;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.SavePasswordReq;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.TriggerAction;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.PasswordCheckRules;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\b\u0010\u0018\u001a\u00020\u0014H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u001d\u001a\u00020\u0014J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u00020\bH\u0002J&\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nJ\u0016\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "uiResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/CheckUiResult;", "hasLoadData", "", "password", "", "saveResult", "dataModel", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomDataModel;", "fetcher", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomPasswordFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "hasSaveSuccess", "doStartMode", "", "isHasSaveSuccess", "init", "data", "enterNoRulesMode", "getSaveResult", "getPasswordLiveData", "onCleared", "getUiResult", "createRandomPassword", "getLoadData", "ruleLoadSuccess", "precheckSave", "hasDenyTipsShow", "savePassword", "token", "type", "", "changeType", "updatePasswordView", "triggerAction", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/TriggerAction;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomSettingViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "CustomSettingViewModel";
    private CompositeDisposable compositeDisposable;
    private final com.bytedance.ee.bear.middleground.permission.custompassword.a dataModel;
    private final com.bytedance.ee.bear.middleground.permission.custompassword.b fetcher;
    private MutableLiveData<Boolean> hasLoadData;
    private boolean hasSaveSuccess;
    private MutableLiveData<String> password;
    private MutableLiveData<String> saveResult;
    private MutableLiveData<jh5.b> uiResult;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomSettingViewModel f233798a;

        public b(CustomSettingViewModel r100) {
            this.f233798a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            CreatePasswordResult r101 = (CreatePasswordResult) r100;
            tt5.a.b(CustomSettingViewModel.TAG, "createRandomPassword success");
            Toast.cancelLoading();
            this.f233798a.getPasswordLiveData().postValue(r101.getPassword());
            CustomSettingViewModel r102 = this.f233798a;
            TriggerAction r103 = TriggerAction.DEFAULT;
            String r104 = r101.getPassword();
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            r102.updatePasswordView(r103, r104);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f233799a = null;

        static {
            f233799a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Toast.cancelLoading();
            Toast.showFailureText(eu5.b.f474075a, R.string.LarkCCM_CM_CustomPassword_GenerationFailed_Toast);
            tt5.a.d(CustomSettingViewModel.TAG, "savePassword " + ((Throwable) r100).getMessage());
        }
    }

    public static final class d implements com.bytedance.ee.bear.middleground.permission.custompassword.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomSettingViewModel f233800a;

        public d(CustomSettingViewModel r100) {
            this.f233800a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.custompassword.a.b
        public final void a(boolean r100) {
            if (r100 == true) goto L4;
            CustomSettingViewModel.access$enterNoRulesMode(this.f233800a);
            return;
        L4:
            tt5.a.b(CustomSettingViewModel.TAG, "init success");
            CustomSettingViewModel.access$doStartMode(this.f233800a);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f233801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CustomSettingViewModel f233802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f233803c;

        public e(String r100, CustomSettingViewModel r101, String r102) {
            this.f233801a = r100;
            this.f233802b = r101;
            this.f233803c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DefaultResponse r101 = (DefaultResponse) r100;
            tt5.a.b(CustomSettingViewModel.TAG, "savePassword success");
            com.bytedance.ee.bear.middleground.permission.c.q(SVGRenderEngine.SAVE, this.f233801a, Boolean.TRUE, Boolean.FALSE, 32);
            Toast.cancelLoading();
            this.f233802b.getSaveResult().postValue(this.f233803c);
            CustomSettingViewModel.access$setHasSaveSuccess$p(this.f233802b, true);
            this.f233802b.updatePasswordView(TriggerAction.LOSE_FOCUS, this.f233803c);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomSettingViewModel f233804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f233805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f233806c;

        public f(CustomSettingViewModel r100, String r101, String r102) {
            this.f233804a = r100;
            this.f233805b = r101;
            this.f233806c = r102;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Toast.cancelLoading();
            if ((r101 instanceof NetService.ServerErrorException) == false) goto L5;
            int r102 = ((NetService.ServerErrorException) r101).getCode();
        L6:
            com.bytedance.ee.bear.middleground.permission.custompassword.a r103 = CustomSettingViewModel.access$getDataModel$p(this.f233804a);
            String r104 = this.f233805b;
            r103.getClass();
            Intrinsics.checkNotNullParameter(r104, "changeType");
            if (r102 != 10052) goto L9;
            Boolean r105 = Boolean.FALSE;
            com.bytedance.ee.bear.middleground.permission.c.p(SVGRenderEngine.SAVE, r104, r105, r105, Integer.valueOf(r102));
            int r106 = R.string.LarkCCM_CM_CustomPassword_DocsTurnedOffSharingViaLink_Toast;
        L13:
            this.f233804a.updatePasswordView(TriggerAction.LOSE_FOCUS, this.f233806c);
            Toast.showFailureText(eu5.b.f474075a, r106);
            tt5.a.d(CustomSettingViewModel.TAG, "savePassword " + r101.getMessage());
            return;
        L9:
            if (r102 == 14005) goto L11;
            Boolean r107 = Boolean.FALSE;
            com.bytedance.ee.bear.middleground.permission.c.p(SVGRenderEngine.SAVE, r104, r107, r107, Integer.valueOf(r102));
            r106 = R.string.LarkCCM_CM_CustomPassword_SaveFailed_Toast;
            goto L13
        L11:
            com.bytedance.ee.bear.middleground.permission.c.p(SVGRenderEngine.SAVE, r104, Boolean.FALSE, Boolean.TRUE, Integer.valueOf(r102));
            r106 = R.string.LarkCCM_CM_CustomPassword_PasswordTooWeak_Toast;
            goto L13
        L5:
            r102 = -1;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    private final void doStartMode() {
        updatePasswordView(TriggerAction.CLEAR, "");
    }

    public final void createRandomPassword() {
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Facade_NetworkInterrutedRetry);
        return;
    L6:
        Application r100 = eu5.b.f474075a;
        Toast.showLoading(r100, r100.getString(R.string.Doc_Widget_LoadingWithoutEllipsis));
        com.bytedance.ee.bear.middleground.permission.custompassword.b r101 = this.fetcher;
        r101.getClass();
        NetService.f r102 = new NetService.f("/space/api/suite/permission/password/random/");
        r102.f216906c = 2;
        Disposable r103 = r101.f233810a.Vc(new kh5.a()).a(r102).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new b(this), c.f233799a);
        this.compositeDisposable.add(r103);
    }

    public final void onDestroy() {
        this.compositeDisposable.dispose();
    }

    public CustomSettingViewModel() {
        this.uiResult = new MutableLiveData();
        this.hasLoadData = new MutableLiveData();
        this.password = new MutableLiveData();
        this.saveResult = new MutableLiveData();
        this.dataModel = new com.bytedance.ee.bear.middleground.permission.custompassword.a();
        this.fetcher = new com.bytedance.ee.bear.middleground.permission.custompassword.b((NetService) e0c.k.a(LarkContext.getApplication(), NetService.class));
        this.compositeDisposable = new CompositeDisposable();
    }

    private final void enterNoRulesMode() {
        getLoadData().setValue(Boolean.FALSE);
    }

    private final boolean hasDenyTipsShow() {
        jh5.b r100 = getUiResult().getValue();
        if (r100 == null) goto L22;
        com.bytedance.ee.bear.middleground.permission.custompassword.a r101 = this.dataModel;
        ArrayList<jh5.c> r102 = r100.f499085b;
        if (r102 != null) goto L7;
        r102 = new ArrayList();
    L7:
        ArrayList<jh5.c> r103 = r100.f499086c;
        if (r103 != null) goto L10;
        r103 = new ArrayList();
    L10:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "passList");
        Intrinsics.checkNotNullParameter(r103, "warningList");
        Iterator<jh5.c> r104 = r102.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        if (r104.next().f499089b != PasswordItemState.STATE_WARNING) goto L12;
    L15:
        return true;
    L16:
        Iterator<jh5.c> r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L30;
        if (r105.next().f499089b != PasswordItemState.STATE_WARNING) goto L18;
    L30:
        return false;
    L22:
        return false;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final boolean precheckSave() {
        jh5.b r100 = getUiResult().getValue();
        if (r100 != null) goto L5;
        return true;
    L5:
        if (hasDenyTipsShow() == false) goto L9;
        Toast.showFailureText(eu5.b.f474075a, R.string.LarkCCM_CM_CustomPassword_PasswordDoesntMeetRequirements_Toast);
        return false;
    L9:
        if (r100.f499084a.f499091b != PasswordLevel.NO) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean ruleLoadSuccess() {
        Boolean r100 = getLoadData().getValue();
        if (r100 != null) goto L5;
        return true;
    L5:
        return r100.booleanValue();
    }

    public final MutableLiveData<Boolean> getLoadData() {
        return this.hasLoadData;
    }

    public final MutableLiveData<String> getPasswordLiveData() {
        return this.password;
    }

    public final MutableLiveData<String> getSaveResult() {
        return this.saveResult;
    }

    public final MutableLiveData<jh5.b> getUiResult() {
        return this.uiResult;
    }

    public final boolean isHasSaveSuccess() {
        return this.hasSaveSuccess;
    }

    public static final /* synthetic */ void access$doStartMode(CustomSettingViewModel r100) {
        r100.doStartMode();
    }

    public static final /* synthetic */ void access$enterNoRulesMode(CustomSettingViewModel r100) {
        r100.enterNoRulesMode();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.permission.custompassword.a access$getDataModel$p(CustomSettingViewModel r100) {
        return r100.dataModel;
    }

    public final void init(String r100) {
        this.compositeDisposable = new CompositeDisposable();
        if (TextUtils.isEmpty(r100) == true) goto L17;
        com.bytedance.ee.bear.middleground.permission.custompassword.a r101 = this.dataModel;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        d r102 = new d(this);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r102, NotificationCompat.CATEGORY_CALL);
        r101.f233807a = (PasswordCheckRules) new Gson().fromJson(r100, PasswordCheckRules.class);     // Catch: Throwable -> L10
    L13:
        if (r101.f233807a == null) goto L15;
        boolean r103 = true;
    L16:
        r102.a(r103);
        return;
    L15:
        r103 = false;
    L10:
        th = move-exception;
        tt5.a.d("CustomDataModel", "parseRuleData " + th.getMessage());
        goto L13
    L17:
        enterNoRulesMode();
    }

    public static final /* synthetic */ void access$setHasSaveSuccess$p(CustomSettingViewModel r100, boolean r101) {
        r100.hasSaveSuccess = r101;
    }

    public final void updatePasswordView(TriggerAction r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "triggerAction");
        Intrinsics.checkNotNullParameter(r101, "password");
        com.bytedance.ee.bear.middleground.permission.custompassword.a r102 = this.dataModel;     // Catch: Throwable -> L8
        jh5.b r103 = getUiResult().getValue();     // Catch: Throwable -> L8
        if (r103 != null) goto L6;
        r103 = new jh5.b();     // Catch: Throwable -> L8
    L6:
        getUiResult().postValue(r102.c(r100, r101, r103));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.d(TAG, "updatePasswordView " + th.getMessage());
    }

    public final void savePassword(String r100, int r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "password");
        Intrinsics.checkNotNullParameter(r103, "changeType");
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(eu5.b.f474075a, R.string.Doc_Facade_NetworkInterrutedRetry);
        return;
    L6:
        Application r104 = eu5.b.f474075a;
        Toast.showLoading(r104, r104.getString(R.string.LarkCCM_CM_CustomPassword_Saving_Toast));
        com.bytedance.ee.bear.middleground.permission.custompassword.b r105 = this.fetcher;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "password");
        NetService.d r106 = r105.f233810a.Vc(new ax4.a());
        NetService.f r107 = new NetService.f("/space/api/suite/permission/password/commit/");
        r107.f216912i = false;
        r107.f216906c = 1;
        SavePasswordReq r108 = new SavePasswordReq();
        r108.setToken(r100);
        r108.setType(Integer.valueOf(r101));
        r108.setPassword(r102);
        r107.f216913j = JSON.toJSONString(r108);
        Disposable r109 = r106.a(r107).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new e(r103, this, r102), new f(this, r103, r102));
        this.compositeDisposable.add(r109);
    }
}
