package com.bytedance.ee.bear.middleground.permission.custompassword;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.DefaultResponse;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.CreatePasswordResult;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.PasswordLevel;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.SavePasswordReq;
import com.bytedance.ee.bear.middleground.permission.custompassword.model.TriggerAction;
import com.bytedance.ee.bear.middleground.permission.custompassword.state.PasswordItemState;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.PasswordCheckRules;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.Gson;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\nJ\b\u0010\u0018\u001a\u00020\u0014H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\b\u0010\u001b\u001a\u00020\u0014H\u0014J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\u001d\u001a\u00020\u0014J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\b\u0010!\u001a\u00020\bH\u0002J&\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nJ\u0016\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "uiResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/CheckUiResult;", "hasLoadData", "", "password", "", "saveResult", "dataModel", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomDataModel;", "fetcher", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/CustomPasswordFetcher;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "hasSaveSuccess", "doStartMode", "", "isHasSaveSuccess", "init", WikiFolderPushPlugin.DATA, "enterNoRulesMode", "getSaveResult", "getPasswordLiveData", "onCleared", "getUiResult", "createRandomPassword", "getLoadData", "ruleLoadSuccess", "precheckSave", "hasDenyTipsShow", "savePassword", ResourceData.KEY_TOKEN, ResourceData.KEY_TYPE, "", "changeType", "updatePasswordView", "triggerAction", "Lcom/bytedance/ee/bear/middleground/permission/custompassword/model/TriggerAction;", "onDestroy", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final /* synthetic */ CustomSettingViewModel a;

        public b(CustomSettingViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            CreatePasswordResult r4 = (CreatePasswordResult) r3;
            tt5.a.b(CustomSettingViewModel.TAG, "createRandomPassword success");
            Toast.cancelLoading();
            this.a.getPasswordLiveData().postValue(r4.getPassword());
            CustomSettingViewModel r0 = this.a;
            TriggerAction r1 = TriggerAction.DEFAULT;
            String r5 = r4.getPassword();
            if (r5 != null) goto L5;
            r5 = "";
        L5:
            r0.updatePasswordView(r1, r5);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            Toast.cancelLoading();
            Toast.showFailureText(eu5.b.a, 2131888748);
            tt5.a.d(CustomSettingViewModel.TAG, "savePassword " + ((Throwable) r3).getMessage());
        }
    }

    public static final class d implements com.bytedance.ee.bear.middleground.permission.custompassword.a.b {
        public final /* synthetic */ CustomSettingViewModel a;

        public d(CustomSettingViewModel r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.custompassword.a.b
        public final void a(boolean r2) {
            if (r2 == true) goto L4;
            CustomSettingViewModel.access$enterNoRulesMode(this.a);
            return;
        L4:
            tt5.a.b(CustomSettingViewModel.TAG, "init success");
            CustomSettingViewModel.access$doStartMode(this.a);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ CustomSettingViewModel b;
        public final /* synthetic */ String c;

        public e(String r1, CustomSettingViewModel r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            DefaultResponse r6 = (DefaultResponse) r5;
            tt5.a.b(CustomSettingViewModel.TAG, "savePassword success");
            com.bytedance.ee.bear.middleground.permission.c.q("save", this.a, Boolean.TRUE, Boolean.FALSE, 32);
            Toast.cancelLoading();
            this.b.getSaveResult().postValue(this.c);
            CustomSettingViewModel.access$setHasSaveSuccess$p(this.b, true);
            this.b.updatePasswordView(TriggerAction.LOSE_FOCUS, this.c);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CustomSettingViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public f(CustomSettingViewModel r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r6) {
            NetService.ServerErrorException r7 = (Throwable) r6;
            Toast.cancelLoading();
            if ((r7 instanceof NetService.ServerErrorException) == false) goto L5;
            int r0 = r7.getCode();
        L6:
            com.bytedance.ee.bear.middleground.permission.custompassword.a r1 = CustomSettingViewModel.access$getDataModel$p(this.a);
            String r2 = this.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "changeType");
            if (r0 != 10052) goto L9;
            Boolean r3 = Boolean.FALSE;
            com.bytedance.ee.bear.middleground.permission.c.p("save", r2, r3, r3, Integer.valueOf(r0));
            int r4 = 2131888746;
        L13:
            this.a.updatePasswordView(TriggerAction.LOSE_FOCUS, this.c);
            Toast.showFailureText(eu5.b.a, r4);
            tt5.a.d(CustomSettingViewModel.TAG, "savePassword " + r7.getMessage());
            return;
        L9:
            if (r0 == 14005) goto L11;
            Boolean r5 = Boolean.FALSE;
            com.bytedance.ee.bear.middleground.permission.c.p("save", r2, r5, r5, Integer.valueOf(r0));
            r4 = 2131888755;
            goto L13
        L11:
            com.bytedance.ee.bear.middleground.permission.c.p("save", r2, Boolean.FALSE, Boolean.TRUE, Integer.valueOf(r0));
            r4 = 2131888752;
            goto L13
        L5:
            r0 = -1;
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
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(eu5.b.a, 2131887782);
        return;
    L6:
        Application r0 = eu5.b.a;
        Toast.showLoading(r0, r0.getString(2131888312));
        com.bytedance.ee.bear.middleground.permission.custompassword.b r1 = this.fetcher;
        r1.getClass();
        NetService.f r2 = new NetService.f("/space/api/suite/permission/password/random/");
        ((NetService.e) r2).c = 2;
        Disposable r3 = r1.a.Vc(new kh5.a()).a(r2).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new b(this), c.a);
        this.compositeDisposable.add(r3);
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
        jh5.b r0 = (jh5.b) getUiResult().getValue();
        if (r0 == null) goto L22;
        com.bytedance.ee.bear.middleground.permission.custompassword.a r2 = this.dataModel;
        ArrayList<jh5.c> r3 = r0.b;
        if (r3 != null) goto L7;
        r3 = new ArrayList();
    L7:
        ArrayList<jh5.c> r1 = r0.c;
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "passList");
        Intrinsics.checkNotNullParameter(r1, "warningList");
        Iterator<jh5.c> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        if (r4.next().b != PasswordItemState.STATE_WARNING) goto L12;
    L15:
        return true;
    L16:
        Iterator<jh5.c> r5 = r1.iterator();
    L18:
        if (r5.hasNext() == false) goto L30;
        if (r5.next().b != PasswordItemState.STATE_WARNING) goto L18;
    L30:
        return false;
    L22:
        return false;
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final boolean precheckSave() {
        jh5.b r0 = (jh5.b) getUiResult().getValue();
        if (r0 != null) goto L5;
        return true;
    L5:
        if (hasDenyTipsShow() == false) goto L9;
        Toast.showFailureText(eu5.b.a, 2131888751);
        return false;
    L9:
        if (r0.a.b != PasswordLevel.NO) goto L14;
        return false;
    L14:
        return true;
    }

    public final boolean ruleLoadSuccess() {
        Boolean r0 = (Boolean) getLoadData().getValue();
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.booleanValue();
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

    public static final /* synthetic */ void access$doStartMode(CustomSettingViewModel r0) {
        r0.doStartMode();
    }

    public static final /* synthetic */ void access$enterNoRulesMode(CustomSettingViewModel r0) {
        r0.enterNoRulesMode();
    }

    public static final /* synthetic */ com.bytedance.ee.bear.middleground.permission.custompassword.a access$getDataModel$p(CustomSettingViewModel r0) {
        return r0.dataModel;
    }

    public final void init(String r5) {
        this.compositeDisposable = new CompositeDisposable();
        if (TextUtils.isEmpty(r5) == true) goto L17;
        com.bytedance.ee.bear.middleground.permission.custompassword.a r0 = this.dataModel;
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        d r1 = new d(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r1, "call");
        r0.a = (PasswordCheckRules) new Gson().fromJson(r5, PasswordCheckRules.class);     // Catch: Throwable -> L10
    L13:
        if (r0.a == null) goto L15;
        boolean r6 = true;
    L16:
        r1.a(r6);
        return;
    L15:
        r6 = false;
    L10:
        th = move-exception;
        tt5.a.d("CustomDataModel", "parseRuleData " + th.getMessage());
        goto L13
    L17:
        enterNoRulesMode();
    }

    public static final /* synthetic */ void access$setHasSaveSuccess$p(CustomSettingViewModel r0, boolean r1) {
        r0.hasSaveSuccess = r1;
    }

    public final void updatePasswordView(TriggerAction r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "triggerAction");
        Intrinsics.checkNotNullParameter(r4, "password");
        com.bytedance.ee.bear.middleground.permission.custompassword.a r0 = this.dataModel;     // Catch: Throwable -> L8
        jh5.b r1 = (jh5.b) getUiResult().getValue();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        r1 = new jh5.b();     // Catch: Throwable -> L8
    L6:
        getUiResult().postValue(r0.c(r3, r4, r1));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.d(TAG, "updatePasswordView " + th.getMessage());
    }

    public final void savePassword(String r5, int r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "password");
        Intrinsics.checkNotNullParameter(r8, "changeType");
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L6;
        Toast.showFailureText(eu5.b.a, 2131887782);
        return;
    L6:
        Application r2 = eu5.b.a;
        Toast.showLoading(r2, r2.getString(2131888757));
        com.bytedance.ee.bear.middleground.permission.custompassword.b r3 = this.fetcher;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "password");
        NetService.d r0 = r3.a.Vc(new ax4.a());
        NetService.f r1 = new NetService.f("/space/api/suite/permission/password/commit/");
        ((NetService.e) r1).i = false;
        ((NetService.e) r1).c = 1;
        SavePasswordReq r4 = new SavePasswordReq();
        r4.setToken(r5);
        r4.setType(Integer.valueOf(r6));
        r4.setPassword(r7);
        ((NetService.e) r1).j = JSON.toJSONString(r4);
        Disposable r9 = r0.a(r1).observeOn(fo5.d.e()).subscribeOn(fo5.d.d()).subscribe(new e(r8, this, r7), new f(this, r8, r7));
        this.compositeDisposable.add(r9);
    }
}
