package jra;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Object> f500155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f500156b;

    /* JADX INFO: renamed from: jra.a$a, reason: collision with other inner class name */
    public static final class C6479a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f500157a = 0;

        static {
        }
    }

    public a() {
    }

    static {
        f500155a = new ArrayList();
        int r100 = C6479a.f500157a;
        f500156b = -1;
    }

    public static boolean a() {
        int r100 = f500156b;
        int r101 = C6479a.f500157a;
        if (r100 != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
