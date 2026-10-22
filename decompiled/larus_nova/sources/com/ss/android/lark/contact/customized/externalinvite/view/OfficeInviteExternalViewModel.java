package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.contact.base.entity.bean.InvitationInfo;
import com.ss.android.lark.contact.customized.mobileinvite.OfficeInviteExternalContactActivity;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import com.ss.android.lark.contact.customized.myqrcode.repository.OfficeInviteMsgRepository$asyncGetInviteMsg$1;
import com.ss.android.lark.contact.customized.myqrcode.repository.OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1;
import com.ss.android.lark.contact.customized.search.OfficeInviteExternalSearchActivity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.l;
import com.ss.android.lark.utils.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0016\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u000eJ\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\"J\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\"\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\b\u0010/\u001a\u00020\u000eH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u00061"}, d2 = {"Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_invitationInfoGroupLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/ss/android/lark/contact/customized/common/model/StatefulModel;", "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfoGroup;", "invitationInfoGroupLiveData", "Landroidx/lifecycle/LiveData;", "getInvitationInfoGroupLiveData", "()Landroidx/lifecycle/LiveData;", "invitationInfoGroup", "contextInfoStartElapsed", "", "localPerfReported", "", "serverPerfReported", "firstPerfReported", "qrCodeHandler", "Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "getQrCodeHandler", "()Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "qrCodeHandler$delegate", "Lkotlin/Lazy;", "requestFinish", "", WidgetService.PARAM_FRAGMENT, "Lcom/ss/android/lark/base/fragment/BaseFragment;", "onClickSearchPhoneOrEmail", "sharedSearchBar", "Landroid/view/View;", "onClickImportContact", "from", "", "onPageViewCreated", "startElapsed", "fetchContactToken", "getInviteUrl", "gotoMyQrCode", "onClickF2f", "startScanQRCodeActivity", "reportContextInfoPerf", "isCache", "isSucceed", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "getContextInfoDurationMs", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalViewModel extends ViewModel {
    public static final int $stable = 0;
    private static final String CONTEXT_INFO_SCENE = "invite_context_info_api";
    public static final a Companion = null;
    private static final String TAG = "Contact_InviteExternalViewModel";
    private final MutableLiveData<i9b.a<z8b.a>> _invitationInfoGroupLiveData;
    private long contextInfoStartElapsed;
    private boolean firstPerfReported;
    private z8b.a invitationInfoGroup;
    private final LiveData<i9b.a<z8b.a>> invitationInfoGroupLiveData;
    private boolean localPerfReported;
    private final Lazy qrCodeHandler$delegate;
    private boolean serverPerfReported;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public final void onClickF2f(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
    }

    private final long getContextInfoDurationMs() {
        long r100 = this.contextInfoStartElapsed;
        if (r100 > 0) goto L6;
        return 0;
    L6:
        return SystemClock.elapsedRealtime() - r100;
    }

    private final owb.b getQrCodeHandler() {
        return (owb.b) this.qrCodeHandler$delegate.getValue();
    }

    public final void fetchContactToken() {
        Log.i(TAG, "fetchContactToken");
        this._invitationInfoGroupLiveData.setValue(i9b.a.b.f488828a);
        int r100 = com.ss.android.lark.contact.customized.myqrcode.repository.a.f419319a;
        Function1<z8b.a, Unit> r101 = new AnonymousClass1(this);
        Intrinsics.checkNotNullParameter(r101, "consumer");
        int r102 = com.ss.android.lark.contact.base.service.d.f418917a;
        com.ss.android.lark.contact.base.service.d.b(new OfficeInviteMsgRepository$asyncGetInviteMsg$1(r101));
        Function1<z8b.a, Unit> r103 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r103, "consumer");
        com.ss.android.lark.contact.base.service.d.a(new OfficeInviteMsgRepository$asyncGetInviteMsgFromLocal$1(r103));
    }

    public final String getInviteUrl() {
        z8b.a r100 = this.invitationInfoGroup;
        if (r100 == null) goto L18;
        InvitationInfo r101 = r100.f570973b;
        if (r101 == null) goto L7;
        String r102 = r101.invUrl;
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L14;
        InvitationInfo r103 = r100.f570972a;
        if (r103 == null) goto L14;
        r102 = r103.invUrl;
    L14:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    L7:
        r102 = "";
        goto L9
    L18:
        return "";
    }

    public OfficeInviteExternalViewModel() {
        MutableLiveData<i9b.a<z8b.a>> r100 = new MutableLiveData();
        this._invitationInfoGroupLiveData = r100;
        this.invitationInfoGroupLiveData = r100;
        this.qrCodeHandler$delegate = LazyKt.lazy(OfficeInviteExternalViewModel$qrCodeHandler$2.INSTANCE);
    }

    public final LiveData<i9b.a<z8b.a>> getInvitationInfoGroupLiveData() {
        return this.invitationInfoGroupLiveData;
    }

    public static final /* synthetic */ z8b.a access$getInvitationInfoGroup$p(OfficeInviteExternalViewModel r100) {
        return r100.invitationInfoGroup;
    }

    public static final /* synthetic */ MutableLiveData access$get_invitationInfoGroupLiveData$p(OfficeInviteExternalViewModel r100) {
        return r100._invitationInfoGroupLiveData;
    }

    public final void onPageViewCreated(long r100) {
        this.contextInfoStartElapsed = r100;
        this.localPerfReported = false;
        this.serverPerfReported = false;
        this.firstPerfReported = false;
    }

    public final void requestFinish(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L6;
        r101.finish();
        return;
    }

    public final void startScanQRCodeActivity(BaseFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L6;
        getQrCodeHandler().N0(r101);
        return;
    }

    public static final /* synthetic */ void access$setInvitationInfoGroup$p(OfficeInviteExternalViewModel r100, z8b.a r101) {
        r100.invitationInfoGroup = r101;
    }

    public final void gotoMyQrCode(BaseFragment r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "from");
        FragmentActivity r102 = r100.getActivity();
        if (r102 == null) goto L6;
        int r103 = OfficeMyQrCodeActivity.f419318a;
        OfficeMyQrCodeActivity.a.a(r102, r101);
        return;
    }

    public final void onClickImportContact(BaseFragment r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r111, "from");
        FragmentActivity r112 = r110.getActivity();
        if (r112 == null) goto L6;
        int r100 = OfficeInviteExternalContactActivity.f419284b;
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(r111, "from");
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter("", "inviteMsg");
        Intrinsics.checkNotNullParameter("", "uniqueId");
        Intrinsics.checkNotNullParameter(r111, "from");
        com.ss.android.lark.contact.customized.mobileinvite.a r101 = new com.ss.android.lark.contact.customized.mobileinvite.a(r112, r111);
        int r113 = n.f444741a;
        com.ss.android.lark.utils.h.d(r112, r101, "android.permission.READ_CONTACTS", null, new l(R.string.Lark_UserGrowth_InviteMemberImportContactsNoPermission, R.string.Lark_UserGrowth_InviteMemberImportContactsTip, R.string.Lark_UserGrowth_InviteMemberImportContactsNoPermission, R.string.Lark_UserGrowth_InviteMemberImportContactsTip, null, null, 240));
        return;
    }

    public final void onClickSearchPhoneOrEmail(BaseFragment r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        FragmentActivity r102 = r100.getActivity();
        int r103 = OfficeInviteExternalSearchActivity.f419401a;
        Intent r104 = new Intent(r102, OfficeInviteExternalSearchActivity.class);
        r104.putExtra("transition", true);
        if (r101 == null) goto L5;
        r100.startActivity(r104, ActivityOptionsCompat.makeSceneTransitionAnimation(r102, r101, "contact_db_transition_invite_search_bar").toBundle());
        return;
    L5:
        r102.startActivity(r104);
    }

    private final void reportContextInfoPerf(boolean r110, boolean r111, ErrorResult r112) {
        if (this.contextInfoStartElapsed > 0) goto L6;
        return;
    L6:
        if (r110 == false) goto L12;
        if (this.localPerfReported == false) goto L10;
        return;
    L10:
        this.localPerfReported = true;
    L15:
        boolean r100 = !this.firstPerfReported;
        if (r100 == false) goto L18;
        this.firstPerfReported = true;
    L18:
        int r101 = com.ss.android.lark.contact.customized.common.a.f418963a;
        com.ss.android.lark.contact.customized.common.a.a(CONTEXT_INFO_SCENE, getContextInfoDurationMs(), r111, r112, r110, r100);
        return;
    L12:
        if (this.serverPerfReported == false) goto L14;
        return;
    L14:
        this.serverPerfReported = true;
        goto L15
    }

    public static final /* synthetic */ void access$reportContextInfoPerf(OfficeInviteExternalViewModel r100, boolean r101, boolean r102, ErrorResult r103) {
        r100.reportContextInfoPerf(r101, r102, r103);
    }
}
