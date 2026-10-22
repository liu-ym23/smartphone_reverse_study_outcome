package w34;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class b<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, a<DATA>> f558146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f558147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, a<DATA>> f558148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f558149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f558150e;

    public final void e() {
        if (this.f558148c.size() <= this.f558150e) goto L13;
        v34.a.a("<<<<<shrink>>>>>CachePool超过最大" + this.f558150e + " 限制，先尝试删除过期视频");
        Iterator r100 = CollectionsKt.toList(this.f558148c.keySet()).iterator();
    L6:
        if (r100.hasNext() == false) goto L13;
        String r101 = (String) r100.next();
        a<DATA> r102 = this.f558148c.get(r101);
        if (r102 == null) goto L11;
        if (r102.a() == true) goto L6;
    L11:
        this.f558148c.remove(r101);
        this.f558146a.remove(r101);
    L13:
        if (this.f558148c.size() <= this.f558150e) goto L27;
        v34.a.a("<<<<<shrink>>>>>还是超过最大限制" + this.f558150e + "，需要删除CachePool 20%的数据");
        float r103 = ((float) this.f558150e) * this.f558149d;
    L16:
        if (r103 <= 0.0f) goto L18;
        String r104 = (String) CollectionsKt.first(this.f558146a.keySet());
        this.f558148c.remove(r104);
        this.f558146a.remove(r104);
        r103 = r103 - 1.0f;
        goto L16
    L18:
        v34.a.a("<<<<<shrink>>>>>当前CachePool的大小 " + this.f558146a.size());
        return;
    }

    public b() {
        this.f558146a = new LinkedHashMap(16, 0.75f, true);
        this.f558147b = new ReentrantLock();
        this.f558148c = new HashMap();
        int r100 = b44.a.f17520a;
        this.f558149d = 0.2f;
        this.f558150e = 500;
    }

    public final a<DATA> a(String r100) {
        this.f558147b.lock();     // Catch: Throwable -> L5
        a<DATA> r101 = this.f558148c.get(r100);     // Catch: Throwable -> L5
        this.f558147b.unlock();
        return r101;
    L5:
        th = move-exception;
        this.f558147b.unlock();
        throw th;
    }

    public final a<DATA> b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f558147b.lock();     // Catch: Throwable -> L6
        a<DATA> r101 = this.f558146a.get(r100);     // Catch: Throwable -> L6
        this.f558147b.unlock();
        return r101;
    L6:
        th = move-exception;
        this.f558147b.unlock();
        throw th;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f558147b.lock();     // Catch: Throwable -> L6
        this.f558148c.remove(r100);     // Catch: Throwable -> L6
        a<DATA> r101 = this.f558146a.remove(r100);     // Catch: Throwable -> L6
        this.f558147b.unlock();
        return;
    L6:
        th = move-exception;
        this.f558147b.unlock();
        throw th;
    }

    public void c(String r100, a<DATA> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f558147b.lock();     // Catch: Throwable -> L11
        this.f558146a.put(r100, r101);     // Catch: Throwable -> L11
        this.f558148c.put(r100, r101);     // Catch: Throwable -> L11
        e();     // Catch: Throwable -> L11
        StringBuilder r102 = new StringBuilder("现在的排序");     // Catch: Throwable -> L11
        this.f558147b.lock();     // Catch: Throwable -> L8
        Set<String> r103 = this.f558146a.keySet();     // Catch: Throwable -> L8
        this.f558147b.unlock();     // Catch: Throwable -> L11
        r102.append(r103);     // Catch: Throwable -> L11
        v34.a.a(r102.toString());     // Catch: Throwable -> L11
        this.f558147b.unlock();
        return;
    L8:
        th = move-exception;
        this.f558147b.unlock();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f558147b.unlock();
        throw th;
    }
}
