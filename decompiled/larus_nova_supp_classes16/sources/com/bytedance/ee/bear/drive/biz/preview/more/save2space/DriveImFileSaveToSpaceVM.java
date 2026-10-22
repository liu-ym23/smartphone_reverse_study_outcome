package com.bytedance.ee.bear.drive.biz.preview.more.save2space;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.drive.sdk.entity.menu.BaseMoreMenuAction;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.contract.route.parcelable.DriveRouteBean;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.drive.biz.permission.handler.PermissionOperation;
import com.bytedance.ee.bear.drive.loader.download.model.imfile.SdkSaveToSpaceStatus;
import com.bytedance.ee.bear.drive.loader.download.platform.api.imfile.SaveToSpaceV2Puller;
import com.bytedance.ee.bear.drivesdk.plugin.model.menu.SaveToSpaceMenu;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.rn.RnPushProtocol;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/more/save2space/DriveImFileSaveToSpaceVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "liveFileToken", "Landroidx/lifecycle/MutableLiveData;", "", "getLiveFileToken", "()Landroidx/lifecycle/MutableLiveData;", "mSaveToSpacePush", "Lcom/bytedance/ee/bear/drive/biz/preview/more/save2space/DriveImFileSaveToSpacePush;", "attachPush", "", "detachPush", "setSaveToSpaceMenuState", JSEventListener.ACTION, "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/menu/DriveMenuClickContext;", "menuContext", "Lcom/bytedance/ee/bear/drive/biz/preview/more/manager/DriveMenuInfoContext;", "handleSave2SpaceMenuClick", "startRequestSave2Space", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveImFileSaveToSpaceVM extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "DriveSdk";
    private final MutableLiveData<String> liveFileToken;
    private com.bytedance.ee.bear.drive.biz.preview.more.save2space.a mSaveToSpacePush;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ e65.a a;

        public b(e65.a r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            Boolean r7 = (Boolean) r6;
            w75.a r8 = this.a.b.getFileModel();
            com.bytedance.ee.bear.drive.report.c r0 = o75.b.a().Ke();
            r0.getClass();
            if (r8 == null) goto L7;
            HashMap<String, Object> r1 = new HashMap();
            String r2 = r8.c().a;
            String r9 = r8.f;
            r1.put(JSEventListener.ACTION, "save_to_drive");
            r1.put("source", "attachment_more");
            r0.z(r1, r2, r9);
            r0.d.v("client_content_management", r1);
            return;
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ e65.a a;

        public c(e65.a r1) {
            this.a = r1;
        }

        public final Object apply(Object r5) {
            Boolean r6 = (Boolean) r5;
            Intrinsics.checkNotNullParameter(r6, "connected");
            BaseOpenEntity r0 = this.a.a;
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.drive.sdk.entity.open.OnlineOpenEntity");
            OnlineOpenEntity r1 = (OnlineOpenEntity) r0;
            if (r6.booleanValue() == false) goto L7;
            SaveToSpaceV2Puller r2 = new SaveToSpaceV2Puller((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
            final SaveToSpaceV2Puller.Params r7 = new SaveToSpaceV2Puller.Params(r1.getAppId(), r1.getFileId(), r1.getAuthExtra());
            return r2.pull(r7).map(new g()).onErrorResumeNext(new h()).doOnError(new i(r7));
        L7:
            return Flowable.error(new Exception("network disconnected !!!"));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b a;
        public final /* synthetic */ DriveImFileSaveToSpaceVM b;

        public d(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r1, DriveImFileSaveToSpaceVM r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            SdkSaveToSpaceStatus r6 = (SdkSaveToSpaceStatus) r5;
            tt5.a.h(DriveImFileSaveToSpaceVM.TAG, "DriveImFileSaveToSpaceVM#saveToSpace() pull result=" + r6);
            if (this.a.a() == true) goto L21;
            int r0 = r6.getStatus();
            if (r0 == 0) goto L15;
            if (r0 != 90002101) goto L10;
            Toast.showText(this.a.getActivity(), this.a.getActivity().getString(2131888479), 0);
            return;
        L10:
            if (r0 != 90002103) goto L22;
            Toast.showFailureText(this.a.getActivity(), this.a.getActivity().getString(2131888477), 1);
            return;
        L22:
            return;
        L15:
            if (TextUtils.isEmpty(r6.getFileToken()) == true) goto L17;
            tt5.a.h(DriveImFileSaveToSpaceVM.TAG, "DriveImFileSaveToSpaceVM#saveToSpace() pull resultSTATUS_SAVED setToken= " + yu5.c.j(r6.getFileToken()));
            this.b.getLiveFileToken().postValue(r6.getFileToken());
        L17:
            Toast.showSuccessText(this.a.getActivity(), this.a.getActivity().getString(2131888478), 0);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b a;
        public final /* synthetic */ e65.a b;

        public e(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r1, e65.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            tt5.a.d(DriveImFileSaveToSpaceVM.TAG, "DriveImFileSaveToSpaceVM#saveToSpace() error= " + r8);
            if (this.a.a() == false) goto L6;
            return;
        L6:
            if (k0.c(r8) == true) goto L17;
            w75.a r0 = this.b.b.getFileModel();
            if (r0 == null) goto L14;
            com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r2 = this.a;
            long r3 = r0.c().c;
            tt5.a.d(DriveImFileSaveToSpaceVM.TAG, "DriveImFileSaveToSpaceVM#saveToSpace() fileSize = " + r3);
            int r1 = f.a;
            if (f.a.a(r8, r2.getActivity(), Long.valueOf(r3), new a95.a()) == true) goto L15;
            Toast.showFailureText(r2.getActivity(), r2.getActivity().getString(2131888446), 0);
            return;
        L15:
            return;
        L14:
            return;
        }
    }

    static {
        Companion = new a();
    }

    public final void attachPush() {
        com.bytedance.ee.bear.drive.biz.preview.more.save2space.a r0 = new com.bytedance.ee.bear.drive.biz.preview.more.save2space.a(this);
        tt5.a.d(TAG, "DriveSdkSaveToSpacePlugin#attach push");
        final AccountService$Account r1 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r1 != null) goto L5;
        tt5.a.d(TAG, "DriveSdkSaveToSpacePlugin#onAttachToUIContainer() account is null");
    L6:
        this.mSaveToSpacePush = r0;
        return;
    L5:
        RnPushProtocol r2 = (RnPushProtocol) org.koin.java.a.b(RnPushProtocol.class, RnPushProtocol.VersionQualifier.Default, new DriveImFileSaveToSpacePush$attach$1(r1));
        r2.b(r0);
        r0.b = r2;
        goto L6
    }

    public final void detachPush() {
        com.bytedance.ee.bear.drive.biz.preview.more.save2space.a r0 = this.mSaveToSpacePush;
        if (r0 == null) goto L12;
        StringBuilder r1 = new StringBuilder("DriveSdkSaveToSpacePlugin#detach push, sdk=");
        if (r0.b != null) goto L7;
        boolean r2 = true;
    L8:
        r1.append(r2);
        tt5.a.d(TAG, r1.toString());
        RnPushProtocol r3 = r0.b;
        if (r3 == null) goto L13;
        r3.a();
        return;
    L13:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public DriveImFileSaveToSpaceVM() {
        this.liveFileToken = new MutableLiveData();
    }

    public final MutableLiveData<String> getLiveFileToken() {
        return this.liveFileToken;
    }

    private final void startRequestSave2Space(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4, e65.a r5) {
        Disposable r6 = Flowable.just(Boolean.valueOf(j.a.a.getNetworkState().a())).doOnNext(new b(r5)).flatMap(new c(r5)).subscribe(new d(r4, this), new e(r4, r5));
        r4.a.add(r6);
    }

    public final void handleSave2SpaceMenuClick(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r24, e65.a r26) {
        Intrinsics.checkNotNullParameter(r24, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r26, "menuContext");
        if (r24.a() == false) goto L5;
        return;
    L5:
        BaseOpenEntity r1 = r26.a;
        String r4 = (String) this.liveFileToken.getValue();
        if (TextUtils.isEmpty(r4) == true) goto L9;
        tt5.a.h(TAG, "DriveImFileSaveToSpaceVM#onClick() instanceof SaveToSpaceMenu, route drive file");
        DriveRouteBean r0 = new DriveRouteBean();
        r0.v = new ArrayList();
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6)).m9(z75.d.a(r4, null, null), r0);
        return;
    L9:
        tt5.a.h(TAG, "DriveImFileSaveToSpaceVM#onClick() instanceof SaveToSpaceMenu, liveSaveToSpace postValue");
        s55.e r5 = new s55.e("UPLOAD", PermissionOperation.UPLOAD, 0, "docx_file", r1.getFileId(), null, null, null, null, null, null, null, null, null, 32740);
        if (s55.a.a.k(r5, r24.getActivity()) == true) goto L12;
        return;
    L12:
        startRequestSave2Space(r24, r26);
    }

    public final void setSaveToSpaceMenuState(com.bytedance.ee.bear.contract.drive.sdk.entity.menu.b r4, e65.a r5) {
        Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
        Intrinsics.checkNotNullParameter(r5, "menuContext");
        ArrayList<BaseMoreMenuAction> r6 = r5.a.getMoreMenuActions();
        if (r6 != null) goto L6;
        return;
    L6:
        if (r4.a() == false) goto L8;
        return;
    L8:
        String r7 = (String) this.liveFileToken.getValue();
        Iterator<BaseMoreMenuAction> r8 = r6.iterator();
    L10:
        if (r8.hasNext() == false) goto L18;
        BaseMoreMenuAction r0 = r8.next();
        if ((r0 instanceof SaveToSpaceMenu) == false) goto L10;
        SaveToSpaceMenu r1 = (SaveToSpaceMenu) r0;
        boolean r2 = !TextUtils.isEmpty(r7);
        r1.n = r2;
        if (r2 == false) goto L16;
        r1.c = 2131888481;
    L17:
        tt5.a.h(TAG, "DriveImFileSaveToSpaceVM#setSaveToSpaceMenuState() setSaved=" + r1.n);
        goto L10
    L16:
        r1.c = 2131888449;
        goto L17
    }
}
