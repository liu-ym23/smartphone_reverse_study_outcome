package ymc;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f568421c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f568422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static b f568423e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f568424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, List<String>> f568425b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f568426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f568427b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f568428c;

        public a() {
        }
    }

    public static b getInstance() {
        if (f568423e != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f568423e != null) goto L9;
        f568423e = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f568423e;
    }

    public void clear() {
        ConcurrentHashMap<String, a> r100 = this.f568424a;
        if (r100 == null) goto L6;
        r100.clear();
        this.f568425b.clear();
        return;
    }

    public int getRecordSize() {
        ConcurrentHashMap<String, a> r100 = this.f568424a;
        if (r100 != null) goto L5;
        return -1;
    L5:
        return r100.size();
    }

    private b() {
        this.f568424a = new ConcurrentHashMap();
        this.f568425b = new ConcurrentHashMap();
    }

    public String getCurNetExtraInfo() {
        return f568422d;
    }

    public int getCurNetType() {
        return f568421c;
    }

    public void disableIpAddress(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<String, a> r101 = this.f568424a;
        if (r101 == null) goto L7;
        a r102 = r101.get(r100);
    L8:
        if (r102 == null) goto L11;
        r102.f568428c = true;
        return;
    L11:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public a get(String r100) {
        ConcurrentHashMap<String, a> r101 = this.f568424a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.get(r100);
    }

    public List<String> gets(String r100) {
        ConcurrentHashMap<String, List<String>> r101 = this.f568425b;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.get(r100);
    }

    public void setCurNetExtraInfo(String r100) {
        f568422d = r100;
    }

    public void setCurNetType(int r100) {
        f568421c = r100;
    }

    public void put(String r100, a r101) {
        ConcurrentHashMap<String, a> r102 = this.f568424a;
        if (r102 == null) goto L6;
        r102.put(r100, r101);
        return;
    }

    public void puts(String r100, List<String> r101) {
        ConcurrentHashMap<String, List<String>> r102 = this.f568425b;
        if (r102 == null) goto L6;
        r102.put(r100, r101);
        return;
    }
}
