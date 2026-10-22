package com.huawei.hms.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidException;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class HMSPackageManager {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static HMSPackageManager f277869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Object f277870p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Object f277871q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Object f277872r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final Map<String, String> f277873s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f277874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PackageManagerHelper f277875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f277877d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f277878e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f277880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f277881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f277882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f277883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f277884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f277885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f277886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f277887n;

    /* JADX INFO: loaded from: classes23.dex */
    public static class PackagePriorityInfo implements Comparable<PackagePriorityInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f277888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f277889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f277890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f277891d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f277892e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f277893f;

        public static /* synthetic */ String a(PackagePriorityInfo r100) {
            return r100.f277888a;
        }

        public static /* synthetic */ String b(PackagePriorityInfo r100) {
            return r100.f277889b;
        }

        public static /* synthetic */ String c(PackagePriorityInfo r100) {
            return r100.f277890c;
        }

        public static /* synthetic */ String d(PackagePriorityInfo r100) {
            return r100.f277891d;
        }

        public static /* synthetic */ Long e(PackagePriorityInfo r100) {
            return r100.f277893f;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(PackagePriorityInfo r100) {
            if (TextUtils.equals(this.f277892e, r100.f277892e) == false) goto L7;
            return this.f277893f.compareTo(r100.f277893f);
        L7:
            return this.f277892e.compareTo(r100.f277892e);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(PackagePriorityInfo r100) {
            return compareTo2(r100);
        }

        public PackagePriorityInfo(String r100, String r101, String r102, String r103, String r104, long r105) {
            this.f277888a = r100;
            this.f277889b = r101;
            this.f277890c = r102;
            this.f277891d = r103;
            this.f277892e = r104;
            this.f277893f = Long.valueOf(r105);
        }
    }

    /* JADX INFO: loaded from: classes23.dex */
    public class a implements Comparator<ResolveInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HMSPackageManager f277894a;

        public a(HMSPackageManager r100) {
            this.f277894a = r100;
        }

        public int a(ResolveInfo r100, ResolveInfo r101) {
            String r102 = r100.serviceInfo.applicationInfo.packageName;
            String r103 = r101.serviceInfo.applicationInfo.packageName;
            if (HMSPackageManager.a().containsKey(r102) == false) goto L9;
            if (HMSPackageManager.a().containsKey(r103) == false) goto L9;
            return r102.compareTo(r103);
        L9:
            if (HMSPackageManager.a().containsKey(r102) == false) goto L13;
            return -1;
        L13:
            if (HMSPackageManager.a().containsKey(r103) == false) goto L16;
            return 1;
        L16:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ResolveInfo r100, ResolveInfo r101) {
            return a(r100, r101);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HMSPackageManager f277895a;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_utils_HMSPackageManager$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_utils_HMSPackageManager$b__run$___twin___() {
            HMSLog.i("HMSPackageManager", "enter asyncOnceCheckMDMState");
            List<ResolveInfo> r100 = HMSPackageManager.a(this.f277895a).getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);     // Catch: Exception -> L16
            if (r100 != null) goto L6;
            return;
        L6:
            if (r100.size() == 0) goto L27;
            Iterator<ResolveInfo> r101 = r100.iterator();
        L10:
            if (r101.hasNext() == false) goto L14;
            if ("com.huawei.hwid".equals(r101.next().serviceInfo.applicationInfo.packageName) == false) goto L10;
            HMSPackageManager.b(this.f277895a);
            goto L10
        L14:
            HMSLog.i("HMSPackageManager", "quit asyncOnceCheckMDMState");
            return;
        L27:
            return;
        L16:
            e = move-exception;
            HMSLog.e("HMSPackageManager", "asyncOnceCheckMDMState query hms action failed. " + e.getMessage());
        }

        public b(HMSPackageManager r100) {
            this.f277895a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_utils_HMSPackageManager$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_huawei_hms_utils_HMSPackageManager$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public String getInnerServiceAction() {
        return PackageConstants.INTERNAL_SERVICES_ACTION;
    }

    static {
        f277870p = new Object();
        f277871q = new Object();
        f277872r = new Object();
        HashMap r100 = new HashMap();
        f277873s = r100;
        r100.put("com.huawei.hwid", "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05");
        r100.put("com.huawei.hwid.tv", "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C");
    }

    private void b() {
        new Thread(new b(this), "Thread-asyncOnceCheckMDMState").start();
    }

    private boolean c() {
        String r100 = ReadApkFileUtil.getHmsPath(this.f277874a);
        if (r100 != null) goto L7;
        HMSLog.i("HMSPackageManager", "hmsPath is null!");
        return false;
    L7:
        if (ReadApkFileUtil.isCertFound(r100) == true) goto L11;
        HMSLog.i("HMSPackageManager", "NO huawer.cer in HMS!");
        return false;
    L11:
        if (ReadApkFileUtil.checkSignature() == true) goto L15;
        HMSLog.i("HMSPackageManager", "checkSignature fail!");
        return false;
    L15:
        if (ReadApkFileUtil.verifyApkHash(r100) == true) goto L18;
        HMSLog.i("HMSPackageManager", "verifyApkHash fail!");
        return false;
    L18:
        return true;
    }

    private void e() {
        Object r100 = f277871q;
        monitor-enter(r100);
        this.f277879f = null;     // Catch: Throwable -> L8
        this.f277880g = null;     // Catch: Throwable -> L8
        this.f277881h = null;     // Catch: Throwable -> L8
        this.f277882i = null;     // Catch: Throwable -> L8
        this.f277883j = 0;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void f() {
        Object r100 = f277871q;
        monitor-enter(r100);
        this.f277876c = null;     // Catch: Throwable -> L8
        this.f277877d = null;     // Catch: Throwable -> L8
        this.f277878e = 0;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private String g() {
        HMSLog.i("HMSPackageManager", "Enter getAvailableHMSPackageNameForMultiService.");
        String r100 = this.f277879f;
        if (r100 == null) goto L9;
        c(r100);
        PackageManagerHelper.PackageStates r101 = this.f277875b.getPackageStates(this.f277879f);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(r101) == true) goto L9;
        String r102 = this.f277879f;
        if (r102 == null) goto L9;
        return r102;
    L9:
        HMSLog.i("HMSPackageManager", " return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    private Pair<String, String> h() {
        List<ResolveInfo> r100 = this.f277874a.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);     // Catch: Exception -> L26
        if (r100 != null) goto L6;
    L24:
        HMSLog.e("HMSPackageManager", "query hms action, resolveInfoList is null or empty.");
        return null;
    L6:
        if (r100.size() == 0) goto L24;
        a(r100);
        Iterator<ResolveInfo> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L23;
        ResolveInfo r102 = r101.next();
        String r103 = r102.serviceInfo.applicationInfo.packageName;
        String r104 = this.f277875b.getPackageSigningCertificate(r103);
        String r105 = this.f277875b.getPackageSignature(r103);
        Pair<String, String> r106 = d(r103, r104);
        if (r106 != null) goto L13;
        Pair<String, String> r107 = a(r102.serviceInfo.metaData, r103, r104, r105);
        if (r107 != null) goto L17;
        Pair<String, String> r108 = a(r103, r105);
        if (r108 == null) goto L10;
        HMSLog.i("HMSPackageManager", "signature V2 check success");
        return r108;
    L17:
        HMSLog.i("HMSPackageManager", "DSS signature check success");
        return r107;
    L13:
        HMSLog.i("HMSPackageManager", "signature V3 check success");
        return r106;
    L23:
        return null;
    L26:
        e = move-exception;
        HMSLog.e("HMSPackageManager", "getHmsPackageName query hms action failed. " + e.getMessage());
        return null;
    }

    private ArrayList<PackagePriorityInfo> j() {
        List<ResolveInfo> r100 = this.f277874a.getPackageManager().queryIntentServices(new Intent(PackageConstants.GENERAL_SERVICES_ACTION), 128);     // Catch: Exception -> L28
        if (r100 != null) goto L6;
    L26:
        HMSLog.e("HMSPackageManager", "query aglite action, resolveInfoList is null or empty");
        return null;
    L6:
        if (r100.isEmpty() == true) goto L26;
        ArrayList<PackagePriorityInfo> r101 = new ArrayList();
        Iterator<ResolveInfo> r102 = r100.iterator();
    L10:
        if (r102.hasNext() == false) goto L24;
        ResolveInfo r103 = r102.next();
        String r104 = r103.serviceInfo.applicationInfo.packageName;
        long r110 = this.f277875b.getPackageFirstInstallTime(r104);
        Bundle r105 = r103.serviceInfo.metaData;
        if (r105 == null) goto L13;
        String r106 = a(r105, "hms_app_checker_config");
        String r111 = a(r106);
        if (TextUtils.isEmpty(r111) == true) goto L16;
        String r107 = a(r105, "hms_app_signer_v2");
        if (TextUtils.isEmpty(r107) == true) goto L19;
        String r108 = a(r105, "hms_app_cert_chain");
        if (TextUtils.isEmpty(r108) == true) goto L22;
        HMSLog.i("HMSPackageManager", "add: " + r104 + ", " + r106 + ", " + r110);
        r101.add(new PackagePriorityInfo(r104, r106, r107, r108, r111, r110));
        goto L10
    L22:
        HMSLog.i("HMSPackageManager", "get certChain fail.");
        goto L10
    L19:
        HMSLog.i("HMSPackageManager", "get signerV2 fail.");
        goto L10
    L16:
        HMSLog.i("HMSPackageManager", "get priority fail. hmsCheckerCfg: " + r106);
        goto L10
    L13:
        HMSLog.e("HMSPackageManager", "package " + r104 + " get metaData is null");
        goto L10
    L24:
        Collections.sort(r101);
        return r101;
    L28:
        e = move-exception;
        HMSLog.e("HMSPackageManager", "query aglite action failed. " + e.getMessage());
        return null;
    }

    private void k() {
        Object r100 = f277871q;
        monitor-enter(r100);
        Pair<String, String> r101 = h();     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        HMSLog.e("HMSPackageManager", "<initHmsPackageInfo> Failed to find HMS apk");     // Catch: Throwable -> L12
        f();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L9:
        String r102 = (String) r101.first;     // Catch: Throwable -> L12
        this.f277876c = r102;     // Catch: Throwable -> L12
        this.f277877d = (String) r101.second;     // Catch: Throwable -> L12
        this.f277878e = this.f277875b.getPackageVersionCode(r102);     // Catch: Throwable -> L12
        HMSLog.i("HMSPackageManager", "<initHmsPackageInfo> Succeed to find HMS apk: " + this.f277876c + " version: " + this.f277878e);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void l() {
        Object r100 = f277871q;
        monitor-enter(r100);
        Pair<String, String> r101 = i();     // Catch: Throwable -> L12
        if (r101 != null) goto L9;
        HMSLog.e("HMSPackageManager", "<initHmsPackageInfoForMultiService> Failed to find HMS apk");     // Catch: Throwable -> L12
        e();     // Catch: Throwable -> L12
        AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L9:
        this.f277879f = (String) r101.first;     // Catch: Throwable -> L12
        this.f277880g = (String) r101.second;     // Catch: Throwable -> L12
        this.f277883j = this.f277875b.getPackageVersionCode(g());     // Catch: Throwable -> L12
        e(this.f277879f);     // Catch: Throwable -> L12
        HMSLog.i("HMSPackageManager", "<initHmsPackageInfoForMultiService> Succeed to find HMS apk: " + this.f277879f + " version: " + this.f277883j);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private boolean m() {
        PackageManager r100 = this.f277874a.getPackageManager();
        if (r100 != null) goto L30;
        HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to get 'PackageManager' instance.");
        return true;
    L30:
    L28:
        HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.");
    L29:
        return true;
    L26:
        e = move-exception;
        HMSLog.e("HMSPackageManager", "In isMinApkVersionEffective, Failed to read meta data for HMSCore API level.", e);
        goto L29
    L7:
        if (TextUtils.isEmpty(this.f277881h) == false) goto L9;
    L14:
        ApplicationInfo r101 = r100.getPackageInfo(getHMSPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L26 AndroidException -> L28
        if (r101 == null) goto L29;
        Bundle r102 = r101.metaData;     // Catch: RuntimeException -> L26 AndroidException -> L28
        if (r102 == null) goto L29;
        if (r102.containsKey("com.huawei.hms.kit.api_level:hmscore") == false) goto L29;
        if (getHmsVersionCode() < 50000000) goto L23;
    L24:
        HMSLog.i("HMSPackageManager", "MinApkVersion is disabled.");     // Catch: RuntimeException -> L26 AndroidException -> L28
        return false;
    L23:
        if (getHmsVersionCode() > 19999999) goto L29;
    L9:
        if (this.f277881h.equals(PackageConstants.GENERAL_SERVICES_ACTION) == false) goto L11;
    L12:
        HMSLog.i("HMSPackageManager", "action = " + this.f277881h + " exist");     // Catch: RuntimeException -> L26 AndroidException -> L28
        return false;
    L11:
        if (this.f277881h.equals(PackageConstants.INTERNAL_SERVICES_ACTION) == false) goto L14;
        goto L12
    }

    public String getHMSFingerprint() {
        String r100 = this.f277877d;
        if (r100 != null) goto L6;
        return "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    L6:
        return r100;
    }

    public String getHMSPackageName() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageName");
        refresh();
        String r100 = this.f277876c;
        if (r100 == null) goto L10;
        PackageManagerHelper.PackageStates r101 = this.f277875b.getPackageStates(r100);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(r101) == false) goto L7;
        HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
        k();
    L7:
        String r102 = this.f277876c;
        if (r102 == null) goto L10;
        return r102;
    L10:
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public String getHMSPackageNameForMultiService() {
        HMSLog.i("HMSPackageManager", "Enter getHMSPackageNameForMultiService");
        refreshForMultiService();
        String r100 = this.f277879f;
        if (r100 == null) goto L10;
        PackageManagerHelper.PackageStates r101 = this.f277875b.getPackageStates(r100);
        if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(r101) == false) goto L7;
        HMSLog.i("HMSPackageManager", "The package name is not installed and needs to be refreshed again");
        l();
    L7:
        String r102 = this.f277879f;
        if (r102 == null) goto L10;
        return r102;
    L10:
        HMSLog.i("HMSPackageManager", "return default packageName: com.huawei.hwid");
        return "com.huawei.hwid";
    }

    public PackageManagerHelper.PackageStates getHMSPackageStates() {
        Object r100 = f277870p;
        monitor-enter(r100);
        refresh();     // Catch: Throwable -> L29
        PackageManagerHelper.PackageStates r101 = this.f277875b.getPackageStates(this.f277876c);     // Catch: Throwable -> L29
        PackageManagerHelper.PackageStates r102 = PackageManagerHelper.PackageStates.NOT_INSTALLED;     // Catch: Throwable -> L29
        if (r101 != r102) goto L9;
        f();     // Catch: Throwable -> L29
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r102;
    L9:
        boolean r103 = false;
        if ("com.huawei.hwid".equals(this.f277876c) == true) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L20;
        PackageManagerHelper.PackageStates r105 = PackageManagerHelper.PackageStates.SPOOF;     // Catch: Throwable -> L29
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r105;
    L20:
        if (r101 == PackageManagerHelper.PackageStates.ENABLED) goto L22;
    L24:
        if (r103 == false) goto L27;
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r102;
    L27:
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r101;
    L22:
        if (c(this.f277876c, this.f277877d) == true) goto L24;
        r103 = true;
        goto L24
    L12:
        if (d() != 1) goto L14;
        r104 = true;
    L29:
        th = move-exception;
        throw th;
    }

    public PackageManagerHelper.PackageStates getHMSPackageStatesForMultiService() {
        Object r100 = f277870p;
        monitor-enter(r100);
        refreshForMultiService();     // Catch: Throwable -> L29
        PackageManagerHelper.PackageStates r101 = this.f277875b.getPackageStates(this.f277879f);     // Catch: Throwable -> L29
        PackageManagerHelper.PackageStates r102 = PackageManagerHelper.PackageStates.NOT_INSTALLED;     // Catch: Throwable -> L29
        if (r101 != r102) goto L9;
        e();     // Catch: Throwable -> L29
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r102;
    L9:
        boolean r103 = false;
        if ("com.huawei.hwid".equals(this.f277879f) == true) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L20;
        PackageManagerHelper.PackageStates r105 = PackageManagerHelper.PackageStates.SPOOF;     // Catch: Throwable -> L29
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r105;
    L20:
        if (r101 == PackageManagerHelper.PackageStates.ENABLED) goto L22;
    L24:
        if (r103 == false) goto L27;
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r102;
    L27:
        monitor-exit(r100);     // Catch: Throwable -> L29
        return r101;
    L22:
        if (c(this.f277879f, this.f277880g) == true) goto L24;
        r103 = true;
        goto L24
    L12:
        if (d() != 1) goto L14;
        r104 = true;
    L29:
        th = move-exception;
        throw th;
    }

    public int getHmsMultiServiceVersion() {
        return this.f277875b.getPackageVersionCode(getHMSPackageNameForMultiService());
    }

    public int getHmsVersionCode() {
        return this.f277875b.getPackageVersionCode(getHMSPackageName());
    }

    public String getServiceAction() {
        if (TextUtils.isEmpty(this.f277881h) == false) goto L5;
        return "com.huawei.hms.core.aidlservice";
    L5:
        return this.f277881h;
    }

    public boolean isUpdateHmsForThirdPartyDevice() {
        if ("com.huawei.hwid".equals(this.f277879f) == true) goto L5;
    L7:
        return false;
    L5:
        if (AgHmsUpdateState.getInstance().isUpdateHms() == false) goto L7;
        return true;
    }

    public void refresh() {
        if (TextUtils.isEmpty(this.f277876c) == false) goto L5;
    L6:
        k();
    L7:
        c(this.f277876c);
        return;
    L5:
        if (TextUtils.isEmpty(this.f277877d) == false) goto L7;
        goto L6
    }

    public void refreshForMultiService() {
        if (TextUtils.isEmpty(this.f277879f) == false) goto L5;
    L6:
        l();
    L7:
        c(this.f277879f);
        return;
    L5:
        if (TextUtils.isEmpty(this.f277880g) == false) goto L7;
        goto L6
    }

    private int d() {
        Object r100 = f277872r;
        monitor-enter(r100);
        HMSLog.i("HMSPackageManager", "enter checkHmsIsSpoof");     // Catch: Throwable -> L22
        long r101 = this.f277875b.getPackageFirstInstallTime("com.huawei.hwid");     // Catch: Throwable -> L22
        int r102 = 1;
        if (this.f277884k != 3) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L16;
        HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof cached state: " + a(this.f277884k));     // Catch: Throwable -> L22
        int r104 = this.f277884k;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return r104;
    L16:
        if (c() == false) goto L18;
        r102 = 2;
    L18:
        this.f277884k = r102;     // Catch: Throwable -> L22
        this.f277885l = this.f277875b.getPackageFirstInstallTime("com.huawei.hwid");     // Catch: Throwable -> L22
        HMSLog.i("HMSPackageManager", "quit checkHmsIsSpoof state: " + a(this.f277884k));     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        return this.f277884k;
    L7:
        if (this.f277885l != r101) goto L10;
        r103 = false;
    L22:
        th = move-exception;
        throw th;
    }

    private Pair<String, String> i() {
        Pair<String, String> r100 = h();
        if (r100 == null) goto L6;
        HMSLog.i("HMSPackageManager", "aidlService pkgName: " + ((String) r100.first));
        this.f277881h = "com.huawei.hms.core.aidlservice";
        this.f277882i = null;
        return r100;
    L6:
        ArrayList<PackagePriorityInfo> r101 = j();
        if (r101 != null) goto L10;
        HMSLog.e("HMSPackageManager", "PackagePriorityInfo list is null");
        return null;
    L10:
        Iterator<PackagePriorityInfo> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L17;
        PackagePriorityInfo r103 = r102.next();
        String r104 = PackagePriorityInfo.a(r103);
        String r105 = PackagePriorityInfo.b(r103);
        String r106 = PackagePriorityInfo.c(r103);
        String r107 = PackagePriorityInfo.d(r103);
        String r108 = this.f277875b.getPackageSignature(r104);
        if (a(r104 + "&" + r108 + "&" + r105, r106, r107) == false) goto L12;
        HMSLog.i("HMSPackageManager", "result: " + r104 + ", " + r105 + ", " + PackagePriorityInfo.e(r103));
        this.f277881h = PackageConstants.GENERAL_SERVICES_ACTION;
        d(r105);
        return new Pair(r104, r108);
    L17:
        return null;
    }

    public static /* synthetic */ Map a() {
        return f277873s;
    }

    public boolean isUseOldCertificate() {
        return this.f277886m;
    }

    public void resetMultiServiceState() {
        e();
    }

    private HMSPackageManager(Context r100) {
        this.f277874a = r100;
        this.f277875b = new PackageManagerHelper(r100);
    }

    private String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        int r101 = r100.indexOf("priority=");
        if (r101 != (-1)) goto L9;
        HMSLog.e("HMSPackageManager", "get indexOfIdentifier -1");
        return null;
    L9:
        int r102 = r100.indexOf(",", r101);
        if (r102 != (-1)) goto L13;
        r102 = r100.length();
    L13:
        return r100.substring(r101, r102);
    }

    private boolean b(String r100) {
        if ("com.huawei.hwid".equals(r100) == true) goto L5;
    L8:
        return true;
    L5:
        if (this.f277887n == 3) goto L8;
        return false;
    }

    private void c(String r100) {
        if ("com.huawei.hwid".equals(r100) == true) goto L6;
        return;
    L6:
        if (AgHmsUpdateState.getInstance().isUpdateHms() == true) goto L9;
        return;
    L9:
        if (this.f277875b.getPackageVersionCode(r100) < AgHmsUpdateState.getInstance().getTargetVersionCode()) goto L12;
        AgHmsUpdateState.getInstance().resetUpdateState();
        HMSLog.i("HMSPackageManager", "refresh update state for HMS V3");
        return;
    }

    private void d(String r100) {
        String r101 = a(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        this.f277882i = r101.substring(9);
    }

    private void e(String r100) {
        if (SystemUtils.isHuawei() == false) goto L5;
    L10:
        AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
        return;
    L5:
        if (SystemUtils.isSystemApp(this.f277874a, r100) == true) goto L10;
        if (Build.VERSION.SDK_INT < 28) goto L10;
        if (b(r100) == true) goto L10;
    }

    public static HMSPackageManager getInstance(Context r100) {
        Object r101 = f277870p;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f277869o != null) goto L12;
        if (r100 == null) goto L12;
        if (r100.getApplicationContext() == null) goto L10;
        f277869o = new HMSPackageManager(r100.getApplicationContext());     // Catch: Throwable -> L15
    L11:
        f277869o.l();     // Catch: Throwable -> L15
        f277869o.b();     // Catch: Throwable -> L15
        goto L12
    L10:
        f277869o = new HMSPackageManager(r100);     // Catch: Throwable -> L15
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return f277869o;
    }

    public boolean hmsVerHigherThan(int r100) {
        if (this.f277878e < r100) goto L5;
        return true;
    L5:
        if (m() == false) goto L12;
        int r101 = this.f277875b.getPackageVersionCode(getHMSPackageName());
        this.f277878e = r101;
        if (r101 >= r100) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    }

    public boolean isApkNeedUpdate(int r100) {
        int r101 = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + r101 + ", target version requirements: " + r100);
        if (r101 >= r100) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isApkUpdateNecessary(int r100) {
        if (isUpdateHmsForThirdPartyDevice() == false) goto L5;
        return true;
    L5:
        int r101 = getHmsVersionCode();
        HMSLog.i("HMSPackageManager", "current versionCode:" + r101 + ", minimum version requirements: " + r100);
        if (m() == false) goto L9;
        if (r101 >= r100) goto L9;
        return true;
    L9:
        return false;
    }

    public void setUseOldCertificate(boolean r100) {
        this.f277886m = r100;
    }

    private static String a(int r100) {
        if (r100 != 1) goto L7;
        return "SPOOFED";
    L7:
        if (r100 != 2) goto L11;
        return "SUCCESS";
    L11:
        if (r100 != 3) goto L14;
        return "UNCHECKED";
    L14:
        HMSLog.e("HMSPackageManager", "invalid checkMDM state: " + r100);
        return "";
    }

    public static /* synthetic */ int b(HMSPackageManager r100) {
        return r100.d();
    }

    private void a(List<ResolveInfo> r100) {
        if (r100.size() > 1) goto L5;
        return;
    L5:
        Collections.sort(r100, new a(this));
    }

    public static /* synthetic */ Context a(HMSPackageManager r100) {
        return r100.f277874a;
    }

    private Pair<String, String> a(String r100, String r101) {
        if (b(r100, r101) == true) goto L5;
        HMSLog.w("HMSPackageManager", "check sign fail: " + r100 + "_" + r101);
        return null;
    L5:
        return new Pair(r100, r101);
    }

    private boolean b(String r100, String r101) {
        Map<String, String> r102 = f277873s;
        if (r102.containsKey(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (r102.get(r100).equalsIgnoreCase(r101) == false) goto L7;
        return true;
    }

    private boolean c(String r100, String r101) {
        if (Objects.equals(r101, this.f277875b.getPackageSigningCertificate(r100)) == false) goto L5;
    L8:
        return true;
    L5:
        if (Objects.equals(r101, this.f277875b.getPackageSignature(r100)) == true) goto L8;
        return false;
    }

    private Pair<String, String> d(String r100, String r101) {
        if (f277873s.containsKey(r100) == true) goto L5;
        return null;
    L5:
        if (PackageConstants.SERVICES_SIGNATURE_V3.equalsIgnoreCase(r101) == false) goto L10;
        this.f277887n = 3;
        return new Pair(r100, r101);
    L10:
        return null;
    }

    private String a(Bundle r100, String r101) {
        if (r100.containsKey(r101) == true) goto L7;
        HMSLog.e("HMSPackageManager", "no " + r101 + " in metaData");
        return null;
    L7:
        return r100.getString(r101);
    }

    private boolean a(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
    L28:
        HMSLog.e("HMSPackageManager", "args is invalid");
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L28;
        List<X509Certificate> r103 = com.huawei.hms.device.a.b(r102);
        if (r103.size() != 0) goto L12;
        HMSLog.e("HMSPackageManager", "certChain is empty");
        return false;
    L12:
        if (com.huawei.hms.device.a.a(com.huawei.hms.device.a.a(this.f277874a), r103) == true) goto L15;
        HMSLog.e("HMSPackageManager", "failed to verify cert chain");
        return false;
    L15:
        X509Certificate r104 = (X509Certificate) ListProtector.get(r103, r103.size() - 1);
        if (com.huawei.hms.device.a.a(r104, "Huawei CBG HMS") == true) goto L20;
        HMSLog.e("HMSPackageManager", "CN is invalid");
        return false;
    L20:
        if (com.huawei.hms.device.a.b(r104, "Huawei CBG Cloud Security Signer") == true) goto L24;
        HMSLog.e("HMSPackageManager", "OU is invalid");
        return false;
    L24:
        if (com.huawei.hms.device.a.a(r104, r100, r101) == true) goto L27;
        HMSLog.e("HMSPackageManager", "signature is invalid: " + r100);
        return false;
    L27:
        return true;
    }

    private boolean a(Bundle r100, String r101, String r102) {
        if (r100.containsKey("hms_app_signer_v3") == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r101, r102) == true) goto L9;
        if (Build.VERSION.SDK_INT < 28) goto L9;
        return true;
    }

    private Pair<String, String> a(Bundle r100, String r101, String r102, String r110) {
        if (r100 != null) goto L6;
        HMSLog.e("HMSPackageManager", "DSS check: " + r101 + " for metadata is null");
        return null;
    L6:
        this.f277887n = 2;
        if (a(r100, r101, r102) == false) goto L9;
        HMSLog.i("HMSPackageManager", "support DSS V3 check");
        r110 = r102;
        String r103 = "hms_app_signer_v3";
    L11:
        if (r100.containsKey(r103) == true) goto L15;
        HMSLog.e("HMSPackageManager", "skip package " + r101 + " for no " + r103);
        return null;
    L15:
        if (r100.containsKey("hms_app_cert_chain") == true) goto L19;
        HMSLog.e("HMSPackageManager", "skip package " + r101 + " for no cert chain");
        return null;
    L19:
        if (a(r101 + "&" + r110, r100.getString(r103), r100.getString("hms_app_cert_chain")) == true) goto L23;
        HMSLog.e("HMSPackageManager", "checkSigner failed");
        return null;
    L23:
        if (r103.equals("hms_app_signer_v3") == false) goto L26;
        this.f277887n = 3;
    L26:
        return new Pair(r101, r110);
    L9:
        r103 = "hms_app_signer";
        goto L11
    }
}
