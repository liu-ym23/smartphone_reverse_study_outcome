package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.drive.sdk.service.f;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.plugin.common.ttpdfreader.IStreamingDownloader;
import com.bytedance.ee.plugin.common.ttpdfreader.Range;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import z75.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PDFStreamingDownloader implements IStreamingDownloader {
    public final String a;
    public final String b;
    public final DriveFilePath c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;
    public final MutableLiveData<Object> h;
    public final a95.a i;
    public final AtomicBoolean j;
    public final AtomicBoolean k;

    public static final class a {
    }

    static {
    }

    public final long requiredHeadTailSize() {
        return 200000;
    }

    public final void deleteRecord() {
        tt5.a.h("PDFStreamingDownloader", "deleteRecord()");
        ((f) org.koin.java.a.c(f.class, null, null, 6)).d0().w(this.a, this.f);
    }

    public final String filePath() {
        return b.a(this.c, this.i.b);
    }

    public final long fileSize() {
        return this.d;
    }

    public final void cancelTask(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        tt5.a.h("PDFStreamingDownloader", "cancelTask() ret1=" + ((f) org.koin.java.a.c(f.class, null, null, 6)).d0().B(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.streaming.PDFStreamingDownloader$getDownloadedRanges$1] */
    public final void getDownloadedRanges(final IStreamingDownloader.DownloadCallback r6) {
        ((f) org.koin.java.a.c(f.class, null, null, 6)).d0().i(this.a, this.f, b.a(this.c, this.i.b), new C03521(r6));
    }

    public final void onPageReady(int r6) {
        if (this.k.compareAndSet(false, true) == false) goto L8;
        tt5.a.h("PDFStreamingDownloader", "onPageReady() start save streaming page cache");
        MutableLiveData<Object> r7 = this.h;
        if (r7 == null) goto L9;
        r7.postValue(new StreamingCache(this.b, this.c, this.d));
        return;
    L9:
        return;
    }

    public final String download(final IStreamingDownloader.DownloadCallback r29, final List<? extends Range> r30) {
        if (r30 != null) goto L5;
        return "";
    L5:
        j r4 = j.a.a;
        if (r4 == null) goto L10;
        boolean r5 = true;
        if (r4.getNetworkState().a() != true) goto L10;
    L11:
        if (r5 == true) goto L15;
        if (r29 == null) goto L14;
        r29.onResult("key_offline", DriveFile.Status.FAILED.value(), CollectionsKt.emptyList());
    L14:
        return "";
    L15:
        DrivePriority.DownloadPriority.DEFAULT.getPriority();
        DownloadRequestInfo.DownloadType r6 = DownloadRequestInfo.DownloadType.DRIVE;
        DriveBizScene r26 = DriveBizScene.DriveBizScene_UNKNOWN;
        DownloadRequestInfo.DownloadType r13 = DownloadRequestInfo.DownloadType.RANGE;
        String r8 = this.a;
        String r7 = b.a(this.c, this.i.b);
        String r14 = this.b;
        int r11 = DrivePriority.DownloadPriority.PREVIEW.getPriority();
        String r12 = this.f;
        long r9 = this.d;
        String r16 = this.e;
        String r10 = this.g;
        List<? extends Range> r17 = r30;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r3 = r17.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        Range r19 = (Range) r3.next();
        Iterator r110 = r3;
        long r20 = r9;
        r18.add(new DownloadRequestInfo.c(r19.begin, r19.end));
        r3 = r110;
        r9 = r20;
        goto L17
    L19:
        DownloadRequestInfo r0 = new DownloadRequestInfo(r7, r8, "", r10, r11, r12, r13, r14, r9, true, "", 2, null, null, false, r16, r18, r26, null);
        r0.o = new AnonymousClass1(r29, this, r30);
        String r1 = ((f) org.koin.java.a.c(f.class, null, null, 6)).d0().f(r0);
        if (r1 == null) goto L22;
        return r1;
    L22:
        return "";
    L10:
        r5 = false;
        goto L11
    }

    public PDFStreamingDownloader(String r2, String r3, DriveFilePath r4, long r5, String r7, String r8, String r9, MutableLiveData<Object> r10, a95.a r11) {
        Intrinsics.checkNotNullParameter(r2, "fileToken");
        Intrinsics.checkNotNullParameter(r3, "streamingUrl");
        Intrinsics.checkNotNullParameter(r4, "filePath");
        Intrinsics.checkNotNullParameter(r11, "userComponentAbility");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = new AtomicBoolean();
        this.k = new AtomicBoolean();
    }
}
