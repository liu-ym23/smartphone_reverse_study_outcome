package com.bytedance.ee.bear.drive.sdk.service;

import androidx.core.util.Pair;
import com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.PDFStreamingDownloader;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.NetworkLevel;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import io.reactivex.Flowable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface g {
    List<DriveFile> A(String r1, String r2);

    int B(String[] r1);

    int a();

    void b();

    void c(rf5.a r1);

    int d(String[] r1);

    Flowable<Integer> e();

    String f(DownloadRequestInfo r1);

    String g(DownloadRequestInfo r1);

    Pair<Integer, String> h(String r1, UploadCallback r2);

    void i(String r1, String r2, String r3, PDFStreamingDownloader.C03521 r4);

    void init();

    boolean isDownloadSuccess(String r1);

    void j(dz4.b r1);

    Flowable<Integer> k(boolean r1);

    byte[] l(byte[] r1, String r2, String r3);

    void m(String r1, String r2, rf5.e r3);

    int n(String[] r1);

    void o();

    NetworkLevel p();

    void q(rf5.a r1);

    void r(rf5.e r1);

    String s(UploadRequestInfo r1);

    boolean t();

    List<String> u(List<DownloadRequestInfo> r1);

    int v();

    void w(String r1, String r2);

    void x();

    boolean y();

    int z(String r1);
}
