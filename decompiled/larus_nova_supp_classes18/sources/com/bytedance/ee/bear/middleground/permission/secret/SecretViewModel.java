package com.bytedance.ee.bear.middleground.permission.secret;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.escape.request.EscapeRuleResult;
import com.bytedance.ee.bear.middleground.permission.secret.model.SecretApprovalResultModel;
import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0012J\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0012J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eJ\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u0012J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0016\u0010$\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 JL\u0010%\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020,\u0018\u00010+J\\\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001e2\u0014\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020,\u0018\u00010+2\b\u00100\u001a\u0004\u0018\u000101J\u0016\u00102\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 JH\u00103\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u001e2\u0006\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u000101J\b\u00109\u001a\u00020\u0018H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006;"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/SecretViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "secretListLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/VisibleSecretResult;", "secretModelData", "Lcom/bytedance/ee/bear/middleground/permission/secret/model/SecretApprovalModel;", "updateSecResultLiveData", "Lcom/bytedance/ee/bear/middleground/permission/secret/UpdateSecretLevelResult;", "secretApprovalModel", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretReviewModel;", "_escapeRuleLiveData", "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretApprovalDefModel;", "escapeRuleLiveData", "Landroidx/lifecycle/LiveData;", "getEscapeRuleLiveData", "()Landroidx/lifecycle/LiveData;", "getSecretModelData", "getSecretApprovalModel", "setSecretApprovalModel", "", "model", "getSecretLiveData", "getUpdateSecLiveData", "fetchEscapeRule", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "convertToSecretApprovalDefModel", "result", "Lcom/bytedance/ee/bear/middleground/permission/escape/request/EscapeRuleResult;", "fetchVisibleSecretLive", "createApproveReq", "approveCode", "originId", "applyId", "changeReason", "extraParams", "", "Ljava/io/Serializable;", "generateApproveReq", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/middleground/permission/secret/model/SecretApprovalResultModel;", "selectSecret", "Lcom/bytedance/ee/bear/secret/SecretLevel;", "fetchApprovalSecretLive", "updateSecret", "secLabelId", "reason", "name", "level", WikiFolderPushPlugin.WIKI_TOKEN, "onCleared", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretViewModel extends ViewModel {
    private static final String CREATE_APPROVAL_INS = "/space/api/sec_label/approval/instance/create/";
    public static final a Companion = null;
    private static final String TAG = "SecretViewModel";
    private static final String UPDATE_SECRET_API = "/space/api/sec_label/update/";
    private static final String VISIBLE_SECRET_API = "/space/api/sec_label/visible/";
    private final MutableLiveData<SecretApprovalDefModel> _escapeRuleLiveData;
    private final CompositeDisposable compositeDisposable;
    private final LiveData<SecretApprovalDefModel> escapeRuleLiveData;
    private final MutableLiveData<SecretReviewModel> secretApprovalModel;
    private final MutableLiveData<VisibleSecretResult> secretListLiveData;
    private final MutableLiveData<di5.a> secretModelData;
    private final MutableLiveData<UpdateSecretLevelResult> updateSecResultLiveData;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public b(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            SecretViewModel.access$getUpdateSecResultLiveData$p(this.a).setValue(new UpdateSecretLevelResult(true, null, ((SecretApprovalResultModel) r5).getInstance_code()));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public c(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            tt5.a.f(SecretViewModel.TAG, r6, false);
            SecretViewModel.access$getUpdateSecResultLiveData$p(this.a).setValue(new UpdateSecretLevelResult(false, r6, ""));
        }
    }

    public static final class d<T1, T2, T3, R> implements Function3 {
        public static final d<T1, T2, T3, R> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final Object apply(Object r2, Object r3, Object r4) {
            SecretApprovalDefModel r5 = (SecretApprovalDefModel) r2;
            SecretApprovalInstanceModel r6 = (SecretApprovalInstanceModel) r3;
            VisibleSecretResult r7 = (VisibleSecretResult) r4;
            Intrinsics.checkNotNullParameter(r5, "defModel");
            Intrinsics.checkNotNullParameter(r6, "instanceModel");
            Intrinsics.checkNotNullParameter(r7, "visibleResult");
            return new di5.a(r5, r6, r7);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public e(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData r0 = SecretViewModel.access$getSecretModelData$p(this.a);
            r0.setValue((di5.a) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public f(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f(SecretViewModel.TAG, (Throwable) r3, false);
            SecretViewModel.access$getSecretModelData$p(this.a).setValue(new di5.a());
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public g(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            SecretViewModel r0 = this.a;
            SecretApprovalDefModel r3 = SecretViewModel.access$convertToSecretApprovalDefModel(r0, (EscapeRuleResult) r2);
            SecretViewModel.access$get_escapeRuleLiveData$p(this.a).setValue(r3);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public h(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(SecretViewModel.TAG, "fetchEscapeRule error: " + r5.getMessage(), r5, false);
            MutableLiveData r6 = SecretViewModel.access$get_escapeRuleLiveData$p(this.a);
            SecretApprovalDefModel r0 = new SecretApprovalDefModel();
            r0.setSuccess(false);
            r6.setValue(r0);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public i(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData r0 = SecretViewModel.access$getSecretListLiveData$p(this.a);
            r0.setValue((VisibleSecretResult) r2);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public j(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f(SecretViewModel.TAG, (Throwable) r3, false);
            MutableLiveData r4 = SecretViewModel.access$getSecretListLiveData$p(this.a);
            VisibleSecretResult r0 = new VisibleSecretResult();
            ((Result) r0).data = new ArrayList();
            r4.setValue(r0);
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ String e;

        public k(SecretViewModel r1, String r2, String r3, int r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r8) {
            SimpleRequestResult r9 = (SimpleRequestResult) r8;
            tt5.a.h(SecretViewModel.TAG, "updateSecret succeed");
            boolean r1 = true;
            SecretViewModel.access$getUpdateSecResultLiveData$p(this.a).setValue(new UpdateSecretLevelResult(true, null, ""));
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().l(this.b, this.c + "", this.d);
            ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(this.b, this.c, this.d);
            if (this.e.length() > 0) goto L6;
            r1 = false;
        L6:
            if (r1 == false) goto L9;
            ((rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6)).Q(this.e, this.c, this.d);
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ SecretViewModel a;

        public l(SecretViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            tt5.a.f(SecretViewModel.TAG, r6, false);
            SecretViewModel.access$getUpdateSecResultLiveData$p(this.a).setValue(new UpdateSecretLevelResult(false, r6, ""));
        }
    }

    static {
        Companion = new a();
    }

    public SecretViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.secretListLiveData = new MutableLiveData();
        this.secretModelData = new MutableLiveData();
        this.updateSecResultLiveData = new MutableLiveData();
        this.secretApprovalModel = new MutableLiveData();
        MutableLiveData<SecretApprovalDefModel> r0 = new MutableLiveData();
        this._escapeRuleLiveData = r0;
        this.escapeRuleLiveData = r0;
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final LiveData<SecretApprovalDefModel> getEscapeRuleLiveData() {
        return this.escapeRuleLiveData;
    }

    public final LiveData<SecretReviewModel> getSecretApprovalModel() {
        return this.secretApprovalModel;
    }

    public final LiveData<VisibleSecretResult> getSecretLiveData() {
        return this.secretListLiveData;
    }

    public final LiveData<di5.a> getSecretModelData() {
        return this.secretModelData;
    }

    public final LiveData<UpdateSecretLevelResult> getUpdateSecLiveData() {
        return this.updateSecResultLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getSecretListLiveData$p(SecretViewModel r0) {
        return r0.secretListLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getSecretModelData$p(SecretViewModel r0) {
        return r0.secretModelData;
    }

    public static final /* synthetic */ MutableLiveData access$getUpdateSecResultLiveData$p(SecretViewModel r0) {
        return r0.updateSecResultLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_escapeRuleLiveData$p(SecretViewModel r0) {
        return r0._escapeRuleLiveData;
    }

    private final SecretApprovalDefModel convertToSecretApprovalDefModel(EscapeRuleResult r3) {
        if (r3 == null) goto L4;
        SecretApprovalDefModel r0 = new SecretApprovalDefModel();
        r0.setSuccess(true);
        r0.setIs_open(r3.isOpen());
        r0.setApproval_code(r3.getApprovalCode());
        return r0;
    L4:
        SecretApprovalDefModel r1 = new SecretApprovalDefModel();
        r1.setSuccess(false);
        return r1;
    }

    public final void setSecretApprovalModel(SecretReviewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "model");
        this.secretApprovalModel.setValue(r2);
    }

    public static final /* synthetic */ SecretApprovalDefModel access$convertToSecretApprovalDefModel(SecretViewModel r0, EscapeRuleResult r1) {
        return r0.convertToSecretApprovalDefModel(r1);
    }

    public final void fetchApprovalSecretLive(String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        int r1 = p.a;
        NetService.f r2 = new NetService.f("/space/api/sec_label/approval/def/");
        ((NetService.e) r2).c = 2;
        Flowable r3 = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ei5.a()).a(r2);
        Intrinsics.checkNotNullParameter(r8, ResourceData.KEY_TOKEN);
        NetService.f r4 = new NetService.f("/space/api/sec_label/approval/instance/list/");
        ((NetService.e) r4).c = 2;
        r4.b(ResourceData.KEY_TOKEN, r8);
        r4.b(ResourceData.KEY_TYPE, "" + r9);
        this.compositeDisposable.add(Flowable.zip(r3, ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ei5.b()).a(r4), p.a(r8, r9), d.a).observeOn(fo5.d.d()).subscribe(new e(this), new f(this)));
    }

    public final void fetchEscapeRule(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Disposable r4 = oh5.f.a(r2, r3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g(this), new h(this));
        this.compositeDisposable.add(r4);
    }

    public final void fetchVisibleSecretLive(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        NetService.f r5 = new NetService.f("/space/api/sec_label/visible/?token=" + r3 + "&type=" + r4);
        ((NetService.e) r5).c = 2;
        this.compositeDisposable.add(((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new e0()).a(r5).subscribe(new i(this), new j(this)));
    }

    public final void createApproveReq(String r11, int r12, String r13, String r14, String r15, String r16, Map<String, ? extends Serializable> r17) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "approveCode");
        Intrinsics.checkNotNullParameter(r14, "originId");
        Intrinsics.checkNotNullParameter(r15, "applyId");
        Intrinsics.checkNotNullParameter(r16, "changeReason");
        Disposable r0 = generateApproveReq(r11, r12, r13, r14, r15, r16, r17, null).subscribe(new b(this), new c(this));
        this.compositeDisposable.add(r0);
    }

    public final Flowable<SecretApprovalResultModel> generateApproveReq(String r5, int r6, String r7, String r8, String r9, String r10, Map<String, ? extends Serializable> r11, SecretLevel r12) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "approveCode");
        Intrinsics.checkNotNullParameter(r8, "originId");
        Intrinsics.checkNotNullParameter(r9, "applyId");
        Intrinsics.checkNotNullParameter(r10, "changeReason");
        NetService.f r1 = new NetService.f(CREATE_APPROVAL_INS);
        boolean r2 = true;
        ((NetService.e) r1).c = 1;
        HashMap r3 = new HashMap();
        r3.put(ResourceData.KEY_TOKEN, r5);
        r3.put(ResourceData.KEY_TYPE, String.valueOf(r6));
        r3.put("sec_label_id", r8);
        r3.put("change_reason", r10);
        r3.put("approval_code", r7);
        r3.put("apply_sec_label_id", r9);
        boolean r13 = idb.f.a().isCurrentEnable("ccm.permission.secret_level_downgrade_approval_opt");
        if (r11 == null) goto L5;
        Serializable r14 = r11.get("update_permission_info");
    L7:
        if ((r14 instanceof String) == false) goto L9;
        String r15 = (String) r14;
    L11:
        if (r11 == null) goto L13;
        Serializable r16 = r11.get("update_permission_type");
    L15:
        if ((r16 instanceof Integer) == false) goto L17;
        Integer r17 = (Integer) r16;
    L18:
        if (r17 == null) goto L20;
        int r18 = r17.intValue();
    L21:
        tt5.a.h(TAG, "generateApproveReq, canAlsoUpdatePermission: " + r13 + ", updatePermissionInfo: " + du5.b.h(r15) + ", updatePermissionType: " + r18);
        if (r13 == false) goto L31;
        if (r15 != null) goto L25;
    L28:
        if (r2 == true) goto L31;
        if (r18 <= 0) goto L31;
        r3.put("update_permission_info", r15);
        r3.put("update_permission_type", String.valueOf(r18));
        goto L31
    L25:
        if (r15.length() == 0) goto L28;
        r2 = false;
    L31:
        r3.put("is_async", "true");
        StringBuilder r19 = new StringBuilder("generateApproveReq: selectSecret?.isSelectedSearch = ");
        if (r12 == null) goto L34;
        Integer r20 = r12.isSelectedSearch();
    L35:
        r19.append(r20);
        tt5.a.h(TAG, r19.toString());
        if (r12 == null) goto L40;
        Integer r21 = r12.isSelectedSearch();
        if (r21 == null) goto L40;
        r3.put("searchable", String.valueOf(r21.intValue()));
    L40:
        r1.d(r3);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ei5.c()).a(r1);
    L34:
        r20 = null;
        goto L35
    L20:
        r18 = -1;
        goto L21
    L17:
        r17 = null;
        goto L18
    L13:
        r16 = null;
        goto L15
    L9:
        r15 = null;
        goto L11
    L5:
        r14 = null;
        goto L7
    }

    public final void updateSecret(String r7, int r8, String r9, String r10, String r11, int r12, String r13, SecretLevel r14) {
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "secLabelId");
        Intrinsics.checkNotNullParameter(r10, "reason");
        Intrinsics.checkNotNullParameter(r11, "name");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.WIKI_TOKEN);
        NetService.f r1 = new NetService.f(UPDATE_SECRET_API);
        ((NetService.e) r1).c = 1;
        HashMap r2 = new HashMap();
        r2.put(ResourceData.KEY_TOKEN, r7);
        r2.put(ResourceData.KEY_TYPE, String.valueOf(r8));
        r2.put("sec_label_id", r9);
        r2.put("change_reason", r10);
        StringBuilder r15 = new StringBuilder("updateSecret: selectSecret?.isSelectedSearch = ");
        if (r14 == null) goto L5;
        Integer r16 = r14.isSelectedSearch();
    L6:
        r15.append(r16);
        tt5.a.h(TAG, r15.toString());
        if (r14 == null) goto L11;
        Integer r17 = r14.isSelectedSearch();
        if (r17 == null) goto L11;
        r2.put("searchable", String.valueOf(r17.intValue()));
    L11:
        r1.d(r2);
        this.compositeDisposable.add(((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new ax4.f()).a(r1).subscribe(new k(this, r7, r11, r12, r13), new l(this)));
        return;
    L5:
        r16 = null;
        goto L6
    }
}
