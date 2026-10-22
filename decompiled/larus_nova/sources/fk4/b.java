package fk4;

import com.bytedance.dora.offline.file.OfflineFileBusiness;
import com.bytedance.dora.offline.record.DoraOfflineRecord;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.LinkedHashMap;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements OfflineFileBusiness {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DoraOfflineRecord f477616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f477617b;

    @Override // com.bytedance.dora.offline.file.OfflineFileBusiness
    public final void f() {
    }

    @Override // com.bytedance.dora.offline.file.OfflineFileBusiness
    public final String a(com.bytedance.dora.offline.file.b.d r100) {
        if (r100.f204590j != 2) goto L5;
        int r101 = r100.f204585e;
        boolean r102 = true;
        if (r101 != 1) goto L9;
        return null;
    L9:
        if (r101 != 2) goto L24;
        if (r100.f204583c == 1) goto L13;
    L18:
        r102 = false;
    L19:
        if (r102 == true) goto L25;
        return "invalid_online_record_context";
    L25:
        return null;
    L13:
        if (com.bytedance.dora.offline.file.b.c(r100.f204584d) == null) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
    L15:
        r103 = false;
        goto L16
    L24:
        return "unsupported_file_type_" + r100.f204585e;
    L5:
        return "unsupported_file_format_" + r100.f204590j;
    }

    public b(DoraOfflineRecord r100, d r101) {
        this.f477616a = r100;
        this.f477617b = r101;
    }

    @Override // com.bytedance.dora.offline.file.OfflineFileBusiness
    public final void d(String r100, com.bytedance.dora.offline.file.b.f r101) {
        this.f477616a.notifyRecordFileReady(r100, r101);
    }

    @Override // com.bytedance.dora.offline.file.OfflineFileBusiness
    public final void e(String r100, OfflineFileBusiness.a r101) {
        this.f477616a.notifyRecordProgress(r100, r101);
    }

    public static c g(String r210, com.bytedance.dora.offline.file.b.d r211, PolarisFileWrapper r212) {
        String r100 = r211.f204582b;
        if (r211.f204583c != 1) goto L5;
        String r101 = r211.f204584d;
    L7:
        return new c(r100, r101, r212.getAbsolutePath(), r211.f204585e, r211.f204586f, r211.f204587g, r211.f204588h, r211.f204589i, r211.f204596p, r211.f204597q, r211.f204594n, r211.f204595o, 960, r211.f204598r, r211.f204599s, r211.f204600t, r211.f204593m, r210);
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.bytedance.dora.offline.file.OfflineFileBusiness
    public final OfflineFileBusiness.DeliveryResult b(String r100, com.bytedance.dora.offline.file.b.d r101, PolarisFileWrapper r102) {
        c r103 = g(r100, r101, r102);
        if (this.f477616a.isRetainedRecordFileUsable(r103) == false) goto L38;
        d r104 = this.f477617b;
        r104.getClass();
        if (d.d(r103.f477618a) == false) goto L41;
        j.d("OfflineRecordDeliveryStore", "Upsert offline record delivery skipped, empty recordId");
    L33:
        boolean r105 = false;
    L34:
        if (r105 == false) goto L38;
        j.d("OfflineRecordBusiness", "Offline record retained, recordId=" + r103.f477618a);
        return OfflineFileBusiness.DeliveryResult.RETAINED;
    L41:
        Object r106 = r104.f477639a;     // Catch: Throwable -> L31
        monitor-enter(r106);     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L10:
        if (ek4.a.a(r100) == true) goto L14;
        j.f("OfflineRecordDeliveryStore", "Upsert offline record delivery skipped because account changed, recordId=" + r103.f477618a);     // Catch: Throwable -> L28
        monitor-exit(r106);     // Catch: Throwable -> L28
        goto L33
    L14:
        LinkedHashMap r107 = d.e(r100);     // Catch: Throwable -> L28
        r107.put(r103.f477618a, r103);     // Catch: Throwable -> L28
        if (ek4.a.a(r100) == true) goto L19;
        j.f("OfflineRecordDeliveryStore", "Upsert offline record delivery skipped before save because account changed, recordId=" + r103.f477618a);     // Catch: Throwable -> L28
        monitor-exit(r106);     // Catch: Throwable -> L28
        goto L33
    L19:
        d.g(r107.values(), r100);     // Catch: Throwable -> L28
        r105 = d.c((c) d.e(r100).get(r103.f477618a), r103);     // Catch: Throwable -> L28
        if (ek4.a.a(r100) == true) goto L24;
        j.f("OfflineRecordDeliveryStore", "Verify offline record delivery store skipped because account changed, recordId=" + r103.f477618a);     // Catch: Throwable -> L28
        monitor-exit(r106);     // Catch: Throwable -> L28
        goto L33
    L24:
        if (r105 == true) goto L26;
        j.b("OfflineRecordDeliveryStore", "Verify offline record delivery store failed, recordId=" + r103.f477618a);     // Catch: Throwable -> L28
    L26:
        monitor-exit(r106);     // Catch: Throwable -> L28
    L31:
        th = move-exception;
        j.c("OfflineRecordDeliveryStore", "Upsert offline record delivery failed, recordId=" + r103.f477618a, th);
    L38:
        j.b("OfflineRecordBusiness", "Persist retained offline record failed, recordId=" + r103.f477618a);
        return OfflineFileBusiness.DeliveryResult.RETRYABLE_FAILED;
    }

    @Override // com.bytedance.dora.offline.file.OfflineFileBusiness
    public final void c(String r100, com.bytedance.dora.offline.file.b.d r101, PolarisFileWrapper r102) {
        this.f477616a.notifyRecordCompleted(r100, g(r100, r101, r102));
    }
}
