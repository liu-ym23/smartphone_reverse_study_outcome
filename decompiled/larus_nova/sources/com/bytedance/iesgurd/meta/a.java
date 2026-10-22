package com.bytedance.iesgurd.meta;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.EventSubType;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.utils.GeckoExecutors;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Keva f250764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Keva f250765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, ConcurrentHashMap<String, ChannelMeta>> f250766c = null;

    /* JADX INFO: renamed from: com.bytedance.iesgurd.meta.a$a, reason: collision with other inner class name */
    public static final class RunnableC3569a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RunnableC3569a f250767a = null;

        static {
            f250767a = new RunnableC3569a();
        }

        public RunnableC3569a() {
        }

        public static void a() {
            Keva r100 = a.f250764a;
            GeckoLogger.d("ChannelMetaManager migrateRes");
            a.f250765b = Keva.getRepo("gecko_channel_meta_migrate", 1);
            com.bytedance.geckox.b r101 = com.bytedance.geckox.b.a.f245076a;
            Map<String, String> r102 = GlobalManager.f250635d;
            GlobalManager.f250633b.set(true);
            Iterator r103 = ((ConcurrentHashMap) r102).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L13;
            Map.Entry r104 = (Map.Entry) r103.next();
            if (AppSettingsManager.b.f245071a.a() == false) goto L11;
            GlobalManager.f250642k.a();
            GeckoGlobalConfig r105 = GlobalManager.f250638g;
            if (r105 != null) goto L10;
            Intrinsics.throwNpe();
        L10:
            String r106 = r105.getRootDir();
        L12:
            Keva r107 = a.f250764a;
            a.d((String) r104.getKey(), r106);
            goto L4
        L11:
            r106 = (String) r104.getValue();
            goto L12
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f250768a = null;

        static {
            f250768a = new b();
        }

        public b() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return !StringsKt.endsWith$default(r101, "--pending-delete", false, 2, null);
        }
    }

    static {
        f250766c = new ConcurrentHashMap();
        GeckoLogger.d("ChannelMetaManager init");
        GeckoLogger.d("ChannelMetaManager readCache");
        Keva r100 = Keva.getRepo("gecko_channel_meta_new", 1);
        f250764a = r100;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L5:
        Iterator<Map.Entry<String, ?>> r101 = r100.getAll().entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L57;
        Map.Entry<String, ?> r102 = r101.next();
        ChannelMeta r103 = null;
        if (r102.getKey().length() < 34) goto L10;
        String r104 = r102.getKey();
        if (r104 == null) goto L56;
        int r105 = 0;
        String r106 = r104.substring(0, 32);
        String r107 = r102.getKey();
        if (r107 == null) goto L54;
        String r108 = r107.substring(33);
        String r109 = (String) r102.getValue();
        if (r109 == null) goto L17;
        ChannelMeta.Companion.getClass();
        List r110 = StringsKt.split$default(r109, new String[]{","}, false, 0, 6, null);
        if (r110.isEmpty() == false) goto L21;
    L50:
        if (r103 == null) goto L51;
        g(r106, r108, r103);
        goto L7
    L51:
        GeckoLogger.w("ChannelMetaManager buffer error: ".concat(r109));
        int r111 = y86.a.f566911a;
        y86.a.b(EventSubType.META_PARSE_ERROR, r106, r108, r109);
        goto L7
    L21:
        if ((r110.size() % 2) != 0) goto L50;
        ChannelMeta r112 = new ChannelMeta();     // Catch: Throwable -> L48
        int r113 = r110.size() / 2;     // Catch: Throwable -> L48
    L24:
        if (r105 >= r113) goto L47;
        int r114 = r105 * 2;     // Catch: Throwable -> L48
        String r115 = (String) ListProtector.get(r110, r114 + 1);     // Catch: Throwable -> L48
        if (Intrinsics.areEqual(r115, "null") == true) goto L46;
        String r116 = (String) ListProtector.get(r110, r114);     // Catch: Throwable -> L48
        switch(r116.hashCode()) {
            case -1142019503: goto L44;
            case -295931082: goto L41;
            case 3355: goto L38;
            case 484716992: goto L35;
            case 1503566841: goto L32;
            default: goto L46;
        };     // Catch: Throwable -> L48
    L32:
        if (r116.equals("forbidden") == false) goto L46;
        r112.setForbidden(true);     // Catch: Throwable -> L48
        goto L46
    L35:
        if (r116.equals("isMiniApp") == false) goto L46;
        r112.setMiniApp(Boolean.valueOf(Boolean.parseBoolean(r115)));     // Catch: Throwable -> L48
        goto L46
    L38:
        if (r116.equals("id") == false) goto L46;
        r112.setId(Long.valueOf(CastLongProtector.parseLong(r115)));     // Catch: Throwable -> L48
        goto L46
    L41:
        if (r116.equals(UserInfo.UPDATE_TIME) == false) goto L46;
        r112.setUpdateTime(Long.valueOf(CastLongProtector.parseLong(r115)));     // Catch: Throwable -> L48
        goto L46
    L44:
        if (r116.equals("accessTime") == false) goto L46;
        r112.setAccessTime(Long.valueOf(CastLongProtector.parseLong(r115)));     // Catch: Throwable -> L48
    L46:
        r105 = r105 + 1;
        goto L24
    L47:
        r103 = r112;
    L48:
        th = move-exception;
        GeckoLogger.w("ChannelMeta fromString error", th);
        goto L50
    L17:
        GeckoLogger.w("ChannelMetaManager value error: " + r102.getValue());
        int r117 = y86.a.f566911a;
        y86.a.b(EventSubType.META_PARSE_VALUE_ERROR, r106, r108, String.valueOf(r102.getValue()));
        goto L7
    L54:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L56:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L10:
        GeckoLogger.w("ChannelMetaManager key length error: " + r102.getKey());
        int r118 = y86.a.f566911a;
        y86.a.b(EventSubType.META_PARSE_KEY_ERROR, null, null, r102.getKey());
        goto L7
    L57:
        GeckoLogger.d("ChannelMetaManager readCache finish");
        ((Executor) GeckoExecutors.f250873f.getValue()).execute(RunnableC3569a.f250767a);
    }

    public static Long b(PolarisFileWrapper r100) {
        File[] r101 = r100.listFiles(com.bytedance.iesgurd.meta.b.f250769a);
        Long r102 = null;
        if (r101 == null) goto L19;
        int r103 = 0;
        if (r101.length != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L19;
        int r105 = r101.length;
        long r106 = 0;
    L11:
        if (r103 >= r105) goto L19;
        File r107 = r101[r103];
        String r108 = r107.getName();
        long r109 = new PolarisFileWrapper(r107, "res").lastModified();
        Long r110 = CastLongProtector.valueOf(r108);     // Catch: Exception -> L20
        if (r102 != null) goto L16;
    L17:
        r102 = r110;
        r106 = r109;
        goto L18
    L16:
        if (r109 > r106) goto L17;
    L18:
        r103 = r103 + 1;
        goto L11
    L7:
        r104 = false;
    L19:
        return r102;
    }

    public static ChannelMeta c(String r100, String r101) {
        ConcurrentHashMap r102 = (ConcurrentHashMap) ((ConcurrentHashMap) f250766c).get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (ChannelMeta) r102.get(r101);
    }

    public static void d(String r110, String r111) {
        Keva r100 = f250765b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repoMigrate");
    L5:
        int r101 = 0;
        if (r100.getBoolean(r110, false) == false) goto L8;
        return;
    L8:
        long r102 = System.currentTimeMillis();
        GeckoLogger.d("ChannelMetaManager migrate: " + r110 + " start");
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111, r110);
        String[] r112 = r103.list(b.f250768a);
        if (r112 == null) goto L22;
        int r104 = r112.length;
    L11:
        if (r101 >= r104) goto L22;
        String r105 = r112[r101];
        PolarisFileWrapper r106 = new PolarisFileWrapper(r103, r105);
        if (r106.isDirectory() == false) goto L21;
        Long r107 = b(r106);
        if (r107 == null) goto L21;
        ChannelMeta r113 = c(r110, r105);
        if (r113 != null) goto L20;
        r113 = new ChannelMeta();
    L20:
        r113.setId(r107);
        r113.setUpdateTime(Long.valueOf(r106.lastModified()));
        g(r110, r105, r113);
        f(r110, r105, r113);
    L21:
        r101 = r101 + 1;
    L22:
        long r108 = System.currentTimeMillis() - r102;
        StringBuilder r109 = new StringBuilder("ChannelMetaManager migrate: ");
        r109.append(r110);
        r109.append(" finish, duration: ");
        r109.append(r108);
        r109.append(", size:");
        if (r112 == null) goto L25;
        Integer r114 = Integer.valueOf(r112.length);
    L26:
        r109.append(r114);
        GeckoLogger.d(r109.toString());
        Keva r115 = f250765b;
        if (r115 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("repoMigrate");
    L29:
        r115.storeBoolean(r110, true);
        return;
    L25:
        r114 = null;
        goto L26
    }

    public static void e(String r100, String r101) {
        GeckoLogger.d("ChannelMetaManager removeChannel " + r100 + '@' + r101);
        ConcurrentHashMap r102 = (ConcurrentHashMap) ((ConcurrentHashMap) f250766c).get(r100);
        if (r102 == null) goto L5;
        ChannelMeta r103 = (ChannelMeta) r102.remove(r101);
    L5:
        Keva r104 = f250764a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L8:
        r104.erase(r100 + '@' + r101);
    }

    public static void f(String r100, String r101, ChannelMeta r102) {
        Keva r103 = f250764a;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("repo");
    L5:
        r103.storeString(r100 + '@' + r101, r102.toString());
    }

    public static void g(String r100, String r101, ChannelMeta r102) {
        ConcurrentHashMap r103 = (ConcurrentHashMap) f250766c;
        if (r103.get(r100) != null) goto L14;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r103.get(r100) != null) goto L8;
        r103.put(r100, new ConcurrentHashMap());     // Catch: Throwable -> L11
    L8:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r103);
    L14:
        Object r105 = r103.get(r100);
        if (r105 != null) goto L17;
        Intrinsics.throwNpe();
    L17:
        ((Map) r105).put(r101, r102);
    }

    public static Long a(String r110, String r111, ChannelMeta r112, String r113) {
        if (r112.getId() != null) goto L5;
        return null;
    L5:
        AtomicBoolean r100 = GlobalManager.f250632a;
        String r101 = GlobalManager.b(r110);
        if (r101 == null) goto L38;
        PolarisFileWrapper r102 = new PolarisFileWrapper(new PolarisFileWrapper(r101, r110), r111);
        if (r102.exists() == true) goto L20;
        EventSubType r103 = EventSubType.META_CHANNEL_FILE_NOT_EXIST;
        String r114 = String.valueOf(r112.getId());
        JSONObject r104 = new JSONObject();
        r104.put("sub_type", r103.getType());
        if (r110 == null) goto L12;
        r104.put("access_key", r110);
    L12:
        if (r111 == null) goto L14;
        r104.put("channels", r111);
    L14:
        r104.put(LocationMonitorConst.ERR_MSG, r114);
        if (r113 == null) goto L17;
        r104.put("extra", r113);
    L17:
        y86.a.c("geckosdk_event_message", r104);
        e(r110, r111);
        return null;
    L20:
        if (new PolarisFileWrapper(r102, String.valueOf(r112.getId())).exists() == true) goto L36;
        Long r105 = b(r102);
        EventSubType r106 = EventSubType.META_VERSION_FILE_NOT_EXIST;
        StringBuilder r107 = new StringBuilder();
        r107.append(r112.getId());
        r107.append('-');
        r107.append(r105);
        String r108 = r107.toString();
        JSONObject r109 = new JSONObject();
        r109.put("sub_type", r106.getType());
        if (r110 == null) goto L24;
        r109.put("access_key", r110);
    L24:
        if (r111 == null) goto L26;
        r109.put("channels", r111);
    L26:
        if (r108 == null) goto L28;
        r109.put(LocationMonitorConst.ERR_MSG, r108);
    L28:
        if (r113 == null) goto L30;
        r109.put("extra", r113);
    L30:
        y86.a.c("geckosdk_event_message", r109);
        if (r105 == null) goto L33;
        r112.setId(r105);
        f(r110, r111, r112);
    L34:
        return r105;
    L33:
        e(r110, r111);
        goto L34
    L36:
        return r112.getId();
    L38:
        return r112.getId();
    }
}
