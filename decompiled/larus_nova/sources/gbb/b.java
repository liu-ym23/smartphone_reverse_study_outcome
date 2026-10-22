package gbb;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends e {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f480765q = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final File f480766p;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File[] f480767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final File[] f480768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f480769c;

        public a(b r100, String r101) {
            HashSet r102 = new HashSet(Arrays.asList(new String[]{"_th", "_mid", "_hd"}));
            this.f480769c = r102;
            this.f480767a = new File[1];
            this.f480768b = new File[1];
            StringBuilder r103 = new StringBuilder(r101);
            int r104 = r103.length();
            Iterator r105 = r102.iterator();
        L4:
            if (r105.hasNext() == false) goto L8;
            String r106 = (String) r105.next();
            if (r101.endsWith(r106) == false) goto L4;
            String r107 = r101.substring(0, r101.length() - r106.length());
        L9:
            if (r107 == null) goto L12;
            r101 = r107;
        L12:
            PolarisFileWrapper r108 = new PolarisFileWrapper(r100.f480766p, r101);
            if (r108.exists() == true) goto L15;
            r108.mkdirs();
        L15:
            this.f480767a[0] = new PolarisFileWrapper(r108, r103.toString());
            r103.append(DefaultDiskStorage.FileType.TEMP);
            this.f480768b[0] = new PolarisFileWrapper(r108, r103.toString());
            r103.setLength(r104);
            return;
        L8:
            r107 = null;
            goto L9
        }
    }

    @Override // gbb.e, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // gbb.e
    public void delete() throws IOException {
        monitor-enter(this);
        monitor-exit(this);
        e.g.b(this.f480766p);
    }

    @Override // gbb.e
    public final File e() {
        return this.f480766p;
    }

    @Override // gbb.e
    public final synchronized e.C6005e d(String r100) throws IOException {
        monitor-enter(this);
        monitor-exit(this);
        return null;
    }

    @Override // gbb.e
    public final synchronized void l(String r100) throws IOException {
        monitor-enter(this);
        monitor-exit(this);
    }

    public final synchronized File q(String r100) throws IOException {
        monitor-enter(this);
        File r101 = new a(this, r100).f480767a[0];     // Catch: Throwable -> L10
        Log.i("AvatarDiskLruCache", "getCacheFile, key is:" + r100 + ", file is:" + r101.getAbsolutePath() + ", file exist:" + r101.exists());     // Catch: Throwable -> L10
        if (r101.exists() == true) goto L8;
        r101 = null;
    L8:
        monitor-exit(this);
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public b(File r100, int r101, long r102) {
        super(r100, r101, r102);
        this.f480766p = r100;
    }
}
