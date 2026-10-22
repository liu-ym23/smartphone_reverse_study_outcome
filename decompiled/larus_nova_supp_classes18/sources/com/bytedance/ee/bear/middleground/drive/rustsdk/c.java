package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.lark.pb.space.drive.v1.PushUploadCallback;
import com.bytedance.lark.pb.space.drive.v1.UploadExtraInfo;
import com.bytedance.lark.pb.space.drive.v1.UploadFailedInfo;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final Set<UploadCallback> a;
    public final a b;

    public final class a extends Handler {
        public final /* synthetic */ c a;

        @Override // android.os.Handler
        public final void handleMessage(Message r14) {
            int r1 = r14.what;
            if (r1 != 1) goto L5;
            byte[] r15 = (byte[]) r14.obj;
            this.a.getClass();
            PushUploadCallback r16 = (PushUploadCallback) PushUploadCallback.ADAPTER.decode(r15);     // Catch: Exception -> L19
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener parse: PushUploadCallback key =" + r16.key + ", bytes_transferred is " + r16.bytes_transferred + ", bytes_total is " + r16.bytes_total + ", file token is " + du5.b.g(r16.file_token) + ", file path is " + du5.b.g(r16.file_path) + ", uri_str is " + du5.b.g(r16.uri_str) + ", mount point is " + r16.mount_point);     // Catch: Exception -> L19
        L21:
            c r2 = this.a;
            r2.getClass();
            if (r16 != null) goto L57;
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener.dispatch: data is null ");
            return;
        L57:
            Set<UploadCallback> r4 = r2.a;     // Catch: Exception -> L52
            if (r4 != null) goto L27;
        L50:
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: no callback");     // Catch: Exception -> L52
            return;
        L27:
            if (((HashSet) r4).size() <= 0) goto L50;
            Iterator r3 = ((HashSet) r2.a).iterator();     // Catch: Exception -> L52
        L30:
            if (r3.hasNext() == false) goto L71;
            UploadCallback r5 = (UploadCallback) r3.next();     // Catch: Exception -> L52
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: has callback,call updateProgress ");     // Catch: Exception -> L52
            if (r16.failed_info != null) goto L33;
            DriveFile.Status r6 = DriveFile.Status.from(r16.status.getValue());     // Catch: Exception -> L52
            UploadExtraInfo r7 = r16.extra_info;     // Catch: Exception -> L52
            if (r7 == null) goto L41;
            String r8 = r7.node_token;     // Catch: Exception -> L52
        L43:
            if (r6 != DriveFile.Status.SUCCESS) goto L45;
            String r9 = f.a(r16.mount_point, r16.file_token, r16.mount_node_point);     // Catch: Exception -> L52
        L46:
            String r10 = r16.key;     // Catch: Exception -> L52
            UploadCallback.b.a r11 = new UploadCallback.b.a();     // Catch: Exception -> L52
            r11.a = r6;     // Catch: Exception -> L52
            r11.b = CastLongProtector.parseLong(r16.bytes_transferred);     // Catch: Exception -> L52
            r11.c = CastLongProtector.parseLong(r16.bytes_total);     // Catch: Exception -> L52
            UploadCallback.b r12 = new UploadCallback.b(r11);     // Catch: Exception -> L52
            UploadCallback.a.C0077a r13 = new UploadCallback.a.C0077a();     // Catch: Exception -> L52
            r13.a = r16.file_token;     // Catch: Exception -> L52
            String r17 = r16.file_path;     // Catch: Exception -> L52
            String r18 = r16.uri_str;     // Catch: Exception -> L52
            if (TextUtils.isEmpty(r17) == false) goto L49;
            r17 = r18;
        L49:
            r13.b = r17;     // Catch: Exception -> L52
            r13.d = r16.mount_point;     // Catch: Exception -> L52
            r13.c = r16.mount_node_point;     // Catch: Exception -> L52
            r13.e = r16.data_version;     // Catch: Exception -> L52
            r13.f = r8;     // Catch: Exception -> L52
            r13.g = r9;     // Catch: Exception -> L52
            r5.updateProgress(r10, r12, new UploadCallback.a(r13));     // Catch: Exception -> L52
            goto L30
        L45:
            r9 = null;
            goto L46
        L41:
            r8 = "";
            goto L43
        L33:
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: has callback,call onFailed ");     // Catch: Exception -> L52
            UploadFailedInfo r19 = r16.failed_info;     // Catch: Exception -> L52
            String r20 = r19.key;     // Catch: Exception -> L52
            int r21 = r19.error_code.intValue();     // Catch: Exception -> L52
            String r22 = r16.mount_node_point;     // Catch: Exception -> L52
            String r23 = r16.bytes_total;     // Catch: Exception -> L52
            if (r23 != null) goto L36;
            long r24 = 0;
        L37:
            r5.onFailed(r20, r21, r22, r24);     // Catch: Exception -> L52
            goto L30
        L36:
            r24 = CastLongProtector.parseLong(r23);     // Catch: Exception -> L52
            goto L37
        L71:
            return;
        L52:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: ", e, false);
            return;
        L19:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener parse: ", e, false);
            r16 = null;
            goto L21
        L5:
            if (r1 != 2) goto L7;
            UploadCallback r110 = (UploadCallback) r14.obj;
            if (r110 == null) goto L66;
            ((HashSet) this.a.a).add(r110);
            return;
        L66:
            return;
        L7:
            if (r1 != 3) goto L9;
            ((HashSet) this.a.a).remove((UploadCallback) r14.obj);
            return;
        L9:
            if (r1 != 4) goto L69;
            ((HashSet) this.a.a).clear();
            return;
        }

        public a(c r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public c() {
        this.a = new HashSet();
        this.b = new a(this, CoreThreadPool.getSerialTaskHandler().getLooper());
    }
}
