package com.bytedance.ee.bear.drive.biz.versions.push;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.versions.DriveVersionOwnerResolver;
import com.bytedance.ee.bear.drive.biz.versions.VersionHistoryRepository;
import com.bytedance.ee.bear.drive.biz.versions.history.DriveHistoryVM;
import com.bytedance.ee.bear.drive.biz.versions.model.DriveVersionHistoryRecord;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J4\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002J,\u0010\"\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\rH\u0002J\"\u0010$\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010%\u001a\u00020\u0014H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/versions/push/DriveMultiVersionPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "mVersionChangeObserver", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ee/bear/drive/biz/versions/model/VersionPayLoadData;", "mVersionPush", "Lcom/bytedance/ee/bear/drive/biz/versions/push/DriveMultiVersionPush;", "ownershipDisposables", "Lio/reactivex/disposables/CompositeDisposable;", "receivedRequestKeys", "", "Lcom/bytedance/ee/bear/drive/biz/versions/push/DriveMultiVersionPlugin$RequestKey;", "attachGeneration", "", "attached", "", "activeRequestKey", "onAttachPreview", "", "handleVersionUpdate", "targetVersion", "", "handleVersionUpdateInternal", "cancelActiveRequest", "reason", "scene", "encryptedToken", "handleOwnerResult", "requestKey", TipCallBackData.RESULT, "Lcom/bytedance/ee/bear/drive/biz/versions/DriveVersionOwnerResolver$OwnerResult;", "encryptedCurrentUid", "publishVersionDialog", "isRequestCurrent", "logStaleRequest", "onDetachPreview", "Companion", "RequestKey", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveMultiVersionPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    public static final String TAG = "DriveComponent_DriveMultiVersionPlugin";
    private b activeRequestKey;
    private long attachGeneration;
    private boolean attached;
    private Observer<VersionPayLoadData> mVersionChangeObserver;
    private f75.a mVersionPush;
    private final CompositeDisposable ownershipDisposables;
    private final Set<b> receivedRequestKeys;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final long a;
        public final String b;
        public final String c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "RequestKey(generation=" + this.a + ", fileToken=" + this.b + ", targetVersion=" + this.c + ')';
        }

        public b(long r2, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "fileToken");
            Intrinsics.checkNotNullParameter(r5, "targetVersion");
            this.a = r2;
            this.b = r4;
            this.c = r5;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ DriveMultiVersionPlugin a;
        public final /* synthetic */ b b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public c(DriveMultiVersionPlugin r1, b r2, String r3, String r4, String r5, String r6, String r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }

        public final void accept(Object r12) {
            Result r13 = (Result) r12;
            if (DriveMultiVersionPlugin.access$isRequestCurrent(this.a, this.b) == true) goto L5;
            DriveMultiVersionPlugin.access$logStaleRequest(this.a, this.b, this.c, this.d);
            return;
        L5:
            DriveMultiVersionPlugin r3 = this.a;
            b r4 = this.b;
            int r0 = DriveVersionOwnerResolver.a;
            String r1 = this.e;
            String r2 = this.f;
            boolean r5 = false;
            if (r1 != null) goto L8;
        L11:
            boolean r6 = true;
        L12:
            if (r6 == false) goto L14;
            DriveVersionOwnerResolver.a.c r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.TARGET_VERSION_MISSING);
        L62:
            DriveVersionOwnerResolver.a r7 = r14;
        L68:
            DriveMultiVersionPlugin.access$handleOwnerResult(r3, r4, r7, this.c, this.d, this.g);
            return;
        L14:
            if (r2 != null) goto L16;
        L19:
            boolean r8 = true;
        L20:
            if (r8 == false) goto L22;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.CURRENT_USER_MISSING);
            goto L62
        L22:
            if (r13 != null) goto L25;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.RESPONSE_MISSING);
            goto L62
        L25:
            if (r13.code == 0) goto L27;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.RESPONSE_CODE_ERROR);
            goto L62
        L27:
            DriveVersionHistoryRecord r16 = (DriveVersionHistoryRecord) r13.data;
            if (r16 != null) goto L30;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.DATA_MISSING);
            goto L62
        L30:
            List<DriveVersionHistoryRecord.RecordBean> r17 = r16.getList();
            if (r17 != null) goto L34;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.HISTORY_EMPTY);
            goto L62
        L34:
            if (r17.isEmpty() == false) goto L36;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.HISTORY_EMPTY);
            goto L62
        L36:
            ArrayList r9 = new ArrayList();
            Iterator<T> r18 = r17.iterator();
        L38:
            if (r18.hasNext() == false) goto L50;
            T r10 = r18.next();
            DriveVersionHistoryRecord.RecordBean r11 = (DriveVersionHistoryRecord.RecordBean) r10;
            if (r11.getType() == 1) goto L44;
            if (r11.getType() == 4) goto L44;
        L46:
            boolean r19 = false;
        L47:
            if (r19 == false) goto L38;
            r9.add(r10);
        L44:
            if (TextUtils.equals(r11.getVersion(), r1) == false) goto L46;
            r19 = true;
            goto L47
        L50:
            if (r9.isEmpty() == false) goto L53;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.VERSION_NOT_FOUND);
            goto L62
        L53:
            if (r9.size() <= 1) goto L55;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.MULTIPLE_VERSION_RECORDS);
            goto L62
        L55:
            String r110 = ((DriveVersionHistoryRecord.RecordBean) CollectionsKt.single(r9)).getEditUid();
            if (r110 != null) goto L58;
        L59:
            r5 = true;
        L60:
            if (r5 == false) goto L64;
            r14 = new DriveVersionOwnerResolver.a.c(DriveVersionOwnerResolver.UnknownReason.EDIT_USER_MISSING);
            goto L62
        L64:
            if (TextUtils.equals(r110, r2) == false) goto L66;
            DriveVersionOwnerResolver.a r20 = new DriveVersionOwnerResolver.a.b(r110);
        L67:
            r7 = r20;
            goto L68
        L66:
            r20 = new DriveVersionOwnerResolver.a.C0158a(r110);
            goto L67
        L58:
            if (r110.length() != 0) goto L60;
        L16:
            if (r2.length() == 0) goto L19;
            r8 = false;
            goto L20
        L8:
            if (r1.length() == 0) goto L11;
            r6 = false;
            goto L12
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DriveMultiVersionPlugin a;
        public final /* synthetic */ b b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public d(DriveMultiVersionPlugin r1, b r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void accept(Object r5) {
            Throwable r6 = (Throwable) r5;
            if (DriveMultiVersionPlugin.access$isRequestCurrent(this.a, this.b) == true) goto L5;
            DriveMultiVersionPlugin.access$logStaleRequest(this.a, this.b, this.c, this.d);
            return;
        L5:
            tt5.a.e(DriveMultiVersionPlugin.TAG, "version owner request failed, reason=" + DriveVersionOwnerResolver.UnknownReason.REQUEST_FAILED + ", version=" + this.e + ", scene=" + this.c + ", token=" + this.d, r6, false);
            DriveMultiVersionPlugin.access$setActiveRequestKey$p(this.a, null);
            DriveMultiVersionPlugin.access$publishVersionDialog(this.a, this.e, "REQUEST_FAILED", this.c, this.d);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ DriveMultiVersionPlugin a;

        public e(DriveMultiVersionPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            VersionPayLoadData r8 = (VersionPayLoadData) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
        L28:
            e = move-exception;
            tt5.a.f(DriveMultiVersionPlugin.TAG, e, false);
            return;
        L4:
            if (TextUtils.equals(k75.a.d(this.a), r8.getToken()) == true) goto L7;
            tt5.a.d(DriveMultiVersionPlugin.TAG, "VersionObserver receive not equals obj token, ignore change.");     // Catch: Exception -> L28
            return;
        L7:
            if (r8.getOperation() != 101) goto L25;
            if (r8.getSource() == 7) goto L19;
            w75.a r2 = this.a.getHost().c.getFileModel();     // Catch: Exception -> L28
            if (r2 != null) goto L13;
        L15:
            boolean r3 = false;
        L16:
            if (r3 == true) goto L19;
            DriveMultiVersionPlugin.access$handleVersionUpdate(this.a, r8.getVersion());     // Catch: Exception -> L28
            return;
        L13:
            if (r2.q != 2) goto L15;
            r3 = true;
        L19:
            tt5.a.h(DriveMultiVersionPlugin.TAG, "wps preview new version, do not show dialog");     // Catch: Exception -> L28
            DriveMultiVersionPlugin r4 = this.a;     // Catch: Exception -> L28
            if (r4.getHost().c.isTypeWiki() == false) goto L22;
            String r5 = FileInfoPuller.CALLER_WIKI;
        L23:
            DriveMultiVersionPlugin.access$cancelActiveRequest(r4, "wps_short_circuit", r5, du5.b.g(k75.a.d(this.a)));     // Catch: Exception -> L28
            ((DriveHistoryVM) DriveMultiVersionPlugin.access$viewModel(this.a, DriveHistoryVM.class)).setCurrentDataVersion(r8.getVersion());     // Catch: Exception -> L28
            return;
        L22:
            r5 = "drive";
            goto L23
        L25:
            if (r8.getOperation() != 102) goto L35;
            tt5.a.h(DriveMultiVersionPlugin.TAG, "file version deleted");     // Catch: Exception -> L28
            String r9 = r8.getVersion();     // Catch: Exception -> L28
            ((DriveHistoryVM) DriveMultiVersionPlugin.access$viewModel(this.a, DriveHistoryVM.class)).getLiveVersionDeleted().postValue(r9);     // Catch: Exception -> L28
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveMultiVersionPlugin() {
        this.ownershipDisposables = new CompositeDisposable();
        this.receivedRequestKeys = new LinkedHashSet();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachPreview() {
        super.onAttachPreview();
        this.attachGeneration++;
        this.attached = true;
        this.activeRequestKey = null;
        this.receivedRequestKeys.clear();
        this.ownershipDisposables.clear();
        f75.a r0 = new f75.a(k75.a.d(this));
        this.mVersionPush = r0;
        r0.a();
        f75.a r1 = this.mVersionPush;
        if (r1 == null) goto L8;
        MutableLiveData<VersionPayLoadData> r2 = r1.e;
        if (r2 == null) goto L9;
        e r3 = new e(this);
        this.mVersionChangeObserver = r3;
        r2.observeForever(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onDetachPreview() {
        super.onDetachPreview();
        this.attached = false;
        this.attachGeneration++;
        this.activeRequestKey = null;
        this.receivedRequestKeys.clear();
        this.ownershipDisposables.clear();
        f75.a r1 = this.mVersionPush;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        Observer<VersionPayLoadData> r2 = this.mVersionChangeObserver;
        if (r2 == null) goto L12;
        f75.a r3 = this.mVersionPush;
        if (r3 == null) goto L12;
        MutableLiveData<VersionPayLoadData> r4 = r3.e;
        if (r4 == null) goto L12;
        r4.removeObserver(r2);
    L12:
        this.mVersionChangeObserver = null;
        this.mVersionPush = null;
    }

    private final void handleVersionUpdate(String r7) {
        handleVersionUpdateInternal(r7);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if (getHost().c.isTypeWiki() == false) goto L8;
        String r1 = FileInfoPuller.CALLER_WIKI;
    L9:
        String r2 = du5.b.g(k75.a.d(this));
        tt5.a.e(TAG, "version owner setup failed, reason=" + DriveVersionOwnerResolver.UnknownReason.REQUEST_FAILED + ", version=" + r7 + ", scene=" + r1 + ", token=" + r2, e, false);
        cancelActiveRequest("setup_failed", r1, r2);
        publishVersionDialog(r7, "REQUEST_FAILED", r1, r2);
        return;
    L8:
        r1 = "drive";
        goto L9
    }

    private final void handleVersionUpdateInternal(String r16) {
        String r0 = k75.a.d(this);
        if (getHost().c.isTypeWiki() == false) goto L5;
        String r1 = FileInfoPuller.CALLER_WIKI;
    L6:
        String r10 = du5.b.g(r0);
        boolean r2 = ((dn4.a) getHost().getUserComponent().a(dn4.a.class)).a().isEnable("ccm.mobile.disable_drive_version_update_toast");
        tt5.a.h(TAG, "version update received, fg=" + r2 + ", version=" + r16 + ", scene=" + r1 + ", token=" + r10);
        if (r2 == true) goto L10;
        cancelActiveRequest("fg_disabled", r1, r10);
        publishVersionDialog(r16, "fg_disabled", r1, r10);
        return;
    L10:
        boolean r3 = false;
        if (r0 != null) goto L13;
    L16:
        boolean r8 = true;
    L17:
        if (r8 == true) goto L45;
        if (r16 != null) goto L20;
    L23:
        boolean r9 = true;
    L24:
        if (r9 == true) goto L45;
        b r11 = new b(this.attachGeneration, r0, r16);
        if (this.receivedRequestKeys.add(r11) == true) goto L30;
        tt5.a.h(TAG, "version owner request ignored, reason=duplicate, version=" + r16 + ", scene=" + r1 + ", token=" + r10);
        return;
    L30:
        cancelActiveRequest("newer_push", r1, r10);
        this.activeRequestKey = r11;
        AccountService$Account r12 = ((h0) getHost().getUserComponent().a(h0.class)).G2();
        if (r12 == null) goto L33;
        String r13 = r12.uid;
    L34:
        String r14 = du5.b.g(r13);
        if (r13 != null) goto L37;
    L38:
        r3 = true;
    L40:
        if (r3 == false) goto L43;
        tt5.a.k(TAG, "version owner unresolved, reason=" + DriveVersionOwnerResolver.UnknownReason.CURRENT_USER_MISSING + ", version=" + r16 + ", scene=" + r1 + ", token=" + r10 + ", currentUid=" + r14);
        this.activeRequestKey = null;
        publishVersionDialog(r16, "CURRENT_USER_MISSING", r1, r10);
        return;
    L43:
        tt5.a.h(TAG, "version owner request start, version=" + r16 + ", scene=" + r1 + ", token=" + r10 + ", currentUid=" + r14);
        NetService.d r4 = ((NetService) getHost().getUserComponent().a(NetService.class)).Vc(new VersionHistoryRepository.a());
        tt5.a.h("VersionHistoryRepository", "start fetch history...");
        VersionHistoryRepository.Params r5 = new VersionHistoryRepository.Params();
        r5.fileToken = r0;
        r5.pageSize = 10;
        r5.lastEditTime = 0;
        NetService.f r6 = new NetService.f("/api/box/file/history/");
        r6.j = JSON.toJSONString(r5);
        r6.c = 1;
        String r7 = r1;
        this.ownershipDisposables.add(r4.a(r6).onErrorResumeNext(new d75.d(r5)).observeOn(fo5.d.d()).subscribe(new c(this, r11, r7, r10, r16, r13, r14), new d(this, r11, r7, r10, r16)));
        return;
    L37:
        if (r13.length() != 0) goto L40;
    L33:
        r13 = null;
        goto L34
    L20:
        if (r16.length() == 0) goto L23;
        r9 = false;
    L45:
        cancelActiveRequest("invalid_request", r1, r10);
        publishVersionDialog(r16, "invalid_request", r1, r10);
        return;
    L13:
        if (r0.length() == 0) goto L16;
        r8 = false;
        goto L17
    L5:
        r1 = "drive";
        goto L6
    }

    private final boolean isRequestCurrent(b r6) {
        if (this.attached == true) goto L5;
    L11:
        return false;
    L5:
        if (this.attachGeneration != r6.a) goto L11;
        if (TextUtils.equals(k75.a.d(this), r6.b) == false) goto L11;
        if (Intrinsics.areEqual(this.activeRequestKey, r6) == false) goto L11;
        return true;
    }

    public static final /* synthetic */ void access$handleVersionUpdate(DriveMultiVersionPlugin r0, String r1) {
        r0.handleVersionUpdate(r1);
    }

    public static final /* synthetic */ boolean access$isRequestCurrent(DriveMultiVersionPlugin r0, b r1) {
        return r0.isRequestCurrent(r1);
    }

    public static final /* synthetic */ void access$setActiveRequestKey$p(DriveMultiVersionPlugin r0, b r1) {
        r0.activeRequestKey = r1;
    }

    public static final /* synthetic */ ViewModel access$viewModel(DriveMultiVersionPlugin r0, Class r1) {
        return r0.viewModel(r1);
    }

    private final void cancelActiveRequest(String r4, String r5, String r6) {
        b r0 = this.activeRequestKey;
        if (r0 == null) goto L5;
        tt5.a.h(TAG, "version owner request cancelled, reason=" + r4 + ", version=" + r0.c + ", scene=" + r5 + ", token=" + r6);
    L5:
        this.activeRequestKey = null;
        this.ownershipDisposables.clear();
    }

    private final void logStaleRequest(b r3, String r4, String r5) {
        tt5.a.h(TAG, "version owner result ignored, reason=stale_request, version=" + r3.c + ", scene=" + r4 + ", token=" + r5);
    }

    public static final /* synthetic */ void access$cancelActiveRequest(DriveMultiVersionPlugin r0, String r1, String r2, String r3) {
        r0.cancelActiveRequest(r1, r2, r3);
    }

    public static final /* synthetic */ void access$logStaleRequest(DriveMultiVersionPlugin r0, b r1, String r2, String r3) {
        r0.logStaleRequest(r1, r2, r3);
    }

    private final void publishVersionDialog(String r3, String r4, String r5, String r6) {
        tt5.a.h(TAG, "version update show dialog, reason=" + r4 + ", version=" + r3 + ", scene=" + r5 + ", token=" + r6);
        ((DriveHistoryVM) viewModel(DriveHistoryVM.class)).getLiveHasNewVersion().postValue(r3);
    }

    public static final /* synthetic */ void access$publishVersionDialog(DriveMultiVersionPlugin r0, String r1, String r2, String r3, String r4) {
        r0.publishVersionDialog(r1, r2, r3, r4);
    }

    private final void handleOwnerResult(b r8, DriveVersionOwnerResolver.a r9, String r10, String r11, String r12) {
        this.activeRequestKey = null;
        if ((r9 instanceof DriveVersionOwnerResolver.a.b) == false) goto L6;
        tt5.a.h(TAG, "version owner resolved, reason=self, version=" + r8.c + ", scene=" + r10 + ", token=" + r11 + ", currentUid=" + r12 + ", editUid=" + du5.b.g(((DriveVersionOwnerResolver.a.b) r9).a));
        int r13 = d75.a.a;
        d75.a.a(getHost(), (DriveMGPermissionVM) viewModel(DriveMGPermissionVM.class), "self_update");
        return;
    L6:
        if ((r9 instanceof DriveVersionOwnerResolver.a.C0158a) == false) goto L9;
        tt5.a.h(TAG, "version owner resolved, reason=other, version=" + r8.c + ", scene=" + r10 + ", token=" + r11 + ", currentUid=" + r12 + ", editUid=" + du5.b.g(((DriveVersionOwnerResolver.a.C0158a) r9).a));
        publishVersionDialog(r8.c, "other_user", r10, r11);
        return;
    L9:
        if ((r9 instanceof DriveVersionOwnerResolver.a.c) == false) goto L13;
        StringBuilder r0 = new StringBuilder("version owner unresolved, reason=");
        DriveVersionOwnerResolver.a.c r14 = (DriveVersionOwnerResolver.a.c) r9;
        r0.append(r14.a);
        r0.append(", version=");
        r0.append(r8.c);
        r0.append(", scene=");
        r0.append(r10);
        r0.append(", token=");
        r0.append(r11);
        r0.append(", currentUid=");
        r0.append(r12);
        tt5.a.k(TAG, r0.toString());
        publishVersionDialog(r8.c, r14.a.name(), r10, r11);
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ void access$handleOwnerResult(DriveMultiVersionPlugin r0, b r1, DriveVersionOwnerResolver.a r2, String r3, String r4, String r5) {
        r0.handleOwnerResult(r1, r2, r3, r4, r5);
    }
}
