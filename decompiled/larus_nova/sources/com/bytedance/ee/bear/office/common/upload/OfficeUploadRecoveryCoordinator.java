package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class OfficeUploadRecoveryCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OfficeUploadRecoveryCoordinator f235291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f235292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f235293c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap<String, a> f235294d = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\"\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryCoordinator$RecoveryMonitor;", "Lcom/bytedance/ee/bear/middleground/drive/export/IMGDriveInterfaces$IUploadStateMonitor;", "Lcom/bytedance/ee/util/io/NonProguard;", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryTarget;", "<init>", "(Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryTarget;)V", "onExistUploadingFile", "", "onFileProgressChange", "totalProgress", "", "progressingEntity", "Lcom/bytedance/ee/bear/middleground/drive/export/ProgressingEntity;", "onFileCountChange", "finishCount", "totalCount", "onUploadFinished", "onUploadError", "count", "onUploadErrorCode", "fileId", "", "errorCode", "bytesTotal", "", "onUploadFileSuccess", "key", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/IMGDriveInterfaces$FileExtra;", "markDirtyOnMain", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecoveryMonitor implements rf5.e, NonProguard {
        private final OfficeUploadRecoveryTarget target;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g0 f235295a;

            public a(g0 r100) {
                this.f235295a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r100 = d0.f235354a;     // Catch: Throwable -> L4
                d0.a(this.f235295a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // rf5.e
        public void onExistUploadingFile() {
        }

        @Override // rf5.e
        public void onFileCountChange(int r100, int r101) {
        }

        @Override // rf5.e
        public void onUploadError(int r100) {
        }

        @Override // rf5.e
        public void onUploadFinished() {
        }

        public RecoveryMonitor(OfficeUploadRecoveryTarget r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.target = r100;
        }

        private final void markDirtyOnMain(g0 r100) {
            OfficeUploadRecoveryCoordinator.f235293c.post(new a(r100));
        }

        @Override // rf5.e
        public void onFileProgressChange(int r210, ProgressingEntity r211) {
            StringBuilder r100 = new StringBuilder("office_upload_recovery_trace monitor_progress total=");
            r100.append(r210);
            r100.append(" entity=");
            final h0 r101 = null;
            if (r211 == null) goto L13;
            OfficeUploadRecoveryCoordinator.f235291a.getClass();
            StringBuilder r102 = new StringBuilder("{key=");
            String r103 = r211.f232469b;
            if (r103 == null) goto L7;
            Integer r104 = Integer.valueOf(r103.hashCode());
        L8:
            r102.append(r104);
            r102.append(",nameLen=");
            String r105 = r211.f232468a;
            if (r105 == null) goto L11;
            Integer r106 = Integer.valueOf(r105.length());
        L12:
            r102.append(r106);
            r102.append(",status=");
            r102.append(r211.f232473f);
            r102.append(",bytes=");
            r102.append(r211.f232470c);
            r102.append('/');
            r102.append(r211.f232471d);
            r102.append(",progress=");
            r102.append(r211.f232472e);
            r102.append('}');
            String r107 = r102.toString();
        L14:
            r100.append(r107);
            tt5.a.h("OfficeUploadRecovery", r100.toString());
            int r108 = c0.f235345a;
            OfficeUploadRecoveryTarget r109 = this.target;
            Intrinsics.checkNotNullParameter(r109, PickerReporterConstants.KEY.TARGET);
            if (r211 == null) goto L82;
            String r110 = r211.f232469b;
            if (r110 == null) goto L82;
            if ((!StringsKt.isBlank(r110)) == false) goto L22;
            String r111 = r110;
        L23:
            if (r111 == null) goto L82;
            DriveFile.Status r112 = DriveFile.Status.from(r211.f232473f);
            Intrinsics.checkNotNull(r112);
            if (r112 != DriveFile.Status.FAILED) goto L28;
        L32:
            boolean r113 = false;
        L34:
            if (r113 == false) goto L43;
            long r114 = r211.f232470c;
            long r115 = r211.f232471d;
            if (r115 > 0) goto L38;
        L40:
            boolean r116 = false;
        L41:
            if (r116 == false) goto L43;
            boolean r117 = true;
        L44:
            if (r117 == false) goto L46;
            OfficeUploadStatus r118 = OfficeUploadStatus.FINISH;
        L47:
            OfficeUploadStatus r119 = r118;
            String r120 = "recovered:".concat(r111);
            String r121 = r211.f232468a;
            if (r121 != null) goto L50;
        L56:
            String r122 = r211.f232474g;
            if (r122 == null) goto L63;
            String r123 = StringsKt.substringAfterLast$default(r122, '/', null, 2, null);
            if (r123 == null) goto L63;
            if ((!StringsKt.isBlank(r123)) == false) goto L63;
        L64:
            if (r123 != null) goto L66;
            r123 = eu5.b.f474075a.getString(R.string.Doc_List_UntitledFile);
        L66:
            String r124 = r123;
        L67:
            Long r125 = Long.valueOf(r211.f232471d);
            if (r125.longValue() <= 0) goto L70;
            boolean r126 = true;
        L71:
            if (r126 == false) goto L73;
            Long r127 = r125;
        L74:
            Long r128 = Long.valueOf(r211.f232470c);
            if (r128.longValue() < 0) goto L77;
            boolean r129 = true;
        L78:
            if (r129 == false) goto L80;
            Long r130 = r128;
        L81:
            r101 = new h0(r120, r111, "", false, r124, null, r127, r130, r109.b(), r119, null, OfficeUploadTaskSource.RECOVERED, 55808);
            goto L82
        L80:
            r130 = null;
            goto L81
        L77:
            r129 = false;
            goto L78
        L73:
            r127 = null;
            goto L74
        L70:
            r126 = false;
        L63:
            r123 = null;
            goto L64
        L50:
            if ((!StringsKt.isBlank(r121)) == true) goto L53;
            r121 = null;
        L53:
            if (r121 == null) goto L56;
            r124 = r121;
            goto L67
        L46:
            r118 = i.a(r112);
            goto L47
        L38:
            if (r114 < r115) goto L40;
            r116 = true;
        L43:
            r117 = false;
            goto L44
        L28:
            if (r112 == DriveFile.Status.CANCEL) goto L32;
            if (r112 == DriveFile.Status.UNKNOWN) goto L32;
            r113 = true;
            goto L34
        L22:
            r111 = null;
        L82:
            if (r101 != null) goto L84;
            return;
        L84:
            Handler r131 = OfficeUploadStore.f235310a;
            Intrinsics.checkNotNullParameter(r101, "task");
            OfficeUploadStore.e(new OfficeUploadStore$updateRecoveredTaskIfPresent$1(r101));
            if (r101.f235383k != OfficeUploadStatus.FINISH) goto L88;
            markDirtyOnMain(r101.f235381i);
            return;
        L88:
            return;
        L11:
            r106 = null;
            goto L12
        L7:
            r104 = null;
            goto L8
        L13:
            r107 = null;
            goto L14
        }

        @Override // rf5.e
        public void onUploadFileSuccess(String r100, rf5.d r101) {
            if (r100 != null) goto L4;
            return;
        L4:
            if ((!StringsKt.isBlank(r100)) == true) goto L7;
            r100 = null;
        L7:
            if (r100 == null) goto L12;
            tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace monitor_success keyHash=" + r100.hashCode());
            Handler r102 = OfficeUploadStore.f235310a;
            OfficeUploadStore.g(r100, OfficeUploadRecoveryCoordinator$RecoveryMonitor$onUploadFileSuccess$1.INSTANCE);
            markDirtyOnMain(this.target.b());
            return;
        }

        @Override // rf5.e
        public void onUploadErrorCode(String r100, final int r101, final long r102) {
            if (r100 != null) goto L4;
            return;
        L4:
            if ((!StringsKt.isBlank(r100)) == true) goto L7;
            r100 = null;
        L7:
            if (r100 == null) goto L12;
            tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace monitor_error keyHash=" + r100.hashCode() + " errorCode=" + r101 + " bytesTotal=" + r102);
            Handler r103 = OfficeUploadStore.f235310a;
            OfficeUploadStore.g(r100, new OfficeUploadRecoveryCoordinator$RecoveryMonitor$onUploadErrorCode$1(r102, r101));
            return;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryCoordinator$ResumeUploadCallback;", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "Lcom/bytedance/ee/util/io/NonProguard;", "driveKey", "", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;)V", "updateProgress", "", "key", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "markDirtyOnMain", "", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResumeUploadCallback implements UploadCallback, NonProguard {
        private final String driveKey;
        private final g0 target;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g0 f235296a;

            public a(g0 r100) {
                this.f235296a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r100 = d0.f235354a;     // Catch: Throwable -> L4
                d0.a(this.f235296a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        private final void markDirtyOnMain(g0 r100) {
            OfficeUploadRecoveryCoordinator.f235293c.post(new a(r100));
        }

        public ResumeUploadCallback(String r100, g0 r101) {
            Intrinsics.checkNotNullParameter(r100, "driveKey");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            this.driveKey = r100;
            this.target = r101;
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean updateProgress(String r100, final UploadCallback.b r101, UploadCallback.a r102) {
            Intrinsics.checkNotNullParameter(r101, "info");
            Intrinsics.checkNotNullParameter(r102, "extra");
            if (r100 != null) goto L5;
        L9:
            r100 = this.driveKey;
        L10:
            tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace resume_progress keyHash=" + r100.hashCode() + " status=" + r101.f232490a + " bytes=" + r101.f232491b + '/' + r101.f232492c);
            Handler r103 = OfficeUploadStore.f235310a;
            OfficeUploadStore.g(r100, new OfficeUploadRecoveryCoordinator$ResumeUploadCallback$updateProgress$1(r101));
            if (r101.f232490a != DriveFile.Status.SUCCESS) goto L15;
            markDirtyOnMain(this.target);
            return false;
        L15:
            return false;
        L5:
            if ((!StringsKt.isBlank(r100)) == true) goto L8;
            r100 = null;
        L8:
            if (r100 != null) goto L10;
            goto L9
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean onFailed(String r100, final int r101, String r102, final long r103) {
            if (r100 != null) goto L4;
        L8:
            r100 = this.driveKey;
        L9:
            tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace resume_failed keyHash=" + r100.hashCode() + " errorCode=" + r101 + " bytesTotal=" + r103);
            Handler r104 = OfficeUploadStore.f235310a;
            OfficeUploadStore.g(r100, new OfficeUploadRecoveryCoordinator$ResumeUploadCallback$onFailed$1(r103, r101));
            return false;
        L4:
            if ((!StringsKt.isBlank(r100)) == true) goto L7;
            r100 = null;
        L7:
            if (r100 != null) goto L9;
            goto L8
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OfficeUploadRecoveryTarget f235297a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final rf5.e f235298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f235299c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f235297a, r101.f235297a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f235298b, r101.f235298b) == true) goto L15;
            return false;
        L15:
            if (this.f235299c == r101.f235299c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f235297a.hashCode() * 31) + this.f235298b.hashCode()) * 31) + this.f235299c;
        }

        public final String toString() {
            return "TargetRegistration(target=" + this.f235297a + ", monitor=" + this.f235298b + ", refCount=" + this.f235299c + ')';
        }

        public a(OfficeUploadRecoveryTarget r100, rf5.e r101) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r101, "monitor");
            this.f235297a = r100;
            this.f235298b = r101;
            this.f235299c = 1;
        }
    }

    public static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f235301a = null;

        static {
            f235301a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "office-upload-recovery");
        }
    }

    public OfficeUploadRecoveryCoordinator() {
    }

    static {
        f235291a = new OfficeUploadRecoveryCoordinator();
        f235292b = PThreadExecutorsUtils.newSingleThreadExecutor(b.f235301a);
        f235293c = new Handler(Looper.getMainLooper());
        f235294d = new LinkedHashMap();
    }

    public static com.bytedance.ee.bear.drive.sdk.service.g a() {
        return ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
    }

    public static String b(OfficeUploadRecoveryTarget r100) {
        g0 r101 = r100.b();
        if (Intrinsics.areEqual(r101, g0.b.f235371a) == false) goto L6;
        return "all_files_token";
    L6:
        if ((r101 instanceof g0.a) == false) goto L10;
        return ((g0.a) r101).f235370a;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(OfficeUploadRecoveryTarget r310) {
        String r100 = du5.b.k(d(r310));
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(a().A(b(r310), FileInfoPuller.CALLER_EXPLORER));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        tt5.a.l("OfficeUploadRecovery", "recover upload list failed, target=" + r100, r103);
        r102 = CollectionsKt.emptyList();
    L11:
        List r104 = (List) r102;
        if (r104 != null) goto L14;
        tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace drive_upload_list_null target=" + r100);
        r104 = CollectionsKt.emptyList();
    L14:
        StringBuilder r105 = new StringBuilder("office_upload_recovery_trace recover_list_result target=");
        r105.append(r100);
        r105.append(" rawCount=");
        r105.append(r104.size());
        r105.append(" raw=");
        List r106 = r104;
        r105.append(CollectionsKt.joinToString$default(r106, null, null, null, 5, null, OfficeUploadRecoveryCoordinator$recoverUploadList$1.INSTANCE, 23, null));
        tt5.a.h("OfficeUploadRecovery", r105.toString());
        final ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L15:
        Object r110 = null;
        if (r108.hasNext() == false) goto L88;
        DriveFile r109 = (DriveFile) r108.next();
        int r111 = c0.f235345a;
        Intrinsics.checkNotNullParameter(r310, PickerReporterConstants.KEY.TARGET);
        if (r109 == null) goto L86;
        String r112 = r109.key;
        if (r112 == null) goto L86;
        if ((!StringsKt.isBlank(r112)) == true) goto L26;
        r112 = null;
    L26:
        if (r112 == null) goto L86;
        int r113 = i.f235389a;
        OfficeUploadStatus r114 = i.a(r109.status);
        if (r114 == OfficeUploadStatus.FINISH) goto L86;
        DriveFile.Status r115 = r109.status;
        if (r115 != DriveFile.Status.FAILED) goto L33;
    L37:
        boolean r116 = false;
    L39:
        if (r116 == false) goto L48;
        long r117 = r109.bytesTransferred;
        long r118 = r109.bytesTotal;
        if (r118 > 0) goto L43;
    L45:
        boolean r119 = false;
    L46:
        if (r119 == false) goto L48;
        boolean r120 = true;
    L49:
        if (r120 == true) goto L86;
        String r121 = "recovered:".concat(r112);
        String r122 = r109.fileName;
        if (r122 != null) goto L54;
    L58:
        String r123 = r109.path;
        if (r123 == null) goto L65;
        r122 = StringsKt.substringAfterLast$default(r123, '/', null, 2, null);
        if (r122 == null) goto L65;
        if ((!StringsKt.isBlank(r122)) == false) goto L65;
    L66:
        if (r122 != null) goto L68;
        r122 = eu5.b.f474075a.getString(R.string.Doc_List_UntitledFile);
    L68:
        String r210 = r122;
        Long r124 = Long.valueOf(r109.bytesTotal);
        if (r124.longValue() <= 0) goto L71;
        boolean r125 = true;
    L72:
        if (r125 == false) goto L74;
        Long r211 = r124;
    L75:
        Long r126 = Long.valueOf(r109.bytesTransferred);
        if (r126.longValue() < 0) goto L78;
        boolean r127 = true;
    L79:
        if (r127 == false) goto L81;
        Long r212 = r126;
    L82:
        g0 r213 = r310.b();
        String r128 = r109.errorCode;
        if (r128 == null) goto L85;
        r110 = StringsKt.toIntOrNull(r128);
    L85:
        r110 = new h0(r121, r112, "", false, r210, null, r211, r212, r213, r114, r110, OfficeUploadTaskSource.RECOVERED, 49664);
        goto L86
    L81:
        r212 = null;
        goto L82
    L78:
        r127 = false;
        goto L79
    L74:
        r211 = null;
        goto L75
    L71:
        r125 = false;
    L65:
        r122 = null;
        goto L66
    L54:
        if ((!StringsKt.isBlank(r122)) == true) goto L57;
        r122 = null;
    L57:
        if (r122 != null) goto L68;
    L43:
        if (r117 < r118) goto L45;
        r119 = true;
    L48:
        r120 = false;
        goto L49
    L33:
        if (r115 == DriveFile.Status.CANCEL) goto L37;
        if (r115 == DriveFile.Status.UNKNOWN) goto L37;
        r116 = true;
    L86:
        if (r110 == null) goto L15;
        r107.add(r110);
        goto L15
    L88:
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace recover_list_mapped target=" + r100 + " mappedCount=" + r107.size() + " mapped=" + CollectionsKt.joinToString$default(r107, null, null, null, 5, null, OfficeUploadRecoveryCoordinator$recoverUploadList$2.INSTANCE, 23, null));
        Handler r129 = OfficeUploadStore.f235310a;
        final g0 r130 = r310.b();
        Intrinsics.checkNotNullParameter(r130, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r107, "recoveredTasks");
        OfficeUploadStore.e(new OfficeUploadStore$mergeRecoveredTasksForTarget$1(r130, r107));
        ArrayList r131 = new ArrayList();
        Iterator r132 = r107.iterator();
    L90:
        if (r132.hasNext() == false) goto L100;
        Object r133 = r132.next();
        OfficeUploadStatus r134 = ((h0) r133).f235383k;
        if (r134 != OfficeUploadStatus.UNSTARTED) goto L94;
    L97:
        boolean r135 = true;
    L98:
        if (r135 == false) goto L90;
        r131.add(r133);
        goto L90
    L94:
        if (r134 == OfficeUploadStatus.UPLOADING) goto L97;
        r135 = false;
        goto L98
    L100:
        ArrayList r136 = new ArrayList();
        Iterator r137 = r131.iterator();
    L102:
        if (r137.hasNext() == false) goto L115;
        h0 r138 = (h0) r137.next();
        String r139 = r138.f235374b;
        if (r139 == null) goto L112;
        if ((!StringsKt.isBlank(r139)) == true) goto L109;
        r139 = null;
    L109:
        if (r139 == null) goto L112;
        Pair r140 = TuplesKt.to(r139, r138.f235381i);
    L113:
        if (r140 == null) goto L102;
        r136.add(r140);
    L112:
        r140 = null;
        goto L113
    L115:
        Iterator r141 = r136.iterator();
    L117:
        if (r141.hasNext() == false) goto L128;
        Pair r142 = (Pair) r141.next();
        String r143 = (String) r142.component1();
        g0 r144 = (g0) r142.component2();
        OfficeUploadRecoveryCoordinator r145 = f235291a;
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L121
        r145.getClass();     // Catch: Throwable -> L121
        Object r147 = Result.m9449constructorimpl(a().h(r143, new ResumeUploadCallback(r143, r144)));     // Catch: Throwable -> L121
    L123:
        Throwable r148 = Result.m9452exceptionOrNullimpl(r147);
        if (r148 == null) goto L127;
        tt5.a.l("OfficeUploadRecovery", "office_upload_recovery_trace resume_throw keyHash=" + r143.hashCode(), r148);
        r147 = null;
    L127:
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace resume_result keyHash=" + r143.hashCode() + " result=" + ((androidx.core.util.Pair) r147));
    L121:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        r147 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L123
    L128:
        return;
    L5:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(OfficeUploadRecoveryTarget r100) {
        return "explorer:" + b(r100);
    }
}
