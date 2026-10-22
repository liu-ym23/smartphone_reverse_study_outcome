package com.bytedance.ee.bear.drive.sdk.service;

import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.bytedance.ee.bear.document.comment.bean.ShowCardsJsData;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.PDFStreamingDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.NetworkLevel;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.rustsdk.DriveRustPBWrapper;
import com.bytedance.ee.bear.middleground.drive.rustsdk.DriveStateMonitorImpl;
import com.bytedance.ee.bear.middleground.drive.rustsdk.c0;
import com.bytedance.ee.bear.middleground.drive.rustsdk.d0;
import com.bytedance.ee.bear.middleground.drive.rustsdk.e0;
import com.bytedance.ee.bear.middleground.drive.rustsdk.h;
import com.bytedance.ee.bear.middleground.drive.rustsdk.i;
import com.bytedance.ee.bear.middleground.drive.rustsdk.init.l;
import com.bytedance.ee.bear.middleground.drive.rustsdk.j;
import com.bytedance.ee.bear.middleground.drive.rustsdk.m;
import com.bytedance.ee.bear.middleground.drive.rustsdk.q;
import com.bytedance.ee.bear.middleground.drive.rustsdk.r;
import com.bytedance.ee.bear.middleground.drive.rustsdk.s;
import com.bytedance.ee.bear.middleground.drive.rustsdk.u;
import com.bytedance.ee.bear.middleground.drive.rustsdk.v;
import com.bytedance.ee.bear.middleground.drive.rustsdk.w;
import com.bytedance.ee.bear.middleground.drive.rustsdk.x;
import com.bytedance.ee.bear.middleground.drive.rustsdk.y;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.space.drive.v1.CancelAllRequest;
import com.bytedance.lark.pb.space.drive.v1.CancelUploadRequest;
import com.bytedance.lark.pb.space.drive.v1.DeleteUploadResourceRequest;
import com.bytedance.lark.pb.space.drive.v1.DocInfo;
import com.bytedance.lark.pb.space.drive.v1.DownloadNormalRequest;
import com.bytedance.lark.pb.space.drive.v1.DownloadRange;
import com.bytedance.lark.pb.space.drive.v1.DownloadRequest;
import com.bytedance.lark.pb.space.drive.v1.DriveDecryptRequest;
import com.bytedance.lark.pb.space.drive.v1.MultiDownloadRequest;
import com.bytedance.lark.pb.space.drive.v1.ResumeUploadRequest;
import com.bytedance.lark.pb.space.drive.v1.UploadRequest;
import com.bytedance.lark.pb.space.drive.v1.UploadScene;
import com.ss.android.lark.sdk.SdkSender;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements g {
    public d() {
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void x() {
        DriveRustPBWrapper.g().e = true;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final Flowable<Integer> e() {
        return Flowable.fromCallable(new b()).onErrorReturnItem(-1);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final int a() {
        DriveRustPBWrapper.g().getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper cancelAll: ");
        CancelAllRequest.Builder r2 = new CancelAllRequest.Builder();     // Catch: Exception -> L5
        return ((Integer) SdkSender.syncSend(Command.SUITE_DRIVE_CANCEL_ALL, r2, new r())).intValue();
    L5:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper cancelAll: ", e, false);
        return 2019;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void b() {
        l r0 = l.b();
        r0.getClass();
        tt5.a.h("BaseRustServiceImp", "onConfigChanged()...");
        tt5.a.h("BaseRustServiceImp", "drive initDrive");
        r0.d(false);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void init() {
        l.b();
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void o() {
        l r0 = l.b();
        r0.getClass();
        tt5.a.h("BaseRustServiceImp", "drive initDrive");
        r0.d(false);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final NetworkLevel p() {
        com.bytedance.ee.bear.middleground.drive.rustsdk.d r0 = DriveRustPBWrapper.g().c;
        if (r0 == null) goto L5;
        NetworkLevel r1 = r0.a;
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        return NetworkLevel.UNKNOWN;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final boolean t() {
        int r0 = l.b().b;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final int v() {
        return DriveStateMonitorImpl.a().b;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final boolean y() {
        return l.b().c();
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final int B(String[] r3) {
        return DriveRustPBWrapper.g().c(r3, true);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void c(rf5.a r2) {
        d0 r0 = DriveRustPBWrapper.g().d;
        if (r0 == null) goto L7;
        if (r2 == null) goto L8;
        ((CopyOnWriteArrayList) r0.a).remove(r2);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final int d(String[] r8) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveCancelUpload: keys" + Arrays.toString(r8));
        ArrayList r1 = new ArrayList(Arrays.asList(r8));
        if (r0.b == null) goto L11;
        List r9 = hu5.b.a(r1, new j(r0));
        if (hu5.a.d(r9) == true) goto L11;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveCancelUpload, unRegisterUpoadCallback: " + r9);
        Iterator r10 = ((ArrayList) r9).iterator();
    L8:
        if (r10.hasNext() == false) goto L11;
        String r3 = (String) r10.next();
        c0 r4 = r0.b;
        String r5 = e0.c(r3);
        String r6 = e0.b(r3);
        c0.b r7 = r4.c;
        c0.a r11 = new c0.a(r5, r6);
        r7.getClass();
        r7.sendMessage(Message.obtain(r7, 3, r11));
    L11:
        if (hu5.a.d(r1) == false) goto L13;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveCancelUpload, return for empty");
    L24:
        return 2019;
    L13:
        ArrayList r12 = new ArrayList();
        Iterator r2 = r1.iterator();
    L15:
        if (r2.hasNext() == false) goto L19;
        String r13 = e0.c((String) r2.next());
        if (r13 == null) goto L15;
        r12.add(r13);
        goto L15
    L19:
        DriveRustPBWrapper.a();
        CancelUploadRequest.Builder r14 = new CancelUploadRequest.Builder();     // Catch: Exception -> L22
        r14.keys(r12);     // Catch: Exception -> L22
        return ((Integer) SdkSender.syncSend(Command.SUITE_DRIVE_CANCEL_UPLOAD, r14, new x())).intValue();
    L22:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveCancelUpload: ", e, false);
        goto L24
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final String f(DownloadRequestInfo r10) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveDownloadNormal requestInfo: " + r10);
        DriveRustPBWrapper.a();
        if (r0.h() == false) goto L45;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveDownloadNormal return because NOT_LOGIN");
        DownloadCallback r1 = r10.o;
        if (r1 == null) goto L43;
        DownloadCallback.b.a r2 = new DownloadCallback.b.a();
        r2.a = DriveFile.Status.FAILED;
        r2.c = 1;
        r2.b = 0;
        r1.updateProgress(ShowCardsJsData.ID_GLOBAL, new DownloadCallback.b(r2), new DownloadCallback.a(new DownloadCallback.a.a()));
        r10.o.onFailed(ShowCardsJsData.ID_GLOBAL, 1024);
    L43:
        return "";
    L45:
        DownloadNormalRequest.Builder r3 = new DownloadNormalRequest.Builder();     // Catch: Exception -> L41
        r3.local_path(r10.a).remote_url(r10.j).priority(Integer.valueOf(r10.e)).with_slice(Boolean.valueOf(r10.l)).file_size(String.valueOf(r10.k)).data_version(r10.f).extra(r10.r);     // Catch: Exception -> L41
        DownloadRequestInfo.DownloadType r4 = r10.g;     // Catch: Exception -> L41
        if (r4 == null) goto L27;
        int r5 = DriveRustPBWrapper.b.a[r4.ordinal()];     // Catch: Exception -> L41
        if (r5 != 1) goto L12;
        DownloadRequest.ApiType r6 = DownloadRequest.ApiType.COVER;     // Catch: Exception -> L41
    L25:
        r3.api_type = r6;     // Catch: Exception -> L41
        goto L27
    L12:
        if (r5 != 2) goto L14;
        r6 = DownloadRequest.ApiType.PREVIEW;     // Catch: Exception -> L41
        goto L25
    L14:
        if (r5 != 3) goto L16;
        r6 = DownloadRequest.ApiType.IMG;     // Catch: Exception -> L41
        goto L25
    L16:
        if (r5 != 4) goto L18;
        r6 = DownloadRequest.ApiType.DRIVE;     // Catch: Exception -> L41
        goto L25
    L18:
        if (r5 == 5) goto L20;
        r6 = null;
        goto L25
    L20:
        r6 = DownloadRequest.ApiType.RANGE;     // Catch: Exception -> L41
    L27:
        if (TextUtils.isEmpty(r10.b) == true) goto L30;
        r3.file_token = r10.b;     // Catch: Exception -> L41
    L30:
        if (hu5.a.d(r10.s) == true) goto L36;
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L41
        Iterator r8 = r10.s.iterator();     // Catch: Exception -> L41
    L33:
        if (r8.hasNext() == false) goto L35;
        DownloadRequestInfo.c r9 = (DownloadRequestInfo.c) r8.next();     // Catch: Exception -> L41
        r7.add(new DownloadRange.Builder().start(Long.valueOf(r9.a)).end(Long.valueOf(r9.b)).build());     // Catch: Exception -> L41
        goto L33
    L35:
        r3.download_ranges = r7;     // Catch: Exception -> L41
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveDownloadNormal() StreamingLoader download_ranges=" + r10.s);     // Catch: Exception -> L41
    L36:
        String r11 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_DOWNLOAD_NORMAL, r3, new v());     // Catch: Exception -> L41
        String r12 = String.valueOf(r10.o.hashCode());     // Catch: Exception -> L41
        com.bytedance.ee.bear.middleground.drive.rustsdk.b r13 = r0.a;     // Catch: Exception -> L41
        if (r13 == null) goto L39;
        r13.b(r11, r12, r10);     // Catch: Exception -> L41
    L39:
        return e0.a(r11, r12);
    L41:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveDownload: ", e, false);
        goto L43
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final String g(DownloadRequestInfo r6) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveDownload requestInfo: " + r6);
        DriveRustPBWrapper.a();
        if (r0.h() == false) goto L14;
        fo5.d.e().scheduleDirect(new i(r6), 20, TimeUnit.MILLISECONDS);
    L12:
        return "";
    L14:
        String r1 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_DOWNLOAD, DriveRustPBWrapper.b(r6), new u());     // Catch: Exception -> L10
        String r3 = String.valueOf(r6.o.hashCode());     // Catch: Exception -> L10
        com.bytedance.ee.bear.middleground.drive.rustsdk.b r2 = r0.a;     // Catch: Exception -> L10
        if (r2 == null) goto L8;
        r2.b(r1, r3, r6);     // Catch: Exception -> L10
    L8:
        return e0.a(r1, r3);
    L10:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "driveDownload: ", e, false);
        goto L12
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final boolean isDownloadSuccess(String r3) {
        if (r3 != null) goto L4;
    L8:
        return false;
    L4:
        if (TextUtils.equals(r3, ShowCardsJsData.ID_GLOBAL) == true) goto L8;
        if (r3.startsWith(ShowCardsJsData.ID_GLOBAL) == true) goto L8;
        return true;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void j(dz4.b r4) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        if (((CopyOnWriteArrayList) r0.f).contains(r4) == true) goto L6;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "registerDownloadListener");
        ((CopyOnWriteArrayList) r0.f).add(r4);
        return;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final Flowable<Integer> k(final boolean r2) {
        return Flowable.fromCallable(new c(r2)).onErrorReturnItem(-1);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final int n(String[] r3) {
        return DriveRustPBWrapper.g().c(r3, false);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void q(rf5.a r5) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        if (r0.d == null) goto L16;
    L8:
        d0 r1 = r0.d;
        if (r1 == null) goto L18;
        if (r5 != null) goto L12;
        return;
    L12:
        if (((CopyOnWriteArrayList) r1.a).contains(r5) == true) goto L20;
        ((CopyOnWriteArrayList) r1.a).add(r5);
        return;
    L20:
        return;
    L18:
        return;
    L16:
        d0 r2 = new d0();     // Catch: Throwable -> L6
        r0.d = r2;     // Catch: Throwable -> L6
        com.ss.android.lark.sdk.g.e.a.b(Command.PUSH_CPU_MANAGER_MAGICSHARE_SCENE_DOWNGRADE_STRATEGY, r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        tt5.a.f("Middleground_Drive_DriveRustPBWrapper", th, false);
        goto L8
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void r(rf5.e r10) {
        DriveStateMonitorImpl r0 = DriveStateMonitorImpl.a();
        r0.getClass();
        tt5.a.k("Middleground_Drive_DriveStateMonitorImpl", "DriveStateMonitorImpl unRegisterUploadStateMonitor");
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.a.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) r2.next();
        Set r4 = (Set) r0.a.get(r3);
        if (r4 == null) goto L4;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        DriveStateMonitorImpl.a r7 = (DriveStateMonitorImpl.a) r6.next();
        if (r7.d != r10) goto L10;
        r5.add(r7);
        goto L10
    L14:
        r4.removeAll(r5);
        if (r4.size() != 0) goto L4;
        r1.add(r3);
        goto L4
    L17:
        Iterator r11 = r1.iterator();
    L19:
        if (r11.hasNext() == false) goto L21;
        String r8 = (String) r11.next();
        r0.a.remove(r8);
        goto L19
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final String s(UploadRequestInfo r7) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveUpload: uploadRequestInfo = " + r7);
        DriveRustPBWrapper.a();
        if (r0.h() == false) goto L32;
        fo5.d.e().scheduleDirect(new com.bytedance.ee.bear.middleground.drive.rustsdk.g(r7), 20, TimeUnit.MILLISECONDS);
    L30:
        return "";
    L32:
        UploadRequest.Builder r1 = new UploadRequest.Builder();     // Catch: Exception -> L28
        UploadRequest.Builder r3 = r1.local_path(r7.a).uri_str(r7.b).file_name(r7.c).priority(Integer.valueOf(r7.g)).mount_node_point(r7.d).mount_point(r7.e).upload_code(r7.f);     // Catch: Exception -> L28
        if (r7.h != UploadRequestInfo.UploadType.IMG) goto L8;
        UploadRequest.ApiType r4 = UploadRequest.ApiType.IMG;     // Catch: Exception -> L28
    L9:
        r3.api_type(r4);     // Catch: Exception -> L28
        if (TextUtils.equals(r7.e, FileInfoPuller.CALLER_WIKI) == false) goto L12;
        UploadScene r5 = UploadScene.WIKI;     // Catch: Exception -> L28
    L13:
        r1.scene(r5);     // Catch: Exception -> L28
        if (hu5.a.e(r7.i) == true) goto L17;
        r1.extra_params(r7.i);     // Catch: Exception -> L28
    L17:
        if (hu5.a.e(r7.k) == true) goto L20;
        r1.extra_headers(r7.k);     // Catch: Exception -> L28
    L20:
        if (hu5.a.e(r7.j) == true) goto L22;
        r1.ext_rust(r7.j);     // Catch: Exception -> L28
    L22:
        UploadCallback r8 = r7.l;     // Catch: Exception -> L28
        DriveRustPBWrapper.a();     // Catch: Exception -> L28
        String r2 = (String) SdkSender.syncSend(Command.SUITE_DRIVE_UPLOAD, r1, new w());     // Catch: Exception -> L28
        c0 r6 = r0.b;     // Catch: Exception -> L28
        if (r6 == null) goto L25;
        tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener registerUploadCallback: ");     // Catch: Exception -> L28
        c0.b r9 = r6.c;     // Catch: Exception -> L28
        c0.a r10 = new c0.a(r2, r8);     // Catch: Exception -> L28
        r9.getClass();     // Catch: Exception -> L28
        r9.sendMessage(Message.obtain(r9, 2, r10));     // Catch: Exception -> L28
    L25:
        if (r8 == null) goto L34;
        return e0.a(r2, String.valueOf(r8.hashCode()));
    L34:
        return r2;
    L12:
        r5 = UploadScene.UNKNOWN;     // Catch: Exception -> L28
        goto L13
    L8:
        r4 = UploadRequest.ApiType.DRIVE;     // Catch: Exception -> L28
    L28:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveUpload: ", e, false);
        goto L30
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final List<String> u(List<DownloadRequestInfo> r11) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        int r1 = ((ArrayList) r11).size();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveMultiDownload requestInfos size  = " + r1);
        DriveRustPBWrapper.a();
        ArrayList r2 = new ArrayList();
        if (r1 != 0) goto L6;
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "driveMultiDownload return because request info size = 0");
    L27:
        return r2;
    L6:
        if (r0.h() == false) goto L28;
        fo5.d.e().scheduleDirect(new q(r11), 20, TimeUnit.MILLISECONDS);
        goto L27
    L28:
        MultiDownloadRequest.Builder r3 = new MultiDownloadRequest.Builder();     // Catch: Exception -> L25
        ArrayList r4 = new ArrayList();     // Catch: Exception -> L25
        ArrayList r12 = (ArrayList) r11;     // Catch: Exception -> L25
        Iterator r5 = r12.iterator();     // Catch: Exception -> L25
    L10:
        if (r5.hasNext() == false) goto L12;
        DownloadRequestInfo r6 = (DownloadRequestInfo) r5.next();     // Catch: Exception -> L25
        DownloadRequest.Builder r7 = DriveRustPBWrapper.b(r6);     // Catch: Exception -> L25
        r7.doc_info(new DocInfo.Builder().doc_token(r6.m).doc_type(Integer.valueOf(r6.n)).build());     // Catch: Exception -> L25
        r4.add(r7.build());     // Catch: Exception -> L25
        goto L10
    L12:
        r3.download_requests(r4);     // Catch: Exception -> L25
        Map r8 = (Map) SdkSender.syncSend(Command.SUITE_DRIVE_MULTI_DOWNLOAD, r3, new h());     // Catch: Exception -> L25
        Iterator r13 = r12.iterator();     // Catch: Exception -> L25
    L13:
        if (r13.hasNext() == false) goto L27;
        DownloadRequestInfo r9 = (DownloadRequestInfo) r13.next();     // Catch: Exception -> L25
        DownloadCallback r10 = r9.o;     // Catch: Exception -> L25
        String r14 = (String) r8.get(r9.b);     // Catch: Exception -> L25
        if (r10 == null) goto L13;
        if (TextUtils.isEmpty(r14) == true) goto L13;
        String r16 = String.valueOf(r9.o.hashCode());     // Catch: Exception -> L25
        com.bytedance.ee.bear.middleground.drive.rustsdk.b r17 = r0.a;     // Catch: Exception -> L25
        if (r17 == null) goto L23;
        r17.b(r14, r16, r9);     // Catch: Exception -> L25
    L23:
        r2.add(e0.a(r14, r16));     // Catch: Exception -> L25
    L25:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "driveMultiDownload: ", e, false);
        goto L27
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final int z(String r4) {
        DriveRustPBWrapper.g().getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper deleteUploadResource: key=" + r4);
        DriveRustPBWrapper.a();
        DeleteUploadResourceRequest.Builder r0 = new DeleteUploadResourceRequest.Builder();     // Catch: Exception -> L5
        r0.key(r4);     // Catch: Exception -> L5
        return ((Integer) SdkSender.syncSend(Command.SUITE_DRIVE_DELETE_UPLOAD, r0, new s())).intValue();
    L5:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper deleteUploadResource: ", e, false);
        return 2019;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final List<DriveFile> A(String r4, String r5) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getAllUploadFileList. ");
        return r0.e(r4, r5, false);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final Pair<Integer, String> h(String r7, UploadCallback r8) {
        DriveRustPBWrapper r0 = DriveRustPBWrapper.g();
        r0.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper resumeUpload: key=" + r7);
        DriveRustPBWrapper.a();
        String r9 = e0.c(r7);
        int r1 = 2019;
        ResumeUploadRequest.Builder r3 = new ResumeUploadRequest.Builder();     // Catch: Exception -> L7
        r3.key(r9);     // Catch: Exception -> L7
        r1 = ((Integer) SdkSender.syncSend(Command.SUITE_DRIVE_RESUME_UPLOAD, r3, new y())).intValue();     // Catch: Exception -> L7
        c0 r2 = r0.b;     // Catch: Exception -> L7
        if (r2 == null) goto L10;
        tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener registerUploadCallback: ");     // Catch: Exception -> L7
        c0.b r4 = r2.c;     // Catch: Exception -> L7
        c0.a r5 = new c0.a(r9, r8);     // Catch: Exception -> L7
        r4.getClass();     // Catch: Exception -> L7
        r4.sendMessage(Message.obtain(r4, 2, r5));     // Catch: Exception -> L7
    L10:
        return new Pair(Integer.valueOf(r1), e0.a(r9, String.valueOf(r8.hashCode())));
    L7:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper resumeUpload: ", e, false);
        goto L10
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void w(String r2, String r3) {
        DriveRustPBWrapper.g().d(r2, r3);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final byte[] l(byte[] r4, String r5, String r6) {
        DriveRustPBWrapper.g().getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveDecrypt start");
        DriveRustPBWrapper.a();
        DriveDecryptRequest.Builder r0 = new DriveDecryptRequest.Builder();     // Catch: Exception -> L5
        r0.decrypt_type(DriveDecryptRequest.DecryptType.Sm4Gcm);     // Catch: Exception -> L5
        r0.body(ByteString.of(r4));     // Catch: Exception -> L5
        r0.key(r5);     // Catch: Exception -> L5
        r0.nonce(r6);     // Catch: Exception -> L5
        return (byte[]) SdkSender.syncSend(Command.SUITE_DRIVE_DECRYPT_REQUEST, r0, new m());
    L5:
        e = move-exception;
        tt5.a.e("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper driveDecrypt error: ", e, false);
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void m(String r4, String r5, rf5.e r6) {
        DriveStateMonitorImpl r0 = DriveStateMonitorImpl.a();
        r0.getClass();
        tt5.a.k("Middleground_Drive_DriveStateMonitorImpl", "DriveStateMonitorImpl registerUploadStateMonitor path = " + du5.b.f(r4) + ", mountPoint: " + r5);
        Set r1 = (Set) r0.a.get(r4);
        if (r1 != null) goto L5;
        r1 = Collections.newSetFromMap(new ConcurrentHashMap());
    L5:
        DriveStateMonitorImpl.a r2 = new DriveStateMonitorImpl.a(r6);
        r2.c = r5;
        r1.add(r2);
        r0.a.put(r4, r1);
        ArrayList r7 = new ArrayList();
        r7.add(r2);
        r0.c(r7, r5, r4);
    }

    @Override // com.bytedance.ee.bear.drive.sdk.service.g
    public final void i(String r2, String r3, String r4, PDFStreamingDownloader.C03521 r5) {
        DriveRustPBWrapper.g().f(r2, r3, r4, r5);
    }
}
