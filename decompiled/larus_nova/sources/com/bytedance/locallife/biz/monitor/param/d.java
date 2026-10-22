package com.bytedance.locallife.biz.monitor.param;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f256725m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f256726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f256727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f256728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f256729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f256730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public JSONObject f256731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReadWriteLock f256732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ReadWriteLock f256733h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReadWriteLock f256734i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReadWriteLock f256735j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ReadWriteLock f256736k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f256737l;

    public static final class a {
        public a() {
        }

        public static final int a(JSONObject r100) {
            int r101 = d.f256725m;
            Iterator<String> r102 = r100.keys();
            int r103 = 0;
        L4:
            if (r102.hasNext() == false) goto L28;
            String r104 = r102.next();
            Charset r105 = Charsets.UTF_8;
            int r106 = r103 + r104.getBytes(r105).length;
            Object r107 = r100.opt(r104);
            if ((r107 instanceof String) == false) goto L9;
            int r108 = ((String) r107).getBytes(r105).length;
        L27:
            r103 = r106 + r108;
            goto L4
        L9:
            if ((r107 instanceof Integer) == false) goto L12;
            r108 = 4;
            goto L27
        L12:
            if ((r107 instanceof Long) == false) goto L15;
        L16:
            r108 = 8;
            goto L27
        L15:
            if ((r107 instanceof Double) == true) goto L16;
            if ((r107 instanceof Boolean) == false) goto L20;
            r108 = 1;
            goto L27
        L20:
            if (r107 == null) goto L26;
            String r109 = r107.toString();
            if (r109 == null) goto L26;
            byte[] r110 = r109.getBytes(r105);
            if (r110 == null) goto L26;
            r108 = r110.length;
        L26:
            r108 = 0;
            goto L27
        L28:
            return r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f256738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f256739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f256740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f256741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f256742e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f256743f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f256744g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f256745h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f256738a == r101.f256738a) goto L12;
            return false;
        L12:
            if (this.f256739b == r101.f256739b) goto L15;
            return false;
        L15:
            if (this.f256740c == r101.f256740c) goto L18;
            return false;
        L18:
            if (this.f256741d == r101.f256741d) goto L21;
            return false;
        L21:
            if (this.f256742e == r101.f256742e) goto L24;
            return false;
        L24:
            if (this.f256743f == r101.f256743f) goto L27;
            return false;
        L27:
            if (this.f256744g == r101.f256744g) goto L30;
            return false;
        L30:
            if (this.f256745h == r101.f256745h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((this.f256738a * 31) + this.f256739b) * 31) + this.f256740c) * 31) + this.f256741d) * 31) + this.f256742e) * 31) + this.f256743f) * 31) + this.f256744g) * 31) + this.f256745h;
        }

        public final String toString() {
            return "PageParamEntityMonitor(queryParamsCount=" + this.f256738a + ", queryParamsSize=" + this.f256739b + ", sessionParamsCount=" + this.f256740c + ", sessionParamsSize=" + this.f256741d + ", apiTrackParamsCount=" + this.f256742e + ", apiTrackParamsSize=" + this.f256743f + ", sourceDetailParamsCount=" + this.f256744g + ", sourceDetailParamsSize=" + this.f256745h + ')';
        }

        public b() {
            this.f256738a = 0;
            this.f256739b = 0;
            this.f256740c = 0;
            this.f256741d = 0;
            this.f256742e = 0;
            this.f256743f = 0;
            this.f256744g = 0;
            this.f256745h = 0;
        }
    }

    static {
        new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f256726a, r101.f256726a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f256727b, r101.f256727b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f256728c, r101.f256728c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f256729d, r101.f256729d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f256730e, r101.f256730e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f256731f, r101.f256731f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f256726a.hashCode() * 31) + this.f256727b.hashCode()) * 31) + this.f256728c.hashCode()) * 31) + this.f256729d.hashCode()) * 31) + this.f256730e.hashCode()) * 31) + this.f256731f.hashCode();
    }

    public final String toString() {
        return "PageParamsEntity(pageName=" + this.f256726a + ", pageSessionId=" + this.f256727b + ", queryParamsObj=" + this.f256728c + ", sessionParamsObj=" + this.f256729d + ", apiTrackParamsObj=" + this.f256730e + ", sourceDetailParamsObj=" + this.f256731f + ')';
    }

    public final JSONObject a() {
        ((ReentrantReadWriteLock) this.f256734i).readLock().lock();
        JSONObject r100 = new JSONObject(this.f256730e.toString());     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256734i).readLock().unlock();
        return r100;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256734i).readLock().unlock();
        throw th;
    }

    public final b b() {
        ((ReentrantReadWriteLock) this.f256736k).readLock().lock();
        b r100 = this.f256737l;     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256736k).readLock().unlock();
        return r100;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256736k).readLock().unlock();
        throw th;
    }

    public final JSONObject c() {
        ((ReentrantReadWriteLock) this.f256732g).readLock().lock();
        JSONObject r100 = new JSONObject(this.f256728c.toString());     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256732g).readLock().unlock();
        return r100;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256732g).readLock().unlock();
        throw th;
    }

    public final JSONObject d() {
        ((ReentrantReadWriteLock) this.f256733h).readLock().lock();
        JSONObject r100 = new JSONObject(this.f256729d.toString());     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256733h).readLock().unlock();
        return r100;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256733h).readLock().unlock();
        throw th;
    }

    public final void e() {
        ((ReentrantReadWriteLock) this.f256732g).readLock().lock();
        ((ReentrantReadWriteLock) this.f256733h).readLock().lock();
        ((ReentrantReadWriteLock) this.f256734i).readLock().lock();
        ((ReentrantReadWriteLock) this.f256735j).readLock().lock();
        ((ReentrantReadWriteLock) this.f256736k).writeLock().lock();
        b r100 = this.f256737l;     // Catch: Throwable -> L6
        r100.f256738a = this.f256728c.length();     // Catch: Throwable -> L6
        r100.f256739b = a.a(this.f256728c);     // Catch: Throwable -> L6
        r100.f256740c = this.f256729d.length();     // Catch: Throwable -> L6
        r100.f256741d = a.a(this.f256729d);     // Catch: Throwable -> L6
        r100.f256742e = this.f256730e.length();     // Catch: Throwable -> L6
        r100.f256743f = a.a(this.f256730e);     // Catch: Throwable -> L6
        r100.f256744g = this.f256731f.length();     // Catch: Throwable -> L6
        r100.f256745h = a.a(this.f256731f);     // Catch: Throwable -> L6
        ((ReentrantReadWriteLock) this.f256736k).writeLock().unlock();
        ((ReentrantReadWriteLock) this.f256735j).readLock().unlock();
        ((ReentrantReadWriteLock) this.f256734i).readLock().unlock();
        ((ReentrantReadWriteLock) this.f256733h).readLock().unlock();
        ((ReentrantReadWriteLock) this.f256732g).readLock().unlock();
        return;
    L6:
        th = move-exception;
        ((ReentrantReadWriteLock) this.f256736k).writeLock().unlock();
        ((ReentrantReadWriteLock) this.f256735j).readLock().unlock();
        ((ReentrantReadWriteLock) this.f256734i).readLock().unlock();
        ((ReentrantReadWriteLock) this.f256733h).readLock().unlock();
        ((ReentrantReadWriteLock) this.f256732g).readLock().unlock();
        throw th;
    }

    public d(String r100, String r101) {
        JSONObject r102 = new JSONObject();
        JSONObject r103 = new JSONObject();
        JSONObject r104 = new JSONObject();
        JSONObject r105 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r101, "pageSessionId");
        Intrinsics.checkNotNullParameter(r102, "queryParamsObj");
        Intrinsics.checkNotNullParameter(r103, "sessionParamsObj");
        Intrinsics.checkNotNullParameter(r104, "apiTrackParamsObj");
        Intrinsics.checkNotNullParameter(r105, "sourceDetailParamsObj");
        this.f256726a = r100;
        this.f256727b = r101;
        this.f256728c = r102;
        this.f256729d = r103;
        this.f256730e = r104;
        this.f256731f = r105;
        this.f256732g = new ReentrantReadWriteLock();
        this.f256733h = new ReentrantReadWriteLock();
        this.f256734i = new ReentrantReadWriteLock();
        this.f256735j = new ReentrantReadWriteLock();
        this.f256736k = new ReentrantReadWriteLock();
        this.f256737l = new b();
        e();
    }
}
