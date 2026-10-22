package com.ss.android.ttve.nativePort;

import android.content.Context;
import com.bef.effectsdk.EffectSDKBuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.tecommonenvinitializer.MultiMediaEnv;
import com.ss.android.tecommonenvinitializer.MultiMediaEnvContext$HostBuildType;
import com.ss.android.vesdk.runtime.VESafelyLibsLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes38.dex */
public class TENativeLibsLoader {
    private static final String TAG = null;
    private static boolean isLibraryLoadedOpt;
    private static c mLibraryHooker;
    private static d mLibraryLoader;
    private static Context sContext;
    private static c sDefaultLibraryHooker;
    private static d sDefaultLibraryLoader;
    private static List<String> sEffectLibs;
    private static boolean sIsSegmentalLoad;
    private static volatile LoadStatus sLibraryLoadStatus;
    private static ArrayList<e> sLibraryReferenceList;
    private static boolean sLoadOptLibrary;

    public static final enum LoadStatus extends Enum<LoadStatus> {
        public static final LoadStatus LOADED = null;
        public static final LoadStatus LOADING = null;
        public static final LoadStatus NOT_LOAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadStatus[] f449961a = null;

        static {
            LoadStatus r100 = new LoadStatus("NOT_LOAD", 0);
            NOT_LOAD = r100;
            LoadStatus r101 = new LoadStatus("LOADING", 1);
            LOADING = r101;
            LoadStatus r102 = new LoadStatus("LOADED", 2);
            LOADED = r102;
            f449961a = new LoadStatus[]{r100, r101, r102};
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) f449961a.clone();
        }

        public static LoadStatus valueOf(String r100) {
            return (LoadStatus) r27.a.a(LoadStatus.class, r100);
        }

        public LoadStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a implements c {
        public a() {
        }
    }

    public static class b implements d {
        public b() {
        }

        @Override // com.ss.android.ttve.nativePort.TENativeLibsLoader.d
        public final boolean onLoadNativeLibs(List<String> r100) {
            TENativeLibsLoader.access$000();
            qgc.a.a(4, "Load library start...");
            long r101 = System.currentTimeMillis();
            Iterator<String> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            String r103 = r102.next();
            System.currentTimeMillis();
            qgc.a.a(3, "Start loadLibrary " + r103);
            if (VESafelyLibsLoader.loadLibrary(r103, TENativeLibsLoader.access$100()) == false) goto L7;
            long r104 = System.currentTimeMillis();
            TENativeLibsLoader.access$000();
            qgc.a.a(4, "Load " + r103 + " cost " + (r104 - r101) + "ms");
            TENativeLibsLoader.access$000();
            System.currentTimeMillis();
            r101 = r104;
            goto L4
        L7:
            TENativeLibsLoader.access$000();
            qgc.a.a(4, "loadLibrary " + r103 + " failed");
            return false;
        L10:
            return true;
        }
    }

    public interface c {
    }

    public interface d {
        boolean onLoadNativeLibs(List<String> r100);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f449962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f449963b;

        public e(String r100) {
            this.f449963b = false;
            this.f449962a = r100;
            this.f449963b = false;
        }
    }

    public TENativeLibsLoader() {
    }

    public static /* synthetic */ boolean a(d r100, List r101) {
        return lambda$loadLibrary$1(r100, r101);
    }

    public static /* synthetic */ Boolean b(d r100, List r101) {
        return lambda$loadLibrary$0(r100, r101);
    }

    static {
        sLibraryLoadStatus = LoadStatus.NOT_LOAD;
        sIsSegmentalLoad = false;
        TAG = "TENativeLibsLoader";
        mLibraryLoader = null;
        mLibraryHooker = null;
        sDefaultLibraryLoader = new b();
        sDefaultLibraryHooker = new a();
        sLibraryReferenceList = new ArrayList();
        sEffectLibs = EffectSDKBuildConfig.getEffectLibs();
        isLibraryLoadedOpt = false;
        sLoadOptLibrary = false;
    }

    public static List<String> getAllLibsList() {
        ArrayList r100 = new ArrayList();
        r100.add("c++_shared");
        r100.add("iesapplogger");
        r100.add("bytevc0");
        r100.add("ByteVC1_dec");
        r100.add("fdk-aac");
        ArrayList r101 = new ArrayList();
        r101.add("ttcrypto");     // Catch: Exception -> L12
        r101.add("ttboringssl");     // Catch: Exception -> L12
        r101.add("ttffmpeg");     // Catch: Exception -> L12
    L4:
        r100.addAll(r101);
        r100.add("yuv");
        r100.add("bytenn");
        r100.add("ttheif_enc");
        Iterator<String> r102 = sEffectLibs.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        if (r100.contains(r103) == true) goto L6;
        r100.add(r103);
        goto L6
    L10:
        r100.add("lens");
        r100.add("ttvesdk");
        return r100;
    }

    public static int getLibraryLoadedVersion() {
        if (sLibraryLoadStatus == LoadStatus.LOADED) goto L7;
        return -1;
    L7:
        if (isLibraryLoadedOpt == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    public static void loadAllLibs() {
        if (sLibraryLoadStatus != LoadStatus.LOADED) goto L5;
        return;
    L5:
        List<String> r100 = getAllLibsList();
        String[] r101 = new String[r100.size()];
        int r102 = 0;
    L7:
        if (r102 >= r100.size()) goto L17;
        if (((String) ListProtector.get(r100, r102)).contentEquals("c++_shared") == true) goto L16;
        if (((String) ListProtector.get(r100, r102)).contentEquals("ttboringssl") == true) goto L16;
        if (((String) ListProtector.get(r100, r102)).contentEquals("ttcrypto") == true) goto L16;
        r101[r102] = "lib" + ((String) ListProtector.get(r100, r102)) + ".so";
    L16:
        r102 = r102 + 1;
        goto L7
    L17:
        sLibraryLoadStatus = LoadStatus.LOADING;
        d r103 = mLibraryLoader;
        if (r103 == null) goto L24;
        if (r103.onLoadNativeLibs(r100) == true) goto L27;
        sLibraryLoadStatus = LoadStatus.NOT_LOAD;
        return;
    L27:
        sLibraryLoadStatus = LoadStatus.LOADED;
        return;
    L24:
        if (sDefaultLibraryLoader.onLoadNativeLibs(r100) == true) goto L27;
        sLibraryLoadStatus = LoadStatus.NOT_LOAD;
    }

    public static synchronized void loadBase() {
        monitor-enter(TENativeLibsLoader.class);
        loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void loadByteBench() {
        monitor-enter(TENativeLibsLoader.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sIsSegmentalLoad == true) goto L7;
        loadAllLibs();     // Catch: Throwable -> L10
    L8:
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        segmentalLoad("bytebench");     // Catch: Throwable -> L10
        goto L8
    }

    public static synchronized void loadEditor() {
        monitor-enter(TENativeLibsLoader.class);
        loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void loadEffectSDK() {
        monitor-enter(TENativeLibsLoader.class);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L13
        r100.add("bytenn");     // Catch: Throwable -> L13
        Iterator<String> r101 = sEffectLibs.iterator();     // Catch: Throwable -> L13
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();     // Catch: Throwable -> L13
        if (r100.contains(r102) == true) goto L6;
        r100.add(r102);     // Catch: Throwable -> L13
        goto L6
    L10:
        sDefaultLibraryLoader.onLoadNativeLibs(r100);     // Catch: Throwable -> L13
        monitor-exit(TENativeLibsLoader.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static synchronized void loadImage() {
        monitor-enter(TENativeLibsLoader.class);
        loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void loadLibrary() {
        monitor-enter(TENativeLibsLoader.class);
        final d r100 = mLibraryLoader;     // Catch: Throwable -> L23
        MultiMediaEnvContext$HostBuildType r101 = MultiMediaEnv.f449594f;     // Catch: Throwable -> L23
        MultiMediaEnvContext$HostBuildType r102 = MultiMediaEnvContext$HostBuildType.INTERNAL;     // Catch: Throwable -> L23
        if (r101 == r102) goto L7;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == false) goto L13;
        setLibraryLoad(new com.ss.android.ttve.nativePort.c(r100));     // Catch: Throwable -> L23
    L13:
        if (sIsSegmentalLoad == true) goto L15;
        loadAllLibs();     // Catch: Throwable -> L23
    L16:
        mLibraryLoader = r100;     // Catch: Throwable -> L23
        if (MultiMediaEnv.f449594f == r102) goto L19;
    L21:
        monitor-exit(TENativeLibsLoader.class);
        return;
    L19:
        if (MultiMediaEnv.f449592d.getValue().f449602b == false) goto L21;
        com.ss.android.tecommonenvinitializer.diagnosis.e.a((String[]) getAllLibsList().toArray(new String[0]));     // Catch: Throwable -> L23
        goto L21
    L15:
        segmentalLoad("ttvesdk");     // Catch: Throwable -> L23
        goto L16
    L7:
        if (MultiMediaEnv.f449592d.getValue().f449601a == false) goto L9;
        r103 = true;
    L23:
        th = move-exception;
        throw th;
    }

    public static synchronized void loadOldEditor() {
        monitor-enter(TENativeLibsLoader.class);
        loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void loadRecorder() {
        monitor-enter(TENativeLibsLoader.class);
        loadLibrary();     // Catch: Throwable -> L7
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void initLibReferenceList() {
        List<String> r100 = getAllLibsList();
        Collections.reverse(r100);
        Iterator<String> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = r101.next();
        sLibraryReferenceList.add(new e(r102));
        goto L4
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ Context access$100() {
        return sContext;
    }

    public static LoadStatus getLibraryLoadStatus() {
        return sLibraryLoadStatus;
    }

    public static boolean isSegmentalLoadEnable() {
        return sIsSegmentalLoad;
    }

    public static void enableLoadOptLibrary(boolean r100) {
        sLoadOptLibrary = r100;
    }

    public static void enableSegmentalLoading(boolean r100) {
        sIsSegmentalLoad = r100;
    }

    public static void segmentalLoad(String r100) {
        if (sLibraryReferenceList.size() > 0) goto L5;
        initLibReferenceList();
    L5:
        LinkedList r101 = new LinkedList();
        Iterator<e> r102 = sLibraryReferenceList.iterator();
    L7:
        if (r102.hasNext() == false) goto L16;
        e r103 = r102.next();
        if (r100 != r103.f449962a) goto L7;
        if (r103.f449963b == true) goto L13;
        r103.f449963b = true;
        r101.add(r103.f449962a);
        goto L16
    L13:
        return;
    L16:
        if (r102.hasNext() == false) goto L21;
        e r104 = r102.next();
        if (r104.f449963b == true) goto L21;
        r104.f449963b = true;
        r101.add(r104.f449962a);
    L21:
        Collections.reverse(r101);
        String[] r105 = new String[r101.size()];
        int r106 = 0;
    L23:
        if (r106 >= r101.size()) goto L25;
        r105[r106] = "lib" + ((String) r101.get(r106)) + ".so";
        r106 = r106 + 1;
        goto L23
    L25:
        sLibraryLoadStatus = LoadStatus.LOADING;
        d r107 = mLibraryLoader;
        if (r107 == null) goto L32;
        if (r107.onLoadNativeLibs(r101) == true) goto L35;
        sLibraryLoadStatus = LoadStatus.NOT_LOAD;
        return;
    L35:
        sLibraryLoadStatus = LoadStatus.LOADED;
        c r108 = mLibraryHooker;
        if (r108 == null) goto L46;
        r108.getClass();
        return;
    L46:
        return;
    L32:
        if (sDefaultLibraryLoader.onLoadNativeLibs(r101) == true) goto L35;
        sLibraryLoadStatus = LoadStatus.NOT_LOAD;
    }

    public static synchronized void setContext(Context r100) {
        monitor-enter(TENativeLibsLoader.class);
        sContext = r100;     // Catch: Throwable -> L7
        monitor-exit(TENativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setLibraryHooker(c r100) {
        mLibraryHooker = r100;
    }

    public static void setLibraryLoad(d r100) {
        mLibraryLoader = r100;
    }

    private static /* synthetic */ Boolean lambda$loadLibrary$0(d r100, List r101) {
        if (r100 == null) goto L6;
        return Boolean.valueOf(r100.onLoadNativeLibs(r101));
    L6:
        return Boolean.valueOf(sDefaultLibraryLoader.onLoadNativeLibs(r101));
    }

    private static boolean lambda$loadLibrary$1(final d r100, List r101) {
        Function1<? super List<String>, Boolean> r102 = new com.ss.android.ttve.nativePort.b(r100);
        com.ss.android.tecommonenvinitializer.diagnosis.c.a r103 = com.ss.android.tecommonenvinitializer.diagnosis.c.f449597a;
        monitor-enter(com.ss.android.tecommonenvinitializer.diagnosis.c.class);
        boolean r104 = com.ss.android.tecommonenvinitializer.diagnosis.c.f449597a.b(r101, r102);     // Catch: Throwable -> L7
        monitor-exit(com.ss.android.tecommonenvinitializer.diagnosis.c.class);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }
}
