package v98;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f553837a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f553838b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f553839c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, l> f553840d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f553841e;

    public static final class a {
        public static void b() {
            Collection<l> r100 = r.f553840d.values();
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L3:
            boolean r103 = true;
            if (r102.hasNext() == false) goto L12;
            Object r104 = r102.next();
            l r105 = (l) r104;
            long r106 = TimeUnit.DAYS.toMillis(7);
            r105.getClass();
            if ((System.currentTimeMillis() - r105.f553833d) > r106) goto L9;
            r103 = false;
        L9:
            if (r103 == false) goto L3;
            r101.add(r104);
            goto L3
        L12:
            if ((!r101.isEmpty()) == false) goto L18;
            FLogger.f375446a.i("StoragePolicyManager", "Found " + r101.size() + " expired files, cleaning up...");
            Iterator r107 = r101.iterator();
        L15:
            if (r107.hasNext() == false) goto L17;
            d((l) r107.next());
            goto L15
        L17:
            FLogger.f375446a.i("StoragePolicyManager", "Cleanup completed. Removed " + r101.size() + " expired files");
        L18:
            long r108 = e();
            long r109 = r.f553838b;
            if (r108 <= r109) goto L42;
            FLogger r110 = FLogger.f375446a;
            StringBuilder r111 = new StringBuilder("Storage limit exceeded: ");
            long r112 = 1024;
            r111.append((r108 / r112) / r112);
            r111.append("MB / ");
            r111.append((r109 / r112) / r112);
            r111.append("MB");
            r110.w("StoragePolicyManager", r111.toString());
            List r113 = CollectionsKt.sortedWith(r.f553840d.values(), new q());
            ArrayList r114 = new ArrayList();
            Iterator r115 = r113.iterator();
            long r116 = 0;
        L23:
            if (r115.hasNext() == false) goto L26;
            l r117 = (l) r115.next();
            r114.add(r117);
            r116 = r116 + r117.f553832c;
            if (r116 < r.f553839c) goto L23;
        L26:
            FLogger.f375446a.i("StoragePolicyManager", "Will delete " + r114.size() + " oldest files to free " + ((r116 / r112) / r112) + "MB");
            Iterator r118 = r114.iterator();
        L28:
            if (r118.hasNext() == false) goto L30;
            d((l) r118.next());
            goto L28
        L30:
            long r119 = e();
            FLogger.f375446a.i("StoragePolicyManager", "Cleanup completed. New storage size: " + ((r119 / r112) / r112) + "MB");
            return;
        }

        public static void c() {
            PolarisFileWrapper r100 = new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "zip_exports");     // Catch: Exception -> L20
            if (r100.exists() == true) goto L6;
            return;
        L6:
            File[] r101 = r100.listFiles();     // Catch: Exception -> L20
            int r102 = 0;
            long r103 = 0;
            if (r101 == null) goto L17;
            int r104 = r101.length;     // Catch: Exception -> L20
            long r105 = 0;
            int r106 = 0;
        L9:
            if (r102 >= r104) goto L16;
            File r107 = r101[r102];     // Catch: Exception -> L20
            if (r107.isFile() == false) goto L15;
            long r108 = r107.length();     // Catch: Exception -> L20
            if (r107.delete() == false) goto L15;
            r106 = r106 + 1;     // Catch: Exception -> L20
            r105 = r105 + r108;     // Catch: Exception -> L20
            FLogger r110 = FLogger.f375446a;     // Catch: Exception -> L20
            StringBuilder r111 = new StringBuilder();     // Catch: Exception -> L20
            r111.append("Cleaned up ZIP file: ");     // Catch: Exception -> L20
            r111.append(r107.getName());     // Catch: Exception -> L20
            r111.append(" (");     // Catch: Exception -> L20
            long r112 = 1024;
            r111.append((r108 / r112) / r112);     // Catch: Exception -> L20
            r111.append("MB)");     // Catch: Exception -> L20
            r110.i("StoragePolicyManager", r111.toString());     // Catch: Exception -> L20
        L15:
            r102 = r102 + 1;     // Catch: Exception -> L20
            goto L9
        L16:
            r102 = r106;
            r103 = r105;
        L17:
            if (r102 <= 0) goto L29;
            FLogger r109 = FLogger.f375446a;     // Catch: Exception -> L20
            StringBuilder r113 = new StringBuilder();     // Catch: Exception -> L20
            r113.append("Cleaned up ");     // Catch: Exception -> L20
            r113.append(r102);     // Catch: Exception -> L20
            r113.append(" ZIP files, freed ");     // Catch: Exception -> L20
            long r114 = 1024;
            r113.append((r103 / r114) / r114);     // Catch: Exception -> L20
            r113.append("MB");     // Catch: Exception -> L20
            r109.i("StoragePolicyManager", r113.toString());     // Catch: Exception -> L20
            return;
        L29:
            return;
        L20:
            e = move-exception;
            FLogger.f375446a.e("StoragePolicyManager", "Error cleaning up ZIP files: " + e.getMessage(), e);
        }

        public static long e() {
            Iterator<T> r100 = r.f553840d.values().iterator();
            long r101 = 0;
        L4:
            if (r100.hasNext() == false) goto L6;
            r101 = r101 + ((l) r100.next()).f553832c;
            goto L4
        L6:
            return r101;
        }

        public static void g() {
            PolarisFileWrapper r100 = new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "dump_files_storage_info.json");     // Catch: Exception -> L12
            if (r100.exists() == true) goto L7;
            FLogger.f375446a.i("StoragePolicyManager", "No existing storage info file found");     // Catch: Exception -> L12
            return;
        L7:
            JSONArray r101 = new JSONArray(FilesKt.readText$default(r100, null, 1, null));     // Catch: Exception -> L12
            int r102 = r101.length();     // Catch: Exception -> L12
            int r103 = 0;
            int r104 = 0;
        L8:
            if (r103 >= r102) goto L10;
            JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r101, r103);     // Catch: Exception -> L12
            l r110 = new l(r105.optString("filePath"), r105.optString("fileName"), r105.optLong("sizeBytes"), r105.optLong("creationTime"));     // Catch: Exception -> L12
            r.f553840d.put(r110.f553830a, r110);     // Catch: Exception -> L12
            r104 = r104 + 1;     // Catch: Exception -> L12
            r103 = r103 + 1;     // Catch: Exception -> L12
            goto L8
        L10:
            FLogger.f375446a.i("StoragePolicyManager", "Loaded " + r104 + " file info entries from disk");     // Catch: Exception -> L12
            return;
        L12:
            e = move-exception;
            FLogger.f375446a.e("StoragePolicyManager", "Failed to load file info from disk: " + e.getMessage(), e);
        }

        public static void h() {
            JSONArray r100 = new JSONArray();     // Catch: Exception -> L9
            Iterator<l> r101 = r.f553840d.values().iterator();     // Catch: Exception -> L9
        L5:
            if (r101.hasNext() == false) goto L7;
            l r102 = r101.next();     // Catch: Exception -> L9
            JSONObject r103 = new JSONObject();     // Catch: Exception -> L9
            r103.put("filePath", r102.f553830a);     // Catch: Exception -> L9
            r103.put("fileName", r102.f553831b);     // Catch: Exception -> L9
            r103.put("sizeBytes", r102.f553832c);     // Catch: Exception -> L9
            r103.put("creationTime", r102.f553833d);     // Catch: Exception -> L9
            r100.put(r103);     // Catch: Exception -> L9
            goto L5
        L7:
            FilesKt.writeText$default(new PolarisFileWrapper(AppHost.f326268a.getApplication().getFilesDir(), "dump_files_storage_info.json"), r100.toString(), null, 2, null);     // Catch: Exception -> L9
            FLogger.f375446a.d("StoragePolicyManager", "Saved " + r.f553840d.size() + " file info entries to disk");     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            FLogger.f375446a.e("StoragePolicyManager", "Failed to save file info to disk: " + e.getMessage(), e);
        }

        public static void i() {
            ArrayList r100 = new ArrayList();
            Iterator<Map.Entry<String, l>> r101 = r.f553840d.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            Map.Entry<String, l> r102 = r101.next();
            String r103 = r102.getKey();
            l r104 = r102.getValue();
            if (new PolarisFileWrapper(r103).exists() == true) goto L4;
            r100.add(r103);
            FLogger.f375446a.w("StoragePolicyManager", "File no longer exists: " + r104.f553831b);
            goto L4
        L8:
            Iterator r105 = r100.iterator();
        L10:
            if (r105.hasNext() == false) goto L13;
            r.f553840d.remove((String) r105.next());
            goto L10
        L13:
            if ((!r100.isEmpty()) == false) goto L22;
            FLogger.f375446a.i("StoragePolicyManager", "Removed " + r100.size() + " non-existent file records");
            h();
            return;
        }

        public final void f() {
            if (r.f553841e == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L7:
            if (r.f553841e == false) goto L10;
            monitor-exit(this);
            return;
        L10:
            FLogger r100 = FLogger.f375446a;     // Catch: Throwable -> L13
            r100.i("StoragePolicyManager", "Initializing StoragePolicyManager...");     // Catch: Throwable -> L13
            a r101 = r.f553837a;     // Catch: Throwable -> L13
            g();     // Catch: Throwable -> L13
            i();     // Catch: Throwable -> L13
            c();     // Catch: Throwable -> L13
            r.f553841e = true;     // Catch: Throwable -> L13
            long r102 = e();     // Catch: Throwable -> L13
            int r103 = r.f553840d.size();     // Catch: Throwable -> L13
            long r104 = r.f553838b;     // Catch: Throwable -> L13
            long r105 = (((long) 100) * r102) / r104;     // Catch: Throwable -> L13
            long r106 = 1024;
            long r107 = (r104 / r106) / r106;     // Catch: Throwable -> L13
            r100.i("StoragePolicyManager", "StoragePolicyManager initialized. Files: " + r103 + ", Size: " + ((r102 / r106) / r106) + "MB");     // Catch: Throwable -> L13
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(this);
        }

        public a() {
        }

        public static void d(l r100) {
            PolarisFileWrapper r101 = new PolarisFileWrapper(r100.f553830a);     // Catch: Exception -> L12
            if (r101.exists() == true) goto L6;
            r.f553840d.remove(r100.f553830a);     // Catch: Exception -> L12
            FLogger.f375446a.d("StoragePolicyManager", "File no longer exists, removed from management: " + r100.f553830a);     // Catch: Exception -> L12
        L10:
            h();     // Catch: Exception -> L12
            return;
        L6:
            if (r101.delete() == false) goto L8;
            r.f553840d.remove(r100.f553830a);     // Catch: Exception -> L12
            FLogger.f375446a.d("StoragePolicyManager", "Deleted file: " + r100.f553831b);     // Catch: Exception -> L12
            goto L10
        L8:
            FLogger.f375446a.w("StoragePolicyManager", "Failed to delete file: " + r100.f553830a);     // Catch: Exception -> L12
        L12:
            e = move-exception;
            FLogger.f375446a.e("StoragePolicyManager", "Error deleting file " + r100.f553830a + ": " + e.getMessage(), e);
        }

        public final void a(String r100, String r110, long r111) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            Intrinsics.checkNotNullParameter(r110, "fileName");
            f();
            r.f553840d.put(r100, new l(r100, r110, r111, System.currentTimeMillis()));
            FLogger.f375446a.d("StoragePolicyManager", "Added file to storage management: " + r110 + " (" + r111 + " bytes)");
            h();
            b();
        }
    }

    static {
        f553837a = new a();
        AppHost.Companion r100 = AppHost.f326268a;
        long r101 = 20971520;
        if (r100.isTestChannel() == false) goto L5;
        long r102 = 3221225472L;
    L6:
        f553838b = r102;
        if (r100.isTestChannel() == false) goto L9;
        r101 = 209715200;
    L9:
        f553839c = r101;
        f553840d = new ConcurrentHashMap();
        return;
    L5:
        r102 = 20971520;
        goto L6
    }
}
