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

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<UploadCallback> f232556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f232557b;

    public final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f232558a;

        @Override // android.os.Handler
        public final void handleMessage(Message r110) {
            int r100 = r110.what;
            if (r100 != 1) goto L5;
            byte[] r111 = (byte[]) r110.obj;
            this.f232558a.getClass();
            PushUploadCallback r112 = PushUploadCallback.ADAPTER.decode(r111);     // Catch: Exception -> L19
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener parse: PushUploadCallback key =" + r112.key + ", bytes_transferred is " + r112.bytes_transferred + ", bytes_total is " + r112.bytes_total + ", file token is " + du5.b.g(r112.file_token) + ", file path is " + du5.b.g(r112.file_path) + ", uri_str is " + du5.b.g(r112.uri_str) + ", mount point is " + r112.mount_point);     // Catch: Exception -> L19
        L21:
            c r101 = this.f232558a;
            r101.getClass();
            if (r112 != null) goto L57;
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener.dispatch: data is null ");
            return;
        L57:
            Set<UploadCallback> r102 = r101.f232556a;     // Catch: Exception -> L52
            if (r102 != null) goto L27;
        L50:
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: no callback");     // Catch: Exception -> L52
            return;
        L27:
            if (((HashSet) r102).size() <= 0) goto L50;
            Iterator r103 = ((HashSet) r101.f232556a).iterator();     // Catch: Exception -> L52
        L30:
            if (r103.hasNext() == false) goto L71;
            UploadCallback r104 = (UploadCallback) r103.next();     // Catch: Exception -> L52
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: has callback,call updateProgress ");     // Catch: Exception -> L52
            if (r112.failed_info != null) goto L33;
            DriveFile.Status r105 = DriveFile.Status.from(r112.status.getValue());     // Catch: Exception -> L52
            UploadExtraInfo r106 = r112.extra_info;     // Catch: Exception -> L52
            if (r106 == null) goto L41;
            String r107 = r106.node_token;     // Catch: Exception -> L52
        L43:
            if (r105 != DriveFile.Status.SUCCESS) goto L45;
            String r108 = f.a(r112.mount_point, r112.file_token, r112.mount_node_point);     // Catch: Exception -> L52
        L46:
            String r109 = r112.key;     // Catch: Exception -> L52
            UploadCallback.b.a r113 = new UploadCallback.b.a();     // Catch: Exception -> L52
            r113.f232493a = r105;     // Catch: Exception -> L52
            r113.f232494b = CastLongProtector.parseLong(r112.bytes_transferred);     // Catch: Exception -> L52
            r113.f232495c = CastLongProtector.parseLong(r112.bytes_total);     // Catch: Exception -> L52
            UploadCallback.b r114 = new UploadCallback.b(r113);     // Catch: Exception -> L52
            UploadCallback.a.C3324a r115 = new UploadCallback.a.C3324a();     // Catch: Exception -> L52
            r115.f232483a = r112.file_token;     // Catch: Exception -> L52
            String r116 = r112.file_path;     // Catch: Exception -> L52
            String r117 = r112.uri_str;     // Catch: Exception -> L52
            if (TextUtils.isEmpty(r116) == false) goto L49;
            r116 = r117;
        L49:
            r115.f232484b = r116;     // Catch: Exception -> L52
            r115.f232486d = r112.mount_point;     // Catch: Exception -> L52
            r115.f232485c = r112.mount_node_point;     // Catch: Exception -> L52
            r115.f232487e = r112.data_version;     // Catch: Exception -> L52
            r115.f232488f = r107;     // Catch: Exception -> L52
            r115.f232489g = r108;     // Catch: Exception -> L52
            r104.updateProgress(r109, r114, new UploadCallback.a(r115));     // Catch: Exception -> L52
            goto L30
        L45:
            r108 = null;
            goto L46
        L41:
            r107 = "";
            goto L43
        L33:
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener dispatch: has callback,call onFailed ");     // Catch: Exception -> L52
            UploadFailedInfo r118 = r112.failed_info;     // Catch: Exception -> L52
            String r119 = r118.key;     // Catch: Exception -> L52
            int r120 = r118.error_code.intValue();     // Catch: Exception -> L52
            String r121 = r112.mount_node_point;     // Catch: Exception -> L52
            String r122 = r112.bytes_total;     // Catch: Exception -> L52
            if (r122 != null) goto L36;
            long r123 = 0;
        L37:
            r104.onFailed(r119, r120, r121, r123);     // Catch: Exception -> L52
            goto L30
        L36:
            r123 = CastLongProtector.parseLong(r122);     // Catch: Exception -> L52
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
            r112 = null;
            goto L21
        L5:
            if (r100 != 2) goto L7;
            UploadCallback r124 = (UploadCallback) r110.obj;
            if (r124 == null) goto L66;
            ((HashSet) this.f232558a.f232556a).add(r124);
            return;
        L66:
            return;
        L7:
            if (r100 != 3) goto L9;
            ((HashSet) this.f232558a.f232556a).remove((UploadCallback) r110.obj);
            return;
        L9:
            if (r100 != 4) goto L69;
            ((HashSet) this.f232558a.f232556a).clear();
            return;
        }

        public a(c r100, Looper r101) {
            this.f232558a = r100;
            super(r101);
        }
    }

    public c() {
        this.f232556a = new HashSet();
        this.f232557b = new a(this, CoreThreadPool.getSerialTaskHandler().getLooper());
    }
}
