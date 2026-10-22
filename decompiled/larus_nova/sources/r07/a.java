package r07;

import android.text.TextUtils;
import android.util.LruCache;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, Boolean> f535482a;

    /* JADX INFO: renamed from: r07.a$a, reason: collision with other inner class name */
    public static class C7413a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f535483a = null;

        static {
            f535483a = new a();
        }
    }

    public a() {
        this.f535482a = new LruCache(128);
    }

    public final boolean a(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        monitor-enter(this);
        Boolean r102 = this.f535482a.get(r100);     // Catch: Throwable -> L13
        if (r102 != null) goto L9;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return r101;
    L9:
        if (r102.booleanValue() == false) goto L11;
        r101 = true;
    L13:
        th = move-exception;
        throw th;
    }
}
