package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.PDFStreamingDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFgConfig;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.GetDownloadedRangesCallback;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.drive.v1.CancelDownloadRequest;
import com.bytedance.lark.pb.space.drive.v1.CancelDownloadResponse;
import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.bytedance.lark.pb.space.drive.v1.DeleteDownloadRecordRequest;
import com.bytedance.lark.pb.space.drive.v1.DeleteDownloadRecordResponse;
import com.bytedance.lark.pb.space.drive.v1.DocInfo;
import com.bytedance.lark.pb.space.drive.v1.DownloadRange;
import com.bytedance.lark.pb.space.drive.v1.DownloadRequest;
import com.bytedance.lark.pb.space.drive.v1.GetDownloadedRangesRequest;
import com.bytedance.lark.pb.space.drive.v1.PushDownloadCallback;
import com.bytedance.lark.pb.space.drive.v1.UploadListRequest;
import com.bytedance.lark.pb.space.drive.v1.UploadListResponse;
import com.bytedance.lark.pb.space.drive.v1.UploadScene;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DriveRustPBWrapper {
    public static volatile DriveRustPBWrapper g;
    public com.bytedance.ee.bear.middleground.drive.rustsdk.b a;
    public c0 b;
    public d c;
    public d0 d;
    public volatile boolean e;
    public final List<rf5.b> f;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.rustsdk.DriveRustPBWrapper$13, reason: invalid class name */
    class AnonymousClass13 implements IGetDataCallback<PushDownloadCallback> {
        final /* synthetic */ DriveRustPBWrapper this$0;
        final /* synthetic */ GetDownloadedRangesCallback val$callback;

        public static /* synthetic */ DownloadRequestInfo.c a(DownloadRange r0) {
            return lambda$onSuccess$0(r0);
        }

        private static /* synthetic */ DownloadRequestInfo.c lambda$onSuccess$0(DownloadRange r5) {
            return new DownloadRequestInfo.c(r5.start.longValue(), r5.end.longValue());
        }

        public void onError(ErrorResult r2) {
            GetDownloadedRangesCallback r0 = this.val$callback;
            if (r0 == null) goto L6;
            r0.onError(r2.getErrorCode());
            return;
        }

        public void onSuccess(PushDownloadCallback r2) {
            if (this.val$callback == null) goto L8;
            List r3 = r2.downloaded_ranges;
            if (r3 == null) goto L9;
            List<DownloadRequestInfo.c> r4 = CollectionsKt.map(r3, new t());
            this.val$callback.onSuccess(r4);
            return;
        L9:
            return;
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((PushDownloadCallback) r1);
        }

        public AnonymousClass13(DriveRustPBWrapper r1, GetDownloadedRangesCallback r2) {
            this.this$0 = r1;
            this.val$callback = r2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.rustsdk.DriveRustPBWrapper$14, reason: invalid class name */
    class AnonymousClass14 implements IGetDataCallback<DeleteDownloadRecordResponse> {
        final /* synthetic */ DriveRustPBWrapper this$0;

        public AnonymousClass14(DriveRustPBWrapper r1) {
            this.this$0 = r1;
        }

        public void onError(ErrorResult r3) {
            tt5.a.d("Middleground_Drive_DriveRustPBWrapper", "deleteDownloadRecordRequest onError: " + r3.getErrorCode());
        }

        public void onSuccess(DeleteDownloadRecordResponse r3) {
            tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "deleteDownloadRecordRequest ret: " + r3.result);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((DeleteDownloadRecordResponse) r1);
        }
    }

    public class a implements SdkSender.IParser<List<DriveFile>> {
        public final /* synthetic */ DriveRustPBWrapper a;

        public a(DriveRustPBWrapper r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r6) throws IOException {
            List r7 = ((UploadListResponse) UploadListResponse.ADAPTER.decode(r6)).list;
            if (r7 == null) goto L13;
            this.a.getClass();
            ArrayList r0 = new ArrayList();
            Iterator r8 = r7.iterator();
        L6:
            if (r8.hasNext() == false) goto L19;
            com.bytedance.lark.pb.space.drive.v1.DriveFile r1 = (com.bytedance.lark.pb.space.drive.v1.DriveFile) r8.next();
            DriveFile r2 = new DriveFile();
            r2.setBytesTotal(CastLongProtector.parseLong(r1.bytes_total));
            r2.setBytesTransferred(CastLongProtector.parseLong(r1.bytes_transferred));
            r2.setFileName(r1.file_name);
            r2.setKey(r1.key);
            r2.setMountNodePoint(r1.mount_node_point);
            r2.setPath(r1.path);
            if (TextUtils.isEmpty(r1.path) == false) goto L12;
            if (TextUtils.isEmpty(r1.file_name) == true) goto L12;
            r2.setPath(r1.file_name);
        L12:
            r2.setStatus(DriveFile.Status.from(r1.status.intValue()));
            r2.setErrorCode(r1.error_code);
            r0.add(r2);
            goto L6
        L19:
            return r0;
        L13:
            tt5.a.d("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getAllUploadFileList parse: list is null");
            return null;
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DownloadRequestInfo.DownloadType.values().length];
            a = r0;
            r0[DownloadRequestInfo.DownloadType.COVER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            a[DownloadRequestInfo.DownloadType.PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            a[DownloadRequestInfo.DownloadType.IMG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            a[DownloadRequestInfo.DownloadType.DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            a[DownloadRequestInfo.DownloadType.RANGE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public class c implements SdkSender.IParser<Integer> {
        public c() {
        }

        public final Object parse(byte[] r2) throws IOException {
            return ((CancelDownloadResponse) CancelDownloadResponse.ADAPTER.decode(r2)).result;
        }
    }

    public static DriveRustPBWrapper g() {
        if (g != null) goto L15;
        monitor-enter(DriveRustPBWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new DriveRustPBWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DriveRustPBWrapper.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public final boolean h() {
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "isAccountStateError() isLogoutingOrSwitching=" + this.e);
        return this.e;
    }

    public DriveRustPBWrapper() {
        this.e = false;
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.f = r0;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper init: ");
        e r1 = new e();
        com.ss.android.lark.sdk.g r3 = com.ss.android.lark.sdk.g.e.a;
        r3.b(Command.SUITE_DRIVE_PUSH_MONITOR_EVENT, r1);
        r3.b(Command.SUITE_DRIVE_PUSH_DOWNLOAD_PROCESS, new p(this));
        this.a = new com.bytedance.ee.bear.middleground.drive.rustsdk.b();
        rf5.b r2 = new o(this);
        if (r0.contains(r2) == true) goto L5;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "registerDownloadListener");
        r0.add(r2);
    L5:
        c0 r4 = new c0();
        this.b = r4;
        r3.b(Command.SUITE_DRIVE_PUSH_UPLOAD_PROGRESS, r4);
        boolean r5 = eu5.g.j();
        if (eu5.g.i() == false) goto L11;
        d r6 = new d();
        this.c = r6;
        if (r5 == true) goto L10;
        r3.b(Command.PUSH_DYNAMIC_NET_STATUS, r6);
        goto L11
    L10:
        ((com.bytedance.ee.bear.lark.dependency.w) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.w.class)).a(this.c);
    L11:
        if (r5 == true) goto L14;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper init addPushObserver");
        ((CopyOnWriteArrayList) com.bytedance.lark.sdk.d.f).add(r3);
        return;
    }

    public static void a() {
        if (eu5.g.i() == false) goto L5;
        com.bytedance.ee.bear.middleground.drive.rustsdk.init.l.b().a();
        return;
    L5:
        tt5.a.d("Middleground_Drive_DriveRustPBWrapper", "checkRustInited MGDriveModule is null");
    }

    public static DownloadRequest.Builder b(DownloadRequestInfo r5) {
        DownloadRequest.Builder r0 = new DownloadRequest.Builder();
        r0.local_path(r5.a).file_token(r5.b).mount_node_point(r5.c).mount_point(r5.d).priority(Integer.valueOf(r5.e)).doc_info(new DocInfo.Builder().doc_token(r5.m).doc_type(Integer.valueOf(r5.n)).build()).disable_cdn_download(Boolean.valueOf(r5.q)).data_version(r5.f).extra(r5.r).biz_scene(r5.h).watermark_scene(r5.i);
        int r1 = b.a[r5.g.ordinal()];
        if (r1 != 1) goto L5;
        r0.api_type(DownloadRequest.ApiType.COVER);
        if (r5.p == null) goto L20;
        r0.cover_info(new CoverDownloadInfo.Builder().width(Integer.valueOf(r5.p.a)).height(Integer.valueOf(r5.p.b)).policy(r5.p.c).build());
        r0.disable_cover_retry(Boolean.valueOf(!r5.p.d));
    L19:
        return r0;
    L20:
        DriveFgConfig r3 = new DriveFgConfig(true, ((Integer) com.bytedance.ee.bear.appsetting.c.a.a.d("drive_rust_cover_size", 1280)).intValue());     // Catch: Exception -> L17
    L18:
        r0.cover_info(new CoverDownloadInfo.Builder().width(Integer.valueOf(r3.mCoverWidth)).height(Integer.valueOf(r3.mCoverWidth)).policy("near").build());
    L17:
        r3 = new DriveFgConfig(true, 1280);
        goto L18
    L5:
        if (r1 != 2) goto L7;
        r0.api_type(DownloadRequest.ApiType.PREVIEW);
        goto L19
    L7:
        if (r1 != 3) goto L19;
        r0.api_type(DownloadRequest.ApiType.IMG);
        goto L19
    }

    public final int c(String[] r6, boolean r7) {
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveCancelDownload: key=" + Arrays.toString(r6) + " ignoreHasOtherRegister=" + r7);
        ArrayList r0 = new ArrayList(Arrays.asList(r6));
        if (r7 == true) goto L13;
        List r8 = hu5.b.a(r0, new k(this));
        if (hu5.a.d(r8) == true) goto L11;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveCancelDownload, unRegisterDownloadCallback: " + r8);
        Iterator r9 = ((ArrayList) r8).iterator();
    L8:
        if (r9.hasNext() == false) goto L11;
        String r2 = (String) r9.next();
        this.a.c(e0.c(r2), e0.b(r2));
    L11:
        if (hu5.a.d(r0) == false) goto L13;
        return 0;
    L13:
        ArrayList r10 = new ArrayList();
        Iterator r1 = r0.iterator();
    L15:
        if (r1.hasNext() == false) goto L19;
        String r3 = e0.c((String) r1.next());
        if (r3 == null) goto L15;
        r10.add(r3);
        goto L15
    L19:
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveCancelDownload, keyNonOtherRegister: " + r10);
        a();
        CancelDownloadRequest.Builder r4 = new CancelDownloadRequest.Builder();     // Catch: Exception -> L22
        r4.keys(r10);     // Catch: Exception -> L22
        return ((Integer) SdkSender.syncSend(Command.SUITE_DRIVE_CANCEL_DOWNLOAD, r4, new c())).intValue();
    L22:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveCancelDownload: ", e, false);
        return 0;
    }

    public final void d(String r5, String r6) {
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveDeleteRangeRecord. fileToken=" + du5.b.i(r5) + " dataVersion=" + r6);
        a();
        DeleteDownloadRecordRequest.Builder r7 = new DeleteDownloadRecordRequest.Builder().api_type(DownloadRequest.ApiType.RANGE).data_version(r6).file_token(r5);
        Command r8 = Command.SUITE_DRIVE_DELETE_DOWNLOADED_RECORD;     // Catch: Exception -> L5
        IGetDataCallback<DeleteDownloadRecordResponse> r0 = new AnonymousClass15(this);     // Catch: Exception -> L5
        final ProtoAdapter r2 = DeleteDownloadRecordResponse.ADAPTER;     // Catch: Exception -> L5
        Objects.requireNonNull(r2);     // Catch: Exception -> L5
        SdkSender.asynSendRequestNonWrap(r8, r7, r0, new l(r2));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("Middleground_Drive_DriveRustPBWrapper", e, false);
    }

    public final List<DriveFile> e(String r6, String r7, boolean r8) {
        a();
        List<DriveFile> r2 = new ArrayList();
        UploadListRequest.Builder r3 = new UploadListRequest.Builder();     // Catch: Exception -> L14
        r3.mount_node_token(r6);     // Catch: Exception -> L14
        r3.for_progress(Boolean.valueOf(r8));     // Catch: Exception -> L14
        UploadScene r9 = UploadScene.UNKNOWN;     // Catch: Exception -> L14
        if (TextUtils.equals(r7, DocumentType.WIKI_NAME) == false) goto L7;
        r9 = UploadScene.WIKI;     // Catch: Exception -> L14
    L9:
        r3.scene(r9);     // Catch: Exception -> L14
        List<DriveFile> r10 = (List) SdkSender.syncSend(Command.SUITE_DRIVE_UPLOAD_LIST, r3, new a(this));     // Catch: Exception -> L14
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getAllUploadFileList, mountNodeToken: " + du5.b.g(r6) + ", mountPoint: " + r7 + ", result: " + r10.size());     // Catch: Exception -> L12
        return r10;
    L12:
        e = e;
        r2 = r10;
    L15:
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getAllUploadFileList: ", e, false);
        return r2;
    L7:
        if (TextUtils.equals(r7, "workspace") == false) goto L9;
        r9 = UploadScene.WORKSPACE;     // Catch: Exception -> L14
    L14:
        e = e;
        goto L15
    }

    public final void f(String r3, String r4, String r5, PDFStreamingDownloader.getDownloadedRanges.1 r6) {
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getDownloadedRanges. ");
        a();
        GetDownloadedRangesRequest.Builder r1 = new GetDownloadedRangesRequest.Builder();
        r1.file_token = r3;
        r1.data_version = r4;
        r1.local_path = r5;
        Command r7 = Command.SUITE_DRIVE_GET_DOWNLOADED_RANGES;     // Catch: Exception -> L5
        AnonymousClass13 r8 = new AnonymousClass13(this, r6);     // Catch: Exception -> L5
        final ProtoAdapter r9 = PushDownloadCallback.ADAPTER;     // Catch: Exception -> L5
        Objects.requireNonNull(r9);     // Catch: Exception -> L5
        SdkSender.asynSendRequestNonWrap(r7, r1, r8, new n(r9));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "driveDownload: ", e, false);
    }
}
