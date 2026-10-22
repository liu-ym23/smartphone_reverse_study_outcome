package om7;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements nm7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Set<String> f524303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Set<String> f524304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CopyOnWriteArraySet<WeakReference<nm7.a>> f524305c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f524306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f524307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f524308c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f524308c.b(this.f524306a, this.f524307b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(d r100, String r101, String r102) {
            this.f524308c = r100;
            this.f524306a = r101;
            this.f524307b = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f524309a = null;

        static {
            f524309a = new d();
        }
    }

    public d() {
        this.f524303a = new HashSet();
        this.f524304b = new HashSet();
        this.f524305c = new CopyOnWriteArraySet();
    }

    public static String c(Set r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L16;
        HashSet r102 = (HashSet) r100;
        if (r102.size() <= 0) goto L16;
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = (String) r103.next();
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r101.append(r104);
        r101.append(", ");
        goto L9
    L14:
        return r101.toString();
    L16:
        return r101.toString();
    }

    @Override // nm7.a
    public final synchronized void a(String r100, String r101) {
        monitor-enter(this);
        um7.e.b("onDataUnion() on call; key = " + r100 + "; value = " + r101);     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r100) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        Iterator<WeakReference<nm7.a>> r102 = this.f524305c.iterator();     // Catch: Throwable -> L20
    L10:
        if (r102.hasNext() == false) goto L17;
        WeakReference<nm7.a> r103 = r102.next();     // Catch: Throwable -> L20
        if (r103 == null) goto L10;
        nm7.a r104 = r103.get();     // Catch: Throwable -> L20
        if (r104 == null) goto L10;
        r104.a(r100, r101);     // Catch: Throwable -> L20
        goto L10
    L17:
        ((HashSet) this.f524304b).remove(r100);     // Catch: Throwable -> L20
        ((HashSet) this.f524303a).add(r100);     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r100, String r101) {
        monitor-enter(this);
        um7.e.b("doSetUnionValue() key = " + r100 + "; value = " + r101);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r101) == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        Context r102 = pm7.b.a.f529854a.getContext();     // Catch: Throwable -> L24
        if (r102 != null) goto L12;
        monitor-exit(this);
        return;
    L12:
        Set r103 = pm7.a.C7212a.f529851a.f529848b;     // Catch: Throwable -> L24
        if (r103 != null) goto L17;
        r103 = new HashSet();     // Catch: Throwable -> L24
    L17:
        if (r103.contains(DataUnionStrategy.UNION_ACCOUNT) == false) goto L20;
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.a.b(r102, r100, r101);     // Catch: Throwable -> L24
        um7.e.b("doSetUnionValue() DataUnionAccountUtils; value = " + r101);     // Catch: Throwable -> L24
    L20:
        if (r103.contains(DataUnionStrategy.UNION_FILE) == false) goto L22;
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.c.d(r102, r100, r101);     // Catch: Throwable -> L24
        um7.e.b("doSetUnionValue() DataUnionFileUtils; value = " + r101);     // Catch: Throwable -> L24
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public final void d(String r100, String r101) {
        um7.e.b("setUnionValue() value = " + r101);
        Context r102 = pm7.b.a.f529854a.getContext();
        if (r102 != null) goto L5;
        return;
    L5:
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(r102).f272296a.edit().putString(r100, r101).apply();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        rm7.c.a.f538587a.b(new a(this, r100, r101));
        return;
    L11:
        b(r100, r101);
        return;
    L8:
        r103 = false;
        goto L9
    }
}
