package g57;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f480053a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static WeakReference<Context> f480054b;

    static {
        f480053a = new a();
    }

    public a() {
    }

    public final Context getContext() {
        WeakReference<Context> r100 = f480054b;
        if (r100 == null) goto L13;
        if (r100 == null) goto L6;
        Context r101 = r100.get();
    L7:
        if (r101 == null) goto L15;
        WeakReference<Context> r102 = f480054b;
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.get();
    L15:
        return null;
    L6:
        r101 = null;
        goto L7
    L13:
        return null;
    }
}
