package com.bytedance.ee.bear.middleground.permission.escape;

import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel;
import com.bytedance.ee.bear.middleground.permission.escape.model.Reviewer;
import com.bytedance.ee.bear.middleground.permission.escape.request.CreateInstanceResult;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 K2\u00020\u0001:\u0001KB¾\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012+\b\u0002\u0010\u0014\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010E\u001a\u00020\u00172\u0006\u0010F\u001a\u00020\u0003H\u0016J8\u0010G\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010I\u001a\u00020\u0017H\u0016J\b\u0010J\u001a\u00020\u0017H\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\u001a\u0010\u0007\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\u001a\u0010\b\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001e\"\u0004\b0\u0010 R\u001a\u0010\r\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001a\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001e\"\u0004\b6\u0010 R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R=\u0010\u0014\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/escape/SecretLevelEscapeViewModel;", "Lcom/bytedance/ee/bear/middleground/permission/adjustment/BaseAdjustmentRequestViewModel;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "title", "description", "inputHint", "reviewers", "", "Lcom/bytedance/ee/bear/middleground/permission/escape/model/Reviewer;", "loadingToast", "successToast", "failedToast", "escapeSetting", "permReqType", "permReqParam", "escapeApprovalCallback", "Lcom/bytedance/ee/bear/middleground/permission/escape/IEscapeApi$EscapeApprovalCallback;", "confirmInterceptor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "proceedFun", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ee/bear/middleground/permission/escape/IEscapeApi$EscapeApprovalCallback;Lkotlin/jvm/functions/Function1;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getTitle", "setTitle", "getDescription", "setDescription", "getInputHint", "setInputHint", "getReviewers", "()Ljava/util/List;", "setReviewers", "(Ljava/util/List;)V", "getLoadingToast", "setLoadingToast", "getSuccessToast", "setSuccessToast", "getFailedToast", "setFailedToast", "getEscapeSetting", "setEscapeSetting", "getPermReqType", "setPermReqType", "getPermReqParam", "setPermReqParam", "getEscapeApprovalCallback", "()Lcom/bytedance/ee/bear/middleground/permission/escape/IEscapeApi$EscapeApprovalCallback;", "setEscapeApprovalCallback", "(Lcom/bytedance/ee/bear/middleground/permission/escape/IEscapeApi$EscapeApprovalCallback;)V", "getConfirmInterceptor", "()Lkotlin/jvm/functions/Function1;", "setConfirmInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "confirm", "reason", "createApproveReq", "escapeReason", DocFeed$Value$Result.CANCEL, "onCleared", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecretLevelEscapeViewModel extends BaseAdjustmentRequestViewModel {
    public static final a Companion = null;
    private static final String TAG = "SecretLevelEscapeViewModel";
    private final CompositeDisposable compositeDisposable;
    private Function1<? super Function0<Unit>, Unit> confirmInterceptor;
    private String description;
    private g.a escapeApprovalCallback;
    private String escapeSetting;
    private String failedToast;
    private String inputHint;
    private String loadingToast;
    private String permReqParam;
    private int permReqType;
    private List<Reviewer> reviewers;
    private String successToast;
    private String title;
    private String token;
    private int type;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SecretLevelEscapeViewModel a;

        public b(SecretLevelEscapeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CreateInstanceResult r3 = (CreateInstanceResult) r2;
            this.a.getStatus().postValue(BaseAdjustmentRequestViewModel.AdjustmentStatus.ADJUST_SUCCESS);
            g.a r4 = this.a.getEscapeApprovalCallback();
            if (r4 == null) goto L6;
            r4.onSuccess();
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SecretLevelEscapeViewModel a;

        public c(SecretLevelEscapeViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.e(SecretLevelEscapeViewModel.TAG, "createApproveReq error!", r5, false);
            this.a.getStatus().postValue(BaseAdjustmentRequestViewModel.AdjustmentStatus.ADJUST_FAILED);
            g.a r0 = this.a.getEscapeApprovalCallback();
            if (r0 == null) goto L6;
            Intrinsics.checkNotNull(r5);
            r0.onFailed(r5);
            return;
        }
    }

    static {
        Companion = new a();
    }

    public SecretLevelEscapeViewModel() {
        this(null, 0, null, null, null, null, null, null, null, null, 0, null, null, null, 16383, null);
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void cancel() {
        tt5.a.h(TAG, DocFeed$Value$Result.CANCEL);
        g.a r0 = this.escapeApprovalCallback;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public void onCleared() {
        tt5.a.h(TAG, "onCleared");
        super.onCleared();
        this.compositeDisposable.clear();
    }

    public final Function1<Function0<Unit>, Unit> getConfirmInterceptor() {
        return this.confirmInterceptor;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getDescription() {
        return this.description;
    }

    public final g.a getEscapeApprovalCallback() {
        return this.escapeApprovalCallback;
    }

    public final String getEscapeSetting() {
        return this.escapeSetting;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getFailedToast() {
        return this.failedToast;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getInputHint() {
        return this.inputHint;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getLoadingToast() {
        return this.loadingToast;
    }

    public final String getPermReqParam() {
        return this.permReqParam;
    }

    public final int getPermReqType() {
        return this.permReqType;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public List<Reviewer> getReviewers() {
        return this.reviewers;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getSuccessToast() {
        return this.successToast;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getTitle() {
        return this.title;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public String getToken() {
        return this.token;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel, ig5.b
    public int getType() {
        return this.type;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void confirm(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "reason");
        tt5.a.h(TAG, "confirm");
        Function1<? super Function0<Unit>, Unit> r0 = this.confirmInterceptor;
        if (r0 == null) goto L5;
        r0.invoke(new AnonymousClass1(this, r10));
        return;
    L5:
        createApproveReq(getToken(), getType(), this.escapeSetting, r10, this.permReqType, this.permReqParam);
    }

    public final void setConfirmInterceptor(Function1<? super Function0<Unit>, Unit> r1) {
        this.confirmInterceptor = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setDescription(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.description = r2;
    }

    public final void setEscapeApprovalCallback(g.a r1) {
        this.escapeApprovalCallback = r1;
    }

    public final void setEscapeSetting(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.escapeSetting = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setFailedToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.failedToast = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setInputHint(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inputHint = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setLoadingToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loadingToast = r2;
    }

    public final void setPermReqParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.permReqParam = r2;
    }

    public final void setPermReqType(int r1) {
        this.permReqType = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setReviewers(List<Reviewer> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reviewers = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setSuccessToast(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.successToast = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.token = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.adjustment.BaseAdjustmentRequestViewModel
    public void setType(int r1) {
        this.type = r1;
    }

    private final void createApproveReq(String r3, int r4, String r5, String r6, int r7, String r8) {
        getStatus().postValue(BaseAdjustmentRequestViewModel.AdjustmentStatus.ADJUSTING);
        Disposable r9 = oh5.d.a(r3, r4, r5, r6, r7, r8).subscribe(new b(this), new c(this));
        this.compositeDisposable.add(r9);
    }

    public static final /* synthetic */ void access$createApproveReq(SecretLevelEscapeViewModel r0, String r1, int r2, String r3, String r4, int r5, String r6) {
        r0.createApproveReq(r1, r2, r3, r4, r5, r6);
    }

    public SecretLevelEscapeViewModel(String r2, int r3, String r4, String r5, String r6, List<Reviewer> r7, String r8, String r9, String r10, String r11, int r12, String r13, g.a r14, Function1<? super Function0<Unit>, Unit> r15) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "description");
        Intrinsics.checkNotNullParameter(r6, "inputHint");
        Intrinsics.checkNotNullParameter(r7, "reviewers");
        Intrinsics.checkNotNullParameter(r8, "loadingToast");
        Intrinsics.checkNotNullParameter(r9, "successToast");
        Intrinsics.checkNotNullParameter(r10, "failedToast");
        Intrinsics.checkNotNullParameter(r11, "escapeSetting");
        Intrinsics.checkNotNullParameter(r13, "permReqParam");
        this.token = r2;
        this.type = r3;
        this.title = r4;
        this.description = r5;
        this.inputHint = r6;
        this.reviewers = r7;
        this.loadingToast = r8;
        this.successToast = r9;
        this.failedToast = r10;
        this.escapeSetting = r11;
        this.permReqType = r12;
        this.permReqParam = r13;
        this.escapeApprovalCallback = r14;
        this.confirmInterceptor = r15;
        this.compositeDisposable = new CompositeDisposable();
    }

    public /* synthetic */ SecretLevelEscapeViewModel(String r16, int r17, String r18, String r19, String r20, List r21, String r22, String r23, String r24, String r25, int r26, String r27, g.a r28, Function1 r29, int r30, DefaultConstructorMarker r31) {
        String r2 = "";
        if ((r30 & 1) == 0) goto L5;
        String r1 = "";
    L6:
        int r4 = 0;
        if ((r30 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r7 = "";
    L23:
        if ((r30 & 32) == 0) goto L25;
        List r8 = CollectionsKt.emptyList();
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r30 & DocUserPermission.USER_PERM_FULL_ACCESS) != 0) goto L47;
        r4 = r26;
    L47:
        if ((r30 & DocUserPermission.USER_PREVIEW) != 0) goto L50;
        r2 = r27;
    L50:
        Function1 r14 = null;
        if ((r30 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        g.a r13 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r14 = r29;
    L58:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r4, r2, r13, r14);
        return;
    L53:
        r13 = r28;
        goto L55
    L41:
        r12 = r25;
        goto L43
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L6
    }
}
