package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f272582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<e> f272583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<Integer> f272584c;

    /* JADX INFO: renamed from: com.bytedance.watson.assist.utils.a$a, reason: collision with other inner class name */
    public static class C3814a implements FilenameFilter {
        public C3814a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return Pattern.matches("policy[0-9]", r101);
        }
    }

    public static class b implements Comparator<File> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(File r100, File r101) {
            return r100.getName().compareTo(r101.getName());
        }
    }

    public static class c implements FileUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f272585a;

        public c(List r100) {
            this.f272585a = r100;
        }

        @Override // com.bytedance.watson.assist.utils.FileUtils.a
        public final void a(String r100) {
            if (r100.isEmpty() == true) goto L8;
            String[] r101 = r100.split(" ");
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L10;
            String r104 = r101[r103];
            this.f272585a.add(Long.valueOf(CastLongProtector.parseLong(r104)));
            r103 = r103 + 1;
            goto L6
        L10:
            return;
        }
    }

    public static class d implements FileUtils.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f272586a;

        public d(List r100) {
            this.f272586a = r100;
        }

        @Override // com.bytedance.watson.assist.utils.FileUtils.a
        public final void a(String r100) {
            if (r100.isEmpty() == true) goto L8;
            String[] r101 = r100.split(" ");
            int r102 = r101.length;
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L10;
            String r104 = r101[r103];
            this.f272586a.add(Integer.valueOf(CastIntegerProtector.parseInt(r104)));
            r103 = r103 + 1;
            goto L6
        L10:
            return;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f272587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Integer> f272588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Long> f272589c;

        public final String toString() {
            return "CpuClusterInfo{name='" + this.f272587a + "', affectedCpuList=" + this.f272588b + ", freqList=" + this.f272589c + '}';
        }

        public e(String r100) {
            this.f272588b = new ArrayList();
            this.f272589c = new ArrayList();
            this.f272587a = r100;
        }
    }

    public static synchronized List<e> a() {
        monitor-enter(a.class);
        List<e> r100 = f272583b;     // Catch: Throwable -> L28
        if (r100 == null) goto L8;
        monitor-exit(a.class);
        return r100;
    L8:
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L28
        File[] r102 = new PolarisFileWrapper("/sys/devices/system/cpu/cpufreq").listFiles(new C3814a());     // Catch: Throwable -> L28
        if (r102 != null) goto L11;
    L25:
        f272583b = r101;     // Catch: Throwable -> L28
        monitor-exit(a.class);
        return r101;
    L11:
        if (r102.length <= 0) goto L25;
        Arrays.sort(r102, new b());     // Catch: Throwable -> L28
        int r103 = r102.length;     // Catch: Throwable -> L28
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L25;
        File r105 = r102[r104];     // Catch: Throwable -> L28
        e r106 = new e(r105.getName());     // Catch: Throwable -> L28
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L28
        ArrayList r108 = new ArrayList();     // Catch: Throwable -> L28
        FileUtils.c(r105.getAbsolutePath() + "/scaling_available_frequencies", new c(r107));     // Catch: Exception -> L17 Throwable -> L28
    L31:
        FileUtils.c(r105.getAbsolutePath() + "/affected_cpus", new d(r108));     // Catch: Exception -> L22 Throwable -> L28
    L24:
        r106.f272589c = r107;     // Catch: Throwable -> L28
        r106.f272588b = r108;     // Catch: Throwable -> L28
        r101.add(r106);     // Catch: Throwable -> L28
        r104 = r104 + 1;     // Catch: Throwable -> L28
    L22:
        e = move-exception;
        Log.getStackTraceString(e);     // Catch: Throwable -> L28
        boolean r109 = hq7.a.f486512a;     // Catch: Throwable -> L28
    L17:
        e = move-exception;
        Log.getStackTraceString(e);     // Catch: Throwable -> L28
        boolean r110 = hq7.a.f486512a;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }
}
