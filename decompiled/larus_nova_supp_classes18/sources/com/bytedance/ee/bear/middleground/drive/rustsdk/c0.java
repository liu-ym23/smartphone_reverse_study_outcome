package com.bytedance.ee.bear.middleground.drive.rustsdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.bytedance.lark.pb.space.drive.v1.PushUploadCallback;
import com.bytedance.lark.pb.space.drive.v1.UploadExtraInfo;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 implements com.ss.android.lark.sdk.g.b {
    public final Map<String, Set<a>> a;
    public final c b;
    public final b c;

    public class a {
        public final String a;
        public final String b;
        public final UploadCallback c;

        public a(String r1, UploadCallback r2) {
            this.a = r1;
            if (r2 != null) goto L5;
            String r3 = "";
        L6:
            this.b = r3;
            this.c = r2;
            return;
        L5:
            r3 = String.valueOf(r2.hashCode());
            goto L6
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
            this.c = null;
        }
    }

    public final class b extends Handler {
        public final /* synthetic */ c0 a;

        @Override // android.os.Handler
        public final void handleMessage(Message r18) {
            switch(r18.what) {
                case 1: goto L33;
                case 2: goto L25;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L8;
                case 6: goto L5;
                default: goto L110;
            };
        L5:
            UploadCallback r0 = (UploadCallback) r18.obj;
            c r2 = this.a.b;
            if (r2 == null) goto L94;
            c.a r3 = r2.b;
            r3.getClass();
            r3.sendMessage(Message.obtain(r3, 3, r0));
            return;
        L94:
            return;
        L8:
            UploadCallback r1 = (UploadCallback) r18.obj;
            if (r1 == null) goto L96;
            c r4 = this.a.b;
            if (r4 == null) goto L97;
            c.a r5 = r4.b;
            r5.getClass();
            r5.sendMessage(Message.obtain(r5, 2, r1));
            return;
        L97:
            return;
        L96:
            return;
        L13:
            ((ConcurrentHashMap) this.a.a).clear();
            return;
        L14:
            a r6 = (a) r18.obj;
            if (TextUtils.isEmpty(r6.b) == false) goto L17;
            ((ConcurrentHashMap) this.a.a).remove(r6.a);
            return;
        L17:
            Set r7 = (Set) ((ConcurrentHashMap) this.a.a).get(r6.a);
            if (CollectionUtils.isEmpty(r7) == true) goto L101;
            Iterator r8 = r7.iterator();
        L21:
            if (r8.hasNext() == false) goto L111;
            if (TextUtils.equals(((a) r8.next()).b, r6.b) == false) goto L21;
            r8.remove();
            goto L21
        L111:
            return;
        L101:
            return;
        L25:
            a r9 = (a) r18.obj;
            if (r9 == null) goto L102;
            String r10 = r9.a;
            if (r10 != null) goto L30;
            return;
        L30:
            if (((ConcurrentHashMap) this.a.a).get(r10) != null) goto L32;
            ((ConcurrentHashMap) this.a.a).put(r9.a, Collections.synchronizedSet(new HashSet()));
        L32:
            ((Set) ((ConcurrentHashMap) this.a.a).get(r9.a)).add(r9);
            return;
        L102:
            return;
        L33:
            byte[] r11 = (byte[]) r18.obj;
            c r12 = this.a.b;
            if (r12 == null) goto L36;
            tt5.a.b("Middleground_Drive_DriveGlobalUploadStateListener", "DriveGlobalUploadStateListener.onPush: 19 ");
            c.a r13 = r12.b;
            r13.getClass();
            r13.sendMessage(Message.obtain(r13, 1, r11));
        L36:
            this.a.getClass();
            PushUploadCallback r14 = (PushUploadCallback) PushUploadCallback.ADAPTER.decode(r11);     // Catch: Exception -> L39
        L41:
            c0 r15 = this.a;
            r15.getClass();
            if (r14 != null) goto L44;
            tt5.a.d("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: data is null ");
            return;
        L44:
            String r16 = r14.key;
            if (TextUtils.isEmpty(r16) == false) goto L47;
            tt5.a.k("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: response key is null");
            return;
        L47:
            Set r17 = (Set) ((ConcurrentHashMap) r15.a).get(r16);
            if (CollectionUtils.isEmpty(r17) == false) goto L84;
            tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: no callback");
            return;
        L84:
            tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: has callback,call updateProgress key=" + r16);     // Catch: Exception -> L71
            if (r14.failed_info == null) goto L55;
            tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: has callback,call onFailed key=" + r16);     // Catch: Exception -> L71
            Iterator r19 = r17.iterator();     // Catch: Exception -> L71
        L53:
            if (r19.hasNext() == false) goto L73;
            a r20 = (a) r19.next();     // Catch: Exception -> L71
            r20.c.onFailed(e0.a(r14.failed_info.key, r20.b), r14.failed_info.error_code.intValue(), r14.mount_node_point, CastLongProtector.parseLong(r14.bytes_total));     // Catch: Exception -> L71
        L73:
            PushUploadCallback.Status r21 = r14.status;
            if (r21 != PushUploadCallback.Status.SUCCESS) goto L76;
        L81:
            tt5.a.h("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: delete callback ,");
            String r22 = r14.key;
            b r23 = r15.c;
            a r24 = new a(r22, "");
            r23.getClass();
            r23.sendMessage(Message.obtain(r23, 3, r24));
            return;
        L76:
            if (r21 == PushUploadCallback.Status.FAILED) goto L80;
            if (r21 == PushUploadCallback.Status.CANCEL) goto L80;
            return;
        L80:
            if (r14.failed_info != null) goto L81;
            return;
        L55:
            Iterator r25 = r17.iterator();     // Catch: Exception -> L71
        L57:
            if (r25.hasNext() == false) goto L73;
            a r26 = (a) r25.next();     // Catch: Exception -> L71
            DriveFile.Status r110 = DriveFile.Status.from(r14.status.getValue());     // Catch: Exception -> L71
            String r111 = e0.a(r14.key, r26.b);     // Catch: Exception -> L71
            UploadExtraInfo r112 = r14.extra_info;     // Catch: Exception -> L71
            if (r112 == null) goto L61;
            String r113 = r112.node_token;     // Catch: Exception -> L71
        L63:
            if (r110 != DriveFile.Status.SUCCESS) goto L65;
            String r114 = f.a(r14.mount_point, r14.file_token, r14.mount_node_point);     // Catch: Exception -> L71
        L66:
            UploadCallback r27 = r26.c;     // Catch: Exception -> L71
            UploadCallback.b.a r115 = new UploadCallback.b.a();     // Catch: Exception -> L71
            r115.a = r110;     // Catch: Exception -> L71
            r115.b = CastLongProtector.parseLong(r14.bytes_transferred);     // Catch: Exception -> L71
            r115.c = CastLongProtector.parseLong(r14.bytes_total);     // Catch: Exception -> L71
            UploadCallback.b r28 = new UploadCallback.b(r115);     // Catch: Exception -> L71
            UploadCallback.a.C0077a r29 = new UploadCallback.a.C0077a();     // Catch: Exception -> L71
            r29.a = r14.file_token;     // Catch: Exception -> L71
            String r116 = r14.file_path;     // Catch: Exception -> L71
            String r117 = r14.uri_str;     // Catch: Exception -> L71
            if (TextUtils.isEmpty(r116) == false) goto L69;
            r116 = r117;
        L69:
            r29.b = r116;     // Catch: Exception -> L71
            r29.c = r14.mount_node_point;     // Catch: Exception -> L71
            r29.d = r14.mount_point;     // Catch: Exception -> L71
            r29.f = r113;     // Catch: Exception -> L71
            r29.e = r14.data_version;     // Catch: Exception -> L71
            r29.g = r114;     // Catch: Exception -> L71
            r27.updateProgress(r111, r28, new UploadCallback.a(r29));     // Catch: Exception -> L71
            goto L57
        L65:
            r114 = null;
            goto L66
        L61:
            r113 = "";
        L71:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener dispatch: ", e, false);
        L39:
            e = move-exception;
            tt5.a.e("Middleground_Drive_DriveUploadStateListener", "parse: ", e, false);
            r14 = null;
            goto L41
        }

        public b(c0 r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public c0() {
        this.a = new ConcurrentHashMap();
        this.c = new b(this, CoreThreadPool.getSerialTaskHandler().getLooper());
        this.b = new c();
    }

    public final void a(byte[] r3) {
        tt5.a.b("Middleground_Drive_DriveUploadStateListener", "DriveUploadStateListener.onPush: 21 ");
        b r0 = this.c;
        r0.getClass();
        r0.sendMessage(Message.obtain(r0, 1, r3));
    }
}
