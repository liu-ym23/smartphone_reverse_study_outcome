package com.bytedance.keva;

import com.larus.bmhome.utils.r3;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.larus.settings.value.go;
import com.larus.settings.value.pe;
import com.larus.utils.l0;
import com.larus.utils.t0;
import hq9.z1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import xp9.o;

/* JADX INFO: loaded from: classes.dex */
public class KevaPreloadHolder {
    public static final long FIRST_FRAME_DELAYED_TIME = 30000;
    public static final String KEVA_REPO_PRELOAD_ENABLE = "keva_repo_preload_enable";
    public static final String KEY_LAST_FETCH_VERSION = "keva_repo_preload_last_fetch";
    public static final String KEY_REPO_PRELOAD_NAME_ARRAY_NAME = "keva_repo_preload_names_array";
    public static final String KEY_TOP_REPO_PRELOAD_ENABLE = "keva_top_repo_preload_enable";
    public static final String KEY_TOP_REPO_PRELOAD_LARK_UID = "keva_top_repo_preload_lark_uid";
    public static final String KEY_TOP_REPO_PRELOAD_NAME_ARRAY = "keva_top_repo_preload_name_array";
    public static final String KEY_TOP_REPO_PRELOAD_SEC_UID = "keva_top_repo_preload_sec_uid";
    public static final String KEY_TOP_REPO_PRELOAD_UID = "keva_top_repo_preload_uid";
    private static final String LARK_UID_PLACEHOLDER = "${larkUid}";
    private static final String MODE_PLACEHOLDER = "_${mode}";
    public static final String REPO_NAME = "keva_preload_names";
    private static final String SEC_UID_PLACEHOLDER = "${secUid}";
    public static final String TAG = "KevaPreload";
    private static final String UID_PLACEHOLDER = "${uid}";
    private static final AtomicInteger cas = null;
    public static long coastTime;
    public static volatile boolean fetchEnable;
    private static boolean isStartUpPeriod;
    private static final LinkedHashSet<RepoInfo> repoPreloadSet = null;

    /* JADX INFO: loaded from: classes3.dex */
    public static class RepoInfo {
        public int mode;
        public String name;

        public int hashCode() {
            return Objects.hash(new Object[]{this.name});
        }

        public static RepoInfo fromKevaString(String r100) {
            if (r100.length() >= 3) goto L5;
            return null;
        L5:
            if (r100.charAt(1) == '#') goto L7;
            return null;
        L7:
            return new RepoInfo(r100.substring(2), r100.charAt(0) - '0');
        }

        public static String toKevaString(RepoInfo r100) {
            return "" + r100.mode + "#" + r100.name;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            if (r100 != null) goto L7;
            return false;
        L7:
            if (getClass() == r100.getClass()) goto L10;
            return false;
        L10:
            return Objects.equals(this.name, ((RepoInfo) r100).name);
        }

        public RepoInfo(String r100, int r101) {
            this.name = r100;
            this.mode = r101;
        }
    }

    public KevaPreloadHolder() {
    }

    public static /* synthetic */ void a() {
        stopFetchAndSaveFetchInfo();
    }

    public static /* synthetic */ Unit b(Object r100) {
        return lambda$updateABSettings$0(r100);
    }

    private static void stopFetchAndSaveFetchInfo() {
        fetchEnable = false;
        String[] r100 = getPreloadRepoArray();
        Keva r101 = Keva.getRepo(REPO_NAME);
        r101.storeStringArray(KEY_REPO_PRELOAD_NAME_ARRAY_NAME, r100);
        r101.storeInt(KEY_LAST_FETCH_VERSION, AppHost.f326268a.getUpdateVersionCode());
        int r102 = r100.length;
    }

    static {
        repoPreloadSet = new LinkedHashSet();
        cas = new AtomicInteger(0);
        isStartUpPeriod = true;
    }

    public static List<RepoInfo> getPreloadRepoInfos() {
        int r100 = 0;
        String[] r101 = Keva.getRepo(REPO_NAME).getStringArray(KEY_REPO_PRELOAD_NAME_ARRAY_NAME, new String[0]);
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
    L3:
        if (r100 >= r103) goto L8;
        RepoInfo r104 = RepoInfo.fromKevaString(r101[r100]);
        if (r104 == null) goto L7;
        r102.add(r104);
    L7:
        r100 = r100 + 1;
        goto L3
    L8:
        return r102;
    }

    public static List<RepoInfo> getTopRepoPreloadInfos() {
        Keva r100 = Keva.getRepo(REPO_NAME);
        String[] r101 = r100.getStringArray(KEY_TOP_REPO_PRELOAD_NAME_ARRAY, new String[0]);
        String r102 = r100.getString(KEY_TOP_REPO_PRELOAD_UID, "");
        String r103 = r100.getString(KEY_TOP_REPO_PRELOAD_SEC_UID, "");
        String r104 = r100.getString(KEY_TOP_REPO_PRELOAD_LARK_UID, "");
        return resolveRepoInfos(Arrays.asList(r101), r102, r103, r104);
    }

    public static boolean isRepoPreloadEnable() {
        if (fetchEnable == false) goto L7;
        return false;
    L7:
        return getAbValue();
    }

    private static void lock() {
    L3:
        if (cas.compareAndSet(0, 1) == false) goto L3;
    }

    public static void onFirstFeedFirstFrame() {
        if (fetchEnable == true) goto L6;
        return;
    L6:
        if (isStartUpPeriod == true) goto L8;
        return;
    L8:
        isStartUpPeriod = false;
        t0.b(new d(), 30000);
    }

    private static void unlock() {
        cas.set(0);
    }

    public static void updateABSettings() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        boolean r102 = ((Boolean) l0.a(Boolean.FALSE, new pe())).booleanValue();
        z1 r103 = (z1) l0.a(new z1(null), new go());
        Keva r104 = Keva.getRepo(REPO_NAME);
        r104.storeBoolean(KEVA_REPO_PRELOAD_ENABLE, r102);
        r104.storeBoolean(KEY_TOP_REPO_PRELOAD_ENABLE, r103.b());
        r104.storeStringArray(KEY_TOP_REPO_PRELOAD_NAME_ARRAY, toPreloadRepoArray(r103.d()));
        AccountService r105 = AccountService.f365697a;
        String r106 = r105.getUserId();
        String r107 = r3.a();
        updateTopRepoUserIds(r106, r105.getSecUserId(), r107);
        if (r107.isEmpty() == false) goto L5;
        o.b(new c());
    L5:
        r103.toString();
    }

    private static boolean getAbValue() {
        if (isMainProcess() == true) goto L5;
        return false;
    L5:
        return Keva.getRepo(REPO_NAME).getBoolean(KEVA_REPO_PRELOAD_ENABLE, false);
    }

    private static String[] getPreloadRepoArray() {
        lock();
        LinkedHashSet<RepoInfo> r100 = repoPreloadSet;
        String[] r101 = new String[r100.size()];
        Iterator<RepoInfo> r102 = r100.iterator();     // Catch: Exception -> L8
        int r103 = 0;
    L5:
        if (r102.hasNext() == false) goto L9;
        int r104 = r103 + 1;     // Catch: Exception -> L8
        r101[r103] = RepoInfo.toKevaString(r102.next());     // Catch: Exception -> L8
        r103 = r104;
    L9:
        unlock();
        return r101;
    L8:
        r101 = new String[0];
        goto L9
    }

    public static void initFetchable() {
        boolean r100 = false;
        if (getAbValue() == true) goto L5;
    L7:
        fetchEnable = r100;
        return;
    L5:
        if (Keva.getRepo(REPO_NAME).getInt(KEY_LAST_FETCH_VERSION, 0) == AppHost.f326268a.getUpdateVersionCode()) goto L7;
        r100 = true;
        goto L7
    }

    private static boolean isMainProcess() {
        return com.bytedance.apm.d.l();
    L4:
        return false;
    }

    public static boolean isTopRepoPreloadEnable() {
        if (isMainProcess() == true) goto L5;
        return false;
    L5:
        return Keva.getRepo(REPO_NAME).getBoolean(KEY_TOP_REPO_PRELOAD_ENABLE, false);
    }

    public static List<RepoInfo> getFeedShowRepoPreloadInfos(List<String> r100) {
        if (r100 == null) goto L12;
        if (r100.isEmpty() == true) goto L12;
        String r101 = r3.a();
        if (r101.isEmpty() == false) goto L9;
        r101 = Keva.getRepo(REPO_NAME).getString(KEY_TOP_REPO_PRELOAD_LARK_UID, "");
    L9:
        AccountService r102 = AccountService.f365697a;
        return resolveRepoInfos(r100, r102.getUserId(), r102.getSecUserId(), r101);
    L12:
        return new ArrayList();
    }

    private static /* synthetic */ Unit lambda$updateABSettings$0(Object r100) {
        String r101 = r3.a();
        if (r101.isEmpty() == true) goto L6;
        Keva.getRepo(REPO_NAME).storeString(KEY_TOP_REPO_PRELOAD_LARK_UID, r101);
    L6:
        return Unit.INSTANCE;
    }

    private static String[] toPreloadRepoArray(List<String> r100) {
        if (r100 == null) goto L18;
        if (r100.isEmpty() == true) goto L18;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<String> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();
        if (r103 == null) goto L9;
        if (r103.isEmpty() == true) goto L9;
        r101.add(r103);
        goto L9
    L16:
        return (String[]) r101.toArray(new String[0]);
    L18:
        return new String[0];
    }

    public static boolean tryPutPreloadMap(String r100, int r101) {
        boolean r102 = false;
        if (fetchEnable == true) goto L6;
        return false;
    L6:
        if (r101 > (-1)) goto L8;
    L16:
        return r102;
    L8:
        if (r101 > 9) goto L16;
        if (r100 == null) goto L16;
        if (r100.length() == 0) goto L16;
        lock();
        r102 = repoPreloadSet.add(new RepoInfo(r100, r101));     // Catch: Exception -> L17
    L15:
        unlock();
        goto L16
    }

    private static void updateTopRepoUserIds(String r100, String r101, String r102) {
        Keva r103 = Keva.getRepo(REPO_NAME);
        r103.storeString(KEY_TOP_REPO_PRELOAD_UID, r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.storeString(KEY_TOP_REPO_PRELOAD_SEC_UID, r101);
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r103.storeString(KEY_TOP_REPO_PRELOAD_LARK_UID, r102);
    }

    private static List<RepoInfo> resolveRepoInfos(List<String> r100, String r101, String r102, String r103) {
        ArrayList r104 = new ArrayList(r100.size());
        Iterator<String> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();
        if (r106 != null) goto L8;
    L10:
        int r107 = 0;
    L11:
        String r108 = resolveRepoName(r106, r101, r102, r103);
        if (r108 == null) goto L4;
        if (r108.isEmpty() == true) goto L4;
        r104.add(new RepoInfo(r108, r107));
        goto L4
    L8:
        if (r106.contains(MODE_PLACEHOLDER) == false) goto L10;
        r107 = 1;
        goto L11
    L16:
        return r104;
    }

    private static String resolveRepoName(String r100, String r101, String r102, String r103) {
        if (r100 != null) goto L5;
    L27:
        return null;
    L5:
        if (r100.isEmpty() == true) goto L27;
        if (r100.contains(UID_PLACEHOLDER) == false) goto L14;
        if (r101.isEmpty() == false) goto L12;
        return null;
    L12:
        r100 = r100.replace(UID_PLACEHOLDER, r101);
    L14:
        if (r100.contains(SEC_UID_PLACEHOLDER) == false) goto L20;
        if (r102.isEmpty() == false) goto L18;
        return null;
    L18:
        r100 = r100.replace(SEC_UID_PLACEHOLDER, r102);
    L20:
        if (r100.contains(LARK_UID_PLACEHOLDER) == false) goto L26;
        if (r103.isEmpty() == false) goto L24;
        return null;
    L24:
        r100 = r100.replace(LARK_UID_PLACEHOLDER, r103);
    L26:
        return r100.replace(MODE_PLACEHOLDER, "");
    }
}
