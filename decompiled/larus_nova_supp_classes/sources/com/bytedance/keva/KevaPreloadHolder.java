package com.bytedance.keva;

import com.bytedance.apm.d;
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
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import org.xmlpull.v1.XmlPullParser;
import xp9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

    public KevaPreloadHolder() {
    }

    public static /* synthetic */ void a() {
        stopFetchAndSaveFetchInfo();
    }

    public static /* synthetic */ Unit b(Object r0) {
        return lambda$updateABSettings$0(r0);
    }

    private static void stopFetchAndSaveFetchInfo() {
        fetchEnable = false;
        String[] r0 = getPreloadRepoArray();
        Keva r1 = Keva.getRepo(REPO_NAME);
        r1.storeStringArray(KEY_REPO_PRELOAD_NAME_ARRAY_NAME, r0);
        r1.storeInt(KEY_LAST_FETCH_VERSION, AppHost.a.getUpdateVersionCode());
        int r2 = r0.length;
    }

    static {
        repoPreloadSet = new LinkedHashSet();
        cas = new AtomicInteger(0);
        isStartUpPeriod = true;
    }

    public static List<RepoInfo> getPreloadRepoInfos() {
        int r1 = 0;
        String[] r0 = Keva.getRepo(REPO_NAME).getStringArray(KEY_REPO_PRELOAD_NAME_ARRAY_NAME, new String[0]);
        ArrayList r2 = new ArrayList(r0.length);
        int r3 = r0.length;
    L3:
        if (r1 >= r3) goto L8;
        RepoInfo r4 = RepoInfo.fromKevaString(r0[r1]);
        if (r4 == null) goto L7;
        r2.add(r4);
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    public static List<RepoInfo> getTopRepoPreloadInfos() {
        Keva r0 = Keva.getRepo(REPO_NAME);
        String[] r1 = r0.getStringArray(KEY_TOP_REPO_PRELOAD_NAME_ARRAY, new String[0]);
        String r2 = r0.getString(KEY_TOP_REPO_PRELOAD_UID, XmlPullParser.NO_NAMESPACE);
        String r4 = r0.getString(KEY_TOP_REPO_PRELOAD_SEC_UID, XmlPullParser.NO_NAMESPACE);
        String r3 = r0.getString(KEY_TOP_REPO_PRELOAD_LARK_UID, XmlPullParser.NO_NAMESPACE);
        return resolveRepoInfos(Arrays.asList(r1), r2, r4, r3);
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
        t0.b(new d(), FIRST_FRAME_DELAYED_TIME);
    }

    private static void unlock() {
        cas.set(0);
    }

    public static void updateABSettings() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        boolean r2 = ((Boolean) l0.a(Boolean.FALSE, new pe())).booleanValue();
        z1 r3 = (z1) l0.a(new z1(null), new go());
        Keva r4 = Keva.getRepo(REPO_NAME);
        r4.storeBoolean(KEVA_REPO_PRELOAD_ENABLE, r2);
        r4.storeBoolean(KEY_TOP_REPO_PRELOAD_ENABLE, r3.b());
        r4.storeStringArray(KEY_TOP_REPO_PRELOAD_NAME_ARRAY, toPreloadRepoArray(r3.d()));
        AccountService r5 = AccountService.a;
        String r6 = r5.getUserId();
        String r7 = r3.a();
        updateTopRepoUserIds(r6, r5.getSecUserId(), r7);
        if (r7.isEmpty() == false) goto L5;
        o.b(new c());
    L5:
        r3.toString();
    }

    private static boolean getAbValue() {
        if (isMainProcess() == true) goto L5;
        return false;
    L5:
        return Keva.getRepo(REPO_NAME).getBoolean(KEVA_REPO_PRELOAD_ENABLE, false);
    }

    private static String[] getPreloadRepoArray() {
        lock();
        LinkedHashSet<RepoInfo> r0 = repoPreloadSet;
        String[] r1 = new String[r0.size()];
        Iterator<RepoInfo> r2 = r0.iterator();     // Catch: Exception -> L8
        int r3 = 0;
    L5:
        if (r2.hasNext() == false) goto L9;
        int r5 = r3 + 1;     // Catch: Exception -> L8
        r1[r3] = RepoInfo.toKevaString(r2.next());     // Catch: Exception -> L8
        r3 = r5;
    L9:
        unlock();
        return r1;
    L8:
        r1 = new String[0];
        goto L9
    }

    public static void initFetchable() {
        boolean r1 = false;
        if (getAbValue() == true) goto L5;
    L7:
        fetchEnable = r1;
        return;
    L5:
        if (Keva.getRepo(REPO_NAME).getInt(KEY_LAST_FETCH_VERSION, 0) == AppHost.a.getUpdateVersionCode()) goto L7;
        r1 = true;
        goto L7
    }

    private static boolean isMainProcess() {
        return d.l();
    L4:
        return false;
    }

    public static boolean isTopRepoPreloadEnable() {
        if (isMainProcess() == true) goto L5;
        return false;
    L5:
        return Keva.getRepo(REPO_NAME).getBoolean(KEY_TOP_REPO_PRELOAD_ENABLE, false);
    }

    public static List<RepoInfo> getFeedShowRepoPreloadInfos(List<String> r3) {
        if (r3 == null) goto L12;
        if (r3.isEmpty() == true) goto L12;
        String r0 = r3.a();
        if (r0.isEmpty() == false) goto L9;
        r0 = Keva.getRepo(REPO_NAME).getString(KEY_TOP_REPO_PRELOAD_LARK_UID, XmlPullParser.NO_NAMESPACE);
    L9:
        AccountService r1 = AccountService.a;
        return resolveRepoInfos(r3, r1.getUserId(), r1.getSecUserId(), r0);
    L12:
        return new ArrayList();
    }

    private static /* synthetic */ Unit lambda$updateABSettings$0(Object r2) {
        String r3 = r3.a();
        if (r3.isEmpty() == true) goto L6;
        Keva.getRepo(REPO_NAME).storeString(KEY_TOP_REPO_PRELOAD_LARK_UID, r3);
    L6:
        return Unit.INSTANCE;
    }

    private static String[] toPreloadRepoArray(List<String> r4) {
        if (r4 == null) goto L18;
        if (r4.isEmpty() == true) goto L18;
        ArrayList r1 = new ArrayList(r4.size());
        Iterator<String> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L16;
        String r2 = r5.next();
        if (r2 == null) goto L9;
        if (r2.isEmpty() == true) goto L9;
        r1.add(r2);
        goto L9
    L16:
        return (String[]) r1.toArray(new String[0]);
    L18:
        return new String[0];
    }

    public static boolean tryPutPreloadMap(String r3, int r4) {
        boolean r1 = false;
        if (fetchEnable == true) goto L6;
        return false;
    L6:
        if (r4 > (-1)) goto L8;
    L16:
        return r1;
    L8:
        if (r4 > 9) goto L16;
        if (r3 == null) goto L16;
        if (r3.length() == 0) goto L16;
        lock();
        r1 = repoPreloadSet.add(new RepoInfo(r3, r4));     // Catch: Exception -> L17
    L15:
        unlock();
        goto L16
    }

    private static void updateTopRepoUserIds(String r2, String r3, String r4) {
        Keva r0 = Keva.getRepo(REPO_NAME);
        r0.storeString(KEY_TOP_REPO_PRELOAD_UID, r2);
        if (r3 != null) goto L5;
        r3 = XmlPullParser.NO_NAMESPACE;
    L5:
        r0.storeString(KEY_TOP_REPO_PRELOAD_SEC_UID, r3);
        if (r4 != null) goto L8;
        r4 = XmlPullParser.NO_NAMESPACE;
    L8:
        r0.storeString(KEY_TOP_REPO_PRELOAD_LARK_UID, r4);
    }

    private static List<RepoInfo> resolveRepoInfos(List<String> r4, String r5, String r6, String r7) {
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<String> r8 = r4.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        String r1 = r8.next();
        if (r1 != null) goto L8;
    L10:
        int r2 = 0;
    L11:
        String r3 = resolveRepoName(r1, r5, r6, r7);
        if (r3 == null) goto L4;
        if (r3.isEmpty() == true) goto L4;
        r0.add(new RepoInfo(r3, r2));
        goto L4
    L8:
        if (r1.contains(MODE_PLACEHOLDER) == false) goto L10;
        r2 = 1;
        goto L11
    L16:
        return r0;
    }

    private static String resolveRepoName(String r3, String r4, String r5, String r6) {
        if (r3 != null) goto L5;
    L27:
        return null;
    L5:
        if (r3.isEmpty() == true) goto L27;
        if (r3.contains(UID_PLACEHOLDER) == false) goto L14;
        if (r4.isEmpty() == false) goto L12;
        return null;
    L12:
        r3 = r3.replace(UID_PLACEHOLDER, r4);
    L14:
        if (r3.contains(SEC_UID_PLACEHOLDER) == false) goto L20;
        if (r5.isEmpty() == false) goto L18;
        return null;
    L18:
        r3 = r3.replace(SEC_UID_PLACEHOLDER, r5);
    L20:
        if (r3.contains(LARK_UID_PLACEHOLDER) == false) goto L26;
        if (r6.isEmpty() == false) goto L24;
        return null;
    L24:
        r3 = r3.replace(LARK_UID_PLACEHOLDER, r6);
    L26:
        return r3.replace(MODE_PLACEHOLDER, XmlPullParser.NO_NAMESPACE);
    }
}
