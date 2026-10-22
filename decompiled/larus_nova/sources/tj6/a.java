package tj6;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static final String a(int r100) {
        StackTraceElement[] r101 = ThreadMethodProxy.currentThread().getStackTrace();
        StringBuilder r102 = new StringBuilder();
        int r103 = Math.min(r100, r101.length);
        int r104 = 2;
    L3:
        if (r104 >= r103) goto L6;
        r102.append(r101[r104].toString());
        r102.append("\n");
        r104 = r104 + 1;
        goto L3
    L6:
        return r102.toString();
    }
}
