package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.os.Message;
import android.util.Pair;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.ProgressingEntity;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.lark.pb.space.drive.v1.PushDownloadCallback;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DriveStateMonitorImpl {
    public static volatile DriveStateMonitorImpl d;
    public ConcurrentHashMap<String, Set<a>> a;
    public int b;
    public final UploadCallback c;

    public static class a {
        public int a;
        public int b;
        public String c;
        public final rf5.e d;

        public a(rf5.e r2) {
            this.a = 0;
            this.b = 0;
            this.d = r2;
        }
    }

    static {
        PushDownloadCallback.Status.READY.getValue();
        PushDownloadCallback.Status.QUEUE.getValue();
        PushDownloadCallback.Status.PENDING.getValue();
        PushDownloadCallback.Status.INFLIGHT.getValue();
        PushDownloadCallback.Status.FAILED.getValue();
        PushDownloadCallback.Status.CANCEL.getValue();
        PushDownloadCallback.Status.SUCCESS.getValue();
    }

    public static DriveStateMonitorImpl a() {
        if (d != null) goto L15;
        monitor-enter(DriveStateMonitorImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new DriveStateMonitorImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DriveStateMonitorImpl.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    public final void b() {
        tt5.a.h("Middleground_Drive_DriveStateMonitorImpl", "notifyAllAfterInit...");
        Iterator<String> r0 = this.a.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        Set<a> r2 = this.a.get(r1);
        if (r2 == null) goto L7;
        Iterator<a> r3 = r2.iterator();
    L10:
        if (r3.hasNext() == false) goto L4;
        a r4 = r3.next();
        ArrayList r5 = new ArrayList(1);
        r5.add(r4);
        c(r5, r4.c, r1);
        goto L10
    L7:
        return;
    }

    public DriveStateMonitorImpl() {
        UploadCallback r0 = new AnonymousClass1(this);
        this.c = r0;
        this.a = new ConcurrentHashMap();
        DriveRustPBWrapper r1 = DriveRustPBWrapper.g();
        r1.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper setGlobalUploadStateListener: ");
        c0 r2 = r1.b;
        if (r2 == null) goto L6;
        tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener setGlobalUploadStateListener: ");
        c0.b r3 = r2.c;
        r3.getClass();
        r3.sendMessage(Message.obtain(r3, 5, r0));
        return;
    }

    public final void c(final List<a> r3, final String r4, final String r5) {
        tt5.a.h("Middleground_Drive_DriveStateMonitorImpl", "notifyGlobalFirstTime...");
        Flowable.fromCallable(new b0(this, r5, r4, r3)).subscribeOn(fo5.d.b()).onErrorReturnItem(Boolean.FALSE).subscribe();
    }

    public final void d(String r17, String r18, List<a> r19, tf5.a r20) {
        DriveRustPBWrapper r4 = DriveRustPBWrapper.g();
        r4.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getAllUploadFileList. ");
        List<DriveFile> r5 = r4.e(r17, r18, false);
        if (r5 != null) goto L5;
    L27:
        Pair r9 = new Pair(0, 0);
    L28:
        int r7 = ((Integer) r9.first).intValue();
        int r8 = ((Integer) r9.second).intValue();
        if (r19 != null) goto L31;
        return;
    L31:
        if (r19.size() == 0) goto L106;
        DriveRustPBWrapper r10 = DriveRustPBWrapper.g();
        r10.getClass();
        tt5.a.h("Middleground_Drive_DriveRustPBWrapper", "DriveRustPBWrapper getAllUploadFileProgressList. ");
        List<DriveFile> r1 = r10.e(r17, r18, true);
        Iterator<DriveFile> r11 = r1.iterator();
        int r12 = 0;
        int r13 = 0;
    L35:
        if (r11.hasNext() == false) goto L44;
        DriveFile.Status r14 = r11.next().status;
        if (r14 == DriveFile.Status.FAILED) goto L42;
        if (r14 == DriveFile.Status.CANCEL) goto L42;
        r13 = r13 + 1;
    L42:
        if (r14 != DriveFile.Status.SUCCESS) goto L35;
        r12 = r12 + 1;
        goto L35
    L44:
        tt5.a.k("Middleground_Drive_DriveStateMonitorImpl", "DriveStateMonitorImpl calculateTotalProgress path = " + du5.b.f(r17) + ", file count = " + r1.size() + ", finishCount = " + r12 + ", totalCount = " + r13);
        Pair r2 = new Pair(Integer.valueOf(r12), Integer.valueOf(r13));
        int r15 = ((Integer) r2.first).intValue();
        int r3 = ((Integer) r2.second).intValue();
        if (r3 != 0) goto L47;
        int r16 = 100;
    L48:
        int r110 = (int) (((r20.c * 1.0f) / r20.d) * 100.0f);
        a r111 = (a) ListProtector.get(r19, 0);
        tt5.a.k("Middleground_Drive_DriveStateMonitorImpl", "DriveStateMonitorImpl notifyGlobalProgress path = " + du5.b.f(r17) + ", key = " + r20.a + ", currentCount = " + r8 + " currentQueueCount = " + r7 + " lastUploadFilesCount = " + r111.a + ", lastQueueCount=" + r111.b + ", status = " + r20.b + ", totalProgress = " + r16);
        if (r20.i.contains("/") == false) goto L51;
        String r21 = r20.i;
        String r22 = r21.substring(r21.lastIndexOf("/") + 1);
    L52:
        ProgressingEntity r112 = new ProgressingEntity();
        r112.b = r20.a;
        r112.a = r22;
        r112.c = r20.c;
        r112.d = r20.d;
        r112.e = r110;
        r112.f = r20.b.value();
        r112.g = r20.i;
        r112.h = r17;
        if (r20.b != DriveFile.Status.SUCCESS) goto L55;
        boolean r0 = true;
    L56:
        if (r8 <= 0) goto L59;
        if (r7 != 0) goto L59;
        boolean r23 = true;
    L60:
        Iterator<a> r6 = r19.iterator();
    L62:
        if (r6.hasNext() == false) goto L107;
        a r113 = r6.next();
        if (r113.b != 0) goto L67;
        if (r7 <= 0) goto L67;
    L69:
        r113.d.onExistUploadingFile();
    L70:
        if (r23 == false) goto L72;
        r113.d.onUploadError(r8);
        r16 = 0;
    L72:
        r113.d.onFileProgressChange(r16, r112);
        if (r0 == false) goto L76;
        rf5.d.a r114 = new rf5.d.a();
        r114.a = r20.e;
        r114.b = r20.f;
        r114.d = r20.h;
        r114.c = r20.g;
        r114.e = r20.i;
        r113.d.onUploadFileSuccess(r20.a, new rf5.d(r114));
    L76:
        if (r8 == r113.a) goto L78;
    L81:
        boolean r24 = true;
    L82:
        if (r24 == false) goto L85;
        r113.d.onFileCountChange(r15, r3);
    L85:
        if (r113.a <= 0) goto L88;
        if (r8 != 0) goto L88;
        boolean r25 = true;
    L89:
        if (r25 == false) goto L91;
        r113.d.onUploadFinished();
    L91:
        r113.a = r8;
        r113.b = r7;
    L88:
        r25 = false;
        goto L89
    L78:
        if (r7 != r113.b) goto L81;
        r24 = false;
    L67:
        if (r113.a != 0) goto L70;
        if (r8 <= 0) goto L70;
    L107:
        return;
    L59:
        r23 = false;
        goto L60
    L55:
        r0 = false;
        goto L56
    L51:
        r22 = r20.i;
        goto L52
    L47:
        r16 = (r15 * 100) / r3;
        goto L48
    L106:
        return;
    L5:
        if (r5.size() == 0) goto L27;
        Iterator<DriveFile> r26 = r5.iterator();
        int r27 = 0;
        int r28 = 0;
    L9:
        if (r26.hasNext() == false) goto L23;
        DriveFile.Status r29 = r26.next().status;
        if (r29 != DriveFile.Status.INFLIGHT) goto L13;
    L18:
        r27 = r27 + 1;
    L20:
        if (r29 == DriveFile.Status.SUCCESS) goto L9;
        r28 = r28 + 1;
        goto L9
    L13:
        if (r29 == DriveFile.Status.PENDING) goto L18;
        if (r29 == DriveFile.Status.READY) goto L18;
        if (r29 != DriveFile.Status.QUEUE) goto L20;
    L23:
        if (r17.equals("all_files_token") == false) goto L26;
        this.b = r27;
    L26:
        r9 = new Pair(Integer.valueOf(r27), Integer.valueOf(r28));
        goto L28
    }
}
