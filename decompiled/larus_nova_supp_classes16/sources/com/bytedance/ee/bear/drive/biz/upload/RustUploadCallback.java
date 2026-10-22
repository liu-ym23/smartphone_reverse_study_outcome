package com.bytedance.ee.bear.drive.biz.upload;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.h;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.bear.quoto.SingleFileQuotaConfig;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.vfs.VFSFile;
import i75.f;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J,\u0010\u0019\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J5\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010$R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/upload/RustUploadCallback;", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "mFilePointer", "", "mIsFileUri", "", "mDriveReport", "Lcom/bytedance/ee/bear/drive/report/DriveReport;", "mExtras", "Landroid/os/Bundle;", "mUserComponentAbility", "Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/ee/bear/drive/report/DriveReport;Landroid/os/Bundle;Lcom/bytedance/ee/bear/drive/usercomponent/DriveUserComponentAbility;)V", "Ljava/lang/Boolean;", "updateProgress", "key", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "reportClientFileUpload", "", "fileToken", "filePath", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "", "addUploadDriveFileCache", "filePointer", "isFileUseUri", "objToken", "dataVersion", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RustUploadCallback implements UploadCallback {
    public static final a Companion = null;
    public final transient Bundle a;
    public final transient a95.a b;
    private final com.bytedance.ee.bear.drive.report.c mDriveReport;
    private final String mFilePointer;
    private final Boolean mIsFileUri;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ Boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ DriveFilePath c;
        public final /* synthetic */ RustUploadCallback d;
        public final /* synthetic */ VFSFile e;

        public b(Boolean r1, String r2, DriveFilePath r3, RustUploadCallback r4, VFSFile r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            boolean r5 = this.a.booleanValue();
            String r0 = this.b;
            DriveFilePath r1 = this.c;
            Intrinsics.checkNotNull(r1);
            FileUtils.i(r5, r0, z75.b.b(r1, RustUploadCallback.access$getMUserComponentAbility$p(this.d).b));
            return Boolean.valueOf(this.e.exists());
        }
    }

    public static final class c<T, R> implements Function {
        public final /* synthetic */ String a;
        public final /* synthetic */ Boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ RustUploadCallback f;

        public c(String r1, Boolean r2, String r3, String r4, String r5, RustUploadCallback r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final Object apply(Object r6) {
            Intrinsics.checkNotNullParameter((Boolean) r6, "it");
            tt5.a.h("UploadPresenter", "addUploadDriveFileCache cachetype=lru");
            String r7 = du5.d.a(this.a);
            DriveFilePath r1 = f.a(0).cacheName(r7);
            v85.c.a r2 = new v85.c.a();
            r2.a = 0;
            r2.b = r7;
            String r8 = this.a;
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            r2.c = r8;
            boolean r9 = this.b.booleanValue();
            String r4 = this.c;
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r2.d = FileUtils.x(r9, r4);
            Intrinsics.checkNotNull(r1);
            r2.c(r1);
            DriveFilePath.Companion.getClass();
            r2.d(DriveFilePath.a.a());
            r2.g = "";
            String r10 = this.d;
            if (r10 != null) goto L11;
            r10 = "";
        L11:
            r2.h = r10;
            String r11 = this.e;
            r2.i = r11;
            r2.j = r11;
            r2.k = "";
            r2.l = "3";
            r2.q = "2";
            r2.n = false;
            r2.o = false;
            r2.s = false;
            v85.c r12 = new v85.c(r2);
            return t.l().m(r12, RustUploadCallback.access$getMUserComponentAbility$p(this.f).b);
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
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
            tt5.a.d("UploadPresenter", "addUploadDriveFileCache fail: " + ((Throwable) r3));
        }
    }

    static {
        Companion = new a();
    }

    public static final /* synthetic */ a95.a access$getMUserComponentAbility$p(RustUploadCallback r0) {
        return r0.b;
    }

    public boolean updateProgress(String r12, UploadCallback.b r13, UploadCallback.a r14) {
        Intrinsics.checkNotNullParameter(r13, "info");
        Intrinsics.checkNotNullParameter(r14, "extra");
        tt5.a.b("DRIVE_RustUploadCallback", "upload file, status: " + r13.a);
        DriveFile.Status r0 = r13.a;
        DriveFile.Status r1 = DriveFile.Status.SUCCESS;
        boolean r2 = true;
        if (r0 == r1) goto L5;
    L24:
        DriveFile.Status r16 = r13.a;
        if (r16 != r1) goto L27;
    L30:
        com.bytedance.ee.bear.drive.report.c r4 = this.mDriveReport;
        String r5 = r14.b;
        if (r12 != null) goto L33;
        r12 = "";
    L33:
        if (r16 == r1) goto L36;
        r2 = false;
    L36:
        r4.J(r5, r12, r2, r14.a);
    L37:
        return false;
    L27:
        if (r16 == DriveFile.Status.FAILED) goto L30;
        if (r16 != DriveFile.Status.CANCEL) goto L37;
    L5:
        if (this.b.c.isEnable("ccm.mobile.drive.add_preview_cache_enable") == false) goto L10;
        String r3 = this.mFilePointer;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        ((h) org.koin.java.a.c(h.class, null, null, 6)).j0(qw4.b.b(qw4.b.a(r14, "2", r3)));
    L11:
        String r6 = r14.a;
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        String r7 = r14.b;
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        if (TextUtils.isEmpty(r7) == true) goto L22;
        int r8 = StringsKt.lastIndexOf$default(r7, ".", 0, false, 6, null);
        if (r8 == (-1)) goto L22;
        String r9 = r7.substring(r8 + 1);
    L23:
        this.mDriveReport.x("finish_upload", r6, r9, this.a);
    L22:
        r9 = "";
        goto L23
    L10:
        addUploadDriveFileCache(this.mFilePointer, this.mIsFileUri, r14.a, r14.e);
        goto L11
    }

    public final void addUploadDriveFileCache(String r12, Boolean r13, String r14, String r16) {
        tt5.a.h("UploadPresenter", "file upload success, start add file to cache...");
        if (TextUtils.isEmpty(r12) == false) goto L5;
    L41:
        tt5.a.k("UploadPresenter", "file info error path=" + r12 + ", token=" + yu5.c.j(r14));
        return;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L41;
        if (r13 == null) goto L41;
        boolean r1 = r13.booleanValue();
        if (r12 != null) goto L11;
        String r3 = "";
    L13:
        if (FileUtils.F(r1, r3) == true) goto L16;
        tt5.a.d("UploadPresenter", "add file to cache error, file not exists");
        return;
    L16:
        o75.a r2 = o75.b.a();
        String r9 = FileUtils.s(FileUtils.x(r13.booleanValue(), r12));
        boolean r4 = false;
        if (r2 == null) goto L23;
        g85.f r5 = r2.getMimeTypeManager();
        if (r5 == null) goto L23;
        if (((g85.b) r5).o(r9, "") != true) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == false) goto L27;
        tt5.a.h("UploadPresenter", "upload file is video, will not be put to cache");
        return;
    L27:
        if (r2 == null) goto L33;
        g85.f r7 = r2.getMimeTypeManager();
        if (r7 == null) goto L33;
        if (((g85.b) r7).k(r9) != true) goto L33;
        r4 = true;
    L33:
        if (r4 == false) goto L36;
        tt5.a.h("UploadPresenter", "upload file is local not support(" + r9 + "), will not be put to cache");
        return;
    L36:
        Application r0 = eu5.b.a;
        DriveFilePath r8 = t.f();
        if (r14 == null) goto L39;
        r8.cacheName(du5.d.a(r14));
    L39:
        Intrinsics.checkNotNull(r8);
        Flowable.just("").observeOn(fo5.d.b()).map(new b(r13, r12, r8, this, z75.b.e(r8, this.b.b))).flatMap(new c(r14, r13, r12, r16, r9, this)).subscribe(d.a, e.a);
        return;
    L23:
        r6 = false;
        goto L24
    L11:
        r3 = r12;
        goto L13
    }

    public boolean onFailed(String r3, int r4, String r5, long r6) {
        tt5.a.h("DRIVE_RustUploadCallback", "onFailed() called with: key = [" + r3 + "], errorCode = [" + r4 + "], mountNodePoint = [" + r5 + "], bytesTotal = [" + r6 + ']');
        if (((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).g(r4) == false) goto L7;
        ((com.bytedance.ee.bear.quoto.t) org.koin.java.a.c(com.bytedance.ee.bear.quoto.t.class, null, null, 6)).f(eu5.b.a, SingleFileQuotaConfig.UPLOAD, Long.valueOf(r6));
        return false;
    L7:
        return false;
    }

    public RustUploadCallback(String r2, Boolean r3, com.bytedance.ee.bear.drive.report.c r4, Bundle r5, a95.a r6) {
        Intrinsics.checkNotNullParameter(r4, "mDriveReport");
        Intrinsics.checkNotNullParameter(r6, "mUserComponentAbility");
        this.mFilePointer = r2;
        this.mIsFileUri = r3;
        this.mDriveReport = r4;
        this.a = r5;
        this.b = r6;
    }
}
