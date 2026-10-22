package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.util.io.NonProguard;
import com.larus.apm.impl.protector.RunnableProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class OfficeUploadRecoveryCoordinator {
    public static final OfficeUploadRecoveryCoordinator a = null;
    public static final ExecutorService b = null;
    public static final Handler c = null;
    public static final LinkedHashMap<String, a> d = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\"\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryCoordinator$RecoveryMonitor;", "Lcom/bytedance/ee/bear/middleground/drive/export/IMGDriveInterfaces$IUploadStateMonitor;", "Lcom/bytedance/ee/util/io/NonProguard;", "target", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryTarget;", "<init>", "(Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryTarget;)V", "onExistUploadingFile", "", "onFileProgressChange", "totalProgress", "", "progressingEntity", "Lcom/bytedance/ee/bear/middleground/drive/export/ProgressingEntity;", "onFileCountChange", "finishCount", "totalCount", "onUploadFinished", "onUploadError", "count", "onUploadErrorCode", "fileId", "", "errorCode", "bytesTotal", "", "onUploadFileSuccess", "key", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/IMGDriveInterfaces$FileExtra;", "markDirtyOnMain", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RecoveryMonitor implements rf5.e, NonProguard {
        private final OfficeUploadRecoveryTarget target;

        public static final class a implements Runnable {
            public final /* synthetic */ g0 a;

            public a(g0 r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r0 = d0.a;     // Catch: Throwable -> L4
                d0.a(this.a);     // Catch: Throwable -> L4
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
        public void onFileCountChange(int r1, int r2) {
        }

        @Override // rf5.e
        public void onUploadError(int r1) {
        }

        @Override // rf5.e
        public void onUploadFinished() {
        }

        public RecoveryMonitor(OfficeUploadRecoveryTarget r2) {
            Intrinsics.checkNotNullParameter(r2, "target");
            this.target = r2;
        }

        private final void markDirtyOnMain(g0 r3) {
            OfficeUploadRecoveryCoordinator.c.post(new a(r3));
        }

        @Override // rf5.e
        public void onFileProgressChange(int r23, ProgressingEntity r24) {
            StringBuilder r2 = new StringBuilder("office_upload_recovery_trace monitor_progress total=");
            r2.append(r23);
            r2.append(" entity=");
            final h0 r4 = null;
            if (r24 == null) goto L13;
            OfficeUploadRecoveryCoordinator.a.getClass();
            StringBuilder r5 = new StringBuilder("{key=");
            String r6 = r24.b;
            if (r6 == null) goto L7;
            Integer r7 = Integer.valueOf(r6.hashCode());
        L8:
            r5.append(r7);
            r5.append(",nameLen=");
            String r8 = r24.a;
            if (r8 == null) goto L11;
            Integer r9 = Integer.valueOf(r8.length());
        L12:
            r5.append(r9);
            r5.append(",status=");
            r5.append(r24.f);
            r5.append(",bytes=");
            r5.append(r24.c);
            r5.append('/');
            r5.append(r24.d);
            r5.append(",progress=");
            r5.append(r24.e);
            r5.append('}');
            String r10 = r5.toString();
        L14:
            r2.append(r10);
            tt5.a.h("OfficeUploadRecovery", r2.toString());
            int r3 = c0.a;
            OfficeUploadRecoveryTarget r11 = this.target;
            Intrinsics.checkNotNullParameter(r11, "target");
            if (r24 == null) goto L82;
            String r12 = r24.b;
            if (r12 == null) goto L82;
            if ((!StringsKt.isBlank(r12)) == false) goto L22;
            String r13 = r12;
        L23:
            if (r13 == null) goto L82;
            DriveFile.Status r14 = DriveFile.Status.from(r24.f);
            Intrinsics.checkNotNull(r14);
            if (r14 != DriveFile.Status.FAILED) goto L28;
        L32:
            boolean r15 = false;
        L34:
            if (r15 == false) goto L43;
            long r16 = r24.c;
            long r17 = r24.d;
            if (r17 > 0) goto L38;
        L40:
            boolean r18 = false;
        L41:
            if (r18 == false) goto L43;
            boolean r19 = true;
        L44:
            if (r19 == false) goto L46;
            OfficeUploadStatus r20 = OfficeUploadStatus.FINISH;
        L47:
            OfficeUploadStatus r110 = r20;
            String r21 = "recovered:".concat(r13);
            String r22 = r24.a;
            if (r22 != null) goto L50;
        L56:
            String r25 = r24.g;
            if (r25 == null) goto L63;
            String r26 = StringsKt.substringAfterLast$default(r25, '/', null, 2, null);
            if (r26 == null) goto L63;
            if ((!StringsKt.isBlank(r26)) == false) goto L63;
        L64:
            if (r26 != null) goto L66;
            r26 = eu5.b.a.getString(2131888008);
        L66:
            String r111 = r26;
        L67:
            Long r27 = Long.valueOf(r24.d);
            if (r27.longValue() <= 0) goto L70;
            boolean r28 = true;
        L71:
            if (r28 == false) goto L73;
            Long r112 = r27;
        L74:
            Long r1 = Long.valueOf(r24.c);
            if (r1.longValue() < 0) goto L77;
            boolean r29 = true;
        L78:
            if (r29 == false) goto L80;
            Long r113 = r1;
        L81:
            r4 = new h0(r21, r13, "", false, r111, null, r112, r113, r11.b(), r110, null, OfficeUploadTaskSource.RECOVERED, 55808);
            goto L82
        L80:
            r113 = null;
            goto L81
        L77:
            r29 = false;
            goto L78
        L73:
            r112 = null;
            goto L74
        L70:
            r28 = false;
        L63:
            r26 = null;
            goto L64
        L50:
            if ((!StringsKt.isBlank(r22)) == true) goto L53;
            r22 = null;
        L53:
            if (r22 == null) goto L56;
            r111 = r22;
            goto L67
        L46:
            r20 = i.a(r14);
            goto L47
        L38:
            if (r16 < r17) goto L40;
            r18 = true;
        L43:
            r19 = false;
            goto L44
        L28:
            if (r14 == DriveFile.Status.CANCEL) goto L32;
            if (r14 == DriveFile.Status.UNKNOWN) goto L32;
            r15 = true;
            goto L34
        L22:
            r13 = null;
        L82:
            if (r4 != null) goto L84;
            return;
        L84:
            Handler r30 = OfficeUploadStore.a;
            Intrinsics.checkNotNullParameter(r4, "task");
            OfficeUploadStore.e(new OfficeUploadStore$updateRecoveredTaskIfPresent$1(r4));
            if (r4.k != OfficeUploadStatus.FINISH) goto L88;
            markDirtyOnMain(r4.i);
            return;
        L88:
            return;
        L11:
            r9 = null;
            goto L12
        L7:
            r7 = null;
            goto L8
        L13:
            r10 = null;
            goto L14
        }

        @Override // rf5.e
        public void onUploadFileSuccess(String r2, rf5.d r3) {
            if (r2 != null) goto L4;
            return;
        L4:
            if ((!StringsKt.isBlank(r2)) == true) goto L7;
            r2 = null;
        L7:
            if (r2 == null) goto L12;
            tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace monitor_success keyHash=" + r2.hashCode());
            Handler r4 = OfficeUploadStore.a;
            OfficeUploadStore.g(r2, OfficeUploadRecoveryCoordinator$RecoveryMonitor$onUploadFileSuccess$1.INSTANCE);
            markDirtyOnMain(this.target.b());
            return;
        }

        @Override // rf5.e
        public void onUploadErrorCode(String r3, final int r4, final long r5) {
            if (r3 != null) goto L4;
            return;
        L4:
            if ((!StringsKt.isBlank(r3)) == true) goto L7;
            r3 = null;
        L7:
            if (r3 == null) goto L12;
            tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace monitor_error keyHash=" + r3.hashCode() + " errorCode=" + r4 + " bytesTotal=" + r5);
            Handler r0 = OfficeUploadStore.a;
            OfficeUploadStore.g(r3, new OfficeUploadRecoveryCoordinator$RecoveryMonitor$onUploadErrorCode$1(r5, r4));
            return;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadRecoveryCoordinator$ResumeUploadCallback;", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "Lcom/bytedance/ee/util/io/NonProguard;", "driveKey", "", "target", "Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;", "<init>", "(Ljava/lang/String;Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadTarget;)V", "updateProgress", "", "key", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "markDirtyOnMain", "", "office-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResumeUploadCallback implements UploadCallback, NonProguard {
        private final String driveKey;
        private final g0 target;

        public static final class a implements Runnable {
            public final /* synthetic */ g0 a;

            public a(g0 r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r0 = d0.a;     // Catch: Throwable -> L4
                d0.a(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        private final void markDirtyOnMain(g0 r3) {
            OfficeUploadRecoveryCoordinator.c.post(new a(r3));
        }

        public ResumeUploadCallback(String r2, g0 r3) {
            Intrinsics.checkNotNullParameter(r2, "driveKey");
            Intrinsics.checkNotNullParameter(r3, "target");
            this.driveKey = r2;
            this.target = r3;
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean updateProgress(String r3, final UploadCallback.b r4, UploadCallback.a r5) {
            Intrinsics.checkNotNullParameter(r4, "info");
            Intrinsics.checkNotNullParameter(r5, "extra");
            if (r3 != null) goto L5;
        L9:
            r3 = this.driveKey;
        L10:
            tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace resume_progress keyHash=" + r3.hashCode() + " status=" + r4.a + " bytes=" + r4.b + '/' + r4.c);
            Handler r6 = OfficeUploadStore.a;
            OfficeUploadStore.g(r3, new OfficeUploadRecoveryCoordinator$ResumeUploadCallback$updateProgress$1(r4));
            if (r4.a != DriveFile.Status.SUCCESS) goto L15;
            markDirtyOnMain(this.target);
            return false;
        L15:
            return false;
        L5:
            if ((!StringsKt.isBlank(r3)) == true) goto L8;
            r3 = null;
        L8:
            if (r3 != null) goto L10;
            goto L9
        }

        @Override // com.bytedance.ee.bear.middleground.drive.export.UploadCallback
        public boolean onFailed(String r2, final int r3, String r4, final long r5) {
            if (r2 != null) goto L4;
        L8:
            r2 = this.driveKey;
        L9:
            tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace resume_failed keyHash=" + r2.hashCode() + " errorCode=" + r3 + " bytesTotal=" + r5);
            Handler r6 = OfficeUploadStore.a;
            OfficeUploadStore.g(r2, new OfficeUploadRecoveryCoordinator$ResumeUploadCallback$onFailed$1(r5, r3));
            return false;
        L4:
            if ((!StringsKt.isBlank(r2)) == true) goto L7;
            r2 = null;
        L7:
            if (r2 != null) goto L9;
            goto L8
        }
    }

    public static final class a {
        public final OfficeUploadRecoveryTarget a;
        public final rf5.e b;
        public int c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public final String toString() {
            return "TargetRegistration(target=" + this.a + ", monitor=" + this.b + ", refCount=" + this.c + ')';
        }

        public a(OfficeUploadRecoveryTarget r2, rf5.e r3) {
            Intrinsics.checkNotNullParameter(r2, "target");
            Intrinsics.checkNotNullParameter(r3, "monitor");
            this.a = r2;
            this.b = r3;
            this.c = 1;
        }
    }

    public static final class b implements ThreadFactory {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            return new PthreadThreadV2(r3, "office-upload-recovery");
        }
    }

    public OfficeUploadRecoveryCoordinator() {
    }

    static {
        a = new OfficeUploadRecoveryCoordinator();
        b = PThreadExecutorsUtils.newSingleThreadExecutor(b.a);
        c = new Handler(Looper.getMainLooper());
        d = new LinkedHashMap();
    }

    public static com.bytedance.ee.bear.drive.sdk.service.g a() {
        return ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0();
    }

    public static String b(OfficeUploadRecoveryTarget r1) {
        g0 r2 = r1.b();
        if (Intrinsics.areEqual(r2, g0.b.a) == false) goto L6;
        return "all_files_token";
    L6:
        if ((r2 instanceof g0.a) == false) goto L10;
        return ((g0.a) r2).a;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(OfficeUploadRecoveryTarget r30) {
        String r1 = du5.b.k(d(r30));
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r2 = Result.constructor-impl(a().A(b(r30), "explorer"));     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L11;
        tt5.a.l("OfficeUploadRecovery", "recover upload list failed, target=" + r1, r3);
        r2 = CollectionsKt.emptyList();
    L11:
        List r4 = (List) r2;
        if (r4 != null) goto L14;
        tt5.a.k("OfficeUploadRecovery", "office_upload_recovery_trace drive_upload_list_null target=" + r1);
        r4 = CollectionsKt.emptyList();
    L14:
        StringBuilder r5 = new StringBuilder("office_upload_recovery_trace recover_list_result target=");
        r5.append(r1);
        r5.append(" rawCount=");
        r5.append(r4.size());
        r5.append(" raw=");
        List r6 = r4;
        r5.append(CollectionsKt.joinToString$default(r6, null, null, null, 5, null, OfficeUploadRecoveryCoordinator$recoverUploadList$1.INSTANCE, 23, null));
        tt5.a.h("OfficeUploadRecovery", r5.toString());
        final ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L15:
        Object r15 = null;
        if (r8.hasNext() == false) goto L88;
        DriveFile r9 = (DriveFile) r8.next();
        int r10 = c0.a;
        Intrinsics.checkNotNullParameter(r30, "target");
        if (r9 == null) goto L86;
        String r11 = r9.key;
        if (r11 == null) goto L86;
        if ((!StringsKt.isBlank(r11)) == true) goto L26;
        r11 = null;
    L26:
        if (r11 == null) goto L86;
        int r12 = i.a;
        OfficeUploadStatus r13 = i.a(r9.status);
        if (r13 == OfficeUploadStatus.FINISH) goto L86;
        DriveFile.Status r14 = r9.status;
        if (r14 != DriveFile.Status.FAILED) goto L33;
    L37:
        boolean r16 = false;
    L39:
        if (r16 == false) goto L48;
        long r17 = r9.bytesTransferred;
        long r18 = r9.bytesTotal;
        if (r18 > 0) goto L43;
    L45:
        boolean r19 = false;
    L46:
        if (r19 == false) goto L48;
        boolean r20 = true;
    L49:
        if (r20 == true) goto L86;
        String r21 = "recovered:".concat(r11);
        String r110 = r9.fileName;
        if (r110 != null) goto L54;
    L58:
        String r111 = r9.path;
        if (r111 == null) goto L65;
        r110 = StringsKt.substringAfterLast$default(r111, '/', null, 2, null);
        if (r110 == null) goto L65;
        if ((!StringsKt.isBlank(r110)) == false) goto L65;
    L66:
        if (r110 != null) goto L68;
        r110 = eu5.b.a.getString(2131888008);
    L68:
        String r22 = r110;
        Long r112 = Long.valueOf(r9.bytesTotal);
        if (r112.longValue() <= 0) goto L71;
        boolean r113 = true;
    L72:
        if (r113 == false) goto L74;
        Long r23 = r112;
    L75:
        Long r114 = Long.valueOf(r9.bytesTransferred);
        if (r114.longValue() < 0) goto L78;
        boolean r115 = true;
    L79:
        if (r115 == false) goto L81;
        Long r24 = r114;
    L82:
        g0 r25 = r30.b();
        String r26 = r9.errorCode;
        if (r26 == null) goto L85;
        r15 = StringsKt.toIntOrNull(r26);
    L85:
        r15 = new h0(r21, r11, "", false, r22, null, r23, r24, r25, r13, r15, OfficeUploadTaskSource.RECOVERED, 49664);
        goto L86
    L81:
        r24 = null;
        goto L82
    L78:
        r115 = false;
        goto L79
    L74:
        r23 = null;
        goto L75
    L71:
        r113 = false;
    L65:
        r110 = null;
        goto L66
    L54:
        if ((!StringsKt.isBlank(r110)) == true) goto L57;
        r110 = null;
    L57:
        if (r110 != null) goto L68;
    L43:
        if (r17 < r18) goto L45;
        r19 = true;
    L48:
        r20 = false;
        goto L49
    L33:
        if (r14 == DriveFile.Status.CANCEL) goto L37;
        if (r14 == DriveFile.Status.UNKNOWN) goto L37;
        r16 = true;
    L86:
        if (r15 == null) goto L15;
        r7.add(r15);
        goto L15
    L88:
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace recover_list_mapped target=" + r1 + " mappedCount=" + r7.size() + " mapped=" + CollectionsKt.joinToString$default(r7, null, null, null, 5, null, OfficeUploadRecoveryCoordinator$recoverUploadList$2.INSTANCE, 23, null));
        Handler r27 = OfficeUploadStore.a;
        final g0 r28 = r30.b();
        Intrinsics.checkNotNullParameter(r28, "target");
        Intrinsics.checkNotNullParameter(r7, "recoveredTasks");
        OfficeUploadStore.e(new OfficeUploadStore$mergeRecoveredTasksForTarget$1(r28, r7));
        ArrayList r29 = new ArrayList();
        Iterator r31 = r7.iterator();
    L90:
        if (r31.hasNext() == false) goto L100;
        Object r32 = r31.next();
        OfficeUploadStatus r33 = ((h0) r32).k;
        if (r33 != OfficeUploadStatus.UNSTARTED) goto L94;
    L97:
        boolean r116 = true;
    L98:
        if (r116 == false) goto L90;
        r29.add(r32);
        goto L90
    L94:
        if (r33 == OfficeUploadStatus.UPLOADING) goto L97;
        r116 = false;
        goto L98
    L100:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r29.iterator();
    L102:
        if (r35.hasNext() == false) goto L115;
        h0 r36 = (h0) r35.next();
        String r37 = r36.b;
        if (r37 == null) goto L112;
        if ((!StringsKt.isBlank(r37)) == true) goto L109;
        r37 = null;
    L109:
        if (r37 == null) goto L112;
        Pair r38 = TuplesKt.to(r37, r36.i);
    L113:
        if (r38 == null) goto L102;
        r34.add(r38);
    L112:
        r38 = null;
        goto L113
    L115:
        Iterator r39 = r34.iterator();
    L117:
        if (r39.hasNext() == false) goto L128;
        Pair r40 = (Pair) r39.next();
        String r41 = (String) r40.component1();
        g0 r42 = (g0) r40.component2();
        OfficeUploadRecoveryCoordinator r43 = a;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L121
        r43.getClass();     // Catch: Throwable -> L121
        Object r45 = Result.constructor-impl(a().h(r41, new ResumeUploadCallback(r41, r42)));     // Catch: Throwable -> L121
    L123:
        Throwable r46 = Result.exceptionOrNull-impl(r45);
        if (r46 == null) goto L127;
        tt5.a.l("OfficeUploadRecovery", "office_upload_recovery_trace resume_throw keyHash=" + r41.hashCode(), r46);
        r45 = null;
    L127:
        tt5.a.h("OfficeUploadRecovery", "office_upload_recovery_trace resume_result keyHash=" + r41.hashCode() + " result=" + ((androidx.core.util.Pair) r45));
    L121:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r45 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L123
    L128:
        return;
    L5:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static String d(OfficeUploadRecoveryTarget r2) {
        return "explorer:" + b(r2);
    }
}
