package r65;

import android.os.Bundle;
import com.bytedance.ee.bear.drive.biz.upload.RustUploadCallback;
import com.bytedance.ee.bear.middleground.drive.export.DrivePriority;
import com.bytedance.ee.bear.middleground.drive.export.UploadRequestInfo;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.util.io.FileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f<V> implements Callable {
    public final /* synthetic */ e a;
    public final /* synthetic */ List<String> b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ boolean e;

    public f(e r1, List<String> r2, boolean r3, Bundle r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        e r1 = this.a;
        this.b.size();
        int r2 = e.j;
        monitor-enter(r1);
        monitor-exit(r1);
        Iterator<String> r3 = this.b.iterator();
    L7:
        if (r3.hasNext() == false) goto L18;
        String r4 = r3.next();
        LinkedHashMap r13 = new LinkedHashMap();
        r13.put("size_checker", String.valueOf(((t) org.koin.java.a.c(t.class, null, null, 6)).e()));
        DrivePriority.UploadPriority.DEFAULT.getPriority();
        UploadRequestInfo.UploadType r11 = UploadRequestInfo.UploadType.DRIVE;
        boolean r5 = this.c;
        if (r5 == false) goto L11;
        String r12 = r4;
        String r10 = "";
    L12:
        String r8 = FileUtils.x(r5, r4);
        e r6 = this.a;
        String r7 = r6.h;
        String r9 = r6.g;
        int r17 = DrivePriority.UploadPriority.BACKGROUND.getPriority();
        RustUploadCallback r18 = new RustUploadCallback(r4, Boolean.valueOf(this.c), this.a.f.Ke(), this.d, this.a.i);
        Iterator<String> r16 = r3;
        UploadRequestInfo r14 = new UploadRequestInfo(r10, r12, r8, r7, r9, "", r17, r11, null, r13, null, r18);
        String r19 = ((com.bytedance.ee.bear.drive.sdk.service.f) org.koin.java.a.c(com.bytedance.ee.bear.drive.sdk.service.f.class, null, null, 6)).d0().s(r14);
        this.a.f.Ke().x("confirm_upload", "", "", this.d);
        if (this.e == false) goto L15;
        com.bytedance.ee.bear.drive.report.c r20 = this.a.f.Ke();
        r20.getClass();
        HashMap<String, Object> r21 = new HashMap();
        r21.put("dummy_token", r19);
        r20.H(r4, "drive_click_upload_multimedia_confirm", r21);
    L16:
        r3 = r16;
        goto L7
    L15:
        com.bytedance.ee.bear.drive.report.c r22 = this.a.f.Ke();
        r22.getClass();
        HashMap<String, Object> r23 = new HashMap();
        r23.put("dummy_token", r19);
        r22.H(r8, "drive_click_upload_file_confirm", r23);
        goto L16
    L11:
        r10 = r4;
        r12 = "";
        goto L12
    L18:
        return Boolean.TRUE;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
