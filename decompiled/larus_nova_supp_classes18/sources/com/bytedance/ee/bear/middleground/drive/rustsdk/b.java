package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.drive.export.DownloadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.lark.pb.space.drive.v1.DownloadFailedInfo;
import com.bytedance.lark.pb.space.drive.v1.PushDownloadCallback;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements com.ss.android.lark.sdk.g.b {
    public final Map<String, Set<a>> a;
    public final HandlerC0078b b;

    public class a {
        public final String a;
        public final String b;
        public final String c;
        public final DownloadCallback d;

        public a(String r1, String r2, String r3, DownloadCallback r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.drive.rustsdk.b$b, reason: collision with other inner class name */
    public final class HandlerC0078b extends Handler {
        public final /* synthetic */ b a;

        @Override // android.os.Handler
        public final void handleMessage(Message r12) {
            int r1 = r12.what;
            if (r1 != 1) goto L5;
            byte[] r13 = (byte[]) r12.obj;
            this.a.getClass();
            PushDownloadCallback r14 = (PushDownloadCallback) PushDownloadCallback.ADAPTER.decode(r13);     // Catch: Exception -> L38
        L40:
            b r2 = this.a;
            r2.getClass();
            if (r14 != null) goto L43;
            tt5.a.d("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: data is null ");
            return;
        L43:
            String r5 = r14.key;
            if (TextUtils.isEmpty(r5) == false) goto L46;
            tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: respone key is null");
            return;
        L46:
            Set r6 = (Set) ((ConcurrentHashMap) r2.a).get(r5);
            if (CollectionUtils.isEmpty(r6) == false) goto L90;
            tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: no callback");
            return;
        L90:
            PushDownloadCallback.Status r7 = r14.status;     // Catch: Exception -> L63
            if (r7 == PushDownloadCallback.Status.FAILED) goto L57;
            if (r7 == PushDownloadCallback.Status.CANCEL) goto L57;
            tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: has callback,call updateProgress key=" + r5);     // Catch: Exception -> L63
            Iterator r3 = r6.iterator();     // Catch: Exception -> L63
        L54:
            if (r3.hasNext() == false) goto L65;
            a r4 = (a) r3.next();     // Catch: Exception -> L63
            DownloadCallback r8 = r4.d;     // Catch: Exception -> L63
            String r9 = e0.a(r14.key, r4.b);     // Catch: Exception -> L63
            DownloadCallback.b.a r10 = new DownloadCallback.b.a();     // Catch: Exception -> L63
            r10.a = DriveFile.Status.from(r14.status.getValue());     // Catch: Exception -> L63
            r10.b = CastLongProtector.parseLong(r14.bytes_transferred);     // Catch: Exception -> L63
            r10.c = CastLongProtector.parseLong(r14.bytes_total);     // Catch: Exception -> L63
            DownloadCallback.b r11 = new DownloadCallback.b(r10);     // Catch: Exception -> L63
            DownloadCallback.a.C0076a r15 = new DownloadCallback.a.C0076a();     // Catch: Exception -> L63
            r15.a = CollectionsKt.map(r14.downloaded_ranges, new com.bytedance.ee.bear.middleground.drive.rustsdk.a());     // Catch: Exception -> L63
            r15.d = r14.file_path;     // Catch: Exception -> L63
            r15.c = r14.file_type;     // Catch: Exception -> L63
            r15.b = r14.file_name;     // Catch: Exception -> L63
            r15.e = r14.data_version;     // Catch: Exception -> L63
            r8.updateProgress(r9, r11, new DownloadCallback.a(r15));     // Catch: Exception -> L63
        L65:
            PushDownloadCallback.Status r16 = r14.status;
            if (r16 != PushDownloadCallback.Status.SUCCESS) goto L68;
        L71:
            Iterator r17 = r6.iterator();
            String r18 = "";
        L73:
            if (r17.hasNext() == false) goto L76;
            r18 = ((a) r17.next()).c;
            if (TextUtils.isEmpty(r18) == true) goto L73;
        L76:
            tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: download finish key=" + r14.key + ", mountPoint=" + r18);
            ((com.bytedance.ee.bear.f) org.koin.java.a.a(com.bytedance.ee.bear.f.class)).e(r14.file_token, r18);
        L77:
            PushDownloadCallback.Status r19 = r14.status;
            if (r19 != PushDownloadCallback.Status.SUCCESS) goto L80;
        L85:
            tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: delete callback key=" + r14.key + ", mountPoint=" + r14.mount_point);
            r2.c(r14.key, "");
            return;
        L80:
            if (r19 == PushDownloadCallback.Status.FAILED) goto L84;
            if (r19 == PushDownloadCallback.Status.CANCEL) goto L84;
            return;
        L84:
            if (r14.failed_info != null) goto L85;
            return;
        L68:
            if (r16 == PushDownloadCallback.Status.FAILED) goto L71;
            if (r14.failed_info == null) goto L77;
        L57:
            if (r14.failed_info == null) goto L65;
            tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: has callback,call onFailed key=" + r5);     // Catch: Exception -> L63
            Iterator r20 = r6.iterator();     // Catch: Exception -> L63
        L60:
            if (r20.hasNext() == false) goto L65;
            DownloadCallback r21 = ((a) r20.next()).d;     // Catch: Exception -> L63
            DownloadFailedInfo r22 = r14.failed_info;     // Catch: Exception -> L63
            r21.onFailed(r22.key, r22.error_code.intValue());     // Catch: Exception -> L63
        L63:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener dispatch: ", e, false);
        L38:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener parse: ", e, false);
            r14 = null;
            goto L40
        L5:
            if (r1 != 2) goto L7;
            a r110 = (a) r12.obj;
            if (r110 == null) goto L106;
            String r0 = r110.a;
            if (r0 != null) goto L32;
            return;
        L32:
            if (((ConcurrentHashMap) this.a.a).get(r0) != null) goto L34;
            ((ConcurrentHashMap) this.a.a).put(r110.a, Collections.synchronizedSet(new HashSet()));
        L34:
            ((Set) ((ConcurrentHashMap) this.a.a).get(r110.a)).add(r110);
            return;
        L106:
            return;
        L7:
            if (r1 != 3) goto L9;
            a r111 = (a) r12.obj;
            if (r111 != null) goto L15;
            return;
        L15:
            if (r111.a != null) goto L17;
            return;
        L17:
            if (TextUtils.isEmpty(r111.b) == false) goto L19;
            ((ConcurrentHashMap) this.a.a).remove(r111.a);
            return;
        L19:
            Set r23 = (Set) ((ConcurrentHashMap) this.a.a).get(r111.a);
            if (CollectionUtils.isEmpty(r23) == true) goto L105;
            Iterator r24 = r23.iterator();
        L23:
            if (r24.hasNext() == false) goto L115;
            if (TextUtils.equals(((a) r24.next()).b, r111.b) == false) goto L23;
            r24.remove();
            goto L23
        L115:
            return;
        L105:
            return;
        L9:
            if (r1 != 4) goto L114;
            ((ConcurrentHashMap) this.a.a).clear();
            return;
        }

        public HandlerC0078b(b r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public b() {
        this.a = new ConcurrentHashMap();
        this.b = new HandlerC0078b(this, CoreThreadPool.getSerialTaskHandler().getLooper());
    }

    public final void a(byte[] r3) {
        tt5.a.b("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener.onPush: 21 ");
        HandlerC0078b r0 = this.b;
        r0.getClass();
        r0.sendMessage(Message.obtain(r0, 1, r3));
    }

    public final void c(String r4, String r5) {
        tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener unRegisterDownloadCallback, uniqueKey: " + r4 + ", callbackKey: " + r5);
        HandlerC0078b r0 = this.b;
        a r1 = new a(r4, r5, null, null);
        r0.getClass();
        r0.sendMessage(Message.obtain(r0, 3, r1));
    }

    public final void b(String r4, String r5, DownloadRequestInfo r6) {
        tt5.a.k("Middleground_Drive_DriveDownloadStateListener", "DriveDownloadStateListener registerDownloadCallback, uniqueKey: " + r4 + ", callbackKey: " + r5);
        HandlerC0078b r0 = this.b;
        a r1 = new a(r4, r5, r6.d, r6.o);
        r0.getClass();
        r0.sendMessage(Message.obtain(r0, 2, r1));
    }
}
