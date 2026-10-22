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

/* JADX INFO: loaded from: classes16.dex */
public interface g {
    List<DriveFile> A(String r100, String r101);

    int B(String[] r100);

    int a();

    void b();

    void c(rf5.a r100);

    int d(String[] r100);

    Flowable<Integer> e();

    String f(DownloadRequestInfo r100);

    String g(DownloadRequestInfo r100);

    Pair<Integer, String> h(String r100, UploadCallback r101);

    void i(String r100, String r101, String r102, PDFStreamingDownloader.C105321 r103);

    void init();

    boolean isDownloadSuccess(String r100);

    void j(dz4.b r100);

    Flowable<Integer> k(boolean r100);

    byte[] l(byte[] r100, String r101, String r102);

    void m(String r100, String r101, rf5.e r102);

    int n(String[] r100);

    void o();

    NetworkLevel p();

    void q(rf5.a r100);

    void r(rf5.e r100);

    String s(UploadRequestInfo r100);

    boolean t();

    List<String> u(List<DownloadRequestInfo> r100);

    int v();

    void w(String r100, String r101);

    void x();

    boolean y();

    int z(String r100);
}
