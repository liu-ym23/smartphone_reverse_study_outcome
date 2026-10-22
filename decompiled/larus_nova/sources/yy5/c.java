package yy5;

import android.os.Looper;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.meta.MetaDataItem;
import com.bytedance.geckox.policy.meta.MetaDataItemNew;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import ez5.f;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ConcurrentHashMap<String, MetaDataItemNew>> f569477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, File> f569478b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Boolean> f569479c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final dz5.b f569480d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Looper f569481e = null;

    static {
        f569477a = new ConcurrentHashMap();
        f569478b = new ConcurrentHashMap();
        f569479c = new ConcurrentHashMap();
        f569480d = new dz5.b("meta-timer-task");
        f569481e = Looper.getMainLooper();
    }

    public static void j() {
        Iterator r100 = ((ConcurrentHashMap) f569479c).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L25;
        Map.Entry r101 = (Map.Entry) r100.next();
        String r102 = (String) r101.getKey();
        if (((Boolean) r101.getValue()).booleanValue() == false) goto L4;
        Map<String, ConcurrentHashMap<String, MetaDataItemNew>> r103 = f569477a;
        if (((ConcurrentHashMap) r103).get(r102) == null) goto L4;
        ((ConcurrentHashMap) f569479c).put(r102, Boolean.FALSE);
        if (a(r102) == true) goto L13;
        d(r102);     // Catch: Throwable -> L18
    L13:
        ObjectOutputStream r104 = new ObjectOutputStream(new PolarisFileOutputStreamWrapper((File) ((ConcurrentHashMap) f569478b).get(r102)));     // Catch: Throwable -> L18
        r104.writeObject(((ConcurrentHashMap) r103).get(r102));     // Catch: Throwable -> L16
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L16
        AtomicBoolean r106 = GlobalManager.f250632a;     // Catch: Throwable -> L16
        r105.append(GlobalManager.b(r102));     // Catch: Throwable -> L16
        String r107 = File.separator;     // Catch: Throwable -> L16
        r105.append(r107);     // Catch: Throwable -> L16
        r105.append(r102);     // Catch: Throwable -> L16
        r105.append(r107);     // Catch: Throwable -> L16
        r105.append("metaData.json");     // Catch: Throwable -> L16
        ez5.c.delete(new PolarisFileWrapper(r105.toString()));     // Catch: Throwable -> L16
    L21:
        ez5.b.a(r104);
    L16:
        th = th;
    L28:
        GeckoLogger.d("MetaDataManager: writeToMetaData occurs exception: " + th.getMessage());     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        ez5.b.a(r104);
        throw th;
    L18:
        th = th;
        r104 = null;
        goto L28
    }

    public static boolean a(String r100) {
        ConcurrentHashMap r101 = (ConcurrentHashMap) f569478b;
        if (((File) r101.get(r100)) == null) goto L5;
        return true;
    L5:
        StringBuilder r102 = new StringBuilder();
        AtomicBoolean r103 = GlobalManager.f250632a;
        r102.append(GlobalManager.b(r100));
        String r104 = File.separator;
        r102.append(r104);
        r102.append(r100);
        r102.append(r104);
        r102.append("metaDataNew.json");
        PolarisFileWrapper r105 = new PolarisFileWrapper(r102.toString());
        if (r105.exists() == false) goto L8;
        r101.put(r100, r105);
        return true;
    L8:
        return false;
    }

    public static void d(String r100) {
        StringBuilder r101 = new StringBuilder();
        AtomicBoolean r102 = GlobalManager.f250632a;
        r101.append(GlobalManager.b(r100));
        String r103 = File.separator;
        r101.append(r103);
        r101.append(r100);
        r101.append(r103);
        r101.append("metaDataNew.json");
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101.toString());
        File r105 = r104.getParentFile();
        if (r105.exists() == true) goto L5;
        r105.mkdirs();
    L5:
        r104.createNewFile();
        ((ConcurrentHashMap) f569478b).put(r100, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.StringBuilder] */
    public static ConcurrentHashMap e(String r110) {
        AppSettingsManager r100 = AppSettingsManager.b.f245071a;
        Map<String, String> r101 = r100.f245060a;
        ?? r102 = 0;
        Object r103 = null;
        Object r104 = null;
        if (r101 == null) goto L93;
        Set<String> r105 = r101.keySet();
        if (r105 == null) goto L93;
        if (r105.contains(r110) != true) goto L93;
        AtomicBoolean r106 = GlobalManager.f250632a;
        ?? r107 = GlobalManager.b(r110);
        if (r107 == 0) goto L93;
        Map<String, ConcurrentHashMap<String, MetaDataItemNew>> r108 = f569477a;
        ConcurrentHashMap r109 = (ConcurrentHashMap) r108;
        if (r109.get(r110) != null) goto L92;
        if (Intrinsics.areEqual(Looper.myLooper(), f569481e) == false) goto L16;
        return null;
    L16:
        monitor-enter(r108);
    L88:
        th = move-exception;
        throw th;
    L96:
        if (((ConcurrentHashMap) r108).get(r110) == null) goto L94;
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L88
        monitor-exit(r108);
        goto L92
    L94:
    L76:
        e = e;
    L77:
        int r112 = y86.a.f566911a;     // Catch: Throwable -> L74
        y86.a.a(EventSubType.BLOCK_IO_ERROR, e.getMessage(), "");     // Catch: Throwable -> L74
        ConcurrentHashMap r113 = f(r110);     // Catch: Throwable -> L74
        ez5.b.a(r102);     // Catch: Throwable -> L88
        ConcurrentHashMap r114 = r113;
    L80:
        monitor-exit(r108);
        return r114;
    L97:
        if (a(r110) == false) goto L51;
        Object r115 = ((ConcurrentHashMap) f569478b).get(r110);     // Catch: Throwable -> L74 Exception -> L76
        if (r115 != null) goto L24;
        Intrinsics.throwNpe();     // Catch: Throwable -> L74 Exception -> L76
    L24:
        ObjectInputStream r116 = new ObjectInputStream(new PolarisFileInputStreamWrapper((File) r115));     // Catch: Throwable -> L74 Exception -> L76
        Object r117 = r116.readObject();     // Catch: Throwable -> L47 Exception -> L49
        if ((r117 instanceof ConcurrentHashMap) == false) goto L29;
        r103 = r117;
    L29:
        r114 = (ConcurrentHashMap) r103;     // Catch: Throwable -> L47 Exception -> L49
        if (r114 != null) goto L32;
        r114 = f(r110);     // Catch: Throwable -> L47 Exception -> L49
    L45:
        ((ConcurrentHashMap) f569477a).put(r110, r114);     // Catch: Throwable -> L47 Exception -> L49
    L72:
        ez5.b.a(r116);     // Catch: Throwable -> L88
        goto L80
    L32:
        Map<String, ArrayList<String>> r118 = r100.f245061b;     // Catch: Throwable -> L47 Exception -> L49
        if (r118 == null) goto L45;
        if (r118.get(r110) == null) goto L45;
        long r119 = System.currentTimeMillis();     // Catch: Throwable -> L47 Exception -> L49
        ArrayList<String> r120 = r118.get(r110);     // Catch: Throwable -> L47 Exception -> L49
        if (r120 != null) goto L39;
        Intrinsics.throwNpe();     // Catch: Throwable -> L47 Exception -> L49
    L39:
        Iterator<String> r121 = r120.iterator();     // Catch: Throwable -> L47 Exception -> L49
    L41:
        if (r121.hasNext() == false) goto L45;
        String r122 = r121.next();     // Catch: Throwable -> L47 Exception -> L49
        if (r114.get(r122) != null) goto L41;
        Iterator<String> r123 = r121;
        r114.put(r122, new MetaDataItemNew(r119, false, 0, 6, null));     // Catch: Throwable -> L47 Exception -> L49
        ((ConcurrentHashMap) f569479c).put(r110, Boolean.TRUE);     // Catch: Throwable -> L47 Exception -> L49
        r121 = r123;
        goto L41
    L51:
        ?? r124 = new StringBuilder();     // Catch: Throwable -> L74 Exception -> L76
        r124.append(r107);     // Catch: Throwable -> L74 Exception -> L76
        String r125 = File.separator;     // Catch: Throwable -> L74 Exception -> L76
        r124.append(r125);     // Catch: Throwable -> L74 Exception -> L76
        r124.append(r110);     // Catch: Throwable -> L74 Exception -> L76
        r124.append(r125);     // Catch: Throwable -> L74 Exception -> L76
        r124.append("metaData.json");     // Catch: Throwable -> L74 Exception -> L76
        PolarisFileWrapper r126 = new PolarisFileWrapper(r124.toString());     // Catch: Throwable -> L74 Exception -> L76
        if (r126.exists() == false) goto L69;
        int r127 = y86.a.f566911a;     // Catch: Throwable -> L74 Exception -> L76
        y86.a.a(EventSubType.META_DATA_MOVE, r110, "");     // Catch: Throwable -> L74 Exception -> L76
        r116 = new ObjectInputStream(new PolarisFileInputStreamWrapper(r126));     // Catch: Throwable -> L74 Exception -> L76
        ConcurrentHashMap r128 = new ConcurrentHashMap();     // Catch: Throwable -> L47 Exception -> L49
        ((ConcurrentHashMap) r108).put(r110, r128);     // Catch: Throwable -> L47 Exception -> L49
        Object r129 = r116.readObject();     // Catch: Throwable -> L47 Exception -> L49
        if ((r129 instanceof ConcurrentHashMap) == false) goto L58;
        r104 = r129;
    L58:
        ConcurrentHashMap r130 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L47 Exception -> L49
        if (r130 == null) goto L65;
        Iterator r131 = r130.entrySet().iterator();     // Catch: Throwable -> L47 Exception -> L49
    L62:
        if (r131.hasNext() == false) goto L64;
        Map.Entry r132 = (Map.Entry) r131.next();     // Catch: Throwable -> L47 Exception -> L49
        String r133 = (String) r132.getKey();     // Catch: Throwable -> L47 Exception -> L49
        MetaDataItem r134 = (MetaDataItem) r132.getValue();     // Catch: Throwable -> L47 Exception -> L49
        r128.put(r133, new MetaDataItemNew(r134.getLastReadTimeStamp(), r134.getAllowUpdate(), 0, 4, null));     // Catch: Throwable -> L47 Exception -> L49
        goto L62
    L64:
        ((ConcurrentHashMap) f569479c).put(r110, Boolean.TRUE);     // Catch: Throwable -> L47 Exception -> L49
        j();     // Catch: Throwable -> L47 Exception -> L49
    L71:
        r114 = r128;
        goto L72
    L65:
        ConcurrentHashMap r135 = f(r110);     // Catch: Throwable -> L47 Exception -> L49
        ez5.b.a(r116);     // Catch: Throwable -> L88
        monitor-exit(r108);
        return r135;
    L69:
        r128 = f(r110);     // Catch: Throwable -> L74 Exception -> L76
        r116 = null;
    L49:
        e = e;
        r102 = r107;
    L47:
        th = th;
    L83:
        ez5.b.a(r107);     // Catch: Throwable -> L88
        throw th;     // Catch: Throwable -> L88
    L74:
        th = th;
        r107 = 0;
    L92:
        return (ConcurrentHashMap) r109.get(r110);
    L93:
        return null;
    }

    public static ConcurrentHashMap f(String r110) {
        ez5.c.delete((File) ((ConcurrentHashMap) f569478b).get(r110));
        StringBuilder r100 = new StringBuilder();
        AtomicBoolean r101 = GlobalManager.f250632a;
        r100.append(GlobalManager.b(r110));
        String r102 = File.separator;
        r100.append(r102);
        r100.append(r110);
        r100.append(r102);
        r100.append("metaData.json");
        ez5.c.delete(new PolarisFileWrapper(r100.toString()));
        Map<String, ArrayList<String>> r103 = AppSettingsManager.b.f245071a.f245061b;
        ConcurrentHashMap r104 = new ConcurrentHashMap();
        ((ConcurrentHashMap) f569477a).put(r110, r104);
        if (r103 != null) goto L5;
    L14:
        return r104;
    L5:
        if (r103.get(r110) == null) goto L14;
        long r111 = System.currentTimeMillis();
        ArrayList<String> r105 = r103.get(r110);
        if (r105 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        Iterator<String> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L13;
        r104.put(r106.next(), new MetaDataItemNew(r111, false, 0, 6, null));
        goto L11
    L13:
        Map<String, Boolean> r107 = f569479c;
        ConcurrentHashMap r108 = (ConcurrentHashMap) r107;
        r108.put(r110, Boolean.TRUE);
        goto L14
    }

    public static boolean g(String r100, String r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L27;
        if (r101 != null) goto L12;
    L15:
        boolean r103 = true;
    L16:
        if (r103 == true) goto L27;
        ConcurrentHashMap r104 = e(r100);
        if (r104 == null) goto L27;
        MetaDataItemNew r105 = (MetaDataItemNew) r104.get(r101);
        if (r105 != null) goto L23;
    L25:
        return false;
    L23:
        if (r105.getAllowUpdate() == true) goto L25;
        return true;
    L12:
        if (r101.length() == 0) goto L15;
        r103 = false;
    L27:
        return false;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static void h(String r100, String r101) {
        ConcurrentHashMap r102 = e(r100);
        if (r102 == null) goto L10;
        MetaDataItemNew r103 = (MetaDataItemNew) r102.get(r101);
        if (r103 != null) goto L7;
        return;
    L7:
        if (r103.getAllowUpdate() == true) goto L12;
        r103.setAllowUpdate(true);
        Map<String, Boolean> r104 = f569479c;
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;
        r105.put(r100, Boolean.TRUE);
        return;
    L12:
        return;
    }

    public static Pair i(String r100, String r101, long r102) {
        ConcurrentHashMap r103 = e(r100);
        long r104 = 0;
        if (r103 == null) goto L16;
        MetaDataItemNew r105 = (MetaDataItemNew) r103.get(r101);
        if (r105 == null) goto L14;
        r105.setLastReadTimeStamp(r102);
        ((ConcurrentHashMap) f569479c).put(r100, Boolean.TRUE);
        boolean r106 = !r105.getAllowUpdate();
        if (r106 == false) goto L12;
        if (r105.getLastCleanTimeStamp() <= 0) goto L12;
        r104 = r102 - r105.getLastCleanTimeStamp();
    L12:
        return new Pair(Boolean.valueOf(r106), Long.valueOf(r104));
    L14:
        return new Pair(Boolean.FALSE, 0L);
    L16:
        return new Pair(Boolean.FALSE, 0L);
    }

    public static long b(String r110, boolean r111, int r112, int r113) {
        long r100 = System.currentTimeMillis();
        if (r110 != null) goto L9;
        Iterator r114 = ((ConcurrentHashMap) f569477a).entrySet().iterator();
        long r101 = 0;
    L6:
        if (r114.hasNext() == false) goto L14;
        Map.Entry r102 = (Map.Entry) r114.next();
        r101 = r101 + c((String) r102.getKey(), (ConcurrentHashMap) r102.getValue(), r100, r111, r112, r113);
        goto L6
    L14:
        return r101;
    L9:
        ConcurrentHashMap r103 = (ConcurrentHashMap) ((ConcurrentHashMap) f569477a).get(r110);
        if (r103 != null) goto L12;
        return 0;
    L12:
        return c(r110, r103, r100, r111, r112, r113);
    }

    public static long c(String r210, Map r211, long r212, boolean r213, int r214, int r215) {
        long r100 = 60;
        long r110 = (((((long) r214) * ((long) 24)) * r100) * r100) * ((long) 1000);
        AtomicBoolean r101 = GlobalManager.f250632a;
        String r102 = GlobalManager.b(r210);
        if (r102 == null) goto L31;
        String r103 = r102 + File.separator + r210;
        Iterator r111 = r211.entrySet().iterator();
        long r104 = 0;
    L6:
        if (r111.hasNext() == false) goto L30;
        Map.Entry r105 = (Map.Entry) r111.next();
        String r106 = (String) r105.getKey();
        MetaDataItemNew r107 = (MetaDataItemNew) r105.getValue();
        if ((r212 - r107.getLastReadTimeStamp()) < r110) goto L28;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r103, r106);
        if (r108.exists() == false) goto L28;
        long r112 = r104 + ez5.c.d(r108);
        if (r213 == false) goto L27;
        long r109 = System.currentTimeMillis();
        boolean r113 = false;
        r107.setAllowUpdate(false);
        r107.setLastCleanTimeStamp(r109);
        ((ConcurrentHashMap) f569479c).put(r210, Boolean.TRUE);
        com.bytedance.iesgurd.meta.a.e(r210, r106);
        Long r114 = f.b(r108);
        int r115 = x86.a.f562912a;
        String r116 = r108.getAbsolutePath();
        if (vy5.b.e(r116) == false) goto L18;
        r113 = ez5.c.delete(new PolarisFileWrapper(r116));
        vy5.b.f(r116);
    L18:
        if (r113 == false) goto L20;
        int r117 = 202;
    L21:
        CleanStrategy r118 = CleanStrategy.EXPIRE_TIME;
        if (r114 == null) goto L24;
        long r119 = r114.longValue();
    L25:
        new z86.a(r118, r215, r210, r106, r119, r117, r214, AppSettingsManager.b.f245071a.f245060a.get(r210)).a();
        x86.a.a(r210, r106);
        goto L27
    L24:
        r119 = 0;
        goto L25
    L20:
        r117 = 203;
    L27:
        r104 = r112;
    L29:
        r103 = r103;
    L28:
        r103 = r103;
        goto L29
    L30:
        return r104;
    L31:
        return 0;
    }
}
