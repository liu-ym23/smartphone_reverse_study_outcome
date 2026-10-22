package com.bytedance.dora.offline.record;

import com.bytedance.dora.offline.file.OfflineFileBusiness;
import com.bytedance.dora.offline.file.OfflineFileSyncEngine;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import fk4.c;
import fk4.d;
import fk4.e;
import fk4.g;
import fk4.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import mj4.f;
import pk4.j;

/* JADX INFO: loaded from: classes3.dex */
public final class DoraOfflineRecord {
    private static final String REASON_APP_DELETE = "app_delete";
    private static final String TAG = "DoraOfflineRecord";
    private final d deliveryStore;
    private final CopyOnWriteArraySet<g> listeners;
    private final fk4.b recordBusiness;
    private final OfflineFileSyncEngine syncEngine;

    /* JADX INFO: loaded from: classes15.dex */
    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoraOfflineRecord f204660a = null;

        static {
            f204660a = new DoraOfflineRecord(null);
        }
    }

    public static /* synthetic */ int a(DoraOfflineRecord r100, c r101, c r102) {
        return r100.lambda$loadUsableSyncedRecords$0(r101, r102);
    }

    private String currentUserIdOrNull() {
        char[] r100 = ek4.a.f472939a;
        String r101 = pk4.c.a.f529617a.a();
        if (r101 != null) goto L5;
    L9:
        String r102 = "";
    L11:
        if (r102.isEmpty() == false) goto L14;
        return null;
    L14:
        return r102;
    L5:
        if (r101.isEmpty() == true) goto L9;
        r102 = r101.trim();
        if (r102.isEmpty() == false) goto L11;
        goto L9
    }

    public void init() {
        OfflineFileSyncEngine r100 = this.syncEngine;
        if (r100.f204510h.compareAndSet(false, true) == false) goto L6;
        r100.f204503a.registerDoraLinkCallback(r100.f204521s);
    L6:
        if (r100.f204511i.compareAndSet(false, true) == false) goto L8;
        sk4.b.C7624b.f542395a.registerProtocolInfoCallback(r100.f204522t, true);
    L8:
        com.bytedance.dora.offline.file.a r101 = r100.f204520r;
        if (r101.f204567b.getAndSet(true) == true) goto L11;
        sk4.b.C7624b.f542395a.registerDoraVoiceCallback(r101);
        ((CopyOnWriteArraySet) f.b.f514251a.f514226a).add(r101);
        r101.o(ak4.a.d().f4000a.A, null, "init");
        j.d("OfflineFileBusinessBlocker", "Business blocker registered callbacks");
    L11:
        OfflineFileSyncEngine r102 = this.syncEngine;
        fk4.b r103 = this.recordBusiness;
        r102.getClass();
        if (r103 == null) goto L16;
        r102.f204514l.put(1, r103);
        j.d("OfflineFileSyncEngine", "Register offline file business, businessType=1");
        r102.A();
        return;
    }

    public boolean isOfflineMinutesSupported() {
        return this.syncEngine.f204524v;
    }

    private DoraOfflineRecord() {
        this.syncEngine = OfflineFileSyncEngine.e.f204538a;
        d r100 = new d();
        this.deliveryStore = r100;
        this.recordBusiness = new fk4.b(this, r100);
        this.listeners = new CopyOnWriteArraySet();
    }

    public List<c> getSyncedRecords() {
        String r100 = currentUserIdOrNull();
        if (r100 != null) goto L7;
        return new ArrayList();
    L7:
        return loadUsableSyncedRecords(r100);
    }

    public static DoraOfflineRecord getInstance() {
        return b.f204660a;
    }

    public /* synthetic */ DoraOfflineRecord(a r100) {
        this();
    }

    private List<c> loadUsableSyncedRecords(String r100) {
        ArrayList r101 = new ArrayList();
        d r102 = this.deliveryStore;
        r102.getClass();
        if (r100 != null) goto L39;
        ArrayList r103 = new ArrayList();
    L23:
        Iterator r104 = r103.iterator();
    L25:
        if (r104.hasNext() == false) goto L34;
        c r105 = (c) r104.next();
        if (isRetainedRecordFileUsable(r105) == true) goto L28;
        StringBuilder r106 = new StringBuilder("Skip unavailable retained offline record, recordId=");
        if (r105 != null) goto L32;
        String r107 = null;
    L33:
        r106.append(r107);
        j.d(TAG, r106.toString());
        goto L25
    L32:
        r107 = r105.f477618a;
        goto L33
    L28:
        r101.add(r105);
        goto L25
    L34:
        Collections.sort(r101, new fk4.a(this));
        if (ek4.a.a(r100) == false) goto L38;
        return r101;
    L38:
        return new ArrayList();
    L39:
        Object r108 = r102.f477639a;     // Catch: Throwable -> L21
        monitor-enter(r108);     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L8:
        if (ek4.a.a(r100) == true) goto L12;
        ArrayList r109 = new ArrayList();     // Catch: Throwable -> L18
        monitor-exit(r108);     // Catch: Throwable -> L18
    L11:
        r103 = r109;
        goto L23
    L12:
        r109 = new ArrayList(d.e(r100).values());     // Catch: Throwable -> L18
        if (ek4.a.a(r100) == true) goto L16;
        r109 = new ArrayList();     // Catch: Throwable -> L18
    L16:
        monitor-exit(r108);     // Catch: Throwable -> L18
    L21:
        th = move-exception;
        j.c("OfflineRecordDeliveryStore", "Read offline record deliveries failed", th);
        r103 = new ArrayList();
        goto L23
    }

    private long recordOrderTime(c r100) {
        return Math.max(r100.f477637t, Math.max(r100.f477622e, r100.f477623f));
    }

    public int configureFileListLimit(int r100) {
        OfflineFileSyncEngine r101 = this.syncEngine;
        int r102 = r101.f204523u;
        if (r100 >= 1) goto L5;
        int r103 = 10;
    L6:
        r101.f204523u = r103;
        j.d("OfflineFileSyncEngine", "Configure file list limit, requested=" + r100 + ", previous=" + r102 + ", effective=" + r103);
        return r103;
    L5:
        r103 = Math.min(r100, 15);
        goto L6
    }

    public boolean configureStorage(fk4.f r100) {
        j.f(TAG, "Configure offline record storage skipped because config is null");
        return false;
    }

    public boolean deleteSyncedRecord(String r100) {
        return deleteSyncedRecord(r100, REASON_APP_DELETE);
    }

    public c getSyncedRecord(String r100) {
        if (r100 != null) goto L5;
    L18:
        return null;
    L5:
        if (r100.length() == 0) goto L18;
        String r101 = currentUserIdOrNull();
        if (r101 != null) goto L10;
        return null;
    L10:
        c r102 = this.deliveryStore.b(r101, r100);
        if (ek4.a.a(r101) == true) goto L14;
        return null;
    L14:
        if (isRetainedRecordFileUsable(r102) == true) goto L17;
        j.d(TAG, "Skip unavailable offline record by query, recordId=".concat(r100));
        return null;
    L17:
        return r102;
    }

    public boolean isRetainedRecordFileUsable(c r100) {
        if (r100 == null) goto L25;
        String r101 = r100.f477618a;
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.length() == 0) goto L27;
        String r102 = r100.f477620c;
        if (r102 != null) goto L11;
        return false;
    L11:
        if (r102.length() == 0) goto L33;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100.f477620c);
        if (r103.exists() == true) goto L16;
        return false;
    L16:
        if (r103.isFile() == true) goto L18;
        return false;
    L18:
        if (r103.canRead() == true) goto L20;
        return false;
    L20:
        if (r100.f477625h > 0) goto L22;
    L23:
        return true;
    L22:
        if (r103.length() == r100.f477625h) goto L23;
        return false;
    L33:
        return false;
    L27:
        return false;
    L25:
        return false;
    }

    public void registerTransferListener(g r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.listeners.add(r100);
        j.d(TAG, "Register offline record listener, count=" + this.listeners.size());
    }

    public void unregisterTransferListener(g r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        j.d(TAG, "Unregister offline record listener, removed=" + this.listeners.remove(r100) + ", count=" + this.listeners.size());
    }

    private /* synthetic */ int lambda$loadUsableSyncedRecords$0(c r100, c r101) {
        return Long.compare(recordOrderTime(r101), recordOrderTime(r100));
    }

    public boolean bindOnlineRecordContext(String r100, String r101) {
        return bindContext(1, r100, 1, r101);
    }

    public boolean deleteSyncedRecord(String r100, String r101) {
        if (r100 != null) goto L5;
    L31:
        j.d(TAG, "Delete synced record skipped because recordId is empty, reason=" + r101);
        return false;
    L5:
        if (r100.length() == 0) goto L31;
        String r102 = currentUserIdOrNull();
        if (r102 != null) goto L11;
        j.d(TAG, "Delete synced record skipped because user is unavailable, recordId=".concat(r100));
        return false;
    L11:
        c r103 = this.deliveryStore.b(r102, r100);
        if (ek4.a.a(r102) == true) goto L15;
        j.d(TAG, "Delete synced record stopped because account changed, recordId=".concat(r100));
        return false;
    L15:
        if (r103 != null) goto L18;
        boolean r104 = this.deliveryStore.f(r102, r100);
        j.d(TAG, "Delete synced record skipped because record is missing, recordId=" + r100 + ", indexCleanupSuccess=" + r104);
        return r104;
    L18:
        if (r101 != null) goto L20;
    L21:
        r101 = REASON_APP_DELETE;
    L23:
        if (deleteRetainedRecordFile(r102, r103, r101) == true) goto L26;
        return false;
    L26:
        if (this.deliveryStore.f(r102, r100) == true) goto L29;
        j.b(TAG, "Remove offline record index failed after file deletion, recordId=".concat(r100));
        return false;
    L29:
        j.d(TAG, "Delete synced offline record finished, recordId=" + r100 + ", reason=" + r101);
        return true;
    L20:
        if (r101.length() != 0) goto L23;
        goto L21
    }

    public void notifyRecordCompleted(String r100, c r101) {
        if (ek4.a.a(r100) == false) goto L28;
        if (r101 == null) goto L28;
        if (r101.f477638u.length() > 0) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == false) goto L28;
        Iterator<g> r103 = this.listeners.iterator();
    L15:
        if (r103.hasNext() == false) goto L27;
        g r104 = r103.next();
    L25:
        th = move-exception;
        j.c(TAG, "Notify offline record completion failed, recordId=" + r101.f477618a, th);
        goto L15
    L18:
        if (ek4.a.a(r100) == false) goto L19;
        if (this.listeners.contains(r104) == false) goto L15;
        r104.a(r101);     // Catch: Throwable -> L25
        goto L15
    L19:
        return;
    L27:
        return;
    L8:
        if (ek4.a.a(r101.f477638u) == false) goto L10;
        r102 = true;
    L28:
        StringBuilder r105 = new StringBuilder("Ignore offline record completion because account changed, recordId=");
        if (r101 != null) goto L31;
        String r106 = null;
    L32:
        r105.append(r106);
        j.d(TAG, r105.toString());
        return;
    L31:
        r106 = r101.f477618a;
        goto L32
    }

    public void notifyRecordFileReady(String r110, com.bytedance.dora.offline.file.b.f r111) {
        if (r111.f204604b == 1) goto L6;
        return;
    L6:
        if (ek4.a.a(r110) == true) goto L9;
        j.d(TAG, "Ignore offline record file ready event because account changed, recordId=" + r111.f204605c);
        return;
    L9:
        j.d(TAG, "Dispatch offline record file ready event, status=" + r111.f204603a + ", recordId=" + r111.f204605c + ", listenerCount=" + this.listeners.size());
        e r100 = new e(r111.f204603a, r111.f204604b, r111.f204605c, r111.f204606d, r111.f204607e, r111.f204608f, r111.f204609g);
        Iterator<g> r112 = this.listeners.iterator();
    L11:
        if (r112.hasNext() == false) goto L23;
        g r101 = r112.next();
    L21:
        th = move-exception;
        j.c(TAG, "Notify offline record file ready failed, recordId=" + r100.f477642c, th);
        goto L11
    L14:
        if (ek4.a.a(r110) == false) goto L15;
        if (this.listeners.contains(r101) == false) goto L11;
        j.d(TAG, "Invoke offline record file ready listener, listener=" + r101.getClass().getSimpleName());     // Catch: Throwable -> L21
        r101.c(r100);     // Catch: Throwable -> L21
        goto L11
    L15:
        return;
    }

    public void notifyRecordProgress(String r100, OfflineFileBusiness.a r110) {
        if (ek4.a.a(r100) == true) goto L5;
        return;
    L5:
        if (r110.f204497a != 1) goto L32;
        h r101 = new h(r110.f204498b, r110.f204499c, r110.f204500d, r110.f204501e, r110.f204502f);
        Iterator<g> r111 = this.listeners.iterator();
    L9:
        if (r111.hasNext() == false) goto L33;
        g r102 = r111.next();
    L19:
        th = move-exception;
        j.c(TAG, "Notify offline record progress failed, recordId=" + r101.f477647a, th);
        goto L9
    L12:
        if (ek4.a.a(r100) == false) goto L13;
        if (this.listeners.contains(r102) == false) goto L9;
        r102.b(r101);     // Catch: Throwable -> L19
        goto L9
    L13:
        return;
    L33:
        return;
    }

    private boolean deleteRetainedRecordFile(String r100, c r110, String r111) {
        if (ek4.a.a(r100) == true) goto L6;
        j.d(TAG, "Delete offline record file stopped because account changed, recordId=" + r110.f477618a);
        return false;
    L6:
        String r101 = r110.f477620c;
        boolean r102 = true;
        if (r101 != null) goto L9;
    L33:
        return true;
    L9:
        if (r101.length() == 0) goto L33;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101);
        if (r103.exists() == true) goto L15;
        return true;
    L15:
        if (r103.isFile() == true) goto L34;
        j.f(TAG, "Delete offline record failed because path is not a file, recordId=" + r110.f477618a);
        return false;
    L34:
    L30:
        th = move-exception;
        j.c(TAG, "Delete offline record file failed, recordId=" + r110.f477618a + ", reason=" + r111, th);
        return false;
    L19:
        if (ek4.a.a(r100) == true) goto L23;
        j.d(TAG, "Delete offline record file stopped because account changed, recordId=" + r110.f477618a);     // Catch: Throwable -> L30
        return false;
    L23:
        if (r103.delete() == false) goto L25;
    L28:
        j.d(TAG, "Delete offline record file finished, recordId=" + r110.f477618a + ", deleted=" + r102 + ", reason=" + r111);     // Catch: Throwable -> L30
        return r102;
    L25:
        if (r103.exists() == false) goto L28;
        r102 = false;
        goto L28
    }

    public boolean bindContext(int r100, String r110, int r111, String r112) {
        boolean r101 = true;
        if (r100 == 1) goto L6;
        j.f(TAG, "Bind offline record context rejected, businessType=" + r100 + ", expectedBusinessType=1");
        return false;
    L6:
        OfflineFileSyncEngine r102 = this.syncEngine;
        r102.getClass();
        com.bytedance.dora.offline.file.b.r(r110, "uint32");     // Catch: IllegalArgumentException -> L9
        boolean r103 = true;
    L11:
        if (r103 == true) goto L13;
    L34:
        StringBuilder r104 = new StringBuilder("Bind context rejected because fields are invalid, businessType=");
        r104.append(r100);
        r104.append(", contextType=");
        r104.append(r111);
        r104.append(", vuiIdValid=");
        com.bytedance.dora.offline.file.b.r(r110, "uint32");     // Catch: IllegalArgumentException -> L37
        boolean r105 = true;
    L38:
        r104.append(r105);
        r104.append(", contextIdValid=");
        if (com.bytedance.dora.offline.file.b.c(r112) != null) goto L42;
        r101 = false;
    L42:
        r104.append(r101);
        j.f("OfflineFileSyncEngine", r104.toString());
        return false;
    L37:
        r105 = false;
        goto L38
    L13:
        if (com.bytedance.dora.offline.file.b.c(r112) == null) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L34;
        if (r100 < 0) goto L34;
        if (r100 > 255) goto L34;
        if (r111 < 0) goto L34;
        if (r111 > 255) goto L34;
        if (r102.f204524v == true) goto L46;
        j.d("OfflineFileSyncEngine", "Bind context skipped because ability is unsupported");
        return false;
    L46:
        int r113 = r102.B(com.bytedance.dora.offline.file.b.a(r100, r110, r111, r112));     // Catch: Throwable -> L32
        if (r113 == 0) goto L30;
        r101 = false;
    L30:
        j.d("OfflineFileSyncEngine", "Bind context finished, success=" + r101 + ", ret=" + r113 + ", businessType=" + r100 + ", vuiId=" + r110);     // Catch: Throwable -> L32
        return r101;
    L32:
        th = move-exception;
        j.c("OfflineFileSyncEngine", "Bind context failed, businessType=" + r100 + ", vuiId=" + r110, th);
        return false;
    L15:
        r106 = false;
    L9:
        r103 = false;
        goto L11
    }
}
